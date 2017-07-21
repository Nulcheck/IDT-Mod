package com.mce.gen.biome;

import com.mce.common.mod_IDT;

import net.minecraft.world.biome.BiomeGenBase;

public class CrystalBiome extends BiomeGenBase {
	public CrystalBiome(int id) {
		super(id);
		this.setHeight(height_Default);
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

		this.theBiomeDecorator.generateLakes = false;
		this.topBlock = mod_IDT.CrystalBlock;
		this.fillerBlock = mod_IDT.CrystalBlock;
		this.enableRain = false;
		this.enableSnow = false;

		this.waterColorMultiplier = 10250102;

		this.setBiomeName("Crystalline");
	}
}
