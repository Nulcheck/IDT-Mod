package com.mce.common;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

import com.mce.api.minechem.MinechemChemicalHandler;
import com.mce.api.minechem.MinechemNameHandler;
import com.mce.api.minechem.MinechemRecipeHandler;
import com.mce.api.other.CraftingPillarIDTAPI;
import com.mce.api.waila.IDTModule;
import com.mce.armor.NeoronArmor;
import com.mce.armor.SteelArmor;
import com.mce.armor.TantalumArmor;
import com.mce.armor.TitaniumArmor;
import com.mce.armor.VCArmor;
import com.mce.armor.VanadiumArmor;
import com.mce.armor.ZimphnodeArmor;
import com.mce.blocks.CrystalFire;
import com.mce.blocks.FrozenFire;
import com.mce.blocks.MineralBlocks.BoronBlock;
import com.mce.blocks.MineralBlocks.CopperBlock;
import com.mce.blocks.MineralBlocks.EinsteiniumBlock;
import com.mce.blocks.MineralBlocks.NeodymiumBlock;
import com.mce.blocks.MineralBlocks.NeoronBlock;
import com.mce.blocks.MineralBlocks.NeptuniumBlock;
import com.mce.blocks.MineralBlocks.PraseodymiumBlock;
import com.mce.blocks.MineralBlocks.SiliconBlock;
import com.mce.blocks.MineralBlocks.SteelBlock;
import com.mce.blocks.MineralBlocks.SulfurBlock;
import com.mce.blocks.MineralBlocks.TantalumBlock;
import com.mce.blocks.MineralBlocks.TitaniumBlock;
import com.mce.blocks.MineralBlocks.UraniumBlock;
import com.mce.blocks.MineralBlocks.VanadiumBlock;
import com.mce.blocks.MineralBlocks.ZimphnodeBlock;
import com.mce.blocks.ModBlocks;
import com.mce.blocks.ModBlocks.AdvancedHealer;
import com.mce.blocks.ModBlocks.BHG;
import com.mce.blocks.ModBlocks.BioFuelExtractor;
import com.mce.blocks.ModBlocks.CryingObsidian;
import com.mce.blocks.ModBlocks.CrystalBlock;
import com.mce.blocks.ModBlocks.DarkMatter;
import com.mce.blocks.ModBlocks.EinsteiniumCoreReactor;
import com.mce.blocks.ModBlocks.Enricher;
import com.mce.blocks.ModBlocks.HealerBlock;
import com.mce.blocks.ModBlocks.IndustrialCutter;
import com.mce.blocks.ModBlocks.LavaCobble;
import com.mce.blocks.ModBlocks.LavaObsidian;
import com.mce.blocks.ModBlocks.LavaStone;
import com.mce.blocks.ModBlocks.Magnetizer;
import com.mce.blocks.ModBlocks.MatterCondenser;
import com.mce.blocks.ModBlocks.ModGlassPane;
import com.mce.blocks.ModBlocks.NeptuniumCoreReactor;
import com.mce.blocks.ModBlocks.SBH;
import com.mce.blocks.ModBlocks.Smelter;
import com.mce.blocks.ModBlocks.SuperReactor;
import com.mce.blocks.ModBlocks.TankCompressor;
import com.mce.blocks.ModBlocks.TitaniumFrame;
import com.mce.blocks.ModBlocks.UraniumCoreReactor;
import com.mce.blocks.ModBlocks.Welder;
import com.mce.blocks.ModBlocks.ZNG;
import com.mce.blocks.ModButtons.AcaciaButton;
import com.mce.blocks.ModButtons.BirchButton;
import com.mce.blocks.ModButtons.DarkOakButton;
import com.mce.blocks.ModButtons.EbonyButton;
import com.mce.blocks.ModButtons.GelidButton;
import com.mce.blocks.ModButtons.JungleButton;
import com.mce.blocks.ModButtons.SilkwoodButton;
import com.mce.blocks.ModButtons.SpruceButton;
import com.mce.blocks.ModButtons.WillowButton;
import com.mce.blocks.ModFenceGates.AcaciaFenceGate;
import com.mce.blocks.ModFenceGates.BirchFenceGate;
import com.mce.blocks.ModFenceGates.DarkOakFenceGate;
import com.mce.blocks.ModFenceGates.EbonyFenceGate;
import com.mce.blocks.ModFenceGates.GelidFenceGate;
import com.mce.blocks.ModFenceGates.JungleFenceGate;
import com.mce.blocks.ModFenceGates.SilkwoodFenceGate;
import com.mce.blocks.ModFenceGates.SpruceFenceGate;
import com.mce.blocks.ModFenceGates.WillowFenceGate;
import com.mce.blocks.ModFences.AcaciaFence;
import com.mce.blocks.ModFences.BirchFence;
import com.mce.blocks.ModFences.DarkOakFence;
import com.mce.blocks.ModFences.EbonyFence;
import com.mce.blocks.ModFences.GelidFence;
import com.mce.blocks.ModFences.JungleFence;
import com.mce.blocks.ModFences.SilkwoodFence;
import com.mce.blocks.ModFences.SpruceFence;
import com.mce.blocks.ModFences.WillowFence;
import com.mce.blocks.ModGlass;
import com.mce.blocks.ModLadder;
import com.mce.blocks.ModLeaves.EbonyLeaves;
import com.mce.blocks.ModLeaves.GelidLeaves;
import com.mce.blocks.ModLeaves.SilkwoodLeaves;
import com.mce.blocks.ModLeaves.WillowLeaves;
import com.mce.blocks.ModLever;
import com.mce.blocks.ModLogs.EbonyLog;
import com.mce.blocks.ModLogs.GelidLog;
import com.mce.blocks.ModLogs.SilkwoodLog;
import com.mce.blocks.ModLogs.WillowLog;
import com.mce.blocks.ModOre.BoronOre;
import com.mce.blocks.ModOre.CopperOre;
import com.mce.blocks.ModOre.CrystalOre;
import com.mce.blocks.ModOre.EinsteiniumOre;
import com.mce.blocks.ModOre.NeodymiumOre;
import com.mce.blocks.ModOre.NeptuniumOre;
import com.mce.blocks.ModOre.Phosphorite;
import com.mce.blocks.ModOre.PraseodymiumOre;
import com.mce.blocks.ModOre.SulfurOre;
import com.mce.blocks.ModOre.TantalumOre;
import com.mce.blocks.ModOre.TitaniumOre;
import com.mce.blocks.ModOre.UraniumOre;
import com.mce.blocks.ModOre.VanadiumOre;
import com.mce.blocks.ModOre.Zimphnode;
import com.mce.blocks.ModPlanks.EbonyPlanks;
import com.mce.blocks.ModPlanks.GelidPlanks;
import com.mce.blocks.ModPlanks.SilkwoodPlanks;
import com.mce.blocks.ModPlanks.WillowPlanks;
import com.mce.blocks.ModPressurePlates;
import com.mce.blocks.ModPressurePlates.Sensitivity;
import com.mce.blocks.ModRedTorch.AcaciaRedTorch;
import com.mce.blocks.ModRedTorch.BirchRedTorch;
import com.mce.blocks.ModRedTorch.DarkOakRedTorch;
import com.mce.blocks.ModRedTorch.EbonyRedTorch;
import com.mce.blocks.ModRedTorch.GelidRedTorch;
import com.mce.blocks.ModRedTorch.JungleRedTorch;
import com.mce.blocks.ModRedTorch.SilkwoodRedTorch;
import com.mce.blocks.ModRedTorch.SpruceRedTorch;
import com.mce.blocks.ModRedTorch.WillowRedTorch;
import com.mce.blocks.ModSlab;
import com.mce.blocks.ModStairs;
import com.mce.blocks.ModTorch;
import com.mce.blocks.ModTrapdoor;
import com.mce.blocks.ModWalls.AcaciaWall;
import com.mce.blocks.ModWalls.BirchWall;
import com.mce.blocks.ModWalls.BrickWall;
import com.mce.blocks.ModWalls.CementBrickWall;
import com.mce.blocks.ModWalls.CementWall;
import com.mce.blocks.ModWalls.CoalWall;
import com.mce.blocks.ModWalls.DarkOakWall;
import com.mce.blocks.ModWalls.EbonyWall;
import com.mce.blocks.ModWalls.GelidWall;
import com.mce.blocks.ModWalls.JungleWall;
import com.mce.blocks.ModWalls.NetherBrickWall;
import com.mce.blocks.ModWalls.OakWall;
import com.mce.blocks.ModWalls.ObsidianWall;
import com.mce.blocks.ModWalls.QuartzWall;
import com.mce.blocks.ModWalls.SandStoneWall;
import com.mce.blocks.ModWalls.SilkwoodWall;
import com.mce.blocks.ModWalls.SnowWall;
import com.mce.blocks.ModWalls.SpruceWall;
import com.mce.blocks.ModWalls.StoneBrickWall;
import com.mce.blocks.ModWalls.StoneWall;
import com.mce.blocks.ModWalls.WillowWall;
import com.mce.blocks.ModWoodStairs;
import com.mce.blocks.ZimWire;
import com.mce.blocks.chest.AcaciaChest;
import com.mce.blocks.chest.BirchChest;
import com.mce.blocks.chest.DarkMatterChest;
import com.mce.blocks.chest.DarkOakChest;
import com.mce.blocks.chest.EbonyChest;
import com.mce.blocks.chest.GelidChest;
import com.mce.blocks.chest.JungleChest;
import com.mce.blocks.chest.SilkwoodChest;
import com.mce.blocks.chest.SpruceChest;
import com.mce.blocks.chest.WillowChest;
import com.mce.blocks.crops.CornCrop;
import com.mce.blocks.crops.SoyBeanCrop;
import com.mce.blocks.dimensions.frost.FrostGrass;
import com.mce.blocks.dimensions.frost.FrostyBlocks;
import com.mce.blocks.dimensions.frost.FrostyBlocks.FrozenStone;
import com.mce.blocks.doors.AcaciaDoor;
import com.mce.blocks.doors.BirchDoor;
import com.mce.blocks.doors.DarkOakDoor;
import com.mce.blocks.doors.EbonyDoor;
import com.mce.blocks.doors.GelidDoor;
import com.mce.blocks.doors.JungleDoor;
import com.mce.blocks.doors.SilkwoodDoor;
import com.mce.blocks.doors.SpruceDoor;
import com.mce.blocks.doors.WillowDoor;
import com.mce.blocks.explosives.DarkMatterBomb;
import com.mce.blocks.explosives.EinsteiniumBomb;
import com.mce.blocks.explosives.NeptuniumBomb;
import com.mce.blocks.explosives.UltimateNuker;
import com.mce.blocks.explosives.UraniumBomb;
import com.mce.blocks.liquids.LiquidNitrogen;
import com.mce.blocks.portals.CrystalPortal;
import com.mce.blocks.portals.FrozenPortal;
import com.mce.blocks.saplings.EbonySapling;
import com.mce.blocks.saplings.GelidSapling;
import com.mce.blocks.saplings.SilkwoodSapling;
import com.mce.blocks.saplings.WillowSapling;
import com.mce.blocks.workbench.AcaciaWorkbench;
import com.mce.blocks.workbench.BirchWorkbench;
import com.mce.blocks.workbench.DarkOakWorkbench;
import com.mce.blocks.workbench.EbonyWorkbench;
import com.mce.blocks.workbench.GelidCraftingTable;
import com.mce.blocks.workbench.IDTWorkbench;
import com.mce.blocks.workbench.JungleWorkbench;
import com.mce.blocks.workbench.SilkwoodWorkbench;
import com.mce.blocks.workbench.SpruceWorkbench;
import com.mce.blocks.workbench.WillowWorkbench;
import com.mce.commands.Bug;
import com.mce.commands.News;
import com.mce.commands.Support;
import com.mce.effects.RadiationEffect;
import com.mce.entity.tile.TEAH;
import com.mce.entity.tile.TECT;
import com.mce.entity.tile.TileEntityECR;
import com.mce.entity.tile.TileEntityNCR;
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
import com.mce.entity.tile.tech.TileEntityBHG;
import com.mce.entity.tile.tech.TileEntityEnricher;
import com.mce.entity.tile.tech.TileEntityIndustrialCutter;
import com.mce.entity.tile.tech.TileEntityMagnetizer;
import com.mce.entity.tile.tech.TileEntityMatterCondenser;
import com.mce.entity.tile.tech.TileEntitySmelter;
import com.mce.entity.tile.tech.TileEntityTankCompressor;
import com.mce.entity.tile.tech.TileEntityWelder;
import com.mce.entity.tile.tech.TileEntityZNG;
import com.mce.entity.tile.wall_parts.TileEntityWPAcacia;
import com.mce.entity.tile.wall_parts.TileEntityWPBirch;
import com.mce.entity.tile.wall_parts.TileEntityWPBrick;
import com.mce.entity.tile.wall_parts.TileEntityWPCement;
import com.mce.entity.tile.wall_parts.TileEntityWPCementBrick;
import com.mce.entity.tile.wall_parts.TileEntityWPCoal;
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
import com.mce.events.BlowtorchEvent;
import com.mce.events.ChatEvent;
import com.mce.events.ChiselEvent;
import com.mce.events.EventBonemeal;
import com.mce.events.OtherEvents;
import com.mce.events.PotionEvents;
import com.mce.events.ToolEvent;
import com.mce.events.WikiPaperEvent;
import com.mce.handlers.AchievementHandler;
import com.mce.handlers.BlockRecipeHandler;
import com.mce.handlers.ChestHookHandler;
import com.mce.handlers.CraftedEventHandler;
import com.mce.handlers.DimensionHandler;
import com.mce.handlers.FuelHandler;
import com.mce.handlers.GUIHandler;
import com.mce.handlers.ItemRecipeHandler;
import com.mce.handlers.OreGenHandler;
import com.mce.handlers.PlayerDevHandler;
import com.mce.handlers.PlayerHandler;
import com.mce.handlers.PlayerWikiPaperHandler;
import com.mce.handlers.ToolRecipeHandler;
import com.mce.handlers.TradeFarmerHandler;
import com.mce.handlers.TradePriestHandler;
import com.mce.handlers.TradeSmithHandler;
import com.mce.handlers.packets.ClientPacketHandler;
import com.mce.handlers.packets.ServerPacketHandler;
import com.mce.handlers.registers.AchRegistry;
import com.mce.handlers.registers.BiomeRegistry;
import com.mce.handlers.registers.BlockRegistry;
import com.mce.handlers.registers.ItemRegistry;
import com.mce.handlers.registers.MobRegistry;
import com.mce.handlers.registers.OreDictionaryRegistry;
import com.mce.items.AcaciaDoorItem;
import com.mce.items.BirchDoorItem;
import com.mce.items.ChargeStone;
import com.mce.items.Chisel;
import com.mce.items.DarkOakDoorItem;
import com.mce.items.EbonyDoorItem;
import com.mce.items.EinsteiniumCoreReactorItem;
import com.mce.items.GelidDoorItem;
import com.mce.items.HardCrystalBall;
import com.mce.items.JungleDoorItem;
import com.mce.items.LiquidNitrogenBucket;
import com.mce.items.ModEssence;
import com.mce.items.ModIngot;
import com.mce.items.ModItems;
import com.mce.items.ModItems.DiamondSawBlade;
import com.mce.items.ModItems.Flask;
import com.mce.items.ModItems.Glycerin;
import com.mce.items.ModItems.H2SO4;
import com.mce.items.ModItems.HNO3;
import com.mce.items.ModItems.IronSawBlade;
import com.mce.items.ModItems.LaserUpgrade;
import com.mce.items.ModItems.MagneticUpgrade;
import com.mce.items.ModItems.Microchip;
import com.mce.items.ModItems.NO2Tank;
import com.mce.items.ModItems.PropaneTank;
import com.mce.items.ModItems.QCUpgrade;
import com.mce.items.ModItems.QMan;
import com.mce.items.ModItems.SO2;
import com.mce.items.ModItems.SO3;
import com.mce.items.ModItems.StabilizerUpgrade;
import com.mce.items.ModItems.SteelSawBlade;
import com.mce.items.ModItems.T1CB;
import com.mce.items.ModItems.T2CB;
import com.mce.items.ModItems.T3CB;
import com.mce.items.ModItems.TitaniumSawBlade;
import com.mce.items.ModItems.UpgradeBase;
import com.mce.items.ModItems.V2O5;
import com.mce.items.ModSticks;
import com.mce.items.NdMagnet;
import com.mce.items.Nitroglycerin;
import com.mce.items.Pouch;
import com.mce.items.SilkwoodDoorItem;
import com.mce.items.SpruceDoorItem;
import com.mce.items.Tools.Axe;
import com.mce.items.Tools.Hoe;
import com.mce.items.Tools.Pick;
import com.mce.items.Tools.Shovel;
import com.mce.items.Tools.Sword;
import com.mce.items.WallPart.AcaciaWallPart;
import com.mce.items.WallPart.BirchWallPart;
import com.mce.items.WallPart.BrickWallPart;
import com.mce.items.WallPart.CementBrickWallPart;
import com.mce.items.WallPart.CementWallPart;
import com.mce.items.WallPart.CoalWallPart;
import com.mce.items.WallPart.CobblestoneWallPart;
import com.mce.items.WallPart.DarkOakWallPart;
import com.mce.items.WallPart.EbonyWallPart;
import com.mce.items.WallPart.GelidWallPart;
import com.mce.items.WallPart.JungleWallPart;
import com.mce.items.WallPart.MossyCobblestoneWallPart;
import com.mce.items.WallPart.NetherBrickWallPart;
import com.mce.items.WallPart.OakWallPart;
import com.mce.items.WallPart.ObsidianWallPart;
import com.mce.items.WallPart.QuartzWallPart;
import com.mce.items.WallPart.SandstoneWallPart;
import com.mce.items.WallPart.SilkwoodWallPart;
import com.mce.items.WallPart.SnowWallPart;
import com.mce.items.WallPart.SpruceWallPart;
import com.mce.items.WallPart.StoneWallPart;
import com.mce.items.WallPart.StonebrickWallPart;
import com.mce.items.WallPart.WillowWallPart;
import com.mce.items.WikiPaper;
import com.mce.items.WillowDoorItem;
import com.mce.items.records.Disc23;
import com.mce.items.records.DiscIcy;
import com.mce.items.records.Discr51;
import com.mce.util.ModCreativeTabs;
import com.mce.util.updater.CheckVersion;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;

@Mod(modid = mod_IDT.modid, name = mod_IDT.name, version = mod_IDT.version)
public class mod_IDT {
	@Mod.Instance("mod_IDT")
	public static mod_IDT instance;

	public static final int renderId = RenderingRegistry.getNextAvailableRenderId();

	public static final String networkChannelName = "IDT";
	public static FMLEventChannel channel;

	public static final String modid = "mod_IDT";
	public static final String modid2 = "mod_idt";
	public static final String name = "Industrial Technologies and More";
	public static final String version = "Snapshot 17w32a";

	@SidedProxy(clientSide = "com.mce.client.ClientProxy", serverSide = "com.mce.common.CommonProxy")
	public static CommonProxy proxy;

	public static Logger log = Logger.getLogger("Minecraft");
	public boolean mobDef = Loader.isModLoaded("mod_mobdefensive");
	public static boolean ebm = Loader.isModLoaded("mod_ebm");
	public static boolean minechem = Loader.isModLoaded("minechem");

	// TODO: Blocks
	// Other
	public static Block Cement;
	public static Block CementBricks;
	public static Block HealerBlock;
	public static Block AdvancedHealer;
	public static Block CryingObsidian;
	public static Block LavaStone;
	public static Block LavaCobble;
	public static Block LavaObsidian;
	public static Block CrystalBlock;
	public static Block SmelterIdle;
	public static Block SmelterActive;
	public static Block SteelBlock;
	public static Block TitaniumBlock;
	public static Block DidymiumGlass;
	public static Block DidymiumGlassPane;
	public static Block EinsteiniumGlass;
	public static Block EinsteiniumGlassPane;
	public static Block NeptuniumGlass;
	public static Block NeptuniumGlassPane;
	public static Block UraniumGlass;
	public static Block UraniumGlassPane;
	public static Block IndustrialCutter;
	public static Block MatterCondenser;
	public static Block DarkMatter;
	public static Block ZNG;
	public static Block TitaniumFrame;
	public static Block StableBlackHole;
	public static Block EinsteiniumCoreReactor;
	public static Block NeptuniumCoreReactor;
	public static Block UraniumCoreReactor;
	public static Block SuperReactor;
	public static Block BioFuelExtractor;
	public static Block TankCompressor;
	public static Block CompactCobblestone;
	public static Block BlackHoleGenerator;
	public static Block Welder;
	public static Block Magnetizer;
	public static Block Enricher;
	public static Block ZimphnodeWire;
	public static Block CopperBlock;
	public static Block ReinforcedGlass;
	public static Block ReinforcedGlassPane;
	public static Block SiliconBlock;
	public static Block EssenceInfuser;
	public static Block EssenceExtractor;
	public static Block VanadiumBlock;
	public static Block TantalumBlock;
	public static Block EinsteiniumBlock;
	public static Block NeptuniumBlock;
	public static Block UraniumBlock;
	public static Block PraseodymiumBlock;
	public static Block NeodymiumBlock;
	public static Block BoronBlock;
	public static Block VCBlock;
	public static Block SulfurBlock;
	public static Block ZimphnodeBlock;
	public static Block NeoronBlock;

	// Fires
	public static FrozenFire FrozenFire;
	public static CrystalFire CrystalFire;

	// Liquids
	public static Fluid LiquidNitrogenF;
	public static Block LiquidNitrogen;

	// Buttons
	public static Block BirchButton;
	public static Block SpruceButton;
	public static Block JungleButton;
	public static Block WillowButton;
	public static Block EbonyButton;
	public static Block SilkwoodButton;
	public static Block AcaciaButton;
	public static Block DarkOakButton;
	public static Block GelidButton;

	// Pressure Plates
	public static Block BirchPressurePlate;
	public static Block SprucePressurePlate;
	public static Block JunglePressurePlate;
	public static Block WillowPressurePlate;
	public static Block EbonyPressurePlate;
	public static Block SilkwoodPressurePlate;
	public static Block AcaciaPressurePlate;
	public static Block DarkOakPressurePlate;
	public static Block GelidPressurePlate;

	// Doors
	public static Block BirchDoor;
	public static Block SpruceDoor;
	public static Block JungleDoor;
	public static Block WillowDoor;
	public static Block EbonyDoor;
	public static Block SilkwoodDoor;
	public static Block AcaciaDoor;
	public static Block DarkOakDoor;
	public static Block GelidDoor;

	// Slabs
	public static Block WillowSlab;
	public static Block WillowDoubleSlab;

	public static Block CementSlab;
	public static Block CementDoubleSlab;

	public static Block CementBrickSlab;
	public static Block CementBrickDoubleSlab;

	public static Block StoneSlab;
	public static Block StoneDoubleSlab;

	public static Block EbonySlab;
	public static Block EbonyDoubleSlab;

	public static Block SilkwoodSlab;
	public static Block SilkwoodDoubleSlab;

	public static Block GlassSlab;
	public static Block GlassDoubleSlab;

	public static Block GelidSlab;
	public static Block GelidDoubleSlab;

	// Colored Slabs
	public static Block GlassSlabWhite;
	public static Block GlassDoubleSlabWhite;

	public static Block GlassSlabOrange;
	public static Block GlassDoubleSlabOrange;

	public static Block GlassSlabMagenta;
	public static Block GlassDoubleSlabMagenta;

	public static Block GlassSlabLightBlue;
	public static Block GlassDoubleSlabLightBlue;

	public static Block GlassSlabYellow;
	public static Block GlassDoubleSlabYellow;

	public static Block GlassSlabLime;
	public static Block GlassDoubleSlabLime;

	public static Block GlassSlabPink;
	public static Block GlassDoubleSlabPink;

	public static Block GlassSlabGray;
	public static Block GlassDoubleSlabGray;

	public static Block GlassSlabLightGray;
	public static Block GlassDoubleSlabLightGray;

	public static Block GlassSlabCyan;
	public static Block GlassDoubleSlabCyan;

	public static Block GlassSlabPurple;
	public static Block GlassDoubleSlabPurple;

	public static Block GlassSlabBlue;
	public static Block GlassDoubleSlabBlue;

	public static Block GlassSlabBrown;
	public static Block GlassDoubleSlabBrown;

	public static Block GlassSlabGreen;
	public static Block GlassDoubleSlabGreen;

	public static Block GlassSlabRed;
	public static Block GlassDoubleSlabRed;

	public static Block GlassSlabBlack;
	public static Block GlassDoubleSlabBlack;

	// Fences
	public static Block BirchFence;
	public static Block SpruceFence;
	public static Block JungleFence;
	public static Block WillowFence;
	public static Block EbonyFence;
	public static Block SilkwoodFence;
	public static Block AcaciaFence;
	public static Block DarkOakFence;
	public static Block GelidFence;

	// Fence Gates
	public static Block BirchFenceGate;
	public static Block SpruceFenceGate;
	public static Block JungleFenceGate;
	public static Block WillowFenceGate;
	public static Block EbonyFenceGate;
	public static Block SilkwoodFenceGate;
	public static Block AcaciaFenceGate;
	public static Block DarkOakFenceGate;
	public static Block GelidFenceGate;

	// Stairs
	public static Block WillowStairs;
	public static Block GlassStairs;
	public static Block StoneStairs;
	public static Block CementStairs;
	public static Block CementBrickStairs;
	public static Block EbonyStairs;
	public static Block CrystalStairs;
	public static Block SilkwoodStairs;
	public static Block GelidStairs;

	// Colored Stairs
	public static Block GlassStairsWhite;
	public static Block GlassStairsOrange;
	public static Block GlassStairsMagenta;
	public static Block GlassStairsLightBlue;
	public static Block GlassStairsYellow;
	public static Block GlassStairsLime;
	public static Block GlassStairsPink;
	public static Block GlassStairsGray;
	public static Block GlassStairsLightGray;
	public static Block GlassStairsCyan;
	public static Block GlassStairsPurple;
	public static Block GlassStairsBlue;
	public static Block GlassStairsBrown;
	public static Block GlassStairsGreen;
	public static Block GlassStairsRed;
	public static Block GlassStairsBlack;

	// Torches
	public static Block BirchTorch;
	public static Block SpruceTorch;
	public static Block JungleTorch;
	public static Block WillowTorch;
	public static Block EbonyTorch;
	public static Block SilkwoodTorch;
	public static Block AcaciaTorch;
	public static Block DarkOakTorch;
	public static Block GelidTorch;

	// Redstone Torches
	public static Block BirchRedTorch;
	public static Block SpruceRedTorch;
	public static Block JungleRedTorch;
	public static Block WillowRedTorch;
	public static Block EbonyRedTorch;
	public static Block SilkwoodRedTorch;
	public static Block AcaciaRedTorch;
	public static Block DarkOakRedTorch;
	public static Block GelidRedTorch;

	// Redstone Torches On
	public static Block BirchRedTorchOn;
	public static Block SpruceRedTorchOn;
	public static Block JungleRedTorchOn;
	public static Block WillowRedTorchOn;
	public static Block EbonyRedTorchOn;
	public static Block SilkwoodRedTorchOn;
	public static Block AcaciaRedTorchOn;
	public static Block DarkOakRedTorchOn;
	public static Block GelidRedTorchOn;

	// Walls
	public static Block StoneWall;
	public static Block SandStoneWall;
	public static Block ObsidianWall;
	public static Block CementWall;
	public static Block CementBrickWall;
	public static Block SnowWall;
	public static Block NetherBrickWall;
	public static Block StoneBrickWall;
	public static Block BrickWall;
	public static Block QuartzWall;
	public static Block CoalWall;

	// Wooden
	public static Block OakWall;
	public static Block BirchWall;
	public static Block SpruceWall;
	public static Block JungleWall;
	public static Block WillowWall;
	public static Block EbonyWall;
	public static Block SilkwoodWall;
	public static Block AcaciaWall;
	public static Block DarkOakWall;
	public static Block GelidWall;

	// Frost Dim
	public static Block FrostGrass;
	public static Block FrostDirt;
	public static Block FrostStone;
	public static Block FrostCobble;
	public static Block FrozenPortal;

	// Crystal Dim
	public static Block CrystalPortal;

	// Ores
	public static Block EinsteiniumOre;
	public static Block UraniumOre;
	public static Block NeptuniumOre;
	public static Block CrystalOre;
	public static Block PraseodymiumOre;
	public static Block NeodymiumOre;
	public static Block VanadiumOre;
	public static Block TantalumOre;
	public static Block ZimphnodeOre;
	public static Block SulfurOre;
	public static Block BoronOre;
	public static Block CopperOre;
	public static Block TitaniumOre;
	public static Block Phosphorite;

	// Bombs
	public static Block EinsteiniumBomb;
	public static Block UraniumBomb;
	public static Block NeptuniumBomb;
	public static Block UltimateNuker;
	public static Block DarkMatterBomb;

	// Logs
	public static Block WillowLog;
	public static Block EbonyLog;
	public static Block SilkwoodLog;
	public static Block GelidLog;

	// Planks
	public static Block WillowPlanks;
	public static Block EbonyPlanks;
	public static Block SilkwoodPlanks;
	public static Block GelidPlanks;

	// Leaves
	public static Block WillowLeaves;
	public static Block EbonyLeaves;
	public static Block SilkwoodLeaves;
	public static Block GelidLeaves;

	// Saplings
	public static Block WillowSapling;
	public static Block EbonySapling;
	public static Block SilkwoodSapling;
	public static Block GelidSapling;

	// Crops
	public static Block CornCrop;
	public static Block SoyBeanCrop;

	// Chests
	public static Block BirchChest;
	public static Block BirchTrapChest;

	public static Block SpruceChest;
	public static Block SpruceTrapChest;

	public static Block JungleChest;
	public static Block JungleTrapChest;

	public static Block WillowChest;
	public static Block WillowTrapChest;

	public static Block EbonyChest;
	public static Block EbonyTrapChest;

	public static Block DarkMatterChest;

	public static Block SilkwoodChest;
	public static Block SilkwoodTrapChest;

	public static Block AcaciaChest;
	public static Block AcaciaTrapChest;

	public static Block DarkOakChest;
	public static Block DarkOakTrapChest;

	public static Block GelidChest;
	public static Block GelidTrapChest;

	// Trapdoors
	public static Block BirchTrapdoor;
	public static Block SpruceTrapdoor;
	public static Block JungleTrapdoor;
	public static Block WillowTrapdoor;
	public static Block EbonyTrapdoor;
	public static Block SilkwoodTrapdoor;
	public static Block AcaciaTrapdoor;
	public static Block DarkOakTrapdoor;
	public static Block CementTrapdoor;
	public static Block CementBrickTrapdoor;
	public static Block StoneTrapdoor;
	public static Block CobblestoneTrapdoor;
	public static Block MossyCobblestoneTrapdoor;
	public static Block StonebrickTrapdoor;
	public static Block MossyStonebrickTrapdoor;
	public static Block CrackedStonebrickTrapdoor;
	public static Block ChiseledStonebrickTrapdoor;
	public static Block GelidTrapdoor;

	// Secret Trapdoors
	public static Block SecretOakTrapdoor;
	public static Block SecretBirchTrapdoor;
	public static Block SecretSpruceTrapdoor;
	public static Block SecretJungleTrapdoor;
	public static Block SecretWillowTrapdoor;
	public static Block SecretEbonyTrapdoor;
	public static Block SecretSilkwoodTrapdoor;
	public static Block SecretAcaciaTrapdoor;
	public static Block SecretDarkOakTrapdoor;
	public static Block SecretCementTrapdoor;
	public static Block SecretCementBrickTrapdoor;
	public static Block SecretStoneTrapdoor;
	public static Block SecretCobblestoneTrapdoor;
	public static Block SecretMossyCobblestoneTrapdoor;
	public static Block SecretStonebrickTrapdoor;
	public static Block SecretMossyStonebrickTrapdoor;
	public static Block SecretCrackedStonebrickTrapdoor;
	public static Block SecretChiseledStonebrickTrapdoor;
	public static Block SecretGelidTrapdoor;

	// Levers
	public static Block BirchLever;
	public static Block SpruceLever;
	public static Block JungleLever;
	public static Block WillowLever;
	public static Block EbonyLever;
	public static Block SilkwoodLever;
	public static Block AcaciaLever;
	public static Block DarkOakLever;
	public static Block GelidLever;

	// Workbenches
	public static Block BirchCraftingTable;
	public static Block SpruceCraftingTable;
	public static Block JungleCraftingTable;
	public static Block WillowCraftingTable;
	public static Block EbonyCraftingTable;
	public static Block IDTCraftingTable;
	public static Block SilkwoodCraftingTable;
	public static Block AcaciaCraftingTable;
	public static Block DarkOakCraftingTable;
	public static Block GelidCraftingTable;

	// Ladders
	public static Block BirchLadder;
	public static Block SpruceLadder;
	public static Block JungleLadder;
	public static Block WillowLadder;
	public static Block EbonyLadder;
	public static Block SilkwoodLadder;
	public static Block AcaciaLadder;
	public static Block DarkOakLadder;
	public static Block GelidLadder;

	// TODO: Items
	// Other
	public static Item StoneBrick;
	public static Item ExplosiveCharge;
	public static Item WikiPaper;
	public static Item IceShard;
	public static Item IronSawBlade;
	public static Item SteelSawBlade;
	public static Item TitaniumSawBlade;
	public static Item DiamondSawBlade;
	public static Item Gear;
	public static Item EmptyTank;
	public static Item PropaneTank;
	public static Item CompressorUnit;
	public static Item SteelRod;
	public static Item TitaniumPlate;
	public static Item Flask;
	public static Item NdMagnet;
	public static Item CompressorUnitGA;
	public static Item VanadiumPlate;
	public static Item BlowTorch;
	public static Item DarkMatterPiece;
	public static Item CopperPlate;
	public static Item CopperWire;
	public static Item CopperFoil;
	public static Item EinsteiniumCoreReactorItem;
	public static Item NeptuniumCoreReactorItem;
	public static Item UraniumCoreReactorItem;
	public static Item SuperReactorItem;
	public static Item Dyanamite;
	public static Item T1CircuitBoard;
	public static Item T2CircuitBoard;
	public static Item T3CircuitBoard;
	public static Item QMan;
	public static Item Transistor;
	public static Item Microchip;
	public static Item Plank;
	public static Item Fiberglass;
	public static Item BoronFG;
	public static Item SiliconWafer;
	public static Item VanadiumWire;
	public static Item TantalumPlate;
	public static Item TantalumFoil;
	public static Item PureQuartz;
	public static Item PolePiece;
	public static Item Rotor;
	public static Item Stator;
	public static Item Alternator;
	public static Item ChargeStone;
	public static Item Pouch;
	public static Item SiliconChip;
	public static Item BSiliconChip;
	public static Item PSiliconChip;

	// Upgrades
	public static Item UpgradeBase;
	public static Item MagneticUpgrade;
	public static Item LaserUpgrade;
	public static Item StabilizerUpgrade;
	public static Item QCUpgrade;

	// Dusts
	public static Item CopperDust;
	public static Item SiliconDust;
	public static Item VCDust;
	public static Item TitaniumDust;
	public static Item PhosphorusDust;
	public static Item BoronDust;

	// Records
	public static Item cd_icy;
	public static Item cd_23;
	public static Item cd_r51;

	// Chemistry Stuff
	public static Item Sulfur;
	public static Item SO2;
	public static Item SO3;
	public static Item H2SO4;
	public static Item NO2Tank;
	public static Item HNO3;
	public static Item VPowder;
	public static Item V2O5;
	public static Item Nitroglycerin;
	public static Item Glycerin;
	public static Item Carbon;
	public static Item Acrolein;
	public static Item Propanol;
	public static Item Propene;
	public static Item Graphene;

	// Liquids
	public static Item LiquidNitrogenBucket;

	// Wall Part
	public static Item CementWallPart;
	public static Item CementBrickWallPart;
	public static Item StoneWallPart;
	public static Item CobblestoneWallPart;
	public static Item MossyCobblestoneWallPart;
	public static Item SandstoneWallPart;
	public static Item ObsidianWallPart;
	public static Item StonebrickWallPart;
	public static Item BrickWallPart;
	public static Item CoalWallPart;
	public static Item SnowWallPart;
	public static Item NetherBrickWallPart;
	public static Item QuartzWallPart;
	public static Item OakWallPart;
	public static Item BirchWallPart;
	public static Item SpruceWallPart;
	public static Item JungleWallPart;
	public static Item WillowWallPart;
	public static Item EbonyWallPart;
	public static Item SilkwoodWallPart;
	public static Item AcaciaWallPart;
	public static Item DarkOakWallPart;
	public static Item GelidWallPart;

	// Doors
	public static Item BirchDoorItem;
	public static Item SpruceDoorItem;
	public static Item JungleDoorItem;
	public static Item WillowDoorItem;
	public static Item EbonyDoorItem;
	public static Item SilkwoodDoorItem;
	public static Item AcaciaDoorItem;
	public static Item DarkOakDoorItem;
	public static Item GelidDoorItem;

	// Ingots
	public static Item EinsteiniumIngot;
	public static Item UraniumIngot;
	public static Item NeptuniumIngot;
	public static Item SteelIngot;
	public static Item TitaniumIngot;
	public static Item PraseodymiumIngot;
	public static Item NeodymiumIngot;
	public static Item VanadiumIngot;
	public static Item TantalumIngot;
	public static Item ZimphnodeBar;
	public static Item NeoronIngot;
	public static Item BoronIngot;
	public static Item CopperIngot;
	public static Item SiliconIngot;
	public static Item VCIngot;

	// Crystals
	public static Item CrystalDust;
	public static Item CrystalGem;
	public static Item CrystalNugget;
	public static Item CrystalPiece;
	public static Item CrystalBall;
	public static Item HardCrystalBall;
	public static Item CutCrystalGem;
	public static Item CrystalLens;
	public static Item CrystalRod;

	// Essence
	public static Item EssenceOfLife;
	public static Item EssenceOfFire;
	public static Item EssenceOfEarth;
	public static Item EssenceOfWater;
	public static Item EssenceOfAir;

	// Pure
	public static Item PureLifeEssence;
	public static Item PureFireEssence;
	public static Item PureEarthEssence;
	public static Item PureWaterEssence;
	public static Item PureAirEssence;
	public static Item EOTP;

	// Sticks
	public static Item WillowStick;
	public static Item BirchStick;
	public static Item SpruceStick;
	public static Item JungleStick;
	public static Item EbonyStick;
	public static Item SilkwoodStick;
	public static Item AcaciaStick;
	public static Item DarkOakStick;
	public static Item GelidStick;

	// Seeds
	public static Item CornSeeds;

	// Foods
	public static Item Corn;
	public static Item SoyBeans;
	public static Item Popcorn;

	// Armor
	// Steel
	public static Item SteelHelmet;
	public static Item SteelChestplate;
	public static Item SteelLeggings;
	public static Item SteelBoots;

	// Titaniun
	public static Item TitaniumHelmet;
	public static Item TitaniumChestplate;
	public static Item TitaniumLeggings;
	public static Item TitaniumBoots;

	// Zimphnode
	public static Item ZimphnodeHelmet;
	public static Item ZimphnodeChestplate;
	public static Item ZimphnodeLeggings;
	public static Item ZimphnodeBoots;

	// Vanadium
	public static Item VanadiumHelmet;
	public static Item VanadiumChestplate;
	public static Item VanadiumLeggings;
	public static Item VanadiumBoots;

	// Tantalum
	public static Item TantalumHelmet;
	public static Item TantalumChestplate;
	public static Item TantalumLeggings;
	public static Item TantalumBoots;

	// Neoron / Magnetic
	public static Item NeoronHelmet;
	public static Item NeoronChestplate;
	public static Item NeoronLeggings;
	public static Item NeoronBoots;

	// VC
	public static Item VCHelmet;
	public static Item VCChestplate;
	public static Item VCLeggings;
	public static Item VCBoots;

	// Tools
	public static Item Chisel;

	// Pick
	public static Item SteelPick;
	public static Item TitaniumPick;
	public static Item VanadiumPick;
	public static Item NeoronPick;
	public static Item VCPick;

	// Shovel
	public static Item SteelShovel;
	public static Item TitaniumShovel;
	public static Item VanadiumShovel;
	public static Item VCShovel;

	// Axe
	public static Item SteelAxe;
	public static Item TitaniumAxe;
	public static Item VanadiumAxe;
	public static Item VCAxe;

	// Sword
	public static Item SteelSword;
	public static Item TitaniumSword;
	public static Item VanadiumSword;
	public static Item VCSword;

	// Hoe
	public static Item SteelHoe;
	public static Item TitaniumHoe;
	public static Item VanadiumHoe;
	public static Item VCHoe;

	public static final int BirchCraftingTableGUI = 0;
	public static final int SpruceCraftingTableGUI = 1;
	public static final int JungleCraftingTableGUI = 2;
	public static final int WillowCraftingTableGUI = 3;
	public static final int EbonyCraftingTableGUI = 4;
	public static final int SmelterGUI = 5;
	public static final int MatterCondenserGUI = 6;
	public static final int ZNGGUI = 7;
	public static final int IDTCraftingTableGUI = 8;
	public static final int SilkwoodCraftingTableGUI = 9;
	public static final int BFEGUI = 10;
	public static final int TankCompressorGUI = 11;
	public static final int IndustrialCutterGUI = 12;
	public static final int AcaciaCraftingTableGUI = 13;
	public static final int DarkOakCraftingTableGUI = 14;
	public static final int GelidCraftingTableGUI = 15;
	public static final int BHGGUI = 16;
	public static final int WelderGUI = 17;
	public static final int MagnetizerGUI = 18;
	public static final int EnricherGUI = 19;
	public static final int EssenceInfuserGUI = 20;
	public static final int EssenceExtractorGUI = 21;

	public static final int PACKET_TYPE_C2S_TEST = 626;
	public static final int PACKET_TYPE_ENTITY_SYNC = 627;

	public static Potion Radiation;

	// public static WorldTypeFrost FrostWorldType = new WorldTypeFrost();

	public static Random random = new Random();

	// Biome IDs
	public static int WillowForestID;
	public static int EbonyForestID;
	public static int SilkwoodForestID;
	public static int FrostBiomeID;
	public static int FrostBarrenID;
	public static int FrostForestID;
	public static int CrystalBiomeID;

	// Dimension IDs
	public static int frostDimId;
	public static int crystalDimId;

	@Mod.EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(modid);
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		WillowForestID = config.get("Biome IDs", "Willow Forest", 130).getInt();
		EbonyForestID = config.get("Biome IDs", "Ebony Forest", 131).getInt();
		SilkwoodForestID = config.get("Biome IDs", "Silkwood Forest", 132).getInt();
		FrostBiomeID = config.get("Biome IDs", "Frozen Lands", 133).getInt();
		FrostBarrenID = config.get("Biome IDs", "Frozen Barren Lands", 134).getInt();
		FrostForestID = config.get("Biome IDs", "Frosty Forest", 135).getInt();
		CrystalBiomeID = config.get("Biome IDs", "Crystalline", 136).getInt();

		frostDimId = config.get("Dimension IDs", "Frost Dimension", 5).getInt();
		crystalDimId = config.get("Dimension IDs", "Crystal Dimension", 6).getInt();
		config.save();

		new CheckVersion();

		// TODO: Blocks
		// Other
		Cement = new ModBlocks(Material.ground).setBlockName("Cement").setHardness(2.0F).setResistance(30.0F)
				.setStepSound(Block.soundTypeStone).setCreativeTab(IDT).setBlockTextureName("mod_IDT:cement");

		CementBricks = new ModBlocks(Material.ground).setBlockName("CementBricks").setHardness(2.5F)
				.setResistance(30.5F).setStepSound(Block.soundTypeStone).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:cement_bricks");

		HealerBlock = new HealerBlock(Material.ground).setBlockName("Healer").setHardness(2.0F).setResistance(2000F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setBlockTextureName("mod_IDT:healer");

		AdvancedHealer = new AdvancedHealer(Material.ground).setBlockName("AdvancedHealer").setHardness(2f)
				.setResistance(2000f).setStepSound(Block.soundTypeGlass).setCreativeTab(IDT);

		CryingObsidian = new CryingObsidian(Material.ground).setBlockName("CryingObsidian").setHardness(50.0F)
				.setResistance(2000F).setStepSound(Block.soundTypeStone).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:crying_obsidian");

		LavaStone = new LavaStone(Material.ground).setBlockName("LavaStone").setHardness(2.0f).setResistance(5f)
				.setLightLevel(1f).setStepSound(Block.soundTypeStone).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:lava_stone");

		LavaCobble = new LavaCobble(Material.ground).setBlockName("LavaCobble").setHardness(2.0F).setResistance(10F)
				.setLightLevel(1.0F).setStepSound(Block.soundTypeStone).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:lava_cobblestone");

		LavaObsidian = new LavaObsidian(Material.ground).setBlockName("LavaObsidian").setHardness(50.0F)
				.setResistance(2000F).setLightLevel(1.0F).setStepSound(Block.soundTypeStone).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:lava_obsidian");

		CrystalBlock = new CrystalBlock(Material.ground).setBlockName("CrystalBlock").setHardness(5.0F)
				.setResistance(30F).setLightOpacity(1).setStepSound(Block.soundTypeGlass).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:crystal_block");

		SmelterIdle = new Smelter(Material.iron, false).setBlockName("SmelterIdle").setHardness(5f).setResistance(30f)
				.setCreativeTab(IDT);

		SmelterActive = new Smelter(Material.iron, true).setBlockName("SmelterActive").setLightLevel(1)
				.setResistance(30f).setHardness(5f);

		SteelBlock = new SteelBlock(Material.iron).setHardness(10F).setResistance(30F).setBlockName("SteelBlock")
				.setStepSound(Block.soundTypeMetal).setCreativeTab(IDT).setBlockTextureName("mod_IDT:steel_block");

		TitaniumBlock = new TitaniumBlock(Material.iron).setHardness(15F).setResistance(35F)
				.setBlockName("TitaniumBlock").setStepSound(Block.soundTypeMetal).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:titanium_block");

		DidymiumGlass = new ModGlass(Material.glass).setHardness(29F).setResistance(35F).setBlockName("DidymiumGlass")
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setBlockTextureName("mod_IDT:didymium_glass");

		DidymiumGlassPane = new ModGlassPane("mod_IDT:didymium_glass", "mod_IDT:didymium_glass", Material.glass, true)
				.setHardness(25F).setResistance(29F).setBlockName("DidymiumGlassPane")
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT);

		EinsteiniumGlass = new ModGlass(Material.glass).setHardness(5f).setResistance(15f)
				.setBlockName("EinsteiniumGlass").setStepSound(Block.soundTypeGlass).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:einsteinium_glass");

		EinsteiniumGlassPane = new ModGlassPane("mod_IDT:einsteinium_glass", "mod_IDT:einsteinium_glass",
				Material.glass, true).setHardness(5f).setResistance(15f).setBlockName("EinsteiniumGlassPane")
						.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT);

		NeptuniumGlass = new ModGlass(Material.glass).setHardness(5f).setResistance(15f).setBlockName("NeptuniumGlass")
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setBlockTextureName("mod_IDT:neptunium_glass");

		NeptuniumGlassPane = new ModGlassPane("mod_IDT:neptunium_glass", "mod_IDT:neptunium_glass", Material.glass,
				true).setHardness(5f).setResistance(15f).setBlockName("NeptuniumGlassPane")
						.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT);

		UraniumGlass = new ModGlass(Material.glass).setHardness(5f).setResistance(15f).setBlockName("UraniumGlass")
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setBlockTextureName("mod_IDT:uranium_glass");

		UraniumGlassPane = new ModGlassPane("mod_IDT:uranium_glass", "mod_IDT:uranium_glass", Material.glass, true)
				.setHardness(5f).setResistance(15f).setBlockName("UraniumGlassPane").setStepSound(Block.soundTypeGlass)
				.setCreativeTab(IDT);

		IndustrialCutter = new IndustrialCutter(Material.ground).setHardness(10F).setResistance(30F).setBlockName("IC")
				.setStepSound(Block.soundTypeMetal).setCreativeTab(IDT);

		MatterCondenser = new MatterCondenser(Material.iron).setHardness(10F).setResistance(100F)
				.setBlockName("MatterCondenser").setStepSound(Block.soundTypeStone).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:titanium_block");

		DarkMatter = new DarkMatter(Material.ground, true).setHardness(30F).setResistance(1500F)
				.setBlockName("DarkMatter").setCreativeTab(IDT).setStepSound(Block.soundTypeCloth)
				.setBlockTextureName("mod_IDT:dark_matter");

		ZNG = new ZNG(Material.iron).setBlockName("ZNG").setResistance(30f).setCreativeTab(IDT)
				.setStepSound(Block.soundTypeMetal).setBlockTextureName("mod_IDT:steel_block");

		TitaniumFrame = new TitaniumFrame(Material.iron).setBlockName("TitaniumFrame").setCreativeTab(IDT)
				.setStepSound(Block.soundTypeMetal).setBlockTextureName("mod_IDT:titanium_block").setResistance(25f);

		StableBlackHole = new SBH(Material.ground).setBlockName("StableBlackHole").setCreativeTab(IDT)
				.setStepSound(Block.soundTypeSnow).setResistance(7000000f).setBlockTextureName("mod_idt:sbh")
				.setBlockUnbreakable();

		EinsteiniumCoreReactor = new EinsteiniumCoreReactor(Material.iron).setBlockName("EinsteiniumCoreReactor")
				.setStepSound(Block.soundTypeMetal).setBlockTextureName("mod_IDT:titanium_block").setCreativeTab(IDT)
				.setResistance(32f);

		NeptuniumCoreReactor = new NeptuniumCoreReactor(Material.iron).setBlockName("NeptuniumCoreReactor")
				.setCreativeTab(IDT).setStepSound(Block.soundTypeMetal).setBlockTextureName("mod_IDT:titanium_block")
				.setResistance(32f);

		UraniumCoreReactor = new UraniumCoreReactor(Material.iron).setBlockName("UraniumCoreReactor")
				.setCreativeTab(IDT).setStepSound(Block.soundTypeMetal).setBlockTextureName("mod_IDT:titanium_block")
				.setResistance(32f);

		SuperReactor = new SuperReactor(Material.iron).setBlockName("SuperReactor").setCreativeTab(IDT)
				.setStepSound(Block.soundTypeMetal).setBlockTextureName("mod_IDT:titanium_block").setResistance(96f);

		BioFuelExtractor = new BioFuelExtractor(Material.iron).setBlockName("BioFuelExtractor").setCreativeTab(IDT)
				.setStepSound(Block.soundTypeMetal).setBlockTextureName("mod_IDT:titanium_block").setResistance(30f)
				.setHardness(3f);

		TankCompressor = new TankCompressor(Material.iron).setBlockName("TankCompressor").setCreativeTab(IDT)
				.setStepSound(Block.soundTypeMetal).setBlockTextureName("mod_IDT:titanium_block").setResistance(30f)
				.setHardness(3f);

		CompactCobblestone = new ModBlocks(Material.rock).setBlockName("CompactCobblestone").setHardness(5f)
				.setResistance(15f).setCreativeTab(IDT).setStepSound(Block.soundTypeStone)
				.setBlockTextureName("mod_IDT:compact_cobble");

		BlackHoleGenerator = new BHG(Material.ground).setBlockName("BHG").setHardness(5f).setResistance(35f)
				.setCreativeTab(IDT).setStepSound(Block.soundTypeStone).setBlockTextureName("mod_IDT:titanium_block");

		Welder = new Welder(Material.ground, false).setBlockName("Welder").setHardness(2f).setResistance(30f)
				.setCreativeTab(IDT).setStepSound(Block.soundTypeMetal).setBlockTextureName("mod_IDT:titanium_block");

		Magnetizer = new Magnetizer(Material.ground).setBlockName("Magnetizer").setHardness(2f).setResistance(30f)
				.setCreativeTab(IDT).setStepSound(Block.soundTypeMetal).setBlockTextureName("mod_IDT:titanium_block");

		Enricher = new Enricher(Material.ground).setBlockName("Enricher").setHardness(2f).setResistance(30f)
				.setCreativeTab(IDT).setStepSound(Block.soundTypeMetal).setBlockTextureName("mod_IDT:titanium_block");

		ZimphnodeWire = new ZimWire(Material.circuits).setBlockName("ZimWire").setHardness(1f).setResistance(5f)
				/* .setCreativeTab(IDT) */.setStepSound(Block.soundTypeStone).setBlockTextureName("mod_IDT:zimphnode");

		CopperBlock = new CopperBlock(Material.iron).setHardness(10F).setResistance(15F).setBlockName("CopperBlock")
				.setStepSound(Block.soundTypeMetal).setCreativeTab(IDT).setBlockTextureName("mod_IDT:copper_block");

		ReinforcedGlass = new ModGlass(Material.glass).setHardness(12f).setResistance(82f).setBlockName("RFGlass")
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setBlockTextureName("mod_IDT:glass_rf");

		ReinforcedGlassPane = new ModGlassPane("mod_IDT:glass_rf", "mod_IDT:glass_rf", Material.glass, true)
				.setHardness(12f).setResistance(82f).setBlockName("RFGlassPane").setStepSound(Block.soundTypeGlass)
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:glass_rf");

		SiliconBlock = new SiliconBlock(Material.iron).setHardness(5F).setResistance(18F).setBlockName("SiliconBlock")
				.setStepSound(Block.soundTypeMetal).setCreativeTab(IDT).setBlockTextureName("mod_IDT:silicon_block");

		VanadiumBlock = new VanadiumBlock(Material.iron).setHardness(20f).setResistance(35f)
				.setBlockName("VanadiumBlock").setStepSound(Block.soundTypeMetal).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:vanadium_block");

		VCBlock = new VanadiumBlock(Material.iron).setHardness(30f).setResistance(45f).setBlockName("VCBlock")
				.setStepSound(Block.soundTypeMetal).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:vanadium_carbide_block");

		TantalumBlock = new TantalumBlock(Material.iron).setHardness(18f).setResistance(32f)
				.setBlockName("TantalumBlock").setStepSound(Block.soundTypeMetal).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:tantalum_block");

		EinsteiniumBlock = new EinsteiniumBlock(Material.iron, true).setHardness(15f).setResistance(20f)
				.setLightLevel(0.5f).setBlockName("EinsteiniumBlock").setStepSound(Block.soundTypeMetal)
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:einsteinium_block");

		NeptuniumBlock = new NeptuniumBlock(Material.iron, true).setHardness(15f).setResistance(20f).setLightLevel(0.5f)
				.setBlockName("NeptuniumBlock").setStepSound(Block.soundTypeMetal).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:neptunium_block");

		UraniumBlock = new UraniumBlock(Material.iron, true).setHardness(15f).setResistance(20f).setLightLevel(0.5f)
				.setBlockName("UraniumBlock").setStepSound(Block.soundTypeMetal).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:uranium_block");

		PraseodymiumBlock = new PraseodymiumBlock(Material.iron).setHardness(18f).setResistance(23f)
				.setBlockName("PraseodymiumBlock").setStepSound(Block.soundTypeMetal).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:praseodymium_block");

		NeodymiumBlock = new NeodymiumBlock(Material.iron).setHardness(18f).setResistance(23f)
				.setBlockName("NeodymiumBlock").setStepSound(Block.soundTypeMetal).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:neodymium_block");

		BoronBlock = new BoronBlock(Material.iron).setHardness(18f).setResistance(20f).setBlockName("BoronBlock")
				.setStepSound(Block.soundTypeMetal).setCreativeTab(IDT).setBlockTextureName("mod_IDT:boron_block");

		SulfurBlock = new SulfurBlock(Material.iron, true).setHardness(10f).setResistance(15f)
				.setBlockName("SulfurBlock").setStepSound(Block.soundTypeMetal).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:sulfur_block");

		ZimphnodeBlock = new ZimphnodeBlock(Material.iron).setHardness(18f).setResistance(20f).setLightLevel(0.8f)
				.setBlockName("ZimphnodeBlock").setStepSound(Block.soundTypeMetal).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:zimphnode");

		NeoronBlock = new NeoronBlock(Material.iron).setHardness(15f).setResistance(18f).setBlockName("NeoronBlock")
				.setStepSound(Block.soundTypeMetal).setBlockTextureName("mod_IDT:neoron_block").setCreativeTab(IDT);

		// Fires
		FrozenFire = new FrozenFire(Material.ground);
		CrystalFire = new CrystalFire(Material.ground);

		// Doors
		BirchDoor = new BirchDoor(Material.wood).setBlockName("BirchDoor").setStepSound(Block.soundTypeWood)
				.setHardness(3F).setResistance(5f);

		SpruceDoor = new SpruceDoor(Material.wood).setBlockName("SpruceDoor").setStepSound(Block.soundTypeWood)
				.setHardness(3F).setResistance(5f);

		JungleDoor = new JungleDoor(Material.wood).setBlockName("JungleDoor").setStepSound(Block.soundTypeWood)
				.setHardness(3F).setResistance(5f);

		WillowDoor = new WillowDoor(Material.wood).setBlockName("WillowDoor").setStepSound(Block.soundTypeWood)
				.setHardness(3F).setResistance(5f);

		EbonyDoor = new EbonyDoor(Material.wood).setBlockName("EbonyDoor").setStepSound(Block.soundTypeWood)
				.setHardness(3F).setResistance(5f);

		SilkwoodDoor = new SilkwoodDoor(Material.wood).setBlockName("SilkwoodDoor").setStepSound(Block.soundTypeWood)
				.setHardness(3F).setResistance(5f);

		AcaciaDoor = new AcaciaDoor(Material.wood).setBlockName("AcaciaDoor").setStepSound(Block.soundTypeWood)
				.setHardness(3F).setResistance(5f);

		DarkOakDoor = new DarkOakDoor(Material.wood).setBlockName("DarkOakDoor").setStepSound(Block.soundTypeWood)
				.setHardness(3F).setResistance(5f);

		GelidDoor = new GelidDoor(Material.wood).setBlockName("GelidDoor").setStepSound(Block.soundTypeWood)
				.setHardness(3F).setResistance(5f);

		// Walls
		StoneWall = new StoneWall(Blocks.stone).setHardness(1.5F).setStepSound(Block.soundTypeStone).setResistance(10F)
				.setBlockName("StoneWall").setCreativeTab(IDT);

		SandStoneWall = new SandStoneWall(Blocks.sandstone).setHardness(0.8F).setResistance(10f)
				.setStepSound(Block.soundTypeStone).setBlockName("SandStoneWall").setCreativeTab(IDT);

		ObsidianWall = new ObsidianWall(Blocks.obsidian).setHardness(25F).setResistance(1000F)
				.setStepSound(Block.soundTypeStone).setBlockName("ObsidianWall").setCreativeTab(IDT);

		CementWall = new CementWall(Blocks.stone).setHardness(2F).setResistance(10F).setStepSound(Block.soundTypeStone)
				.setBlockName("CementWall").setCreativeTab(IDT);

		CementBrickWall = new CementBrickWall(Blocks.stone).setHardness(2f).setResistance(10f)
				.setStepSound(Block.soundTypeStone).setBlockName("CementBrickWall").setCreativeTab(IDT);

		SnowWall = new SnowWall(Blocks.snow).setHardness(0.2F).setResistance(3f).setStepSound(Block.soundTypeSnow)
				.setBlockName("SnowWall").setCreativeTab(IDT);

		NetherBrickWall = new NetherBrickWall(Blocks.nether_brick).setHardness(2F).setResistance(10F)
				.setStepSound(Block.soundTypeStone).setBlockName("NetherBrickWall").setCreativeTab(IDT);

		StoneBrickWall = new StoneBrickWall(Blocks.stonebrick).setHardness(1.5F).setResistance(10F)
				.setStepSound(Block.soundTypeStone).setBlockName("StoneBrickWall").setCreativeTab(IDT);

		BrickWall = new BrickWall(Blocks.brick_block).setHardness(2F).setResistance(10F)
				.setStepSound(Block.soundTypeStone).setBlockName("BrickWall").setCreativeTab(IDT);

		QuartzWall = new QuartzWall(Blocks.quartz_block).setHardness(0.8F).setResistance(10f)
				.setStepSound(Block.soundTypeStone).setBlockName("QuartzWall").setCreativeTab(IDT);

		CoalWall = new CoalWall(Blocks.coal_block).setHardness(4F).setResistance(10F).setStepSound(Block.soundTypeStone)
				.setBlockName("CoalWall").setCreativeTab(IDT);

		// Wooden
		OakWall = new OakWall(Blocks.planks).setHardness(2f).setResistance(5f).setStepSound(Block.soundTypeWood)
				.setBlockName("OakWall").setCreativeTab(IDT);

		BirchWall = new BirchWall(Blocks.planks).setHardness(2f).setResistance(5f).setStepSound(Block.soundTypeWood)
				.setBlockName("BirchWall").setCreativeTab(IDT);

		SpruceWall = new SpruceWall(Blocks.planks).setHardness(2f).setResistance(5f).setStepSound(Block.soundTypeWood)
				.setBlockName("SpruceWall").setCreativeTab(IDT);

		JungleWall = new JungleWall(Blocks.planks).setHardness(2f).setResistance(5f).setStepSound(Block.soundTypeWood)
				.setBlockName("JungleWall").setCreativeTab(IDT);

		WillowWall = new WillowWall(Blocks.planks).setHardness(2f).setResistance(5f).setStepSound(Block.soundTypeWood)
				.setBlockName("WillowWall").setCreativeTab(IDT);

		EbonyWall = new EbonyWall(Blocks.planks).setHardness(2f).setResistance(5f).setStepSound(Block.soundTypeWood)
				.setBlockName("EbonyWall").setCreativeTab(IDT);

		SilkwoodWall = new SilkwoodWall(Blocks.planks).setHardness(2f).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setBlockName("SilkwoodWall").setCreativeTab(IDT);

		AcaciaWall = new AcaciaWall(Blocks.planks).setHardness(2f).setResistance(5f).setStepSound(Block.soundTypeWood)
				.setBlockName("AcaciaWall").setCreativeTab(IDT);

		DarkOakWall = new DarkOakWall(Blocks.planks).setHardness(2f).setResistance(5f).setStepSound(Block.soundTypeWood)
				.setBlockName("DarkOakWall").setCreativeTab(IDT);

		GelidWall = new GelidWall(Blocks.planks).setHardness(2f).setResistance(5f).setStepSound(Block.soundTypeWood)
				.setBlockName("GelidWall").setCreativeTab(IDT);

		// Liquids
		LiquidNitrogenF = new Fluid("LiquidNitrogen").setTemperature(77);
		FluidRegistry.registerFluid(LiquidNitrogenF);
		LiquidNitrogen = new LiquidNitrogen(LiquidNitrogenF, Material.water).setBlockName("LiquidNitrogen");

		// Pressure Plates
		BirchPressurePlate = new ModPressurePlates("planks_birch", Material.wood, Sensitivity.everything)
				.setCreativeTab(IDT).setBlockName("BirchPressurePlate").setResistance(0.8f);

		SprucePressurePlate = new ModPressurePlates("planks_spruce", Material.wood, Sensitivity.everything)
				.setCreativeTab(IDT).setBlockName("SprucePressurePlate").setResistance(0.8f);

		JunglePressurePlate = new ModPressurePlates("planks_jungle", Material.wood, Sensitivity.everything)
				.setCreativeTab(IDT).setBlockName("JunglePressurePlate").setResistance(0.8f);

		WillowPressurePlate = new ModPressurePlates("mod_IDT:planks_willow", Material.wood, Sensitivity.everything)
				.setCreativeTab(IDT).setBlockName("WillowPressurePlate").setResistance(0.8f);

		EbonyPressurePlate = new ModPressurePlates("mod_IDT:planks_ebony", Material.wood, Sensitivity.everything)
				.setCreativeTab(IDT).setBlockName("EbonyPressurePlate").setResistance(0.8f);

		SilkwoodPressurePlate = new ModPressurePlates("mod_IDT:planks_silkwood", Material.wood, Sensitivity.everything)
				.setCreativeTab(IDT).setBlockName("SilkwoodPressurePlate").setResistance(0.8f);

		AcaciaPressurePlate = new ModPressurePlates("planks_acacia", Material.wood, Sensitivity.everything)
				.setCreativeTab(IDT).setBlockName("AcaciaPressurePlate").setResistance(0.8f);

		DarkOakPressurePlate = new ModPressurePlates("planks_big_oak", Material.wood, Sensitivity.everything)
				.setCreativeTab(IDT).setBlockName("DarkOakPressurePlate").setResistance(0.8f);

		GelidPressurePlate = new ModPressurePlates("mod_IDT:planks_gelid", Material.wood, Sensitivity.everything)
				.setCreativeTab(IDT).setBlockName("GelidPressurePlate").setResistance(0.8f);

		// Buttons
		BirchButton = new BirchButton(true).setCreativeTab(IDT).setBlockName("BirchButton")
				.setBlockTextureName("planks_birch").setResistance(0.8f);

		SpruceButton = new SpruceButton(true).setCreativeTab(IDT).setBlockName("SpruceButton")
				.setBlockTextureName("planks_spruce").setResistance(0.8f);

		JungleButton = new JungleButton(true).setCreativeTab(IDT).setBlockName("JungleButton")
				.setBlockTextureName("planks_jungle").setResistance(0.8f);

		WillowButton = new WillowButton(true).setCreativeTab(IDT).setBlockName("WillowButton")
				.setBlockTextureName("mod_IDT:planks_willow").setResistance(0.8f);

		EbonyButton = new EbonyButton(true).setCreativeTab(IDT).setBlockName("EbonyButton")
				.setBlockTextureName("mod_IDT:planks_ebony").setResistance(0.8f);

		SilkwoodButton = new SilkwoodButton(true).setCreativeTab(IDT).setBlockName("SilkwoodButton")
				.setBlockTextureName("mod_IDT:planks_silkwood").setResistance(0.8f);

		AcaciaButton = new AcaciaButton(true).setCreativeTab(IDT).setBlockName("AcaciaButton")
				.setBlockTextureName("planks_acacia").setResistance(0.8f);

		DarkOakButton = new DarkOakButton(true).setCreativeTab(IDT).setBlockName("DarkOakButton")
				.setBlockTextureName("planks_big_oak").setResistance(0.8f);

		GelidButton = new GelidButton(true).setCreativeTab(IDT).setBlockName("GelidButton")
				.setBlockTextureName("mod_IDT:planks_gelid").setResistance(0.8f);

		// Logs
		WillowLog = new WillowLog().setCreativeTab(IDT).setBlockName("WillowLog").setResistance(3.333f);

		EbonyLog = new EbonyLog().setCreativeTab(IDT).setBlockName("EbonyLog").setResistance(3.333f);

		SilkwoodLog = new SilkwoodLog().setCreativeTab(IDT).setBlockName("SilkwoodLog").setResistance(3.333f);

		GelidLog = new GelidLog().setCreativeTab(IDT).setBlockName("GelidLog").setResistance(3.333f);

		// Planks
		WillowPlanks = new WillowPlanks().setHardness(2F).setResistance(5F).setStepSound(Block.soundTypeWood)
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:planks_willow").setBlockName("WillowPlanks");

		EbonyPlanks = new EbonyPlanks().setHardness(2F).setResistance(5F).setStepSound(Block.soundTypeWood)
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:planks_ebony").setBlockName("EbonyPlanks");

		SilkwoodPlanks = new SilkwoodPlanks().setHardness(2F).setResistance(5F).setStepSound(Block.soundTypeWood)
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:planks_silkwood").setBlockName("SilkwoodPlanks");

		GelidPlanks = new GelidPlanks().setHardness(2f).setResistance(5f).setStepSound(Block.soundTypeWood)
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:planks_gelid").setBlockName("GelidPlanks");

		// Leaves
		WillowLeaves = new WillowLeaves().setBlockName("leaves_willow").setBlockTextureName("leaves").setHardness(0.2F)
				.setResistance(.333f).setStepSound(Block.soundTypeGrass).setCreativeTab(IDT).setLightOpacity(1);

		EbonyLeaves = new EbonyLeaves().setBlockName("leaves_ebony").setBlockTextureName("leaves").setHardness(0.2F)
				.setResistance(.333f).setStepSound(Block.soundTypeGrass).setCreativeTab(IDT).setLightOpacity(1);

		SilkwoodLeaves = new SilkwoodLeaves().setBlockName("leaves_silkwood").setBlockTextureName("leaves")
				.setHardness(.2F).setResistance(.333f).setStepSound(Block.soundTypeGrass).setCreativeTab(IDT)
				.setLightOpacity(1);

		GelidLeaves = new GelidLeaves().setBlockName("leaves_gelid").setBlockTextureName("leaves").setHardness(.2f)
				.setResistance(.333f).setStepSound(Block.soundTypeGrass).setCreativeTab(IDT).setLightOpacity(1);

		// Saplings
		WillowSapling = new WillowSapling().setBlockName("sapling_willow").setBlockTextureName("mod_IDT:sapling_willow")
				.setLightOpacity(1);

		EbonySapling = new EbonySapling().setBlockName("sapling_ebony").setBlockTextureName("mod_IDT:sapling_ebony")
				.setLightOpacity(1);

		SilkwoodSapling = new SilkwoodSapling().setBlockName("sapling_silkwood")
				.setBlockTextureName("mod_IDT:sapling_silkwood").setLightOpacity(1);

		GelidSapling = new GelidSapling().setBlockName("splaing_gelid").setBlockTextureName("mod_IDT:sapling_gelid")
				.setLightOpacity(1);

		// Slabs
		WillowSlab = new ModSlab(false, Material.wood).setHardness(2.0F).setResistance(10.0F)
				.setStepSound(Block.soundTypeWood).setBlockName("WillowSlab")
				.setBlockTextureName("mod_IDT:planks_willow").setCreativeTab(IDT);

		WillowDoubleSlab = new ModSlab(true, Material.wood).setHardness(2.0F).setResistance(10.0F)
				.setStepSound(Block.soundTypeWood).setBlockName("WillowDoubleSlab")
				.setBlockTextureName("mod_IDT:planks_willow");

		GlassSlab = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlab").setCreativeTab(IDT)
				.setBlockTextureName("glass").setLightOpacity(1);

		GlassDoubleSlab = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlab").setBlockTextureName("glass")
				.setLightOpacity(1);

		CementSlab = new ModSlab(false, Material.rock).setHardness(2.0F).setResistance(10.0F)
				.setStepSound(Block.soundTypeStone).setBlockName("CementSlab").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:cement");

		CementDoubleSlab = new ModSlab(true, Material.rock).setHardness(2.0F).setResistance(10.0F)
				.setStepSound(Block.soundTypeStone).setBlockName("CementDoubleSlab")
				.setBlockTextureName("mod_IDT:cement");

		CementBrickSlab = new ModSlab(false, Material.rock).setHardness(2f).setResistance(10f)
				.setStepSound(Block.soundTypeStone).setBlockName("CementBrickSlab").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:cement_bricks");

		CementBrickDoubleSlab = new ModSlab(true, Material.rock).setHardness(2f).setResistance(10f)
				.setStepSound(Block.soundTypeStone).setBlockName("CementBrickDoubleSlab")
				.setBlockTextureName("mod_IDT:cement_bricks");

		StoneSlab = new ModSlab(false, Material.rock).setHardness(2.0F).setResistance(10.0F)
				.setStepSound(Block.soundTypeStone).setBlockName("StoneSlab").setCreativeTab(IDT)
				.setBlockTextureName("stone");

		StoneDoubleSlab = new ModSlab(true, Material.rock).setHardness(2.0F).setResistance(10.0F)
				.setStepSound(Block.soundTypeStone).setBlockName("StoneDoubleSlab").setBlockTextureName("stone");

		EbonySlab = new ModSlab(false, Material.wood).setHardness(2.0F).setResistance(10.0F)
				.setStepSound(Block.soundTypeWood).setBlockName("EbonySlab").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:planks_ebony");

		EbonyDoubleSlab = new ModSlab(true, Material.wood).setHardness(2.0F).setResistance(10.0F)
				.setStepSound(Block.soundTypeWood).setBlockName("EbonyDoubleSlab")
				.setBlockTextureName("mod_IDT:planks_ebony");

		SilkwoodSlab = new ModSlab(false, Material.wood).setHardness(2.0F).setResistance(10.0F)
				.setStepSound(Block.soundTypeWood).setBlockName("SilkwoodSlab").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:planks_silkwood");

		SilkwoodDoubleSlab = new ModSlab(true, Material.wood).setHardness(2.0F).setResistance(10.0F)
				.setStepSound(Block.soundTypeWood).setBlockName("SilkwoodDoubleSlab")
				.setBlockTextureName("mod_IDT:planks_silkwood");

		GelidSlab = new ModSlab(false, Material.wood).setHardness(2f).setResistance(10f)
				.setStepSound(Block.soundTypeWood).setBlockName("GelidSlab").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:planks_gelid");

		GelidDoubleSlab = new ModSlab(true, Material.wood).setHardness(2.0F).setResistance(10.0F)
				.setStepSound(Block.soundTypeWood).setBlockName("GelidDoubleSlab")
				.setBlockTextureName("mod_IDT:planks_gelid");

		// Colored Slabs
		GlassSlabWhite = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabWhite").setCreativeTab(IDT)
				.setBlockTextureName("glass_white").setLightOpacity(1);

		GlassDoubleSlabWhite = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabWhite")
				.setBlockTextureName("glass_white").setLightOpacity(1);

		GlassSlabOrange = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabOrange").setCreativeTab(IDT)
				.setBlockTextureName("glass_orange").setLightOpacity(1);

		GlassDoubleSlabOrange = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabOrange")
				.setBlockTextureName("glass_orange").setLightOpacity(1);

		GlassSlabMagenta = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabMagenta").setCreativeTab(IDT)
				.setBlockTextureName("glass_magenta").setLightOpacity(1);

		GlassDoubleSlabMagenta = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabMagenta")
				.setBlockTextureName("glass_magenta").setLightOpacity(1);

		GlassSlabLightBlue = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabLightBlue").setCreativeTab(IDT)
				.setBlockTextureName("glass_light_blue").setLightOpacity(1);

		GlassDoubleSlabLightBlue = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabLightBlue")
				.setBlockTextureName("glass_light_blue").setLightOpacity(1);

		GlassSlabYellow = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabYellow").setCreativeTab(IDT)
				.setBlockTextureName("glass_yellow").setLightOpacity(1);

		GlassDoubleSlabYellow = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabYellow")
				.setBlockTextureName("glass_yellow").setLightOpacity(1);

		GlassSlabLime = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabLime").setCreativeTab(IDT)
				.setBlockTextureName("glass_lime").setLightOpacity(1);

		GlassDoubleSlabLime = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabLime")
				.setBlockTextureName("glass_lime").setLightOpacity(1);

		GlassSlabPink = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabPink").setCreativeTab(IDT)
				.setBlockTextureName("glass_pink").setLightOpacity(1);

		GlassDoubleSlabPink = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabPink")
				.setBlockTextureName("glass_pink").setLightOpacity(1);

		GlassSlabGray = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabGray").setCreativeTab(IDT)
				.setBlockTextureName("glass_gray").setLightOpacity(1);

		GlassDoubleSlabGray = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabGray")
				.setBlockTextureName("glass_gray").setLightOpacity(1);

		GlassSlabLightGray = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabLightGray").setCreativeTab(IDT)
				.setBlockTextureName("glass_silver").setLightOpacity(1);

		GlassDoubleSlabLightGray = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabLightGray")
				.setBlockTextureName("glass_silver").setLightOpacity(1);

		GlassSlabCyan = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabCyan").setCreativeTab(IDT)
				.setBlockTextureName("glass_cyan").setLightOpacity(1);

		GlassDoubleSlabCyan = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabCyan")
				.setBlockTextureName("glass_cyan").setLightOpacity(1);

		GlassSlabPurple = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabPurple").setCreativeTab(IDT)
				.setBlockTextureName("glass_purple").setLightOpacity(1);

		GlassDoubleSlabPurple = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabPurple")
				.setBlockTextureName("glass_purple").setLightOpacity(1);

		GlassSlabBlue = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabBlue").setCreativeTab(IDT)
				.setBlockTextureName("glass_blue").setLightOpacity(1);

		GlassDoubleSlabBlue = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabBlue")
				.setBlockTextureName("glass_blue").setLightOpacity(1);

		GlassSlabBrown = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabBrown").setCreativeTab(IDT)
				.setBlockTextureName("glass_brown").setLightOpacity(1);

		GlassDoubleSlabBrown = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabBrown")
				.setBlockTextureName("glass_brown").setLightOpacity(1);

		GlassSlabGreen = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabGreen").setCreativeTab(IDT)
				.setBlockTextureName("glass_green").setLightOpacity(1);

		GlassDoubleSlabGreen = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabGreen")
				.setBlockTextureName("glass_green").setLightOpacity(1);

		GlassSlabRed = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabRed").setCreativeTab(IDT)
				.setBlockTextureName("glass_red").setLightOpacity(1);

		GlassDoubleSlabRed = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabRed").setBlockTextureName("glass_red")
				.setLightOpacity(1);

		GlassSlabBlack = new ModSlab(false, Material.glass).setHardness(1.0F).setResistance(2.0F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassSlabBlack").setCreativeTab(IDT)
				.setBlockTextureName("glass_black").setLightOpacity(1);

		GlassDoubleSlabBlack = new ModSlab(true, Material.glass).setHardness(1.6F).setResistance(2.6F)
				.setStepSound(Block.soundTypeGlass).setBlockName("GlassDoubleSlabBlack")
				.setBlockTextureName("glass_black").setLightOpacity(1);

		// Fences
		BirchFence = new BirchFence("planks_birch", Material.wood).setStepSound(Block.soundTypeWood).setHardness(2F)
				.setResistance(5f).setCreativeTab(IDT).setBlockName("BirchFence");

		SpruceFence = new SpruceFence("planks_spruce", Material.wood).setStepSound(Block.soundTypeWood)
				.setResistance(5f).setHardness(2F).setCreativeTab(IDT).setBlockName("SpruceFence");

		JungleFence = new JungleFence("planks_jungle", Material.wood).setStepSound(Block.soundTypeWood)
				.setResistance(5f).setHardness(2F).setCreativeTab(IDT).setBlockName("JungleFence");

		WillowFence = new WillowFence("mod_IDT:planks_willow", Material.wood).setStepSound(Block.soundTypeWood)
				.setResistance(5f).setHardness(2F).setCreativeTab(IDT).setBlockName("WillowFence");

		EbonyFence = new EbonyFence("mod_IDT:planks_ebony", Material.wood).setStepSound(Block.soundTypeWood)
				.setResistance(5f).setHardness(2F).setCreativeTab(IDT).setBlockName("EbonyFence");

		SilkwoodFence = new SilkwoodFence("mod_IDT:planks_silkwood", Material.wood).setStepSound(Block.soundTypeWood)
				.setResistance(5f).setHardness(2F).setCreativeTab(IDT).setBlockName("SilkwoodFence");

		AcaciaFence = new AcaciaFence("planks_acacia", Material.wood).setStepSound(Block.soundTypeWood)
				.setResistance(5f).setHardness(2F).setCreativeTab(IDT).setBlockName("AcaciaFence");

		DarkOakFence = new DarkOakFence("planks_big_oak", Material.wood).setStepSound(Block.soundTypeWood)
				.setResistance(5f).setHardness(2F).setCreativeTab(IDT).setBlockName("DarkOakFence");

		GelidFence = new GelidFence("mod_IDT:planks_gelid", Material.wood).setStepSound(Block.soundTypeWood)
				.setResistance(5f).setHardness(2f).setCreativeTab(IDT).setBlockName("GelidFence");

		// Fence Gates
		BirchFenceGate = new BirchFenceGate().setBlockName("BirchGate").setHardness(2F).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		SpruceFenceGate = new SpruceFenceGate().setBlockTextureName("planks_spruce").setBlockName("SpruceGate")
				.setHardness(2F).setResistance(5f).setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		JungleFenceGate = new JungleFenceGate().setBlockName("JungleGate").setHardness(2F).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		WillowFenceGate = new WillowFenceGate().setBlockName("WillowGate").setHardness(2F).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		EbonyFenceGate = new EbonyFenceGate().setBlockName("EbonyGate").setHardness(2F).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		SilkwoodFenceGate = new SilkwoodFenceGate().setBlockName("SilkwoodGate").setHardness(2F).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		AcaciaFenceGate = new AcaciaFenceGate().setBlockName("AcaciaGate").setHardness(2F).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		DarkOakFenceGate = new DarkOakFenceGate().setBlockName("DarkOakGate").setHardness(2F).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		GelidFenceGate = new GelidFenceGate().setBlockName("GelidGate").setHardness(2f).setResistance(5f)
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		// Stairs
		WillowStairs = new ModWoodStairs(WillowPlanks, 0).setHardness(2.0F).setStepSound(Block.soundTypeWood)
				.setCreativeTab(IDT).setBlockName("WillowStairs").setLightOpacity(0);

		GlassStairs = new ModStairs(Blocks.glass, 0).setBlockName("GlassStairs").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		StoneStairs = new ModStairs(Blocks.stone, 0).setBlockName("StoneStairs").setHardness(2.0F)
				.setStepSound(Block.soundTypeStone).setCreativeTab(IDT).setLightOpacity(0);

		CementStairs = new ModStairs(Cement, 0).setBlockName("CementStairs").setHardness(1.5F).setResistance(5.0F)
				.setStepSound(Block.soundTypeStone).setCreativeTab(IDT).setLightOpacity(0);

		CementBrickStairs = new ModStairs(CementBricks, 0).setBlockName("CementBrickStairs").setHardness(1.5f)
				.setResistance(5f).setStepSound(Block.soundTypeStone).setCreativeTab(IDT).setLightOpacity(0);

		EbonyStairs = new ModWoodStairs(EbonyPlanks, 0).setHardness(2.0F).setStepSound(Block.soundTypeWood)
				.setCreativeTab(IDT).setBlockName("EbonyStairs").setLightOpacity(0);

		CrystalStairs = new ModStairs(CrystalBlock, 0).setHardness(5.0F).setStepSound(Block.soundTypeGlass)
				.setCreativeTab(IDT).setBlockName("CrystalStairs").setLightOpacity(1);

		SilkwoodStairs = new ModWoodStairs(SilkwoodPlanks, 0).setHardness(2.0F).setStepSound(Block.soundTypeWood)
				.setCreativeTab(IDT).setBlockName("SilkwoodStairs").setLightOpacity(0);

		GelidStairs = new ModWoodStairs(GelidPlanks, 0).setHardness(2f).setStepSound(Block.soundTypeWood)
				.setCreativeTab(IDT).setBlockName("GelidStairs").setLightOpacity(0);

		// Colored Stairs
		GlassStairsWhite = new ModStairs(Blocks.stained_glass, 0).setBlockName("GlassStairsWhite").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsOrange = new ModStairs(Blocks.stained_glass, 1).setBlockName("GlassStairsOrange").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsMagenta = new ModStairs(Blocks.stained_glass, 2).setBlockName("GlassStairsMagenta").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsLightBlue = new ModStairs(Blocks.stained_glass, 3).setBlockName("GlassStairsLightBlue")
				.setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsYellow = new ModStairs(Blocks.stained_glass, 4).setBlockName("GlassStairsYellow").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsLime = new ModStairs(Blocks.stained_glass, 5).setBlockName("GlassStairsLime").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsPink = new ModStairs(Blocks.stained_glass, 6).setBlockName("GlassStairsPink").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsGray = new ModStairs(Blocks.stained_glass, 7).setBlockName("GlassStairsGray").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsLightGray = new ModStairs(Blocks.stained_glass, 8).setBlockName("GlassStairsLightGray")
				.setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsCyan = new ModStairs(Blocks.stained_glass, 9).setBlockName("GlassStairsCyan").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsPurple = new ModStairs(Blocks.stained_glass, 10).setBlockName("GlassStairsPurple").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsBlue = new ModStairs(Blocks.stained_glass, 11).setBlockName("GlassStairsBlue").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsBrown = new ModStairs(Blocks.stained_glass, 12).setBlockName("GlassStairsBrown").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsGreen = new ModStairs(Blocks.stained_glass, 13).setBlockName("GlassStairsGreen").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsRed = new ModStairs(Blocks.stained_glass, 14).setBlockName("GlassStairsRed").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		GlassStairsBlack = new ModStairs(Blocks.stained_glass, 15).setBlockName("GlassStairsBlack").setHardness(0.3F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setLightOpacity(1);

		// Torches
		BirchTorch = new ModTorch().setHardness(0.0F).setLightLevel(0.9375F).setStepSound(Block.soundTypeWood)
				.setBlockName("BirchTorch").setCreativeTab(IDT).setBlockTextureName("mod_IDT:torch_birch");

		SpruceTorch = new ModTorch().setHardness(0.0F).setLightLevel(0.9375F).setStepSound(Block.soundTypeWood)
				.setBlockName("SpruceTorch").setCreativeTab(IDT).setBlockTextureName("mod_IDT:torch_spruce");

		JungleTorch = new ModTorch().setHardness(0.0F).setLightLevel(0.9375F).setStepSound(Block.soundTypeWood)
				.setBlockName("JungleTorch").setCreativeTab(IDT).setBlockTextureName("mod_IDT:torch_jungle");

		WillowTorch = new ModTorch().setHardness(0.0F).setLightLevel(0.9375F).setStepSound(Block.soundTypeWood)
				.setBlockName("WillowTorch").setCreativeTab(IDT).setBlockTextureName("mod_IDT:torch_willow");

		EbonyTorch = new ModTorch().setHardness(0.0F).setLightLevel(0.9375F).setStepSound(Block.soundTypeWood)
				.setBlockName("EbonyTorch").setCreativeTab(IDT).setBlockTextureName("mod_IDT:torch_ebony");

		SilkwoodTorch = new ModTorch().setHardness(0.0F).setLightLevel(0.9375F).setStepSound(Block.soundTypeWood)
				.setBlockName("SilkwoodTorch").setCreativeTab(IDT).setBlockTextureName("mod_IDT:torch_silkwood");

		AcaciaTorch = new ModTorch().setHardness(0.0F).setLightLevel(0.9375F).setStepSound(Block.soundTypeWood)
				.setBlockName("AcaciaTorch").setCreativeTab(IDT).setBlockTextureName("mod_IDT:torch_acacia");

		DarkOakTorch = new ModTorch().setHardness(0.0F).setLightLevel(0.9375F).setStepSound(Block.soundTypeWood)
				.setBlockName("DarkOakTorch").setCreativeTab(IDT).setBlockTextureName("mod_IDT:torch_dark_oak");

		GelidTorch = new ModTorch().setHardness(0f).setLightLevel(.9375f).setStepSound(Block.soundTypeWood)
				.setBlockName("GelidTorch").setCreativeTab(IDT).setBlockTextureName("mod_IDT:torch_gelid");

		// Redstone Torches
		BirchRedTorch = new BirchRedTorch(false).setHardness(0.0F).setStepSound(Block.soundTypeWood).setBlockName("BRT")
				.setBlockTextureName("mod_IDT:red_torch_birch").setCreativeTab(null);

		SpruceRedTorch = new SpruceRedTorch(false).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("SRT").setBlockTextureName("mod_IDT:red_torch_spruce").setCreativeTab(null);

		JungleRedTorch = new JungleRedTorch(false).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("JRT").setBlockTextureName("mod_IDT:red_torch_jungle").setCreativeTab(null);

		WillowRedTorch = new WillowRedTorch(false).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("WRT").setBlockTextureName("mod_IDT:red_torch_willow").setCreativeTab(null);

		EbonyRedTorch = new EbonyRedTorch(false).setHardness(0.0F).setStepSound(Block.soundTypeWood).setBlockName("ERT")
				.setBlockTextureName("mod_IDT:red_torch_ebony").setCreativeTab(null);

		SilkwoodRedTorch = new SilkwoodRedTorch(false).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("SWRT").setBlockTextureName("mod_IDT:red_torch_silkwood").setCreativeTab(null);

		AcaciaRedTorch = new AcaciaRedTorch(false).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("ART").setBlockTextureName("mod_IDT:red_torch_acacia").setCreativeTab(null);

		DarkOakRedTorch = new DarkOakRedTorch(false).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("DORT").setBlockTextureName("mod_IDT:red_torch_dark_oak").setCreativeTab(null);

		GelidRedTorch = new GelidRedTorch(false).setHardness(0f).setStepSound(Block.soundTypeWood).setBlockName("GRT")
				.setBlockTextureName("mod_IDT:red_torch_gelid").setCreativeTab(null);

		// On
		BirchRedTorchOn = new BirchRedTorch(true).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("BRTO").setLightLevel(0.5F).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:red_torch_on_birch");

		SpruceRedTorchOn = new SpruceRedTorch(true).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("SRTO").setLightLevel(0.5F).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:red_torch_on_spruce");

		JungleRedTorchOn = new JungleRedTorch(true).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("JRTO").setLightLevel(0.5F).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:red_torch_on_jungle");

		WillowRedTorchOn = new WillowRedTorch(true).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("WRTO").setLightLevel(0.5F).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:red_torch_on_willow");

		EbonyRedTorchOn = new EbonyRedTorch(true).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("ERTO").setLightLevel(0.5F).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:red_torch_on_ebony");

		SilkwoodRedTorchOn = new SilkwoodRedTorch(true).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("SWRTO").setLightLevel(0.5F).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:red_torch_on_silkwood");

		AcaciaRedTorchOn = new AcaciaRedTorch(true).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("ARTO").setLightLevel(0.5F).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:red_torch_on_acacia");

		DarkOakRedTorchOn = new DarkOakRedTorch(true).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("DORTO").setLightLevel(0.5F).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:red_torch_on_dark_oak");

		GelidRedTorchOn = new GelidRedTorch(true).setHardness(0f).setStepSound(Block.soundTypeWood).setBlockName("GRTO")
				.setLightLevel(.5f).setCreativeTab(IDT).setBlockTextureName("mod_IDT:red_torch_on_gelid");

		// Frost Dimension
		FrostGrass = new FrostGrass().setBlockName("FrostGrass").setHardness(0.6F).setResistance(2f)
				.setStepSound(Block.soundTypeGrass).setBlockTextureName("mod_IDT:frost_grass").setCreativeTab(IDT);

		FrostDirt = new FrostyBlocks(Material.ground).setBlockName("FrostDirt").setHardness(0.5F).setResistance(2f)
				.setStepSound(Block.soundTypeGravel).setBlockTextureName("mod_IDT:frost_dirt").setCreativeTab(IDT);

		FrostStone = new FrozenStone(Material.ground).setBlockName("FrostStone").setHardness(1.5F).setResistance(15F)
				.setStepSound(Block.soundTypeStone).setBlockTextureName("mod_IDT:frost_stone").setCreativeTab(IDT);

		FrostCobble = new FrostyBlocks(Material.ground).setBlockName("FrostCobble").setHardness(2F).setResistance(15F)
				.setStepSound(Block.soundTypeStone).setBlockTextureName("mod_IDT:frost_cobble").setCreativeTab(IDT);

		// Ores
		EinsteiniumOre = new EinsteiniumOre(true).setBlockName("EinsteiniumOre").setHardness(3F).setResistance(5F)
				.setLightLevel(0.5F).setStepSound(Block.soundTypeStone).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:ore_einsteinium");

		UraniumOre = new UraniumOre(true).setBlockName("UraniumOre").setHardness(3.0F).setResistance(5.0F)
				.setLightLevel(0.5F).setStepSound(Block.soundTypeStone).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:ore_uranium");

		NeptuniumOre = new NeptuniumOre(true).setBlockName("NeptuniumOre").setHardness(3.0F).setResistance(5.0F)
				.setLightLevel(0.5F).setStepSound(Block.soundTypeStone).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:ore_neptunium");

		CrystalOre = new CrystalOre().setBlockName("CrystalOre").setHardness(3.0F).setResistance(5F)
				.setStepSound(Block.soundTypeGlass).setCreativeTab(IDT).setBlockTextureName("mod_IDT:ore_crystal");

		PraseodymiumOre = new PraseodymiumOre().setBlockName("PraOre").setHardness(3.5F).setResistance(5.5F)
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:ore_praseodymium");

		NeodymiumOre = new NeodymiumOre().setBlockName("NeoOre").setHardness(3.5F).setResistance(5F).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:ore_neodymium");

		VanadiumOre = new VanadiumOre().setBlockName("VanOre").setHardness(4f).setResistance(7f).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:ore_vanadium");

		ZimphnodeOre = new Zimphnode().setBlockName("Zimphnode").setCreativeTab(IDT).setStepSound(Block.soundTypeStone)
				.setHardness(3F).setResistance(20F).setLightLevel(.8F).setBlockTextureName("mod_IDT:zimphnode_ore");

		TantalumOre = new TantalumOre().setBlockName("TantOre").setHardness(3f).setResistance(7f).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:ore_tantalum");

		SulfurOre = new SulfurOre(true).setBlockName("SulfurOre").setHardness(1.5f).setResistance(5f)
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:ore_sulfur");

		BoronOre = new BoronOre().setBlockName("BoronOre").setHardness(2f).setResistance(5f).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:ore_boron");

		CopperOre = new CopperOre().setBlockName("CopperOre").setHardness(2.5f).setResistance(5f).setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:ore_copper");

		TitaniumOre = new TitaniumOre().setBlockName("TitaniumOre").setHardness(3f).setResistance(5f)
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:ore_titanium");

		Phosphorite = new Phosphorite().setBlockName("Phosphorite").setHardness(2f).setResistance(4f)
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:ore_phosphorite");

		// Bombs
		EinsteiniumBomb = new EinsteiniumBomb().setBlockName("EinsteiniumBomb").setHardness(1.0F)
				.setStepSound(Block.soundTypeMetal).setCreativeTab(IDT).setBlockTextureName("iron_block");

		UraniumBomb = new UraniumBomb().setBlockName("UraniumBomb").setHardness(1.0F).setStepSound(Block.soundTypeMetal)
				.setCreativeTab(IDT).setBlockTextureName("iron_block");

		NeptuniumBomb = new NeptuniumBomb().setBlockName("NeptuniumBomb").setHardness(1.0F)
				.setStepSound(Block.soundTypeMetal).setCreativeTab(IDT).setBlockTextureName("iron_block");

		UltimateNuker = new UltimateNuker().setBlockName("UltimateNuker").setHardness(1.0F)
				.setStepSound(Block.soundTypeMetal).setCreativeTab(IDT).setBlockTextureName("iron_block");

		DarkMatterBomb = new DarkMatterBomb().setBlockName("DarkMatterBomb").setHardness(1.0F)
				.setStepSound(Block.soundTypeMetal).setCreativeTab(IDT).setBlockTextureName("mod_IDT:dark_matter");

		// Crops
		CornCrop = new CornCrop().setBlockName("CornCrop").setHardness(0.0F).setBlockTextureName("mod_IDT:corn");

		SoyBeanCrop = new SoyBeanCrop().setBlockName("SoyBeanCrop").setHardness(0.0F)
				.setBlockTextureName("mod_IDT:soybean");

		// Chests
		BirchChest = new BirchChest(0).setBlockName("BirchChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		BirchTrapChest = new BirchChest(1).setBlockName("BirchTrapChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		SpruceChest = new SpruceChest(0).setBlockName("SpruceChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		SpruceTrapChest = new SpruceChest(1).setBlockName("SpruceTrapChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		JungleChest = new JungleChest(0).setBlockName("JungleChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		JungleTrapChest = new JungleChest(1).setBlockName("JungleTrapChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		WillowChest = new WillowChest(0).setBlockName("WillowChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		WillowTrapChest = new WillowChest(1).setBlockName("WillowTrapChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		EbonyChest = new EbonyChest(0).setBlockName("EbonyChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		EbonyTrapChest = new EbonyChest(1).setBlockName("EbonyTrapChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		DarkMatterChest = new DarkMatterChest(0).setBlockName("DarkMatterChest").setCreativeTab(IDT).setHardness(2.8F)
				.setResistance(2000f).setStepSound(Block.soundTypeCloth);

		SilkwoodChest = new SilkwoodChest(0).setBlockName("SilkwoodChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		SilkwoodTrapChest = new SilkwoodChest(1).setBlockName("SilkwoodTrapChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		AcaciaChest = new AcaciaChest(0).setBlockName("AcaciaChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		AcaciaTrapChest = new AcaciaChest(1).setBlockName("AcaciaTrapChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		DarkOakChest = new DarkOakChest(0).setBlockName("DarkOakChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		DarkOakTrapChest = new DarkOakChest(1).setBlockName("DarkOakTrapChest").setCreativeTab(IDT).setHardness(2.5F)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		GelidChest = new GelidChest(0).setBlockName("GelidChest").setCreativeTab(IDT).setHardness(2.5f)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		GelidTrapChest = new GelidChest(1).setBlockName("GelidTrapChest").setCreativeTab(IDT).setHardness(2.5f)
				.setResistance(5f).setStepSound(Block.soundTypeWood);

		// Trapdoors
		BirchTrapdoor = new ModTrapdoor(Material.wood).setBlockName("BirchTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:trapdoor_birch").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		SpruceTrapdoor = new ModTrapdoor(Material.wood).setBlockName("SpruceTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:trapdoor_spruce").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		JungleTrapdoor = new ModTrapdoor(Material.wood).setBlockName("JungleTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:trapdoor_jungle").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		WillowTrapdoor = new ModTrapdoor(Material.wood).setBlockName("WillowTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:trapdoor_willow").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		EbonyTrapdoor = new ModTrapdoor(Material.wood).setBlockName("EbonyTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:trapdoor_ebony").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		SilkwoodTrapdoor = new ModTrapdoor(Material.wood).setBlockName("SilkwoodTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:trapdoor_silkwood").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		AcaciaTrapdoor = new ModTrapdoor(Material.wood).setBlockName("AcaciaTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:trapdoor_acacia").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		DarkOakTrapdoor = new ModTrapdoor(Material.wood).setBlockName("DarkOakTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:trapdoor_dark_oak").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		CementTrapdoor = new ModTrapdoor(Material.ground).setBlockName("CementTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:trapdoor_cement").setStepSound(Block.soundTypeStone).setHardness(2f)
				.setResistance(5f);

		CementBrickTrapdoor = new ModTrapdoor(Material.ground).setBlockName("CementBrickTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:trapdoor_cement_brick").setStepSound(Block.soundTypeStone)
				.setHardness(2.5f).setResistance(5f);

		StoneTrapdoor = new ModTrapdoor(Material.rock).setBlockName("StoneTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:trapdoor_stone").setStepSound(Block.soundTypeStone).setHardness(1.5f)
				.setResistance(5f);

		CobblestoneTrapdoor = new ModTrapdoor(Material.rock).setBlockName("CobblestoneTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:trapdoor_cobblestone").setStepSound(Block.soundTypeStone).setHardness(2f)
				.setResistance(5f);

		MossyCobblestoneTrapdoor = new ModTrapdoor(Material.rock).setBlockName("MossyCobblestoneTrapdoor")
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:trapdoor_mossy_cobblestone")
				.setStepSound(Block.soundTypeStone).setHardness(2f).setResistance(5f);

		StonebrickTrapdoor = new ModTrapdoor(Material.rock).setBlockName("StonebrickTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:trapdoor_stonebrick").setStepSound(Block.soundTypeStone).setHardness(1.5f)
				.setResistance(5f);

		MossyStonebrickTrapdoor = new ModTrapdoor(Material.rock).setBlockName("MossyStonebrickTrapdoor")
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:trapdoor_mossy_stonebrick")
				.setStepSound(Block.soundTypeStone).setHardness(1.5f).setResistance(5f);

		CrackedStonebrickTrapdoor = new ModTrapdoor(Material.rock).setBlockName("CrackedStonebrickTrapdoor")
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:trapdoor_cracked_stonebrick")
				.setStepSound(Block.soundTypeStone).setHardness(1.5f).setResistance(5f);

		ChiseledStonebrickTrapdoor = new ModTrapdoor(Material.rock).setBlockName("ChiseledStonebrickTrapdoor")
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:trapdoor_chiseled_stonebrick")
				.setStepSound(Block.soundTypeStone).setHardness(1.5f).setResistance(5f);

		GelidTrapdoor = new ModTrapdoor(Material.wood).setBlockName("GelidTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:trapdoor_gelid").setStepSound(Block.soundTypeWood).setHardness(3f)
				.setResistance(5f);

		// Secret Trapdoors
		SecretOakTrapdoor = new ModTrapdoor(Material.wood).setBlockName("SecretOakTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("planks_oak").setStepSound(Block.soundTypeWood).setHardness(3F).setResistance(5f);

		SecretBirchTrapdoor = new ModTrapdoor(Material.wood).setBlockName("SecretBirchTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("planks_birch").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		SecretSpruceTrapdoor = new ModTrapdoor(Material.wood).setBlockName("SecretSpruceTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("planks_spruce").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		SecretJungleTrapdoor = new ModTrapdoor(Material.wood).setBlockName("SecretJungleTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("planks_jungle").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		SecretWillowTrapdoor = new ModTrapdoor(Material.wood).setBlockName("SecretWillowTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:planks_willow").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		SecretEbonyTrapdoor = new ModTrapdoor(Material.wood).setBlockName("SecretEbonyTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:planks_ebony").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		SecretSilkwoodTrapdoor = new ModTrapdoor(Material.wood).setBlockName("SecretSilkwoodTrapdoor")
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:planks_silkwood").setStepSound(Block.soundTypeWood)
				.setHardness(3F).setResistance(5f);

		SecretAcaciaTrapdoor = new ModTrapdoor(Material.wood).setBlockName("SecretAcaciaTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("planks_acacia").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		SecretDarkOakTrapdoor = new ModTrapdoor(Material.wood).setBlockName("SecretDarkOakTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("planks_big_oak").setStepSound(Block.soundTypeWood).setHardness(3F)
				.setResistance(5f);

		SecretCementTrapdoor = new ModTrapdoor(Material.ground).setBlockName("SecretCementTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:cement").setStepSound(Block.soundTypeStone).setHardness(2f)
				.setResistance(5f);

		SecretCementBrickTrapdoor = new ModTrapdoor(Material.ground).setBlockName("SecretCementBrickTrapdoor")
				.setCreativeTab(IDT).setBlockTextureName("mod_IDT:cement_bricks").setStepSound(Block.soundTypeStone)
				.setHardness(2.5f).setResistance(5f);

		SecretStoneTrapdoor = new ModTrapdoor(Material.rock).setBlockName("SecretStoneTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("stone").setStepSound(Block.soundTypeStone).setHardness(1.5f).setResistance(5f);

		SecretCobblestoneTrapdoor = new ModTrapdoor(Material.rock).setBlockName("SecretCobblestoneTrapdoor")
				.setCreativeTab(IDT).setBlockTextureName("cobblestone").setStepSound(Block.soundTypeStone)
				.setHardness(2f).setResistance(5f);

		SecretMossyCobblestoneTrapdoor = new ModTrapdoor(Material.rock).setBlockName("SecretMossyCobblestoneTrapdoor")
				.setCreativeTab(IDT).setBlockTextureName("cobblestone_mossy").setStepSound(Block.soundTypeStone)
				.setHardness(2f).setResistance(5f);

		SecretStonebrickTrapdoor = new ModTrapdoor(Material.rock).setBlockName("SecretStonebrickTrapdoor")
				.setCreativeTab(IDT).setBlockTextureName("stonebrick").setStepSound(Block.soundTypeStone)
				.setHardness(1.5f).setResistance(5f);

		SecretMossyStonebrickTrapdoor = new ModTrapdoor(Material.rock).setBlockName("SecretMossyStonebrickTrapdoor")
				.setCreativeTab(IDT).setBlockTextureName("stonebrick_mossy").setStepSound(Block.soundTypeStone)
				.setHardness(1.5f).setResistance(5f);

		SecretCrackedStonebrickTrapdoor = new ModTrapdoor(Material.rock).setBlockName("SecretCrackedStonebrickTrapdoor")
				.setCreativeTab(IDT).setBlockTextureName("stonebrick_cracked").setStepSound(Block.soundTypeStone)
				.setHardness(1.5f).setResistance(5f);

		SecretChiseledStonebrickTrapdoor = new ModTrapdoor(Material.rock)
				.setBlockName("SecretChiseledStonebrickTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("stonebrick_carved").setStepSound(Block.soundTypeStone).setHardness(1.5f)
				.setResistance(5f);

		SecretGelidTrapdoor = new ModTrapdoor(Material.wood).setBlockName("SecretGelidTrapdoor").setCreativeTab(IDT)
				.setBlockTextureName("mod_IDT:planks_gelid").setStepSound(Block.soundTypeWood).setHardness(3f)
				.setResistance(5f);

		// Levers
		BirchLever = new ModLever().setHardness(0.5F).setBlockName("BirchLever")
				.setBlockTextureName("mod_IDT:lever_birch").setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		SpruceLever = new ModLever().setBlockName("SpruceLever").setBlockTextureName("mod_IDT:lever_spruce")
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		JungleLever = new ModLever().setBlockName("JungleLever").setBlockTextureName("mod_IDT:lever_jungle")
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		WillowLever = new ModLever().setBlockName("WillowLever").setBlockTextureName("mod_IDT:lever_willow")
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		EbonyLever = new ModLever().setBlockName("EbonyLever").setBlockTextureName("mod_IDT:lever_ebony")
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		SilkwoodLever = new ModLever().setBlockName("SilkwoodLever").setBlockTextureName("mod_IDT:lever_silkwood")
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		AcaciaLever = new ModLever().setBlockName("AcaciaLever").setBlockTextureName("mod_IDT:lever_acacia")
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		DarkOakLever = new ModLever().setBlockName("DarkOakLever").setBlockTextureName("mod_IDT:lever_dark_oak")
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		GelidLever = new ModLever().setBlockName("GelidLever").setBlockTextureName("mod_IDT:lever_gelid")
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		// Crafting Tables
		BirchCraftingTable = new BirchWorkbench().setHardness(2.5F).setResistance(5f).setBlockName("BirchCraftingTable")
				.setBlockTextureName("mod_IDT:birch").setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		SpruceCraftingTable = new SpruceWorkbench().setHardness(2.5F).setResistance(5f)
				.setBlockName("SpruceCraftingTable").setBlockTextureName("mod_IDT:spruce")
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		JungleCraftingTable = new JungleWorkbench().setHardness(2.5F).setResistance(5f)
				.setBlockName("JungleCraftingTable").setBlockTextureName("mod_IDT:jungle")
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		WillowCraftingTable = new WillowWorkbench().setHardness(2.5F).setResistance(5f)
				.setBlockName("WillowCraftingTable").setBlockTextureName("mod_IDT:willow")
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		EbonyCraftingTable = new EbonyWorkbench().setHardness(2.5F).setResistance(5f).setBlockName("EbonyCraftingTable")
				.setBlockTextureName("mod_IDT:ebony").setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		IDTCraftingTable = new IDTWorkbench().setHardness(2.5F).setResistance(5f).setBlockName("IDTCraftingTable")
				.setBlockTextureName("planks_wood").setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		SilkwoodCraftingTable = new SilkwoodWorkbench().setHardness(2.5F).setResistance(5f)
				.setBlockName("SilkwoodCraftingTable").setBlockTextureName("mod_IDT:silkwood")
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		AcaciaCraftingTable = new AcaciaWorkbench().setHardness(2.5F).setResistance(5f)
				.setBlockName("AcaciaCraftingTable").setBlockTextureName("acacia").setStepSound(Block.soundTypeWood)
				.setCreativeTab(IDT);

		DarkOakCraftingTable = new DarkOakWorkbench().setHardness(2.5F).setResistance(5f)
				.setBlockName("DarkOakCraftingTable").setBlockTextureName("dark_oak").setStepSound(Block.soundTypeWood)
				.setCreativeTab(IDT);

		GelidCraftingTable = new GelidCraftingTable().setHardness(2.5f).setResistance(5f)
				.setBlockName("GelidCraftingTable").setBlockTextureName("mod_IDT:planks_gelid")
				.setStepSound(Block.soundTypeWood).setCreativeTab(IDT);

		// Ladders
		BirchLadder = new ModLadder().setBlockName("BirchLadder").setHardness(0.4F).setResistance(0.5f)
				.setStepSound(Block.soundTypeLadder).setBlockTextureName("mod_IDT:ladder_birch").setCreativeTab(IDT);

		SpruceLadder = new ModLadder().setBlockName("SpruceLadder").setHardness(0.4F).setResistance(0.5f)
				.setStepSound(Block.soundTypeLadder).setBlockTextureName("mod_IDT:ladder_spruce").setCreativeTab(IDT);

		JungleLadder = new ModLadder().setBlockName("JungleLadder").setHardness(0.4F).setResistance(0.5f)
				.setStepSound(Block.soundTypeLadder).setBlockTextureName("mod_IDT:ladder_jungle").setCreativeTab(IDT);

		WillowLadder = new ModLadder().setBlockName("WillowLadder").setHardness(0.4F).setResistance(0.5f)
				.setStepSound(Block.soundTypeLadder).setBlockTextureName("mod_IDT:ladder_willow").setCreativeTab(IDT);

		EbonyLadder = new ModLadder().setBlockName("EbonyLadder").setHardness(0.4F).setResistance(0.5f)
				.setStepSound(Block.soundTypeLadder).setBlockTextureName("mod_IDT:ladder_ebony").setCreativeTab(IDT);

		SilkwoodLadder = new ModLadder().setBlockName("SilkwoodLadder").setHardness(0.4F).setResistance(0.5f)
				.setStepSound(Block.soundTypeLadder).setBlockTextureName("mod_IDT:ladder_silkwood").setCreativeTab(IDT);

		AcaciaLadder = new ModLadder().setBlockName("AcaciaLadder").setHardness(0.4F).setResistance(0.5f)
				.setStepSound(Block.soundTypeLadder).setBlockTextureName("mod_IDT:ladder_acacia").setCreativeTab(IDT);

		DarkOakLadder = new ModLadder().setBlockName("DarkOakLadder").setHardness(0.4F).setResistance(0.5f)
				.setStepSound(Block.soundTypeLadder).setBlockTextureName("mod_IDT:ladder_dark_oak").setCreativeTab(IDT);

		GelidLadder = new ModLadder().setBlockName("GelidLadder").setHardness(0.4f).setResistance(0.5f)
				.setStepSound(Block.soundTypeLadder).setBlockTextureName("mod_IDT:ladder_gelid").setCreativeTab(IDT);

		// Portals
		FrozenPortal = new FrozenPortal().setBlockName("FrozenPortal").setBlockUnbreakable();

		CrystalPortal = new CrystalPortal().setBlockName("CrystalPortal").setBlockUnbreakable();
		// log.info("Blocks loaded.");

		// TODO: Items
		// Other
		StoneBrick = new Item().setTextureName("mod_IDT:stone_brick").setCreativeTab(IDTItems)
				.setUnlocalizedName("StoneBrick");

		ExplosiveCharge = new Item().setTextureName("mod_IDT:explosive_charge").setCreativeTab(IDTItems)
				.setUnlocalizedName("ExplosiveCharge");

		WikiPaper = new WikiPaper().setTextureName("map_filled").setCreativeTab(IDTItems)
				.setUnlocalizedName("WikiPaper");

		IceShard = new Item().setTextureName("mod_IDT:ice_shard").setCreativeTab(IDTItems)
				.setUnlocalizedName("IceShard");

		ZimphnodeBar = new Item().setTextureName("mod_IDT:zimphnode_bar").setCreativeTab(IDTItems)
				.setUnlocalizedName("ZimphnodeBar");

		IronSawBlade = new IronSawBlade().setTextureName("mod_IDT:saw_blade_iron").setCreativeTab(IDTItems)
				.setUnlocalizedName("IronSawBlade");

		SteelSawBlade = new SteelSawBlade().setTextureName("mod_IDT:saw_blade_steel").setCreativeTab(IDTItems)
				.setUnlocalizedName("SteelSawBlade");

		TitaniumSawBlade = new TitaniumSawBlade().setTextureName("mod_IDT:saw_blade_titanium").setCreativeTab(IDTItems)
				.setUnlocalizedName("TitaniumSawBlade");

		DiamondSawBlade = new DiamondSawBlade().setTextureName("mod_IDT:saw_blade_diamond").setCreativeTab(IDTItems)
				.setUnlocalizedName("DiamondSawBlade");

		Gear = new Item().setTextureName("mod_IDT:gear").setCreativeTab(IDTItems).setUnlocalizedName("Gear");

		EmptyTank = new ModItems().setTextureName("mod_IDT:empty_tank").setCreativeTab(IDTItems)
				.setUnlocalizedName("EmptyTank");

		PropaneTank = new PropaneTank().setTextureName("mod_IDT:propane_tank").setCreativeTab(IDTItems)
				.setUnlocalizedName("PropaneTank");

		CompressorUnit = new Item().setTextureName("mod_IDT:compressor_unit").setCreativeTab(IDTItems)
				.setUnlocalizedName("CompressorUnit");

		SteelRod = new Item().setTextureName("mod_IDT:steel_rod").setCreativeTab(IDTItems)
				.setUnlocalizedName("SteelRod");

		TitaniumPlate = new Item().setTextureName("mod_IDT:plate_titanium").setCreativeTab(IDTItems)
				.setUnlocalizedName("TitaniumPlate");

		Flask = new Flask().setTextureName("mod_IDT:flask").setCreativeTab(IDTItems).setUnlocalizedName("Flask");

		NdMagnet = new NdMagnet().setTextureName("mod_IDT:nd_magnet").setCreativeTab(IDTItems)
				.setUnlocalizedName("NdMagnet");

		CompressorUnitGA = new Item().setTextureName("mod_IDT:compressor_unit_ga").setCreativeTab(IDTItems)
				.setUnlocalizedName("CompressorUnitGA");

		VanadiumPlate = new Item().setTextureName("mod_IDT:plate_vanadium").setCreativeTab(IDTItems)
				.setUnlocalizedName("VPlate");

		BlowTorch = new Shovel(ToolMaterial.IRON).setTextureName("mod_IDT:blowtorch").setCreativeTab(IDTItems)
				.setUnlocalizedName("BlowTorch");

		DarkMatterPiece = new Item().setTextureName("mod_IDT:piece_dark_matter").setCreativeTab(IDTItems)
				.setUnlocalizedName("DMPiece");

		CopperPlate = new Item().setTextureName("mod_IDT:plate_copper").setCreativeTab(IDTItems)
				.setUnlocalizedName("CopperPlate");

		CopperWire = new Item().setTextureName("mod_IDT:wire_copper").setCreativeTab(IDTItems)
				.setUnlocalizedName("CopperWire");

		EinsteiniumCoreReactorItem = new EinsteiniumCoreReactorItem().setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:titanium_block").setUnlocalizedName("ECRI");

		/*
		 * NeptuniumCoreReactorItem = new
		 * NeptuniumCoreReactorItem(Material.iron).setBlockName(
		 * "NeptuniumCoreReactor")
		 * .setCreativeTab(IDTItems).setStepSound(Block.soundTypeMetal).
		 * setBlockTextureName("mod_IDT:titanium_block");
		 * 
		 * UraniumCoreReactorItem = new
		 * UraniumCoreReactorItem(Material.iron).setBlockName(
		 * "UraniumCoreReactor")
		 * .setCreativeTab(IDTItems).setStepSound(Block.soundTypeMetal).
		 * setBlockTextureName("mod_IDT:titanium_block");
		 * 
		 * SuperReactorItem = new
		 * SuperReactorItem(Material.iron).setBlockName("SuperReactor").
		 * setCreativeTab(IDT)
		 * .setStepSound(Block.soundTypeMetal).setBlockTextureName(
		 * "mod_IDT:titanium_block");
		 */

		Dyanamite = new Item();

		T1CircuitBoard = new T1CB().setTextureName("mod_IDT:board_circuit_t1").setCreativeTab(IDTItems)
				.setUnlocalizedName("T1CB");

		T2CircuitBoard = new T2CB().setTextureName("mod_IDT:board_circuit_t2").setCreativeTab(IDTItems)
				.setUnlocalizedName("T2CB");

		T3CircuitBoard = new T3CB().setTextureName("mod_IDT:board_circuit_t3").setCreativeTab(IDTItems)
				.setUnlocalizedName("T3CB");

		Transistor = new Item().setTextureName("mod_IDT:transistor").setCreativeTab(IDTItems)
				.setUnlocalizedName("Trans");

		Microchip = new Microchip().setTextureName("mod_IDT:microchip").setCreativeTab(IDTItems)
				.setUnlocalizedName("Microchip");

		Plank = new Item().setTextureName("mod_IDT:wooden_chip").setCreativeTab(IDTItems).setUnlocalizedName("Plank");

		CopperFoil = new Item().setTextureName("mod_IDT:foil_copper").setCreativeTab(IDTItems)
				.setUnlocalizedName("CopperFoil");

		Fiberglass = new Item().setTextureName("mod_IDT:fiberglass").setCreativeTab(IDTItems)
				.setUnlocalizedName("Fiberglass");

		BoronFG = new Item().setTextureName("mod_IDT:fiberglass_boron").setCreativeTab(IDTItems)
				.setUnlocalizedName("BoronFG");

		SiliconWafer = new Item().setTextureName("mod_IDT:wafer_silicon").setCreativeTab(IDTItems)
				.setUnlocalizedName("SiliconWafer");

		VanadiumWire = new Item().setTextureName("mod_IDT:wire_vanadium").setCreativeTab(IDTItems)
				.setUnlocalizedName("VanWire");

		TantalumPlate = new Item().setTextureName("mod_IDT:plate_tantalum").setCreativeTab(IDTItems)
				.setUnlocalizedName("TantPlate");

		TantalumFoil = new Item().setTextureName("mod_IDT:foil_tantalum").setCreativeTab(IDTItems)
				.setUnlocalizedName("TantFoil");

		QMan = new QMan().setTextureName("mod_IDT:board_q").setCreativeTab(IDTItems).setUnlocalizedName("QMan");

		PureQuartz = new Item().setTextureName("mod_IDT:pure_quartz").setCreativeTab(IDTItems)
				.setUnlocalizedName("PQuartz");

		PolePiece = new Item().setTextureName("mod_IDT:piece_pole").setCreativeTab(IDTItems)
				.setUnlocalizedName("PolePiece");

		Rotor = new Item().setTextureName("mod_IDT:rotor").setUnlocalizedName("Rotor").setCreativeTab(IDTItems);

		Stator = new Item().setTextureName("mod_IDT:stator").setUnlocalizedName("Stator").setCreativeTab(IDTItems);

		Alternator = new Item().setTextureName("mod_IDT:alternator").setUnlocalizedName("Alternator")
				.setCreativeTab(IDTItems);

		ChargeStone = new ChargeStone().setTextureName("mod_IDT:charge_stone").setUnlocalizedName("ChargeStone")
				.setCreativeTab(IDTItems);

		Pouch = new Pouch().setTextureName("mod_IDT:pouch").setUnlocalizedName("ChargeStone").setCreativeTab(IDTItems);

		SiliconChip = new Item().setTextureName("mod_IDT:chip_silicon").setUnlocalizedName("SiliconChip")
				.setCreativeTab(IDTItems);

		BSiliconChip = new Item().setTextureName("mod_IDT:chip_bsilicon").setUnlocalizedName("BSiliconChip")
				.setCreativeTab(IDTItems);

		PSiliconChip = new Item().setTextureName("mod_IDT:chip_psilicon").setUnlocalizedName("PSiliconChip")
				.setCreativeTab(IDTItems);

		// Upgrades
		UpgradeBase = new UpgradeBase().setTextureName("mod_IDT:upgrade_base").setCreativeTab(IDTItems)
				.setUnlocalizedName("UpBase");

		MagneticUpgrade = new MagneticUpgrade().setTextureName("mod_IDT:upgrade_magnetic").setCreativeTab(IDTItems)
				.setUnlocalizedName("UpMag");

		LaserUpgrade = new LaserUpgrade().setTextureName("mod_IDT:upgrade_laser").setUnlocalizedName("LaserUpgrade")
				.setCreativeTab(IDTItems);

		StabilizerUpgrade = new StabilizerUpgrade().setTextureName("mod_IDT:upgrade_stable")
				.setUnlocalizedName("StabilizerUpgrade").setCreativeTab(IDTItems);

		QCUpgrade = new QCUpgrade().setTextureName("mod_IDT:upgrade_qc").setUnlocalizedName("QCUpgrade")
				.setCreativeTab(IDTItems);

		// Dusts
		CopperDust = new Item().setTextureName("mod_IDT:dust_copper").setCreativeTab(IDTItems)
				.setUnlocalizedName("CopperDust");

		SiliconDust = new Item().setTextureName("mod_IDT:dust_silicon").setCreativeTab(IDTItems)
				.setUnlocalizedName("SiliconDust");

		VCDust = new Item().setTextureName("mod_IDT:dust_vc").setCreativeTab(IDTItems).setUnlocalizedName("VCDust");

		TitaniumDust = new Item().setTextureName("mod_IDT:dust_titanium").setCreativeTab(IDTItems)
				.setUnlocalizedName("TitaniumDust");

		PhosphorusDust = new Item().setTextureName("mod_IDT:dust_phosphorus").setCreativeTab(IDTItems)
				.setUnlocalizedName("PhosphorusDust");

		BoronDust = new Item().setTextureName("mod_IDT:dust_boron").setCreativeTab(IDTItems)
				.setUnlocalizedName("BoronDust");

		// Records
		cd_icy = new DiscIcy("8-bit Icy").setUnlocalizedName("cd_icy").setTextureName("mod_idt:cd_icy")
				.setCreativeTab(IDTItems);

		cd_23 = new Disc23("23").setUnlocalizedName("cd_23").setTextureName("mod_idt:cd_23").setCreativeTab(IDTItems);

		cd_r51 = new Discr51("r51vWLcxy9jo1Nvi").setUnlocalizedName("r51vWLcxy9jo1Nvi")
				.setTextureName("mod_idt:r51vWLcxy9jo1Nvi").setCreativeTab(IDTItems);

		// Chemistry Things
		Sulfur = new Item().setTextureName("mod_IDT:sulfur").setCreativeTab(IDTItems).setUnlocalizedName("Sulfur");

		SO2 = new SO2().setTextureName("mod_IDT:so2").setCreativeTab(IDTItems).setUnlocalizedName("SO2");

		SO3 = new SO3().setTextureName("mod_IDT:so3").setCreativeTab(IDTItems).setUnlocalizedName("SO3");

		H2SO4 = new H2SO4().setTextureName("mod_IDT:h2so4").setCreativeTab(IDTItems).setUnlocalizedName("H2SO4");

		NO2Tank = new NO2Tank().setTextureName("mod_IDT:no2_tank").setCreativeTab(IDTItems)
				.setUnlocalizedName("NO2Tank");

		HNO3 = new HNO3().setTextureName("mod_IDT:hno3").setCreativeTab(IDTItems).setUnlocalizedName("HNO3");

		VPowder = new Item().setTextureName("mod_IDT:vanadium_powder").setCreativeTab(IDTItems)
				.setUnlocalizedName("VPowder");

		V2O5 = new V2O5().setTextureName("mod_IDT:v2o5").setCreativeTab(IDTItems).setUnlocalizedName("V2O5");

		Nitroglycerin = new Nitroglycerin().setTextureName("mod_IDT:glycerin").setCreativeTab(IDTItems)
				.setUnlocalizedName("NG");

		Glycerin = new Glycerin().setTextureName("mod_IDT:glycerin").setCreativeTab(IDTItems)
				.setUnlocalizedName("Glycerin");

		Carbon = new Item().setTextureName("mod_IDT:carbon").setCreativeTab(IDTItems).setUnlocalizedName("Carbon");

		Acrolein = new Item().setTextureName("mod_IDT:glycerin").setCreativeTab(IDTItems)
				.setUnlocalizedName("Acrolein");

		Propanol = new Item().setTextureName("mod_IDT:propane_tank").setCreativeTab(IDTItems)
				.setUnlocalizedName("Propanol");

		Propene = new Item().setTextureName("mod_IDT:propane_tank").setCreativeTab(IDTItems)
				.setUnlocalizedName("Propene");

		Graphene = new Item().setTextureName("mod_IDT:graphene").setUnlocalizedName("Graphene")
				.setCreativeTab(IDTItems);

		// Liquids
		LiquidNitrogenBucket = new LiquidNitrogenBucket(LiquidNitrogen).setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:bucket_liquid_nitrogen").setMaxStackSize(1)
				.setUnlocalizedName("LiquidNitrogenBucket").setContainerItem(Items.bucket);

		// Wall Parts
		CementWallPart = new CementWallPart().setTextureName("mod_IDT:wall_part_cement").setCreativeTab(IDTItems)
				.setUnlocalizedName("CementWallPart");

		CementBrickWallPart = new CementBrickWallPart().setTextureName("mod_IDT:wall_part_cement_brick")
				.setCreativeTab(IDTItems).setUnlocalizedName("CementBrickWallPart");

		StoneWallPart = new StoneWallPart().setTextureName("mod_IDT:wall_part_stone").setCreativeTab(IDTItems)
				.setUnlocalizedName("StoneWallPart");

		CobblestoneWallPart = new CobblestoneWallPart().setTextureName("mod_IDT:wall_part_cobblestone")
				.setCreativeTab(IDTItems).setUnlocalizedName("CobblestoneWallPart");

		MossyCobblestoneWallPart = new MossyCobblestoneWallPart().setTextureName("mod_IDT:wall_part__mossy_cobblestone")
				.setCreativeTab(IDTItems).setUnlocalizedName("MossyCobblestoneWallPart");

		SandstoneWallPart = new SandstoneWallPart().setTextureName("mod_IDT:wall_part_sandstone")
				.setCreativeTab(IDTItems).setUnlocalizedName("SandstoneWallPart");

		ObsidianWallPart = new ObsidianWallPart().setTextureName("mod_IDT:wall_part_obsidian").setCreativeTab(IDTItems)
				.setUnlocalizedName("ObsidianWallPart");

		StonebrickWallPart = new StonebrickWallPart().setTextureName("mod_IDT:wall_part_stonebrick")
				.setCreativeTab(IDTItems).setUnlocalizedName("StoneBrickWallPart");

		BrickWallPart = new BrickWallPart().setTextureName("mod_IDT:wall_part_brick").setCreativeTab(IDTItems)
				.setUnlocalizedName("BrickWallPart");

		CoalWallPart = new CoalWallPart().setTextureName("mod_IDT:wall_part_coal").setCreativeTab(IDTItems)
				.setUnlocalizedName("CoalWallPart");

		SnowWallPart = new SnowWallPart().setTextureName("mod_IDT:wall_part_snow").setCreativeTab(IDTItems)
				.setUnlocalizedName("SnowWallPart");

		NetherBrickWallPart = new NetherBrickWallPart().setTextureName("mod_IDT:wall_part_nether_brick")
				.setCreativeTab(IDTItems).setUnlocalizedName("NetherBrickWallPart");

		QuartzWallPart = new QuartzWallPart().setTextureName("mod_IDT:wall_part_quartz").setCreativeTab(IDTItems)
				.setUnlocalizedName("QuartzWallPart");

		OakWallPart = new OakWallPart().setTextureName("mod_IDT:wall_part_oak").setCreativeTab(IDTItems)
				.setUnlocalizedName("OakWallPart");

		BirchWallPart = new BirchWallPart().setTextureName("mod_IDT:wall_part_birch").setCreativeTab(IDTItems)
				.setUnlocalizedName("BirchWallPart");

		SpruceWallPart = new SpruceWallPart().setTextureName("mod_IDT:wall_part_spruce").setCreativeTab(IDTItems)
				.setUnlocalizedName("SpruceWallPart");

		JungleWallPart = new JungleWallPart().setTextureName("mod_IDT:wall_part_jungle").setCreativeTab(IDTItems)
				.setUnlocalizedName("JungleWallPart");

		WillowWallPart = new WillowWallPart().setTextureName("mod_IDT:wall_part_willow").setCreativeTab(IDTItems)
				.setUnlocalizedName("WillowWallPart");

		EbonyWallPart = new EbonyWallPart().setTextureName("mod_IDT:wall_part_ebony").setCreativeTab(IDTItems)
				.setUnlocalizedName("EbonyWallPart");

		SilkwoodWallPart = new SilkwoodWallPart().setTextureName("mod_IDT:wall_part_silkwood").setCreativeTab(IDTItems)
				.setUnlocalizedName("SilkwoodWallPart");

		AcaciaWallPart = new AcaciaWallPart().setTextureName("mod_IDT:wall_part_acacia").setCreativeTab(IDTItems)
				.setUnlocalizedName("AcaciaWallPart");

		DarkOakWallPart = new DarkOakWallPart().setTextureName("mod_IDT:wall_part_dark_oak").setCreativeTab(IDTItems)
				.setUnlocalizedName("DarkOakWallPart");

		GelidWallPart = new GelidWallPart().setTextureName("mod_IDT:wall_part_gelid").setCreativeTab(IDTItems)
				.setUnlocalizedName("GelidWallPart");

		// Door Items
		BirchDoorItem = new BirchDoorItem(Material.wood).setCreativeTab(IDTItems).setTextureName("mod_IDT:door_birch")
				.setUnlocalizedName("BirchDoorItem");

		SpruceDoorItem = new SpruceDoorItem(Material.wood).setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:door_spruce").setUnlocalizedName("SpruceDoorItem");

		JungleDoorItem = new JungleDoorItem(Material.wood).setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:door_jungle").setUnlocalizedName("JungleDoorItem");

		WillowDoorItem = new WillowDoorItem(Material.wood).setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:door_willow").setUnlocalizedName("WillowDoorItem");

		EbonyDoorItem = new EbonyDoorItem(Material.wood).setCreativeTab(IDTItems).setTextureName("mod_IDT:door_ebony")
				.setUnlocalizedName("EbonyDoorItem");

		SilkwoodDoorItem = new SilkwoodDoorItem(Material.wood).setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:door_silkwood").setUnlocalizedName("SilkwoodDoorItem");

		AcaciaDoorItem = new AcaciaDoorItem(Material.wood).setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:door_acacia").setUnlocalizedName("AcaciaDoorItem");

		DarkOakDoorItem = new DarkOakDoorItem(Material.wood).setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:door_dark_oak").setUnlocalizedName("DarkOakDoorItem");

		GelidDoorItem = new GelidDoorItem(Material.wood).setCreativeTab(IDTItems).setTextureName("mod_IDT:door_gelid")
				.setUnlocalizedName("GelidDoorItem");

		// Ingots
		EinsteiniumIngot = new ModIngot().setTextureName("mod_IDT:ingot_einsteinium").setCreativeTab(IDTItems)
				.setUnlocalizedName("EinsteiniumIngot");

		UraniumIngot = new ModIngot().setTextureName("mod_IDT:ingot_uranium").setCreativeTab(IDTItems)
				.setUnlocalizedName("UraniumIngot");

		NeptuniumIngot = new ModIngot().setTextureName("mod_IDT:ingot_neptunium").setCreativeTab(IDTItems)
				.setUnlocalizedName("NeptuniumIngot");

		SteelIngot = new ModIngot().setCreativeTab(IDTItems).setTextureName("mod_IDT:ingot_steel")
				.setUnlocalizedName("SteelIngot");

		TitaniumIngot = new ModIngot().setTextureName("mod_IDT:ingot_titanium").setCreativeTab(IDTItems)
				.setUnlocalizedName("TitaniumIngot");

		PraseodymiumIngot = new ModIngot().setTextureName("mod_IDT:ingot_praseodymium").setCreativeTab(IDTItems)
				.setUnlocalizedName("PraIngot");

		NeodymiumIngot = new ModIngot().setTextureName("mod_IDT:ingot_neodymium").setCreativeTab(IDTItems)
				.setUnlocalizedName("NeoIngot");

		VanadiumIngot = new ModIngot().setTextureName("mod_IDT:ingot_vanadium").setCreativeTab(IDTItems)
				.setUnlocalizedName("VanIngot");

		TantalumIngot = new ModIngot().setTextureName("mod_IDT:ingot_tantalum").setCreativeTab(IDTItems)
				.setUnlocalizedName("TantIngot");

		NeoronIngot = new ModIngot().setTextureName("mod_IDT:ingot_neoron").setCreativeTab(IDTItems)
				.setUnlocalizedName("NeoronIngot");

		BoronIngot = new ModIngot().setTextureName("mod_IDT:ingot_boron").setCreativeTab(IDTItems)
				.setUnlocalizedName("BoronIngot");

		CopperIngot = new ModIngot().setTextureName("mod_IDT:ingot_copper").setCreativeTab(IDTItems)
				.setUnlocalizedName("CopperIngot");

		SiliconIngot = new ModIngot().setTextureName("mod_IDT:ingot_silicon").setCreativeTab(IDTItems)
				.setUnlocalizedName("SiliconIngot");

		VCIngot = new ModIngot().setTextureName("mod_IDT:ingot_vc").setCreativeTab(IDTItems)
				.setUnlocalizedName("VCIngot");

		// Crystals
		CrystalDust = new Item().setTextureName("mod_IDT:crystal_dust").setCreativeTab(IDTItems)
				.setUnlocalizedName("CrystalDust");

		CrystalGem = new Item().setTextureName("mod_IDT:crystal_gem").setCreativeTab(IDTItems)
				.setUnlocalizedName("CrystalGem");

		CrystalNugget = new Item().setTextureName("mod_IDT:crystal_nugget").setCreativeTab(IDTItems)
				.setUnlocalizedName("CrystalNugget");

		CrystalPiece = new Item().setTextureName("mod_IDT:crystal_piece").setCreativeTab(IDTItems)
				.setUnlocalizedName("CrystalPiece");

		CrystalBall = new Item().setTextureName("mod_IDT:crystal_ball").setCreativeTab(IDTItems)
				.setUnlocalizedName("CrystalBall");

		HardCrystalBall = new HardCrystalBall().setTextureName("mod_IDT:crystal_ball_hard").setCreativeTab(IDTItems)
				.setUnlocalizedName("HardCrystalBall");

		CutCrystalGem = new Item().setTextureName("mod_IDT:crystal_gem_cut").setCreativeTab(IDTItems)
				.setUnlocalizedName("CutCrystalGem");

		CrystalLens = new Item().setTextureName("mod_IDT:crystal_lens").setCreativeTab(IDTItems)
				.setUnlocalizedName("CrystalLens");

		CrystalRod = new Item().setTextureName("mod_IDT:crystal_rod").setCreativeTab(IDTItems)
				.setUnlocalizedName("CrystalRod");

		// Essence
		EssenceOfLife = new ModEssence().setTextureName("mod_IDT:essence_life").setCreativeTab(IDTItems)
				.setUnlocalizedName("EssenceOfLife");

		EssenceOfFire = new ModEssence().setTextureName("mod_IDT:essence_fire").setCreativeTab(IDTItems)
				.setUnlocalizedName("EssenceOfFire");

		EssenceOfWater = new ModEssence().setTextureName("mod_IDT:essence_water").setCreativeTab(IDTItems)
				.setUnlocalizedName("EssenceOfWater");

		EssenceOfEarth = new ModEssence().setTextureName("mod_IDT:essence_earth").setCreativeTab(IDTItems)
				.setUnlocalizedName("EssenceOfEarth");

		EssenceOfAir = new ModEssence().setTextureName("mod_IDT:essence_air").setCreativeTab(IDTItems)
				.setUnlocalizedName("EssenceOfAir");

		// Pure
		PureLifeEssence = new ModEssence().setTextureName("mod_IDT:essence_life_pure").setCreativeTab(IDTItems)
				.setUnlocalizedName("PureLifeEssence");

		PureFireEssence = new ModEssence().setTextureName("mod_IDT:essence_fire_pure").setCreativeTab(IDTItems)
				.setUnlocalizedName("PureFireEssence");

		PureWaterEssence = new ModEssence().setTextureName("mod_IDT:essence_water_pure").setCreativeTab(IDTItems)
				.setUnlocalizedName("PureWaterEssence");

		PureEarthEssence = new ModEssence().setTextureName("mod_IDT:essence_earth_pure").setCreativeTab(IDTItems)
				.setUnlocalizedName("PureEarthEssence");

		PureAirEssence = new ModEssence().setTextureName("mod_IDT:essence_air_pure").setCreativeTab(IDTItems)
				.setUnlocalizedName("PureAirEssence");

		EOTP = new ModEssence().setTextureName("mod_IDT:essence_pure").setCreativeTab(IDTItems)
				.setUnlocalizedName("EOTP");

		// Sticks
		BirchStick = new ModSticks().setTextureName("mod_IDT:stick_birch").setUnlocalizedName("BirchStick")
				.setCreativeTab(IDTItems);

		SpruceStick = new ModSticks().setTextureName("mod_IDT:stick_spruce").setUnlocalizedName("SpruceStick")
				.setCreativeTab(IDTItems);

		JungleStick = new ModSticks().setTextureName("mod_IDT:stick_jungle").setUnlocalizedName("JungleStick")
				.setCreativeTab(IDTItems);

		WillowStick = new ModSticks().setTextureName("mod_IDT:stick_willow").setUnlocalizedName("WillowStick")
				.setCreativeTab(IDTItems);

		EbonyStick = new ModSticks().setTextureName("mod_IDT:stick_ebony").setUnlocalizedName("EbonyStick")
				.setCreativeTab(IDTItems);

		SilkwoodStick = new ModSticks().setTextureName("mod_IDT:stick_silkwood").setUnlocalizedName("SilkwoodStick")
				.setCreativeTab(IDTItems);

		AcaciaStick = new ModSticks().setTextureName("mod_IDT:stick_acacia").setUnlocalizedName("AcaciaStick")
				.setCreativeTab(IDTItems);

		DarkOakStick = new ModSticks().setTextureName("mod_IDT:stick_dark_oak").setUnlocalizedName("DarkOakStick")
				.setCreativeTab(IDTItems);

		GelidStick = new ModSticks().setTextureName("mod_IDT:stick_gelid").setUnlocalizedName("GelidStick")
				.setCreativeTab(IDTItems);

		// Seeds
		CornSeeds = new ItemSeeds(CornCrop, Blocks.farmland).setTextureName("mod_IDT:seeds_corn")
				.setCreativeTab(IDTItems).setUnlocalizedName("CornSeeds");

		SoyBeans = new ItemSeedFood(2, 2.0F, SoyBeanCrop, Blocks.farmland).setTextureName("mod_IDT:seeds_soy_beans")
				.setCreativeTab(IDTItems).setUnlocalizedName("SoyBeans");

		// Foods
		Corn = new ItemFood(4, false).setTextureName("mod_IDT:corn").setCreativeTab(IDTItems)
				.setUnlocalizedName("Corn");

		Popcorn = new ItemFood(2, false).setTextureName("mod_IDT:popcorn").setCreativeTab(IDTItems)
				.setUnlocalizedName("Popcorn");

		// TODO: Tools/Armors
		ArmorMaterial mat_steel = EnumHelper.addArmorMaterial("mat_steel", 17,
				new int[] { (int) 2.5, 7, (int) 5.5, (int) 2.5 }, (int) 9.5);

		ArmorMaterial mat_titanium = EnumHelper.addArmorMaterial("mat_titanium", 20,
				new int[] { 3, (int) 7.5, 6, (int) 3.2 }, 12);

		ArmorMaterial mat_zimphnode = EnumHelper.addArmorMaterial("mat_zimphnode", 25, new int[] { 5, (int) 8.8, 7, 4 },
				15);

		ArmorMaterial mat_tantalum = EnumHelper.addArmorMaterial("mat_tantalum", 19, new int[] { 4, 9, (int) 7.3, 9 },
				18);

		ArmorMaterial mat_vanadium = EnumHelper.addArmorMaterial("mat_vanadium", 38, new int[] { 6, 10, (int) 7.5, 5 },
				20);

		ArmorMaterial mat_neoron = EnumHelper.addArmorMaterial("mat_neoron", 15, new int[] { 4, 8, 5, 3 }, 15);

		ArmorMaterial mat_vc = EnumHelper.addArmorMaterial("mat_vc", 40, new int[] { 8, 15, 10, 10 }, 25);

		ToolMaterial mat_steel_tool = EnumHelper.addToolMaterial("mat_steel_tool", 2, 700, 6.5F, 2.5F, 14);

		ToolMaterial mat_titanium_tool = EnumHelper.addToolMaterial("mat_titanium_tool", 2, 1000, 7.3F, 3F, 15);

		ToolMaterial mat_vanadium_tool = EnumHelper.addToolMaterial("mat_vanadium_tool", 3, 2000, 9F, 5F, 10);

		ToolMaterial mat_neoron_tool = EnumHelper.addToolMaterial("mat_neoron_tool", 2, 300, 5f, 5f, 15);

		ToolMaterial mat_vc_tool = EnumHelper.addToolMaterial("mat_vc_tool", 3, 3500, 10f, 7f, 20);

		// Steel
		SteelHelmet = (new SteelArmor(mat_steel, 5, 0)).setUnlocalizedName("SteelHelmet")
				.setTextureName("mod_IDT:helmet_steel").setCreativeTab(IDTItems);

		SteelChestplate = (new SteelArmor(mat_steel, 5, 1)).setUnlocalizedName("SteelChest")
				.setTextureName("mod_IDT:chestplate_steel").setCreativeTab(IDTItems);

		SteelLeggings = (new SteelArmor(mat_steel, 5, 2)).setUnlocalizedName("SteelLegs")
				.setTextureName("mod_IDT:leggings_steel").setCreativeTab(IDTItems);

		SteelBoots = (new SteelArmor(mat_steel, 5, 3)).setUnlocalizedName("SteelBoots")
				.setTextureName("mod_IDT:boots_steel").setCreativeTab(IDTItems);

		// Titanium
		TitaniumHelmet = (new TitaniumArmor(mat_titanium, 5, 0)).setUnlocalizedName("TitaniumHelmet")
				.setTextureName("mod_IDT:helmet_titanium").setCreativeTab(IDTItems);

		TitaniumChestplate = (new TitaniumArmor(mat_titanium, 5, 1)).setUnlocalizedName("TitaniumChest")
				.setTextureName("mod_IDT:chestplate_titanium").setCreativeTab(IDTItems);

		TitaniumLeggings = (new TitaniumArmor(mat_titanium, 5, 2)).setUnlocalizedName("TitaniumLegs")
				.setTextureName("mod_IDT:leggings_titanium").setCreativeTab(IDTItems);

		TitaniumBoots = (new TitaniumArmor(mat_titanium, 5, 3)).setUnlocalizedName("TitaniumBoots")
				.setTextureName("mod_IDT:boots_titanium").setCreativeTab(IDTItems);

		// Zimphnode
		ZimphnodeHelmet = (new ZimphnodeArmor(mat_zimphnode, 5, 0)).setUnlocalizedName("ZimphnodeHelmet")
				.setTextureName("mod_IDT:helmet_zimphnode").setCreativeTab(IDTItems);

		ZimphnodeChestplate = (new ZimphnodeArmor(mat_zimphnode, 5, 1)).setUnlocalizedName("ZimphnodeChest")
				.setTextureName("mod_IDT:chestplate_zimphnode").setCreativeTab(IDTItems);

		ZimphnodeLeggings = (new ZimphnodeArmor(mat_zimphnode, 5, 2)).setUnlocalizedName("ZimphnodeLegs")
				.setTextureName("mod_IDT:leggings_zimphnode").setCreativeTab(IDTItems);

		ZimphnodeBoots = (new ZimphnodeArmor(mat_zimphnode, 5, 3)).setUnlocalizedName("ZimphnodeBoots")
				.setTextureName("mod_IDT:boots_zimphnode").setCreativeTab(IDTItems);

		// Vanadium
		VanadiumHelmet = (new VanadiumArmor(mat_vanadium, 5, 0)).setUnlocalizedName("VanadiumHelmet")
				.setTextureName("mod_IDT:helmet_vanadium").setCreativeTab(IDTItems);

		VanadiumChestplate = (new VanadiumArmor(mat_vanadium, 5, 1)).setUnlocalizedName("VanadiumChest")
				.setTextureName("mod_IDT:chestplate_vanadium").setCreativeTab(IDTItems);

		VanadiumLeggings = (new VanadiumArmor(mat_vanadium, 5, 2)).setUnlocalizedName("VanadiumLegs")
				.setTextureName("mod_IDT:leggings_vanadium").setCreativeTab(IDTItems);

		VanadiumBoots = (new VanadiumArmor(mat_vanadium, 5, 3)).setUnlocalizedName("VanadiumBoots")
				.setTextureName("mod_IDT:boots_vanadium").setCreativeTab(IDTItems);

		// Tantalum
		TantalumHelmet = (new TantalumArmor(mat_tantalum, 5, 0)).setUnlocalizedName("TantalumHelmet")
				.setTextureName("mod_IDT:helmet_tantalum").setCreativeTab(IDTItems);

		TantalumChestplate = (new TantalumArmor(mat_tantalum, 5, 1)).setUnlocalizedName("TantalumChest")
				.setTextureName("mod_IDT:chestplate_tantalum").setCreativeTab(IDTItems);

		TantalumLeggings = (new TantalumArmor(mat_tantalum, 5, 2)).setUnlocalizedName("TantalumLegs")
				.setTextureName("mod_IDT:leggings_tantalum").setCreativeTab(IDTItems);

		TantalumBoots = (new TantalumArmor(mat_tantalum, 5, 3)).setUnlocalizedName("TantalumBoots")
				.setTextureName("mod_IDT:boots_tantalum").setCreativeTab(IDTItems);

		// Neoron
		NeoronHelmet = new NeoronArmor(mat_neoron, 5, 0).setUnlocalizedName("NeoHelmet").setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:helmet_neoron");

		NeoronChestplate = new NeoronArmor(mat_neoron, 5, 1).setUnlocalizedName("NeoChest").setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:chestplate_neoron");

		NeoronLeggings = new NeoronArmor(mat_neoron, 5, 2).setUnlocalizedName("NeoLegs").setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:leggings_neoron");

		NeoronBoots = new NeoronArmor(mat_neoron, 5, 3).setUnlocalizedName("NeoBoots").setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:boots_neoron");

		// VC
		VCHelmet = new VCArmor(mat_vc, 5, 0).setUnlocalizedName("VCHelmet").setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:helmet_vc");

		VCChestplate = new VCArmor(mat_vc, 5, 1).setUnlocalizedName("VCChest").setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:chestplate_vc");

		VCLeggings = new VCArmor(mat_vc, 5, 2).setUnlocalizedName("VCLegs").setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:leggings_vc");

		VCBoots = new VCArmor(mat_vc, 5, 3).setUnlocalizedName("VCBoots").setCreativeTab(IDTItems)
				.setTextureName("mod_IDT:boots_vc");

		// Tools
		Chisel = new Chisel().setTextureName("mod_IDT:chisel").setCreativeTab(IDTItems).setUnlocalizedName("Chisel");

		// Pick
		SteelPick = new Pick(mat_steel_tool).setTextureName("mod_IDT:pick_steel").setCreativeTab(IDTItems)
				.setUnlocalizedName("SteelPick");

		TitaniumPick = new Pick(mat_titanium_tool).setTextureName("mod_IDT:pick_titanium").setCreativeTab(IDTItems)
				.setUnlocalizedName("TitaniumPick");

		VanadiumPick = new Pick(mat_vanadium_tool).setTextureName("mod_IDT:pick_vanadium").setCreativeTab(IDTItems)
				.setUnlocalizedName("VanadiumPick");

		NeoronPick = new Pick(mat_neoron_tool).setTextureName("mod_IDT:pick_neoron").setCreativeTab(IDTItems)
				.setUnlocalizedName("NeoPick");

		VCPick = new Pick(mat_vc_tool).setTextureName("mod_IDT:pick_vc").setCreativeTab(IDTItems)
				.setUnlocalizedName("VCPick");

		// Shovel
		SteelShovel = new Shovel(mat_steel_tool).setTextureName("mod_IDT:shovel_steel").setCreativeTab(IDTItems)
				.setUnlocalizedName("SteelShovel");

		TitaniumShovel = new Shovel(mat_titanium_tool).setTextureName("mod_IDT:shovel_titanium")
				.setCreativeTab(IDTItems).setUnlocalizedName("TitaniumShovel");

		VanadiumShovel = new Shovel(mat_vanadium_tool).setTextureName("mod_IDT:shovel_vanadium")
				.setCreativeTab(IDTItems).setUnlocalizedName("VanadiumShovel");

		VCShovel = new Shovel(mat_vc_tool).setTextureName("mod_IDT:shovel_vc").setCreativeTab(IDTItems)
				.setUnlocalizedName("VCShovel");

		// Axe
		SteelAxe = new Axe(mat_steel_tool).setTextureName("mod_IDT:axe_steel").setCreativeTab(IDTItems)
				.setUnlocalizedName("SteelAxe");

		TitaniumAxe = new Axe(mat_titanium_tool).setTextureName("mod_IDT:axe_titanium").setCreativeTab(IDTItems)
				.setUnlocalizedName("TitaniumAxe");

		VanadiumAxe = new Axe(mat_vanadium_tool).setTextureName("mod_IDT:axe_vanadium").setCreativeTab(IDTItems)
				.setUnlocalizedName("VanadiumAxe");

		VCAxe = new Axe(mat_vc_tool).setTextureName("mod_IDT:axe_vc").setCreativeTab(IDTItems)
				.setUnlocalizedName("VCAxe");

		// Sword
		SteelSword = new Sword(mat_steel_tool).setTextureName("mod_IDT:sword_steel").setCreativeTab(IDTItems)
				.setUnlocalizedName("SteelSword");

		TitaniumSword = new Sword(mat_titanium_tool).setTextureName("mod_IDT:sword_titanium").setCreativeTab(IDTItems)
				.setUnlocalizedName("TitaniumSword");

		VanadiumSword = new Sword(mat_vanadium_tool).setTextureName("mod_IDT:sword_vanadium").setCreativeTab(IDTItems)
				.setUnlocalizedName("VanadiumSword");

		VCSword = new Sword(mat_vc_tool).setTextureName("mod_IDT:sword_vc").setCreativeTab(IDTItems)
				.setUnlocalizedName("VCSword");

		// Hoe
		SteelHoe = new Hoe(mat_steel_tool).setTextureName("mod_IDT:hoe_steel").setCreativeTab(IDTItems)
				.setUnlocalizedName("SteelHoe");

		TitaniumHoe = new Hoe(mat_titanium_tool).setTextureName("mod_IDT:hoe_titanium").setCreativeTab(IDTItems)
				.setUnlocalizedName("TitaniumHoe");

		VanadiumHoe = new Hoe(mat_vanadium_tool).setTextureName("mod_IDT:hoe_vanadium").setCreativeTab(IDTItems)
				.setUnlocalizedName("VanadiumHoe");

		VCHoe = new Hoe(mat_vc_tool).setTextureName("mod_IDT:hoe_vc").setCreativeTab(IDTItems)
				.setUnlocalizedName("VCHoe");
		// log.info("Items loaded.");

		// Remove shit and add villager trades crap
		RemoveRecipe(new ItemStack(Blocks.stonebrick));
		RemoveRecipe(new ItemStack(Blocks.wooden_button));
		RemoveRecipe(new ItemStack(Blocks.stone_button));
		RemoveRecipe(new ItemStack(Items.stick));
		RemoveRecipe(new ItemStack(Blocks.stone_slab));
		RemoveRecipe(new ItemStack(Blocks.wooden_pressure_plate));
		RemoveRecipe(new ItemStack(Blocks.chest));
		RemoveRecipe(new ItemStack(Blocks.trapped_chest));
		RemoveRecipe(new ItemStack(Items.wooden_door));
		RemoveRecipe(new ItemStack(Blocks.crafting_table));
		RemoveRecipe(new ItemStack(Blocks.wooden_slab));
		RemoveRecipe(new ItemStack(Blocks.fence));
		RemoveRecipe(new ItemStack(Blocks.fence_gate));
		RemoveRecipe(new ItemStack(Blocks.nether_brick_fence));
		RemoveRecipe(new ItemStack(Blocks.cobblestone_wall));
		// log.info("Recipes removed.");

		// 0 - farmer; 1 - librarian; 2 - priest; 3 - blacksmith; 4 - butcher
		VillagerRegistry.instance().registerVillageTradeHandler(0, new TradeFarmerHandler());

		VillagerRegistry.instance().registerVillageTradeHandler(2, new TradePriestHandler());

		VillagerRegistry.instance().registerVillageTradeHandler(3, new TradeSmithHandler());

		// Status Effects
		Radiation = new RadiationEffect(25, true, 0).setIconIndex(0, 0).setPotionName("potion.radiationEffect");

		new BiomeRegistry().main();
		// log.info("Biomes Loaded.");

		// Village gen stuff (WIP)
		// new VillageRegistry().main();

		// Wheels on the bus go round and round!
		MinecraftForge.EVENT_BUS.register(new EventBonemeal());
		MinecraftForge.EVENT_BUS.register(new OtherEvents());
		MinecraftForge.EVENT_BUS.register(new ChiselEvent());
		MinecraftForge.EVENT_BUS.register(new WikiPaperEvent());
		MinecraftForge.EVENT_BUS.register(new PotionEvents());
		MinecraftForge.EVENT_BUS.register(new PlayerWikiPaperHandler());
		MinecraftForge.EVENT_BUS.register(new ChatEvent());
		MinecraftForge.EVENT_BUS.register(new ToolEvent());
		MinecraftForge.EVENT_BUS.register(new BlowtorchEvent());
		// MinecraftForge.EVENT_BUS.register(new ChemicalHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerDevHandler());
		FMLCommonHandler.instance().bus().register(new OtherEvents());
		FMLCommonHandler.instance().bus().register(new PlayerHandler());
		FMLCommonHandler.instance().bus().register(new AchievementHandler());
		FMLCommonHandler.instance().bus().register(new CraftedEventHandler());
		GameRegistry.registerFuelHandler(new FuelHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(mod_IDT.instance, new GUIHandler());

		if (minechem) {
			MinechemChemicalHandler.getInstance().chem();
			MinechemNameHandler.getInstance().naming(null);
			log.info("Custom chemicals loaded for Minechem. :D");
		}

		if (Loader.isModLoaded("craftingpillars")) {
			CraftingPillarIDTAPI.CraftingPillarIDTAPI();
			log.info("Loaded integration with Crafting Pillars.");
		}

		channel = NetworkRegistry.INSTANCE.newEventDrivenChannel(networkChannelName);
		channel.register(new ServerPacketHandler());
		channel.register(new ClientPacketHandler());
		log.info("IDT loaded.");
	}

	@Mod.EventHandler
	public void processIMC(FMLInterModComms.IMCEvent e) {
		if (Loader.isModLoaded("Waila")) {
			IDTModule.register();
			log.info("Loaded integration with Waila.");
		}
	}

	// TODO: Everything Else
	@Mod.EventHandler
	public static void load(FMLInitializationEvent event) {
		gameRegistry();
		OreDictionaryRegistry.oreDictionary();
		tileEntityRegistry();
		proxy.registerRenders();
	}

	public static SimpleNetworkWrapper networkWrapper;
	public static CreativeTabs IDT = new ModCreativeTabs("IDT");
	public static CreativeTabs IDTItems = new ModCreativeTabs("IDTItems");

	// Game Registry.. Duh
	public static void gameRegistry() {
		MobRegistry.preInit();

		BlockRegistry.registerBlocks();
		ItemRegistry.registerItems();

		MinecraftForge.addGrassSeed(new ItemStack(CornSeeds), 9);
		MinecraftForge.addGrassSeed(new ItemStack(SoyBeans), 9);

		ChestHookHandler.addHooks();

		BlockRecipeHandler.registerSmelting();
		BlockRecipeHandler.registerCrafting();

		ItemRecipeHandler.registerSmelting();
		ItemRecipeHandler.registerCrafting();

		ToolRecipeHandler.registerCrafting();

		DimensionHandler.mainRegistry();

		AchRegistry.registerAch();
		AchRegistry.namingAch();

		OreGenHandler.genOres();
	}

	// Registering tile entities
	public static void tileEntityRegistry() {
		// Bombs
		GameRegistry.registerTileEntity(TileEntityEB.class, "EB");
		GameRegistry.registerTileEntity(TileEntityNB.class, "NB");
		GameRegistry.registerTileEntity(TileEntityUB.class, "UB");
		GameRegistry.registerTileEntity(TileEntityUN.class, "UN");
		GameRegistry.registerTileEntity(TileEntityDM.class, "DM");

		// Tech
		GameRegistry.registerTileEntity(TileEntitySmelter.class, "te_smelter");
		GameRegistry.registerTileEntity(TileEntityIndustrialCutter.class, "te_ic");
		GameRegistry.registerTileEntity(TileEntityMatterCondenser.class, "te_mc");
		GameRegistry.registerTileEntity(TileEntityZNG.class, "te_zng");
		GameRegistry.registerTileEntity(TileEntityBFE.class, "te_bfe");
		GameRegistry.registerTileEntity(TileEntityTankCompressor.class, "te_tc");
		GameRegistry.registerTileEntity(TEAH.class, "te_ah");
		GameRegistry.registerTileEntity(TileEntityBHG.class, "te_bhg");
		GameRegistry.registerTileEntity(TileEntityWelder.class, "te_welder");
		GameRegistry.registerTileEntity(TileEntityEnricher.class, "te_enricher");
		GameRegistry.registerTileEntity(TileEntityMagnetizer.class, "te_magnetizer");

		// Chests
		GameRegistry.registerTileEntity(TileEntityBirchChest.class, "te_birchchest");
		GameRegistry.registerTileEntity(TileEntitySpruceChest.class, "te_sprucechest");
		GameRegistry.registerTileEntity(TileEntityJungleChest.class, "te_junglechest");
		GameRegistry.registerTileEntity(TileEntityWillowChest.class, "te_willowchest");
		GameRegistry.registerTileEntity(TileEntityEbonyChest.class, "te_ebonychest");
		GameRegistry.registerTileEntity(TileEntitySilkwoodChest.class, "te_silkwoodchest");
		GameRegistry.registerTileEntity(TileEntityAcaciaChest.class, "te_acaciachest");
		GameRegistry.registerTileEntity(TileEntityDarkOakChest.class, "te_darkoakchest");
		GameRegistry.registerTileEntity(TileEntityGelidChest.class, "te_gelidchest");
		GameRegistry.registerTileEntity(TileEntityDarkMatterChest.class, "te_darkmatterchest");

		// Other
		GameRegistry.registerTileEntity(TECT.class, "te_craft");
		GameRegistry.registerTileEntity(TileEntityTF.class, "te_tf");
		GameRegistry.registerTileEntity(TileEntityECR.class, "te_ecr");
		GameRegistry.registerTileEntity(TileEntityUCR.class, "te_ucr");
		GameRegistry.registerTileEntity(TileEntityNCR.class, "te_ncr");
		GameRegistry.registerTileEntity(TileEntitySR.class, "te_sr");
		GameRegistry.registerTileEntity(TileEntityZimWire.class, "te_zw");

		// Wall Parts
		GameRegistry.registerTileEntity(TileEntityWPOak.class, "te_wp-oak");
		GameRegistry.registerTileEntity(TileEntityWPBirch.class, "te_wp-birch");
		GameRegistry.registerTileEntity(TileEntityWPSpruce.class, "te_wp-spruce");
		GameRegistry.registerTileEntity(TileEntityWPJungle.class, "te_wp-jungle");
		GameRegistry.registerTileEntity(TileEntityWPDarkOak.class, "te_wp-darkoak");
		GameRegistry.registerTileEntity(TileEntityWPAcacia.class, "te_wp-acacia");
		GameRegistry.registerTileEntity(TileEntityWPWillow.class, "te_wp-willow");
		GameRegistry.registerTileEntity(TileEntityWPEbony.class, "te_wp-ebony");
		GameRegistry.registerTileEntity(TileEntityWPSilkwood.class, "te_wp-silkwood");
		GameRegistry.registerTileEntity(TileEntityWPGelid.class, "te_wp-gelid");
		GameRegistry.registerTileEntity(TileEntityWPCement.class, "te_wp-cement");
		GameRegistry.registerTileEntity(TileEntityWPCementBrick.class, "te_wp-cementbrick");
		GameRegistry.registerTileEntity(TileEntityWPStone.class, "te_wp-stone");
		GameRegistry.registerTileEntity(TileEntityWPStonebrick.class, "te_wp-stonebirck");
		GameRegistry.registerTileEntity(TileEntityWPBrick.class, "te_wp-brick");
		GameRegistry.registerTileEntity(TileEntityWPNetherBrick.class, "te_wp-netherbrick");
		GameRegistry.registerTileEntity(TileEntityWPSandstone.class, "te_wp-sandstone");
		GameRegistry.registerTileEntity(TileEntityWPObsidian.class, "te_wp-obsidian");
		GameRegistry.registerTileEntity(TileEntityWPSnow.class, "te_wp-snow");
		GameRegistry.registerTileEntity(TileEntityWPMossyCobblestone.class, "te_wp-mossycobble");
		GameRegistry.registerTileEntity(TileEntityWPCoal.class, "te_wp-coal");
		GameRegistry.registerTileEntity(TileEntityWPQuartz.class, "te_wp-quartz");
	}

	// TODO: Post
	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		// For liquids and their buckets
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(
				FluidRegistry.getFluidStack(LiquidNitrogenF.getName(), FluidContainerRegistry.BUCKET_VOLUME),
				new ItemStack(LiquidNitrogenBucket), new ItemStack(Items.bucket)));
	}

	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		MinecraftServer server = MinecraftServer.getServer();
		ICommandManager command = server.getCommandManager();
		ServerCommandManager cmd = (ServerCommandManager) command;

		cmd.registerCommand(new News());
		cmd.registerCommand(new Bug());
		cmd.registerCommand(new Support());
	}

	@Mod.EventHandler
	public void onLoadComplete(FMLLoadCompleteEvent e) {
		if (minechem) {
			e.getModState();
			MinechemRecipeHandler.getInstance().recipes();
			log.info("Loaded integration with Minechem. & IDT recipe test");
		}

		/*
		 * if(Loader.isModLoaded("mod_IDT")){ IDTRecH.getInstance().recipes(); }
		 */
	}

	@SuppressWarnings("rawtypes")
	private static void RemoveRecipe(ItemStack resultItem) {
		ItemStack recipeResult = null;
		ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();
		for (int scan = 0; scan < recipes.size(); scan++) {
			IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
			recipeResult = tmpRecipe.getRecipeOutput();
			if ((recipeResult != null) && (recipeResult.getItem() == resultItem.getItem())
					&& (recipeResult.isStackable() == resultItem.isStackable())) {
				// System.out.println("Removed Recipe: " + recipes.get(scan) + "
				// -> " + recipeResult);

				recipes.remove(scan);
				scan--;
			}
		}
	}
}