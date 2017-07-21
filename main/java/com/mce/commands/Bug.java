package com.mce.commands;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class Bug extends CommandBase {
	public int compareTo(Object arg0) {
		return 0;
	}

	public String getCommandName() {
		return "idtbug";
	}

	public String getCommandUsage(ICommandSender icommandsender) {
		return "/idtbug";
	}

	public List getCommandAliases() {
		return null;
	}

	public void processCommand(ICommandSender icommandsender, String[] astring) {
		func_152373_a(icommandsender, this, "command.idtbug");
	}

	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}

	public List addTabCompletionOptions(ICommandSender icommandsender,
			String[] astring) {
		return null;
	}

	public boolean isUsernameIndex(String[] astring, int i) {
		return false;
	}

}
