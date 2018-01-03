package com.mce.client.render.itemrender.tech;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import com.mce.entity.tile.tech.TileEntityMatterCondenser;
import com.mce.models.blocks.MatterCondenserModel;

public class ItemRenderMatterCondenser implements IItemRenderer {
	private MatterCondenserModel model;

	public ItemRenderMatterCondenser() {
		this.model = new MatterCondenserModel();
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
