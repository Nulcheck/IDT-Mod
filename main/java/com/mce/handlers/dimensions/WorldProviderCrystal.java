package com.mce.handlers.dimensions;

import com.mce.common.mod_IDT;
import com.mce.handlers.dimensions.chunks.ChunkProviderCrystal;
import com.mce.handlers.dimensions.chunks.managers.WorldChunkManagerCrystal;
import com.mce.handlers.dimensions.renders.SkyRenderCrystal;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderCrystal extends WorldProvider {
	IRenderHandler skyRenderer;

	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderCrystal(this.worldObj, this.worldObj.getSeed(), true);
	}

	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerCrystal(this.worldObj.getSeed(), terrainType);
		this.dimensionId = mod_IDT.crystalDimId;
	}

	public static WorldProvider getProviderForDimension(int id) {
		return DimensionManager.createProviderFor(mod_IDT.crystalDimId);
	}

	public boolean canCoordinateBeSpawn(int x, int z) {
		return this.worldObj.getTopBlock(x, z) == mod_IDT.CrystalGlass
				|| this.worldObj.getTopBlock(x, z) == mod_IDT.CrystalRock;
	}

	public ChunkCoordinates getRandomizedSpawnPoint() {
		ChunkCoordinates chunkcoordinates = new ChunkCoordinates(this.worldObj.getSpawnPoint());

		boolean isAdventure = worldObj.getWorldInfo().getGameType() == GameType.ADVENTURE;
		int spawnFuzz = terrainType.getSpawnFuzz();
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

	@SideOnly(Side.CLIENT)
	public String getDimensionName() {
		return "Crystalline";
	}

	public String getSaveFolder() {
		return "IDT-DIM" + mod_IDT.crystalDimId;
	}

	@SideOnly(Side.CLIENT)
	public boolean renderStars() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public double getMovementFactor() {
		return 4;
	}

	@SideOnly(Side.CLIENT)
	public float getStarBrightness(World world, float f) {
		return .3f;
	}

	@SideOnly(Side.CLIENT)
	public boolean renderClouds() {
		return false;
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
	public Vec3 getSkyColor(Entity entity, float ticks) {
		return worldObj.getSkyColorBody(entity, ticks);
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
		return true;
	}

	@SideOnly(Side.CLIENT)
	public ChunkCoordinates getEntrancePortalPosition() {
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

	@SideOnly(Side.CLIENT)
	public String getWelcomeMessage() {
		return "Don't step on any crystals!";
	}

	@SideOnly(Side.CLIENT)
	public String getDepartMessage() {
		return "You didn't steal any crystals, did you?";
	}

	@SideOnly(Side.CLIENT)
	public IRenderHandler getSkyRender() {
		return new SkyRenderCrystal();
	}

	@SideOnly(Side.CLIENT)
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
