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

public class IndustrialCutterRecipes {
	private static final IndustrialCutterRecipes cuttingBase = new IndustrialCutterRecipes();
	/** The list of cutting results. */
	private Map cuttingList = new HashMap();
	private Map experienceList = new HashMap();
	private static final String __OBFID = "CL_00000085";

	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static IndustrialCutterRecipes cutting() {
		return cuttingBase;
	}

	private IndustrialCutterRecipes() {
		this.cutItem(mod_IDT.CrystalGem, new ItemStack(mod_IDT.CutCrystalGem), 0.7f);

		this.cutItem(mod_IDT.PureQuartz, new ItemStack(mod_IDT.SiliconDust, 6), 0.5f);

		this.cutItem(mod_IDT.SiliconIngot, new ItemStack(mod_IDT.SiliconWafer, 4), 0.8f);

		this.cutItem(mod_IDT.CopperPlate, new ItemStack(mod_IDT.CopperFoil, 6), 0.5f);

		this.cutItem(mod_IDT.TantalumPlate, new ItemStack(mod_IDT.TantalumFoil, 3), 0.5f);

		this.cutItem(mod_IDT.VanadiumIngot, new ItemStack(mod_IDT.VanadiumWire, 4), 0.5f);

		this.cutItem(Item.getItemFromBlock(mod_IDT.ReinforcedGlassPane), new ItemStack(mod_IDT.Fiberglass, 6), 0.7f);

		this.cutItem(Item.getItemFromBlock(Blocks.ice), new ItemStack(mod_IDT.IceShard, 6), 0.5f);

		this.cutItem(mod_IDT.BoronIngot, new ItemStack(mod_IDT.BoronDust, 3), 0.5f);

		this.cutItem(mod_IDT.CutCrystalGem, new ItemStack(mod_IDT.CrystalRod, 2), 0.8f);

		this.cutItem(mod_IDT.CrystalRod, new ItemStack(mod_IDT.CrystalLens), 1f);

		this.cutBase(new ItemStack(Blocks.log, 1, 0), new ItemStack(Blocks.planks, 6, 0), 0f);

		this.cutBase(new ItemStack(Blocks.log, 1, 1), new ItemStack(Blocks.planks, 6, 1), 0f);

		this.cutBase(new ItemStack(Blocks.log, 1, 2), new ItemStack(Blocks.planks, 6, 2), 0f);

		this.cutBase(new ItemStack(Blocks.log, 1, 3), new ItemStack(Blocks.planks, 6, 3), 0f);

		this.cutBase(new ItemStack(Blocks.log2, 1, 0), new ItemStack(Blocks.planks, 6, 4), 0f);

		this.cutBase(new ItemStack(Blocks.log2, 1, 1), new ItemStack(Blocks.planks, 6, 5), 0f);

		this.cutBase(new ItemStack(mod_IDT.WillowLog), new ItemStack(mod_IDT.WillowPlanks, 6), 0f);

		this.cutBase(new ItemStack(mod_IDT.SilkwoodLog), new ItemStack(mod_IDT.SilkwoodPlanks, 6), 0f);

		this.cutBase(new ItemStack(mod_IDT.EbonyLog), new ItemStack(mod_IDT.EbonyPlanks, 6), 0f);

		this.cutBase(new ItemStack(mod_IDT.GelidLog), new ItemStack(mod_IDT.GelidPlanks, 6), 0f);

		this.cutBase(new ItemStack(Blocks.planks, 1, 0), new ItemStack(Items.stick, 4), 0f);

		this.cutBase(new ItemStack(Blocks.planks, 1, 1), new ItemStack(mod_IDT.SpruceStick, 4), 0f);

		this.cutBase(new ItemStack(Blocks.planks, 1, 2), new ItemStack(mod_IDT.BirchStick, 4), 0f);

		this.cutBase(new ItemStack(Blocks.planks, 1, 3), new ItemStack(mod_IDT.JungleStick, 4), 0f);

		this.cutBase(new ItemStack(Blocks.planks, 1, 4), new ItemStack(mod_IDT.AcaciaStick, 4), 0f);

		this.cutBase(new ItemStack(Blocks.planks, 1, 5), new ItemStack(mod_IDT.DarkOakStick, 4), 0f);

		this.cutBase(new ItemStack(mod_IDT.WillowPlanks), new ItemStack(mod_IDT.WillowStick, 4), 0f);

		this.cutBase(new ItemStack(mod_IDT.SilkwoodPlanks), new ItemStack(mod_IDT.SilkwoodStick, 4), 0f);

		this.cutBase(new ItemStack(mod_IDT.EbonyPlanks), new ItemStack(mod_IDT.EbonyStick, 4), 0f);

		this.cutBase(new ItemStack(mod_IDT.GelidPlanks), new ItemStack(mod_IDT.GelidStick, 4), 0f);
	}

	/**
	 * 
	 * @param In
	 *            (Block)
	 * @param Out
	 * @param exp
	 */
	public void cutBlock(Block block, ItemStack stack, float exp) {
		this.cutItem(Item.getItemFromBlock(block), stack, exp);
	}

	/**
	 * 
	 * @param In
	 * @param Out
	 * @param exp
	 */
	public void cutItem(Item item, ItemStack stack, float exp) {
		this.cutBase(new ItemStack(item, 1, 32767), stack, exp);
	}

	public void cutBase(ItemStack stack1, ItemStack stack2, float exp) {
		this.cuttingList.put(stack1, stack2);
		this.experienceList.put(stack2, Float.valueOf(exp));
	}

	public ItemStack getInput(ItemStack stack) {
		Iterator iter = this.cuttingList.entrySet().iterator();
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
	public ItemStack getCuttingResult(ItemStack stack) {
		Iterator iterator = this.cuttingList.entrySet().iterator();
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
		return this.cuttingList;
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

	public static IndustrialCutterRecipes instance() {
		return cuttingBase;
	}
}