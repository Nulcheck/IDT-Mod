package com.mce.handlers.registers;

import com.mce.common.mod_IDT;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryRegistry {
	public static void oreDictionary() {
		// Blocks
		OreDictionary.registerOre("blockCement", new ItemStack(mod_IDT.Cement));
		OreDictionary.registerOre("blockCementBricks", new ItemStack(mod_IDT.CementBricks));
		OreDictionary.registerOre("blockSteel", new ItemStack(mod_IDT.SteelBlock));
		OreDictionary.registerOre("blockTitanium", new ItemStack(mod_IDT.TitaniumBlock));
		OreDictionary.registerOre("blockCopper", new ItemStack(mod_IDT.CopperBlock));
		OreDictionary.registerOre("blockSilicon", new ItemStack(mod_IDT.SiliconBlock));
		OreDictionary.registerOre("blockVanadium", new ItemStack(mod_IDT.VanadiumBlock));
		OreDictionary.registerOre("blockVanadiumCarbide", new ItemStack(mod_IDT.VanadiumCarbideBlock));
		OreDictionary.registerOre("blockTantalum", new ItemStack(mod_IDT.TantalumBlock));
		OreDictionary.registerOre("blockEinsteinium", new ItemStack(mod_IDT.EinsteiniumBlock));
		OreDictionary.registerOre("blockNeptunium", new ItemStack(mod_IDT.NeptuniumBlock));
		OreDictionary.registerOre("blockUranium", new ItemStack(mod_IDT.UraniumBlock));
		OreDictionary.registerOre("blockPraseodymium", new ItemStack(mod_IDT.PraseodymiumBlock));
		OreDictionary.registerOre("blockNeodymium", new ItemStack(mod_IDT.NeodymiumBlock));
		OreDictionary.registerOre("blockBoron", new ItemStack(mod_IDT.BoronBlock));
		OreDictionary.registerOre("blockSulfur", new ItemStack(mod_IDT.SulfurBlock));
		OreDictionary.registerOre("blockZimphnode", new ItemStack(mod_IDT.ZimphnodeBlock));
		OreDictionary.registerOre("blockNeoron", new ItemStack(mod_IDT.NeoronBlock));

		// Ores
		OreDictionary.registerOre("oreUranium", new ItemStack(mod_IDT.UraniumOre));
		OreDictionary.registerOre("oreNeptunium", new ItemStack(mod_IDT.NeptuniumOre));
		OreDictionary.registerOre("oreEinsteinium", new ItemStack(mod_IDT.EinsteiniumOre));
		OreDictionary.registerOre("oreCrystal", new ItemStack(mod_IDT.AmblygoniteOre));
		OreDictionary.registerOre("orePraseodymium", new ItemStack(mod_IDT.PraseodymiumOre));
		OreDictionary.registerOre("oreNeodymium", new ItemStack(mod_IDT.NeodymiumOre));
		OreDictionary.registerOre("orePraseodymium", new ItemStack(mod_IDT.PraseodymiumOre));
		OreDictionary.registerOre("oreZimphnode", new ItemStack(mod_IDT.ZimphnodeOre));
		OreDictionary.registerOre("oreVanadium", new ItemStack(mod_IDT.VanadiumOre));
		OreDictionary.registerOre("oreTantalum", new ItemStack(mod_IDT.TantalumOre));
		OreDictionary.registerOre("oreSulfur", new ItemStack(mod_IDT.SulfurOre));
		OreDictionary.registerOre("oreBoron", new ItemStack(mod_IDT.BoronOre));
		OreDictionary.registerOre("oreCopper", new ItemStack(mod_IDT.CopperOre));
		OreDictionary.registerOre("oreTitanium", new ItemStack(mod_IDT.TitaniumOre));
		OreDictionary.registerOre("orePhosphorus", new ItemStack(mod_IDT.Phosphorite));

		// Ingots
		OreDictionary.registerOre("ingotUranium", new ItemStack(mod_IDT.UraniumIngot));
		OreDictionary.registerOre("ingotNeptunium", new ItemStack(mod_IDT.NeptuniumIngot));
		OreDictionary.registerOre("ingotEinsteinium", new ItemStack(mod_IDT.EinsteiniumIngot));
		OreDictionary.registerOre("ingotSteel", new ItemStack(mod_IDT.SteelIngot));
		OreDictionary.registerOre("ingotTitanium", new ItemStack(mod_IDT.TitaniumIngot));
		OreDictionary.registerOre("ingotZimphnode", new ItemStack(mod_IDT.ZimphnodeBar));
		OreDictionary.registerOre("ingotNeodymium", new ItemStack(mod_IDT.NeodymiumIngot));
		OreDictionary.registerOre("ingotPraseodymium", new ItemStack(mod_IDT.PraseodymiumIngot));
		OreDictionary.registerOre("ingotVanadium", new ItemStack(mod_IDT.VanadiumIngot));
		OreDictionary.registerOre("ingotVanadiumCarbide", new ItemStack(mod_IDT.VanadiumCarbideIngot));
		OreDictionary.registerOre("ingotTantalum", new ItemStack(mod_IDT.TantalumIngot));
		OreDictionary.registerOre("ingotNeoron", new ItemStack(mod_IDT.NeoronIngot));
		OreDictionary.registerOre("ingotBoron", new ItemStack(mod_IDT.BoronIngot));
		OreDictionary.registerOre("ingotCopper", new ItemStack(mod_IDT.CopperIngot));
		OreDictionary.registerOre("ingotSilicon", new ItemStack(mod_IDT.SiliconIngot));

		// Nuggets
		OreDictionary.registerOre("nuggetEinsteinium", new ItemStack(mod_IDT.EinsteiniumNugget));
		OreDictionary.registerOre("nuggetNeptunium", new ItemStack(mod_IDT.NeptuniumNugget));
		OreDictionary.registerOre("nuggetUranium", new ItemStack(mod_IDT.UraniumNugget));
		OreDictionary.registerOre("nuggetSteel", new ItemStack(mod_IDT.SteelNugget));
		OreDictionary.registerOre("nuggetTitanium", new ItemStack(mod_IDT.TitaniumNugget));
		OreDictionary.registerOre("nuggetPraseodymium", new ItemStack(mod_IDT.PraseodymiumNugget));
		OreDictionary.registerOre("nuggetNeodymium", new ItemStack(mod_IDT.NeodymiumNugget));
		OreDictionary.registerOre("nuggetVanadium", new ItemStack(mod_IDT.VanadiumNugget));
		OreDictionary.registerOre("nuggetVanadiumCarbide", new ItemStack(mod_IDT.VanadiumCarbideNugget));
		OreDictionary.registerOre("nuggetTantalum", new ItemStack(mod_IDT.TantalumNugget));
		OreDictionary.registerOre("nuggetBoron", new ItemStack(mod_IDT.BoronNugget));
		OreDictionary.registerOre("nuggetCopper", new ItemStack(mod_IDT.CopperNugget));
		OreDictionary.registerOre("nuggetSilicon", new ItemStack(mod_IDT.SiliconNugget));
		OreDictionary.registerOre("nuggetCrystal", new ItemStack(mod_IDT.AmblygoniteNugget));

		// Dusts
		OreDictionary.registerOre("dustEinsteinium", new ItemStack(mod_IDT.EinsteiniumDust));
		OreDictionary.registerOre("dustNeptunium", new ItemStack(mod_IDT.NeptuniumDust));
		OreDictionary.registerOre("dustUranium", new ItemStack(mod_IDT.UraniumDust));
		OreDictionary.registerOre("dustSteel", new ItemStack(mod_IDT.SteelDust));
		OreDictionary.registerOre("dustTitanium", new ItemStack(mod_IDT.TitaniumDust));
		OreDictionary.registerOre("dustPraseodymium", new ItemStack(mod_IDT.PraseodymiumDust));
		OreDictionary.registerOre("dustNeodymium", new ItemStack(mod_IDT.NeodymiumDust));
		OreDictionary.registerOre("dustVanadium", new ItemStack(mod_IDT.VanadiumDust));
		OreDictionary.registerOre("dustVanadiumCarbide", new ItemStack(mod_IDT.VanadiumCarbideDust));
		OreDictionary.registerOre("dustTantalum", new ItemStack(mod_IDT.TantalumDust));
		OreDictionary.registerOre("dustBoron", new ItemStack(mod_IDT.BoronDust));
		OreDictionary.registerOre("dustCopper", new ItemStack(mod_IDT.CopperDust));
		OreDictionary.registerOre("dustSilicon", new ItemStack(mod_IDT.SiliconDust));
		OreDictionary.registerOre("dustCrystal", new ItemStack(mod_IDT.AmblygoniteDust));
		OreDictionary.registerOre("dustPhosphorus", new ItemStack(mod_IDT.PhosphorusDust));
		OreDictionary.registerOre("dustBoron", new ItemStack(mod_IDT.BoronDust));
		OreDictionary.registerOre("lumpSulfur", new ItemStack(mod_IDT.Sulfur));
		OreDictionary.registerOre("dustSulfur", new ItemStack(mod_IDT.Sulfur));
		OreDictionary.registerOre("dustCarbon", new ItemStack(mod_IDT.Carbon));
		

		// Wire
		OreDictionary.registerOre("wireCopper", new ItemStack(mod_IDT.CopperWire));
		OreDictionary.registerOre("wireVanadium", new ItemStack(mod_IDT.VanadiumWire));

		// Plates
		OreDictionary.registerOre("plateTitanium", new ItemStack(mod_IDT.TitaniumPlate));
		OreDictionary.registerOre("plateVanadium", new ItemStack(mod_IDT.VanadiumPlate));
		OreDictionary.registerOre("plateCopper", new ItemStack(mod_IDT.CopperPlate));
		OreDictionary.registerOre("plateTantalum", new ItemStack(mod_IDT.TantalumPlate));

		// Foil
		OreDictionary.registerOre("foilCopper", new ItemStack(mod_IDT.CopperFoil));
		OreDictionary.registerOre("foilTantalum", new ItemStack(mod_IDT.TantalumFoil));

		// Crystal
		OreDictionary.registerOre("gemCrystal", new ItemStack(mod_IDT.AmblygoniteGem));
		OreDictionary.registerOre("gemCrystal", new ItemStack(mod_IDT.CutAmblygoniteGem));
		OreDictionary.registerOre("pieceCrystal", new ItemStack(mod_IDT.AmblygonitePiece));
		OreDictionary.registerOre("blockCrystal", new ItemStack(mod_IDT.AmblygoniteBlock));

		// Seeds
		OreDictionary.registerOre("seedCorn", new ItemStack(mod_IDT.CornSeeds));
		OreDictionary.registerOre("seedSoybean", new ItemStack(mod_IDT.SoyBeans));

		// Food
		OreDictionary.registerOre("foodCorn", new ItemStack(mod_IDT.Corn));
		OreDictionary.registerOre("foodPopcorn", new ItemStack(mod_IDT.Popcorn));
		OreDictionary.registerOre("foodSoybean", new ItemStack(mod_IDT.SoyBeans));

		// Planks
		OreDictionary.registerOre("plankWood", new ItemStack(mod_IDT.WillowPlanks));
		OreDictionary.registerOre("plankWood", new ItemStack(mod_IDT.EbonyPlanks));
		OreDictionary.registerOre("plankWood", new ItemStack(mod_IDT.SilkwoodPlanks));
		OreDictionary.registerOre("plankWood", new ItemStack(mod_IDT.GelidPlanks));

		// Logs
		OreDictionary.registerOre("logWood", new ItemStack(mod_IDT.WillowLog));
		OreDictionary.registerOre("logWood", new ItemStack(mod_IDT.EbonyLog));
		OreDictionary.registerOre("logWood", new ItemStack(mod_IDT.SilkwoodLog));
		OreDictionary.registerOre("logWood", new ItemStack(mod_IDT.GelidLog));

		// Leaves
		OreDictionary.registerOre("treeLeaves", new ItemStack(mod_IDT.WillowLeaves));
		OreDictionary.registerOre("treeLeaves", new ItemStack(mod_IDT.EbonyLeaves));
		OreDictionary.registerOre("treeLeaves", new ItemStack(mod_IDT.SilkwoodLeaves));
		OreDictionary.registerOre("treeLeaves", new ItemStack(mod_IDT.GelidLeaves));

		// Saplings
		OreDictionary.registerOre("treeSapling", new ItemStack(mod_IDT.WillowSapling));
		OreDictionary.registerOre("treeSapling", new ItemStack(mod_IDT.EbonySapling));
		OreDictionary.registerOre("treeSapling", new ItemStack(mod_IDT.SilkwoodSapling));
		OreDictionary.registerOre("treeSapling", new ItemStack(mod_IDT.GelidSapling));

		// Sticks
		OreDictionary.registerOre("stickWood", new ItemStack(mod_IDT.BirchStick));
		OreDictionary.registerOre("stickWood", new ItemStack(mod_IDT.SpruceStick));
		OreDictionary.registerOre("stickWood", new ItemStack(mod_IDT.JungleStick));
		OreDictionary.registerOre("stickWood", new ItemStack(mod_IDT.WillowStick));
		OreDictionary.registerOre("stickWood", new ItemStack(mod_IDT.EbonyStick));
		OreDictionary.registerOre("stickWood", new ItemStack(mod_IDT.SilkwoodStick));
		OreDictionary.registerOre("stickWood", new ItemStack(mod_IDT.AcaciaStick));
		OreDictionary.registerOre("stickWood", new ItemStack(mod_IDT.DarkOakStick));
		OreDictionary.registerOre("stickWood", new ItemStack(mod_IDT.GelidStick));

		// Stairs
		OreDictionary.registerOre("stairWood", new ItemStack(mod_IDT.WillowStairs));
		OreDictionary.registerOre("stairWood", new ItemStack(mod_IDT.EbonyStairs));
		OreDictionary.registerOre("stairWood", new ItemStack(mod_IDT.SilkwoodStairs));
		OreDictionary.registerOre("stairWood", new ItemStack(mod_IDT.GelidStairs));
		OreDictionary.registerOre("stairGlass", new ItemStack(mod_IDT.GlassStairs));
		OreDictionary.registerOre("stairStone", new ItemStack(mod_IDT.StoneStairs));
		OreDictionary.registerOre("stairCement", new ItemStack(mod_IDT.CementStairs));

		// Slabs
		OreDictionary.registerOre("slabWood", new ItemStack(mod_IDT.WillowSlab));
		OreDictionary.registerOre("slabWood", new ItemStack(mod_IDT.EbonySlab));
		OreDictionary.registerOre("slabWood", new ItemStack(mod_IDT.SilkwoodSlab));
		OreDictionary.registerOre("slabWood", new ItemStack(mod_IDT.GelidSlab));
		OreDictionary.registerOre("slabGlass", new ItemStack(mod_IDT.GlassSlab));
		OreDictionary.registerOre("slabStone", new ItemStack(mod_IDT.StoneSlab));
		OreDictionary.registerOre("slabCement", new ItemStack(mod_IDT.CementSlab));

		// Crafting Tables
		OreDictionary.registerOre("workbench", new ItemStack(mod_IDT.BirchCraftingTable));
		OreDictionary.registerOre("workbench", new ItemStack(mod_IDT.SpruceCraftingTable));
		OreDictionary.registerOre("workbench", new ItemStack(mod_IDT.JungleCraftingTable));
		OreDictionary.registerOre("workbench", new ItemStack(mod_IDT.WillowCraftingTable));
		OreDictionary.registerOre("workbench", new ItemStack(mod_IDT.EbonyCraftingTable));
		OreDictionary.registerOre("workbench", new ItemStack(mod_IDT.SilkwoodCraftingTable));
		OreDictionary.registerOre("workbench", new ItemStack(mod_IDT.AcaciaCraftingTable));
		OreDictionary.registerOre("workbench", new ItemStack(mod_IDT.DarkOakCraftingTable));
		OreDictionary.registerOre("workbench", new ItemStack(mod_IDT.GelidCraftingTable));

		// Chests
		OreDictionary.registerOre("blockChest", new ItemStack(mod_IDT.BirchChest));
		OreDictionary.registerOre("blockChest", new ItemStack(mod_IDT.SpruceChest));
		OreDictionary.registerOre("blockChest", new ItemStack(mod_IDT.JungleChest));
		OreDictionary.registerOre("blockChest", new ItemStack(mod_IDT.WillowChest));
		OreDictionary.registerOre("blockChest", new ItemStack(mod_IDT.EbonyChest));
		OreDictionary.registerOre("blockChest", new ItemStack(mod_IDT.SilkwoodChest));
		OreDictionary.registerOre("blockChest", new ItemStack(mod_IDT.AcaciaChest));
		OreDictionary.registerOre("blockChest", new ItemStack(mod_IDT.DarkOakChest));
		OreDictionary.registerOre("blockChest", new ItemStack(mod_IDT.GelidChest));

		// Trapped Chests
		OreDictionary.registerOre("trappedChest", new ItemStack(mod_IDT.BirchTrapChest));
		OreDictionary.registerOre("trappedChest", new ItemStack(mod_IDT.SpruceTrapChest));
		OreDictionary.registerOre("trappedChest", new ItemStack(mod_IDT.JungleTrapChest));
		OreDictionary.registerOre("trappedChest", new ItemStack(mod_IDT.WillowTrapChest));
		OreDictionary.registerOre("trappedChest", new ItemStack(mod_IDT.EbonyTrapChest));
		OreDictionary.registerOre("trappedChest", new ItemStack(mod_IDT.SilkwoodTrapChest));
		OreDictionary.registerOre("trappedChest", new ItemStack(mod_IDT.AcaciaTrapChest));
		OreDictionary.registerOre("trappedChest", new ItemStack(mod_IDT.DarkOakTrapChest));
		OreDictionary.registerOre("trappedChest", new ItemStack(mod_IDT.GelidTrapChest));

		// Torches
		OreDictionary.registerOre("blockTorch", new ItemStack(mod_IDT.BirchTorch));
		OreDictionary.registerOre("blockTorch", new ItemStack(mod_IDT.SpruceTorch));
		OreDictionary.registerOre("blockTorch", new ItemStack(mod_IDT.JungleTorch));
		OreDictionary.registerOre("blockTorch", new ItemStack(mod_IDT.WillowTorch));
		OreDictionary.registerOre("blockTorch", new ItemStack(mod_IDT.EbonyTorch));
		OreDictionary.registerOre("blockTorch", new ItemStack(mod_IDT.SilkwoodTorch));
		OreDictionary.registerOre("blockTorch", new ItemStack(mod_IDT.AcaciaTorch));
		OreDictionary.registerOre("blockTorch", new ItemStack(mod_IDT.DarkOakTorch));
		OreDictionary.registerOre("blockTorch", new ItemStack(mod_IDT.GelidTorch));

		// Redstone Torches
		OreDictionary.registerOre("redstoneTorch", new ItemStack(mod_IDT.BirchRedTorchOn));
		OreDictionary.registerOre("redstoneTorch", new ItemStack(mod_IDT.SpruceRedTorchOn));
		OreDictionary.registerOre("redstoneTorch", new ItemStack(mod_IDT.JungleRedTorchOn));
		OreDictionary.registerOre("redstoneTorch", new ItemStack(mod_IDT.WillowRedTorchOn));
		OreDictionary.registerOre("redstoneTorch", new ItemStack(mod_IDT.EbonyRedTorchOn));
		OreDictionary.registerOre("redstoneTorch", new ItemStack(mod_IDT.SilkwoodRedTorchOn));
		OreDictionary.registerOre("redstoneTorch", new ItemStack(mod_IDT.AcaciaRedTorchOn));
		OreDictionary.registerOre("redstoneTorch", new ItemStack(mod_IDT.DarkOakRedTorchOn));
		OreDictionary.registerOre("redstoneTorch", new ItemStack(mod_IDT.GelidRedTorchOn));

		// Ladders
		OreDictionary.registerOre("blockLadder", new ItemStack(mod_IDT.BirchLadder));
		OreDictionary.registerOre("blockLadder", new ItemStack(mod_IDT.SpruceLadder));
		OreDictionary.registerOre("blockLadder", new ItemStack(mod_IDT.JungleLadder));
		OreDictionary.registerOre("blockLadder", new ItemStack(mod_IDT.WillowLadder));
		OreDictionary.registerOre("blockLadder", new ItemStack(mod_IDT.EbonyLadder));
		OreDictionary.registerOre("blockLadder", new ItemStack(mod_IDT.SilkwoodLadder));
		OreDictionary.registerOre("blockLadder", new ItemStack(mod_IDT.AcaciaLadder));
		OreDictionary.registerOre("blockLadder", new ItemStack(mod_IDT.DarkOakLadder));
		OreDictionary.registerOre("blockLadder", new ItemStack(mod_IDT.GelidLadder));

		// Fences
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_IDT.BirchFence));
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_IDT.SpruceFence));
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_IDT.JungleFence));
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_IDT.WillowFence));
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_IDT.EbonyFence));
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_IDT.SilkwoodFence));
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_IDT.AcaciaFence));
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_IDT.DarkOakFence));
		OreDictionary.registerOre("fenceWood", new ItemStack(mod_IDT.GelidFence));

		// Fence Gates
		OreDictionary.registerOre("fenceGate", new ItemStack(mod_IDT.BirchFenceGate));
		OreDictionary.registerOre("fenceGate", new ItemStack(mod_IDT.SpruceFenceGate));
		OreDictionary.registerOre("fenceGate", new ItemStack(mod_IDT.JungleFenceGate));
		OreDictionary.registerOre("fenceGate", new ItemStack(mod_IDT.WillowFenceGate));
		OreDictionary.registerOre("fenceGate", new ItemStack(mod_IDT.EbonyFenceGate));
		OreDictionary.registerOre("fenceGate", new ItemStack(mod_IDT.SilkwoodFenceGate));
		OreDictionary.registerOre("fenceGate", new ItemStack(mod_IDT.AcaciaFenceGate));
		OreDictionary.registerOre("fenceGate", new ItemStack(mod_IDT.DarkOakFenceGate));
		OreDictionary.registerOre("fenceGate", new ItemStack(mod_IDT.GelidFenceGate));

		// Trapdoors
		OreDictionary.registerOre("trapdoor", new ItemStack(mod_IDT.BirchTrapdoor));
		OreDictionary.registerOre("trapdoor", new ItemStack(mod_IDT.SpruceTrapdoor));
		OreDictionary.registerOre("trapdoor", new ItemStack(mod_IDT.JungleTrapdoor));
		OreDictionary.registerOre("trapdoor", new ItemStack(mod_IDT.WillowTrapdoor));
		OreDictionary.registerOre("trapdoor", new ItemStack(mod_IDT.EbonyTrapdoor));
		OreDictionary.registerOre("trapdoor", new ItemStack(mod_IDT.SilkwoodTrapdoor));
		OreDictionary.registerOre("trapdoor", new ItemStack(mod_IDT.AcaciaTrapdoor));
		OreDictionary.registerOre("trapdoor", new ItemStack(mod_IDT.DarkOakTrapdoor));
		OreDictionary.registerOre("trapdoor", new ItemStack(mod_IDT.GelidTrapdoor));

		// Secret Trapdoors
		OreDictionary.registerOre("secretTrapdoor", new ItemStack(mod_IDT.SecretBirchTrapdoor));
		OreDictionary.registerOre("secretTrapdoor", new ItemStack(mod_IDT.SecretSpruceTrapdoor));
		OreDictionary.registerOre("secretTrapdoor", new ItemStack(mod_IDT.SecretJungleTrapdoor));
		OreDictionary.registerOre("secretTrapdoor", new ItemStack(mod_IDT.SecretWillowTrapdoor));
		OreDictionary.registerOre("secretTrapdoor", new ItemStack(mod_IDT.SecretEbonyTrapdoor));
		OreDictionary.registerOre("secretTrapdoor", new ItemStack(mod_IDT.SecretSilkwoodTrapdoor));
		OreDictionary.registerOre("secretTrapdoor", new ItemStack(mod_IDT.SecretAcaciaTrapdoor));
		OreDictionary.registerOre("secretTrapdoor", new ItemStack(mod_IDT.SecretDarkOakTrapdoor));
		OreDictionary.registerOre("secretTrapdoor", new ItemStack(mod_IDT.SecretGelidTrapdoor));

		// Walls - Wooden
		OreDictionary.registerOre("wallWood", new ItemStack(mod_IDT.BirchWall));
		OreDictionary.registerOre("wallWood", new ItemStack(mod_IDT.SpruceWall));
		OreDictionary.registerOre("wallWood", new ItemStack(mod_IDT.JungleWall));
		OreDictionary.registerOre("wallWood", new ItemStack(mod_IDT.WillowWall));
		OreDictionary.registerOre("wallWood", new ItemStack(mod_IDT.EbonyWall));
		OreDictionary.registerOre("wallWood", new ItemStack(mod_IDT.SilkwoodWall));
		OreDictionary.registerOre("wallWood", new ItemStack(mod_IDT.AcaciaWall));
		OreDictionary.registerOre("wallWood", new ItemStack(mod_IDT.DarkOakWall));
		OreDictionary.registerOre("wallWood", new ItemStack(mod_IDT.GelidWall));

		// Wall Parts
		OreDictionary.registerOre("wallWoodPart", new ItemStack(mod_IDT.BirchWallPart));
		OreDictionary.registerOre("wallWoodPart", new ItemStack(mod_IDT.SpruceWallPart));
		OreDictionary.registerOre("wallWoodPart", new ItemStack(mod_IDT.JungleWallPart));
		OreDictionary.registerOre("wallWoodPart", new ItemStack(mod_IDT.WillowWallPart));
		OreDictionary.registerOre("wallWoodPart", new ItemStack(mod_IDT.EbonyWallPart));
		OreDictionary.registerOre("wallWoodPart", new ItemStack(mod_IDT.SilkwoodWallPart));
		OreDictionary.registerOre("wallWoodPart", new ItemStack(mod_IDT.AcaciaWallPart));
		OreDictionary.registerOre("wallWoodPart", new ItemStack(mod_IDT.DarkOakWallPart));
		OreDictionary.registerOre("wallWoodPart", new ItemStack(mod_IDT.GelidWallPart));

		// Doors
		OreDictionary.registerOre("doorWood", new ItemStack(mod_IDT.BirchDoorItem));
		OreDictionary.registerOre("doorWood", new ItemStack(mod_IDT.SpruceDoorItem));
		OreDictionary.registerOre("doorWood", new ItemStack(mod_IDT.JungleDoorItem));
		OreDictionary.registerOre("doorWood", new ItemStack(mod_IDT.WillowDoorItem));
		OreDictionary.registerOre("doorWood", new ItemStack(mod_IDT.EbonyDoorItem));
		OreDictionary.registerOre("doorWood", new ItemStack(mod_IDT.SilkwoodDoorItem));
		OreDictionary.registerOre("doorWood", new ItemStack(mod_IDT.AcaciaDoorItem));
		OreDictionary.registerOre("doorWood", new ItemStack(mod_IDT.DarkOakDoorItem));
		OreDictionary.registerOre("doorWood", new ItemStack(mod_IDT.GelidDoorItem));

		// Other
		OreDictionary.registerOre("stickSteel", new ItemStack(mod_IDT.SteelRod));
		OreDictionary.registerOre("rodSteel", new ItemStack(mod_IDT.SteelRod));

		// Records
		OreDictionary.registerOre("record", new ItemStack(mod_IDT.cd_23));
		OreDictionary.registerOre("record", new ItemStack(mod_IDT.cd_icy));
		OreDictionary.registerOre("record", new ItemStack(mod_IDT.cd_r51));

		// Liquids
		OreDictionary.registerOre("liquidNitrogen", new ItemStack(mod_IDT.LiquidNitrogen));

		// Vanilla stuff not in the ore dict
		// Stone brick stuff
		OreDictionary.registerOre("stonebrick", new ItemStack(Blocks.stonebrick, 1, 0));
		OreDictionary.registerOre("stonebrick", new ItemStack(Blocks.stonebrick, 1, 1));
		OreDictionary.registerOre("stonebrick", new ItemStack(Blocks.stonebrick, 1, 2));
		OreDictionary.registerOre("stonebrick", new ItemStack(Blocks.stonebrick, 1, 3));

		// Sandstone stuff
		OreDictionary.registerOre("sandstone", new ItemStack(Blocks.sandstone, 1, 0));
		OreDictionary.registerOre("sandstone", new ItemStack(Blocks.sandstone, 1, 1));
		OreDictionary.registerOre("sandstone", new ItemStack(Blocks.sandstone, 1, 2));

		// Quartz stuff
		OreDictionary.registerOre("quartzBlocks", new ItemStack(Blocks.quartz_block, 1, 0));
		OreDictionary.registerOre("quartzBlocks", new ItemStack(Blocks.quartz_block, 1, 1));
		OreDictionary.registerOre("quartzBlocks", new ItemStack(Blocks.quartz_block, 1, 2));

		// Cobble
		OreDictionary.registerOre("cobblestone", new ItemStack(Blocks.cobblestone));
		OreDictionary.registerOre("cobblestone", new ItemStack(Blocks.mossy_cobblestone));
	}
}
