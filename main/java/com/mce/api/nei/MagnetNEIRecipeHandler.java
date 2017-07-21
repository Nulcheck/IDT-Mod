package com.mce.api.nei;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.gui.MagnetizerGui;
import com.mce.handlers.custom_recipes.MagnetizerRecipes;

import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import codechicken.nei.recipe.TemplateRecipeHandler.RecipeTransferRect;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public class MagnetNEIRecipeHandler extends TemplateRecipeHandler {
	public class MagnetizingPair extends CachedRecipe {
		PositionedStack ingred;
		PositionedStack result;

		public MagnetizingPair(ItemStack ingred, ItemStack result) {
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
		transferRects.add(new RecipeTransferRect(new Rectangle(75, 23, 24, 16), "idt.magnet"));
	}

	public Class<? extends GuiContainer> getGuiClass() {
		return MagnetizerGui.class;
	}

	public String getRecipeName() {
		return NEIClientUtils.translate("recipe.magnet");
	}

	public TemplateRecipeHandler newInstance() {
		return super.newInstance();
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals("idt.magnet") && getClass() == MagnetNEIRecipeHandler.class) {
			Map<ItemStack, ItemStack> recipes = MagnetizerRecipes.instance().getRecipeList();
			for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
				arecipes.add(new MagnetizingPair(recipe.getKey(), recipe.getValue()));
			}
		} else {
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		Map<ItemStack, ItemStack> recipes = MagnetizerRecipes.instance().getRecipeList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameType(recipe.getValue(), result)) {
				arecipes.add(new MagnetizingPair(recipe.getKey(), recipe.getValue()));
			}
		}
	}

	@Override
	public void loadUsageRecipes(String inputId, Object... ingredients) {
		if (inputId.equals("idt.power") && getClass() == MagnetNEIRecipeHandler.class) {
			loadCraftingRecipes("idt.power");
		} else {
			super.loadUsageRecipes(inputId, ingredients);
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		Map<ItemStack, ItemStack> recipes = MagnetizerRecipes.instance().getRecipeList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getKey(), ingredient)) {
				MagnetizingPair arecipe = new MagnetizingPair(recipe.getKey(), recipe.getValue());
				arecipe.setIngredientPermutation(Arrays.asList(arecipe.ingred), ingredient);
				arecipes.add(arecipe);
			}
		}
	}

	public String getGuiTexture() {
		return "mod_idt:textures/gui/nei/magnetizer_nei.png";
	}

	public void drawExtras(int recipe) {
		drawProgressBar(69, 28, 176, 22, 37, 11, 48, 0);
		//drawProgressBar(1, -6, 176, 0, 25, 20, 1f, 0);
	}

	public String getOverlayIdentifier() {
		return "idt.magnet";
	}
}
