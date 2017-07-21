package com.mce.handlers.custom_recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TankCompressorRecipes {
	private static final TankCompressorRecipes compBase = new TankCompressorRecipes();
	/** The list of compressing results. */
	private Map compList = new HashMap();
	private Map experienceList = new HashMap();
	private static final String __OBFID = "CL_00000085";

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static TankCompressorRecipes compressing() {
		return compBase;
	}

	private TankCompressorRecipes() {
		this.compItem(mod_IDT.EmptyTank, new ItemStack(mod_IDT.NO2Tank), 0.7f);
	}

	public void compBlock(Block block, ItemStack stack, float exp) {
		this.compItem(Item.getItemFromBlock(block), stack, exp);
	}

	public void compItem(Item item, ItemStack stack, float exp) {
		this.comp3(new ItemStack(item, 1, 32767), stack, exp);
	}

	public void comp3(ItemStack stack1, ItemStack stack2, float exp) {
		this.compList.put(stack1, stack2);
		this.experienceList.put(stack2, Float.valueOf(exp));
	}
	
	public ItemStack getInput(ItemStack stack){
		Iterator iter = this.compList.entrySet().iterator();
		Entry entry;
		
		do{
			if(!iter.hasNext()){
				return null;
			}
			
			entry = (Entry) iter.next();
		} while(!this.input(stack, (ItemStack) entry.getKey()));

		return stack;
	}
	
	private boolean input(ItemStack in, ItemStack out){
		return in.getItem() == out.getItem();
	}

	/**
	 * Returns the result of an item.
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

	public float expHandling(ItemStack stack) {
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1)
			return ret;

		Iterator iterator = this.experienceList.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return 0.0F;
			}

			entry = (Entry) iterator.next();
		} while (!this.compressingOutput(stack, (ItemStack) entry.getKey()));

		return ((Float) entry.getValue()).floatValue();
	}

	public static TankCompressorRecipes instance() {
		return compBase;
	}
}