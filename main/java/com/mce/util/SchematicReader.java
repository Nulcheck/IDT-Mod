package com.mce.util;

import java.io.InputStream;

import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class SchematicReader {
	public Schematic get(String schemname) {
		try {
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("assets/mod_idt/schem/" + schemname);
			NBTTagCompound tag = CompressedStreamTools.readCompressed(is);
			short width = tag.getShort("Width");
			short height = tag.getShort("Height");
			short length = tag.getShort("Length");

			byte[] blocks = tag.getByteArray("Blocks");
			byte[] data = tag.getByteArray("Data");
			NBTTagList te = tag.getTagList("TileEntities", 10);
			is.close();

			return new Schematic(te, width, height, length, blocks, data);
		} catch (Exception e) {
			System.out.println("An error has occurred! Error ID: 307. Problem: " + e.toString());
			return null;
		}
	}

	public class Schematic {
		public NBTTagList te;
		public short width;
		public short height;
		public short length;
		public byte[] blocks;
		public byte[] data;

		public Schematic(NBTTagList teList, short width, short height, short length, byte[] blocks, byte[] data) {
			this.te = teList;
			this.width = width;
			this.height = height;
			this.length = length;
			this.blocks = blocks;
			this.data = data;
		}
	}
}
