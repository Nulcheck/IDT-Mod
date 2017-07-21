package com.mce.render.mobs;

import com.mce.entity.mobs.EntityIcyCreeper;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderIcyCreeper extends RenderLiving {
	private static final ResourceLocation mobTexture = new ResourceLocation("mod_idt",
			"/textures/entity/mob/icyCreeper.png".substring(1));

	public RenderIcyCreeper(ModelBase base, float shadow) {
		super(base, shadow);
	}

	protected ResourceLocation getEntityTexture(EntityIcyCreeper entity) {
		return mobTexture;
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityIcyCreeper) entity);
	}
}
