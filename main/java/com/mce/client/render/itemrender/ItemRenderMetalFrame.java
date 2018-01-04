package com.mce.client.render.itemrender;

import org.lwjgl.opengl.GL11;

import com.mce.models.blocks.MetalFrameModel;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderMetalFrame implements IItemRenderer {
	public static final ResourceLocation steel = new ResourceLocation("mod_idt",
			"/textures/models/tech/frames/steelFrame.png".substring(1));

	public static final ResourceLocation titanium = new ResourceLocation("mod_idt",
			"/textures/models/tech/frames/titaniumFrame.png".substring(1));

	public static final ResourceLocation tantalum = new ResourceLocation("mod_idt",
			"/textures/models/tech/frames/tantalumFrame.png".substring(1));

	public static final ResourceLocation vanadium = new ResourceLocation("mod_idt",
			"/textures/models/tech/frames/vanadiumFrame.png".substring(1));

	public static final ResourceLocation vc = new ResourceLocation("mod_idt",
			"/textures/models/tech/frames/vcFrame.png".substring(1));
	private MetalFrameModel model;

	public ItemRenderMetalFrame() {
		this.model = new MetalFrameModel();
	}

	public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item,
			IItemRenderer.ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack stack, Object... data) {
		int meta = stack.getItemDamage();

		switch (type) {
		case INVENTORY: {
			switch (meta) {
			case 0:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(steel);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 1:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(titanium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 2:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(tantalum);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 3:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vanadium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 4:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vc);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}
		}

		case ENTITY: {
			switch (meta) {
			case 0:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(steel);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 1:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(titanium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 2:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(tantalum);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 3:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vanadium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 4:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vc);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}
		}

		case EQUIPPED: {
			switch (meta) {
			case 0:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(steel);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 1:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(titanium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 2:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(tantalum);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 3:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vanadium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 4:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vc);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}
		}

		case EQUIPPED_FIRST_PERSON: {
			switch (meta) {
			case 0:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(steel);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 1:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(titanium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 2:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(tantalum);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 3:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vanadium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 4:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vc);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}
		}

		default: {
			switch (meta) {
			case 0:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(steel);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 1:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(titanium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 2:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(tantalum);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 3:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vanadium);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			case 4:
				GL11.glPushMatrix();
				GL11.glTranslatef(.3f, 1.25f, .3f);
				GL11.glRotatef(180f, 0f, 0f, 1f);
				GL11.glScalef(.1f, .1f, .1f);

				Minecraft.getMinecraft().renderEngine.bindTexture(vc);
				model.renderModel(.625f);
				GL11.glPopMatrix();
				break;
			}
		}
		}
	}
}
