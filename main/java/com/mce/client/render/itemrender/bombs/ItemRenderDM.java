package com.mce.client.render.itemrender.bombs;

import com.mce.entity.tile.bombs.TileEntityDM;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderDM implements IItemRenderer {
	public ItemRenderDM() {
	}

	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item,
			Object... data) {
		TileEntityRendererDispatcher.instance.renderTileEntityAt(
				new TileEntityDM(), 0.0D, -0.1D, 0.0D, 0.0F);
	}

}
