package com.mce.handlers;

import java.util.Calendar;

import com.mce.util.updater.UpdateInfo;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class PlayerHandler {
	private boolean isAnniv;
	private boolean isBirthday;
	private boolean isChristmas;
	private boolean newUpdate;

	public PlayerHandler() {
		Calendar calendar = Calendar.getInstance();
		if ((calendar.get(2) + 1 == 5) && (calendar.get(5) == 14)) {
			this.isAnniv = true;
		}

		if ((calendar.get(2) + 1 == 6) && (calendar.get(5) == 16)) {
			this.isBirthday = true;
		}

		if ((calendar.get(2) + 1 == 12) && (calendar.get(5) >= 24) && (calendar.get(5) <= 26)) {
			this.isChristmas = true;
		}

		try {
			if (Integer.parseInt(UpdateInfo.getLatestVersion()) > UpdateInfo.thisVersion) {
				this.newUpdate = true;
			}
		} catch (Exception e) {
			System.out.println("An error has occurred! Error ID: IDT-300");
			e.printStackTrace();
		}
	}

	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent e) {
		onLogin(e.player);
	}

	public void onLogin(EntityPlayer player) {
		if (isAnniv) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.GREEN + "Today is the birthday of the IDT Mod!"));
		}

		else if (isBirthday) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.AQUA + "Today is MCE626's birthday!"));
		}

		else if (isChristmas) {
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + "M" + EnumChatFormatting.RED
					+ "e" + EnumChatFormatting.GREEN + "r" + EnumChatFormatting.RED + "r" + EnumChatFormatting.GREEN
					+ "y" + EnumChatFormatting.RED + " C" + EnumChatFormatting.GREEN + "h" + EnumChatFormatting.RED
					+ "r" + EnumChatFormatting.GREEN + "i" + EnumChatFormatting.RED + "s" + EnumChatFormatting.GREEN
					+ "t" + EnumChatFormatting.RED + "m" + EnumChatFormatting.GREEN + "a" + EnumChatFormatting.RED + "s"
					+ EnumChatFormatting.GREEN + "!"));
		}

		else if (newUpdate) {
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "New IDT mod update! "));
		}

		else if (player.getCommandSenderName().equals("MCE626")) {
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Hello me."));
		}

		else if (player.getCommandSenderName().equals("The_Crazy_Guy34")) {
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Hello Drew."));
		}

		else if (player.getCommandSenderName().equals("Tic_toc26")) {
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Hello Sean."));
		}

		else if (player.getCommandSenderName().equals("Guybot1001")) {
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Hello Nick."));
		}

		else if (player.getCommandSenderName().equals("Piemaster_33")) {
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Hello Patrick."));
		}
		
		else if (player.getCommandSenderName().equals("Shemenski")) {
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Hello Jack."));
		}

		else if (player.getCommandSenderName().equals("jeb_")) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.GOLD + "Hello Jeb! Hope you enjoy my mod! :D"));
		}

		else if (player.getCommandSenderName().equals("Notch")) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.GOLD + "Hello Notch! Hope you enjoy my mod! :D"));
		}

		else if (player.getCommandSenderName().equals("Dinnerbone")) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.GOLD + "Hello Dinnerbone! Hope you enjoy my mod! :D"));
		}

		else if (player.getCommandSenderName().equals("C418")) {
			player.addChatComponentMessage(new ChatComponentText(
					EnumChatFormatting.GOLD + "Hello C418! Hope you enjoy my mod! Cat is my favorite music disc! :D"));
		}

		else if (player.getCommandSenderName().equals("MinecraftChick")) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.GOLD + "Hello Lydia! Hope you enjoy my mod! :D"));
		}

		else if (player.getCommandSenderName().equals("SethBling")) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.GOLD + "Hello SethBling! Hope you enjoy my mod! :D"));
		}

		else if (player.getCommandSenderName().equals("AntVenom")) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.GOLD + "Hello AntVenom! Hope you enjoy my mod! :D"));
		}

		else if (player.getCommandSenderName().equals("SkythekidRS")) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.GOLD + "Hello Sky! Hope you enjoy my mod! :D"));
		}

		else if (player.getCommandSenderName().equals("DanTDM")) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.GOLD + "Hello Dan! Hope you enjoy my mod! :D"));
		}

		else if (player.getCommandSenderName().equals("MrCrayfish")) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.GOLD + "Hello MrCrayfish! Hope you enjoy my mod! :D"));
		}

		else if (player.getCommandSenderName().equals("iChun")) {
			player.addChatComponentMessage(new ChatComponentText(
					EnumChatFormatting.GOLD + "Hello iChun! Hope you enjoy my mod! Love the morph mod, btw. :D"));
		}

		else if (player.getCommandSenderName().equals("TrueMU")) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.GOLD + "Hello Jason! Hope you enjoy my mod! :D"));
		}

		else if (player.getCommandSenderName().equals("Eloraam")) {
			player.addChatComponentMessage(new ChatComponentText(
					EnumChatFormatting.GOLD + "Hello Eloraam! Hope you enjoy my mod! Love the RedPower mod! :D"));
		}

		else if (player.getCommandSenderName().equals("jakimfett")) {
			player.addChatComponentMessage(new ChatComponentText(
					EnumChatFormatting.GOLD + "Hello jakimfett! Hope you enjoy my mod! Love the Minechem mod! :D"));
		}

		else if (player.getCommandSenderName().equals("BebopVox")) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.GOLD + "Hello BebopVox! Hope you enjoy my mod! :D"));
		}

		else if (player.getCommandSenderName().equals("direwolf20")) {
			player.addChatComponentMessage(
					new ChatComponentText(EnumChatFormatting.GOLD + "Hello direwolf20! Hope you enjoy my mod! :D"));
		}

		else if (player.getCommandSenderName().equals("CaptainSparklez")) {
			player.addChatComponentMessage(new ChatComponentText(
					EnumChatFormatting.GOLD + "Hello CaptainSparklez! Hope you enjoy my mod! :D"));
		}

		else if (player.getCommandSenderName().equals("SdogSteven")) {
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD
					+ "Hello SCMowns! I give many thanks to you, as it was only your mod tutorials that actually worked for me at the time. :D"));
		}

		else if (player.getCommandSenderName().equals("kylelaw11")) {
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Hello Kyle!"));
		}

		else if (player.getCommandSenderName().equals("B4RevenantGamer")) {
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Hello Nate."));
		}

		else if (player.getCommandSenderName().equals("Kevvstar123")) {
			player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GOLD + "Hello Kevin."));
		}

		else if (player.getCommandSenderName().equals("deadmau5")) {
			player.addChatComponentMessage(new ChatComponentText(
					EnumChatFormatting.GOLD + "Hello Deadmau5! Hope you enjoy my mod! I like your music, btw."));
		}

		player.addChatComponentMessage(
				new ChatComponentText(EnumChatFormatting.GOLD + "Thanks " + EnumChatFormatting.AQUA
						+ player.getDisplayName() + EnumChatFormatting.GOLD + ", for downloading the IDT Mod!"));
		player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.DARK_PURPLE + "Support MCE: "));
	}
}
