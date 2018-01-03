package com.mce.handlers;

import com.mce.common.mod_IDT;
import com.mce.container.BFEContainer;
import com.mce.container.BHGContainer;
import com.mce.container.IndustrialCutterContainer;
import com.mce.container.MagnetizerContainer;
import com.mce.container.MatterCondenserContainer;
import com.mce.container.ModContainerWorkbench;
import com.mce.container.SmelterContainer;
import com.mce.container.TankCompressorContainer;
import com.mce.container.WelderContainer;
import com.mce.container.ZNGContainer;
import com.mce.entity.tile.tech.TileEntityBFE;
import com.mce.entity.tile.tech.TileEntityBHG;
import com.mce.entity.tile.tech.TileEntityIndustrialCutter;
import com.mce.entity.tile.tech.TileEntityMagnetizer;
import com.mce.entity.tile.tech.TileEntityMatterCondenser;
import com.mce.entity.tile.tech.TileEntitySmelter;
import com.mce.entity.tile.tech.TileEntityTankCompressor;
import com.mce.entity.tile.tech.TileEntityWelder;
import com.mce.entity.tile.tech.TileEntityZNG;
import com.mce.gui.BFEGui;
import com.mce.gui.BHGGui;
import com.mce.gui.IndustrialCutterGui;
import com.mce.gui.MagnetizerGui;
import com.mce.gui.MatterCondenserGui;
import com.mce.gui.SmelterGui;
import com.mce.gui.TankCompressorGui;
import com.mce.gui.WelderGui;
import com.mce.gui.ZNGGui;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GUIHandler implements IGuiHandler {

	public GUIHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(mod_IDT.instance, this);
	}

	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {

			switch (id) {
			case mod_IDT.BirchCraftingTableGUI:
				return (id == 0) && (world.getBlock(x, y, z) == mod_IDT.BirchCraftingTable)
						? new ModContainerWorkbench(player.inventory, world, x, y, z) : null;

			case mod_IDT.SpruceCraftingTableGUI:
				return (id == 1) && (world.getBlock(x, y, z) == mod_IDT.SpruceCraftingTable)
						? new ModContainerWorkbench(player.inventory, world, x, y, z) : null;

			case mod_IDT.JungleCraftingTableGUI:
				return (id == 2) && (world.getBlock(x, y, z) == mod_IDT.JungleCraftingTable)
						? new ModContainerWorkbench(player.inventory, world, x, y, z) : null;

			case mod_IDT.WillowCraftingTableGUI:
				return (id == 3) && (world.getBlock(x, y, z) == mod_IDT.WillowCraftingTable)
						? new ModContainerWorkbench(player.inventory, world, x, y, z) : null;

			case mod_IDT.EbonyCraftingTableGUI:
				return (id == 4) && (world.getBlock(x, y, z) == mod_IDT.EbonyCraftingTable)
						? new ModContainerWorkbench(player.inventory, world, x, y, z) : null;

			case mod_IDT.SmelterGUI:
				if (entity instanceof TileEntitySmelter) {
					return new SmelterContainer(player.inventory, (TileEntitySmelter) entity);
				}

			case mod_IDT.MatterCondenserGUI:
				if (entity instanceof TileEntityMatterCondenser) {
					return new MatterCondenserContainer(player.inventory, (TileEntityMatterCondenser) entity);
				}

			case mod_IDT.ZNGGUI:
				if (entity instanceof TileEntityZNG) {
					return new ZNGContainer(player.inventory, (TileEntityZNG) entity);
				}

			case mod_IDT.SilkwoodCraftingTableGUI:
				return (id == 9) && (world.getBlock(x, y, z) == mod_IDT.SilkwoodCraftingTable)
						? new ModContainerWorkbench(player.inventory, world, x, y, z) : null;

			case mod_IDT.BFEGUI:
				if (entity instanceof TileEntityBFE) {
					return new BFEContainer(player.inventory, (TileEntityBFE) entity);
				}

			case mod_IDT.TankCompressorGUI:
				if (entity instanceof TileEntityTankCompressor) {
					return new TankCompressorContainer(player.inventory, (TileEntityTankCompressor) entity);
				}

			case mod_IDT.IndustrialCutterGUI:
				if (entity instanceof TileEntityIndustrialCutter) {
					return new IndustrialCutterContainer(player.inventory, (TileEntityIndustrialCutter) entity);
				}

			case mod_IDT.AcaciaCraftingTableGUI:
				return (id == 13) && (world.getBlock(x, y, z) == mod_IDT.AcaciaCraftingTable)
						? new ModContainerWorkbench(player.inventory, world, x, y, z) : null;

			case mod_IDT.DarkOakCraftingTableGUI:
				return (id == 14) && (world.getBlock(x, y, z) == mod_IDT.DarkOakCraftingTable)
						? new ModContainerWorkbench(player.inventory, world, x, y, z) : null;

			case mod_IDT.GelidCraftingTableGUI:
				return (id == 15) && (world.getBlock(x, y, z) == mod_IDT.GelidCraftingTable)
						? new ModContainerWorkbench(player.inventory, world, x, y, z) : null;

			case mod_IDT.WelderGUI:
				if (entity instanceof TileEntityWelder) {
					return new WelderContainer(player.inventory, (TileEntityWelder) entity);
				}

			case mod_IDT.MagnetizerGUI:
				if (entity instanceof TileEntityMagnetizer) {
					return new MagnetizerContainer(player.inventory, (TileEntityMagnetizer) entity);
				}

			case mod_IDT.BHGGUI:
				if (entity instanceof TileEntityBHG) {
					return new BHGContainer(player.inventory, (TileEntityBHG) entity);
				}
			}
		}

		return null;
	}

	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {

			switch (id) {
			case mod_IDT.BirchCraftingTableGUI:
				return (id == 0) && (world.getBlock(x, y, z) == mod_IDT.BirchCraftingTable)
						? new GuiCrafting(player.inventory, world, x, y, z) : null;

			case mod_IDT.SpruceCraftingTableGUI:
				return (id == 1) && (world.getBlock(x, y, z) == mod_IDT.SpruceCraftingTable)
						? new GuiCrafting(player.inventory, world, x, y, z) : null;

			case mod_IDT.JungleCraftingTableGUI:
				return (id == 2) && (world.getBlock(x, y, z) == mod_IDT.JungleCraftingTable)
						? new GuiCrafting(player.inventory, world, x, y, z) : null;

			case mod_IDT.WillowCraftingTableGUI:
				return (id == 3) && (world.getBlock(x, y, z) == mod_IDT.WillowCraftingTable)
						? new GuiCrafting(player.inventory, world, x, y, z) : null;

			case mod_IDT.EbonyCraftingTableGUI:
				return (id == 4) && (world.getBlock(x, y, z) == mod_IDT.EbonyCraftingTable)
						? new GuiCrafting(player.inventory, world, x, y, z) : null;

			case mod_IDT.SmelterGUI:
				if (entity instanceof TileEntitySmelter) {
					return new SmelterGui(player.inventory, (TileEntitySmelter) entity);
				}

			case mod_IDT.MatterCondenserGUI:
				if (entity instanceof TileEntityMatterCondenser) {
					return new MatterCondenserGui(player.inventory, (TileEntityMatterCondenser) entity);
				}

			case mod_IDT.ZNGGUI:
				if (entity instanceof TileEntityZNG) {
					return new ZNGGui(player.inventory, (TileEntityZNG) entity);
				}

			case mod_IDT.SilkwoodCraftingTableGUI:
				return (id == 9) && (world.getBlock(x, y, z) == mod_IDT.SilkwoodCraftingTable)
						? new GuiCrafting(player.inventory, world, x, y, z) : null;

			case mod_IDT.BFEGUI:
				if (entity instanceof TileEntityBFE) {
					return new BFEGui(player.inventory, (TileEntityBFE) entity);
				}

			case mod_IDT.TankCompressorGUI:
				if (entity instanceof TileEntityTankCompressor) {
					return new TankCompressorGui(player.inventory, (TileEntityTankCompressor) entity);
				}

			case mod_IDT.IndustrialCutterGUI:
				if (entity instanceof TileEntityIndustrialCutter) {
					return new IndustrialCutterGui(player.inventory, (TileEntityIndustrialCutter) entity);
				}

			case mod_IDT.AcaciaCraftingTableGUI:
				return (id == 13) && (world.getBlock(x, y, z) == mod_IDT.AcaciaCraftingTable)
						? new GuiCrafting(player.inventory, world, x, y, z) : null;

			case mod_IDT.DarkOakCraftingTableGUI:
				return (id == 14) && (world.getBlock(x, y, z) == mod_IDT.DarkOakCraftingTable)
						? new GuiCrafting(player.inventory, world, x, y, z) : null;

			case mod_IDT.GelidCraftingTableGUI:
				return (id == 15) && (world.getBlock(x, y, z) == mod_IDT.GelidCraftingTable)
						? new GuiCrafting(player.inventory, world, x, y, z) : null;

			case mod_IDT.WelderGUI:
				if (entity instanceof TileEntityWelder) {
					return new WelderGui(player.inventory, (TileEntityWelder) entity);
				}

			case mod_IDT.MagnetizerGUI:
				if (entity instanceof TileEntityMagnetizer) {
					return new MagnetizerGui(player.inventory, (TileEntityMagnetizer) entity);
				}
			case mod_IDT.BHGGUI:
				if (entity instanceof TileEntityBHG) {
					return new BHGGui(player.inventory, (TileEntityBHG) entity);
				}
			}
		}

		return null;
	}
}