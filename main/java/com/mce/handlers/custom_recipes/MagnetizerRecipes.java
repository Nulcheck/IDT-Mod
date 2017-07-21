package com.mce.handlers.custom_recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MagnetizerRecipes {
	private static final MagnetizerRecipes magnetizeBase = new MagnetizerRecipes();
	/** The list of cutting results. */
	private Map magList = new HashMap();
	private Map experienceList = new HashMap();
	private static final String __OBFID = "CL_00000085";

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static MagnetizerRecipes magnetizing() {
		return magnetizeBase;
	}

	// Recipes are registered right here
	private MagnetizerRecipes() {
		this.magItem(new ItemStack(mod_IDT.NdMagnet, 1, 0), new ItemStack(mod_IDT.NdMagnet, 1, 1), 0.7f);
	}

	// For blocks into item stacks
	public void magBlock(Block block, ItemStack stack, float exp) {
		this.magItem(new ItemStack(Item.getItemFromBlock(block)), stack, exp);
	}

	// Items into item stacks
	public void magItem(ItemStack stack1, ItemStack stack, float exp) {
		this.magBase(stack1, stack, exp);
	}

	public void magBase(ItemStack stack1, ItemStack stack2, float exp) {
		this.magList.put(stack1, stack2);
		this.experienceList.put(stack2, Float.valueOf(exp));
	}
	
	public ItemStack getInput(ItemStack stack){
		Iterator iter = this.magList.entrySet().iterator();
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
	public ItemStack getMagnetizingResult(ItemStack stack) {
		Iterator iterator = this.magList.entrySet().iterator();
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
		return this.magList;
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

	public static MagnetizerRecipes instance() {
		return magnetizeBase;
	}
}