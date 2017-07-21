package com.mce.blocks.saplings;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.mce.common.mod_IDT;
import com.mce.gen.trees.WorldGenSilkwoodTree;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SilkwoodSapling extends BlockSapling implements IGrowable {
	private IIcon[] textures;
	public static final String[] SAPLINGNAMES = new String[] { "silkwood" };
	private static final IIcon[] SAPLINGICONS = new IIcon[SAPLINGNAMES.length];
	private static final int TYPES = 1;

	private static WorldGenerator tree;
	private static WorldGenerator tree1;

	public SilkwoodSapling() {
		tree = new WorldGenSilkwoodTree(true);
		tree1 = new WorldGenSilkwoodTree(true, 5, 0, 0, false);
		this.setHardness(0.0F);
		this.setStepSound(Block.soundTypeGrass);
		this.setCreativeTab(mod_IDT.IDT);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		textures = new IIcon[SAPLINGNAMES.length];
		for (int i = 0; i < SAPLINGNAMES.length; ++i) {
			textures[i] = iconRegister.registerIcon("mod_IDT:sapling_"
					+ SAPLINGNAMES[i]);
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if (meta < 0 || meta >= SAPLINGNAMES.length) {
			meta = 0;
		}
		return textures[meta];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < SAPLINGNAMES.length; ++i) {
			list.add(new ItemStack(block, 1, i));
		}
	}

	/**
	 * Is this position a valid spawn position. <br>
	 * Test block below placed sapling to see if it can sustain a plant?
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param metadata
	 * @return boolean
	 */
	public boolean isValidPosition(World world, int x, int y, int z,
			int metadata) {
		Block block = world.getBlock(x, y - 1, z);
		switch (metadata) {
		default:
			return block == Blocks.grass
					|| block == Blocks.dirt
					|| block.canSustainPlant(world, x, y - 1, z,
							ForgeDirection.UP, this);
		}
	}

	public boolean canPlaceBlockOnSide(World world, int x, int y, int z,
			int side) {
		return isValidPosition(world, x, y, z, -1);
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		Block soil = world.getBlock(x, y - 1, z);
		if (world.getBlockMetadata(x, y, z) != 7)
			return (world.getFullBlockLightValue(x, y, z) >= 8 || world
					.canBlockSeeTheSky(x, y, z))
					&& (soil != null && soil.canSustainPlant(world, x, y - 1,
							z, ForgeDirection.UP, this));
		else
			return (world.getFullBlockLightValue(x, y, z) >= 8 || world
					.canBlockSeeTheSky(x, y, z))
					&& (soil != null && soil.canSustainPlant(world, x, y - 1,
							z, ForgeDirection.UP, this));
	}

	public void updateTick(World world, int x, int y, int z, Random random) {
		if (world.isRemote) {
			return;
		}
		if (world.getBlockLightValue(x, y + 1, z) >= 9
				&& random.nextInt(7) == 0) {
			this.func_149878_d(world, x, y, z, random);
		}
	}

	public void func_149878_d(World world, int x, int y, int z, Random random) {
		int meta = world.getBlockMetadata(x, y, z) & TYPES;
		Object obj = null;
		int rnd = random.nextInt(10);
		if (obj == null) {
			if (rnd < 5) {
				obj = tree;
			}
			if (rnd >= 5) {
				obj = tree1;
			}
		}
		if (obj != null) {
			world.setBlockToAir(x, y, z);
			if (!((WorldGenerator) obj).generate(world, random, x, y, z)) {
				world.setBlock(x, y, z, this, meta, 2);
			}
		}
	}

	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z,
			ForgeDirection direction, IPlantable plantable) {
		if (world.getBlock(x, y, z) == Blocks.grass) {
			return true;
		} else if (world.getBlock(x, y, z) == Blocks.dirt) {
			return true;
		} else {
			return false;
		}
	}

	public void onPlantGrow(World world, int x, int y, int z, int sourceX,
			int sourceY, int sourceZ) {
		if (this == Blocks.dirt) {
			world.setBlock(x, y, z, Blocks.dirt, 0, 2);
		}
	}

	public void growTree(World world, Random rand, int y, int z, int x) {
	}
}