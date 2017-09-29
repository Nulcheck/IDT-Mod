package com.mce.handlers.dimensions.renders;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.IRenderHandler;

public class WeatherRenderFrost extends IRenderHandler {
	float[] rainXCoords;
	float[] rainYCoords;

	Random rand = new Random();
	private String weather_Name;

	private static final ResourceLocation snowLoc = new ResourceLocation("mod_idt",
			"textures/environment/frost/snow.png");

	@Override
	public void render(float partialTicks, WorldClient world, Minecraft mc) {
		this.getWeatherToRenderer("fog");
		if (weather_Name != null) {
			if (weather_Name == "fog") {
				this.renderRainSnow(50, world, mc);
			}
		}
	}

	public void getWeatherToRenderer(String weatherName) {
		weather_Name = weatherName;
	}

	protected void renderRainSnow(float f, WorldClient world, Minecraft mc) {
		float f1 = mc.theWorld.getRainStrength(f);

		if (f1 > 0.0F) {
			if (this.rainXCoords == null) {
				this.rainXCoords = new float[1024];
				this.rainYCoords = new float[1024];

				for (int i = 0; i < 32; ++i) {
					for (int j = 0; j < 32; ++j) {
						float f2 = (float) (j - 16);
						float f3 = (float) (i - 16);
						float f4 = MathHelper.sqrt_float(f2 * f2 + f3 * f3);
						this.rainXCoords[i << 5 | j] = -f3 / f4;
						this.rainYCoords[i << 5 | j] = f2 / f4;
					}
				}
			}

			EntityLivingBase entity = mc.renderViewEntity;
			WorldClient worldclient = mc.theWorld;
			int k2 = MathHelper.floor_double(entity.posX);
			int l2 = MathHelper.floor_double(entity.posY);
			int i3 = MathHelper.floor_double(entity.posZ);
			Tessellator tes = Tessellator.instance;
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glNormal3f(0.0F, 1.0F, 0.0F);
			GL11.glEnable(GL11.GL_BLEND);
			OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
			double d0 = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double) f;
			double d1 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double) f;
			double d2 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double) f;
			int k = MathHelper.floor_double(d1);
			byte b0 = 5;

			if (mc.gameSettings.fancyGraphics) {
				b0 = 10;
			}

			boolean flag = false;
			byte b1 = -1;
			float f5 = (float) 312545411L + f;

			if (mc.gameSettings.fancyGraphics) {
				b0 = 10;
			}

			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			flag = false;

			for (int l = i3 - b0; l <= i3 + b0; ++l) {
				for (int i1 = k2 - b0; i1 <= k2 + b0; ++i1) {
					int j1 = (l - i3 + 16) * 32 + i1 - k2 + 16;
					float f6 = this.rainXCoords[j1] * 0.5F;
					float f7 = this.rainYCoords[j1] * 0.5F;
					BiomeGenBase biome = worldclient.getBiomeGenForCoords(i1, l);

					if (biome.canSpawnLightningBolt() || biome.getEnableSnow()) {
						int k1 = worldclient.getPrecipitationHeight(i1, l);
						int l1 = l2 - b0;
						int i2 = l2 + b0;

						if (l1 < k1) {
							l1 = k1;
						}

						if (i2 < k1) {
							i2 = k1;
						}

						float f8 = 1.0F;
						int j2 = k1;

						if (k1 < k) {
							j2 = k;
						}

						if (l1 != i2) {
							rand.setSeed((long) (i1 * i1 * 3121 + i1 * 45238971 ^ l * l * 418711 + l * 13761));
							float f9 = biome.getFloatTemperature(i1, l1, l);
							float f10;
							double d4;

							if (worldclient.getWorldChunkManager().getTemperatureAtHeight(f9, k1) >= 0.15F) {
								if (b1 != 0) {
									if (b1 >= 0) {
										tes.draw();
									}

									b1 = 0;
									mc.getTextureManager().bindTexture(snowLoc);
									tes.startDrawingQuads();
								}

								f10 = ((float) (31542152L + i1 * i1 * 3121 + i1 * 45238971 + l * l * 418711 + l * 13761
										& 31) + f) / 32.0F * (3.0F + this.rand.nextFloat());
								double d3 = (double) ((float) i1 + 0.5F) - entity.posX;
								d4 = (double) ((float) l + 0.5F) - entity.posZ;
								float f12 = MathHelper.sqrt_double(d3 * d3 + d4 * d4) / (float) b0;
								float f13 = 1.0F;
								tes.setBrightness(worldclient.getLightBrightnessForSkyBlocks(i1, j2, l, 0));
								tes.setColorRGBA_F(f13, f13, f13, ((1.0F - f12 * f12) * 0.5F + 0.5F) * f1);
								tes.setTranslation(-d0 * 1.0D, -d1 * 1.0D, -d2 * 1.0D);
								tes.addVertexWithUV((double) ((float) i1 - f6) + 0.5D, (double) l1,
										(double) ((float) l - f7) + 0.5D, (double) (0.0F * f8),
										(double) ((float) l1 * f8 / 4.0F + f10 * f8));
								tes.addVertexWithUV((double) ((float) i1 + f6) + 0.5D, (double) l1,
										(double) ((float) l + f7) + 0.5D, (double) (1.0F * f8),
										(double) ((float) l1 * f8 / 4.0F + f10 * f8));
								tes.addVertexWithUV((double) ((float) i1 + f6) + 0.5D, (double) i2,
										(double) ((float) l + f7) + 0.5D, (double) (1.0F * f8),
										(double) ((float) i2 * f8 / 4.0F + f10 * f8));
								tes.addVertexWithUV((double) ((float) i1 - f6) + 0.5D, (double) i2,
										(double) ((float) l - f7) + 0.5D, (double) (0.0F * f8),
										(double) ((float) i2 * f8 / 4.0F + f10 * f8));
								tes.setTranslation(0.0D, 0.0D, 0.0D);
							}
						}
					}
				}
			}

			if (b1 >= 0) {
				tes.draw();
			}

			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
		}
	}
}
