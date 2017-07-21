package com.mce.blocks.itemblocks.tech;

import com.mce.common.mod_IDT;
import com.mce.util.DamageHandlerUtil;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemSmelter extends ItemBlock {
	public ItemSmelter() {
		super(mod_IDT.SmelterIdle);
	}

	public static ItemStack createStackWithDamage(int damage) {
		ItemStack stack = new ItemStack(mod_IDT.SmelterActive);
		DamageHandlerUtil.setDamageForItem(stack, damage);
		return stack;
	}

	public int getMetadata(int meta) {
		return meta;
	}

	public boolean showDurabilityBar(ItemStack stack) {
		return stack.getItemDamage() != 1;
	}

	public double getDurabilityBarForDisplay(ItemStack stack) {
		double damage = getMaxDamageStored(stack) - getDamageStored(stack) + 1;
		double max = getMaxDamageStored(stack) + 1;
		return damage / max;
	}

	public int getMaxDamageStored(ItemStack stack) {
		return 32000;
	}

	public int getDamageStored(ItemStack stack) {
		return DamageHandlerUtil.getDamageForItem(stack);
	}
}
