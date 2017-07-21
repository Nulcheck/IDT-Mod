package com.mce.blocks.itemblocks.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import com.mce.common.mod_IDT;

public class ItemSlabSilkwood extends ItemSlab {
	public ItemSlabSilkwood(Block block) {
		super(block, (BlockSlab) mod_IDT.SilkwoodSlab,
				(BlockSlab) mod_IDT.SilkwoodDoubleSlab, false);
	}
}
