package com.mce.handlers.dimensions;

import com.mce.common.mod_IDT;
import com.mce.handlers.dimensions.chunks.managers.WorldChunkManagerFrost;
import com.mce.handlers.dimensions.renders.CloudRender;
import com.mce.handlers.dimensions.renders.frost.SkyRenderFrost;
import com.mce.handlers.dimensions.renders.frost.WeatherRenderFrost;

import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderFrost extends WorldProvider {
	public WorldType terType;
	public String options;
	public World worldObj;
	public int dimensionId;
	public WorldChunkManager worldChunkMgr;
	public boolean hasNoSky;
	public float[] lightBrightnessTable = new float[16];

	public final void registerTheWorld(World world) {
		this.worldObj = world;
		this.terType = world.getWorldInfo().getTerrainType();
		this.options = world.getWorldInfo().getGeneratorOptions();
		this.registerWorldChunkManager();
		this.generateLightBrightnessTable();
	}

	public void registerWorldChunkManager() {
		this.worldChunkMgr = this.getChunkManager(worldObj);
		this.dimensionId = mod_IDT.frostDimId;
	}

	public IChunkProvider createChunkGenerator() {
		return this.getChunkGenerator(worldObj, options);
	}

	public static WorldProvider getProviderForDimension(int id) {
		return DimensionManager.createProviderFor(mod_IDT.frostDimId);
	}

	public boolean canCoordinateBeSpawn(int x, int z) {
		return this.worldObj.getTopBlock(x, z) == mod_IDT.FrostGrass
				|| this.worldObj.getTopBlock(x, z) == mod_IDT.FrostDirt;
	}

	public IChunkProvider getChunkGenerator(World world, String options) {
		return new ChunkProviderGenerate(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled());
	}

	public WorldChunkManager getChunkManager(World world) {
		return new WorldChunkManagerFrost(world);
	}

	public ChunkCoordinates getRandomizedSpawnPoint() {
		ChunkCoordinates chunkcoordinates = new ChunkCoordinates(this.worldObj.getSpawnPoint());

		boolean isAdventure = worldObj.getWorldInfo().getGameType() == GameType.ADVENTURE;
		int spawnFuzz = terType.getSpawnFuzz();
		int spawnFuzzHalf = spawnFuzz / 2;

		if (!hasNoSky && !isAdventure && net.minecraftforge.common.ForgeModContainer.defaultHasSpawnFuzz) {
			chunkcoordinates.posX += this.worldObj.rand.nextInt(spawnFuzz) - spawnFuzzHalf;
			chunkcoordinates.posZ += this.worldObj.rand.nextInt(spawnFuzz) - spawnFuzzHalf;
			chunkcoordinates.posY = this.worldObj.getTopSolidOrLiquidBlock(chunkcoordinates.posX,
					chunkcoordinates.posZ);
		}

		return chunkcoordinates;
	}

	public BiomeGenBase getBiomeGenForCoords(int x, int z) {
		return worldObj.getBiomeGenForCoordsBody(x, z);
	}

	public String getDimensionName() {
		return "Frosty the Snowman";
	}

	public String getSaveFolder() {
		return "IDT-DIM" + mod_IDT.frostDimId;
	}

	public boolean renderStars() {
		return false;
	}

	public float getStarBrightness(World world, float f) {
		return 0f;
	}

	public double getMovementFactor() {
		return 2;
	}

	public boolean renderClouds() {
		return true;
	}

	public boolean renderVoidFog() {
		return false;
	}

	public boolean renderEndSky() {
		return false;
	}

	public Vec3 getSkyColor(Entity entity, float ticks) {
		return worldObj.getSkyColorBody(entity, ticks);
	}

	public boolean isSkyColored() {
		return true;
	}

	public boolean canRespawnHere() {
		return true;
	}

	public boolean isSurfaceWorld() {
		return false;
	}

	public int setHeight() {
		return 512;
	}

	public float getCloudHeight() {
		return this.terType.getCloudHeight();
	}

	public ChunkCoordinates getEntrancePortalPosition() {
		// eturn new ChunkCoordinates(50, 5, 0);
		return null;
	}

	public void generateLightBrightnessTable() {
		float f = 0f;

		for (int i = 0; i <= 15; i++) {
			float f1 = 1f - (float) i / 15f;
			this.lightBrightnessTable[i] = (1f - f1) / (f1 * 3f + 1f) * (1f - f) + f;
		}
	}

	public String getWelcomeMessage() {
		return "Bundle up so you don't get frostbyte!";
	}

	public String getDepartMessage() {
		return "Thawing out body..";
	}

	public IRenderHandler getSkyRender() {
		return new SkyRenderFrost();
	}

	public IRenderHandler getCloudRender() {
		return new CloudRender();
	}

	public IRenderHandler getWeatherRenderer() {
		return new WeatherRenderFrost();
	}

	public Vec3 drawClouds(float ticks) {
		return worldObj.drawCloudsBody(ticks);
	}
}
