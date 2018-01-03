package com.mce.items.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemMachineFrame extends ItemBlockWithMetadata {
	String name = "";

	public ItemMachineFrame(Block block) {
		super(block, block);
		this.setUnlocalizedName(getUnlocalizedName() + "." + name);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
		switch (stack.getItemDamage()) {
		case 0:
			list.add("Tier 1 Frame");
			break;
		case 1:
			list.add("Tier 2 Frame");
			break;
		case 2:
			list.add("Tier 3 Frame");
			break;
		case 3:
			list.add("Tier 4 Frame");
			break;
		case 4:
			list.add("Tier 5 Frame");
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
			System.out.println("Invalid metadata for Machine Frame.");
			name = "invalid";
			break;
		}
		return getUnlocalizedName() + "." + name;
	}
}
