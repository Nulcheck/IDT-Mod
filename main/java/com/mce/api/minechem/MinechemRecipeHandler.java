package com.mce.api.minechem;

import com.mce.common.mod_IDT;

import minechem.api.RecipeAPI;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MinechemRecipeHandler {
	private static final MinechemRecipeHandler recipes = new MinechemRecipeHandler();

	public static MinechemRecipeHandler getInstance() {
		return recipes;
	}

	public void recipes() {
		// Decomp
		// ores 48, ingots 16
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.EinsteiniumOre), "48 Es");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.NeptuniumOre), "48 Np");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CrystalOre), "5 amblygonite");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.PraseodymiumOre), "48 Pr");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.NeodymiumOre), "48 Nd");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.VanadiumOre), "48 V");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.TantalumOre), "48 Ta");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SulfurOre), "48 S");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.BoronOre), "48 B");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CopperOre), "48 Cu");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.EinsteiniumIngot), "16 Es");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.NeptuniumIngot), "16 Np");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.PraseodymiumIngot), "16 Pr");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.NeodymiumIngot), "16 Nd");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.VanadiumIngot), "16 V");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.TantalumIngot), "16 Ta");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.Sulfur), "16 S");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.BoronIngot), "16 B");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CopperIngot), "16 Cu");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SiliconIngot), "16 Si");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.VCIngot), "6 V, 3 C");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SteelIngot), "16 Fe, 1 C");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.TitaniumIngot), "16 Ti");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.NeoronIngot), "16 Fe, 16 Nd");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CrystalGem), "7 amblygonite");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CutCrystalGem), "7 amblygonite");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CrystalNugget), "5 amblygonite");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CrystalPiece), "3 amblygonite");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CrystalDust), "1 amblygonite");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CrystalBlock), "9 amblygonite");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CrystalBall), "28 amblygonite");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.HardCrystalBall), "28 amblygonite");
		RecipeAPI.addDecompositionRecipe(new ItemStack(Items.lava_bucket), "16 magma", "48 Fe");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.Cement), "2 siliconDioxide");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CementBricks), "4 siliconDioxide");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CryingObsidian), "16 siliconDioxide", "8 magnesiumOxide",
				"16 water");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.LavaObsidian), "16 siliconDioxide", "8 magnesiumOxide",
				"16 magma");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.LavaCobble), "2 siliconDioxide", "16 magma");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.Nitroglycerin), "1 nitroglycerin");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.VPowder), "2 V");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.V2O5), "2 V", "5 O");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SO2), "1 S", "2 O");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SO3), "1 S", "3 O");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.HNO3), "1 H", "1 N", "3 O");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.H2SO4), "2 H", "1 S", "4 O");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.Glycerin), "3 C", "8 H", "3 O");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.NO2Tank), "16 nitrogenDioxide", "96 Fe");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.PropaneTank), "16 propane", "96 Fe");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.Carbon), "1 C");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CopperDust), "1 Cu");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SiliconDust), "1 Si");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.VCDust), "2 V, 1 C");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.PureQuartz), "2 siliconDioxide");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CopperWire), "6 Cu");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.VanadiumWire), "6 V");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SiliconWafer), "4 Si");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CopperFoil), "4 Cu");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.CopperPlate), "8 Cu");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.TitaniumPlate), "8 Ti");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.VanadiumPlate), "8 V");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.TantalumPlate), "8 Ta");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.TantalumFoil), "4 Ta");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.LiquidNitrogenBucket), "48 N", "16 Fe");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.IceShard), "4 water");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.cd_icy), "2 polyvinylChloride");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.cd_23), "2 polyvinylChloride");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.cd_r51), "2 polyvinylChloride");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.DidymiumGlass), "16 siliconDioxide", "16 Pr", "16 Nd");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.DidymiumGlassPane), "6 siliconDioxide", "6 Pr", "6 Nd");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.EinsteiniumGlass), "16 siliconDioxide", "16 Es");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.EinsteiniumGlassPane), "6 siliconDioxide", "6 Es");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.NeptuniumGlass), "16 siliconDioxide", "16 Np");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.NeptuniumGlassPane), "6 siliconDioxide", "6 Np");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.UraniumGlass), "16 siliconDioxide", "16 U");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.UraniumGlassPane), "6 siliconDioxide", "6 U");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.AcaciaButton), "2 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.DarkOakButton), "2 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.AcaciaPressurePlate), "4 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.DarkOakPressurePlate), "4 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.GlassSlab), "8 siliconDioxide");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.BirchRedTorchOn), "1 cellulose", "1 iron3oxide", "1 Cu");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SpruceRedTorchOn), "1 cellulose", "1 iron3oxide",
				"1 Cu");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.JungleRedTorchOn), "1 cellulose", "1 iron3oxide",
				"1 Cu");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.AcaciaRedTorchOn), "1 cellulose", "1 iron3oxide",
				"1 Cu");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.DarkOakRedTorchOn), "1 cellulose", "1 iron3oxide",
				"1 Cu");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.WillowRedTorchOn), "1 cellulose", "1 iron3oxide",
				"1 Cu");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.EbonyRedTorchOn), "1 cellulose", "1 iron3oxide", "1 Cu");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SilkwoodRedTorchOn), "1 cellulose", "1 iron3oxide",
				"1 Cu");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.StoneBrickWall), "2 cellulose", "4 siliconDioxide");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.OakWall), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.BirchWall), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SpruceWall), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.JungleWall), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.AcaciaWall), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.DarkOakWall), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.WillowWall), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.EbonyWall), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SilkwoodWall), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.WillowLog), "8 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.EbonyLog), "8 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SilkwoodLog), "8 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.WillowPlanks), "2 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.EbonyPlanks), "2 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SilkwoodPlanks), "2 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.WillowLeaves), "4 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.EbonyLeaves), "4 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SilkwoodLeaves), "4 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.WillowSapling), "1 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.EbonySapling), "1 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SilkwoodSapling), "1 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.EbonyChest), "16 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SecretOakTrapdoor), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SecretBirchTrapdoor), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SecretSpruceTrapdoor), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SecretJungleTrapdoor), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SecretAcaciaTrapdoor), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SecretDarkOakTrapdoor), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SecretWillowTrapdoor), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SecretEbonyTrapdoor), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SecretSilkwoodTrapdoor), "6 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SecretCementTrapdoor), "6 siliconDioxide");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SecretCementBrickTrapdoor), "3 Si", "3 O");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SecretStoneTrapdoor), "3 Si", "3 O");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SecretCobblestoneTrapdoor), "3 Si", "3 O");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.IDTCraftingTable), "8 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.StoneBrick), "1 Si", "2 O");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.AcaciaWallPart), "2 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.DarkOakWallPart), "2 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.WillowWallPart), "2 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.EbonyWallPart), "2 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.SilkwoodWallPart), "2 cellulose");
		RecipeAPI.addDecompositionRecipe(new ItemStack(mod_IDT.WikiPaper), "1 cellulose");

		// Synth
		// output, shaped recipe (bool), energy cost, inputs
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.EinsteiniumIngot), false, 1000, "16 Es");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.NeptuniumIngot), false, 1000, "16 Np");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.PraseodymiumIngot), false, 1000, "16 Pr");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.NeodymiumIngot), false, 1000, "16 Nd");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.VanadiumIngot), false, 1000, "16 V");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.TantalumIngot), false, 1000, "16 Ta");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.Sulfur), false, 1000, "16 S");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.Cement), false, 1000, "2 siliconDioxide");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.CementBricks), true, 1000, "1 siliconDioxide",
				"1 siliconDioxide", "", "1 siliconDioxide", "1 siliconDioxide", "", "", "", "", "", "");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.CrystalGem), true, 1000, "", "1 amblygonite",
				"1 amblygonite", "1 amblygonite", "1 amblygonite", "1 amblygonite", "1 amblygonite", "1 amblygonite",
				"");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.CrystalNugget), true, 1000, "", "1 amblygonite", "",
				"1 amblygonite", "1 amblygonite", "1 amblygonite", "", "1 amblygonite", "");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.CrystalPiece), true, 1000, "", "1 amblygonite", "",
				"1 amblygonite", "1 amblygonite", "1 amblygonite", "1 amblygonite", "1 amblygonite", "1 amblygonite");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.CrystalDust), false, 1000, "1 amblygonite");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.CrystalBlock), true, 1000, "7 amblygonite", "7 amblygonite",
				"7 amblygonite", "7 amblygonite", "7 amblygonite", "7 amblygonite", "7 amblygonite", "7 amblygonite",
				"7 amblygonite");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.CrystalBall), true, 1000, "", "7 amblygonite", "",
				"7 amblygonite", "", "7 amblygonite", "", "7 amblygonite", "");
		RecipeAPI.addSynthesisRecipe(new ItemStack(Items.lava_bucket), true, 1000, "", "", "", "16 Fe", "16 magma",
				"16 Fe", "", "16 Fe", "");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.CryingObsidian), true, 1000, "4 siliconDioxide",
				"4 siliconDioxide", "4 siliconDioxide", "2 magnesiumOxide", "16 water", "4 siliconDioxide",
				"2 magnesiumOxide", "2 magnesiumOxide", "2 magnesiumOxide");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.LavaObsidian), true, 1000, "4 siliconDioxide",
				"4 siliconDioxide", "4 siliconDioxide", "2 magnesiumOxide", "16 magma", "4 siliconDioxide",
				"2 magnesiumOxide", "2 magnesiumOxide", "2 magnesiumOxide");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.LavaCobble), true, 1000, "1 siliconDioxide",
				"1 siliconDioxide", "1 siliconDioxide", "1 siliconDioxide", "16 magma", "1 siliconDioxide",
				"1 siliconDioxide", "1 siliconDioxide", "1 siliconDioxide");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.Nitroglycerin), false, 1000, "1  nitroglycerin");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.VPowder), true, 1000, "2 V", "", "", "", "", "", "", "", "");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.V2O5), false, 1000, "2 V", "5 O");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.LiquidNitrogenBucket), true, 1000, "", "", "", "16 Fe",
				"16 N", "16 Fe", "", "16 Fe", "");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.NO2Tank), true, 1000, "", "16 Fe", "", "16 Fe",
				"16 nitrogenDioxide", "16 Fe", "16 Fe", "16 Fe", "16 Fe");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.PropaneTank), true, 1000, "", "16 Fe", "", "16 Fe",
				"16 propane", "16 Fe", "16 Fe", "16 Fe", "16 Fe");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.Carbon), false, 1000, "1 C");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.HNO3), false, 1000, "1 H", "1 N", "3 O");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.SO2), false, 1000, "1 S", "2 O");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.SO3), false, 1000, "1 S", "3 O");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.H2SO4), false, 1000, "2 H", "1 S", "4 O");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.cd_icy), true, 1000, "2 polyvinylChloride", "", "", "", "",
				"", "", "", "");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.cd_23), true, 1000, "", "2 polyvinylChloride", "", "", "",
				"", "", "", "");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.cd_r51), true, 1000, "", "", "2 polyvinylChloride", "", "",
				"", "", "", "");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.DidymiumGlass), true, 1000, "4 siliconDioxide", "",
				"4 siliconDioxide", "16 Pr", "", "16 Nd", "4 siliconDioxide", "", "4 siliconDioxide");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.EinsteiniumGlass), true, 1000, "4 siliconDioxide", "",
				"4 siliconDioxide", "", "16 Es", "", "4 siliconDioxide", "", "4 siliconDioxide");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.NeptuniumGlass), true, 1000, "4 siliconDioxide", "",
				"4 siliconDioxide", "", "16 Np", "", "4 siliconDioxide", "", "4 siliconDioxide");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.UraniumGlass), true, 1000, "4 siliconDioxide", "",
				"4 siliconDioxide", "", "16 U", "", "4 siliconDioxide", "", "4 siliconDioxide");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.DidymiumGlassPane), true, 1000, "1 siliconDioxide",
				"1 siliconDioxide", "1 siliconDioxide", "6 Pr", "", "6 Nd", "1 siliconDioxide", "1 siliconDioxide",
				"1 siliconDioxide");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.EinsteiniumGlassPane), true, 1000, "1 siliconDioxide",
				"1 siliconDioxide", "1 siliconDioxide", "", "6 Es", "", "1 siliconDioxide", "1 siliconDioxide",
				"1 siliconDioxide");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.NeptuniumGlassPane), true, 1000, "1 siliconDioxide",
				"1 siliconDioxide", "1 siliconDioxide", "", "6 Np", "", "1 siliconDioxide", "1 siliconDioxide",
				"1 siliconDioxide");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.UraniumGlassPane), true, 1000, "1 siliconDioxide",
				"1 siliconDioxide", "1 siliconDioxide", "", "6 U", "", "1 siliconDioxide", "1 siliconDioxide",
				"1 siliconDioxide");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.Flask), true, 1000, "", "7 siliconDioxide", "",
				"5 siliconDioxide", "", "5 siliconDioxide", "5 siliconDioxide", "5 siliconDioxide", "5 siliconDioxide");
		RecipeAPI.addSynthesisRecipe(new ItemStack(mod_IDT.EmptyTank), true, 1000, "", "16 Fe", "", "16 Fe", "",
				"16 Fe", "16 Fe", "16 Fe", "16 Fe");
	}
}