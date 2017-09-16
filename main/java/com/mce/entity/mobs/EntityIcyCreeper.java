package com.mce.entity.mobs;

import com.mce.entity.mobs.ai.attributes.EntityAIIcyCreeperSwell;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityIcyCreeper extends EntityMob {
	private int lastActiveTime;
	private int timeSinceIgnited;
	private int fuseTime = 30;
	private double explosionRadius = 2.5d;

	public EntityIcyCreeper(World world) {
		super(world);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIIcyCreeperSwell(this));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.28D);
	}

	public boolean isAIEnabled() {
		return true;
	}
	
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, Byte.valueOf((byte) -1));
		this.dataWatcher.addObject(17, Byte.valueOf((byte) 0));
		this.dataWatcher.addObject(18, Byte.valueOf((byte) 0));
	}

	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);

		if (this.dataWatcher.getWatchableObjectByte(17) == 1) {
			tag.setBoolean("powered", true);
		}

		tag.setShort("Fuse", (short) this.fuseTime);
		tag.setByte("ExplosionRadius", (byte) this.explosionRadius);
		tag.setBoolean("ignited", this.func_146078_ca());
	}

	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		this.dataWatcher.updateObject(17, Byte.valueOf((byte) (tag.getBoolean("powered") ? 1 : 0)));

		if (tag.hasKey("Fuse", 99)) {
			this.fuseTime = tag.getShort("Fuse");
		}

		if (tag.hasKey("ExplosionRadius", 99)) {
			this.explosionRadius = tag.getByte("ExplosionRadius");
		}

		if (tag.getBoolean("ignited")) {
			this.func_146079_cb();
		}
	}

	public void onUpdate() {
		if (this.isEntityAlive()) {
			this.lastActiveTime = this.timeSinceIgnited;

			if (this.func_146078_ca()) {
				this.setCreeperState(1);
			}

			int i = this.getCreeperState();

			if (i > 0 && this.timeSinceIgnited == 0) {
				this.playSound("creeper.primed", 1.0F, 0.5F);
			}

			this.timeSinceIgnited += i;

			if (this.timeSinceIgnited < 0) {
				this.timeSinceIgnited = 0;
			}

			if (this.timeSinceIgnited >= this.fuseTime) {
				this.timeSinceIgnited = this.fuseTime;
				this.func_146077_cc();
			}
		}

		super.onUpdate();
	}
	
	public void onLivingUpdate(){
		super.onLivingUpdate();
	}

	protected String getHurtSound() {
		return "mob.creeper.say";
	}

	protected String getDeathSound() {
		return "mob.creeper.death";
	}

	public void onDeath(DamageSource dam) {
		super.onDeath(dam);

		if (dam.getEntity() instanceof EntitySkeleton) {
			int i = Item.getIdFromItem(Items.record_13);
			int j = Item.getIdFromItem(Items.record_wait);
			int k = i + this.rand.nextInt(j - i + 1);
			this.dropItem(Item.getItemById(k), 1);
		}
	}

	public boolean attackEntityAsMob(Entity entity) {
		return true;
	}

	public boolean getPowered() {
		return this.dataWatcher.getWatchableObjectByte(17) == 1;
	}

	@SideOnly(Side.CLIENT)
	public float getCreeperFlashIntensity(float render) {
		return ((float) this.lastActiveTime + (float) (this.timeSinceIgnited - this.lastActiveTime) * render)
				/ (float) (this.fuseTime - 2);
	}

	protected Item getDropItem() {
		return Items.gunpowder;
	}

	public int getCreeperState() {
		return this.dataWatcher.getWatchableObjectByte(16);
	}

	public void setCreeperState(int state) {
		this.dataWatcher.updateObject(16, Byte.valueOf((byte) state));
	}

	public void onStruckByLightning(EntityLightningBolt bolt) {
		super.onStruckByLightning(bolt);
		this.dataWatcher.updateObject(17, Byte.valueOf((byte) 1));
	}

	protected boolean interact(EntityPlayer player) {
		ItemStack itemstack = player.inventory.getCurrentItem();

		if (itemstack != null && itemstack.getItem() == Items.flint_and_steel) {
			this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "fire.ignite", 1.0F,
					this.rand.nextFloat() * 0.4F + 0.8F);
			player.swingItem();

			if (!this.worldObj.isRemote) {
				this.func_146079_cb();
				itemstack.damageItem(1, player);
				return true;
			}
		}

		return super.interact(player);
	}

	private void func_146077_cc() {
		if (!this.worldObj.isRemote) {
			boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");

			if (this.getPowered()) {
				this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float) (this.explosionRadius * 2),
						flag);
			} else {
				this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float) this.explosionRadius,
						flag);
			}

			this.setDead();
		}
	}

	public boolean func_146078_ca() {
		return this.dataWatcher.getWatchableObjectByte(18) != 0;
	}

	public void func_146079_cb() {
		this.dataWatcher.updateObject(18, Byte.valueOf((byte) 1));
	}
}
