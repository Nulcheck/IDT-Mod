package com.mce.gen.biome;

import java.util.Random;

import com.mce.gen.trees.WorldGenSilkwoodTree;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class SilkwoodForest extends BiomeGenBase {
	public WorldGenerator worldGenSilkTree;
	int idfk = 1;

	public SilkwoodForest(int id) {
		super(id);
		this.setHeight(height_Default);
		this.setTemperatureRainfall(.4f, .4f);
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.addAll(this.spawnableCaveCreatureList);
		this.spawnableCreatureList.addAll(this.spawnableCreatureList);
		this.spawnableMonsterList.addAll(this.spawnableMonsterList);
		this.spawnableWaterCreatureList.addAll(this.spawnableWaterCreatureList);
		this.theBiomeDecorator.treesPerChunk = 8;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = 3;
		this.theBiomeDecorator.generateLakes = false;
		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
		this.worldGenSilkTree = new WorldGenSilkwoodTree(true);
		this.biomeName = "Silkwood Forest";
		this.waterColorMultiplier = 15395562; // 14474460
	}

	public int getBiomeGrassColor(int x, int y, int z) {
		return 14474460;
	}

	public WorldGenAbstractTree func_150567_a(Random ran) {
		return (WorldGenAbstractTree) ((this.idfk == 1) && ran.nextInt(3) == 0 ? (this.idfk != 2
				&& ran.nextInt(13) != 0 ? worldGenSilkTree : worldGenSilkTree)
				: (ran.nextInt(3) == 0 ? worldGenSilkTree : worldGenSilkTree));
	}
}
