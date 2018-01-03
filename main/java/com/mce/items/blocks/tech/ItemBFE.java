package com.mce.items.blocks.tech;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBFE extends ItemBlockWithMetadata {
	String name = "";

	public ItemBFE(Block block) {
		super(block, block);
		this.setUnlocalizedName(getUnlocalizedName() + "." + name);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
		switch (stack.getItemDamage()) {
		case 0:
			list.add("Using Tier 1 Machine Frame");
			break;
		case 1:
			list.add("Using Tier 2 Machine Frame");
			break;
		case 2:
			list.add("Using Tier 3 Machine Frame");
			break;
		case 3:
			list.add("Using Tier 4 Machine Frame");
			break;
		case 4:
			list.add("Using Tier 5 Machine Frame");
			break;
		}
	}

	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getItemDamage()) {
		case 0:
			name = "Steel";
			break;
		case 1:
			name = "Titanium";
			break;
		case 2:
			name = "Tantalum";
			break;
		case 3:
			name = "Vanadium";
			break;
		case 4:
			name = "VC";
			break;
		default:
			System.out.println("Invalid metadata for BioFuel Extractor tier.");
			name = "invalid";
			break;
		}
		return getUnlocalizedName() + "." + name;
	}
}
