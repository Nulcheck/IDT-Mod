package com.mce.handlers.village;

import java.util.List;
import java.util.Random;

import com.mce.gen.structures.parts.VillageComponentIndustrialist;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageCreationHandler;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.PieceWeight;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;

public class VillageHandlerIndustrialist implements IVillageCreationHandler {
	public PieceWeight getVillagePieceWeight(Random random, int i) {
		return new StructureVillagePieces.PieceWeight(VillageComponentIndustrialist.class, 15, i + random.nextInt(3));
	}

	public Class<?> getComponentClass() {
		return VillageComponentIndustrialist.class;
	}

	public Object buildComponent(PieceWeight villagePiece, Start startPiece, List pieces, Random random, int p1, int p2,
			int p3, int p4, int p5) {
		return VillageComponentIndustrialist.buildComponent(startPiece, pieces, random, p1, p2, p3, p4, p5);
	}
}
