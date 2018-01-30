package com.mce.entity.tile.tech;

import com.mce.blocks.tech.Smelter;
import com.mce.common.mod_IDT;
import com.mce.handlers.custom_recipes.SmelterRecipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

public class TileEntitySmelter extends TileEntity implements ISidedInventory {
	// Slot 0 = fuel; slot 1 = input1; slot 2 = input2; slot 3 = output
	private static final int[] slot_fuel = new int[] { 0 };
	private static final int[] slots_input = new int[] { 1, 2 };
	private static final int[] slot_output = new int[] { 3 };

	private String isInvNameLocalized;
	private String isModeNameLocalized;
	public String modeName;
	// public int mode;

	private ItemStack[] slots = new ItemStack[4];

	// Speed 400 is twice as long as normal furnace
	public int smelterSpeed;
	public int cookTime;
	public int cookDTime;

	public int fuelAmount;
	public final int maxFuelAmount = 150000;

	public int damage;
	public final int maxDamage = 32000;

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

	public boolean isModeNameLocalized() {
		return this.isModeNameLocalized != null && this.ln.length() > 0;
	}

	public String getInvName() {
		return this.isInvNameLocalized() ? this.ln : "container.smelter";
	}

	public String getModeName() {
		return this.isModeNameLocalized() ? this.ln : modeName;
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
		this.fuelAmount = tag.getShort("FuelAmount");
		this.damage = tag.getShort("DamageAmount");

		if (tag.hasKey("CustomName")) {
			this.ln = tag.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		tag.setShort("CookTime", (short) this.cookTime);
		tag.setShort("FuelAmount", (short) this.fuelAmount);
		tag.setShort("DamageAmount", (short) this.damage);
		tag.setShort("MaxDamage", (short) this.maxDamage);
		tag.setShort("SmelterMode", (short) this.smelterSpeed);

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

	public int getDamage() {
		return damage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public String getMode() {
		return modeName;
	}

	public void setDamage(int stored) {
		damage = MathHelper.clamp_int(stored, 0, maxDamage);
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

	public boolean hasFuel() {
		return this.fuelAmount > 0;
	}

	public boolean isSmelting() {
		return this.cookDTime > 0;
	}

	public void updateEntity() {
		boolean flag = this.hasFuel();
		boolean flag1 = false;

		if (this.hasFuel() && this.isSmelting()) {
			this.fuelAmount--;
			this.damage--;
		}

		if (this.damage > this.maxDamage) {
			this.damage = this.maxDamage;
		}

		if (this.fuelAmount > this.maxFuelAmount) {
			this.fuelAmount = this.maxFuelAmount;
		}

		if (!this.worldObj.isRemote) {
			if (this.fuelAmount < this.maxFuelAmount && getItemFuel(this.slots[0]) > 0 && this.damage > 0) {
				this.fuelAmount += getItemFuel(this.slots[0]);

				if (this.slots[0] != null) {
					flag1 = true;
					this.slots[0].stackSize--;

					if (this.slots[0].stackSize == 0) {
						this.slots[0] = this.slots[0].getItem().getContainerItem(this.slots[0]);
					}
				}
			}

			this.detectUpgrade();
			// this.detectUpgradeAndCanSmelt();

			if (this.hasFuel() && this.checkSlot() && this.canSmelt() && this.damage > 0) {
				this.cookTime++;
				this.cookDTime++;

				if (this.cookTime >= this.smelterSpeed) {
					this.cookTime = 0;
					this.smeltItem();
					flag1 = true;
				}

				if (this.cookDTime == 400) {
					this.cookDTime = 0;
				}

				if (this.damage <= 0) {
					this.cookTime = 0;
					this.cookDTime = 0;
				}

			} else {
				this.cookTime = 0;
				this.cookDTime = 0;
			}

			if (flag != this.hasFuel()) {
				flag1 = true;
				Smelter.updateState(this.hasFuel(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		if (flag1) {
			this.onInventoryChanged();
		}
	}

	public void detectUpgradeAndCanSmelt() {
		if (this.canSmelt() && this.damage > 0) {
			detectUpgrade();
		}
	}

	public void detectUpgrade() {
		if (this.slots[0] == null || this.slots[0] != null && this.slots[0].getItem() == Items.bucket
				|| this.slots[0] != null && this.slots[0].getItem() == Items.lava_bucket) {
			this.smelterSpeed = 400;
			this.modeName = "";
		}

		if (this.slots[0] != null && this.slots[0].getItem() == Item.getItemFromBlock(mod_IDT.EinsteiniumCoreReactor)
				|| this.slots[0] != null && this.slots[0].getItem() == Item.getItemFromBlock(mod_IDT.UraniumCoreReactor)
				|| this.slots[0] != null
						&& this.slots[0].getItem() == Item.getItemFromBlock(mod_IDT.NeptuniumCoreReactor)) {
			this.smelterSpeed = 200;
			this.modeName = "container.smelter.nuclear";
			Smelter.updateState(this.hasFuel(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}

		if (this.slots[0] != null && this.slots[0].getItem() == Item.getItemFromBlock(mod_IDT.SuperReactor)) {
			this.smelterSpeed = 150;
			this.modeName = "container.smelter.nuclear.super";
			Smelter.updateState(this.hasFuel(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}

		if (this.slots[0] != null && this.slots[0].getItem() == mod_IDT.MagneticUpgrade) {
			this.smelterSpeed = 60;
			this.modeName = "container.smelter.induction";
			Smelter.updateState(this.hasFuel(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}
	}

	private void onInventoryChanged() {
	}

	public boolean checkUpgrade() {
		if (this.slots[0] == null || this.slots[0] != null && this.slots[0].getItem() == Items.bucket
				|| this.slots[0] != null && this.slots[0].getItem() == Items.lava_bucket) {
			return false;
		}

		if (this.slots[0] != null && this.slots[0].getItem() == Item.getItemFromBlock(mod_IDT.EinsteiniumCoreReactor)
				|| this.slots[0] != null && this.slots[0].getItem() == Item.getItemFromBlock(mod_IDT.UraniumCoreReactor)
				|| this.slots[0] != null
						&& this.slots[0].getItem() == Item.getItemFromBlock(mod_IDT.NeptuniumCoreReactor)) {
			return true;
		}

		if (this.slots[0] != null && this.slots[0].getItem() == Item.getItemFromBlock(mod_IDT.SuperReactor)) {
			return true;
		}

		if (this.slots[0] != null && this.slots[0].getItem() == mod_IDT.MagneticUpgrade) {
			return true;
		}

		return false;
	}

	public boolean checkSlot() {
		if (this.slots[1] != null && this.slots[2] != null) {
			ItemStack stack1 = SmelterRecipes.instance().getInput1(this.slots[1]);
			ItemStack stack2 = SmelterRecipes.instance().getInput2(this.slots[2]);

			if (this.slots[1].getItem() == mod_IDT.Carbon && this.slots[2].getItem() == mod_IDT.VPowder
					&& !checkUpgrade()) {
				return false;
			}

			else if (this.slots[1] == stack1 && this.slots[2] == stack2) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private boolean canSmelt() {
		if (this.slots[1] == null && this.slots[2] == null || (this.slots[1] == null || this.slots[2] == null)) {
			return false;
		} else {
			ItemStack stack = SmelterRecipes.instance().getOutput(this.slots[2]);

			if (this.slots[1] == null && this.slots[2] == null)
				return false;
			if (this.slots[3] == null)
				return true;
			if (this.checkSlot() == true) {
				if (!this.slots[3].isItemEqual(stack)) {
					return false;
				}
			}
			int result = this.slots[3].stackSize + stack.stackSize;
			return (result <= getInventoryStackLimit() && result <= this.slots[2].getMaxStackSize());
		}
	}

	public void smeltItem() {
		if (this.canSmelt() == true) {
			ItemStack stack = SmelterRecipes.instance().getOutput(this.slots[2]);

			if (this.slots[3] == null) {
				this.slots[3] = stack.copy();
			}

			else if (this.slots[3].isItemEqual(stack)) {
				this.slots[3].stackSize += stack.stackSize;
			}

			--this.slots[1].stackSize;
			--this.slots[2].stackSize;

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
			if (stack.getItem() == Items.lava_bucket) {
				return 20000;
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

	public int getFuelRemainingScaled(int i) {
		return this.fuelAmount * i / this.maxFuelAmount;
	}

	public int getDamageScaled(int i) {
		return this.damage * i / this.maxDamage;
	}

	public int getCookProgressScaled(int i) {
		detectUpgrade();
		return this.cookTime * i / this.smelterSpeed;
	}
}
