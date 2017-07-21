package com.mce.armor;

import com.mce.common.mod_IDT;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class SteelArmor extends ItemArmor {
	public SteelArmor(ArmorMaterial mat, int index, int meta) {
		super(mat, index, meta);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
		if (stack.getItem().equals(mod_IDT.SteelHelmet) || stack.getItem().equals(mod_IDT.SteelChestplate)
				|| stack.getItem().equals(mod_IDT.SteelBoots)) {
			return "mod_IDT:textures/armor/steel_layer_1.png";
		}

		if (stack.getItem().equals(mod_IDT.SteelLeggings)) {
			return "mod_IDT:textures/armor/steel_layer_2.png";
		}

		else {
			System.out.println("An error has occurred! Error ID: IDT-303a");
			return null;
		}
	}

	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		// return stack.getItem() ==
		// stack.getItem().getItemById(OreDictionary.getOreID("ingotSteel"));
		return stack.getItem() == mod_IDT.SteelIngot;
	}
}
