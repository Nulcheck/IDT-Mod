package com.mce.api.waila;

import java.lang.reflect.Method;

import org.apache.logging.log4j.Level;

import com.mce.blocks.MineralBlocks.EinsteiniumBlock;
import com.mce.blocks.MineralBlocks.NeptuniumBlock;
import com.mce.blocks.MineralBlocks.UraniumBlock;
import com.mce.blocks.ModBlocks.MetalFrame;
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
import com.mce.entity.tile.tech.TileEntityBFE;
import com.mce.entity.tile.tech.TileEntityBHG;
import com.mce.entity.tile.tech.TileEntityIndustrialCutter;
import com.mce.entity.tile.tech.TileEntityMagnetizer;
import com.mce.entity.tile.tech.TileEntityMatterCondenser;
import com.mce.entity.tile.tech.TileEntitySmelter;
import com.mce.entity.tile.tech.TileEntityTankCompressor;
import com.mce.entity.tile.tech.TileEntityZNG;

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
	public static Class<?> metalFrame = null;

	public static Class<?> smelter = null;
	public static Method smelter_damage = null;
	public static Method smelter_damageMax = null;
	public static Method smelter_mode = null;

	public static Class<?> bfe = null;
	public static Method bfe_damage = null;
	public static Method bfe_damageMax = null;
	public static Method bfe_tier = null;

	public static Class<?> bhg = null;
	public static Method bhg_damage = null;
	public static Method bhg_damageMax = null;
	public static Method bhg_tier = null;

	public static Class<?> cutter = null;
	public static Method cutter_damage = null;
	public static Method cutter_damageMax = null;
	public static Method cutter_tier = null;

	public static Class<?> mag = null;
	public static Method mag_damage = null;
	public static Method mag_damageMax = null;
	public static Method mag_tier = null;

	public static Class<?> tc = null;
	public static Method tc_damage = null;
	public static Method tc_damageMax = null;
	public static Method tc_tier = null;

	public static Class<?> mc = null;
	public static Method mc_damage = null;
	public static Method mc_damageMax = null;
	public static Method mc_tier = null;

	public static Class<?> zng = null;
	public static Method zng_damage = null;
	public static Method zng_damageMax = null;

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
			metalFrame = MetalFrame.class;

			smelter = TileEntitySmelter.class;
			smelter_damage = smelter.getMethod("getDamage");
			smelter_damageMax = smelter.getMethod("getMaxDamage");
			smelter_mode = smelter.getMethod("getMode");

			bfe = TileEntityBFE.class;
			bfe_damage = bfe.getMethod("getDamage");
			bfe_damageMax = bfe.getMethod("getMaxDamage");

			bhg = TileEntityBHG.class;
			bhg_damage = bhg.getMethod("getDamage");
			bhg_damageMax = bhg.getMethod("getMaxDamage");

			mag = TileEntityMagnetizer.class;
			mag_damage = mag.getMethod("getDamage");
			mag_damageMax = mag.getMethod("getMaxDamage");

			cutter = TileEntityIndustrialCutter.class;
			cutter_damage = cutter.getMethod("getDamage");
			cutter_damageMax = cutter.getMethod("getMaxDamage");

			tc = TileEntityTankCompressor.class;
			tc_damage = tc.getMethod("getDamage");
			tc_damageMax = tc.getMethod("getMaxDamage");

			mc = TileEntityMatterCondenser.class;
			mc_damage = mc.getMethod("getDamage");
			mc_damageMax = mc.getMethod("getMaxDamage");

			zng = TileEntityZNG.class;
			zng_damage = zng.getMethod("getDamage");
			zng_damageMax = zng.getMethod("getMaxDamage");
		} catch (Exception e) {
			Waila.log.log(Level.WARN, "[IDT] Class not found. " + e);
			return;
		}

		ModuleRegistrar.instance().registerBodyProvider(new HUDHandlerIDT(), smelter);
		ModuleRegistrar.instance().registerNBTProvider(new HUDHandlerIDT(), smelter);
		ModuleRegistrar.instance().registerBodyProvider(new HUDHandlerIDT(), bfe);
		ModuleRegistrar.instance().registerNBTProvider(new HUDHandlerIDT(), bfe);
		ModuleRegistrar.instance().registerBodyProvider(new HUDHandlerIDT(), bhg);
		ModuleRegistrar.instance().registerNBTProvider(new HUDHandlerIDT(), bhg);
		ModuleRegistrar.instance().registerBodyProvider(new HUDHandlerIDT(), cutter);
		ModuleRegistrar.instance().registerNBTProvider(new HUDHandlerIDT(), cutter);
		ModuleRegistrar.instance().registerBodyProvider(new HUDHandlerIDT(), tc);
		ModuleRegistrar.instance().registerNBTProvider(new HUDHandlerIDT(), tc);
		ModuleRegistrar.instance().registerBodyProvider(new HUDHandlerIDT(), mc);
		ModuleRegistrar.instance().registerNBTProvider(new HUDHandlerIDT(), mc);
		ModuleRegistrar.instance().registerBodyProvider(new HUDHandlerIDT(), mag);
		ModuleRegistrar.instance().registerNBTProvider(new HUDHandlerIDT(), mag);
		ModuleRegistrar.instance().registerBodyProvider(new HUDHandlerIDT(), zng);
		ModuleRegistrar.instance().registerNBTProvider(new HUDHandlerIDT(), zng);

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
		ModuleRegistrar.instance().registerTailProvider(new HUDHandlerIDT(), metalFrame);
	}
}
