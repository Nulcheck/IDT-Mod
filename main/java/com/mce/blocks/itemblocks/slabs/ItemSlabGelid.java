package com.mce.blocks.itemblocks.slabs;

import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ItemSlabGelid extends ItemSlab {
	public ItemSlabGelid(Block block) {
		super(block, (BlockSlab) mod_IDT.GelidSlab, (BlockSlab) mod_IDT.GelidDoubleSlab, false);
	}
}
