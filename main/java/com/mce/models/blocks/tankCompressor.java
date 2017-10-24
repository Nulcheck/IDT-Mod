package com.mce.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class tankCompressor extends ModelBase {
	// fields
	ModelRenderer base;
	ModelRenderer colomn1;
	ModelRenderer colomn2;
	ModelRenderer colomn3;
	ModelRenderer colomn4;
	ModelRenderer top;
	ModelRenderer tankbase;
	ModelRenderer tanktopbase;
	ModelRenderer tanktopnozzel;

	public tankCompressor() {
		textureWidth = 64;
		textureHeight = 64;

		base = new ModelRenderer(this, 0, 0);
		base.addBox(0F, 0F, 0F, 16, 2, 16);
		base.setRotationPoint(-8F, 22F, -8F);
		base.setTextureSize(64, 64);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		colomn1 = new ModelRenderer(this, 0, 19);
		colomn1.addBox(0F, 0F, 0F, 1, 12, 1);
		colomn1.setRotationPoint(7F, 10F, -8F);
		colomn1.setTextureSize(64, 64);
		colomn1.mirror = true;
		setRotation(colomn1, 0F, 0F, 0F);
		colomn2 = new ModelRenderer(this, 0, 19);
		colomn2.addBox(0F, 0F, 0F, 1, 12, 1);
		colomn2.setRotationPoint(7F, 10F, 7F);
		colomn2.setTextureSize(64, 64);
		colomn2.mirror = true;
		setRotation(colomn2, 0F, 0F, 0F);
		colomn3 = new ModelRenderer(this, 0, 19);
		colomn3.addBox(0F, 0F, 0F, 1, 12, 1);
		colomn3.setRotationPoint(-8F, 10F, 7F);
		colomn3.setTextureSize(64, 64);
		colomn3.mirror = true;
		setRotation(colomn3, 0F, 0F, 0F);
		colomn4 = new ModelRenderer(this, 0, 19);
		colomn4.addBox(0F, 0F, 0F, 1, 12, 1);
		colomn4.setRotationPoint(-8F, 10F, -8F);
		colomn4.setTextureSize(64, 64);
		colomn4.mirror = true;
		setRotation(colomn4, 0F, 0F, 0F);
		top = new ModelRenderer(this, 0, 0);
		top.addBox(0F, 0F, 0F, 16, 2, 16);
		top.setRotationPoint(-8F, 8F, -8F);
		top.setTextureSize(64, 64);
		top.mirror = true;
		setRotation(top, 0F, 0F, 0F);
		tankbase = new ModelRenderer(this, 5, 19);
		tankbase.addBox(0F, 0F, 0F, 10, 1, 10);
		tankbase.setRotationPoint(-5F, 21F, -5F);
		tankbase.setTextureSize(64, 64);
		tankbase.mirror = true;
		setRotation(tankbase, 0F, 0F, 0F);
		tanktopbase = new ModelRenderer(this, 46, 19);
		tanktopbase.addBox(0F, 0F, 0F, 4, 3, 4);
		tanktopbase.setRotationPoint(-2F, 10F, -2F);
		tanktopbase.setTextureSize(64, 64);
		tanktopbase.mirror = true;
		setRotation(tanktopbase, 0F, 0F, 0F);
		tanktopnozzel = new ModelRenderer(this, 46, 27);
		tanktopnozzel.addBox(0F, 0F, 0F, 2, 2, 2);
		tanktopnozzel.setRotationPoint(-1F, 13F, -1F);
		tanktopnozzel.setTextureSize(64, 64);
		tanktopnozzel.mirror = true;
		setRotation(tanktopnozzel, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		base.render(f5);
		colomn1.render(f5);
		colomn2.render(f5);
		colomn3.render(f5);
		colomn4.render(f5);
		top.render(f5);
		tankbase.render(f5);
		tanktopbase.render(f5);
		tanktopnozzel.render(f5);
	}

	public void renderModel(float f5) {
		base.render(f5);
		colomn1.render(f5);
		colomn2.render(f5);
		colomn3.render(f5);
		colomn4.render(f5);
		top.render(f5);
		tankbase.render(f5);
		tanktopbase.render(f5);
		tanktopnozzel.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
