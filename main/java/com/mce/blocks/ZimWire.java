package com.mce.blocks;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.mce.common.mod_IDT;
import com.mce.entity.tile.TileEntityZimWire;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class ZimWire extends BlockContainer {
	private boolean powered = true;
	private Set hash = new HashSet();

	/*
	 * public static IIcon cross; public static IIcon line; public static IIcon
	 * cross_overlay; public static IIcon line_overlay;
	 */

	public ZimWire(Material mat) {
		super(mat);
		float px = 1f / 16f;

		this.setBlockBounds(11 * px / 2, 11 * px / 2, 11 * px / 2, 1 - 11 * px / 2, 1 - 11 * px / 2, 1 - 11 * px / 2);
	}

	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityZimWire();
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return -1;
	}

	/*
	 * public int getRenderType() { return 5; }
	 */

	/*
	 * public int colorMultiplier(IBlockAccess block, int x, int y, int z) {
	 * return 8388608; }
	 * 
	 * public boolean canPlaceBlockAt(World world, int x, int y, int z) { return
	 * World.doesBlockHaveSolidTopSurface(world, x, y - 1, z); }
	 * 
	 * private void fe(World world, int x, int y, int z) { this.fa(world, x, y,
	 * z, x, y, z); ArrayList arraylist = new ArrayList(this.hash);
	 * this.hash.clear();
	 * 
	 * for (int l = 0; l < arraylist.size(); ++l) { ChunkPosition chunk =
	 * (ChunkPosition) arraylist.get(l);
	 * world.notifyBlocksOfNeighborChange(chunk.chunkPosX, chunk.chunkPosY,
	 * chunk.chunkPosZ, this); } }
	 * 
	 * private void fa(World world, int x, int y, int z, int xCoord, int
	 * yChoord, int zChoord) { int k1 = world.getBlockMetadata(x, y, z); byte b0
	 * = 0; int i3 = this.fa2(world, xCoord, yChoord, zChoord, b0); this.powered
	 * = false; int l1 = world.getStrongestIndirectPower(x, y, z); this.powered
	 * = true;
	 * 
	 * if (l1 > 0 && l1 > i3 - 1) { i3 = l1; }
	 * 
	 * int i2 = 0;
	 * 
	 * for (int j2 = 0; j2 < 4; ++j2) { int k2 = x; int l2 = z;
	 * 
	 * if (j2 == 0) { k2 = x - 1; }
	 * 
	 * if (j2 == 1) { ++k2; }
	 * 
	 * if (j2 == 2) { l2 = z - 1; }
	 * 
	 * if (j2 == 3) { ++l2; }
	 * 
	 * if (k2 != xCoord || l2 != zChoord) { i2 = this.fa2(world, k2, y, l2, i2);
	 * }
	 * 
	 * if (world.getBlock(k2, y, l2).isNormalCube() && !world.getBlock(x, y + 1,
	 * z).isNormalCube()) { if ((k2 != xCoord || l2 != zChoord) && y >= yChoord)
	 * { i2 = this.fa2(world, k2, y + 1, l2, i2); } } else if
	 * (!world.getBlock(k2, y, l2).isNormalCube() && (k2 != xCoord || l2 !=
	 * zChoord) && y <= yChoord) { i2 = this.fa2(world, k2, y - 1, l2, i2); } }
	 * 
	 * if (i2 > i3) { i3 = i2 - 1; } else if (i3 > 0) { --i3; } else { i3 = 0; }
	 * 
	 * if (l1 > i3 - 1) { i3 = l1; }
	 * 
	 * if (k1 != i3) { world.setBlockMetadataWithNotify(x, y, z, i3, 2);
	 * this.hash.add(new ChunkPosition(x, y, z)); this.hash.add(new
	 * ChunkPosition(x - 1, y, z)); this.hash.add(new ChunkPosition(x + 1, y,
	 * z)); this.hash.add(new ChunkPosition(x, y - 1, z)); this.hash.add(new
	 * ChunkPosition(x, y + 1, z)); this.hash.add(new ChunkPosition(x, y, z -
	 * 1)); this.hash.add(new ChunkPosition(x, y, z + 1)); } }
	 * 
	 * private void fm(World world, int x, int y, int z) { if (world.getBlock(x,
	 * y, z) == this) { world.notifyBlocksOfNeighborChange(x, y, z, this);
	 * world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
	 * world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
	 * world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
	 * world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
	 * world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
	 * world.notifyBlocksOfNeighborChange(x, y + 1, z, this); } }
	 * 
	 * public void onBlockAdded(World world, int x, int y, int z) {
	 * super.onBlockAdded(world, x, y, z);
	 * 
	 * if (!world.isRemote) { this.fe(world, x, y, z);
	 * world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
	 * world.notifyBlocksOfNeighborChange(x, y - 1, z, this); this.fm(world, x -
	 * 1, y, z); this.fm(world, x + 1, y, z); this.fm(world, x, y, z - 1);
	 * this.fm(world, x, y, z + 1);
	 * 
	 * if (world.getBlock(x - 1, y, z).isNormalCube()) { this.fm(world, x - 1, y
	 * + 1, z); } else { this.fm(world, x - 1, y - 1, z); }
	 * 
	 * if (world.getBlock(x + 1, y, z).isNormalCube()) { this.fm(world, x + 1, y
	 * + 1, z); } else { this.fm(world, x + 1, y - 1, z); }
	 * 
	 * if (world.getBlock(x, y, z - 1).isNormalCube()) { this.fm(world, x, y +
	 * 1, z - 1); } else { this.fm(world, x, y - 1, z - 1); }
	 * 
	 * if (world.getBlock(x, y, z + 1).isNormalCube()) { this.fm(world, x, y +
	 * 1, z + 1); } else { this.fm(world, x, y - 1, z + 1); } } }
	 * 
	 * public void breakBlock(World world, int x, int y, int z, Block block, int
	 * meta) { super.breakBlock(world, x, y, z, block, meta);
	 * 
	 * if (!world.isRemote) { world.notifyBlocksOfNeighborChange(x, y + 1, z,
	 * this); world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
	 * world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
	 * world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
	 * world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
	 * world.notifyBlocksOfNeighborChange(x, y, z - 1, this); this.fe(world, x,
	 * y, z); this.fm(world, x - 1, y, z); this.fm(world, x + 1, y, z);
	 * this.fm(world, x, y, z - 1); this.fm(world, x, y, z + 1);
	 * 
	 * if (world.getBlock(x - 1, y, z).isNormalCube()) { this.fm(world, x - 1, y
	 * + 1, z); } else { this.fm(world, x - 1, y - 1, z); }
	 * 
	 * if (world.getBlock(x + 1, y, z).isNormalCube()) { this.fm(world, x + 1, y
	 * + 1, z); } else { this.fm(world, x + 1, y - 1, z); }
	 * 
	 * if (world.getBlock(x, y, z - 1).isNormalCube()) { this.fm(world, x, y +
	 * 1, z - 1); } else { this.fm(world, x, y - 1, z - 1); }
	 * 
	 * if (world.getBlock(x, y, z + 1).isNormalCube()) { this.fm(world, x, y +
	 * 1, z + 1); } else { this.fm(world, x, y - 1, z + 1); } } }
	 * 
	 * private int fa2(World world, int x, int y, int z, int side) { if
	 * (world.getBlock(x, y, z) != this) { return side; } else { int i1 =
	 * world.getBlockMetadata(x, y, z); return i1 > side ? i1 : side; } }
	 * 
	 * public void onNeighborBlockChange(World world, int x, int y, int z, Block
	 * block) { if (!world.isRemote) { boolean flag =
	 * this.canPlaceBlockAt(world, x, y, z);
	 * 
	 * if (flag) { this.fe(world, x, y, z); } else { this.dropBlockAsItem(world,
	 * x, y, z, 0, 0); world.setBlockToAir(x, y, z); }
	 * 
	 * super.onNeighborBlockChange(world, x, y, z, block); } }
	 */

	public Item getItemDropped(int num, Random rand, int i) {
		return Item.getItemFromBlock(mod_IDT.ZimphnodeWire);
	}

	/*
	 * public int isProvidingStrongPower(IBlockAccess block, int x, int y, int
	 * z, int side) { return !this.powered ? 0 :
	 * this.isProvidingWeakPower(block, x, y, z, side); }
	 * 
	 * public int isProvidingWeakPower(IBlockAccess block, int x, int y, int z,
	 * int side) { if (!this.powered) { return 0; } else { int i1 =
	 * block.getBlockMetadata(x, y, z);
	 * 
	 * if (i1 == 0) { return 0; } else if (side == 1) { return i1; } else {
	 * boolean flag = fg(block, x - 1, y, z, 1) || !block.getBlock(x - 1, y,
	 * z).isNormalCube() && fg(block, x - 1, y - 1, z, -1); boolean flag1 =
	 * fg(block, x + 1, y, z, 3) || !block.getBlock(x + 1, y, z).isNormalCube()
	 * && fg(block, x + 1, y - 1, z, -1); boolean flag2 = fg(block, x, y, z - 1,
	 * 2) || !block.getBlock(x, y, z - 1).isNormalCube() && fg(block, x, y - 1,
	 * z - 1, -1); boolean flag3 = fg(block, x, y, z + 1, 0) ||
	 * !block.getBlock(x, y, z + 1).isNormalCube() && fg(block, x, y - 1, z + 1,
	 * -1);
	 * 
	 * if (!block.getBlock(x, y + 1, z).isNormalCube()) { if (block.getBlock(x -
	 * 1, y, z).isNormalCube() && fg(block, x - 1, y + 1, z, -1)) { flag = true;
	 * }
	 * 
	 * if (block.getBlock(x + 1, y, z).isNormalCube() && fg(block, x + 1, y + 1,
	 * z, -1)) { flag1 = true; }
	 * 
	 * if (block.getBlock(x, y, z - 1).isNormalCube() && fg(block, x, y + 1, z -
	 * 1, -1)) { flag2 = true; }
	 * 
	 * if (block.getBlock(x, y, z + 1).isNormalCube() && fg(block, x, y + 1, z +
	 * 1, -1)) { flag3 = true; } }
	 * 
	 * return !flag2 && !flag1 && !flag && !flag3 && side >= 2 && side <= 5 ? i1
	 * : (side == 2 && flag2 && !flag && !flag1 ? i1 : (side == 3 && flag3 &&
	 * !flag && !flag1 ? i1 : (side == 4 && flag && !flag2 && !flag3 ? i1 :
	 * (side == 5 && flag1 && !flag2 && !flag3 ? i1 : 0)))); } } }
	 */

	public boolean canProvidePower() {
		return this.powered;
	}

	/*
	 * public static boolean isPowerProviderOrWire(IBlockAccess block2, int x,
	 * int y, int z, int side) { Block block = block2.getBlock(x, y, z);
	 * 
	 * if (block == mod_IDT.ZimphnodeWire) { return true; } else { int i1 =
	 * block2.getBlockMetadata(x, y, z); return side == (i1 & 3) || side ==
	 * Direction.rotateOpposite[i1 & 3]; } }
	 * 
	 * @SideOnly(Side.CLIENT) public void randomDisplayTick(World world, int x,
	 * int y, int z, Random rand) { int l = world.getBlockMetadata(x, y, z);
	 * 
	 * if (l > 0) { double d0 = (double) x + 0.5D + ((double) rand.nextFloat() -
	 * 0.5D) * 0.2D; double d1 = (double) ((float) y + 0.0625F); double d2 =
	 * (double) z + 0.5D + ((double) rand.nextFloat() - 0.5D) * 0.2D; float f =
	 * (float) l / 15.0F; float f1 = f * 0.6F + 0.4F;
	 * 
	 * if (l == 0) { f1 = 0.0F; }
	 * 
	 * float f2 = f * f * 0.7F - 0.5F; float f3 = f * f * 0.6F - 0.7F;
	 * 
	 * if (f2 < 0.0F) { f2 = 0.0F; }
	 * 
	 * if (f3 < 0.0F) { f3 = 0.0F; }
	 * 
	 * // world.spawnParticle("reddust", d0, d1, d2, (double) f1, (double) //
	 * f2, (double) f3); } }
	 * 
	 * public static boolean fg(IBlockAccess block, int x, int y, int z, int
	 * side) { if (isPowerProviderOrWire(block, x, y, z, side)) { return true; }
	 * else { return false; } }
	 */

	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(mod_IDT.ZimphnodeWire);
	}

	/*
	 * public void registerBlockIcons(IIconRegister icon) { this.cross =
	 * icon.registerIcon(this.getTextureName() + "_" + "cross"); this.line =
	 * icon.registerIcon(this.getTextureName() + "_" + "line");
	 * this.cross_overlay = icon.registerIcon(this.getTextureName() + "_" +
	 * "cross_overlay"); this.line_overlay =
	 * icon.registerIcon(this.getTextureName() + "_" + "line_overlay");
	 * this.blockIcon = this.cross; }
	 * 
	 * public static IIcon getRedstoneWireIcon(String s) { return
	 * s.equals("cross") ? cross : (s.equals("line") ? line :
	 * (s.equals("cross_overlay") ? cross_overlay : (s.equals("line_overlay") ?
	 * line_overlay : null))); }
	 */
}