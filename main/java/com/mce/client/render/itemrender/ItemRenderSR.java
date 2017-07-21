package com.mce.client.render.itemrender;

import org.lwjgl.opengl.GL11;

import com.mce.blocks.modeled.superReactor;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderSR implements IItemRenderer {
	public static final ResourceLocation texture = new ResourceLocation("mod_idt",
			"/textures/models/superReactor.png".substring(1));
	private superReactor model;

	public ItemRenderSR() {
		this.model = new superReactor();
	}

	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item,
			IItemRenderer.ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
		case INVENTORY: {
			GL11.glPushMatrix();
			GL11.glTranslatef(1F, 1.8F, 1F);
			GL11.glRotatef(180f, 0f, 0f, 1f);
			GL11.glScalef(.1f, .1f, .1f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(.625f);
			GL11.glPopMatrix();
			break;
		}

		case ENTITY: {
			GL11.glPushMatrix();
			GL11.glTranslatef(1F, 1.8F, 1F);
			GL11.glRotatef(180f, 0f, 0f, 1f);
			GL11.glScalef(.1f, .1f, .1f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(.625f);
			GL11.glPopMatrix();
			break;
		}

		case EQUIPPED: {
			GL11.glPushMatrix();
			GL11.glTranslatef(.5F, 1.4F, .5F);
			GL11.glScalef(.1f, .1f, .1f);
			GL11.glRotatef(180f, 0f, 0f, 1f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(.625f);
			GL11.glPopMatrix();
			break;
		}

		case EQUIPPED_FIRST_PERSON: {
			GL11.glPushMatrix();
			GL11.glTranslatef(.5F, 1.4F, .5F);
			GL11.glScalef(.1f, .1f, .1f);
			GL11.glRotatef(180f, 0f, 0f, 1f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(.625f);
			GL11.glPopMatrix();
			break;
		}

		default: {
			GL11.glPushMatrix();
			GL11.glTranslatef(1F, 1.8F, 1F);
			GL11.glRotatef(180f, 0f, 0f, 1f);
			GL11.glScalef(.1f, .1f, .1f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);

			model.renderModel(.0625f);
			GL11.glPopMatrix();
			break;
		}
		}
	}
}