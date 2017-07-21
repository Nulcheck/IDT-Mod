package com.mce.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockWood;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ModPlanks extends BlockWood {
	public ModPlanks() {
		super();
	}

	public static class WillowPlanks extends BlockWood {
		public static final String[] woodTypes = new String[] { "willow" };
		@SideOnly(Side.CLIENT)
		private IIcon[] iconTex;
		private static final String __OBFID = "CL_00000335";

		public WillowPlanks() {
			super();
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			if (meta < 0 || meta >= this.iconTex.length) {
				meta = 0;
			}

			return this.iconTex[meta];
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister icon) {
			this.iconTex = new IIcon[woodTypes.length];

			for (int i = 0; i < this.iconTex.length; ++i) {
				this.iconTex[i] = icon.registerIcon("mod_IDT:planks_willow");
			}
		}
	}

	public static class EbonyPlanks extends BlockWood {
		public static final String[] woodTypes = new String[] { "ebony" };
		@SideOnly(Side.CLIENT)
		private IIcon[] iconTex;
		private static final String __OBFID = "CL_00000335";

		public EbonyPlanks() {
			super();
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			if (meta < 0 || meta >= this.iconTex.length) {
				meta = 0;
			}

			return this.iconTex[meta];
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister icon) {
			this.iconTex = new IIcon[woodTypes.length];

			for (int i = 0; i < this.iconTex.length; ++i) {
				this.iconTex[i] = icon.registerIcon("mod_IDT:planks_ebony");
			}
		}
	}

	public static class SilkwoodPlanks extends BlockWood {
		public static final String[] woodTypes = new String[] { "silkwood" };
		@SideOnly(Side.CLIENT)
		private IIcon[] iconTex;
		private static final String __OBFID = "CL_00000335";

		public SilkwoodPlanks() {
			super();
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			if (meta < 0 || meta >= this.iconTex.length) {
				meta = 0;
			}

			return this.iconTex[meta];
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister icon) {
			this.iconTex = new IIcon[woodTypes.length];

			for (int i = 0; i < this.iconTex.length; ++i) {
				this.iconTex[i] = icon.registerIcon("mod_IDT:planks_silkwood");
			}
		}
	}

	public static class GelidPlanks extends BlockWood {
		public static final String[] woodTypes = new String[] { "gelid" };
		@SideOnly(Side.CLIENT)
		private IIcon[] iconTex;
		private static final String __OBFID = "CL_00000335";

		public GelidPlanks() {
			super();
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			if (meta < 0 || meta >= this.iconTex.length) {
				meta = 0;
			}

			return this.iconTex[meta];
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister icon) {
			this.iconTex = new IIcon[woodTypes.length];

			for (int i = 0; i < this.iconTex.length; ++i) {
				this.iconTex[i] = icon.registerIcon("mod_IDT:planks_gelid");
			}
		}
	}
}
