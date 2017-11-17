package com.mce.handlers.dimensions;

import com.mce.common.mod_IDT;
import com.mce.handlers.dimensions.chunks.ChunkProviderFrost;
import com.mce.handlers.dimensions.chunks.managers.WorldChunkManagerFrost;
import com.mce.handlers.dimensions.renders.CloudRender;
import com.mce.handlers.dimensions.renders.SkyRenderFrost;
import com.mce.handlers.dimensions.renders.WeatherRenderFrost;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderFrost extends WorldProvider {
	IRenderHandler skyRenderer;
	IRenderHandler cloudRenderer;
	IRenderHandler weatherRenderer;
	
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderFrost(this.worldObj, this.worldObj.getSeed(), true);
	}
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerFrost(this.worldObj.getSeed(), terrainType);
		this.dimensionId = mod_IDT.frostDimId;
	}

	public static WorldProvider getProviderForDimension(int id) {
		return DimensionManager.createProviderFor(mod_IDT.frostDimId);
	}

	public boolean canCoordinateBeSpawn(int x, int z) {
		return this.worldObj.getTopBlock(x, z) == mod_IDT.FrostGrass
				|| this.worldObj.getTopBlock(x, z) == mod_IDT.FrostDirt;
	}

	public ChunkCoordinates getRandomizedSpawnPoint() {
		ChunkCoordinates coord = new ChunkCoordinates(this.worldObj.getSpawnPoint());

		boolean isAdventure = worldObj.getWorldInfo().getGameType() == GameType.ADVENTURE;
		int spawnFuzz = terrainType.getSpawnFuzz();
		int spawnFuzzHalf = spawnFuzz / 2;

		if (!hasNoSky && !isAdventure && net.minecraftforge.common.ForgeModContainer.defaultHasSpawnFuzz) {
			coord.posX += this.worldObj.rand.nextInt(spawnFuzz) - spawnFuzzHalf;
			coord.posZ += this.worldObj.rand.nextInt(spawnFuzz) - spawnFuzzHalf;
			coord.posY = this.worldObj.getTopSolidOrLiquidBlock(coord.posX,
					coord.posZ);
		}

		return coord;
	}

	public BiomeGenBase getBiomeGenForCoords(int x, int z) {
		return worldObj.getBiomeGenForCoordsBody(x, z);
	}

	@Override
	public String getDimensionName() {
		return "Frosty the Snowman";
	}

	@Override
	public String getSaveFolder() {
		return "IDT-DIM" + mod_IDT.frostDimId;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean renderStars() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public float getStarBrightness(World world, float f) {
		return 0f;
	}

	@SideOnly(Side.CLIENT)
	public double getMovementFactor() {
		return 2;
	}

	@SideOnly(Side.CLIENT)
	public boolean renderClouds() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public boolean renderVoidFog() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean renderEndSky() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean isSkyColored() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public boolean canRespawnHere() {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public boolean isSurfaceWorld() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int setHeight() {
		return 512;
	}

	@SideOnly(Side.CLIENT)
	public float getCloudHeight() {
		return this.terrainType.getCloudHeight();
	}

	@SideOnly(Side.CLIENT)
	public ChunkCoordinates getEntrancePortalPosition() {
		// return new ChunkCoordinates(50, 5, 0);
		return null;
	}

	@SideOnly(Side.CLIENT)
	public void generateLightBrightnessTable() {
		float f = 0f;

		for (int i = 0; i <= 15; i++) {
			float f1 = 1f - (float) i / 15f;
			this.lightBrightnessTable[i] = (1f - f1) / (f1 * 3f + 1f) * (1f - f) + f;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getWelcomeMessage() {
		return "Bundle up so you don't get frostbyte!";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getDepartMessage() {
		return "Thawing out body..";
	}

	@SideOnly(Side.CLIENT)
	public IRenderHandler getSkyRenderer() {
		return new SkyRenderFrost();
	}

	@SideOnly(Side.CLIENT)
	public IRenderHandler getCloudRenderer() {
		return new CloudRender();
	}

	@SideOnly(Side.CLIENT)
	public IRenderHandler getWeatherRenderer() {
		return new WeatherRenderFrost();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Vec3 drawClouds(float ticks) {
		return worldObj.drawCloudsBody(ticks);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Vec3 getSkyColor(Entity entity, float ticks) {
		return worldObj.getSkyColorBody(entity, ticks);
	}
}
