package com.mce.render.mobs;

import org.lwjgl.opengl.GL11;

import com.mce.entity.mobs.EntityIcePhantom;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;

public class RenderIcePhantom extends RenderLiving {
	private static final ResourceLocation texture = new ResourceLocation("mod_idt",
			"/textures/entity/mob/icePhantom.png".substring(1));

	public RenderIcePhantom(ModelBase base, float shadow) {
		super(base, shadow);
		this.setRenderPassModel(base);
	}

	protected ResourceLocation getEntityTexture(EntityIcePhantom entity) {
		return texture;
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityIcePhantom) entity);
	}

	protected int shouldRenderPass(EntityIcePhantom entity, int id, float brightness) {
		if (id == 1 && entity.isTamed()) {
			int color = entity.getColor();
			GL11.glColor3f(EntitySheep.fleeceColorTable[color][0], EntitySheep.fleeceColorTable[color][1],
					EntitySheep.fleeceColorTable[color][2]);
			return 1;
		} else {
			return -1;
		}
	}

	protected int shouldRenderPass(EntityLivingBase entity, int id, float brightness) {
		return this.shouldRenderPass((EntityIcePhantom) entity, id, brightness);
	}
}
