package com.mce.blocks.dimensions.frost;

import java.util.Random;

import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class FrostyBlocks extends Block {
	public FrostyBlocks(Material mat) {
		super(mat);
	}

	public static class FrozenStone extends Block {
		public FrozenStone(Material mat) {
			super(mat);
		}

		public Item getItemDropped(int id, Random random, int amount) {
			return Item.getItemFromBlock(mod_IDT.FrostCobble);
		}
	}
}
