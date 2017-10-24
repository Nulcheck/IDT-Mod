package com.mce.client.render.itemrender;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import com.mce.entity.tile.TileEntityTF;
import com.mce.models.blocks.titaniumFrame;

public class ItemRenderTF implements IItemRenderer {
	private titaniumFrame model;

	public ItemRenderTF() {
		this.model = new titaniumFrame();
	}

	public boolean handleRenderType(ItemStack item,
			IItemRenderer.ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type,
			ItemStack item, IItemRenderer.ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item,
			Object... data) {
		TileEntityRendererDispatcher.instance.renderTileEntityAt(
				new TileEntityTF(), 0.0D, -0.1D, 0.0D, 0.0F);
	}
}
