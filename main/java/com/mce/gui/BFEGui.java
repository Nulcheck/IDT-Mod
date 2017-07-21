package com.mce.gui;

import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import com.mce.blocks.ModBlocks.BioFuelExtractor;
import com.mce.container.BFEContainer;
import com.mce.entity.tile.tech.TileEntityBFE;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class BFEGui extends GuiContainer {
	public TileEntityBFE bfe;
	public World world;

	public final ResourceLocation texture = new ResourceLocation("mod_idt", "/textures/gui/cutter.png".substring(1));

	public BFEGui(InventoryPlayer player, TileEntityBFE entity) {
		super(new BFEContainer(player, entity));

		this.bfe = entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int x, int y) {
		String name = this.bfe.isInvNameLocalized() ? this.bfe.getInvName() : I18n.format(this.bfe.getInvName());

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		double pdam = (this.bfe.damage * 100d) / this.bfe.maxDamage;
		String dam = String.valueOf(df.format(pdam));

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
				4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);

		this.fontRendererObj.drawString(dam + "%", 134, this.ySize - 96 + 2, 4210752);
	}

	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1f, 1f, 1f, 1f);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		int k, d;

		if (this.bfe.isExtracting()) {
			k = this.bfe.getCookProgressScaled(24);
			drawTexturedModalRect(guiLeft + 80, guiTop + 34, 176, 22, k + 1, 17);
		}

		if (BioFuelExtractor.isActive) {
			drawTexturedModalRect(guiLeft + 6, guiTop + 3, 176, 0 - 3, 23, 22);
		}

		d = this.bfe.getDamageScaled(49);
		drawTexturedModalRect(guiLeft + 164, guiTop + 80 - d, 176, 88 - d, 4, d);
	}
}
