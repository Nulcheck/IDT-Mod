package com.mce.blocks.itemblocks.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import com.mce.common.mod_IDT;

public class ItemSlabWillow extends ItemSlab {
	public ItemSlabWillow(Block block) {
		super(block, (BlockSlab) mod_IDT.WillowSlab,
				(BlockSlab) mod_IDT.WillowDoubleSlab, false);
	}
}
