package com.mce.handlers.dimensions;

import com.mce.common.mod_IDT;
import com.mce.handlers.dimensions.chunks.ChunkProviderFrost;
import com.mce.handlers.dimensions.chunks.managers.WorldChunkManagerFrost;
import com.mce.handlers.dimensions.renders.CloudRender;
import com.mce.handlers.dimensions.renders.frost.SkyRenderFrost;
import com.mce.handlers.dimensions.renders.frost.WeatherRenderFrost;

import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderFrost extends WorldProvider {
	private IRenderHandler skyRenderer = null;
	private IRenderHandler cloudRenderer = null;
	private IRenderHandler weatherRenderer = null;

	public final void registerTheWorld(World world) {
		this.registerWorldChunkManager();
		this.generateLightBrightnessTable();
	}

	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderFrost(this.worldObj, this.worldObj.getSeed(), true);
	}
	
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerFrost(this.worldObj);
		this.dimensionId = mod_IDT.frostDimId;
	}

	public static WorldProvider getProviderForDimension(int id) {
		return DimensionManager.createProviderFor(mod_IDT.frostDimId);
	}

	public boolean canCoordinateBeSpawn(int x, int z) {
		return this.worldObj.getTopBlock(x, z) == mod_IDT.FrostGrass
				|| this.worldObj.getTopBlock(x, z) == mod_IDT.FrostDirt;
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
		return true;
	}

	public int setHeight() {
		return 512;
	}

	public float getCloudHeight() {
		return this.terrainType.getCloudHeight();
	}

	public ChunkCoordinates getEntrancePortalPosition() {
		return new ChunkCoordinates(50, 5, 0);
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

	public void setSkyRender(IRenderHandler render) {
		this.skyRenderer = new SkyRenderFrost();
	}

	public void setCloudRender(IRenderHandler render) {
		this.cloudRenderer = new CloudRender();
	}

	public void setWeatherRenderer(IRenderHandler render) {
		this.weatherRenderer = new WeatherRenderFrost();
	}

	public Vec3 drawClouds(float ticks) {
		return super.drawClouds(ticks);
	}
}
