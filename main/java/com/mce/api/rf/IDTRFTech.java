package com.mce.api.rf;

import cofh.api.energy.IEnergyReceiver;
import cpw.mods.fml.common.Optional;
import net.minecraftforge.common.util.ForgeDirection;

@Optional.Interface(iface = "cofh.api.energy.IEnergyReceiver", modid = "CoFHAPI|energy")
public class IDTRFTech extends IDTRFBase implements IEnergyReceiver {
	@Optional.Method(modid = "CoFHAPI|energy")
	public boolean canConnectEnergy(ForgeDirection dir) {
		return true;
	}

	@Optional.Method(modid = "CoFHAPI|energy")
	public int getEnergyStored(ForgeDirection dir) {
		return this.energy.getStored();
	}

	@Optional.Method(modid = "CoFHAPI|energy")
	public int getMaxEnergyStored(ForgeDirection dir) {
		return this.energy.getCapacity();
	}

	@Optional.Method(modid = "CoFHAPI|energy")
	public int receiveEnergy(ForgeDirection dir, int amount, boolean doInput) {
		return this.energy.inputEnergy(amount, doInput);
	}
}
