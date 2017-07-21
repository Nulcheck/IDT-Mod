package com.mce.client.render.chest;

import java.util.Calendar;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.mce.blocks.chest.GelidChest;
import com.mce.entity.tile.chest.TileEntityGelidChest;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class ClientRenderGelidChest extends TileEntitySpecialRenderer {
	private static final ResourceLocation trap_double = new ResourceLocation("mod_idt",
			"/textures/entity/chest/trapped_double_gelid.png".substring(1));

	private static final ResourceLocation trap_single = new ResourceLocation("mod_idt",
			"/textures/entity/chest/trapped_gelid.png".substring(1));

	private static final ResourceLocation normal_double = new ResourceLocation("mod_idt",
			"/textures/entity/chest/normal_double_gelid.png".substring(1));

	private static final ResourceLocation normal_single = new ResourceLocation("mod_idt",
			"/textures/entity/chest/normal_gelid.png".substring(1));

	private static final ResourceLocation xmas_double = new ResourceLocation(
			"textures/entity/chest/christmas_double.png");

	private static final ResourceLocation xmas_single = new ResourceLocation("textures/entity/chest/christmas.png");

	private static final ResourceLocation bday_single = new ResourceLocation("mod_idt",
			"/textures/entity/chest/bday.png".substring(1));

	private static final ResourceLocation bday_double = new ResourceLocation("mod_idt",
			"/textures/entity/chest/bday_double.png".substring(1));

	private ModelChest chestModel = new ModelChest();
	private ModelChest largeChestModel = new ModelLargeChest();
	private boolean isChristmas;
	private boolean isBirthday;

	public ClientRenderGelidChest() {
		Calendar calendar = Calendar.getInstance();
		if ((calendar.get(2) + 1 == 12) && (calendar.get(5) >= 24) && (calendar.get(5) <= 26)) {
			this.isChristmas = true;
		}
		if ((calendar.get(2) + 1 == 6) && (calendar.get(5) == 16)) {
			this.isBirthday = true;
		}
	}

	public void renderTileEntityChestAt(TileEntityGelidChest te, double par2, double par4, double par6, float par8) {
		int i;

		if (!te.hasWorldObj()) {
			i = 0;
		} else {
			Block block = te.getBlockType();
			i = te.getBlockMetadata();

			if (block instanceof GelidChest && i == 0) {
				try {
					((GelidChest) block).unifyAdjacentChests(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord);
				} catch (ClassCastException e) {
					FMLLog.severe("Attempted to render a chest at %d,  %d, %d that was not a chest", te.xCoord,
							te.yCoord, te.zCoord);
				}
				i = te.getBlockMetadata();
			}

			te.checkForAdjacentChests();
		}

		if (te.adjacentChestZNeg == null && te.adjacentChestXNeg == null) {
			ModelChest modelchest;

			if (te.adjacentChestXPos == null && te.adjacentChestZPos == null) {
				modelchest = this.chestModel;

				if (te.getChestType() == 1) {
					this.bindTexture(trap_single);
				} else if (this.isChristmas) {
					this.bindTexture(xmas_single);
				} else if (this.isBirthday) {
					this.bindTexture(bday_single);
				} else {
					this.bindTexture(normal_single);
				}
			} else {
				modelchest = this.largeChestModel;

				if (te.getChestType() == 1) {
					this.bindTexture(trap_double);
				} else if (this.isChristmas) {
					this.bindTexture(xmas_double);
				} else if (this.isBirthday) {
					this.bindTexture(bday_double);
				} else {
					this.bindTexture(normal_double);
				}
			}

			GL11.glPushMatrix();
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glTranslatef((float) par2, (float) par4 + 1.0F, (float) par6 + 1.0F);
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

			if (i == 2 && te.adjacentChestXPos != null) {
				GL11.glTranslatef(1.0F, 0.0F, 0.0F);
			}

			if (i == 5 && te.adjacentChestZPos != null) {
				GL11.glTranslatef(0.0F, 0.0F, -1.0F);
			}

			GL11.glRotatef((float) short1, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
			float f1 = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * par8;
			float f2;

			if (te.adjacentChestZNeg != null) {
				f2 = te.adjacentChestZNeg.prevLidAngle
						+ (te.adjacentChestZNeg.lidAngle - te.adjacentChestZNeg.prevLidAngle) * par8;

				if (f2 > f1) {
					f1 = f2;
				}
			}

			if (te.adjacentChestXNeg != null) {
				f2 = te.adjacentChestXNeg.prevLidAngle
						+ (te.adjacentChestXNeg.lidAngle - te.adjacentChestXNeg.prevLidAngle) * par8;

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

	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8) {
		renderTileEntityChestAt((TileEntityGelidChest) par1TileEntity, par2, par4, par6, par8);
	}
}
