package com.mce.util;

import com.mce.common.mod_IDT;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ModCreativeTabs extends CreativeTabs {
	public final String gui_idt = "idt.png";
	public final String tabName;

	public ModCreativeTabs(String name) {
		super(name);
		tabName = name;
		setBackgroundImageName(gui_idt);
	}

	public Item getTabIconItem() {
		if (tabName == "IDTItems") {
			return mod_IDT.BlowTorch;
		} else if (tabName == "IDTTech") {
			return Item.getItemFromBlock(mod_IDT.UraniumCoreReactor);
		} else {
			return Item.getItemFromBlock(mod_IDT.Cement);
		}
	}
}
