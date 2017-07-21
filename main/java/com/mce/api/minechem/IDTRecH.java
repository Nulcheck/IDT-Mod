package com.mce.api.minechem;

import com.mce.api.IDTRecipeAPI;
import com.mce.common.mod_IDT;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class IDTRecH {
	private static final IDTRecH recipes = new IDTRecH();

	public static IDTRecH getInstance() {
		return recipes;
	}

	public void recipes() {
		IDTRecipeAPI.addSmelterRecipe(new ItemStack(Items.stick), new ItemStack(Items.apple),
				new ItemStack(Items.arrow), 0.8f);
		//IDTRecipeAPI.addWelderRecipe(new ItemStack(Items.apple), new ItemStack(Items.apple), new ItemStack(Items.bone), 5f);
	}
}
