package com.mce.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class ModLogs extends BlockLog {
	public ModLogs() {
		super();
	}

	public static class WillowLog extends BlockLog {
		private static final String __OBFID = "CL_00000221";

		public String logType[] = { "willow" };

		public WillowLog() {
			super();
			this.setHardness(2.0F);
			this.setStepSound(soundTypeWood);
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister icon) {
			this.field_150167_a = new IIcon[logType.length];
			this.field_150166_b = new IIcon[logType.length];

			for (int i = 0; i < this.field_150167_a.length; ++i) {
				this.field_150167_a[i] = icon.registerIcon("mod_IDT:log_willow");
				this.field_150166_b[i] = icon.registerIcon("mod_IDT:log_willow_top");
			}
		}

		public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
			return true;
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isWood(IBlockAccess world, int x, int y, int z) {
			return true;
		}
	}

	public static class EbonyLog extends BlockLog {
		private static final String __OBFID = "CL_00000221";

		public String logType[] = { "ebony" };

		public EbonyLog() {
			super();
			this.setHardness(2.0F);
			this.setStepSound(soundTypeWood);
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister icon) {
			this.field_150167_a = new IIcon[logType.length];
			this.field_150166_b = new IIcon[logType.length];

			for (int i = 0; i < this.field_150167_a.length; ++i) {
				this.field_150167_a[i] = icon.registerIcon("mod_IDT:log_ebony");
				this.field_150166_b[i] = icon.registerIcon("mod_IDT:log_ebony_top");
			}
		}

		public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
			return true;
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isWood(IBlockAccess world, int x, int y, int z) {
			return true;
		}
	}

	public static class SilkwoodLog extends BlockLog {
		private static final String __OBFID = "CL_00000221";

		public String logType[] = { "silkwood" };

		public SilkwoodLog() {
			super();
			this.setHardness(2.0F);
			this.setStepSound(soundTypeWood);
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister icon) {
			this.field_150167_a = new IIcon[logType.length];
			this.field_150166_b = new IIcon[logType.length];

			for (int i = 0; i < this.field_150167_a.length; ++i) {
				this.field_150167_a[i] = icon.registerIcon("mod_IDT:log_silkwood");
				this.field_150166_b[i] = icon.registerIcon("mod_IDT:log_silkwood_top");
			}
		}

		public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
			return true;
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isWood(IBlockAccess world, int x, int y, int z) {
			return true;
		}
	}

	public static class GelidLog extends BlockLog {
		private static final String __OBFID = "CL_00000221";

		public String logType[] = { "gelid" };

		public GelidLog() {
			super();
			this.setHardness(2.0F);
			this.setStepSound(soundTypeWood);
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister icon) {
			this.field_150167_a = new IIcon[logType.length];
			this.field_150166_b = new IIcon[logType.length];

			for (int i = 0; i < this.field_150167_a.length; ++i) {
				this.field_150167_a[i] = icon.registerIcon("mod_IDT:log_gelid");
				this.field_150166_b[i] = icon.registerIcon("mod_IDT:log_gelid_top");
			}
		}

		public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
			return true;
		}

		public void getSubBlocks(Item item, CreativeTabs tab, List list) {
			list.add(new ItemStack(item, 1, 0));
		}

		public boolean isWood(IBlockAccess world, int x, int y, int z) {
			return true;
		}
	}
}
