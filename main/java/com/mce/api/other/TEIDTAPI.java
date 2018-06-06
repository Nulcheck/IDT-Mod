package com.mce.api.other;

import com.mce.common.mod_IDT;

import cofh.thermalexpansion.util.crafting.PulverizerManager;
import net.minecraft.item.ItemStack;

public class TEIDTAPI {
	public static void pulverizerRecipes() {
		int energy = 4000;

		// Ores
		// Energy, Input, Output, Overwrite
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.EinsteiniumOre),
				new ItemStack(mod_IDT.EinsteiniumDust, 2), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.NeptuniumOre),
				new ItemStack(mod_IDT.NeptuniumDust, 2), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.UraniumOre),
				new ItemStack(mod_IDT.UraniumDust, 2), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.CrystalOre),
				new ItemStack(mod_IDT.CrystalNugget, 3), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.PraseodymiumOre),
				new ItemStack(mod_IDT.PraseodymiumDust, 2), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.NeodymiumOre),
				new ItemStack(mod_IDT.NeodymiumDust, 2), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.VanadiumOre),
				new ItemStack(mod_IDT.VanadiumDust, 2), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.TantalumOre),
				new ItemStack(mod_IDT.TantalumDust, 2), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.SulfurOre),
				new ItemStack(mod_IDT.Sulfur, 6), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.BoronOre),
				new ItemStack(mod_IDT.BoronDust, 2), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.CopperOre),
				new ItemStack(mod_IDT.CopperDust, 2), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.TitaniumOre),
				new ItemStack(mod_IDT.TitaniumDust, 2), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.Phosphorite),
				new ItemStack(mod_IDT.PhosphorusDust, 6), true);
		
		// Dimensional
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.Agate),
				new ItemStack(mod_IDT.PureQuartz, 6), true);
		
		// Ingots
		energy = 2400;
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.EinsteiniumIngot),
				new ItemStack(mod_IDT.EinsteiniumDust, 1), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.NeptuniumIngot),
				new ItemStack(mod_IDT.NeptuniumDust, 1), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.UraniumIngot),
				new ItemStack(mod_IDT.UraniumDust, 1), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.PraseodymiumIngot),
				new ItemStack(mod_IDT.PraseodymiumDust, 1), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.NeodymiumIngot),
				new ItemStack(mod_IDT.NeodymiumDust, 1), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.VanadiumIngot),
				new ItemStack(mod_IDT.VanadiumDust, 1), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.VanadiumCarbideIngot),
				new ItemStack(mod_IDT.VanadiumCarbideDust, 1), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.TantalumIngot),
				new ItemStack(mod_IDT.TantalumDust, 1), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.BoronIngot),
				new ItemStack(mod_IDT.BoronDust, 1), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.CopperIngot),
				new ItemStack(mod_IDT.CopperDust, 1), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.TitaniumIngot),
				new ItemStack(mod_IDT.TitaniumDust, 1), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.SteelIngot),
				new ItemStack(mod_IDT.SteelDust, 1), true);
		
		// Crystals
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.CrystalGem),
				new ItemStack(mod_IDT.CrystalNugget, 7), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.CutCrystalGem),
				new ItemStack(mod_IDT.CrystalNugget, 7), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.CrystalBall),
				new ItemStack(mod_IDT.CrystalNugget, 14), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(mod_IDT.CrystalNugget, 14), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.CrystalNugget),
				new ItemStack(mod_IDT.CrystalPiece, 5), true);
		
		PulverizerManager.addRecipe(energy, new ItemStack(mod_IDT.CrystalPiece),
				new ItemStack(mod_IDT.CrystalDust, 7), true);
	}
}