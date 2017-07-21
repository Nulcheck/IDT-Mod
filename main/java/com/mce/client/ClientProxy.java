package com.mce.client;

import java.util.Random;

import com.mce.client.render.bombs.ClientRenderEB;
import com.mce.client.render.bombs.ClientRenderNB;
import com.mce.client.render.bombs.ClientRenderUB;
import com.mce.client.render.bombs.ClientRenderUN;
import com.mce.client.render.chest.ClientRenderAcaciaChest;
import com.mce.client.render.chest.ClientRenderBirchChest;
import com.mce.client.render.chest.ClientRenderDarkMatterChest;
import com.mce.client.render.chest.ClientRenderDarkOakChest;
import com.mce.client.render.chest.ClientRenderEbonyChest;
import com.mce.client.render.chest.ClientRenderGelidChest;
import com.mce.client.render.chest.ClientRenderJungleChest;
import com.mce.client.render.chest.ClientRenderSilkwoodChest;
import com.mce.client.render.chest.ClientRenderSpruceChest;
import com.mce.client.render.chest.ClientRenderWillowChest;
import com.mce.client.render.itemrender.ItemRenderAdvancedHealer;
import com.mce.client.render.itemrender.ItemRenderECR;
import com.mce.client.render.itemrender.ItemRenderNCR;
import com.mce.client.render.itemrender.ItemRenderSR;
import com.mce.client.render.itemrender.ItemRenderTF;
import com.mce.client.render.itemrender.ItemRenderUCR;
import com.mce.client.render.itemrender.bombs.ItemRenderDM;
import com.mce.client.render.itemrender.bombs.ItemRenderEB;
import com.mce.client.render.itemrender.bombs.ItemRenderNB;
import com.mce.client.render.itemrender.bombs.ItemRenderUB;
import com.mce.client.render.itemrender.bombs.ItemRenderUN;
import com.mce.client.render.itemrender.chest.ItemAcaciaChestRender;
import com.mce.client.render.itemrender.chest.ItemBirchChestRender;
import com.mce.client.render.itemrender.chest.ItemDarkMatterChestRender;
import com.mce.client.render.itemrender.chest.ItemDarkOakChestRender;
import com.mce.client.render.itemrender.chest.ItemEbonyChestRender;
import com.mce.client.render.itemrender.chest.ItemGelidChestRender;
import com.mce.client.render.itemrender.chest.ItemJungleChestRender;
import com.mce.client.render.itemrender.chest.ItemSilkwoodChestRender;
import com.mce.client.render.itemrender.chest.ItemSpruceChestRender;
import com.mce.client.render.itemrender.chest.ItemWillowChestRender;
import com.mce.client.render.itemrender.tech.ItemRenderBFE;
import com.mce.client.render.itemrender.tech.ItemRenderMagnetizer;
import com.mce.client.render.itemrender.tech.ItemRenderMatterCondenser;
import com.mce.client.render.itemrender.tech.ItemRenderTC;
import com.mce.client.render.itemrender.tech.ItemRenderWelder;
import com.mce.client.render.itemrender.tech.ItemRenderZNG;
import com.mce.client.render.wall_parts.ItemRenderAcacia;
import com.mce.client.render.wall_parts.ItemRenderBirch;
import com.mce.client.render.wall_parts.ItemRenderBrick;
import com.mce.client.render.wall_parts.ItemRenderCement;
import com.mce.client.render.wall_parts.ItemRenderCementBrick;
import com.mce.client.render.wall_parts.ItemRenderCoal;
import com.mce.client.render.wall_parts.ItemRenderCobblestone;
import com.mce.client.render.wall_parts.ItemRenderDarkOak;
import com.mce.client.render.wall_parts.ItemRenderEbony;
import com.mce.client.render.wall_parts.ItemRenderGelid;
import com.mce.client.render.wall_parts.ItemRenderJungle;
import com.mce.client.render.wall_parts.ItemRenderMossyCobblestone;
import com.mce.client.render.wall_parts.ItemRenderNetherBrick;
import com.mce.client.render.wall_parts.ItemRenderOak;
import com.mce.client.render.wall_parts.ItemRenderObsidian;
import com.mce.client.render.wall_parts.ItemRenderQuartz;
import com.mce.client.render.wall_parts.ItemRenderSandstone;
import com.mce.client.render.wall_parts.ItemRenderSilkwood;
import com.mce.client.render.wall_parts.ItemRenderSnow;
import com.mce.client.render.wall_parts.ItemRenderSpruce;
import com.mce.client.render.wall_parts.ItemRenderStone;
import com.mce.client.render.wall_parts.ItemRenderStonebrick;
import com.mce.client.render.wall_parts.ItemRenderWillow;
import com.mce.common.CommonProxy;
import com.mce.common.mod_IDT;
import com.mce.entity.explosives.EntityEB;
import com.mce.entity.explosives.EntityNB;
import com.mce.entity.explosives.EntityUB;
import com.mce.entity.explosives.EntityUN;
import com.mce.entity.mobs.EntityIcePhantom;
import com.mce.entity.mobs.EntityIcyCreeper;
import com.mce.entity.tile.TEAH;
import com.mce.entity.tile.TileEntityECR;
import com.mce.entity.tile.TileEntityNCR;
import com.mce.entity.tile.TileEntitySBH;
import com.mce.entity.tile.TileEntitySR;
import com.mce.entity.tile.TileEntityTF;
import com.mce.entity.tile.TileEntityUCR;
import com.mce.entity.tile.TileEntityZimWire;
import com.mce.entity.tile.bombs.TileEntityDM;
import com.mce.entity.tile.bombs.TileEntityEB;
import com.mce.entity.tile.bombs.TileEntityNB;
import com.mce.entity.tile.bombs.TileEntityUB;
import com.mce.entity.tile.bombs.TileEntityUN;
import com.mce.entity.tile.chest.TileEntityAcaciaChest;
import com.mce.entity.tile.chest.TileEntityBirchChest;
import com.mce.entity.tile.chest.TileEntityDarkMatterChest;
import com.mce.entity.tile.chest.TileEntityDarkOakChest;
import com.mce.entity.tile.chest.TileEntityEbonyChest;
import com.mce.entity.tile.chest.TileEntityGelidChest;
import com.mce.entity.tile.chest.TileEntityJungleChest;
import com.mce.entity.tile.chest.TileEntitySilkwoodChest;
import com.mce.entity.tile.chest.TileEntitySpruceChest;
import com.mce.entity.tile.chest.TileEntityWillowChest;
import com.mce.entity.tile.tech.TileEntityBFE;
import com.mce.entity.tile.tech.TileEntityMagnetizer;
import com.mce.entity.tile.tech.TileEntityMatterCondenser;
import com.mce.entity.tile.tech.TileEntityTankCompressor;
import com.mce.entity.tile.tech.TileEntityWelder;
import com.mce.entity.tile.tech.TileEntityZNG;
import com.mce.entity.tile.wall_parts.TileEntityWPAcacia;
import com.mce.entity.tile.wall_parts.TileEntityWPBirch;
import com.mce.entity.tile.wall_parts.TileEntityWPBrick;
import com.mce.entity.tile.wall_parts.TileEntityWPCement;
import com.mce.entity.tile.wall_parts.TileEntityWPCementBrick;
import com.mce.entity.tile.wall_parts.TileEntityWPCoal;
import com.mce.entity.tile.wall_parts.TileEntityWPCobblestone;
import com.mce.entity.tile.wall_parts.TileEntityWPDarkOak;
import com.mce.entity.tile.wall_parts.TileEntityWPEbony;
import com.mce.entity.tile.wall_parts.TileEntityWPGelid;
import com.mce.entity.tile.wall_parts.TileEntityWPJungle;
import com.mce.entity.tile.wall_parts.TileEntityWPMossyCobblestone;
import com.mce.entity.tile.wall_parts.TileEntityWPNetherBrick;
import com.mce.entity.tile.wall_parts.TileEntityWPOak;
import com.mce.entity.tile.wall_parts.TileEntityWPObsidian;
import com.mce.entity.tile.wall_parts.TileEntityWPQuartz;
import com.mce.entity.tile.wall_parts.TileEntityWPSandstone;
import com.mce.entity.tile.wall_parts.TileEntityWPSilkwood;
import com.mce.entity.tile.wall_parts.TileEntityWPSnow;
import com.mce.entity.tile.wall_parts.TileEntityWPSpruce;
import com.mce.entity.tile.wall_parts.TileEntityWPStone;
import com.mce.entity.tile.wall_parts.TileEntityWPStonebrick;
import com.mce.entity.tile.wall_parts.TileEntityWPWillow;
import com.mce.handlers.PlayerRenderHandler;
import com.mce.models.mobs.IcePhantomModel;
import com.mce.models.mobs.ModCreeperModel;
import com.mce.render.RenderAdvancedHealer;
import com.mce.render.RenderECR;
import com.mce.render.RenderNCR;
import com.mce.render.RenderSBH;
import com.mce.render.RenderSR;
import com.mce.render.RenderTC;
import com.mce.render.RenderTF;
import com.mce.render.RenderUCR;
import com.mce.render.RenderZimWire;
import com.mce.render.bombs.RenderDM;
import com.mce.render.bombs.RenderEB;
import com.mce.render.bombs.RenderNB;
import com.mce.render.bombs.RenderUB;
import com.mce.render.bombs.RenderUN;
import com.mce.render.mobs.RenderIcePhantom;
import com.mce.render.mobs.RenderIcyCreeper;
import com.mce.render.tech.RenderBFE;
import com.mce.render.tech.RenderMagnetizer;
import com.mce.render.tech.RenderMatterCondenser;
import com.mce.render.tech.RenderWelder;
import com.mce.render.tech.RenderZNG;
import com.mce.render.wall_parts.RenderAcacia;
import com.mce.render.wall_parts.RenderBirch;
import com.mce.render.wall_parts.RenderBrick;
import com.mce.render.wall_parts.RenderCement;
import com.mce.render.wall_parts.RenderCementBrick;
import com.mce.render.wall_parts.RenderCoal;
import com.mce.render.wall_parts.RenderCobblestone;
import com.mce.render.wall_parts.RenderDarkOak;
import com.mce.render.wall_parts.RenderEbony;
import com.mce.render.wall_parts.RenderGelid;
import com.mce.render.wall_parts.RenderJungle;
import com.mce.render.wall_parts.RenderMossyCobblestone;
import com.mce.render.wall_parts.RenderNetherBrick;
import com.mce.render.wall_parts.RenderOak;
import com.mce.render.wall_parts.RenderObsidian;
import com.mce.render.wall_parts.RenderQuartz;
import com.mce.render.wall_parts.RenderSandstone;
import com.mce.render.wall_parts.RenderSilkwood;
import com.mce.render.wall_parts.RenderSnow;
import com.mce.render.wall_parts.RenderSpruce;
import com.mce.render.wall_parts.RenderStone;
import com.mce.render.wall_parts.RenderStonebrick;
import com.mce.render.wall_parts.RenderWillow;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
	public void registerRenders() {
		MinecraftForge.EVENT_BUS.register(new PlayerRenderHandler());

		// Armor
		RenderingRegistry.addNewArmourRendererPrefix("5");

		// Mobs
		RenderingRegistry.registerEntityRenderingHandler(EntityIcePhantom.class,
				new RenderIcePhantom(new IcePhantomModel(), 0));

		RenderingRegistry.registerEntityRenderingHandler(EntityIcyCreeper.class,
				new RenderIcyCreeper(new ModCreeperModel(), .5F));

		// Rendering for bombs
		RenderingRegistry.registerEntityRenderingHandler(EntityEB.class, new ClientRenderEB());
		RenderingRegistry.registerEntityRenderingHandler(EntityNB.class, new ClientRenderNB());
		RenderingRegistry.registerEntityRenderingHandler(EntityUB.class, new ClientRenderUB());
		RenderingRegistry.registerEntityRenderingHandler(EntityUN.class, new ClientRenderUN());

		// Other Blocks
		ClientRegistry.bindTileEntitySpecialRenderer(TEAH.class, new RenderAdvancedHealer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.AdvancedHealer),
				new ItemRenderAdvancedHealer());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityZimWire.class, new RenderZimWire());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTF.class, new RenderTF());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.TitaniumFrame), new ItemRenderTF());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityECR.class, new RenderECR());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.EinsteiniumCoreReactor),
				new ItemRenderECR());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNCR.class, new RenderNCR());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.NeptuniumCoreReactor),
				new ItemRenderNCR());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityUCR.class, new RenderUCR());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.UraniumCoreReactor),
				new ItemRenderUCR());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySR.class, new RenderSR());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.SuperReactor), new ItemRenderSR());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBFE.class, new RenderBFE());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.BioFuelExtractor), new ItemRenderBFE());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMatterCondenser.class, new RenderMatterCondenser());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.MatterCondenser),
				new ItemRenderMatterCondenser());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTankCompressor.class, new RenderTC());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.TankCompressor), new ItemRenderTC());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityZNG.class, new RenderZNG());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.ZNG), new ItemRenderZNG());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWelder.class, new RenderWelder());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.Welder), new ItemRenderWelder());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagnetizer.class, new RenderMagnetizer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.Magnetizer),
				new ItemRenderMagnetizer());

		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySBH.class, new RenderSBH());

		// Wall Parts
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPCement.class, new RenderCement());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.CementWallPart, new ItemRenderCement());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPCementBrick.class, new RenderCementBrick());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.CementBrickWallPart, new ItemRenderCementBrick());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPStone.class, new RenderStone());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.StoneWallPart, new ItemRenderStone());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPCobblestone.class, new RenderCobblestone());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.CobblestoneWallPart, new ItemRenderCobblestone());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPMossyCobblestone.class, new RenderMossyCobblestone());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.MossyCobblestoneWallPart, new ItemRenderMossyCobblestone());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPSandstone.class, new RenderSandstone());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.SandstoneWallPart, new ItemRenderSandstone());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPObsidian.class, new RenderObsidian());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.ObsidianWallPart, new ItemRenderObsidian());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPStonebrick.class, new RenderStonebrick());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.StonebrickWallPart, new ItemRenderStonebrick());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPBrick.class, new RenderBrick());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.BrickWallPart, new ItemRenderBrick());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPCoal.class, new RenderCoal());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.CoalWallPart, new ItemRenderCoal());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPSnow.class, new RenderSnow());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.SnowWallPart, new ItemRenderSnow());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPNetherBrick.class, new RenderNetherBrick());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.NetherBrickWallPart, new ItemRenderNetherBrick());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPQuartz.class, new RenderQuartz());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.QuartzWallPart, new ItemRenderQuartz());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPOak.class, new RenderOak());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.OakWallPart, new ItemRenderOak());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPBirch.class, new RenderBirch());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.BirchWallPart, new ItemRenderBirch());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPSpruce.class, new RenderSpruce());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.SpruceWallPart, new ItemRenderSpruce());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPJungle.class, new RenderJungle());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.JungleWallPart, new ItemRenderJungle());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPWillow.class, new RenderWillow());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.WillowWallPart, new ItemRenderWillow());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPEbony.class, new RenderEbony());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.EbonyWallPart, new ItemRenderEbony());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPSilkwood.class, new RenderSilkwood());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.SilkwoodWallPart, new ItemRenderSilkwood());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPAcacia.class, new RenderAcacia());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.AcaciaWallPart, new ItemRenderAcacia());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPDarkOak.class, new RenderDarkOak());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.DarkOakWallPart, new ItemRenderDarkOak());

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWPGelid.class, new RenderGelid());
		MinecraftForgeClient.registerItemRenderer(mod_IDT.GelidWallPart, new ItemRenderGelid());

		// Bombs Client
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEB.class, new RenderEB());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityUB.class, new RenderUB());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNB.class, new RenderNB());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityUN.class, new RenderUN());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDM.class, new RenderDM());

		// Bombs Item
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.EinsteiniumBomb), new ItemRenderEB());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.UraniumBomb), new ItemRenderUB());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.NeptuniumBomb), new ItemRenderNB());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.UltimateNuker), new ItemRenderUN());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.DarkMatterBomb), new ItemRenderDM());

		// Other
		// Chests
		// Birch
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBirchChest.class, new ClientRenderBirchChest());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.BirchChest),
				new ItemBirchChestRender());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.BirchTrapChest),
				new ItemBirchChestRender());

		// Spruce
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpruceChest.class, new ClientRenderSpruceChest());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.SpruceChest),
				new ItemSpruceChestRender());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.SpruceTrapChest),
				new ItemSpruceChestRender());

		// Jungle
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJungleChest.class, new ClientRenderJungleChest());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.JungleChest),
				new ItemJungleChestRender());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.JungleTrapChest),
				new ItemJungleChestRender());

		// Willow
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWillowChest.class, new ClientRenderWillowChest());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.WillowChest),
				new ItemWillowChestRender());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.WillowTrapChest),
				new ItemWillowChestRender());

		// Ebony
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEbonyChest.class, new ClientRenderEbonyChest());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.EbonyChest),
				new ItemEbonyChestRender());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.EbonyTrapChest),
				new ItemEbonyChestRender());

		// Dark Matter
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDarkMatterChest.class,
				new ClientRenderDarkMatterChest());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.DarkMatterChest),
				new ItemDarkMatterChestRender());

		// Silkwood
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySilkwoodChest.class, new ClientRenderSilkwoodChest());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.SilkwoodChest),
				new ItemSilkwoodChestRender());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.SilkwoodTrapChest),
				new ItemSilkwoodChestRender());

		// Acacia
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAcaciaChest.class, new ClientRenderAcaciaChest());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.AcaciaChest),
				new ItemAcaciaChestRender());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.AcaciaTrapChest),
				new ItemAcaciaChestRender());

		// Dark Oak
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDarkOakChest.class, new ClientRenderDarkOakChest());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.DarkOakChest),
				new ItemDarkOakChestRender());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.DarkOakTrapChest),
				new ItemDarkOakChestRender());

		// Dark Oak
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGelidChest.class, new ClientRenderGelidChest());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.GelidChest),
				new ItemGelidChestRender());

		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(mod_IDT.GelidTrapChest),
				new ItemGelidChestRender());
	}

	public void spawnParticle(World world, double posX, double posY, double posZ, String type) {
		Minecraft minecraft = Minecraft.getMinecraft();
		Random rand = world.rand;

		if (minecraft != null && minecraft.renderViewEntity != null && minecraft.effectRenderer != null) {
			int particleSetting = minecraft.gameSettings.particleSetting;

			if (particleSetting == 1 && world.rand.nextInt(3) == 0) {
				particleSetting = 2;
			}

			double entityX = minecraft.renderViewEntity.posX - posX;
			double entityY = minecraft.renderViewEntity.posY - posY;
			double entityZ = minecraft.renderViewEntity.posZ - posZ;

			if (entityX * entityX + entityY * entityY + entityZ * entityZ > 16.0D * 16.0D) {
				return;
			} else if (particleSetting > 1) {
				return;
			} else {
				EntityFX particle = null;

				if (type.equals("iceFx")) {
					particle = new EntityIceFX(world, posX + rand.nextDouble() - .5d, posY + rand.nextDouble() - .5d,
							posZ + rand.nextDouble() - .5d, 0d, 0d, 0d);
				}

				else if (type.equals("darkMatterFx")) {
					particle = new EntityDarkMatterFX(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d);
				}

				else if (type.equals("einsteiniumFx")) {
					particle = new EntityEinsteiniumFX(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d);
				}

				else if (type.equals("neptuniumFx")) {
					particle = new EntityNeptuniumFX(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d);
				}

				else if (type.equals("uraniumFx")) {
					particle = new EntityUraniumFX(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d);
				}

				else if (type.equals("sulfurFx")) {
					particle = new EntitySulfurFX(world, posX + rand.nextDouble(), posY + rand.nextDouble(),
							posZ + rand.nextDouble(), 0d, 0d, 0d);
				}

				if (particle != null) {
					minecraft.effectRenderer.addEffect(particle);
				}
			}
		}
	}

	public static class EntityIceFX extends EntityFX {
		float dustParticleScale;

		public EntityIceFX(World world, double moveX, double moveY, double moveZ, double x, double y, double z) {
			this(world, moveX, moveY, moveZ, 1.0F, x, y, (float) z);
		}

		public EntityIceFX(World world, double moveX, double moveY, double moveZ, double x, double y, double z,
				float size) {
			super(world, moveX, moveY, moveZ, 0.0D, 0.0D, 0.0D);
			this.motionX *= 0.10000000149011612D;
			this.motionY *= 0.25000000149011612D;
			this.motionZ *= 0.10000000149011612D;

			if (y == 0.0F) {
				y = 1.0F;
			}

			float f4 = (float) Math.random() * 0.2F + 0.6F;
			this.particleRed = (float) (((Math.random() * 0.20000000298023224D) + 0.6F) * y * f4);
			this.particleGreen = (float) (((Math.random() * 0.20000000298023224D) + 0.8F) * y * f4);
			this.particleBlue = (float) (((Math.random() * 0.20000000298023224D) + 1F) * y * f4);
			this.particleScale *= 0.5F;
			this.particleScale *= x;
			this.dustParticleScale = this.particleScale;
			this.particleMaxAge = (int) (8.0D / (Math.random() * 0.8D + .2D));
			this.particleMaxAge = (int) ((float) this.particleMaxAge * x);
			this.noClip = false;
		}

		public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5,
				float par6, float par7) {
			float f6 = ((float) this.particleAge + par2) / (float) this.particleMaxAge * 32.0F;

			if (f6 < 0.0F) {
				f6 = 0.0F;
			}

			if (f6 > 1.0F) {
				f6 = 1.0F;
			}

			this.particleScale = this.dustParticleScale * f6;
			super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
		}

		/**
		 * Called to update the entity's position/logic.
		 */
		public void onUpdate() {
			this.prevPosX = this.posX;
			this.prevPosY = this.posY;
			this.prevPosZ = this.posZ;

			if (this.particleAge++ >= this.particleMaxAge) {
				this.setDead();
			}

			this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
			if (!this.worldObj.isRemote) {
				this.moveEntity(this.motionX, this.motionY, this.motionZ);
			}

			if (this.posY == this.prevPosY) {
				this.motionX *= 1.1D;
				this.motionZ *= 1.1D;
			}

			this.motionX *= 0.9599999785423279D;
			this.motionY *= 0.9599999785423279D;
			this.motionZ *= 0.9599999785423279D;

			if (this.onGround) {
				this.motionX *= 0.699999988079071D;
				this.motionZ *= 0.699999988079071D;
			}
		}
	}

	public static class EntityDarkMatterFX extends EntityFX {
		float dustParticleScale;

		public EntityDarkMatterFX(World world, double moveX, double moveY, double moveZ, double x, double y, double z) {
			this(world, moveX, moveY, moveZ, 1.0F, x, y, (float) z);
		}

		public EntityDarkMatterFX(World world, double moveX, double moveY, double moveZ, double x, double y, double z,
				float size) {
			super(world, moveX, moveY, moveZ, 0.0D, 0.0D, 0.0D);
			this.motionX *= .1D;
			this.motionY *= .1D;
			this.motionZ *= .1D;

			if (y == 0.0F) {
				y = 1.0F;
			}

			float f4 = (float) Math.random() * 0.2F + 0.6F;
			this.particleRed = (float) (((Math.random() * 0.20000000298023224D) + -1F) * y * f4);
			this.particleGreen = (float) (((Math.random() * 0.20000000298023224D) + -1F) * y * f4);
			this.particleBlue = (float) (((Math.random() * 0.20000000298023224D) + -1F) * y * f4);
			this.particleScale *= .35F;
			this.particleScale *= x;
			this.dustParticleScale = this.particleScale;
			this.particleMaxAge = (int) (8.0D / (Math.random() * 0.8D + .2D));
			this.particleMaxAge = (int) ((float) this.particleMaxAge * x);
			this.noClip = false;
		}

		public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5,
				float par6, float par7) {
			float f6 = ((float) this.particleAge + par2) / (float) this.particleMaxAge * 32.0F;

			if (f6 < 0.0F) {
				f6 = 0.0F;
			}

			if (f6 > 1.0F) {
				f6 = 1.0F;
			}

			this.particleScale = this.dustParticleScale * f6;
			super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
		}

		/**
		 * Called to update the entity's position/logic.
		 */
		public void onUpdate() {
			this.prevPosX = this.posX;
			this.prevPosY = this.posY;
			this.prevPosZ = this.posZ;

			if (this.particleAge++ >= this.particleMaxAge) {
				this.setDead();
			}

			this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
			if (this.worldObj.isRemote) {
				this.moveEntity(this.motionX, this.motionY, this.motionZ);
			}

			if (this.posY == this.prevPosY) {
				this.motionX *= 1.1D;
				this.motionZ *= 1.1D;
			}

			this.motionX *= 0.9599999785423279D;
			this.motionY *= 0.9599999785423279D;
			this.motionZ *= 0.9599999785423279D;

			if (this.onGround) {
				this.motionX *= 0.699999988079071D;
				this.motionZ *= 0.699999988079071D;
			}
		}
	}

	public static class EntityEinsteiniumFX extends EntityFX {
		float dustParticleScale;

		public EntityEinsteiniumFX(World world, double moveX, double moveY, double moveZ, double x, double y,
				double z) {
			this(world, moveX, moveY, moveZ, 1.0F, x, y, (float) z);
		}

		public EntityEinsteiniumFX(World world, double moveX, double moveY, double moveZ, double x, double y, double z,
				float size) {
			super(world, moveX, moveY, moveZ, 0.0D, 0.0D, 0.0D);
			this.motionX *= 0.10000000149011612D;
			this.motionY *= 0.10000000149011612D;
			this.motionZ *= 0.10000000149011612D;

			if (y == 0.0F) {
				y = 1.0F;
			}

			float f4 = (float) Math.random() * 0.4F + 0.6F;
			this.particleRed = (float) (((Math.random() * 0.20000000298023224D) + 0.8F) * y * f4);
			this.particleGreen = (float) (((Math.random() * 0.20000000298023224D) + 0.9F) * y * f4);
			this.particleBlue = (float) (((Math.random() * 0.20000000298023224D) + 1.1F) * y * f4);
			this.particleScale *= 0.75F;
			this.particleScale *= x;
			this.dustParticleScale = this.particleScale;
			this.particleMaxAge = (int) (8.0D / (Math.random() * 0.8D + 0.2D));
			this.particleMaxAge = (int) ((float) this.particleMaxAge * x);
			this.noClip = false;
		}

		public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5,
				float par6, float par7) {
			float f6 = ((float) this.particleAge + par2) / (float) this.particleMaxAge * 32.0F;

			if (f6 < 0.0F) {
				f6 = 0.0F;
			}

			if (f6 > 1.0F) {
				f6 = 1.0F;
			}

			this.particleScale = this.dustParticleScale * f6;
			super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
		}

		/**
		 * Called to update the entity's position/logic.
		 */
		public void onUpdate() {
			this.prevPosX = this.posX;
			this.prevPosY = this.posY;
			this.prevPosZ = this.posZ;

			if (this.particleAge++ >= this.particleMaxAge) {
				this.setDead();
			}

			this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
			if (this.worldObj.isRemote) {
				this.moveEntity(this.motionX, this.motionY, this.motionZ);
			}

			if (this.posY == this.prevPosY) {
				this.motionX *= 1.1D;
				this.motionZ *= 1.1D;
			}

			this.motionX *= 0.9599999785423279D;
			this.motionY *= 0.9599999785423279D;
			this.motionZ *= 0.9599999785423279D;

			if (this.onGround) {
				this.motionX *= 0.699999988079071D;
				this.motionZ *= 0.699999988079071D;
			}
		}
	}

	public static class EntityNeptuniumFX extends EntityFX {
		float dustParticleScale;

		public EntityNeptuniumFX(World world, double moveX, double moveY, double moveZ, double x, double y, double z) {
			this(world, moveX, moveY, moveZ, 1.0F, x, y, (float) z);
		}

		public EntityNeptuniumFX(World world, double moveX, double moveY, double moveZ, double x, double y, double z,
				float size) {
			super(world, moveX, moveY, moveZ, 0.0D, 0.0D, 0.0D);
			this.motionX *= 0.10000000149011612D;
			this.motionY *= 0.10000000149011612D;
			this.motionZ *= 0.10000000149011612D;

			if (y == 0.0F) {
				y = 1.0F;
			}

			float f4 = (float) Math.random() * 0.4F + 0.6F;
			this.particleRed = (float) (((Math.random() * 0.20000000298023224D) + 0.8F) * y * f4);
			this.particleGreen = (float) (((Math.random() * 0.20000000298023224D) + 0.6F) * y * f4);
			this.particleBlue = (float) (((Math.random() * 0.20000000298023224D) + 0.3F) * y * f4);
			this.particleScale *= 0.75F;
			this.particleScale *= x;
			this.dustParticleScale = this.particleScale;
			this.particleMaxAge = (int) (8.0D / (Math.random() * 0.8D + 0.2D));
			this.particleMaxAge = (int) ((float) this.particleMaxAge * x);
			this.noClip = false;
		}

		public void renderParticle(Tessellator tes, float r, float g, float b, float i, float j, float k) {
			float f6 = ((float) this.particleAge + r) / (float) this.particleMaxAge * 32.0F;

			if (f6 < 0.0F) {
				f6 = 0.0F;
			}

			if (f6 > 1.0F) {
				f6 = 1.0F;
			}

			this.particleScale = this.dustParticleScale * f6;
			super.renderParticle(tes, r, g, b, i, j, k);
		}

		/**
		 * Called to update the entity's position/logic.
		 */
		public void onUpdate() {
			this.prevPosX = this.posX;
			this.prevPosY = this.posY;
			this.prevPosZ = this.posZ;

			if (this.particleAge++ >= this.particleMaxAge) {
				this.setDead();
			}

			this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
			if (this.worldObj.isRemote) {
				this.moveEntity(this.motionX, this.motionY, this.motionZ);
			}

			if (this.posY == this.prevPosY) {
				this.motionX *= 1.1D;
				this.motionZ *= 1.1D;
			}

			this.motionX *= 0.9599999785423279D;
			this.motionY *= 0.9599999785423279D;
			this.motionZ *= 0.9599999785423279D;

			if (this.onGround) {
				this.motionX *= 0.699999988079071D;
				this.motionZ *= 0.699999988079071D;
			}
		}
	}

	public static class EntityUraniumFX extends EntityFX {
		float dustParticleScale;

		public EntityUraniumFX(World world, double moveX, double moveY, double moveZ, double x, double y, double z) {
			this(world, moveX, moveY, moveZ, 1.0F, x, y, (float) z);
		}

		public EntityUraniumFX(World world, double moveX, double moveY, double moveZ, double x, double y, double z,
				float size) {
			super(world, moveX, moveY, moveZ, 0.0D, 0.0D, 0.0D);
			this.motionX *= 0.10000000149011612D;
			this.motionY *= 0.10000000149011612D;
			this.motionZ *= 0.10000000149011612D;

			if (y == 0.0F) {
				y = 1.0F;
			}

			float f4 = (float) Math.random() * 0.4F + 0.6F;
			this.particleRed = (float) (((Math.random() * 0.20000000298023224D) + 0.8F) * y * f4);
			this.particleGreen = (float) (((Math.random() * 0.20000000298023224D) + 1.2F) * y * f4);
			this.particleBlue = (float) (((Math.random() * 0.20000000298023224D) + 0.9F) * y * f4);
			this.particleScale *= 0.75F;
			this.particleScale *= x;
			this.dustParticleScale = this.particleScale;
			this.particleMaxAge = (int) (8.0D / (Math.random() * 0.8D + 0.2D));
			this.particleMaxAge = (int) ((float) this.particleMaxAge * x);
			this.noClip = false;
		}

		public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5,
				float par6, float par7) {
			float f6 = ((float) this.particleAge + par2) / (float) this.particleMaxAge * 32.0F;

			if (f6 < 0.0F) {
				f6 = 0.0F;
			}

			if (f6 > 1.0F) {
				f6 = 1.0F;
			}

			this.particleScale = this.dustParticleScale * f6;
			super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
		}

		/**
		 * Called to update the entity's position/logic.
		 */
		public void onUpdate() {
			this.prevPosX = this.posX;
			this.prevPosY = this.posY;
			this.prevPosZ = this.posZ;

			if (this.particleAge++ >= this.particleMaxAge) {
				this.setDead();
			}

			this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
			if (this.worldObj.isRemote) {
				this.moveEntity(this.motionX, this.motionY, this.motionZ);
			}

			if (this.posY == this.prevPosY) {
				this.motionX *= 1.1D;
				this.motionZ *= 1.1D;
			}

			this.motionX *= 0.9599999785423279D;
			this.motionY *= 0.9599999785423279D;
			this.motionZ *= 0.9599999785423279D;

			if (this.onGround) {
				this.motionX *= 0.699999988079071D;
				this.motionZ *= 0.699999988079071D;
			}
		}
	}

	public static class EntitySulfurFX extends EntityFX {
		float dustParticleScale;

		public EntitySulfurFX(World world, double moveX, double moveY, double moveZ, double x, double y, double z) {
			this(world, moveX, moveY, moveZ, 1.0F, x, y, (float) z);
		}

		public EntitySulfurFX(World world, double moveX, double moveY, double moveZ, double x, double y, double z,
				float size) {
			super(world, moveX, moveY, moveZ, 0.0D, 0.0D, 0.0D);
			this.motionX *= 0.10000000149011612D;
			this.motionY *= 0.10000000149011612D;
			this.motionZ *= 0.10000000149011612D;

			if (y == 0.0F) {
				y = 1.0F;
			}

			float f4 = (float) Math.random() * 0.4F + 0.6F;
			this.particleRed = (float) (((Math.random() * 0.20000000298023224D) + 0.8F) * y * f4);
			this.particleGreen = (float) (((Math.random() * 0.20000000298023224D) + 0.7F) * y * f4);
			this.particleBlue = (float) (((Math.random() * 0.20000000298023224D) + 0.3F) * y * f4);
			this.particleScale *= 0.75F;
			this.particleScale *= x;
			this.dustParticleScale = this.particleScale;
			this.particleMaxAge = (int) (8.0D / (Math.random() * 0.8D + 0.2D));
			this.particleMaxAge = (int) ((float) this.particleMaxAge * x);
			this.noClip = false;
		}

		public void renderParticle(Tessellator tes, float r, float g, float b, float i, float j, float k) {
			float f6 = ((float) this.particleAge + r) / (float) this.particleMaxAge * 32.0F;

			if (f6 < 0.0F) {
				f6 = 0.0F;
			}

			if (f6 > 1.0F) {
				f6 = 1.0F;
			}

			this.particleScale = this.dustParticleScale * f6;
			super.renderParticle(tes, r, g, b, i, j, k);
		}

		/**
		 * Called to update the entity's position/logic.
		 */
		public void onUpdate() {
			this.prevPosX = this.posX;
			this.prevPosY = this.posY;
			this.prevPosZ = this.posZ;

			if (this.particleAge++ >= this.particleMaxAge) {
				this.setDead();
			}

			this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
			if (this.worldObj.isRemote) {
				this.moveEntity(this.motionX, this.motionY, this.motionZ);
			}

			if (this.posY == this.prevPosY) {
				this.motionX *= 1.1D;
				this.motionZ *= 1.1D;
			}

			this.motionX *= 0.9599999785423279D;
			this.motionY *= 0.9599999785423279D;
			this.motionZ *= 0.9599999785423279D;

			if (this.onGround) {
				this.motionX *= 0.699999988079071D;
				this.motionZ *= 0.699999988079071D;
			}
		}
	}
}