package com.mce.handlers;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;

public class ChemicalHandler {
	@SubscribeEvent
	public void physicsShit(ItemTossEvent e) {
		if (e.entityItem.equals(mod_IDT.Nitroglycerin) && e.entityItem.onGround) {
			System.out.println("Boom!");
			e.entityItem.lifespan = 0;
		}
	}
}
