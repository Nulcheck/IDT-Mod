package com.mce.blocks.crops;

import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.mce.common.mod_IDT;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CornCrop extends BlockCrops {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public CornCrop() {
		super();
	}

	@SideOnly(Side.CLIENT)
	public IIcon func_71858_a(int par1, int par2) {
		if (par2 < 7) {
			if (par2 == 6) {
				par2 = 5;
			}
			return this.iconArray[(par2 >> 1)];
		}
		return this.iconArray[3];
	}

	protected Item func_149866_i() {
		return mod_IDT.CornSeeds;
	}

	protected Item func_149865_P() {
		return mod_IDT.Corn;
	}

	@SideOnly(Side.CLIENT)
	public void texture(IIconRegister par1IconRegister) {
		this.iconArray = new IIcon[4];
		for (int i = 0; i < this.iconArray.length; i++) {
			this.iconArray[i] = par1IconRegister.registerIcon("mod_IDT:corn"
					+ "_stage_" + i);
		}
	}

	public void fertilize(World world, int x, int y, int z) {
	}

}
