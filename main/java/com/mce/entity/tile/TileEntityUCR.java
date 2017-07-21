package com.mce.entity.tile;

import net.minecraft.tileentity.TileEntity;

public class TileEntityUCR extends TileEntity {
	public float rotation;
	
	public void updateEntity(){
		if(worldObj.isRemote) rotation += 1f;
	}
}
