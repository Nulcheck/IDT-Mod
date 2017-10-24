package com.mce.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBomb extends ModelBase {
	ModelRenderer Bottom;
	ModelRenderer Side_1;
	ModelRenderer Side_2;
	ModelRenderer Side_3;
	ModelRenderer Side_4;
	ModelRenderer Top;
	ModelRenderer Corner_1;
	ModelRenderer Corner_2;
	ModelRenderer Corner_3;
	ModelRenderer Corner_4;
	ModelRenderer Vile_Side_1;
	ModelRenderer Vile_Side_2;
	ModelRenderer Vile_Side_3;
	ModelRenderer Vile_Side_4;
	ModelRenderer Vile_Top;
	ModelRenderer Vile_Bottom;
	ModelRenderer Arm_1;
	ModelRenderer Arm_2;
	ModelRenderer Arm_3;
	ModelRenderer Arm_4;
	ModelRenderer Liquid;

	public ModelBomb() {
		this.textureHeight = 256;
		this.textureWidth = 256;

		this.Bottom = new ModelRenderer(this, 0, 0);
		this.Bottom.addBox(0.0F, 0.0F, 0.0F, 16, 1, 16);
		this.Bottom.setRotationPoint(-8.0F, 23.0F, -8.0F);
		this.Bottom.setTextureSize(256, 256);
		this.Bottom.mirror = true;
		setRotation(this.Bottom, 0.0F, 0.0F, 0.0F);
		this.Side_1 = new ModelRenderer(this, 0, 19);
		this.Side_1.addBox(0.0F, 0.0F, 0.0F, 1, 14, 14);
		this.Side_1.setRotationPoint(7.0F, 9.0F, -7.0F);
		this.Side_1.setTextureSize(256, 256);
		this.Side_1.mirror = true;
		setRotation(this.Side_1, 0.0F, 0.0F, 0.0F);
		this.Side_2 = new ModelRenderer(this, 34, 33);
		this.Side_2.addBox(0.0F, 0.0F, 0.0F, 14, 14, 1);
		this.Side_2.setRotationPoint(-7.0F, 9.0F, 7.0F);
		this.Side_2.setTextureSize(256, 256);
		this.Side_2.mirror = true;
		setRotation(this.Side_2, 0.0F, 0.0F, 0.0F);
		this.Side_3 = new ModelRenderer(this, 0, 51);
		this.Side_3.addBox(0.0F, 0.0F, 0.0F, 1, 14, 14);
		this.Side_3.setRotationPoint(-8.0F, 9.0F, -7.0F);
		this.Side_3.setTextureSize(256, 256);
		this.Side_3.mirror = true;
		setRotation(this.Side_3, 0.0F, 0.0F, 0.0F);
		this.Side_4 = new ModelRenderer(this, 34, 52);
		this.Side_4.addBox(0.0F, 0.0F, 0.0F, 14, 14, 1);
		this.Side_4.setRotationPoint(-7.0F, 9.0F, -8.0F);
		this.Side_4.setTextureSize(256, 256);
		this.Side_4.mirror = true;
		setRotation(this.Side_4, 0.0F, 0.0F, 0.0F);
		this.Top = new ModelRenderer(this, 68, 0);
		this.Top.addBox(0.0F, 0.0F, 0.0F, 16, 1, 16);
		this.Top.setRotationPoint(-8.0F, 8.0F, -8.0F);
		this.Top.setTextureSize(256, 256);
		this.Top.mirror = true;
		setRotation(this.Top, 0.0F, 0.0F, 0.0F);
		this.Corner_1 = new ModelRenderer(this, 0, 83);
		this.Corner_1.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
		this.Corner_1.setRotationPoint(-8.0F, 9.0F, 7.0F);
		this.Corner_1.setTextureSize(256, 256);
		this.Corner_1.mirror = true;
		setRotation(this.Corner_1, 0.0F, 0.0F, 0.0F);
		this.Corner_2 = new ModelRenderer(this, 6, 83);
		this.Corner_2.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
		this.Corner_2.setRotationPoint(-8.0F, 9.0F, -8.0F);
		this.Corner_2.setTextureSize(256, 256);
		this.Corner_2.mirror = true;
		setRotation(this.Corner_2, 0.0F, 0.0F, 0.0F);
		this.Corner_3 = new ModelRenderer(this, 13, 83);
		this.Corner_3.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
		this.Corner_3.setRotationPoint(7.0F, 9.0F, -8.0F);
		this.Corner_3.setTextureSize(256, 256);
		this.Corner_3.mirror = true;
		setRotation(this.Corner_3, 0.0F, 0.0F, 0.0F);
		this.Corner_4 = new ModelRenderer(this, 20, 83);
		this.Corner_4.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1);
		this.Corner_4.setRotationPoint(7.0F, 9.0F, 7.0F);
		this.Corner_4.setTextureSize(256, 256);
		this.Corner_4.mirror = true;
		setRotation(this.Corner_4, 0.0F, 0.0F, 0.0F);
		this.Vile_Side_1 = new ModelRenderer(this, 0, 120);
		this.Vile_Side_1.addBox(0.0F, 0.0F, 0.0F, 3, 5, 1);
		this.Vile_Side_1.setRotationPoint(-2.0F, 14.0F, 2.0F);
		this.Vile_Side_1.setTextureSize(256, 256);
		this.Vile_Side_1.mirror = true;
		setRotation(this.Vile_Side_1, 0.0F, 0.0F, 0.0F);
		this.Vile_Side_2 = new ModelRenderer(this, 11, 120);
		this.Vile_Side_2.addBox(0.0F, 0.0F, 0.0F, 1, 5, 3);
		this.Vile_Side_2.setRotationPoint(1.0F, 14.0F, -1.0F);
		this.Vile_Side_2.setTextureSize(256, 256);
		this.Vile_Side_2.mirror = true;
		setRotation(this.Vile_Side_2, 0.0F, 0.0F, 0.0F);
		this.Vile_Side_3 = new ModelRenderer(this, 22, 120);
		this.Vile_Side_3.addBox(0.0F, 0.0F, 0.0F, 3, 5, 1);
		this.Vile_Side_3.setRotationPoint(-2.0F, 14.0F, -2.0F);
		this.Vile_Side_3.setTextureSize(256, 256);
		this.Vile_Side_3.mirror = true;
		setRotation(this.Vile_Side_3, 0.0F, 0.0F, 0.0F);
		this.Vile_Side_4 = new ModelRenderer(this, 33, 120);
		this.Vile_Side_4.addBox(0.0F, 0.0F, 0.0F, 1, 5, 3);
		this.Vile_Side_4.setRotationPoint(-3.0F, 14.0F, -1.0F);
		this.Vile_Side_4.setTextureSize(256, 256);
		this.Vile_Side_4.mirror = true;
		setRotation(this.Vile_Side_4, 0.0F, 0.0F, 0.0F);
		this.Vile_Top = new ModelRenderer(this, 0, 135);
		this.Vile_Top.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3);
		this.Vile_Top.setRotationPoint(-2.0F, 13.0F, -1.0F);
		this.Vile_Top.setTextureSize(256, 256);
		this.Vile_Top.mirror = true;
		setRotation(this.Vile_Top, 0.0F, 0.0F, 0.0F);
		this.Vile_Bottom = new ModelRenderer(this, 16, 135);
		this.Vile_Bottom.addBox(0.0F, 0.0F, 0.0F, 3, 1, 3);
		this.Vile_Bottom.setRotationPoint(-2.0F, 19.0F, -1.0F);
		this.Vile_Bottom.setTextureSize(256, 256);
		this.Vile_Bottom.mirror = true;
		setRotation(this.Vile_Bottom, 0.0F, 0.0F, 0.0F);
		this.Arm_1 = new ModelRenderer(this, 75, 150);
		this.Arm_1.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1);
		this.Arm_1.setRotationPoint(1.0F, 9.0F, -2.0F);
		this.Arm_1.setTextureSize(256, 256);
		this.Arm_1.mirror = true;
		setRotation(this.Arm_1, 0.0F, 0.0F, 0.0F);
		this.Arm_2 = new ModelRenderer(this, 83, 150);
		this.Arm_2.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1);
		this.Arm_2.setRotationPoint(1.0F, 9.0F, 2.0F);
		this.Arm_2.setTextureSize(256, 256);
		this.Arm_2.mirror = true;
		setRotation(this.Arm_2, 0.0F, 0.0F, 0.0F);
		this.Arm_3 = new ModelRenderer(this, 90, 150);
		this.Arm_3.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1);
		this.Arm_3.setRotationPoint(-3.0F, 9.0F, 2.0F);
		this.Arm_3.setTextureSize(256, 256);
		this.Arm_3.mirror = true;
		setRotation(this.Arm_3, 0.0F, 0.0F, 0.0F);
		this.Arm_4 = new ModelRenderer(this, 97, 150);
		this.Arm_4.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
		this.Arm_4.setRotationPoint(-3.0F, 9.0F, -2.0F);
		this.Arm_4.setTextureSize(256, 256);
		this.Arm_4.mirror = true;
		setRotation(this.Arm_4, 0.0F, 0.0F, 0.0F);
		this.Liquid = new ModelRenderer(this, 21, 169);
		this.Liquid.addBox(0.0F, 0.0F, 0.0F, 3, 5, 3);
		this.Liquid.setRotationPoint(-2.0F, 14.0F, -1.0F);
		this.Liquid.setTextureSize(256, 256);
		this.Liquid.mirror = true;
		setRotation(this.Liquid, 0.0F, 0.0F, 0.0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.Bottom.render(f5);
		this.Side_1.render(f5);
		this.Side_2.render(f5);
		this.Side_3.render(f5);
		this.Side_4.render(f5);
		this.Top.render(f5);
		this.Corner_1.render(f5);
		this.Corner_2.render(f5);
		this.Corner_3.render(f5);
		this.Corner_4.render(f5);
		this.Vile_Side_1.render(f5);
		this.Vile_Side_2.render(f5);
		this.Vile_Side_3.render(f5);
		this.Vile_Side_4.render(f5);
		this.Vile_Top.render(f5);
		this.Vile_Bottom.render(f5);
		this.Arm_1.render(f5);
		this.Arm_2.render(f5);
		this.Arm_3.render(f5);
		this.Arm_4.render(f5);
		this.Liquid.render(f5);
	}

	public void renderModel(float f) {
		this.Bottom.render(f);
		this.Side_1.render(f);
		this.Side_2.render(f);
		this.Side_3.render(f);
		this.Side_4.render(f);
		this.Top.render(f);
		this.Corner_1.render(f);
		this.Corner_2.render(f);
		this.Corner_3.render(f);
		this.Corner_4.render(f);
		this.Vile_Side_1.render(f);
		this.Vile_Side_2.render(f);
		this.Vile_Side_3.render(f);
		this.Vile_Side_4.render(f);
		this.Vile_Top.render(f);
		this.Vile_Bottom.render(f);
		this.Arm_1.render(f);
		this.Arm_2.render(f);
		this.Arm_3.render(f);
		this.Arm_4.render(f);
		this.Liquid.render(f);
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
