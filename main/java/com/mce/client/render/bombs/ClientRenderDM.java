package com.mce.client.render.bombs;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mce.common.mod_IDT;
import com.mce.entity.explosives.EntityDM;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientRenderDM extends Render {
	private RenderBlocks blockRenderer = new RenderBlocks();

	public ClientRenderDM() {
		this.shadowSize = 0.5F;
	}

	public void renderDM(EntityDM entity, double x, double y, double z,
			float size, float light) {
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, 0.0F, 0.0F);
		if (entity.fuse - 1.0F + 1.0F < 10.0F) {
			float f2 = 1.0F - (entity.fuse - 1.0F + 1.0F) / 10.0F;
			if (f2 < 0.0F) {
				f2 = 0.0F;
			}
			if (f2 > 1.0F) {
				f2 = 1.0F;
			}
			f2 *= f2;
			f2 *= f2;
			float f3 = 1.0F + f2 * 0.3F;
			GL11.glScalef(f3, f3, f3);
		}
		float f2 = (1.0F - (entity.fuse - 1.0F + 1.0F) / 100.0F) * 0.8F;
		this.bindEntityTexture(entity);
		this.blockRenderer.renderBlockAsItem(mod_IDT.DarkMatterBomb, 0,
				entity.getBrightness(1.0F));
		if (entity.fuse / 5 % 2 == 0) {
			GL11.glDisable(3553);
			GL11.glDisable(2896);
			GL11.glEnable(3042);
			GL11.glBlendFunc(770, 772);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, f2);
			this.blockRenderer.renderBlockAsItem(mod_IDT.DarkMatterBomb, 0,
					1.0F);

			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(3042);
			GL11.glEnable(2896);
			GL11.glEnable(3553);
		}
		GL11.glPopMatrix();
	}

	public ResourceLocation textureLocation(EntityDM entity) {
		return TextureMap.locationBlocksTexture;
	}

	public ResourceLocation getEntityTexture(Entity entity) {
		return textureLocation((EntityDM) entity);
	}

	public void doRender(Entity entity, double x, double y, double z,
			float size, float light) {
		renderDM((EntityDM) entity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
	}
}
