package com.mce.handlers.registers;

import com.mce.common.mod_IDT;
import com.mce.entity.mobs.EntityIcePhantom;
import com.mce.entity.mobs.EntityIcyCreeper;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public class MobRegistry {
	private static int entityID = 0;
	private static BiomeGenBase[] frostMobs = { BiomeRegistry.FrostForest, BiomeRegistry.FrostBarren,
			BiomeRegistry.FrostBiome };

	public static void preInit() {
		registerEntity(EntityIcePhantom.class, "Ice Phantom", 168, 255, 255, 48, 184, 252);
		registerEntity(EntityIcyCreeper.class, "Icy Creeper", 168, 255, 255, 0, 0, 0);
		spawnEntities();
	}

	// Register an Entity with a spawn egg
	private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int bgRed, int bgGreen,
			int bgBlue, int fgRed, int fgGreen, int fgBlue) {
		EntityRegistry.registerGlobalEntityID(entityClass, "mod_IDT." + entityName,
				EntityRegistry.findGlobalUniqueEntityId(), getRGBInt(bgRed, bgGreen, bgBlue),
				getRGBInt(fgRed, fgGreen, fgBlue));
		registerEntity(entityClass, entityName);
	}

	// Register an Entity without a spawn egg
	private static void registerEntity(Class<? extends Entity> entityClass, String entityName) {
		EntityRegistry.registerModEntity(entityClass, entityName, entityID++, mod_IDT.instance, 64, 3, true);
	}

	private static int getRGBInt(int rInt, int gInt, int bInt) {
		return (rInt << 16) + (gInt << 8) + bInt;
	}

	public static void spawnEntities() {
		EntityRegistry.addSpawn(EntityIcePhantom.class, 10, 2, 5, EnumCreatureType.creature, frostMobs);
		EntityRegistry.addSpawn(EntityIcyCreeper.class, 10, 2, 5, EnumCreatureType.monster, frostMobs);
	}
}
