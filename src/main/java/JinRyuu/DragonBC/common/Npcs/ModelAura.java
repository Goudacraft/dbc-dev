package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAura extends ModelBiped {
   ModelRenderer auro;
   public float inc = 1.6F;
   public float inc2 = 0.0F;
   public float[] offY = new float[]{-12.0F, -17.0F, -22.0F, -27.0F, -33.0F, -38.0F, -41.0F, -44.0F};
   public float[] offZ = new float[]{-8.0F, -5.5F, -3.0F, -1.5F, 0.0F, 3.0F, 5.0F, 8.0F};

   public ModelAura() {
      this.textureWidth = 64;
      this.textureHeight = 32;
      this.auro = new ModelRenderer(this, 0, 0);
      this.auro.addBox(-10.0F, -17.0F, -8.0F, 20, 20, 0);
      this.auro.setRotationPoint(0.0F, 20.0F, 0.0F);
      this.setRotation(this.auro, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
      this.auro.render(var7);
   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      float var8 = var3;
      if(var3 > var1) {
         var8 = var3 - var1;
      }

      float var9 = 100.0F / var1;
      float var10 = var8 * var9;
      var8 = var10 * 0.01F * 20.0F;
      this.auro.rotationPointY = 55.0F + var8;
      this.auro.offsetY = -var8 * 0.2F;
      this.auro.offsetZ = var8 < 8.0F?0.4F - var8 * 0.1F:-0.3F + (var8 - 7.0F) * 0.053F;
      float var11 = var8 * this.inc / 3.2F;
      this.auro.rotateAngleX = 0.8726646F - var10 * 0.01F - var2;
   }

   public void renderModel(Entity var1, float var2, float var3, float var4, float var5) {
      this.render(var1, var5, var4, var3, 0.0F, 0.0F, var2);
   }

   public int func_78104_a() {
      return 8;
   }
}
