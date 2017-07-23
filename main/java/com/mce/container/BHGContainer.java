package com.mce.container;

import com.mce.entity.tile.tech.TileEntityBHG;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class BHGContainer extends Container {
	private TileEntityBHG bhg;
	public int lastFuel;
	public int lastCreate;
	public int lastDamage;

	public BHGContainer(InventoryPlayer player, TileEntityBHG entity) {
		this.bhg = entity;

		this.addSlotToContainer(new Slot(entity, 0, 8, 34)); // Fuel
		this.addSlotToContainer(new Slot(entity, 1, 152, 11)); // Upgrade

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting craft) {
		super.addCraftingToCrafters(craft);
		craft.sendProgressBarUpdate(this, 0, this.bhg.createTime);
		craft.sendProgressBarUpdate(this, 1, this.bhg.fuel);
		craft.sendProgressBarUpdate(this, 2, this.bhg.damage);
	}

	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); i++) {
			ICrafting craft = (ICrafting) this.crafters.get(i);

			if (this.lastCreate != this.bhg.createTime) {
				craft.sendProgressBarUpdate(this, 0, this.bhg.createTime);
			}

			if (this.lastFuel != this.bhg.fuel) {
				craft.sendProgressBarUpdate(this, 1, this.bhg.fuel);
			}

			if (this.lastDamage != this.bhg.damage) {
				craft.sendProgressBarUpdate(this, 2, this.bhg.damage);
			}

			this.lastCreate = this.bhg.createTime;
			this.lastFuel = this.bhg.fuel;
			this.lastDamage = this.bhg.damage;
		}
	}

	public void updateProgressBar(int slot, int i) {
		if (slot == 0)
			this.bhg.createTime = i;
		if (slot == 1)
			this.bhg.fuel = i;
		if (slot == 2)
			this.bhg.damage = i;
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int sSlot) {
		ItemStack stack = null;
		Slot slot = (Slot) this.inventorySlots.get(sSlot);

		if (slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();

			if (TileEntityBHG.isItemFuel(stack1)) {
				if (!this.mergeItemStack(stack1, 0, 0, false)) {
					return null;
				}
			}

			if (stack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

			if (stack1.stackSize == stack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(player, stack1);
		}

		return stack;
	}

	public boolean canInteractWith(EntityPlayer player) {
		return this.bhg.isUseableByPlayer(player);
	}
}
