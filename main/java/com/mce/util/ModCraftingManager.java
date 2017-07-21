package com.mce.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mce.handlers.ModBlockRecipeHandler;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class ModCraftingManager {
	private static final ModCraftingManager instance = new ModCraftingManager();
	private List recipes = new ArrayList();

	public static final ModCraftingManager getInstance() {
		return instance;
	}

	public ModCraftingManager() {
		ModBlockRecipeHandler.registerCrafting(this);
		// ModItemRecipeHandler.registerCrafting(this);
	}

	public ShapedRecipes addRecipe(ItemStack stack, Object... obj) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;

		if (obj[i] instanceof String[]) {
			String[] astring = (String[]) ((String[]) obj[i++]);

			for (int l = 0; l < astring.length; ++l) {
				String s1 = astring[l];
				++k;
				j = s1.length();
				s = s + s1;
			}
		} else {
			while (obj[i] instanceof String) {
				String s2 = (String) obj[i++];
				++k;
				j = s2.length();
				s = s + s2;
			}
		}

		HashMap hashmap;

		for (hashmap = new HashMap(); i < obj.length; i += 2) {
			Character character = (Character) obj[i];
			ItemStack itemstack1 = null;

			if (obj[i + 1] instanceof Item) {
				itemstack1 = new ItemStack((Item) obj[i + 1]);
			} else if (obj[i + 1] instanceof Block) {
				itemstack1 = new ItemStack((Block) obj[i + 1], 1, 32767);
			} else if (obj[i + 1] instanceof ItemStack) {
				itemstack1 = (ItemStack) obj[i + 1];
			}

			hashmap.put(character, itemstack1);
		}

		ItemStack[] aitemstack = new ItemStack[j * k];

		for (int i1 = 0; i1 < j * k; ++i1) {
			char c0 = s.charAt(i1);

			if (hashmap.containsKey(Character.valueOf(c0))) {
				aitemstack[i1] = ((ItemStack) hashmap.get(Character.valueOf(c0))).copy();
			} else {
				aitemstack[i1] = null;
			}
		}

		ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, stack);
		this.recipes.add(shapedrecipes);
		return shapedrecipes;
	}

	public void addShapelessRecipe(ItemStack stack, Object... obj) {
		ArrayList arraylist = new ArrayList();
		Object[] aobject = obj;
		int i = obj.length;

		for (int j = 0; j < i; ++j) {
			Object object1 = aobject[j];

			if (object1 instanceof ItemStack) {
				arraylist.add(((ItemStack) object1).copy());
			} else if (object1 instanceof Item) {
				arraylist.add(new ItemStack((Item) object1));
			} else {
				if (!(object1 instanceof Block)) {
					throw new RuntimeException("Invalid shapeless recipy!");
				}

				arraylist.add(new ItemStack((Block) object1));
			}
		}

		this.recipes.add(new ShapelessRecipes(stack, arraylist));
	}

	public ItemStack findMatchingRecipe(InventoryCrafting inv, World world) {
		int i = 0;
		ItemStack itemstack = null;
		ItemStack itemstack1 = null;
		int j;

		for (j = 0; j < inv.getSizeInventory(); ++j) {
			ItemStack itemstack2 = inv.getStackInSlot(j);

			if (itemstack2 != null) {
				if (i == 0) {
					itemstack = itemstack2;
				}

				if (i == 1) {
					itemstack1 = itemstack2;
				}

				++i;
			}
		}

		if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1
				&& itemstack1.stackSize == 1 && itemstack.getItem().isRepairable()) {
			Item item = itemstack.getItem();
			int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
			int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
			int l = j1 + k + item.getMaxDamage() * 5 / 100;
			int i1 = item.getMaxDamage() - l;

			if (i1 < 0) {
				i1 = 0;
			}

			return new ItemStack(itemstack.getItem(), 1, i1);
		} else {
			for (j = 0; j < this.recipes.size(); ++j) {
				IRecipe irecipe = (IRecipe) this.recipes.get(j);

				if (irecipe.matches(inv, world)) {
					return irecipe.getCraftingResult(inv);
				}
			}

			return null;
		}
	}

	public List getRecipeList() {
		return this.recipes;
	}
}