package JinRyuu.DragonBC.common.Render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ArtGravDevModel extends ModelBase {
   ModelRenderer bottom;

   public ArtGravDevModel() {
      this.textureWidth = 128;
      this.textureHeight = 32;
      this.bottom = new ModelRenderer(this, 0, 0);
      this.bottom.addBox(-8.0F, -16.0F, -8.0F, 16, 16, 16);
      this.bottom.setRotationPoint(0.0F, 24.0F, 0.0F);
      this.bottom.setTextureSize(128, 32);
      this.setRotation(this.bottom, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      super.render(var1, var2, var3, var4, var5, var6, var7);
      this.setRotationAngles(var2, var3, var4, var5, var6, var7);
      this.bottom.render(var7);
   }

   public void renderModel(float var1) {
      this.bottom.render(var1);
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
