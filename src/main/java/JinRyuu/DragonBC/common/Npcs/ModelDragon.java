package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDragon extends ModelBiped {
   ModelRenderer dragon1;
   ModelRenderer dragon2;
   ModelRenderer dragon3;
   ModelRenderer dragon4;
   ModelRenderer dragon5;
   ModelRenderer dragon6;
   ModelRenderer dragon7;
   ModelRenderer dragon8;
   ModelRenderer dragon9;
   ModelRenderer dragon10;
   ModelRenderer dragon11;
   ModelRenderer dragon12;
   ModelRenderer dragon13;
   ModelRenderer dragon14;

   public ModelDragon() {
      this.textureWidth = 128;
      this.textureHeight = 64;
      this.dragon1 = new ModelRenderer(this, 0, 0);
      this.dragon1.addBox(-4.0F, -4.0F, -4.0F, 8, 16, 8);
      this.dragon1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.dragon1, 0.0F, 0.0F, 0.0F);
      this.dragon2 = new ModelRenderer(this, 0, 0);
      this.dragon2.addBox(-4.0F, -18.0F, -3.0F, 8, 16, 8);
      this.dragon2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.dragon2, 0.4537856F, 0.0174533F, 0.0F);
      this.dragon3 = new ModelRenderer(this, 0, 0);
      this.dragon3.addBox(-4.0F, -25.0F, -16.0F, 8, 16, 8);
      this.dragon3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.dragon3, -0.4363323F, 0.0F, 0.0F);
      this.dragon4 = new ModelRenderer(this, 34, 0);
      this.dragon4.addBox(2.0F, -26.0F, 4.0F, 11, 4, 4);
      this.dragon4.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.dragon4, 0.2443461F, 0.3839724F, 0.0F);
      this.dragon5 = new ModelRenderer(this, 0, 47);
      this.dragon5.addBox(-5.0F, -40.0F, 16.0F, 10, 7, 10);
      this.dragon5.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.dragon5, 0.6806784F, 0.0F, 0.0F);
      this.dragon6 = new ModelRenderer(this, 0, 37);
      this.dragon6.addBox(-3.0F, -32.0F, 15.0F, 6, 2, 8);
      this.dragon6.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.dragon6, 0.8726646F, 0.0F, 0.0F);
      this.dragon7 = new ModelRenderer(this, 0, 27);
      this.dragon7.addBox(-3.0F, -37.0F, 8.0F, 6, 2, 8);
      this.dragon7.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.dragon7, 0.6632251F, 0.0F, 0.0F);
      this.dragon8 = new ModelRenderer(this, 0, 0);
      this.dragon8.addBox(-4.0F, -40.0F, 1.0F, 8, 16, 8);
      this.dragon8.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.dragon8, 0.2443461F, 0.0174533F, 0.0F);
      this.dragon9 = new ModelRenderer(this, 34, 0);
      this.dragon9.addBox(1.0F, 0.0F, -1.0F, 11, 4, 4);
      this.dragon9.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.dragon9, 0.2443461F, 0.3839724F, 0.0F);
      this.dragon10 = new ModelRenderer(this, 34, 0);
      this.dragon10.addBox(-13.0F, -26.0F, 4.0F, 11, 4, 4);
      this.dragon10.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.dragon10, 0.2443461F, -0.3839724F, 0.0F);
      this.dragon11 = new ModelRenderer(this, 34, 0);
      this.dragon11.addBox(-12.0F, 0.0F, -1.0F, 11, 4, 4);
      this.dragon11.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.dragon11, 0.2443461F, -0.3839724F, 0.0F);
      this.dragon12 = new ModelRenderer(this, 32, 8);
      this.dragon12.addBox(-3.0F, 7.0F, -6.0F, 6, 16, 6);
      this.dragon12.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.dragon12, 0.2617994F, 0.0F, 0.0F);
      this.dragon13 = new ModelRenderer(this, 28, 34);
      this.dragon13.addBox(4.0F, -31.0F, 33.0F, 3, 3, 10);
      this.dragon13.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.dragon13, 0.9773844F, 0.3316126F, 0.0F);
      this.dragon14 = new ModelRenderer(this, 28, 34);
      this.dragon14.addBox(-7.0F, -31.0F, 33.0F, 3, 3, 10);
      this.dragon14.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.dragon14, 0.9773844F, -0.3316126F, 0.0F);
      this.dragon1.addChild(this.dragon2);
      this.dragon1.addChild(this.dragon3);
      this.dragon1.addChild(this.dragon4);
      this.dragon1.addChild(this.dragon5);
      this.dragon1.addChild(this.dragon6);
      this.dragon1.addChild(this.dragon7);
      this.dragon1.addChild(this.dragon8);
      this.dragon1.addChild(this.dragon9);
      this.dragon1.addChild(this.dragon10);
      this.dragon1.addChild(this.dragon11);
      this.dragon1.addChild(this.dragon12);
      this.dragon1.addChild(this.dragon13);
      this.dragon1.addChild(this.dragon14);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
      this.dragon1.render(var7);
   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      this.dragon1.rotateAngleY = var4 / 57.295776F;
   }

   public void renderModel(Entity var1, float var2) {
      this.render(var1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, var2);
   }
}
