package JinRyuu.DragonBC.common.Entitys;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKiHame extends ModelBase {
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape6;
   ModelRenderer Shape7;
   ModelRenderer Shape1;
   public String textureFile;

   public ModelKiHame(String var1) {
      this.textureFile = var1;
   }

   public ModelKiHame() {
      this.textureWidth = 128;
      this.textureHeight = 64;
      this.Shape2 = new ModelRenderer(this, 0, 0);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 25, 15, 15);
      this.Shape2.setRotationPoint(2.5F, -5.0F, -5.0F);
      this.Shape2.setTextureSize(128, 64);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 0, 0);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 5, 30, 5);
      this.Shape3.setRotationPoint(12.5F, -12.5F, 0.0F);
      this.Shape3.setTextureSize(128, 64);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 0, 0);
      this.Shape4.addBox(0.0F, 0.0F, 0.0F, 5, 5, 30);
      this.Shape4.setRotationPoint(12.5F, 0.0F, -12.5F);
      this.Shape4.setTextureSize(128, 64);
      this.Shape4.mirror = true;
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 0, 0);
      this.Shape5.addBox(0.0F, 0.0F, 0.0F, 15, 25, 15);
      this.Shape5.setRotationPoint(7.5F, -10.0F, -5.0F);
      this.Shape5.setTextureSize(128, 64);
      this.Shape5.mirror = true;
      this.setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 0, 0);
      this.Shape6.addBox(0.0F, 0.0F, 0.0F, 15, 15, 25);
      this.Shape6.setRotationPoint(7.5F, -5.0F, -10.0F);
      this.Shape6.setTextureSize(128, 64);
      this.Shape6.mirror = true;
      this.setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
      this.Shape7 = new ModelRenderer(this, 0, 0);
      this.Shape7.addBox(0.0F, 0.0F, 0.0F, 20, 20, 20);
      this.Shape7.setRotationPoint(5.0F, -7.5F, -7.5F);
      this.Shape7.setTextureSize(128, 64);
      this.Shape7.mirror = true;
      this.setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 30, 5, 5);
      this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape1.setTextureSize(128, 64);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      super.render(var1, var2, var3, var4, var5, var6, var7);
      this.setRotationAngles(var2, var3, var4, var5, var6, var7);
      this.Shape2.render(var7);
      this.Shape3.render(var7);
      this.Shape4.render(var7);
      this.Shape5.render(var7);
      this.Shape6.render(var7);
      this.Shape7.render(var7);
      this.Shape1.render(var7);
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
