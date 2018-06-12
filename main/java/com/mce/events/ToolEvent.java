package com.mce.events;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.event.world.BlockEvent;

public class ToolEvent {
	@SubscribeEvent
	public void autoSmelt(BlockEvent.HarvestDropsEvent e) {
		if (e.harvester != null) {
			if (e.harvester.getHeldItem() != null && e.harvester.getHeldItem().getItem() == mod_IDT.NeoronPick) {
				ItemStack stack = FurnaceRecipes.smelting()
						.getSmeltingResult(new ItemStack(e.block, 1, e.blockMetadata));
				if (stack != null && !stack.isItemEqual(new ItemStack(mod_IDT.LavaStone))) {
					e.drops.clear();
					e.drops.add(stack.copy());
				}
			}
		}
	}
}