package com.mce.entity.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityECR extends TileEntity {
	int damage;
	final int maxDamage = 10000;
	
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setInteger("Damage", getDamage());
	}
	
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		setDamage(tag.getInteger("Damage"));
	}
	
	public int getDamage(){
		return damage;
	}
	
	public int getMaxDamage(){
		return maxDamage;
	}
	
	public void setDamage(int damage){
		this.damage = damage;
	}
}
