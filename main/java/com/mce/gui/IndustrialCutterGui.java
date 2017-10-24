package com.mce.gui;

import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import com.mce.blocks.tech.IndustrialCutter;
import com.mce.container.IndustrialCutterContainer;
import com.mce.entity.tile.tech.TileEntityIndustrialCutter;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class IndustrialCutterGui extends GuiContainer {
	public TileEntityIndustrialCutter cutter;

	public final ResourceLocation texture = new ResourceLocation("mod_idt", "/textures/gui/cutter.png".substring(1));

	public IndustrialCutterGui(InventoryPlayer player, TileEntityIndustrialCutter entity) {
		super(new IndustrialCutterContainer(player, entity));

		this.cutter = entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int x, int y) {
		String name = this.cutter.isInvNameLocalized() ? this.cutter.getInvName()
				: I18n.format(this.cutter.getInvName());

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		double pdam = (this.cutter.damage * 100d) / this.cutter.maxDamage;
		String dam = String.valueOf(df.format(pdam));

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
				4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);

		this.fontRendererObj.drawString(dam + "%", 131, this.ySize - 96 + 2, 4210752);
	}

	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1f, 1f, 1f, 1f);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		int k, d;

		if (IndustrialCutter.isActive) {
			drawTexturedModalRect(guiLeft + 6, guiTop + 3, 176, 0 - 3, 23, 22);
		}

		k = this.cutter.getCookProgressScaled(24);
		drawTexturedModalRect(guiLeft + 80, guiTop + 34, 176, 22, k + 1, 17);

		d = this.cutter.getDamageScaled(49);
		drawTexturedModalRect(guiLeft + 164, guiTop + 80 - d, 176, 88 - d, 4, d);
	}
}
