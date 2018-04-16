package com.mce.api.nei;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.common.mod_IDT;
import com.mce.entity.tile.tech.TileEntitySmelter;
import com.mce.gui.SmelterGui;
import com.mce.handlers.custom_recipes.SmelterRecipes;
import com.mce.handlers.custom_recipes.SmelterRecipes.DoubleInputHandler;

import codechicken.nei.ItemList;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

public class SmelterNEIRecipeHandler extends TemplateRecipeHandler {
	public static ArrayList<FuelPair> afuels;
	public static HashSet<Block> efuels;

	public SmelterNEIRecipeHandler() {
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
		return NEIClientUtils.translate("idt.smelter");
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
		if (outputId.equals("idt.smelter") && getClass() == SmelterNEIRecipeHandler.class) {
			Map<ItemStack, ItemStack> recipes = SmelterRecipes.getRecipeListMap();
			for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
				arecipes.add(new SmelterPair(recipe.getKey(), recipe.getValue()));
			}
		} else {
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result) {
		Map<ItemStack, ItemStack> recipes = SmelterRecipes.getRecipeListMap();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameType(recipe.getValue(), result)) {
				arecipes.add(new SmelterPair(recipe.getKey(), recipe.getValue()));
			}
		}
	}

	@Override
	public void loadUsageRecipes(String inputId, Object... ingredients) {
		if (inputId.equals("idt.smelter") && getClass() == SmelterNEIRecipeHandler.class) {
			loadCraftingRecipes("idt.smelter");
		} else {
			super.loadUsageRecipes(inputId, ingredients);
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient) {
		Map<ItemStack, ItemStack> recipes = SmelterRecipes.getRecipeListMap();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet()) {
			if (NEIServerUtils.areStacksSameTypeCrafting(recipe.getKey(), ingredient)) {
				SmelterPair arecipe = new SmelterPair(recipe.getKey(), recipe.getValue());
				arecipe.setIngredientPermutation(Arrays.asList(arecipe.in, arecipe.in2), ingredient);
				arecipes.add(arecipe);
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

		if (((SmelterPair) arecipes.get(recipe)).out.contains(mod_IDT.VanadiumCarbideDust)) {
			drawString("Upgrade is Required.", 100, 20);
		}
	}

	private void drawString(String string, int i, int j) {

	}

	/*
	 * private static Set<Item> excludedFuels() { Set<Item> efuels = new
	 * HashSet<Item>();
	 * efuels.add(Item.getItemFromBlock(Blocks.brown_mushroom));
	 * efuels.add(Item.getItemFromBlock(Blocks.red_mushroom));
	 * efuels.add(Item.getItemFromBlock(Blocks.standing_sign));
	 * efuels.add(Item.getItemFromBlock(Blocks.wall_sign));
	 * efuels.add(Item.getItemFromBlock(Blocks.trapped_chest)); return efuels; }
	 */

	private static void findFuels() {
		afuels = new ArrayList<FuelPair>();
		// Set<Item> efuels = excludedFuels();
		for (ItemStack item : ItemList.items) {
			Block block = Block.getBlockFromItem(item.getItem());
			if (block instanceof BlockDoor) {
				continue;
			}
			/*
			 * if (efuels.contains(item.getItem())) { continue; }
			 */

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

	public class SmelterPair extends CachedRecipe {
		PositionedStack in;
		PositionedStack in2;
		PositionedStack out;
		DoubleInputHandler stackIn2;

		public SmelterPair(ItemStack in, ItemStack out) {
			// in.stackSize = 1;
			this.in = new PositionedStack(in, 51, 24);
			this.in2 = new PositionedStack(stackIn2.getInput2(), 64, 24);
			this.out = new PositionedStack(out, 111, 24);
		}

		public List<PositionedStack> getIngredients() {
			return getCycledIngredients(cycleticks / 48, Arrays.asList(in, in2));
		}

		public PositionedStack getResult() {
			return out;
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
}
