package com.mce.client.render.wall_parts;

import com.mce.entity.tile.wall_parts.TileEntityWPGelid;
import com.mce.models.items.WallPartModel;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderGelid implements IItemRenderer {
	private WallPartModel model;

	public ItemRenderGelid() {
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
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityWPGelid(), 0.0D, -0.1D, 0.0D, 0.0F);
	}
}
