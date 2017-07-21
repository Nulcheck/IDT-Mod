package com.mce.handlers;

import com.mce.common.mod_IDT;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ToolRecipeHandler {
	@SuppressWarnings("unchecked")
	public static void registerCrafting() {
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.SteelPick, 1),
				"***", " s ", " s ", '*', "ingotSteel", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.TitaniumPick, 1),
				"***", " s ", " s ", '*', "ingotTitanium", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.VanadiumPick, 1),
				"***", " s ", " s ", '*', "ingotVanadium", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.VCPick, 1), "***",
				" s ", " s ", '*', "ingotVC", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.NeoronPick, 1),
				"***", " s ", " s ", '*', "ingotNeoron", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.SteelShovel, 1),
				"*", "s", "s", '*', "ingotSteel", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.TitaniumShovel, 1),
				"*", "s", "s", '*', "ingotTitanium", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.VanadiumShovel, 1),
				"*", "s", "s", '*', "ingotVanadium", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.VCShovel, 1), "*",
				"s", "s", '*', "ingotVC", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.SteelAxe, 1), "** ",
				"*s ", " s ", '*', "ingotSteel", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.TitaniumAxe, 1),
				"** ", "*s ", " s ", '*', "ingotTitanium", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.VanadiumAxe, 1),
				"** ", "*s ", " s ", '*', "ingotVanadium", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.VCAxe, 1), "** ",
				"*s ", " s ", '*', "ingotVC", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.SteelSword, 1), "*",
				"*", "s", '*', "ingotSteel", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.TitaniumSword, 1),
				"*", "*", "s", '*', "ingotTitanium", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.VanadiumSword, 1),
				"*", "*", "s", '*', "ingotVanadium", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.VCSword, 1), "*",
				"*", "s", '*', "ingotVC", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.SteelHoe, 1), "** ",
				" s ", " s ", '*', "ingotSteel", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.TitaniumHoe, 1),
				"** ", " s ", " s ", '*', "ingotTitanium", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.VanadiumHoe, 1),
				"** ", " s ", " s ", '*', "ingotVanadium", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.VCHoe, 1), "** ",
				" s ", " s ", '*', "ingotVC", 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(
				new ItemStack(Items.flint_and_steel, 1), "ingotSteel", new ItemStack(Items.flint)));
	}
}
