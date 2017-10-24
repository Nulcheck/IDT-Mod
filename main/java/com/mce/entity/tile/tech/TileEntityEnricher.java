package com.mce.entity.tile.tech;

import com.mce.blocks.tech.Enricher;
import com.mce.common.mod_IDT;
import com.mce.handlers.custom_recipes.WelderRecipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityEnricher extends TileEntity implements ISidedInventory {
	private static final int[] slot_fuel = new int[] { 0 };
	private static final int[] slots_input = new int[] { 1, 2 };
	private static final int[] slot_output = new int[] { 3 };

	private String isInvNameLocalized;

	public ItemStack[] slots = new ItemStack[4];

	public int speed = 250;
	public int enrichTime;
	public int burnTime;
	public int currentBurnTime;

	public int damage;
	public final int maxDamage = 16000;

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
		return this.isInvNameLocalized() ? this.ln : "container.enricher";
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

		this.enrichTime = tag.getShort("EnrichTime");
		// this.fuelAmount = tag.getShort("FuelAmount");
		// this.damageAmount = tag.getShort("DamageAmount");

		if (tag.hasKey("CustomName")) {
			this.ln = tag.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		tag.setShort("EnrichTime", (short) this.enrichTime);
		// tag.setShort("FuelAmount", (short) this.fuelAmount);
		// tag.setShort("DamageAmount", (short) this.damageAmount);

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

	public boolean isEnriching() {
		return this.enrichTime > 0;
	}

	public boolean isPowered() {
		return Enricher.isActive;
	}

	public void updateEntity() {
		boolean flag = this.isPowered();
		boolean flag1 = false;

		if (this.isEnriching() && this.isPowered()) {
			this.burnTime--;
			this.damage--;
		}

		if (this.damage > this.maxDamage) {
			this.damage = this.maxDamage;
		}

		if (!this.worldObj.isRemote) {
			if (this.isPowered() && this.canEnrich() && this.checkSlot() && this.damage > 0) {
				this.enrichTime++;

				if (this.enrichTime == this.speed) {
					this.enrichTime = 0;
					this.enrichItem();
					flag1 = true;
				}

				if (this.damage <= 0) {
					this.enrichTime = 0;
				}
			} else {
				this.enrichTime = 0;
			}

			if (flag != this.isPowered()) {
				flag1 = true;
				Enricher.updateState(this.isPowered(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}

		if (flag1) {
			this.onInventoryChanged();
		}
	}

	public void onInventoryChanged() {
	}

	public boolean checkSlot() {
		if (this.slots[0] != null && this.slots[0].getItem() == Item.getItemFromBlock(mod_IDT.EinsteiniumCoreReactor)
				|| this.slots[0].getItem() == Item.getItemFromBlock(mod_IDT.NeptuniumCoreReactor)
				|| this.slots[0].getItem() == Item.getItemFromBlock(mod_IDT.UraniumCoreReactor)
				|| this.slots[0].getItem() == Item.getItemFromBlock(mod_IDT.SuperReactor)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean canEnrich() {
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

	public void enrichItem() {
		if (this.canEnrich() == true) {
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
		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
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
		return this.enrichTime * i / this.speed;
	}

	public int getDamageScaled(int i) {
		return this.damage * i / this.maxDamage;
	}
}
