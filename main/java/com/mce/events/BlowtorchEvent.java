package com.mce.events;

import com.mce.common.mod_IDT;
import com.mce.entity.tile.tech.TileEntityBFE;
import com.mce.entity.tile.tech.TileEntityBHG;
import com.mce.entity.tile.tech.TileEntityIndustrialCutter;
import com.mce.entity.tile.tech.TileEntityMagnetizer;
import com.mce.entity.tile.tech.TileEntityMatterCondenser;
import com.mce.entity.tile.tech.TileEntitySmelter;
import com.mce.entity.tile.tech.TileEntityTankCompressor;
import com.mce.entity.tile.tech.TileEntityZNG;
import com.mce.handlers.registers.AchRegistry;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class BlowtorchEvent {
	// public static int smelterDam;
	TileEntity smelter, tc, gc, mag, mc, bfe, zng, bhg;

	@SubscribeEvent
	public void fix(PlayerInteractEvent e) {
		smelter = e.world.getTileEntity(e.x, e.y, e.z);
		tc = e.world.getTileEntity(e.x, e.y, e.z);
		gc = e.world.getTileEntity(e.x, e.y, e.z);
		mag = e.world.getTileEntity(e.x, e.y, e.z);
		mc = e.world.getTileEntity(e.x, e.y, e.z);
		bfe = e.world.getTileEntity(e.x, e.y, e.z);
		zng = e.world.getTileEntity(e.x, e.y, e.z);
		bhg = e.world.getTileEntity(e.x, e.y, e.z);

		if (e.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			if (e.entityPlayer.isSneaking()
					&& (e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SmelterIdle
							|| e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SmelterActive)
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.BlowTorch
					&& ((TileEntitySmelter) smelter).damage < ((TileEntitySmelter) smelter).maxDamage) {
				((TileEntitySmelter) smelter).damage += 100;
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.world.playSoundAtEntity(e.entityPlayer, "mod_idt:blowtorch", .5f, 1f);
				e.entityPlayer.addStat(AchRegistry.fixIt, 1);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.TankCompressor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.BlowTorch
					&& ((TileEntityTankCompressor) tc).damage < ((TileEntityTankCompressor) tc).maxDamage) {
				((TileEntityTankCompressor) tc).damage += 100;
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.world.playSoundAtEntity(e.entityPlayer, "mod_idt:blowtorch", .5f, 1f);
				e.entityPlayer.addStat(AchRegistry.fixIt, 1);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.IndustrialCutter
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.BlowTorch
					&& ((TileEntityIndustrialCutter) gc).damage < ((TileEntityIndustrialCutter) gc).maxDamage) {
				((TileEntityIndustrialCutter) gc).damage += 100;
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.world.playSoundAtEntity(e.entityPlayer, "mod_idt:blowtorch", .5f, 1f);
				e.entityPlayer.addStat(AchRegistry.fixIt, 1);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.Magnetizer
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.BlowTorch
					&& ((TileEntityMagnetizer) mag).damage < ((TileEntityMagnetizer) mag).maxDamage) {
				((TileEntityMagnetizer) mag).damage += 100;
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.world.playSoundAtEntity(e.entityPlayer, "mod_idt:blowtorch", .5f, 1f);
				e.entityPlayer.addStat(AchRegistry.fixIt, 1);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.MatterCondenser
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.BlowTorch
					&& ((TileEntityMatterCondenser) mc).damage < ((TileEntityMatterCondenser) mc).maxDamage) {
				((TileEntityMatterCondenser) mc).damage += 100;
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.world.playSoundAtEntity(e.entityPlayer, "mod_idt:blowtorch", .5f, 1f);
				e.entityPlayer.addStat(AchRegistry.fixIt, 1);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.BioFuelExtractor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.BlowTorch
					&& ((TileEntityBFE) bfe).damage < ((TileEntityBFE) bfe).maxDamage) {
				((TileEntityBFE) bfe).damage += 100;
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.world.playSoundAtEntity(e.entityPlayer, "mod_idt:blowtorch", .5f, 1f);
				e.entityPlayer.addStat(AchRegistry.fixIt, 1);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.ZNG
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.BlowTorch
					&& ((TileEntityZNG) zng).damage < ((TileEntityZNG) zng).maxDamage) {
				((TileEntityZNG) zng).damage += 100;
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.world.playSoundAtEntity(e.entityPlayer, "mod_idt:blowtorch", .5f, 1f);
				e.entityPlayer.addStat(AchRegistry.fixIt, 1);
			}
			
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.BlackHoleGenerator
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.BlowTorch
					&& ((TileEntityBHG) bhg).damage < ((TileEntityBHG) bhg).maxDamage) {
				((TileEntityBHG) bhg).damage += 100;
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.world.playSoundAtEntity(e.entityPlayer, "mod_idt:blowtorch", .5f, 1f);
				e.entityPlayer.addStat(AchRegistry.fixIt, 1);
			}

			// Null checks
			/*
			 * else if (e.entityPlayer.isSneaking() &&
			 * e.entityPlayer.getHeldItem() != null &&
			 * e.entityPlayer.getHeldItem().getItem() != mod_IDT.BlowTorch) {
			 * System.out.println("Null check1"); }
			 */

			/*
			 * else if (!e.entityPlayer.isSneaking() &&
			 * e.entityPlayer.getHeldItem() != null &&
			 * e.entityPlayer.getHeldItem().getItem() == mod_IDT.BlowTorch) {
			 * System.out.println("Null check5"); }
			 */
		}

		// Smelt blocks with blowtorch if recipe is a block smelting into a
		// block
		ItemStack stack = FurnaceRecipes.smelting().getSmeltingResult(
				new ItemStack(e.world.getBlock(e.x, e.y, e.z), 1, e.world.getBlockMetadata(e.x, e.y, e.z)));

		if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) instanceof Block
				&& e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == mod_IDT.BlowTorch
				&& stack != null) {
			if (stack.getItem() instanceof ItemBlock) {
				if (e.world.getBlock(e.x, e.y, e.z) == Blocks.stone_slab) {
					int meta = e.world.getBlockMetadata(e.x, e.y, e.z);
					if (meta == 11) {
						e.world.setBlock(e.x, e.y, e.z, Block.getBlockFromItem(stack.getItem()));
						e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
						e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
						e.world.markBlockForUpdate(e.x, e.y, e.z);
						e.world.playSoundAtEntity(e.entityPlayer, "mod_idt:blowtorch", .5f, 1f);
					} else {
						e.world.setBlock(e.x, e.y, e.z, Block.getBlockFromItem(stack.getItem()));
						e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
						e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
						e.world.markBlockForUpdate(e.x, e.y, e.z);
						e.world.playSoundAtEntity(e.entityPlayer, "mod_idt:blowtorch", .5f, 1f);
					}
				} else {
					int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

					e.world.setBlock(e.x, e.y, e.z, Block.getBlockFromItem(stack.getItem()));
					e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
					e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
					e.world.markBlockForUpdate(e.x, e.y, e.z);
					e.world.playSoundAtEntity(e.entityPlayer, "mod_idt:blowtorch", .5f, 1f);
				}
			}
		}
	}

	@SubscribeEvent
	public void breakItem(PlayerDestroyItemEvent e) {
		if (e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == mod_IDT.BlowTorch
				&& e.entityPlayer.getHeldItem().getItemDamage() <= 0) {
			e.entityPlayer.inventory.addItemStackToInventory(new ItemStack(mod_IDT.EmptyTank));
		}
	}

	@SubscribeEvent
	public void setEntityOnFire(AttackEntityEvent e) {
		if (e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() == mod_IDT.BlowTorch
				&& e.target instanceof EntityLiving) {
			e.target.setFire(8);
		}
	}
}
