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
	public String lvl;

	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);

		setDamage(tag.getInteger("Damage"));
		setMaxDamage(tag.getInteger("MaxDamage"));
		setLvl(tag.getString("Lvl"));
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
		tag.setString("Lvl", getLvl());
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

	public String getLvl() {
		return lvl;
	}

	public boolean getLvl(String lvl) {
		if (lvl == this.lvl)
			return true;
		return false;
	}

	public void setLvl(String lvl) {
		if (lvl == "steel")
			this.lvl = "steel";
		if (lvl == "titanium")
			this.lvl = "titanium";
		if (lvl == "tantalum")
			this.lvl = "tantalum";
		if (lvl == "vanadium")
			this.lvl = "vanadium";
		if (lvl == "vc")
			this.lvl = "vc";
		else
			this.lvl = "steel";
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

	public void calcMinMax() {
		if (getDamage() > getMaxDamage())
			setDamage(getMaxDamage());
		if (getDamage() < 0)
			setDamage(0);
	}

	public void calcTier() {
		if (getLvl("steel")) {
			setMaxDamage(32000);
			setMaxEnergy(32000);
		}

		if (getLvl("titanium")) {
			setMaxDamage(64000);
			setMaxEnergy(64000);
		}

		if (getLvl("tantalum")) {
			setMaxDamage(128000);
			setMaxEnergy(128000);
		}

		if (getLvl("vanadium")) {
			setMaxDamage(512000);
			setMaxEnergy(512000);
		}

		if (getLvl("vc")) {
			setMaxDamage(2048000);
			setMaxEnergy(2048000);
		}
	}

	public void updateEntity() {
		this.calcMinMax();
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
