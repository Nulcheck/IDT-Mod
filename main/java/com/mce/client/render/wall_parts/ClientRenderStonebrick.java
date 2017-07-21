package com.mce.client.render.wall_parts;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class ClientRenderStonebrick extends Render {
	public ClientRenderStonebrick() {
		super();
	}

	public void render(Entity entity, double x, double y, double z, float size, float light) {
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, 0.0F, 0.0F);
		GL11.glPopMatrix();
	}

	public ResourceLocation textureLocation(Entity entity) {
		return TextureMap.locationBlocksTexture;
	}

	public void doRender(Entity entity, double x, double y, double z, float size, float light) {
		render((Entity) entity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return textureLocation((Entity) entity);
	}
}
