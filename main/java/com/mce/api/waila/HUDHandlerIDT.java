package com.mce.api.waila;

import java.util.List;

import com.mce.common.mod_IDT;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class HUDHandlerIDT implements IWailaDataProvider {
	public NBTTagCompound getNBTData(EntityPlayerMP playerMP, TileEntity entity, NBTTagCompound tag, World world, int x,
			int y, int z) {
		return null;
	}

	public List<String> getWailaBody(ItemStack stack, List<String> list, IWailaDataAccessor data,
			IWailaConfigHandler conf) {
		return list;
	}

	public List<String> getWailaHead(ItemStack stack, List<String> list, IWailaDataAccessor data,
			IWailaConfigHandler conf) {
		return list;
	}

	public ItemStack getWailaStack(IWailaDataAccessor data, IWailaConfigHandler conf) {
		return null;
	}

	public List<String> getWailaTail(ItemStack stack, List<String> list, IWailaDataAccessor data,
			IWailaConfigHandler conf) {
		if (stack.getItem() == Item.getItemFromBlock(mod_IDT.DidymiumGlass)) {
			list.add("Welder's Glass");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.DidymiumGlassPane)) {
			list.add("Welder's Glass");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.EinsteiniumOre)) {
			list.add("Radioactive!");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.NeptuniumOre)) {
			list.add("Radioactive!");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.UraniumOre)) {
			list.add("Radioactive!");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.EinsteiniumBlock)) {
			list.add("Radioactive!");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.NeptuniumBlock)) {
			list.add("Radioactive!");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.UraniumBlock)) {
			list.add("Radioactive!");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.EinsteiniumBomb)) {
			list.add(EnumChatFormatting.BOLD + "**" + EnumChatFormatting.RESET + "*****");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.NeptuniumBomb)) {
			list.add(EnumChatFormatting.BOLD + "***" + EnumChatFormatting.RESET + "****");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.UraniumBomb)) {
			list.add(EnumChatFormatting.BOLD + "****" + EnumChatFormatting.RESET + "***");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.UltimateNuker)) {
			list.add(EnumChatFormatting.BOLD + "******" + EnumChatFormatting.RESET + "*");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.StableBlackHole)) {
			list.add("Fancy Trashcan");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.LiquidNitrogen)) {
			list.add("Cold!");
		}
		return list;
	}
}
