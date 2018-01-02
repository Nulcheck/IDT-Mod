package com.mce.gui;

import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import com.mce.container.MagnetizerContainer;
import com.mce.entity.tile.tech.TileEntityMagnetizer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class MagnetizerGui extends GuiContainer {
	public TileEntityMagnetizer magnetizer;

	public static final ResourceLocation texture = new ResourceLocation("mod_idt",
			"/textures/gui/magnetizer.png".substring(1));

	public MagnetizerGui(InventoryPlayer player, TileEntityMagnetizer entity) {
		super(new MagnetizerContainer(player, entity));

		this.magnetizer = entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int x, int y) {
		String name = this.magnetizer.isInvNameLocalized() ? this.magnetizer.getInvName()
				: I18n.format(this.magnetizer.getInvName());

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		double pdam = (this.magnetizer.damage * 100d) / this.magnetizer.maxDamage;
		String dam = String.valueOf(df.format(pdam));

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
				4210752);
		//this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);

		this.fontRendererObj.drawString(dam + "%", 131, this.ySize - 96 + 2, 4210752);
	}

	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1f, 1f, 1f, 1f);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		int k, d;

		if (this.magnetizer.isMagnetizing()) {
			k = this.magnetizer.getCookProgressScaled(35);
			drawTexturedModalRect(guiLeft + 74, guiTop + 39, 176, 22, k + 1, 11);
		}

		if (this.magnetizer.isPowered() == true) {
			drawTexturedModalRect(guiLeft + 6, guiTop + 3, 176, 0 - 3, 23, 22);
		}

		d = this.magnetizer.getDamageScaled(49);
		drawTexturedModalRect(guiLeft + 164, guiTop + 80 - d, 176, 82 - d, 4, d);
	}
}
