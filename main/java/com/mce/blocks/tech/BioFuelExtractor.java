package com.mce.blocks.tech;

import java.util.List;
import java.util.Random;

import com.mce.common.mod_IDT;
import com.mce.entity.tile.tech.TileEntityBFE;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BioFuelExtractor extends BlockContainer {
	private Random rand = new Random();
	private static boolean keepInv;

	public BioFuelExtractor(Material mat) {
		super(mat);
	}

	// Creative middle click
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(mod_IDT.BioFuelExtractor);
	}

	/*
	 * public void onBlockAdded(World world, int x, int y, int z) {
	 * TileEntityBFE bfe = (TileEntityBFE) world.getTileEntity(x, y, z); int
	 * meta = world.getBlockMetadata(x, y, z);
	 * 
	 * super.onBlockAdded(world, x, y, z);
	 * 
	 * if (meta == 0) { bfe.setLvl("steel"); bfe.updateEntity(); } if (meta ==
	 * 1) { bfe.setLvl("titanium"); bfe.updateEntity(); } if (meta == 2) {
	 * bfe.setLvl("tantalum"); bfe.updateEntity(); } if (meta == 3) {
	 * bfe.setLvl("vanadium"); bfe.updateEntity(); } if (meta == 4) {
	 * bfe.setLvl("vc"); bfe.updateEntity(); }
	 * 
	 * 
	 * bfe.setDamage(bfe.getMaxDamage()); }
	 */

	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBFE();
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX,
			float hitY, float hitZ) {

		player.openGui(mod_IDT.instance, mod_IDT.BFEGUI, world, x, y, z);
		return true;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		TileEntityBFE bfe = (TileEntityBFE) world.getTileEntity(x, y, z);
		int l = MathHelper.floor_double((double) (entity.rotationYaw * 4f / 360f) + .5d) & 3;

		bfe.setDamage(bfe.getMaxDamage());

		if (l == 0)
			bfe.setFacing(2);
		if (l == 1)
			bfe.setFacing(5);
		if (l == 3)
			bfe.setFacing(3);
		if (l == 4)
			bfe.setFacing(4);

		if (stack.hasDisplayName()) {
			bfe.setGuiDisplayName(stack.getDisplayName());
		}
	}

	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(item, 1, 0)); // Steel
		list.add(new ItemStack(item, 1, 1)); // Titanium
		list.add(new ItemStack(item, 1, 2)); // Tantalum
		list.add(new ItemStack(item, 1, 3)); // Vanadium
		list.add(new ItemStack(item, 1, 4)); // Vanadium Carbide
	}

	public int damageDropped(int meta) {
		return meta;
	}

	public static void updateState(boolean active, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		keepInv = true;

		if (active) {
			// idfk
		} else {
			// idfk either..
		}

		keepInv = false;

		if (te != null) {
			te.validate();
			world.setTileEntity(x, y, z, te);
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (!keepInv) {
			TileEntityBFE entity = (TileEntityBFE) world.getTileEntity(x, y, z);

			if (entity != null) {
				for (int i = 0; i < entity.getSizeInv(); i++) {
					ItemStack stack = entity.getStackInSlot(i);

					if (stack != null) {
						float f = this.rand.nextFloat() * .8f + .1f;
						float f1 = this.rand.nextFloat() * .8f + .1f;
						float f2 = this.rand.nextFloat() * .8f + .1f;

						while (stack.stackSize > 0) {
							int j = this.rand.nextInt(21) + 10;

							if (j > stack.stackSize) {
								j = stack.stackSize;
							}

							stack.stackSize -= j;

							EntityItem item = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1),
									(double) ((float) z + f2),
									new ItemStack(stack.getItem(), j, stack.getItemDamage()));

							// Check items for tag and load it
							if (stack.hasTagCompound()) {
								item.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
							}

							// Set motion to dropped items
							float f3 = .05f;
							item.motionX = (double) ((float) this.rand.nextGaussian() * f3);
							item.motionY = (double) ((float) this.rand.nextGaussian() * f3 + .2f);
							item.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

							world.spawnEntityInWorld(item);
						}
					}
				}
				world.getBlock(x, y, z);
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	// Comparator stuff!
	public boolean hasComparatorOverride(World world, int x, int y, int z) {
		return true;
	}

	public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
		return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
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
