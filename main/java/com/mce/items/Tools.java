package com.mce.items;

import com.mce.common.mod_IDT;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class Tools {
	public static class Pick extends ItemPickaxe {
		public Pick(ToolMaterial mat) {
			super(mat);
		}

		public boolean getIsRepairable(ItemStack tool, ItemStack stack) {
			if (tool.getItem() == mod_IDT.SteelPick)
				return stack.getItem() == mod_IDT.SteelIngot;
			if (tool.getItem() == mod_IDT.TitaniumPick)
				return stack.getItem() == mod_IDT.TitaniumIngot;
			if (tool.getItem() == mod_IDT.VanadiumPick)
				return stack.getItem() == mod_IDT.VanadiumIngot;
			if (tool.getItem() == mod_IDT.VCPick)
				return stack.getItem() == mod_IDT.VCIngot;
			if (tool.getItem() == mod_IDT.NeoronPick)
				return stack.getItem() == mod_IDT.NeoronIngot;
			return false;
		}
	}

	public static class Shovel extends ItemSpade {
		public Shovel(ToolMaterial mat) {
			super(mat);
		}

		public boolean getIsRepairable(ItemStack tool, ItemStack stack) {
			if (tool.getItem() == mod_IDT.SteelShovel)
				return stack.getItem() == mod_IDT.SteelIngot;
			if (tool.getItem() == mod_IDT.TitaniumShovel)
				return stack.getItem() == mod_IDT.TitaniumIngot;
			if (tool.getItem() == mod_IDT.VanadiumShovel)
				return stack.getItem() == mod_IDT.VanadiumIngot;
			if (tool.getItem() == mod_IDT.VCShovel)
				return stack.getItem() == mod_IDT.VCIngot;
			return false;
		}
	}

	public static class Axe extends ItemAxe {
		public Axe(ToolMaterial mat) {
			super(mat);
		}

		public boolean getIsRepairable(ItemStack tool, ItemStack stack) {
			if (tool.getItem() == mod_IDT.SteelAxe)
				return stack.getItem() == mod_IDT.SteelIngot;
			if (tool.getItem() == mod_IDT.TitaniumAxe)
				return stack.getItem() == mod_IDT.TitaniumIngot;
			if (tool.getItem() == mod_IDT.VanadiumAxe)
				return stack.getItem() == mod_IDT.VanadiumIngot;
			if (tool.getItem() == mod_IDT.VCAxe)
				return stack.getItem() == mod_IDT.VCIngot;
			return false;
		}
	}

	public static class Sword extends ItemSword {
		public Sword(ToolMaterial mat) {
			super(mat);
		}

		public boolean getIsRepairable(ItemStack tool, ItemStack stack) {
			if (tool.getItem() == mod_IDT.SteelSword)
				return stack.getItem() == mod_IDT.SteelIngot;
			if (tool.getItem() == mod_IDT.TitaniumSword)
				return stack.getItem() == mod_IDT.TitaniumIngot;
			if (tool.getItem() == mod_IDT.VanadiumSword)
				return stack.getItem() == mod_IDT.VanadiumIngot;
			if (tool.getItem() == mod_IDT.VCSword)
				return stack.getItem() == mod_IDT.VCIngot;
			return false;
		}
	}

	public static class Hoe extends ItemHoe {
		public Hoe(ToolMaterial mat) {
			super(mat);
		}

		public boolean getIsRepairable(ItemStack tool, ItemStack stack) {
			if (tool.getItem() == mod_IDT.SteelHoe)
				return stack.getItem() == mod_IDT.SteelIngot;
			if (tool.getItem() == mod_IDT.TitaniumHoe)
				return stack.getItem() == mod_IDT.TitaniumIngot;
			if (tool.getItem() == mod_IDT.VanadiumHoe)
				return stack.getItem() == mod_IDT.VanadiumIngot;
			if (tool.getItem() == mod_IDT.VCHoe)
				return stack.getItem() == mod_IDT.VCIngot;
			return false;
		}
	}
}
