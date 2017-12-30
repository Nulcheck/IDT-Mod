package com.mce.api.rf;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class IDTRFBase extends TileEntity {
	protected EnergyBase energy;

	public IDTRFBase() {
		energy = new EnergyBase();
	}

	public IDTRFBase(int cap) {
		energy = new EnergyBase(cap);
	}

	public IDTRFBase(int cap, int maxIn) {
		energy = new EnergyBase(cap, maxIn);
	}

	public IDTRFBase(int cap, int maxIn, int maxOut) {
		energy = new EnergyBase(cap, maxIn, maxOut);
	}

	public boolean consumeEnergy(int amount) {
		return this.energy.consumeEnergy(amount);
	}

	public boolean hasEnergy(int amount) {
		return this.energy.hasEnergy(amount);
	}

	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		energy.writeToNBT(tag);
	}

	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		energy.readFromNBT(tag);
	}
}
