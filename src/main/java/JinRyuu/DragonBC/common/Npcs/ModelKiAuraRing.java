package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKiAuraRing extends ModelBiped {
   ModelRenderer low;
   ModelRenderer lowm1;
   ModelRenderer lowm2;
   ModelRenderer lowm3;
   ModelRenderer lowm4;
   ModelRenderer lowm5;
   ModelRenderer lowm6;
   ModelRenderer lowm7;
   ModelRenderer lowm8;

   public ModelKiAuraRing() {
      this.textureWidth = 64;
      this.textureHeight = 32;
      this.low = new ModelRenderer(this, 32, 0);
      this.low.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
      this.low.setRotationPoint(0.0F, 20.0F, 0.0F);
      this.setRotation(this.low, 0.0F, 0.0F, 0.0F);
      this.lowm1 = new ModelRenderer(this, 0, 0);
      this.lowm1.addBox(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm1.setRotationPoint(0.0F, 20.0F, 0.0F);
      this.lowm1.setTextureSize(64, 32);
      this.setRotation(this.lowm1, 0.8726646F, 1.570796F, 0.0F);
      this.lowm2 = new ModelRenderer(this, 0, 0);
      this.lowm2.addBox(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm2.setRotationPoint(0.0F, 20.0F, 0.0F);
      this.lowm2.setTextureSize(64, 32);
      this.setRotation(this.lowm2, 0.8726646F, 0.0F, 0.0F);
      this.lowm3 = new ModelRenderer(this, 0, 0);
      this.lowm3.addBox(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm3.setRotationPoint(0.0F, 20.0F, 0.0F);
      this.lowm3.setTextureSize(64, 32);
      this.setRotation(this.lowm3, 0.8726646F, -0.7853982F, 0.0F);
      this.lowm4 = new ModelRenderer(this, 0, 0);
      this.lowm4.addBox(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm4.setRotationPoint(0.0F, 20.0F, 0.0F);
      this.lowm4.setTextureSize(64, 32);
      this.setRotation(this.lowm4, 0.8726646F, 3.141593F, 0.0F);
      this.lowm5 = new ModelRenderer(this, 0, 0);
      this.lowm5.addBox(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm5.setRotationPoint(0.0F, 20.0F, 0.0F);
      this.lowm5.setTextureSize(64, 32);
      this.setRotation(this.lowm5, 0.8726646F, -1.570796F, 0.0F);
      this.lowm6 = new ModelRenderer(this, 0, 0);
      this.lowm6.addBox(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm6.setRotationPoint(0.0F, 20.0F, 0.0F);
      this.lowm6.setTextureSize(64, 32);
      this.setRotation(this.lowm6, 0.8726646F, -2.373648F, 0.0F);
      this.lowm7 = new ModelRenderer(this, 0, 0);
      this.lowm7.addBox(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm7.setRotationPoint(0.0F, 20.0F, 0.0F);
      this.lowm7.setTextureSize(64, 32);
      this.setRotation(this.lowm7, 0.8726646F, 2.373648F, 0.0F);
      this.lowm8 = new ModelRenderer(this, 0, 0);
      this.lowm8.addBox(-5.0F, -12.0F, -8.0F, 10, 10, 0);
      this.lowm8.setRotationPoint(0.0F, 20.0F, 0.0F);
      this.lowm8.setTextureSize(64, 32);
      this.setRotation(this.lowm8, 0.8726646F, 0.7853982F, 0.0F);
      this.low.addChild(this.lowm1);
      this.low.addChild(this.lowm2);
      this.low.addChild(this.lowm3);
      this.low.addChild(this.lowm4);
      this.low.addChild(this.lowm5);
      this.low.addChild(this.lowm6);
      this.low.addChild(this.lowm7);
      this.low.addChild(this.lowm8);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
      this.low.render(var7);
   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      float var9 = 1.0F;
      this.low.rotationPointY = 28.0F;
      this.low.rotateAngleY = -var3 / 5.0F;
   }

   public void renderModel(Entity var1, float var2, float var3, float var4, float var5) {
      this.render(var1, 0.0F, 0.0F, var5, var2, var3, var4);
   }
}
