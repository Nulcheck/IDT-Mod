package com.mce.handlers;

import java.util.Random;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class TradeFarmerHandler implements IVillageTradeHandler {

	@SuppressWarnings("unchecked")
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
		recipeList.add(new MerchantRecipe(new ItemStack(mod_IDT.CornSeeds, 32), new ItemStack(Items.emerald, 1)));

		recipeList.add(new MerchantRecipe(new ItemStack(mod_IDT.SoyBeans, 32), new ItemStack(Items.emerald, 1)));

		recipeList.add(new MerchantRecipe(new ItemStack(mod_IDT.Corn, 32), new ItemStack(Items.emerald, 1)));
	}
}
