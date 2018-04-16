package com.mce.container;

import com.mce.common.mod_IDT;
import com.mce.container.parts.SlotOutSmelter;
import com.mce.entity.tile.tech.TileEntitySmelter;
import com.mce.handlers.custom_recipes.SmelterRecipes;
import com.mce.handlers.custom_recipes.SmelterRecipes.DoubleInputHandler;
import com.mce.handlers.registers.AchRegistry;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SmelterContainer extends Container {
	private TileEntitySmelter smelter;
	public int lastFuelAmount;
	public int lastCookTime;
	public int lastDamAmount;

	public SmelterContainer(InventoryPlayer player, TileEntitySmelter entity) {
		this.smelter = entity;

		this.addSlotToContainer(new Slot(entity, 0, 8, 64)); // Fuel
		this.addSlotToContainer(new Slot(entity, 1, 44, 36)); // input1
		this.addSlotToContainer(new Slot(entity, 2, 74, 36)); // input2
		this.addSlotToContainer(new SlotOutSmelter(player.player, entity, 3, 136, 35)); // output

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting crafting) {
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, this.smelter.cookTime);
		crafting.sendProgressBarUpdate(this, 1, this.smelter.fuelAmount);
		crafting.sendProgressBarUpdate(this, 2, this.smelter.damage);
	}

	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for (int i = 0; i < this.crafters.size(); i++) {
			ICrafting crafting = (ICrafting) this.crafters.get(i);

			if (this.lastCookTime != this.smelter.cookTime) {
				crafting.sendProgressBarUpdate(this, 0, this.smelter.cookTime);
			}

			if (this.lastFuelAmount != this.smelter.fuelAmount) {
				crafting.sendProgressBarUpdate(this, 1, this.smelter.fuelAmount);
			}

			if (this.lastDamAmount != this.smelter.damage) {
				crafting.sendProgressBarUpdate(this, 2, this.smelter.damage);
			}

			this.lastCookTime = this.smelter.cookTime;
			this.lastFuelAmount = this.smelter.fuelAmount;
			this.lastDamAmount = this.smelter.damage;
		}
	}

	// Not sure what par2 really is...
	public void updateProgressBar(int slot, int i) {
		if (slot == 0)
			this.smelter.cookTime = i;
		if (slot == 1)
			this.smelter.fuelAmount = i;
		if (slot == 2)
			this.smelter.damage = i;
	}

	// Super Custom Achievement shit
	public ItemStack slotClickOutput(int x, int y, int slot, EntityPlayer player) {
		ItemStack stack = null;

		if (slot == 3) {
			if (player.inventory.hasItem(mod_IDT.SteelIngot)) {
				player.addStat(AchRegistry.steelIngot, 1);
			}
		}

		return stack;
	}

	// Shift click
	/*public ItemStack transferStackInSlot(EntityPlayer player, int sSlot) {
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
			DoubleInputHandler stackOut = DoubleInputHandler.getOutput();
			
			// Fuel and input(s), if selected slot is not
			else if (sSlot != 0 && sSlot != 1 && sSlot != 2) {
				if (SmelterRecipes.instance().getOutput(stack1) != null) {
					if (!this.mergeItemStack(stack1, 2, 3, false)) {
						// 2 input
						return null;
					}

					else if (!this.mergeItemStack(stack1, 1, 3, false) && stack1.getItem().equals(Items.coal)) {
						// 1 input
						return null;
					}
				} else if (TileEntitySmelter.isItemFuel(stack1)) {
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
	}*/

	public boolean canInteractWith(EntityPlayer player) {
		return this.smelter.isUseableByPlayer(player);
	}
}