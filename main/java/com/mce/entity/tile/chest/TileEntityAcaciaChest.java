package com.mce.entity.tile.chest;

import java.util.Iterator;
import java.util.List;

import com.mce.blocks.chest.AcaciaChest;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityAcaciaChest extends TileEntity implements IInventory {
	private ItemStack[] chestContents = new ItemStack[36];
	/** Determines if the check for adjacent chests has taken place. */
	public boolean adjacentChestChecked;
	/** Contains the chest tile located adjacent to this one (if any) */
	public TileEntityAcaciaChest adjacentChestZNeg;
	/** Contains the chest tile located adjacent to this one (if any) */
	public TileEntityAcaciaChest adjacentChestXPos;
	/** Contains the chest tile located adjacent to this one (if any) */
	public TileEntityAcaciaChest adjacentChestXNeg;
	/** Contains the chest tile located adjacent to this one (if any) */
	public TileEntityAcaciaChest adjacentChestZPos;
	/** The current angle of the lid (between 0 and 1) */
	public float lidAngle;
	/** The angle of the lid last tick */
	public float prevLidAngle;
	/** The number of players currently using this chest */
	public int numPlayersUsing;
	/** Server sync counter (once per 20 ticks) */
	private int ticksSinceSync;
	private int cachedChestType;
	private String customName;
	private static final String __OBFID = "CL_00000346";

	public TileEntityAcaciaChest() {
		this.cachedChestType = -1;
	}

	@SideOnly(Side.CLIENT)
	public TileEntityAcaciaChest(int i) {
		this.cachedChestType = i;
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	public int getSizeInventory() {
		return 27;
	}

	/**
	 * Returns the stack in slot i
	 */
	public ItemStack getStackInSlot(int i) {
		return this.chestContents[i];
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number
	 * (second arg) of items and returns them in a new stack.
	 */
	public ItemStack decrStackSize(int slot, int num) {
		if (this.chestContents[slot] != null) {
			ItemStack itemstack;

			if (this.chestContents[slot].stackSize <= num) {
				itemstack = this.chestContents[slot];
				this.chestContents[slot] = null;
				this.markDirty();
				return itemstack;
			} else {
				itemstack = this.chestContents[slot].splitStack(num);

				if (this.chestContents[slot].stackSize == 0) {
					this.chestContents[slot] = null;
				}

				this.markDirty();
				return itemstack;
			}
		} else {
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then drop
	 * whatever it returns as an EntityItem - like when you close a workbench
	 * GUI.
	 */
	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.chestContents[i] != null) {
			ItemStack itemstack = this.chestContents[i];
			this.chestContents[i] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be
	 * crafting or armor sections).
	 */
	public void setInventorySlotContents(int slot, ItemStack stack) {
		this.chestContents[slot] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
		}

		this.markDirty();
	}

	/**
	 * Returns the name of the inventory
	 */
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.customName : "container.acaciaChest";
	}

	/**
	 * Returns if the inventory is named
	 */
	public boolean hasCustomInventoryName() {
		return this.customName != null && this.customName.length() > 0;
	}

	public void func_145976_a(String s) {
		this.customName = s;
	}

	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		NBTTagList nbttaglist = tag.getTagList("Items", 10);
		this.chestContents = new ItemStack[this.getSizeInventory()];

		if (tag.hasKey("CustomName", 8)) {
			this.customName = tag.getString("CustomName");
		}

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;

			if (j >= 0 && j < this.chestContents.length) {
				this.chestContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}

	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.chestContents.length; ++i) {
			if (this.chestContents[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.chestContents[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		tag.setTag("Items", nbttaglist);

		if (this.hasCustomInventoryName()) {
			tag.setString("CustomName", this.customName);
		}
	}

	/**
	 * Returns the maximum stack size for a inventory slot.
	 */
	public int getInventoryStackLimit() {
		return 64;
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes
	 * with Container
	 */
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false
				: player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D,
						(double) this.zCoord + 0.5D) <= 64.0D;
	}

	/**
	 * Causes the TileEntity to reset all it's cached values for it's container
	 * Block, metadata and in the case of chests, the adjacent chest check
	 */
	public void updateContainingBlockInfo() {
		super.updateContainingBlockInfo();
		this.adjacentChestChecked = false;
	}

	private void func_145978_a(TileEntityAcaciaChest te, int i) {
		if (te.isInvalid()) {
			this.adjacentChestChecked = false;
		} else if (this.adjacentChestChecked) {
			switch (i) {
			case 0:
				if (this.adjacentChestZPos != te) {
					this.adjacentChestChecked = false;
				}

				break;
			case 1:
				if (this.adjacentChestXNeg != te) {
					this.adjacentChestChecked = false;
				}

				break;
			case 2:
				if (this.adjacentChestZNeg != te) {
					this.adjacentChestChecked = false;
				}

				break;
			case 3:
				if (this.adjacentChestXPos != te) {
					this.adjacentChestChecked = false;
				}
			}
		}
	}

	/**
	 * Performs the check for adjacent chests to determine if this chest is
	 * double or not.
	 */
	public void checkForAdjacentChests() {
		if (!this.adjacentChestChecked) {
			this.adjacentChestChecked = true;
			this.adjacentChestZNeg = null;
			this.adjacentChestXPos = null;
			this.adjacentChestXNeg = null;
			this.adjacentChestZPos = null;

			if (this.func_145977_a(this.xCoord - 1, this.yCoord, this.zCoord)) {
				this.adjacentChestXNeg = (TileEntityAcaciaChest) this.worldObj.getTileEntity(this.xCoord - 1,
						this.yCoord, this.zCoord);
			}

			if (this.func_145977_a(this.xCoord + 1, this.yCoord, this.zCoord)) {
				this.adjacentChestXPos = (TileEntityAcaciaChest) this.worldObj.getTileEntity(this.xCoord + 1,
						this.yCoord, this.zCoord);
			}

			if (this.func_145977_a(this.xCoord, this.yCoord, this.zCoord - 1)) {
				this.adjacentChestZNeg = (TileEntityAcaciaChest) this.worldObj.getTileEntity(this.xCoord, this.yCoord,
						this.zCoord - 1);
			}

			if (this.func_145977_a(this.xCoord, this.yCoord, this.zCoord + 1)) {
				this.adjacentChestZPos = (TileEntityAcaciaChest) this.worldObj.getTileEntity(this.xCoord, this.yCoord,
						this.zCoord + 1);
			}

			if (this.adjacentChestZNeg != null) {
				this.adjacentChestZNeg.func_145978_a(this, 0);
			}

			if (this.adjacentChestZPos != null) {
				this.adjacentChestZPos.func_145978_a(this, 2);
			}

			if (this.adjacentChestXPos != null) {
				this.adjacentChestXPos.func_145978_a(this, 1);
			}

			if (this.adjacentChestXNeg != null) {
				this.adjacentChestXNeg.func_145978_a(this, 3);
			}
		}
	}

	private boolean func_145977_a(int x, int y, int z) {
		if (this.worldObj == null) {
			return false;
		} else {
			Block block = this.worldObj.getBlock(x, y, z);
			return block instanceof AcaciaChest && ((AcaciaChest) block).field_149956_a == this.getChestType();
		}
	}

	public void updateEntity() {
		super.updateEntity();
		this.checkForAdjacentChests();
		++this.ticksSinceSync;
		float f;

		if (!this.worldObj.isRemote && this.numPlayersUsing != 0
				&& (this.ticksSinceSync + this.xCoord + this.yCoord + this.zCoord) % 200 == 0) {
			this.numPlayersUsing = 0;
			f = 5.0F;
			List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class,
					AxisAlignedBB.getBoundingBox((double) ((float) this.xCoord - f), (double) ((float) this.yCoord - f),
							(double) ((float) this.zCoord - f), (double) ((float) (this.xCoord + 1) + f),
							(double) ((float) (this.yCoord + 1) + f), (double) ((float) (this.zCoord + 1) + f)));
			Iterator iterator = list.iterator();

			while (iterator.hasNext()) {
				EntityPlayer entityplayer = (EntityPlayer) iterator.next();

				if (entityplayer.openContainer instanceof ContainerChest) {
					IInventory iinventory = ((ContainerChest) entityplayer.openContainer).getLowerChestInventory();

					if (iinventory == this || iinventory instanceof InventoryLargeChest
							&& ((InventoryLargeChest) iinventory).isPartOfLargeChest(this)) {
						++this.numPlayersUsing;
					}
				}
			}
		}

		this.prevLidAngle = this.lidAngle;
		f = 0.1F;
		double d2;

		if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F && this.adjacentChestZNeg == null
				&& this.adjacentChestXNeg == null) {
			double d1 = (double) this.xCoord + 0.5D;
			d2 = (double) this.zCoord + 0.5D;

			if (this.adjacentChestZPos != null) {
				d2 += 0.5D;
			}

			if (this.adjacentChestXPos != null) {
				d1 += 0.5D;
			}

			this.worldObj.playSoundEffect(d1, (double) this.yCoord + 0.5D, d2, "random.chestopen", 0.5F,
					this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
		}

		if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
			float f1 = this.lidAngle;

			if (this.numPlayersUsing > 0) {
				this.lidAngle += f;
			} else {
				this.lidAngle -= f;
			}

			if (this.lidAngle > 1.0F) {
				this.lidAngle = 1.0F;
			}

			float f2 = 0.5F;

			if (this.lidAngle < f2 && f1 >= f2 && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null) {
				d2 = (double) this.xCoord + 0.5D;
				double d0 = (double) this.zCoord + 0.5D;

				if (this.adjacentChestZPos != null) {
					d0 += 0.5D;
				}

				if (this.adjacentChestXPos != null) {
					d2 += 0.5D;
				}

				this.worldObj.playSoundEffect(d2, (double) this.yCoord + 0.5D, d0, "random.chestclosed", 0.5F,
						this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
			}

			if (this.lidAngle < 0.0F) {
				this.lidAngle = 0.0F;
			}
		}
	}

	/**
	 * Called when a client event is received with the event number and
	 * argument, see World.sendClientEvent
	 */
	public boolean receiveClientEvent(int num, int numPlayer) {
		if (num == 1) {
			this.numPlayersUsing = numPlayer;
			return true;
		} else {
			return super.receiveClientEvent(num, numPlayer);
		}
	}

	public void openInventory() {
		if (this.numPlayersUsing < 0) {
			this.numPlayersUsing = 0;
		}

		++this.numPlayersUsing;
		this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1,
				this.numPlayersUsing);
		this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType());
		this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType());
	}

	public void closeInventory() {
		if (this.getBlockType() instanceof AcaciaChest) {
			--this.numPlayersUsing;
			this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1,
					this.numPlayersUsing);
			this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType());
			this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType());
		}
	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring
	 * stack size) into the given slot.
	 */
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return true;
	}

	/**
	 * invalidates a tile entity
	 */
	public void invalidate() {
		super.invalidate();
		this.updateContainingBlockInfo();
		this.checkForAdjacentChests();
	}

	public int getChestType() {
		if (this.cachedChestType == -1) {
			if (this.worldObj == null || !(this.getBlockType() instanceof AcaciaChest)) {
				return 0;
			}

			this.cachedChestType = ((AcaciaChest) this.getBlockType()).field_149956_a;
		}

		return this.cachedChestType;
	}
}