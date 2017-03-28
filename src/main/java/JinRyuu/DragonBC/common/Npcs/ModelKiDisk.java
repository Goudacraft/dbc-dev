package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKiDisk extends ModelBiped {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;

   public ModelKiDisk() {
      this.textureWidth = 128;
      this.textureHeight = 32;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.addBox(-10.0F, -1.0F, -10.0F, 20, 2, 20);
      this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape1.setTextureSize(128, 32);
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 0, 0);
      this.Shape2.addBox(-7.0F, -0.5F, -12.0F, 14, 1, 24);
      this.Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape2.setTextureSize(128, 32);
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 0, 0);
      this.Shape3.addBox(-12.0F, -0.5F, -7.0F, 24, 1, 14);
      this.Shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape3.setTextureSize(128, 32);
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape1.addChild(this.Shape2);
      this.Shape1.addChild(this.Shape3);
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
      this.Shape1.rotateAngleY = 2.0F + var3;
   }

   public void renderModel(Entity var1, float var2, float var3, float var4, float var5) {
      this.render(var1, 0.0F, 0.0F, var5, var2, var3, var4);
   }
}
