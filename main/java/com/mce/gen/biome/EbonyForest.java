package com.mce.gen.biome;

import java.util.Random;

import com.mce.gen.trees.WorldGenEbonyTree;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class EbonyForest extends BiomeGenBase {
	public WorldGenerator worldGenEbonyTree;
	int idfk = 1;

	public EbonyForest(int id) {
		super(id);
		this.setHeight(height_Default);
		this.setTemperatureRainfall(.3f, .5f);
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.addAll(this.spawnableCaveCreatureList);
		this.spawnableCreatureList.addAll(this.spawnableCreatureList);
		this.spawnableMonsterList.addAll(this.spawnableMonsterList);
		this.spawnableWaterCreatureList.addAll(this.spawnableWaterCreatureList);
		this.theBiomeDecorator.flowersPerChunk = 5;
		this.theBiomeDecorator.treesPerChunk = 8;
		this.theBiomeDecorator.grassPerChunk = 8;
		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
		this.worldGenEbonyTree = new WorldGenEbonyTree(true);
		this.biomeName = "Ebony Forest";
		// this.waterColorMultiplier = 10250102;
	}

	public BiomeGenBase.TempCategory getTempCategory() {
		return BiomeGenBase.TempCategory.MEDIUM;
	}

	public WorldGenAbstractTree func_150567_a(Random ran) {
		return (WorldGenAbstractTree) ((this.idfk == 1) && ran.nextInt(3) == 0 ? (this.idfk != 2
				&& ran.nextInt(13) != 0 ? worldGenEbonyTree : worldGenEbonyTree)
				: (ran.nextInt(3) == 0 ? worldGenEbonyTree : worldGenEbonyTree));
	}
}
