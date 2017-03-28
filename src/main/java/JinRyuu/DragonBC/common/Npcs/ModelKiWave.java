package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKiWave extends ModelBiped {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;

   public ModelKiWave() {
      this.textureWidth = 128;
      this.textureHeight = 128;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
      this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape1.setTextureSize(128, 128);
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 0, 0);
      this.Shape2.addBox(-3.0F, -3.0F, -5.0F, 6, 6, 10);
      this.Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape2.setTextureSize(128, 128);
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 0, 0);
      this.Shape3.addBox(-3.0F, -5.0F, -3.0F, 6, 10, 6);
      this.Shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape3.setTextureSize(128, 128);
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 0, 0);
      this.Shape4.addBox(-5.0F, -3.0F, -3.0F, 10, 6, 6);
      this.Shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape4.setTextureSize(128, 128);
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape1.addChild(this.Shape2);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
      this.Shape1.render(var7);
   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      float var9 = 1.0F;
      this.Shape1.rotateAngleZ = var3;
   }

   public void renderModel(Entity var1, float var2, float var3, float var4, float var5) {
      this.render(var1, 0.0F, 0.0F, var5, var2, var3, var4);
   }
}
