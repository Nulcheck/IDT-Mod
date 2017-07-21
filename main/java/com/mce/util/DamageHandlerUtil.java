package com.mce.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class DamageHandlerUtil {
	public static int getDamageForItem(ItemStack stack){
		NBTTagCompound tag = stack.getTagCompound();
		if(tag == null){
			return 0;
		}
		
		if(tag.hasKey("DamageAmount")){
			double damage = tag.getInteger("DamageAmount");
			return (int) (damage);
		}
		
		return tag.getInteger("DamageAmount");
	}
	
	public static void setDamageForItem(ItemStack stack, int damage){
		NBTTagCompound tag = stack.getTagCompound();
		if(tag == null){
			tag = new NBTTagCompound();
		}
		tag.setInteger("DamageAmount", damage);
		stack.setTagCompound(tag);
	}
}
