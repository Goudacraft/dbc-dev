package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPorunga extends ModelBiped {
   ModelRenderer dragon1;
   ModelRenderer dragon2;
   ModelRenderer dragon3;
   ModelRenderer dragon4;
   ModelRenderer dragon5;
   ModelRenderer dragon8;
   ModelRenderer dragon10;
   ModelRenderer dragon12;
   ModelRenderer dragon13;
   ModelRenderer dragon14;
   ModelRenderer dragon15;
   ModelRenderer dragon16;
   ModelRenderer dragon17;
   ModelRenderer dragon18;
   ModelRenderer dragon19;
   ModelRenderer dragon20;
   ModelRenderer dragon22;
   ModelRenderer dragon23;
   ModelRenderer dragon24;

   public ModelPorunga() {
      this.textureWidth = 256;
      this.textureHeight = 128;
      this.dragon1 = new ModelRenderer(this, 0, 0);
      this.dragon1.addBox(-4.0F, -4.0F, -4.0F, 8, 16, 8);
      this.dragon1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon1.setTextureSize(256, 128);
      this.dragon1.mirror = true;
      this.dragon2 = new ModelRenderer(this, 0, 0);
      this.dragon2.addBox(-4.0F, -18.0F, -3.0F, 8, 16, 8);
      this.dragon2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon2.setTextureSize(256, 128);
      this.setRotation(this.dragon2, 0.4537856F, 0.0174533F, 0.0F);
      this.dragon3 = new ModelRenderer(this, 0, 0);
      this.dragon3.addBox(-4.0F, -25.0F, -16.0F, 8, 16, 8);
      this.dragon3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon3.setTextureSize(256, 128);
      this.setRotation(this.dragon3, -0.4363323F, 0.0F, 0.0F);
      this.dragon4 = new ModelRenderer(this, 40, 37);
      this.dragon4.addBox(-3.0F, -91.0F, 11.0F, 11, 4, 4);
      this.dragon4.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon4.setTextureSize(256, 128);
      this.setRotation(this.dragon4, 0.2443461F, -0.3839724F, 0.0F);
      this.dragon5 = new ModelRenderer(this, 0, 47);
      this.dragon5.addBox(-5.0F, -80.0F, 44.0F, 10, 10, 10);
      this.dragon5.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon5.setTextureSize(256, 128);
      this.setRotation(this.dragon5, 0.6806784F, 0.0F, 0.0F);
      this.dragon8 = new ModelRenderer(this, 152, 0);
      this.dragon8.addBox(-17.0F, -85.0F, 13.0F, 36, 20, 16);
      this.dragon8.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon8.setTextureSize(256, 128);
      this.setRotation(this.dragon8, 0.2443461F, 0.0174533F, 0.0F);
      this.dragon10 = new ModelRenderer(this, 40, 37);
      this.dragon10.addBox(-8.0F, -91.0F, 11.0F, 11, 4, 4);
      this.dragon10.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon10.setTextureSize(256, 128);
      this.setRotation(this.dragon10, 0.2443461F, 0.3839724F, 0.0F);
      this.dragon12 = new ModelRenderer(this, 0, 24);
      this.dragon12.addBox(-3.0F, 7.0F, -6.0F, 6, 16, 6);
      this.dragon12.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon12.setTextureSize(256, 128);
      this.setRotation(this.dragon12, 0.2617994F, 0.0F, 0.0F);
      this.dragon13 = new ModelRenderer(this, 40, 45);
      this.dragon13.addBox(3.0F, -61.0F, 71.0F, 4, 4, 12);
      this.dragon13.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon13.setTextureSize(256, 128);
      this.setRotation(this.dragon13, 0.9773844F, 0.2094395F, 0.0F);
      this.dragon14 = new ModelRenderer(this, 40, 45);
      this.dragon14.addBox(-7.0F, -61.0F, 71.0F, 4, 4, 12);
      this.dragon14.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon14.setTextureSize(256, 128);
      this.setRotation(this.dragon14, 0.9773844F, -0.2094395F, 0.0F);
      this.dragon15 = new ModelRenderer(this, 80, 0);
      this.dragon15.addBox(-12.0F, -76.0F, -8.0F, 24, 24, 12);
      this.dragon15.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon15.setTextureSize(256, 128);
      this.setRotation(this.dragon15, -0.0872665F, 0.0F, 0.0F);
      this.dragon16 = new ModelRenderer(this, 32, 0);
      this.dragon16.addBox(-7.0F, -53.0F, -9.0F, 14, 27, 10);
      this.dragon16.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon16.setTextureSize(256, 128);
      this.setRotation(this.dragon16, -0.122173F, 0.0F, 0.0F);
      this.dragon17 = new ModelRenderer(this, 0, 90);
      this.dragon17.addBox(-43.0F, -58.0F, -19.0F, 13, 26, 12);
      this.dragon17.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon17.setTextureSize(256, 128);
      this.setRotation(this.dragon17, -0.2617994F, -0.0174533F, 0.1745329F);
      this.dragon18 = new ModelRenderer(this, 50, 90);
      this.dragon18.addBox(-43.0F, -84.0F, -4.0F, 13, 26, 12);
      this.dragon18.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon18.setTextureSize(256, 128);
      this.setRotation(this.dragon18, 0.0F, 0.0F, 0.1745329F);
      this.dragon19 = new ModelRenderer(this, 50, 90);
      this.dragon19.mirror = true;
      this.dragon19.addBox(32.0F, -84.0F, -4.0F, 13, 26, 12);
      this.dragon19.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon19.setTextureSize(256, 128);
      this.setRotation(this.dragon19, 0.0F, 0.0F, -0.1745329F);
      this.dragon20 = new ModelRenderer(this, 0, 90);
      this.dragon20.mirror = true;
      this.dragon20.addBox(32.0F, -58.0F, -19.0F, 13, 26, 12);
      this.dragon20.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon20.setTextureSize(256, 128);
      this.setRotation(this.dragon20, -0.2617994F, 0.0174533F, -0.1745329F);
      this.dragon22 = new ModelRenderer(this, 116, 88);
      this.dragon22.addBox(0.0F, -92.0F, 22.0F, 0, 27, 13);
      this.dragon22.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon22.setTextureSize(256, 128);
      this.setRotation(this.dragon22, 0.2443461F, 0.0174533F, 0.0F);
      this.dragon23 = new ModelRenderer(this, 100, 73);
      this.dragon23.addBox(0.0F, -74.0F, -9.0F, 0, 47, 8);
      this.dragon23.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon23.setTextureSize(256, 128);
      this.setRotation(this.dragon23, -0.2617994F, 0.0F, 0.0F);
      this.dragon24 = new ModelRenderer(this, 1, 52);
      this.dragon24.addBox(-4.0F, -75.1F, 43.0F, 8, 5, 10);
      this.dragon24.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.dragon24.setTextureSize(256, 128);
      this.setRotation(this.dragon24, 0.6806784F, 0.0F, 0.0F);
      this.dragon1.addChild(this.dragon2);
      this.dragon1.addChild(this.dragon3);
      this.dragon1.addChild(this.dragon4);
      this.dragon1.addChild(this.dragon5);
      this.dragon1.addChild(this.dragon8);
      this.dragon1.addChild(this.dragon10);
      this.dragon1.addChild(this.dragon12);
      this.dragon1.addChild(this.dragon13);
      this.dragon1.addChild(this.dragon14);
      this.dragon1.addChild(this.dragon15);
      this.dragon1.addChild(this.dragon16);
      this.dragon1.addChild(this.dragon17);
      this.dragon1.addChild(this.dragon18);
      this.dragon1.addChild(this.dragon19);
      this.dragon1.addChild(this.dragon20);
      this.dragon1.addChild(this.dragon22);
      this.dragon1.addChild(this.dragon23);
      this.dragon1.addChild(this.dragon24);
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
   }

   public void renderModel(Entity var1, float var2) {
      this.render(var1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, var2);
   }
}
