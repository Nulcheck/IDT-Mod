package com.mce.render;

import org.lwjgl.opengl.GL11;

import com.mce.models.blocks.MetalFrameModel;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderMetalFrame extends TileEntitySpecialRenderer {
	public static final ResourceLocation steel = new ResourceLocation("mod_idt",
			"/textures/models/tech/frames/steelFrame.png".substring(1));

	public static final ResourceLocation titanium = new ResourceLocation("mod_idt",
			"/textures/models/tech/frames/titaniumFrame.png".substring(1));

	public static final ResourceLocation tantalum = new ResourceLocation("mod_idt",
			"/textures/models/tech/frames/tantalumFrame.png".substring(1));

	public static final ResourceLocation vanadium = new ResourceLocation("mod_idt",
			"/textures/models/tech/frames/vanadiumFrame.png".substring(1));

	public static final ResourceLocation vc = new ResourceLocation("mod_idt",
			"/textures/models/tech/frames/vcFrame.png".substring(1));
	public MetalFrameModel model;

	public RenderMetalFrame() {
		this.model = new MetalFrameModel();
	}

	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
		int meta = te.getWorldObj().getBlockMetadata(te.xCoord, te.yCoord, te.zCoord);

		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);

		switch (meta) {
		case 0:
			GL11.glPushMatrix();
			this.bindTexture(steel);
			this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
			break;
		case 1:
			GL11.glPushMatrix();
			this.bindTexture(titanium);
			this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
			break;
		case 2:
			GL11.glPushMatrix();
			this.bindTexture(tantalum);
			this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
			break;
		case 3:
			GL11.glPushMatrix();
			this.bindTexture(vanadium);
			this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
			break;
		case 4:
			GL11.glPushMatrix();
			this.bindTexture(vc);
			this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
			break;
		}
		GL11.glPopMatrix();
	}

}
