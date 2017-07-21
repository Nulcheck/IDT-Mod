package com.mce.gen.biome;

import com.mce.common.mod_IDT;
import com.mce.entity.mobs.EntityIcePhantom;
import com.mce.entity.mobs.EntityIcyCreeper;

import net.minecraft.world.biome.BiomeGenBase;

public class FrostBarren extends BiomeGenBase {
	public FrostBarren(int id) {
		super(id);
		this.setHeight(height_Default);
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityIcePhantom.class, 1, 1, 5));
		this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityIcyCreeper.class, 1, 1, 5));
		this.theBiomeDecorator.generateLakes = true;
		this.topBlock = mod_IDT.FrostStone;
		this.fillerBlock = mod_IDT.FrostStone;
		this.temperature = 0F;
		this.setEnableSnow();

		this.waterColorMultiplier = 7195119;

		this.setBiomeName("Frozen Barren Lands");
	}
}
