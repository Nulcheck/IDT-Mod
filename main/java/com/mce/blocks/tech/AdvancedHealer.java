package com.mce.blocks.tech;

import com.mce.entity.tile.TEAH;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class AdvancedHealer extends BlockContainer {
	public AdvancedHealer(Material mat) {
		super(mat);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}

	public void setDefaultDirection(World world, int x, int y, int z) {
		if (!world.isRemote) {
			Block block = world.getBlock(x, y, z - 1);
			Block block1 = world.getBlock(x, y, z + 1);
			Block block2 = world.getBlock(x - 1, y, z);
			Block block3 = world.getBlock(x + 1, y, z);
			byte b0 = 0;

			if (block.func_149730_j() && !block1.func_149730_j()) {
				b0 = 3;
			}

			if (block1.func_149730_j() && !block.func_149730_j()) {
				b0 = 2;
			}

			if (block2.func_149730_j() && !block3.func_149730_j()) {
				b0 = 5;
			}

			if (block3.func_149730_j() && !block2.func_149730_j()) {
				b0 = 4;
			}

			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}

	public TileEntity createNewTileEntity(World world, int meta) {
		return new TEAH();
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		int l = MathHelper.floor_double((double) (entity.rotationYaw * 4f / 360f) + .5d) & 3;

		if (l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 1);
		}

		if (l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 1);
		}

		if (l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 1);
		}

		if (l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 1);
		}

		/*
		 * if (stack.hasDisplayName()) { ((TET) world.getTileEntity(x, y,
		 * z)).setGuiDisplayName(stack.getDisplayName()); }
		 */
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderBlockPass() {
		return -1;
	}
}
