package com.mce.client.render.itemrender.tech;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import com.mce.blocks.modeled.matterCondenser;
import com.mce.entity.tile.tech.TileEntityMatterCondenser;

public class ItemRenderMatterCondenser implements IItemRenderer {
	private matterCondenser model;

	public ItemRenderMatterCondenser() {
		this.model = new matterCondenser();
	}

	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRendererDispatcher.instance.renderTileEntityAt(
				new TileEntityMatterCondenser(), 0d, -.1d, 0d, 0f);
	}

}
