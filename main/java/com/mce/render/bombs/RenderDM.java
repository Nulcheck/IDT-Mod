package com.mce.render.bombs;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

public class RenderDM extends TileEntitySpecialRenderer {

	public static final ResourceLocation texture = new ResourceLocation(
			"mod_idt", "/textures/models/bombs/DM.png".substring(1));

	public static final ResourceLocation modelDir = new ResourceLocation(
			"mod_idt", "/models/DarkMatterBomb.obj");

	public IModelCustom model;

	public RenderDM() {
		//this.model = AdvancedModelLoader.loadModel(modelDir);
	}

	public void render() {
		model.renderAll();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
		GL11.glScalef(.095f, .095f, .095f);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		this.render();
		GL11.glPopMatrix();
	}

}
