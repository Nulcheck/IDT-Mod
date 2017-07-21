package com.mce.gui;

import java.awt.Rectangle;
import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import com.mce.container.SmelterContainer;
import com.mce.entity.tile.tech.TileEntitySmelter;

import codechicken.nei.recipe.TemplateRecipeHandler.RecipeTransferRect;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class SmelterGui extends GuiContainer {
	public TileEntitySmelter smelter;

	public static final ResourceLocation texture = new ResourceLocation("mod_idt",
			"/textures/gui/smelter.png".substring(1));

	public SmelterGui(InventoryPlayer player, TileEntitySmelter entity) {
		super(new SmelterContainer(player, entity));

		this.smelter = entity;

		this.xSize = 176;
		this.ySize = 176; //166
	}

	public void drawGuiContainerForegroundLayer(int x, int y) {
		String name = this.smelter.isInvNameLocalized() ? this.smelter.getInvName()
				: I18n.format(this.smelter.getInvName());

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		double pdam = (this.smelter.damage * 100d) / this.smelter.maxDamage;
		String dam = String.valueOf(df.format(pdam));

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
				4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 28, this.ySize - 106 + 2, 4210752);

		this.fontRendererObj.drawString(dam + "%", 134, this.ySize - 106 + 2, 4210752);
	}

	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1f, 1f, 1f, 1f);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		int L, c, d;

		if (this.smelter.hasFuel()) {
			L = this.smelter.getFuelRemainingScaled(50);
			drawTexturedModalRect(guiLeft + 8, guiTop + 61 - L, 176, 17, 16, L);
		}

		c = this.smelter.getCookProgressScaled(24);
		drawTexturedModalRect(guiLeft + 100, guiTop + 34, 176, 0, c + 1, 17);

		d = this.smelter.getDamageScaled(49);
		drawTexturedModalRect(guiLeft + 164, guiTop + 80 - d, 192, 66 - d, 4, d);
	}
}
