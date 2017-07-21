package com.mce.container;

import com.mce.container.parts.SlotOutWelder;
import com.mce.entity.tile.tech.TileEntityWelder;
import com.mce.handlers.custom_recipes.WelderRecipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class WelderContainer extends Container {
	private TileEntityWelder welder;
	public int lastCookTime;
	public int lastBurnTime;
	public int lastCurrentBurnTime;

	public WelderContainer(InventoryPlayer player, TileEntityWelder te) {
		this.welder = te;

		this.addSlotToContainer(new Slot(te, 0, 8, 9)); // Fuel
		this.addSlotToContainer(new Slot(te, 1, 44, 36)); // input1
		this.addSlotToContainer(new Slot(te, 2, 74, 36)); // input2
		this.addSlotToContainer(new SlotOutWelder(player.player, te, 3, 136, 35)); // output

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting c) {
		super.addCraftingToCrafters(c);
		c.sendProgressBarUpdate(this, 0, this.welder.cookTime);
		c.sendProgressBarUpdate(this, 1, this.welder.burnTime);
		c.sendProgressBarUpdate(this, 2, this.welder.currentBurnTime);
	}

	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); i++) {
			ICrafting c = (ICrafting) this.crafters.get(i);

			if (this.lastCookTime != this.welder.cookTime) {
				c.sendProgressBarUpdate(this, 0, this.welder.cookTime);
			}

			if (this.lastBurnTime != this.welder.burnTime) {
				c.sendProgressBarUpdate(this, 1, this.welder.burnTime);
			}

			if (this.lastCurrentBurnTime != this.welder.currentBurnTime) {
				c.sendProgressBarUpdate(this, 2, this.welder.currentBurnTime);
			}

			this.lastCookTime = this.welder.cookTime;
			this.lastBurnTime = this.welder.burnTime;
			this.lastCurrentBurnTime = this.welder.currentBurnTime;
		}
	}

	public void updateProgressBar(int slot, int i) {
		if (slot == 0) {
			this.welder.cookTime = i;
		}

		if (slot == 1) {
			this.welder.burnTime = i;
		}

		if (slot == 2) {
			this.welder.currentBurnTime = i;
		}
	}

	// Super advanced achievement shit
	public ItemStack slotClickOutput(int x, int y, int slot, EntityPlayer player) {
		ItemStack stack = null;

		if (slot == 3) {

		}

		return stack;
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int sSlot) {
		ItemStack stack = null;
		Slot slot = (Slot) this.inventorySlots.get(sSlot);

		if (slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();

			// Output
			if (sSlot == 3) {
				// 3 slots, 39, true (furnace)
				if (!this.mergeItemStack(stack1, 4, 40, true)) {
					return null;
				}

				slot.onSlotChange(stack1, stack);
			}
			// Fuel and input(s), if selected slot is not
			else if (sSlot != 0 && sSlot != 1 && sSlot != 2) {
				if (WelderRecipes.welding().getWeldingResult(stack1) != null) {
					if (!this.mergeItemStack(stack1, 2, 3, false)) {
						// 2 input
						return null;
					}

					else if (!this.mergeItemStack(stack1, 1, 3, false)) {
						// 1 input
						return null;
					}
				} else if (TileEntityWelder.isItemFuel(stack1)) {
					if (!this.mergeItemStack(stack1, 0, 3, false)) {
						// 0 fuel, 3 output
						return null;
					}
				} else if (sSlot >= 4 && sSlot < 31) {
					// 4, 31, and 40 is for moving within inv
					if (!this.mergeItemStack(stack1, 31, 40, false)) {
						return null;
					}
				} else if (sSlot >= 31 && sSlot < 40) {
					if (!this.mergeItemStack(stack1, 4, 31, false)) {
						return null;
					}
				}
			} else if (!this.mergeItemStack(stack1, 4, 40, false)) {
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
		return this.welder.isUseableByPlayer(player);
	}
}
