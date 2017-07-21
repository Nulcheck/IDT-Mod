package com.mce.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModGlass extends Block {
	public ModGlass(Material mat) {
		super(mat);
	}

	public int getRenderBlockPass() {
		return 1;
	}

	public boolean isOpaqueCube() {
		return false;
	}
}
