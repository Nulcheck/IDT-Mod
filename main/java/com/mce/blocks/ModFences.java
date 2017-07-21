package com.mce.blocks;

import static net.minecraftforge.common.util.ForgeDirection.UP;

import java.util.List;

import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModFences extends BlockFence {
	public ModFences(String block, Material mat) {
		super(block, mat);
	}

	public static class BirchFence extends BlockFence {
		public BirchFence(String block, Material mat) {
			super(block, mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectFenceTo(IBlockAccess blockacc, int x, int y, int z) {
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
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.SilkwoodFence && l != mod_IDT.SilkwoodFenceGate
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.AcaciaWall
					&& l != mod_IDT.DarkOakFence && l != mod_IDT.DarkOakFenceGate && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidWall) {
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
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.SilkwoodFence
						|| this == mod_IDT.AcaciaFence || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.GelidFence || this == mod_IDT.GelidWall;
			}
		}
	}

	public static class SpruceFence extends BlockFence {
		public SpruceFence(String block, Material mat) {
			super(block, mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectFenceTo(IBlockAccess blockacc, int x, int y, int z) {
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
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.SilkwoodFence && l != mod_IDT.SilkwoodFenceGate
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.AcaciaWall
					&& l != mod_IDT.DarkOakFence && l != mod_IDT.DarkOakFenceGate && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidWall) {
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
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.SilkwoodFence
						|| this == mod_IDT.AcaciaFence || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.GelidFence || this == mod_IDT.GelidWall;
			}
		}
	}

	public static class JungleFence extends BlockFence {
		public JungleFence(String block, Material mat) {
			super(block, mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectFenceTo(IBlockAccess blockacc, int x, int y, int z) {
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
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.SilkwoodFence && l != mod_IDT.SilkwoodFenceGate
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.AcaciaWall
					&& l != mod_IDT.DarkOakFence && l != mod_IDT.DarkOakFenceGate && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidWall) {
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
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.SilkwoodFence
						|| this == mod_IDT.AcaciaFence || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.GelidFence || this == mod_IDT.GelidWall;
			}
		}
	}

	public static class WillowFence extends BlockFence {
		public WillowFence(String block, Material mat) {
			super(block, mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectFenceTo(IBlockAccess blockacc, int x, int y, int z) {
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
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.SilkwoodFence && l != mod_IDT.SilkwoodFenceGate
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.AcaciaWall
					&& l != mod_IDT.DarkOakFence && l != mod_IDT.DarkOakFenceGate && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidWall) {
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
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.SilkwoodFence
						|| this == mod_IDT.AcaciaFence || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.GelidFence || this == mod_IDT.GelidWall;
			}
		}
	}

	public static class EbonyFence extends BlockFence {
		public EbonyFence(String block, Material mat) {
			super(block, mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectFenceTo(IBlockAccess blockacc, int x, int y, int z) {
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
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.SilkwoodFence && l != mod_IDT.SilkwoodFenceGate
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.AcaciaWall
					&& l != mod_IDT.DarkOakFence && l != mod_IDT.DarkOakFenceGate && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidWall) {
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
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.SilkwoodFence
						|| this == mod_IDT.AcaciaFence || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.GelidFence || this == mod_IDT.GelidWall;
			}
		}
	}

	public static class SilkwoodFence extends BlockFence {
		public SilkwoodFence(String block, Material mat) {
			super(block, mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectFenceTo(IBlockAccess blockacc, int x, int y, int z) {
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
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.SilkwoodFence && l != mod_IDT.SilkwoodFenceGate
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.AcaciaWall
					&& l != mod_IDT.DarkOakFence && l != mod_IDT.DarkOakFenceGate && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidWall) {
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
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.SilkwoodFence
						|| this == mod_IDT.AcaciaFence || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.GelidFence || this == mod_IDT.GelidWall;
			}
		}
	}

	public static class AcaciaFence extends BlockFence {
		public AcaciaFence(String block, Material mat) {
			super(block, mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectFenceTo(IBlockAccess blockacc, int x, int y, int z) {
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
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.SilkwoodFence && l != mod_IDT.SilkwoodFenceGate
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.AcaciaWall
					&& l != mod_IDT.DarkOakFence && l != mod_IDT.DarkOakFenceGate && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidWall) {
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
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.SilkwoodFence
						|| this == mod_IDT.AcaciaFence || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.GelidFence || this == mod_IDT.GelidWall;
			}
		}
	}

	public static class DarkOakFence extends BlockFence {
		public DarkOakFence(String block, Material mat) {
			super(block, mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectFenceTo(IBlockAccess blockacc, int x, int y, int z) {
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
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.SilkwoodFence && l != mod_IDT.SilkwoodFenceGate
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.AcaciaWall
					&& l != mod_IDT.DarkOakFence && l != mod_IDT.DarkOakFenceGate && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidWall) {
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
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.SilkwoodFence
						|| this == mod_IDT.AcaciaFence || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.GelidFence || this == mod_IDT.GelidWall;
			}
		}
	}

	public static class GelidFence extends BlockFence {
		public GelidFence(String block, Material mat) {
			super(block, mat);
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		// Connections
		public boolean canConnectFenceTo(IBlockAccess blockacc, int x, int y, int z) {
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
					&& l != mod_IDT.SilkwoodWall && l != mod_IDT.SilkwoodFence && l != mod_IDT.SilkwoodFenceGate
					&& l != mod_IDT.AcaciaFence && l != mod_IDT.AcaciaFenceGate && l != mod_IDT.AcaciaWall
					&& l != mod_IDT.DarkOakFence && l != mod_IDT.DarkOakFenceGate && l != mod_IDT.DarkOakWall
					&& l != mod_IDT.GelidFence && l != mod_IDT.GelidFenceGate && l != mod_IDT.GelidWall) {
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
						|| this == mod_IDT.EbonyWall || this == mod_IDT.SilkwoodWall || this == mod_IDT.SilkwoodFence
						|| this == mod_IDT.AcaciaFence || this == mod_IDT.DarkOakFence || this == mod_IDT.AcaciaWall
						|| this == mod_IDT.DarkOakWall || this == mod_IDT.GelidFence || this == mod_IDT.GelidWall;
			}
		}
	}
}
