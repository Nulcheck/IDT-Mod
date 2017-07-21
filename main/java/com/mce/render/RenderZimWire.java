package com.mce.render;

import org.lwjgl.opengl.GL11;

import com.mce.entity.tile.TileEntityZimWire;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

public class RenderZimWire extends TileEntitySpecialRenderer {
	public ResourceLocation texture = new ResourceLocation("mod_idt", "/textures/models/zimWire.png".substring(1));
	float px = 1f / 16f;
	float tpx = 1f / 32f;

	public void renderTileEntityAt(TileEntity te, double dx, double dy, double dz, float f) {
		GL11.glTranslated(dx, dy, dz);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.bindTexture(texture);
		drawCore(te);

		TileEntityZimWire zw = (TileEntityZimWire) te;
		for (int i = 0; i < zw.connect.length; i++) {
			if (zw.connect[i] != null) {
				drawConnect(zw.connect[i]);
			}
		}

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-dx, -dy, -dz);
	}

	public void drawConnect(ForgeDirection dir) {
		Tessellator tes = Tessellator.instance;
		tes.startDrawingQuads();
		{
			GL11.glTranslatef(.5f, .5f, .5f);
			if (dir.equals(ForgeDirection.UP)) {

			}

			else if (dir.equals(ForgeDirection.DOWN)) {
				GL11.glRotatef(180, 1, 0, 0);
			}

			else if (dir.equals(ForgeDirection.SOUTH)) {
				GL11.glRotatef(90, 1, 0, 0);
			}

			else if (dir.equals(ForgeDirection.NORTH)) {
				GL11.glRotatef(270, 1, 0, 0);
			}

			else if (dir.equals(ForgeDirection.WEST)) {
				GL11.glRotatef(90, 0, 0, 1);
			}

			else if (dir.equals(ForgeDirection.EAST)) {
				GL11.glRotatef(270, 0, 0, 1);
			}
			GL11.glTranslatef(-.5f, -.5f, -.5f);

			tes.addVertexWithUV(1 - 11 * px / 2, 1 - 11 * px / 2, 1 - 11 * px / 2, 5 * tpx, 5 * tpx);
			tes.addVertexWithUV(1 - 11 * px / 2, 1, 1 - 11 * px / 2, 10 * tpx, 5 * tpx);
			tes.addVertexWithUV(11 * px / 2, 1, 1 - 11 * px / 2, 10 * tpx, 0 * tpx);
			tes.addVertexWithUV(11 * px / 2, 11 * px / 2, 1 - 11 * px / 2, 5 * tpx, 0 * tpx);

			tes.addVertexWithUV(11 * px / 2, 11 * px / 2, 11 * px / 2, 5 * tpx, 0 * tpx);
			tes.addVertexWithUV(11 * px / 2, 1, 11 * px / 2, 10 * tpx, 0 * tpx);
			tes.addVertexWithUV(1 - 11 * px / 2, 1, 11 * px / 2, 10 * tpx, 5 * tpx);
			tes.addVertexWithUV(1 - 11 * px / 2, 1 - 11 * px / 2, 11 * px / 2, 5 * tpx, 5 * tpx);

			tes.addVertexWithUV(1 - 11 * px / 2, 11 * px / 2, 11 * px / 2, 5 * tpx, 0 * tpx);
			tes.addVertexWithUV(1 - 11 * px / 2, 1, 11 * px / 2, 10 * tpx, 0 * tpx);
			tes.addVertexWithUV(1 - 11 * px / 2, 1, 1 - 11 * px / 2, 10 * tpx, 5 * tpx);
			tes.addVertexWithUV(1 - 11 * px / 2, 1 - 11 * px / 2, 1 - 11 * px / 2, 5 * tpx, 5 * tpx);

			tes.addVertexWithUV(11 * px / 2, 1 - 11 * px / 2, 1 - 11 * px / 2, 5 * tpx, 5 * tpx);
			tes.addVertexWithUV(11 * px / 2, 1, 1 - 11 * px / 2, 10 * tpx, 5 * tpx);
			tes.addVertexWithUV(11 * px / 2, 1, 11 * px / 2, 10 * tpx, 0 * tpx);
			tes.addVertexWithUV(11 * px / 2, 11 * px / 2, 11 * px / 2, 5 * tpx, 0 * tpx);
		}
		tes.draw();

		GL11.glTranslatef(.5f, .5f, .5f);
		if (dir.equals(ForgeDirection.UP)) {

		}

		else if (dir.equals(ForgeDirection.DOWN)) {
			GL11.glRotatef(-180, 1, 0, 0);
		}

		else if (dir.equals(ForgeDirection.SOUTH)) {
			GL11.glRotatef(-90, 1, 0, 0);
		}

		else if (dir.equals(ForgeDirection.NORTH)) {
			GL11.glRotatef(-270, 1, 0, 0);
		}

		else if (dir.equals(ForgeDirection.WEST)) {
			GL11.glRotatef(-90, 0, 0, 1);
		}

		else if (dir.equals(ForgeDirection.EAST)) {
			GL11.glRotatef(-270, 0, 0, 1);
		}
		GL11.glTranslatef(-.5f, -.5f, -.5f);
	}

	public void drawCore(TileEntity te) {
		Tessellator tes = Tessellator.instance;
		tes.startDrawingQuads();
		{
			tes.addVertexWithUV(1 - 11 * px / 2, 11 * px / 2, 1 - 11 * px / 2, 5 * tpx, 5 * tpx);
			tes.addVertexWithUV(1 - 11 * px / 2, 1 - 11 * px / 2, 1 - 11 * px / 2, 5 * tpx, 0 * tpx);
			tes.addVertexWithUV(11 * px / 2, 1 - 11 * px / 2, 1 - 11 * px / 2, 0 * tpx, 0 * tpx);
			tes.addVertexWithUV(11 * px / 2, 11 * px / 2, 1 - 11 * px / 2, 0 * tpx, 5 * tpx);

			tes.addVertexWithUV(1 - 11 * px / 2, 11 * px / 2, 11 * px / 2, 5 * tpx, 5 * tpx);
			tes.addVertexWithUV(1 - 11 * px / 2, 1 - 11 * px / 2, 11 * px / 2, 5 * tpx, 0 * tpx);
			tes.addVertexWithUV(1 - 11 * px / 2, 1 - 11 * px / 2, 1 - 11 * px / 2, 0 * tpx, 0 * tpx);
			tes.addVertexWithUV(1 - 11 * px / 2, 11 * px / 2, 1 - 11 * px / 2, 0 * tpx, 5 * tpx);

			tes.addVertexWithUV(11 * px / 2, 11 * px / 2, 11 * px / 2, 5 * tpx, 5 * tpx);
			tes.addVertexWithUV(11 * px / 2, 1 - 11 * px / 2, 11 * px / 2, 5 * tpx, 0 * tpx);
			tes.addVertexWithUV(11 * px / 2, 1 - 11 * px / 2, 11 * px / 2, 0 * tpx, 0 * tpx);
			tes.addVertexWithUV(11 * px / 2, 11 * px / 2, 11 * px / 2, 0 * tpx, 5 * tpx);

			tes.addVertexWithUV(11 * px / 2, 11 * px / 2, 1 - 11 * px / 2, 5 * tpx, 5 * tpx);
			tes.addVertexWithUV(11 * px / 2, 1 - 11 * px / 2, 1 - 11 * px / 2, 5 * tpx, 0 * tpx);
			tes.addVertexWithUV(11 * px / 2, 1 - 11 * px / 2, 11 * px / 2, 0 * tpx, 0 * tpx);
			tes.addVertexWithUV(11 * px / 2, 11 * px / 2, 11 * px / 2, 0 * tpx, 5 * tpx);

			tes.addVertexWithUV(1 - 11 * px / 2, 1 - 11 * px / 2, 1 - 11 * px / 2, 5 * tpx, 5 * tpx);
			tes.addVertexWithUV(1 - 11 * px / 2, 1 - 11 * px / 2, 11 * px / 2, 5 * tpx, 0 * tpx);
			tes.addVertexWithUV(11 * px / 2, 1 - 11 * px / 2, 11 * px / 2, 0 * tpx, 0 * tpx);
			tes.addVertexWithUV(11 * px / 2, 1 - 11 * px / 2, 1 - 11 * px / 2, 0 * tpx, 5 * tpx);

			tes.addVertexWithUV(11 * px / 2, 11 * px / 2, 1 - 11 * px / 2, 5 * tpx, 5 * tpx);
			tes.addVertexWithUV(11 * px / 2, 11 * px / 2, 11 * px / 2, 5 * tpx, 0 * tpx);
			tes.addVertexWithUV(1 - 11 * px / 2, 11 * px / 2, 11 * px / 2, 0 * tpx, 0 * tpx);
			tes.addVertexWithUV(1 - 11 * px / 2, 11 * px / 2, 1 - 11 * px / 2, 0 * tpx, 5 * tpx);
		}

		tes.draw();
	}
}
