package com.mce.api.minechem;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class MinechemNameHandler {
	private static final MinechemNameHandler names = new MinechemNameHandler();

	public static MinechemNameHandler getInstance() {
		return names;
	}

	@SuppressWarnings("deprecation")
	public void naming(LanguageRegistry lr) {
		lr.instance().addStringLocalization("molecule.nitricAcid", "en_US", "Nitric Acid");
		lr.instance().addStringLocalization("molecule.sulfurTrioxide", "en_US", "Sulfur Trioxide");
		lr.instance().addStringLocalization("molecule.vanadiumPentoxide", "en_US", "Vanadium Pentoxide");
	}
}
