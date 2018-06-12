package com.mce.handlers.custom_recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.mce.common.mod_IDT;

import gnu.trove.map.hash.THashMap;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SmelterRecipes {
	// public static final SmelterRecipes smeltingBase = new SmelterRecipes();
	private static Map<List<ItemStack>, DoubleInputHandler> recipeMap = new THashMap();
	/*
	 * private static Map expMap = new HashMap(); private static Map input1 =
	 * new HashMap(); private static Map input2 = new HashMap(); private static
	 * Map output = new HashMap();
	 */

	/*
	 * public static SmelterRecipes instance() { return smeltingBase; }
	 */

	public SmelterRecipes() {
		addRecipe(new ItemStack(mod_IDT.SteelIngot), new ItemStack(Items.coal, 1, 0), new ItemStack(Items.iron_ingot));

		addRecipe(new ItemStack(mod_IDT.NeoronIngot), new ItemStack(Items.iron_ingot),
				new ItemStack(mod_IDT.NeodymiumIngot));

		addRecipe(new ItemStack(mod_IDT.PureQuartz), new ItemStack(Item.getItemFromBlock(Blocks.sand)),
				new ItemStack(Item.getItemFromBlock(Blocks.sand)));

		addRecipe(new ItemStack(mod_IDT.ReinforcedGlass), new ItemStack(Item.getItemFromBlock(Blocks.sand)),
				new ItemStack(Item.getItemFromBlock(Blocks.glass)));

		addRecipe(new ItemStack(mod_IDT.BoronFG), new ItemStack(mod_IDT.Fiberglass), new ItemStack(mod_IDT.BoronIngot));

		addRecipe(new ItemStack(mod_IDT.VanadiumCarbideDust), new ItemStack(mod_IDT.Carbon),
				new ItemStack(mod_IDT.VanadiumDust));

		addRecipe(new ItemStack(mod_IDT.BSiliconChip), new ItemStack(mod_IDT.SiliconChip),
				new ItemStack(mod_IDT.BoronDust));

		addRecipe(new ItemStack(mod_IDT.PSiliconChip), new ItemStack(mod_IDT.SiliconChip),
				new ItemStack(mod_IDT.PhosphorusDust));

		addRecipe(new ItemStack(mod_IDT.CrystalGlass), new ItemStack(mod_IDT.ReinforcedGlass),
				new ItemStack(mod_IDT.PureQuartz));
	}

	/*
	 * public void addRecipe(ItemStack out, ItemStack in, ItemStack in2, float
	 * exp) { // this.inputs.put(in, in2); this.input1.put(in, out);
	 * this.input2.put(in2, out); this.output.put(in2, out); //
	 * this.recipeMap.put(in2, out); this.expMap.put(out, exp); }
	 */

	public static DoubleInputHandler addRecipe(ItemStack input1, ItemStack input2, ItemStack output) {
		DoubleInputHandler recipe = new DoubleInputHandler(input1, input2, output);
		recipeMap.put(Arrays.asList(input1, input2), recipe);
		return recipe;
	}

	public static DoubleInputHandler removeRecipe(ItemStack input1, ItemStack input2) {
		return recipeMap.remove(Arrays.asList(input1, input2));
	}

	public static DoubleInputHandler getRecipe(ItemStack input1, ItemStack input2) {
		if (input1 == null || input2 == null)
			return null;
		DoubleInputHandler recipe = recipeMap.get(Arrays.asList(input1, input2));
		if (recipe == null)
			return null;
		return recipe;
	}

	public static DoubleInputHandler[] getRecipeList() {
		return recipeMap.values().toArray(new DoubleInputHandler[recipeMap.size()]);
	}

	public static Map getRecipeListMap() {
		return recipeMap;
	}

	/*
	 * public ItemStack getInput1(ItemStack stack) { Iterator iter =
	 * this.input1.entrySet().iterator(); Entry entry;
	 * 
	 * do { if (!iter.hasNext()) { return null; }
	 * 
	 * entry = (Entry) iter.next(); } while (!this.input(stack, (ItemStack)
	 * entry.getKey()));
	 * 
	 * return stack; }
	 * 
	 * public ItemStack getInput2(ItemStack stack) { Iterator iter =
	 * this.input2.entrySet().iterator(); Entry entry;
	 * 
	 * do { if (!iter.hasNext()) { return null; }
	 * 
	 * entry = (Entry) iter.next(); } while (!this.input(stack, (ItemStack)
	 * entry.getKey()));
	 * 
	 * return stack; }
	 * 
	 * private boolean input(ItemStack in, ItemStack out) { return in.getItem()
	 * == out.getItem(); }
	 * 
	 * public ItemStack getOutput(ItemStack stack) { Iterator iter =
	 * this.output.entrySet().iterator(); Entry entry;
	 * 
	 * do { if (!iter.hasNext()) { return null; }
	 * 
	 * entry = (Entry) iter.next(); } while (!this.output(stack, (ItemStack)
	 * entry.getKey()));
	 * 
	 * return (ItemStack) entry.getValue(); }
	 * 
	 * private boolean output(ItemStack in, ItemStack out) { return
	 * out.getItem() == in.getItem(); }
	 * 
	 * public Map getRecipeList() { return this.output; }
	 * 
	 * public Map getInput1List() { return this.input1; }
	 * 
	 * public Map getInput2List() { return this.input2; }
	 * 
	 * public float expHandling(ItemStack stack) { float ret =
	 * stack.getItem().getSmeltingExperience(stack); if (ret != -1) return ret;
	 * 
	 * Iterator iter = this.expMap.entrySet().iterator(); Entry entry;
	 * 
	 * do { if (!iter.hasNext()) { return 0.0F; }
	 * 
	 * entry = (Entry) iter.next(); } while (!this.output(stack, (ItemStack)
	 * entry.getKey()));
	 * 
	 * return ((Float) entry.getValue()).floatValue(); }
	 */

	public static class DoubleInputHandler {
		final ItemStack input1;
		final ItemStack input2;
		final ItemStack output;

		public DoubleInputHandler(ItemStack input2, ItemStack input1, ItemStack output) {
			this.input1 = input1;
			this.input2 = input2;
			this.output = output;
		}

		public ItemStack getInput1() {
			return input1;
		}

		public ItemStack getInput2() {
			return input2;
		}

		public ItemStack getOutput() {
			return output;
		}
	}
}