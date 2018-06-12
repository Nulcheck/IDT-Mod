package com.mce.handlers;

import java.util.Random;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class TradeSmithHandler implements IVillageTradeHandler {

	@SuppressWarnings("unchecked")
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {

		recipeList.add(new MerchantRecipe(new ItemStack(mod_IDT.EinsteiniumIngot, 5), new ItemStack(Items.emerald, 2)));

		recipeList.add(new MerchantRecipe(new ItemStack(mod_IDT.NeptuniumIngot, 5), new ItemStack(Items.emerald, 2)));

		recipeList.add(new MerchantRecipe(new ItemStack(mod_IDT.UraniumIngot, 5), new ItemStack(Items.emerald, 2)));

		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 2), new ItemStack(mod_IDT.IronSawBlade, 1)));

		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(mod_IDT.TitaniumSawBlade, 1)));

		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 10), new ItemStack(mod_IDT.DiamondSawBlade, 1)));

		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 5), new ItemStack(mod_IDT.TitaniumIngot, 1)));

		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 8), new ItemStack(mod_IDT.TitaniumHelmet, 1)));

		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 2), new ItemStack(mod_IDT.SteelIngot, 1)));

		recipeList.add(new MerchantRecipe(new ItemStack(mod_IDT.TitaniumIngot, 1), new ItemStack(Items.emerald, 3)));

		recipeList.add(new MerchantRecipe(new ItemStack(mod_IDT.SteelIngot, 1), new ItemStack(Items.emerald, 2)));

		recipeList.add(new MerchantRecipe(new ItemStack(mod_IDT.DiamondSawBlade, 1), new ItemStack(Items.emerald, 3)));
	}
}
