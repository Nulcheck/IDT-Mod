package com.mce.items.blocks.tech;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemMachineCasing extends ItemBlockWithMetadata {
	String name = "";

	public ItemMachineCasing(Block block) {
		super(block, block);
		this.setUnlocalizedName(getUnlocalizedName() + "." + name);
		this.setHasSubtypes(true);
	}

	public IIcon getIconFromDamage(int meta) {
		return Block.getBlockFromItem(this).getIcon(2, meta);
	}

	public int getMetadata(int meta) {
		return meta;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
		switch (stack.getItemDamage()) {
		case 0:
			list.add("Tier 1 Case");
			break;
		case 1:
			list.add("Tier 2 Case");
			break;
		case 2:
			list.add("Tier 3 Case");
			break;
		case 3:
			list.add("Tier 4 Case");
			break;
		case 4:
			list.add("Tier 5 Case");
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
			System.out.println("Invalid metadata for Machine Casing.");
			name = "invalid";
			break;
		}
		return getUnlocalizedName() + "." + name;
	}
}
