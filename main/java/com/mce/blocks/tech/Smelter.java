package com.mce.blocks.tech;

import java.util.Random;

import com.mce.common.mod_IDT;
import com.mce.entity.tile.tech.TileEntitySmelter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Smelter extends BlockContainer {
	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon side;
	private Random rand = new Random();
	byte b0 = 3;

	private static boolean keepInv;
	private final boolean isActive;

	public Smelter(Material mat, boolean isActive) {
		super(mat);
		this.isActive = isActive;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return meta == 0 && side == 3 ? this.side : (side == meta ? this.side : this.top);
		// return side == 1 ? this.top : (side == 0 ? this.top : (side !=
		// meta ? this.blockIcon : this.side));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon("mod_IDT:smelter_side");
		this.side = icon.registerIcon("mod_IDT:" + (this.isActive ? "smelter_front_active" : "smelter_front_idle"));
		this.top = icon.registerIcon("mod_IDT:smelter_top");
	}

	public Item getItemDropped(int i, Random rand, int j) {
		return Item.getItemFromBlock(mod_IDT.SmelterIdle);
	}

	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(mod_IDT.SmelterIdle);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		TileEntity tile = (TileEntitySmelter) world.getTileEntity(x, y, z);
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);

		if (tile instanceof TileEntitySmelter) {
			TileEntitySmelter smelter = (TileEntitySmelter) tile;
			smelter.setDamage(smelter.maxDamage);
		}
	}

	public void setDefaultDirection(World world, int x, int y, int z) {
		if (!world.isRemote) {
			Block block = world.getBlock(x, y, z - 1);
			Block block1 = world.getBlock(x, y, z + 1);
			Block block2 = world.getBlock(x - 1, y, z);
			Block block3 = world.getBlock(x + 1, y, z);

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

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX,
			float hitY, float hitZ) {
		if (!world.isRemote) {
			player.openGui(mod_IDT.instance, mod_IDT.SmelterGUI, world, x, y, z);
			return true;
		}
		return false;
	}

	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntitySmelter();
	}

	/*
	 * public int damageDropped(int damage) { return damage; }
	 */

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if (this.isActive) {
			int dir = world.getBlockMetadata(x, y, z);
			float x1 = (float) x + 0.5f;
			float y1 = (float) y + random.nextFloat();
			float z1 = (float) z + 0.5f;

			float f = .52f;
			float f1 = random.nextFloat() * .6f - .3f;

			if (dir == 4) {
				world.spawnParticle("smoke", (double) (x1 - f), (double) (y1), (double) (z1 + f1), 0d, 0d, 0d);
				world.spawnParticle("flame", (double) (x1 - f), (double) (y1), (double) (z1 + f1), 0d, 0d, 0d);
			}

			else if (dir == 5) {
				world.spawnParticle("smoke", (double) (x1 + f), (double) (y1), (double) (z1 + f1), 0d, 0d, 0d);
				world.spawnParticle("flame", (double) (x1 + f), (double) (y1), (double) (z1 + f1), 0d, 0d, 0d);
			}

			else if (dir == 2) {
				world.spawnParticle("smoke", (double) (x1 + f1), (double) (y1), (double) (z1 - f), 0d, 0d, 0d);
				world.spawnParticle("flame", (double) (x1 + f1), (double) (y1), (double) (z1 - f), 0d, 0d, 0d);
			}

			else if (dir == 3) {
				world.spawnParticle("smoke", (double) (x1 + f1), (double) (y1), (double) (z1 + f), 0d, 0d, 0d);
				world.spawnParticle("flame", (double) (x1 + f1), (double) (y1), (double) (z1 + f), 0d, 0d, 0d);
			}
		}
	}

	/*
	 * protected void processDrop(World world, int x, int y, int z,
	 * TileEntitySmelter te, ItemStack stack) {
	 * DamageHandlerUtil.setDamageForItem(stack, (te).getDamage()); }
	 */

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		int l = MathHelper.floor_double((double) (entity.rotationYaw * 4f / 360f) + .5D) & 3;

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
			((TileEntitySmelter) world.getTileEntity(x, y, z)).setGuiDisplayName(stack.getDisplayName());
		}

		world.markBlockForUpdate(x, y, z);
	}

	public static void updateState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
		int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

		TileEntity te = worldObj.getTileEntity(xCoord, yCoord, zCoord);
		keepInv = true;

		if (active) {
			worldObj.setBlock(xCoord, yCoord, zCoord, mod_IDT.SmelterActive);

		} else {
			worldObj.setBlock(xCoord, yCoord, zCoord, mod_IDT.SmelterIdle);
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
			TileEntitySmelter entity = (TileEntitySmelter) world.getTileEntity(x, y, z);

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

	public boolean hasComparatorInputOverride() {
		return true;
	}

	public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
		return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
	}
}
