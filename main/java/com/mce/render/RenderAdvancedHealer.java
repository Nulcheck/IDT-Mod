package com.mce.render;

import org.lwjgl.opengl.GL11;

import com.mce.common.mod_IDT;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class RenderAdvancedHealer extends TileEntitySpecialRenderer {
	private IModelCustom model;
	private ResourceLocation texture;

	public RenderAdvancedHealer() {
		model = AdvancedModelLoader.loadModel(new ResourceLocation(mod_IDT.modid2, "obj/test.obj"));
		texture = new ResourceLocation(mod_IDT.modid2, "/textures/models/tex.png");
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);

		if (meta == 0) {
			GL11.glRotatef(270, 0f, 0f, 1f);
		}
		if (meta == 3) {
			GL11.glRotatef(0, 0F, 0f, 1F);
		}
		if (meta == 2) {
			GL11.glRotatef(meta * (45), 0F, 0f, 1F);
		}
		if (meta == 5) {
			GL11.glRotatef(meta * (180), 0F, 0f, 1F);
		}
	}

	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

		this.bindTexture(texture);

		GL11.glPushMatrix();
		GL11.glTranslatef(0f, -1f, 0f);
		GL11.glScalef(.5f, .5f, .5f);
		this.adjustRotatePivotViaMeta(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
		this.model.renderAll();

		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}