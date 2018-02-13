package com.mce.entity.tile.tech;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyStorage;
import cofh.api.energy.TileEnergyHandler;
import cofh.api.tileentity.IEnergyInfo;
import cofh.lib.util.helpers.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityMachineCasing extends TileEnergyHandler implements IEnergyInfo {
	protected EnergyStorage es = new EnergyStorage(0);

	public int damage;
	public int maxDamage;
	// public int lvl;

	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);

		setDamage(tag.getInteger("Damage"));
		setMaxDamage(tag.getInteger("MaxDamage"));
		es.readFromNBT(tag);

		if (getDamage() > getMaxDamage())
			setDamage(getMaxDamage());
		if (getDamage() < 0)
			setDamage(0);
	}

	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		if (getDamage() > getMaxDamage())
			setDamage(getMaxDamage());
		if (getDamage() < 0)
			setDamage(0);

		tag.setInteger("Damage", getDamage());
		tag.setInteger("MaxDamage", getMaxDamage());
		es.writeToNBT(tag);
	}

	public void setMaxEnergy(int max) {
		es.setCapacity(max);
	}

	public void setMaxDamage(int max) {
		maxDamage = max;
	}

	public void setDamage(int dam) {
		damage = dam;
	}

	public int getDamage() {
		return damage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public boolean getMeta(int meta) {
		if (meta == this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord))
			return true;
		else
			return false;
	}

	public boolean isPowered() {
		return this.getEnergyStored(ForgeDirection.UNKNOWN) > 0;
	}

	public boolean hasEnergy(int energy) {
		return es.getEnergyStored() >= energy;
	}

	public boolean drainEnergy(int energy) {
		return hasEnergy(energy) && es.extractEnergy(energy, false) == energy;
	}

	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		return es.receiveEnergy(maxReceive, simulate);
	}

	public int getEnergyStored(ForgeDirection from) {
		return es.getEnergyStored();
	}

	public int getMaxEnergyStored(ForgeDirection from) {
		return es.getMaxEnergyStored();
	}

	public boolean canConnectEnergy(ForgeDirection from) {
		return es.getMaxEnergyStored() > 0;
	}

	public final void setEnergyStored(int quantity) {
		es.setEnergyStored(quantity);
	}

	public IEnergyStorage getEnergyStored() {
		return es;
	}

	public int getScaledEnergyStorage(int scale) {
		return MathHelper.round((long) es.getEnergyStored() * scale / es.getMaxEnergyStored());
	}

	public void calcTier() {
		// Steel
		if (getMeta(0)) {
			setMaxDamage(32000);
			setMaxEnergy(32000);

			if (getDamage() > getMaxDamage())
				setDamage(getMaxDamage());
			if (getDamage() < 0)
				setDamage(0);
		}

		// Titanium
		if (getMeta(1)) {
			setMaxDamage(64000);
			setMaxEnergy(64000);

			if (getDamage() > getMaxDamage())
				setDamage(getMaxDamage());
			if (getDamage() < 0)
				setDamage(0);
		}

		// Tantalum
		if (getMeta(2)) {
			setMaxDamage(96000);
			setMaxEnergy(96000);

			if (getDamage() > getMaxDamage())
				setDamage(getMaxDamage());
			if (getDamage() < 0)
				setDamage(0);
		}

		// Vanadium
		if (getMeta(3)) {
			setMaxDamage(128000);
			setMaxEnergy(128000);

			if (getDamage() > getMaxDamage())
				setDamage(getMaxDamage());
			if (getDamage() < 0)
				setDamage(0);
		}

		// VC
		if (getMeta(4)) {
			setMaxDamage(160000);
			setMaxEnergy(160000);

			if (getDamage() > getMaxDamage())
				setDamage(getMaxDamage());
			if (getDamage() < 0)
				setDamage(0);
		}
	}

	public void updateEntity() {
		this.calcTier();
	}

	public int getInfoEnergyStored() {
		return es.getEnergyStored();
	}

	public int getInfoMaxEnergyStored() {
		return es.getMaxEnergyStored();
	}

	public int getInfoEnergyPerTick() {
		return 0;
	}

	public int getInfoMaxEnergyPerTick() {
		return 0;
	}
}
