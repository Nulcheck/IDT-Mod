package com.mce.items;

import java.util.List;

import com.mce.common.mod_IDT;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItems extends Item {
	public ModItems() {
		super();
	}

	public static class SO2 extends Item {
		public SO2() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("SO" + "\u2082"); // small 2
		}
	}

	public static class SO3 extends Item {
		public SO3() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("SO" + "\u2083"); // small 3
		}
	}

	public static class H2SO4 extends Item {
		public H2SO4() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("H" + "\u2082" + "SO" + "\u2084"); // small 2 and 4

		}
	}

	public static class NO2Tank extends Item {
		public NO2Tank() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("NO" + "\u2082"); // small 2
		}
	}

	public static class HNO3 extends Item {
		public HNO3() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("HNO" + "\u2083"); // small 3
		}
	}

	public static class V2O5 extends Item {
		public V2O5() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("V" + "\u2082" + "O" + "\u2085"); // small 2 and 5
			list.add("Vanadium(V) Oxide");
		}
	}

	public static class Glycerin extends Item {
		public Glycerin() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("Glycerin");
			list.add("Glycerine");
		}
	}

	public static class Flask extends Item {
		public Flask() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("Erlenmeyer Flask");
		}
	}

	public static class PropaneTank extends Item {
		public static boolean containerItem = true;

		public PropaneTank() {
			super();
			this.maxStackSize = 1;
		}

		public ItemStack getContainerItem(ItemStack stack) {
			if (this.containerItem == true) {
				return new ItemStack(mod_IDT.EmptyTank);
			}
			return null;
		}

		public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
			if (this.containerItem == true) {
				return true;
			}
			return false;
		}

		public boolean hasContainerItem(ItemStack stack) {
			return this.containerItem;
		}
	}

	public static class T1CB extends Item {
		public T1CB() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("Tier 1");
		}
	}

	public static class T2CB extends Item {
		public T2CB() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("Tier 2");
		}
	}

	public static class T3CB extends Item {
		public T3CB() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("Tier 3");
			list.add("PCB");
		}
	}

	public static class Microchip extends Item {
		public Microchip() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("Integrated Circuit Board");
		}
	}

	public static class QMan extends Item {
		public QMan() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("Tier 4");
			list.add("Because raisins.");
		}
	}

	public static class IronSawBlade extends Item {
		public static boolean containerItem = true;

		public IronSawBlade() {
			super();
		}

		public ItemStack getContainerItem(ItemStack stack) {
			if (this.containerItem == false) {
				return null;
			}
			return new ItemStack(mod_IDT.IronSawBlade);
		}

		public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
			if (this.containerItem == false) {
				return true;
			}
			return false;
		}

		public boolean hasContainerItem(ItemStack stack) {
			return this.containerItem;
		}
	}

	public static class SteelSawBlade extends Item {
		public static boolean containerItem = true;

		public SteelSawBlade() {
			super();
		}

		public ItemStack getContainerItem(ItemStack stack) {
			if (this.containerItem == false) {
				return null;
			}
			return new ItemStack(mod_IDT.SteelSawBlade);
		}

		public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
			if (this.containerItem == false) {
				return true;
			}
			return false;
		}

		public boolean hasContainerItem(ItemStack stack) {
			return this.containerItem;
		}
	}

	public static class TitaniumSawBlade extends Item {
		public static boolean containerItem = true;

		public TitaniumSawBlade() {
			super();
		}

		public ItemStack getContainerItem(ItemStack stack) {
			if (this.containerItem == false) {
				return null;
			}
			return new ItemStack(mod_IDT.TitaniumSawBlade);
		}

		public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
			if (this.containerItem == false) {
				return true;
			}
			return false;
		}

		public boolean hasContainerItem(ItemStack stack) {
			return this.containerItem;
		}
	}

	public static class DiamondSawBlade extends Item {
		public static boolean containerItem = true;

		public DiamondSawBlade() {
			super();
		}

		public ItemStack getContainerItem(ItemStack stack) {
			if (this.containerItem == false) {
				return null;
			}
			return new ItemStack(mod_IDT.DiamondSawBlade);
		}

		public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
			if (this.containerItem == false) {
				return true;
			}
			return false;
		}

		public boolean hasContainerItem(ItemStack stack) {
			return this.containerItem;
		}
	}

	public static class MagneticUpgrade extends Item {
		public MagneticUpgrade() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("Smelter Upgrade");
		}
	}

	public static class LaserUpgrade extends Item {
		public LaserUpgrade() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("Industrial Cutter Upgrade");
		}
	}

	public static class StabilizerUpgrade extends Item {
		public StabilizerUpgrade() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("Black Hole Generator Upgrade");
		}
	}

	public static class QCUpgrade extends Item {
		public QCUpgrade() {
			super();
		}

		public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
			list.add("Matter Condenser Upgrade");
		}
	}
}