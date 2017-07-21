package com.mce.handlers;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FuelHandler implements IFuelHandler {
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == mod_IDT.BirchStick) {
			return 100;
		}

		if (fuel.getItem() == mod_IDT.SpruceStick) {
			return 100;
		}

		if (fuel.getItem() == mod_IDT.JungleStick) {
			return 100;
		}

		if (fuel.getItem() == mod_IDT.WillowStick) {
			return 100;
		}

		if (fuel.getItem() == mod_IDT.EbonyStick) {
			return 100;
		}

		if (fuel.getItem() == mod_IDT.SilkwoodStick) {
			return 100;
		}

		if (fuel.getItem() == mod_IDT.GelidStick) {
			return 100;
		}

		if (fuel.getItem() == Item.getItemFromBlock(mod_IDT.WillowSlab)) {
			return 150;
		}

		if (fuel.getItem() == Item.getItemFromBlock(mod_IDT.EbonySlab)) {
			return 150;
		}

		if (fuel.getItem() == Item.getItemFromBlock(mod_IDT.SilkwoodSlab)) {
			return 150;
		}

		if (fuel.getItem() == Item.getItemFromBlock(mod_IDT.GelidSlab)) {
			return 150;
		}
		return 0;
	}
}
