package com.mce.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.mce.common.mod_IDT;

public class VanadiumArmor extends ItemArmor {

	public VanadiumArmor(ArmorMaterial mat, int index, int meta) {
		super(mat, index, meta);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String layer) {
		if (stack.getItem().equals(mod_IDT.VanadiumHelmet)
				|| stack.getItem().equals(mod_IDT.VanadiumChestplate)
				|| stack.getItem().equals(mod_IDT.VanadiumBoots)) {
			return "mod_IDT:textures/armor/vanadium_layer_1.png";
		}

		if (stack.getItem().equals(mod_IDT.VanadiumLeggings)) {
			return "mod_IDT:textures/armor/vanadium_layer_2.png";
		}

		else {
			System.out.println("An error has occurred! Error ID: IDT-303d");
			return null;
		}
	}

	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == mod_IDT.VanadiumIngot;
	}
}
