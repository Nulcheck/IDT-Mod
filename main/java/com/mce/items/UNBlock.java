package com.mce.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class UNBlock extends ItemBlock {

	public UNBlock(Block block) {
		super(block);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List list,
			boolean show) {
		list.add(EnumChatFormatting.BOLD + "******" + EnumChatFormatting.RESET
				+ "*");
	}

}
