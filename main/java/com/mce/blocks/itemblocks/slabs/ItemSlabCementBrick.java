package com.mce.blocks.itemblocks.slabs;

import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabCementBrick extends ItemSlab {
	public ItemSlabCementBrick(Block block) {
		super(block, (BlockSlab) mod_IDT.CementBrickSlab, (BlockSlab) mod_IDT.CementBrickDoubleSlab, false);
	}
}
