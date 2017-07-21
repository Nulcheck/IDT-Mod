package com.mce.blocks.workbench;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.mce.common.mod_IDT;
import com.mce.entity.tile.TECT;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class JungleWorkbench extends BlockContainer {
	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon side;
	private static final String __OBFID = "CL_00000221";

	public JungleWorkbench() {
		super(Material.wood);
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.top : (side == 0 ? Blocks.planks
				.getBlockTextureFromSide(1)
				: (side != 2 && side != 4 ? this.blockIcon : this.side));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon("mod_IDT:jungle_crafting_table"
				+ "_side");
		this.top = icon.registerIcon("mod_IDT:jungle_crafting_table" + "_top");
		this.side = icon.registerIcon("mod_IDT:jungle_crafting_table"
				+ "_front");
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		player.openGui(mod_IDT.instance, mod_IDT.JungleCraftingTableGUI,
				player.worldObj, x, y, z);
		return true;
	}

	public TileEntity createNewTileEntity(World world, int id) {
		return new TECT();
	}
}
