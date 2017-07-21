package com.mce.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Chisel extends Item {
	public Chisel() {
		super();
		this.setMaxDamage(251);
		this.setMaxStackSize(1);
	}

	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == Items.iron_ingot;
	}
}
