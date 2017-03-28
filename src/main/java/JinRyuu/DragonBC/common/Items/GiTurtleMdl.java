package JinRyuu.DragonBC.common.Items;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class GiTurtleMdl extends ModelBiped {
   ModelRenderer leftarmshoulder;
   ModelRenderer rightarmshoulder = new ModelRenderer(this, 40, 32);
   ModelRenderer cape;
   ModelRenderer c20;
   ModelRenderer c19;

   public GiTurtleMdl(float var1) {
      super(var1, 0.0F, 128, 64);
      this.rightarmshoulder.addBox(-3.0F, -5.0F, -3.0F, 7, 4, 6);
      this.rightarmshoulder.setRotationPoint(-5.0F, 2.0F, 0.0F);
      this.rightarmshoulder.setTextureSize(128, 64);
      this.setRotation(this.rightarmshoulder, 0.0F, 0.0F, 0.1570796F);
      this.leftarmshoulder = new ModelRenderer(this, 40, 32);
      this.leftarmshoulder.mirror = true;
      this.leftarmshoulder.addBox(-4.0F, -5.0F, -3.0F, 7, 4, 6);
      this.leftarmshoulder.setRotationPoint(5.0F, 2.0F, 0.0F);
      this.leftarmshoulder.setTextureSize(128, 64);
      this.setRotation(this.leftarmshoulder, 0.0F, 0.0F, -0.1570796F);
      this.cape = new ModelRenderer(this, 100, 0);
      this.cape.addBox(-7.0F, 1.0F, 2.0F, 14, 20, 0, var1);
      this.cape.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.cape.setTextureSize(128, 64);
      this.setRotation(this.cape, 0.1570796F, 0.0F, 0.0F);
      this.c20 = new ModelRenderer(this, 76, 35);
      this.c20.addBox(-4.0F, -12.0F, -4.0F, 8, 4, 8, var1);
      this.c20.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.c20.setTextureSize(128, 64);
      this.c20.mirror = true;
      this.setRotation(this.c20, 0.0F, 0.0F, 0.0F);
      this.c19 = new ModelRenderer(this, 106, 29);
      this.c19.addBox(-1.0F, -11.0F, -0.5F, 2, 4, 2, var1);
      this.c19.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.c19.setTextureSize(128, 64);
      this.c19.mirror = true;
      this.setRotation(this.c19, 0.0F, 0.0F, 0.0F);
      this.bipedHead.addChild(this.c20);
      this.bipedHead.addChild(this.c19);
      this.bipedBody.addChild(this.cape);
      this.bipedLeftArm.addChild(this.leftarmshoulder);
      this.bipedRightArm.addChild(this.rightarmshoulder);
   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void setRotationPub(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      super.render(var1, var2, var3, var4, var5, var6, var7);
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
   }
}
