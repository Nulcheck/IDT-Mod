package com.mce.gui;

import org.lwjgl.opengl.GL11;

import com.mce.container.WelderContainer;
import com.mce.entity.tile.tech.TileEntityWelder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class WelderGui extends GuiContainer {
	public TileEntityWelder welder;

	public static final ResourceLocation texture = new ResourceLocation("mod_idt",
			"/textures/gui/welder.png".substring(1));

	public WelderGui(InventoryPlayer player, TileEntityWelder entity) {
		super(new WelderContainer(player, entity));

		this.welder = entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int x, int y) {
		String name = this.welder.isInvNameLocalized() ? this.welder.getInvName()
				: I18n.format(this.welder.getInvName());

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
				4210752);
		//this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1f, 1f, 1f, 1f);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		int p, c;

		if (this.welder.isBurning()) {
			p = this.welder.getFuelRemainingScaled(29);
			drawTexturedModalRect(guiLeft + 8, guiTop + 64 - p, 176, 46 - p, 16, p + 1);
		}

		if (this.welder.isWelding()) {
			c = this.welder.getCookProgressScaled(24);
			drawTexturedModalRect(guiLeft + 100, guiTop + 34, 176, 0, c + 1, 17);
		}
	}
}
