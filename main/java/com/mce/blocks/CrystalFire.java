package com.mce.blocks;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.UP;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.IdentityHashMap;
import java.util.Map.Entry;
import java.util.Random;

import com.google.common.collect.Maps;
import com.mce.blocks.portals.CrystalPortal;
import com.mce.common.mod_IDT;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class CrystalFire extends BlockFire {
	@Deprecated
	private int[] field_149849_a = new int[4096];
	@Deprecated
	private int[] field_149848_b = new int[4096];
	@SideOnly(Side.CLIENT)
	private IIcon[] field_149850_M;

	public CrystalFire(String name) {
		super();
		this.setTickRandomly(true);
		this.setBlockName(name);
		this.setLightLevel(1.0F);
	}

	/*
	 * public static void setFire() {
	 * mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.planks), 5, 20);
	 * mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.double_wooden_slab),
	 * 5, 20);
	 * mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.wooden_slab), 5,
	 * 20); mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.fence), 5, 20);
	 * mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.oak_stairs), 5, 20);
	 * mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.birch_stairs), 5,
	 * 20); mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.spruce_stairs),
	 * 5, 20);
	 * mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.jungle_stairs), 5,
	 * 20); mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.log), 5, 5);
	 * mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.log2), 5, 5);
	 * mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.leaves), 30, 60);
	 * mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.leaves2), 30, 60);
	 * mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.bookshelf), 30, 20);
	 * mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.tnt), 15, 100);
	 * mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.tallgrass), 60,
	 * 100); mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.double_plant),
	 * 60, 100);
	 * mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.yellow_flower), 60,
	 * 100); mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.red_flower),
	 * 60, 100); mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.wool), 30,
	 * 60); mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.vine), 15,
	 * 100); mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.coal_block),
	 * 5, 5); mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.hay_block),
	 * 60, 20); mod_IDT.FrozenFire.setFireInfo(getIdFromBlock(Blocks.carpet),
	 * 60, 20); }
	 */

	@Deprecated // Use setFireInfo
	public void setFireInfo(int id, int meta, int side) {
		this.setFireInfo((Block) Block.blockRegistry.getObjectById(id), meta, side);
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube() {
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType() {
		return 3;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random rand) {
		return 0;
	}

	/**
	 * How many world ticks before ticking
	 */
	public int tickRate(World world) {
		return 30;
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (world.getGameRules().getGameRuleBooleanValue("doFireTick")) {
			boolean flag = world.getBlock(x, y - 1, z).isFireSource(world, x, y - 1, z, UP);

			if (!this.canPlaceBlockAt(world, x, y, z)) {
				world.setBlockToAir(x, y, z);
			}

			if (!flag && world.isRaining()
					&& (world.canLightningStrikeAt(x, y, z) || world.canLightningStrikeAt(x - 1, y, z)
							|| world.canLightningStrikeAt(x + 1, y, z) || world.canLightningStrikeAt(x, y, z - 1)
							|| world.canLightningStrikeAt(x, y, z + 1))) {
				world.setBlockToAir(x, y, z);
			} else {
				int l = world.getBlockMetadata(x, y, z);

				if (l < 15) {
					world.setBlockMetadataWithNotify(x, y, z, l + rand.nextInt(3) / 2, 4);
				}

				world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world) + rand.nextInt(10));

				if (!flag && !this.canNeighborBurn(world, x, y, z)) {
					if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) || l > 3) {
						world.setBlockToAir(x, y, z);
					}
				} else if (!flag && !this.canCatchFire(world, x, y - 1, z, UP) && l == 15 && rand.nextInt(4) == 0) {
					world.setBlockToAir(x, y, z);
				} else {
					boolean flag1 = world.isBlockHighHumidity(x, y, z);
					byte b0 = 0;

					if (flag1) {
						b0 = -50;
					}

					this.tryCatchFire(world, x + 1, y, z, 300 + b0, rand, l, WEST);
					this.tryCatchFire(world, x - 1, y, z, 300 + b0, rand, l, EAST);
					this.tryCatchFire(world, x, y - 1, z, 250 + b0, rand, l, UP);
					this.tryCatchFire(world, x, y + 1, z, 250 + b0, rand, l, DOWN);
					this.tryCatchFire(world, x, y, z - 1, 300 + b0, rand, l, SOUTH);
					this.tryCatchFire(world, x, y, z + 1, 300 + b0, rand, l, NORTH);

					for (int i1 = x - 1; i1 <= x + 1; ++i1) {
						for (int j1 = z - 1; j1 <= z + 1; ++j1) {
							for (int k1 = y - 1; k1 <= y + 4; ++k1) {
								if (i1 != x || k1 != y || j1 != z) {
									int l1 = 100;

									if (k1 > y + 1) {
										l1 += (k1 - (y + 1)) * 100;
									}

									int i2 = this.getChanceOfNeighborsEncouragingFire(world, i1, k1, j1);

									if (i2 > 0) {
										int j2 = (i2 + 40 + world.difficultySetting.getDifficultyId() * 7) / (l + 30);

										if (flag1) {
											j2 /= 2;
										}

										if (j2 > 0 && rand.nextInt(l1) <= j2
												&& (!world.isRaining() || !world.canLightningStrikeAt(i1, k1, j1))
												&& !world.canLightningStrikeAt(i1 - 1, k1, z)
												&& !world.canLightningStrikeAt(i1 + 1, k1, j1)
												&& !world.canLightningStrikeAt(i1, k1, j1 - 1)
												&& !world.canLightningStrikeAt(i1, k1, j1 + 1)) {
											int k2 = l + rand.nextInt(5) / 4;

											if (k2 > 15) {
												k2 = 15;
											}

											world.setBlock(i1, k1, j1, this, k2, 3);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public boolean func_149698_L() {
		return false;
	}

	/**
	 * Tries to set block on fire. Deprecated in favour of side-sensitive
	 * version.
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private void tryCatchFire(World world, int x, int y, int z, int meta, Random rand, int side) {
		this.tryCatchFire(world, x, y, z, meta, rand, side, UP);
	}

	private void tryCatchFire(World world, int x, int y, int z, int meta, Random rand, int side, ForgeDirection face) {
		int j1 = world.getBlock(x, y, z).getFlammability(world, x, y, z, face);

		if (rand.nextInt(meta) < j1) {
			boolean flag = world.getBlock(x, y, z) == Blocks.tnt;

			if (rand.nextInt(side + 10) < 5 && !world.canLightningStrikeAt(x, y, z)) {
				int k1 = side + rand.nextInt(5) / 4;

				if (k1 > 15) {
					k1 = 15;
				}

				world.setBlock(x, y, z, this, k1, 3);
			} else {
				world.setBlockToAir(x, y, z);
			}

			if (flag) {
				Blocks.tnt.onBlockDestroyedByPlayer(world, x, y, z, 1);
			}
		}
	}

	/**
	 * Returns true if at least one block next to this one can burn.
	 */
	private boolean canNeighborBurn(World world, int x, int y, int z) {
		return this.canCatchFire(world, x + 1, y, z, WEST) || this.canCatchFire(world, x - 1, y, z, EAST)
				|| this.canCatchFire(world, x, y - 1, z, UP) || this.canCatchFire(world, x, y + 1, z, DOWN)
				|| this.canCatchFire(world, x, y, z - 1, SOUTH) || this.canCatchFire(world, x, y, z + 1, NORTH);
	}

	/**
	 * Gets the highest chance of a neighbor block encouraging this block to
	 * catch fire
	 */
	private int getChanceOfNeighborsEncouragingFire(World world, int x, int y, int z) {
		byte b0 = 0;

		if (!world.isAirBlock(x, y, z)) {
			return 0;
		} else {
			int l = b0;
			l = this.getChanceToEncourageFire(world, x + 1, y, z, l, WEST);
			l = this.getChanceToEncourageFire(world, x - 1, y, z, l, EAST);
			l = this.getChanceToEncourageFire(world, x, y - 1, z, l, UP);
			l = this.getChanceToEncourageFire(world, x, y + 1, z, l, DOWN);
			l = this.getChanceToEncourageFire(world, x, y, z - 1, l, SOUTH);
			l = this.getChanceToEncourageFire(world, x, y, z + 1, l, NORTH);
			return l;
		}
	}

	/**
	 * Returns if this block is collidable (only used by Fire). Args: x, y, z
	 */
	public boolean isCollidable() {
		return false;
	}

	/**
	 * Checks the specified block coordinate to see if it can catch fire. Args:
	 * blockAccess, x, y, z
	 */
	@Deprecated
	public boolean canBlockCatchFire(IBlockAccess acc, int x, int y, int z) {
		return canCatchFire(acc, x, y, z, UP);
	}

	@Deprecated
	public int func_149846_a(World world, int x, int y, int z, int side) {
		return getChanceToEncourageFire(world, x, y, z, side, UP);
	}

	/**
	 * Checks to see if its valid to put this block at the specified
	 * coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) || this.canNeighborBurn(world, x, y, z);
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor Block
	 */
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) {
			world.setBlockToAir(x, y, z);
		}
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World world, int x, int y, int z) {
		if (world.provider.dimensionId > 0 || !((CrystalPortal) mod_IDT.CrystalPortal).getPortalSize(world, x, y, z)) {
			if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) && !this.canNeighborBurn(world, x, y, z)) {
				world.setBlockToAir(x, y, z);
			} else {
				if (world.provider.dimensionId != 0) {
					world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world) + world.rand.nextInt(10));
				}
				world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world) + world.rand.nextInt(10));
			}
		}
	}

	/**
	 * A randomly called display update to be able to add particles or other
	 * items for display
	 */
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		if (rand.nextInt(24) == 0) {
			world.playSound((double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F),
					"fire.fire", 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
		}

		int l;
		float f;
		float f1;
		float f2;

		if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z)
				&& !mod_IDT.CrystalFire.canCatchFire(world, x, y - 1, z, UP)) {
			if (mod_IDT.CrystalFire.canCatchFire(world, x - 1, y, z, EAST)) {
				for (l = 0; l < 2; ++l) {
					f = (float) x + rand.nextFloat() * 0.1F;
					f1 = (float) y + rand.nextFloat();
					f2 = (float) z + rand.nextFloat();
					world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
				}
			}

			if (mod_IDT.CrystalFire.canCatchFire(world, x + 1, y, z, WEST)) {
				for (l = 0; l < 2; ++l) {
					f = (float) (x + 1) - rand.nextFloat() * 0.1F;
					f1 = (float) y + rand.nextFloat();
					f2 = (float) z + rand.nextFloat();
					world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
				}
			}

			if (mod_IDT.CrystalFire.canCatchFire(world, x, y, z - 1, SOUTH)) {
				for (l = 0; l < 2; ++l) {
					f = (float) x + rand.nextFloat();
					f1 = (float) y + rand.nextFloat();
					f2 = (float) z + rand.nextFloat() * 0.1F;
					world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
				}
			}

			if (mod_IDT.CrystalFire.canCatchFire(world, x, y, z + 1, NORTH)) {
				for (l = 0; l < 2; ++l) {
					f = (float) x + rand.nextFloat();
					f1 = (float) y + rand.nextFloat();
					f2 = (float) (z + 1) - rand.nextFloat() * 0.1F;
					world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
				}
			}

			if (mod_IDT.CrystalFire.canCatchFire(world, x, y + 1, z, DOWN)) {
				for (l = 0; l < 2; ++l) {
					f = (float) x + rand.nextFloat();
					f1 = (float) (y + 1) - rand.nextFloat() * 0.1F;
					f2 = (float) z + rand.nextFloat();
					world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
				}
			}
		} else {
			for (l = 0; l < 3; ++l) {
				f = (float) x + rand.nextFloat();
				f1 = (float) y + rand.nextFloat() * 0.5F + 0.5F;
				f2 = (float) z + rand.nextFloat();
				world.spawnParticle("largesmoke", (double) f, (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.field_149850_M = new IIcon[] { icon.registerIcon("mod_IDT:crystal_fire_layer_0"),
				icon.registerIcon("mod_IDT:crystal_fire_layer_0") };
	}

	@SideOnly(Side.CLIENT)
	public IIcon getFireIcon(int i) {
		return this.field_149850_M[i];
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return this.field_149850_M[0];
	}

	public MapColor getMapColor(int color) {
		return MapColor.tntColor;
	}

	/*
	 * ================================= Forge Start
	 * ======================================
	 */
	private static class FireInfo {
		private int encouragement = 0;
		private int flammibility = 0;
	}

	private IdentityHashMap<Block, FireInfo> blockInfo = Maps.newIdentityHashMap();

	public void setFireInfo(Block block, int encouragement, int flammibility) {
		if (block == Blocks.air)
			throw new IllegalArgumentException("Tried to set air on fire... This is bad.");
		int id = Block.getIdFromBlock(block);
		this.field_149849_a[id] = encouragement;
		this.field_149848_b[id] = flammibility;

		FireInfo info = getInfo(block, true);
		info.encouragement = encouragement;
		info.flammibility = flammibility;
	}

	private FireInfo getInfo(Block block, boolean garentee) {
		FireInfo ret = blockInfo.get(block);
		if (ret == null && garentee) {
			ret = new FireInfo();
			blockInfo.put(block, ret);
		}
		return ret;
	}

	public void rebuildFireInfo() {
		for (int x = 0; x < 4096; x++) {
			// If we care.. we could detect changes in here and make sure we
			// keep them, however
			// it's my thinking that anyone who hacks into the private variables
			// should DIAF and we don't care about them.
			field_149849_a[x] = 0;
			field_149848_b[x] = 0;
		}

		for (Entry<Block, FireInfo> e : blockInfo.entrySet()) {
			int id = Block.getIdFromBlock(e.getKey());
			if (id >= 0 && id < 4096) {
				field_149849_a[id] = e.getValue().encouragement;
				field_149848_b[id] = e.getValue().flammibility;
			}
		}
	}

	public int getFlammability(Block block) {
		int id = Block.getIdFromBlock(block);
		return id >= 0 && id < 4096 ? field_149848_b[id] : 0;
	}

	public int getEncouragement(Block block) {
		int id = Block.getIdFromBlock(block);
		return id >= 0 && id < 4096 ? field_149849_a[id] : 0;
	}

	/**
	 * Side sensitive version that calls the block function.
	 * 
	 * @param world
	 *            The current world
	 * @param x
	 *            X Position
	 * @param y
	 *            Y Position
	 * @param z
	 *            Z Position
	 * @param face
	 *            The side the fire is coming from
	 * @return True if the face can catch fire.
	 */
	public boolean canCatchFire(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
		return world.getBlock(x, y, z).isFlammable(world, x, y, z, face);
	}

	/**
	 * Side sensitive version that calls the block function.
	 * 
	 * @param world
	 *            The current world
	 * @param x
	 *            X Position
	 * @param y
	 *            Y Position
	 * @param z
	 *            Z Position
	 * @param oldChance
	 *            The previous maximum chance.
	 * @param face
	 *            The side the fire is coming from
	 * @return The chance of the block catching fire, or oldChance if it is
	 *         higher
	 */
	public int getChanceToEncourageFire(IBlockAccess world, int x, int y, int z, int oldChance, ForgeDirection face) {
		int newChance = world.getBlock(x, y, z).getFireSpreadSpeed(world, x, y, z, face);
		return (newChance > oldChance ? newChance : oldChance);
	}
}