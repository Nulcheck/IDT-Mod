package com.mce.render;

import org.lwjgl.opengl.GL11;

import com.mce.entity.tile.TileEntityUCR;
import com.mce.models.blocks.CoreReactorModel;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderUCR extends TileEntitySpecialRenderer {
	public static final ResourceLocation texture = new ResourceLocation("mod_idt",
			"/textures/models/uraniumCoreReactor.png".substring(1));
	public CoreReactorModel model;

	public RenderUCR() {
		this.model = new CoreReactorModel();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);

		if (meta == 0) {
			GL11.glRotatef(270, 1f, 800f, 1f);
		}
		if (meta == 3) {
			GL11.glRotatef(0, 1F, 800F, 1F);
		}
		if (meta == 2) {
			GL11.glRotatef(meta * (45), 1F, 800F, 1F);
		}
		if (meta == 4) {
			GL11.glRotatef(meta * (225), 1F, 10F, 1F);
		}
		if (meta == 5) {
			GL11.glRotatef(meta * (180), 1F, 800F, 1F);
		}
	}

	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
		TileEntityUCR te2 = (TileEntityUCR) te;
		float rotation = te2.rotation + (f / 2f);

		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

		this.bindTexture(texture);

		GL11.glPushMatrix();
		GL11.glRotatef(180f, 0f, 0f, 1f);

		/*model.Inner_Core_1.rotateAngleY = rotation;
		model.Inner_Core_2.rotateAngleY = rotation;*/

		this.adjustRotatePivotViaMeta(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
