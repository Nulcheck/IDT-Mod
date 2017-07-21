package com.mce.handlers.registers;

import com.mce.gen.structures.parts.VillageComponentIndustrialist;
import com.mce.handlers.village.VillageHandlerIndustrialist;

import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.world.gen.structure.MapGenStructureIO;

public class VillageRegistry {
	public void main() {
		addVillagePiece(VillageComponentIndustrialist.class, "BiMH");
		addVillageCreationHandler(new VillageHandlerIndustrialist());
	}

	public static void addVillagePiece(Class c, String s) {
		try {
			MapGenStructureIO.func_143031_a(c, s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addVillageCreationHandler(VillagerRegistry.IVillageCreationHandler v) {
		VillagerRegistry.instance().registerVillageCreationHandler(v);
	}
}