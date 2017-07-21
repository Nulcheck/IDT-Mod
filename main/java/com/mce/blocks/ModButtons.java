package com.mce.blocks;

import com.mce.common.mod_IDT;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockButton;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class ModButtons extends BlockButton {

	public ModButtons(boolean sense) {
		super(sense);
	}

	public static class BirchButton extends BlockButton {
		public BirchButton(boolean sense) {
			super(sense);
		}

		public IIcon getIcon(int side, int meta) {
			return Blocks.planks.getIcon(side, 2);
		}
	}

	public static class SpruceButton extends BlockButton {
		public SpruceButton(boolean sense) {
			super(sense);
		}

		public IIcon getIcon(int side, int meta) {
			return Blocks.planks.getIcon(side, 1);
		}
	}

	public static class JungleButton extends BlockButton {
		public JungleButton(boolean sense) {
			super(sense);
		}

		public IIcon getIcon(int side, int meta) {
			return Blocks.planks.getIcon(side, 3);
		}
	}

	public static class WillowButton extends BlockButton {
		public WillowButton(boolean sense) {
			super(sense);
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int meta, int side) {
			return mod_IDT.WillowPlanks.getBlockTextureFromSide(side);
		}
	}

	public static class EbonyButton extends BlockButton {
		public EbonyButton(boolean sense) {
			super(sense);
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int meta, int side) {
			return mod_IDT.EbonyPlanks.getBlockTextureFromSide(side);
		}
	}

	public static class SilkwoodButton extends BlockButton {
		public SilkwoodButton(boolean sense) {
			super(sense);
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int meta, int side) {
			return mod_IDT.SilkwoodPlanks.getBlockTextureFromSide(side);
		}
	}

	public static class AcaciaButton extends BlockButton {
		public AcaciaButton(boolean sense) {
			super(sense);
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int meta, int side) {
			return Blocks.planks.getIcon(side, 4);
		}
	}

	public static class DarkOakButton extends BlockButton {
		public DarkOakButton(boolean sense) {
			super(sense);
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int meta, int side) {
			return Blocks.planks.getIcon(side, 5);
		}
	}

	public static class GelidButton extends BlockButton {
		public GelidButton(boolean sense) {
			super(sense);
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int meta, int side) {
			return mod_IDT.GelidPlanks.getIcon(side, 0);
		}
	}
}
