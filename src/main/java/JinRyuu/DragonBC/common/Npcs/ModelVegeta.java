package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelVegeta extends ModelBiped {
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;
   ModelRenderer leftarmshoulder;
   ModelRenderer rightarmshoulder;
   ModelRenderer hair1;
   ModelRenderer hair2;
   ModelRenderer hair3;
   ModelRenderer hair4;
   ModelRenderer hea5;
   ModelRenderer hea6;

   public ModelVegeta() {
      this.textureWidth = 128;
      this.textureHeight = 64;
      this.head = new ModelRenderer(this, 0, 0);
      this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
      this.head.setRotationPoint(0.0F, 2.0F, 0.0F);
      this.head.setTextureSize(128, 64);
      this.body = new ModelRenderer(this, 16, 16);
      this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 11, 4);
      this.body.setRotationPoint(0.0F, 2.0F, 0.0F);
      this.body.setTextureSize(128, 64);
      this.rightarm = new ModelRenderer(this, 40, 16);
      this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 11, 4);
      this.rightarm.setRotationPoint(-5.0F, 4.0F, 0.0F);
      this.rightarm.setTextureSize(128, 64);
      this.leftarm = new ModelRenderer(this, 40, 16);
      this.leftarm.mirror = true;
      this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 11, 4);
      this.leftarm.setRotationPoint(5.0F, 4.0F, 0.0F);
      this.leftarm.setTextureSize(128, 64);
      this.rightleg = new ModelRenderer(this, 0, 16);
      this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4);
      this.rightleg.setRotationPoint(-2.0F, 13.0F, 0.0F);
      this.rightleg.setTextureSize(128, 64);
      this.leftleg = new ModelRenderer(this, 0, 16);
      this.leftleg.mirror = true;
      this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4);
      this.leftleg.setRotationPoint(2.0F, 13.0F, 0.0F);
      this.leftleg.setTextureSize(128, 64);
      this.rightarmshoulder = new ModelRenderer(this, 40, 32);
      this.rightarmshoulder.addBox(-6.0F, -3.0F, -3.0F, 7, 4, 6);
      this.rightarmshoulder.setRotationPoint(-5.0F, 4.0F, 0.0F);
      this.rightarmshoulder.setTextureSize(128, 64);
      this.leftarmshoulder = new ModelRenderer(this, 40, 32);
      this.leftarmshoulder.mirror = true;
      this.leftarmshoulder.addBox(-1.0F, -3.0F, -3.0F, 7, 4, 6);
      this.leftarmshoulder.setRotationPoint(5.0F, 4.0F, 0.0F);
      this.leftarmshoulder.setTextureSize(128, 64);
      this.hair1 = new ModelRenderer(this, 32, 0);
      this.hair1.addBox(-4.0F, -10.0F, -6.0F, 8, 4, 8);
      this.hair1.setRotationPoint(0.0F, 2.0F, 0.0F);
      this.hair1.setTextureSize(128, 64);
      this.hair2 = new ModelRenderer(this, 64, 0);
      this.hair2.addBox(-3.0F, -12.0F, -7.0F, 6, 4, 6);
      this.hair2.setRotationPoint(0.0F, 2.0F, 0.0F);
      this.hair2.setTextureSize(128, 64);
      this.hair3 = new ModelRenderer(this, 88, 0);
      this.hair3.addBox(-2.0F, -13.0F, -8.0F, 4, 4, 4);
      this.hair3.setRotationPoint(0.0F, 2.0F, 0.0F);
      this.hair3.setTextureSize(128, 64);
      this.hair4 = new ModelRenderer(this, 104, 0);
      this.hair4.addBox(-1.0F, -15.0F, -7.0F, 2, 4, 2);
      this.hair4.setRotationPoint(0.0F, 2.0F, 0.0F);
      this.hair4.setTextureSize(128, 64);
      this.hea5 = new ModelRenderer(this, 112, 0);
      this.hea5.addBox(-1.0F, -15.5F, 3.5F, 2, 8, 2);
      this.hea5.setRotationPoint(0.0F, 2.0F, 0.0F);
      this.hea5.setTextureSize(128, 64);
      this.hea6 = new ModelRenderer(this, 56, 12);
      this.hea6.addBox(-5.0F, -6.0F, -7.0F, 10, 2, 8);
      this.hea6.setRotationPoint(0.0F, 2.0F, 0.0F);
      this.hea6.setTextureSize(128, 64);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
      this.head.render(var7);
      this.body.render(var7);
      this.rightarm.render(var7);
      this.leftarm.render(var7);
      this.rightleg.render(var7);
      this.leftleg.render(var7);
      this.leftarmshoulder.render(var7);
      this.rightarmshoulder.render(var7);
      this.hair1.render(var7);
      this.hair2.render(var7);
      this.hair3.render(var7);
      this.hair4.render(var7);
      this.hea5.render(var7);
      this.hea6.render(var7);
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      this.head.rotateAngleY = var4 / 57.295776F;
      this.head.rotateAngleX = var5 / 57.295776F;
      this.hair1.rotateAngleY = this.head.rotateAngleY;
      this.hair1.rotateAngleX = -0.296706F + this.head.rotateAngleX;
      this.hair2.rotateAngleY = this.head.rotateAngleY;
      this.hair2.rotateAngleX = -0.4537856F + this.head.rotateAngleX;
      this.hair3.rotateAngleY = this.head.rotateAngleY;
      this.hair3.rotateAngleX = -0.6108652F + this.head.rotateAngleX;
      this.hair4.rotateAngleY = this.head.rotateAngleY;
      this.hair4.rotateAngleX = -0.5934119F + this.head.rotateAngleX;
      this.hea5.rotateAngleY = this.head.rotateAngleY;
      this.hea5.rotateAngleX = 0.1047198F + this.head.rotateAngleX;
      this.hea6.rotateAngleY = this.head.rotateAngleY;
      this.hea6.rotateAngleX = -0.5585054F + this.head.rotateAngleX;
      this.rightarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F + 3.1415927F) * 2.0F * var2 * 0.5F;
      this.rightarmshoulder.rotateAngleX = this.rightarm.rotateAngleX;
      this.leftarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
      this.leftarmshoulder.rotateAngleX = this.leftarm.rotateAngleX;
      this.rightarm.rotateAngleZ = 0.0F;
      this.rightarmshoulder.rotateAngleZ = this.rightarm.rotateAngleZ;
      this.leftarm.rotateAngleZ = 0.0F;
      this.leftarmshoulder.rotateAngleZ = this.leftarm.rotateAngleZ;
      this.rightleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
      this.leftleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
      this.rightleg.rotateAngleY = 0.0F;
      this.leftleg.rotateAngleY = 0.0F;
      if(this.isRiding) {
         this.rightarm.rotateAngleX += -0.62831855F;
         this.rightarmshoulder.rotateAngleX = this.rightarm.rotateAngleX;
         this.leftarm.rotateAngleX += -0.62831855F;
         this.leftarmshoulder.rotateAngleX = this.leftarm.rotateAngleX;
         this.rightleg.rotateAngleX = -1.2566371F;
         this.leftleg.rotateAngleX = -1.2566371F;
         this.rightleg.rotateAngleY = 0.31415927F;
         this.leftleg.rotateAngleY = -0.31415927F;
      }

      this.rightarm.rotateAngleY = 0.0F;
      this.rightarmshoulder.rotateAngleY = this.rightarm.rotateAngleY;
      this.leftarm.rotateAngleY = 0.0F;
      this.leftarmshoulder.rotateAngleY = this.leftarm.rotateAngleY;
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
         this.rightarmshoulder.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
         this.rightarmshoulder.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
         this.leftarmshoulder.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
         this.leftarmshoulder.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
         this.rightarmshoulder.rotateAngleY += this.body.rotateAngleY;
         this.leftarmshoulder.rotateAngleY += this.body.rotateAngleY;
         this.leftarmshoulder.rotateAngleX += this.body.rotateAngleY;
         var8 = 1.0F - this.onGround;
         var8 = var8 * var8;
         var8 = var8 * var8;
         var8 = 1.0F - var8;
         float var9 = MathHelper.sin(var8 * 3.1415927F);
         float var10 = MathHelper.sin(this.onGround * 3.1415927F) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
         this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)var9 * 1.2D + (double)var10));
         this.rightarm.rotateAngleY += this.body.rotateAngleY * 2.0F;
         this.rightarm.rotateAngleZ = MathHelper.sin(this.onGround * 3.1415927F) * -0.4F;
         this.rightarmshoulder.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)var9 * 1.2D + (double)var10));
         this.rightarmshoulder.rotateAngleY += this.body.rotateAngleY * 2.0F;
         this.rightarmshoulder.rotateAngleZ = MathHelper.sin(this.onGround * 3.1415927F) * -0.4F;
      }

      this.rightarm.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
      this.rightarmshoulder.rotateAngleZ = this.rightarm.rotateAngleZ;
      this.leftarm.rotateAngleZ -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
      this.leftarmshoulder.rotateAngleZ = this.leftarm.rotateAngleZ;
      this.rightarm.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
      this.rightarmshoulder.rotateAngleX = this.rightarm.rotateAngleX;
      this.leftarm.rotateAngleX -= MathHelper.sin(var3 * 0.067F) * 0.05F;
      this.leftarmshoulder.rotateAngleX = this.leftarm.rotateAngleX;
   }
}
