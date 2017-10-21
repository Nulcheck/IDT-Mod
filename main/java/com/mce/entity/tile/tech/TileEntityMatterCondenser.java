package com.mce.entity.tile.tech;

import com.mce.api.rf.IDTRFTech;
import com.mce.blocks.ModBlocks.MatterCondenser;
import com.mce.common.mod_IDT;
import com.mce.handlers.custom_recipes.MatterCondenserRecipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityMatterCondenser extends IDTRFTech implements ISidedInventory {
	// Slot 0 = input; slot 1 = output
	private static final int[] input_slot = new int[] { 0 };
	private static final int[] output_slot = new int[] { 1 };
	private static final int[] upgrade_slot = new int[] { 2 };

	private String isInvNameLocalized;

	private ItemStack[] slots = new ItemStack[3];

	// Speed is really slow, 30 minutes
	public int speed;
	public int cTime;
	public int cDTime;
	public int burnTime;

	public int damage;
	public final int maxDamage = 96000;
	public static int capacity = 2000000;

	public TileEntityMatterCondenser() {
		super(capacity, 1000);
	}

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
		return this.isInvNameLocalized() ? this.ln : "container.matter.condenser";
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

		this.cTime = tag.getShort("Progress");
		this.damage = tag.getShort("Damage");

		if (tag.hasKey("CustomName")) {
			this.ln = tag.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		tag.setShort("Progress", (short) this.cTime);
		tag.setShort("Damage", (short) this.damage);

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

	public boolean isCondensing() {
		return this.cDTime > 0;
	}

	public boolean isPowered() {
		return this.hasEnergy(energy.getStored());
	}

	public int getEnergyNeeded() {
		return 500;
	}

	public void updateEntity() {
		boolean flag = this.isPowered();
		boolean flag1 = false;

		if (this.isCondensing() && this.isPowered()) {
			this.burnTime--;
			this.damage--;
		}

		if (this.damage > this.maxDamage) {
			this.damage = this.maxDamage;
		}

		if (!this.worldObj.isRemote) {

			if (this.isPowered() && (this.damage > 0)) {
				if (this.canCondense() && this.checkSlot()) {
					if (this.consumeEnergy(this.getEnergyNeeded())) {
						this.cTime++;
						this.cDTime++;

						if (this.cTime >= this.speed) {
							this.cTime = 0;
							this.cDTime = 0;
							this.condenseItem();

							flag1 = true;
						}

						if (this.cDTime == 36000) {
							this.cDTime = 0;
						}

						if (this.damage <= 0) {
							this.cTime = 0;
							this.cDTime = 0;
						}
					}
				} else {
					this.cTime = 0;
					this.cDTime = 0;
				}
			}

			if (flag != this.isPowered()) {
				flag1 = true;
				MatterCondenser.updateState(this.isPowered(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}

		if (flag1) {
			this.onInventoryChanged();
		}
	}

	private void onInventoryChanged() {
	}

	public void detectUpgradeAndCondense() {
		if (this.canCondense() && this.damage > 0) {
			detectUpgrade();
		}
	}

	public void detectUpgrade() {
		if (this.slots[2] == null) {
			this.speed = 36000; // 30 min
		}

		if (this.slots[2] != null && this.slots[2].getItem() == mod_IDT.QCUpgrade) {
			this.speed = 12000; // 10 min (I think)
			MatterCondenser.updateState(this.isPowered(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}
	}

	public boolean checkSlot() {
		ItemStack stack = MatterCondenserRecipes.condensing().getInput(this.slots[0]);
		if (this.slots[0] == stack) {
			return true;
		} else {
			return false;
		}
	}

	private boolean canCondense() {
		if (this.slots[0] == null) {
			return false;
		} else {
			ItemStack stack = MatterCondenserRecipes.condensing().getCondensingResult(this.slots[0]);

			if (this.slots[0] == null) {
				return false;
			}

			if (this.slots[0].stackSize != 64) {
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

	public void condenseItem() {
		if (this.canCondense() == true) {
			ItemStack stack = MatterCondenserRecipes.condensing().getCondensingResult(this.slots[0]);

			if (this.slots[1] == null) {
				this.slots[1] = stack.copy();
			}

			else if (this.slots[1].isItemEqual(stack)) {
				this.slots[1].stackSize += stack.stackSize;
			}

			this.slots[0].stackSize -= 64;

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
		return this.cTime * i / this.speed;
	}

	public int getDamageScaled(int i) {
		return this.damage * i / this.maxDamage;
	}
}