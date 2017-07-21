package com.mce.handlers.dimensions.chunks.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mce.handlers.dimensions.layers.CrystalGenLayer;

import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class WorldChunkManagerCrystal extends WorldChunkManager {
	private GenLayer genBiomes;
	private GenLayer biomeIndex;
	private BiomeCache biomeCache;
	private List<BiomeGenBase> biomes;

	public WorldChunkManagerCrystal() {
		this.biomeCache = new BiomeCache(this);
		this.biomes = new ArrayList();
		this.biomes.addAll(allowedBiomes);
	}

	public WorldChunkManagerCrystal(long seed, WorldType type) {
		this();
		GenLayer[] layer = CrystalGenLayer.makeWorld(seed, type);
		layer = getModdedBiomeGenerators(type, seed, layer);
		this.genBiomes = layer[0];
		this.biomeIndex = layer[1];
	}

	public WorldChunkManagerCrystal(World world) {
		this(world.getSeed(), world.getWorldInfo().getTerrainType());
	}

	public List<BiomeGenBase> biomes() {
		return this.biomes;
	}

	public BiomeGenBase genBiomeAt(int x, int z) {
		return this.biomeCache.getBiomeGenAt(x, z);
	}

	public float[] getRainfall(float[] listToReuse, int x, int z, int w, int l) {
		IntCache.resetIntCache();

		if (listToReuse == null || listToReuse.length < w * l) {
			listToReuse = new float[w * l];
		}

		int[] i = this.biomeIndex.getInts(x, z, w, l);

		for (int i1 = 0; i1 < w * l; i1++) {
			try {
				float f = (float) BiomeGenBase.getBiome(i[i1]).getIntRainfall() / 65536f;

				if (f > 1f) {
					f = 1f;
				}

				listToReuse[i1] = f;
			} catch (Throwable throwIt) {
				CrashReport crash = CrashReport.makeCrashReport(throwIt, "Invalid biome id!");
				CrashReportCategory cat = crash.makeCategory("DownfallBlock");

				cat.addCrashSection("biome id", Integer.valueOf(i1));
				cat.addCrashSection("downfalls[] size", Integer.valueOf(listToReuse.length));
				cat.addCrashSection("x", Integer.valueOf(x));
				cat.addCrashSection("z", Integer.valueOf(z));
				cat.addCrashSection("w", Integer.valueOf(w));
				cat.addCrashSection("l", Integer.valueOf(l));

				throw new ReportedException(crash);
			}
		}

		return listToReuse;
	}

	public float getTemeratureAtHeight(float i, int j) {
		return i;
	}

	// par2 = x, par3 = y, par4 = w, par5 = l
	public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] biomes, int x, int y, int w, int l) {
		IntCache.resetIntCache();

		if (biomes == null || biomes.length < w * l) {
			biomes = new BiomeGenBase[w * l];
		}

		int[] i = this.genBiomes.getInts(x, y, w, l);

		try {
			for (int i1 = 0; i1 < w * l; i1++) {
				biomes[i1] = BiomeGenBase.getBiome(i[i1]);
			}

			return biomes;
		} catch (Throwable throwIt) {
			CrashReport crash = CrashReport.makeCrashReport(throwIt, "Invalid biome id");
			CrashReportCategory cat = crash.makeCategory("RawBiomeBlock");

			cat.addCrashSection("biomes[] size", Integer.valueOf(biomes.length));
			cat.addCrashSection("x", Integer.valueOf(x));
			cat.addCrashSection("y", Integer.valueOf(y));
			cat.addCrashSection("w", Integer.valueOf(w));
			cat.addCrashSection("l", Integer.valueOf(l));

			throw new ReportedException(crash);
		}
	}

	public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] biomes, int x, int z, int w, int d) {
		return this.getBiomeGenAt(biomes, x, z, w, d, true);
	}

	public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] biomes, int x, int y, int w, int l, boolean flag) {
		IntCache.resetIntCache();

		if (biomes == null || biomes.length < w * l) {
			biomes = new BiomeGenBase[w * l];
		}

		if (flag && w == 16 && l == 16 && (x & 15) == 0 && (y & 15) == 0) {
			BiomeGenBase[] biomeGen = this.biomeCache.getCachedBiomes(x, y);
			System.arraycopy(biomeGen, 0, biomes, 0, w * l);

			return biomes;
		} else {
			int[] i = this.biomeIndex.getInts(x, y, w, l);

			for (int i1 = 0; i1 < w * l; i1++) {
				biomes[i1] = BiomeGenBase.getBiome(i[i1]);
			}

			return biomes;
		}
	}

	public boolean areBiomesVisible(int x, int y, int z, List list) {
		IntCache.resetIntCache();

		int l = x - z >> 2;
		int i1 = y - z >> 2;
		int j1 = x + z >> 2;
		int k1 = y + z >> 2;
		int l1 = j1 - l + 1;
		int i2 = k1 - i1 + 1;
		int[] i = this.genBiomes.getInts(l, i1, l1, i2);

		try {
			for (int j2 = 0; j2 < l1 * i2; j2++) {
				BiomeGenBase biomeGen = BiomeGenBase.getBiome(i[j2]);

				if (!list.contains(biomeGen)) {
					return false;
				}
			}

			return true;
		} catch (Throwable throwIt) {
			CrashReport crash = CrashReport.makeCrashReport(throwIt, "Invalid Biome id");
			CrashReportCategory cat = crash.makeCategory("Layer");

			cat.addCrashSection("Layer", this.genBiomes.toString());
			cat.addCrashSection("x", Integer.valueOf(x));
			cat.addCrashSection("z", Integer.valueOf(y));
			cat.addCrashSection("radius", Integer.valueOf(z));
			cat.addCrashSection("allowed", list);

			throw new ReportedException(crash);
		}
	}

	public ChunkPosition findBiomePosition(int x, int y, int z, List list, Random rand) {
		IntCache.resetIntCache();

		int l = x - z >> 2;
		int i1 = y - z >> 2;
		int j1 = x + z >> 2;
		int k1 = y + z >> 2;
		int l1 = j1 - l + 1;
		int i2 = k1 - i1 + 1;
		int[] i = this.genBiomes.getInts(l, i1, l1, i2);
		ChunkPosition cpos = null;
		int j2 = 0;

		for (int k2 = 0; k2 < l1 * i2; k2++) {
			int l2 = l + k2 % l1 << 2;
			int i3 = i1 + k2 / l1 << 2;
			BiomeGenBase biomeGen = BiomeGenBase.getBiome(i[k2]);

			if (list.contains(biomeGen) && (cpos == null || rand.nextInt(j2 + 1) == 0)) {
				cpos = new ChunkPosition(l2, 0, i3);
				++j2;
			}
		}

		return cpos;
	}

	public void cleanupAche() {
		this.biomeCache.cleanupCache();
	}
}