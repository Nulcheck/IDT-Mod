package com.mce.items.blocks.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import com.mce.common.mod_IDT;

public class ItemSlabCement extends ItemSlab {
	public ItemSlabCement(Block block) {
		super(block, (BlockSlab) mod_IDT.CementSlab,
				(BlockSlab) mod_IDT.CementDoubleSlab, false);
	}
}
