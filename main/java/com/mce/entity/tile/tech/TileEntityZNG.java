package com.mce.entity.tile.tech;

import com.mce.blocks.ModBlocks.ZNG;
import com.mce.common.mod_IDT;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityZNG extends TileEntity implements ISidedInventory {
	// Slot 0 is just the input. There is no output item thing.
	private static final int[] input_slot = new int[] { 0 };

	private String isInvNameLocalized;
	private String getInvName;

	private ItemStack[] slots = new ItemStack[2];

	// Specs
	public int fuel;
	public final int maxFuel = 50000;

	public int speed = 50;
	public int burnTime;
	public final int maxTime = 50;

	public int damage;
	public final int maxDamage = 60000;

	public int getSizeInv() {
		return this.slots.length;
	}

	private String ln;

	public void setGuiDisplayName(String dn) {
		this.ln = dn;
	}

	public boolean isInvNameLocalized() {
		return this.isInvNameLocalized != null && this.ln.length() > 0;
	}

	public String getInvName() {
		return this.isInvNameLocalized() ? this.ln : "container.zng";
	}

	public int getSizeInventory() {
		return 0;
	}

	public ItemStack getStackInSlot(int i) {
		return this.slots[i];
	}

	public ItemStack decrStackSize(int i, int j) {
		if (this.slots[i] != null) {
			ItemStack stack;

			if (this.slots[i].stackSize <= j) {
				stack = this.slots[i];
				this.slots[i] = null;
				return stack;
			} else {
				stack = this.slots[i].splitStack(j);

				if (this.slots[i].stackSize == 0) {
					this.slots[i] = null;
				}

				return stack;
			}

		}
		return null;
	}

	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.slots[i] != null) {
			ItemStack stack = this.slots[i];
			this.slots[i] = null;
			return stack;
		}

		return null;
	}

	public void setInventorySlotContents(int i, ItemStack stack) {
		this.slots[i] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
		}
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);

		NBTTagList list = tag.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInv()];

		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound comp = (NBTTagCompound) list.getCompoundTagAt(i);
			byte b = comp.getByte("Slot");

			if (b >= 0 && b < this.slots.length) {
				this.slots[b] = ItemStack.loadItemStackFromNBT(comp);
			}
		}

		ZNG.isActive = tag.getBoolean("Active");
		this.fuel = tag.getShort("Fuel");
		this.damage = tag.getShort("DamageAmount");

		if (tag.hasKey("CustomName")) {
			this.ln = tag.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		tag.setBoolean("Active", ZNG.isActive);
		tag.setShort("Fuel", (short) this.fuel);
		tag.setShort("DamageAmount", (short) this.damage);

		NBTTagList list = new NBTTagList();

		for (int i = 0; i < this.slots.length; i++) {
			if (this.slots[i] != null) {
				NBTTagCompound comp = new NBTTagCompound();
				comp.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(comp);
				list.appendTag(comp);
			}
		}

		tag.setTag("Items", list);

		if (this.isInvNameLocalized()) {
			tag.setString("CustomName", this.ln);
		}
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false
				: player.getDistanceSq((double) this.xCoord + .5d, (double) this.yCoord + .5d,
						(double) this.zCoord + .5d) <= 64d;
	}

	public void openChest() {
	}

	public void closeChest() {
	}

	public boolean hasFuel() {
		return this.fuel > 0;
	}

	public boolean isPowering() {
		return this.burnTime > 0;
	}

	public boolean isActive() {
		return ZNG.isActive;
	}

	public void updateEntity() {
		boolean flag = this.hasFuel();
		boolean flag1 = false;

		if (this.hasFuel() && this.isPowering() && this.isActive()) {
			this.fuel--;
			this.damage--;
		}

		if (this.damage > this.maxDamage) {
			this.damage = this.maxDamage;
		}

		if (this.fuel > this.maxFuel) {
			this.fuel = this.maxFuel;
		}

		if (this.burnTime > this.maxTime) {
			this.burnTime = this.maxTime;
		}

		if (!this.worldObj.isRemote) {
			if (this.fuel < this.maxFuel && getItemFuel(this.slots[0]) > 0 && this.damage > 0) {
				this.fuel += getItemFuel(this.slots[0]);

				if (this.slots[0] != null) {
					flag1 = true;
					this.slots[0].stackSize--;

					if (this.slots[0].stackSize == 0) {
						this.slots[0] = this.slots[0].getItem().getContainerItem(this.slots[0]);
					}
				}
			}

			if (this.hasFuel() && this.isActive() && this.damage > 0) {
				this.burnTime++;

				if (this.burnTime == this.speed) {
					this.burnTime = 0;
					this.power();
					flag1 = true;
				}

				if (this.damage <= 0) {
					this.burnTime = 0;
				}
			} else {
				this.burnTime = 0;
			}

			if (flag != this.hasFuel()) {
				flag1 = true;
				ZNG.updateState(this.hasFuel(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		if (flag1) {
			this.onInventoryChanged();
		}
	}

	public void onInventoryChanged() {
	}

	public boolean checkSlot() {
		if (this.slots[0] != null && this.slots[0].getItem() == mod_IDT.ZimphnodeBar) {
			return true;
		} else {
			return false;
		}
	}

	public void power() {
		// idk how to do this yet.
		// output zPower.
	}

	public static int getItemFuel(ItemStack stack) {
		if (stack == null) {
			return 0;
		} else {
			if (stack.getItem() == mod_IDT.ZimphnodeBar) {
				return 500;
			}

			if (stack.getItem() == Item.getItemFromBlock(mod_IDT.ZimphnodeBlock)) {
				return 500 * 9;
			}
			return 0;
		}
	}

	public static boolean isItemFuel(ItemStack stack) {
		return getItemFuel(stack) > 0;
	}

	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return i == 2 ? false : (i == 1 ? isItemFuel(itemstack) : true);
	}

	public int[] getAccessibleSlotsFromSide(int side) {
		// return side == 0 ? input_slot : (side == 1 ? input_slot :
		// input_slot);
		return input_slot;
	}

	public boolean canInsertItem(int i, ItemStack stack, int j) {
		return this.isItemValidForSlot(i, stack);
	}

	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 0 || i != 1;
	}

	public String getInventoryName() {
		return null;
	}

	public boolean hasCustomInventoryName() {
		return false;
	}

	public void openInventory() {
	}

	public void closeInventory() {
	}

	public int getFuelTimeRemainingScaled(int i) {
		return this.fuel * i / this.maxFuel;
	}

	public int getDamageScaled(int i) {
		return this.damage * i / this.maxDamage;
	}
}