package JinRyuu.DragonBC.common.Render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SaibaiHatchedModel extends ModelBase {
   ModelRenderer bottom;
   ModelRenderer side1;
   ModelRenderer side2;
   ModelRenderer side3;
   ModelRenderer side4;
   ModelRenderer a1;
   ModelRenderer a2;
   ModelRenderer a3;
   ModelRenderer a4;

   public SaibaiHatchedModel() {
      this.textureWidth = 128;
      this.textureHeight = 32;
      this.bottom = new ModelRenderer(this, 0, 0);
      this.bottom.addBox(-8.0F, -8.0F, -8.0F, 16, 8, 16);
      this.bottom.setRotationPoint(0.0F, 24.0F, 0.0F);
      this.bottom.setTextureSize(64, 32);
      this.bottom.mirror = true;
      this.setRotation(this.bottom, 0.0F, 0.0F, 0.0F);
      this.side1 = new ModelRenderer(this, 64, 0);
      this.side1.addBox(-8.0F, -7.0F, -8.0F, 16, 8, 1);
      this.side1.setRotationPoint(0.0F, 15.0F, 0.0F);
      this.side1.setTextureSize(64, 32);
      this.side1.mirror = true;
      this.setRotation(this.side1, 0.0F, 0.0F, 0.0F);
      this.side2 = new ModelRenderer(this, 64, 0);
      this.side2.addBox(-8.0F, -7.0F, -8.0F, 16, 8, 1);
      this.side2.setRotationPoint(0.0F, 15.0F, 15.0F);
      this.side2.setTextureSize(64, 32);
      this.side2.mirror = true;
      this.setRotation(this.side2, 0.0F, 0.0F, 0.0F);
      this.side3 = new ModelRenderer(this, 98, 0);
      this.side3.addBox(-8.0F, -7.0F, -8.0F, 1, 8, 14);
      this.side3.setRotationPoint(15.0F, 15.0F, 1.0F);
      this.side3.setTextureSize(64, 32);
      this.side3.mirror = true;
      this.setRotation(this.side3, 0.0F, 0.0F, 0.0F);
      this.side4 = new ModelRenderer(this, 98, 0);
      this.side4.addBox(-8.0F, -7.0F, -8.0F, 1, 8, 14);
      this.side4.setRotationPoint(0.0F, 15.0F, 1.0F);
      this.side4.setTextureSize(64, 32);
      this.side4.mirror = true;
      this.setRotation(this.side4, 0.0F, 0.0F, 0.0F);
      this.a1 = new ModelRenderer(this, 50, 10);
      this.a1.addBox(0.0F, 0.0F, 0.0F, 14, 0, 14);
      this.a1.setRotationPoint(-7.0F, 8.0F, -7.0F);
      this.a1.setTextureSize(64, 32);
      this.a1.mirror = true;
      this.setRotation(this.a1, -0.7853982F, 0.0F, 0.0F);
      this.a2 = new ModelRenderer(this, 50, 10);
      this.a2.addBox(-14.0F, 0.0F, 0.0F, 14, 0, 14);
      this.a2.setRotationPoint(7.0F, 8.0F, -7.0F);
      this.a2.setTextureSize(64, 32);
      this.a2.mirror = true;
      this.setRotation(this.a2, 0.0F, 0.0F, -0.7853982F);
      this.a3 = new ModelRenderer(this, 50, 10);
      this.a3.addBox(-14.0F, 0.0F, -14.0F, 14, 0, 14);
      this.a3.setRotationPoint(7.0F, 8.0F, 7.0F);
      this.a3.setTextureSize(64, 32);
      this.a3.mirror = true;
      this.setRotation(this.a3, 0.7853982F, 0.0F, 0.0F);
      this.a4 = new ModelRenderer(this, 50, 10);
      this.a4.addBox(0.0F, 0.0F, -14.0F, 14, 0, 14);
      this.a4.setRotationPoint(-7.0F, 8.0F, 7.0F);
      this.a4.setTextureSize(64, 32);
      this.a4.mirror = true;
      this.setRotation(this.a4, 0.0F, 0.0F, 0.7853982F);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      super.render(var1, var2, var3, var4, var5, var6, var7);
      this.setRotationAngles(var2, var3, var4, var5, var6, var7);
      this.bottom.render(var7);
      this.side1.render(var7);
      this.side2.render(var7);
      this.side3.render(var7);
      this.side4.render(var7);
      this.a1.render(var7);
      this.a2.render(var7);
      this.a3.render(var7);
      this.a4.render(var7);
   }

   public void renderModel(float var1) {
      this.bottom.render(var1);
      this.side1.render(var1);
      this.side2.render(var1);
      this.side3.render(var1);
      this.side4.render(var1);
      this.a1.render(var1);
      this.a2.render(var1);
      this.a3.render(var1);
      this.a4.render(var1);
   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6) {
      super.setRotationAngles(var1, var2, var3, var4, var5, var6, (Entity)null);
   }
}
