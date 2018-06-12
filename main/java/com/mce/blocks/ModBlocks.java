package com.mce.blocks;

import java.util.Random;

import com.mce.common.mod_IDT;
import com.mce.entity.tile.TileEntityECR;
import com.mce.entity.tile.TileEntityNCR;
import com.mce.entity.tile.TileEntitySBH;
import com.mce.entity.tile.TileEntitySR;
import com.mce.entity.tile.TileEntityUCR;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ModBlocks extends Block {
	public ModBlocks(Material mat) {
		super(mat);
	}

	public static class HealerBlock extends Block {
		public HealerBlock(Material mat) {
			super(mat);
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public int getRenderBlockPass() {
			return 1;
		}

		// Heals the player
		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX,
				float hitY, float hitZ) {
			player.heal(0.5f);
			return true;
		}
	}

	public static class CryingObsidian extends Block {
		public CryingObsidian(Material mat) {
			super(mat);
			this.setHarvestLevel("pickaxe", 3);
		}

		// Puts the fire out on the player, and replace block with normal
		// obsidian when right clicked with bucket
		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float idk,
				float idk2, float idk3) {
			player.extinguish();
			return true;
		}

		// For when lava runs into the block.
		public void onNeighborBlockChange(World world, int x, int y, int z, int meta) {
			this.checkForHarden(world, x, y, z);
		}

		// Harden
		public void checkForHarden(World world, int x, int y, int z) {
			if (world.getBlock(x, y, z) == this) {
				boolean flag = false;

				if (flag || world.getBlock(x, y, z - 1).getMaterial() == Material.lava) {
					flag = true;
				}

				if (flag || world.getBlock(x, y, z + 1).getMaterial() == Material.lava) {
					flag = true;
				}

				if (flag || world.getBlock(x - 1, y, z).getMaterial() == Material.lava) {
					flag = true;
				}

				if (flag || world.getBlock(x + 1, y, z).getMaterial() == Material.lava) {
					flag = true;
				}

				if (flag || world.getBlock(x, y + 1, z).getMaterial() == Material.lava) {
					flag = true;
				}

				if (flag) {
					world.setBlock(x, y, z, Blocks.snow);
				}
			}
		}
	}

	public static class LavaStone extends Block {
		public LavaStone(Material mat) {
			super(mat);
		}

		// For when water runs into the block.
		public void onNeighborBlockChange(World world, int x, int y, int z, int meta) {
			this.checkForHarden(world, x, y, z);
		}

		// Harden
		private void checkForHarden(World world, int x, int y, int z) {
			if (world.getBlock(x, y, z) == this) {
				boolean flag = false;

				if (flag || world.getBlock(x, y, z - 1).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag || world.getBlock(x, y, z + 1).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag || world.getBlock(x - 1, y, z).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag || world.getBlock(x + 1, y, z).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag || world.getBlock(x, y + 1, z).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag) {
					world.setBlock(x, y, z, Blocks.stone);
				}

			}
		}
	}

	public static class LavaCobble extends Block {
		public LavaCobble(Material mat) {
			super(mat);
		}

		// For when water runs into the block.
		public void onNeighborBlockChange(World world, int x, int y, int z, int meta) {
			this.checkForHarden(world, x, y, z);
		}

		// Harden
		private void checkForHarden(World world, int x, int y, int z) {
			if (world.getBlock(x, y, z) == this) {
				boolean flag = false;

				if (flag || world.getBlock(x, y, z - 1).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag || world.getBlock(x, y, z + 1).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag || world.getBlock(x - 1, y, z).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag || world.getBlock(x + 1, y, z).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag || world.getBlock(x, y + 1, z).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag) {
					world.setBlock(x, y, z, Blocks.cobblestone);
				}

			}
		}
	}

	public static class LavaObsidian extends Block {
		public LavaObsidian(Material mat) {
			super(mat);
			this.setHarvestLevel("pickaxe", 3);
		}

		// For when water runs into the block.
		public void onNeighborBlockChange(World world, int x, int y, int z, int meta) {
			this.checkForHarden(world, x, y, z);
		}

		// Harden
		private void checkForHarden(World world, int x, int y, int z) {
			if (world.getBlock(x, y, z) == this) {
				boolean flag = false;

				if (flag || world.getBlock(x, y, z - 1).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag || world.getBlock(x, y, z + 1).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag || world.getBlock(x - 1, y, z).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag || world.getBlock(x + 1, y, z).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag || world.getBlock(x, y + 1, z).getMaterial() == Material.water) {
					flag = true;
				}

				if (flag) {
					world.setBlock(x, y, z, Blocks.snow);
				}
			}
		}
	}

	public static class CrystalBlock extends Block {
		public CrystalBlock(Material mat) {
			super(mat);
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public int getRenderBlockPass() {
			return 1;
		}

		// Makes it see through like ice
		public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
			return super.shouldSideBeRendered(blockAccess, x, y, z, 1 - side);
		}

		// 0 = Push & move over (Most blocks)
		// 1 = Free (Drops into an item)
		// 2 = Stop piston
		public int getMobilityFlag() {
			return 1;
		}
	}

	public static class ModGlassPane extends BlockPane {
		public ModGlassPane(String s1, String s2, Material mat, boolean itemDrop) {
			super(s1, s1, mat, itemDrop);
		}

		public int getRenderBlockPass() {
			return 1;
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public final boolean canPaneConnectToModBlock(Block block) {
			return block.func_149730_j() || block == mod_IDT.EinsteiniumGlass || block == mod_IDT.NeptuniumGlass
					|| block == mod_IDT.UraniumGlass || block == mod_IDT.DidymiumGlass
					|| block == mod_IDT.ReinforcedGlass || block == Blocks.glass || block == Blocks.stained_glass
					|| block == Blocks.stained_glass_pane || block instanceof BlockPane;
		}

		public boolean canPaneConnectTo(IBlockAccess world, int x, int y, int z, ForgeDirection dir) {
			return canPaneConnectToModBlock(world.getBlock(x, y, z))
					|| world.isSideSolid(x, y, z, dir.getOpposite(), false);
		}
	}

	public static class DarkMatter extends Block {
		private boolean glow;

		public DarkMatter(Material mat, boolean glow) {
			super(mat);
			this.glow = glow;
			this.setHarvestLevel("pickaxe", 3);
		}

		// Tick for particles
		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.glow) {
				this.dust(world, x, y, z);
			}
		}

		public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
			entity.attackEntityFrom(DamageSource.generic, 3);
			super.onEntityWalking(world, x, y, z, entity);
		}

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float idk,
				float idk2, float idk3) {
			player.addPotionEffect(new PotionEffect(2, 1000, 3));
			player.addPotionEffect(new PotionEffect(4, 1000, 3));
			player.attackEntityFrom(DamageSource.generic, 3);
			return true;
		}

		// Particles!
		private void dust(World world, int x, int y, int z) {
			Random rand = world.rand;
			double d0 = 0.0625D;

			for (int l = 0; l < 6; ++l) {
				double d1 = (double) ((float) x + rand.nextFloat());
				double d2 = (double) ((float) y + rand.nextFloat());
				double d3 = (double) ((float) z + rand.nextFloat());

				if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) {
					d2 = (double) (y + 1) + d0;
				}

				if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) {
					d2 = (double) (y + 0) - d0;
				}

				if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) {
					d3 = (double) (z + 1) + d0;
				}

				if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) {
					d3 = (double) (z + 0) - d0;
				}

				if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 1) + d0;
				}

				if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) {
					d1 = (double) (x + 0) - d0;
				}

				if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D || d2 > (double) (y + 1) || d3 < (double) z
						|| d3 > (double) (z + 1)) {
					mod_IDT.proxy.spawnParticle(world, x, y, z, "darkMatterFx");
				}
			}
		}
	}

	// Stable black hole
	public static class SBH extends Block {
		public SBH(Material mat) {
			super(mat);
			// float f = 0.0625f;
			this.setBlockBounds(0.2f, 0.2f, 0.2f, 0.8f, 0.8f, 0.8f);
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public int getRenderBlockPass() {
			return 1;
		}

		public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
			float f = 0.0625F;
			// return AxisAlignedBB.getBoundingBox((double) ((float) x + f),
			// (double) y, (double) ((float) z + f),(double) ((float) (x + 1) -
			// f), (double) ((float) (y + 1) - f), (double) ((float) (z + 1) -
			// f));
			return AxisAlignedBB.getBoundingBox(0.2d, 0.2d, 0.2d, 0.8d, 0.8d, 0.8d);
		}

		@SideOnly(Side.CLIENT)
		public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
			float f = 0.0625F;
			return AxisAlignedBB.getBoundingBox(0.2d, 0.2d, 0.2d, 0.8d, 0.8d, 0.8d);
		}

		public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
			entity.attackEntityFrom(DamageSource.generic, 1.0F);
			super.onEntityCollidedWithBlock(world, x, y, z, entity);
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntitySBH();
		}
	}

	public static class EinsteiniumCoreReactor extends BlockContainer {
		public EinsteiniumCoreReactor(Material mat) {
			super(mat);
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			super.onBlockAdded(world, x, y, z);
			this.setDefaultDirection(world, x, y, z);
		}

		public void setDefaultDirection(World world, int x, int y, int z) {
			if (!world.isRemote) {
				Block block = world.getBlock(x, y, z - 1);
				Block block1 = world.getBlock(x, y, z + 1);
				Block block2 = world.getBlock(x - 1, y, z);
				Block block3 = world.getBlock(x + 1, y, z);
				byte b0 = 0;

				if (block.func_149730_j() && !block1.func_149730_j()) {
					b0 = 3;
				}

				if (block1.func_149730_j() && !block.func_149730_j()) {
					b0 = 2;
				}

				if (block2.func_149730_j() && !block3.func_149730_j()) {
					b0 = 5;
				}

				if (block3.func_149730_j() && !block2.func_149730_j()) {
					b0 = 4;
				}

				world.setBlockMetadataWithNotify(x, y, z, b0, 2);
			}
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityECR();
		}

		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
			int l = MathHelper.floor_double((double) (entity.rotationYaw * 4f / 360f) + .5d) & 3;

			if (l == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 2, 1);
			}

			if (l == 1) {
				world.setBlockMetadataWithNotify(x, y, z, 5, 1);
			}

			if (l == 3) {
				world.setBlockMetadataWithNotify(x, y, z, 3, 1);
			}

			if (l == 4) {
				world.setBlockMetadataWithNotify(x, y, z, 4, 1);
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
	}

	public static class NeptuniumCoreReactor extends BlockContainer {
		public NeptuniumCoreReactor(Material mat) {
			super(mat);
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			super.onBlockAdded(world, x, y, z);
			this.setDefaultDirection(world, x, y, z);
		}

		public void setDefaultDirection(World world, int x, int y, int z) {
			if (!world.isRemote) {
				Block block = world.getBlock(x, y, z - 1);
				Block block1 = world.getBlock(x, y, z + 1);
				Block block2 = world.getBlock(x - 1, y, z);
				Block block3 = world.getBlock(x + 1, y, z);
				byte b0 = 0;

				if (block.func_149730_j() && !block1.func_149730_j()) {
					b0 = 3;
				}

				if (block1.func_149730_j() && !block.func_149730_j()) {
					b0 = 2;
				}

				if (block2.func_149730_j() && !block3.func_149730_j()) {
					b0 = 5;
				}

				if (block3.func_149730_j() && !block2.func_149730_j()) {
					b0 = 4;
				}

				world.setBlockMetadataWithNotify(x, y, z, b0, 2);
			}
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityNCR();
		}

		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
			int l = MathHelper.floor_double((double) (entity.rotationYaw * 4f / 360f) + .5d) & 3;

			if (l == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 2, 1);
			}

			if (l == 1) {
				world.setBlockMetadataWithNotify(x, y, z, 5, 1);
			}

			if (l == 3) {
				world.setBlockMetadataWithNotify(x, y, z, 3, 1);
			}

			if (l == 4) {
				world.setBlockMetadataWithNotify(x, y, z, 4, 1);
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
	}

	public static class UraniumCoreReactor extends BlockContainer {
		public UraniumCoreReactor(Material mat) {
			super(mat);
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			super.onBlockAdded(world, x, y, z);
			this.setDefaultDirection(world, x, y, z);
		}

		public void setDefaultDirection(World world, int x, int y, int z) {
			if (!world.isRemote) {
				Block block = world.getBlock(x, y, z - 1);
				Block block1 = world.getBlock(x, y, z + 1);
				Block block2 = world.getBlock(x - 1, y, z);
				Block block3 = world.getBlock(x + 1, y, z);
				byte b0 = 0;

				if (block.func_149730_j() && !block1.func_149730_j()) {
					b0 = 3;
				}

				if (block1.func_149730_j() && !block.func_149730_j()) {
					b0 = 2;
				}

				if (block2.func_149730_j() && !block3.func_149730_j()) {
					b0 = 5;
				}

				if (block3.func_149730_j() && !block2.func_149730_j()) {
					b0 = 4;
				}

				world.setBlockMetadataWithNotify(x, y, z, b0, 2);
			}
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityUCR();
		}

		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
			int l = MathHelper.floor_double((double) (entity.rotationYaw * 4f / 360f) + .5d) & 3;

			if (l == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 2, 1);
			}

			if (l == 1) {
				world.setBlockMetadataWithNotify(x, y, z, 5, 1);
			}

			if (l == 3) {
				world.setBlockMetadataWithNotify(x, y, z, 3, 1);
			}

			if (l == 4) {
				world.setBlockMetadataWithNotify(x, y, z, 4, 1);
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
	}

	public static class SuperReactor extends BlockContainer {
		public SuperReactor(Material mat) {
			super(mat);
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			super.onBlockAdded(world, x, y, z);
			this.setDefaultDirection(world, x, y, z);
		}

		public void setDefaultDirection(World world, int x, int y, int z) {
			if (!world.isRemote) {
				Block block = world.getBlock(x, y, z - 1);
				Block block1 = world.getBlock(x, y, z + 1);
				Block block2 = world.getBlock(x - 1, y, z);
				Block block3 = world.getBlock(x + 1, y, z);
				byte b0 = 0;

				if (block.func_149730_j() && !block1.func_149730_j()) {
					b0 = 3;
				}

				if (block1.func_149730_j() && !block.func_149730_j()) {
					b0 = 2;
				}

				if (block2.func_149730_j() && !block3.func_149730_j()) {
					b0 = 5;
				}

				if (block3.func_149730_j() && !block2.func_149730_j()) {
					b0 = 4;
				}

				world.setBlockMetadataWithNotify(x, y, z, b0, 2);
			}
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntitySR();
		}

		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
			int l = MathHelper.floor_double((double) (entity.rotationYaw * 4f / 360f) + .5d) & 3;

			if (l == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 2, 1);
			}

			if (l == 1) {
				world.setBlockMetadataWithNotify(x, y, z, 5, 1);
			}

			if (l == 3) {
				world.setBlockMetadataWithNotify(x, y, z, 3, 1);
			}

			if (l == 4) {
				world.setBlockMetadataWithNotify(x, y, z, 4, 1);
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
	}

	public static class CrystalGlass extends Block {
		public CrystalGlass(Material mat) {
			super(mat);
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			return null;
		}

		public boolean isOpaqueCube() {
			return false;
		}

		public int getRenderBlockPass() {
			return 1;
		}
	}

	public static class CrystalRock extends Block {
		public CrystalRock(Material mat) {
			super(mat);
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			int i = rand.nextInt(3);

			if (i >= 2 && i <= 3) {
				return mod_IDT.PureQuartz;
			}

			else {
				return mod_IDT.CrystalDust;
			}
		}

		public int quantityDropped(Random ran) {
			return 2 + ran.nextInt(2);
		}
	}
}