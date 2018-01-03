package com.mce.handlers.custom_recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.api.interfaces.ISmelterRecipe;
import com.mce.common.mod_IDT;

import cofh.core.util.oredict.OreDictionaryArbiter;
import cofh.lib.inventory.ComparableItemStack;
import cofh.lib.util.helpers.ItemHelper;
import gnu.trove.map.hash.THashMap;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SmelterRecipes {
	public static final SmelterRecipes smeltingBase = new SmelterRecipes();
	private static Map<OreDictItemStackSmelter, RecipeSmelter> recipeMap = new THashMap<OreDictItemStackSmelter, RecipeSmelter>();
	private static Map experienceList = new HashMap();
	private Map input1 = new HashMap();
	private Map input2 = new HashMap();
	private static Map output = new HashMap();

	public static SmelterRecipes smelting() {
		return smeltingBase;
	}

	public SmelterRecipes() {
		addRecipe(new ItemStack(mod_IDT.SteelIngot), new ItemStack(Items.coal, 1, 0), new ItemStack(Items.iron_ingot),
				0.4f);

		addRecipe(new ItemStack(mod_IDT.NeoronIngot), new ItemStack(Items.iron_ingot),
				new ItemStack(mod_IDT.NeodymiumIngot), 0.8f);

		addRecipe(new ItemStack(mod_IDT.PureQuartz), new ItemStack(Item.getItemFromBlock(Blocks.sand)),
				new ItemStack(Item.getItemFromBlock(Blocks.sand)), 0.6f);

		addRecipe(new ItemStack(mod_IDT.ReinforcedGlass), new ItemStack(Item.getItemFromBlock(Blocks.sand)),
				new ItemStack(Item.getItemFromBlock(Blocks.glass)), 0.7f);

		addRecipe(new ItemStack(mod_IDT.BoronFG), new ItemStack(mod_IDT.Fiberglass), new ItemStack(mod_IDT.BoronIngot),
				0.6f);

		addRecipe(new ItemStack(mod_IDT.VCDust), new ItemStack(mod_IDT.Carbon), new ItemStack(mod_IDT.VPowder), 1f);

		addRecipe(new ItemStack(mod_IDT.BSiliconChip), new ItemStack(mod_IDT.SiliconChip),
				new ItemStack(mod_IDT.BoronDust), 1.5f);

		addRecipe(new ItemStack(mod_IDT.PSiliconChip), new ItemStack(mod_IDT.SiliconChip),
				new ItemStack(mod_IDT.PhosphorusDust), 1.5f);

		// API shiz
		/*
		 * this.smeltItem(IDTRecipeAPI.smelterItem1, IDTRecipeAPI.smelterItem2,
		 * IDTRecipeAPI.smelterOutput, IDTRecipeAPI.smelterExp);
		 */

	}

	public static boolean addRecipe(ItemStack out, ItemStack item1, ItemStack item2, float exp) {
		if ((item1 == null && item2 == null) || out == null) {
			return false;
		}

		RecipeSmelter recipe = new RecipeSmelter(out, item1, item2);
		recipeMap.put(new OreDictItemStackSmelter(item2), recipe);
		//experienceList.put(item2, Float.valueOf(exp));
		return true;
	}
	
	public static RecipeSmelter[] getRecipeList() {
		return recipeMap.values().toArray(new RecipeSmelter[0]);
	}

	public static RecipeSmelter getRecipe(ItemStack input) {

		if (input == null) {
			return null;
		}
		OreDictItemStackSmelter query = new OreDictItemStackSmelter(input);

		RecipeSmelter recipe = recipeMap.get(query);

		if (recipe == null) {
			query.metadata = OreDictionary.WILDCARD_VALUE;
			recipe = recipeMap.get(query);
		}
		return recipe;
	}

	public static boolean recipeExists(ItemStack input) {

		return getRecipe(input) != null;
	}

	public static class RecipeSmelter implements ISmelterRecipe {
		public static RecipeSmelter instance;
		final ItemStack input1;
		final ItemStack input2;
		final ItemStack output;

		RecipeSmelter(ItemStack out, ItemStack slot1, ItemStack slot2) {
			this.input1 = slot1;
			this.input2 = slot2;
			this.output = out;

			if (input1.stackSize < 0) {
				input1.stackSize = 1;
			}

			if (input2 != null && input2.stackSize < 0) {
				input2.stackSize = 1;
			}

			if (output.stackSize < 0) {
				output.stackSize = 1;
			}
		}

		public ItemStack getInput1() {
			if(input1 == null){
				return null;
			}
			return input1.copy();
		}

		public ItemStack getInput2() {
			if(input2 == null){
				return null;
			}
			return input2.copy();
		}

		public ItemStack getOutput() {
			return output.copy();
		}
		
		public static RecipeSmelter instance() {
			return instance;
		}
	}

	public static class OreDictItemStackSmelter extends ComparableItemStack {
		static final String ore = "ore";
		static final String ingot = "ingot";

		public static boolean safeOreType(String oreName) {
			return oreName.startsWith(ore) || oreName.startsWith(ingot);
		}

		public static int getOreID(String oreName) {

			if (!safeOreType(oreName)) {
				return -1;
			}
			return ItemHelper.oreProxy.getOreID(oreName);
		}

		public static int getOreID(ItemStack stack) {

			ArrayList<Integer> ids = OreDictionaryArbiter.getAllOreIDs(stack);

			if (ids != null) {
				for (int i = 0, e = ids.size(); i < e;) {
					int id = ids.get(i++);
					if (id != -1 && safeOreType(ItemHelper.oreProxy.getOreName(id))) {
						return id;
					}
				}
			}
			return -1;
		}

		public OreDictItemStackSmelter(ItemStack stack) {

			super(stack);
			oreID = getOreID(stack);
		}

		public OreDictItemStackSmelter(Item item, int damage, int stackSize) {

			super(item, damage, stackSize);
			this.oreID = getOreID(this.toItemStack());
		}

		@Override
		public OreDictItemStackSmelter set(ItemStack stack) {

			super.set(stack);
			oreID = getOreID(stack);

			return this;
		}
	}
}