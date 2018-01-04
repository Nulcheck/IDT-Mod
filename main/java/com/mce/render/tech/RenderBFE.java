package com.mce.render.tech;

import org.lwjgl.opengl.GL11;

import com.mce.entity.tile.tech.TileEntityBFE;
import com.mce.models.blocks.BFEModel;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderBFE extends TileEntitySpecialRenderer {
	public static final ResourceLocation steel = new ResourceLocation("mod_idt",
			"/textures/models/tech/bfe/bioFuelExtractor_steel.png".substring(1));

	public static final ResourceLocation titanium = new ResourceLocation("mod_idt",
			"/textures/models/tech/bfe/bioFuelExtractor_titanium.png".substring(1));

	public static final ResourceLocation tantalum = new ResourceLocation("mod_idt",
			"/textures/models/tech/bfe/bioFuelExtractor_tantalum.png".substring(1));

	public static final ResourceLocation vanadium = new ResourceLocation("mod_idt",
			"/textures/models/tech/bfe/bioFuelExtractor_vanadium.png".substring(1));

	public static final ResourceLocation vc = new ResourceLocation("mod_idt",
			"/textures/models/tech/bfe/bioFuelExtractor_vc.png".substring(1));
	public BFEModel model;
	public TileEntity bfe;

	public RenderBFE() {
		this.model = new BFEModel();
	}

	private void rotateBlock(World world, int x, int y, int z) {
		TileEntityBFE bfe = (TileEntityBFE) world.getTileEntity(x, y, z);
		int meta = bfe.getFacing();

		if (meta == 0) {
			GL11.glRotatef(180 + 90, 1f, 800f, 1f);
		}
		if (meta == 3) {
			GL11.glRotatef(270 + 90, 1F, 800F, 1F);
		}
		if (meta == 2) {
			GL11.glRotatef(meta * (180) + 90, 1F, 800F, 1F);
		}
		if (meta == 5) {
			GL11.glRotatef(meta * (90) + 90, 1F, 800F, 1F);
		}
	}

	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
		TileEntityBFE bfe = (TileEntityBFE) te;

		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

		if (bfe.getLvl("steel")) {
			GL11.glPushMatrix();
			this.bindTexture(steel);

			GL11.glPushMatrix();
			GL11.glRotatef(180f, 0f, 0f, 1f);
			this.rotateBlock(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
			this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}

		if (bfe.getLvl("titanium")) {
			GL11.glPushMatrix();
			this.bindTexture(titanium);

			GL11.glPushMatrix();
			GL11.glRotatef(180f, 0f, 0f, 1f);
			this.rotateBlock(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
			this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}

		if (bfe.getLvl("tantalum")) {
			GL11.glPushMatrix();
			this.bindTexture(tantalum);

			GL11.glPushMatrix();
			GL11.glRotatef(180f, 0f, 0f, 1f);
			this.rotateBlock(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
			this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}

		if (bfe.getLvl("vanadium")) {
			GL11.glPushMatrix();
			this.bindTexture(vanadium);

			GL11.glPushMatrix();
			GL11.glRotatef(180f, 0f, 0f, 1f);
			this.rotateBlock(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
			this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}

		if (bfe.getLvl("vc")) {
			GL11.glPushMatrix();
			this.bindTexture(vc);

			GL11.glPushMatrix();
			GL11.glRotatef(180f, 0f, 0f, 1f);
			this.rotateBlock(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
			this.model.renderModel(0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}

		GL11.glPopMatrix();
	}
}
