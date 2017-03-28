package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKiMakanko extends ModelBiped {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape5;
   ModelRenderer Shape6;
   ModelRenderer Shape7;
   ModelRenderer Shape8;
   ModelRenderer Shape9;

   public ModelKiMakanko() {
      this.textureWidth = 128;
      this.textureHeight = 128;
      this.Shape1 = new ModelRenderer(this, 0, 8);
      this.Shape1.addBox(-3.0F, -3.0F, -7.0F, 6, 6, 14);
      this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape1.setTextureSize(128, 128);
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 0, 8);
      this.Shape2.addBox(-2.0F, -2.0F, -8.0F, 4, 4, 16);
      this.Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape2.setTextureSize(128, 128);
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 0, 8);
      this.Shape3.addBox(-2.0F, -4.0F, -6.0F, 4, 8, 12);
      this.Shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape3.setTextureSize(128, 128);
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 0, 8);
      this.Shape4.addBox(-4.0F, -2.0F, -6.0F, 8, 4, 12);
      this.Shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape4.setTextureSize(128, 128);
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape5 = new ModelRenderer(this, 0, 0);
      this.Shape5.addBox(6.0F, -3.0F, -5.0F, 1, 6, 1);
      this.Shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape5.setTextureSize(128, 128);
      this.setRotation(this.Shape5, -0.3490659F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 0, 0);
      this.Shape6.addBox(7.0F, -3.0F, -3.0F, 1, 6, 1);
      this.Shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape6.setTextureSize(128, 128);
      this.setRotation(this.Shape6, -0.3490659F, 0.0F, -0.7853982F);
      this.Shape7 = new ModelRenderer(this, 0, 0);
      this.Shape7.addBox(-3.533333F, -8.2F, -0.5333334F, 7, 1, 1);
      this.Shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape7.setTextureSize(128, 128);
      this.setRotation(this.Shape7, 0.0F, 0.4537856F, 0.0F);
      this.Shape8 = new ModelRenderer(this, 0, 0);
      this.Shape8.addBox(-3.0F, -8.0F, -0.4666667F, 6, 1, 1);
      this.Shape8.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape8.setTextureSize(128, 128);
      this.setRotation(this.Shape8, 0.0F, 0.4014257F, -0.7853982F);
      this.Shape9 = new ModelRenderer(this, 0, 0);
      this.Shape9.addBox(-7.0F, -3.0F, 3.0F, 1, 6, 1);
      this.Shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape9.setTextureSize(128, 128);
      this.setRotation(this.Shape9, 0.3490659F, 0.0F, 0.0F);
      this.Shape1.addChild(this.Shape2);
      this.Shape1.addChild(this.Shape3);
      this.Shape1.addChild(this.Shape4);
      this.Shape7.addChild(this.Shape5);
      this.Shape7.addChild(this.Shape6);
      this.Shape7.addChild(this.Shape8);
      this.Shape7.addChild(this.Shape9);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
      this.Shape1.render(var7);
      this.Shape7.render(var7);
   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      float var9 = 1.0F;
      this.Shape1.rotateAngleZ = var3;
      this.Shape7.rotateAngleZ = -var3;
   }

   public void renderModel(Entity var1, float var2, float var3, float var4, float var5) {
      this.render(var1, 0.0F, 0.0F, var5, var2, var3, var4);
   }
}
