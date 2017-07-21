package com.mce.entity.explosives;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;

public class EntityNB extends EntityTNTPrimed {
	public int fuse;
	public EntityLivingBase tntPlacedBy;

	public EntityNB(World world) {
		super(world);
		this.preventEntitySpawning = true;
		this.setSize(0.98F, 0.98F);
		this.yOffset = this.height / 2.0F;
	}

	public EntityNB(World world, double x, double y, double z,
			EntityLivingBase entity) {
		this(world);
		this.fuse = 100;
		this.setPosition(x, y, z);
		float f = (float) (Math.random() * Math.PI * 2.0D);
		this.motionX = (double) (-((float) Math.sin((double) f)) * 0.02F);
		this.motionY = 0.20000000298023224D;
		this.motionZ = (double) (-((float) Math.cos((double) f)) * 0.02F);
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
		this.tntPlacedBy = entity;
	}

	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY -= 0.03999999910593033D;
		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;

		if (this.onGround) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
			this.motionY *= -0.5D;
		}

		if (this.fuse-- <= 0) {
			this.setDead();

			if (!this.worldObj.isRemote) {
				this.explode();
			}
		} else {
			this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D,
					this.posZ, 0.0D, 0.0D, 0.0D);
		}
	}

	private void explode() {
		float f = 9.0F;
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, f,
				true);
	}
	
	public EntityLivingBase getTntPlacedBy() {
		return this.tntPlacedBy;
	}
}
