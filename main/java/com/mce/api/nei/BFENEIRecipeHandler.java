package com.mce.api.nei;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.gui.BFEGui;
import com.mce.handlers.custom_recipes.BFERecipes;

import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import codechicken.nei.recipe.TemplateRecipeHandler.RecipeTransferRect;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public class BFENEIRecipeHandler extends TemplateRecipeHandler {
	public class ExtractingPair extends CachedRecipe {
		PositionedStack ingred;
		PositionedStack result;

		public ExtractingPair(ItemStack ingred, ItemStack result) {
			ingred.stackSize = 1;
			this.ingred = new PositionedStack(ingred, 51, 24);
			this.result = new PositionedStack(result, 111, 24);
		}

		public List<PositionedStack> getIngredients() {
			return getCycledIngredients(cycleticks / 48, Arrays.asList(ingred));
		}

		public PositionedStack getResult() {
			return result;
		}
	}

	public void loadTransferRects() {
		//transferRects.add(new RecipeTransferRect(new Rectangle(1, -6, 23, 22), "idt.power"));
		transferRects.add(new RecipeTransferRect(new Rectangle(75, 23, 24, 16), "idt.extract"));
	}

	public Class<? extends GuiContainer> getGuiClass() {
		return BFEGui.class;
	}

	public String getRecipeName() {
		return NEIClientUtils.translate("recipe.extract");
	}

	public TemplateRecipeHandler newInstance() {
		return super.newInstance();
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals("idt.extract") && getClass() == BFENEIRecipeHandler.class) {
			Map<ItemStack, ItemStack> recipes = BFERecipes.instance().getRecipeList();
			for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
				arecipes.add(new ExtractingPair(recipe.getKey(), recipe.getValue()));
			}
		} else {
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		Map<ItemStack, ItemStack> recipes = BFERecipes.instance().getRecipeList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameType(recipe.getValue(), result)) {
				arecipes.add(new ExtractingPair(recipe.getKey(), recipe.getValue()));
			}
		}
	}

	@Override
	public void loadUsageRecipes(String inputId, Object... ingredients) {
		if (inputId.equals("idt.power") && getClass() == BFENEIRecipeHandler.class) {
			loadCraftingRecipes("idt.power");
		} else {
			super.loadUsageRecipes(inputId, ingredients);
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		Map<ItemStack, ItemStack> recipes = BFERecipes.instance().getRecipeList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getKey(), ingredient)) {
				ExtractingPair arecipe = new ExtractingPair(recipe.getKey(), recipe.getValue());
				arecipe.setIngredientPermutation(Arrays.asList(arecipe.ingred), ingredient);
				arecipes.add(arecipe);
			}
		}
	}

	public String getGuiTexture() {
		return "mod_idt:textures/gui/nei/cutter_nei.png";
	}

	public void drawExtras(int recipe) {
		drawProgressBar(74, 24, 176, 22, 25, 16, 48, 0);
		//drawProgressBar(1, -6, 176, 0, 25, 20, 1f, 0);
	}

	public String getOverlayIdentifier() {
		return "idt.extract";
	}
}
