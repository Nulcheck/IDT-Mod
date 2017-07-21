package com.mce.events;

import com.mce.common.mod_IDT;
import com.mce.util.ModDamageSource;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class PotionEvents {
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event) {
		if (event.entityLiving.isPotionActive(mod_IDT.Radiation)) {
			if (event.entityLiving.getActivePotionEffect(mod_IDT.Radiation).getDuration() == 0) {
				event.entityLiving.removePotionEffect(mod_IDT.Radiation.id);
				return;
			}

			else if (event.entityLiving.worldObj.rand.nextInt(50) <= 1) {
				event.entityLiving.attackEntityFrom(ModDamageSource.radiation, 2);
			}
		}
	}
}