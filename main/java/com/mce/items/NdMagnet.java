package com.mce.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class NdMagnet extends Item {
	public String types[] = { "unmag", "mag" };

	public NdMagnet() {
		super();
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(this, 1, 0));
		list.add(new ItemStack(this, 1, 1));
	}

	public String getUnlocalizedName(ItemStack stack) {
		int i = MathHelper.clamp_int(stack.getItemDamage(), 0, 1);
		return super.getUnlocalizedName() + "." + types[i];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean show) {
		if (stack.getItemDamage() == stack.getItem().getMetadata(0)) {
			list.add("Unmagnetized");
		} else {
			list.add("Magnetized");
		}
	}
}