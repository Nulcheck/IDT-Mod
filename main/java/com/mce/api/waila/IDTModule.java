package com.mce.api.waila;

import org.apache.logging.log4j.Level;

import com.mce.blocks.MineralBlocks.EinsteiniumBlock;
import com.mce.blocks.MineralBlocks.NeptuniumBlock;
import com.mce.blocks.MineralBlocks.UraniumBlock;
import com.mce.blocks.ModBlocks.ModGlassPane;
import com.mce.blocks.ModBlocks.SBH;
import com.mce.blocks.ModGlass;
import com.mce.blocks.ModOre.EinsteiniumOre;
import com.mce.blocks.ModOre.NeptuniumOre;
import com.mce.blocks.ModOre.UraniumOre;
import com.mce.blocks.explosives.EinsteiniumBomb;
import com.mce.blocks.explosives.NeptuniumBomb;
import com.mce.blocks.explosives.UltimateNuker;
import com.mce.blocks.explosives.UraniumBomb;
import com.mce.blocks.liquids.LiquidNitrogen;

import mcp.mobius.waila.Waila;
import mcp.mobius.waila.api.impl.ModuleRegistrar;

public class IDTModule {
	// Blocks
	public static Class<?> weldersGlass = null;
	public static Class<?> weldersGlassPane = null;
	public static Class<?> esOre = null;
	public static Class<?> npOre = null;
	public static Class<?> uOre = null;
	public static Class<?> esBlock = null;
	public static Class<?> npBlock = null;
	public static Class<?> uBlock = null;
	public static Class<?> esBomb = null;
	public static Class<?> npBomb = null;
	public static Class<?> uBomb = null;
	public static Class<?> nuker = null;
	public static Class<?> sbh = null;
	public static Class<?> ln = null;

	public static void register() {
		try {
			Class<?> blocks = Class.forName("com.mce.common.mod_IDT");
			Waila.log.log(Level.INFO, "IDT mod found.");
		} catch (ClassNotFoundException e) {
			Waila.log.log(Level.INFO, "IDT mod not found.");
			return;
		}

		try {
			weldersGlass = ModGlass.class;
			weldersGlassPane = ModGlassPane.class;
			esOre = EinsteiniumOre.class;
			npOre = NeptuniumOre.class;
			uOre = UraniumOre.class;
			esBlock = EinsteiniumBlock.class;
			npBlock = NeptuniumBlock.class;
			uBlock = UraniumBlock.class;
			esBomb = EinsteiniumBomb.class;
			npBomb = NeptuniumBomb.class;
			uBomb = UraniumBomb.class;
			nuker = UltimateNuker.class;
			sbh = SBH.class;
			ln = LiquidNitrogen.class;
		} catch (Exception e) {
			Waila.log.log(Level.WARN, "[IDT] Class not found. " + e);
			return;
		}

		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), weldersGlass);
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), weldersGlassPane);
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), esOre);
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), npOre);
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), uOre);
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), esBlock);
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), npBlock);
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), uBlock);
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), esBomb);
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), npBomb);
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), uBomb);
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), nuker);
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), sbh);
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), ln);
	}
}
