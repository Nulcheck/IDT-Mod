package com.mce.armor;

import com.mce.common.mod_IDT;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class TantalumArmor extends ItemArmor {

	public TantalumArmor(ArmorMaterial mat, int index, int meta) {
		super(mat, index, meta);
	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		player.addPotionEffect(new PotionEffect(12, 100, 0));
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
		if (stack.getItem().equals(mod_IDT.TantalumHelmet) || stack.getItem().equals(mod_IDT.TantalumChestplate)
				|| stack.getItem().equals(mod_IDT.TantalumBoots)) {
			return "mod_IDT:textures/armor/tantalum_layer_1.png";
		}

		if (stack.getItem().equals(mod_IDT.TantalumLeggings)) {
			return "mod_IDT:textures/armor/tantalum_layer_2.png";
		}

		else {
			System.out.println("An error has occurred! Error ID: IDT-303e");
			return null;
		}
	}

	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == mod_IDT.TantalumIngot;
	}
}
