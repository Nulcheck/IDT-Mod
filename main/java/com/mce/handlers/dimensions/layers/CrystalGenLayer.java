package com.mce.handlers.dimensions.layers;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class CrystalGenLayer extends GenLayer {
	public CrystalGenLayer(long seed) {
		super(seed);
	}

	public static GenLayer[] makeWorld(long seed, WorldType type) {
		GenLayer biomes = new FrostGenBiomes(1L);
		biomes = new GenLayerZoom(100L, biomes);
		GenLayer zoom = new GenLayerVoronoiZoom(10L, biomes);
		biomes.initWorldGenSeed(seed);
		zoom.initWorldGenSeed(seed);
		return new GenLayer[] { biomes, zoom };
	}

	public int[] getInts(int i, int j, int k, int l) {
		return null;
	}
}
