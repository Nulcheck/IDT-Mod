package com.mce.handlers;

import com.mce.gen.ores.WorldGenBoronOre;
import com.mce.gen.ores.WorldGenCopperOre;
import com.mce.gen.ores.WorldGenAmblygoniteOre;
import com.mce.gen.ores.WorldGenEinsteiniumOre;
import com.mce.gen.ores.WorldGenNeodymiumOre;
import com.mce.gen.ores.WorldGenNeptuniumOre;
import com.mce.gen.ores.WorldGenPhosphorite;
import com.mce.gen.ores.WorldGenPraseodymiumOre;
import com.mce.gen.ores.WorldGenSulfurOre;
import com.mce.gen.ores.WorldGenTantalumOre;
import com.mce.gen.ores.WorldGenTitaniumOre;
import com.mce.gen.ores.WorldGenUraniumOre;
import com.mce.gen.ores.WorldGenVanadiumOre;
import com.mce.gen.ores.WorldGenZimphnode;

import cpw.mods.fml.common.registry.GameRegistry;

public class OreGenHandler {
	public static void genOres() {
		GameRegistry.registerWorldGenerator(new WorldGenEinsteiniumOre(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenNeptuniumOre(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenUraniumOre(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenAmblygoniteOre(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenPraseodymiumOre(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenNeodymiumOre(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenZimphnode(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenVanadiumOre(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenTantalumOre(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenSulfurOre(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenBoronOre(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenCopperOre(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenTitaniumOre(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenPhosphorite(), 0);
	}
}
