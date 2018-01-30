package com.mce.handlers.custom_recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.common.mod_IDT;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SmelterRecipes {
	public static final SmelterRecipes smeltingBase = new SmelterRecipes();
	//private static Map recipeMap = new HashMap();
	private static Map expMap = new HashMap();
	private static Map input1 = new HashMap();
	private static Map input2 = new HashMap();
	private static Map output = new HashMap();

	public static SmelterRecipes instance() {
		return smeltingBase;
	}

	public SmelterRecipes() {
		addRecipe(new ItemStack(mod_IDT.SteelIngot), new ItemStack(Items.coal, 1, 0), new ItemStack(Items.iron_ingot),
				0.4f);

		addRecipe(new ItemStack(mod_IDT.NeoronIngot), new ItemStack(Items.iron_ingot),
				new ItemStack(mod_IDT.NeodymiumIngot), 0.8f);

		addRecipe(new ItemStack(mod_IDT.PureQuartz), new ItemStack(Item.getItemFromBlock(Blocks.sand)),
				new ItemStack(Item.getItemFromBlock(Blocks.sand)), 0.6f);

		addRecipe(new ItemStack(mod_IDT.ReinforcedGlass), new ItemStack(Item.getItemFromBlock(Blocks.sand)),
				new ItemStack(Item.getItemFromBlock(Blocks.glass)), 0.7f);

		addRecipe(new ItemStack(mod_IDT.BoronFG), new ItemStack(mod_IDT.Fiberglass), new ItemStack(mod_IDT.BoronIngot),
				0.6f);

		addRecipe(new ItemStack(mod_IDT.VCDust), new ItemStack(mod_IDT.Carbon), new ItemStack(mod_IDT.VPowder), 1f);

		addRecipe(new ItemStack(mod_IDT.BSiliconChip), new ItemStack(mod_IDT.SiliconChip),
				new ItemStack(mod_IDT.BoronDust), 1.5f);

		addRecipe(new ItemStack(mod_IDT.PSiliconChip), new ItemStack(mod_IDT.SiliconChip),
				new ItemStack(mod_IDT.PhosphorusDust), 1.5f);
	}

	public void addRecipe(ItemStack out, ItemStack in, ItemStack in2, float exp) {
		// this.inputs.put(in, in2);
		this.input1.put(in, out);
		this.input2.put(in2, out);
		this.output.put(in2, out);
		//this.recipeMap.put(in2, out);
		this.expMap.put(out, exp);
	}

	public ItemStack getInput1(ItemStack stack) {
		Iterator iter = this.input1.entrySet().iterator();
		Entry entry;

		do {
			if (!iter.hasNext()) {
				return null;
			}

			entry = (Entry) iter.next();
		} while (!this.input(stack, (ItemStack) entry.getKey()));

		return stack;
	}

	public ItemStack getInput2(ItemStack stack) {
		Iterator iter = this.input2.entrySet().iterator();
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

	public ItemStack getOutput(ItemStack stack) {
		Iterator iter = this.output.entrySet().iterator();
		Entry entry;

		do {
			if (!iter.hasNext()) {
				return null;
			}

			entry = (Entry) iter.next();
		} while (!this.output(stack, (ItemStack) entry.getKey()));

		return (ItemStack) entry.getValue();
	}

	private boolean output(ItemStack in, ItemStack out) {
		return out.getItem() == in.getItem();
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

	public float expHandling(ItemStack stack) {
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1)
			return ret;

		Iterator iter = this.expMap.entrySet().iterator();
		Entry entry;

		do {
			if (!iter.hasNext()) {
				return 0.0F;
			}

			entry = (Entry) iter.next();
		} while (!this.output(stack, (ItemStack) entry.getKey()));

		return ((Float) entry.getValue()).floatValue();
	}
}