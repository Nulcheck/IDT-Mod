package com.mce.blocks.crops;

import net.minecraft.block.BlockPotato;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.mce.common.mod_IDT;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoyBeanCrop extends BlockPotato {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;

	public SoyBeanCrop() {
		super();
	}

	@SideOnly(Side.CLIENT)
	public IIcon func_71858_a(int side, int meta) {
		if (meta < 7) {
			if (meta == 6) {
				meta = 5;
			}
			return this.iconArray[(meta >> 1)];
		} else {
			return this.iconArray[3];
		}
	}

	protected Item func_149866_i() {
		return mod_IDT.SoyBeans;
	}

	protected Item func_149865_P() {
		return mod_IDT.SoyBeans;
	}

	@SideOnly(Side.CLIENT)
	public void texture(IIconRegister par1IconRegister) {
		this.iconArray = new IIcon[4];
		for (int i = 0; i < this.iconArray.length; i++) {
			this.iconArray[i] = par1IconRegister.registerIcon("mod_IDT:"
					+ this.getTextureName() + "_stage_" + i);
		}
	}

	public void fertilize(World world, int x, int y, int z) {
	}

}
