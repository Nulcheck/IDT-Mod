package com.mce.models.blocks;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class BFEModel extends MetalFrameModel {
	// fields
	ModelRenderer Box1;
	ModelRenderer Box2;
	ModelRenderer Box3;
	ModelRenderer Wire;
	ModelRenderer Pipe1;
	ModelRenderer Pipe2;
	ModelRenderer Pipe3;
	ModelRenderer Pipe4;

	public BFEModel() {
		textureWidth = 64;
		textureHeight = 64;

		Box1 = new ModelRenderer(this, 0, 21);
		Box1.addBox(0F, 0F, 0F, 7, 6, 6);
		Box1.setRotationPoint(-7F, 8F, -7F);
		Box1.setTextureSize(64, 64);
		Box1.mirror = true;
		setRotation(Box1, 0F, 0F, 0F);
		Box2 = new ModelRenderer(this, 27, 21);
		Box2.addBox(0F, 0F, 0F, 3, 4, 3);
		Box2.setRotationPoint(4F, 8F, -2F);
		Box2.setTextureSize(64, 64);
		Box2.mirror = true;
		setRotation(Box2, 0F, 0F, 0F);
		Box3 = new ModelRenderer(this, 0, 35);
		Box3.addBox(0F, 0F, 0F, 9, 5, 10);
		Box3.setRotationPoint(-2F, 19F, -7F);
		Box3.setTextureSize(64, 64);
		Box3.mirror = true;
		setRotation(Box3, 0F, 0F, 0F);
		Wire = new ModelRenderer(this, 5, 6);
		Wire.addBox(0F, 0F, 0F, 7, 1, 1);
		Wire.setRotationPoint(-1F, 10F, -3F);
		Wire.setTextureSize(64, 64);
		Wire.mirror = true;
		setRotation(Wire, 0F, -0.3839724F, 0F);
		Pipe1 = new ModelRenderer(this, 42, 22);
		Pipe1.addBox(0F, 0F, 0F, 1, 3, 1);
		Pipe1.setRotationPoint(-2F, 14F, -3F);
		Pipe1.setTextureSize(64, 64);
		Pipe1.mirror = true;
		setRotation(Pipe1, 0F, 0F, 0F);
		Pipe2 = new ModelRenderer(this, 41, 29);
		Pipe2.addBox(0F, 0F, 0F, 5, 1, 1);
		Pipe2.setRotationPoint(-6F, 17F, -3F);
		Pipe2.setTextureSize(64, 64);
		Pipe2.mirror = true;
		setRotation(Pipe2, 0F, 0F, 0F);
		Pipe3 = new ModelRenderer(this, 56, 29);
		Pipe3.addBox(0F, 0F, 0F, 1, 3, 1);
		Pipe3.setRotationPoint(-6F, 18F, -3F);
		Pipe3.setTextureSize(64, 64);
		Pipe3.mirror = true;
		setRotation(Pipe3, 0F, 0F, 0F);
		Pipe4 = new ModelRenderer(this, 43, 34);
		Pipe4.addBox(0F, 0F, 0F, 4, 1, 1);
		Pipe4.setRotationPoint(-6F, 20F, -3F);
		Pipe4.setTextureSize(64, 64);
		Pipe4.mirror = true;
		setRotation(Pipe4, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Base1.render(f5);
		Base2.render(f5);
		Base3.render(f5);
		Base4.render(f5);
		Collumn1.render(f5);
		Collumn2.render(f5);
		Collumn3.render(f5);
		Collumn4.render(f5);
		Top1.render(f5);
		Top2.render(f5);
		Top3.render(f5);
		Top4.render(f5);
		Box1.render(f5);
		Box2.render(f5);
		Box3.render(f5);
		Wire.render(f5);
		Pipe1.render(f5);
		Pipe2.render(f5);
		Pipe3.render(f5);
		Pipe4.render(f5);
	}

	public void renderModel(float f) {
		Base1.render(f);
		Base2.render(f);
		Base3.render(f);
		Base4.render(f);
		Collumn1.render(f);
		Collumn2.render(f);
		Collumn3.render(f);
		Collumn4.render(f);
		Top1.render(f);
		Top2.render(f);
		Top3.render(f);
		Top4.render(f);
		Box1.render(f);
		Box2.render(f);
		Box3.render(f);
		Wire.render(f);
		Pipe1.render(f);
		Pipe2.render(f);
		Pipe3.render(f);
		Pipe4.render(f);
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
