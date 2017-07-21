package com.mce.blocks.explosives;

import com.mce.common.mod_IDT;
import com.mce.entity.explosives.EntityUB;
import com.mce.entity.tile.bombs.TileEntityUB;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class UraniumBomb extends BlockContainer {
	IIcon blockIcon;

	public UraniumBomb() {
		super(Material.tnt);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);

		if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
			this.onBlockDestroyedByPlayer(world, x, y, z, 1);
			world.setBlockToAir(x, y, z);
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
			this.onBlockDestroyedByPlayer(world, x, y, z, 1);
			world.setBlockToAir(x, y, z);
		}
	}

	public void onBlockDestroyedByExplosion(World world, int x, int y, int z, Explosion exp) {
		if (!world.isRemote) {
			EntityUB ub = new EntityUB(world, (double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
					(double) ((float) z + 0.5F), exp.getExplosivePlacedBy());
			ub.fuse = world.rand.nextInt(ub.fuse / 4) + ub.fuse / 8;
			world.spawnEntityInWorld(ub);
		}
	}

	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int rad) {
		this.primeTnt(world, x, y, z, rad, (EntityLivingBase) null);
	}

	public void primeTnt(World world, int x, int y, int z, int meta, EntityLivingBase entity) {
		if (!world.isRemote) {
			if ((meta & 1) == 1) {
				EntityUB ub = new EntityUB(world, (double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
						(double) ((float) z + 0.5F), entity);
				world.spawnEntityInWorld(ub);
				world.playSoundAtEntity(ub, "random.fuse", 1.0F, 1.0F);
			}
		}
	}

	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityUB();
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX,
			float hitY, float hitZ) {
		if (player.getCurrentEquippedItem() != null
				&& player.getCurrentEquippedItem().getItem() == Item.getItemFromBlock(Blocks.redstone_torch)
				|| player.getCurrentEquippedItem().getItem() == Item.getItemFromBlock(mod_IDT.BirchRedTorchOn)
				|| player.getCurrentEquippedItem().getItem() == Item.getItemFromBlock(mod_IDT.SpruceRedTorchOn)
				|| player.getCurrentEquippedItem().getItem() == Item.getItemFromBlock(mod_IDT.JungleRedTorchOn)
				|| player.getCurrentEquippedItem().getItem() == Item.getItemFromBlock(mod_IDT.WillowRedTorchOn)
				|| player.getCurrentEquippedItem().getItem() == Item.getItemFromBlock(mod_IDT.EbonyRedTorchOn)
				|| player.getCurrentEquippedItem().getItem() == Item.getItemFromBlock(mod_IDT.SilkwoodRedTorchOn)
				|| player.getCurrentEquippedItem().getItem() == Item.getItemFromBlock(mod_IDT.DarkOakRedTorchOn)
				|| player.getCurrentEquippedItem().getItem() == Item.getItemFromBlock(mod_IDT.AcaciaRedTorchOn)
				|| player.getCurrentEquippedItem().getItem() == Item.getItemFromBlock(mod_IDT.GelidRedTorchOn)) {
			this.primeTnt(world, x, y, z, 1, player);
			world.setBlockToAir(x, y, z);
			player.getCurrentEquippedItem().damageItem(1, player);
			return true;
		} else {
			System.out.println("An error has occurred! Error ID: IDT-304e");
			return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
		}
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderBlockPass() {
		return -1;
	}

	public void registerIcons(IIconRegister reg) {
		this.blockIcon = reg.registerIcon("iron_block");
	}
}
