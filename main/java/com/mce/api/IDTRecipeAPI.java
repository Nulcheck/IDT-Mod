package com.mce.api;

import net.minecraft.item.ItemStack;

@SuppressWarnings({ "unchecked", "unused" })
public class IDTRecipeAPI {
	/**
	 * @param input1
	 *            - First slot input. (usually coal)
	 * @param input2
	 *            - Second slot input. (usually ingots)
	 * @param output
	 *            - Output slot.
	 * @param exp
	 *            - XP you get for smelting something.
	 * @return If recipe detected, true, otherwise false.
	 */
	public static ItemStack smelterItem1;
	public static ItemStack smelterItem2;
	public static ItemStack smelterOutput;
	public static float smelterExp;

	public static boolean addSmelterRecipe(ItemStack input1, ItemStack input2, ItemStack output, float exp) {
		try {
			Object items = IDTClassAccess.classSmelterRecipes.getConstructor(new Class[] { ItemStack.class })
					.newInstance(new Object[] { input1, input2, output, exp });
			Object recipeThing = IDTClassAccess.classSmelterRecipes
					.getMethod("add", new Class[] { IDTClassAccess.classSmelterRecipes })
					.invoke(null, new Object[] { items });
			smelterItem1 = input1;
			smelterItem2 = input2;
			smelterOutput = output;
			smelterExp = exp;
			return true;
		} catch (Exception e) {
			System.out.println(":(");
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * @param input1
	 *            - First slot input.
	 * @param input2
	 *            - Second slot input.
	 * @param output
	 *            - Output slot..
	 * @param exp
	 *            - XP you get for smelting something.
	 * @return If recipe detected, true, otherwise false.
	 */
	public static ItemStack welderItem1;
	public static ItemStack welderItem2;
	public static ItemStack welderOutput;
	public static float welderExp;

	public static boolean addWelderRecipe(ItemStack input1, ItemStack input2, ItemStack output, float exp) {
		try {
			Object items = IDTClassAccess.classWelderRecipes.getConstructor(new Class[] { ItemStack.class })
					.newInstance(new Object[] { input1, input2, output, exp });
			Object recipeThing = IDTClassAccess.classWelderRecipes
					.getMethod("add", new Class[] { IDTClassAccess.classWelderRecipes })
					.invoke(null, new Object[] { items });
			welderItem1 = input1;
			welderItem2 = input2;
			welderOutput = output;
			welderExp = exp;
			return true;
		} catch (Exception e) {
		}

		return false;
	}
}
