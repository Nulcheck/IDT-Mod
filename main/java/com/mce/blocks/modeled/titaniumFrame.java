package com.mce.blocks.modeled;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class titaniumFrame extends ModelBase {
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

	public titaniumFrame() {
		textureWidth = 64;
		textureHeight = 32;

		Base1 = new ModelRenderer(this, 0, 0);
		Base1.addBox(0F, 0F, 0F, 16, 1, 1);
		Base1.setRotationPoint(-8F, 23F, -8F);
		Base1.setTextureSize(64, 32);
		Base1.mirror = true;
		setRotation(Base1, 0F, 0F, 0F);
		Base2 = new ModelRenderer(this, 0, 2);
		Base2.addBox(0F, 0F, 0F, 16, 1, 1);
		Base2.setRotationPoint(-8F, 23F, 7F);
		Base2.setTextureSize(64, 32);
		Base2.mirror = true;
		setRotation(Base2, 0F, 0F, 0F);
		Base3 = new ModelRenderer(this, 24, 0);
		Base3.addBox(0F, 0F, 0F, 1, 1, 16);
		Base3.setRotationPoint(7F, 23F, -8F);
		Base3.setTextureSize(64, 32);
		Base3.mirror = true;
		setRotation(Base3, 0F, 0F, 0F);
		Base4 = new ModelRenderer(this, 26, 0);
		Base4.addBox(0F, 0F, 0F, 1, 1, 16);
		Base4.setRotationPoint(-8F, 23F, -8F);
		Base4.setTextureSize(64, 32);
		Base4.mirror = true;
		setRotation(Base4, 0F, 0F, 0F);
		Collumn1 = new ModelRenderer(this, 0, 3);
		Collumn1.addBox(0F, 0F, 0F, 1, 16, 1);
		Collumn1.setRotationPoint(7F, 8F, -8F);
		Collumn1.setTextureSize(64, 32);
		Collumn1.mirror = true;
		setRotation(Collumn1, 0F, 0F, 0F);
		Collumn2 = new ModelRenderer(this, 2, 3);
		Collumn2.addBox(0F, 0F, 0F, 1, 16, 1);
		Collumn2.setRotationPoint(7F, 8F, 7F);
		Collumn2.setTextureSize(64, 32);
		Collumn2.mirror = true;
		setRotation(Collumn2, 0F, 0F, 0F);
		Collumn3 = new ModelRenderer(this, 6, 3);
		Collumn3.addBox(0F, 0F, 0F, 1, 16, 1);
		Collumn3.setRotationPoint(-8F, 8F, 7F);
		Collumn3.setTextureSize(64, 32);
		Collumn3.mirror = true;
		setRotation(Collumn3, 0F, 0F, 0F);
		Collumn4 = new ModelRenderer(this, 3, 3);
		Collumn4.addBox(0F, 0F, 0F, 1, 16, 1);
		Collumn4.setRotationPoint(-8F, 8F, -8F);
		Collumn4.setTextureSize(64, 32);
		Collumn4.mirror = true;
		setRotation(Collumn4, 0F, 0F, 0F);
		Top1 = new ModelRenderer(this, 0, 3);
		Top1.addBox(0F, 0F, 0F, 16, 1, 1);
		Top1.setRotationPoint(-8F, 8F, -8F);
		Top1.setTextureSize(64, 32);
		Top1.mirror = true;
		setRotation(Top1, 0F, 0F, 0F);
		Top2 = new ModelRenderer(this, 0, 1);
		Top2.addBox(0F, 0F, 0F, 16, 1, 1);
		Top2.setRotationPoint(-8F, 8F, 7F);
		Top2.setTextureSize(64, 32);
		Top2.mirror = true;
		setRotation(Top2, 0F, 0F, 0F);
		Top3 = new ModelRenderer(this, 28, 0);
		Top3.addBox(0F, 0F, 0F, 1, 1, 16);
		Top3.setRotationPoint(7F, 8F, -8F);
		Top3.setTextureSize(64, 32);
		Top3.mirror = true;
		setRotation(Top3, 0F, 0F, 0F);
		Top4 = new ModelRenderer(this, 30, 0);
		Top4.addBox(0F, 0F, 0F, 1, 1, 16);
		Top4.setRotationPoint(-8F, 8F, -8F);
		Top4.setTextureSize(64, 32);
		Top4.mirror = true;
		setRotation(Top4, 0F, 0F, 0F);
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
