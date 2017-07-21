package com.mce.events;

import com.mce.blocks.crops.CornCrop;
import com.mce.blocks.crops.SoyBeanCrop;
import com.mce.blocks.saplings.EbonySapling;
import com.mce.blocks.saplings.GelidSapling;
import com.mce.blocks.saplings.SilkwoodSapling;
import com.mce.blocks.saplings.WillowSapling;
import com.mce.common.mod_IDT;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class EventBonemeal {
	EntityPlayer player;

	@EventHandler
	public void onUseBonemeal(BonemealEvent event) {
		if (event.world.getBlock(event.x, event.y, event.z) == mod_IDT.WillowSapling) {
			((WillowSapling) mod_IDT.WillowSapling).growTree(event.world, event.world.rand, event.y, event.z, event.x);
		}

		else if (event.world.getBlock(event.x, event.y, event.z) == mod_IDT.EbonySapling) {
			((EbonySapling) mod_IDT.EbonySapling).growTree(event.world, event.world.rand, event.y, event.z, event.x);
		}

		else if (event.world.getBlock(event.x, event.y, event.z) == mod_IDT.SilkwoodSapling) {
			((SilkwoodSapling) mod_IDT.SilkwoodSapling).growTree(event.world, event.world.rand, event.y, event.z,
					event.x);
		}

		else if (event.world.getBlock(event.x, event.y, event.z) == mod_IDT.GelidSapling) {
			((GelidSapling) mod_IDT.GelidSapling).growTree(event.world, event.world.rand, event.y, event.z, event.x);
		}

		else if (event.world.getBlock(event.x, event.y, event.z) == mod_IDT.CornCrop) {
			((CornCrop) mod_IDT.CornCrop).fertilize(event.world, event.x, event.y, event.z);
			event.setResult(Result.ALLOW);
		}

		else if (event.world.getBlock(event.x, event.y, event.z) == mod_IDT.SoyBeanCrop) {
			((SoyBeanCrop) mod_IDT.SoyBeanCrop).fertilize(event.world, event.x, event.y, event.z);
			event.setResult(Result.ALLOW);
		} else {
			player.addChatComponentMessage(new ChatComponentText("Something went wrong! Error code: IDT-301"));
		}

	}
}