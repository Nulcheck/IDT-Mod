package com.mce.blocks.tech;

import java.util.Random;

import com.mce.common.mod_IDT;
import com.mce.entity.tile.tech.TileEntityMatterCondenser;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
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

public class MatterCondenser extends BlockContainer {
	private Random rand = new Random();
	private static boolean keepInv;

	public MatterCondenser(Material mat) {
		super(mat);
	}

	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(mod_IDT.MatterCondenser);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		TileEntityMatterCondenser mc = (TileEntityMatterCondenser) world.getTileEntity(x, y, z);

		super.onBlockAdded(world, x, y, z);
		mc.damage = mc.maxDamage;
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX,
			float hitY, float hitZ) {

		player.openGui(mod_IDT.instance, mod_IDT.MatterCondenserGUI, world, x, y, z);
		return true;
	}

	public TileEntity createNewTileEntity(World world, int id) {
		return new TileEntityMatterCondenser();
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

		if (stack.hasDisplayName()) {
			((TileEntityMatterCondenser) world.getTileEntity(x, y, z)).setGuiDisplayName(stack.getDisplayName());
		}
	}

	public static void updateState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
		int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

		TileEntity te = worldObj.getTileEntity(xCoord, yCoord, zCoord);
		keepInv = true;

		if (active) {
			// idfk
		} else {
			// idfk either
		}

		keepInv = false;
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

		if (te != null) {
			te.validate();
			worldObj.setTileEntity(xCoord, yCoord, zCoord, te);
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (!keepInv) {
			TileEntityMatterCondenser entity = (TileEntityMatterCondenser) world.getTileEntity(x, y, z);

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
	public boolean hasComparatorInputOverride() {
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
