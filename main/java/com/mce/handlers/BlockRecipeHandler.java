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

public class BlockRecipeHandler {
	@SuppressWarnings("unchecked")
	public static void registerCrafting() {
		GameRegistry.addRecipe(new ItemStack(mod_IDT.HealerBlock), "wrl", "grg", "dra", 'w',
				new ItemStack(mod_IDT.EssenceOfWater), 'r', new ItemStack(Items.dye, 1, 1), 'l',
				new ItemStack(mod_IDT.EssenceOfFire), 'g', new ItemStack(mod_IDT.EssenceOfLife), 'd',
				new ItemStack(mod_IDT.EssenceOfEarth), 'a', new ItemStack(mod_IDT.EssenceOfAir));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.CryingObsidian), new ItemStack(Blocks.obsidian),
				new ItemStack(Items.water_bucket));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.StoneBrick, 4), new ItemStack(Blocks.stone));

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stone_button), new ItemStack(mod_IDT.StoneBrick));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.LavaObsidian), new ItemStack(Blocks.obsidian),
				new ItemStack(Items.lava_bucket));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.LavaCobble), new ItemStack(Blocks.cobblestone),
				new ItemStack(Items.lava_bucket));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EinsteiniumBomb), "***", "*r*", "***", '*',
				new ItemStack(Items.iron_ingot), 'r', new ItemStack(mod_IDT.EinsteiniumCoreReactor));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.NeptuniumBomb), "***", "*r*", "***", '*',
				new ItemStack(Items.iron_ingot), 'r', new ItemStack(mod_IDT.NeptuniumCoreReactor));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.UraniumBomb), "***", "*r*", "***", '*',
				new ItemStack(Items.iron_ingot), 'r', new ItemStack(mod_IDT.UraniumCoreReactor));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowSlab, 6), "***", '*', new ItemStack(mod_IDT.WillowPlanks));

		GameRegistry.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 0), "***", '*', new ItemStack(Blocks.planks, 1, 0));

		GameRegistry.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 1), "***", '*', new ItemStack(Blocks.planks, 1, 1));

		GameRegistry.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 2), "***", '*', new ItemStack(Blocks.planks, 1, 2));

		GameRegistry.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 3), "***", '*', new ItemStack(Blocks.planks, 1, 3));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonySlab, 6), "***", '*', new ItemStack(mod_IDT.EbonyPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidSlab, 6), "***", '*', new ItemStack(mod_IDT.GelidPlanks));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Blocks.wooden_slab, 6, 0), "***", '*', "plankWood"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_IDT.WillowPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_IDT.EbonyPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_IDT.GelidPlanks));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Blocks.oak_stairs, 1), "*  ", "** ", "***", '*', "plankWood"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.glass));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.StoneStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stone));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowFence, 2), "***", "***", '*',
				new ItemStack(mod_IDT.WillowStick, 1, 0));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchFence, 2), "***", "***", '*',
				new ItemStack(mod_IDT.BirchStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceFence, 2), "***", "***", '*',
				new ItemStack(mod_IDT.SpruceStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleFence, 2), "***", "***", '*',
				new ItemStack(mod_IDT.JungleStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyFence, 2), "***", "***", '*',
				new ItemStack(mod_IDT.EbonyStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidFence, 2), "***", "***", '*',
				new ItemStack(mod_IDT.GelidStick));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Blocks.fence, 2, 0), "***", "***", '*', "stickWood"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.UltimateNuker), "iii", "isi", "iii", 'i',
				new ItemStack(Items.iron_ingot), 's', new ItemStack(mod_IDT.SuperReactor));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowPlanks, 4), "*", '*', new ItemStack(mod_IDT.WillowLog));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchTorch, 4), "C", "*", 'C', new ItemStack(Items.coal), '*',
				new ItemStack(mod_IDT.BirchStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceTorch, 4), "C", "*", 'C', new ItemStack(Items.coal), '*',
				new ItemStack(mod_IDT.SpruceStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleTorch, 4), "C", "*", 'C', new ItemStack(Items.coal), '*',
				new ItemStack(mod_IDT.JungleStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowTorch, 4), "C", "*", 'C', new ItemStack(Items.coal), '*',
				new ItemStack(mod_IDT.WillowStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyTorch, 4), "C", "*", 'C', new ItemStack(Items.coal), '*',
				new ItemStack(mod_IDT.EbonyStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidTorch, 4), "C", "*", 'C', new ItemStack(Items.coal), '*',
				new ItemStack(mod_IDT.GelidStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchTorch, 4), "C", "*", 'C', new ItemStack(Items.coal, 1, 1),
				'*', new ItemStack(mod_IDT.BirchStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceTorch, 4), "C", "*", 'C', new ItemStack(Items.coal, 1, 1),
				'*', new ItemStack(mod_IDT.SpruceStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleTorch, 4), "C", "*", 'C', new ItemStack(Items.coal, 1, 1),
				'*', new ItemStack(mod_IDT.JungleStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowTorch, 4), "C", "*", 'C', new ItemStack(Items.coal, 1, 1),
				'*', new ItemStack(mod_IDT.WillowStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyTorch, 4), "C", "*", 'C', new ItemStack(Items.coal, 1, 1),
				'*', new ItemStack(mod_IDT.EbonyStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidTorch, 4), "C", "*", 'C', new ItemStack(Items.coal, 1, 1),
				'*', new ItemStack(mod_IDT.GelidStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchRedTorchOn), "R", "*", 'R', new ItemStack(Items.redstone),
				'*', new ItemStack(mod_IDT.BirchStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceRedTorchOn), "R", "*", 'R', new ItemStack(Items.redstone),
				'*', new ItemStack(mod_IDT.SpruceStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleRedTorchOn), "R", "*", 'R', new ItemStack(Items.redstone),
				'*', new ItemStack(mod_IDT.JungleStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowRedTorchOn), "R", "*", 'R', new ItemStack(Items.redstone),
				'*', new ItemStack(mod_IDT.WillowStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyRedTorchOn), "R", "*", 'R', new ItemStack(Items.redstone),
				'*', new ItemStack(mod_IDT.EbonyStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidRedTorchOn), "R", "*", 'R', new ItemStack(Items.redstone),
				'*', new ItemStack(mod_IDT.GelidStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlab, 6), "***", '*', new ItemStack(Blocks.glass));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.CementStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_IDT.Cement));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.CementSlab, 6), "***", '*', new ItemStack(mod_IDT.Cement));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.StoneSlab, 6), "***", '*', new ItemStack(Blocks.stone));

		GameRegistry.addRecipe(new ItemStack(Blocks.stone_slab, 1), "*", '*', new ItemStack(mod_IDT.StoneSlab));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchButton, 1), "*", '*', new ItemStack(Blocks.planks, 1, 2));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceButton, 1), "*", '*', new ItemStack(Blocks.planks, 1, 1));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleButton, 1), "*", '*', new ItemStack(Blocks.planks, 1, 3));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowButton, 1), "*", '*', new ItemStack(mod_IDT.WillowPlanks));

		GameRegistry.addRecipe(new ItemStack(Blocks.wooden_button, 1), "*", '*', new ItemStack(Blocks.planks, 1, 0));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyButton, 1), "*", '*', new ItemStack(mod_IDT.EbonyPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidButton, 1), "*", '*', new ItemStack(mod_IDT.GelidPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchPressurePlate, 1), "**", '*',
				new ItemStack(Blocks.planks, 1, 2));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SprucePressurePlate, 1), "**", '*',
				new ItemStack(Blocks.planks, 1, 1));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JunglePressurePlate, 1), "**", '*',
				new ItemStack(Blocks.planks, 1, 3));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowPressurePlate, 1), "**", '*',
				new ItemStack(mod_IDT.WillowPlanks));

		GameRegistry.addRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1), "**", '*',
				new ItemStack(Blocks.planks, 1, 0));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyPressurePlate, 1), "**", '*',
				new ItemStack(mod_IDT.EbonyPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidPressurePlate, 1), "**", '*',
				new ItemStack(mod_IDT.GelidPlanks));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1), "**", '*', "plankWood"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchChest, 1), "***", "* *", "***", '*',
				new ItemStack(Blocks.planks, 1, 2));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceChest, 1), "***", "* *", "***", '*',
				new ItemStack(Blocks.planks, 1, 1));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleChest, 1), "***", "* *", "***", '*',
				new ItemStack(Blocks.planks, 1, 3));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowChest, 1), "***", "* *", "***", '*',
				new ItemStack(mod_IDT.WillowPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyChest, 1), "***", "* *", "***", '*',
				new ItemStack(mod_IDT.EbonyPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidChest, 1), "***", "* *", "***", '*',
				new ItemStack(mod_IDT.GelidPlanks));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Blocks.chest, 1), "***", "* *", "***", '*', "plankWood"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchTrapdoor, 2), "***", "***", '*',
				new ItemStack(Blocks.planks, 1, 2));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceTrapdoor, 2), "***", "***", '*',
				new ItemStack(Blocks.planks, 1, 1));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleTrapdoor, 2), "***", "***", '*',
				new ItemStack(Blocks.planks, 1, 3));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowTrapdoor, 2), "***", "***", '*',
				new ItemStack(mod_IDT.WillowPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyTrapdoor, 2), "***", "***", '*',
				new ItemStack(mod_IDT.EbonyPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidTrapdoor, 2), "***", "***", '*',
				new ItemStack(mod_IDT.GelidPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchLever), "*", "c", '*', new ItemStack(mod_IDT.BirchStick), 'c',
				new ItemStack(Blocks.cobblestone));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceLever), "*", "c", '*', new ItemStack(mod_IDT.SpruceStick),
				'c', new ItemStack(Blocks.cobblestone));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleLever), "*", "c", '*', new ItemStack(mod_IDT.JungleStick),
				'c', new ItemStack(Blocks.cobblestone));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowLever), "*", "c", '*', new ItemStack(mod_IDT.WillowStick),
				'c', new ItemStack(Blocks.cobblestone));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyLever), "*", "c", '*', new ItemStack(mod_IDT.EbonyStick), 'c',
				new ItemStack(Blocks.cobblestone));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidLever), "*", "c", '*', new ItemStack(mod_IDT.GelidStick), 'c',
				new ItemStack(Blocks.cobblestone));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchCraftingTable), "**", "**", '*',
				new ItemStack(Blocks.planks, 1, 2));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceCraftingTable), "**", "**", '*',
				new ItemStack(Blocks.planks, 1, 1));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleCraftingTable), "**", "**", '*',
				new ItemStack(Blocks.planks, 1, 3));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowCraftingTable), "**", "**", '*',
				new ItemStack(mod_IDT.WillowPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyCraftingTable), "**", "**", '*',
				new ItemStack(mod_IDT.EbonyPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidCraftingTable), "**", "**", '*',
				new ItemStack(mod_IDT.GelidPlanks));

		GameRegistry.addRecipe(new ItemStack(Blocks.crafting_table), "**", "**", '*',
				new ItemStack(Blocks.planks, 1, 0));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchLadder, 3), "* *", "***", "* *", '*',
				new ItemStack(mod_IDT.BirchStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceLadder, 3), "* *", "***", "* *", '*',
				new ItemStack(mod_IDT.SpruceStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleLadder, 3), "* *", "***", "* *", '*',
				new ItemStack(mod_IDT.JungleStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowLadder, 3), "* *", "***", "* *", '*',
				new ItemStack(mod_IDT.WillowStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyLadder, 3), "* *", "***", "* *", '*',
				new ItemStack(mod_IDT.EbonyStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidLadder, 3), "* *", "***", "* *", '*',
				new ItemStack(mod_IDT.GelidStick));

		GameRegistry.addRecipe(new ItemStack(Blocks.trapped_chest, 1), "*-", '*', new ItemStack(Blocks.chest), '-',
				new ItemStack(Blocks.tripwire_hook));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchTrapChest, 1), "*", "-", '*',
				new ItemStack(mod_IDT.BirchChest), '-', new ItemStack(Blocks.tripwire_hook));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceTrapChest, 1), "*", "-", '*',
				new ItemStack(mod_IDT.SpruceChest), '-', new ItemStack(Blocks.tripwire_hook));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleTrapChest, 1), "*", "-", '*',
				new ItemStack(mod_IDT.JungleChest), '-', new ItemStack(Blocks.tripwire_hook));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowTrapChest, 1), "*", "-", '*',
				new ItemStack(mod_IDT.WillowChest), '-', new ItemStack(Blocks.tripwire_hook));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyTrapChest, 1), "*", "-", '*',
				new ItemStack(mod_IDT.EbonyChest), '-', new ItemStack(Blocks.tripwire_hook));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidTrapChest, 1), "*", "-", '*',
				new ItemStack(mod_IDT.GelidChest), '-', new ItemStack(Blocks.tripwire_hook));

		GameRegistry.addRecipe(new ItemStack(Blocks.chest, 1), "***", "* *", "***", '*',
				new ItemStack(Blocks.planks, 1, 0));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AmblygoniteBlock, 1), "***", "***", "***", '*',
				new ItemStack(mod_IDT.AmblygoniteGem));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.CementBricks, 4), "**", "**", '*', new ItemStack(mod_IDT.Cement));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchFenceGate), "s*s", "s*s", 's',
				new ItemStack(mod_IDT.BirchStick), '*', new ItemStack(Blocks.planks, 1, 2));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleFenceGate), "s*s", "s*s", 's',
				new ItemStack(mod_IDT.JungleStick), '*', new ItemStack(Blocks.planks, 1, 3));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceFenceGate), "s*s", "s*s", 's',
				new ItemStack(mod_IDT.SpruceStick), '*', new ItemStack(Blocks.planks, 1, 1));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowFenceGate), "s*s", "s*s", 's',
				new ItemStack(mod_IDT.WillowStick), '*', new ItemStack(mod_IDT.WillowPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyFenceGate), "s*s", "s*s", 's',
				new ItemStack(mod_IDT.EbonyStick), '*', new ItemStack(mod_IDT.EbonyPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidFenceGate), "s*s", "s*s", 's',
				new ItemStack(mod_IDT.GelidStick), '*', new ItemStack(mod_IDT.GelidPlanks));

		GameRegistry.addRecipe(new ItemStack(Blocks.nether_brick_fence), "***", "***", '*',
				new ItemStack(Items.netherbrick));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.fence_gate, 1),
				"s*s", "s*s", '*', "plankWood", 's', "stickWood"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyPlanks, 4), "*", '*', new ItemStack(mod_IDT.EbonyLog));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidPlanks, 4), "*", '*', new ItemStack(mod_IDT.GelidLog));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SmelterIdle, 1), "***", "*F*", "***", '*',
				new ItemStack(Items.iron_ingot), 'F', new ItemStack(Item.getItemFromBlock(Blocks.furnace)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.IndustrialCutter, 1), " * ", "srs", "sss", '*',
						new ItemStack(mod_IDT.DiamondSawBlade), 'r', new ItemStack(Items.redstone), 's', "ingotSteel"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.MetalFrame, 1),
				"t t", "   ", "t t", 't', "ingotTitanium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.MatterCondenser), "f*f", "tct", "fgf", 'f',
						new ItemStack(mod_IDT.MetalFrame), 'c', new ItemStack(mod_IDT.CompressorUnitGA), 't',
						"ingotTitanium", 'g', new ItemStack(mod_IDT.CutAmblygoniteGem), '*',
						new ItemStack(mod_IDT.T3CircuitBoard)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.ZNG, 1), "scs", "sas", "szs", 's', "ingotSteel", 'z',
						new ItemStack(mod_IDT.ZimphnodeBar), 'a', new ItemStack(mod_IDT.Alternator), 'c',
						new ItemStack(mod_IDT.T1CircuitBoard)));

		/*
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(mod_IDT.IDTCraftingTable, 1), new
		 * ItemStack(Blocks.crafting_table));
		 * 
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(mod_IDT.IDTCraftingTable, 1), new
		 * ItemStack(mod_IDT.BirchCraftingTable));
		 * 
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(mod_IDT.IDTCraftingTable, 1), new
		 * ItemStack(mod_IDT.SpruceCraftingTable));
		 * 
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(mod_IDT.IDTCraftingTable, 1), new
		 * ItemStack(mod_IDT.JungleCraftingTable));
		 * 
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(mod_IDT.IDTCraftingTable, 1), new
		 * ItemStack(mod_IDT.WillowCraftingTable));
		 * 
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(mod_IDT.IDTCraftingTable, 1), new
		 * ItemStack(mod_IDT.EbonyCraftingTable));
		 * 
		 * GameRegistry.addShapelessRecipe(new
		 * ItemStack(mod_IDT.IDTCraftingTable, 1), new
		 * ItemStack(mod_IDT.GelidCraftingTable));
		 */

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.SteelBlock, 1), "***", "***", "***", '*', "ingotSteel"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.TitaniumBlock, 1),
				"***", "***", "***", '*', "ingotTitanium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Items.comparator), " * ", "*q*", "sss", '*', "redstoneTorch",
						'q', new ItemStack(Items.quartz), 's', new ItemStack(Blocks.stone)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Items.repeater), "*r*",
				"sss", '*', "redstoneTorch", 's', new ItemStack(Blocks.stone), 'r', new ItemStack(Items.redstone)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.lit_pumpkin, 1), "p",
				"*", '*', "blockTorch", 'p', new ItemStack(Blocks.pumpkin)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Blocks.hopper, 1), "i i",
				"i*i", " i ", '*', "blockChest", 'i', new ItemStack(Items.iron_ingot)));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.OakWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.OakWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BirchWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.BirchWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SpruceWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.SpruceWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.JungleWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.JungleWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.WillowWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.WillowWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EbonyWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.EbonyWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GelidWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.GelidWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodPlanks, 4), "*", '*', new ItemStack(mod_IDT.SilkwoodLog));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodButton), "*", '*', new ItemStack(mod_IDT.SilkwoodPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodChest), "***", "* *", "***", '*',
				new ItemStack(mod_IDT.SilkwoodPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodCraftingTable), "**", "**", '*',
				new ItemStack(mod_IDT.SilkwoodPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodFence, 2), "***", "***", '*',
				new ItemStack(mod_IDT.SilkwoodStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodFenceGate), "*^*", "*^*", '*',
				new ItemStack(mod_IDT.SilkwoodStick), '^', new ItemStack(mod_IDT.SilkwoodPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodLadder, 3), "* *", "***", "* *", '*',
				new ItemStack(mod_IDT.SilkwoodStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodLever), "*", "c", '*',
				new ItemStack(mod_IDT.SilkwoodStick), 'c', new ItemStack(Item.getItemFromBlock(Blocks.cobblestone)));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodPressurePlate), "**", '*',
				new ItemStack(mod_IDT.SilkwoodPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodRedTorchOn), "r", "*", 'r', new ItemStack(Items.redstone),
				'*', new ItemStack(mod_IDT.SilkwoodStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodSlab, 6), "***", '*',
				new ItemStack(mod_IDT.SilkwoodPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_IDT.SilkwoodPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodTorch, 4), "c", "*", 'c', new ItemStack(Items.coal), '*',
				new ItemStack(mod_IDT.SilkwoodStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodTorch, 4), "c", "*", 'c', new ItemStack(Items.coal, 1, 1),
				'*', new ItemStack(mod_IDT.SilkwoodStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodTrapChest), "*", "-", '*',
				new ItemStack(mod_IDT.SilkwoodChest), '-', new ItemStack(Item.getItemFromBlock(Blocks.tripwire_hook)));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodTrapdoor, 2), "***", "***", '*',
				new ItemStack(mod_IDT.SilkwoodPlanks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SilkwoodWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.SilkwoodWallPart));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(mod_IDT.DidymiumGlass),
				"ingotPraseodymium", "ingotNeodymium", new ItemStack(Item.getItemFromBlock(Blocks.glass))));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.AcaciaButton), new ItemStack(Blocks.planks, 1, 4));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaChest), "***", "* *", "***", '*',
				new ItemStack(Blocks.planks, 1, 4));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaCraftingTable), "**", "**", '*',
				new ItemStack(Blocks.planks, 1, 4));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaDoorItem), "**", "**", "**", '*',
				new ItemStack(Blocks.planks, 1, 4));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaFence, 2), "***", "***", '*',
				new ItemStack(mod_IDT.AcaciaStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaFenceGate), "s*s", "s*s", 's',
				new ItemStack(mod_IDT.AcaciaStick), '*', new ItemStack(Blocks.planks, 1, 4));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaLadder, 3), "* *", "***", "* *", '*',
				new ItemStack(mod_IDT.AcaciaStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaLever), "*", "c", '*', new ItemStack(mod_IDT.AcaciaStick),
				'c', new ItemStack(Blocks.cobblestone));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaPressurePlate, 2), "**", '*',
				new ItemStack(Blocks.planks, 1, 4));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaRedTorchOn), "r", "*", 'r', new ItemStack(Items.redstone),
				'*', new ItemStack(mod_IDT.AcaciaStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaStick, 4), "*", "*", '*',
				new ItemStack(Blocks.planks, 1, 4));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaTorch, 4), "c", "*", 'c', new ItemStack(Items.coal), '*',
				new ItemStack(mod_IDT.AcaciaStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaTorch, 4), "c", "*", 'c', new ItemStack(Items.coal, 1, 1),
				'*', new ItemStack(mod_IDT.AcaciaStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaTrapChest), "-", "*", '-',
				new ItemStack(Blocks.tripwire_hook), '*', new ItemStack(mod_IDT.AcaciaChest));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaTrapdoor, 2), "***", "***", '*',
				new ItemStack(Blocks.planks, 1, 4));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.AcaciaWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.AcaciaWallPart, 2), "s*", "s*", 's',
				new ItemStack(mod_IDT.AcaciaStick), '*', new ItemStack(Blocks.planks, 1, 4));

		GameRegistry.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 4), "***", '*', new ItemStack(Blocks.planks, 1, 4));

		GameRegistry.addRecipe(new ItemStack(Blocks.acacia_stairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.planks, 1, 4));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.DarkOakButton), new ItemStack(Blocks.planks, 1, 5));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakChest), "***", "* *", "***", '*',
				new ItemStack(Blocks.planks, 1, 5));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakCraftingTable), "**", "**", '*',
				new ItemStack(Blocks.planks, 1, 5));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakDoorItem), "**", "**", "**", '*',
				new ItemStack(Blocks.planks, 1, 5));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakFence, 2), "***", "***", '*',
				new ItemStack(mod_IDT.DarkOakStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakFenceGate), "s*s", "s*s", 's',
				new ItemStack(mod_IDT.DarkOakStick), '*', new ItemStack(Blocks.planks, 1, 5));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakLadder, 3), "* *", "***", "* *", '*',
				new ItemStack(mod_IDT.DarkOakStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakLever), "*", "c", '*', new ItemStack(mod_IDT.DarkOakStick),
				'c', new ItemStack(Blocks.cobblestone));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakPressurePlate, 2), "**", '*',
				new ItemStack(Blocks.planks, 1, 5));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakRedTorchOn), "r", "*", 'r', new ItemStack(Items.redstone),
				'*', new ItemStack(mod_IDT.DarkOakStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakStick, 4), "*", "*", '*',
				new ItemStack(Blocks.planks, 1, 5));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakTorch, 4), "c", "*", 'c', new ItemStack(Items.coal), '*',
				new ItemStack(mod_IDT.DarkOakStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakTorch, 4), "c", "*", 'c', new ItemStack(Items.coal, 1, 1),
				'*', new ItemStack(mod_IDT.DarkOakStick));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakTrapChest), "-", "*", '-',
				new ItemStack(Blocks.tripwire_hook), '*', new ItemStack(mod_IDT.DarkOakChest));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakTrapdoor, 2), "***", "***", '*',
				new ItemStack(Blocks.planks, 1, 5));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.DarkOakWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkOakWallPart, 2), "s*", "s*", 's',
				new ItemStack(mod_IDT.DarkOakStick), '*', new ItemStack(Blocks.planks, 1, 5));

		GameRegistry.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 5), "***", '*', new ItemStack(Blocks.planks, 1, 5));

		GameRegistry.addRecipe(new ItemStack(Blocks.dark_oak_stairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.planks, 1, 5));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.EinsteiniumCoreReactor), "ppp", "sis", "ppp", 'p',
						"plateTitanium", 's', new ItemStack(mod_IDT.SteelRod), 'i', "ingotEinsteinium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.NeptuniumCoreReactor), "ppp", "sis", "ppp", 'p',
						"plateTitanium", 's', new ItemStack(mod_IDT.SteelRod), 'i', "ingotNeptunium"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.UraniumCoreReactor),
				"ppp", "sis", "ppp", 'p', "plateTitanium", 's', new ItemStack(mod_IDT.SteelRod), 'i', "ingotUranium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.SuperReactor), " u ", "nxe", "ppp", 'u',
						new ItemStack(mod_IDT.UraniumCoreReactor), 'n', new ItemStack(mod_IDT.NeptuniumCoreReactor),
						'e', new ItemStack(mod_IDT.EinsteiniumCoreReactor), 'x', new ItemStack(mod_IDT.ExplosiveCharge),
						'p', "plateTitanium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.SuperReactor), " u ", "exn", "ppp", 'u',
						new ItemStack(mod_IDT.UraniumCoreReactor), 'n', new ItemStack(mod_IDT.NeptuniumCoreReactor),
						'e', new ItemStack(mod_IDT.EinsteiniumCoreReactor), 'x', new ItemStack(mod_IDT.ExplosiveCharge),
						'p', "plateTitanium"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DidymiumGlassPane, 6), "***", "***", '*',
				new ItemStack(mod_IDT.DidymiumGlass));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Blocks.stone_slab, 6, 1), "***", '*', "sandstone"));

		GameRegistry.addRecipe(new ItemStack(Blocks.stone_slab, 6, 3), "***", '*', new ItemStack(Blocks.cobblestone));

		GameRegistry.addRecipe(new ItemStack(Blocks.stone_slab, 6, 4), "***", '*', new ItemStack(Blocks.brick_block));

		/*
		 * GameRegistry.addRecipe(new ItemStack(Blocks.stone_slab, 6, 5), "***",
		 * '*', new ItemStack(Blocks.stonebrick, 1, 0));
		 * 
		 * GameRegistry.addRecipe(new ItemStack(Blocks.stone_slab, 6, 5), "***",
		 * '*', new ItemStack(Blocks.stonebrick, 1, 1));
		 * 
		 * GameRegistry.addRecipe(new ItemStack(Blocks.stone_slab, 6, 5), "***",
		 * '*', new ItemStack(Blocks.stonebrick, 1, 2));
		 * 
		 * GameRegistry.addRecipe(new ItemStack(Blocks.stone_slab, 6, 5), "***",
		 * '*', new ItemStack(Blocks.stonebrick, 1, 3));
		 */

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Blocks.stone_slab, 6, 5), "***", '*', "stonebrick"));

		GameRegistry.addRecipe(new ItemStack(Blocks.stone_slab, 6, 6), "***", '*', new ItemStack(Blocks.nether_brick));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(Blocks.stone_slab, 6, 7), "***", '*', "quartzBlocks"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsWhite, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 15));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsOrange, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 14));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsMagenta, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 13));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsLightBlue, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 12));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsYellow, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 11));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsLime, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 10));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsPink, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 9));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsGray, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 8));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsLightGray, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 7));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsCyan, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 6));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsPurple, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 5));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsBlue, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 4));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsBrown, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 3));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsGreen, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 2));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsRed, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 1));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsBlack, 8), "ggg", "gdg", "ggg", 'g',
				new ItemStack(mod_IDT.GlassStairs), 'd', new ItemStack(Items.dye, 1, 0));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsWhite, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 0));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsOrange, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 1));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsMagenta, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 2));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsLightBlue, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 3));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsYellow, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 4));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsLime, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 5));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsPink, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 6));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsGray, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 7));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsLightGray, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 8));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsCyan, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 9));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsPurple, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 10));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsBlue, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 11));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsBrown, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 12));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsGreen, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 13));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsRed, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 14));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassStairsBlack, 4), "*  ", "** ", "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 15));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabWhite, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 0));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabOrange, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 1));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabMagenta, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 2));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabLightBlue, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 3));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabYellow, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 4));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabLime, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 5));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabPink, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 6));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabGray, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 7));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabLightGray, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 8));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabCyan, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 9));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabPurple, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 10));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabBlue, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 11));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabBrown, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 12));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabGreen, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 13));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabRed, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 14));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.GlassSlabBlack, 6), "***", '*',
				new ItemStack(Blocks.stained_glass, 1, 15));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.CementBrickStairs, 4), "*  ", "** ", "***", '*',
				new ItemStack(mod_IDT.CementBricks));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(
				new ItemStack(mod_IDT.EinsteiniumGlass), new ItemStack(Blocks.glass), "ingotEinsteinium"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.EinsteiniumGlassPane, 6), "***", "***", '*',
				new ItemStack(mod_IDT.EinsteiniumGlass));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(mod_IDT.NeptuniumGlass),
				new ItemStack(Blocks.glass), "ingotNeptunium"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.NeptuniumGlassPane, 6), "***", "***", '*',
				new ItemStack(mod_IDT.NeptuniumGlass));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(mod_IDT.UraniumGlass),
				new ItemStack(Blocks.glass), "ingotUranium"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.UraniumGlassPane, 6), "***", "***", '*',
				new ItemStack(mod_IDT.UraniumGlass));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.TankCompressor), "ttt", "xcx", "ttt", 'x',
						new ItemStack(mod_IDT.EmptyTank), 'c', new ItemStack(mod_IDT.CompressorUnit), 't',
						"ingotTitanium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.BioFuelExtractor), "sfs", "sas", "scs", 'f',
						new ItemStack(mod_IDT.Flask), 'a', new ItemStack(mod_IDT.MetalFrame), 'c',
						new ItemStack(mod_IDT.CompressorUnit), 's', "ingotSteel"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.CementBrickSlab, 6), "***", '*',
				new ItemStack(mod_IDT.CementBricks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.CementTrapdoor, 2), "***", "***", '*',
				new ItemStack(mod_IDT.Cement));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.CementBrickTrapdoor, 2), "***", "***", '*',
				new ItemStack(mod_IDT.CementBricks));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.StoneTrapdoor, 2), "***", "***", '*', new ItemStack(Blocks.stone));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.CobblestoneTrapdoor, 2), "***", "***", '*',
				new ItemStack(Blocks.cobblestone));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.MossyCobblestoneTrapdoor, 2), "***", "***", '*',
				new ItemStack(Blocks.mossy_cobblestone));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.StonebrickTrapdoor, 2), "***", "***", '*',
				new ItemStack(Blocks.stonebrick, 1, 0));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.MossyStonebrickTrapdoor, 2), "***", "***", '*',
				new ItemStack(Blocks.stonebrick, 1, 1));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.CrackedStonebrickTrapdoor, 2), "***", "***", '*',
				new ItemStack(Blocks.stonebrick, 1, 2));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.ChiseledStonebrickTrapdoor, 2), "***", "***", '*',
				new ItemStack(Blocks.stonebrick, 1, 3));

		CraftingManager.getInstance().getRecipeList().add(
				new ShapedOreRecipe(new ItemStack(mod_IDT.StonebrickTrapdoor, 2), "***", "***", '*', "stonebrick"));

		CraftingManager.getInstance().getRecipeList().add(
				new ShapedOreRecipe(new ItemStack(mod_IDT.CobblestoneTrapdoor, 2), "***", "***", '*', "cobblestone"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapelessOreRecipe(new ItemStack(mod_IDT.DidymiumGlassPane), new ItemStack(Blocks.glass_pane),
						"ingotNeodymium", "ingotPraseodymium"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(
				new ItemStack(mod_IDT.EinsteiniumGlassPane), new ItemStack(Blocks.glass_pane), "ingotEinsteinium"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(
				new ItemStack(mod_IDT.NeptuniumGlassPane), new ItemStack(Blocks.glass_pane), "ingotNeptunium"));

		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(
				new ItemStack(mod_IDT.UraniumGlassPane), new ItemStack(Blocks.glass_pane), "ingotUranium"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.CementWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.CementWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.CementBrickWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.CementBrickWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.StoneWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.StoneWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SandStoneWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.SandstoneWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.ObsidianWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.ObsidianWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.StoneBrickWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.StonebrickWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.BrickWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.BrickWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.CoalWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.CoalWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.SnowWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.SnowWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.NetherBrickWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.NetherBrickWallPart));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.QuartzWall, 6), "***", "***", '*',
				new ItemStack(mod_IDT.QuartzWallPart));

		GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone_wall, 6, 0), "***", "***", '*',
				new ItemStack(mod_IDT.CobblestoneWallPart));

		GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone_wall, 6, 1), "***", "***", '*',
				new ItemStack(mod_IDT.MossyCobblestoneWallPart));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.BlackHoleGenerator), "*g*", "vnv", "tct", 'v',
						"plateVanadium", 'n', new ItemStack(mod_IDT.NdMagnet, 1, 1), 't', "blockTitanium", 'c',
						new ItemStack(mod_IDT.CompressorUnitGA), 'g', new ItemStack(mod_IDT.CutAmblygoniteGem), '*',
						new ItemStack(mod_IDT.QMan)));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.Welder), "s s",
				"tet", "ttt", 's', "ingotSteel", 't', "ingotTitanium", 'e', new ItemStack(mod_IDT.EmptyTank)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.Magnetizer), "ttt", "m m", "tct", 't', "ingotTitanium",
						'm', new ItemStack(mod_IDT.NdMagnet, 1, 0), 'c', new ItemStack(mod_IDT.T2CircuitBoard)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.Enricher), "ttt", "eun", "tct", 't', "ingotTitanium",
						'e', "ingotEinsteinium", 'u', "ingotUranium", 'n', "ingotNeptunium", 'c',
						new ItemStack(mod_IDT.T3CircuitBoard)));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.Enricher), "ttt", "nue", "tct", 't', "ingotTitanium",
						'e', "ingotEinsteinium", 'u', "ingotUranium", 'n', "ingotNeptunium", 'c',
						new ItemStack(mod_IDT.T3CircuitBoard)));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.ZimphnodeWire, 3), "***", '*',
				new ItemStack(mod_IDT.ZimphnodeBar));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.DarkMatter), "**", "**", '*',
				new ItemStack(mod_IDT.DarkMatterPiece));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.DarkMatterChest), new ItemStack(mod_IDT.DarkMatter),
				new ItemStack(Blocks.chest));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.CopperBlock), "***", "***", "***", '*', "ingotCopper"));

		CraftingManager.getInstance().getRecipeList().add(
				new ShapedOreRecipe(new ItemStack(mod_IDT.SiliconBlock), "***", "***", "***", '*', "ingotSilicon"));

		GameRegistry.addRecipe(new ItemStack(mod_IDT.ReinforcedGlassPane, 6), "***", "***", '*',
				new ItemStack(mod_IDT.ReinforcedGlass));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.VanadiumBlock, 1),
				"***", "***", "***", '*', "ingotVanadium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.VanadiumCarbideBlock, 1), "***", "***", "***", '*', "ingotVanadiumCarbide"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.TantalumBlock, 1),
				"***", "***", "***", '*', "ingotTantalum"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(
				new ItemStack(mod_IDT.EinsteiniumBlock, 1), "***", "***", "***", '*', "ingotEinsteinium"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.NeptuniumBlock, 1),
				"***", "***", "***", '*', "ingotNeptunium"));

		CraftingManager.getInstance().getRecipeList().add(
				new ShapedOreRecipe(new ItemStack(mod_IDT.UraniumBlock, 1), "***", "***", "***", '*', "ingotUranium"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(
				new ItemStack(mod_IDT.PraseodymiumBlock, 1), "***", "***", "***", '*', "ingotPraseodymium"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.NeodymiumBlock, 1),
				"***", "***", "***", '*', "ingotNeodymium"));

		CraftingManager.getInstance().getRecipeList()
				.add(new ShapedOreRecipe(new ItemStack(mod_IDT.BoronBlock, 1), "***", "***", "***", '*', "ingotBoron"));

		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mod_IDT.ZimphnodeBlock, 1),
				"***", "***", "***", '*', "ingotZimphnode"));

		CraftingManager.getInstance().getRecipeList().add(
				new ShapedOreRecipe(new ItemStack(mod_IDT.SulfurBlock, 1), "***", "***", "***", '*', "lumpSulfur"));

		CraftingManager.getInstance().getRecipeList().add(
				new ShapedOreRecipe(new ItemStack(mod_IDT.NeoronBlock, 1), "***", "***", "***", '*', "ingotNeoron"));

		GameRegistry.addShapelessRecipe(new ItemStack(mod_IDT.LavaStone), new ItemStack(Items.lava_bucket),
				new ItemStack(Blocks.stone));
	}

	public static void registerSmelting() {
		GameRegistry.addSmelting(Blocks.gravel, new ItemStack(mod_IDT.Cement), 1f);
		GameRegistry.addSmelting(Blocks.stone_stairs, new ItemStack(mod_IDT.StoneStairs), 1f);
		GameRegistry.addSmelting(Blocks.cobblestone_wall, new ItemStack(mod_IDT.StoneWall), 1f);
		GameRegistry.addSmelting(new ItemStack(Blocks.stone_slab, 1, 3), new ItemStack(mod_IDT.StoneSlab), 1f);
		GameRegistry.addSmelting(new ItemStack(Blocks.stone_slab, 1, 11), new ItemStack(mod_IDT.StoneSlab), 1f);
		GameRegistry.addSmelting(new ItemStack(Blocks.double_stone_slab, 1, 3), new ItemStack(mod_IDT.StoneDoubleSlab),
				1f);
		GameRegistry.addSmelting(mod_IDT.CobblestoneTrapdoor, new ItemStack(mod_IDT.StoneTrapdoor), 1f);
		GameRegistry.addSmelting(mod_IDT.SecretCobblestoneTrapdoor, new ItemStack(mod_IDT.SecretStoneTrapdoor), 1f);
		GameRegistry.addSmelting(Blocks.stone, new ItemStack(mod_IDT.LavaStone), 1f);
	}
}
