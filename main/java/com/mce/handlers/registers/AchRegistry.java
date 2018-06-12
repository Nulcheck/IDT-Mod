package com.mce.handlers.registers;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class AchRegistry {
	// Achievements
	public static Achievement mineModWood;
	public static Achievement modPlanks;
	public static Achievement sadObsidian;
	public static Achievement cement;
	public static Achievement cementBricks;
	public static Achievement crystal;
	public static Achievement essence;
	public static Achievement healer;
	public static Achievement zimphnode;
	public static Achievement zimphnodeBar;
	public static Achievement zng;
	public static Achievement titaniumIngot;
	public static Achievement steelIngot;
	public static Achievement vanadiumIngot;
	public static Achievement praOre;
	public static Achievement darkMatterBomb;
	public static Achievement vanPick;
	public static Achievement tantalumIngot;
	public static Achievement tantArmor;
	public static Achievement didGlass;
	public static Achievement superReactor;
	public static Achievement ultimNuke;
	public static Achievement matterCon;
	public static Achievement darkMatter;
	public static Achievement AmblygoniteBlock;
	public static Achievement dts;
	public static Achievement cutter;
	public static Achievement soPretty;
	public static Achievement greenChem;
	public static Achievement kompressor;
	public static Achievement warfareChem;
	public static Achievement uranGlass;
	public static Achievement dimFrost;
	public static Achievement dimCrystal;
	public static Achievement smeltering;
	public static Achievement copperIngot;
	public static Achievement silicon;
	public static Achievement trans;
	public static Achievement mic;
	public static Achievement t1Cir;
	public static Achievement t2Cir;
	public static Achievement t3Cir;
	public static Achievement dmPiece;
	public static Achievement qMan;
	public static Achievement gaComp;
	public static Achievement craftGem;
	public static Achievement bhg;
	public static Achievement fixIt;
	public static Achievement comp;
	public static Achievement vcIngot;
	public static Achievement vcPick;
	public static Achievement mag;

	public static AchievementPage Modpage;

	public static void registerAch() {
		// 1st # is horz, 2nd # is vert
		mineModWood = new Achievement("achievement.mineModWood", "mineModWood", -2, 4,
				Item.getItemFromBlock(mod_IDT.WillowLog), AchievementList.openInventory).registerStat();

		modPlanks = new Achievement("achievement.modPlanks", "modPlanks", 0, 4,
				Item.getItemFromBlock(mod_IDT.WillowPlanks), mineModWood).registerStat();

		sadObsidian = new Achievement("achievement.sadObsidian", "sadObsidian", -4, 4,
				Item.getItemFromBlock(mod_IDT.CryingObsidian), AchievementList.diamonds);

		cement = new Achievement("achievement.cement", "cement", -2, 3, Item.getItemFromBlock(mod_IDT.Cement),
				AchievementList.buildFurnace).registerStat();

		cementBricks = new Achievement("achievement.cementBricks", "cementBricks", 0, 3,
				Item.getItemFromBlock(mod_IDT.CementBricks), cement).registerStat();

		crystal = new Achievement("achievement.crystal", "crystal", -4, 6, Item.getItemFromBlock(mod_IDT.AmblygoniteOre),
				AchievementList.acquireIron).registerStat();

		essence = new Achievement("achievement.essence", "essence", -3, 6, mod_IDT.EssenceOfLife, crystal)
				.registerStat();

		healer = new Achievement("achievement.healer", "healer", -2, 6, Item.getItemFromBlock(mod_IDT.HealerBlock),
				essence).setSpecial().registerStat();

		zimphnode = new Achievement("achievement.zimphnode", "zimphnode", -2, 2,
				Item.getItemFromBlock(mod_IDT.ZimphnodeOre), AchievementList.buildBetterPickaxe).registerStat();

		zimphnodeBar = new Achievement("achievement.zimphnodeBar", "zimphnodeBar", -1, 2, mod_IDT.ZimphnodeBar,
				zimphnode).registerStat();

		zng = new Achievement("achievement.zng", "zng", 0, 2, mod_IDT.ZNG, zimphnodeBar).registerStat();

		smeltering = new Achievement("achievement.smeltering", "smeltering", -2, 0, mod_IDT.SmelterIdle,
				AchievementList.buildFurnace).registerStat();

		steelIngot = new Achievement("achievement.steelIngot", "steelIngot", -3, 0, mod_IDT.SteelIngot, smeltering)
				.registerStat();

		titaniumIngot = new Achievement("achievement.titaniumIngot", "titaniumIngot", -4, 0, mod_IDT.TitaniumIngot,
				AchievementList.buildFurnace).registerStat();

		vanadiumIngot = new Achievement("achievement.vanadiumIngot", "vanadiumIngot", 2, 4, mod_IDT.VanadiumIngot,
				AchievementList.diamonds).registerStat();

		praOre = new Achievement("achievement.praOre", "praOre", -6, 4, Item.getItemFromBlock(mod_IDT.PraseodymiumOre),
				AchievementList.acquireIron).registerStat();

		vanPick = new Achievement("achievement.vanPick", "vanPick", 2, 5, mod_IDT.VanadiumPick, vanadiumIngot)
				.registerStat();

		tantalumIngot = new Achievement("achievement.tantalumIngot", "tantalumIngot", -5, 4, mod_IDT.TantalumIngot,
				AchievementList.acquireIron).registerStat();

		tantArmor = new Achievement("achievement.tantArmor", "tantArmor", -5, 3, mod_IDT.TantalumHelmet, tantalumIngot)
				.registerStat();

		didGlass = new Achievement("achievement.didGlass", "didGlass", -6, 3,
				Item.getItemFromBlock(mod_IDT.DidymiumGlass), praOre).registerStat();

		superReactor = new Achievement("achievement.superReactor", "superReactor", -4, 1,
				Item.getItemFromBlock(mod_IDT.SuperReactor), titaniumIngot).registerStat();

		ultimNuke = new Achievement("achievement.ultimNuke", "ultimNuke", -4, 2,
				Item.getItemFromBlock(mod_IDT.UltimateNuker), superReactor).registerStat();

		AmblygoniteBlock = new Achievement("achievement.AmblygoniteBlock", "AmblygoniteBlock", -4, 7,
				Item.getItemFromBlock(mod_IDT.AmblygoniteBlock), crystal).setSpecial().registerStat();

		dts = new Achievement("achievement.dts", "dts", -3, -5, mod_IDT.DiamondSawBlade, AchievementList.diamonds)
				.registerStat();

		cutter = new Achievement("achievemetn.proJeweler", "proJeweler", -2, -5,
				Item.getItemFromBlock(mod_IDT.IndustrialCutter), dts).registerStat();

		soPretty = new Achievement("achievement.soPretty", "soPretty", -2, -6, mod_IDT.CutAmblygoniteGem, cutter)
				.registerStat();

		uranGlass = new Achievement("achievement.uranGlass", "uranGlass", -7, 3, mod_IDT.UraniumGlass,
				AchievementList.acquireIron).registerStat();

		dimFrost = new Achievement("achievement.dimFrost", "dimFrost", -5, 9, mod_IDT.FrostStone, null).setSpecial()
				.registerStat();

		dimCrystal = new Achievement("achievement.dimAmblygonite", "dimAmblygonite", -4, 9, mod_IDT.AmblygoniteBlock, AmblygoniteBlock)
				.setSpecial().registerStat();

		copperIngot = new Achievement("achievement.copperIngot", "copperIngot", -1, -1, mod_IDT.CopperIngot,
				AchievementList.buildFurnace).registerStat();

		silicon = new Achievement("achievement.silicon", "silicon", -2, -4, mod_IDT.SiliconDust, cutter).registerStat();

		trans = new Achievement("achievement.trans", "trans", -2, -3, mod_IDT.Transistor, silicon).registerStat();

		mic = new Achievement("achievement.mic", "mic", -1, -3, mod_IDT.Microchip, trans).registerStat();

		t1Cir = new Achievement("achievement.t1Cir", "t1Cir", 1, -1, mod_IDT.T1CircuitBoard, copperIngot)
				.registerStat();

		t2Cir = new Achievement("achievement.t2Cir", "t2Cir", 1, -2, mod_IDT.T2CircuitBoard, trans).registerStat();

		t3Cir = new Achievement("achievement.t3Cir", "t3Cir", 1, -3, mod_IDT.T3CircuitBoard, mic).registerStat();
		
		comp = new Achievement("achievement.comp", "comp", 1, 0, mod_IDT.CompressorUnit, t1Cir).registerStat();
		
		greenChem = new Achievement("achievement.greenChem", "greenChem", 3, 1,
				Item.getItemFromBlock(mod_IDT.BioFuelExtractor), comp).registerStat();

		kompressor = new Achievement("achievement.kompressor", "kompressor", 3, 0,
				Item.getItemFromBlock(mod_IDT.TankCompressor), comp).registerStat();

		warfareChem = new Achievement("achievement.warfareChem", "warfareChem", 3, 2, mod_IDT.Nitroglycerin, greenChem)
				.registerStat();

		matterCon = new Achievement("achievement.matterCon", "matterCon", 3, -3,
				Item.getItemFromBlock(mod_IDT.MatterCondenser), t3Cir).registerStat();
		
		dmPiece = new Achievement("achievement.dmPiece", "dmPiece", 4, -3, mod_IDT.DarkMatterPiece, matterCon)
				.setSpecial().registerStat();

		darkMatter = new Achievement("achievement.darkMatter", "darkMatter", 4, -4,
				Item.getItemFromBlock(mod_IDT.DarkMatter), dmPiece).setSpecial().registerStat();

		qMan = new Achievement("achievement.qMan", "qMan", 5, -3, mod_IDT.QMan, dmPiece).setSpecial().registerStat();

		gaComp = new Achievement("achievement.gaComp", "gaComp", -1, -6, mod_IDT.CompressorUnitGA, soPretty)
				.setSpecial().registerStat();

		craftGem = new Achievement("achievement.craftGem", "craftGem", -5, 6, mod_IDT.AmblygoniteGem, crystal)
				.registerStat();

		bhg = new Achievement("achievement.bhg", "bhg", 6, -3, mod_IDT.BlackHoleGenerator, qMan).setSpecial()
				.registerStat();

		fixIt = new Achievement("achievement.fixIt", "fixIt", 4, 1, mod_IDT.BlowTorch, greenChem).registerStat();

		vcIngot = new Achievement("achievement.vcIngot", "vcIngot", 3, 4, mod_IDT.VanadiumCarbideIngot, vanadiumIngot).registerStat()
				.setSpecial();

		vcPick = new Achievement("achievement.vcPick", "vcPick", 3, 5, mod_IDT.VCPick, vcIngot).registerStat();

		mag = new Achievement("achievement.mag", "mag", 3, -2, Item.getItemFromBlock(mod_IDT.Magnetizer), t2Cir)
				.registerStat();

		/*
		 * darkMatterBomb = new Achievement("achievement.darkMatterBomb",
		 * "darkMatterBomb", -8, 2, DarkMatterBomb, titaniumIngot)
		 * .registerStat();
		 */

		// 1st # is horz (x), 2nd # is vert (y)
		// Achievement Page
		Modpage = new AchievementPage("\u00A7bIndustrial Technologies", mineModWood, modPlanks, sadObsidian, cement,
				cementBricks, crystal, essence, healer, zimphnode, zimphnodeBar, zng, steelIngot, titaniumIngot,
				vanadiumIngot, praOre, vanPick, tantalumIngot, tantArmor, didGlass, superReactor, ultimNuke, matterCon,
				darkMatter, AmblygoniteBlock, dts, cutter, soPretty, greenChem, kompressor, warfareChem, uranGlass,
				dimFrost, dimCrystal, smeltering, copperIngot, silicon, trans, mic, t1Cir, t2Cir, t3Cir, dmPiece, qMan,
				gaComp, craftGem, bhg, fixIt, comp, vcIngot, vcPick, mag);

		AchievementPage.registerAchievementPage(Modpage);
	}

	@SuppressWarnings("deprecation")
	private static void addName(String ach, String lang, String name) {
		LanguageRegistry.instance().addStringLocalization("achievement." + ach, lang, name);
	}

	@SuppressWarnings("deprecation")
	private static void addDesc(String ach, String lang, String desc) {
		LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", lang, desc);
	}

	public static void namingAch() {
		// Achievements
		addName("mineModWood", "en_US", "More Woods?!");
		addDesc("mineModWood", "en_US", "Get any of the mod woods");

		addName("modPlanks", "en_US", "More Plank Colors?!");
		addDesc("modPlanks", "en_US", "Get any of the mod wooden planks");

		addName("sadObsidian", "en_US", "Poor Obsidian");
		addDesc("sadObsidian", "en_US", "Make crying obsidian");

		addName("cement", "en_US", "Yay! Uses for Gravel!");
		addDesc("cement", "en_US", "Obtain cement.");

		addName("cementBricks", "en_US", "Gettin' fancy here!");
		addDesc("cementBricks", "en_US", "Make cement bricks");

		addName("crystal", "en_US", "Rare Ores!");
		addDesc("crystal", "en_US", "Obtain a crystal ore, gem, nugget, piece, or dust");

		addName("essence", "en_US", "Magical Stuff?");
		addDesc("essence", "en_US", "Obtain essence of life, fire, earth, air or water");

		addName("healer", "en_US", "Laugh in the Face of Death");
		addDesc("healer", "en_US", "Craft a healer block");

		addName("zimphnode", "en_US", "Zimphnode");
		addDesc("zimphnode", "en_US", "No one really knows what this is...");

		addName("zimphnodeBar", "en_US", "Zimphnode Bar");
		addDesc("zimphnodeBar", "en_US", "No really, what is this stuff?");

		addName("zng", "en_US", "Zimphnode Generator");
		addDesc("zng", "en_US", "How? How does this work?");

		addName("steelIngot", "en_US", "As Strong as Steel");
		addDesc("steelIngot", "en_US", "Obtain a steel ingot");

		addName("titaniumIngot", "en_US", "Stronger than Steel");
		addDesc("titaniumIngot", "en_US", "Obtain a titanium ingot");

		addName("vanadiumIngot", "en_US", "Strong Metal");
		addDesc("vanadiumIngot", "en_US", "Vanadium is one of MCE's favorite elements!");

		addName("praOre", "en_US", "Prase--What?");
		addDesc("praOre", "en_US", "How the hell do I say that?");

		addName("vanPick", "en_US", "Better than Diamond");
		addDesc("vanPick", "en_US", "Craft a vanadium pickaxe");

		addName("tantalumIngot", "en_US", "Fireproof Metal");
		addDesc("tantalumIngot", "en_US", "Obtain a tantalum ingot");

		addName("tantArmor", "en_US", "Fireproof Armor");
		addDesc("tantArmor", "en_US", "Craft tantalum armor");

		addName("didGlass", "en_US", "Didym--What?");
		addDesc("didGlass", "en_US", "Ok really? How do you even?");

		addName("superReactor", "en_US", "Super Charged");
		addDesc("superReactor", "en_US", "Craft a super reactor");

		addName("ultimNuke", "en_US", "Mega-Bomb");
		addDesc("ultimNuke", "en_US", "Craft an ultimate nuker");

		addName("matterCon", "en_US", "Compressed to all Hell");
		addDesc("matterCon", "en_US", "Craft a matter condenser");

		addName("darkMatter", "en_US", "The Darkest Matter Ever");
		addDesc("darkMatter", "en_US", "Make dark matter");

		addName("AmblygoniteBlock", "en_US", "Expensive Block");
		addDesc("AmblygoniteBlock", "en_US", "Craft a Amblygonite block");

		addName("dts", "en_US", "Diamond Tipped Saw");
		addDesc("dts", "en_US", "Craft a diamond saw blade");

		addName("proJeweler", "en_US", "Pro Cutter");
		addDesc("proJeweler", "en_US", "Craft an industrial cutter");

		addName("soPretty", "en_US", "So Pretty");
		addDesc("soPretty", "en_US", "Cut a Amblygonite gem.");

		addName("greenChem", "en_US", "Green Chemistry");
		addDesc("greenChem", "en_US", "Craft a biofuel extractor");

		addName("kompressor", "en_US", "Kompressor");
		addDesc("kompressor", "en_US", "Craft a tank compressor");

		addName("warfareChem", "en_US", "Warfare Chemist");
		addDesc("warfareChem", "en_US", "Make nitroglycerin");

		addName("uranGlass", "en_US", "Is it Safe?");
		addDesc("uranGlass", "en_US", "Craft uranium glass");

		addName("dimFrost", "en_US", "Frostbyte");
		addDesc("dimFrost", "en_US", "Go to the frost dimension");

		addName("dimCrystal", "en_US", "Crystalline");
		addDesc("dimCrystal", "en_US", "Go to the Crystal dimension");

		addName("smeltering", "en_US", "Smeltering");
		addDesc("smeltering", "en_US", "Craft a smelter");

		addName("copperIngot", "en_US", "A Very Common Metal!");
		addDesc("copperIngot", "en_US", "Obtain a copper ingot");

		addName("silicon", "en_US", "Dust Free Zone");
		addDesc("silicon", "en_US", "Obtain silicon dust");

		addName("trans", "en_US", "Transisting");
		addDesc("trans", "en_US", "Craft a transistor");

		addName("mic", "en_US", "ICB");
		addDesc("mic", "en_US", "Craft a microchip");

		addName("t1Cir", "en_US", "Basic Circuit Board");
		addDesc("t1Cir", "en_US", "Craft a tier 1 circuit board");

		addName("t2Cir", "en_US", "Better Than Tier 1");
		addDesc("t2Cir", "en_US", "Craft a tier 2 circuit board");

		addName("t3Cir", "en_US", "The Advanced Board");
		addDesc("t3Cir", "en_US", "Craft a tier 3 circuit board");

		addName("dmPiece", "en_US", "A Piece of.. Something");
		addDesc("dmPiece", "en_US", "Obtain a dark matter piece");

		addName("qMan", "en_US", "Quantum Man");
		addDesc("qMan", "en_US", "Craft a quantum manipulator");

		addName("gaComp", "en_US", "Compress all the Things!");
		addDesc("gaComp", "en_US", "Craft an advanced compressor");

		addName("craftGem", "en_US", "Hardcore Crafting");
		addDesc("craftGem", "en_US", "Craft a crystal gem. How long did that take?");

		addName("bhg", "en_US", "Ruler of Physics");
		addDesc("bhg", "en_US", "Craft a black hole generator");

		addName("fixIt", "en_US", "Fix it! Fix it! Fix it!");
		addDesc("fixIt", "en_US", "Repair a tech block with a blowtorch");

		addName("comp", "en_US", "Compression");
		addDesc("comp", "en_US", "Craft a compressor unit");

		addName("vcIngot", "en_US", "Super Strong Metal");
		addDesc("vcIngot", "en_US", "Craft a vanadium carbide ingot");

		addName("vcPick", "en_US", "Better than Vanadium");
		addDesc("vcPick", "en_US", "Craft a vanadium carbide pickaxe");
		
		addName("mag", "en_US", "How do Magnets Work?");
		addDesc("mag", "en_US", "Craft a magnetizer");
	}
}
