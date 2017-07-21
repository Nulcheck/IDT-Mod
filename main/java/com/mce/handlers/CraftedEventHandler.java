package com.mce.handlers;

import com.mce.common.mod_IDT;
import com.mce.items.ModItems.DiamondSawBlade;
import com.mce.items.ModItems.IronSawBlade;
import com.mce.items.ModItems.PropaneTank;
import com.mce.items.ModItems.SteelSawBlade;
import com.mce.items.ModItems.TitaniumSawBlade;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.Item;

public class CraftedEventHandler {
	@SubscribeEvent
	public void crafting(PlayerEvent.ItemCraftedEvent e) {
		if (e.crafting.getItem().equals(mod_IDT.SteelSawBlade)) {
			IronSawBlade.containerItem = false;
		}

		else if (e.crafting.getItem().equals(mod_IDT.TitaniumSawBlade)) {
			SteelSawBlade.containerItem = false;
		}

		else if (e.crafting.getItem().equals(mod_IDT.DiamondSawBlade)) {
			TitaniumSawBlade.containerItem = false;
		}

		else if (e.crafting.getItem().equals(Item.getItemFromBlock(mod_IDT.IndustrialCutter))) {
			DiamondSawBlade.containerItem = false;
		}

		else if (e.crafting.getItem().equals(mod_IDT.BlowTorch)) {
			PropaneTank.containerItem = false;
		}

		else {
			IronSawBlade.containerItem = true;
			SteelSawBlade.containerItem = true;
			TitaniumSawBlade.containerItem = true;
			DiamondSawBlade.containerItem = true;
		}
	}
}
