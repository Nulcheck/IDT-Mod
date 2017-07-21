package com.mce.gui;

import java.text.DecimalFormat;

import org.lwjgl.opengl.GL11;

import com.mce.blocks.ModBlocks.BHG;
import com.mce.container.BHGContainer;
import com.mce.entity.tile.tech.TileEntityBHG;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class BHGGui extends GuiContainer {
	public TileEntityBHG bhg;

	public static final ResourceLocation texture = new ResourceLocation("mod_idt",
			"/textures/gui/bhg.png".substring(1));

	public BHGGui(InventoryPlayer player, TileEntityBHG entity) {
		super(new BHGContainer(player, entity));

		this.bhg = entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int x, int y) {
		String name = this.bhg.isInvNameLocalized() ? this.bhg.getInvName() : I18n.format(this.bhg.getInvName());

		DecimalFormat df = new DecimalFormat();
		DecimalFormat df2 = new DecimalFormat();
		DecimalFormat df3 = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df2.setMaximumFractionDigits(3);
		df3.setMaximumFractionDigits(1);
		double pdam = (this.bhg.damage * 100d) / this.bhg.maxDamage;
		double pfuel = (this.bhg.fuel * 100d) / this.bhg.maxFuel;
		double pprog = (this.bhg.createTime * 100d) / this.bhg.speed;
		String dam = String.valueOf(df.format(pdam));
		String fuel = String.valueOf(df2.format(pfuel));
		String prog = String.valueOf(df3.format(pprog));

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6,
				4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);

		this.fontRendererObj.drawString(dam + "%", 134, this.ySize - 96 + 2, 4210752);
		this.fontRendererObj.drawString(fuel + "%", 30, this.ySize - 122, 4210752);
		this.fontRendererObj.drawString("Hole Progress:", 35, this.ySize - 140, 4210752);
		
		if(pprog >= 100){
			this.fontRendererObj.drawString("Done", 115, this.ySize - 140, 4210752);
		} else {
			this.fontRendererObj.drawString(prog + "%", 115, this.ySize - 140, 4210752);
		}
	}

	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1f, 1f, 1f, 1f);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		int L, d, p;

		if (this.bhg.hasFuel()) {
			L = this.bhg.getFuelScaled(81);
			drawTexturedModalRect(guiLeft + 8, guiTop + 54, 176, 22, L - 2, 16);
		}

		if (BHG.isActive) {
			drawTexturedModalRect(guiLeft + 6, guiTop + 3, 176, 0 - 3, 23, 22);
		}
		
		d = this.bhg.getDamagedScaled(49);
		drawTexturedModalRect(guiLeft + 164, guiTop + 80 - d, 176, 87 - d, 4, d);
	}
}
