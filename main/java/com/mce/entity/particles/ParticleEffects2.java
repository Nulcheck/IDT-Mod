package com.mce.entity.particles;

import com.mce.client.ClientProxy;
import com.mce.client.ClientProxy.EntityEinsteiniumFX;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.world.World;

public class ParticleEffects2 {
	private static Minecraft mc = Minecraft.getMinecraft();
	private static World theWorld = mc.theWorld;
	private static TextureManager renderEngine = mc.renderEngine;

	public static EntityFX spawnParticle(String name, double moveX, double moveY, double moveZ, double x, double y,
			double z) {
		if (mc != null && mc.renderViewEntity != null && mc.effectRenderer != null) {
			int settings = mc.gameSettings.particleSetting;

			if (settings == 1 && theWorld.rand.nextInt(3) == 0) {
				settings = 2;
			}

			double mx = mc.renderViewEntity.posX - moveX;
			double my = mc.renderViewEntity.posY - moveY;
			double mz = mc.renderViewEntity.posZ - moveZ;
			EntityFX fx = null;
			double size = 16.0D;

			if (mx * mx + my * my + mz * mz > size * size) {
				return null;
			} else if (settings > 1) {
				return null;
			} else {
				if (name.equals("einsteiniumDust")) {
					fx = new ClientProxy.EntityEinsteiniumFX(theWorld, moveX, moveY, moveZ, (float) x, (float) y,
							(float) z);
				}

				if (name.equals("uraniumDust")) {
					fx = new ClientProxy.EntityUraniumFX(theWorld, moveX, moveY, moveZ, (float) x, (float) y,
							(float) z);
				}

				if (name.equals("neptuniumDust")) {
					fx = new ClientProxy.EntityNeptuniumFX(theWorld, moveX, moveY, moveZ, (float) x, (float) y,
							(float) z);
				}

				if (name.equals("ice")) {
					fx = new ClientProxy.EntityIceFX(theWorld, moveX, moveY, moveZ, (float) x, (float) y, (float) z);
				}

				if (name.equals("darkMatter")) {
					fx = new ClientProxy.EntityDarkMatterFX(theWorld, moveX, moveY, moveZ, (float) x, (float) y,
							(float) z);
				}

				if (name.equals("sulfurDust")) {
					fx = new ClientProxy.EntitySulfurFX(theWorld, moveX, moveY, moveZ, (float) x, (float) y, (float) z);
				}

				mc.effectRenderer.addEffect((EntityFX) fx);
				return (EntityFX) fx;
			}
		}
		return null;
	}
}