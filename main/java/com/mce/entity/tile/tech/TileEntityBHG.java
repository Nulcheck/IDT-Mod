package com.mce.entity.tile.tech;

import com.mce.blocks.ModBlocks.BHG;
import com.mce.common.mod_IDT;
import com.mce.handlers.custom_recipes.BHGRecipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBHG extends TileEntity implements IInventory {
	// Slot 0 = input
	private static final int[] input_slot = new int[] { 0 };

	private String isInvNameLocalized;
	private ItemStack[] slots = new ItemStack[1];

	// Specs
	public int speed = 600;
	public boolean isPowered;

	public int createTime;
	public final int minTime = 0;
	public final int maxTime = 600;

	public int fuel;
	public final int maxFuel = 500000;

	public int damage;
	public final int maxDamage = 96000;

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
		return this.isInvNameLocalized() ? this.ln : "container.bhg";
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

		tag.setShort("CreateTime", (short) this.createTime);
		tag.setShort("Fuel", (short) this.fuel);
		tag.setShort("DamageAmount", (short) this.damage);
		tag.setBoolean("Powered", BHG.isActive);

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

		this.createTime = tag.getShort("CreateTime");
		this.fuel = tag.getShort("Fuel");
		this.damage = tag.getShort("DamageAmount");
		BHG.isActive = tag.getBoolean("Powered");

		if (tag.hasKey("CustomName")) {
			this.ln = tag.getString("CustomName");
		}
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false
				: player.getDistanceSq((double) this.xCoord + 0.5d, (double) this.yCoord + 0.5d,
						(double) this.zCoord + 0.5d) <= 64d;
	}

	public void openChest() {
	}

	public void closeChest() {
	}

	public boolean isCreating() {
		return this.createTime > 0;
	}

	public boolean hasFuel() {
		return this.fuel > 0;
	}

	public boolean isPowered() {
		return BHG.isActive;
	}

	public void updateEntity() {
		boolean flag = this.isPowered();
		boolean flag1 = false;

		if (this.hasFuel() && this.isCreating()) {
			this.fuel--;
			this.damage--;
		}

		if (this.damage > this.maxDamage) {
			this.damage = this.maxDamage;
		}

		if (this.fuel > this.maxFuel) {
			this.fuel = this.maxFuel;
		}

		if (this.createTime < this.minTime) {
			this.createTime = this.minTime;
		}

		if (this.createTime > this.maxTime) {
			this.createTime = this.maxTime;
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

			if (this.isPowered() && this.hasFuel() && this.damage > 0) {
				this.createTime++;

				if (this.createTime == this.speed) {
					// this.createTime = 0;
					this.createHole();
					flag1 = true;
				}

				if (this.damage <= 0) {
					this.createTime = 0;
				}
			} else {
				this.createTime--;
				this.destoryHole();
			}

			if (flag != this.hasFuel()) {
				flag1 = true;
				BHG.updateState(this.hasFuel(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}

		if (flag1) {
			this.onInventoryChanged();
		}
	}

	private void onInventoryChanged() {
	}

	public boolean checkSlot() {
		ItemStack stack = BHGRecipes.compressing().getInput(this.slots[0]);
		if (this.slots[0] == stack) {
			return true;
		} else {
			return false;
		}
	}

	public void createHole() {
		if (this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord) == Blocks.air) {
			this.worldObj.setBlock(this.xCoord, this.yCoord + 1, this.zCoord, mod_IDT.StableBlackHole);
		} else {
			/*Minecraft.getMinecraft().thePlayer
					.addChatComponentMessage(new ChatComponentText("The block above the BHG isn't air!"));*/
			//System.out.println("Block above isn't air!");
		}
	}

	public void destoryHole() {
		if (this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord) == mod_IDT.StableBlackHole) {
			this.worldObj.setBlock(this.xCoord, this.yCoord + 1, this.zCoord, Blocks.air);
		} else {
			// System.out.println("There isn't a stable black hole to remove");
		}
	}

	public static int getItemFuel(ItemStack stack) {
		if (stack == null) {
			return 0;
		} else {
			if (stack.getItem() == Item.getItemFromBlock(mod_IDT.DarkMatter)) {
				return 30000;
			}

			return 0;
		}
	}

	public static boolean isItemFuel(ItemStack stack) {
		return getItemFuel(stack) > 0;
	}

	public boolean isItemValidForSlot(int i, ItemStack stack) {
		return i == 1 ? false : true;
	}

	public int[] getAccessibleSlotFromSide(int side) {
		return input_slot;
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

	public int getCreateProgressScaled(int i) {
		return this.createTime * i / this.speed;
	}

	public int getDamagedScaled(int i) {
		return this.damage * i / this.maxDamage;
	}

	public int getFuelScaled(int i) {
		return this.fuel * i / this.maxFuel;
	}
}
