package com.mce.events;

import java.util.Random;

import com.mce.common.mod_IDT;
import com.mce.handlers.registers.AchRegistry;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fluids.FluidEvent;

public class OtherEvents {
	// For dev drops
	@SubscribeEvent
	public void onPlayerDeath(PlayerDropsEvent e) {
		Random rand = new Random();
		int i = rand.nextInt(149);

		if (i == 50) {
			if (e.entityPlayer.getCommandSenderName().equals("MCE626")) {
				e.entityPlayer.func_146097_a(new ItemStack(mod_IDT.Nitroglycerin), true, false);
			}

			if (e.entityPlayer.getCommandSenderName().equals("The_Crazy_Guy43")) {
				e.entityPlayer.func_146097_a(new ItemStack(Item.getItemFromBlock(mod_IDT.UltimateNuker)), true, false);
			}

			if (e.entityPlayer.getCommandSenderName().equals("Tic_toc26")) {
				e.entityPlayer.func_146097_a(new ItemStack(Item.getItemFromBlock(mod_IDT.LavaObsidian)), true, false);
			}

			if (e.entityPlayer.getCommandSenderName().equals("Kevvstar123")) {
				e.entityPlayer.func_146097_a(new ItemStack(Item.getItemFromBlock(Blocks.tnt)), true, false);
			}
		}
	}

	// For the double slab droppings
	@SubscribeEvent
	public void doubleSlabDrops(BlockEvent.HarvestDropsEvent e) {
		Block block = e.block;

		if (block == mod_IDT.WillowDoubleSlab) {
			e.drops.add(new ItemStack(mod_IDT.WillowSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.EbonyDoubleSlab) {
			e.drops.add(new ItemStack(mod_IDT.EbonySlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.SilkwoodDoubleSlab) {
			e.drops.add(new ItemStack(mod_IDT.SilkwoodSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GelidDoubleSlab) {
			e.drops.add(new ItemStack(mod_IDT.SilkwoodSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.StoneDoubleSlab) {
			e.drops.add(new ItemStack(mod_IDT.StoneSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.CementDoubleSlab) {
			e.drops.add(new ItemStack(mod_IDT.CementSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.CementBrickDoubleSlab) {
			e.drops.add(new ItemStack(mod_IDT.CementBrickSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlab) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlab, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabWhite) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabWhite, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabOrange) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabOrange, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabMagenta) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabMagenta, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabLightBlue) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabLightBlue, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabYellow) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabYellow, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabLime) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabLime, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabPink) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabPink, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabGray) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabGray, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabLightGray) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabLightGray, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabCyan) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabCyan, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabPurple) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabPurple, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabBlue) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabBlue, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabBrown) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabBrown, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabGreen) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabGreen, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabRed) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabRed, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}

		else if (block == mod_IDT.GlassDoubleSlabBlack) {
			e.drops.add(new ItemStack(mod_IDT.GlassSlabBlack, 2));
			e.drops.remove(0);
			e.drops.remove(0);
		}
	}

	// For block changing.
	@SubscribeEvent
	public void changeBlock(PlayerInteractEvent e) {
		// Lava obsidian
		if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == Blocks.obsidian
				&& e.entityPlayer.getHeldItem() != null
				&& e.entityPlayer.getHeldItem().getItem() == Items.lava_bucket) {
			e.entityPlayer.inventory.consumeInventoryItem(Items.lava_bucket);
			e.world.setBlock(e.x, e.y, e.z, mod_IDT.LavaObsidian);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.bucket, 1));
		}

		else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.LavaObsidian
				&& e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.bucket) {
			e.entityPlayer.inventory.consumeInventoryItem(Items.bucket);
			e.world.setBlock(e.x, e.y, e.z, Blocks.obsidian);
			e.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.lava_bucket, 1));
		}

		// Lava cobble
		else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == Blocks.cobblestone
				&& e.entityPlayer.getHeldItem() != null
				&& e.entityPlayer.getHeldItem().getItem() == Items.lava_bucket) {
			e.entityPlayer.inventory.consumeInventoryItem(Items.lava_bucket);
			e.world.setBlock(e.x, e.y, e.z, mod_IDT.LavaCobble);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.bucket, 1));
		}

		else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.LavaCobble
				&& e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.bucket) {
			e.entityPlayer.inventory.consumeInventoryItem(Items.bucket);
			e.world.setBlock(e.x, e.y, e.z, Blocks.cobblestone);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.lava_bucket, 1));
		}

		// Crying obsidian
		else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == Blocks.obsidian
				&& e.entityPlayer.getHeldItem() != null
				&& e.entityPlayer.getHeldItem().getItem() == Items.water_bucket) {
			e.entityPlayer.inventory.consumeInventoryItem(Items.water_bucket);
			e.world.setBlock(e.x, e.y, e.z, mod_IDT.CryingObsidian);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.bucket, 1));
			e.entityPlayer.addStat(AchRegistry.sadObsidian, 1);
		}

		else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CryingObsidian
				&& e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.bucket) {
			e.entityPlayer.inventory.consumeInventoryItem(Items.bucket);
			e.world.setBlock(e.x, e.y, e.z, Blocks.obsidian);
			e.world.markBlockForUpdate(e.x, e.y, e.z);
			e.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.water_bucket, 1));
		}

		// Essence of Air
		else if (e.action == PlayerInteractEvent.Action.RIGHT_CLICK_AIR) {
			if (e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.HardCrystalBall) {
				if (!e.world.isRemote) {
					e.entityPlayer.addChatComponentMessage(
							new ChatComponentText("The crystal ball has been changed into Essence of Air."));
				}
				e.entityPlayer.inventory.consumeInventoryItem(mod_IDT.HardCrystalBall);
				e.entityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_IDT.EssenceOfAir, 1));
			}
		}

		// Portal creations
		else if (e.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			if (e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == Items.snowball
					&& e.world.getBlock(e.x, e.y, e.z) == Blocks.snow) {
				e.world.setBlock(e.x, e.y + 1, e.z, mod_IDT.FrozenFire);
				e.world.scheduleBlockUpdate(e.x, e.y, e.z, mod_IDT.FrozenFire, 1);
			}

			else if (e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.CrystalGem
					&& e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CrystalBlock) {
				e.world.setBlock(e.x, e.y + 1, e.z, mod_IDT.CrystalFire);
				e.world.scheduleBlockUpdate(e.x, e.y, e.z, mod_IDT.CrystalFire, 1);
			}
		}
	}

	// For liquids and their buckets
	@SubscribeEvent
	public void fillBucket(FillBucketEvent e) {
		if (!e.current.getItem().equals(Items.bucket)) {
			return;
		}

		ItemStack fullBucket = getFluid(e.world, e.target);

		if (fullBucket == null) {
			return;
		}

		e.world.setBlockToAir(e.target.blockX, e.target.blockY, e.target.blockZ);
		e.result = fullBucket;
		e.setResult(Result.ALLOW);
	}

	private ItemStack getFluid(World world, MovingObjectPosition pos) {
		Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);

		if (block == mod_IDT.LiquidNitrogen) {
			return new ItemStack(mod_IDT.LiquidNitrogenBucket);
		}

		return null;
	}

	@SuppressWarnings("unused")
	@SubscribeEvent
	public void harden(FluidEvent e) {
		if (e.world.getBlock(e.x, e.y, e.x) == mod_IDT.LiquidNitrogen) {
			boolean flag = false;
			boolean b = e.world.getBlock(e.x, e.y, e.z) == mod_IDT.LiquidNitrogen;

			// Water
			if (flag || e.world.getBlock(e.x, e.y, e.x - 1).getMaterial() == Material.water) {
				flag = true;
				b = e.world.setBlock(e.x, e.y, e.x, Blocks.packed_ice);
			}

			if (flag || e.world.getBlock(e.x, e.y, e.x + 1).getMaterial() == Material.water) {
				flag = true;
				b = e.world.setBlock(e.x, e.y, e.x, Blocks.packed_ice);
			}

			if (flag || e.world.getBlock(e.x - 1, e.y, e.x).getMaterial() == Material.water) {
				flag = true;
				b = e.world.setBlock(e.x, e.y, e.x, Blocks.packed_ice);
			}

			if (flag || e.world.getBlock(e.x + 1, e.y, e.x).getMaterial() == Material.water) {
				flag = true;
				b = e.world.setBlock(e.x, e.y, e.x, Blocks.packed_ice);
			}

			if (flag || e.world.getBlock(e.x, e.y + 1, e.x).getMaterial() == Material.water) {
				flag = true;
				b = e.world.setBlock(e.x, e.y, e.x, Blocks.packed_ice);
			}

			// Lava
			if (flag || e.world.getBlock(e.x, e.y, e.x - 1).getMaterial() == Material.lava) {
				flag = true;
				b = e.world.setBlock(e.x, e.y, e.x, Blocks.air);
			}

			if (flag || e.world.getBlock(e.x, e.y, e.x + 1).getMaterial() == Material.lava) {
				flag = true;
				b = e.world.setBlock(e.x, e.y, e.x, Blocks.air);
			}

			if (flag || e.world.getBlock(e.x - 1, e.y, e.x).getMaterial() == Material.lava) {
				flag = true;
			}

			if (flag || e.world.getBlock(e.x + 1, e.y, e.x).getMaterial() == Material.lava) {
				flag = true;
				b = e.world.setBlock(e.x, e.y, e.x, Blocks.air);
			}

			if (flag || e.world.getBlock(e.x, e.y + 1, e.x).getMaterial() == Material.lava) {
				flag = true;
				b = e.world.setBlock(e.x, e.y, e.x, Blocks.air);
			}

			if (flag == true) {
				int l = e.world.getBlockMetadata(e.x, e.y, e.x);

				if (l == 0 && e.world.getBlock(e.x, e.y, e.x).getMaterial() == Material.water) {
					b = e.world.setBlock(e.x, e.y, e.x, Blocks.packed_ice);
				}

				else if (l == 0 && e.world.getBlock(e.x, e.y, e.x).getMaterial() == Material.lava) {
					b = e.world.setBlock(e.x, e.y, e.x, Blocks.air);
				}

				else if (l <= 4 && e.world.getBlock(e.x, e.y, e.x).getMaterial() == Material.water) {
					b = e.world.setBlock(e.x, e.y, e.x, Blocks.packed_ice);
				}

				else if (l <= 4 && e.world.getBlock(e.x, e.y, e.x).getMaterial() == Material.lava) {
					b = e.world.setBlock(e.x, e.y, e.x, Blocks.air);
				}

				e.world.playSoundEffect((double) ((float) e.x + 0.5F), (double) ((float) e.y + 0.5F),
						(double) ((float) e.x + 0.5F), "random.fie.xe.x", 0.5F,
						2.6F + (e.world.rand.nextFloat() - e.world.rand.nextFloat()) * 0.8F);
			}
		}
	}
}