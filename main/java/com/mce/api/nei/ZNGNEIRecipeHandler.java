package com.mce.api.nei;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.gui.ZNGGui;
import com.mce.handlers.custom_recipes.ZNGRecipes;

import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public class ZNGNEIRecipeHandler extends TemplateRecipeHandler {
	public class PowerPair extends CachedRecipe {
		PositionedStack ingred;
		PositionedStack result;

		public PowerPair(ItemStack ingred, ItemStack result) {
			ingred.stackSize = 1;
			this.ingred = new PositionedStack(ingred, 75, 24);
		}

		public List<PositionedStack> getIngredients() {
			return getCycledIngredients(cycleticks / 48, Arrays.asList(ingred));
		}

		public PositionedStack getResult() {
			return result;
		}
	}

	public void loadTransferRects() {
		transferRects.add(new RecipeTransferRect(new Rectangle(114, 9, 25, 16), "idt.zng")); // Power
		transferRects.add(new RecipeTransferRect(new Rectangle(3, 26, 16, 24), "idt.zng")); // Input
	}

	public Class<? extends GuiContainer> getGuiClass() {
		return ZNGGui.class;
	}

	public String getRecipeName() {
		return NEIClientUtils.translate("recipe.zng");
	}

	public TemplateRecipeHandler newInstance() {
		return super.newInstance();
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results) {
		if (outputId.equals("idt.zng") && getClass() == ZNGNEIRecipeHandler.class) {
			Map<ItemStack, ItemStack> recipes = ZNGRecipes.instance().getRecipeList();
			for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
				arecipes.add(new PowerPair(recipe.getKey(), recipe.getValue()));
			}
		} else {
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		Map<ItemStack, ItemStack> recipes = ZNGRecipes.instance().getRecipeList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameType(recipe.getValue(), result)) {
				arecipes.add(new PowerPair(recipe.getKey(), recipe.getValue()));
			}
		}
	}

	@Override
	public void loadUsageRecipes(String inputId, Object... ingredients) {
		if (inputId.equals("idt.zng") && getClass() == ZNGNEIRecipeHandler.class) {
			loadCraftingRecipes("idt.zng");
		} else {
			super.loadUsageRecipes(inputId, ingredients);
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		Map<ItemStack, ItemStack> recipes = ZNGRecipes.instance().getRecipeList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getKey(), ingredient)) {
				PowerPair arecipe = new PowerPair(recipe.getKey(), recipe.getValue());
				arecipe.setIngredientPermutation(Arrays.asList(arecipe.ingred), ingredient);
				arecipes.add(arecipe);
			}
		}
	}

	public String getGuiTexture() {
		return "mod_idt:textures/gui/nei/zng_nei.png";
	}

	public void drawExtras(int recipe) {
		drawProgressBar(114, 9, 176, 50, 25, 16, 1f, 0);
		drawProgressBar(3, 26, 176, 0, 16, 24, 100, 7);
	}

	public String getOverlayIdentifier() {
		return "idt.zng";
	}
}
