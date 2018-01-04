package com.mce.api.waila;

import java.text.DecimalFormat;
import java.util.List;

import com.mce.common.mod_IDT;

import mcp.mobius.waila.api.ITaggedList;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.utils.WailaExceptionHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class HUDHandlerIDT implements IWailaDataProvider {
	public ItemStack getWailaStack(IWailaDataAccessor data, IWailaConfigHandler conf) {
		return null;
	}

	public List<String> getWailaHead(ItemStack stack, List<String> list, IWailaDataAccessor data,
			IWailaConfigHandler conf) {
		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<String> getWailaBody(ItemStack stack, List<String> list, IWailaDataAccessor data,
			IWailaConfigHandler conf) {
		int damage = data.getNBTInteger(data.getNBTData(), "DamageAmount");
		int maxDamage = data.getNBTInteger(data.getNBTData(), "MaxDamage");
		NBTTagCompound tag = data.getNBTData();

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		double increase = maxDamage - damage;
		double pdam = ((increase * 100d) / maxDamage);
		String dam = String.valueOf(df.format(pdam));

		try {
			// Smelter Modes
			if ((((ITaggedList) list).getEntries("SmelterMode").size() == 0)) {
				if (tag.getString("SmelterMode").equals("container.smelter.nuclear")) {
					((ITaggedList) list).add("Smelter Mode: Nuclear");
				}

				else if (tag.getString("SmelterMode").equals("container.smelter.nuclear.super")) {
					((ITaggedList) list).add("Smelter Mode: Thermal Nuclear");
				}

				else if (tag.getString("SmelterMode").equals("container.smelter.induction")) {
					((ITaggedList) list).add("Smelter Mode: Induction");
				}

				else if (tag.getString("SmelterMode").equals("")) {
					((ITaggedList) list).add("");
				}
			}

			// Tech Damage
			if ((maxDamage != 0) && (((ITaggedList) list).getEntries("DamageAmount").size() == 0)) {
				((ITaggedList) list).add(String.format("%d / %d Damage", damage, maxDamage), "DamageAmount");
				((ITaggedList) list).add(dam + "% Damaged");
			}
		} catch (Exception e) {
			list = WailaExceptionHandler.handleErr(e, data.getTileEntity().getClass().getName(), list);
		}
		return list;
	}

	public List<String> getWailaTail(ItemStack stack, List<String> list, IWailaDataAccessor data,
			IWailaConfigHandler conf) {
		// Other
		if (stack.getItem() == Item.getItemFromBlock(mod_IDT.DidymiumGlass)) {
			list.add("Welder's Glass");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.DidymiumGlassPane)) {
			list.add("Welder's Glass");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.EinsteiniumOre)) {
			list.add("Radioactive!");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.NeptuniumOre)) {
			list.add("Radioactive!");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.UraniumOre)) {
			list.add("Radioactive!");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.EinsteiniumBlock)) {
			list.add("Radioactive!");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.NeptuniumBlock)) {
			list.add("Radioactive!");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.UraniumBlock)) {
			list.add("Radioactive!");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.EinsteiniumBomb)) {
			list.add(EnumChatFormatting.BOLD + "**" + EnumChatFormatting.RESET + "*****");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.NeptuniumBomb)) {
			list.add(EnumChatFormatting.BOLD + "***" + EnumChatFormatting.RESET + "****");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.UraniumBomb)) {
			list.add(EnumChatFormatting.BOLD + "****" + EnumChatFormatting.RESET + "***");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.UltimateNuker)) {
			list.add(EnumChatFormatting.BOLD + "******" + EnumChatFormatting.RESET + "*");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.StableBlackHole)) {
			list.add("Fancy Trashcan");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.LiquidNitrogen)) {
			list.add("Cold!");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.MetalFrame) && stack.getItemDamage() == 0) {
			list.add("Tier 1 Frame");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.MetalFrame) && stack.getItemDamage() == 1) {
			list.add("Tier 2 Frame");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.MetalFrame) && stack.getItemDamage() == 2) {
			list.add("Tier 3 Frame");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.MetalFrame) && stack.getItemDamage() == 3) {
			list.add("Tier 4 Frame");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.MetalFrame) && stack.getItemDamage() == 4) {
			list.add("Tier 5 Frame");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.BioFuelExtractor) && stack.getItemDamage() == 0) {
			list.add("Using Tier 1 Casing");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.BioFuelExtractor) && stack.getItemDamage() == 1) {
			list.add("Using Tier 2 Casing");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.BioFuelExtractor) && stack.getItemDamage() == 2) {
			list.add("Using Tier 3 Casing");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.BioFuelExtractor) && stack.getItemDamage() == 3) {
			list.add("Using Tier 4 Casing");
		}

		else if (stack.getItem() == Item.getItemFromBlock(mod_IDT.BioFuelExtractor) && stack.getItemDamage() == 4) {
			list.add("Using Tier 5 Casing");
		}
		return list;
	}

	public NBTTagCompound getNBTData(EntityPlayerMP playerMP, TileEntity te, NBTTagCompound tag, World world, int x,
			int y, int z) {
		try {
			Integer dam = -1;
			Integer mdam = -1;
			String mode = "";

			if (IDTModule.smelter.isInstance(te)) {
				dam = (Integer) IDTModule.smelter_damage.invoke(te);
				mdam = (Integer) IDTModule.smelter_damageMax.invoke(te);
				mode = (String) IDTModule.smelter_mode.invoke(te);
			}

			else if (IDTModule.cutter.isInstance(te)) {
				dam = (Integer) IDTModule.cutter_damage.invoke(te);
				mdam = (Integer) IDTModule.cutter_damageMax.invoke(te);
			}

			else if (IDTModule.bfe.isInstance(te)) {
				dam = (Integer) IDTModule.bfe_damage.invoke(te);
				mdam = (Integer) IDTModule.bfe_damageMax.invoke(te);
			}

			else if (IDTModule.bhg.isInstance(te)) {
				dam = (Integer) IDTModule.bhg_damage.invoke(te);
				mdam = (Integer) IDTModule.bhg_damageMax.invoke(te);
			}

			else if (IDTModule.mag.isInstance(te)) {
				dam = (Integer) IDTModule.mag_damage.invoke(te);
				mdam = (Integer) IDTModule.mag_damageMax.invoke(te);
			}

			else if (IDTModule.zng.isInstance(te)) {
				dam = (Integer) IDTModule.zng_damage.invoke(te);
				mdam = (Integer) IDTModule.zng_damageMax.invoke(te);
			}

			else if (IDTModule.tc.isInstance(te)) {
				dam = (Integer) IDTModule.tc_damage.invoke(te);
				mdam = (Integer) IDTModule.tc_damageMax.invoke(te);
			}

			else if (IDTModule.mc.isInstance(te)) {
				dam = (Integer) IDTModule.mc_damage.invoke(te);
				mdam = (Integer) IDTModule.mc_damageMax.invoke(te);
			}

			tag.setInteger("DamageAmount", dam);
			tag.setInteger("MaxDamage", mdam);
			tag.setString("SmelterMode", mode);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return tag;
	}
}
