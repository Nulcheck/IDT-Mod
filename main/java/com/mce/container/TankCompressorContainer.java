package com.mce.container;

import com.mce.entity.tile.tech.TileEntityTankCompressor;
import com.mce.handlers.custom_recipes.TankCompressorRecipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

public class TankCompressorContainer extends Container {
	private TileEntityTankCompressor tankCompressor;
	public int lastCompTime;
	public int lastDam;

	public TankCompressorContainer(InventoryPlayer player, TileEntityTankCompressor entity) {
		this.tankCompressor = entity;

		this.addSlotToContainer(new Slot(entity, 0, 56, 35)); // Input
		this.addSlotToContainer(new SlotFurnace(player.player, entity, 1, 116, 35)); // Output

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
		craft.sendProgressBarUpdate(this, 0, this.tankCompressor.compTime);
		craft.sendProgressBarUpdate(this, 1, this.tankCompressor.damage);
	}

	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); i++) {
			ICrafting craft = (ICrafting) this.crafters.get(i);

			if (this.lastCompTime != this.tankCompressor.compTime) {
				craft.sendProgressBarUpdate(this, 0, this.tankCompressor.compTime);
			}

			if (this.lastDam != this.tankCompressor.damage) {
				craft.sendProgressBarUpdate(this, 1, this.tankCompressor.damage);
			}

			this.lastCompTime = this.tankCompressor.compTime;
			this.lastDam = this.tankCompressor.damage;
		}
	}

	// Not sure what par2 is
	public void updateProgressBar(int slot, int i) {
		if (slot == 0) {
			this.tankCompressor.compTime = i;
		}

		if (slot == 1) {
			this.tankCompressor.damage = i;
		}
	}

	// Shift click
	public ItemStack transferStackInSlot(EntityPlayer player, int sSlot) {
		ItemStack stack = null;
		Slot slot = (Slot) this.inventorySlots.get(sSlot);

		if (slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();

			// Output
			if (sSlot == 1) {
				// 3 slots, 39, true (furnace)
				if (!this.mergeItemStack(stack1, 2, 38, true)) {
					return null;
				}

				slot.onSlotChange(stack1, stack);
			}
			// Fuel and input(s), if selected slot is not
			else if (sSlot != 0) {
				if (TankCompressorRecipes.compressing().getCompressingResult(stack1) != null) {
					if (!this.mergeItemStack(stack1, 0, 0, false)) {
						// 0 input
						return null;
					}
				} else if (sSlot >= 2 && sSlot < 29) {
					// 2, 29, and 38 is for moving within inv
					if (!this.mergeItemStack(stack1, 29, 38, false)) {
						return null;
					}
				} else if (sSlot >= 29 && sSlot < 40) {
					if (!this.mergeItemStack(stack1, 2, 29, false)) {
						return null;
					}
				}
			} else if (!this.mergeItemStack(stack1, 2, 38, false)) {
				// from in or fuel to inv
				return null;
			}

			// left over
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
		return this.tankCompressor.isUseableByPlayer(player);
	}
}
