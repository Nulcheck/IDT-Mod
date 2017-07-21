package com.mce.handlers.dimensions.layers;

import com.mce.handlers.registers.BiomeRegistry;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class FrostGenBiomes extends GenLayer {
	public static BiomeGenBase[] allowBiomes = { BiomeRegistry.FrostBiome, BiomeRegistry.FrostBarren,
			BiomeRegistry.FrostForest, };

	public FrostGenBiomes(long seed) {
		super(seed);
	}

	public FrostGenBiomes(long seed, GenLayer gen) {
		super(seed);
		this.parent = gen;
	}

	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);

		for (int dz = 0; dz < depth; dz++) {
			for (int dx = 0; dx < width; dx++) {
				this.initChunkSeed(dx + x, dz + z);
				dest[(dx + dz * width)] = this.allowBiomes[nextInt(this.allowBiomes.length)].biomeID;
			}
		}

		return dest;
	}
}
