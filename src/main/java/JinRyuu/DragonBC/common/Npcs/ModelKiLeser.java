package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelKiLeser extends ModelBiped {
   ModelRenderer Shape1;

   public ModelKiLeser() {
      this.textureWidth = 128;
      this.textureHeight = 128;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.addBox(-1.0F, -1.0F, -10.0F, 2, 2, 20);
      this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape1.setTextureSize(128, 128);
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
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
      this.Shape1.rotationPointZ = var3;
      this.Shape1.rotateAngleZ = var3;
   }

   public void renderModel(Entity var1, float var2, float var3, float var4, float var5) {
      this.render(var1, 0.0F, 0.0F, var5, var2, var3, var4);
   }
}
