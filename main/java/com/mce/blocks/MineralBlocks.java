package com.mce.blocks;

import java.util.Random;

import com.mce.common.mod_IDT;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class MineralBlocks {
	// 0 Wood, Gold; 1 Stone; 2 Iron; 3; Diamond

	public static class SteelBlock extends Block {
		public SteelBlock(Material mat) {
			super(mat);
			this.setHarvestLevel("pickaxe", 2);
		}
	}

	public static class TitaniumBlock extends Block {
		public TitaniumBlock(Material mat) {
			super(mat);
			this.setHarvestLevel("pickaxe", 2);
		}
	}

	public static class CopperBlock extends Block {
		public CopperBlock(Material mat) {
			super(mat);
			this.setHarvestLevel("pickaxe", 1);
		}
	}

	public static class SiliconBlock extends Block {
		public SiliconBlock(Material mat) {
			super(mat);
			this.setHarvestLevel("pickaxe", 1);
		}
	}

	public static class VanadiumBlock extends Block {
		public VanadiumBlock(Material mat) {
			super(mat);
			this.setHarvestLevel("pickaxe", 3);
		}
	}

	public static class TantalumBlock extends Block {
		public TantalumBlock(Material mat) {
			super(mat);
			this.setHarvestLevel("pickaxe", 2);
		}
	}

	public static class EinsteiniumBlock extends Block {
		private boolean glow;

		public EinsteiniumBlock(Material mat, boolean glow) {
			super(mat);
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
				System.out.println("An error has occurred! Error ID: IDT-307a");
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

	public static class NeptuniumBlock extends Block {
		private boolean glow;

		public NeptuniumBlock(Material mat, boolean glow) {
			super(mat);
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
				System.out.println("An error has occurred! Error ID: IDT-307b");
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

	public static class UraniumBlock extends Block {
		private boolean glow;

		public UraniumBlock(Material mat, boolean glow) {
			super(mat);
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
				System.out.println("An error has occurred! Error ID: IDT-307c");
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

	public static class PraseodymiumBlock extends Block {
		public PraseodymiumBlock(Material mat) {
			super(mat);
			this.setHarvestLevel("pickaxe", 2);
		}
	}

	public static class NeodymiumBlock extends Block {
		public NeodymiumBlock(Material mat) {
			super(mat);
			this.setHarvestLevel("pickaxe", 2);
		}
	}

	public static class BoronBlock extends Block {
		public BoronBlock(Material mat) {
			super(mat);
			this.setHarvestLevel("pickaxe", 2);
		}
	}
	
	public static class NeoronBlock extends Block {
		public NeoronBlock(Material mat){
			super(mat);
			this.setHarvestLevel("pickaxe", 2);
		}
	}

	public static class SulfurBlock extends Block {
		private boolean glow;

		public SulfurBlock(Material mat, boolean glow) {
			super(mat);
			this.glow = glow;
			this.setHarvestLevel("pickaxe", 1);
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

	public static class ZimphnodeBlock extends Block {
		public ZimphnodeBlock(Material mat) {
			super(mat);
			this.setHarvestLevel("pickaxe", 1);
		}
	}
}
