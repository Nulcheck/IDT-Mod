package com.mce.blocks;

import java.util.Random;

import com.mce.common.mod_IDT;
import com.mce.entity.tile.TEAH;
import com.mce.entity.tile.TileEntityECR;
import com.mce.entity.tile.TileEntityNCR;
import com.mce.entity.tile.TileEntitySBH;
import com.mce.entity.tile.TileEntitySR;
import com.mce.entity.tile.TileEntityTF;
import com.mce.entity.tile.TileEntityUCR;
import com.mce.entity.tile.tech.TileEntityBFE;
import com.mce.entity.tile.tech.TileEntityBHG;
import com.mce.entity.tile.tech.TileEntityEnricher;
import com.mce.entity.tile.tech.TileEntityIndustrialCutter;
import com.mce.entity.tile.tech.TileEntityMagnetizer;
import com.mce.entity.tile.tech.TileEntityMatterCondenser;
import com.mce.entity.tile.tech.TileEntitySmelter;
import com.mce.entity.tile.tech.TileEntityTankCompressor;
import com.mce.entity.tile.tech.TileEntityWelder;
import com.mce.entity.tile.tech.TileEntityZNG;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
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

	public static class TitaniumFrame extends BlockContainer {
		public TitaniumFrame(Material mat) {
			super(mat);
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityTF();
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

	public static class Smelter extends BlockContainer {
		@SideOnly(Side.CLIENT)
		private IIcon top;
		@SideOnly(Side.CLIENT)
		private IIcon side;
		private Random rand = new Random();

		private static boolean keepInv;
		private final boolean isActive;

		public Smelter(Material mat, boolean isActive) {
			super(mat);
			this.isActive = isActive;
		}

		@SideOnly(Side.CLIENT)
		public IIcon getIcon(int side, int meta) {
			return meta == 0 && side == 3 ? this.side : (side == meta ? this.side : this.top);
			// return side == 1 ? this.top : (side == 0 ? this.top : (side !=
			// meta ? this.blockIcon : this.side));
		}

		@SideOnly(Side.CLIENT)
		public void registerBlockIcons(IIconRegister icon) {
			this.blockIcon = icon.registerIcon("mod_IDT:smelter_side");
			this.side = icon.registerIcon("mod_IDT:" + (this.isActive ? "smelter_front_active" : "smelter_front_idle"));
			this.top = icon.registerIcon("mod_IDT:smelter_top");
		}

		public Item getItemDropped(int i, Random rand, int j) {
			return Item.getItemFromBlock(mod_IDT.SmelterIdle);
		}

		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.SmelterIdle);
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			TileEntity tile = (TileEntitySmelter) world.getTileEntity(x, y, z);
			super.onBlockAdded(world, x, y, z);
			this.setDefaultDirection(world, x, y, z);

			if (tile instanceof TileEntitySmelter) {
				TileEntitySmelter smelter = (TileEntitySmelter) tile;
				smelter.setDamage(smelter.maxDamage);
			}
		}

		public void setDefaultDirection(World world, int x, int y, int z) {
			if (!world.isRemote) {
				Block block = world.getBlock(x, y, z - 1);
				Block block1 = world.getBlock(x, y, z + 1);
				Block block2 = world.getBlock(x - 1, y, z);
				Block block3 = world.getBlock(x + 1, y, z);
				byte b0 = 3;

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

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX,
				float hitY, float hitZ) {
			if (!world.isRemote) {
				player.openGui(mod_IDT.instance, mod_IDT.SmelterGUI, world, x, y, z);
			}
			return true;
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntitySmelter();
		}

		/*
		 * public int damageDropped(int damage) { return damage; }
		 */

		@SideOnly(Side.CLIENT)
		public void randomDisplayTick(World world, int x, int y, int z, Random random) {
			if (this.isActive) {
				int dir = world.getBlockMetadata(x, y, z);
				float x1 = (float) x + 0.5f;
				float y1 = (float) y + random.nextFloat();
				float z1 = (float) z + 0.5f;

				float f = .52f;
				float f1 = random.nextFloat() * .6f - .3f;

				if (dir == 4) {
					world.spawnParticle("smoke", (double) (x1 - f), (double) (y1), (double) (z1 + f1), 0d, 0d, 0d);
					world.spawnParticle("flame", (double) (x1 - f), (double) (y1), (double) (z1 + f1), 0d, 0d, 0d);
				}

				else if (dir == 5) {
					world.spawnParticle("smoke", (double) (x1 + f), (double) (y1), (double) (z1 + f1), 0d, 0d, 0d);
					world.spawnParticle("flame", (double) (x1 + f), (double) (y1), (double) (z1 + f1), 0d, 0d, 0d);
				}

				else if (dir == 2) {
					world.spawnParticle("smoke", (double) (x1 + f1), (double) (y1), (double) (z1 - f), 0d, 0d, 0d);
					world.spawnParticle("flame", (double) (x1 + f1), (double) (y1), (double) (z1 - f), 0d, 0d, 0d);
				}

				else if (dir == 3) {
					world.spawnParticle("smoke", (double) (x1 + f1), (double) (y1), (double) (z1 + f), 0d, 0d, 0d);
					world.spawnParticle("flame", (double) (x1 + f1), (double) (y1), (double) (z1 + f), 0d, 0d, 0d);
				}
			}
		}

		/*
		 * protected void processDrop(World world, int x, int y, int z,
		 * TileEntitySmelter te, ItemStack stack) {
		 * DamageHandlerUtil.setDamageForItem(stack, (te).getDamage()); }
		 */

		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
			int l = MathHelper.floor_double((double) (entity.rotationYaw * 4f / 360f) + .5D) & 3;

			if (l == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 2, 1);
			}

			if (l == 1) {
				world.setBlockMetadataWithNotify(x, y, z, 5, 1);
			}

			if (l == 2) {
				world.setBlockMetadataWithNotify(x, y, z, 3, 1);
			}

			if (l == 3) {
				world.setBlockMetadataWithNotify(x, y, z, 4, 1);
			}

			if (stack.hasDisplayName()) {
				((TileEntitySmelter) world.getTileEntity(x, y, z)).setGuiDisplayName(stack.getDisplayName());
			}

			world.markBlockForUpdate(x, y, z);
		}

		public static void updateState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
			int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

			TileEntity te = worldObj.getTileEntity(xCoord, yCoord, zCoord);
			keepInv = true;

			if (active) {
				worldObj.setBlock(xCoord, yCoord, zCoord, mod_IDT.SmelterActive);
				
			} else {
				worldObj.setBlock(xCoord, yCoord, zCoord, mod_IDT.SmelterIdle);
			}

			keepInv = false;
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

			if (te != null) {
				te.validate();
				worldObj.setTileEntity(xCoord, yCoord, zCoord, te);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
			if (!keepInv) {
				TileEntitySmelter entity = (TileEntitySmelter) world.getTileEntity(x, y, z);

				if (entity != null) {
					for (int i = 0; i < entity.getSizeInv(); i++) {
						ItemStack stack = entity.getStackInSlot(i);

						if (stack != null) {
							float f = this.rand.nextFloat() * .8f + .1f;
							float f1 = this.rand.nextFloat() * .8f + .1f;
							float f2 = this.rand.nextFloat() * .8f + .1f;

							while (stack.stackSize > 0) {
								int j = this.rand.nextInt(21) + 10;

								if (j > stack.stackSize) {
									j = stack.stackSize;
								}

								stack.stackSize -= j;

								EntityItem item = new EntityItem(world, (double) ((float) x + f),
										(double) ((float) y + f1), (double) ((float) z + f2),
										new ItemStack(stack.getItem(), j, stack.getItemDamage()));

								// Check items for tag and load it
								if (stack.hasTagCompound()) {
									item.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
								}

								// Set motion to dropped items
								float f3 = .05f;
								item.motionX = (double) ((float) this.rand.nextGaussian() * f3);
								item.motionY = (double) ((float) this.rand.nextGaussian() * f3 + .2f);
								item.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

								world.spawnEntityInWorld(item);
							}
						}
					}
					world.getBlock(x, y, z);
				}
			}
			super.breakBlock(world, x, y, z, block, meta);
		}

		public boolean hasComparatorInputOverride() {
			return true;
		}

		public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
			return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
		}
	}

	public static class BioFuelExtractor extends BlockContainer {
		private Random rand = new Random();

		private static boolean keepInv;
		public static boolean isActive;

		public BioFuelExtractor(Material mat) {
			super(mat);
		}

		// Creative middle click
		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.BioFuelExtractor);
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			TileEntityBFE bfe = (TileEntityBFE) world.getTileEntity(x, y, z);

			super.onBlockAdded(world, x, y, z);
			bfe.damage = bfe.maxDamage;

			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				BioFuelExtractor.isActive = true;
			} else {
				BioFuelExtractor.isActive = false;
			}
		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				BioFuelExtractor.isActive = true;
			} else {
				BioFuelExtractor.isActive = false;
			}
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityBFE();
		}

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX,
				float hitY, float hitZ) {

			player.openGui(mod_IDT.instance, mod_IDT.BFEGUI, world, x, y, z);
			return true;
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

			if (stack.hasDisplayName()) {
				((TileEntityBFE) world.getTileEntity(x, y, z)).setGuiDisplayName(stack.getDisplayName());
			}
		}

		public static void updateState(boolean active, World world, int x, int y, int z) {
			int i = world.getBlockMetadata(x, y, z);

			TileEntity te = world.getTileEntity(x, y, z);
			keepInv = true;

			if (active) {
				// idfk
			} else {
				// idfk either..
			}

			keepInv = false;
			world.setBlockMetadataWithNotify(x, y, z, i, 2);

			if (te != null) {
				te.validate();
				world.setTileEntity(x, y, z, te);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
			if (!keepInv) {
				TileEntityBFE entity = (TileEntityBFE) world.getTileEntity(x, y, z);

				if (entity != null) {
					for (int i = 0; i < entity.getSizeInv(); i++) {
						ItemStack stack = entity.getStackInSlot(i);

						if (stack != null) {
							float f = this.rand.nextFloat() * .8f + .1f;
							float f1 = this.rand.nextFloat() * .8f + .1f;
							float f2 = this.rand.nextFloat() * .8f + .1f;

							while (stack.stackSize > 0) {
								int j = this.rand.nextInt(21) + 10;

								if (j > stack.stackSize) {
									j = stack.stackSize;
								}

								stack.stackSize -= j;

								EntityItem item = new EntityItem(world, (double) ((float) x + f),
										(double) ((float) y + f1), (double) ((float) z + f2),
										new ItemStack(stack.getItem(), j, stack.getItemDamage()));

								// Check items for tag and load it
								if (stack.hasTagCompound()) {
									item.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
								}

								// Set motion to dropped items
								float f3 = .05f;
								item.motionX = (double) ((float) this.rand.nextGaussian() * f3);
								item.motionY = (double) ((float) this.rand.nextGaussian() * f3 + .2f);
								item.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

								world.spawnEntityInWorld(item);
							}
						}
					}
					world.getBlock(x, y, z);
				}
			}
			super.breakBlock(world, x, y, z, block, meta);
		}

		// Comparator stuff!
		public boolean hasComparatorOverride(World world, int x, int y, int z) {
			return true;
		}

		public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
			return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
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

	public static class TankCompressor extends BlockContainer {
		private Random rand = new Random();

		private static boolean keepInv;
		public static boolean isActive;

		public TankCompressor(Material mat) {
			super(mat);
		}

		// Creative middle click
		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.TankCompressor);
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			TileEntityTankCompressor tc = (TileEntityTankCompressor) world.getTileEntity(x, y, z);

			super.onBlockAdded(world, x, y, z);
			this.setDefaultDirection(world, x, y, z);
			tc.damage = tc.maxDamage;

			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				TankCompressor.isActive = true;
			} else {
				TankCompressor.isActive = false;
			}
		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				TankCompressor.isActive = true;
			} else {
				TankCompressor.isActive = false;
			}
		}

		public void setDefaultDirection(World world, int x, int y, int z) {
			if (!world.isRemote) {
				Block block = world.getBlock(x, y, z - 1);
				Block block1 = world.getBlock(x, y, z + 1);
				Block block2 = world.getBlock(x - 1, y, z);
				Block block3 = world.getBlock(x + 1, y, z);
				byte b0 = 3;

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
			return new TileEntityTankCompressor();
		}

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX,
				float hitY, float hitZ) {

			player.openGui(mod_IDT.instance, mod_IDT.TankCompressorGUI, world, x, y, z);
			return true;
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

			if (stack.hasDisplayName()) {
				((TileEntityTankCompressor) world.getTileEntity(x, y, z)).setGuiDisplayName(stack.getDisplayName());
			}
		}

		public static void updateState(boolean active, World world, int x, int y, int z) {
			int i = world.getBlockMetadata(x, y, z);

			TileEntity te = world.getTileEntity(x, y, z);
			keepInv = true;

			if (active) {
				// idfk
			} else {
				// idfk either..
			}

			keepInv = false;
			world.setBlockMetadataWithNotify(x, y, z, i, 2);

			if (te != null) {
				te.validate();
				world.setTileEntity(x, y, z, te);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
			if (!keepInv) {
				TileEntityTankCompressor entity = (TileEntityTankCompressor) world.getTileEntity(x, y, z);

				if (entity != null) {
					for (int i = 0; i < entity.getSizeInv(); i++) {
						ItemStack stack = entity.getStackInSlot(i);

						if (stack != null) {
							float f = this.rand.nextFloat() * .8f + .1f;
							float f1 = this.rand.nextFloat() * .8f + .1f;
							float f2 = this.rand.nextFloat() * .8f + .1f;

							while (stack.stackSize > 0) {
								int j = this.rand.nextInt(21) + 10;

								if (j > stack.stackSize) {
									j = stack.stackSize;
								}

								stack.stackSize -= j;

								EntityItem item = new EntityItem(world, (double) ((float) x + f),
										(double) ((float) y + f1), (double) ((float) z + f2),
										new ItemStack(stack.getItem(), j, stack.getItemDamage()));

								// Check items for tag and load it
								if (stack.hasTagCompound()) {
									item.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
								}

								// Set motion to dropped items
								float f3 = .05f;
								item.motionX = (double) ((float) this.rand.nextGaussian() * f3);
								item.motionY = (double) ((float) this.rand.nextGaussian() * f3 + .2f);
								item.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

								world.spawnEntityInWorld(item);
							}
						}
					}
					world.getBlock(x, y, z);
				}
			}
			super.breakBlock(world, x, y, z, block, meta);
		}

		// Comparator stuff!
		public boolean hasComparatorOverride(World world, int x, int y, int z) {
			return true;
		}

		public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
			return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
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

	public static class ZNG extends BlockContainer {
		private Random rand = new Random();

		private static boolean keepInv;
		public static boolean isActive;

		public ZNG(Material mat) {
			super(mat);
		}

		// Creative middle click
		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.ZNG);
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			TileEntityZNG zng = (TileEntityZNG) world.getTileEntity(x, y, z);

			super.onBlockAdded(world, x, y, z);
			zng.damage = zng.maxDamage;

			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				ZNG.isActive = true;
			} else {
				ZNG.isActive = false;
			}
		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				ZNG.isActive = true;
			} else {
				ZNG.isActive = false;
			}
		}

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX,
				float hitY, float hitZ) {
			player.openGui(mod_IDT.instance, mod_IDT.ZNGGUI, world, x, y, z);
			return true;
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityZNG();
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

			if (stack.hasDisplayName()) {
				((TileEntityZNG) world.getTileEntity(x, y, z)).setGuiDisplayName(stack.getDisplayName());
			}
		}

		public static void updateState(boolean active, World world, int x, int y, int z) {
			int i = world.getBlockMetadata(x, y, z);

			TileEntity te = world.getTileEntity(x, y, z);
			keepInv = true;

			if (active) {
				// idfk
			} else {
				// idfk either..
			}

			keepInv = false;
			world.setBlockMetadataWithNotify(x, y, z, i, 2);

			if (te != null) {
				te.validate();
				world.setTileEntity(x, y, z, te);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
			if (!keepInv) {
				TileEntityZNG entity = (TileEntityZNG) world.getTileEntity(x, y, z);

				if (entity != null) {
					for (int i = 0; i < entity.getSizeInv(); i++) {
						ItemStack stack = entity.getStackInSlot(i);

						if (stack != null) {
							float f = this.rand.nextFloat() * .8f + .1f;
							float f1 = this.rand.nextFloat() * .8f + .1f;
							float f2 = this.rand.nextFloat() * .8f + .1f;

							while (stack.stackSize > 0) {
								int j = this.rand.nextInt(21) + 10;

								if (j > stack.stackSize) {
									j = stack.stackSize;
								}

								stack.stackSize -= j;

								EntityItem item = new EntityItem(world, (double) ((float) x + f),
										(double) ((float) y + f1), (double) ((float) z + f2),
										new ItemStack(stack.getItem(), j, stack.getItemDamage()));

								// Check items for tag and load it
								if (stack.hasTagCompound()) {
									item.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
								}

								// Set motion to dropped items
								float f3 = .05f;
								item.motionX = (double) ((float) this.rand.nextGaussian() * f3);
								item.motionY = (double) ((float) this.rand.nextGaussian() * f3 + .2f);
								item.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

								world.spawnEntityInWorld(item);
							}
						}
					}
					world.getBlock(x, y, z);
				}
			}
			super.breakBlock(world, x, y, z, block, meta);
		}

		// Comparator stuff!
		public boolean hasComparatorOverride(World world, int x, int y, int z) {
			return true;
		}

		public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
			return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
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

	public static class IndustrialCutter extends BlockContainer {
		private Random rand = new Random();

		private static boolean keepInv;
		public static boolean isActive;

		public IndustrialCutter(Material mat) {
			super(mat);
		}

		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.IndustrialCutter);
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			TileEntityIndustrialCutter gc = (TileEntityIndustrialCutter) world.getTileEntity(x, y, z);

			super.onBlockAdded(world, x, y, z);
			this.setDefaultDirection(world, x, y, z);
			gc.damage = gc.maxDamage;

			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				IndustrialCutter.isActive = true;
			} else {
				IndustrialCutter.isActive = false;
			}
		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				IndustrialCutter.isActive = true;
			} else {
				IndustrialCutter.isActive = false;
			}
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

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX,
				float hitY, float hitZ) {
			player.openGui(mod_IDT.instance, mod_IDT.IndustrialCutterGUI, world, x, y, z);
			return true;
		}

		public TileEntity createNewTileEntity(World world, int id) {
			return new TileEntityIndustrialCutter();
		}

		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
			int l = MathHelper.floor_double((double) (entity.rotationYaw * 4f / 360f) + .5d) & 3;

			if (l == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 2, 1);
			}

			if (l == 1) {
				world.setBlockMetadataWithNotify(x, y, z, 5, 1);
			}

			if (l == 2) {
				world.setBlockMetadataWithNotify(x, y, z, 3, 1);
			}

			if (l == 3) {
				world.setBlockMetadataWithNotify(x, y, z, 4, 1);
			}

			if (stack.hasDisplayName()) {
				((TileEntityIndustrialCutter) world.getTileEntity(x, y, z)).setGuiDisplayName(stack.getDisplayName());
			}
		}

		public static void updateState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
			int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

			TileEntity te = worldObj.getTileEntity(xCoord, yCoord, zCoord);
			keepInv = true;

			if (active) {
				// idfk
			} else {
				// idfk either
			}

			keepInv = false;
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

			if (te != null) {
				te.validate();
				worldObj.setTileEntity(xCoord, yCoord, zCoord, te);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
			if (!keepInv) {
				TileEntityIndustrialCutter entity = (TileEntityIndustrialCutter) world.getTileEntity(x, y, z);

				if (entity != null) {
					for (int i = 0; i < entity.getSizeInv(); i++) {
						ItemStack stack = entity.getStackInSlot(i);

						if (stack != null) {
							float f = this.rand.nextFloat() * .8f + .1f;
							float f1 = this.rand.nextFloat() * .8f + .1f;
							float f2 = this.rand.nextFloat() * .8f + .1f;

							while (stack.stackSize > 0) {
								int j = this.rand.nextInt(21) + 10;

								if (j > stack.stackSize) {
									j = stack.stackSize;
								}

								stack.stackSize -= j;

								EntityItem item = new EntityItem(world, (double) ((float) x + f),
										(double) ((float) y + f1), (double) ((float) z + f2),
										new ItemStack(stack.getItem(), j, stack.getItemDamage()));

								// Check items for tag and load it
								if (stack.hasTagCompound()) {
									item.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
								}

								// Set motion to dropped items
								float f3 = .05f;
								item.motionX = (double) ((float) this.rand.nextGaussian() * f3);
								item.motionY = (double) ((float) this.rand.nextGaussian() * f3 + .2f);
								item.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

								world.spawnEntityInWorld(item);
							}
						}
					}
					world.getBlock(x, y, z);
				}
			}
			super.breakBlock(world, x, y, z, block, meta);
		}

		// Comparator stuff!
		public boolean hasComparatorInputOverride() {
			return true;
		}

		public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
			return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
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

	public static class AdvancedHealer extends BlockContainer {
		public AdvancedHealer(Material mat) {
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
			return new TEAH();
		}

		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
			int l = MathHelper.floor_double((double) (entity.rotationYaw * 4f / 360f) + .5d) & 3;

			if (l == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 2, 1);
			}

			if (l == 1) {
				world.setBlockMetadataWithNotify(x, y, z, 5, 1);
			}

			if (l == 2) {
				world.setBlockMetadataWithNotify(x, y, z, 3, 1);
			}

			if (l == 3) {
				world.setBlockMetadataWithNotify(x, y, z, 4, 1);
			}

			/*
			 * if (stack.hasDisplayName()) { ((TET) world.getTileEntity(x, y,
			 * z)).setGuiDisplayName(stack.getDisplayName()); }
			 */
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

	public static class MatterCondenser extends BlockContainer {
		private Random rand = new Random();

		private static boolean keepInv;
		public static boolean isActive;

		public MatterCondenser(Material mat) {
			super(mat);
		}

		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.MatterCondenser);
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			TileEntityMatterCondenser mc = (TileEntityMatterCondenser) world.getTileEntity(x, y, z);

			super.onBlockAdded(world, x, y, z);
			mc.damage = mc.maxDamage;

			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				MatterCondenser.isActive = true;
			} else {
				MatterCondenser.isActive = false;
			}
		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				MatterCondenser.isActive = true;
			} else {
				MatterCondenser.isActive = false;
			}
		}

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX,
				float hitY, float hitZ) {

			player.openGui(mod_IDT.instance, mod_IDT.MatterCondenserGUI, world, x, y, z);
			return true;
		}

		public TileEntity createNewTileEntity(World world, int id) {
			return new TileEntityMatterCondenser();
		}

		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
			int l = MathHelper.floor_double((double) (entity.rotationYaw * 4f / 360f) + .5d) & 3;

			if (l == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 2, 1);
			}

			if (l == 1) {
				world.setBlockMetadataWithNotify(x, y, z, 5, 1);
			}

			if (l == 2) {
				world.setBlockMetadataWithNotify(x, y, z, 3, 1);
			}

			if (l == 3) {
				world.setBlockMetadataWithNotify(x, y, z, 4, 1);
			}

			if (stack.hasDisplayName()) {
				((TileEntityMatterCondenser) world.getTileEntity(x, y, z)).setGuiDisplayName(stack.getDisplayName());
			}
		}

		public static void updateState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
			int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

			TileEntity te = worldObj.getTileEntity(xCoord, yCoord, zCoord);
			keepInv = true;

			if (active) {
				// idfk
			} else {
				// idfk either
			}

			keepInv = false;
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

			if (te != null) {
				te.validate();
				worldObj.setTileEntity(xCoord, yCoord, zCoord, te);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
			if (!keepInv) {
				TileEntityMatterCondenser entity = (TileEntityMatterCondenser) world.getTileEntity(x, y, z);

				if (entity != null) {
					for (int i = 0; i < entity.getSizeInv(); i++) {
						ItemStack stack = entity.getStackInSlot(i);

						if (stack != null) {
							float f = this.rand.nextFloat() * .8f + .1f;
							float f1 = this.rand.nextFloat() * .8f + .1f;
							float f2 = this.rand.nextFloat() * .8f + .1f;

							while (stack.stackSize > 0) {
								int j = this.rand.nextInt(21) + 10;

								if (j > stack.stackSize) {
									j = stack.stackSize;
								}

								stack.stackSize -= j;

								EntityItem item = new EntityItem(world, (double) ((float) x + f),
										(double) ((float) y + f1), (double) ((float) z + f2),
										new ItemStack(stack.getItem(), j, stack.getItemDamage()));

								// Check items for tag and load it
								if (stack.hasTagCompound()) {
									item.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
								}

								// Set motion to dropped items
								float f3 = .05f;
								item.motionX = (double) ((float) this.rand.nextGaussian() * f3);
								item.motionY = (double) ((float) this.rand.nextGaussian() * f3 + .2f);
								item.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

								world.spawnEntityInWorld(item);
							}
						}
					}
					world.getBlock(x, y, z);
				}
			}
			super.breakBlock(world, x, y, z, block, meta);
		}

		// Comparator stuff!
		public boolean hasComparatorInputOverride() {
			return true;
		}

		public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
			return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
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

	public static class BHG extends BlockContainer {
		private Random rand = new Random();

		private static boolean keepInv;
		public static boolean isActive;

		public BHG(Material mat) {
			super(mat);
		}

		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.BlackHoleGenerator);
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityBHG();
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			TileEntityBHG bhg = (TileEntityBHG) world.getTileEntity(x, y, z);

			super.onBlockAdded(world, x, y, z);
			this.setDefaultDirection(world, x, y, z);
			bhg.damage = bhg.maxDamage;

			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				BHG.isActive = true;
			} else {
				BHG.isActive = false;
			}
		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				BHG.isActive = true;
			} else {
				BHG.isActive = false;
			}
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

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX,
				float hitY, float hitZ) {

			player.openGui(mod_IDT.instance, mod_IDT.BHGGUI, world, x, y, z);
			return true;
		}

		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
			int l = MathHelper.floor_double((double) (entity.rotationYaw * 4f / 360f) + .5d) & 3;

			if (l == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 2, 1);
			}

			if (l == 1) {
				world.setBlockMetadataWithNotify(x, y, z, 5, 1);
			}

			if (l == 2) {
				world.setBlockMetadataWithNotify(x, y, z, 3, 1);
			}

			if (l == 3) {
				world.setBlockMetadataWithNotify(x, y, z, 4, 1);
			}

			if (stack.hasDisplayName()) {
				((TileEntityBHG) world.getTileEntity(x, y, z)).setGuiDisplayName(stack.getDisplayName());
			}
		}

		public static void updateState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
			int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

			TileEntity te = worldObj.getTileEntity(xCoord, yCoord, zCoord);
			keepInv = true;

			if (active) {
				// idfk
			} else {
				// idfk either
			}

			keepInv = false;
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

			if (te != null) {
				te.validate();
				worldObj.setTileEntity(xCoord, yCoord, zCoord, te);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
			if (!keepInv) {
				TileEntityBHG entity = (TileEntityBHG) world.getTileEntity(x, y, z);

				if (entity != null) {
					for (int i = 0; i < entity.getSizeInv(); i++) {
						ItemStack stack = entity.getStackInSlot(i);

						if (stack != null) {
							float f = this.rand.nextFloat() * .8f + .1f;
							float f1 = this.rand.nextFloat() * .8f + .1f;
							float f2 = this.rand.nextFloat() * .8f + .1f;

							while (stack.stackSize > 0) {
								int j = this.rand.nextInt(21) + 10;

								if (j > stack.stackSize) {
									j = stack.stackSize;
								}

								stack.stackSize -= j;

								EntityItem item = new EntityItem(world, (double) ((float) x + f),
										(double) ((float) y + f1), (double) ((float) z + f2),
										new ItemStack(stack.getItem(), j, stack.getItemDamage()));

								// Check items for tag and load it
								if (stack.hasTagCompound()) {
									item.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
								}

								// Set motion to dropped items
								float f3 = .05f;
								item.motionX = (double) ((float) this.rand.nextGaussian() * f3);
								item.motionY = (double) ((float) this.rand.nextGaussian() * f3 + .2f);
								item.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

								world.spawnEntityInWorld(item);
							}
						}
					}
					world.getBlock(x, y, z);
				}
			}
			super.breakBlock(world, x, y, z, block, meta);
		}

		// Comparator stuff!
		public boolean hasComparatorInputOverride() {
			return true;
		}

		public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
			return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
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

	public static class Welder extends BlockContainer {
		private Random rand = new Random();

		private static boolean keepInv;
		public static boolean isActive;

		public Welder(Material mat, boolean isActive) {
			super(mat);
			Welder.isActive = isActive;
		}

		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.Welder);
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			super.onBlockAdded(world, x, y, z);

			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				Welder.isActive = true;
			} else {
				Welder.isActive = false;
			}

		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				Welder.isActive = true;
			} else {
				Welder.isActive = false;
			}
		}

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX,
				float hitY, float hitZ) {
			player.openGui(mod_IDT.instance, mod_IDT.WelderGUI, world, x, y, z);
			return true;
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWelder();
		}

		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
			int l = MathHelper.floor_double((double) (entity.rotationYaw * 4f / 360f) + .5d) & 3;

			if (l == 0) {
				world.setBlockMetadataWithNotify(x, y, z, 0, 1);
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

			if (stack.hasDisplayName()) {
				((TileEntityWelder) world.getTileEntity(x, y, z)).setGuiDisplayName(stack.getDisplayName());
			}
		}

		public static void updateState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
			int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

			TileEntity te = worldObj.getTileEntity(xCoord, yCoord, zCoord);
			keepInv = true;

			if (active) {
				// idfk
			} else {
				// idfk either
			}

			keepInv = false;
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

			if (te != null) {
				te.validate();
				worldObj.setTileEntity(xCoord, yCoord, zCoord, te);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
			if (!keepInv) {
				TileEntityWelder entity = (TileEntityWelder) world.getTileEntity(x, y, z);

				if (entity != null) {
					for (int i = 0; i < entity.getSizeInv(); i++) {
						ItemStack stack = entity.getStackInSlot(i);

						if (stack != null) {
							float f = this.rand.nextFloat() * .8f + .1f;
							float f1 = this.rand.nextFloat() * .8f + .1f;
							float f2 = this.rand.nextFloat() * .8f + .1f;

							while (stack.stackSize > 0) {
								int j = this.rand.nextInt(21) + 10;

								if (j > stack.stackSize) {
									j = stack.stackSize;
								}

								stack.stackSize -= j;

								EntityItem item = new EntityItem(world, (double) ((float) x + f),
										(double) ((float) y + f1), (double) ((float) z + f2),
										new ItemStack(stack.getItem(), j, stack.getItemDamage()));

								// Check items for tag and load it
								if (stack.hasTagCompound()) {
									item.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
								}

								// Set motion to dropped items
								float f3 = .05f;
								item.motionX = (double) ((float) this.rand.nextGaussian() * f3);
								item.motionY = (double) ((float) this.rand.nextGaussian() * f3 + .2f);
								item.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

								world.spawnEntityInWorld(item);
							}
						}
					}
					world.getBlock(x, y, z);
				}
			}
			super.breakBlock(world, x, y, z, block, meta);
		}

		// Comparator stuff!
		public boolean hasComparatorInputOverride() {
			return true;
		}

		public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
			return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
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

	public static class Magnetizer extends BlockContainer {
		private Random rand = new Random();

		private static boolean keepInv;
		public static boolean isActive;

		public Magnetizer(Material mat) {
			super(mat);
		}

		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.Magnetizer);
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			TileEntityMagnetizer mag = (TileEntityMagnetizer) world.getTileEntity(x, y, z);

			super.onBlockAdded(world, x, y, z);
			mag.damage = mag.maxDamage;

			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				Magnetizer.isActive = true;
			} else {
				Magnetizer.isActive = false;
			}
		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				Magnetizer.isActive = true;
			} else {
				Magnetizer.isActive = false;
			}
		}

		public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX,
				float hitY, float hitZ) {

			player.openGui(mod_IDT.instance, mod_IDT.MagnetizerGUI, world, x, y, z);
			return true;
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityMagnetizer();
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

			if (stack.hasDisplayName()) {
				((TileEntityMagnetizer) world.getTileEntity(x, y, z)).setGuiDisplayName(stack.getDisplayName());
			}
		}

		public static void updateState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
			int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

			TileEntity te = worldObj.getTileEntity(xCoord, yCoord, zCoord);
			keepInv = true;

			if (active) {
				// idfk
			} else {
				// idfk either
			}

			keepInv = false;
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

			if (te != null) {
				te.validate();
				worldObj.setTileEntity(xCoord, yCoord, zCoord, te);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
			if (!keepInv) {
				TileEntityMagnetizer entity = (TileEntityMagnetizer) world.getTileEntity(x, y, z);

				if (entity != null) {
					for (int i = 0; i < entity.getSizeInv(); i++) {
						ItemStack stack = entity.getStackInSlot(i);

						if (stack != null) {
							float f = this.rand.nextFloat() * .8f + .1f;
							float f1 = this.rand.nextFloat() * .8f + .1f;
							float f2 = this.rand.nextFloat() * .8f + .1f;

							while (stack.stackSize > 0) {
								int j = this.rand.nextInt(21) + 10;

								if (j > stack.stackSize) {
									j = stack.stackSize;
								}

								stack.stackSize -= j;

								EntityItem item = new EntityItem(world, (double) ((float) x + f),
										(double) ((float) y + f1), (double) ((float) z + f2),
										new ItemStack(stack.getItem(), j, stack.getItemDamage()));

								// Check items for tag and load it
								if (stack.hasTagCompound()) {
									item.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
								}

								// Set motion to dropped items
								float f3 = .05f;
								item.motionX = (double) ((float) this.rand.nextGaussian() * f3);
								item.motionY = (double) ((float) this.rand.nextGaussian() * f3 + .2f);
								item.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

								world.spawnEntityInWorld(item);
							}
						}
					}
					world.getBlock(x, y, z);
				}
			}
			super.breakBlock(world, x, y, z, block, meta);
		}

		// Comparator stuff!
		public boolean hasComparatorInputOverride() {
			return true;
		}

		public int getComparatorInputOverride(World world, int x, int y, int z, int i) {
			return Container.calcRedstoneFromInventory((IInventory) world.getTileEntity(x, y, z));
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

	public static class Enricher extends BlockContainer {
		private Random rand = new Random();

		private static boolean keepInv;
		public static boolean isActive;

		public Enricher(Material mat) {
			super(mat);
		}

		public void onBlockAdded(World world, int x, int y, int z) {
			super.onBlockAdded(world, x, y, z);
			this.setDefaultDirection(world, x, y, z);

			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				Enricher.isActive = true;
			} else {
				Enricher.isActive = false;
			}
		}

		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
				Enricher.isActive = true;
			} else {
				Enricher.isActive = false;
			}
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
			return new TileEntityEnricher();
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

			if (stack.hasDisplayName()) {
				((TileEntityEnricher) world.getTileEntity(x, y, z)).setGuiDisplayName(stack.getDisplayName());
			}
		}

		public static void updateState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
			int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

			TileEntity te = worldObj.getTileEntity(xCoord, yCoord, zCoord);
			keepInv = true;

			if (active) {
				// idfk
			} else {
				// idfk either
			}

			keepInv = false;
			worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

			if (te != null) {
				te.validate();
				worldObj.setTileEntity(xCoord, yCoord, zCoord, te);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
			if (!keepInv) {
				TileEntityEnricher entity = (TileEntityEnricher) world.getTileEntity(x, y, z);

				if (entity != null) {
					for (int i = 0; i < entity.getSizeInv(); i++) {
						ItemStack stack = entity.getStackInSlot(i);

						if (stack != null) {
							float f = this.rand.nextFloat() * .8f + .1f;
							float f1 = this.rand.nextFloat() * .8f + .1f;
							float f2 = this.rand.nextFloat() * .8f + .1f;

							while (stack.stackSize > 0) {
								int j = this.rand.nextInt(21) + 10;

								if (j > stack.stackSize) {
									j = stack.stackSize;
								}

								stack.stackSize -= j;

								EntityItem item = new EntityItem(world, (double) ((float) x + f),
										(double) ((float) y + f1), (double) ((float) z + f2),
										new ItemStack(stack.getItem(), j, stack.getItemDamage()));

								// Check items for tag and load it
								if (stack.hasTagCompound()) {
									item.getEntityItem().setTagCompound((NBTTagCompound) stack.getTagCompound().copy());
								}

								// Set motion to dropped items
								float f3 = .05f;
								item.motionX = (double) ((float) this.rand.nextGaussian() * f3);
								item.motionY = (double) ((float) this.rand.nextGaussian() * f3 + .2f);
								item.motionZ = (double) ((float) this.rand.nextGaussian() * f3);

								world.spawnEntityInWorld(item);
							}
						}
					}
					world.getBlock(x, y, z);
				}
			}
			super.breakBlock(world, x, y, z, block, meta);
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
}