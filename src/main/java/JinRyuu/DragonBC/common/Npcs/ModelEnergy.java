package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEnergy extends ModelBiped {
   ModelRenderer aShape1;
   ModelRenderer aShape2;
   ModelRenderer aShape3;
   ModelRenderer aShape4;
   ModelRenderer bShape1;
   ModelRenderer bShape2;
   ModelRenderer bShape3;
   ModelRenderer bShape4;
   ModelRenderer bShape5;
   ModelRenderer bShape6;
   ModelRenderer bShape7;
   ModelRenderer cShape1;
   ModelRenderer cShape2;
   ModelRenderer cShape3;
   ModelRenderer dShape1;
   ModelRenderer eShape1;
   ModelRenderer eShape2;
   ModelRenderer eShape3;
   ModelRenderer eShape4;
   ModelRenderer eShape5;
   ModelRenderer eShape6;
   ModelRenderer eShape7;
   ModelRenderer eShape8;
   ModelRenderer eShape9;

   public ModelEnergy() {
      this.textureWidth = 128;
      this.textureHeight = 128;
      this.aShape1 = new ModelRenderer(this, 0, 0);
      this.aShape1.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 8);
      this.aShape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.aShape1.setTextureSize(128, 128);
      this.setRotation(this.aShape1, 0.0F, 0.0F, 0.0F);
      this.aShape2 = new ModelRenderer(this, 0, 0);
      this.aShape2.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8);
      this.aShape2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.aShape2.setTextureSize(128, 128);
      this.setRotation(this.aShape2, 0.0F, 0.0F, 0.0F);
      this.bShape1 = new ModelRenderer(this, 0, 0);
      this.bShape1.addBox(-10.0F, -10.0F, -10.0F, 20, 20, 20);
      this.bShape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bShape1.setTextureSize(128, 128);
      this.setRotation(this.bShape1, 0.0F, 0.0F, 0.0F);
      this.bShape2 = new ModelRenderer(this, 0, 0);
      this.bShape2.addBox(-8.0F, -8.0F, -12.0F, 16, 16, 24);
      this.bShape2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bShape2.setTextureSize(128, 128);
      this.setRotation(this.bShape2, 0.0F, 0.0F, 0.0F);
      this.bShape3 = new ModelRenderer(this, 0, 0);
      this.bShape3.addBox(-4.0F, -4.0F, -14.0F, 8, 8, 28);
      this.bShape3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bShape3.setTextureSize(128, 128);
      this.setRotation(this.bShape3, 0.0F, 0.0F, 0.0F);
      this.bShape4 = new ModelRenderer(this, 0, 0);
      this.bShape4.addBox(-8.0F, -12.0F, -8.0F, 16, 24, 16);
      this.bShape4.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bShape4.setTextureSize(128, 128);
      this.setRotation(this.bShape4, 0.0F, 0.0F, 0.0F);
      this.bShape5 = new ModelRenderer(this, 0, 0);
      this.bShape5.addBox(-4.0F, -14.0F, -4.0F, 8, 28, 8);
      this.bShape5.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bShape5.setTextureSize(128, 128);
      this.setRotation(this.bShape5, 0.0F, 0.0F, 0.0F);
      this.bShape6 = new ModelRenderer(this, 0, 0);
      this.bShape6.addBox(-12.0F, -8.0F, -8.0F, 24, 16, 16);
      this.bShape6.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bShape6.setTextureSize(128, 128);
      this.setRotation(this.bShape6, 0.0F, 0.0F, 0.0F);
      this.bShape7 = new ModelRenderer(this, 0, 0);
      this.bShape7.addBox(-14.0F, -4.0F, -4.0F, 28, 8, 8);
      this.bShape7.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.bShape7.setTextureSize(128, 128);
      this.setRotation(this.bShape7, 0.0F, 0.0F, 0.0F);
      this.bShape1.addChild(this.bShape2);
      this.bShape1.addChild(this.bShape3);
      this.bShape1.addChild(this.bShape4);
      this.bShape1.addChild(this.bShape5);
      this.bShape1.addChild(this.bShape6);
      this.bShape1.addChild(this.bShape7);
      this.cShape1 = new ModelRenderer(this, 0, 0);
      this.cShape1.addBox(-10.0F, -1.0F, -10.0F, 20, 2, 20);
      this.cShape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.cShape1.setTextureSize(128, 32);
      this.setRotation(this.cShape1, 0.0F, 0.0F, 0.0F);
      this.cShape2 = new ModelRenderer(this, 0, 0);
      this.cShape2.addBox(-7.0F, -0.5F, -12.0F, 14, 1, 24);
      this.cShape2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.cShape2.setTextureSize(128, 32);
      this.setRotation(this.cShape2, 0.0F, 0.0F, 0.0F);
      this.cShape3 = new ModelRenderer(this, 0, 0);
      this.cShape3.addBox(-12.0F, -0.5F, -7.0F, 24, 1, 14);
      this.cShape3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.cShape3.setTextureSize(128, 32);
      this.setRotation(this.cShape3, 0.0F, 0.0F, 0.0F);
      this.cShape1.addChild(this.cShape2);
      this.cShape1.addChild(this.cShape3);
      this.dShape1 = new ModelRenderer(this, 0, 0);
      this.dShape1.addBox(-1.0F, -1.0F, -10.0F, 2, 2, 20);
      this.dShape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dShape1.setTextureSize(128, 128);
      this.setRotation(this.dShape1, 0.0F, 0.0F, 0.0F);
      this.eShape1 = new ModelRenderer(this, 0, 8);
      this.eShape1.addBox(-3.0F, -3.0F, -7.0F, 6, 6, 14);
      this.eShape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.eShape1.setTextureSize(128, 128);
      this.setRotation(this.eShape1, 0.0F, 0.0F, 0.0F);
      this.eShape2 = new ModelRenderer(this, 0, 8);
      this.eShape2.addBox(-2.0F, -2.0F, -8.0F, 4, 4, 16);
      this.eShape2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.eShape2.setTextureSize(128, 128);
      this.setRotation(this.eShape2, 0.0F, 0.0F, 0.0F);
      this.eShape3 = new ModelRenderer(this, 0, 8);
      this.eShape3.addBox(-2.0F, -4.0F, -6.0F, 4, 8, 12);
      this.eShape3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.eShape3.setTextureSize(128, 128);
      this.setRotation(this.eShape3, 0.0F, 0.0F, 0.0F);
      this.eShape4 = new ModelRenderer(this, 0, 8);
      this.eShape4.addBox(-4.0F, -2.0F, -6.0F, 8, 4, 12);
      this.eShape4.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.eShape4.setTextureSize(128, 128);
      this.setRotation(this.eShape4, 0.0F, 0.0F, 0.0F);
      this.eShape5 = new ModelRenderer(this, 0, 0);
      this.eShape5.addBox(6.0F, -3.0F, -5.0F, 1, 6, 1);
      this.eShape5.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.eShape5.setTextureSize(128, 128);
      this.setRotation(this.eShape5, -0.3490659F, 0.0F, 0.0F);
      this.eShape6 = new ModelRenderer(this, 0, 0);
      this.eShape6.addBox(7.0F, -3.0F, -3.0F, 1, 6, 1);
      this.eShape6.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.eShape6.setTextureSize(128, 128);
      this.setRotation(this.eShape6, -0.3490659F, 0.0F, -0.7853982F);
      this.eShape7 = new ModelRenderer(this, 0, 0);
      this.eShape7.addBox(-3.533333F, -8.2F, -0.5333334F, 7, 1, 1);
      this.eShape7.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.eShape7.setTextureSize(128, 128);
      this.setRotation(this.eShape7, 0.0F, 0.4537856F, 0.0F);
      this.eShape8 = new ModelRenderer(this, 0, 0);
      this.eShape8.addBox(-3.0F, -8.0F, -0.4666667F, 6, 1, 1);
      this.eShape8.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.eShape8.setTextureSize(128, 128);
      this.setRotation(this.eShape8, 0.0F, 0.4014257F, -0.7853982F);
      this.eShape9 = new ModelRenderer(this, 0, 0);
      this.eShape9.addBox(-7.0F, -3.0F, 3.0F, 1, 6, 1);
      this.eShape9.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.eShape9.setTextureSize(128, 128);
      this.setRotation(this.eShape9, 0.3490659F, 0.0F, 0.0F);
      this.eShape1.addChild(this.eShape2);
      this.eShape1.addChild(this.eShape3);
      this.eShape1.addChild(this.eShape4);
      this.eShape7.addChild(this.eShape5);
      this.eShape7.addChild(this.eShape6);
      this.eShape7.addChild(this.eShape8);
      this.eShape7.addChild(this.eShape9);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
   }

   public void render(ModelRenderer var1, Entity var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.setRotationAngles(var3, var4, var5, var6, var7, var8, var2);
      var1.render(var8);
   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      float var9 = 1.0F;
      this.aShape1.rotateAngleZ = var3;
      this.aShape2.rotateAngleZ = var3;
      this.bShape1.rotateAngleZ = var3;
      this.bShape1.rotateAngleY = var3;
      this.bShape1.rotateAngleX = var3;
      this.cShape1.rotateAngleY = var3;
      this.dShape1.rotationPointZ = var3;
      this.dShape1.rotateAngleZ = var3;
      this.eShape7.rotateAngleZ = -var3 * 2.0F;
   }

   public void renderModel(byte var1, Entity var2, float var3, float var4, float var5, float var6, boolean var7) {
      ModelRenderer var8 = null;
      if(var1 == 0) {
         var8 = var7?this.aShape1:this.aShape2;
      }

      if(var1 == 1) {
         var8 = this.bShape1;
      }

      if(var1 == 2) {
         var8 = this.cShape1;
      }

      if(var1 == 3) {
         var8 = this.dShape1;
      }

      if(var1 == 4) {
         var8 = this.eShape7;
      }

      this.render(var8, var2, 0.0F, 0.0F, var6, var3, var4, var5);
   }
}
