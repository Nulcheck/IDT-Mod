package com.mce.entity.mobs;

import com.mce.common.mod_IDT;

import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityIcePhantom extends EntityTameable {
	public EntityIcePhantom(World world) {
		super(world);
		this.setSize(.5F, .5F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.3f));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, .5D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.setTamed(false);
	}

	protected void clearAITasks() {
		tasks.taskEntries.clear();
		targetTasks.taskEntries.clear();
	}

	protected boolean canDamagePlayer() {
		return true;
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected void updateAITick() {
		this.dataWatcher.updateObject(19, Float.valueOf(this.getHealth()));
		this.dataWatcher.updateObject(20, Byte.valueOf((byte) this.getColor()));
	}

	public int getBrightnessForRender(float f) {
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.posZ);

		if (this.worldObj.blockExists(i, 0, j)) {
			double d0 = (this.boundingBox.maxY - this.boundingBox.minY) * 0.66D;
			int k = MathHelper.floor_double(this.posY - (double) this.yOffset + d0);
			return this.worldObj.getLightBrightnessForSkyBlocks(i, k, j, 0);
		} else {
			return 0;
		}
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(19, new Float(this.getHealth()));
		this.dataWatcher.addObject(20, new Byte((byte) 0));
	}

	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);

		if (this.func_152113_b() == null) {
			tag.setString("OwnerUUID", "");
		} else {
			tag.setString("OwnerUUID", this.func_152113_b());
		}

		tag.setByte("Color", (byte) this.getColor());
		tag.setBoolean("Sitting", this.isSitting());
	}

	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		String s = "";

		if (tag.hasKey("OwnerUUID", 8)) {
			s = tag.getString("OwnerUUID");
		} else {
			String s1 = tag.getString("Owner");
			s = PreYggdrasilConverter.func_152719_a(s1);
		}

		if (s.length() > 0) {
			this.func_152115_b(s);
			this.setTamed(true);
		}

		if (tag.hasKey("Color", 99)) {
			this.setColor(tag.getByte("Color"));
		}

		this.aiSit.setSitting(tag.getBoolean("Sitting"));
		this.setSitting(tag.getBoolean("Sitting"));
	}

	public void setColor(int color) {
		this.dataWatcher.updateObject(20, Byte.valueOf((byte) (color & 15)));
	}

	public int getColor() {
		return this.dataWatcher.getWatchableObjectByte(20) & 15;
	}

	public void onDeath(DamageSource dam) {
		super.onDeath(dam);

		if (dam.getEntity() instanceof EntitySkeleton) {
			int i = Item.getIdFromItem(mod_IDT.cd_icy);
			int k = i + this.rand.nextInt(i + 1);
			this.dropItem(Item.getItemById(k), 1);
		}
	}

	public void setAttackTarget(EntityLivingBase entity) {
		super.setAttackTarget(entity);
	}

	public void setTamed(boolean tame) {
		super.setTamed(tame);
	}

	public boolean attackEntityFrom(DamageSource dam, float damage) {
		if (this.isEntityInvulnerable()) {
			return false;
		} else {
			Entity entity = dam.getEntity();
			this.aiSit.setSitting(false);

			if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
				damage = (damage + 1.0F) / 2.0F;
			}

			return super.attackEntityFrom(dam, damage);
		}
	}

	public boolean attackEntityAsMob(Entity entity) {
		int i = this.isTamed() ? 4 : 2;
		return entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) i);
	}

	protected String getLivingSound() {
		return mod_IDT.modid + ":" + "ice_phantom_breathe";
	}

	protected String getHurtSound() {
		return mod_IDT.modid + ":" + "ice_phantom_hurt";
	}

	protected String getDeathSound() {
		return mod_IDT.modid + ":" + "ice_phantom_death";
	}

	protected void dropFewItems(boolean hit, int lvl) {
		if (hit) {
			int j = this.rand.nextInt(2 + lvl);

			for (int k = 0; k < j; ++k) {
				this.dropItem(Item.getItemFromBlock(Blocks.ice), 1);
				this.dropItem(mod_IDT.IceShard, 4);
			}
		}
	}

	public boolean canMateWith(EntityAnimal entity) {
		if (entity == this) {
			return false;
		} else if (!this.isTamed()) {
			return false;
		} else if (!(entity instanceof EntityIcePhantom)) {
			return false;
		} else {
			EntityIcePhantom entityIce = (EntityIcePhantom) entity;
			return !entityIce.isTamed() ? false
					: (entityIce.isSitting() ? false : this.isInLove() && entityIce.isInLove());
		}
	}

	public void onLivingUpdate() {
		for (int i = 0; i < 2; ++i) {
			if (!this.worldObj.isRemote) {
				mod_IDT.proxy.spawnParticle(this.worldObj,
						this.posX + (this.rand.nextDouble() - .5d) * (double) this.width,
						this.posY + (this.rand.nextDouble() - .5d) * (double) this.height,
						this.posZ + (this.rand.nextDouble() - .5d) * (double) this.width, "iceFx");
			}
		}

		super.onLivingUpdate();
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(.4F);
	}

	public boolean isBreedingItem(ItemStack item) {
		return item != null && item.getItem() == mod_IDT.IceShard;
	}

	protected boolean canDespawn() {
		return !this.isTamed() && this.ticksExisted > 2400;
	}

	public boolean interact(EntityPlayer player) {
		ItemStack stack = player.inventory.getCurrentItem();

		if (this.isTamed()) {
			if (stack != null) {
				if (stack.getItem() == mod_IDT.IceShard || stack.getItem() == Item.getItemFromBlock(Blocks.ice)
						|| stack.getItem() == Item.getItemFromBlock(Blocks.packed_ice)) {
					if (this.getHealth() < 20.0F) {
						if (!player.capabilities.isCreativeMode) {
							--stack.stackSize;
						}
						this.heal(5f);
						return true;
					}
				} else if (stack.getItem() == Items.dye) {
					int i = BlockColored.func_150032_b(stack.getItemDamage());

					if (i != this.getColor()) {
						this.setColor(i);
						if (!player.capabilities.isCreativeMode) {
							--stack.stackSize;
						}
						return true;
					}
				}
			}

			if (this.func_152114_e(player) && !this.worldObj.isRemote && !this.isBreedingItem(stack)) {
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.setPathToEntity((PathEntity) null);
				this.setTarget((Entity) null);
				this.setAttackTarget((EntityLivingBase) null);
			}
		} else if (stack != null && stack.getItem() == mod_IDT.IceShard && !this.isTamed()) {
			if (!player.capabilities.isCreativeMode) {
				--stack.stackSize;
			}

			if (stack.stackSize <= 0) {
				player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
			}

			if (!this.worldObj.isRemote) {
				if (this.rand.nextInt(3) == 0) {
					this.setTamed(true);
					player.addChatComponentMessage(new ChatComponentText("The ice phantom is now your pet."));
					this.setPathToEntity((PathEntity) null);
					this.setAttackTarget((EntityLivingBase) null);
					this.aiSit.setSitting(true);
					this.setHealth(20.0F);
					this.func_152115_b(player.getUniqueID().toString());
					this.playTameEffect(true);
					this.worldObj.setEntityState(this, (byte) 7);
				} else {
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte) 6);
				}
			}
			return true;
		}

		if (this.isSitting() && this.isTamed() && !this.worldObj.isRemote) {
			player.addChatComponentMessage(new ChatComponentText("The ice phantom will now stay."));
		} else if (!this.isSitting() && this.isTamed() && !this.worldObj.isRemote) {
			player.addChatComponentMessage(new ChatComponentText("The ice phantom will follow."));
		}

		return super.interact(player);
	}

	public EntityIcePhantom createChild(EntityAgeable entityAge) {
		EntityIcePhantom entity = new EntityIcePhantom(this.worldObj);
		String s = this.func_152113_b();

		if (s != null && s.trim().length() > 0) {
			entity.func_152115_b(s);
			entity.setTamed(true);
		}

		return entity;
	}
}
