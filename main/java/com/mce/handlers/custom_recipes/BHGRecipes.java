package com.mce.handlers.custom_recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BHGRecipes {
	private static final BHGRecipes compBase = new BHGRecipes();
	private Map compList = new HashMap();

	public static BHGRecipes compressing() {
		return compBase;
	}

	private BHGRecipes() {
		this.compBlock(mod_IDT.DarkMatter);
	}

	public void compBlock(Block block) {
		this.compItem(Item.getItemFromBlock(block));
	}

	public void compItem(Item item) {
		this.comp3(new ItemStack(item, 1, 32767));
	}

	public void comp3(ItemStack stack1) {
		this.compList.put(stack1, null);
	}

	public ItemStack getInput(ItemStack stack) {
		Iterator iter = this.compList.entrySet().iterator();
		Entry entry;

		do {
			if (!iter.hasNext()) {
				return null;
			}

			entry = (Entry) iter.next();
		} while (!this.input(stack, (ItemStack) entry.getKey()));

		return stack;
	}

	private boolean input(ItemStack in, ItemStack out) {
		return in.getItem() == out.getItem();
	}

	/**
	 * Returns the cutting result of an item.
	 */
	public ItemStack getCompressingResult(ItemStack stack) {
		Iterator iterator = this.compList.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}

			entry = (Entry) iterator.next();
		} while (!this.compressingOutput(stack, (ItemStack) entry.getKey()));

		return (ItemStack) entry.getValue();
	}

	private boolean compressingOutput(ItemStack in, ItemStack out) {
		return out.getItem() == in.getItem();
	}

	public Map getRecipeList() {
		return this.compList;
	}

	public static BHGRecipes instance() {
		return compBase;
	}
}