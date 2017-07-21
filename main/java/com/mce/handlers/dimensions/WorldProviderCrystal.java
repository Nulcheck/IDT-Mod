package com.mce.handlers.dimensions;

import com.mce.common.mod_IDT;
import com.mce.handlers.dimensions.chunks.ChunkProviderCrystal;
import com.mce.handlers.dimensions.renders.CloudRender;
import com.mce.handlers.dimensions.renders.frost.SkyRenderFrost;
import com.mce.handlers.dimensions.renders.frost.WeatherRenderFrost;
import com.mce.handlers.registers.BiomeRegistry;

import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderCrystal extends WorldProvider {
	public IChunkProvider createChunkGen() {
		return new ChunkProviderCrystal(this.worldObj, this.worldObj.getSeed(), true);
	}

	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeRegistry.CrystalBiome, 1.2f);
		this.dimensionId = mod_IDT.crystalDimId;
	}

	public static WorldProvider getProviderForDimension(int id) {
		return DimensionManager.createProviderFor(mod_IDT.crystalDimId);
	}

	public String getDimensionName() {
		return "Crystalline";
	}

	// The folder in the world save.
	public String getSaveFolder() {
		return "IDT-DIM" + mod_IDT.crystalDimId;
	}

	public boolean renderStars() {
		return false;
	}

	// Player speeds
	public double getMovementFactor() {
		return .01;
	}

	// How bright it is at night?
	public float getStarBrightness(World world, float f) {
		return .3f;
	}

	public boolean renderClouds() {
		return true;
	}

	// This is so annoying, so i'm not going to do it.
	public boolean renderVoidFog() {
		return false;
	}

	// Render that end skybox over the normal one
	public boolean renderEndSky() {
		return false;
	}

	public float setSunSize() {
		return .5f;
	}

	public float setMoonSize() {
		return 2f;
	}

	// Sky color..
	public Vec3 getSkyColor(Entity entity, float ticks) {
		return worldObj.getSkyColorBody(entity, ticks);
	}

	public boolean isSkyColored() {
		return true;
	}

	// If dead, can player respawn in this dimension?
	public boolean canRespawnHere() {
		return true;
	}

	// Surface or underworld like nether?
	public boolean isSurfaceWorld() {
		return true;
	}

	public float getCloudHeight() {
		return this.terrainType.getCloudHeight();
	}

	public ChunkCoordinates getEntrancePortalPosition() {
		return new ChunkCoordinates(50, 5, 0);
	}

	// General lightness of the dimension
	public void generateLightBrightnessTable() {
		float f = 0f;

		for (int i = 0; i <= 15; i++) {
			float f1 = 1f - (float) i / 15f;
			this.lightBrightnessTable[i] = (1f - f1) / (f1 * 3f + 1f) * (1f - f) + f;
		}
	}

	public String getWelcomeMessage() {
		return "Don't step on any crystals!";
	}

	public String getDepartMessage() {
		return "You didn't steal any crystals, did you?";
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
		return super.drawClouds(ticks);
	}

	public Vec3 getFogColor(float i, float j) {
		float f2 = MathHelper.cos(i * (float) Math.PI * 2f) * 2f + .5f;

		if (f2 < 0f) {
			f2 = 0f;
		}

		if (f2 > 1f) {
			f2 = 1f;
		}

		float f3 = .7529412f;
		float f4 = .84705883f;
		float f5 = 1f;
		f3 *= f2 * .94f + .06f;
		f4 *= f2 * .94f + .06f;
		f5 *= f2 * .91 + .09f;
		return Vec3.createVectorHelper((double) f3, (double) f4, (double) f5);
	}
}
