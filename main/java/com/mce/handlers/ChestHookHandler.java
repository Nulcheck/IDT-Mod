package com.mce.handlers;

import com.mce.common.mod_IDT;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class ChestHookHandler {
	public static void addHooks() {
		// Par1 is min, par2 is max, par3 is weight. Golden apple is rarity 1,
		// 100 is rarity of iron ingots.

		// Mineshafts
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.EinsteiniumIngot), 1, 5, 25));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.NeptuniumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.CrystalDust), 2, 5, 5));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.VanadiumIngot), 1, 2, 1));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.CrystalNugget), 1, 3, 5));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.NeptuniumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SoyBeans), 5, 10, 35));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.Corn), 3, 5, 35));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TantalumIngot), 2, 4, 18));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.VanadiumHelmet), 1, 1, 1));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TantalumBoots), 1, 1, 2));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelChestplate), 1, 1, 5));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TitaniumHelmet), 1, 1, 3));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelIngot), 2, 4, 60));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.NeodymiumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.PraseodymiumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TitaniumIngot), 3, 5, 35));

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.Chisel), 1, 2, 5));

		// Stronghold
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.EinsteiniumIngot), 1, 5, 25));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.NeptuniumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.CrystalDust), 2, 5, 5));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.VanadiumIngot), 1, 2, 1));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.CrystalNugget), 1, 3, 5));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.NeptuniumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SoyBeans), 5, 10, 35));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.Corn), 3, 5, 35));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TantalumIngot), 2, 4, 18));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.VanadiumHelmet), 1, 1, 1));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TantalumBoots), 1, 1, 2));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelChestplate), 1, 1, 5));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TitaniumHelmet), 1, 1, 3));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelIngot), 2, 4, 60));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TitaniumIngot), 3, 5, 35));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.NeodymiumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.PraseodymiumIngot), 1, 3, 15));

		// Pyramids
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.CrystalDust), 2, 5, 5));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.VanadiumIngot), 1, 2, 1));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.CrystalNugget), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.NeodymiumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.PraseodymiumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TantalumIngot), 2, 4, 18));

		// Jungle
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.CrystalDust), 2, 5, 50));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.VanadiumIngot), 1, 2, 1));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.CrystalNugget), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.NeodymiumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.PraseodymiumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TantalumIngot), 2, 4, 18));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.cd_icy), 1, 1, 2));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.cd_23), 1, 1, 2));

		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.cd_r51), 1, 1, 1));

		// Dungeon
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.cd_icy), 1, 1, 2));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.cd_23), 1, 1, 2));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.cd_r51), 1, 1, 1));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.EinsteiniumIngot), 1, 5, 25));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.NeptuniumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.CrystalDust), 2, 5, 5));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.VanadiumIngot), 1, 2, 1));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.CrystalNugget), 1, 3, 5));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.NeptuniumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SoyBeans), 5, 10, 35));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.Corn), 3, 5, 35));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TantalumIngot), 2, 4, 18));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.VanadiumHelmet), 1, 1, 1));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TantalumBoots), 1, 1, 2));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelChestplate), 1, 1, 5));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TitaniumHelmet), 1, 1, 3));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelIngot), 2, 4, 60));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.NeodymiumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.PraseodymiumIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TitaniumIngot), 3, 5, 35));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.Chisel), 1, 2, 5));

		// Village
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TantalumIngot), 2, 4, 18));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.VanadiumIngot), 1, 2, 1));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.CrystalNugget), 1, 3, 5));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.VanadiumPick), 1, 1, 1));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.VanadiumHelmet), 1, 1, 1));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.NeoronPick), 1, 1, 3));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TantalumBoots), 1, 1, 3));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelChestplate), 1, 1, 15));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TitaniumHelmet), 1, 1, 15));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TitaniumAxe), 1, 1, 15));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelPick), 1, 1, 15));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelHoe), 1, 1, 15));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TitaniumShovel), 1, 1, 15));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelRod), 1, 5, 20));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TitaniumPlate), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.CopperPlate), 1, 5, 17));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.CopperDust), 2, 8, 25));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.CopperWire), 2, 5, 15));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.Plank), 2, 10, 30));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.IronSawBlade), 1, 2, 15));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.TitaniumSawBlade), 1, 2, 15));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.DiamondSawBlade), 1, 1, 1));

		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.Chisel), 1, 2, 5));

		// Bonus Chest
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.Chisel), 1, 1, 15));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.Plank), 2, 10, 30));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelPick), 1, 1, 15));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelAxe), 1, 2, 15));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelIngot), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelHelmet), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelChestplate), 1, 3, 15));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.StoneBrick), 1, 5, 30));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.Corn), 1, 10, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SoyBeans), 1, 10, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.Popcorn), 1, 10, 30));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.ExplosiveCharge), 1, 2, 15));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.BirchStick), 1, 10, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SpruceStick), 1, 10, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.JungleStick), 1, 10, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.AcaciaStick), 1, 10, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.DarkOakStick), 1, 10, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.WillowStick), 1, 10, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.EbonyStick), 1, 10, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SilkwoodStick), 1, 10, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.IronSawBlade), 1, 2, 15));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SteelSawBlade), 1, 2, 15));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.BirchTorch), 1, 15, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SpruceTorch), 1, 15, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.JungleTorch), 1, 15, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.AcaciaTorch), 1, 15, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.DarkOakTorch), 1, 15, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.WillowTorch), 1, 15, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.EbonyTorch), 1, 15, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SilkwoodTorch), 1, 15, 50));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.WillowSapling), 1, 3, 20));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.EbonySapling), 1, 3, 20));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(mod_IDT.SilkwoodSapling), 1, 3, 20));
	}
}
