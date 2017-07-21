package com.mce.blocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.mce.common.mod_IDT;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModRedTorch extends BlockTorch {
	public ModRedTorch() {
		super();
	}

	public static class BirchRedTorch extends BlockTorch {
		private boolean field_150113_a;
		private static Map field_150112_b = new HashMap();
		private static final String __OBFID = "CL_00000298";

		private boolean func_150111_a(World world, int x, int y, int z, boolean on) {
			if (!field_150112_b.containsKey(world)) {
				field_150112_b.put(world, new ArrayList());
			}

			List list = (List) field_150112_b.get(world);

			if (on) {
				list.add(new BirchRedTorch.Toggle(x, y, z, world.getTotalWorldTime()));
			}

			int l = 0;

			for (int i1 = 0; i1 < list.size(); ++i1) {
				BirchRedTorch.Toggle toggle = (BirchRedTorch.Toggle) list.get(i1);

				if (toggle.field_150847_a == x && toggle.field_150845_b == y && toggle.field_150846_c == z) {
					++l;

					if (l >= 8) {
						return true;
					}
				}
			}

			return false;
		}

		public BirchRedTorch(boolean on) {
			this.field_150113_a = on;
			this.setTickRandomly(true);
		}

		/**
		 * How many world ticks before ticking
		 */
		public int tickRate(World world) {
			return 2;
		}

		/**
		 * Called whenever the block is added into the world. Args: world, x, y,
		 * z
		 */
		public void onBlockAdded(World world, int x, int y, int z) {
			if (world.getBlockMetadata(x, y, z) == 0) {
				super.onBlockAdded(world, x, y, z);
			}

			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int damage) {
			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public int isProvidingWeakPower(IBlockAccess blockAcc, int x, int y, int z, int power) {
			if (!this.field_150113_a) {
				return 0;
			} else {
				int i1 = blockAcc.getBlockMetadata(x, y, z);
				return i1 == 5 && power == 1 ? 0
						: (i1 == 3 && power == 3 ? 0
								: (i1 == 4 && power == 2 ? 0
										: (i1 == 1 && power == 5 ? 0 : (i1 == 2 && power == 4 ? 0 : 15))));
			}
		}

		private boolean func_150110_m(World world, int x, int y, int z) {
			int l = world.getBlockMetadata(x, y, z);
			return l == 5 && world.getIndirectPowerOutput(x, y - 1, z, 0) ? true
					: (l == 3 && world.getIndirectPowerOutput(x, y, z - 1, 2) ? true
							: (l == 4 && world.getIndirectPowerOutput(x, y, z + 1, 3) ? true
									: (l == 1 && world.getIndirectPowerOutput(x - 1, y, z, 4) ? true
											: l == 2 && world.getIndirectPowerOutput(x + 1, y, z, 5))));
		}

		/**
		 * Ticks the block if it's been scheduled
		 */
		public void updateTick(World world, int x, int y, int z, Random rand) {
			boolean flag = this.func_150110_m(world, x, y, z);
			List list = (List) field_150112_b.get(world);

			while (list != null && !list.isEmpty()
					&& world.getTotalWorldTime() - ((BirchRedTorch.Toggle) list.get(0)).field_150844_d > 60L) {
				list.remove(0);
			}

			if (this.field_150113_a) {
				if (flag) {
					world.setBlock(x, y, z, mod_IDT.BirchRedTorch, world.getBlockMetadata(x, y, z), 3);

					if (this.func_150111_a(world, x, y, z, true)) {
						world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
								(double) ((float) z + 0.5F), "random.fizz", 0.5F,
								2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

						for (int l = 0; l < 5; ++l) {
							double d0 = (double) x + rand.nextDouble() * 0.6D + 0.2D;
							double d1 = (double) y + rand.nextDouble() * 0.6D + 0.2D;
							double d2 = (double) z + rand.nextDouble() * 0.6D + 0.2D;
							world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			} else if (!flag && !this.func_150111_a(world, x, y, z, false)) {
				world.setBlock(x, y, z, mod_IDT.BirchRedTorchOn, world.getBlockMetadata(x, y, z), 3);
			}
		}

		/**
		 * Lets the block know when one of its neighbor changes. Doesn't know
		 * which neighbor changed (coordinates passed are their own) Args: x, y,
		 * z, neighbor Block
		 */
		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (!this.func_150108_b(world, x, y, z, block)) {
				boolean flag = this.func_150110_m(world, x, y, z);

				if (this.field_150113_a && flag || !this.field_150113_a && !flag) {
					world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
				}
			}
		}

		public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int power) {
			return power == 0 ? this.isProvidingWeakPower(world, x, y, z, power) : 0;
		}

		public Item getItemDropped(int id, Random rand, int damage) {
			return Item.getItemFromBlock(mod_IDT.BirchRedTorchOn);
		}

		/**
		 * Can this block provide power. Only wire currently seems to have this
		 * change based on its state.
		 */
		public boolean canProvidePower() {
			return true;
		}

		/**
		 * A randomly called display update to be able to add particles or other
		 * items for display
		 */
		@SideOnly(Side.CLIENT)
		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.field_150113_a) {
				int l = world.getBlockMetadata(x, y, z);
				double d0 = (double) ((float) x + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d1 = (double) ((float) y + 0.7F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d2 = (double) ((float) z + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d3 = 0.2199999988079071D;
				double d4 = 0.27000001072883606D;

				if (l == 1) {
					world.spawnParticle("reddust", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					world.spawnParticle("reddust", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 4) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				} else {
					world.spawnParticle("reddust", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		/**
		 * Gets an item for the block being called on. Args: world, x, y, z
		 */
		@SideOnly(Side.CLIENT)
		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.BirchRedTorchOn);
		}

		public boolean isAssociatedBlock(Block block) {
			return block == mod_IDT.BirchRedTorch || block == mod_IDT.BirchRedTorchOn;
		}

		static class Toggle {
			int field_150847_a;
			int field_150845_b;
			int field_150846_c;
			long field_150844_d;
			private static final String __OBFID = "CL_00000299";

			public Toggle(int x, int y, int z, long idfk) {
				this.field_150847_a = x;
				this.field_150845_b = y;
				this.field_150846_c = z;
				this.field_150844_d = idfk;
			}
		}
	}

	public static class SpruceRedTorch extends BlockTorch {
		private boolean field_150113_a;
		private static Map field_150112_b = new HashMap();
		private static final String __OBFID = "CL_00000298";

		private boolean func_150111_a(World world, int x, int y, int z, boolean on) {
			if (!field_150112_b.containsKey(world)) {
				field_150112_b.put(world, new ArrayList());
			}

			List list = (List) field_150112_b.get(world);

			if (on) {
				list.add(new SpruceRedTorch.Toggle(x, y, z, world.getTotalWorldTime()));
			}

			int l = 0;

			for (int i1 = 0; i1 < list.size(); ++i1) {
				SpruceRedTorch.Toggle toggle = (SpruceRedTorch.Toggle) list.get(i1);

				if (toggle.field_150847_a == x && toggle.field_150845_b == y && toggle.field_150846_c == z) {
					++l;

					if (l >= 8) {
						return true;
					}
				}
			}

			return false;
		}

		public SpruceRedTorch(boolean on) {
			this.field_150113_a = on;
			this.setTickRandomly(true);
		}

		/**
		 * How many world ticks before ticking
		 */
		public int tickRate(World world) {
			return 2;
		}

		/**
		 * Called whenever the block is added into the world. Args: world, x, y,
		 * z
		 */
		public void onBlockAdded(World world, int x, int y, int z) {
			if (world.getBlockMetadata(x, y, z) == 0) {
				super.onBlockAdded(world, x, y, z);
			}

			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int damage) {
			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public int isProvidingWeakPower(IBlockAccess blockAcc, int x, int y, int z, int power) {
			if (!this.field_150113_a) {
				return 0;
			} else {
				int i1 = blockAcc.getBlockMetadata(x, y, z);
				return i1 == 5 && power == 1 ? 0
						: (i1 == 3 && power == 3 ? 0
								: (i1 == 4 && power == 2 ? 0
										: (i1 == 1 && power == 5 ? 0 : (i1 == 2 && power == 4 ? 0 : 15))));
			}
		}

		private boolean func_150110_m(World world, int x, int y, int z) {
			int l = world.getBlockMetadata(x, y, z);
			return l == 5 && world.getIndirectPowerOutput(x, y - 1, z, 0) ? true
					: (l == 3 && world.getIndirectPowerOutput(x, y, z - 1, 2) ? true
							: (l == 4 && world.getIndirectPowerOutput(x, y, z + 1, 3) ? true
									: (l == 1 && world.getIndirectPowerOutput(x - 1, y, z, 4) ? true
											: l == 2 && world.getIndirectPowerOutput(x + 1, y, z, 5))));
		}

		/**
		 * Ticks the block if it's been scheduled
		 */
		public void updateTick(World world, int x, int y, int z, Random rand) {
			boolean flag = this.func_150110_m(world, x, y, z);
			List list = (List) field_150112_b.get(world);

			while (list != null && !list.isEmpty()
					&& world.getTotalWorldTime() - ((SpruceRedTorch.Toggle) list.get(0)).field_150844_d > 60L) {
				list.remove(0);
			}

			if (this.field_150113_a) {
				if (flag) {
					world.setBlock(x, y, z, mod_IDT.SpruceRedTorch, world.getBlockMetadata(x, y, z), 3);

					if (this.func_150111_a(world, x, y, z, true)) {
						world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
								(double) ((float) z + 0.5F), "random.fizz", 0.5F,
								2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

						for (int l = 0; l < 5; ++l) {
							double d0 = (double) x + rand.nextDouble() * 0.6D + 0.2D;
							double d1 = (double) y + rand.nextDouble() * 0.6D + 0.2D;
							double d2 = (double) z + rand.nextDouble() * 0.6D + 0.2D;
							world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			} else if (!flag && !this.func_150111_a(world, x, y, z, false)) {
				world.setBlock(x, y, z, mod_IDT.SpruceRedTorchOn, world.getBlockMetadata(x, y, z), 3);
			}
		}

		/**
		 * Lets the block know when one of its neighbor changes. Doesn't know
		 * which neighbor changed (coordinates passed are their own) Args: x, y,
		 * z, neighbor Block
		 */
		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (!this.func_150108_b(world, x, y, z, block)) {
				boolean flag = this.func_150110_m(world, x, y, z);

				if (this.field_150113_a && flag || !this.field_150113_a && !flag) {
					world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
				}
			}
		}

		public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int power) {
			return power == 0 ? this.isProvidingWeakPower(world, x, y, z, power) : 0;
		}

		public Item getItemDropped(int id, Random rand, int damage) {
			return Item.getItemFromBlock(mod_IDT.SpruceRedTorchOn);
		}

		/**
		 * Can this block provide power. Only wire currently seems to have this
		 * change based on its state.
		 */
		public boolean canProvidePower() {
			return true;
		}

		/**
		 * A randomly called display update to be able to add particles or other
		 * items for display
		 */
		@SideOnly(Side.CLIENT)
		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.field_150113_a) {
				int l = world.getBlockMetadata(x, y, z);
				double d0 = (double) ((float) x + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d1 = (double) ((float) y + 0.7F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d2 = (double) ((float) z + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d3 = 0.2199999988079071D;
				double d4 = 0.27000001072883606D;

				if (l == 1) {
					world.spawnParticle("reddust", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					world.spawnParticle("reddust", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 4) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				} else {
					world.spawnParticle("reddust", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		/**
		 * Gets an item for the block being called on. Args: world, x, y, z
		 */
		@SideOnly(Side.CLIENT)
		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.SpruceRedTorchOn);
		}

		public boolean isAssociatedBlock(Block block) {
			return block == mod_IDT.SpruceRedTorch || block == mod_IDT.SpruceRedTorchOn;
		}

		static class Toggle {
			int field_150847_a;
			int field_150845_b;
			int field_150846_c;
			long field_150844_d;
			private static final String __OBFID = "CL_00000299";

			public Toggle(int x, int y, int z, long idfk) {
				this.field_150847_a = x;
				this.field_150845_b = y;
				this.field_150846_c = z;
				this.field_150844_d = idfk;
			}
		}
	}

	public static class JungleRedTorch extends BlockTorch {
		private boolean field_150113_a;
		private static Map field_150112_b = new HashMap();
		private static final String __OBFID = "CL_00000298";

		private boolean func_150111_a(World world, int x, int y, int z, boolean on) {
			if (!field_150112_b.containsKey(world)) {
				field_150112_b.put(world, new ArrayList());
			}

			List list = (List) field_150112_b.get(world);

			if (on) {
				list.add(new JungleRedTorch.Toggle(x, y, z, world.getTotalWorldTime()));
			}

			int l = 0;

			for (int i1 = 0; i1 < list.size(); ++i1) {
				JungleRedTorch.Toggle toggle = (JungleRedTorch.Toggle) list.get(i1);

				if (toggle.field_150847_a == x && toggle.field_150845_b == y && toggle.field_150846_c == z) {
					++l;

					if (l >= 8) {
						return true;
					}
				}
			}

			return false;
		}

		public JungleRedTorch(boolean on) {
			this.field_150113_a = on;
			this.setTickRandomly(true);
		}

		/**
		 * How many world ticks before ticking
		 */
		public int tickRate(World world) {
			return 2;
		}

		/**
		 * Called whenever the block is added into the world. Args: world, x, y,
		 * z
		 */
		public void onBlockAdded(World world, int x, int y, int z) {
			if (world.getBlockMetadata(x, y, z) == 0) {
				super.onBlockAdded(world, x, y, z);
			}

			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int damage) {
			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public int isProvidingWeakPower(IBlockAccess blockAcc, int x, int y, int z, int power) {
			if (!this.field_150113_a) {
				return 0;
			} else {
				int i1 = blockAcc.getBlockMetadata(x, y, z);
				return i1 == 5 && power == 1 ? 0
						: (i1 == 3 && power == 3 ? 0
								: (i1 == 4 && power == 2 ? 0
										: (i1 == 1 && power == 5 ? 0 : (i1 == 2 && power == 4 ? 0 : 15))));
			}
		}

		private boolean func_150110_m(World world, int x, int y, int z) {
			int l = world.getBlockMetadata(x, y, z);
			return l == 5 && world.getIndirectPowerOutput(x, y - 1, z, 0) ? true
					: (l == 3 && world.getIndirectPowerOutput(x, y, z - 1, 2) ? true
							: (l == 4 && world.getIndirectPowerOutput(x, y, z + 1, 3) ? true
									: (l == 1 && world.getIndirectPowerOutput(x - 1, y, z, 4) ? true
											: l == 2 && world.getIndirectPowerOutput(x + 1, y, z, 5))));
		}

		/**
		 * Ticks the block if it's been scheduled
		 */
		public void updateTick(World world, int x, int y, int z, Random rand) {
			boolean flag = this.func_150110_m(world, x, y, z);
			List list = (List) field_150112_b.get(world);

			while (list != null && !list.isEmpty()
					&& world.getTotalWorldTime() - ((JungleRedTorch.Toggle) list.get(0)).field_150844_d > 60L) {
				list.remove(0);
			}

			if (this.field_150113_a) {
				if (flag) {
					world.setBlock(x, y, z, mod_IDT.JungleRedTorch, world.getBlockMetadata(x, y, z), 3);

					if (this.func_150111_a(world, x, y, z, true)) {
						world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
								(double) ((float) z + 0.5F), "random.fizz", 0.5F,
								2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

						for (int l = 0; l < 5; ++l) {
							double d0 = (double) x + rand.nextDouble() * 0.6D + 0.2D;
							double d1 = (double) y + rand.nextDouble() * 0.6D + 0.2D;
							double d2 = (double) z + rand.nextDouble() * 0.6D + 0.2D;
							world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			} else if (!flag && !this.func_150111_a(world, x, y, z, false)) {
				world.setBlock(x, y, z, mod_IDT.JungleRedTorchOn, world.getBlockMetadata(x, y, z), 3);
			}
		}

		/**
		 * Lets the block know when one of its neighbor changes. Doesn't know
		 * which neighbor changed (coordinates passed are their own) Args: x, y,
		 * z, neighbor Block
		 */
		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (!this.func_150108_b(world, x, y, z, block)) {
				boolean flag = this.func_150110_m(world, x, y, z);

				if (this.field_150113_a && flag || !this.field_150113_a && !flag) {
					world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
				}
			}
		}

		public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int power) {
			return power == 0 ? this.isProvidingWeakPower(world, x, y, z, power) : 0;
		}

		public Item getItemDropped(int id, Random rand, int damage) {
			return Item.getItemFromBlock(mod_IDT.JungleRedTorchOn);
		}

		/**
		 * Can this block provide power. Only wire currently seems to have this
		 * change based on its state.
		 */
		public boolean canProvidePower() {
			return true;
		}

		/**
		 * A randomly called display update to be able to add particles or other
		 * items for display
		 */
		@SideOnly(Side.CLIENT)
		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.field_150113_a) {
				int l = world.getBlockMetadata(x, y, z);
				double d0 = (double) ((float) x + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d1 = (double) ((float) y + 0.7F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d2 = (double) ((float) z + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d3 = 0.2199999988079071D;
				double d4 = 0.27000001072883606D;

				if (l == 1) {
					world.spawnParticle("reddust", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					world.spawnParticle("reddust", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 4) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				} else {
					world.spawnParticle("reddust", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		/**
		 * Gets an item for the block being called on. Args: world, x, y, z
		 */
		@SideOnly(Side.CLIENT)
		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.JungleRedTorchOn);
		}

		public boolean isAssociatedBlock(Block block) {
			return block == mod_IDT.JungleRedTorch || block == mod_IDT.JungleRedTorchOn;
		}

		static class Toggle {
			int field_150847_a;
			int field_150845_b;
			int field_150846_c;
			long field_150844_d;
			private static final String __OBFID = "CL_00000299";

			public Toggle(int x, int y, int z, long idfk) {
				this.field_150847_a = x;
				this.field_150845_b = y;
				this.field_150846_c = z;
				this.field_150844_d = idfk;
			}
		}
	}

	public static class WillowRedTorch extends BlockTorch {
		private boolean field_150113_a;
		private static Map field_150112_b = new HashMap();
		private static final String __OBFID = "CL_00000298";

		private boolean func_150111_a(World world, int x, int y, int z, boolean on) {
			if (!field_150112_b.containsKey(world)) {
				field_150112_b.put(world, new ArrayList());
			}

			List list = (List) field_150112_b.get(world);

			if (on) {
				list.add(new WillowRedTorch.Toggle(x, y, z, world.getTotalWorldTime()));
			}

			int l = 0;

			for (int i1 = 0; i1 < list.size(); ++i1) {
				WillowRedTorch.Toggle toggle = (WillowRedTorch.Toggle) list.get(i1);

				if (toggle.field_150847_a == x && toggle.field_150845_b == y && toggle.field_150846_c == z) {
					++l;

					if (l >= 8) {
						return true;
					}
				}
			}

			return false;
		}

		public WillowRedTorch(boolean on) {
			this.field_150113_a = on;
			this.setTickRandomly(true);
		}

		/**
		 * How many world ticks before ticking
		 */
		public int tickRate(World world) {
			return 2;
		}

		/**
		 * Called whenever the block is added into the world. Args: world, x, y,
		 * z
		 */
		public void onBlockAdded(World world, int x, int y, int z) {
			if (world.getBlockMetadata(x, y, z) == 0) {
				super.onBlockAdded(world, x, y, z);
			}

			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int damage) {
			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public int isProvidingWeakPower(IBlockAccess blockAcc, int x, int y, int z, int power) {
			if (!this.field_150113_a) {
				return 0;
			} else {
				int i1 = blockAcc.getBlockMetadata(x, y, z);
				return i1 == 5 && power == 1 ? 0
						: (i1 == 3 && power == 3 ? 0
								: (i1 == 4 && power == 2 ? 0
										: (i1 == 1 && power == 5 ? 0 : (i1 == 2 && power == 4 ? 0 : 15))));
			}
		}

		private boolean func_150110_m(World world, int x, int y, int z) {
			int l = world.getBlockMetadata(x, y, z);
			return l == 5 && world.getIndirectPowerOutput(x, y - 1, z, 0) ? true
					: (l == 3 && world.getIndirectPowerOutput(x, y, z - 1, 2) ? true
							: (l == 4 && world.getIndirectPowerOutput(x, y, z + 1, 3) ? true
									: (l == 1 && world.getIndirectPowerOutput(x - 1, y, z, 4) ? true
											: l == 2 && world.getIndirectPowerOutput(x + 1, y, z, 5))));
		}

		/**
		 * Ticks the block if it's been scheduled
		 */
		public void updateTick(World world, int x, int y, int z, Random rand) {
			boolean flag = this.func_150110_m(world, x, y, z);
			List list = (List) field_150112_b.get(world);

			while (list != null && !list.isEmpty()
					&& world.getTotalWorldTime() - ((WillowRedTorch.Toggle) list.get(0)).field_150844_d > 60L) {
				list.remove(0);
			}

			if (this.field_150113_a) {
				if (flag) {
					world.setBlock(x, y, z, mod_IDT.WillowRedTorch, world.getBlockMetadata(x, y, z), 3);

					if (this.func_150111_a(world, x, y, z, true)) {
						world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
								(double) ((float) z + 0.5F), "random.fizz", 0.5F,
								2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

						for (int l = 0; l < 5; ++l) {
							double d0 = (double) x + rand.nextDouble() * 0.6D + 0.2D;
							double d1 = (double) y + rand.nextDouble() * 0.6D + 0.2D;
							double d2 = (double) z + rand.nextDouble() * 0.6D + 0.2D;
							world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			} else if (!flag && !this.func_150111_a(world, x, y, z, false)) {
				world.setBlock(x, y, z, mod_IDT.WillowRedTorchOn, world.getBlockMetadata(x, y, z), 3);
			}
		}

		/**
		 * Lets the block know when one of its neighbor changes. Doesn't know
		 * which neighbor changed (coordinates passed are their own) Args: x, y,
		 * z, neighbor Block
		 */
		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (!this.func_150108_b(world, x, y, z, block)) {
				boolean flag = this.func_150110_m(world, x, y, z);

				if (this.field_150113_a && flag || !this.field_150113_a && !flag) {
					world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
				}
			}
		}

		public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int power) {
			return power == 0 ? this.isProvidingWeakPower(world, x, y, z, power) : 0;
		}

		public Item getItemDropped(int id, Random rand, int damage) {
			return Item.getItemFromBlock(mod_IDT.WillowRedTorchOn);
		}

		/**
		 * Can this block provide power. Only wire currently seems to have this
		 * change based on its state.
		 */
		public boolean canProvidePower() {
			return true;
		}

		/**
		 * A randomly called display update to be able to add particles or other
		 * items for display
		 */
		@SideOnly(Side.CLIENT)
		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.field_150113_a) {
				int l = world.getBlockMetadata(x, y, z);
				double d0 = (double) ((float) x + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d1 = (double) ((float) y + 0.7F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d2 = (double) ((float) z + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d3 = 0.2199999988079071D;
				double d4 = 0.27000001072883606D;

				if (l == 1) {
					world.spawnParticle("reddust", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					world.spawnParticle("reddust", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 4) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				} else {
					world.spawnParticle("reddust", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		/**
		 * Gets an item for the block being called on. Args: world, x, y, z
		 */
		@SideOnly(Side.CLIENT)
		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.WillowRedTorchOn);
		}

		public boolean isAssociatedBlock(Block block) {
			return block == mod_IDT.WillowRedTorch || block == mod_IDT.WillowRedTorchOn;
		}

		static class Toggle {
			int field_150847_a;
			int field_150845_b;
			int field_150846_c;
			long field_150844_d;
			private static final String __OBFID = "CL_00000299";

			public Toggle(int x, int y, int z, long idfk) {
				this.field_150847_a = x;
				this.field_150845_b = y;
				this.field_150846_c = z;
				this.field_150844_d = idfk;
			}
		}
	}

	public static class EbonyRedTorch extends BlockTorch {
		private boolean field_150113_a;
		private static Map field_150112_b = new HashMap();
		private static final String __OBFID = "CL_00000298";

		private boolean func_150111_a(World world, int x, int y, int z, boolean on) {
			if (!field_150112_b.containsKey(world)) {
				field_150112_b.put(world, new ArrayList());
			}

			List list = (List) field_150112_b.get(world);

			if (on) {
				list.add(new EbonyRedTorch.Toggle(x, y, z, world.getTotalWorldTime()));
			}

			int l = 0;

			for (int i1 = 0; i1 < list.size(); ++i1) {
				EbonyRedTorch.Toggle toggle = (EbonyRedTorch.Toggle) list.get(i1);

				if (toggle.field_150847_a == x && toggle.field_150845_b == y && toggle.field_150846_c == z) {
					++l;

					if (l >= 8) {
						return true;
					}
				}
			}

			return false;
		}

		public EbonyRedTorch(boolean on) {
			this.field_150113_a = on;
			this.setTickRandomly(true);
		}

		/**
		 * How many world ticks before ticking
		 */
		public int tickRate(World world) {
			return 2;
		}

		/**
		 * Called whenever the block is added into the world. Args: world, x, y,
		 * z
		 */
		public void onBlockAdded(World world, int x, int y, int z) {
			if (world.getBlockMetadata(x, y, z) == 0) {
				super.onBlockAdded(world, x, y, z);
			}

			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int damage) {
			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public int isProvidingWeakPower(IBlockAccess blockAcc, int x, int y, int z, int power) {
			if (!this.field_150113_a) {
				return 0;
			} else {
				int i1 = blockAcc.getBlockMetadata(x, y, z);
				return i1 == 5 && power == 1 ? 0
						: (i1 == 3 && power == 3 ? 0
								: (i1 == 4 && power == 2 ? 0
										: (i1 == 1 && power == 5 ? 0 : (i1 == 2 && power == 4 ? 0 : 15))));
			}
		}

		private boolean func_150110_m(World world, int x, int y, int z) {
			int l = world.getBlockMetadata(x, y, z);
			return l == 5 && world.getIndirectPowerOutput(x, y - 1, z, 0) ? true
					: (l == 3 && world.getIndirectPowerOutput(x, y, z - 1, 2) ? true
							: (l == 4 && world.getIndirectPowerOutput(x, y, z + 1, 3) ? true
									: (l == 1 && world.getIndirectPowerOutput(x - 1, y, z, 4) ? true
											: l == 2 && world.getIndirectPowerOutput(x + 1, y, z, 5))));
		}

		/**
		 * Ticks the block if it's been scheduled
		 */
		public void updateTick(World world, int x, int y, int z, Random rand) {
			boolean flag = this.func_150110_m(world, x, y, z);
			List list = (List) field_150112_b.get(world);

			while (list != null && !list.isEmpty()
					&& world.getTotalWorldTime() - ((EbonyRedTorch.Toggle) list.get(0)).field_150844_d > 60L) {
				list.remove(0);
			}

			if (this.field_150113_a) {
				if (flag) {
					world.setBlock(x, y, z, mod_IDT.EbonyRedTorch, world.getBlockMetadata(x, y, z), 3);

					if (this.func_150111_a(world, x, y, z, true)) {
						world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
								(double) ((float) z + 0.5F), "random.fizz", 0.5F,
								2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

						for (int l = 0; l < 5; ++l) {
							double d0 = (double) x + rand.nextDouble() * 0.6D + 0.2D;
							double d1 = (double) y + rand.nextDouble() * 0.6D + 0.2D;
							double d2 = (double) z + rand.nextDouble() * 0.6D + 0.2D;
							world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			} else if (!flag && !this.func_150111_a(world, x, y, z, false)) {
				world.setBlock(x, y, z, mod_IDT.EbonyRedTorchOn, world.getBlockMetadata(x, y, z), 3);
			}
		}

		/**
		 * Lets the block know when one of its neighbor changes. Doesn't know
		 * which neighbor changed (coordinates passed are their own) Args: x, y,
		 * z, neighbor Block
		 */
		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (!this.func_150108_b(world, x, y, z, block)) {
				boolean flag = this.func_150110_m(world, x, y, z);

				if (this.field_150113_a && flag || !this.field_150113_a && !flag) {
					world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
				}
			}
		}

		public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int power) {
			return power == 0 ? this.isProvidingWeakPower(world, x, y, z, power) : 0;
		}

		public Item getItemDropped(int id, Random rand, int damage) {
			return Item.getItemFromBlock(mod_IDT.EbonyRedTorchOn);
		}

		/**
		 * Can this block provide power. Only wire currently seems to have this
		 * change based on its state.
		 */
		public boolean canProvidePower() {
			return true;
		}

		/**
		 * A randomly called display update to be able to add particles or other
		 * items for display
		 */
		@SideOnly(Side.CLIENT)
		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.field_150113_a) {
				int l = world.getBlockMetadata(x, y, z);
				double d0 = (double) ((float) x + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d1 = (double) ((float) y + 0.7F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d2 = (double) ((float) z + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d3 = 0.2199999988079071D;
				double d4 = 0.27000001072883606D;

				if (l == 1) {
					world.spawnParticle("reddust", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					world.spawnParticle("reddust", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 4) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				} else {
					world.spawnParticle("reddust", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		/**
		 * Gets an item for the block being called on. Args: world, x, y, z
		 */
		@SideOnly(Side.CLIENT)
		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.EbonyRedTorchOn);
		}

		public boolean isAssociatedBlock(Block block) {
			return block == mod_IDT.EbonyRedTorch || block == mod_IDT.EbonyRedTorchOn;
		}

		static class Toggle {
			int field_150847_a;
			int field_150845_b;
			int field_150846_c;
			long field_150844_d;
			private static final String __OBFID = "CL_00000299";

			public Toggle(int x, int y, int z, long idfk) {
				this.field_150847_a = x;
				this.field_150845_b = y;
				this.field_150846_c = z;
				this.field_150844_d = idfk;
			}
		}
	}

	public static class SilkwoodRedTorch extends BlockTorch {
		private boolean field_150113_a;
		private static Map field_150112_b = new HashMap();
		private static final String __OBFID = "CL_00000298";

		private boolean func_150111_a(World world, int x, int y, int z, boolean on) {
			if (!field_150112_b.containsKey(world)) {
				field_150112_b.put(world, new ArrayList());
			}

			List list = (List) field_150112_b.get(world);

			if (on) {
				list.add(new SilkwoodRedTorch.Toggle(x, y, z, world.getTotalWorldTime()));
			}

			int l = 0;

			for (int i1 = 0; i1 < list.size(); ++i1) {
				SilkwoodRedTorch.Toggle toggle = (SilkwoodRedTorch.Toggle) list.get(i1);

				if (toggle.field_150847_a == x && toggle.field_150845_b == y && toggle.field_150846_c == z) {
					++l;

					if (l >= 8) {
						return true;
					}
				}
			}

			return false;
		}

		public SilkwoodRedTorch(boolean on) {
			this.field_150113_a = on;
			this.setTickRandomly(true);
		}

		/**
		 * How many world ticks before ticking
		 */
		public int tickRate(World world) {
			return 2;
		}

		/**
		 * Called whenever the block is added into the world. Args: world, x, y,
		 * z
		 */
		public void onBlockAdded(World world, int x, int y, int z) {
			if (world.getBlockMetadata(x, y, z) == 0) {
				super.onBlockAdded(world, x, y, z);
			}

			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int damage) {
			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public int isProvidingWeakPower(IBlockAccess blockAcc, int x, int y, int z, int power) {
			if (!this.field_150113_a) {
				return 0;
			} else {
				int i1 = blockAcc.getBlockMetadata(x, y, z);
				return i1 == 5 && power == 1 ? 0
						: (i1 == 3 && power == 3 ? 0
								: (i1 == 4 && power == 2 ? 0
										: (i1 == 1 && power == 5 ? 0 : (i1 == 2 && power == 4 ? 0 : 15))));
			}
		}

		private boolean func_150110_m(World world, int x, int y, int z) {
			int l = world.getBlockMetadata(x, y, z);
			return l == 5 && world.getIndirectPowerOutput(x, y - 1, z, 0) ? true
					: (l == 3 && world.getIndirectPowerOutput(x, y, z - 1, 2) ? true
							: (l == 4 && world.getIndirectPowerOutput(x, y, z + 1, 3) ? true
									: (l == 1 && world.getIndirectPowerOutput(x - 1, y, z, 4) ? true
											: l == 2 && world.getIndirectPowerOutput(x + 1, y, z, 5))));
		}

		/**
		 * Ticks the block if it's been scheduled
		 */
		public void updateTick(World world, int x, int y, int z, Random rand) {
			boolean flag = this.func_150110_m(world, x, y, z);
			List list = (List) field_150112_b.get(world);

			while (list != null && !list.isEmpty()
					&& world.getTotalWorldTime() - ((SilkwoodRedTorch.Toggle) list.get(0)).field_150844_d > 60L) {
				list.remove(0);
			}

			if (this.field_150113_a) {
				if (flag) {
					world.setBlock(x, y, z, mod_IDT.SilkwoodRedTorch, world.getBlockMetadata(x, y, z), 3);

					if (this.func_150111_a(world, x, y, z, true)) {
						world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
								(double) ((float) z + 0.5F), "random.fizz", 0.5F,
								2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

						for (int l = 0; l < 5; ++l) {
							double d0 = (double) x + rand.nextDouble() * 0.6D + 0.2D;
							double d1 = (double) y + rand.nextDouble() * 0.6D + 0.2D;
							double d2 = (double) z + rand.nextDouble() * 0.6D + 0.2D;
							world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			} else if (!flag && !this.func_150111_a(world, x, y, z, false)) {
				world.setBlock(x, y, z, mod_IDT.SilkwoodRedTorchOn, world.getBlockMetadata(x, y, z), 3);
			}
		}

		/**
		 * Lets the block know when one of its neighbor changes. Doesn't know
		 * which neighbor changed (coordinates passed are their own) Args: x, y,
		 * z, neighbor Block
		 */
		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (!this.func_150108_b(world, x, y, z, block)) {
				boolean flag = this.func_150110_m(world, x, y, z);

				if (this.field_150113_a && flag || !this.field_150113_a && !flag) {
					world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
				}
			}
		}

		public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int power) {
			return power == 0 ? this.isProvidingWeakPower(world, x, y, z, power) : 0;
		}

		public Item getItemDropped(int id, Random rand, int damage) {
			return Item.getItemFromBlock(mod_IDT.SilkwoodRedTorchOn);
		}

		/**
		 * Can this block provide power. Only wire currently seems to have this
		 * change based on its state.
		 */
		public boolean canProvidePower() {
			return true;
		}

		/**
		 * A randomly called display update to be able to add particles or other
		 * items for display
		 */
		@SideOnly(Side.CLIENT)
		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.field_150113_a) {
				int l = world.getBlockMetadata(x, y, z);
				double d0 = (double) ((float) x + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d1 = (double) ((float) y + 0.7F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d2 = (double) ((float) z + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d3 = 0.2199999988079071D;
				double d4 = 0.27000001072883606D;

				if (l == 1) {
					world.spawnParticle("reddust", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					world.spawnParticle("reddust", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 4) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				} else {
					world.spawnParticle("reddust", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		/**
		 * Gets an item for the block being called on. Args: world, x, y, z
		 */
		@SideOnly(Side.CLIENT)
		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.SilkwoodRedTorchOn);
		}

		public boolean isAssociatedBlock(Block block) {
			return block == mod_IDT.SilkwoodRedTorch || block == mod_IDT.SilkwoodRedTorchOn;
		}

		static class Toggle {
			int field_150847_a;
			int field_150845_b;
			int field_150846_c;
			long field_150844_d;
			private static final String __OBFID = "CL_00000299";

			public Toggle(int x, int y, int z, long idfk) {
				this.field_150847_a = x;
				this.field_150845_b = y;
				this.field_150846_c = z;
				this.field_150844_d = idfk;
			}
		}
	}

	public static class AcaciaRedTorch extends BlockTorch {
		private boolean field_150113_a;
		private static Map field_150112_b = new HashMap();
		private static final String __OBFID = "CL_00000298";

		private boolean func_150111_a(World world, int x, int y, int z, boolean on) {
			if (!field_150112_b.containsKey(world)) {
				field_150112_b.put(world, new ArrayList());
			}

			List list = (List) field_150112_b.get(world);

			if (on) {
				list.add(new AcaciaRedTorch.Toggle(x, y, z, world.getTotalWorldTime()));
			}

			int l = 0;

			for (int i1 = 0; i1 < list.size(); ++i1) {
				AcaciaRedTorch.Toggle toggle = (AcaciaRedTorch.Toggle) list.get(i1);

				if (toggle.field_150847_a == x && toggle.field_150845_b == y && toggle.field_150846_c == z) {
					++l;

					if (l >= 8) {
						return true;
					}
				}
			}

			return false;
		}

		public AcaciaRedTorch(boolean on) {
			this.field_150113_a = on;
			this.setTickRandomly(true);
		}

		/**
		 * How many world ticks before ticking
		 */
		public int tickRate(World world) {
			return 2;
		}

		/**
		 * Called whenever the block is added into the world. Args: world, x, y,
		 * z
		 */
		public void onBlockAdded(World world, int x, int y, int z) {
			if (world.getBlockMetadata(x, y, z) == 0) {
				super.onBlockAdded(world, x, y, z);
			}

			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int damage) {
			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public int isProvidingWeakPower(IBlockAccess blockAcc, int x, int y, int z, int power) {
			if (!this.field_150113_a) {
				return 0;
			} else {
				int i1 = blockAcc.getBlockMetadata(x, y, z);
				return i1 == 5 && power == 1 ? 0
						: (i1 == 3 && power == 3 ? 0
								: (i1 == 4 && power == 2 ? 0
										: (i1 == 1 && power == 5 ? 0 : (i1 == 2 && power == 4 ? 0 : 15))));
			}
		}

		private boolean func_150110_m(World world, int x, int y, int z) {
			int l = world.getBlockMetadata(x, y, z);
			return l == 5 && world.getIndirectPowerOutput(x, y - 1, z, 0) ? true
					: (l == 3 && world.getIndirectPowerOutput(x, y, z - 1, 2) ? true
							: (l == 4 && world.getIndirectPowerOutput(x, y, z + 1, 3) ? true
									: (l == 1 && world.getIndirectPowerOutput(x - 1, y, z, 4) ? true
											: l == 2 && world.getIndirectPowerOutput(x + 1, y, z, 5))));
		}

		/**
		 * Ticks the block if it's been scheduled
		 */
		public void updateTick(World world, int x, int y, int z, Random rand) {
			boolean flag = this.func_150110_m(world, x, y, z);
			List list = (List) field_150112_b.get(world);

			while (list != null && !list.isEmpty()
					&& world.getTotalWorldTime() - ((AcaciaRedTorch.Toggle) list.get(0)).field_150844_d > 60L) {
				list.remove(0);
			}

			if (this.field_150113_a) {
				if (flag) {
					world.setBlock(x, y, z, mod_IDT.AcaciaRedTorch, world.getBlockMetadata(x, y, z), 3);

					if (this.func_150111_a(world, x, y, z, true)) {
						world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
								(double) ((float) z + 0.5F), "random.fizz", 0.5F,
								2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

						for (int l = 0; l < 5; ++l) {
							double d0 = (double) x + rand.nextDouble() * 0.6D + 0.2D;
							double d1 = (double) y + rand.nextDouble() * 0.6D + 0.2D;
							double d2 = (double) z + rand.nextDouble() * 0.6D + 0.2D;
							world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			} else if (!flag && !this.func_150111_a(world, x, y, z, false)) {
				world.setBlock(x, y, z, mod_IDT.AcaciaRedTorchOn, world.getBlockMetadata(x, y, z), 3);
			}
		}

		/**
		 * Lets the block know when one of its neighbor changes. Doesn't know
		 * which neighbor changed (coordinates passed are their own) Args: x, y,
		 * z, neighbor Block
		 */
		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (!this.func_150108_b(world, x, y, z, block)) {
				boolean flag = this.func_150110_m(world, x, y, z);

				if (this.field_150113_a && flag || !this.field_150113_a && !flag) {
					world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
				}
			}
		}

		public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int power) {
			return power == 0 ? this.isProvidingWeakPower(world, x, y, z, power) : 0;
		}

		public Item getItemDropped(int id, Random rand, int damage) {
			return Item.getItemFromBlock(mod_IDT.AcaciaRedTorchOn);
		}

		/**
		 * Can this block provide power. Only wire currently seems to have this
		 * change based on its state.
		 */
		public boolean canProvidePower() {
			return true;
		}

		/**
		 * A randomly called display update to be able to add particles or other
		 * items for display
		 */
		@SideOnly(Side.CLIENT)
		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.field_150113_a) {
				int l = world.getBlockMetadata(x, y, z);
				double d0 = (double) ((float) x + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d1 = (double) ((float) y + 0.7F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d2 = (double) ((float) z + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d3 = 0.2199999988079071D;
				double d4 = 0.27000001072883606D;

				if (l == 1) {
					world.spawnParticle("reddust", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					world.spawnParticle("reddust", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 4) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				} else {
					world.spawnParticle("reddust", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		/**
		 * Gets an item for the block being called on. Args: world, x, y, z
		 */
		@SideOnly(Side.CLIENT)
		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.AcaciaRedTorchOn);
		}

		public boolean isAssociatedBlock(Block block) {
			return block == mod_IDT.AcaciaRedTorch || block == mod_IDT.AcaciaRedTorchOn;
		}

		static class Toggle {
			int field_150847_a;
			int field_150845_b;
			int field_150846_c;
			long field_150844_d;
			private static final String __OBFID = "CL_00000299";

			public Toggle(int x, int y, int z, long idfk) {
				this.field_150847_a = x;
				this.field_150845_b = y;
				this.field_150846_c = z;
				this.field_150844_d = idfk;
			}
		}
	}

	public static class DarkOakRedTorch extends BlockTorch {
		private boolean field_150113_a;
		private static Map field_150112_b = new HashMap();
		private static final String __OBFID = "CL_00000298";

		private boolean func_150111_a(World world, int x, int y, int z, boolean on) {
			if (!field_150112_b.containsKey(world)) {
				field_150112_b.put(world, new ArrayList());
			}

			List list = (List) field_150112_b.get(world);

			if (on) {
				list.add(new DarkOakRedTorch.Toggle(x, y, z, world.getTotalWorldTime()));
			}

			int l = 0;

			for (int i1 = 0; i1 < list.size(); ++i1) {
				DarkOakRedTorch.Toggle toggle = (DarkOakRedTorch.Toggle) list.get(i1);

				if (toggle.field_150847_a == x && toggle.field_150845_b == y && toggle.field_150846_c == z) {
					++l;

					if (l >= 8) {
						return true;
					}
				}
			}

			return false;
		}

		public DarkOakRedTorch(boolean on) {
			this.field_150113_a = on;
			this.setTickRandomly(true);
		}

		/**
		 * How many world ticks before ticking
		 */
		public int tickRate(World world) {
			return 2;
		}

		/**
		 * Called whenever the block is added into the world. Args: world, x, y,
		 * z
		 */
		public void onBlockAdded(World world, int x, int y, int z) {
			if (world.getBlockMetadata(x, y, z) == 0) {
				super.onBlockAdded(world, x, y, z);
			}

			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int damage) {
			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public int isProvidingWeakPower(IBlockAccess blockAcc, int x, int y, int z, int power) {
			if (!this.field_150113_a) {
				return 0;
			} else {
				int i1 = blockAcc.getBlockMetadata(x, y, z);
				return i1 == 5 && power == 1 ? 0
						: (i1 == 3 && power == 3 ? 0
								: (i1 == 4 && power == 2 ? 0
										: (i1 == 1 && power == 5 ? 0 : (i1 == 2 && power == 4 ? 0 : 15))));
			}
		}

		private boolean func_150110_m(World world, int x, int y, int z) {
			int l = world.getBlockMetadata(x, y, z);
			return l == 5 && world.getIndirectPowerOutput(x, y - 1, z, 0) ? true
					: (l == 3 && world.getIndirectPowerOutput(x, y, z - 1, 2) ? true
							: (l == 4 && world.getIndirectPowerOutput(x, y, z + 1, 3) ? true
									: (l == 1 && world.getIndirectPowerOutput(x - 1, y, z, 4) ? true
											: l == 2 && world.getIndirectPowerOutput(x + 1, y, z, 5))));
		}

		/**
		 * Ticks the block if it's been scheduled
		 */
		public void updateTick(World world, int x, int y, int z, Random rand) {
			boolean flag = this.func_150110_m(world, x, y, z);
			List list = (List) field_150112_b.get(world);

			while (list != null && !list.isEmpty()
					&& world.getTotalWorldTime() - ((DarkOakRedTorch.Toggle) list.get(0)).field_150844_d > 60L) {
				list.remove(0);
			}

			if (this.field_150113_a) {
				if (flag) {
					world.setBlock(x, y, z, mod_IDT.DarkOakRedTorch, world.getBlockMetadata(x, y, z), 3);

					if (this.func_150111_a(world, x, y, z, true)) {
						world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
								(double) ((float) z + 0.5F), "random.fizz", 0.5F,
								2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

						for (int l = 0; l < 5; ++l) {
							double d0 = (double) x + rand.nextDouble() * 0.6D + 0.2D;
							double d1 = (double) y + rand.nextDouble() * 0.6D + 0.2D;
							double d2 = (double) z + rand.nextDouble() * 0.6D + 0.2D;
							world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			} else if (!flag && !this.func_150111_a(world, x, y, z, false)) {
				world.setBlock(x, y, z, mod_IDT.DarkOakRedTorchOn, world.getBlockMetadata(x, y, z), 3);
			}
		}

		/**
		 * Lets the block know when one of its neighbor changes. Doesn't know
		 * which neighbor changed (coordinates passed are their own) Args: x, y,
		 * z, neighbor Block
		 */
		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (!this.func_150108_b(world, x, y, z, block)) {
				boolean flag = this.func_150110_m(world, x, y, z);

				if (this.field_150113_a && flag || !this.field_150113_a && !flag) {
					world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
				}
			}
		}

		public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int power) {
			return power == 0 ? this.isProvidingWeakPower(world, x, y, z, power) : 0;
		}

		public Item getItemDropped(int id, Random rand, int damage) {
			return Item.getItemFromBlock(mod_IDT.DarkOakRedTorchOn);
		}

		/**
		 * Can this block provide power. Only wire currently seems to have this
		 * change based on its state.
		 */
		public boolean canProvidePower() {
			return true;
		}

		/**
		 * A randomly called display update to be able to add particles or other
		 * items for display
		 */
		@SideOnly(Side.CLIENT)
		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.field_150113_a) {
				int l = world.getBlockMetadata(x, y, z);
				double d0 = (double) ((float) x + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d1 = (double) ((float) y + 0.7F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d2 = (double) ((float) z + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d3 = 0.2199999988079071D;
				double d4 = 0.27000001072883606D;

				if (l == 1) {
					world.spawnParticle("reddust", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					world.spawnParticle("reddust", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 4) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				} else {
					world.spawnParticle("reddust", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		/**
		 * Gets an item for the block being called on. Args: world, x, y, z
		 */
		@SideOnly(Side.CLIENT)
		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.DarkOakRedTorchOn);
		}

		public boolean isAssociatedBlock(Block block) {
			return block == mod_IDT.DarkOakRedTorch || block == mod_IDT.DarkOakRedTorchOn;
		}

		static class Toggle {
			int field_150847_a;
			int field_150845_b;
			int field_150846_c;
			long field_150844_d;
			private static final String __OBFID = "CL_00000299";

			public Toggle(int x, int y, int z, long idfk) {
				this.field_150847_a = x;
				this.field_150845_b = y;
				this.field_150846_c = z;
				this.field_150844_d = idfk;
			}
		}
	}

	public static class GelidRedTorch extends BlockTorch {
		private boolean field_150113_a;
		private static Map field_150112_b = new HashMap();
		private static final String __OBFID = "CL_00000298";

		private boolean func_150111_a(World world, int x, int y, int z, boolean on) {
			if (!field_150112_b.containsKey(world)) {
				field_150112_b.put(world, new ArrayList());
			}

			List list = (List) field_150112_b.get(world);

			if (on) {
				list.add(new GelidRedTorch.Toggle(x, y, z, world.getTotalWorldTime()));
			}

			int l = 0;

			for (int i1 = 0; i1 < list.size(); ++i1) {
				GelidRedTorch.Toggle toggle = (GelidRedTorch.Toggle) list.get(i1);

				if (toggle.field_150847_a == x && toggle.field_150845_b == y && toggle.field_150846_c == z) {
					++l;

					if (l >= 8) {
						return true;
					}
				}
			}

			return false;
		}

		public GelidRedTorch(boolean on) {
			this.field_150113_a = on;
			this.setTickRandomly(true);
		}

		/**
		 * How many world ticks before ticking
		 */
		public int tickRate(World world) {
			return 2;
		}

		/**
		 * Called whenever the block is added into the world. Args: world, x, y,
		 * z
		 */
		public void onBlockAdded(World world, int x, int y, int z) {
			if (world.getBlockMetadata(x, y, z) == 0) {
				super.onBlockAdded(world, x, y, z);
			}

			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public void breakBlock(World world, int x, int y, int z, Block block, int damage) {
			if (this.field_150113_a) {
				world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
				world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
				world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
				world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
				world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			}
		}

		public int isProvidingWeakPower(IBlockAccess blockAcc, int x, int y, int z, int power) {
			if (!this.field_150113_a) {
				return 0;
			} else {
				int i1 = blockAcc.getBlockMetadata(x, y, z);
				return i1 == 5 && power == 1 ? 0
						: (i1 == 3 && power == 3 ? 0
								: (i1 == 4 && power == 2 ? 0
										: (i1 == 1 && power == 5 ? 0 : (i1 == 2 && power == 4 ? 0 : 15))));
			}
		}

		private boolean func_150110_m(World world, int x, int y, int z) {
			int l = world.getBlockMetadata(x, y, z);
			return l == 5 && world.getIndirectPowerOutput(x, y - 1, z, 0) ? true
					: (l == 3 && world.getIndirectPowerOutput(x, y, z - 1, 2) ? true
							: (l == 4 && world.getIndirectPowerOutput(x, y, z + 1, 3) ? true
									: (l == 1 && world.getIndirectPowerOutput(x - 1, y, z, 4) ? true
											: l == 2 && world.getIndirectPowerOutput(x + 1, y, z, 5))));
		}

		/**
		 * Ticks the block if it's been scheduled
		 */
		public void updateTick(World world, int x, int y, int z, Random rand) {
			boolean flag = this.func_150110_m(world, x, y, z);
			List list = (List) field_150112_b.get(world);

			while (list != null && !list.isEmpty()
					&& world.getTotalWorldTime() - ((GelidRedTorch.Toggle) list.get(0)).field_150844_d > 60L) {
				list.remove(0);
			}

			if (this.field_150113_a) {
				if (flag) {
					world.setBlock(x, y, z, mod_IDT.GelidRedTorch, world.getBlockMetadata(x, y, z), 3);

					if (this.func_150111_a(world, x, y, z, true)) {
						world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F),
								(double) ((float) z + 0.5F), "random.fizz", 0.5F,
								2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

						for (int l = 0; l < 5; ++l) {
							double d0 = (double) x + rand.nextDouble() * 0.6D + 0.2D;
							double d1 = (double) y + rand.nextDouble() * 0.6D + 0.2D;
							double d2 = (double) z + rand.nextDouble() * 0.6D + 0.2D;
							world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			} else if (!flag && !this.func_150111_a(world, x, y, z, false)) {
				world.setBlock(x, y, z, mod_IDT.GelidRedTorchOn, world.getBlockMetadata(x, y, z), 3);
			}
		}

		/**
		 * Lets the block know when one of its neighbor changes. Doesn't know
		 * which neighbor changed (coordinates passed are their own) Args: x, y,
		 * z, neighbor Block
		 */
		public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
			if (!this.func_150108_b(world, x, y, z, block)) {
				boolean flag = this.func_150110_m(world, x, y, z);

				if (this.field_150113_a && flag || !this.field_150113_a && !flag) {
					world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
				}
			}
		}

		public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int power) {
			return power == 0 ? this.isProvidingWeakPower(world, x, y, z, power) : 0;
		}

		public Item getItemDropped(int id, Random rand, int damage) {
			return Item.getItemFromBlock(mod_IDT.GelidRedTorchOn);
		}

		/**
		 * Can this block provide power. Only wire currently seems to have this
		 * change based on its state.
		 */
		public boolean canProvidePower() {
			return true;
		}

		/**
		 * A randomly called display update to be able to add particles or other
		 * items for display
		 */
		@SideOnly(Side.CLIENT)
		public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
			if (this.field_150113_a) {
				int l = world.getBlockMetadata(x, y, z);
				double d0 = (double) ((float) x + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d1 = (double) ((float) y + 0.7F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d2 = (double) ((float) z + 0.5F) + (double) (rand.nextFloat() - 0.5F) * 0.2D;
				double d3 = 0.2199999988079071D;
				double d4 = 0.27000001072883606D;

				if (l == 1) {
					world.spawnParticle("reddust", d0 - d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 2) {
					world.spawnParticle("reddust", d0 + d4, d1 + d3, d2, 0.0D, 0.0D, 0.0D);
				} else if (l == 3) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 - d4, 0.0D, 0.0D, 0.0D);
				} else if (l == 4) {
					world.spawnParticle("reddust", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
				} else {
					world.spawnParticle("reddust", d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		/**
		 * Gets an item for the block being called on. Args: world, x, y, z
		 */
		@SideOnly(Side.CLIENT)
		public Item getItem(World world, int x, int y, int z) {
			return Item.getItemFromBlock(mod_IDT.GelidRedTorchOn);
		}

		public boolean isAssociatedBlock(Block block) {
			return block == mod_IDT.GelidRedTorch || block == mod_IDT.GelidRedTorchOn;
		}

		static class Toggle {
			int field_150847_a;
			int field_150845_b;
			int field_150846_c;
			long field_150844_d;
			private static final String __OBFID = "CL_00000299";

			public Toggle(int x, int y, int z, long idfk) {
				this.field_150847_a = x;
				this.field_150845_b = y;
				this.field_150846_c = z;
				this.field_150844_d = idfk;
			}
		}
	}
}
