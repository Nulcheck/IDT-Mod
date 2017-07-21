package com.mce.armor;

import com.mce.common.mod_IDT;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class VCArmor extends ItemArmor {
	public VCArmor(ArmorMaterial mat, int index, int meta) {
		super(mat, index, meta);
	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
		if (stack.getItem().equals(mod_IDT.VCHelmet) || stack.getItem().equals(mod_IDT.VCChestplate)
				|| stack.getItem().equals(mod_IDT.VCBoots)) {
			return "mod_IDT:textures/armor/vc_layer_1.png";
		}

		if (stack.getItem().equals(mod_IDT.VCLeggings)) {
			return "mod_IDT:textures/armor/vc_layer_2.png";
		}

		else {
			System.out.println("An error has occurred! Error ID: IDT-303g");
			return null;
		}
	}
	
	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == mod_IDT.VCIngot;
	}
}
