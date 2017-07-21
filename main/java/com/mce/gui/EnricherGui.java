package com.mce.gui;

import org.lwjgl.opengl.GL11;

import com.mce.container.SmelterContainer;
import com.mce.entity.tile.tech.TileEntitySmelter;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class EnricherGui extends GuiContainer {
	public TileEntitySmelter smelter;

	public static final ResourceLocation texture = new ResourceLocation("mod_idt",
			"/textures/gui/enricher.png".substring(1));

	public EnricherGui(InventoryPlayer player, TileEntitySmelter entity) {
		super(new SmelterContainer(player, entity));

		this.smelter = entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int x, int y) {
		String name = this.smelter.isInvNameLocalized() ? this.smelter.getInvName()
				: I18n.format(this.smelter.getInvName());

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
				4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"),
				this.xSize / 2 - this.fontRendererObj.getStringWidth("Inventory") / 2, this.ySize - 96 + 2, 4210752);
	}

	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1f, 1f, 1f, 1f);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		int k;

		//k = this.smelter.getCookProgressScaled(24);
		//drawTexturedModalRect(guiLeft + 100, guiTop + 34, 176, 0, k + 1, 17);

	}
}