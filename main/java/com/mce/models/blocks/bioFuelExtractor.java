package com.mce.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class bioFuelExtractor extends ModelBase {
	// fields
	ModelRenderer Base1;
	ModelRenderer Base2;
	ModelRenderer Base3;
	ModelRenderer Base4;
	ModelRenderer Collumn1;
	ModelRenderer Collumn2;
	ModelRenderer Collumn3;
	ModelRenderer Collumn4;
	ModelRenderer Top1;
	ModelRenderer Top2;
	ModelRenderer Top3;
	ModelRenderer Top4;
	ModelRenderer Box1;
	ModelRenderer Box2;
	ModelRenderer Box3;
	ModelRenderer Wire;
	ModelRenderer Pipe1;
	ModelRenderer Pipe2;
	ModelRenderer Pipe3;
	ModelRenderer Pipe4;

	public bioFuelExtractor() {
		textureWidth = 64;
		textureHeight = 64;

		Base1 = new ModelRenderer(this, 0, 0);
		Base1.addBox(0F, 0F, 0F, 16, 1, 1);
		Base1.setRotationPoint(-8F, 23F, -8F);
		Base1.setTextureSize(64, 64);
		Base1.mirror = true;
		setRotation(Base1, 0F, 0F, 0F);
		Base2 = new ModelRenderer(this, 0, 0);
		Base2.addBox(0F, 0F, 0F, 16, 1, 1);
		Base2.setRotationPoint(-8F, 23F, 7F);
		Base2.setTextureSize(64, 64);
		Base2.mirror = true;
		setRotation(Base2, 0F, 0F, 0F);
		Base3 = new ModelRenderer(this, 31, 0);
		Base3.addBox(0F, 0F, 0F, 1, 1, 16);
		Base3.setRotationPoint(7F, 23F, -8F);
		Base3.setTextureSize(64, 64);
		Base3.mirror = true;
		setRotation(Base3, 0F, 0F, 0F);
		Base4 = new ModelRenderer(this, 30, 0);
		Base4.addBox(0F, 0F, 0F, 1, 1, 16);
		Base4.setRotationPoint(-8F, 23F, -8F);
		Base4.setTextureSize(64, 64);
		Base4.mirror = true;
		setRotation(Base4, 0F, 0F, 0F);
		Collumn1 = new ModelRenderer(this, 0, 3);
		Collumn1.addBox(0F, 0F, 0F, 1, 16, 1);
		Collumn1.setRotationPoint(7F, 8F, -8F);
		Collumn1.setTextureSize(64, 64);
		Collumn1.mirror = true;
		setRotation(Collumn1, 0F, 0F, 0F);
		Collumn2 = new ModelRenderer(this, 0, 3);
		Collumn2.addBox(0F, 0F, 0F, 1, 16, 1);
		Collumn2.setRotationPoint(7F, 8F, 7F);
		Collumn2.setTextureSize(64, 64);
		Collumn2.mirror = true;
		setRotation(Collumn2, 0F, 0F, 0F);
		Collumn3 = new ModelRenderer(this, 0, 3);
		Collumn3.addBox(0F, 0F, 0F, 1, 16, 1);
		Collumn3.setRotationPoint(-8F, 8F, 7F);
		Collumn3.setTextureSize(64, 64);
		Collumn3.mirror = true;
		setRotation(Collumn3, 0F, 0F, 0F);
		Collumn4 = new ModelRenderer(this, 0, 3);
		Collumn4.addBox(0F, 0F, 0F, 1, 16, 1);
		Collumn4.setRotationPoint(-8F, 8F, -8F);
		Collumn4.setTextureSize(64, 64);
		Collumn4.mirror = true;
		setRotation(Collumn4, 0F, 0F, 0F);
		Top1 = new ModelRenderer(this, 0, 0);
		Top1.addBox(0F, 0F, 0F, 16, 1, 1);
		Top1.setRotationPoint(-8F, 8F, -8F);
		Top1.setTextureSize(64, 64);
		Top1.mirror = true;
		setRotation(Top1, 0F, 0F, 0F);
		Top2 = new ModelRenderer(this, 0, 0);
		Top2.addBox(0F, 0F, 0F, 16, 1, 1);
		Top2.setRotationPoint(-8F, 8F, 7F);
		Top2.setTextureSize(64, 64);
		Top2.mirror = true;
		setRotation(Top2, 0F, 0F, 0F);
		Top3 = new ModelRenderer(this, 30, 0);
		Top3.addBox(0F, 0F, 0F, 1, 1, 16);
		Top3.setRotationPoint(7F, 8F, -8F);
		Top3.setTextureSize(64, 64);
		Top3.mirror = true;
		setRotation(Top3, 0F, 0F, 0F);
		Top4 = new ModelRenderer(this, 30, 0);
		Top4.addBox(0F, 0F, 0F, 1, 1, 16);
		Top4.setRotationPoint(-8F, 8F, -8F);
		Top4.setTextureSize(64, 64);
		Top4.mirror = true;
		setRotation(Top4, 0F, 0F, 0F);
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

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
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

	public void renderModel(float f5) {
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

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
