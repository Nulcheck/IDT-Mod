package com.mce.handlers.dimensions.biomes;

import java.util.Random;

import com.mce.common.mod_IDT;
import com.mce.gen.biome.dimension.FrostBarren;
import com.mce.gen.biome.dimension.FrostBiome;
import com.mce.gen.biome.dimension.FrostForest;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class FrostBiomes extends BiomeGenBase {
	public static BiomeGenBase frostBarren;
	public static BiomeGenBase frostForest;
	public static BiomeGenBase frostBiome;

	public FrostBiomes(int id) {
		super(id);
	}

	static {
		frostBarren = (new FrostBarren(mod_IDT.FrostBarrenID).setBiomeName("Frozen Barren Lands"));
		frostForest = (new FrostForest(mod_IDT.FrostForestID).setBiomeName("Frosty Forest"));
		frostBiome = (new FrostBiome(mod_IDT.FrostBiomeID).setBiomeName("Frozen Lands"));
	}

	public static void registerWithBiomeDictionary() {
		BiomeDictionary.registerBiomeType(frostBarren, Type.SNOWY);
		BiomeDictionary.registerBiomeType(frostForest, Type.SNOWY);
		BiomeDictionary.registerBiomeType(frostBiome, Type.SNOWY);
		BiomeDictionary.registerAllBiomes();
	}

	public void genTerrainBlocks(World world, Random rand, Block[] block, byte[] b, int x, int y, double z) {
		genBiomeModdedTerrain(world, rand, block, b, x, y, z);
	}

	/**
	 * Replaces custom Stone to allow top/filler blocks to work in dimension.
	 * 
	 * @param world
	 * @param random
	 * @param replacableBlock
	 * @param aByte
	 * @param x
	 * @param y
	 * @param z
	 */
	public void genBiomeModdedTerrain(World world, Random random, Block[] replacableBlock, byte[] aByte, int x, int y,
			double z) {
		Block block = this.topBlock;
		byte b0 = (byte) (this.field_150604_aj & 255);
		Block block1 = this.fillerBlock;
		int k = -1;
		int l = (int) (z / 3.0D + 3.0D + random.nextDouble() * 0.25D);
		int i1 = x & 15;
		int j1 = y & 15;
		int k1 = replacableBlock.length / 256;
		for (int l1 = 255; l1 >= 0; --l1) {
			int i2 = (j1 * 16 + i1) * k1 + l1;

			if (l1 <= 0 + random.nextInt(5)) {
				replacableBlock[i2] = Blocks.bedrock;
			} else {
				Block block2 = replacableBlock[i2];

				if (block2 != null && block2.getMaterial() != Material.air) {
					if (block2 == mod_IDT.FrostStone) {
						if (k == -1) {
							if (l <= 0) {
								block = null;
								b0 = 0;
								block1 = mod_IDT.FrostStone;
							} else if (l1 >= 59 && l1 <= 64) {
								block = this.topBlock;
								b0 = (byte) (this.field_150604_aj & 255);
								block1 = this.fillerBlock;
							}

							if (l1 < 63 && (block == null || block.getMaterial() == Material.air)) {
								if (this.getFloatTemperature(x, l1, y) < 0.15F) {
									block = Blocks.ice;
									b0 = 0;
								} else {
									block = mod_IDT.LiquidNitrogen; // Water
									b0 = 0;
								}
							}

							k = l;

							if (l1 >= 62) {
								replacableBlock[i2] = block;
								aByte[i2] = b0;
							} else if (l1 < 56 - l) {
								block = null;
								block1 = mod_IDT.FrostStone;
								replacableBlock[i2] = mod_IDT.FrostStone; // Gravel
							} else {
								replacableBlock[i2] = block1;
							}
						}
					}
				} else {
					k = -1;
				}
			}
		}
	}
}
