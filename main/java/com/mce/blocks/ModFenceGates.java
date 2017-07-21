package com.mce.blocks;

import com.mce.common.mod_IDT;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class ModFenceGates extends BlockFenceGate {
	public ModFenceGates() {
		super();
	}

	public static class BirchFenceGate extends BlockFenceGate {

		public BirchFenceGate() {
			super();
		}

		public IIcon getIcon(int side, int meta) {
			return Blocks.planks.getIcon(side, 2);
		}
	}

	public static class SpruceFenceGate extends BlockFenceGate {

		public SpruceFenceGate() {
			super();
		}

		public IIcon getIcon(int side, int meta) {
			return Blocks.planks.getIcon(side, 1);
		}
	}

	public static class JungleFenceGate extends BlockFenceGate {

		public JungleFenceGate() {
			super();
		}

		public IIcon getIcon(int side, int meta) {
			return Blocks.planks.getIcon(side, 3);
		}
	}

	public static class WillowFenceGate extends BlockFenceGate {

		public WillowFenceGate() {
			super();
		}

		public IIcon getIcon(int side, int meta) {
			return mod_IDT.WillowPlanks.getBlockTextureFromSide(side);
		}
	}

	public static class EbonyFenceGate extends BlockFenceGate {

		public EbonyFenceGate() {
			super();
		}

		public IIcon getIcon(int side, int meta) {
			return mod_IDT.EbonyPlanks.getBlockTextureFromSide(side);
		}
	}

	public static class SilkwoodFenceGate extends BlockFenceGate {

		public SilkwoodFenceGate() {
			super();
		}

		public IIcon getIcon(int side, int meta) {
			return mod_IDT.SilkwoodPlanks.getBlockTextureFromSide(side);
		}
	}

	public static class AcaciaFenceGate extends BlockFenceGate {

		public AcaciaFenceGate() {
			super();
		}

		public IIcon getIcon(int side, int meta) {
			return Blocks.planks.getIcon(side, 4);
		}
	}

	public static class DarkOakFenceGate extends BlockFenceGate {

		public DarkOakFenceGate() {
			super();
		}

		public IIcon getIcon(int side, int meta) {
			return Blocks.planks.getIcon(side, 5);
		}
	}

	public static class GelidFenceGate extends BlockFenceGate {

		public GelidFenceGate() {
			super();
		}

		public IIcon getIcon(int side, int meta) {
			return mod_IDT.GelidPlanks.getIcon(side, 0);
		}
	}
}
