package com.mce.gen.biome.dimension;

import com.mce.common.mod_IDT;
import com.mce.handlers.dimensions.biomes.CrystalBiomes;

public class CrystalBiome extends CrystalBiomes {
	public CrystalBiome(int id) {
		super(id);
		this.setHeight(height_Default);
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		this.theBiomeDecorator.generateLakes = false;
		this.topBlock = mod_IDT.CrystalGlass;
		this.fillerBlock = mod_IDT.CrystalRock;
		this.enableRain = false;
		this.enableSnow = false;

		this.waterColorMultiplier = 10250102;

		this.setBiomeName("Crystalline");
	}
}
