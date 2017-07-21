package com.mce.util;

import net.minecraft.util.DamageSource;

public class ModDamageSource extends DamageSource {
	public static ModDamageSource radiation = (new ModDamageSource("idtradiation")).setDamageBypassesArmor();
	private boolean isUnblockable;
	private float hungerDamage = 0.3F;

	public ModDamageSource(String type) {
		super(type);
	}

	public ModDamageSource setDamageBypassesArmor() {
		this.isUnblockable = true;
		this.hungerDamage = 0.0F;
		return this;
	}
}
