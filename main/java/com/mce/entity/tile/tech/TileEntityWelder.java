package com.mce.entity.tile.tech;

import com.mce.blocks.ModBlocks.Welder;
import com.mce.common.mod_IDT;
import com.mce.handlers.custom_recipes.WelderRecipes;
import com.mce.items.ModItems.PropaneTank;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityWelder extends TileEntity implements ISidedInventory {
	private static final int[] slot_fuel = new int[] { 0 };
	private static final int[] slots_input = new int[] { 1, 2 };
	private static final int[] slot_output = new int[] { 3 };

	private String isInvNameLocalized;

	public ItemStack[] slots = new ItemStack[4];

	public int speed = 160;
	public int cookTime;
	public int burnTime;
	public int currentBurnTime;

	public int getSizeInv() {
		return this.slots.length;
	}

	public String ln;

	public void setGuiDisplayName(String dn) {
		this.ln = dn;
	}

	public boolean isInvNameLocalized() {
		return this.isInvNameLocalized != null && this.ln.length() > 0;
	}

	public String getInvName() {
		return this.isInvNameLocalized() ? this.ln : "container.welder";
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

		this.cookTime = tag.getShort("CookTime");
		this.burnTime = tag.getShort("BurnTime");
		this.currentBurnTime = tag.getShort("CBurnTime");

		if (tag.hasKey("CustomName")) {
			this.ln = tag.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		tag.setShort("CookTime", (short) this.cookTime);
		tag.setShort("BurnTime", (short) this.burnTime);
		tag.setShort("CBurnTime", (short) this.currentBurnTime);

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
				: player.getDistanceSq((double) this.xCoord + .5D, (double) this.yCoord + .5D,
						(double) this.zCoord + .5D) <= 64D;
	}

	public void openChest() {
	}

	public void closeChest() {
	}

	public boolean isBurning() {
		return this.burnTime > 0;
	}

	public boolean isWelding() {
		return this.cookTime > 0;
	}

	public void updateEntity() {
		boolean flag = this.isBurning();
		boolean flag1 = false;

		if (this.isWelding() && this.isBurning()) {
			this.burnTime--;
		}

		if (!this.worldObj.isRemote) {
			if (this.burnTime != 0 || this.slots[0] != null && this.slots[1] != null && this.slots[2] != null) {
				if (this.burnTime == 0 && this.canWeld()) {
					this.currentBurnTime = this.burnTime = getItemFuel(this.slots[0]);

					if (this.burnTime > 0) {
						flag1 = true;

						if (this.slots[0] != null) {
							this.slots[0].stackSize--;

							if (this.slots[0].stackSize == 0) {
								PropaneTank.containerItem = true;
								this.slots[0] = this.slots[0].getItem().getContainerItem(this.slots[0]);
							}
						}
					}
				}

				if (this.isBurning() && this.canWeld() && this.checkSlot()) {
					this.cookTime++;

					if (this.cookTime == this.speed) {
						this.cookTime = 0;
						this.weldItem();
						flag1 = true;
					}
				} else {
					this.cookTime = 0;
				}
			}

			if (flag != this.isBurning()) {
				flag1 = true;
				Welder.updateState(this.isBurning(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		if (flag1) {
			this.onInventoryChanged();
		}
	}

	public void onInventoryChanged() {
	}

	public boolean checkSlot() {
		if (this.slots[1] != null && this.slots[2] != null) {
			ItemStack stack1 = WelderRecipes.welding().getInput1(this.slots[1]);
			ItemStack stack2 = WelderRecipes.welding().getInput2(this.slots[2]);

			if (this.slots[1] == stack1 && this.slots[2] == stack2) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean canWeld() {
		if (this.slots[1] == null && this.slots[2] == null || (this.slots[1] == null | this.slots[2] == null)) {
			return false;
		} else {
			ItemStack stack = WelderRecipes.welding().getWeldingResult(this.slots[2]);

			if (this.slots[1] == null && this.slots[2] == null || (this.slots[1] == null || this.slots[2] == null)) {
				return false;
			}

			if (this.slots[3] == null) {
				return true;
			}

			if (!this.slots[3].isItemEqual(stack)) {
				return false;
			}

			int result = this.slots[3].stackSize + stack.stackSize;

			return (result <= getInventoryStackLimit() && result <= stack.getMaxStackSize());
		}
	}

	public void weldItem() {
		if (this.canWeld() == true) {
			ItemStack stack = WelderRecipes.welding().getWeldingResult(this.slots[2]);

			if (this.slots[3] == null) {
				this.slots[3] = stack.copy();
			}

			else if (this.slots[3].isItemEqual(stack)) {
				this.slots[3].stackSize += stack.stackSize;
			}

			this.slots[1].stackSize--;
			this.slots[2].stackSize--;

			if (this.slots[1].stackSize <= 0) {
				this.slots[1] = null;
			}

			if (this.slots[2].stackSize <= 0) {
				this.slots[2] = null;
			}
		}
	}

	public static int getItemFuel(ItemStack stack) {
		if (stack == null) {
			return 0;
		} else {
			if (stack.getItem() == mod_IDT.PropaneTank) {
				return 2000;
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
		return side == 0 ? slot_fuel : (side == 1 ? slots_input : slot_output);
	}

	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
	}

	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 0 || i != 1 || itemstack.getItem() == mod_IDT.EmptyTank;
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

	public int getCookProgressScaled(int i) {
		return this.cookTime * i / this.speed;
	}

	public int getFuelRemainingScaled(int i) {
		if (this.currentBurnTime == 0) {
			this.currentBurnTime = this.speed;
		}

		return this.burnTime * i / this.currentBurnTime;
	}
}
