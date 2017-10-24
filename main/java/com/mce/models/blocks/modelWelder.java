package com.mce.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelWelder extends ModelBase {
	// fields
	ModelRenderer Base;
	ModelRenderer WeldSide1;
	ModelRenderer WeldSide2;

	public modelWelder() {
		textureWidth = 64;
		textureHeight = 128;

		Base = new ModelRenderer(this, 0, 0);
		Base.addBox(0F, 0F, 0F, 16, 13, 16);
		Base.setRotationPoint(-8F, 11F, -8F);
		Base.setTextureSize(64, 128);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
		WeldSide1 = new ModelRenderer(this, 0, 31);
		WeldSide1.addBox(0F, 0F, 0F, 7, 3, 16);
		WeldSide1.setRotationPoint(-8F, 8F, -8F);
		WeldSide1.setTextureSize(64, 128);
		WeldSide1.mirror = true;
		setRotation(WeldSide1, 0F, 0F, 0F);
		WeldSide2 = new ModelRenderer(this, 0, 51);
		WeldSide2.addBox(0F, 0F, 0F, 7, 3, 16);
		WeldSide2.setRotationPoint(1F, 8F, -8F);
		WeldSide2.setTextureSize(64, 128);
		WeldSide2.mirror = true;
		setRotation(WeldSide2, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Base.render(f5);
		WeldSide1.render(f5);
		WeldSide2.render(f5);
	}

	public void renderModel(float f5) {
		Base.render(f5);
		WeldSide1.render(f5);
		WeldSide2.render(f5);
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
