package com.mce.gen.structures.parts;

import java.util.List;
import java.util.Random;

import com.mce.common.mod_IDT;
import com.mce.util.SchematicReader;
import com.mce.util.SchematicReader.Schematic;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public class VillageComponentIndustrialist extends StructureVillagePieces.Village {
	private int averageGround = -1;
	private boolean madeChest;

	private static int x = 9;
	private static int y = 7;
	private static int z = 11;

	private SchematicReader sread = new SchematicReader();
	SchematicReader.Schematic sch;

	public VillageComponentIndustrialist(StructureVillagePieces.Start pieces, int i, Random rand,
			StructureBoundingBox box, int j) {
		this.coordBaseMode = j;
		this.boundingBox = box;
	}

	// Item, metadata, min, max, weight
	public static final WeightedRandomChestContent[] indChest = {
			new WeightedRandomChestContent(mod_IDT.SteelIngot, 0, 1, 32, 15),
			new WeightedRandomChestContent(mod_IDT.TitaniumIngot, 0, 1, 16, 13),
			new WeightedRandomChestContent(mod_IDT.NeoronIngot, 0, 0, 8, 8),
			new WeightedRandomChestContent(mod_IDT.DiamondSawBlade, 0, 0, 1, 2),
			new WeightedRandomChestContent(mod_IDT.CopperDust, 0, 1, 32, 15),
			new WeightedRandomChestContent(mod_IDT.Carbon, 0, 1, 32, 15),
			new WeightedRandomChestContent(mod_IDT.AmblygoniteDust, 0, 0, 6, 2),
			new WeightedRandomChestContent(mod_IDT.CopperWire, 0, 1, 6, 15),
			new WeightedRandomChestContent(mod_IDT.Plank, 0, 3, 6, 15),
			new WeightedRandomChestContent(mod_IDT.Gear, 0, 0, 2, 15),
			new WeightedRandomChestContent(mod_IDT.SteelRod, 0, 0, 4, 15),
			new WeightedRandomChestContent(mod_IDT.CopperFoil, 0, 1, 6, 15),
			new WeightedRandomChestContent(mod_IDT.CopperIngot, 0, 1, 16, 15),
			new WeightedRandomChestContent(mod_IDT.UraniumIngot, 0, 1, 16, 15),
			new WeightedRandomChestContent(mod_IDT.SiliconDust, 0, 0, 8, 15),
			new WeightedRandomChestContent(mod_IDT.BoronIngot, 0, 0, 6, 6),
			new WeightedRandomChestContent(mod_IDT.VanadiumDust, 0, 0, 4, 5),
			new WeightedRandomChestContent(Item.getItemFromBlock(mod_IDT.SteelBlock), 0, 0, 2, 15),
			new WeightedRandomChestContent(Item.getItemFromBlock(mod_IDT.CopperBlock), 0, 0, 2, 15),
			new WeightedRandomChestContent(mod_IDT.Sulfur, 0, 0, 6, 5) };

	protected void writeNBT(NBTTagCompound tag) {
		super.func_143012_a(tag);
		tag.setBoolean("IDT_createdChest-ind", this.madeChest);
	}

	protected void readNBT(NBTTagCompound tag) {
		super.func_143011_b(tag);
		this.madeChest = tag.getBoolean("IDT_createdChest-ind");
	}

	public static VillageComponentIndustrialist buildComponent(StructureVillagePieces.Start villagePiece, List pieces,
			Random rand, int p1, int p2, int p3, int p4, int p5) {
		StructureBoundingBox box = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, x, y, z, p4);
		return (canVillageGoDeeper(box)) && (StructureComponent.findIntersecting(pieces, box) == null)
				? new VillageComponentIndustrialist(villagePiece, p5, rand, box, p4) : null;
	}

	public boolean addComponentParts(World world, Random rand, StructureBoundingBox box) {
		int bcy = 0;
		int i = 0;
		int blockUnderGround = 1;
		Schematic house = sread.get("indHouse.schematic");

		if (this.averageGround < 0) {
			this.averageGround = getAverageGroundLevel(world, box);
			if (this.averageGround < 0) {
				return true;
			}
			this.boundingBox.offset(0, this.averageGround - this.boundingBox.maxY + 4, 0);
		}

		for (bcy = 256; bcy > 32; bcy--) {
			if (world.getBlock(x, bcy - 1, z) != Blocks.air) {
				bcy = bcy - (blockUnderGround + 1);
				break;
			}
		}

		for (int y = 0; y < house.height; y++) {
			for (int z = 0; z < house.length; z++) {
				for (int x = 0; x < house.width; x++) {

					Block b = Block.getBlockById(house.blocks[i]);
					if (b != Blocks.air) {
						placeBlockAtCurrentPosition(world, Blocks.air, 0, x, y + bcy, z, box);
						placeBlockAtCurrentPosition(world, b, house.data[i], x, y + bcy, z, box);
					}
					i++;
				}
			}
		}

		if (!this.madeChest) {
			int l = getYWithOffset(1);
			int m = getXWithOffset(5, 5);
			int n = getZWithOffset(5, 5);
			if (box.isVecInside(l, m, n)) {
				this.madeChest = true;
				generateStructureChestContents(world, box, rand, 5, 3, 5, indChest, 1 + rand.nextInt(3));
			}
		}

		spawnVillagers(world, box, 2, 3, 5, 1);
		return true;
	}

	public int getVillagerType(int i) {
		return 3;
	}
}