package com.mce.blocks.itemblocks.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import com.mce.common.mod_IDT;

public class ItemSlabStone extends ItemSlab {
	public ItemSlabStone(Block block) {
		super(block, (BlockSlab) mod_IDT.StoneSlab,
				(BlockSlab) mod_IDT.StoneDoubleSlab, false);
	}
}
