package com.mce.handlers.dimensions.chunks;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CAVE;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.RAVINE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAVA;

import java.util.List;
import java.util.Random;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class ChunkProviderCrystal implements IChunkProvider {
	/** RNG. */
	private Random rand;

	private NoiseGeneratorOctaves ng1;
	private NoiseGeneratorOctaves ng2;
	private NoiseGeneratorOctaves ng3;
	private NoiseGeneratorPerlin np;

	/** A NoiseGeneratorOctaves used in generating terrain */
	public NoiseGeneratorOctaves ng5;

	/** A NoiseGeneratorOctaves used in generating terrain */
	public NoiseGeneratorOctaves ng6;
	public NoiseGeneratorOctaves msn;

	/** Reference to the World object. */
	private World worldObj;

	/** are map structures going to be generated (e.g. strongholds) */
	private final boolean mapFeaturesEnabled;

	private WorldType wType;
	private final double[] nArray;
	private final float[] pf;
	private double[] stoneNoise = new double[256];
	private MapGenBase caveGenerator = new MapGenCaves();

	// private MapGenScatteredFeature scatteredFeatureGenerator = new
	// MapGenScatteredFeature();

	/** Holds ravine generator */
	private MapGenBase ravineGenerator = new MapGenRavine();

	/** The biomes that are used to generate the chunk */
	private BiomeGenBase[] biomesForGeneration;

	double[] n3;
	double[] n1;
	double[] n2;
	double[] n5;
	int[][] iArray = new int[32][32];
	private static final String __OBFID = "CL_00000396";

	{
		caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
		/*
		 * scatteredFeatureGenerator = (MapGenScatteredFeature)
		 * TerrainGen.getModdedMapGen(scatteredFeatureGenerator,
		 * SCATTERED_FEATURE);
		 */
		ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
	}

	public ChunkProviderCrystal(World world, long seed, boolean features) {
		this.worldObj = world;
		this.mapFeaturesEnabled = features;
		this.wType = world.getWorldInfo().getTerrainType();
		this.rand = new Random(seed);
		this.ng1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.ng2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.ng3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.np = new NoiseGeneratorPerlin(this.rand, 4);
		this.ng5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.ng6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.msn = new NoiseGeneratorOctaves(this.rand, 8);
		this.nArray = new double[825];
		this.pf = new float[25];

		for (int j = -2; j <= 2; ++j) {
			for (int k = -2; k <= 2; ++k) {
				float f = 10.0F / MathHelper.sqrt_float((float) (j * j + k * k) + 0.2F);
				this.pf[j + 2 + (k + 2) * 5] = f;
			}
		}

		NoiseGenerator[] noiseGens = { ng1, ng2, ng3, np, ng5, ng6, msn };
		noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);
		this.ng1 = (NoiseGeneratorOctaves) noiseGens[0];
		this.ng2 = (NoiseGeneratorOctaves) noiseGens[1];
		this.ng3 = (NoiseGeneratorOctaves) noiseGens[2];
		this.np = (NoiseGeneratorPerlin) noiseGens[3];
		this.ng5 = (NoiseGeneratorOctaves) noiseGens[4];
		this.ng6 = (NoiseGeneratorOctaves) noiseGens[5];
		this.msn = (NoiseGeneratorOctaves) noiseGens[6];
	}

	public void generateTerrain(int i, int j, Block[] block) {
		byte b0 = 63;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration,
				i * 4 - 2, j * 4 - 2, 10, 10);
		this.initNoise(i * 4, 0, j * 4);

		for (int k = 0; k < 4; ++k) {
			int l = k * 5;
			int i1 = (k + 1) * 5;

			for (int j1 = 0; j1 < 4; ++j1) {
				int k1 = (l + j1) * 33;
				int l1 = (l + j1 + 1) * 33;
				int i2 = (i1 + j1) * 33;
				int j2 = (i1 + j1 + 1) * 33;

				for (int k2 = 0; k2 < 32; ++k2) {
					double d0 = 0.125D;
					double d1 = this.nArray[k1 + k2];
					double d2 = this.nArray[l1 + k2];
					double d3 = this.nArray[i2 + k2];
					double d4 = this.nArray[j2 + k2];
					double d5 = (this.nArray[k1 + k2 + 1] - d1) * d0;
					double d6 = (this.nArray[l1 + k2 + 1] - d2) * d0;
					double d7 = (this.nArray[i2 + k2 + 1] - d3) * d0;
					double d8 = (this.nArray[j2 + k2 + 1] - d4) * d0;

					for (int l2 = 0; l2 < 8; ++l2) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;

						for (int i3 = 0; i3 < 4; ++i3) {
							int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
							short short1 = 256;
							j3 -= short1;
							double d14 = 0.25D;
							double d16 = (d11 - d10) * d14;
							double d15 = d10 - d16;

							for (int k3 = 0; k3 < 4; ++k3) {
								if ((d15 += d16) > 0.0D) {
									block[j3 += short1] = mod_IDT.CrystalBlock;
								} else if (k2 * 8 + l2 < b0) {
									block[j3 += short1] = null;
								} else {
									block[j3 += short1] = null; // air?
								}
							}

							d10 += d12;
							d11 += d13;
						}

						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}

	public void replaceBlocksForBiome(int i, int j, Block[] block, byte[] b0, BiomeGenBase[] biome) {
		ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, i, j, block, b0,
				biome, this.worldObj);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY)
			return;

		double d0 = 0.03125D;
		this.stoneNoise = this.np.func_151599_a(this.stoneNoise, (double) (i * 16), (double) (j * 16), 16, 16,
				d0 * 2.0D, d0 * 2.0D, 1.0D);

		for (int k = 0; k < 16; ++k) {
			for (int l = 0; l < 16; ++l) {
				BiomeGenBase biomegenbase = biome[l + k * 16];
				biomegenbase.genTerrainBlocks(this.worldObj, this.rand, block, b0, i * 16 + k, j * 16 + l,
						this.stoneNoise[l + k * 16]);
			}
		}
	}

	public Chunk loadChunk(int i, int j) {
		return this.provideChunk(i, j);
	}

	public Chunk provideChunk(int i, int j) {
		this.rand.setSeed((long) i * 341873128712L + (long) j * 132897987541L);
		Block[] ablock = new Block[65536];
		byte[] abyte = new byte[65536];
		this.generateTerrain(i, j, ablock);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration,
				i * 16, j * 16, 16, 16);
		this.replaceBlocksForBiome(i, j, ablock, abyte, this.biomesForGeneration);
		this.caveGenerator.func_151539_a(this, this.worldObj, i, j, ablock);
		this.ravineGenerator.func_151539_a(this, this.worldObj, i, j, ablock);

		if (this.mapFeaturesEnabled) {
			// this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj,
			// i, j, ablock);
		}

		Chunk chunk = new Chunk(this.worldObj, ablock, abyte, i, j);
		byte[] abyte1 = chunk.getBiomeArray();

		for (int k = 0; k < abyte1.length; ++k) {
			abyte1[k] = (byte) this.biomesForGeneration[k].biomeID;
		}

		chunk.generateSkylightMap();
		return chunk;
	}

	private void initNoise(int x, int y, int z) {
		double d0 = 684.412D;
		double d1 = 684.412D;
		double d2 = 512.0D;
		double d3 = 512.0D;
		this.n5 = this.ng6.generateNoiseOctaves(this.n5, x, z, 5, 5, 200.0D, 200.0D, 0.5D);
		this.n3 = this.ng3.generateNoiseOctaves(this.n3, x, y, z, 5, 33, 5, 8.555150000000001D, 4.277575000000001D,
				8.555150000000001D);
		this.n1 = this.ng1.generateNoiseOctaves(this.n1, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		this.n3 = this.ng2.generateNoiseOctaves(this.n3, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		boolean flag1 = false;
		boolean flag = false;
		int l = 0;
		int i1 = 0;
		double d4 = 8.5D;

		for (int j1 = 0; j1 < 5; ++j1) {
			for (int k1 = 0; k1 < 5; ++k1) {
				float f = 0.0F;
				float f1 = 0.0F;
				float f2 = 0.0F;
				byte b0 = 2;
				BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];

				for (int l1 = -b0; l1 <= b0; ++l1) {
					for (int i2 = -b0; i2 <= b0; ++i2) {
						BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
						float f3 = biomegenbase1.rootHeight;
						float f4 = biomegenbase1.heightVariation;

						if (this.wType == WorldType.AMPLIFIED && f3 > 0.0F) {
							f3 = 1.0F + f3 * 2.0F;
							f4 = 1.0F + f4 * 4.0F;
						}

						float f5 = this.pf[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);

						if (biomegenbase1.rootHeight > biomegenbase.rootHeight) {
							f5 /= 2.0F;
						}

						f += f4 * f5;
						f1 += f3 * f5;
						f2 += f5;
					}
				}

				f /= f2;
				f1 /= f2;
				f = f * 0.9F + 0.1F;
				f1 = (f1 * 4.0F - 1.0F) / 8.0F;
				double d12 = this.n5[i1] / 8000.0D;

				if (d12 < 0.0D) {
					d12 = -d12 * 0.3D;
				}

				d12 = d12 * 3.0D - 2.0D;

				if (d12 < 0.0D) {
					d12 /= 2.0D;

					if (d12 < -1.0D) {
						d12 = -1.0D;
					}

					d12 /= 1.4D;
					d12 /= 2.0D;
				} else {
					if (d12 > 1.0D) {
						d12 = 1.0D;
					}

					d12 /= 8.0D;
				}

				++i1;
				double d13 = (double) f1;
				double d14 = (double) f;
				d13 += d12 * 0.2D;
				d13 = d13 * 8.5D / 8.0D;
				double d5 = 8.5D + d13 * 4.0D;

				for (int j2 = 0; j2 < 33; ++j2) {
					double d6 = ((double) j2 - d5) * 12.0D * 128.0D / 256.0D / d14;

					if (d6 < 0.0D) {
						d6 *= 4.0D;
					}

					double d7 = this.n1[l] / 512.0D;
					double d8 = this.n3[l] / 512.0D;
					double d9 = (this.n3[l] / 10.0D + 1.0D) / 2.0D;
					double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;

					if (j2 > 29) {
						double d11 = (double) ((float) (j2 - 29) / 3.0F);
						d10 = d10 * (1.0D - d11) + -10.0D * d11;
					}

					this.nArray[l] = d10;
					++l;
				}
			}
		}
	}

	public boolean chunkExists(int i, int j) {
		return true;
	}

	// Populate chucks with ores.
	public void populate(IChunkProvider chunkProv, int i, int j) {
		BlockFalling.fallInstantly = true;
		int k = i * 16;
		int l = j * 16;
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long i1 = this.rand.nextLong() / 2L * 2L + 1L;
		long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long) i * i1 + (long) j * j1 ^ this.worldObj.getSeed());
		boolean flag = false;

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(chunkProv, worldObj, rand, i, j, flag));

		if (this.mapFeaturesEnabled) {
			// this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj,
			// this.rand, i, j);
		}

		int k1;
		int l1;
		int i2;

		if (TerrainGen.populate(chunkProv, worldObj, rand, i, j, flag, LAVA) && !flag && this.rand.nextInt(8) == 0) {
			k1 = k + this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
			i2 = l + this.rand.nextInt(16) + 8;

			if (l1 < 63 || this.rand.nextInt(10) == 0) {
				(new WorldGenLakes(null)).generate(this.worldObj, this.rand, k1, l1, i2);
			}
		}

		biomegenbase.decorate(this.worldObj, this.rand, k, l);
		if (TerrainGen.populate(chunkProv, worldObj, rand, i, j, flag, ANIMALS)) {
			SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
		}
		k += 8;
		l += 8;

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(chunkProv, worldObj, rand, i, j, flag));

		BlockFalling.fallInstantly = false;
	}

	public boolean saveChunks(boolean save, IProgressUpdate update) {
		return true;
	}

	public void saveExtraData() {
	}

	public boolean unloadQueuedChunks() {
		return false;
	}

	public boolean canSave() {
		return true;
	}

	public String makeString() {
		return "RandomLevelSource";
	}

	public List getPossibleCreatures(EnumCreatureType type, int x, int y, int z) {
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(x, z);
		/*
		 * return type == EnumCreatureType.monster &&
		 * this.scatteredFeatureGenerator.func_143030_a(x, y, z) ?
		 * this.scatteredFeatureGenerator.getScatteredFeatureSpawnList() :
		 * biome.getSpawnableList(type);
		 */
		return biome.getSpawnableList(type);
	}

	public ChunkPosition func_147416_a(World world, String string, int x, int y, int z) {
		return null;
	}

	public int getLoadedChunkCount() {
		return 0;
	}

	public void recreateStructures(int p_82695_1_, int p_82695_2_) {
		if (this.mapFeaturesEnabled) {
			// this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj,
			// p_82695_1_, p_82695_2_, (Block[]) null);
		}
	}
}