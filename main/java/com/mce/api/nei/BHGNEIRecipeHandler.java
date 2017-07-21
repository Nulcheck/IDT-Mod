package com.mce.api.nei;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.gui.BHGGui;
import com.mce.handlers.custom_recipes.BHGRecipes;

import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public class BHGNEIRecipeHandler extends TemplateRecipeHandler {
	public class HolePair extends CachedRecipe {
		PositionedStack ingred;
		PositionedStack result;

		public HolePair(ItemStack ingred, ItemStack result) {
			ingred.stackSize = 1;
			this.ingred = new PositionedStack(ingred, 3, 23);
		}

		public List<PositionedStack> getIngredients() {
			return getCycledIngredients(cycleticks / 48, Arrays.asList(ingred));
		}

		public PositionedStack getResult() {
			return result;
		}
	}

	public void loadTransferRects() {
		transferRects.add(new RecipeTransferRect(new Rectangle(1, -6, 23, 22), "idt.power"));
		transferRects.add(new RecipeTransferRect(new Rectangle(3, 43, 79, 16), "idt.bhg"));
	}

	public Class<? extends GuiContainer> getGuiClass() {
		return BHGGui.class;
	}

	public String getRecipeName() {
		return NEIClientUtils.translate("recipe.bhg");
	}

	public TemplateRecipeHandler newInstance() {
		return super.newInstance();
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals("idt.bhg") && getClass() == BHGNEIRecipeHandler.class) {
			Map<ItemStack, ItemStack> recipes = BHGRecipes.instance().getRecipeList();
			for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
				arecipes.add(new HolePair(recipe.getKey(), recipe.getValue()));
			}
		} else {
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		Map<ItemStack, ItemStack> recipes = BHGRecipes.instance().getRecipeList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameType(recipe.getValue(), result)) {
				arecipes.add(new HolePair(recipe.getKey(), recipe.getValue()));
			}
		}
	}

	@Override
	public void loadUsageRecipes(String inputId, Object... ingredients) {
		if (inputId.equals("idt.power") && getClass() == BHGNEIRecipeHandler.class) {
			loadCraftingRecipes("idt.power");
		} else {
			super.loadUsageRecipes(inputId, ingredients);
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		Map<ItemStack, ItemStack> recipes = BHGRecipes.instance().getRecipeList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getKey(), ingredient)) {
				HolePair arecipe = new HolePair(recipe.getKey(), recipe.getValue());
				arecipe.setIngredientPermutation(Arrays.asList(arecipe.ingred), ingredient);
				arecipes.add(arecipe);
			}
		}
	}

	public String getGuiTexture() {
		return "mod_idt:textures/gui/nei/bhg_nei.png";
	}

	public void drawExtras(int recipe) {
		drawProgressBar(3, 43, 176, 22, 79, 16, 100, 4);
		//drawProgressBar(1, -6, 176, 0, 25, 20, 1f, 0);
	}

	public String getOverlayIdentifier() {
		return "idt.bhg";
	}
}
