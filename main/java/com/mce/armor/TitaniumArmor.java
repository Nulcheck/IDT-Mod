package com.mce.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.mce.common.mod_IDT;

public class TitaniumArmor extends ItemArmor {

	public TitaniumArmor(ArmorMaterial mat, int index, int meta) {
		super(mat, index, meta);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String layer) {
		if (stack.getItem().equals(mod_IDT.TitaniumHelmet)
				|| stack.getItem().equals(mod_IDT.TitaniumChestplate)
				|| stack.getItem().equals(mod_IDT.TitaniumBoots)) {
			return "mod_IDT:textures/armor/titanium_layer_1.png";
		}

		if (stack.getItem().equals(mod_IDT.TitaniumLeggings)) {
			return "mod_IDT:textures/armor/titanium_layer_2.png";
		}

		else {
			System.out.println("An error has occurred! Error ID: IDT-303b");
			return null;
		}
	}

	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == mod_IDT.TitaniumIngot;
	}
}
