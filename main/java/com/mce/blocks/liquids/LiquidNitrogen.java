package com.mce.blocks.liquids;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class LiquidNitrogen extends BlockFluidClassic {
	protected IIcon stillIcon;
	protected IIcon flowingIcon;
	EntityPlayer player;

	public LiquidNitrogen(Fluid fluid, Material mat) {
		super(fluid, mat);
	}

	public IIcon getIcon(int side, int meta) {
		return (side == 0 || side == 1) ? stillIcon : flowingIcon;
	}

	public void registerBlockIcons(IIconRegister register) {
		stillIcon = register.registerIcon("mod_IDT:liquid_nitrogen_still");
		flowingIcon = register.registerIcon("mod_IDT:liquid_nitrogen_flow");
	}

	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		entity.attackEntityFrom(DamageSource.generic, 2f);

		if (entity instanceof EntityLivingBase) {
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(2, 500, 1, false));
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(4, 500, 1, false));
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(18, 500, 1, false));
		}

		super.onEntityCollidedWithBlock(world, x, y, z, entity);
	}
}
