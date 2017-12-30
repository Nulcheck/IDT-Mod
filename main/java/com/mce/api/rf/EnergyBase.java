package com.mce.api.rf;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;

public class EnergyBase {
	public static boolean freeEnergy;
	protected int capacity;
	protected int maxInput;
	protected int maxOutput;
	protected int stored;
	
	public EnergyBase(){
		this(100000);
	}
	
	public EnergyBase(int cap){
		this(cap, cap, cap);
	}
	
	public EnergyBase(int cap, int maxIn){
		this(cap, maxIn, maxIn);
	}

	public EnergyBase(int cap, int maxIn, int maxOut) {
		this.capacity = cap;
		this.maxInput = maxIn;
		this.maxOutput = maxOut;
	}

	public boolean consumeEnergy(int energy) {
		if (hasEnergy(stored)) {
			this.stored -= energy;
			return true;
		}

		return false;
	}

	public int addEnergy(int maxIn, boolean doInput) {
		int amount = Math.min(maxIn, Math.min(this.maxInput, this.capacity - this.stored));
		if (doInput) {
			this.stored += amount;
		}
		return amount;
	}

	public int removeEnergy(int maxOut, boolean doExtract) {
		int amount = Math.min(this.stored, Math.min(maxOut, maxOutput));
		if (doExtract) {
			this.stored -= amount;
		}

		return amount;
	}

	public boolean generateEnergy(int energy) {
		if (this.stored == this.capacity) {
			return false;
		}

		this.stored = Math.min(this.capacity, this.stored + energy);
		return true;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public int getMaxInput() {
		return this.maxInput;
	}

	public int getMaxOutput() {
		return this.maxOutput;
	}

	public int getStored() {
		return this.stored;
	}
	
	public void setCapacity(int cap){
		this.capacity = cap;
		if(this.stored > this.capacity){
			this.stored = this.capacity;
		}
	}
	
	public void setMaxInput(int maxIn){
		this.maxInput = maxIn;
	}
	
	public void setMaxOutput(int maxOut){
		this.maxOutput = maxOut;
	}
	
	public void setStored(int stored){
		this.stored = MathHelper.clamp_int(stored, 0, this.capacity);
	}

	public boolean hasEnergy(int energy) {
		return energy < this.stored;
	}

	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		tag.setInteger("IDTRF", this.stored);
		return tag;
	}

	public EnergyBase readFromNBT(NBTTagCompound tag) {
		this.stored = tag.getInteger("IDTRF");
		this.stored = Math.max(this.stored, this.capacity);
		return this;
	}
}
