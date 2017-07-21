package com.mce.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBucket;
import net.minecraft.world.World;

import com.mce.common.mod_IDT;

public class LiquidNitrogenBucket extends ItemBucket {
	public LiquidNitrogenBucket(Block block) {
		super(block);
	}

	public boolean tryPlaceContainedLiquid(World world, int x, int y, int z) {
		if (!world.isAirBlock(x, y, z)) {
			return false;
		} else {
			world.setBlock(x, y, z, mod_IDT.LiquidNitrogen, 0, 3);
			return true;
		}
	}
}
