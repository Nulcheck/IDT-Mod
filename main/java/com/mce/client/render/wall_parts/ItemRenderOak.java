package com.mce.client.render.wall_parts;

import com.mce.blocks.modeled.wallPart;
import com.mce.entity.tile.wall_parts.TileEntityWPOak;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderOak implements IItemRenderer {
	private wallPart model;

	public ItemRenderOak() {
		this.model = new wallPart();
	}

	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item,
			IItemRenderer.ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityWPOak(), 0.0D, -0.1D, 0.0D, 0.0F);
	}
}
