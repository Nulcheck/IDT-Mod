package com.mce.handlers.custom_recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SmelterRecipes {
	public static final SmelterRecipes smeltingBase = new SmelterRecipes();
	private HashMap smeltingList = new HashMap();
	private Map experienceList = new HashMap();
	private HashMap input1 = new HashMap();
	private HashMap input2 = new HashMap();
	private HashMap output = new HashMap();

	public static SmelterRecipes smelting() {
		return smeltingBase;
	}

	@SuppressWarnings("unchecked")
	public SmelterRecipes() {
		this.smeltItem(new ItemStack(Items.coal, 1, 0), new ItemStack(Items.iron_ingot),
				new ItemStack(mod_IDT.SteelIngot), 0.4f);

		this.smeltItem(new ItemStack(Items.iron_ingot), new ItemStack(mod_IDT.NeodymiumIngot),
				new ItemStack(mod_IDT.NeoronIngot), 0.8f);

		this.smeltBlock(new ItemStack(Item.getItemFromBlock(Blocks.sand)), Blocks.sand,
				new ItemStack(mod_IDT.PureQuartz), 0.6f);

		this.smeltItem(new ItemStack(Item.getItemFromBlock(Blocks.sand)),
				new ItemStack(Item.getItemFromBlock(Blocks.glass)), new ItemStack(mod_IDT.ReinforcedGlass), 0.7f);

		this.smeltItem(new ItemStack(mod_IDT.Fiberglass), new ItemStack(mod_IDT.BoronIngot),
				new ItemStack(mod_IDT.BoronFG), 0.6f);

		this.smeltItem(new ItemStack(mod_IDT.Carbon), new ItemStack(mod_IDT.VPowder), new ItemStack(mod_IDT.VCDust),
				1f);

		this.smeltItem(new ItemStack(mod_IDT.SiliconChip), new ItemStack(mod_IDT.BoronDust),
				new ItemStack(mod_IDT.BSiliconChip), 1.5f);

		this.smeltItem(new ItemStack(mod_IDT.SiliconChip), new ItemStack(mod_IDT.PhosphorusDust),
				new ItemStack(mod_IDT.PSiliconChip), 1.5f);

		// API shiz
		/*
		 * this.smeltItem(IDTRecipeAPI.smelterItem1, IDTRecipeAPI.smelterItem2,
		 * IDTRecipeAPI.smelterOutput, IDTRecipeAPI.smelterExp);
		 */

	}

	public void smeltBlock(ItemStack item, Block block, ItemStack out, float exp) {
		this.smeltItem(item, new ItemStack(Item.getItemFromBlock(block)), out, exp);
	}

	public void smeltItem(ItemStack in1, ItemStack in2, ItemStack out, float exp) {
		this.smeltBase(in1, in2, out, exp);
	}

	public void smeltBase(ItemStack item1, ItemStack item2, ItemStack out, float exp) {
		this.input1.put(item1, out);
		this.input2.put(item2, out);
		this.output.put(item2, out);
		this.experienceList.put(item2, Float.valueOf(exp));
	}

	public ItemStack getInput1(ItemStack stack) {
		Iterator iterator = this.input1.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}

			entry = (Entry) iterator.next();
		} while (!this.input(stack, (ItemStack) entry.getKey()));

		return stack;
	}

	public ItemStack getInput2(ItemStack stack) {
		Iterator iterator = this.input2.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}

			entry = (Entry) iterator.next();
		} while (!this.input(stack, (ItemStack) entry.getKey()));

		return stack;
	}

	public ItemStack getSmeltingResult(ItemStack stack) {
		Iterator iterator = this.output.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}

			entry = (Entry) iterator.next();
		} while (!this.getOutput(stack, (ItemStack) entry.getKey()));

		return (ItemStack) entry.getValue();
	}

	private boolean input(ItemStack in, ItemStack out) {
		return in.getItem() == out.getItem();
	}

	private boolean getOutput(ItemStack in, ItemStack out) {
		return out.getItem() == in.getItem()
		/*
		 * && (out.getItemDamage() == 32767 || out.getItemDamage() ==
		 * in.getItemDamage())
		 */;
	}

	public Map getRecipeList() {
		return this.output;
	}

	public Map getInput1List() {
		return this.input1;
	}

	public Map getInput2List() {
		return this.input2;
	}

	public Map getOutputList() {
		return this.output;
	}

	public float getExp(ItemStack stack) {
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
		} while (!this.getOutput(stack, (ItemStack) entry.getKey()));

		return ((Float) entry.getValue()).floatValue();
	}

	public static SmelterRecipes instance() {
		return smeltingBase;
	}
}