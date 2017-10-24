package com.mce.render.tech;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mce.models.blocks.matterCondenser;

public class RenderMatterCondenser extends TileEntitySpecialRenderer {
	public static final ResourceLocation texture = new ResourceLocation(
			"mod_idt", "/textures/models/matterCondenser.png".substring(1));
	public matterCondenser model;

	public RenderMatterCondenser() {
		this.model = new matterCondenser();
	}

	public void renderTileEntityAt(TileEntity entity, double x, double y,
			double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + .5f, (float) y + 1.5f, (float) z + .5f);
		GL11.glRotatef(180, 0f, 0f, 1f);

		this.bindTexture(texture);

		GL11.glPushMatrix();
		this.model.renderModel(.0625f);
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
