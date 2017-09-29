package com.mce.gen.biome.dimension;

import com.mce.common.mod_IDT;
import com.mce.entity.mobs.EntityIcePhantom;
import com.mce.entity.mobs.EntityIcyCreeper;
import com.mce.handlers.dimensions.biomes.FrostBiomes;

import net.minecraft.world.biome.BiomeGenBase;

public class FrostBiome extends FrostBiomes {
	public FrostBiome(int id) {
		super(id);
		this.setHeight(height_Default);
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityIcePhantom.class, 1, 1, 5));
		this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityIcyCreeper.class, 1, 1, 5));
		this.theBiomeDecorator.generateLakes = true;
		this.topBlock = mod_IDT.FrostGrass;
		this.fillerBlock = mod_IDT.FrostDirt;
		this.temperature = 0F;
		this.setEnableSnow();

		this.waterColorMultiplier = 7195119;

		this.setBiomeName("Frozen Lands");
	}
}
