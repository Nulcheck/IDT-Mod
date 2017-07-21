package com.mce.entity.explosives;

import com.mce.client.ClientProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;

public class EntityDM extends EntityTNTPrimed {
	public int fuse;

	public EntityDM(World world) {
		super(world);
	}

	public EntityDM(World world, double x, double y, double z, EntityLivingBase entity) {
		this(world);
		this.fuse = 180;
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
			Minecraft.getMinecraft().effectRenderer
					.addEffect(new ClientProxy.EntityDarkMatterFX(this.worldObj, this.posX + (rand.nextDouble() - 0.5D),
							this.posY + rand.nextDouble(), this.posZ + (rand.nextDouble() - 0.5D), 0.0D, 0.0D, 0.0D));
		}
	}

	private void explode() {
		float f = 500f;
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, f, true);
	}
}
