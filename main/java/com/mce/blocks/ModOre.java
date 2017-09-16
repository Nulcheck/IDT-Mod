package com.mce.blocks;

import java.util.Random;

import com.mce.common.mod_IDT;

import net.minecraft.block.BlockOre;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ModOre extends BlockOre {
	public ModOre() {
		super();
	}

	public static class EinsteiniumOre extends BlockOre {
		private boolean glow;

		public EinsteiniumOre(boolean glow) {
			super();
			this.glow = glow;
			this.setHarvestLevel("pickaxe", 1);
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.glow) {
				this.dust(world, x, y, z);
			}
		}

		public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
			try {
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(mod_IDT.Radiation.id, 1000, 1, false));
				super.onEntityWalking(world, x, y, z, entity);
			} catch (Exception e) {
				System.out.println("An error has occurred! Error ID: IDT-301a");
			}
		}

		// Dust particles!
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
					mod_IDT.proxy.spawnParticle(world, x, y, z, "einsteiniumFx");
				}
			}
		}
	}

	public static class NeptuniumOre extends BlockOre {
		private boolean glow;

		public NeptuniumOre(boolean glow) {
			super();
			this.glow = glow;
			this.setHarvestLevel("pickaxe", 1);
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.glow) {
				this.dust(world, x, y, z);
			}
		}

		public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
			try {
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(mod_IDT.Radiation.id, 1000, 1, false));
				super.onEntityWalking(world, x, y, z, entity);
			} catch (Exception e) {
				System.out.println("An error has occurred! Error ID: IDT-301b");
			}
		}

		// Dust particles!
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
					mod_IDT.proxy.spawnParticle(world, x, y, z, "neptuniumFx");
				}
			}
		}
	}

	public static class UraniumOre extends BlockOre {
		private boolean glow;

		public UraniumOre(boolean glow) {
			super();
			this.glow = glow;
			this.setHarvestLevel("pickaxe", 1);
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.glow) {
				this.dust(world, x, y, z);
			}
		}

		public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
			try {
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(mod_IDT.Radiation.id, 1000, 1, false));
				super.onEntityWalking(world, x, y, z, entity);
			} catch (Exception e) {
				System.out.println("An error has occurred! Error ID: IDT-301c");
			}
		}

		// Dust particles!
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
					mod_IDT.proxy.spawnParticle(world, x, y, z, "uraniumFx");
				}
			}
		}
	}

	public static class CrystalOre extends BlockOre {
		int id, meta;

		public CrystalOre() {
			super();
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			int i = rand.nextInt(99);

			if (i >= 97 && i <= 99) {
				return Item.getItemFromBlock(mod_IDT.CrystalOre);
			}

			if (i >= 77 && i <= 79) {
				return mod_IDT.CrystalGem;
			}

			if (i >= 47 && i <= 49) {
				return mod_IDT.CrystalNugget;
			}

			if (i >= 27 && i <= 29) {
				return mod_IDT.CrystalPiece;
			}

			else {
				return mod_IDT.CrystalDust;
			}
		}

		public int quantityDropped(Random rand) {
			if (getItemDropped(id, rand, meta) == Item.getItemFromBlock(mod_IDT.CrystalOre)) {
				return 2 + rand.nextInt(1);
			} else {
				return 6 + rand.nextInt(2);
			}
		}
	}

	public static class PraseodymiumOre extends BlockOre {
		public PraseodymiumOre() {
			super();
			this.setHarvestLevel("pickaxe", 2);
		}
	}

	public static class NeodymiumOre extends BlockOre {
		public NeodymiumOre() {
			super();
			this.setHarvestLevel("pickaxe", 2);
		}
	}

	public static class Zimphnode extends BlockOre {
		public Zimphnode() {
			super();
			this.setHarvestLevel("pickaxe", 1);
		}
	}

	public static class VanadiumOre extends BlockOre {
		public VanadiumOre() {
			super();
			this.setHarvestLevel("pickaxe", 3);
		}
	}

	public static class TantalumOre extends BlockOre {
		public TantalumOre() {
			super();
			this.setHarvestLevel("pickaxe", 2);
		}
	}

	public static class SulfurOre extends BlockOre {
		private boolean glow;

		public SulfurOre(boolean glow) {
			super();
			this.setHarvestLevel("pickaxe", 1);
			this.glow = glow;
		}

		public Item getItemDropped(int id, Random rand, int meta) {
			return mod_IDT.Sulfur;
		}

		public int quantityDroppedWithBonus(int i, Random ran) {
			return this.quantityDropped(ran) + ran.nextInt(i + 1);
		}

		public int quantityDropped(Random ran) {
			return 4 + ran.nextInt(2);
		}

		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.glow) {
				this.dust(world, x, y, z);
			}
		}

		// Dust particles!
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
					mod_IDT.proxy.spawnParticle(world, x, y, z, "sulfurFx");
				}
			}
		}
	}

	public static class BoronOre extends BlockOre {
		public BoronOre() {
			super();
			this.setHarvestLevel("pickaxe", 2);
		}
	}

	public static class CopperOre extends BlockOre {
		public CopperOre() {
			super();
			this.setHarvestLevel("pickaxe", 1);
		}
	}

	public static class TitaniumOre extends BlockOre {
		public TitaniumOre() {
			super();
			this.setHarvestLevel("pickaxe", 2);
		}
	}
	
	public static class Phosphorite extends BlockOre {
		public Phosphorite(){
			super();
			this.setHarvestLevel("pickaxe", 1);
		}
	}
	
	public static class Agate extends BlockOre {
		public Agate(){
			super();
			this.setHarvestLevel("pickaxe", 2);
		}
		
		public Item getItemDropped(int id, Random rand, int meta) {
			return mod_IDT.PureQuartz;
		}

		public int quantityDroppedWithBonus(int i, Random ran) {
			return this.quantityDropped(ran) + ran.nextInt(i + 1);
		}

		public int quantityDropped(Random ran) {
			return 4 + ran.nextInt(2);
		}
	}
}
