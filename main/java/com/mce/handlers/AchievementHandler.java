package com.mce.handlers;

import com.mce.common.mod_IDT;
import com.mce.handlers.registers.AchRegistry;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;

public class AchievementHandler {
	// Pick up
	@SubscribeEvent
	public void notifyPickup(PlayerEvent.ItemPickupEvent e) {
		if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(Item.getItemFromBlock(mod_IDT.WillowLog)))) {
			e.player.addStat(AchRegistry.mineModWood, 1);
			e.player.addStat(AchievementList.mineWood, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(Item.getItemFromBlock(mod_IDT.EbonyLog)))) {
			e.player.addStat(AchRegistry.mineModWood, 1);
			e.player.addStat(AchievementList.mineWood, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(Item.getItemFromBlock(mod_IDT.SilkwoodLog)))) {
			e.player.addStat(AchRegistry.mineModWood, 1);
			e.player.addStat(AchievementList.mineWood, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(Item.getItemFromBlock(mod_IDT.CrystalOre)))) {
			e.player.addStat(AchRegistry.crystal, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(mod_IDT.CrystalGem))) {
			e.player.addStat(AchRegistry.crystal, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(mod_IDT.CrystalNugget))) {
			e.player.addStat(AchRegistry.crystal, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(mod_IDT.CrystalPiece))) {
			e.player.addStat(AchRegistry.crystal, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(mod_IDT.CrystalDust))) {
			e.player.addStat(AchRegistry.crystal, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(Item.getItemFromBlock(mod_IDT.ZimphnodeOre)))) {
			e.player.addStat(AchRegistry.zimphnode, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(mod_IDT.ZimphnodeBar))) {
			e.player.addStat(AchRegistry.zimphnodeBar, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(mod_IDT.EssenceOfAir))) {
			e.player.addStat(AchRegistry.essence, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(mod_IDT.EssenceOfFire))) {
			e.player.addStat(AchRegistry.essence, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(mod_IDT.EssenceOfEarth))) {
			e.player.addStat(AchRegistry.essence, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(mod_IDT.EssenceOfWater))) {
			e.player.addStat(AchRegistry.essence, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(mod_IDT.EssenceOfLife))) {
			e.player.addStat(AchRegistry.essence, 1);
		}

		else if (e.pickedUp.getEntityItem().isItemEqual(new ItemStack(mod_IDT.PraseodymiumOre))) {
			e.player.addStat(AchRegistry.praOre, 1);
		}
	}

	@SubscribeEvent
	public void onDimension(PlayerEvent.PlayerChangedDimensionEvent e) {
		if (e.toDim == mod_IDT.frostDimId) {
			e.player.addStat(AchRegistry.dimFrost, 1);
		}

		else if (e.toDim == mod_IDT.crystalDimId) {
			e.player.addStat(AchRegistry.dimCrystal, 1);
		}
	}

	// Craft
	@SubscribeEvent
	public void onCrafting(PlayerEvent.ItemCraftedEvent e) {
		if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.CryingObsidian))) {
			e.player.addStat(AchRegistry.sadObsidian, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.CementBricks))) {
			e.player.addStat(AchRegistry.cementBricks, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.EssenceOfLife)) {
			e.player.addStat(AchRegistry.essence, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.EssenceOfFire)) {
			e.player.addStat(AchRegistry.essence, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.EssenceOfEarth)) {
			e.player.addStat(AchRegistry.essence, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.EssenceOfAir)) {
			e.player.addStat(AchRegistry.essence, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.EssenceOfWater)) {
			e.player.addStat(AchRegistry.essence, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.HealerBlock))) {
			e.player.addStat(AchRegistry.healer, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.ZNG))) {
			e.player.addStat(AchRegistry.zng, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.WillowPlanks))) {
			e.player.addStat(AchRegistry.modPlanks, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.EbonyPlanks))) {
			e.player.addStat(AchRegistry.modPlanks, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.SilkwoodPlanks))) {
			e.player.addStat(AchRegistry.modPlanks, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.BirchCraftingTable))) {
			e.player.addStat(AchievementList.buildWorkBench, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.SpruceCraftingTable))) {
			e.player.addStat(AchievementList.buildWorkBench, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.JungleCraftingTable))) {
			e.player.addStat(AchievementList.buildWorkBench, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.WillowCraftingTable))) {
			e.player.addStat(AchievementList.buildWorkBench, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.EbonyCraftingTable))) {
			e.player.addStat(AchievementList.buildWorkBench, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.SilkwoodCraftingTable))) {
			e.player.addStat(AchievementList.buildWorkBench, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.AcaciaCraftingTable))) {
			e.player.addStat(AchievementList.buildWorkBench, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.DarkOakCraftingTable))) {
			e.player.addStat(AchievementList.buildWorkBench, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.VanadiumPick)) {
			e.player.addStat(AchRegistry.vanPick, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.TantalumHelmet)) {
			e.player.addStat(AchRegistry.tantArmor, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.TantalumChestplate)) {
			e.player.addStat(AchRegistry.tantArmor, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.TantalumLeggings)) {
			e.player.addStat(AchRegistry.tantArmor, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.TantalumBoots)) {
			e.player.addStat(AchRegistry.tantArmor, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.DidymiumGlass))) {
			e.player.addStat(AchRegistry.didGlass, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.SuperReactor))) {
			e.player.addStat(AchRegistry.superReactor, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.UltimateNuker))) {
			e.player.addStat(AchRegistry.ultimNuke, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.MatterCondenser))) {
			e.player.addStat(AchRegistry.matterCon, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.CrystalBlock))) {
			e.player.addStat(AchRegistry.crystalBlock, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.DiamondSawBlade)) {
			e.player.addStat(AchRegistry.dts, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.IndustrialCutter))) {
			e.player.addStat(AchRegistry.cutter, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.CutCrystalGem)) {
			e.player.addStat(AchRegistry.soPretty, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.BioFuelExtractor))) {
			e.player.addStat(AchRegistry.greenChem, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.TankCompressor))) {
			e.player.addStat(AchRegistry.kompressor, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.Nitroglycerin)) {
			e.player.addStat(AchRegistry.warfareChem, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.UraniumGlass))) {
			e.player.addStat(AchRegistry.uranGlass, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.SmelterIdle))) {
			e.player.addStat(AchRegistry.smeltering, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.Transistor)) {
			e.player.addStat(AchRegistry.trans, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.Microchip)) {
			e.player.addStat(AchRegistry.mic, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.T1CircuitBoard)) {
			e.player.addStat(AchRegistry.t1Cir, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.T2CircuitBoard)) {
			e.player.addStat(AchRegistry.t2Cir, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.T3CircuitBoard)) {
			e.player.addStat(AchRegistry.t3Cir, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.QMan)) {
			e.player.addStat(AchRegistry.qMan, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.CompressorUnitGA)) {
			e.player.addStat(AchRegistry.gaComp, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.CrystalGem)) {
			e.player.addStat(AchRegistry.craftGem, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.BlackHoleGenerator))) {
			e.player.addStat(AchRegistry.bhg, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.DarkMatter))) {
			e.player.addStat(AchRegistry.darkMatter, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.CompressorUnit)) {
			e.player.addStat(AchRegistry.comp, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.VanadiumCarbideIngot)) {
			e.player.addStat(AchRegistry.vcIngot, 1);
		}

		else if (e.crafting.getItem().equals(mod_IDT.VCPick)) {
			e.player.addStat(AchRegistry.vcPick, 1);
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.Magnetizer))) {
			e.player.addStat(AchRegistry.mag, 1);
		}
	}

	// Smelt
	@SubscribeEvent
	public void onSmelting(PlayerEvent.ItemSmeltedEvent e) {
		if (e.smelting.getItem().equals(Item.getItemFromBlock(mod_IDT.Cement))) {
			e.player.addStat(AchRegistry.cement, 1);
		}

		else if (e.smelting.getItem().equals(mod_IDT.ZimphnodeBar)) {
			e.player.addStat(AchRegistry.zimphnodeBar, 1);
		}

		else if (e.smelting.getItem().equals(mod_IDT.VanadiumIngot)) {
			e.player.addStat(AchRegistry.vanadiumIngot, 1);
		}

		else if (e.smelting.getItem().equals(mod_IDT.TantalumIngot)) {
			e.player.addStat(AchRegistry.tantalumIngot, 1);
		}

		else if (e.smelting.getItem().equals(mod_IDT.CopperIngot)) {
			e.player.addStat(AchRegistry.copperIngot, 1);
		}
		
		else if(e.smelting.getItem().equals(mod_IDT.TitaniumIngot)){
			e.player.addStat(AchRegistry.titaniumIngot, 1);
		}
	}
}
