package com.mce.handlers.custom_recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BFERecipes {
	private static final BFERecipes extractingBase = new BFERecipes();
	/** The list of extracting results. */
	private Map extractingList = new HashMap();
	private Map experienceList = new HashMap();
	private static final String __OBFID = "CL_00000085";

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static BFERecipes extracting() {
		return extractingBase;
	}

	private BFERecipes() {
		this.extractItem(mod_IDT.SoyBeans, new ItemStack(mod_IDT.Glycerin), 0.7f);
		this.extractItem(mod_IDT.CornSeeds, new ItemStack(mod_IDT.Glycerin), 0.7f);
		this.extractItem(Items.wheat_seeds, new ItemStack(mod_IDT.Glycerin), 0.7f);
		this.extractItem(Items.pumpkin_seeds, new ItemStack(mod_IDT.Glycerin), 0.7f);
		this.extractItem(Items.melon_seeds, new ItemStack(mod_IDT.Glycerin), 0.7f);
	}

	public void extractBlock(Block block, ItemStack stack, float exp) {
		this.extractItem(Item.getItemFromBlock(block), stack, exp);
	}

	public void extractItem(Item item, ItemStack stack, float exp) {
		this.extract(new ItemStack(item, 1, 32767), stack, exp);
	}

	public void extract(ItemStack stack1, ItemStack stack2, float exp) {
		this.extractingList.put(stack1, stack2);
		this.experienceList.put(stack2, Float.valueOf(exp));
	}
	
	public ItemStack getInput(ItemStack stack){
		Iterator iter = this.extractingList.entrySet().iterator();
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
	 * Returns the extracting result of an item.
	 */
	public ItemStack getExtractingResult(ItemStack stack) {
		Iterator iterator = this.extractingList.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}

			entry = (Entry) iterator.next();
		} while (!this.extractingOutput(stack, (ItemStack) entry.getKey()));

		return (ItemStack) entry.getValue();
	}

	private boolean extractingOutput(ItemStack in, ItemStack out) {
		return out.getItem() == in.getItem();
	}

	public Map getRecipeList() {
		return this.extractingList;
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
		} while (!this.extractingOutput(stack, (ItemStack) entry.getKey()));

		return ((Float) entry.getValue()).floatValue();
	}

	public static BFERecipes instance() {
		return extractingBase;
	}
}