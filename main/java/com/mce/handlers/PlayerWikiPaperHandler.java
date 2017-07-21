package com.mce.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import com.mce.common.mod_IDT;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerWikiPaperHandler {
	public static final String give_paper_tag = "givenPaper";
	public static final String modName = "IDT";

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		final Entity entity = event.entity;

		if (!event.world.isRemote && entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			NBTTagCompound persistTag = this.getModPlayerPersistTag(player,
					"IDT");

			boolean givePaper = mod_IDT.WikiPaper != null
					&& !persistTag.getBoolean(give_paper_tag);
			if (givePaper) {
				ItemStack manual = new ItemStack(mod_IDT.WikiPaper);
				if (!player.inventory.addItemStackToInventory(manual)) {
					this.dropItemStackInWorld(player.worldObj, player.posX,
							player.posY, player.posZ, manual);
				}
				persistTag.setBoolean(give_paper_tag, true);
			}
		}
	}

	public NBTTagCompound getModPlayerPersistTag(EntityPlayer player,
			String modName) {

		NBTTagCompound tag = player.getEntityData();

		NBTTagCompound persistTag = null;
		if (tag.hasKey(EntityPlayer.PERSISTED_NBT_TAG)) {
			persistTag = tag.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		} else {
			persistTag = new NBTTagCompound();
			tag.setTag(EntityPlayer.PERSISTED_NBT_TAG, persistTag);
		}

		NBTTagCompound modTag = null;
		if (persistTag.hasKey(modName)) {
			modTag = persistTag.getCompoundTag(modName);
		} else {
			modTag = new NBTTagCompound();
			persistTag.setTag(modName, modTag);
		}

		return modTag;
	}

	public EntityItem dropItemStackInWorld(World worldObj, double x, double y,
			double z, ItemStack stack) {
		float f = 0.7F;
		float d0 = worldObj.rand.nextFloat() * f + (1.0F - f) * 0.5F;
		float d1 = worldObj.rand.nextFloat() * f + (1.0F - f) * 0.5F;
		float d2 = worldObj.rand.nextFloat() * f + (1.0F - f) * 0.5F;
		EntityItem entityitem = new EntityItem(worldObj, x + d0, y + d1,
				z + d2, stack);
		entityitem.delayBeforeCanPickup = 10;
		if (stack.hasTagCompound()) {
			entityitem.getEntityItem().setTagCompound(
					(NBTTagCompound) stack.getTagCompound().copy());
		}
		worldObj.spawnEntityInWorld(entityitem);
		return entityitem;
	}
}
