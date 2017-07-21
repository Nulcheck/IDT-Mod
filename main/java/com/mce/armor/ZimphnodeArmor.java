package com.mce.armor;

import com.mce.common.mod_IDT;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ZimphnodeArmor extends ItemArmor {
	public ZimphnodeArmor(ArmorMaterial mat, int index, int meta) {
		super(mat, index, meta);
	}

	public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
		if (stack.getItem().equals(mod_IDT.ZimphnodeBoots)) {
			player.addPotionEffect(new PotionEffect(1, 0, 1));
		}
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) {
		if (stack.getItem().equals(mod_IDT.ZimphnodeHelmet) || stack.getItem().equals(mod_IDT.ZimphnodeChestplate)
				|| stack.getItem().equals(mod_IDT.ZimphnodeBoots)) {
			return "mod_IDT:textures/armor/zimphnode_layer_1.png";
		}

		if (stack.getItem().equals(mod_IDT.ZimphnodeLeggings)) {
			return "mod_IDT:textures/armor/zimphnode_layer_2.png";
		}

		else {
			System.out.println("An error has occurred! Error ID: IDT-303c");
			return null;
		}
	}

	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == mod_IDT.ZimphnodeBar;
	}
}
