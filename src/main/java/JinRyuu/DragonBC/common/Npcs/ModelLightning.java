package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLightning extends ModelBiped {
   ModelRenderer Shape1;
   ModelRenderer Shape2;

   public ModelLightning() {
      this.textureWidth = 256;
      this.textureHeight = 128;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16);
      this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape1.setTextureSize(64, 32);
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 0, 42);
      this.Shape2.addBox(-15.0F, -15.0F, -15.0F, 30, 30, 30);
      this.Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape2.setTextureSize(64, 32);
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
      this.Shape1.render(var7);
      this.Shape2.render(var7);
   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      float var9 = 1.0F;
      this.Shape1.rotationPointY = 3.0F;
      this.Shape1.rotateAngleY = var3 * 2.0F;
      this.Shape2.rotationPointY = 3.0F;
      this.Shape2.rotateAngleY = -var3 * 2.0F;
      this.Shape2.rotateAngleX = -var3 / 3.0F;
      this.Shape2.rotateAngleZ = -var3 / 3.0F;
      this.Shape1.rotateAngleX = -var3 / 3.0F;
      this.Shape1.rotateAngleZ = -var3 / 3.0F;
   }

   public void renderModel(Entity var1, float var2, float var3, float var4, float var5) {
      this.render(var1, 0.0F, 0.0F, var5, var2, var3, var4);
   }
}
