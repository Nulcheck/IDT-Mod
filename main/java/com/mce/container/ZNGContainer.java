package com.mce.container;

import com.mce.entity.tile.tech.TileEntityZNG;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ZNGContainer extends Container {
	private TileEntityZNG zng;
	public int lastBurn;
	public int lastFuel;
	public int lastDam;

	public ZNGContainer(InventoryPlayer player, TileEntityZNG entity) {
		this.zng = entity;

		this.addSlotToContainer(new Slot(entity, 0, 80, 35)); // Input

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
		craft.sendProgressBarUpdate(this, 0, this.zng.fuel);
		craft.sendProgressBarUpdate(this, 1, this.zng.damage);
		craft.sendProgressBarUpdate(this, 2, this.zng.burnTime);
	}

	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); i++) {
			ICrafting craft = (ICrafting) this.crafters.get(i);

			if (this.lastFuel != this.zng.fuel) {
				craft.sendProgressBarUpdate(this, 0, this.zng.fuel);
			}

			if (this.lastDam != this.zng.damage) {
				craft.sendProgressBarUpdate(this, 1, this.zng.damage);
			}
			
			if(this.lastBurn != this.zng.burnTime){
				craft.sendProgressBarUpdate(this, 2, this.zng.burnTime);
			}

			this.lastFuel = this.zng.fuel;
			this.lastDam = this.zng.damage;
			this.lastBurn = this.zng.burnTime;
		}
	}

	// Don't know what par2 is
	public void updateProgressBar(int slot, int i) {
		if (slot == 0) {
			this.zng.fuel = i;
		}

		if (slot == 1) {
			this.zng.damage = i;
		}
		
		if(slot == 2){
			this.zng.burnTime = i;
		}
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int sSlot) {
		ItemStack stack = null;
		Slot slot = (Slot) this.inventorySlots.get(sSlot);

		if (slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();

			if (TileEntityZNG.isItemFuel(stack1)) {
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
		return this.zng.isUseableByPlayer(player);
	}
}
