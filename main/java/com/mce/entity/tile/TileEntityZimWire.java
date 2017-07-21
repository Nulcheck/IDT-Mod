package com.mce.entity.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityZimWire extends TileEntity {
	// Up, down, north, east, south, west
	public ForgeDirection[] connect = new ForgeDirection[6];

	public TileEntityZimWire() {
	}

	public void updateEntity() {
		this.updateConnections();
	}

	public void updateConnections() {
		if (this.worldObj.getTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityZimWire) {
			connect[0] = ForgeDirection.UP;
		} else {
			connect[0] = null;
		}

		if (this.worldObj.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityZimWire) {
			connect[1] = ForgeDirection.DOWN;
		} else {
			connect[1] = null;
		}

		if (this.worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityZimWire) {
			connect[2] = ForgeDirection.NORTH;
		} else {
			connect[2] = null;
		}

		if (this.worldObj.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityZimWire) {
			connect[3] = ForgeDirection.EAST;
		} else {
			connect[3] = null;
		}

		if (this.worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityZimWire) {
			connect[4] = ForgeDirection.SOUTH;
		} else {
			connect[4] = null;
		}

		if (this.worldObj.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityZimWire) {
			connect[5] = ForgeDirection.WEST;
		} else {
			connect[5] = null;
		}
	}
}
