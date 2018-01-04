package com.mce.client.render.itemrender.tech;

import org.lwjgl.opengl.GL11;

import com.mce.models.blocks.BFEModel;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderBFE implements IItemRenderer {
	public static final ResourceLocation steel = new ResourceLocation("mod_idt",
			"/textures/models/tech/bfe/bioFuelExtractor_steel.png".substring(1));

	public static final ResourceLocation titanium = new ResourceLocation("mod_idt",
			"/textures/models/tech/bfe/bioFuelExtractor_titanium.png".substring(1));

	public static final ResourceLocation tantalum = new ResourceLocation("mod_idt",
			"/textures/models/tech/bfe/bioFuelExtractor_tantalum.png".substring(1));

	public static final ResourceLocation vanadium = new ResourceLocation("mod_idt",
			"/textures/models/tech/bfe/bioFuelExtractor_vanadium.png".substring(1));

	public static final ResourceLocation vc = new ResourceLocation("mod_idt",
			"/textures/models/tech/bfe/bioFuelExtractor_vc.png".substring(1));
	private BFEModel model;

	public ItemRenderBFE() {
		this.model = new BFEModel();
	}

	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item,
			IItemRenderer.ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack stack, Object... data) {
		// TODO: Steel
		if (stack.getItemDamage() == 0) {
			switch (type) {
			case INVENTORY: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(steel);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case ENTITY: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(steel);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case EQUIPPED: {
				GL11.glPushMatrix();
				GL11.glTranslatef(.5F, 1.4F, .5F);
				GL11.glScalef(.1f, .1f, .1f);
				GL11.glRotatef(180f, 0f, 0f, 1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(steel);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case EQUIPPED_FIRST_PERSON: {
				GL11.glPushMatrix();
				GL11.glTranslatef(.5F, 1.4F, .5F);
				GL11.glScalef(.1f, .1f, .1f);
				GL11.glRotatef(180f, 0f, 0f, 1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(steel);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			default: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(steel);
				model.renderModel(.0625f);
				GL11.glPopMatrix();
				break;
			}
			}
		}

		// TODO: Titanium
		if (stack.getItemDamage() == 1) {
			switch (type) {
			case INVENTORY: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(titanium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case ENTITY: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(titanium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case EQUIPPED: {
				GL11.glPushMatrix();
				GL11.glTranslatef(.5F, 1.4F, .5F);
				GL11.glScalef(.1f, .1f, .1f);
				GL11.glRotatef(180f, 0f, 0f, 1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(titanium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case EQUIPPED_FIRST_PERSON: {
				GL11.glPushMatrix();
				GL11.glTranslatef(.5F, 1.4F, .5F);
				GL11.glScalef(.1f, .1f, .1f);
				GL11.glRotatef(180f, 0f, 0f, 1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(titanium);

				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			default: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(titanium);
				model.renderModel(.0625f);
				GL11.glPopMatrix();
				break;
			}
			}
		}

		// TODO: Tantalum
		if (stack.getItemDamage() == 2) {
			switch (type) {
			case INVENTORY: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(tantalum);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case ENTITY: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(tantalum);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case EQUIPPED: {
				GL11.glPushMatrix();
				GL11.glTranslatef(.5F, 1.4F, .5F);
				GL11.glScalef(.1f, .1f, .1f);
				GL11.glRotatef(180f, 0f, 0f, 1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(tantalum);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case EQUIPPED_FIRST_PERSON: {
				GL11.glPushMatrix();
				GL11.glTranslatef(.5F, 1.4F, .5F);
				GL11.glScalef(.1f, .1f, .1f);
				GL11.glRotatef(180f, 0f, 0f, 1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(tantalum);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			default: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(tantalum);
				model.renderModel(.0625f);
				GL11.glPopMatrix();
				break;
			}
			}
		}

		// TODO: Vanadium
		if (stack.getItemDamage() == 3) {
			switch (type) {
			case INVENTORY: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vanadium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case ENTITY: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vanadium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case EQUIPPED: {
				GL11.glPushMatrix();
				GL11.glTranslatef(.5F, 1.4F, .5F);
				GL11.glScalef(.1f, .1f, .1f);
				GL11.glRotatef(180f, 0f, 0f, 1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vanadium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case EQUIPPED_FIRST_PERSON: {
				GL11.glPushMatrix();
				GL11.glTranslatef(.5F, 1.4F, .5F);
				GL11.glScalef(.1f, .1f, .1f);
				GL11.glRotatef(180f, 0f, 0f, 1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vanadium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			default: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vanadium);
				model.renderModel(.0625f);
				GL11.glPopMatrix();
				break;
			}
			}
		}

		// TODO: VC
		if (stack.getItemDamage() == 4) {
			switch (type) {
			case INVENTORY: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vc);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case ENTITY: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vc);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case EQUIPPED: {
				GL11.glPushMatrix();
				GL11.glTranslatef(.5F, 1.4F, .5F);
				GL11.glScalef(.1f, .1f, .1f);
				GL11.glRotatef(180f, 0f, 0f, 1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vc);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			case EQUIPPED_FIRST_PERSON: {
				GL11.glPushMatrix();
				GL11.glTranslatef(.5F, 1.4F, .5F);
				GL11.glScalef(.1f, .1f, .1f);
				GL11.glRotatef(180f, 0f, 0f, 1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vc);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}

			default: {
				GL11.glPushMatrix();
				GL11.glTranslatef(1F, 1.8F, 1F);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vc);
				model.renderModel(.0625f);
				GL11.glPopMatrix();
				break;
			}
			}
		}
	}
}
