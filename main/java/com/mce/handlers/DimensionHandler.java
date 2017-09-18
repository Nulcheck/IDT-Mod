package com.mce.handlers;

import com.mce.common.mod_IDT;
import com.mce.handlers.dimensions.WorldProviderCrystal;
import com.mce.handlers.dimensions.WorldProviderFrost;

import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;

public class DimensionHandler {
	public static void mainRegistry() {
		dimensionRegistry();
	}

	public static void dimensionRegistry() {
		DimensionManager.registerProviderType(mod_IDT.frostDimId, WorldProviderFrost.class, true);
		DimensionManager.registerDimension(mod_IDT.frostDimId, mod_IDT.frostDimId);

		DimensionManager.registerProviderType(mod_IDT.crystalDimId, WorldProviderCrystal.class, true);
		DimensionManager.registerDimension(mod_IDT.crystalDimId, mod_IDT.crystalDimId);
	}
}
