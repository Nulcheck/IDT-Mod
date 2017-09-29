package com.mce.gen.biome;

import java.util.Random;

import com.mce.gen.trees.WorldGenWillowTree;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WillowForest extends BiomeGenBase {
	private WorldGenerator worldGenWillowTree;
	int idfk = 1;

	public WillowForest(int id) {
		super(id);
		this.setHeight(height_Default);
		this.setTemperatureRainfall(.5f, .8f);
		this.isHighHumidity();
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.addAll(this.spawnableCaveCreatureList);
		this.spawnableCreatureList.addAll(this.spawnableCreatureList);
		this.spawnableMonsterList.addAll(this.spawnableMonsterList);
		this.spawnableWaterCreatureList.addAll(this.spawnableWaterCreatureList);
		this.theBiomeDecorator.flowersPerChunk = 5;
		this.theBiomeDecorator.treesPerChunk = 8;
		this.theBiomeDecorator.grassPerChunk = 10;
		this.theBiomeDecorator.generateLakes = true;
		this.topBlock = Blocks.grass;
		this.fillerBlock = Blocks.dirt;
		this.worldGenWillowTree = new WorldGenWillowTree(true);
		this.biomeName = "Willow Forest";
		this.waterColorMultiplier = 10250102;
	}

	public WorldGenAbstractTree func_150567_a(Random ran) {
		return (WorldGenAbstractTree) ((this.idfk == 1) && ran.nextInt(3) == 0
				? (this.idfk != 2 && ran.nextInt(13) != 0 ? worldGenWillowTree : worldGenWillowTree)
				: (ran.nextInt(3) == 0 ? worldGenWillowTree : worldGenWillowTree));
	}

	public WorldGenerator getRandomWorldGenForGrass(Random rand) {
		return rand.nextInt(4) == 0 ? new WorldGenTallGrass(Blocks.tallgrass, 2)
				: new WorldGenTallGrass(Blocks.tallgrass, 1);
	}
}
