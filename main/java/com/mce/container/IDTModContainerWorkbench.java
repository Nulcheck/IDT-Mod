package com.mce.container;

import com.mce.common.mod_IDT;
import com.mce.util.ModCraftingManager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IDTModContainerWorkbench extends Container {
	/** The crafting matrix inventory (3x3). */
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
	public IInventory craftResult = new InventoryCraftResult();
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;

	public IDTModContainerWorkbench(InventoryPlayer player, World world, int x, int y, int z) {
		this.worldObj = world;
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.addSlotToContainer(new SlotCrafting(player.player, this.craftMatrix, this.craftResult, 0, 124, 35));
		int l;
		int i1;

		for (l = 0; l < 3; ++l) {
			for (i1 = 0; i1 < 3; ++i1) {
				this.addSlotToContainer(new Slot(this.craftMatrix, i1 + l * 3, 30 + i1 * 18, 17 + l * 18));
			}
		}

		for (l = 0; l < 3; ++l) {
			for (i1 = 0; i1 < 9; ++i1) {
				this.addSlotToContainer(new Slot(player, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
			}
		}

		for (l = 0; l < 9; ++l) {
			this.addSlotToContainer(new Slot(player, l, 8 + l * 18, 142));
		}

		this.onCraftMatrixChanged(this.craftMatrix);
	}

	/**
	 * Callback for when the crafting matrix is changed.
	 */
	public void onCraftMatrixChanged(IInventory inv) {
		this.craftResult.setInventorySlotContents(0,
				ModCraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
	}

	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);

		if (!this.worldObj.isRemote) {
			for (int i = 0; i < 9; ++i) {
				ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

				if (itemstack != null) {
					player.dropPlayerItemWithRandomChoice(itemstack, false);
				}
			}
		}
	}

	public boolean canInteractWith(EntityPlayer player) {
		return this.worldObj.getBlock(this.posX, this.posY, this.posZ) != mod_IDT.IDTCraftingTable ? false
				: player.getDistanceSq((double) this.posX + 0.5D, (double) this.posY + 0.5D,
						(double) this.posZ + 0.5D) <= 64.0D;
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int selSlot) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(selSlot);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (selSlot == 0) {
				if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			} else if (selSlot >= 10 && selSlot < 37) {
				if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
					return null;
				}
			} else if (selSlot >= 37 && selSlot < 46) {
				if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.stackSize == itemstack.stackSize) {
				return null;
			}

			slot.onPickupFromSlot(player, itemstack1);
		}

		return itemstack;
	}

	public boolean func_94530_a(ItemStack stack, Slot slot) {
		return slot.inventory != this.craftResult && super.func_94530_a(stack, slot);
	}
}