package com.mce.blocks.modeled;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelMagnetizer extends ModelBase {
	// fields
	ModelRenderer Base;
	ModelRenderer Side1;
	ModelRenderer Side2;
	ModelRenderer Top;

	public modelMagnetizer() {
		textureWidth = 128;
		textureHeight = 128;

		Base = new ModelRenderer(this, 0, 0);
		Base.addBox(0F, 0F, 0F, 16, 8, 16);
		Base.setRotationPoint(-8F, 16F, -8F);
		Base.setTextureSize(128, 128);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
		Side1 = new ModelRenderer(this, 0, 37);
		Side1.addBox(0F, 0F, 0F, 16, 3, 6);
		Side1.setRotationPoint(-8F, 13F, -8F);
		Side1.setTextureSize(128, 128);
		Side1.mirror = true;
		setRotation(Side1, 0F, 0F, 0F);
		Side2 = new ModelRenderer(this, 0, 26);
		Side2.addBox(0F, 0F, 0F, 16, 3, 6);
		Side2.setRotationPoint(-8F, 13F, 2F);
		Side2.setTextureSize(128, 128);
		Side2.mirror = true;
		setRotation(Side2, 0F, 0F, 0F);
		Top = new ModelRenderer(this, 46, 26);
		Top.addBox(0F, 0F, 0F, 16, 5, 16);
		Top.setRotationPoint(-8F, 8F, -8F);
		Top.setTextureSize(128, 128);
		Top.mirror = true;
		setRotation(Top, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Base.render(f5);
		Side1.render(f5);
		Side2.render(f5);
		Top.render(f5);
	}

	public void renderModel(float f5) {
		Base.render(f5);
		Side1.render(f5);
		Side2.render(f5);
		Top.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}

}
