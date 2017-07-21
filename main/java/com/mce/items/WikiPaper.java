package com.mce.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WikiPaper extends Item {
	public WikiPaper() {
		super();
		this.setMaxStackSize(1);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
		list.add("Right click to get");
		list.add("the link to the wiki.");
	}

	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
