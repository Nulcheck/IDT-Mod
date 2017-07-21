package com.mce.api.nei;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.gui.IndustrialCutterGui;
import com.mce.handlers.custom_recipes.IndustrialCutterRecipes;

import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import codechicken.nei.recipe.TemplateRecipeHandler.RecipeTransferRect;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public class CutterNEIRecipeHandler extends TemplateRecipeHandler {
	public class CuttingPair extends CachedRecipe {
		PositionedStack ingred;
		PositionedStack result;

		public CuttingPair(ItemStack ingred, ItemStack result) {
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
		transferRects.add(new RecipeTransferRect(new Rectangle(75, 23, 24, 16), "idt.cutter"));
	}

	public Class<? extends GuiContainer> getGuiClass() {
		return IndustrialCutterGui.class;
	}

	public String getRecipeName() {
		return NEIClientUtils.translate("recipe.cutter");
	}

	public TemplateRecipeHandler newInstance() {
		return super.newInstance();
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals("idt.cutter") && getClass() == CutterNEIRecipeHandler.class) {
			Map<ItemStack, ItemStack> recipes = IndustrialCutterRecipes.instance().getRecipeList();
			for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
				arecipes.add(new CuttingPair(recipe.getKey(), recipe.getValue()));
			}
		} else {
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		Map<ItemStack, ItemStack> recipes = IndustrialCutterRecipes.instance().getRecipeList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameType(recipe.getValue(), result)) {
				arecipes.add(new CuttingPair(recipe.getKey(), recipe.getValue()));
			}
		}
	}

	@Override
	public void loadUsageRecipes(String inputId, Object... ingredients) {
		if (inputId.equals("idt.power") && getClass() == CutterNEIRecipeHandler.class) {
			loadCraftingRecipes("idt.power");
		} else {
			super.loadUsageRecipes(inputId, ingredients);
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		Map<ItemStack, ItemStack> recipes = IndustrialCutterRecipes.instance().getRecipeList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getKey(), ingredient)) {
				CuttingPair arecipe = new CuttingPair(recipe.getKey(), recipe.getValue());
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
		return "idt.cutter";
	}
}
