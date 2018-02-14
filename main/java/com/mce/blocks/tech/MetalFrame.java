package com.mce.blocks.tech;

import java.util.List;

import com.mce.entity.tile.TileEntityMetalFrame;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MetalFrame extends BlockContainer {
	public MetalFrame(Material mat) {
		super(mat);
	}

	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityMetalFrame();
	}

	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item, 1, 0)); // Steel
		list.add(new ItemStack(item, 1, 1)); // Titanium
		list.add(new ItemStack(item, 1, 2)); // Tantalum
		list.add(new ItemStack(item, 1, 3)); // Vanadium
		list.add(new ItemStack(item, 1, 4)); // Vanadium Carbide
	}

	public float getBlockHardness(World world, int x, int y, int z) {
		if (world.getBlockMetadata(x, y, z) == 0)
			return 1.5f;
		if (world.getBlockMetadata(x, y, z) == 1)
			return 2f;
		if (world.getBlockMetadata(x, y, z) == 2)
			return 2.5f;
		if (world.getBlockMetadata(x, y, z) == 3)
			return 3f;
		if (world.getBlockMetadata(x, y, z) == 4)
			return 4f;
		else
			return 2f;
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

	public int damageDropped(int meta) {
		return meta;
	}
}