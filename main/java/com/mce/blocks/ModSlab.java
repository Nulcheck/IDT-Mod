package com.mce.blocks;

import com.mce.common.mod_IDT;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModSlab extends BlockSlab {
	public static final String[] metas = { "0", "1", "2", "3", "4", "5", "6", "7", "8" };
	public final boolean stack;

	public ModSlab(boolean stack, Material mat) {
		super(stack, mat);
		useNeighborBrightness = true;
		this.stack = stack;
	}

	public void setBlockBoundsBasedOnState(IBlockAccess mesh, int x, int y, int z) {
		if (this.stack) {
			this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		} else {
			boolean flag = (mesh.getBlockMetadata(x, y, z) & 8) != 0;

			boolean flagV1 = mesh.getBlockMetadata(x, y, z) == 1;
			boolean flagV2 = mesh.getBlockMetadata(x, y, z) == 2;
			boolean flagV3 = mesh.getBlockMetadata(x, y, z) == 3;
			boolean flagV4 = mesh.getBlockMetadata(x, y, z) == 4;

			if (flag) {
				this.setBlockBounds(0F, .5F, 0F, 1F, 1F, 1F);
			}

			else if (flagV1) {
				this.setBlockBounds(0f, 0f, 0f, 1f, 1f, .5f);
			}

			else if (flagV2) {
				this.setBlockBounds(.5f, 0f, 0f, 1f, 1f, 1f);
			}

			else if (flagV3) {
				this.setBlockBounds(0f, 0f, .5f, 1f, 1f, 1f);
			}

			else if (flagV4) {
				this.setBlockBounds(0f, 0f, 0f, .5f, 1f, 1f);
			}

			else {
				this.setBlockBounds(0F, 0F, 0F, 1F, .5F, 1F);
			}
		}
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}
	
	public int getRenderBlockPass() {
		return 1;
	}

	public String getFullSlabName(int id) {
		if (id < 0) {
			id = 0;
		}
		return super.getUnlocalizedName() + "." + metas[id];
	}

	public static boolean isBlockSingleSlab(ModSlab slab) {
		return slab == mod_IDT.WillowSlab || slab == mod_IDT.CementSlab || slab == mod_IDT.CementBrickSlab
				|| slab == mod_IDT.StoneSlab || slab == mod_IDT.GlassSlab || slab == mod_IDT.GlassSlabWhite
				|| slab == mod_IDT.GlassSlabOrange || slab == mod_IDT.GlassSlabMagenta
				|| slab == mod_IDT.GlassSlabLightBlue || slab == mod_IDT.GlassSlabYellow
				|| slab == mod_IDT.GlassSlabLime || slab == mod_IDT.GlassSlabPink || slab == mod_IDT.GlassSlabGray
				|| slab == mod_IDT.GlassSlabLightGray || slab == mod_IDT.GlassSlabCyan
				|| slab == mod_IDT.GlassSlabPurple || slab == mod_IDT.GlassSlabBlue || slab == mod_IDT.GlassSlabBlue
				|| slab == mod_IDT.GlassSlabBrown || slab == mod_IDT.GlassSlabGreen || slab == mod_IDT.GlassSlabRed
				|| slab == mod_IDT.GlassSlabBlack || slab == mod_IDT.EbonySlab || slab == mod_IDT.SilkwoodSlab
				|| slab == mod_IDT.GelidSlab;
	}

	public int getDamageValue(World world, int x, int y, int z) {
		return super.getDamageValue(world, x, y, z) & 7;
	}

	// Pick blocking for creative
	public Item getItem(World world, int x, int y, int z) {
		return isBlockSingleSlab(this) ? Item.getItemFromBlock(this)
				: (this == mod_IDT.WillowDoubleSlab ? Item.getItemFromBlock(mod_IDT.WillowSlab)
						: (this == mod_IDT.EbonyDoubleSlab ? Item.getItemFromBlock(mod_IDT.EbonySlab)
								: (this == mod_IDT.SilkwoodDoubleSlab ? Item.getItemFromBlock(mod_IDT.SilkwoodSlab)
										: (this == mod_IDT.CementDoubleSlab ? Item.getItemFromBlock(mod_IDT.CementSlab)
												: (this == mod_IDT.CementBrickDoubleSlab ? Item.getItemFromBlock(
														mod_IDT.CementBrickSlab)
														: (this == mod_IDT.StoneDoubleSlab
																? Item.getItemFromBlock(mod_IDT.StoneSlab)
																: (this == mod_IDT.GlassDoubleSlab
																		? Item.getItemFromBlock(mod_IDT.GlassSlab)
																		: (this == mod_IDT.GlassDoubleSlabWhite
																				? Item.getItemFromBlock(
																						mod_IDT.GlassSlabWhite)
																				: (this == mod_IDT.GlassDoubleSlabOrange
																						? Item.getItemFromBlock(
																								mod_IDT.GlassSlabOrange)
																						: (this == mod_IDT.GlassDoubleSlabMagenta
																								? Item.getItemFromBlock(
																										mod_IDT.GlassSlabMagenta)
																								: (this == mod_IDT.GlassDoubleSlabLightBlue
																										? Item.getItemFromBlock(
																												mod_IDT.GlassSlabLightBlue)
																										: (this == mod_IDT.GlassDoubleSlabYellow
																												? Item.getItemFromBlock(
																														mod_IDT.GlassSlabYellow)
																												: (this == mod_IDT.GlassDoubleSlabLime
																														? Item.getItemFromBlock(
																																mod_IDT.GlassSlabLime)
																														: (this == mod_IDT.GlassDoubleSlabPink
																																? Item.getItemFromBlock(
																																		mod_IDT.GlassSlabPink)
																																: (this == mod_IDT.GlassDoubleSlabGray
																																		? Item.getItemFromBlock(
																																				mod_IDT.GlassSlabGray)
																																		: (this == mod_IDT.GlassDoubleSlabLightGray
																																				? Item.getItemFromBlock(
																																						mod_IDT.GlassSlabLightGray)
																																				: (this == mod_IDT.GlassDoubleSlabCyan
																																						? Item.getItemFromBlock(
																																								mod_IDT.GlassSlabCyan)
																																						: (this == mod_IDT.GlassDoubleSlabPurple
																																								? Item.getItemFromBlock(
																																										mod_IDT.GlassSlabPurple)
																																								: (this == mod_IDT.GlassDoubleSlabBlue
																																										? Item.getItemFromBlock(
																																												mod_IDT.GlassSlabBlue)
																																										: (this == mod_IDT.GlassDoubleSlabBrown
																																												? Item.getItemFromBlock(
																																														mod_IDT.GlassSlabBrown)
																																												: (this == mod_IDT.GlassDoubleSlabGreen
																																														? Item.getItemFromBlock(
																																																mod_IDT.GlassSlabGreen)
																																														: (this == mod_IDT.GlassDoubleSlabRed
																																																? Item.getItemFromBlock(
																																																		mod_IDT.GlassSlabRed)
																																																: (this == mod_IDT.GlassDoubleSlabBlack
																																																		? Item.getItemFromBlock(
																																																				mod_IDT.GlassSlabBlack)
																																																		: (this == mod_IDT.GelidDoubleSlab
																																																				? Item.getItemFromBlock(
																																																						mod_IDT.GelidSlab)
																																																				: Item.getItemFromBlock(
																																																						mod_IDT.WillowSlab)))))))))))))))))))))))));
	}

	public String func_150002_b(int id) {
		return getFullSlabName(id);
	}
}
