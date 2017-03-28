package JinRyuu.DragonBC.common.Render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class hair extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape5;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape6;
   ModelRenderer Shape7;
   ModelRenderer Shape8;
   ModelRenderer Shape9;

   public hair() {
      this.textureWidth = 128;
      this.textureHeight = 128;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16);
      this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape1.setTextureSize(128, 128);
      this.Shape1.mirror = true;
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 0, 32);
      this.Shape5.addBox(0.0F, 0.0F, 0.0F, 7, 7, 10);
      this.Shape5.setRotationPoint(6.0F, 0.0F, 9.0F);
      this.Shape5.setTextureSize(128, 128);
      this.Shape5.mirror = true;
      this.setRotation(this.Shape5, 1.27409F, 0.3141593F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 64, 0);
      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 5, 5, 10);
      this.Shape3.setRotationPoint(8.0F, 4.0F, -6.0F);
      this.Shape3.setTextureSize(128, 128);
      this.Shape3.mirror = true;
      this.setRotation(this.Shape3, -0.2268928F, -0.2617994F, 0.0F);
      this.Shape3.mirror = false;
      this.Shape4 = new ModelRenderer(this, 64, 0);
      this.Shape4.addBox(0.0F, 0.0F, 0.0F, 5, 5, 10);
      this.Shape4.setRotationPoint(7.0F, 10.0F, -7.0F);
      this.Shape4.setTextureSize(128, 128);
      this.Shape4.mirror = true;
      this.setRotation(this.Shape4, -0.1047198F, -0.1396263F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 0, 32);
      this.Shape6.addBox(0.0F, 0.0F, 0.0F, 7, 7, 10);
      this.Shape6.setRotationPoint(6.0F, 2.0F, 12.0F);
      this.Shape6.setTextureSize(128, 128);
      this.Shape6.mirror = true;
      this.setRotation(this.Shape6, 0.5410521F, 0.296706F, 0.0F);
      this.Shape7 = new ModelRenderer(this, 0, 49);
      this.Shape7.addBox(0.0F, 0.0F, 0.0F, 5, 5, 8);
      this.Shape7.setRotationPoint(6.0F, 8.0F, 15.0F);
      this.Shape7.setTextureSize(128, 128);
      this.Shape7.mirror = true;
      this.setRotation(this.Shape7, 0.0698132F, 0.296706F, 0.0F);
      this.Shape8 = new ModelRenderer(this, 0, 62);
      this.Shape8.addBox(0.0F, 0.0F, 0.0F, 4, 4, 8);
      this.Shape8.setRotationPoint(8.0F, -8.0F, 12.0F);
      this.Shape8.setTextureSize(128, 128);
      this.Shape8.mirror = true;
      this.setRotation(this.Shape8, 0.8028515F, 0.296706F, 0.0F);
      this.Shape9 = new ModelRenderer(this, 0, 62);
      this.Shape9.addBox(0.0F, 0.0F, 0.0F, 4, 4, 8);
      this.Shape9.setRotationPoint(10.0F, -2.0F, 19.0F);
      this.Shape9.setTextureSize(128, 128);
      this.Shape9.mirror = true;
      this.setRotation(this.Shape9, 0.2094395F, 0.296706F, 0.0F);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      super.render(var1, var2, var3, var4, var5, var6, var7);
      this.Shape1.render(var7);
      this.Shape5.render(var7);
      this.Shape3.render(var7);
      this.Shape4.render(var7);
      this.Shape6.render(var7);
      this.Shape7.render(var7);
      this.Shape8.render(var7);
      this.Shape9.render(var7);
   }

   public void renderModel(float var1) {
      this.Shape1.render(var1);
      this.Shape3.render(var1);
      this.Shape4.render(var1);
      this.Shape5.render(var1);
      this.Shape6.render(var1);
      this.Shape7.render(var1);
      this.Shape8.render(var1);
      this.Shape9.render(var1);
   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }
}
