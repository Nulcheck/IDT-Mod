package com.mce.events;

import com.mce.common.mod_IDT;
import com.mce.entity.tile.tech.TileEntityBFE;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class UpgradeTechEvent {
	TileEntity bfe;

	@SubscribeEvent
	public void upgrade(PlayerInteractEvent e) {
		bfe = e.world.getTileEntity(e.x, e.y, e.z);

		if (e.action == Action.RIGHT_CLICK_BLOCK && e.entityPlayer.getHeldItem() != null
				&& e.entityPlayer.isSneaking()) {
			if (e.world.getBlock(e.x, e.y, e.z) == mod_IDT.BioFuelExtractor) {
				if (e.entityPlayer.getHeldItem().getItem() == Item.getItemFromBlock(mod_IDT.MachineCasing)
						&& e.entityPlayer.getHeldItem().getItemDamage() == 0) {
					int lvl = e.world.getBlockMetadata(e.x, e.y, e.z);
					((TileEntityBFE) bfe).setLvl("steel");
					e.entityPlayer.getHeldItem().stackSize--;
					e.entityPlayer.inventory.addItemStackToInventory(
							new ItemStack(Item.getItemFromBlock(mod_IDT.MachineCasing), 1, lvl));
					e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 0, 0);
					e.world.markBlockForUpdate(e.x, e.y, e.z);
				}

				else if (e.entityPlayer.getHeldItem().getItem() == Item.getItemFromBlock(mod_IDT.MachineCasing)
						&& e.entityPlayer.getHeldItem().getItemDamage() == 1) {
					int lvl = e.world.getBlockMetadata(e.x, e.y, e.z);
					((TileEntityBFE) bfe).setLvl("titanium");
					e.entityPlayer.getHeldItem().stackSize--;
					e.entityPlayer.inventory.addItemStackToInventory(
							new ItemStack(Item.getItemFromBlock(mod_IDT.MachineCasing), 1, lvl));
					e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 1, 0);
					e.world.markBlockForUpdate(e.x, e.y, e.z);
				}

				else if (e.entityPlayer.getHeldItem().getItem() == Item.getItemFromBlock(mod_IDT.MachineCasing)
						&& e.entityPlayer.getHeldItem().getItemDamage() == 2) {
					int lvl = e.world.getBlockMetadata(e.x, e.y, e.z);
					((TileEntityBFE) bfe).setLvl("tantalum");
					e.entityPlayer.getHeldItem().stackSize--;
					e.entityPlayer.inventory.addItemStackToInventory(
							new ItemStack(Item.getItemFromBlock(mod_IDT.MachineCasing), 1, lvl));
					e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 2, 0);
					e.world.markBlockForUpdate(e.x, e.y, e.z);
				}

				else if (e.entityPlayer.getHeldItem().getItem() == Item.getItemFromBlock(mod_IDT.MachineCasing)
						&& e.entityPlayer.getHeldItem().getItemDamage() == 3) {
					int lvl = e.world.getBlockMetadata(e.x, e.y, e.z);
					((TileEntityBFE) bfe).setLvl("vanadium");
					e.entityPlayer.getHeldItem().stackSize--;
					e.entityPlayer.inventory.addItemStackToInventory(
							new ItemStack(Item.getItemFromBlock(mod_IDT.MachineCasing), 1, lvl));
					e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 3, 0);
					e.world.markBlockForUpdate(e.x, e.y, e.z);
				}

				else if (e.entityPlayer.getHeldItem().getItem() == Item.getItemFromBlock(mod_IDT.MachineCasing)
						&& e.entityPlayer.getHeldItem().getItemDamage() == 4) {
					int lvl = e.world.getBlockMetadata(e.x, e.y, e.z);
					((TileEntityBFE) bfe).setLvl("vc");
					e.entityPlayer.getHeldItem().stackSize--;
					e.entityPlayer.inventory.addItemStackToInventory(
							new ItemStack(Item.getItemFromBlock(mod_IDT.MachineCasing), 1, lvl));
					e.world.setBlockMetadataWithNotify(e.x, e.y, e.z, 4, 0);
					e.world.markBlockForUpdate(e.x, e.y, e.z);
				}
			}
		}
	}
}
