package com.mce.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class ModWoodStairs extends BlockStairs {
	public ModWoodStairs(Block block, int meta) {
		super(block, meta);
		useNeighborBrightness = true;
	}
}
