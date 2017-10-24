package com.mce.client.render.itemrender.bombs;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import com.mce.entity.tile.bombs.TileEntityUB;
import com.mce.models.blocks.ModelBomb;

public class ItemRenderUB implements IItemRenderer {
	private ModelBomb model;

	public ItemRenderUB() {
		this.model = new ModelBomb();
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
				new TileEntityUB(), 0.0D, -0.1D, 0.0D, 0.0F);
	}
}
