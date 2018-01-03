package com.mce.api.nei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.mce.common.mod_IDT;
import com.mce.entity.tile.tech.TileEntitySmelter;
import com.mce.gui.SmelterGui;
import com.mce.handlers.custom_recipes.SmelterRecipes;
import com.mce.handlers.custom_recipes.SmelterRecipes.OreDictItemStackSmelter;
import com.mce.handlers.custom_recipes.SmelterRecipes.RecipeSmelter;

import codechicken.nei.ItemList;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import cofh.lib.inventory.ComparableItemStackSafe;
import cofh.lib.util.helpers.ItemHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SmelterNEIRecipeHandler extends TemplateRecipeHandler {
	public static ArrayList<FuelPair> afuels;
	public static HashSet<Block> efuels;
	
	public SmelterNEIRecipeHandler(){
		super();
	}

	@Override
	public void loadTransferRects() {
		transferRects.add(new RecipeTransferRect(new Rectangle(3, 0, 16, 50), "fuel"));
		transferRects.add(new RecipeTransferRect(new Rectangle(95, 23, 24, 16), "idt.smelter"));
	}

	@Override
	public Class<? extends GuiContainer> getGuiClass() {
		return SmelterGui.class;
	}

	@Override
	public String getRecipeName() {
		return NEIClientUtils.translate("recipe.smelter");
	}

	@Override
	public TemplateRecipeHandler newInstance() {
		if (afuels == null || afuels.isEmpty()) {
			findFuels();
		}
		return super.newInstance();
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals("idt.smelter")) {
			RecipeSmelter[] recipes = SmelterRecipes.getRecipeList();

			for (RecipeSmelter recipe : recipes) {
				arecipes.add(new NEIRecpieSmelter(recipe));
			}
		} else {
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		RecipeSmelter[] recipes = SmelterRecipes.getRecipeList();

		for (RecipeSmelter recipe : recipes) {
			if (NEIServerUtils.areStacksSameType(recipe.getOutput(), result)) {
				arecipes.add(new NEIRecpieSmelter(recipe));
			}
		}
	}

	@Override
	public void loadUsageRecipes(String inputId, Object... ingredients) {
		if (inputId.equals("fuel") && getClass() == SmelterNEIRecipeHandler.class) {
			loadCraftingRecipes("idt.smelter");
		} else {
			super.loadUsageRecipes(inputId, ingredients);
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		RecipeSmelter[] recipes = SmelterRecipes.getRecipeList();

		for (RecipeSmelter recipe : recipes) {
			if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getInput1(), ingredient)
					|| NEIServerUtils.areStacksSameTypeCrafting(recipe.getInput2(), ingredient)) {
				arecipes.add(new NEIRecpieSmelter(recipe));
			}
		}
	}

	@Override
	public String getGuiTexture() {
		return "mod_idt:textures/gui/nei/smelter_nei.png";
	}

	@Override
	public void drawExtras(int recipe) {
		drawProgressBar(3, -12, 176, 17, 16, 49, 0.5f, 7);
		drawProgressBar(95, 23, 176, 0, 24, 16, 48, 0);
		// drawProgressBar(159, 20, 192, 17, 4, 50, 0f, 7);
		
		if(((SmeltingPair) arecipes.get(recipe)).result.contains(mod_IDT.VCDust)){
			drawString("Upgrade is Required.", 100, 20);
		}
	}

	private void drawString(String string, int i, int j) {
		
	}

	private static Set<Item> excludedFuels() {
		Set<Item> efuels = new HashSet<Item>();
		efuels.add(Item.getItemFromBlock(Blocks.brown_mushroom));
		efuels.add(Item.getItemFromBlock(Blocks.red_mushroom));
		efuels.add(Item.getItemFromBlock(Blocks.standing_sign));
		efuels.add(Item.getItemFromBlock(Blocks.wall_sign));
		efuels.add(Item.getItemFromBlock(Blocks.trapped_chest));
		return efuels;
	}

	private static void findFuels() {
		afuels = new ArrayList<FuelPair>();
		Set<Item> efuels = excludedFuels();
		for (ItemStack item : ItemList.items) {
			Block block = Block.getBlockFromItem(item.getItem());
			if (block instanceof BlockDoor) {
				continue;
			}
			if (efuels.contains(item.getItem())) {
				continue;
			}

			int burnTime = TileEntitySmelter.getItemFuel(item);
			if (burnTime > 0) {
				afuels.add(new FuelPair(item.copy(), burnTime));
			}
		}
	}

	@Override
	public String getOverlayIdentifier() {
		return "idt.smelter";
	}

	public class SmeltingPair extends CachedRecipe {
		PositionedStack input = null;
		PositionedStack input2 = null;
		PositionedStack result = null;
		ArrayList<ItemStack> inputList = null;
		ArrayList<ItemStack> input2List = null;
		boolean cycleInput = true;
		boolean cycleInput2 = true;

		String inputOreName = "Unknown";
		String inputOreName2 = "Unknown";

		int inputPosition = 0;
		int input2Position = 0;

		protected void setOres() {

			if (input != null) {
				inputOreName = ItemHelper.getOreName(input.item);

				if (!inputOreName.equals("Unknown")) {
					inputList = OreDictionary.getOres(inputOreName);
				}
				cycleInput &= ComparableItemStackSafe.getOreID(inputOreName) != -1;
			}
			if (input2 != null) {
				inputOreName2 = ItemHelper.getOreName(input2.item);

				if (!inputOreName2.equals("Unknown")) {
					input2List = OreDictionary.getOres(inputOreName2);
				}
				cycleInput2 &= ComparableItemStackSafe.getOreID(inputOreName2) != -1;
			}
		}

		protected void cycleInput1() {
			if(inputList == null || inputList.size() <= 0){
				return;
			}
			if (cycleInput && !inputOreName.equals("Unknown")) {
				inputPosition++;
				inputPosition %= inputList.size();

				int stackSize = input.item.stackSize;
				input.item = inputList.get(inputPosition);
				input.item.stackSize = stackSize;
				if (inputList.get(inputPosition).getItemDamage() != OreDictionary.WILDCARD_VALUE) {
					input.item.setItemDamage(inputList.get(inputPosition).getItemDamage());
				}
			}
		}

		protected void cycleInput2() {
			if(input2List == null || input2List.size() <= 0){
				return;
			}
			if (cycleInput2 && !inputOreName2.equals("Unknown")) {
				input2Position++;
				input2Position %= input2List.size();

				int stackSize = input2.item.stackSize;
				input2.item = input2List.get(input2Position);
				input2.item.stackSize = stackSize;
				if (input2List.get(input2Position).getItemDamage() != OreDictionary.WILDCARD_VALUE) {
					input2.item.setItemDamage(input2List.get(input2Position).getItemDamage());
				}
			}
		}

		public PositionedStack getIngredient() {
			if (cycleticks % 20 == 0) {
				cycleInput1();
			}

			return input;
		}

		public PositionedStack getResult() {
			return result;
		}

		public ArrayList<PositionedStack> getOtherStacks() {
			ArrayList<PositionedStack> stacks = new ArrayList<PositionedStack>();
			if (input2 != null) {
				if (cycleticks % 20 == 0) {
					cycleInput2();
				}
				stacks.add(input2);
			}

			return stacks;
		}
	}

	public static class FuelPair {
		public PositionedStack stack;
		public int burnTime;

		public FuelPair(ItemStack ingred, int burnTime) {
			this.stack = new PositionedStack(ingred, 3, 39, false);
			this.burnTime = burnTime;
		}
	}
	
	class NEIRecpieSmelter extends SmeltingPair {
		public NEIRecpieSmelter(RecipeSmelter recipe) {
			result = new PositionedStack(recipe.getOutput(), 131, 24);
			if (recipe.getInput1() != null) {
				input = new PositionedStack(recipe.getInput1(), 69, 25);
			}

			if (recipe.getInput2() != null) {
				input2 = new PositionedStack(recipe.getInput2(), 49, 25);
			}

			setOres();
			cycleInput = OreDictItemStackSmelter.getOreID(inputOreName) != -1;
			cycleInput2 = OreDictItemStackSmelter.getOreID(inputOreName2) != -1;
		}
	}
}
