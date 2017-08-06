package com.mce.blocks;

import com.mce.blocks.portals.FrozenPortal;
import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class FrozenFire extends Block {
	public FrozenFire(Material mat) {
		super(mat);
		this.setBlockTextureName("mod_IDT:invs");
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}
	
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		return AxisAlignedBB.getBoundingBox(0,0,0,0,0,0);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int getRenderBlockPass() {
		return 1;
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		if (!((FrozenPortal) mod_IDT.FrozenPortal).getPortalSize(world, x, y, z)) {
			world.setBlockToAir(x, y, z);
		}
	}
}