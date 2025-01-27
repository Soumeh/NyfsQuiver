package com.nyfaria.nyfsquiver.client.render.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class OldQuiverModel<T extends LivingEntity> extends EntityModel<T> {
	private final ModelRenderer bone;
	private final ModelRenderer bone_r1;
	private final ModelRenderer arrows;
	private final ModelRenderer arrows_r1;
	public boolean displayArrows;

	public OldQuiverModel() {
		texWidth = 64;
		texHeight = 64;

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, 24.0F, 0.0F);


		bone_r1 = new ModelRenderer(this);
		bone_r1.setPos(-1.0F, -19.0F, 4.0F);
		bone.addChild(bone_r1);
		setRotationAngle(bone_r1, 1.5708F, 0.0F, 0.0F);
		bone_r1.texOffs(25, 2).addBox(4.0F, -2.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(7, 10).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		bone_r1.texOffs(7, 10).addBox(0.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		bone_r1.texOffs(7, 10).addBox(1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		bone_r1.texOffs(7, 10).addBox(2.0F, -2.0F, -3.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		bone_r1.texOffs(7, 10).addBox(-2.0F, -2.0F, 1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(7, 10).addBox(-1.0F, -2.0F, 2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(7, 10).addBox(4.0F, -2.0F, -3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(7, 10).addBox(3.0F, -2.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(5, 12).addBox(2.0F, -1.5F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(5, 12).addBox(1.0F, -1.5F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(5, 12).addBox(0.0F, -1.5F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(5, 12).addBox(-1.0F, -1.5F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(5, 12).addBox(-2.0F, -1.5F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(18, 3).addBox(0.0F, -1.5F, 2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(18, 3).addBox(1.0F, -1.5F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(18, 3).addBox(2.0F, -1.5F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(18, 3).addBox(3.0F, -1.5F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(18, 3).addBox(4.0F, -1.5F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(0, 0).addBox(5.0F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(0, 0).addBox(4.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(0, 0).addBox(3.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(0, 0).addBox(2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(0, 0).addBox(1.0F, -1.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(0, 0).addBox(0.0F, -1.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(23, 12).addBox(-3.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(23, 12).addBox(-3.0F, -1.5F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(23, 12).addBox(-1.0F, -1.5F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(23, 12).addBox(-2.0F, -2.0F, 2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(23, 12).addBox(-2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(23, 12).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(23, 12).addBox(0.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(23, 12).addBox(1.0F, -1.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(23, 12).addBox(2.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(21, 3).addBox(5.0F, -1.5F, -4.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone_r1.texOffs(18, 1).addBox(3.0F, -1.5F, -5.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(0, 0).addBox(3.0F, -1.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bone_r1.texOffs(0, 0).addBox(6.0F, -1.0F, -5.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		arrows = new ModelRenderer(this);
		arrows.setPos(0.0F, 24.0F, 0.0F);


		arrows_r1 = new ModelRenderer(this);
		arrows_r1.setPos(-1.0F, -19.0F, 4.0F);
		arrows.addChild(arrows_r1);
		setRotationAngle(arrows_r1, 1.5708F, 0.0F, 0.0F);
		arrows_r1.texOffs(7, 27).addBox(-3.0F, -1.5F, 5.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(6, 26).addBox(-4.0F, -1.5F, 6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(6, 26).addBox(-6.0F, -1.5F, 4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(6, 26).addBox(-5.0F, -1.5F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(22, 18).addBox(-4.0F, -1.5F, 2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(22, 18).addBox(-2.0F, -1.5F, 4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(5, 35).addBox(-3.0F, -2.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(9, 26).addBox(-5.0F, -2.0F, 5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(21, 26).addBox(-5.0F, -2.0F, 4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(21, 26).addBox(-4.0F, -2.0F, 5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(7, 25).addBox(-4.0F, -2.0F, 4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(8, 18).addBox(-4.0F, -2.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(8, 18).addBox(-3.0F, -2.0F, 4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(23, 34).addBox(-3.0F, -1.0F, 6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(8, 18).addBox(-2.0F, -1.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(8, 18).addBox(-1.0F, -1.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(8, 18).addBox(-3.0F, -2.0F, 2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		arrows_r1.texOffs(8, 18).addBox(-2.0F, -2.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
	}


	@Override
	public void setupAnim(T pEntityIn, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
		

	}


	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		if(!displayArrows)
		arrows.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}