package com.mce.items;

import com.mce.entity.tile.wall_parts.TileEntityWPAcacia;
import com.mce.entity.tile.wall_parts.TileEntityWPBirch;
import com.mce.entity.tile.wall_parts.TileEntityWPBrick;
import com.mce.entity.tile.wall_parts.TileEntityWPCement;
import com.mce.entity.tile.wall_parts.TileEntityWPCementBrick;
import com.mce.entity.tile.wall_parts.TileEntityWPCoal;
import com.mce.entity.tile.wall_parts.TileEntityWPCobblestone;
import com.mce.entity.tile.wall_parts.TileEntityWPDarkOak;
import com.mce.entity.tile.wall_parts.TileEntityWPEbony;
import com.mce.entity.tile.wall_parts.TileEntityWPGelid;
import com.mce.entity.tile.wall_parts.TileEntityWPJungle;
import com.mce.entity.tile.wall_parts.TileEntityWPMossyCobblestone;
import com.mce.entity.tile.wall_parts.TileEntityWPNetherBrick;
import com.mce.entity.tile.wall_parts.TileEntityWPOak;
import com.mce.entity.tile.wall_parts.TileEntityWPObsidian;
import com.mce.entity.tile.wall_parts.TileEntityWPQuartz;
import com.mce.entity.tile.wall_parts.TileEntityWPSandstone;
import com.mce.entity.tile.wall_parts.TileEntityWPSilkwood;
import com.mce.entity.tile.wall_parts.TileEntityWPSnow;
import com.mce.entity.tile.wall_parts.TileEntityWPSpruce;
import com.mce.entity.tile.wall_parts.TileEntityWPStone;
import com.mce.entity.tile.wall_parts.TileEntityWPStonebrick;
import com.mce.entity.tile.wall_parts.TileEntityWPWillow;

import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class WallPart extends Item {
	public WallPart() {
		super();
	}

	public static class CementWallPart extends Item {
		public CementWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPCement();
		}
	}

	public static class CementBrickWallPart extends Item {
		public CementBrickWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPCementBrick();
		}
	}

	public static class StoneWallPart extends Item {
		public StoneWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPStone();
		}
	}

	public static class CobblestoneWallPart extends Item {
		public CobblestoneWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPCobblestone();
		}
	}

	public static class MossyCobblestoneWallPart extends Item {
		public MossyCobblestoneWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPMossyCobblestone();
		}
	}

	public static class SandstoneWallPart extends Item {
		public SandstoneWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPSandstone();
		}
	}

	public static class ObsidianWallPart extends Item {
		public ObsidianWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPObsidian();
		}
	}

	public static class StonebrickWallPart extends Item {
		public StonebrickWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPStonebrick();
		}
	}

	public static class BrickWallPart extends Item {
		public BrickWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPBrick();
		}
	}

	public static class CoalWallPart extends Item {
		public CoalWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPCoal();
		}
	}

	public static class SnowWallPart extends Item {
		public SnowWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPSnow();
		}
	}

	public static class NetherBrickWallPart extends Item {
		public NetherBrickWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPNetherBrick();
		}
	}

	public static class QuartzWallPart extends Item {
		public QuartzWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPQuartz();
		}
	}

	public static class OakWallPart extends Item {
		public OakWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPOak();
		}
	}

	public static class BirchWallPart extends Item {
		public BirchWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPBirch();
		}
	}

	public static class SpruceWallPart extends Item {
		public SpruceWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPSpruce();
		}
	}

	public static class JungleWallPart extends Item {
		public JungleWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPJungle();
		}
	}

	public static class WillowWallPart extends Item {
		public WillowWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPWillow();
		}
	}

	public static class EbonyWallPart extends Item {
		public EbonyWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPEbony();
		}
	}

	public static class SilkwoodWallPart extends Item {
		public SilkwoodWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPSilkwood();
		}
	}

	public static class AcaciaWallPart extends Item {
		public AcaciaWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPAcacia();
		}
	}

	public static class DarkOakWallPart extends Item {
		public DarkOakWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPDarkOak();
		}
	}

	public static class GelidWallPart extends Item {
		public GelidWallPart() {
			super();
		}

		public TileEntity createNewTileEntity(World world, int meta) {
			return new TileEntityWPGelid();
		}
	}
}
