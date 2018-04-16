package com.mce.api;

import com.mce.handlers.custom_recipes.BFERecipes;
import com.mce.handlers.custom_recipes.IndustrialCutterRecipes;
import com.mce.handlers.custom_recipes.MatterCondenserRecipes;
import com.mce.handlers.custom_recipes.SmelterRecipes;
import com.mce.handlers.custom_recipes.WelderRecipes;

import net.minecraft.item.ItemStack;

public class IDTRecipeAPI {
	/**
	 * Adds a Smelter recipe.
	 * 
	 * @param out
	 * @param in
	 * @param in2
	 */
	public static void addSmelterRecipe(ItemStack out, ItemStack in, ItemStack in2) {
		SmelterRecipes.addRecipe(in, in2, out);
	}
	
	/**
	 * Removes a Smelter recipe.
	 * 
	 * @param in
	 * @param in2
	 */
	public static void removeSmelterRecipe(ItemStack in, ItemStack in2){
		SmelterRecipes.removeRecipe(in, in2);
	}
	
	/**
	 * Adds a BioFuel Extractor recipe.
	 * 
	 * @param in
	 * @param out
	 * @param exp
	 */
	public static void addBioFuelRecipe(ItemStack in, ItemStack out, float exp){
		BFERecipes.instance().extract(in, out, exp);
	}
	
	/**
	 * Adds an Industrial Cutter recipe.
	 * 
	 * @param in
	 * @param out
	 * @param exp
	 */
	public static void addCutterRecipe(ItemStack in, ItemStack out, float exp){
		IndustrialCutterRecipes.instance().cutBase(in, out, exp);
	}
	
	/**
	 * Adds a Matter Condenser recipe.
	 * 
	 * @param in
	 * @param out
	 * @param exp
	 */
	public static void addCondenserRecipe(ItemStack in, ItemStack out, float exp){
		MatterCondenserRecipes.instance().conBase(in, out, exp);
	}
	
	/**
	 * Adds a Welder recipe.
	 * 
	 * @param in
	 * @param in2
	 * @param out
	 * @param exp
	 */
	public static void addWelderRecipe(ItemStack in, ItemStack in2, ItemStack out, float exp){
		WelderRecipes.instance().weldBase(in, in2, out, exp);
	}
}
