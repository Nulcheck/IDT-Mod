package com.mce.entity.tile.tech;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.TileEnergyHandler;
import cofh.lib.util.helpers.MathHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityMachineCasing extends TileEnergyHandler {
	protected EnergyStorage es = new EnergyStorage(0);

	public int damage;
	public int maxDamage;

	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);

		setDamage(tag.getInteger("Damage"));
		setMaxDamage(tag.getInteger("MaxDamage"));
		es.readFromNBT(tag);

		if (getDamage() > getMaxDamage())
			setDamage(getMaxDamage());
		if (getDamage() < 0)
			setDamage(0);
		
		if (es.getEnergyStored() > es.getMaxEnergyStored())
			es.setEnergyStored(es.getMaxEnergyStored());
		if (es.getEnergyStored() < 0)
			es.setEnergyStored(0);
	}

	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		if (getDamage() > getMaxDamage())
			setDamage(getMaxDamage());
		if (getDamage() < 0)
			setDamage(0);
		
		if (es.getEnergyStored() > es.getMaxEnergyStored())
			es.setEnergyStored(es.getMaxEnergyStored());
		if (es.getEnergyStored() < 0)
			es.setEnergyStored(0);

		tag.setInteger("Damage", getDamage());
		tag.setInteger("MaxDamage", getMaxDamage());
		es.writeToNBT(tag);
	}

	/*public void setMaxEnergy(int max) {
		es.setCapacity(max);
	}

	public void setEnergy(int energy) {
		es.setEnergyStored(energy);
	}

	public int getEnergy() {
		return es.getEnergyStored();
	}

	public int getMaxEnergy() {
		return es.getMaxEnergyStored();
	}*/

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

	public void calculateTier() {
		// Steel
		if (getMeta(0)) {
			setMaxDamage(32000);
			es.setCapacity(32000);

			if (getDamage() > getMaxDamage())
				setDamage(getMaxDamage());
			if (getDamage() < 0)
				setDamage(0);

			if (es.getEnergyStored() > es.getMaxEnergyStored())
				es.setEnergyStored(es.getMaxEnergyStored());
			if (es.getEnergyStored() < 0)
				es.setEnergyStored(0);
		}

		// Titanium
		if (getMeta(1)) {
			setMaxDamage(64000);
			es.setCapacity(64000);

			if (getDamage() > getMaxDamage())
				setDamage(getMaxDamage());
			if (getDamage() < 0)
				setDamage(0);

			if (es.getEnergyStored() > es.getMaxEnergyStored())
				es.setEnergyStored(es.getMaxEnergyStored());
			if (es.getEnergyStored() < 0)
				es.setEnergyStored(0);
		}

		// Tantalum
		if (getMeta(2)) {
			setMaxDamage(96000);
			es.setCapacity(96000);

			if (getDamage() > getMaxDamage())
				setDamage(getMaxDamage());
			if (getDamage() < 0)
				setDamage(0);

			if (es.getEnergyStored() > es.getMaxEnergyStored())
				es.setEnergyStored(es.getMaxEnergyStored());
			if (es.getEnergyStored() < 0)
				es.setEnergyStored(0);
		}

		// Vanadium
		if (getMeta(3)) {
			setMaxDamage(128000);
			es.setCapacity(128000);

			if (getDamage() > getMaxDamage())
				setDamage(getMaxDamage());
			if (getDamage() < 0)
				setDamage(0);

			if (es.getEnergyStored() > es.getMaxEnergyStored())
				es.setEnergyStored(es.getMaxEnergyStored());
			if (es.getEnergyStored() < 0)
				es.setEnergyStored(0);
		}

		// VC
		if (getMeta(4)) {
			setMaxDamage(160000);
			es.setCapacity(160000);

			if (getDamage() > getMaxDamage())
				setDamage(getMaxDamage());
			if (getDamage() < 0)
				setDamage(0);

			if (es.getEnergyStored() > es.getMaxEnergyStored())
				es.setEnergyStored(es.getMaxEnergyStored());
			if (es.getEnergyStored() < 0)
				es.setEnergyStored(0);
		}
	}

	public int getScaledEnergyStorage(int scale) {
		return MathHelper.round((long) es.getEnergyStored() * scale / es.getMaxEnergyStored());
	}

	public int getDamageScaled(int i) {
		return getDamage() * i / getMaxDamage();
	}
}
