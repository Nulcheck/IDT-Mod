package com.mce.entity.tile.tech;

import com.mce.blocks.ModBlocks.IndustrialCutter;
import com.mce.common.mod_IDT;
import com.mce.handlers.custom_recipes.IndustrialCutterRecipes;

import cofh.api.energy.EnergyStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityIndustrialCutter extends TileEntity implements ISidedInventory {
	// Slot 0 = input; slot 1 = output
	private static final int[] input_slot = new int[] { 0 };
	private static final int[] output_slot = new int[] { 1 };
	private static final int[] upgrade_slot = new int[] { 2 };

	private String isInvNameLocalized;

	private ItemStack[] slots = new ItemStack[3];

	// Cutter Specs
	// Speed is a little slower than a furnace
	public int cuttingSpeed;
	public int cutTime;
	public int cutDTime;
	public int burnTime;
	public boolean isPowered;

	public int damage;
	public final int maxDamage = 16000;

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
		return this.isInvNameLocalized() ? this.ln : "container.cutter";
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

	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		tag.setShort("CutTime", (short) this.cutTime);
		tag.setBoolean("Powered", IndustrialCutter.isActive);
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

		this.cutTime = tag.getShort("CutTime");
		IndustrialCutter.isActive = tag.getBoolean("Powered");
		this.damage = tag.getShort("DamageAmount");

		if (tag.hasKey("CustomName")) {
			this.ln = tag.getString("CustomName");
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

	public boolean isCutting() {
		return this.cutDTime > 0;
	}

	public boolean isPowered() {
		return IndustrialCutter.isActive;
	}

	public void updateEntity() {
		boolean flag = this.isPowered();
		boolean flag1 = false;

		if (isCutting() && this.isPowered()) {
			this.burnTime--;
			this.damage--;
		}

		if (this.damage > this.maxDamage) {
			this.damage = this.maxDamage;
		}

		if (!this.worldObj.isRemote) {
			this.detectUpgradeAndCut();

			if (this.isPowered() && this.canCut() && this.checkSlot()
					&& this.damage > 0) {
				this.cutTime++;
				this.cutDTime++;

				if (this.cutTime >= this.cuttingSpeed) {
					this.cutTime = 0;
					this.cutItem();
					flag1 = true;
				}

				if (this.cutDTime == 300) {
					this.cutDTime = 0;
				}

				if (this.damage <= 0) {
					this.cutTime = 0;
					this.cutDTime = 0;
				}
			} else {
				this.cutTime = 0;
				this.cutDTime = 0;
			}

			if (flag != this.isPowered()) {
				flag1 = true;
				IndustrialCutter.updateState(this.isPowered(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}

		if (flag1) {
			this.onInventoryChanged();
		}
	}

	private void onInventoryChanged() {
	}

	public void detectUpgradeAndCut() {
		if (this.canCut() && this.damage > 0) {
			detectUpgrade();
		}
	}

	public void detectUpgrade() {
		if (this.slots[2] == null) {
			this.cuttingSpeed = 300;
		}

		if (this.slots[2] != null && this.slots[2].getItem() == mod_IDT.LaserUpgrade) {
			this.cuttingSpeed = 120;
			IndustrialCutter.updateState(this.isPowered(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}
	}

	public boolean checkSlot() {
		ItemStack stack = IndustrialCutterRecipes.cutting().getInput(this.slots[0]);
		if (this.slots[0] == stack) {
			return true;
		} else {
			return false;
		}
	}

	private boolean canCut() {
		if (this.slots[0] == null) {
			return false;
		} else {
			ItemStack stack = IndustrialCutterRecipes.cutting().getCuttingResult(this.slots[0]);

			if (this.slots[0] == null) {
				return false;
			}

			if (this.slots[1] == null) {
				return true;
			}

			if (!this.slots[1].isItemEqual(stack)) {
				return false;
			}

			int result = this.slots[1].stackSize + stack.stackSize;
			return (result <= getInventoryStackLimit() && result <= stack.getMaxStackSize());
		}
	}

	public void cutItem() {
		if (this.canCut() == true) {
			ItemStack stack = IndustrialCutterRecipes.cutting().getCuttingResult(this.slots[0]);

			if (this.slots[1] == null) {
				this.slots[1] = stack.copy();
			}

			else if (this.slots[1].isItemEqual(stack)) {
				this.slots[1].stackSize += stack.stackSize;
			}

			this.slots[0].stackSize--;

			if (this.slots[0].stackSize <= 0) {
				this.slots[0] = null;
			}
		}
	}

	public boolean isItemValidForSlot(int i, ItemStack stack) {
		return i == 1 ? false : true;
	}

	public int[] getAccessibleSlotsFromSide(int side) {
		return side == 0 ? input_slot : side == 1 ? output_slot : null;
	}

	public boolean canInsertItem(int i, ItemStack stack, int j) {
		return this.isItemValidForSlot(i, stack);
	}

	public boolean canExtractItem(int i, ItemStack stack, int j) {
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

	public int getCookProgressScaled(int i) {
		detectUpgrade();
		return this.cutTime * i / this.cuttingSpeed;
	}

	public int getDamageScaled(int i) {
		return this.damage * i / this.maxDamage;
	}
}