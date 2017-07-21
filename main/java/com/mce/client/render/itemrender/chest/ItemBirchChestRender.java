package com.mce.client.render.itemrender.chest;

import com.mce.common.mod_IDT;
import com.mce.entity.tile.chest.TileEntityBirchChest;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemBirchChestRender implements IItemRenderer {

	public static ItemBirchChestRender instance = new ItemBirchChestRender();
	private TileEntityBirchChest itemRender = new TileEntityBirchChest();

	private ModelChest chestModel;

	public ItemBirchChestRender() {
		chestModel = new ModelChest();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityBirchChest(), 0.0D, -0.1D, 0.0D, 0.0F);

	}

	public void renderChest(Block var1, int var2, float var3) {
		if (var1 == mod_IDT.BirchChest) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.itemRender, 0.0D, 0.0D, 0.0D, 0.0F);
		}

		if (var1 == mod_IDT.BirchTrapChest) {
			TileEntityRendererDispatcher.instance.renderTileEntityAt(this.itemRender, 0.0D, 0.0D, 0.0D, 0.0F);
		}
	}

}
