package com.mce.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ZNGModel extends ModelBase {
	// fields
	ModelRenderer Base;
	ModelRenderer Middle;
	ModelRenderer Top;

	public ZNGModel() {
		textureWidth = 64;
		textureHeight = 64;

		Base = new ModelRenderer(this, 0, 0);
		Base.addBox(0F, 0F, 0F, 16, 7, 16);
		Base.setRotationPoint(-8F, 17F, -8F);
		Base.setTextureSize(64, 64);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
		Middle = new ModelRenderer(this, 0, 24);
		Middle.addBox(0F, 0F, 0F, 14, 4, 14);
		Middle.setRotationPoint(-7F, 13F, -7F);
		Middle.setTextureSize(64, 64);
		Middle.mirror = true;
		setRotation(Middle, 0F, 0F, 0F);
		Top = new ModelRenderer(this, 0, 43);
		Top.addBox(0F, 0F, 0F, 16, 5, 16);
		Top.setRotationPoint(-8F, 8F, -8F);
		Top.setTextureSize(64, 64);
		Top.mirror = true;
		setRotation(Top, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Base.render(f5);
		Middle.render(f5);
		Top.render(f5);
	}

	public void renderModel(float f5) {
		Base.render(f5);
		Middle.render(f5);
		Top.render(f5);
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
