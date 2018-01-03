package com.mce.render.wall_parts;

import org.lwjgl.opengl.GL11;

import com.mce.models.items.WallPartModel;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderOak extends TileEntitySpecialRenderer {
	public static final ResourceLocation texture = new ResourceLocation("mod_idt",
			"/textures/models/wall_part_oak.png".substring(1));
	public WallPartModel model;

	public RenderOak() {
		this.model = new WallPartModel();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 2F, (float) z + 0.5F);
		GL11.glRotatef(180.0F, 5.0F, 0.0F, 1.0F);

		this.bindTexture(texture);

		GL11.glPushMatrix();
		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
