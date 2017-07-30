package com.mce.handlers;

import java.io.InputStream;
import java.net.URL;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PlayerDevHandler {
	public static final String name = "https://docs.google.com/document/d/1I3vsIBKBeYvLp0XKToGBJWDG0DRpiO_c4KuYRkzKqd4/pub";

	@SubscribeEvent
	public void changeDevName(PlayerEvent.NameFormat e) throws Exception {
		if (e.username.equals("MCE626")) {
			e.displayname = EnumChatFormatting.AQUA + "{Dev} MCE626";
		}

		else if (e.username.equals("Tic_toc26")) {
			e.displayname = EnumChatFormatting.GOLD + "(Dev) Tic_toc26";
		}

		else if (e.username.equals("The_Crazy_Guy34")) {
			e.displayname = EnumChatFormatting.DARK_GREEN + "(Dev) The_Crazy_Guy34";
		}

		else if (e.username.equals("_Guybot1001_")) {
			e.displayname = EnumChatFormatting.BLUE + "(Dev) _Guybot1001_";
		}

		// Contributors
		else if (e.username.equals(getNames())) {
			try {
				e.displayname = EnumChatFormatting.AQUA + "ᶦ " + EnumChatFormatting.RESET + getNames();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public static String getNames() throws Exception {
		String data = getData("https://docs.google.com/document/d/1I3vsIBKBeYvLp0XKToGBJWDG0DRpiO_c4KuYRkzKqd4/pub");
		return data.substring(data.indexOf("[u]") + 3, data.indexOf("[/u]"));
	}

	private static String getData(String address) throws Exception {
		URL url = new URL(address);
		InputStream html = null;
		html = url.openStream();

		int c = 0;
		StringBuffer buff = new StringBuffer("");
		while (c != -1) {
			c = html.read();
			buff.append((char) c);
		}
		return buff.toString();
	}
}
