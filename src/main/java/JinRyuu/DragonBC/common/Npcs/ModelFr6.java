package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelFr6 extends ModelBiped {
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;
   ModelRenderer body2;
   ModelRenderer body3;
   ModelRenderer tail1;
   ModelRenderer tail2;

   public ModelFr6() {
      this.textureWidth = 128;
      this.textureHeight = 64;
      this.head = new ModelRenderer(this, 0, 0);
      this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
      this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.head.setTextureSize(128, 64);
      this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
      this.body = new ModelRenderer(this, 64, 0);
      this.body.addBox(-5.0F, 0.0F, -2.0F, 10, 5, 5);
      this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.body.setTextureSize(128, 64);
      this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
      this.rightarm = new ModelRenderer(this, 40, 16);
      this.rightarm.addBox(-5.0F, -2.0F, -2.0F, 5, 12, 5);
      this.rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
      this.rightarm.setTextureSize(128, 64);
      this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
      this.leftarm = new ModelRenderer(this, 40, 16);
      this.leftarm.mirror = true;
      this.leftarm.addBox(0.0F, -2.0F, -2.0F, 5, 12, 5);
      this.leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
      this.leftarm.setTextureSize(128, 64);
      this.setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
      this.rightleg = new ModelRenderer(this, 0, 16);
      this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
      this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
      this.rightleg.setTextureSize(128, 64);
      this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
      this.leftleg = new ModelRenderer(this, 0, 16);
      this.leftleg.mirror = true;
      this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
      this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
      this.leftleg.setTextureSize(128, 64);
      this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
      this.body2 = new ModelRenderer(this, 64, 12);
      this.body2.addBox(-4.5F, 1.0F, -1.933333F, 9, 4, 1);
      this.body2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.body2.setTextureSize(128, 64);
      this.setRotation(this.body2, -0.1745329F, 0.0F, 0.0F);
      this.body3 = new ModelRenderer(this, 16, 16);
      this.body3.addBox(-3.5F, 5.0F, -2.0F, 7, 7, 4);
      this.body3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.body3.setTextureSize(128, 64);
      this.setRotation(this.body3, 0.0F, 0.0F, 0.0F);
      this.tail1 = new ModelRenderer(this, 32, 48);
      this.tail1.addBox(-2.0F, 7.0F, 4.0F, 4, 4, 12);
      this.tail1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.tail1.setTextureSize(128, 64);
      this.setRotation(this.tail1, -0.3490659F, 0.0F, 0.0F);
      this.tail2 = new ModelRenderer(this, 32, 48);
      this.tail2.addBox(-2.0F, 15.0F, 2.0F, 4, 4, 12);
      this.tail2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.tail2.setTextureSize(128, 64);
      this.setRotation(this.tail2, 0.5235988F, 0.0F, 0.0F);
      this.body.addChild(this.body2);
      this.body.addChild(this.body3);
      this.body.addChild(this.tail1);
      this.body.addChild(this.tail2);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
      this.head.render(var7);
      this.body.render(var7);
      this.rightarm.render(var7);
      this.leftarm.render(var7);
      this.rightleg.render(var7);
      this.leftleg.render(var7);
   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      this.head.rotateAngleY = var4 / 57.295776F;
      this.head.rotateAngleX = var5 / 57.295776F;
      this.rightarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F + 3.1415927F) * 2.0F * var2 * 0.5F;
      this.leftarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
      this.rightarm.rotateAngleZ = 0.0F;
      this.leftarm.rotateAngleZ = 0.0F;
      this.rightleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
      this.leftleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
      this.rightleg.rotateAngleY = 0.0F;
      this.leftleg.rotateAngleY = 0.0F;
      if(this.isRiding) {
         this.rightarm.rotateAngleX += -0.62831855F;
         this.leftarm.rotateAngleX += -0.62831855F;
         this.rightleg.rotateAngleX = -1.2566371F;
         this.leftleg.rotateAngleX = -1.2566371F;
         this.rightleg.rotateAngleY = 0.31415927F;
         this.leftleg.rotateAngleY = -0.31415927F;
      }

      this.rightarm.rotateAngleY = 0.0F;
      this.leftarm.rotateAngleY = 0.0F;
      if(this.onGround > -9990.0F) {
         float var8 = this.onGround;
         this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(var8) * 3.1415927F * 2.0F) * 0.2F;
         this.rightarm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
         this.rightarm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
         this.leftarm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
         this.leftarm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
         this.rightarm.rotateAngleY += this.body.rotateAngleY;
         this.leftarm.rotateAngleY += this.body.rotateAngleY;
         this.leftarm.rotateAngleX += this.body.rotateAngleY;
         var8 = 1.0F - this.onGround;
         var8 = var8 * var8;
         var8 = var8 * var8;
         var8 = 1.0F - var8;
         float var9 = MathHelper.sin(var8 * 3.1415927F);
         float var10 = MathHelper.sin(this.onGround * 3.1415927F) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
         this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)var9 * 1.2D + (double)var10));
         this.rightarm.rotateAngleY += this.body.rotateAngleY * 2.0F;
         this.rightarm.rotateAngleZ = MathHelper.sin(this.onGround * 3.1415927F) * -0.4F;
      }

      this.rightarm.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
      this.leftarm.rotateAngleZ -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
      this.rightarm.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
      this.leftarm.rotateAngleX -= MathHelper.sin(var3 * 0.067F) * 0.05F;
   }
}
