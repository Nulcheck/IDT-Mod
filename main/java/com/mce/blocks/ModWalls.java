package com.mce.blocks;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.List;

import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ModWalls extends BlockWall {
	public ModWalls(Block block) {
		super(block);
	}

	public static class BrickWall extends BlockWall {

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.brick_block.getBlockTextureFromSide(side);
		}

		public BrickWall(Block block) {
			super(block);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidFence
					&& l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class CementWall extends BlockWall {

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return mod_IDT.Cement.getBlockTextureFromSide(side);
		}

		public CementWall(Block block) {
			super(block);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidFence
					&& l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class CementBrickWall extends BlockWall {

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return mod_IDT.CementBricks.getBlockTextureFromSide(side);
		}

		public CementBrickWall(Block block) {
			super(block);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidFence
					&& l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class CoalWall extends BlockWall {

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.coal_block.getBlockTextureFromSide(side);
		}

		public CoalWall(Block block) {
			super(block);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class NetherBrickWall extends BlockWall {

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.nether_brick.getBlockTextureFromSide(side);
		}

		public NetherBrickWall(Block block) {
			super(block);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}

	}

	public static class ObsidianWall extends BlockWall {

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.obsidian.getBlockTextureFromSide(side);
		}

		public ObsidianWall(Block block) {
			super(block);
			this.setHarvestLevel("pickaxe", 3);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class QuartzWall extends BlockWall {

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.quartz_block.getBlockTextureFromSide(side);
		}

		public QuartzWall(Block block) {
			super(block);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class SandStoneWall extends BlockWall {

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.sandstone.getBlockTextureFromSide(side);
		}

		public SandStoneWall(Block block) {
			super(block);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class SnowWall extends BlockWall {

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.snow.getBlockTextureFromSide(side);
		}

		public SnowWall(Block block) {
			super(block);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class StoneBrickWall extends BlockWall {

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.stonebrick.getBlockTextureFromSide(side);
		}

		public StoneBrickWall(Block block) {
			super(block);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			}

			else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class StoneWall extends BlockWall {

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.stone.getBlockTextureFromSide(side);
		}

		public StoneWall(Block block) {
			super(block);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class OakWall extends BlockWall {
		public OakWall(Block block) {
			super(block);
		}

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.planks.getIcon(side, 0);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
			return true;
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class BirchWall extends BlockWall {
		public BirchWall(Block block) {
			super(block);
		}

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.planks.getIcon(side, 2);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
			return true;
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class SpruceWall extends BlockWall {
		public SpruceWall(Block block) {
			super(block);
		}

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.planks.getIcon(side, 1);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
			return true;
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class JungleWall extends BlockWall {
		public JungleWall(Block block) {
			super(block);
		}

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.planks.getIcon(side, 3);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
			return true;
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class WillowWall extends BlockWall {
		public WillowWall(Block block) {
			super(block);
		}

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return mod_IDT.WillowPlanks.getIcon(side, 0);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
			return true;
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class EbonyWall extends BlockWall {
		public EbonyWall(Block block) {
			super(block);
		}

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return mod_IDT.EbonyPlanks.getIcon(side, 0);
		}

		public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
			return true;
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class SilkwoodWall extends BlockWall {
		public SilkwoodWall(Block block) {
			super(block);
		}

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return mod_IDT.SilkwoodPlanks.getIcon(side, 0);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
			return true;
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class AcaciaWall extends BlockWall {
		public AcaciaWall(Block block) {
			super(block);
		}

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.planks.getIcon(side, 4);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
			return true;
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class DarkOakWall extends BlockWall {
		public DarkOakWall(Block block) {
			super(block);
		}

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return Blocks.planks.getIcon(side, 5);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
			return true;
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}

	public static class GelidWall extends BlockWall {
		public GelidWall(Block block) {
			super(block);
		}

		// Texturing stuff
		public IIcon getIcon(int side, int meta) {
			return mod_IDT.GelidPlanks.getIcon(side, 0);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
			return true;
		}

		// Connections
		public boolean canConnectWallTo(IBlockAccess blockacc, int x, int y, int z) {
			Block l = blockacc.getBlock(x, y, z);

			if (l != Blocks.fence_gate && l != mod_IDT.SandStoneWall && l != mod_IDT.ObsidianWall
					&& l != mod_IDT.BirchFenceGate && l != mod_IDT.SpruceFenceGate && l != mod_IDT.JungleFenceGate
					&& l != mod_IDT.WillowFenceGate && l != mod_IDT.EbonyFenceGate && l != mod_IDT.CementWall
					&& l != mod_IDT.SnowWall && l != mod_IDT.NetherBrickWall && l != mod_IDT.StoneBrickWall
					&& l != mod_IDT.StoneWall && l != mod_IDT.QuartzWall && l != mod_IDT.CoalWall
					&& l != mod_IDT.BrickWall && l != mod_IDT.BirchFence && l != mod_IDT.SpruceFence
					&& l != mod_IDT.JungleFence && l != mod_IDT.WillowFence && l != mod_IDT.EbonyFence
					&& l != mod_IDT.OakWall && l != mod_IDT.BirchWall && l != mod_IDT.SpruceWall
					&& l != mod_IDT.JungleWall && l != mod_IDT.WillowWall && l != mod_IDT.EbonyWall
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.AcaciaWall && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.DarkOakFence
					&& l != mod_IDT.DarkOakFenceGate && l != mod_IDT.CementBrickWall && l != mod_IDT.GelidWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate) {
				Block block = blockacc.getBlock(x, y, z);
				return block != null && block.getMaterial().isOpaque() && block.renderAsNormalBlock()
						? block.getMaterial() != Material.ground : false;
			} else {
				return true;
			}
		}

		public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
			if (isSideSolid(world, x, y, z, UP)) {
				return true;
			} else {
				return this == Blocks.fence || this == Blocks.nether_brick_fence || this == Blocks.glass
						|| this == Blocks.cobblestone_wall || this == mod_IDT.BirchFence || this == mod_IDT.SpruceFence
						|| this == mod_IDT.JungleFence || this == mod_IDT.WillowFence || this == mod_IDT.EbonyFence
						|| this == mod_IDT.BrickWall || this == mod_IDT.CementWall || this == mod_IDT.CoalWall
						|| this == mod_IDT.NetherBrickWall || this == mod_IDT.ObsidianWall || this == mod_IDT.QuartzWall
						|| this == mod_IDT.SandStoneWall || this == mod_IDT.SnowWall || this == mod_IDT.StoneBrickWall
						|| this == mod_IDT.StoneWall || this == mod_IDT.OakWall || this == mod_IDT.BirchWall
						|| this == mod_IDT.SpruceWall || this == mod_IDT.JungleWall || this == mod_IDT.WillowWall
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaFence
						|| this == mod_IDT.CementBrickWall || this == mod_IDT.GelidWall || this == mod_IDT.GelidFence;
			}
		}
	}
}
