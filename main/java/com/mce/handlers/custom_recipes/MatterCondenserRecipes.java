package com.mce.handlers.custom_recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MatterCondenserRecipes {
	private static final MatterCondenserRecipes condensingBase = new MatterCondenserRecipes();
	/** The list of cutting results. */
	private Map condenseList = new HashMap();
	private Map experienceList = new HashMap();
	private static final String __OBFID = "CL_00000085";

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static MatterCondenserRecipes condensing() {
		return condensingBase;
	}

	// Recipes are registered right here
	private MatterCondenserRecipes() {
		this.conItem(new ItemStack(Blocks.obsidian, 64), new ItemStack(mod_IDT.DarkMatterPiece), 10f);
	}

	public void conItem(ItemStack stack1, ItemStack stack2, float exp) {
		this.conBase(stack1, stack2, exp);
	}

	public void conBase(ItemStack stack1, ItemStack stack2, float exp) {
		this.condenseList.put(stack1, stack2);
		this.experienceList.put(stack2, Float.valueOf(exp));
	}
	
	public ItemStack getInput(ItemStack stack){
		Iterator iter = this.condenseList.entrySet().iterator();
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
	public ItemStack getCondensingResult(ItemStack stack) {
		Iterator iterator = this.condenseList.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}

			entry = (Entry) iterator.next();
		} while (!this.cuttingOutput(stack, (ItemStack) entry.getKey()));

		return (ItemStack) entry.getValue();
	}

	private boolean cuttingOutput(ItemStack in, ItemStack out) {
		return out.getItem() == in.getItem();
	}

	public Map getRecipeList() {
		return this.condenseList;
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
		} while (!this.cuttingOutput(stack, (ItemStack) entry.getKey()));

		return ((Float) entry.getValue()).floatValue();
	}

	public static MatterCondenserRecipes instance() {
		return condensingBase;
	}
}