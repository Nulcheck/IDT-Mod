package com.mce.blocks;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ModPressurePlates extends BlockBasePressurePlate {
	private ModPressurePlates.Sensitivity sense;
	private static final String __OBFID = "CL_00000289";

	public ModPressurePlates(String block, Material mat,
			ModPressurePlates.Sensitivity type) {
		super(block, mat);
		this.sense = type;
	}

	protected int func_150066_d(int meta) {
		return meta > 0 ? 1 : 0;
	}

	protected int func_150060_c(int meta) {
		return meta == 1 ? 15 : 0;
	}

	protected int func_150065_e(World world, int x, int y, int z) {
		List list = null;

		if (this.sense == ModPressurePlates.Sensitivity.everything) {
			list = world.getEntitiesWithinAABBExcludingEntity((Entity) null,
					this.func_150061_a(x, y, z));
		}

		if (this.sense == ModPressurePlates.Sensitivity.mobs) {
			list = world.getEntitiesWithinAABB(EntityLivingBase.class,
					this.func_150061_a(x, y, z));
		}

		if (this.sense == ModPressurePlates.Sensitivity.players) {
			list = world.getEntitiesWithinAABB(EntityPlayer.class,
					this.func_150061_a(x, y, z));
		}

		if (list != null && !list.isEmpty()) {
			Iterator iterator = list.iterator();

			while (iterator.hasNext()) {
				Entity entity = (Entity) iterator.next();

				if (!entity.doesEntityNotTriggerPressurePlate()) {
					return 15;
				}
			}
		}

		return 0;
	}

	public static enum Sensitivity {
		everything, mobs, players;

		private static final String __OBFID = "CL_00000290";
	}
}