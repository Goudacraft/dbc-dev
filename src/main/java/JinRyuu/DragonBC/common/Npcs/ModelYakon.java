package JinRyuu.DragonBC.common.Npcs;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelYakon extends ModelBiped {
   ModelRenderer head;
   ModelRenderer body;
   ModelRenderer body2;
   ModelRenderer leftarm;
   ModelRenderer leftarm1;
   ModelRenderer leftarm2;
   ModelRenderer leftarm3;
   ModelRenderer rightarm;
   ModelRenderer rightarm1;
   ModelRenderer rightarm2;
   ModelRenderer rightarm3;
   ModelRenderer leftleg;
   ModelRenderer leftleg1;
   ModelRenderer leftleg2;
   ModelRenderer leftleg3;
   ModelRenderer rightleg;
   ModelRenderer rightleg1;
   ModelRenderer rightleg2;
   ModelRenderer rightleg3;
   ModelRenderer back1;
   ModelRenderer back2;
   ModelRenderer back3;
   ModelRenderer back4;
   ModelRenderer tail;
   private float F;

   public ModelYakon(float var1) {
      this();
      this.F = var1;
   }

   public ModelYakon() {
      this.F = 1.0F;
      this.textureWidth = 128;
      this.textureHeight = 64;
      this.head = new ModelRenderer(this, 0, 0);
      this.head.addBox(-4.0F, -4.0F, -5.0F, 8, 8, 5);
      this.head.setRotationPoint(0.0F, -6.0F, -4.0F);
      this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
      this.body = new ModelRenderer(this, 0, 29);
      this.body.addBox(-4.0F, 8.0F, -2.0F, 8, 8, 4);
      this.body.setRotationPoint(0.0F, -8.0F, 0.0F);
      this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
      this.body2 = new ModelRenderer(this, 0, 13);
      this.body2.addBox(-6.0F, 0.0F, -4.0F, 12, 8, 8);
      this.body2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.body2, 0.0F, 0.0F, 0.0F);
      this.leftarm = new ModelRenderer(this, 40, 0);
      this.leftarm.addBox(0.0F, -3.0F, -3.0F, 6, 6, 6);
      this.leftarm.setRotationPoint(6.0F, -5.0F, 0.0F);
      this.leftarm.mirror = true;
      this.setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
      this.leftarm1 = new ModelRenderer(this, 40, 12);
      this.leftarm1.addBox(0.0F, 3.0F, -2.0F, 4, 7, 4);
      this.leftarm1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.leftarm1.mirror = true;
      this.setRotation(this.leftarm1, 0.0F, 0.0F, 0.0F);
      this.leftarm2 = new ModelRenderer(this, 64, 0);
      this.leftarm2.addBox(0.0F, 6.0F, -12.0F, 4, 4, 10);
      this.leftarm2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.leftarm2.mirror = true;
      this.setRotation(this.leftarm2, 0.0F, 0.0F, 0.0F);
      this.leftarm3 = new ModelRenderer(this, 56, 14);
      this.leftarm3.addBox(1.0F, 7.0F, -13.0F, 2, 2, 8);
      this.leftarm3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.leftarm3.mirror = true;
      this.setRotation(this.leftarm3, -0.1745329F, 0.0F, 0.0F);
      this.rightarm = new ModelRenderer(this, 40, 0);
      this.rightarm.addBox(-6.0F, -3.0F, -3.0F, 6, 6, 6);
      this.rightarm.setRotationPoint(-6.0F, -5.0F, 0.0F);
      this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
      this.rightarm1 = new ModelRenderer(this, 40, 12);
      this.rightarm1.addBox(-4.0F, 3.0F, -2.0F, 4, 7, 4);
      this.rightarm1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.rightarm1, 0.0F, 0.0F, 0.0F);
      this.rightarm2 = new ModelRenderer(this, 64, 0);
      this.rightarm2.addBox(-4.0F, 6.0F, -12.0F, 4, 4, 10);
      this.rightarm2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.rightarm2, 0.0F, 0.0F, 0.0F);
      this.rightarm3 = new ModelRenderer(this, 56, 14);
      this.rightarm3.addBox(-3.0F, 7.0F, -13.0F, 2, 2, 8);
      this.rightarm3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.rightarm3, -0.1745329F, 0.0F, 0.0F);
      this.leftleg = new ModelRenderer(this, 0, 41);
      this.leftleg.addBox(0.0F, -2.0F, -10.0F, 4, 4, 12);
      this.leftleg.setRotationPoint(4.0F, 8.0F, 0.0F);
      this.leftleg.mirror = true;
      this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
      this.leftleg1 = new ModelRenderer(this, 22, 47);
      this.leftleg1.addBox(0.0F, 4.0F, -9.0F, 4, 4, 10);
      this.leftleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.leftleg1.mirror = true;
      this.setRotation(this.leftleg1, -0.3490659F, 0.0F, 0.0174533F);
      this.leftleg2 = new ModelRenderer(this, 40, 42);
      this.leftleg2.addBox(0.0F, 4.0F, 1.0F, 4, 11, 4);
      this.leftleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.leftleg2.mirror = true;
      this.setRotation(this.leftleg2, -0.3665191F, 0.0F, 0.0174533F);
      this.leftleg3 = new ModelRenderer(this, 20, 39);
      this.leftleg3.addBox(0.0F, 14.0F, -8.0F, 4, 2, 6);
      this.leftleg3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.leftleg3.mirror = true;
      this.setRotation(this.leftleg3, 0.0F, 0.0F, 0.0174533F);
      this.rightleg = new ModelRenderer(this, 0, 41);
      this.rightleg.addBox(-4.0F, -2.0F, -10.0F, 4, 4, 12);
      this.rightleg.setRotationPoint(-4.0F, 8.0F, 0.0F);
      this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
      this.rightleg1 = new ModelRenderer(this, 22, 47);
      this.rightleg1.addBox(-4.0F, 4.0F, -9.0F, 4, 4, 10);
      this.rightleg1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.rightleg1, -0.3490659F, 0.0F, 0.0174533F);
      this.rightleg2 = new ModelRenderer(this, 40, 42);
      this.rightleg2.addBox(-4.0F, 4.0F, 1.0F, 4, 11, 4);
      this.rightleg2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.rightleg2, -0.3665191F, 0.0F, 0.0174533F);
      this.rightleg3 = new ModelRenderer(this, 20, 39);
      this.rightleg3.addBox(-4.0F, 14.0F, -8.0F, 4, 2, 6);
      this.rightleg3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.rightleg3, 0.0F, 0.0F, 0.0174533F);
      this.back1 = new ModelRenderer(this, 40, 32);
      this.back1.addBox(1.0F, 1.0F, 1.0F, 4, 4, 6);
      this.back1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.back1, 0.5235988F, 0.2617994F, 0.0F);
      this.back2 = new ModelRenderer(this, 40, 32);
      this.back2.addBox(-5.0F, 1.0F, 1.0F, 4, 4, 6);
      this.back2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.back2, 0.5235988F, -0.2617994F, 0.0F);
      this.back3 = new ModelRenderer(this, 40, 23);
      this.back3.addBox(1.0F, 5.0F, 1.0F, 3, 3, 6);
      this.back3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.back3, 0.2617994F, 0.2617994F, 0.0F);
      this.back4 = new ModelRenderer(this, 40, 23);
      this.back4.addBox(-4.0F, 5.0F, 2.0F, 3, 3, 6);
      this.back4.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.back4, 0.2617994F, -0.2617994F, 0.0F);
      this.tail = new ModelRenderer(this, 56, 38);
      this.tail.addBox(-2.0F, 8.0F, -3.0F, 4, 12, 4);
      this.tail.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.tail, 0.3316126F, 0.0F, 0.0F);
      this.leftarm.addChild(this.leftarm1);
      this.leftarm.addChild(this.leftarm2);
      this.leftarm.addChild(this.leftarm3);
      this.rightarm.addChild(this.rightarm1);
      this.rightarm.addChild(this.rightarm2);
      this.rightarm.addChild(this.rightarm3);
      this.leftleg.addChild(this.leftleg1);
      this.leftleg.addChild(this.leftleg2);
      this.leftleg.addChild(this.leftleg3);
      this.rightleg.addChild(this.rightleg1);
      this.rightleg.addChild(this.rightleg2);
      this.rightleg.addChild(this.rightleg3);
      this.body.addChild(this.body2);
      this.body.addChild(this.back1);
      this.body.addChild(this.back2);
      this.body.addChild(this.back3);
      this.body.addChild(this.back4);
      this.body.addChild(this.tail);
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
