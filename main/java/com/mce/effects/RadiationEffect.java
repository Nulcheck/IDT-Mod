package com.mce.effects;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class RadiationEffect extends Potion {
	public static final ResourceLocation icon = new ResourceLocation("mod_idt",
			"/textures/gui/inventory.png".substring(1));

	public RadiationEffect(int id, boolean bad, int amp) {
		super(id, bad, amp);
	}

	public Potion setIconIndex(int x, int y) {
		super.setIconIndex(x, y);
		return (Potion) this;
	}

	public int getStatusIconIndex() {
		Minecraft.getMinecraft().renderEngine.bindTexture(icon);
		return super.getStatusIconIndex();
	}

	public boolean isBadEffect() {
		return true;
	}
}
