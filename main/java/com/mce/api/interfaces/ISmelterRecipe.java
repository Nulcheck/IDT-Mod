package com.mce.api.interfaces;

import net.minecraft.item.ItemStack;

public interface ISmelterRecipe {
	ItemStack getInput1();
	ItemStack getInput2();
	ItemStack getOutput();
}
