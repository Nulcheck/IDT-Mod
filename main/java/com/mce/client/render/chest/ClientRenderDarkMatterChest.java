package com.mce.client.render.chest;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.mce.blocks.chest.EbonyChest;
import com.mce.entity.tile.chest.TileEntityDarkMatterChest;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientRenderDarkMatterChest extends TileEntitySpecialRenderer {
	/*
	 * private static final ResourceLocation trap_double = new ResourceLocation(
	 * "mod_idt",
	 * "/textures/entity/chest/trapped_double_ebony.png".substring(1));
	 * 
	 * private static final ResourceLocation trap_single = new ResourceLocation(
	 * "mod_idt", "/textures/entity/chest/trapped_ebony.png".substring(1));
	 */

	private static final ResourceLocation normal_double = new ResourceLocation(
			"mod_idt",
			"/textures/entity/chest/normal_double_dm.png".substring(1));

	private static final ResourceLocation normal_single = new ResourceLocation(
			"mod_idt", "/textures/entity/chest/normal_dm.png".substring(1));

	private ModelChest chestModel = new ModelChest();
	private ModelChest largeChestModel = new ModelLargeChest();

	public ClientRenderDarkMatterChest() {
	}

	public void renderTileEntityChestAt(
			TileEntityDarkMatterChest par1TileEntity, double par2, double par4,
			double par6, float par8) {
		int i;

		if (!par1TileEntity.hasWorldObj()) {
			i = 0;
		} else {
			Block block = par1TileEntity.getBlockType();
			i = par1TileEntity.getBlockMetadata();

			if (block instanceof EbonyChest && i == 0) {
				try {
					((EbonyChest) block).unifyAdjacentChests(
							par1TileEntity.getWorldObj(),
							par1TileEntity.xCoord, par1TileEntity.yCoord,
							par1TileEntity.zCoord);
				} catch (ClassCastException e) {
					FMLLog.severe(
							"Attempted to render a chest at %d,  %d, %d that was not a chest",
							par1TileEntity.xCoord, par1TileEntity.yCoord,
							par1TileEntity.zCoord);
				}
				i = par1TileEntity.getBlockMetadata();
			}

			par1TileEntity.checkForAdjacentChests();
		}

		if (par1TileEntity.adjacentChestZNeg == null
				&& par1TileEntity.adjacentChestXNeg == null) {
			ModelChest modelchest;

			if (par1TileEntity.adjacentChestXPos == null
					&& par1TileEntity.adjacentChestZPos == null) {
				modelchest = this.chestModel;

				/*
				 * if (par1TileEntityChest.getChestType() == 1) {
				 * this.bindTexture(trap_single); } else if (this.isChristmas) {
				 * this.bindTexture(xmas_single); } else if (this.isBirthday) {
				 * this.bindTexture(bday_single); }
				 */

				this.bindTexture(normal_single);

			} else {
				modelchest = this.largeChestModel;

				/*
				 * if (par1TileEntityChest.getChestType() == 1) {
				 * this.bindTexture(trap_double); } else if (this.isChristmas) {
				 * this.bindTexture(xmas_double); } else if (this.isBirthday) {
				 * this.bindTexture(bday_double); }
				 */
				this.bindTexture(normal_double);

			}

			GL11.glPushMatrix();
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) par2, (float) par4 + 1.0F,
					(float) par6 + 1.0F);
			GL11.glScalef(1.0F, -1.0F, -1.0F);
			GL11.glTranslatef(0.5F, 0.5F, 0.5F);
			short short1 = 0;

			if (i == 2) {
				short1 = 180;
			}

			if (i == 3) {
				short1 = 0;
			}

			if (i == 4) {
				short1 = 90;
			}

			if (i == 5) {
				short1 = -90;
			}

			if (i == 2 && par1TileEntity.adjacentChestXPos != null) {
				GL11.glTranslatef(1.0F, 0.0F, 0.0F);
			}

			if (i == 5 && par1TileEntity.adjacentChestZPos != null) {
				GL11.glTranslatef(0.0F, 0.0F, -1.0F);
			}

			GL11.glRotatef((float) short1, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			float f1 = par1TileEntity.prevLidAngle
					+ (par1TileEntity.lidAngle - par1TileEntity.prevLidAngle)
					* par8;
			float f2;

			if (par1TileEntity.adjacentChestZNeg != null) {
				f2 = par1TileEntity.adjacentChestZNeg.prevLidAngle
						+ (par1TileEntity.adjacentChestZNeg.lidAngle - par1TileEntity.adjacentChestZNeg.prevLidAngle)
						* par8;

				if (f2 > f1) {
					f1 = f2;
				}
			}

			if (par1TileEntity.adjacentChestXNeg != null) {
				f2 = par1TileEntity.adjacentChestXNeg.prevLidAngle
						+ (par1TileEntity.adjacentChestXNeg.lidAngle - par1TileEntity.adjacentChestXNeg.prevLidAngle)
						* par8;

				if (f2 > f1) {
					f1 = f2;
				}
			}

			f1 = 1.0F - f1;
			f1 = 1.0F - f1 * f1 * f1;
			modelchest.chestLid.rotateAngleX = -(f1 * (float) Math.PI / 2.0F);
			modelchest.renderAll();
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
			GL11.glPopMatrix();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	public void renderTileEntityAt(TileEntity par1TileEntity, double par2,
			double par4, double par6, float par8) {
		renderTileEntityChestAt((TileEntityDarkMatterChest) par1TileEntity,
				par2, par4, par6, par8);
	}

}
