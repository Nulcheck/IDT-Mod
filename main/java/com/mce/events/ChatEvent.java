package com.mce.events;

import com.mce.handlers.PlayerDevHandler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.event.HoverEvent.Action;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class ChatEvent {
	PlayerDevHandler dev;
	
	@SubscribeEvent
	public void chat(ClientChatReceivedEvent e) {
		if (e.message.getUnformattedText().contains("IDT News: ")) {
			e.message.appendSibling(
					new ChatComponentText("[Click Here]").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)
							.setChatHoverEvent(new HoverEvent(Action.SHOW_TEXT, new ChatComponentText("IDT News!")))
							.setChatClickEvent(new ClickEvent(net.minecraft.event.ClickEvent.Action.OPEN_URL,
									"http://mce626.enjin.com/idtnews"))));
		}

		if (e.message.getUnformattedText().contains("IDT Polls: ")) {
			e.message
					.appendSibling(
							new ChatComponentText("[Click Here]")
									.setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)
											.setChatHoverEvent(new HoverEvent(Action.SHOW_TEXT, new ChatComponentText(
													"Check for Polls!")))
					.setChatClickEvent(new ClickEvent(net.minecraft.event.ClickEvent.Action.OPEN_URL,
							"http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2381040-idtmod"))));
		}

		if (e.message.getUnformattedText().contains("IDT Bug Tracker: ")) {
			e.message.appendSibling(
					new ChatComponentText("[Click Here]").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)
							.setChatHoverEvent(
									new HoverEvent(Action.SHOW_TEXT, new ChatComponentText("Report bugs here!")))
					.setChatClickEvent(new ClickEvent(net.minecraft.event.ClickEvent.Action.OPEN_URL,
							"https://bitbucket.org/MCE626/idt-mod/issues"))));
		}

		if (e.message.getUnformattedText().contains("Support MCE: ")) {
			e.message.appendSibling(
					new ChatComponentText("[Click Here]").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)
							.setChatHoverEvent(new HoverEvent(Action.SHOW_TEXT,
									new ChatComponentText("Support MCE's mods via Patreon!")))
					.setChatClickEvent(new ClickEvent(net.minecraft.event.ClickEvent.Action.OPEN_URL,
							"https://www.patreon.com/MCE626"))));
			e.message.appendSibling(
					new ChatComponentText("!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_PURPLE)));
		}

		if (e.message.getUnformattedText().contains("New IDT mod update! ")) {
			e.message
					.appendSibling(
							new ChatComponentText("[Click Here]")
									.setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)
											.setChatHoverEvent(new HoverEvent(Action.SHOW_TEXT, new ChatComponentText(
													"New update!")))
					.setChatClickEvent(new ClickEvent(net.minecraft.event.ClickEvent.Action.OPEN_URL,
							"https://minecraft.curseforge.com/projects/industrial-technologies-and-more-idt"))));
		}
	}
}
