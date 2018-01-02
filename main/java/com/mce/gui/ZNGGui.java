package com.mce.gui;

import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import com.mce.container.ZNGContainer;
import com.mce.entity.tile.tech.TileEntityZNG;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class ZNGGui extends GuiContainer {
	public TileEntityZNG zng;

	public final ResourceLocation texture = new ResourceLocation("mod_idt", "/textures/gui/zng.png".substring(1));

	public ZNGGui(InventoryPlayer player, TileEntityZNG entity) {
		super(new ZNGContainer(player, entity));

		this.zng = entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int x, int y) {
		String name = this.zng.isInvNameLocalized() ? this.zng.getInvName() : I18n.format(this.zng.getInvName());

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		double pdam = (this.zng.damage * 100d) / this.zng.maxDamage;
		double pfuel = (this.zng.fuel * 100d) / this.zng.maxFuel;
		String dam = String.valueOf(df.format(pdam));
		String fuel = String.valueOf(df.format(pfuel));

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
				4210752);
		//this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);

		this.fontRendererObj.drawString(dam + "%", 131, this.ySize - 96 + 2, 4210752);

		this.fontRendererObj.drawString(fuel + "%", 30, this.ySize - 111, 4210752);

		// this.fontRendererObj.drawString("Power", 137, 32, 4210752);
		// this.fontRendererObj.drawString("Output", 137, 42, 4210752);
	}

	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1f, 1f, 1f, 1f);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		int k, d;

		if (this.zng.hasFuel()) {
			k = this.zng.getFuelTimeRemainingScaled(50);
			this.drawTexturedModalRect(guiLeft + 8, guiTop + 61 - k, 176, 0, 16, k);
		}

		if (this.zng.isPowering()) {
			this.drawTexturedModalRect(guiLeft + 120, guiTop + 21, 177, 51, 20, 15);
		}

		d = this.zng.getDamageScaled(49);
		drawTexturedModalRect(guiLeft + 164, guiTop + 80 - d, 192, 49 - d, 4, d);
	}
}
