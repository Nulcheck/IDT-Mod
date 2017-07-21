package com.mce.handlers.custom_recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WelderRecipes {
	private static final WelderRecipes weldingBase = new WelderRecipes();
	private Map xpList = new HashMap();
	private HashMap input1 = new HashMap();
	private HashMap input2 = new HashMap();
	private HashMap output = new HashMap();

	public static WelderRecipes welding() {
		return weldingBase;
	}

	@SuppressWarnings("unchecked")
	public WelderRecipes() {
		this.weldItem(new ItemStack(mod_IDT.TitaniumIngot), new ItemStack(mod_IDT.TitaniumIngot),
				new ItemStack(mod_IDT.TitaniumPlate), 0.5f);

		/*
		 * this.weldItem(new ItemStack(mod_IDT.SteelIngot), new
		 * ItemStack(mod_IDT.SteelIngot), new ItemStack(mod_IDT.SteelPlate),
		 * .5f);
		 */

		this.weldItem(new ItemStack(mod_IDT.VanadiumIngot), new ItemStack(mod_IDT.VanadiumIngot),
				new ItemStack(mod_IDT.VanadiumPlate), 0.5f);

		this.weldItem(new ItemStack(mod_IDT.CopperIngot), new ItemStack(mod_IDT.CopperIngot),
				new ItemStack(mod_IDT.CopperPlate), 0.5f);

		this.weldItem(new ItemStack(mod_IDT.TantalumIngot), new ItemStack(mod_IDT.TantalumIngot),
				new ItemStack(mod_IDT.TantalumPlate), 0.5f);

		// API shiz
		/*
		 * if (mod_IDT.detectAddon) this.weldItem(IDTRecipeAPI.welderItem1,
		 * IDTRecipeAPI.welderItem2, IDTRecipeAPI.welderOutput,
		 * IDTRecipeAPI.welderExp);
		 */
	}

	public void weldBlock(ItemStack item, Block block, ItemStack out, float xp) {
		this.weldItem(item, new ItemStack(Item.getItemFromBlock(block)), out, xp);
	}

	public void weldItem(ItemStack in1, ItemStack in2, ItemStack out, float xp) {
		this.weldBase(in1, in2, out, xp);
	}

	public void weldBase(ItemStack item1, ItemStack item2, ItemStack out, float xp) {
		this.input1.put(item1, out);
		this.input2.put(item2, out);
		this.output.put(item2, out);
		this.xpList.put(item2, Float.valueOf(xp));
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

	private boolean input(ItemStack in, ItemStack out) {
		return in.getItem() == out.getItem();
	}

	public ItemStack getWeldingResult(ItemStack stack) {
		Iterator iter = this.output.entrySet().iterator();
		Entry entry;

		do {
			if (!iter.hasNext()) {
				return null;
			}

			entry = (Entry) iter.next();
		} while (!this.getOutput(stack, (ItemStack) entry.getKey()));

		return (ItemStack) entry.getValue();
	}

	private boolean getOutput(ItemStack in, ItemStack out) {
		return out.getItem() == in.getItem();
	}

	public Map getRecipeList() {
		return this.output;
	}

	public float getXp(ItemStack stack) {
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1) {
			return ret;
		}

		Iterator iter = this.xpList.entrySet().iterator();
		Entry entry;

		do {
			if (!iter.hasNext()) {
				return 0f;
			}

			entry = (Entry) iter.next();
		} while (!this.getOutput(stack, (ItemStack) entry.getKey()));

		return ((Float) entry.getValue()).floatValue();
	}

	public static WelderRecipes instance() {
		return weldingBase;
	}
}