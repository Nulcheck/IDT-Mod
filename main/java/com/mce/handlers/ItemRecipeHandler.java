package com.mce.handlers;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ItemRecipeHandler {
	@SuppressWarnings("unchecked")
	public static void registerCrafting() {
		GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 1, 0), "ss ", "ss ", 's',
				new ItemStack(mod_IDT.StoneBrick));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.StoneBrick, 4), new ItemStack(Blocks.stonebrick, 1, 0));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowStick, 4), "*", "*", '*',
				new ItemStack(mod_IDT.WillowPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyStick, 4), "*", "*", '*', new ItemStack(mod_IDT.EbonyPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidStick, 4), "*", "*", '*', new ItemStack(mod_IDT.GelidPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchStick, 4), "*", "*", '*', new ItemStack(Blocks.planks, 1, 2));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceStick, 4), "*", "*", '*',
				new ItemStack(Blocks.planks, 1, 1));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleStick, 4), "*", "*", '*',
				new ItemStack(Blocks.planks, 1, 3));

		GameRegistry.addRecipe(new ItemStack(Items.stick, 4), "*", "*", '*', new ItemStack(Blocks.planks, 1, 0));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.ExplosiveCharge), " * ", "*G*", " * ", 'G',
				new ItemStack(Items.gunpowder), '*', new ItemStack(Items.paper));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AmblygonitePiece), " * ", "***", "***", '*',
				new ItemStack(mod_IDT.AmblygoniteDust));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AmblygoniteNugget), " * ", "***", " * ", '*',
				new ItemStack(mod_IDT.AmblygonitePiece));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AmblygoniteGem), " **", "***", "** ", '*',
				new ItemStack(mod_IDT.AmblygoniteNugget));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AmblygoniteGem, 9), "*", '*', new ItemStack(mod_IDT.AmblygoniteBlock));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.AmblygonitePiece, 5), new ItemStack(mod_IDT.AmblygoniteNugget));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.AmblygoniteDust, 7), new ItemStack(mod_IDT.AmblygonitePiece));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.AmblygoniteNugget, 7), new ItemStack(mod_IDT.AmblygoniteGem));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.red_flower));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.yellow_flower));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.cactus));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.sapling, 1, 0));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.sapling, 1, 1));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.sapling, 1, 2));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.sapling, 1, 3));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.brown_mushroom));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.red_mushroom));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.grass, 1, 1));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.grass, 1, 2));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.grass, 1, 3));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.leaves, 1, 0));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.leaves, 1, 1));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.leaves, 1, 2));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.leaves, 1, 3));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(mod_IDT.WillowSapling));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(mod_IDT.WillowLeaves));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.vine));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.waterlily));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfLife, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Items.dye, 1, 2));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfFire, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.fire));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfFire, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Items.flint_and_steel));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfFire, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Items.lava_bucket));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfFire, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.lava));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfFire, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.flowing_lava));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfFire, 1), new ItemStack(mod_IDT.HardCrystalBall),
				new ItemStack(Blocks.netherrack));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfWater, 1),
				new ItemStack(mod_IDT.HardCrystalBall), new ItemStack(Blocks.water));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfWater, 1),
				new ItemStack(mod_IDT.HardCrystalBall), new ItemStack(Blocks.flowing_water));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfWater, 1),
				new ItemStack(mod_IDT.HardCrystalBall), new ItemStack(Items.water_bucket));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfEarth, 1),
				new ItemStack(mod_IDT.HardCrystalBall), new ItemStack(Blocks.dirt));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfEarth, 1),
				new ItemStack(mod_IDT.HardCrystalBall), new ItemStack(Blocks.grass));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.CrystalBall, 1), " * ", "* *", " * ", '*',
				new ItemStack(mod_IDT.AmblygoniteGem));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.EssenceOfAir, 1), new ItemStack(mod_IDT.HardCrystalBall));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Items.arrow, 4), "f", "*",
				"F", '*', "stickWood", 'f', new ItemStack(Items.flint), 'F', new ItemStack(Items.feather)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Items.chest_minecart, 1),
				"*", "m", '*', "blockChest", 'm', new ItemStack(Items.minecart)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.IronSawBlade, 1),
				" i ", "isi", " i ", 'i', new ItemStack(Items.iron_ingot), 's', "stickWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.SteelSawBlade, 1),
				" s ", "s*s", " s ", 's', "ingotSteel", '*', new ItemStack(mod_IDT.IronSawBlade)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.TitaniumSawBlade, 1), " t ", "t*t", " t ", 't',
						"ingotTitanium", '*', new ItemStack(mod_IDT.SteelSawBlade)));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DiamondSawBlade, 1), " d ", "d*d", " d ", 'd',
				new ItemStack(Items.diamond), '*', new ItemStack(mod_IDT.TitaniumSawBlade));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.Gear), " i ", "iri",
				" i ", 'i', "ingotIron", 'r', "rodSteel"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.Gear), " i ", "iri",
				" i ", 'i', "ingotIron", 'r', "stickSteel"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.SteelHelmet), "***", "* *", '*', "ingotSteel"));

		CraftingManager.getInstance().getRecipeList().add(
				new ShapedOreRecipe(new ItemStack(mod_IDT.SteelChestplate), "* *", "***", "***", '*', "ingotSteel"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.SteelLeggings), "***", "* *", "* *", '*', "ingotSteel"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.SteelBoots), "* *", "* *", '*', "ingotSteel"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.TitaniumHelmet), "***", "* *", '*', "ingotTitanium"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.TitaniumChestplate),
				"* *", "***", "***", '*', "ingotTitanium"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.TitaniumLeggings),
				"***", "* *", "* *", '*', "ingotTitanium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.TitaniumBoots), "* *", "* *", '*', "ingotTitanium"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.ZimphnodeHelmet), "***", "* *", '*',
				new ItemStack(mod_IDT.ZimphnodeBar));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.ZimphnodeChestplate), "* *", "***", "***", '*',
				new ItemStack(mod_IDT.ZimphnodeBar));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.ZimphnodeLeggings), "***", "* *", "* *", '*',
				new ItemStack(mod_IDT.ZimphnodeBar));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.ZimphnodeBoots), "* *", "* *", '*',
				new ItemStack(mod_IDT.ZimphnodeBar));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.VanadiumHelmet), "***", "* *", '*', "ingotVanadium"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.VanadiumChestplate),
				"* *", "***", "***", '*', "ingotVanadium"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.VanadiumLeggings),
				"***", "* *", "* *", '*', "ingotVanadium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.VanadiumBoots), "* *", "* *", '*', "ingotVanadium"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.OakWallPart, 2), "*p", "*p", '*', new ItemStack(Items.stick), 'p',
				new ItemStack(Item.getItemFromBlock(Blocks.planks), 0, 0));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchWallPart, 2), "*p", "*p", '*',
				new ItemStack(mod_IDT.BirchStick), 'p', new ItemStack(Item.getItemFromBlock(Blocks.planks), 0, 2));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceWallPart, 2), "*p", "*p", '*',
				new ItemStack(mod_IDT.SpruceStick), 'p', new ItemStack(Item.getItemFromBlock(Blocks.planks), 0, 1));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleWallPart, 2), "*p", "*p", '*',
				new ItemStack(mod_IDT.JungleStick), 'p', new ItemStack(Item.getItemFromBlock(Blocks.planks), 0, 3));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowWallPart, 2), "*p", "*p", '*',
				new ItemStack(mod_IDT.WillowStick), 'p', new ItemStack(Item.getItemFromBlock(mod_IDT.WillowPlanks)));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyWallPart, 2), "*p", "*p", '*',
				new ItemStack(mod_IDT.EbonyStick), 'p', new ItemStack(Item.getItemFromBlock(mod_IDT.EbonyPlanks)));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidWallPart, 2), "*p", "*p", '*',
				new ItemStack(mod_IDT.GelidStick), 'p', new ItemStack(Item.getItemFromBlock(mod_IDT.GelidPlanks)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.OakWallPart, 2),
				"*p", "*p", '*', "stickWood", 'p', "plankWood"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.Chisel, 1), " *",
				"s ", '*', new ItemStack(Items.iron_ingot), 's', "stickWood"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodDoorItem), "**", "**", "**", '*',
				new ItemStack(mod_IDT.SilkwoodPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchDoorItem), "**", "**", "**", '*',
				new ItemStack(Blocks.planks, 1, 2));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceDoorItem), "**", "**", "**", '*',
				new ItemStack(Blocks.planks, 1, 1));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleDoorItem), "**", "**", "**", '*',
				new ItemStack(Blocks.planks, 1, 3));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowDoorItem), "**", "**", "**", '*',
				new ItemStack(mod_IDT.WillowPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyDoorItem), "**", "**", "**", '*',
				new ItemStack(mod_IDT.EbonyPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidDoorItem), "**", "**", "**", '*',
				new ItemStack(mod_IDT.GelidPlanks));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Items.wooden_door, 1), "**", "**", "**", '*', "plankWood"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodWallPart, 2), "s*", "s*", 's',
				new ItemStack(mod_IDT.SilkwoodStick), '*', new ItemStack(mod_IDT.SilkwoodPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodStick, 4), "*", "*", '*',
				new ItemStack(mod_IDT.SilkwoodPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EmptyTank), " * ", "* *", "***", '*',
				new ItemStack(Items.iron_ingot));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.CompressorUnit), "iwi", "ipi", "ici", 'i', "ingotSteel",
						'w', "wireCopper", 'p', new ItemStack(Item.getItemFromBlock(Blocks.piston)), 'c',
						new ItemStack(mod_IDT.T1CircuitBoard)));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.WikiPaper), new ItemStack(Items.paper));

		GameRegistry.addShapelessRecipe(new ItemStack(Items.paper), new ItemStack(mod_IDT.WikiPaper));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.SteelRod, 2), "*", "*", '*', "ingotSteel"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.TantalumHelmet), "***", "* *", '*', "ingotTantalum"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.TantalumChestplate),
				"* *", "***", "***", '*', "ingotTantalum"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.TantalumLeggings),
				"***", "* *", "* *", '*', "ingotTantalum"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.TantalumBoots), "* *", "* *", '*', "ingotTantalum"));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.SO3), new ItemStack(mod_IDT.SO2),
				new ItemStack(mod_IDT.V2O5));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.H2SO4), new ItemStack(mod_IDT.SO3),
				new ItemStack(Items.water_bucket));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.HNO3), new ItemStack(mod_IDT.NO2Tank),
				new ItemStack(Items.water_bucket));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.Nitroglycerin), new ItemStack(mod_IDT.H2SO4),
				new ItemStack(mod_IDT.HNO3), new ItemStack(mod_IDT.Glycerin));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.Flask, 3), " * ", "* *", "***", '*',
				new ItemStack(Item.getItemFromBlock(Blocks.glass)));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.Carbon, 3), new ItemStack(mod_IDT.H2SO4),
				new ItemStack(Items.sugar));

		GameRegistry.addRecipe(new ItemStack(Items.coal, 1, 0), "***", "***", "***", '*',
				new ItemStack(mod_IDT.Carbon));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.CementWallPart, 2),
				"*p", "*p", '*', "stickWood", 'p', new ItemStack(mod_IDT.Cement)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.CementBrickWallPart, 2), "*p", "*p", '*', "stickWood",
						'p', new ItemStack(mod_IDT.CementBricks)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.StoneWallPart, 2),
				"*p", "*p", '*', "stickWood", 'p', new ItemStack(Blocks.stone)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(
				new ItemStack(mod_IDT.SandstoneWallPart, 2), "*p", "*p", '*', "stickWood", 'p', "sandstone"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.ObsidianWallPart, 2), "*p", "*p", '*', "stickWood", 'p',
						new ItemStack(Blocks.obsidian)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(
				new ItemStack(mod_IDT.StonebrickWallPart, 2), "*p", "*p", '*', "stickWood", 'p', "stonebrick"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.BrickWallPart, 2),
				"*p", "*p", '*', "stickWood", 'p', new ItemStack(Blocks.brick_block)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.CoalWallPart, 2),
				"*p", "*p", '*', "stickWood", 'p', new ItemStack(Blocks.coal_block)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.SnowWallPart, 2),
				"*p", "*p", '*', "stickWood", 'p', new ItemStack(Blocks.snow)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.NetherBrickWallPart, 2), "*p", "*p", '*', "stickWood",
						'p', new ItemStack(Blocks.nether_brick)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.QuartzWallPart, 2),
				"*p", "*p", '*', "stickWood", 'p', "quartzBlocks"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.CobblestoneWallPart, 2), "*p", "*p", '*', "stickWood",
						'p', new ItemStack(Blocks.cobblestone)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.MossyCobblestoneWallPart, 2), "*p", "*p", '*',
						"stickWood", 'p', new ItemStack(Blocks.mossy_cobblestone)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.NdMagnet), " n ",
				"nin", " n ", 'n', "ingotNeoron", 'i', "ingotBoron"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.CompressorUnitGA), "tgt", "vcv", "tdt", 't',
						"plateTitanium", 'g', new ItemStack(mod_IDT.CutAmblygoniteGem), 'v', "plateVanadium", 'c',
						new ItemStack(mod_IDT.CompressorUnit), 'd', new ItemStack(mod_IDT.T3CircuitBoard)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.BlowTorch), "g",
				"p", 'g', "ingotGold", 'p', new ItemStack(mod_IDT.PropaneTank)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.NeoronHelmet), "***", "* *", '*', "ingotNeoron"));

		CraftingManager.getInstance().getRecipeList().add(
				new ShapedOreRecipe(new ItemStack(mod_IDT.NeoronChestplate), "* *", "***", "***", '*', "ingotNeoron"));

		CraftingManager.getInstance().getRecipeList().add(
				new ShapedOreRecipe(new ItemStack(mod_IDT.NeoronLeggings), "***", "* *", "* *", '*', "ingotNeoron"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.NeoronBoots), "* *", "* *", '*', "ingotNeoron"));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.Propanol), new ItemStack(mod_IDT.Acrolein),
				new ItemStack(Items.water_bucket), new ItemStack(mod_IDT.EmptyTank));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.PropaneTank), new ItemStack(mod_IDT.Propene),
				new ItemStack(Items.water_bucket));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.CopperWire, 2), "***", '*', "ingotCopper"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.CopperDust, 3), "*", '*', "ingotCopper"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.CopperIngot), "***", '*', "dustCopper"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.CopperIngot, 9), "blockCopper"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.SteelIngot, 9), "blockSteel"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.TitaniumIngot, 9), "blockTitanium"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.T1CircuitBoard),
				"w w", " f ", "ccc", 'w', "wireCopper", 'f', "foilCopper", 'c', new ItemStack(mod_IDT.Plank)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.T2CircuitBoard), "w w", "ftf", "ggg", 'w', "wireCopper",
						'f', "foilCopper", 't', new ItemStack(mod_IDT.Transistor), 'g',
						new ItemStack(mod_IDT.ReinforcedGlassPane)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.T3CircuitBoard), "wmw", "fff", "ggg", 'w', "wireCopper",
						'm', new ItemStack(mod_IDT.Microchip), 'f', "foilCopper", 'g', new ItemStack(mod_IDT.BoronFG)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.Transistor), "pbp", "pbp", "www", 'p',
						new ItemStack(mod_IDT.PSiliconChip), 'b', new ItemStack(mod_IDT.BSiliconChip), 'w',
						"wireCopper"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.Microchip), "tdt", "wfw", "sss", 't',
						new ItemStack(mod_IDT.Transistor), 'f', "foilCopper", 'd', "dustAmblygonite", 'w', "wireCopper",
						's', new ItemStack(mod_IDT.SiliconWafer)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.SiliconIngot), "***", '*', "dustSilicon"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.SiliconIngot, 9), "blockSilicon"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.QMan), "wcw", "fpf", "ggg", 'w', "wireVanadium", 'c',
						new ItemStack(mod_IDT.Microchip), 'f', "foilTantalum", 'p',
						new ItemStack(mod_IDT.DarkMatterPiece), 'g', new ItemStack(mod_IDT.BoronFG)));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(mod_IDT.Plank, 4),
				"plankWood", new ItemStack(mod_IDT.IronSawBlade)));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(mod_IDT.Plank, 4),
				"plankWood", new ItemStack(mod_IDT.SteelSawBlade)));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(mod_IDT.Plank, 4),
				"plankWood", new ItemStack(mod_IDT.TitaniumSawBlade)));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(mod_IDT.Plank, 4),
				"plankWood", new ItemStack(mod_IDT.DiamondSawBlade)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.CopperPlate), "ingotCopper", "ingotCopper"));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.Carbon, 9), new ItemStack(Items.coal, 1, 0));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.SiliconDust, 3), new ItemStack(mod_IDT.SiliconIngot));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.VCHelmet), "***", "* *", '*', "ingotVanadiumCarbide"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.VCChestplate), "* *", "***", "***", '*', "ingotVanadiumCarbide"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.VCLeggings), "***", "* *", "* *", '*', "ingotVanadiumCarbide"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.VCBoots), "* *", "* *", '*', "ingotVanadiumCarbide"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.PolePiece), "wiw",
				"wiw", "wiw", 'w', "wireCopper", 'i', "ingotSteel"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.Rotor), "ppp",
				"prp", "ppp", 'p', new ItemStack(mod_IDT.PolePiece), 'r', "rodSteel"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.Rotor), "ppp",
				"prp", "ppp", 'p', new ItemStack(mod_IDT.PolePiece), 'r', "stickSteel"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.Stator), "iii",
				"www", "iii", 'i', "ingotSteel", 'w', "wireCopper"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.Alternator), "iri", "isi", "igi", 'i', "ingotIron", 'r',
						new ItemStack(mod_IDT.Rotor), 's', new ItemStack(mod_IDT.Stator), 'g',
						new ItemStack(mod_IDT.Gear)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.VanadiumIngot, 9), "blockVanadium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.VanadiumCarbideIngot, 9), "blockVanadiumCarbide"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.TantalumIngot, 9), "blockTantalum"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.EinsteiniumIngot, 9), "blockEinsteinium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.NeptuniumIngot, 9), "blockNeptunium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.UraniumIngot, 9), "blockUranium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.PraseodymiumIngot, 9), "blockPraseodymium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.NeodymiumIngot, 9), "blockNeodymium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.BoronIngot, 9), "blockBoron"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.Sulfur, 9), "blockSulfur"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.ZimphnodeBar, 9), "blockZimphnode"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.NeoronIngot, 9), "blockNeoron"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(mod_IDT.CopperFoil, 3),
				"plateCopper", new ItemStack(mod_IDT.TitaniumSawBlade)));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(mod_IDT.CopperFoil, 3),
				"plateCopper", new ItemStack(mod_IDT.DiamondSawBlade)));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.IceShard, 4), new ItemStack(mod_IDT.IronSawBlade),
				new ItemStack(Blocks.ice));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.IceShard, 4), new ItemStack(mod_IDT.SteelSawBlade),
				new ItemStack(Blocks.ice));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.IceShard, 4), new ItemStack(mod_IDT.TitaniumSawBlade),
				new ItemStack(Blocks.ice));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.IceShard, 4), new ItemStack(mod_IDT.DiamondSawBlade),
				new ItemStack(Blocks.ice));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SiliconChip, 2), "***", "***", '*',
				new ItemStack(mod_IDT.SiliconDust));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.UpgradeBase), "www",
				"sss", "sps", 's', "ingotSteel", 'p', "plateCopper", 'f', "foilCopper", 'w', "wireCopper"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.MagneticUpgrade), "sms", "mcm", "tut", 'u',
						new ItemStack(mod_IDT.UpgradeBase), 's', "ingotSteel", 't', "ingotTitanium", 'm',
						new ItemStack(mod_IDT.NdMagnet, 1, 1), 'c', new ItemStack(mod_IDT.T2CircuitBoard)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.LaserUpgrade), "sgs", "sls", "tut", 'u',
						new ItemStack(mod_IDT.UpgradeBase), 't', "ingotTitanium", 'l',
						new ItemStack(mod_IDT.AmblygoniteLens), 's', "ingotSteel", 'g', new ItemStack(Blocks.glass_pane)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.StabilizerUpgrade), "vmv", "mqm", "vuv", 'u',
						new ItemStack(mod_IDT.UpgradeBase), 'v', "ingotVanadiumCarbide", 'm',
						new ItemStack(mod_IDT.NdMagnet, 1, 1), 'q', new ItemStack(mod_IDT.QMan)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.QCUpgrade), "vcv", "mqm", "vuv", 'u',
						new ItemStack(mod_IDT.UpgradeBase), 'v', "ingotVanadium", 'm', new ItemStack(mod_IDT.NdMagnet, 1, 1),
						'q', new ItemStack(mod_IDT.QMan), 'c', new ItemStack(mod_IDT.CompressorUnitGA)));
	}

	public static void registerSmelting() {
		// Ores
		GameRegistry.addSmelting(mod_IDT.EinsteiniumOre, new ItemStack(mod_IDT.EinsteiniumIngot), 5.0F);

		GameRegistry.addSmelting(mod_IDT.NeptuniumOre, new ItemStack(mod_IDT.NeptuniumIngot), 5.0F);
		
		GameRegistry.addSmelting(mod_IDT.UraniumOre, new ItemStack(mod_IDT.UraniumIngot), 5.0F);

		GameRegistry.addSmelting(mod_IDT.AmblygoniteOre, new ItemStack(mod_IDT.AmblygoniteNugget), 5.0F);
		
		GameRegistry.addSmelting(mod_IDT.ZimphnodeOre, new ItemStack(mod_IDT.ZimphnodeBar), 5.3F);

		GameRegistry.addSmelting(mod_IDT.VanadiumOre, new ItemStack(mod_IDT.VanadiumIngot), 5.0f);

		GameRegistry.addSmelting(mod_IDT.NeodymiumOre, new ItemStack(mod_IDT.NeodymiumIngot), 5.0f);

		GameRegistry.addSmelting(mod_IDT.PraseodymiumOre, new ItemStack(mod_IDT.PraseodymiumIngot), 5.0f);

		GameRegistry.addSmelting(mod_IDT.TantalumOre, new ItemStack(mod_IDT.TantalumIngot), 5f);
		
		GameRegistry.addSmelting(mod_IDT.BoronOre, new ItemStack(mod_IDT.BoronIngot), 1.5f);

		GameRegistry.addSmelting(mod_IDT.CopperOre, new ItemStack(mod_IDT.CopperIngot), 1.5f);

		GameRegistry.addSmelting(mod_IDT.TitaniumOre, new ItemStack(mod_IDT.TitaniumIngot), 1f);

		GameRegistry.addSmelting(mod_IDT.Phosphorite, new ItemStack(mod_IDT.PhosphorusDust, 3), 1.5f);
		
		GameRegistry.addSmelting(mod_IDT.Agate, new ItemStack(mod_IDT.PureQuartz, 2), 1.5f);
		
		// Dusts
		GameRegistry.addSmelting(mod_IDT.EinsteiniumDust, new ItemStack(mod_IDT.EinsteiniumIngot), 5.0F);

		GameRegistry.addSmelting(mod_IDT.NeptuniumDust, new ItemStack(mod_IDT.NeptuniumIngot), 5.0F);
		
		GameRegistry.addSmelting(mod_IDT.UraniumDust, new ItemStack(mod_IDT.UraniumIngot), 5.0F);

		GameRegistry.addSmelting(mod_IDT.AmblygoniteDust, new ItemStack(mod_IDT.AmblygoniteNugget), 5.0F);
		
		GameRegistry.addSmelting(mod_IDT.ZimphnodeDust, new ItemStack(mod_IDT.ZimphnodeBar), 5.3F);

		GameRegistry.addSmelting(mod_IDT.VanadiumDust, new ItemStack(mod_IDT.VanadiumIngot), 5.0f);
		
		GameRegistry.addSmelting(mod_IDT.VanadiumCarbideDust, new ItemStack(mod_IDT.VanadiumCarbideIngot), 5.0f);

		GameRegistry.addSmelting(mod_IDT.NeodymiumDust, new ItemStack(mod_IDT.NeodymiumIngot), 5.0f);

		GameRegistry.addSmelting(mod_IDT.PraseodymiumDust, new ItemStack(mod_IDT.PraseodymiumIngot), 5.0f);

		GameRegistry.addSmelting(mod_IDT.TantalumDust, new ItemStack(mod_IDT.TantalumIngot), 5f);
		
		GameRegistry.addSmelting(mod_IDT.BoronDust, new ItemStack(mod_IDT.BoronIngot), 1.5f);

		GameRegistry.addSmelting(mod_IDT.CopperDust, new ItemStack(mod_IDT.CopperIngot), 1.5f);

		GameRegistry.addSmelting(mod_IDT.TitaniumDust, new ItemStack(mod_IDT.TitaniumIngot), 1f);
		
		// Logs
		GameRegistry.addSmelting(mod_IDT.WillowLog, new ItemStack(Items.coal, 1, 1), 5.0F);

		GameRegistry.addSmelting(mod_IDT.EbonyLog, new ItemStack(Items.coal, 1, 1), 5.0F);

		GameRegistry.addSmelting(mod_IDT.SilkwoodLog, new ItemStack(Items.coal, 1, 1), 5.0F);

		GameRegistry.addSmelting(mod_IDT.GelidLog, new ItemStack(Items.coal, 1, 1), 5.0F);
		
		// Other
		GameRegistry.addSmelting(mod_IDT.CrystalBall, new ItemStack(mod_IDT.HardCrystalBall), 5.0F);

		GameRegistry.addSmelting(mod_IDT.CornSeeds, new ItemStack(mod_IDT.Popcorn, 4), 3.0F);

		GameRegistry.addSmelting(mod_IDT.Sulfur, new ItemStack(mod_IDT.SO2), 3f);

		GameRegistry.addSmelting(mod_IDT.Glycerin, new ItemStack(mod_IDT.Acrolein), 1.3f);

		GameRegistry.addSmelting(mod_IDT.Propanol, new ItemStack(mod_IDT.Propene), 1.4f);
		
		GameRegistry.addSmelting(mod_IDT.V2O5, new ItemStack(mod_IDT.VanadiumIngot), 1.4f);
	}
}
