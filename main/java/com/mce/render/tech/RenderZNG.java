package com.mce.render.tech;

import org.lwjgl.opengl.GL11;

import com.mce.models.blocks.zng;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderZNG extends TileEntitySpecialRenderer {
	public static final ResourceLocation texture = new ResourceLocation("mod_idt",
			"/textures/models/zng.png".substring(1));
	public zng model;

	public RenderZNG() {
		this.model = new zng();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);

		if (meta == 0) {
			GL11.glRotatef(180, 1f, 800f, 1f);
		}
		if (meta == 3) {
			GL11.glRotatef(270, 1F, 800F, 1F);
		}
		if (meta == 2) {
			GL11.glRotatef(meta * (180), 1F, 800F, 1F);
		}
		if (meta == 5) {
			GL11.glRotatef(meta * (90), 1F, 800F, 1F);
		}
	}

	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

		this.bindTexture(texture);

		GL11.glPushMatrix();
		GL11.glRotatef(180f, 0f, 0f, 1f);
		this.adjustRotatePivotViaMeta(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
