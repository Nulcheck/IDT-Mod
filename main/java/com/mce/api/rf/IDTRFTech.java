package com.mce.api.rf;

import cofh.api.energy.IEnergyReceiver;
import cpw.mods.fml.common.Optional;
import net.minecraftforge.common.util.ForgeDirection;

@Optional.Interface(iface = "cofh.api.energy.IEnergyReceiver", modid = "CoFHAPI|energy")
public class IDTRFTech extends IDTRFBase implements IEnergyReceiver {
	public IDTRFTech(int cap, int maxIn, int maxOut){
		super(cap, maxIn, maxOut);
	}
	
	public IDTRFTech(int cap, int maxIn){
		super(cap, maxIn);
	}
	
	public IDTRFTech(int cap){
		super(cap);
	}
	
	public IDTRFTech(){
		super();
	}
	
	@Optional.Method(modid = "CoFHAPI|energy")
	@Override
	public boolean canConnectEnergy(ForgeDirection dir) {
		return true;
	}

	@Optional.Method(modid = "CoFHAPI|energy")
	@Override
	public int getEnergyStored(ForgeDirection dir) {
		return this.energy.getStored();
	}

	@Optional.Method(modid = "CoFHAPI|energy")
	@Override
	public int getMaxEnergyStored(ForgeDirection dir) {
		return this.energy.getCapacity();
	}

	@Optional.Method(modid = "CoFHAPI|energy")
	@Override
	public int receiveEnergy(ForgeDirection dir, int amount, boolean doInput) {
		return this.energy.receiveEnergy(amount, doInput);
	}
}
