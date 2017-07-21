package com.mce.api.nei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.mce.entity.tile.tech.TileEntityWelder;
import com.mce.gui.WelderGui;
import com.mce.handlers.custom_recipes.WelderRecipes;

import codechicken.nei.ItemList;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WelderNEIRecipeHandler extends TemplateRecipeHandler {
	public static ArrayList<FuelPair> afuels;
	public static HashSet<Block> efuels;

	public class WeldingPair extends CachedRecipe {
		PositionedStack ingred;
		PositionedStack result;

		public WeldingPair(ItemStack ingred, ItemStack result) {
			ingred.stackSize = 1;
			this.ingred = new PositionedStack(ingred, 69, 25);
			// this.ingred = new PositionedStack(ingred, 49, 25);
			this.result = new PositionedStack(result, 131, 24);
		}

		public List<PositionedStack> getIngredients() {
			return getCycledIngredients(cycleticks / 48, Arrays.asList(ingred));
		}

		public PositionedStack getResult() {
			return result;
		}

		public PositionedStack getOtherStack() {
			return afuels.get((cycleticks / 48) % afuels.size()).stack;
		}
	}

	public static class FuelPair {
		public PositionedStack stack;
		public int burnTime;

		public FuelPair(ItemStack ingred, int burnTime) {
			this.stack = new PositionedStack(ingred, 3, 5, false);
			this.burnTime = burnTime;
		}
	}

	@Override
	public void loadTransferRects() {
		transferRects.add(new RecipeTransferRect(new Rectangle(3, 16, 16, 40), "fuel"));
		transferRects.add(new RecipeTransferRect(new Rectangle(95, 23, 24, 16), "idt.welder"));
	}

	@Override
	public Class<? extends GuiContainer> getGuiClass() {
		return WelderGui.class;
	}

	@Override
	public String getRecipeName() {
		return NEIClientUtils.translate("recipe.welder");
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
		if (outputId.equals("idt.welder") && getClass() == WelderNEIRecipeHandler.class) {
			Map<ItemStack, ItemStack> recipes = WelderRecipes.instance().getRecipeList();
			for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
				arecipes.add(new WeldingPair(recipe.getKey(), recipe.getValue()));
			}
		} else {
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		Map<ItemStack, ItemStack> recipes = WelderRecipes.instance().getRecipeList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameType(recipe.getValue(), result)) {
				arecipes.add(new WeldingPair(recipe.getKey(), recipe.getValue()));
			}
		}
	}

	@Override
	public void loadUsageRecipes(String inputId, Object... ingredients) {
		if (inputId.equals("fuel") && getClass() == WelderNEIRecipeHandler.class) {
			loadCraftingRecipes("idt.welder");
		} else {
			super.loadUsageRecipes(inputId, ingredients);
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		Map<ItemStack, ItemStack> recipes = WelderRecipes.instance().getRecipeList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getKey(), ingredient)) {
				WeldingPair arecipe = new WeldingPair(recipe.getKey(), recipe.getValue());
				arecipe.setIngredientPermutation(Arrays.asList(arecipe.ingred), ingredient);
				arecipes.add(arecipe);
			}
		}
	}

	@Override
	public String getGuiTexture() {
		return "mod_idt:textures/gui/nei/welder_nei.png";
	}

	@Override
	public void drawExtras(int recipe) {
		drawProgressBar(3, 24, 176, 16, 16, 49, 1f, 0);
		drawProgressBar(95, 23, 176, 0, 24, 16, 48, 0);
		// drawProgressBar(159, 20, 192, 17, 4, 50, 0f, 7);
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

			int burnTime = TileEntityWelder.getItemFuel(item);
			if (burnTime > 0) {
				afuels.add(new FuelPair(item.copy(), burnTime));
			}
		}
	}

	@Override
	public String getOverlayIdentifier() {
		return "idt.welder";
	}
}
