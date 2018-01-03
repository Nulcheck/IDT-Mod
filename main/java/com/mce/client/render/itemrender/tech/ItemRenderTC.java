package com.mce.client.render.itemrender.tech;

import com.mce.entity.tile.tech.TileEntityTankCompressor;
import com.mce.models.blocks.TankCompressorModel;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderTC implements IItemRenderer {
	private TankCompressorModel model;

	public ItemRenderTC() {
		this.model = new TankCompressorModel();
	}

	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item,
			IItemRenderer.ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityTankCompressor(), 0.0D, -0.1D, 0.0D,
				0.0F);
	}
}
