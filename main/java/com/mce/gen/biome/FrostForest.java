package com.mce.gen.biome;

import java.util.Random;

import com.mce.common.mod_IDT;
import com.mce.entity.mobs.EntityIcePhantom;
import com.mce.entity.mobs.EntityIcyCreeper;
import com.mce.gen.trees.WorldGenGelidTree;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class FrostForest extends BiomeGenBase {
	private WorldGenerator worldGenFrostTree;
	int idfk = 1;

	public FrostForest(int id) {
		super(id);
		this.setHeight(height_Default);
		this.temperature = 0F;
		this.setEnableSnow();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityIcePhantom.class, 1, 2, 5));
		this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityIcyCreeper.class, 1, 2, 5));
		this.theBiomeDecorator.generateLakes = true;
		this.worldGenFrostTree = new WorldGenGelidTree();
		
		this.topBlock = mod_IDT.FrostGrass;
		this.fillerBlock = mod_IDT.FrostDirt;
		
		this.waterColorMultiplier = 7195119;
		this.setBiomeName("Frosty Forest");
	}

	public WorldGenAbstractTree func_150567_a(Random ran) {
		return (WorldGenAbstractTree) ((this.idfk == 1) && ran.nextInt(3) == 0
				? (this.idfk != 2 && ran.nextInt(13) != 0 ? worldGenFrostTree : worldGenFrostTree)
				: (ran.nextInt(3) == 0 ? worldGenFrostTree : worldGenFrostTree));
	}
}
