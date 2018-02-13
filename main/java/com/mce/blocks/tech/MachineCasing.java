package com.mce.blocks.tech;

import java.util.List;
import java.util.Random;

import com.mce.entity.tile.tech.TileEntityMachineCasing;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MachineCasing extends BlockContainer {
	public MachineCasing(Material mat) {
		super(mat);
	}

	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityMachineCasing();
	}

	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item, 1, 0)); // Steel
		list.add(new ItemStack(item, 1, 1)); // Titanium
		list.add(new ItemStack(item, 1, 2)); // Tantalum
		list.add(new ItemStack(item, 1, 3)); // Vanadium
		list.add(new ItemStack(item, 1, 4)); // Vanadium Carbide
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

	public Item getItemDropped(int id, Random random, int amount) {
		return Item.getItemFromBlock(this);
	}
}
