package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelDBCZed extends ModelBiped {
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer rightarm;
   ModelRenderer leftarm;
   ModelRenderer rightleg;
   ModelRenderer leftleg;
   public ModelRenderer bipedHeadAll;
   public ModelRenderer goku1;
   public ModelRenderer goku2;
   public ModelRenderer goku3;
   public ModelRenderer goku4;
   public ModelRenderer goku5;
   public ModelRenderer goku6;
   public ModelRenderer goku7;
   public ModelRenderer goku8;
   public ModelRenderer goku9;
   public ModelRenderer goku10;
   public ModelRenderer goku11;
   public ModelRenderer goku12;
   public ModelRenderer goku13;
   public ModelRenderer goku14;
   public ModelRenderer goku15;
   public ModelRenderer goku16;
   private float F;

   public ModelDBCZed(float var1) {
      this();
      this.F = var1;
   }

   public ModelDBCZed() {
      this.F = 1.0F;
      this.textureWidth = 128;
      this.textureHeight = 64;
      this.head = new ModelRenderer(this, 0, 0);
      this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
      this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.head.setTextureSize(128, 64);
      this.body = new ModelRenderer(this, 16, 16);
      this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
      this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.body.setTextureSize(128, 64);
      this.rightarm = new ModelRenderer(this, 40, 16);
      this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4);
      this.rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
      this.rightarm.setTextureSize(128, 64);
      this.leftarm = new ModelRenderer(this, 40, 16);
      this.leftarm.mirror = true;
      this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4);
      this.leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
      this.leftarm.setTextureSize(128, 64);
      this.rightleg = new ModelRenderer(this, 0, 16);
      this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
      this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
      this.rightleg.setTextureSize(128, 64);
      this.leftleg = new ModelRenderer(this, 0, 16);
      this.leftleg.mirror = true;
      this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
      this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
      this.leftleg.setTextureSize(128, 64);
      this.goku1 = new ModelRenderer(this, 64, 0);
      this.goku1.addBox(-1.0F, -10.0F, 0.0F, 4, 4, 4);
      this.goku1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku1.setTextureSize(128, 64);
      this.setRotation(this.goku1, 0.1745329F, 0.0F, -0.4363323F);
      this.goku2 = new ModelRenderer(this, 64, 0);
      this.goku2.addBox(-8.0F, -4.5F, 0.0F, 4, 3, 3);
      this.goku2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku2.setTextureSize(128, 64);
      this.setRotation(this.goku2, 0.0F, -0.1745329F, 0.3490659F);
      this.goku3 = new ModelRenderer(this, 64, 0);
      this.goku3.addBox(-7.0F, -2.6F, 1.0F, 4, 2, 2);
      this.goku3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku3.setTextureSize(128, 64);
      this.setRotation(this.goku3, 0.0F, -0.2617994F, 0.1943133F);
      this.goku4 = new ModelRenderer(this, 64, 0);
      this.goku4.addBox(3.0F, -4.0F, 0.0F, 4, 3, 3);
      this.goku4.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku4.setTextureSize(128, 64);
      this.setRotation(this.goku4, 0.0F, 0.1745329F, -0.3490659F);
      this.goku5 = new ModelRenderer(this, 64, 0);
      this.goku5.addBox(3.0F, -2.3F, 0.7F, 3, 2, 2);
      this.goku5.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku5.setTextureSize(128, 64);
      this.setRotation(this.goku5, 0.0F, 0.1745329F, -0.1151917F);
      this.goku6 = new ModelRenderer(this, 64, 0);
      this.goku6.addBox(5.0F, -4.3F, 1.5F, 3, 2, 2);
      this.goku6.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku6.setTextureSize(128, 64);
      this.setRotation(this.goku6, 0.0F, 0.3490659F, -0.2617994F);
      this.goku7 = new ModelRenderer(this, 64, 0);
      this.goku7.addBox(1.0F, -11.0F, 2.0F, 3, 3, 3);
      this.goku7.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku7.setTextureSize(128, 64);
      this.setRotation(this.goku7, 0.3490659F, 0.0F, -0.6108652F);
      this.goku8 = new ModelRenderer(this, 64, 0);
      this.goku8.addBox(3.0F, -12.0F, 4.0F, 2, 3, 2);
      this.goku8.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku8.setTextureSize(128, 64);
      this.setRotation(this.goku8, 0.5235988F, 0.0F, -0.7853982F);
      this.goku9 = new ModelRenderer(this, 64, 0);
      this.goku9.addBox(-9.0F, -4.7F, 1.5F, 3, 2, 2);
      this.goku9.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku9.setTextureSize(128, 64);
      this.setRotation(this.goku9, 0.0F, -0.3490659F, 0.2617994F);
      this.goku10 = new ModelRenderer(this, 64, 0);
      this.goku10.addBox(-10.0F, -4.8F, 1.0F, 5, 2, 2);
      this.goku10.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku10.setTextureSize(128, 64);
      this.setRotation(this.goku10, 0.0F, -0.3839724F, 0.5270894F);
      this.goku11 = new ModelRenderer(this, 64, 0);
      this.goku11.addBox(1.0F, -8.0F, 5.0F, 1, 4, 1);
      this.goku11.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku11.setTextureSize(128, 64);
      this.setRotation(this.goku11, 0.6806784F, 0.0F, -0.1745329F);
      this.goku12 = new ModelRenderer(this, 64, 0);
      this.goku12.addBox(-3.5F, -7.0F, -5.0F, 2, 3, 3);
      this.goku12.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku12.setTextureSize(128, 64);
      this.setRotation(this.goku12, 0.0F, 0.0F, 0.4014257F);
      this.goku13 = new ModelRenderer(this, 64, 0);
      this.goku13.addBox(-6.2F, -5.5F, -5.0F, 2, 3, 2);
      this.goku13.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku13.setTextureSize(128, 64);
      this.setRotation(this.goku13, 0.0F, 0.0F, 0.5235988F);
      this.goku14 = new ModelRenderer(this, 64, 0);
      this.goku14.addBox(-7.5F, -4.0F, -5.0F, 1, 3, 2);
      this.goku14.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku14.setTextureSize(128, 64);
      this.setRotation(this.goku14, 0.0F, 0.0F, 0.6108652F);
      this.goku15 = new ModelRenderer(this, 64, 0);
      this.goku15.addBox(3.2F, -6.5F, -5.0F, 2, 3, 2);
      this.goku15.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku15.setTextureSize(128, 64);
      this.setRotation(this.goku15, 0.0F, 0.0F, -0.3490659F);
      this.goku16 = new ModelRenderer(this, 64, 0);
      this.goku16.addBox(6.5F, -4.5F, -5.0F, 1, 3, 2);
      this.goku16.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.goku16.setTextureSize(128, 64);
      this.setRotation(this.goku16, 0.0F, 0.0F, -0.6108652F);
      this.bipedHeadAll = new ModelRenderer(this, 0, 0);
      this.bipedHeadAll.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.01F);
      this.bipedHeadAll.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.head.addChild(this.bipedHeadAll);
      this.head.addChild(this.goku1);
      this.head.addChild(this.goku2);
      this.head.addChild(this.goku3);
      this.head.addChild(this.goku4);
      this.head.addChild(this.goku5);
      this.head.addChild(this.goku6);
      this.head.addChild(this.goku7);
      this.head.addChild(this.goku8);
      this.head.addChild(this.goku9);
      this.head.addChild(this.goku10);
      this.head.addChild(this.goku11);
      this.head.addChild(this.goku12);
      this.head.addChild(this.goku13);
      this.head.addChild(this.goku14);
      this.head.addChild(this.goku15);
      this.head.addChild(this.goku16);
   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
      GL11.glPushMatrix();
      GL11.glScalef(this.F, this.F, this.F);
      GL11.glTranslatef(0.0F, (this.F - 1.0F) * -0.74F, 0.0F);
      this.head.render(var7);
      this.body.render(var7);
      this.rightarm.render(var7);
      this.leftarm.render(var7);
      this.rightleg.render(var7);
      this.leftleg.render(var7);
      GL11.glPopMatrix();
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
