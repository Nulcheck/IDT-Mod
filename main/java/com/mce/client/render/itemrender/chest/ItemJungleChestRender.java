package com.mce.client.render.itemrender.chest;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import com.mce.common.mod_IDT;
import com.mce.entity.tile.chest.TileEntityJungleChest;

public class ItemJungleChestRender implements IItemRenderer {

	public static ItemJungleChestRender instance = new ItemJungleChestRender();
	private TileEntityJungleChest itemRender = new TileEntityJungleChest();

	private ModelChest chestModel;

	public ItemJungleChestRender() {

		chestModel = new ModelChest();

	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		TileEntityRendererDispatcher.instance.renderTileEntityAt(
				new TileEntityJungleChest(), 0.0D, -0.1D, 0.0D, 0.0F);

	}

	public void renderChest(Block var1, int var2, float var3) {
		if (var1 == mod_IDT.JungleChest) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(
					this.itemRender, 0.0D, 0.0D, 0.0D, 0.0F);
		}

		if (var1 == mod_IDT.JungleTrapChest) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(
					this.itemRender, 0.0D, 0.0D, 0.0D, 0.0F);
		}
	}

}
