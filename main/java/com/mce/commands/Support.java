package com.mce.commands;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class Support extends CommandBase {
	public int compareTo(Object arg0) {
		return 0;
	}

	public String getCommandName() {
		return "idtsupport";
	}

	public String getCommandUsage(ICommandSender icommandsender) {
		return "/idtsupport";
	}

	public List getCommandAliases() {
		return null;
	}

	public void processCommand(ICommandSender icommandsender, String[] astring) {
		func_152373_a(icommandsender, this, "command.idtsupport");
	}

	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}

	public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring) {
		return null;
	}

	public boolean isUsernameIndex(String[] astring, int i) {
		return false;
	}
}
