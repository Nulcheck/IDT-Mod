package com.mce.handlers.custom_recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ZNGRecipes {
	private static final ZNGRecipes powerBase = new ZNGRecipes();
	private Map powerList = new HashMap();

	public static ZNGRecipes powering() {
		return powerBase;
	}

	private ZNGRecipes() {
		this.powerItem(mod_IDT.ZimphnodeBar);
		this.powerBlock(mod_IDT.ZimphnodeBlock);
	}

	public void powerBlock(Block block) {
		this.powerItem(Item.getItemFromBlock(block));
	}

	public void powerItem(Item item) {
		this.power3(new ItemStack(item, 1, 32767));
	}

	public void power3(ItemStack stack1) {
		this.powerList.put(stack1, null);
	}

	/**
	 * Returns the cutting result of an item.
	 */
	public ItemStack getCompressingResult(ItemStack stack) {
		Iterator iterator = this.powerList.entrySet().iterator();
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
		return this.powerList;
	}

	public static ZNGRecipes instance() {
		return powerBase;
	}
}