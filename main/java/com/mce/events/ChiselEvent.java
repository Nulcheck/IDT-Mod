package com.mce.events;

import com.mce.common.mod_IDT;
import com.mce.handlers.registers.AchRegistry;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class ChiselEvent {
	@SubscribeEvent
	public void chisel(PlayerInteractEvent e) {
		if (e.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == Blocks.stone
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stonebrick, 0, 0);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == Blocks.stonebrick
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stonebrick, 1, 0);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == Blocks.stonebrick
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stonebrick, 2, 0);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == Blocks.stonebrick
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.world.getBlockMetadata(e.x, e.y, e.z) == 2
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stonebrick, 3, 0);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == Blocks.stonebrick
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.stonebrick, 0, 0);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == Blocks.sandstone
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.sandstone, 1, 0);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == Blocks.sandstone
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.sandstone, 2, 0);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == Blocks.sandstone
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, Blocks.sandstone, 0, 0);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.Cement
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_IDT.CementBricks);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
				e.entityPlayer.addStat(AchRegistry.cementBricks, 1);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementBricks
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlock(e.x, e.y, e.z, mod_IDT.Cement);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Secret Trapdoors!
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.BirchTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretBirchTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SpruceTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretSpruceTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.JungleTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretJungleTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.WillowTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretWillowTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.EbonyTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretEbonyTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SilkwoodTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretSilkwoodTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.AcaciaTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretAcaciaTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.DarkOakTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretDarkOakTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretBirchTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.BirchTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretSpruceTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SpruceTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretJungleTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.JungleTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretWillowTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.WillowTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretEbonyTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.EbonyTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretSilkwoodTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SilkwoodTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretAcaciaTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.AcaciaTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretDarkOakTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.DarkOakTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == Blocks.trapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretOakTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretOakTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, Blocks.trapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretCementTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretCementTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.CementTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementBrickTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretCementBrickTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretCementBrickTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.CementBrickTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.StoneTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretStoneTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretStoneTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.StoneTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CobblestoneTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretCobblestoneTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretCobblestoneTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.CobblestoneTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.MossyCobblestoneTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretMossyCobblestoneTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking()
					&& e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretMossyCobblestoneTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.MossyCobblestoneTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.StonebrickTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretStonebrickTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretStonebrickTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.StonebrickTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.MossyStonebrickTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretMossyStonebrickTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking()
					&& e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretMossyStonebrickTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.MossyStonebrickTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CrackedStonebrickTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretCrackedStonebrickTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking()
					&& e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretCrackedStonebrickTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.CrackedStonebrickTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking()
					&& e.world.getBlock(e.x, e.y, e.z) == mod_IDT.ChiseledStonebrickTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.SecretChiseledStonebrickTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			else if (e.entityPlayer.isSneaking()
					&& e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SecretChiseledStonebrickTrapdoor
					&& e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				int meta = e.world.getBlockMetadata(e.x, e.y, e.z);

				e.world.setBlock(e.x, e.y, e.z, mod_IDT.ChiseledStonebrickTrapdoor);
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, meta, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
			}

			// TODO: Wall slabs
			// Willow
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.WillowSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.WillowSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.WillowSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.WillowSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.WillowSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.WillowSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Ebony
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.EbonySlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.EbonySlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.EbonySlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.EbonySlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.EbonySlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.EbonySlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Silkwood
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SilkwoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SilkwoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SilkwoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SilkwoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SilkwoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.SilkwoodSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Real Stone
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.StoneSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.StoneSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.StoneSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.StoneSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.StoneSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.StoneSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Cement
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Cement Brick
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.CementBrickSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Glass
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlab
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// White
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabWhite
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabWhite
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabWhite
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabWhite
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabWhite
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabWhite
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Orange
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabOrange
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabOrange
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabOrange
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabOrange
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabOrange
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabOrange
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Magenta
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabMagenta
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabMagenta
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabMagenta
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabMagenta
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabMagenta
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabMagenta
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Light Blue
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLightBlue
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLightBlue
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLightBlue
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLightBlue
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLightBlue
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLightBlue
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Yellow
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabYellow
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabYellow
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabYellow
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabYellow
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabYellow
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabYellow
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Lime
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLime
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLime
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLime
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLime
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLime
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLime
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Pink
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabPink
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabPink
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabPink
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabPink
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabPink
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabPink
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Gray
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabGray
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabGray
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabGray
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabGray
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabGray
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabGray
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Light Gray
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLightGray
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLightGray
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLightGray
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLightGray
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLightGray
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabLightGray
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Cyan
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabCyan
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabCyan
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabCyan
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabCyan
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabCyan
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabCyan
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Purple
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabPurple
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabPurple
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabPurple
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabPurple
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabPurple
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabPurple
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Blue
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBlue
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBlue
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBlue
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBlue
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBlue
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBlue
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Brown
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBrown
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBrown
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBrown
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBrown
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBrown
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBrown
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Green
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabGreen
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabGreen
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabGreen
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabGreen
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabGreen
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabGreen
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Red
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabRed
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabRed
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabRed
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabRed
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabRed
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabRed
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Black
			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBlack
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 0 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBlack
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 1 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBlack
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 2 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBlack
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 3 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBlack
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 4 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 8, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			else if (e.entityPlayer.isSneaking() && e.world.getBlock(e.x, e.y, e.z) == mod_IDT.GlassSlabBlack
					&& e.world.getBlockMetadata(e.x, e.y, e.z) == 8 && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel) {
				e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 1);
				e.entityPlayer.inventory.getCurrentItem().damageItem(1, e.entityPlayer);
				e.world.markBlockForUpdate(e.x, e.y, e.z);
			}

			// Leave the null check in there, or it will crash when you use a
			// trapdoor with anything but the chisel
			else if (!e.entityPlayer.isSneaking() && e.entityPlayer.getHeldItem() != null
					&& e.entityPlayer.getHeldItem().getItem() == mod_IDT.Chisel && !e.world.isRemote) {
				e.entityPlayer
						.addChatComponentMessage(new ChatComponentText("You need to be sneaking to chisel something!"));
			}
		}
	}
}
