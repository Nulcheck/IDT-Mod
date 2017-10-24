package com.mce.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class matterCondenser extends ModelBase {
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
	ModelRenderer Base;
	ModelRenderer CollectionBox;
	ModelRenderer MainPipe;
	ModelRenderer InputBox;
	ModelRenderer Support1;
	ModelRenderer Support2;
	ModelRenderer Support3;
	ModelRenderer Support4;

	public matterCondenser() {
		textureWidth = 128;
		textureHeight = 128;

		Base1 = new ModelRenderer(this, 0, 0);
		Base1.addBox(0F, 0F, 0F, 16, 1, 1);
		Base1.setRotationPoint(-8F, 23F, -8F);
		Base1.setTextureSize(128, 128);
		Base1.mirror = true;
		setRotation(Base1, 0F, 0F, 0F);
		Base2 = new ModelRenderer(this, 0, 0);
		Base2.addBox(0F, 0F, 0F, 16, 1, 1);
		Base2.setRotationPoint(-8F, 23F, 7F);
		Base2.setTextureSize(128, 128);
		Base2.mirror = true;
		setRotation(Base2, 0F, 0F, 0F);
		Base3 = new ModelRenderer(this, 31, 0);
		Base3.addBox(0F, 0F, 0F, 1, 1, 16);
		Base3.setRotationPoint(7F, 23F, -8F);
		Base3.setTextureSize(128, 128);
		Base3.mirror = true;
		setRotation(Base3, 0F, 0F, 0F);
		Base4 = new ModelRenderer(this, 30, 0);
		Base4.addBox(0F, 0F, 0F, 1, 1, 16);
		Base4.setRotationPoint(-8F, 23F, -8F);
		Base4.setTextureSize(128, 128);
		Base4.mirror = true;
		setRotation(Base4, 0F, 0F, 0F);
		Collumn1 = new ModelRenderer(this, 0, 3);
		Collumn1.addBox(0F, 0F, 0F, 1, 16, 1);
		Collumn1.setRotationPoint(7F, 8F, -8F);
		Collumn1.setTextureSize(128, 128);
		Collumn1.mirror = true;
		setRotation(Collumn1, 0F, 0F, 0F);
		Collumn2 = new ModelRenderer(this, 0, 3);
		Collumn2.addBox(0F, 0F, 0F, 1, 16, 1);
		Collumn2.setRotationPoint(7F, 8F, 7F);
		Collumn2.setTextureSize(128, 128);
		Collumn2.mirror = true;
		setRotation(Collumn2, 0F, 0F, 0F);
		Collumn3 = new ModelRenderer(this, 0, 3);
		Collumn3.addBox(0F, 0F, 0F, 1, 16, 1);
		Collumn3.setRotationPoint(-8F, 8F, 7F);
		Collumn3.setTextureSize(128, 128);
		Collumn3.mirror = true;
		setRotation(Collumn3, 0F, 0F, 0F);
		Collumn4 = new ModelRenderer(this, 0, 3);
		Collumn4.addBox(0F, 0F, 0F, 1, 16, 1);
		Collumn4.setRotationPoint(-8F, 8F, -8F);
		Collumn4.setTextureSize(128, 128);
		Collumn4.mirror = true;
		setRotation(Collumn4, 0F, 0F, 0F);
		Top1 = new ModelRenderer(this, 0, 0);
		Top1.addBox(0F, 0F, 0F, 16, 1, 1);
		Top1.setRotationPoint(-8F, 8F, -8F);
		Top1.setTextureSize(128, 128);
		Top1.mirror = true;
		setRotation(Top1, 0F, 0F, 0F);
		Top2 = new ModelRenderer(this, 0, 0);
		Top2.addBox(0F, 0F, 0F, 16, 1, 1);
		Top2.setRotationPoint(-8F, 8F, 7F);
		Top2.setTextureSize(128, 128);
		Top2.mirror = true;
		setRotation(Top2, 0F, 0F, 0F);
		Top3 = new ModelRenderer(this, 30, 0);
		Top3.addBox(0F, 0F, 0F, 1, 1, 16);
		Top3.setRotationPoint(7F, 8F, -8F);
		Top3.setTextureSize(128, 128);
		Top3.mirror = true;
		setRotation(Top3, 0F, 0F, 0F);
		Top4 = new ModelRenderer(this, 30, 0);
		Top4.addBox(0F, 0F, 0F, 1, 1, 16);
		Top4.setRotationPoint(-8F, 8F, -8F);
		Top4.setTextureSize(128, 128);
		Top4.mirror = true;
		setRotation(Top4, 0F, 0F, 0F);
		Base = new ModelRenderer(this, 0, 28);
		Base.addBox(0F, 0F, 0F, 14, 1, 14);
		Base.setRotationPoint(-7F, 23F, -7F);
		Base.setTextureSize(128, 128);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
		CollectionBox = new ModelRenderer(this, 0, 48);
		CollectionBox.addBox(0F, 0F, 0F, 10, 1, 10);
		CollectionBox.setRotationPoint(-5F, 22F, -5F);
		CollectionBox.setTextureSize(128, 128);
		CollectionBox.mirror = true;
		setRotation(CollectionBox, 0F, 0F, 0F);
		MainPipe = new ModelRenderer(this, 42, 49);
		MainPipe.addBox(0F, 0F, 0F, 4, 4, 4);
		MainPipe.setRotationPoint(-2F, 18F, -2F);
		MainPipe.setTextureSize(128, 128);
		MainPipe.mirror = true;
		setRotation(MainPipe, 0F, 0F, 0F);
		InputBox = new ModelRenderer(this, 0, 63);
		InputBox.addBox(0F, 0F, 0F, 14, 10, 14);
		InputBox.setRotationPoint(-7F, 8F, -7F);
		InputBox.setTextureSize(128, 128);
		InputBox.mirror = true;
		setRotation(InputBox, 0F, 0F, 0F);
		Support1 = new ModelRenderer(this, 10, 9);
		Support1.addBox(0F, 0F, 0F, 1, 5, 1);
		Support1.setRotationPoint(6F, 18F, 6F);
		Support1.setTextureSize(128, 128);
		Support1.mirror = true;
		setRotation(Support1, 0F, 0F, 0F);
		Support2 = new ModelRenderer(this, 10, 9);
		Support2.addBox(0F, 0F, 0F, 1, 5, 1);
		Support2.setRotationPoint(6F, 18F, -7F);
		Support2.setTextureSize(128, 128);
		Support2.mirror = true;
		setRotation(Support2, 0F, 0F, 0F);
		Support3 = new ModelRenderer(this, 10, 9);
		Support3.addBox(0F, 0F, 0F, 1, 5, 1);
		Support3.setRotationPoint(-7F, 18F, -7F);
		Support3.setTextureSize(128, 128);
		Support3.mirror = true;
		setRotation(Support3, 0F, 0F, 0F);
		Support4 = new ModelRenderer(this, 10, 9);
		Support4.addBox(0F, 0F, 0F, 1, 5, 1);
		Support4.setRotationPoint(-7F, 18F, 6F);
		Support4.setTextureSize(128, 128);
		Support4.mirror = true;
		setRotation(Support4, 0F, 0F, 0F);
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
		Base.render(f5);
		CollectionBox.render(f5);
		MainPipe.render(f5);
		InputBox.render(f5);
		Support1.render(f5);
		Support2.render(f5);
		Support3.render(f5);
		Support4.render(f5);
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
		Base.render(f5);
		CollectionBox.render(f5);
		MainPipe.render(f5);
		InputBox.render(f5);
		Support1.render(f5);
		Support2.render(f5);
		Support3.render(f5);
		Support4.render(f5);
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
