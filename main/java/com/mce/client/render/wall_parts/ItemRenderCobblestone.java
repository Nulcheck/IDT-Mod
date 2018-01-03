package com.mce.client.render.wall_parts;

import com.mce.entity.tile.wall_parts.TileEntityWPCobblestone;
import com.mce.models.items.WallPartModel;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderCobblestone implements IItemRenderer {
	private WallPartModel model;

	public ItemRenderCobblestone() {
		this.model = new WallPartModel();
	}

	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item,
			IItemRenderer.ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityWPCobblestone(), 0.0D, -0.1D, 0.0D,
				0.0F);
	}
}
