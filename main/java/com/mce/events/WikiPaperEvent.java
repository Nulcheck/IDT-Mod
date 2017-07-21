package com.mce.events;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.event.HoverEvent.Action;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class WikiPaperEvent {
	@SubscribeEvent
	public void wikiPaper(PlayerInteractEvent e) {
		if (e.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR && !e.world.isRemote) {
			if (e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.WikiPaper) {
				e.entityPlayer.addChatComponentMessage(new ChatComponentText("IDT Wiki: ").appendSibling(new ChatComponentText("\u00A76[Click Here]").setChatStyle(new ChatStyle()
								.setChatHoverEvent(new HoverEvent(Action.SHOW_TEXT, new ChatComponentText("Wiki")))
								.setChatClickEvent(new ClickEvent(net.minecraft.event.ClickEvent.Action.OPEN_URL,
										"https://idtmod.gamepedia.com")))));
			}
		}
	}
}
