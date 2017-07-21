package com.mce.items;

import com.mce.common.mod_IDT;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class HardCrystalBall extends Item {
	public HardCrystalBall() {
		super();
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float fx,
			float fy, float fz) {
		boolean flag = true;
		MovingObjectPosition mp = getMovingObjectPositionFromPlayer(world, player, flag);

		int i = mp.blockX;
		int j = mp.blockY;
		int k = mp.blockZ;

		if (flag && !world.isRemote) {
			if (player.isSneaking() && world.getBlock(i, j, k) == Blocks.netherrack) {
				player.addChatComponentMessage(
						new ChatComponentText("The crystal ball has been changed into Essence of Fir"));
				player.inventory.consumeInventoryItem(mod_IDT.HardCrystalBall);
				player.inventory.addItemStackToInventory(new ItemStack(mod_IDT.EssenceOfFire));
			}

			else if (player.isSneaking() && world.getBlock(i, j, k) == Blocks.grass) {
				player.addChatComponentMessage(
						new ChatComponentText("The crystal ball has been changed into Essence of Earth."));
				player.inventory.consumeInventoryItem(mod_IDT.HardCrystalBall);
				player.inventory.addItemStackToInventory(new ItemStack(mod_IDT.EssenceOfEarth));
			}

			else if (player.isSneaking() && world.getBlock(i, j, k) == Blocks.dirt) {
				player.addChatComponentMessage(
						new ChatComponentText("The crystal ball has been changed into Essence of Earth."));
				player.inventory.consumeInventoryItem(mod_IDT.HardCrystalBall);
				player.inventory.addItemStackToInventory(new ItemStack(mod_IDT.EssenceOfEarth));
			}

			else if (player.isSneaking() && world.getBlock(i, j, k).getMaterial() == Material.plants) {
				player.addChatComponentMessage(
						new ChatComponentText("The crystal ball has been changed into Essence of Life"));
				player.inventory.consumeInventoryItem(mod_IDT.HardCrystalBall);
				player.inventory.addItemStackToInventory(new ItemStack(mod_IDT.EssenceOfLife));
			}

			else if (player.isSneaking() && world.getBlock(i, j, k).getMaterial() == Material.leaves) {
				player.addChatComponentMessage(
						new ChatComponentText("The crystal ball has been changed into Essence of Life"));
				player.inventory.consumeInventoryItem(mod_IDT.HardCrystalBall);
				player.inventory.addItemStackToInventory(new ItemStack(mod_IDT.EssenceOfLife));
			}

			else if (player.isSneaking() && world.getBlock(i, j, k) == Blocks.tallgrass) {
				player.addChatComponentMessage(
						new ChatComponentText("The crystal ball has been changed into Essence of Life"));
				player.inventory.consumeInventoryItem(mod_IDT.HardCrystalBall);
				player.inventory.addItemStackToInventory(new ItemStack(mod_IDT.EssenceOfLife));
			}

			else if (player.isSneaking() && world.getBlock(i, j, k) == Blocks.cactus) {
				player.addChatComponentMessage(
						new ChatComponentText("The crystal ball has been changed into Essence of Life"));
				player.inventory.consumeInventoryItem(mod_IDT.HardCrystalBall);
				player.inventory.addItemStackToInventory(new ItemStack(mod_IDT.EssenceOfLife));
			}

			else if (player.isSneaking() && world.getBlock(i, j, k) == Blocks.vine) {
				player.addChatComponentMessage(
						new ChatComponentText("The crystal ball has been changed into Essence of Life"));
				player.inventory.consumeInventoryItem(mod_IDT.HardCrystalBall);
				player.inventory.addItemStackToInventory(new ItemStack(mod_IDT.EssenceOfLife));
			}

			else if (player.isSneaking() && world.getBlock(i, j, k) == Blocks.water) {
				player.addChatComponentMessage(
						new ChatComponentText("The crystal ball has been changed into Essence of Water."));
				player.inventory.consumeInventoryItem(mod_IDT.HardCrystalBall);
				player.inventory.addItemStackToInventory(new ItemStack(mod_IDT.EssenceOfWater, 1));
			}

			else if (player.isSneaking() && world.getBlock(i, j, k) == Blocks.lava) {
				player.addChatComponentMessage(
						new ChatComponentText("The crystal ball has been changed into Essence of Fir"));
				player.inventory.consumeInventoryItem(mod_IDT.HardCrystalBall);
				player.inventory.addItemStackToInventory(new ItemStack(mod_IDT.EssenceOfFire, 1));
			}
		}

		return true;
	}
}
