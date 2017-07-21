package com.mce.blocks;

import java.util.List;
import java.util.Random;

import com.mce.common.mod_IDT;
import com.mce.util.ModFoliageColor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModLeaves extends BlockLeaves {
	public ModLeaves() {
		super();
	}

	public IIcon getIcon(int side, int meta) {
		return null;
	}

	public String[] func_150125_e() {
		return null;
	}

	public static class WillowLeaves extends BlockLeaves {
		public static final String[][] leafType = new String[][] { { "mod_IDT:leaves_willow" },
				{ "mod_IDT:leaves_willow_opaque" } };
		public static final String[] logType = new String[] { "willow" };
		private static final String __OBFID = "CL_00000280";

		/**
		 * Returns the color this block should be rendered. Used by leaves.
		 */
		@SideOnly(Side.CLIENT)
		public int getRenderColor(int color) {
			return ColorizerFoliage.getFoliageColorBasic();
		}

		/**
		 * Returns a integer with hex for 0xrrggbb with this color multiplied
		 * against the blocks color. Note only called when first determining
		 * what to render.
		 */
		@SideOnly(Side.CLIENT)
		public int colorMultiplier(IBlockAccess blockAcc, int x, int y, int z) {
			return ColorizerFoliage.getFoliageColorBasic();
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			return Item.getItemFromBlock(mod_IDT.WillowSapling);
		}

		public void func_150124_c(World world, int x, int y, int z, int item, int meta) {
			if ((item & 3) == 0 && world.rand.nextInt(meta) == 0) {
				this.dropBlockAsItem(world, x, y, z, new ItemStack(Items.apple, 1, 0));
			}
		}

		protected int func_150123_b(int side) {
			int j = super.func_150123_b(side);

			if ((side & 3) == 3) {
				j = 40;
			}

			return j;
		}

		/**
		 * Gets the block's texture. Args: side, meta
		 */
		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1]
					: ((meta & 3) == 3 ? this.field_150129_M[this.field_150127_b][3]
							: ((meta & 3) == 2 ? this.field_150129_M[this.field_150127_b][2]
									: this.field_150129_M[this.field_150127_b][0]));
		}

		/**
		 * returns a list of blocks with the same ID, but different meta (eg:
		 * wood returns 4 blocks)
		 */
		@SideOnly(Side.CLIENT)
		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public int getRenderBlockPass() {
			return 1;
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
			return null;
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister reg) {
			for (int i = 0; i < leafType.length; ++i) {
				this.field_150129_M[i] = new IIcon[leafType[i].length];

				for (int j = 0; j < leafType[i].length; ++j) {
					this.field_150129_M[i][j] = reg.registerIcon(leafType[i][j]);
				}
			}
		}

		public String[] func_150125_e() {
			return logType;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}
	}

	public static class EbonyLeaves extends BlockLeaves {
		public static final String[][] leafType = new String[][] { { "leaves_oak" }, { "leaves_oak_opaque" } };
		public static final String[] logType = new String[] { "ebony" };
		private static final String __OBFID = "CL_00000280";

		/**
		 * Returns the color this block should be rendered. Used by leaves.
		 */
		@SideOnly(Side.CLIENT)
		public int getRenderColor(int color) {
			return ColorizerFoliage.getFoliageColorBasic();
		}

		/**
		 * Returns a integer with hex for 0xrrggbb with this color multiplied
		 * against the blocks color. Note only called when first determining
		 * what to render.
		 */
		@SideOnly(Side.CLIENT)
		public int colorMultiplier(IBlockAccess blockAcc, int x, int y, int z) {
			return ColorizerFoliage.getFoliageColorBasic();
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			return Item.getItemFromBlock(mod_IDT.EbonySapling);
		}

		public void func_150124_c(World world, int x, int y, int z, int item, int meta) {
			if ((item & 3) == 0 && world.rand.nextInt(meta) == 0) {
				this.dropBlockAsItem(world, x, y, z, new ItemStack(Items.apple, 1, 0));
			}
		}

		protected int func_150123_b(int side) {
			int j = super.func_150123_b(side);

			if ((side & 3) == 3) {
				j = 40;
			}

			return j;
		}

		/**
		 * Gets the block's texture. Args: side, meta
		 */
		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1]
					: ((meta & 3) == 3 ? this.field_150129_M[this.field_150127_b][3]
							: ((meta & 3) == 2 ? this.field_150129_M[this.field_150127_b][2]
									: this.field_150129_M[this.field_150127_b][0]));
		}

		/**
		 * returns a list of blocks with the same ID, but different meta (eg:
		 * wood returns 4 blocks)
		 */
		@SideOnly(Side.CLIENT)
		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public int getRenderBlockPass() {
			return 1;
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
			return null;
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister reg) {
			for (int i = 0; i < leafType.length; ++i) {
				this.field_150129_M[i] = new IIcon[leafType[i].length];

				for (int j = 0; j < leafType[i].length; ++j) {
					this.field_150129_M[i][j] = reg.registerIcon(leafType[i][j]);
				}
			}
		}

		public String[] func_150125_e() {
			return logType;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}
	}

	public static class SilkwoodLeaves extends BlockLeaves {
		public static final String[][] leafType = new String[][] { { "mod_IDT:leaves_silkwood" },
				{ "mod_IDT:leaves_silkwood_opaque" } };
		public static final String[] logType = new String[] { "silkwood" };
		private static final String __OBFID = "CL_00000280";

		/**
		 * Returns the color this block should be rendered. Used by leaves.
		 */
		@SideOnly(Side.CLIENT)
		public int getRenderColor(int color) {
			return ModFoliageColor.getFoliageColorSilkwood();
		}

		/**
		 * Returns a integer with hex for 0xrrggbb with this color multiplied
		 * against the blocks color. Note only called when first determining
		 * what to render.
		 */
		@SideOnly(Side.CLIENT)
		public int colorMultiplier(IBlockAccess blockAcc, int x, int y, int z) {
			return ModFoliageColor.getFoliageColorSilkwood();
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			return Item.getItemFromBlock(mod_IDT.SilkwoodSapling);
		}

		public void func_150124_c(World world, int x, int y, int z, int item, int meta) {
			if ((item & 3) == 0 && world.rand.nextInt(meta) == 0) {
				this.dropBlockAsItem(world, x, y, z, new ItemStack(Items.apple, 1, 0));
			}
		}

		protected int func_150123_b(int side) {
			int j = super.func_150123_b(side);

			if ((side & 3) == 3) {
				j = 40;
			}

			return j;
		}

		/**
		 * Gets the block's texture. Args: side, meta
		 */
		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1]
					: ((meta & 3) == 3 ? this.field_150129_M[this.field_150127_b][3]
							: ((meta & 3) == 2 ? this.field_150129_M[this.field_150127_b][2]
									: this.field_150129_M[this.field_150127_b][0]));
		}

		/**
		 * returns a list of blocks with the same ID, but different meta (eg:
		 * wood returns 4 blocks)
		 */
		@SideOnly(Side.CLIENT)
		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public int getRenderBlockPass() {
			return 1;
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
			return null;
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister reg) {
			for (int i = 0; i < leafType.length; ++i) {
				this.field_150129_M[i] = new IIcon[leafType[i].length];

				for (int j = 0; j < leafType[i].length; ++j) {
					this.field_150129_M[i][j] = reg.registerIcon(leafType[i][j]);
				}
			}
		}

		public String[] func_150125_e() {
			return logType;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}
	}

	public static class GelidLeaves extends BlockLeaves {
		public static final String[][] leafType = new String[][] { { "mod_IDT:leaves_gelid" },
				{ "mod_IDT:leaves_gelid_opaque" } };
		public static final String[] logType = new String[] { "gelid" };
		private static final String __OBFID = "CL_00000280";

		/**
		 * Returns the color this block should be rendered. Used by leaves.
		 */
		@SideOnly(Side.CLIENT)
		public int getRenderColor(int color) {
			return ModFoliageColor.getFoliageColorSilkwood();
		}

		/**
		 * Returns a integer with hex for 0xrrggbb with this color multiplied
		 * against the blocks color. Note only called when first determining
		 * what to render.
		 */
		@SideOnly(Side.CLIENT)
		public int colorMultiplier(IBlockAccess blockAcc, int x, int y, int z) {
			return ModFoliageColor.getFoliageColorSilkwood();
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			return Item.getItemFromBlock(mod_IDT.GelidSapling);
		}

		public void func_150124_c(World world, int x, int y, int z, int item, int meta) {
			if ((item & 3) == 0 && world.rand.nextInt(meta) == 0) {
				this.dropBlockAsItem(world, x, y, z, new ItemStack(Items.apple, 1, 0));
			}
		}

		protected int func_150123_b(int side) {
			int j = super.func_150123_b(side);

			if ((side & 3) == 3) {
				j = 40;
			}

			return j;
		}

		/**
		 * Gets the block's texture. Args: side, meta
		 */
		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			return (meta & 3) == 1 ? this.field_150129_M[this.field_150127_b][1]
					: ((meta & 3) == 3 ? this.field_150129_M[this.field_150127_b][3]
							: ((meta & 3) == 2 ? this.field_150129_M[this.field_150127_b][2]
									: this.field_150129_M[this.field_150127_b][0]));
		}

		/**
		 * returns a list of blocks with the same ID, but different meta (eg:
		 * wood returns 4 blocks)
		 */
		@SideOnly(Side.CLIENT)
		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public int getRenderBlockPass() {
			return 1;
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
			return null;
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister reg) {
			for (int i = 0; i < leafType.length; ++i) {
				this.field_150129_M[i] = new IIcon[leafType[i].length];

				for (int j = 0; j < leafType[i].length; ++j) {
					this.field_150129_M[i][j] = reg.registerIcon(leafType[i][j]);
				}
			}
		}

		public String[] func_150125_e() {
			return logType;
		}

		public boolean shouldSideBeRendered(IBlockAccess blockAcc, int x, int y, int z, int side) {
			return true;
		}
	}
}
