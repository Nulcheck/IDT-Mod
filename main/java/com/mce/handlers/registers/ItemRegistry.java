package com.mce.handlers.registers;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegistry {
	public static void registerItems() {
		// Other
		GameRegistry.registerItem(mod_IDT.StoneBrick, "StoneBrick");
		GameRegistry.registerItem(mod_IDT.ExplosiveCharge, "ExplosiveCharge");
		GameRegistry.registerItem(mod_IDT.IceShard, "IceShard");
		GameRegistry.registerItem(mod_IDT.IronSawBlade, "IronSawBlade");
		GameRegistry.registerItem(mod_IDT.SteelSawBlade, "SteelSawBlade");
		GameRegistry.registerItem(mod_IDT.TitaniumSawBlade, "TitaniumSawBlade");
		GameRegistry.registerItem(mod_IDT.DiamondSawBlade, "DiamondSawBlade");
		GameRegistry.registerItem(mod_IDT.Gear, "Gear");
		GameRegistry.registerItem(mod_IDT.EmptyTank, "EmptyTank");
		GameRegistry.registerItem(mod_IDT.PropaneTank, "PropaneTank");
		GameRegistry.registerItem(mod_IDT.Propanol, "Propanol");
		GameRegistry.registerItem(mod_IDT.Propene, "Propene");
		GameRegistry.registerItem(mod_IDT.NO2Tank, "NO2Tank");
		GameRegistry.registerItem(mod_IDT.CompressorUnit, "CompressorUnit");
		GameRegistry.registerItem(mod_IDT.CompressorUnitGA, "CompressorUnitGA");
		GameRegistry.registerItem(mod_IDT.SteelRod, "SteelRod");
		GameRegistry.registerItem(mod_IDT.CrystalRod, "CrystalRod");
		GameRegistry.registerItem(mod_IDT.TitaniumPlate, "TitaniumPlate");
		GameRegistry.registerItem(mod_IDT.VanadiumPlate, "VPlate");
		GameRegistry.registerItem(mod_IDT.CopperPlate, "CopperPlate");
		GameRegistry.registerItem(mod_IDT.TantalumPlate, "TantPlate");
		GameRegistry.registerItem(mod_IDT.CopperWire, "CopperWire");
		GameRegistry.registerItem(mod_IDT.VanadiumWire, "VanWire");
		GameRegistry.registerItem(mod_IDT.CopperFoil, "CopperFoil");
		GameRegistry.registerItem(mod_IDT.TantalumFoil, "TantFoil");
		GameRegistry.registerItem(mod_IDT.SiliconChip, "SiliconChip");
		GameRegistry.registerItem(mod_IDT.BSiliconChip, "BSiliconChip");
		GameRegistry.registerItem(mod_IDT.PSiliconChip, "PSiliconChip");
		GameRegistry.registerItem(mod_IDT.Flask, "Flask");
		GameRegistry.registerItem(mod_IDT.NdMagnet, "NdMagnet");
		GameRegistry.registerItem(mod_IDT.BlowTorch, "BlowTorch");
		GameRegistry.registerItem(mod_IDT.DarkMatterPiece, "DMPiece");
		GameRegistry.registerItem(mod_IDT.T1CircuitBoard, "T1CB");
		GameRegistry.registerItem(mod_IDT.T2CircuitBoard, "T2CB");
		GameRegistry.registerItem(mod_IDT.T3CircuitBoard, "T3CB");
		GameRegistry.registerItem(mod_IDT.QMan, "QMan");
		GameRegistry.registerItem(mod_IDT.Transistor, "Trans");
		GameRegistry.registerItem(mod_IDT.Microchip, "Microchip");
		GameRegistry.registerItem(mod_IDT.SiliconWafer, "SiliconWafer");
		GameRegistry.registerItem(mod_IDT.Plank, "Plank");
		GameRegistry.registerItem(mod_IDT.Fiberglass, "Fiberglass");
		GameRegistry.registerItem(mod_IDT.BoronFG, "BoronFG");
		GameRegistry.registerItem(mod_IDT.PolePiece, "PolePiece");
		GameRegistry.registerItem(mod_IDT.Rotor, "Rotor");
		GameRegistry.registerItem(mod_IDT.Stator, "Stator");
		GameRegistry.registerItem(mod_IDT.Alternator, "Alternator");
		/*
		 * GameRegistry.registerItem(mod_IDT.ChargeStone, "ChargeStone");
		 * GameRegistry.registerItem(mod_IDT.Pouch, "Pouch");
		 */

		// Upgrades
		GameRegistry.registerItem(mod_IDT.MagneticUpgrade, "UpMag");
		GameRegistry.registerItem(mod_IDT.LaserUpgrade, "LaserUpgrade");

		// Records
		GameRegistry.registerItem(mod_IDT.cd_icy, "cd_icy");
		GameRegistry.registerItem(mod_IDT.cd_23, "cd_23");
		GameRegistry.registerItem(mod_IDT.cd_r51, "r51vWLcxy9jo1Nvi");

		// Chemistry Stuff
		GameRegistry.registerItem(mod_IDT.Sulfur, "Sulfur");
		GameRegistry.registerItem(mod_IDT.VPowder, "VPowder");
		GameRegistry.registerItem(mod_IDT.V2O5, "V2O5");
		GameRegistry.registerItem(mod_IDT.Carbon, "Carbon");
		// GameRegistry.registerItem(mod_IDT.Graphene, "Graphene");
		GameRegistry.registerItem(mod_IDT.SiliconDust, "SiliconDust");
		GameRegistry.registerItem(mod_IDT.CopperDust, "CopperDust");
		// GameRegistry.registerItem(mod_IDT.TitaniumDust, "TitaniumDust");
		GameRegistry.registerItem(mod_IDT.PhosphorusDust, "PhosphorusDust");
		GameRegistry.registerItem(mod_IDT.BoronDust, "BoronDust");
		GameRegistry.registerItem(mod_IDT.VCDust, "VCDust");
		GameRegistry.registerItem(mod_IDT.PureQuartz, "PQuartz");
		GameRegistry.registerItem(mod_IDT.SO2, "SO2");
		GameRegistry.registerItem(mod_IDT.SO3, "SO3");
		GameRegistry.registerItem(mod_IDT.H2SO4, "H2SO4");
		GameRegistry.registerItem(mod_IDT.HNO3, "HNO3");
		GameRegistry.registerItem(mod_IDT.Nitroglycerin, "NG");
		GameRegistry.registerItem(mod_IDT.Glycerin, "Glycerin");
		GameRegistry.registerItem(mod_IDT.Acrolein, "Acrolein");

		// Liquids
		GameRegistry.registerItem(mod_IDT.LiquidNitrogenBucket, "LiquidNitrogenBucket");

		// Wall Parts
		GameRegistry.registerItem(mod_IDT.StoneWallPart, "StoneWallPart");
		GameRegistry.registerItem(mod_IDT.CobblestoneWallPart, "CobblestoneWallPart");
		GameRegistry.registerItem(mod_IDT.MossyCobblestoneWallPart, "MossyCobblestoneWallPart");
		GameRegistry.registerItem(mod_IDT.SandstoneWallPart, "SandstoneWallPart");
		GameRegistry.registerItem(mod_IDT.ObsidianWallPart, "ObsidianWallPart");
		GameRegistry.registerItem(mod_IDT.CementWallPart, "CementWallPart");
		GameRegistry.registerItem(mod_IDT.CementBrickWallPart, "CementBrickWallPart");
		GameRegistry.registerItem(mod_IDT.StonebrickWallPart, "StonebrickWallPart");
		GameRegistry.registerItem(mod_IDT.BrickWallPart, "BrickWallPart");
		GameRegistry.registerItem(mod_IDT.CoalWallPart, "CoalWallPart");
		GameRegistry.registerItem(mod_IDT.SnowWallPart, "SnowWallPart");
		GameRegistry.registerItem(mod_IDT.NetherBrickWallPart, "NetherBrickWallPart");
		GameRegistry.registerItem(mod_IDT.QuartzWallPart, "QuartzWallPart");
		GameRegistry.registerItem(mod_IDT.OakWallPart, "OakWallPart");
		GameRegistry.registerItem(mod_IDT.BirchWallPart, "BirchWallPart");
		GameRegistry.registerItem(mod_IDT.SpruceWallPart, "SpruceWallPart");
		GameRegistry.registerItem(mod_IDT.JungleWallPart, "JungleWallPart");
		GameRegistry.registerItem(mod_IDT.AcaciaWallPart, "AcaciaWallPart");
		GameRegistry.registerItem(mod_IDT.DarkOakWallPart, "DarkOakWallPart");
		GameRegistry.registerItem(mod_IDT.WillowWallPart, "WillowWallPart");
		GameRegistry.registerItem(mod_IDT.EbonyWallPart, "EbonyWallPart");
		GameRegistry.registerItem(mod_IDT.SilkwoodWallPart, "SilkwoodWallPart");
		GameRegistry.registerItem(mod_IDT.GelidWallPart, "GelidWallPart");

		// Armor
		// Steel
		GameRegistry.registerItem(mod_IDT.SteelHelmet, "SteelHelmet");
		GameRegistry.registerItem(mod_IDT.SteelChestplate, "SteelChest");
		GameRegistry.registerItem(mod_IDT.SteelLeggings, "SteelLegs");
		GameRegistry.registerItem(mod_IDT.SteelBoots, "SteelBoots");

		// Titanium
		GameRegistry.registerItem(mod_IDT.TitaniumHelmet, "TitaniumHelmet");
		GameRegistry.registerItem(mod_IDT.TitaniumChestplate, "TitaniumChest");
		GameRegistry.registerItem(mod_IDT.TitaniumLeggings, "TitaniumLegs");
		GameRegistry.registerItem(mod_IDT.TitaniumBoots, "TitaniumBoots");

		// Zimphnode
		GameRegistry.registerItem(mod_IDT.ZimphnodeHelmet, "ZimphnodeHelmet");
		GameRegistry.registerItem(mod_IDT.ZimphnodeChestplate, "ZimphnodeChest");
		GameRegistry.registerItem(mod_IDT.ZimphnodeLeggings, "ZimphnodeLegs");
		GameRegistry.registerItem(mod_IDT.ZimphnodeBoots, "ZimphnodeBoots");

		// Vanadium
		GameRegistry.registerItem(mod_IDT.VanadiumHelmet, "VanadiumHelmet");
		GameRegistry.registerItem(mod_IDT.VanadiumChestplate, "VanadiumChest");
		GameRegistry.registerItem(mod_IDT.VanadiumLeggings, "VanadiumLegs");
		GameRegistry.registerItem(mod_IDT.VanadiumBoots, "VanadiumBoots");

		// VC
		GameRegistry.registerItem(mod_IDT.VCHelmet, "VCHelmet");
		GameRegistry.registerItem(mod_IDT.VCChestplate, "VCChest");
		GameRegistry.registerItem(mod_IDT.VCLeggings, "VCLegs");
		GameRegistry.registerItem(mod_IDT.VCBoots, "VCBoots");

		// Tantalum
		GameRegistry.registerItem(mod_IDT.TantalumHelmet, "TantalumHelmet");
		GameRegistry.registerItem(mod_IDT.TantalumChestplate, "TantalumChest");
		GameRegistry.registerItem(mod_IDT.TantalumLeggings, "TantalumLegs");
		GameRegistry.registerItem(mod_IDT.TantalumBoots, "TantalumBoots");

		// Neoron / Magnetic
		GameRegistry.registerItem(mod_IDT.NeoronHelmet, "NeoHelmet");
		GameRegistry.registerItem(mod_IDT.NeoronChestplate, "NeoChest");
		GameRegistry.registerItem(mod_IDT.NeoronLeggings, "NeoLegs");
		GameRegistry.registerItem(mod_IDT.NeoronBoots, "NeoBoots");

		// Door Items
		GameRegistry.registerItem(mod_IDT.BirchDoorItem, "BirchDoorItem");
		GameRegistry.registerItem(mod_IDT.SpruceDoorItem, "SpruceDoorItem");
		GameRegistry.registerItem(mod_IDT.JungleDoorItem, "JungleDoorItem");
		GameRegistry.registerItem(mod_IDT.AcaciaDoorItem, "AcaciaDoorItem");
		GameRegistry.registerItem(mod_IDT.DarkOakDoorItem, "DarkOakDoorItem");
		GameRegistry.registerItem(mod_IDT.WillowDoorItem, "WillowDoorItem");
		GameRegistry.registerItem(mod_IDT.EbonyDoorItem, "EbonyDoorItem");
		GameRegistry.registerItem(mod_IDT.SilkwoodDoorItem, "SilkwoodDoorItem");
		GameRegistry.registerItem(mod_IDT.GelidDoorItem, "GelidDoorItem");

		// Ingots
		GameRegistry.registerItem(mod_IDT.EinsteiniumIngot, "EinsteiniumIngot");
		GameRegistry.registerItem(mod_IDT.NeptuniumIngot, "NeptuniumIngot");
		GameRegistry.registerItem(mod_IDT.UraniumIngot, "UraniumIngot");
		GameRegistry.registerItem(mod_IDT.SteelIngot, "SteelIngot");
		GameRegistry.registerItem(mod_IDT.TitaniumIngot, "TitaniumIngot");
		GameRegistry.registerItem(mod_IDT.PraseodymiumIngot, "PraIngot");
		GameRegistry.registerItem(mod_IDT.NeodymiumIngot, "NeoIngot");
		GameRegistry.registerItem(mod_IDT.VanadiumIngot, "VanIngot");
		GameRegistry.registerItem(mod_IDT.TantalumIngot, "TantIngot");
		GameRegistry.registerItem(mod_IDT.ZimphnodeBar, "ZimphnodeBar");
		GameRegistry.registerItem(mod_IDT.NeoronIngot, "NeoronIngot");
		GameRegistry.registerItem(mod_IDT.BoronIngot, "BoronIngot");
		GameRegistry.registerItem(mod_IDT.CopperIngot, "CopperIngot");
		GameRegistry.registerItem(mod_IDT.SiliconIngot, "SiliconIngot");
		GameRegistry.registerItem(mod_IDT.VCIngot, "VCIngot");

		// Crystals
		GameRegistry.registerItem(mod_IDT.CrystalDust, "CrystalDust");
		GameRegistry.registerItem(mod_IDT.CrystalGem, "CrystalGem");
		GameRegistry.registerItem(mod_IDT.CutCrystalGem, "CutCrystalGem");
		GameRegistry.registerItem(mod_IDT.CrystalNugget, "CrystalNugget");
		GameRegistry.registerItem(mod_IDT.CrystalPiece, "CrystalPiece");
		GameRegistry.registerItem(mod_IDT.CrystalLens, "CrystalLens");
		GameRegistry.registerItem(mod_IDT.CrystalBall, "CrystalBall");
		GameRegistry.registerItem(mod_IDT.HardCrystalBall, "HardCrystalBall");

		// Essence
		GameRegistry.registerItem(mod_IDT.EssenceOfLife, "EssenceOfLife");
		GameRegistry.registerItem(mod_IDT.EssenceOfFire, "EssenceOfFire");
		GameRegistry.registerItem(mod_IDT.EssenceOfEarth, "EssenceOfEarth");
		GameRegistry.registerItem(mod_IDT.EssenceOfWater, "EssenceOfWater");
		GameRegistry.registerItem(mod_IDT.EssenceOfAir, "EssenceOfAir");

		// Pure
		/*
		 * GameRegistry.registerItem(mod_IDT.PureLifeEssence,
		 * "PureLifeEssence");
		 * GameRegistry.registerItem(mod_IDT.PureFireEssence,
		 * "PureFireEssence");
		 * GameRegistry.registerItem(mod_IDT.PureEarthEssence,
		 * "PureEarthEssence");
		 * GameRegistry.registerItem(mod_IDT.PureWaterEssence,
		 * "PureWaterEssence");
		 * GameRegistry.registerItem(mod_IDT.PureAirEssence, "PureAirEssence");
		 * GameRegistry.registerItem(mod_IDT.EOTP, "EOTP");
		 */

		// Sticks
		GameRegistry.registerItem(mod_IDT.WillowStick, "WillowStick");
		GameRegistry.registerItem(mod_IDT.BirchStick, "BirchStick");
		GameRegistry.registerItem(mod_IDT.SpruceStick, "SpruceStick");
		GameRegistry.registerItem(mod_IDT.JungleStick, "JungleStick");
		GameRegistry.registerItem(mod_IDT.AcaciaStick, "AcaciaStick");
		GameRegistry.registerItem(mod_IDT.DarkOakStick, "DarkOakStick");
		GameRegistry.registerItem(mod_IDT.EbonyStick, "EbonyStick");
		GameRegistry.registerItem(mod_IDT.SilkwoodStick, "SilkwoodStick");
		GameRegistry.registerItem(mod_IDT.GelidStick, "GelidStick");

		// Seeds
		GameRegistry.registerItem(mod_IDT.CornSeeds, "CornSeeds");
		GameRegistry.registerItem(mod_IDT.SoyBeans, "SoyBeans");

		// Foods
		GameRegistry.registerItem(mod_IDT.Corn, "Corn");
		GameRegistry.registerItem(mod_IDT.Popcorn, "Popcorn");

		// Tools
		GameRegistry.registerItem(mod_IDT.Chisel, "Chisel");
		GameRegistry.registerItem(mod_IDT.WikiPaper, "WikiPaper");

		// Pick
		GameRegistry.registerItem(mod_IDT.SteelPick, "SteelPick");
		GameRegistry.registerItem(mod_IDT.TitaniumPick, "TitaniumPick");
		GameRegistry.registerItem(mod_IDT.VanadiumPick, "VanadiumPick");
		GameRegistry.registerItem(mod_IDT.VCPick, "VCPick");
		GameRegistry.registerItem(mod_IDT.NeoronPick, "NeoPick");

		// Shovel
		GameRegistry.registerItem(mod_IDT.SteelShovel, "SteelShovel");
		GameRegistry.registerItem(mod_IDT.TitaniumShovel, "TitaniumShovel");
		GameRegistry.registerItem(mod_IDT.VanadiumShovel, "VanadiumShovel");
		GameRegistry.registerItem(mod_IDT.VCShovel, "VCShovel");

		// Axe
		GameRegistry.registerItem(mod_IDT.SteelAxe, "SteelAxe");
		GameRegistry.registerItem(mod_IDT.TitaniumAxe, "TitaniumAxe");
		GameRegistry.registerItem(mod_IDT.VanadiumAxe, "VanadiumAxe");
		GameRegistry.registerItem(mod_IDT.VCAxe, "VCAxe");

		// Sword
		GameRegistry.registerItem(mod_IDT.SteelSword, "SteelSword");
		GameRegistry.registerItem(mod_IDT.TitaniumSword, "TitaniumSword");
		GameRegistry.registerItem(mod_IDT.VanadiumSword, "VanadiumSword");
		GameRegistry.registerItem(mod_IDT.VCSword, "VCSword");

		// Hoe
		GameRegistry.registerItem(mod_IDT.SteelHoe, "SteelHoe");
		GameRegistry.registerItem(mod_IDT.TitaniumHoe, "TitaniumHoe");
		GameRegistry.registerItem(mod_IDT.VanadiumHoe, "VanadiumHoe");
		GameRegistry.registerItem(mod_IDT.VCHoe, "VCHoe");
	}
}
