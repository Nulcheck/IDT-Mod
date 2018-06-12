package com.mce.handlers.registers;

import com.mce.common.mod_IDT;
import com.mce.items.blocks.ItemDidymiumGlass;
import com.mce.items.blocks.ItemEsBomb;
import com.mce.items.blocks.ItemNpBomb;
import com.mce.items.blocks.ItemUBomb;
import com.mce.items.blocks.ItemUltimateNuker;
import com.mce.items.blocks.ItemZNG;
import com.mce.items.blocks.ItemZimWire;
import com.mce.items.blocks.slabs.ItemSlabCement;
import com.mce.items.blocks.slabs.ItemSlabCementBrick;
import com.mce.items.blocks.slabs.ItemSlabEbony;
import com.mce.items.blocks.slabs.ItemSlabGelid;
import com.mce.items.blocks.slabs.ItemSlabGlass;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassBlack;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassBlue;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassBrown;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassCyan;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassGray;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassGreen;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassLightBlue;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassLightGray;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassLime;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassMagenta;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassOrange;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassPink;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassPurple;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassRed;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassWhite;
import com.mce.items.blocks.slabs.ItemSlabGlass.ItemSlabGlassYellow;
import com.mce.items.blocks.slabs.ItemSlabSilkwood;
import com.mce.items.blocks.slabs.ItemSlabStone;
import com.mce.items.blocks.slabs.ItemSlabWillow;
import com.mce.items.blocks.tech.ItemBFE;
import com.mce.items.blocks.tech.ItemMachineCasing;
import com.mce.items.blocks.tech.ItemMetalFrame;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegistry {
	public static void registerBlocks() {
		// Tech
		GameRegistry.registerBlock(mod_IDT.MetalFrame, ItemMetalFrame.class, mod_IDT.MetalFrame.getUnlocalizedName());
		GameRegistry.registerBlock(mod_IDT.MachineCasing, ItemMachineCasing.class,
				mod_IDT.MachineCasing.getUnlocalizedName());
		GameRegistry.registerBlock(mod_IDT.HealerBlock, "Healer");
		// GameRegistry.registerBlock(mod_IDT.AdvancedHealer, "AdvancedHealer");
		GameRegistry.registerBlock(mod_IDT.SmelterIdle, "SmelterIdle");
		GameRegistry.registerBlock(mod_IDT.SmelterActive, "SmelterActive");
		GameRegistry.registerBlock(mod_IDT.IndustrialCutter, "IC");
		GameRegistry.registerBlock(mod_IDT.MatterCondenser, "MatterCondenser");
		GameRegistry.registerBlock(mod_IDT.BioFuelExtractor, ItemBFE.class,
				mod_IDT.BioFuelExtractor.getUnlocalizedName());
		GameRegistry.registerBlock(mod_IDT.TankCompressor, "TankCompressor");
		GameRegistry.registerBlock(mod_IDT.BlackHoleGenerator, "BHG");
		GameRegistry.registerBlock(mod_IDT.Welder, "Welder");
		GameRegistry.registerBlock(mod_IDT.Magnetizer, "Magnetizer");
		GameRegistry.registerBlock(mod_IDT.Enricher, "Enricher");
		GameRegistry.registerBlock(mod_IDT.ZNG, ItemZNG.class, mod_IDT.ZNG.getUnlocalizedName());
		// GameRegistry.registerBlock(mod_IDT.EssenceInfuser,
		// "EssenceInfuser");
		// GameRegistry.registerBlock(mod_IDT.EssenceExtractor,
		// "EssenceExtractor");

		// Other
		GameRegistry.registerBlock(mod_IDT.Cement, "Cement");
		GameRegistry.registerBlock(mod_IDT.CementBricks, "CementBricks");
		GameRegistry.registerBlock(mod_IDT.CryingObsidian, "CryingObsidian");
		GameRegistry.registerBlock(mod_IDT.LavaStone, "LavaStone");
		GameRegistry.registerBlock(mod_IDT.LavaCobble, "LavaCobble");
		GameRegistry.registerBlock(mod_IDT.LavaObsidian, "LavaObsidin");
		GameRegistry.registerBlock(mod_IDT.DidymiumGlass, ItemDidymiumGlass.class,
				mod_IDT.DidymiumGlass.getUnlocalizedName());
		GameRegistry.registerBlock(mod_IDT.DidymiumGlassPane, "DidymiumGlassPane");
		GameRegistry.registerBlock(mod_IDT.EinsteiniumGlass, "EinsteiniumGlass");
		GameRegistry.registerBlock(mod_IDT.EinsteiniumGlassPane, "EinsteiniumGlassPane");
		GameRegistry.registerBlock(mod_IDT.NeptuniumGlass, "NeptuniumGlass");
		GameRegistry.registerBlock(mod_IDT.NeptuniumGlassPane, "NeptuniumGlassPane");
		GameRegistry.registerBlock(mod_IDT.UraniumGlass, "UraniumGlass");
		GameRegistry.registerBlock(mod_IDT.UraniumGlassPane, "UraniumGlassPane");
		GameRegistry.registerBlock(mod_IDT.ReinforcedGlass, "RFGlass");
		GameRegistry.registerBlock(mod_IDT.ReinforcedGlassPane, "RFGlassPane");
		GameRegistry.registerBlock(mod_IDT.DarkMatter, "DarkMatter");
		GameRegistry.registerBlock(mod_IDT.StableBlackHole, "StableBlackHole");
		GameRegistry.registerBlock(mod_IDT.EinsteiniumCoreReactor, "EinsteiniumCoreReactor");
		// GameRegistry.registerItem(mod_IDT.EinsteiniumCoreReactorItem,
		// "ECRI");
		GameRegistry.registerBlock(mod_IDT.NeptuniumCoreReactor, "NeptuniumCoreReactor");
		GameRegistry.registerBlock(mod_IDT.UraniumCoreReactor, "UraniumCoreReactor");
		GameRegistry.registerBlock(mod_IDT.SuperReactor, "SuperReactor");
		GameRegistry.registerBlock(mod_IDT.ZimphnodeWire, ItemZimWire.class,
				mod_IDT.ZimphnodeWire.getUnlocalizedName());

		// Bombs
		GameRegistry.registerBlock(mod_IDT.EinsteiniumBomb, ItemEsBomb.class,
				mod_IDT.EinsteiniumBomb.getUnlocalizedName());
		GameRegistry.registerBlock(mod_IDT.NeptuniumBomb, ItemNpBomb.class, mod_IDT.NeptuniumBomb.getUnlocalizedName());
		GameRegistry.registerBlock(mod_IDT.UraniumBomb, ItemUBomb.class, mod_IDT.UraniumBomb.getUnlocalizedName());
		GameRegistry.registerBlock(mod_IDT.UltimateNuker, ItemUltimateNuker.class,
				mod_IDT.UltimateNuker.getUnlocalizedName());
		// GameRegistry.registerBlock(mod_IDT.DarkMatterBomb, "DarkMatterBomb");

		// Frost Dim
		GameRegistry.registerBlock(mod_IDT.FrozenPortal, "FrozenPortal");
		GameRegistry.registerBlock(mod_IDT.FrostGrass, "FrostGrass");
		GameRegistry.registerBlock(mod_IDT.FrostDirt, "FrostDirt");
		GameRegistry.registerBlock(mod_IDT.FrostStone, "FrostStone");
		GameRegistry.registerBlock(mod_IDT.FrostCobble, "FrostCobble");

		// Crystal Dim
		GameRegistry.registerBlock(mod_IDT.CrystalPortal, "CrystalPortal");
		GameRegistry.registerBlock(mod_IDT.CrystalGlass, "CrystalGlass");
		GameRegistry.registerBlock(mod_IDT.CrystalRock, "CrystalRock");

		// Mineral Blocks
		GameRegistry.registerBlock(mod_IDT.EinsteiniumBlock, "EinsteiniumBlock");
		GameRegistry.registerBlock(mod_IDT.NeptuniumBlock, "NeptuniumBlock");
		GameRegistry.registerBlock(mod_IDT.UraniumBlock, "UraniumBlock");
		GameRegistry.registerBlock(mod_IDT.SteelBlock, "SteelBlock");
		GameRegistry.registerBlock(mod_IDT.TitaniumBlock, "TitaniumBlock");
		GameRegistry.registerBlock(mod_IDT.PraseodymiumBlock, "PraseodymiumBlock");
		GameRegistry.registerBlock(mod_IDT.NeodymiumBlock, "NeodymiumBlock");
		GameRegistry.registerBlock(mod_IDT.VanadiumBlock, "VanadiumBlock");
		GameRegistry.registerBlock(mod_IDT.VanadiumCarbideBlock, "VanadiumCarbideBlock");
		GameRegistry.registerBlock(mod_IDT.TantalumBlock, "TantalumBlock");
		GameRegistry.registerBlock(mod_IDT.ZimphnodeBlock, "ZimphnodeBlock");
		GameRegistry.registerBlock(mod_IDT.NeoronBlock, "NeoronBlock");
		GameRegistry.registerBlock(mod_IDT.BoronBlock, "BoronBlock");
		GameRegistry.registerBlock(mod_IDT.CopperBlock, "CopperBlock");
		GameRegistry.registerBlock(mod_IDT.SiliconBlock, "SiliconBlock");
		GameRegistry.registerBlock(mod_IDT.SulfurBlock, "SulfurBlock");
		GameRegistry.registerBlock(mod_IDT.AmblygoniteBlock, "AmblygoniteBlock");

		// Ores
		GameRegistry.registerBlock(mod_IDT.EinsteiniumOre, "EindteiniumOre");
		GameRegistry.registerBlock(mod_IDT.NeptuniumOre, "NeptuniumOre");
		GameRegistry.registerBlock(mod_IDT.UraniumOre, "UraniumOre");
		GameRegistry.registerBlock(mod_IDT.AmblygoniteOre, "AmblygoniteOre");
		GameRegistry.registerBlock(mod_IDT.PraseodymiumOre, "PraOre");
		GameRegistry.registerBlock(mod_IDT.NeodymiumOre, "NeoOre");
		GameRegistry.registerBlock(mod_IDT.VanadiumOre, "VanOre");
		GameRegistry.registerBlock(mod_IDT.TantalumOre, "TantOre");
		GameRegistry.registerBlock(mod_IDT.ZimphnodeOre, "Zimphnode");
		GameRegistry.registerBlock(mod_IDT.SulfurOre, "SulfurOre");
		GameRegistry.registerBlock(mod_IDT.BoronOre, "BoronOre");
		GameRegistry.registerBlock(mod_IDT.CopperOre, "CopperOre");
		GameRegistry.registerBlock(mod_IDT.TitaniumOre, "TitaniumOre");
		GameRegistry.registerBlock(mod_IDT.Phosphorite, "Phosphorite");

		// Dimensional
		// Frost
		GameRegistry.registerBlock(mod_IDT.Agate, "Agate");

		// Crystal
		GameRegistry.registerBlock(mod_IDT.ChrysocollaOre, "ChrysocollaOre");

		// Fires
		GameRegistry.registerBlock(mod_IDT.FrozenFire, "FrozenFire");
		GameRegistry.registerBlock(mod_IDT.CrystalFire, "CrystalFire");

		// Liquids
		GameRegistry.registerBlock(mod_IDT.LiquidNitrogen, "LiquidNitrogen");

		// Buttons
		GameRegistry.registerBlock(mod_IDT.BirchButton, "BirchButton");
		GameRegistry.registerBlock(mod_IDT.SpruceButton, "SpruceButton");
		GameRegistry.registerBlock(mod_IDT.JungleButton, "JungleButton");
		GameRegistry.registerBlock(mod_IDT.AcaciaButton, "AcaciaButton");
		GameRegistry.registerBlock(mod_IDT.DarkOakButton, "DarkOakButton");
		GameRegistry.registerBlock(mod_IDT.WillowButton, "WillowButton");
		GameRegistry.registerBlock(mod_IDT.EbonyButton, "EbonyButton");
		GameRegistry.registerBlock(mod_IDT.SilkwoodButton, "SilkwoodButton");
		GameRegistry.registerBlock(mod_IDT.GelidButton, "GelidButton");

		// Pressure Plates
		GameRegistry.registerBlock(mod_IDT.BirchPressurePlate, "BirchPressurePlate");
		GameRegistry.registerBlock(mod_IDT.SprucePressurePlate, "SprucePressurePlate");
		GameRegistry.registerBlock(mod_IDT.JunglePressurePlate, "JunglePressurePlate");
		GameRegistry.registerBlock(mod_IDT.AcaciaPressurePlate, "AcaciaPressurePlate");
		GameRegistry.registerBlock(mod_IDT.DarkOakPressurePlate, "DarkOakPressurePlate");
		GameRegistry.registerBlock(mod_IDT.WillowPressurePlate, "PressurePlate");
		GameRegistry.registerBlock(mod_IDT.EbonyPressurePlate, "EbonyPressurePlate");
		GameRegistry.registerBlock(mod_IDT.SilkwoodPressurePlate, "SilkwoodPressurePlate");
		GameRegistry.registerBlock(mod_IDT.GelidPressurePlate, "GelidPressurePlate");

		// Slabs
		GameRegistry.registerBlock(mod_IDT.WillowSlab, ItemSlabWillow.class, "WillowSlab");
		GameRegistry.registerBlock(mod_IDT.WillowDoubleSlab, ItemSlabWillow.class, "WillowDoubleSlab");

		GameRegistry.registerBlock(mod_IDT.EbonySlab, ItemSlabEbony.class, "EbonySlab");
		GameRegistry.registerBlock(mod_IDT.EbonyDoubleSlab, ItemSlabEbony.class, "EbonyDoubleSlab");

		GameRegistry.registerBlock(mod_IDT.SilkwoodSlab, ItemSlabSilkwood.class, "SilkwoodSlab");
		GameRegistry.registerBlock(mod_IDT.SilkwoodDoubleSlab, ItemSlabSilkwood.class, "SilkwoodDoubleSlab");

		GameRegistry.registerBlock(mod_IDT.GelidSlab, ItemSlabGelid.class, "GelidSlab");
		GameRegistry.registerBlock(mod_IDT.GelidDoubleSlab, ItemSlabGelid.class, "GelidDoubleSlab");

		GameRegistry.registerBlock(mod_IDT.CementSlab, ItemSlabCement.class, "CementSlab");
		GameRegistry.registerBlock(mod_IDT.CementDoubleSlab, ItemSlabCement.class, "CementDoubleSlab");

		GameRegistry.registerBlock(mod_IDT.CementBrickSlab, ItemSlabCementBrick.class, "CementBrickSlab");
		GameRegistry.registerBlock(mod_IDT.CementBrickDoubleSlab, ItemSlabCementBrick.class, "CementBrickDoubleSlab");

		GameRegistry.registerBlock(mod_IDT.StoneSlab, ItemSlabStone.class, "StoneSlab");
		GameRegistry.registerBlock(mod_IDT.StoneDoubleSlab, ItemSlabStone.class, "StoneDoubleSlab");

		GameRegistry.registerBlock(mod_IDT.GlassSlab, ItemSlabGlass.class, "GlassSlab");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlab, ItemSlabGlass.class, "GlassDoubleSlab");

		// Colored Slabs
		GameRegistry.registerBlock(mod_IDT.GlassSlabWhite, ItemSlabGlassWhite.class, "GlassSlabWhite");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabWhite, ItemSlabGlassWhite.class, "GlassDoubleSlabWhite");

		GameRegistry.registerBlock(mod_IDT.GlassSlabOrange, ItemSlabGlassOrange.class, "GlassSlabOrange");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabOrange, ItemSlabGlassOrange.class, "GlassDoubleSlabOrange");

		GameRegistry.registerBlock(mod_IDT.GlassSlabMagenta, ItemSlabGlassMagenta.class, "GlassSlabMagenta");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabMagenta, ItemSlabGlassMagenta.class,
				"GlassDoubleSlabMagenta");

		GameRegistry.registerBlock(mod_IDT.GlassSlabLightBlue, ItemSlabGlassLightBlue.class, "GlassSlabLightBlue");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabLightBlue, ItemSlabGlassLightBlue.class,
				"GlassDoubleSlabLightBlue");

		GameRegistry.registerBlock(mod_IDT.GlassSlabYellow, ItemSlabGlassYellow.class, "GlassSlabYellow");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabYellow, ItemSlabGlassYellow.class, "GlassDoubleSlabYellow");

		GameRegistry.registerBlock(mod_IDT.GlassSlabLime, ItemSlabGlassLime.class, "GlassSlabLime");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabLime, ItemSlabGlassLime.class, "GlassDoubleSlabLime");

		GameRegistry.registerBlock(mod_IDT.GlassSlabPink, ItemSlabGlassPink.class, "GlassSlabPink");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabPink, ItemSlabGlassPink.class, "GlassDoubleSlabPink");

		GameRegistry.registerBlock(mod_IDT.GlassSlabGray, ItemSlabGlassGray.class, "GlassSlabGray");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabGray, ItemSlabGlassGray.class, "GlassDoubleSlabGray");

		GameRegistry.registerBlock(mod_IDT.GlassSlabLightGray, ItemSlabGlassLightGray.class, "GlassSlabLightGray");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabLightGray, ItemSlabGlassLightGray.class,
				"GlassDoubleSlabLightGray");

		GameRegistry.registerBlock(mod_IDT.GlassSlabCyan, ItemSlabGlassCyan.class, "GlassSlabCyan");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabCyan, ItemSlabGlassCyan.class, "GlassDoubleSlabCyan");

		GameRegistry.registerBlock(mod_IDT.GlassSlabPurple, ItemSlabGlassPurple.class, "GlassSlabPurple");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabPurple, ItemSlabGlassPurple.class, "GlassDoubleSlabPurple");

		GameRegistry.registerBlock(mod_IDT.GlassSlabBlue, ItemSlabGlassBlue.class, "GlassSlabBlue");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabBlue, ItemSlabGlassBlue.class, "GlassDoubleSlabBlue");

		GameRegistry.registerBlock(mod_IDT.GlassSlabBrown, ItemSlabGlassBrown.class, "GlassSlabBrown");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabBrown, ItemSlabGlassBrown.class, "GlassDoubleSlabBrown");

		GameRegistry.registerBlock(mod_IDT.GlassSlabGreen, ItemSlabGlassGreen.class, "GlassSlabGreen");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabGreen, ItemSlabGlassGreen.class, "GlassDoubleSlabGreen");

		GameRegistry.registerBlock(mod_IDT.GlassSlabRed, ItemSlabGlassRed.class, "GlassSlabRed");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabRed, ItemSlabGlassRed.class, "GlassDoubleSlabRed");

		GameRegistry.registerBlock(mod_IDT.GlassSlabBlack, ItemSlabGlassBlack.class, "GlassSlabBlack");
		GameRegistry.registerBlock(mod_IDT.GlassDoubleSlabBlack, ItemSlabGlassBlack.class, "GlassDoubleSlabBlack");

		// Fences
		GameRegistry.registerBlock(mod_IDT.BirchFence, "BirchFence");
		GameRegistry.registerBlock(mod_IDT.SpruceFence, "SpruceFence");
		GameRegistry.registerBlock(mod_IDT.JungleFence, "JungleFence");
		GameRegistry.registerBlock(mod_IDT.AcaciaFence, "AcaciaFence");
		GameRegistry.registerBlock(mod_IDT.DarkOakFence, "DarkOakFence");
		GameRegistry.registerBlock(mod_IDT.WillowFence, "WillowFence");
		GameRegistry.registerBlock(mod_IDT.EbonyFence, "EbonyFence");
		GameRegistry.registerBlock(mod_IDT.SilkwoodFence, "SilkwoodFence");
		GameRegistry.registerBlock(mod_IDT.GelidFence, "GelidFence");

		// Fence Gates
		GameRegistry.registerBlock(mod_IDT.BirchFenceGate, "BirchGate");
		GameRegistry.registerBlock(mod_IDT.SpruceFenceGate, "SpruceGate");
		GameRegistry.registerBlock(mod_IDT.JungleFenceGate, "JungleGate");
		GameRegistry.registerBlock(mod_IDT.AcaciaFenceGate, "AcaciaGate");
		GameRegistry.registerBlock(mod_IDT.DarkOakFenceGate, "DarkOakGate");
		GameRegistry.registerBlock(mod_IDT.WillowFenceGate, "WillowGate");
		GameRegistry.registerBlock(mod_IDT.EbonyFenceGate, "EbonyGate");
		GameRegistry.registerBlock(mod_IDT.SilkwoodFenceGate, "SilkwoodGate");
		GameRegistry.registerBlock(mod_IDT.GelidFenceGate, "GelidGate");

		// Stairs
		GameRegistry.registerBlock(mod_IDT.WillowStairs, "WillowStairs");
		GameRegistry.registerBlock(mod_IDT.EbonyStairs, "EbonyStairs");
		GameRegistry.registerBlock(mod_IDT.SilkwoodStairs, "SilkwoodStairs");
		GameRegistry.registerBlock(mod_IDT.GelidStairs, "GelidStairs");
		GameRegistry.registerBlock(mod_IDT.StoneStairs, "StoneStairs");
		GameRegistry.registerBlock(mod_IDT.CementStairs, "CementStairs");
		GameRegistry.registerBlock(mod_IDT.CementBrickStairs, "CementBrickStairs");
		GameRegistry.registerBlock(mod_IDT.GlassStairs, "GlassStairs");

		// Colored Stairs
		GameRegistry.registerBlock(mod_IDT.GlassStairsWhite, "GlassStairsWhite");
		GameRegistry.registerBlock(mod_IDT.GlassStairsOrange, "GlassStairsOrange");
		GameRegistry.registerBlock(mod_IDT.GlassStairsMagenta, "GlassStairsMagenta");
		GameRegistry.registerBlock(mod_IDT.GlassStairsLightBlue, "GlassStairsLightBlue");
		GameRegistry.registerBlock(mod_IDT.GlassStairsYellow, "GlassStairsYellow");
		GameRegistry.registerBlock(mod_IDT.GlassStairsLime, "GlassStairsLime");
		GameRegistry.registerBlock(mod_IDT.GlassStairsPink, "GlassStairsPink");
		GameRegistry.registerBlock(mod_IDT.GlassStairsGray, "GlassStairsGray");
		GameRegistry.registerBlock(mod_IDT.GlassStairsLightGray, "GlassStairsLightGray");
		GameRegistry.registerBlock(mod_IDT.GlassStairsCyan, "GlassStairsCyan");
		GameRegistry.registerBlock(mod_IDT.GlassStairsPurple, "GlassStairsPurple");
		GameRegistry.registerBlock(mod_IDT.GlassStairsBlue, "GlassStairsBlue");
		GameRegistry.registerBlock(mod_IDT.GlassStairsBrown, "GlassStairsBrown");
		GameRegistry.registerBlock(mod_IDT.GlassStairsGreen, "GlassStairsGreen");
		GameRegistry.registerBlock(mod_IDT.GlassStairsRed, "GlassStairsRed");
		GameRegistry.registerBlock(mod_IDT.GlassStairsBlack, "GlassStairsBlack");

		// Torch
		GameRegistry.registerBlock(mod_IDT.BirchTorch, "BirchTorch");
		GameRegistry.registerBlock(mod_IDT.SpruceTorch, "SpruceTorch");
		GameRegistry.registerBlock(mod_IDT.JungleTorch, "JungleTorch");
		GameRegistry.registerBlock(mod_IDT.AcaciaTorch, "AcaciaTorch");
		GameRegistry.registerBlock(mod_IDT.DarkOakTorch, "DarkOakTorch");
		GameRegistry.registerBlock(mod_IDT.WillowTorch, "WillowTorch");
		GameRegistry.registerBlock(mod_IDT.EbonyTorch, "EbonyTorch");
		GameRegistry.registerBlock(mod_IDT.SilkwoodTorch, "SilkwoodTorch");
		GameRegistry.registerBlock(mod_IDT.GelidTorch, "GelidTorch");

		// Redstone Torch
		GameRegistry.registerBlock(mod_IDT.BirchRedTorch, "BRT");
		GameRegistry.registerBlock(mod_IDT.SpruceRedTorch, "SRT");
		GameRegistry.registerBlock(mod_IDT.JungleRedTorch, "JRT");
		GameRegistry.registerBlock(mod_IDT.AcaciaRedTorch, "ART");
		GameRegistry.registerBlock(mod_IDT.DarkOakRedTorch, "DORT");
		GameRegistry.registerBlock(mod_IDT.WillowRedTorch, "WRT");
		GameRegistry.registerBlock(mod_IDT.EbonyRedTorch, "ERT");
		GameRegistry.registerBlock(mod_IDT.SilkwoodRedTorch, "SWRT");
		GameRegistry.registerBlock(mod_IDT.GelidRedTorch, "GRT");

		// On
		GameRegistry.registerBlock(mod_IDT.BirchRedTorchOn, "BRTO");
		GameRegistry.registerBlock(mod_IDT.SpruceRedTorchOn, "SRTO");
		GameRegistry.registerBlock(mod_IDT.JungleRedTorchOn, "JRTO");
		GameRegistry.registerBlock(mod_IDT.AcaciaRedTorchOn, "ARTO");
		GameRegistry.registerBlock(mod_IDT.DarkOakRedTorchOn, "DORTO");
		GameRegistry.registerBlock(mod_IDT.WillowRedTorchOn, "WRTO");
		GameRegistry.registerBlock(mod_IDT.EbonyRedTorchOn, "ERTO");
		GameRegistry.registerBlock(mod_IDT.SilkwoodRedTorchOn, "SWRTO");
		GameRegistry.registerBlock(mod_IDT.GelidRedTorchOn, "GRTO");

		// Walls
		GameRegistry.registerBlock(mod_IDT.StoneWall, "StoneWall");
		GameRegistry.registerBlock(mod_IDT.SandStoneWall, "SandStoneWall");
		GameRegistry.registerBlock(mod_IDT.ObsidianWall, "ObsidianWall");
		GameRegistry.registerBlock(mod_IDT.CementWall, "CementWall");
		GameRegistry.registerBlock(mod_IDT.CementBrickWall, "CementBrickWall");
		GameRegistry.registerBlock(mod_IDT.SnowWall, "SnowWall");
		GameRegistry.registerBlock(mod_IDT.NetherBrickWall, "NetherBrickWall");
		GameRegistry.registerBlock(mod_IDT.StoneBrickWall, "StoneBrickWall");
		GameRegistry.registerBlock(mod_IDT.BrickWall, "BrickWall");
		GameRegistry.registerBlock(mod_IDT.QuartzWall, "QuartzWall");
		GameRegistry.registerBlock(mod_IDT.CoalWall, "CoalWall");

		// Wooden
		GameRegistry.registerBlock(mod_IDT.OakWall, "OakWall");
		GameRegistry.registerBlock(mod_IDT.BirchWall, "BirchWall");
		GameRegistry.registerBlock(mod_IDT.SpruceWall, "SpruceWall");
		GameRegistry.registerBlock(mod_IDT.JungleWall, "JungleWall");
		GameRegistry.registerBlock(mod_IDT.AcaciaWall, "AcaciaWall");
		GameRegistry.registerBlock(mod_IDT.DarkOakWall, "DarkOakWall");
		GameRegistry.registerBlock(mod_IDT.WillowWall, "WillowWall");
		GameRegistry.registerBlock(mod_IDT.EbonyWall, "EbonyWall");
		GameRegistry.registerBlock(mod_IDT.SilkwoodWall, "SilkwoodWall");
		GameRegistry.registerBlock(mod_IDT.GelidWall, "GelidWall");

		// Doors
		GameRegistry.registerBlock(mod_IDT.BirchDoor, "BirchDoor");
		GameRegistry.registerBlock(mod_IDT.SpruceDoor, "SpruceDoor");
		GameRegistry.registerBlock(mod_IDT.JungleDoor, "JungleDoor");
		GameRegistry.registerBlock(mod_IDT.AcaciaDoor, "AcaciaDoor");
		GameRegistry.registerBlock(mod_IDT.DarkOakDoor, "DarkOakDoor");
		GameRegistry.registerBlock(mod_IDT.WillowDoor, "WillowDoor");
		GameRegistry.registerBlock(mod_IDT.EbonyDoor, "EbonyDoor");
		GameRegistry.registerBlock(mod_IDT.SilkwoodDoor, "SilkwoodDoor");
		GameRegistry.registerBlock(mod_IDT.GelidDoor, "GelidDoor");

		// Logs
		GameRegistry.registerBlock(mod_IDT.WillowLog, "WillowLog");
		GameRegistry.registerBlock(mod_IDT.EbonyLog, "EbonyLog");
		GameRegistry.registerBlock(mod_IDT.SilkwoodLog, "SilkwoodLog");
		GameRegistry.registerBlock(mod_IDT.GelidLog, "GelidLog");

		// Planks
		GameRegistry.registerBlock(mod_IDT.WillowPlanks, "WillowPlanks");
		GameRegistry.registerBlock(mod_IDT.EbonyPlanks, "EbonyPlanks");
		GameRegistry.registerBlock(mod_IDT.SilkwoodPlanks, "SilkwoodPlanks");
		GameRegistry.registerBlock(mod_IDT.GelidPlanks, "GelidPlanks");

		// Leaves
		GameRegistry.registerBlock(mod_IDT.WillowLeaves, "WillowLeaves");
		GameRegistry.registerBlock(mod_IDT.EbonyLeaves, "EbonyLeaves");
		GameRegistry.registerBlock(mod_IDT.SilkwoodLeaves, "SilkwoodLeaves");
		GameRegistry.registerBlock(mod_IDT.GelidLeaves, "GelidLeaves");

		// Saplings
		GameRegistry.registerBlock(mod_IDT.WillowSapling, "WillowSapling");
		GameRegistry.registerBlock(mod_IDT.EbonySapling, "EbonySapling");
		GameRegistry.registerBlock(mod_IDT.SilkwoodSapling, "SilkwoodSapling");
		GameRegistry.registerBlock(mod_IDT.GelidSapling, "GelidSapling");

		// Crops
		GameRegistry.registerBlock(mod_IDT.CornCrop, "CornCrop");
		GameRegistry.registerBlock(mod_IDT.SoyBeanCrop, "SoyBeanCrop");

		// Chests
		GameRegistry.registerBlock(mod_IDT.BirchChest, "BirchChest");
		GameRegistry.registerBlock(mod_IDT.BirchTrapChest, "BirchTrapChest");

		GameRegistry.registerBlock(mod_IDT.SpruceChest, "SpruceChest");
		GameRegistry.registerBlock(mod_IDT.SpruceTrapChest, "SpruceTrapChest");

		GameRegistry.registerBlock(mod_IDT.JungleChest, "JungleChest");
		GameRegistry.registerBlock(mod_IDT.JungleTrapChest, "JungleTrapChest");

		GameRegistry.registerBlock(mod_IDT.AcaciaChest, "AcaciaChest");
		GameRegistry.registerBlock(mod_IDT.AcaciaTrapChest, "AcaciaTrapChest");

		GameRegistry.registerBlock(mod_IDT.DarkOakChest, "DarkOakChest");
		GameRegistry.registerBlock(mod_IDT.DarkOakTrapChest, "DarkOakTrapChest");

		GameRegistry.registerBlock(mod_IDT.WillowChest, "WillowChest");
		GameRegistry.registerBlock(mod_IDT.WillowTrapChest, "WillowTrapChest");

		GameRegistry.registerBlock(mod_IDT.EbonyChest, "EbonyChest");
		GameRegistry.registerBlock(mod_IDT.EbonyTrapChest, "EbonyTrapChest");

		GameRegistry.registerBlock(mod_IDT.SilkwoodChest, "SilkwoodChest");
		GameRegistry.registerBlock(mod_IDT.SilkwoodTrapChest, "SilkwoodTrapChest");

		GameRegistry.registerBlock(mod_IDT.GelidChest, "GelidChest");
		GameRegistry.registerBlock(mod_IDT.GelidTrapChest, "GelidTrapChest");

		GameRegistry.registerBlock(mod_IDT.DarkMatterChest, "DarkMatterChest");

		// Trapdoors
		GameRegistry.registerBlock(mod_IDT.BirchTrapdoor, "BirchTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SpruceTrapdoor, "SpruceTrapdoor");
		GameRegistry.registerBlock(mod_IDT.JungleTrapdoor, "JungleTrapdoor");
		GameRegistry.registerBlock(mod_IDT.AcaciaTrapdoor, "AcaciaTrapdoor");
		GameRegistry.registerBlock(mod_IDT.DarkOakTrapdoor, "DarkOakTrapdoor");
		GameRegistry.registerBlock(mod_IDT.WillowTrapdoor, "WillowTrapdoor");
		GameRegistry.registerBlock(mod_IDT.EbonyTrapdoor, "EbonyTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SilkwoodTrapdoor, "SilkwoodTrapdoor");
		GameRegistry.registerBlock(mod_IDT.GelidTrapdoor, "GelidTrapdoor");
		GameRegistry.registerBlock(mod_IDT.CementTrapdoor, "CementTrapdoor");
		GameRegistry.registerBlock(mod_IDT.CementBrickTrapdoor, "CementBrickTrapdoor");
		GameRegistry.registerBlock(mod_IDT.StoneTrapdoor, "StoneTrapdoor");
		GameRegistry.registerBlock(mod_IDT.CobblestoneTrapdoor, "CobblestoneTrapdoor");
		GameRegistry.registerBlock(mod_IDT.MossyCobblestoneTrapdoor, "MossyCobblestoneTrapdoor");
		GameRegistry.registerBlock(mod_IDT.StonebrickTrapdoor, "StonebrickTrapdoor");
		GameRegistry.registerBlock(mod_IDT.MossyStonebrickTrapdoor, "MossyStonebrickTrapdoor");
		GameRegistry.registerBlock(mod_IDT.CrackedStonebrickTrapdoor, "CrackedStonebrickTrapdoor");
		GameRegistry.registerBlock(mod_IDT.ChiseledStonebrickTrapdoor, "ChiseledStonebrickTrapdoor");

		// Secret Trapdoors
		GameRegistry.registerBlock(mod_IDT.SecretOakTrapdoor, "SecretOakTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretBirchTrapdoor, "SecretBirchTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretSpruceTrapdoor, "SecretSpruceTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretJungleTrapdoor, "SecretJungleTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretAcaciaTrapdoor, "SecretAcaciaTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretDarkOakTrapdoor, "SecretDarkOakTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretWillowTrapdoor, "SecretWillowTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretEbonyTrapdoor, "SecretEbonyTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretSilkwoodTrapdoor, "SecretSilkwoodTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretGelidTrapdoor, "SecretGelidTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretCementTrapdoor, "SecretCementTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretCementBrickTrapdoor, "SecretCementBrickTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretStoneTrapdoor, "SecretStoneTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretCobblestoneTrapdoor, "SecretCobblestoneTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretMossyCobblestoneTrapdoor, "SecretMossyCobblestoneTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretStonebrickTrapdoor, "SecretStonebrickTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretMossyStonebrickTrapdoor, "SecretMossyStonebrickTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretCrackedStonebrickTrapdoor, "SecretCrackedStonebrickTrapdoor");
		GameRegistry.registerBlock(mod_IDT.SecretChiseledStonebrickTrapdoor, "SecretChiseledStonebrickTrapdoor");

		// Levers
		GameRegistry.registerBlock(mod_IDT.BirchLever, "BirchLever");
		GameRegistry.registerBlock(mod_IDT.SpruceLever, "SpruceLever");
		GameRegistry.registerBlock(mod_IDT.JungleLever, "JungleLever");
		GameRegistry.registerBlock(mod_IDT.AcaciaLever, "AcaciaLever");
		GameRegistry.registerBlock(mod_IDT.DarkOakLever, "DarkOakLever");
		GameRegistry.registerBlock(mod_IDT.WillowLever, "WillowLever");
		GameRegistry.registerBlock(mod_IDT.EbonyLever, "EbonyLever");
		GameRegistry.registerBlock(mod_IDT.SilkwoodLever, "SilkwoodLever");
		GameRegistry.registerBlock(mod_IDT.GelidLever, "GelidLever");

		// Crafting Tables
		GameRegistry.registerBlock(mod_IDT.BirchCraftingTable, "BirchCraftingTable");
		GameRegistry.registerBlock(mod_IDT.SpruceCraftingTable, "SpruceCraftingTable");
		GameRegistry.registerBlock(mod_IDT.JungleCraftingTable, "JungleCraftingTable");
		GameRegistry.registerBlock(mod_IDT.AcaciaCraftingTable, "AcaciaCraftingTable");
		GameRegistry.registerBlock(mod_IDT.DarkOakCraftingTable, "DarkOakCraftingTable");
		GameRegistry.registerBlock(mod_IDT.WillowCraftingTable, "WillowCraftingTable");
		GameRegistry.registerBlock(mod_IDT.EbonyCraftingTable, "EbonyCraftingTable");
		GameRegistry.registerBlock(mod_IDT.SilkwoodCraftingTable, "SilkwoodCraftingTable");
		GameRegistry.registerBlock(mod_IDT.GelidCraftingTable, "GelidCraftingTable");

		// Ladders
		GameRegistry.registerBlock(mod_IDT.BirchLadder, "BirchLadder");
		GameRegistry.registerBlock(mod_IDT.SpruceLadder, "SpruceLadder");
		GameRegistry.registerBlock(mod_IDT.JungleLadder, "JungleLadder");
		GameRegistry.registerBlock(mod_IDT.AcaciaLadder, "AcaciaLadder");
		GameRegistry.registerBlock(mod_IDT.DarkOakLadder, "DarkOakLadder");
		GameRegistry.registerBlock(mod_IDT.WillowLadder, "WillowLadder");
		GameRegistry.registerBlock(mod_IDT.EbonyLadder, "EbonyLadder");
		GameRegistry.registerBlock(mod_IDT.SilkwoodLadder, "SilkwoodLadder");
		GameRegistry.registerBlock(mod_IDT.GelidLadder, "GelidLadder");
	}
}
