package com.mce.api.other;

import com.mce.common.mod_IDT;

import cofh.thermalexpansion.util.crafting.PulverizerManager;
import net.minecraft.item.ItemStack;

public class TEIDTAPI {
	public static void loadComplete() {
		int energy = 4000;

		// Energy, Input, Output, Overwrite
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.EinsteiniumOre),
				new ItemStack(mod_IDT.EinsteiniumIngot, 2), true);
	}
}