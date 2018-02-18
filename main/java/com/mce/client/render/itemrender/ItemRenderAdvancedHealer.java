package com.mce.client.render.itemrender;

import com.mce.models.blocks.ModelBomb;
import org.lwjgl.opengl.GL11;

import com.mce.common.mod_IDT;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ItemRenderAdvancedHealer implements IItemRenderer {
	//private IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation(mod_IDT.modid2, "obj/test.obj"));
	private ModelBomb model;
	public static final ResourceLocation texture = new ResourceLocation("mod_idt",
			"/textures/models/tex.png".substring(1));

	public ItemRenderAdvancedHealer() {
	}

	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item,
			IItemRenderer.ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack stack, Object... data) {
		switch (type) {
		case INVENTORY: {
			GL11.glPushMatrix();
			GL11.glScalef(.5f, .5f, .5f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(0.0625f);
			GL11.glPopMatrix();
			break;
		}

		case ENTITY: {
			GL11.glPushMatrix();
			GL11.glScalef(.5f, .5f, .5f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(0.0625f);
			GL11.glPopMatrix();
			break;
		}

		case EQUIPPED: {
			GL11.glPushMatrix();
			GL11.glTranslatef(.5F, .4F, .5F);
			GL11.glScalef(.5f, .5f, .5f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(0.0625f);
			GL11.glPopMatrix();
			break;
		}

		case EQUIPPED_FIRST_PERSON: {
			GL11.glPushMatrix();
			GL11.glTranslatef(.5F, .4F, .5F);
			GL11.glScalef(.5f, .5f, .5f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			model.renderModel(0.0625f);
			GL11.glPopMatrix();
			break;
		}

		default: {
			GL11.glPushMatrix();
			GL11.glTranslatef(1F, .8F, 1F);
			GL11.glScalef(.5f, .5f, .5f);

			Minecraft.getMinecraft().renderEngine.bindTexture(texture);

			model.renderModel(0.0625f);
			GL11.glPopMatrix();
			break;
		}
		}
	}
}
