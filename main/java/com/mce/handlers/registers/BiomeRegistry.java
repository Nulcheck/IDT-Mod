package com.mce.handlers.registers;

import com.mce.common.mod_IDT;
import com.mce.gen.biome.EbonyForest;
import com.mce.gen.biome.SilkwoodForest;
import com.mce.gen.biome.WillowForest;
import com.mce.gen.biome.dimension.CrystalBiome;
import com.mce.gen.biome.dimension.FrostBarren;
import com.mce.gen.biome.dimension.FrostBiome;
import com.mce.gen.biome.dimension.FrostForest;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeRegistry {
	public void main() {
		initBiome();
		registerBiome();
	}

	public static BiomeGenBase WillowForest;
	public static BiomeGenBase EbonyForest;
	public static BiomeGenBase SilkwoodForest;

	// Dimensions
	public static BiomeGenBase FrostBiome;
	public static BiomeGenBase FrostBarren;
	public static BiomeGenBase FrostForest;
	public static BiomeGenBase CrystalBiome;

	public static void initBiome() {
		// Biomes!
		WillowForest = new WillowForest(mod_IDT.WillowForestID);
		EbonyForest = new EbonyForest(mod_IDT.EbonyForestID);
		SilkwoodForest = new SilkwoodForest(mod_IDT.SilkwoodForestID);

		// Dimensional biomes
		FrostBiome = new FrostBiome(mod_IDT.FrostBiomeID);
		FrostBarren = new FrostBarren(mod_IDT.FrostBarrenID);
		FrostForest = new FrostForest(mod_IDT.FrostForestID);
		CrystalBiome = new CrystalBiome(mod_IDT.CrystalBiomeID);
	}

	public static void registerBiome() {
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(WillowForest, 10));
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(EbonyForest, 10));
		BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(SilkwoodForest, 10));
	}
}
