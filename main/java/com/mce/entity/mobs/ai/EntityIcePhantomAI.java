package com.mce.entity.mobs.ai;

import com.mce.common.mod_IDT;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
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
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

class EntityIcePhantomAI extends EntityTameable {
	private static final String __OBFID = "CL_00001654";
	private float up;
	private float down;

	public EntityIcePhantomAI(World world) {
		super(world);
		this.setSize(.5F, .5F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, this.aiSit);
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(4, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(5, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWander(this, .5D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.setTamed(false);
	}

	protected void updateAITick() {
		this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(18, new Float(this.getHealth()));
		this.dataWatcher.addObject(19, new Byte((byte) 0));
		this.dataWatcher.addObject(20, new Byte((byte) BlockColored.func_150032_b(1)));
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

	public float getEyeHeight() {
		return this.height * 0.8F;
	}

	@SideOnly(Side.CLIENT)
	public float getInterestedAngle(float angle) {
		return (this.down + (this.up - this.down) * angle) * 0.15F * (float) Math.PI;
	}

	public int getVerticalFaceSpeed() {
		return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
	}

	public void onDeath(DamageSource dam) {
		super.onDeath(dam);

		if (dam.getEntity() instanceof EntitySkeleton) {
			int i = Item.getIdFromItem(mod_IDT.cd_icy);
			int k = i + this.rand.nextInt(i + 1);
			this.dropItem(Item.getItemById(k), 1);
		}
	}

	public boolean isAIEnabled() {
		return true;
	}

	public void setAttackTarget(EntityLivingBase entity) {
		super.setAttackTarget(entity);
	}

	public void setTamed(boolean tame) {
		super.setTamed(tame);
	}

	public float getTailRotation() {
		return this.isTamed()
				? (0.55F - (20.0F - this.dataWatcher.getWatchableObjectFloat(18)) * 0.02F) * (float) Math.PI
				: ((float) Math.PI / 5F);
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

	protected void func_145780_a(int x, int y, int z, Block block) {
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

	public int getMaxSpawnedInChunk() {
		return 64;
	}

	public void func_70918_i(boolean idk) {
		if (idk) {
			this.dataWatcher.updateObject(19, Byte.valueOf((byte) 1));
		} else {
			this.dataWatcher.updateObject(19, Byte.valueOf((byte) 0));
		}
	}

	public boolean canMateWith(EntityAnimal entity) {
		if (entity == this) {
			return false;
		} else if (!this.isTamed()) {
			return false;
		} else if (!(entity instanceof EntityIcePhantomAI)) {
			return false;
		} else {
			EntityIcePhantomAI entityIce = (EntityIcePhantomAI) entity;
			return !entityIce.isTamed() ? false
					: (entityIce.isSitting() ? false : this.isInLove() && entityIce.isInLove());
		}
	}

	public void onLivingUpdate() {
		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.6D;
		}

		if (this.func_70922_bv()) {
			this.numTicksToChaseTarget = 10;
		}

		/*for (int i = 0; i < 2; ++i) {
			ParticleEffects.spawnParticle("ice", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width,
					this.posY + this.rand.nextDouble() * (double) this.height,
					this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
		}*/

		super.onLivingUpdate();
	}

	public void onUpdate() {
		super.onUpdate();
		this.up = this.down;

		if (this.func_70922_bv()) {
			this.down += (1.0F - this.down) * 0.4F;
		} else {
			this.down += (0.0F - this.down) * 0.4F;
		}
	}

	public Item getDropItem() {
		return mod_IDT.IceShard;
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(.4F);
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

	public float getBrightness(float f) {
		return 1.0F;
	}

	protected void fall(float f) {
	}

	public boolean isBreedingItem(ItemStack item) {
		return item == null ? false : (!(item.getItem() instanceof Item) ? false : mod_IDT.IceShard != null);
	}

	public boolean func_70922_bv() {
		return this.dataWatcher.getWatchableObjectByte(19) == 1;
	}

	protected boolean canDespawn() {
		return !this.isTamed() && this.ticksExisted > 2400;
	}

	public boolean interact(EntityPlayer player) {
		ItemStack stack = player.inventory.getCurrentItem();

		if (this.isTamed()) {
			if (stack != null) {
				if (stack.getItem() instanceof ItemFood) {
					ItemFood itemfood = (ItemFood) stack.getItem();

					if (itemfood.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectFloat(18) < 20.0F) {
						if (!player.capabilities.isCreativeMode) {
							--stack.stackSize;
						}

						this.heal((float) itemfood.func_150905_g(stack));

						if (stack.stackSize <= 0) {
							player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
						}

						return true;
					}
				} else if (stack.getItem() == Items.dye) {
					int i = BlockColored.func_150032_b(stack.getItemDamage());

					if (i != this.getColor()) {
						this.setColor(i);

						if (!player.capabilities.isCreativeMode && --stack.stackSize <= 0) {
							player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
						}

						return true;
					}
				}
			}

			if (this.func_152114_e(player) && !this.worldObj.isRemote && !this.isBreedingItem(stack)) {
				this.aiSit.setSitting(!this.isSitting());
				player.addChatComponentMessage(new ChatComponentText("The ice phantom will follow."));

				this.isJumping = false;
				this.setPathToEntity((PathEntity) null);
				this.setTarget((Entity) null);
				this.setAttackTarget((EntityLivingBase) null);
			}
		} else if (stack != null && stack.getItem() == mod_IDT.IceShard) {
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
					player.addChatComponentMessage(new ChatComponentText("The ice phantom will now stay."));

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

		return super.interact(player);
	}

	public EntityIcePhantomAI createChild(EntityAgeable entityAge) {
		EntityIcePhantomAI entity = new EntityIcePhantomAI(this.worldObj);
		String s = this.func_152113_b();

		if (s != null && s.trim().length() > 0) {
			entity.func_152115_b(s);
			entity.setTamed(true);
		}

		return entity;
	}

	protected boolean isValidLightLevel() {
		return false;
	}

	protected boolean canDamagePlayer() {
		return true;
	}
}
