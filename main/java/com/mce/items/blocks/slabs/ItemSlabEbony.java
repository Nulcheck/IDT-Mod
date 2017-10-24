package com.mce.items.blocks.slabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

import com.mce.common.mod_IDT;

public class ItemSlabEbony extends ItemSlab {
	public ItemSlabEbony(Block block) {
		super(block, (BlockSlab) mod_IDT.EbonySlab,
				(BlockSlab) mod_IDT.EbonyDoubleSlab, false);
	}
}
