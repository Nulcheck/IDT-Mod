package com.mce.api.minechem;

import minechem.api.ChemicalAPI;
import minechem.item.molecule.MoleculeEnum;

public class MinechemChemicalHandler {
	private static final MinechemChemicalHandler chemicals = new MinechemChemicalHandler();

	public static MinechemChemicalHandler getInstance() {
		return chemicals;
	}

	public void chem() {
		// Molecules | arg8 is phase
		ChemicalAPI.registerMolecule(200, "nitroglycerin", "liquid", 3, "C", 5, "H", 3, "N", 9, "O");
		ChemicalAPI.registerMolecule(201, "amblygonite", "solid", 1, "Li", 1, "Al", 1, "phosphate", 1, "F");
		ChemicalAPI.registerMolecule(202, "magma", 1f, .4f, 0f, 1f, .6f, 0f, "liquid", 10, "siliconDioxide", 10, "Fe",
				5, "Ca", 3, "K", 2, "Mg");
	}
}