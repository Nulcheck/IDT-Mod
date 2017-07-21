package com.mce.api.nei;

import com.mce.common.mod_IDT;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Optional;
import net.minecraft.item.ItemStack;

/**
 * This class hides things from the NEI sidebar thing and registers recipe
 * handlers.
 */

@Optional.Interface(iface = "codechicken.nei.api.API", modid = "NotEnoughItems")
public class NEIIDTConfig implements IConfigureNEI {

	@Optional.Method(modid = "NotEnoughItems")
	public String getName() {
		return "IDT NEI Plugin";
	}

	@Optional.Method(modid = "NotEnoughItems")
	public String getVersion() {
		return mod_IDT.class.getAnnotation(Mod.class).version();
	}

	@Optional.Method(modid = "NotEnoughItems")
	public void loadConfig() {
		// Recipe Lookup helpers
		API.registerRecipeHandler(new SmelterNEIRecipeHandler());
		API.registerUsageHandler(new SmelterNEIRecipeHandler());
		API.registerRecipeHandler(new CutterNEIRecipeHandler());
		API.registerUsageHandler(new CutterNEIRecipeHandler());
		API.registerRecipeHandler(new BFENEIRecipeHandler());
		API.registerUsageHandler(new BFENEIRecipeHandler());
		API.registerRecipeHandler(new MCNEIRecipeHandler());
		API.registerUsageHandler(new MCNEIRecipeHandler());
		API.registerRecipeHandler(new TCNEIRecipeHandler());
		API.registerUsageHandler(new TCNEIRecipeHandler());
		API.registerRecipeHandler(new MagnetNEIRecipeHandler());
		API.registerUsageHandler(new MagnetNEIRecipeHandler());
		API.registerRecipeHandler(new BHGNEIRecipeHandler());
		API.registerUsageHandler(new BHGNEIRecipeHandler());
		API.registerRecipeHandler(new ZNGNEIRecipeHandler());
		API.registerUsageHandler(new ZNGNEIRecipeHandler());
		API.registerRecipeHandler(new WelderNEIRecipeHandler());
		API.registerUsageHandler(new WelderNEIRecipeHandler());

		// Hide Items
		API.hideItem(new ItemStack(mod_IDT.BirchDoor));
		API.hideItem(new ItemStack(mod_IDT.SpruceDoor));
		API.hideItem(new ItemStack(mod_IDT.JungleDoor));
		API.hideItem(new ItemStack(mod_IDT.AcaciaDoor));
		API.hideItem(new ItemStack(mod_IDT.DarkOakDoor));
		API.hideItem(new ItemStack(mod_IDT.WillowDoor));
		API.hideItem(new ItemStack(mod_IDT.EbonyDoor));
		API.hideItem(new ItemStack(mod_IDT.SilkwoodDoor));
		API.hideItem(new ItemStack(mod_IDT.GelidDoor));
		API.hideItem(new ItemStack(mod_IDT.FrozenFire));
		API.hideItem(new ItemStack(mod_IDT.CrystalFire));
		API.hideItem(new ItemStack(mod_IDT.FrozenPortal));
		API.hideItem(new ItemStack(mod_IDT.CrystalPortal));
		API.hideItem(new ItemStack(mod_IDT.SoyBeanCrop));
		API.hideItem(new ItemStack(mod_IDT.CornCrop));
		API.hideItem(new ItemStack(mod_IDT.LiquidNitrogen));
		API.hideItem(new ItemStack(mod_IDT.BirchRedTorch));
		API.hideItem(new ItemStack(mod_IDT.SpruceRedTorch));
		API.hideItem(new ItemStack(mod_IDT.JungleRedTorch));
		API.hideItem(new ItemStack(mod_IDT.AcaciaRedTorch));
		API.hideItem(new ItemStack(mod_IDT.DarkOakRedTorch));
		API.hideItem(new ItemStack(mod_IDT.WillowRedTorch));
		API.hideItem(new ItemStack(mod_IDT.EbonyRedTorch));
		API.hideItem(new ItemStack(mod_IDT.SilkwoodRedTorch));
		API.hideItem(new ItemStack(mod_IDT.WillowDoubleSlab));
		API.hideItem(new ItemStack(mod_IDT.EbonyDoubleSlab));
		API.hideItem(new ItemStack(mod_IDT.SilkwoodDoubleSlab));
		API.hideItem(new ItemStack(mod_IDT.GelidDoubleSlab));
		API.hideItem(new ItemStack(mod_IDT.CementDoubleSlab));
		API.hideItem(new ItemStack(mod_IDT.CementBrickDoubleSlab));
		API.hideItem(new ItemStack(mod_IDT.StoneDoubleSlab));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlab));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabWhite));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabOrange));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabMagenta));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabLightBlue));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabYellow));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabLime));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabPink));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabGray));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabLightGray));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabCyan));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabPurple));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabBlue));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabBrown));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabGreen));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabRed));
		API.hideItem(new ItemStack(mod_IDT.GlassDoubleSlabBlack));
	}
}