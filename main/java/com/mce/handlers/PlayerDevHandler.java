package com.mce.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PlayerDevHandler {	
	@SubscribeEvent
	public void changeDevName(PlayerEvent.NameFormat e) {
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
		else if(e.username.equals("MrProBro")){
			e.displayname = EnumChatFormatting.AQUA + "ᶦ " + EnumChatFormatting.RESET + "MrProBro";
		}
		
		else if(e.username.equals("domi1819")){
			e.displayname = EnumChatFormatting.AQUA + "ᶦ " + EnumChatFormatting.RESET + "domi1819";
		}
		
		// Patreons
		else if(e.username.equals("ergwghetrgergerg")){ // Test name so I can just copy that generic currency symbol
			e.displayname = EnumChatFormatting.AQUA + "¤ " + EnumChatFormatting.RESET + "name";
		}
	}
}
