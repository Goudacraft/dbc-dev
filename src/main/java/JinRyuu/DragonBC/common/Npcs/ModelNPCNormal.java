package JinRyuu.DragonBC.common.Npcs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ModelNPCNormal extends ModelBiped {
   public ModelRenderer bipedHead;
   public ModelRenderer bipedHeadwear;
   public ModelRenderer bipedBody;
   public ModelRenderer bipedRightArm;
   public ModelRenderer bipedLeftArm;
   public ModelRenderer bipedRightLeg;
   public ModelRenderer bipedLeftLeg;
   public ModelRenderer bipedEars;
   public ModelRenderer bipedCloak;
   public int heldItemLeft;
   public int heldItemRight;
   public boolean isSneak;
   public boolean aimedBow;

   public ModelNPCNormal() {
      this(0.0F);
   }

   public ModelNPCNormal(float var1) {
      this(var1, 0.0F, 64, 32);
   }

   public ModelNPCNormal(float var1, float var2, int var3, int var4) {
      this.heldItemLeft = 0;
      this.heldItemRight = 0;
      this.isSneak = false;
      this.aimedBow = false;
      this.textureWidth = var3;
      this.textureHeight = var4;
      this.bipedCloak = new ModelRenderer(this, 0, 0);
      this.bipedCloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, var1);
      this.bipedEars = new ModelRenderer(this, 24, 0);
      this.bipedEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, var1);
      this.bipedHead = new ModelRenderer(this, 0, 0);
      this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, var1);
      this.bipedHead.setRotationPoint(0.0F, 0.0F + var2, 0.0F);
      this.bipedHeadwear = new ModelRenderer(this, 32, 0);
      this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, var1 + 0.5F);
      this.bipedHeadwear.setRotationPoint(0.0F, 0.0F + var2, 0.0F);
      this.bipedBody = new ModelRenderer(this, 16, 16);
      this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, var1);
      this.bipedBody.setRotationPoint(0.0F, 0.0F + var2, 0.0F);
      this.bipedRightArm = new ModelRenderer(this, 40, 16);
      this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, var1);
      this.bipedRightArm.setRotationPoint(-5.0F, 2.0F + var2, 0.0F);
      this.bipedLeftArm = new ModelRenderer(this, 40, 16);
      this.bipedLeftArm.mirror = true;
      this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, var1);
      this.bipedLeftArm.setRotationPoint(5.0F, 2.0F + var2, 0.0F);
      this.bipedRightLeg = new ModelRenderer(this, 0, 16);
      this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1);
      this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F + var2, 0.0F);
      this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
      this.bipedLeftLeg.mirror = true;
      this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1);
      this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F + var2, 0.0F);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
      if(this.isChild) {
         float var8 = 2.0F;
         GL11.glPushMatrix();
         GL11.glScalef(1.5F / var8, 1.5F / var8, 1.5F / var8);
         GL11.glTranslatef(0.0F, 16.0F * var7, 0.0F);
         this.bipedHead.render(var7);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glScalef(1.0F / var8, 1.0F / var8, 1.0F / var8);
         GL11.glTranslatef(0.0F, 24.0F * var7, 0.0F);
         this.bipedBody.render(var7);
         this.bipedRightArm.render(var7);
         this.bipedLeftArm.render(var7);
         this.bipedRightLeg.render(var7);
         this.bipedLeftLeg.render(var7);
         this.bipedHeadwear.render(var7);
         GL11.glPopMatrix();
      } else {
         this.bipedHead.render(var7);
         this.bipedBody.render(var7);
         this.bipedRightArm.render(var7);
         this.bipedLeftArm.render(var7);
         this.bipedRightLeg.render(var7);
         this.bipedLeftLeg.render(var7);
         this.bipedHeadwear.render(var7);
      }

   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      this.bipedHead.rotateAngleY = var4 / 57.295776F;
      this.bipedHead.rotateAngleX = var5 / 57.295776F;
      this.bipedHeadwear.rotateAngleY = this.bipedHead.rotateAngleY;
      this.bipedHeadwear.rotateAngleX = this.bipedHead.rotateAngleX;
      this.bipedRightArm.rotateAngleX = MathHelper.cos(var1 * 0.6662F + 3.1415927F) * 2.0F * var2 * 0.5F;
      this.bipedLeftArm.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
      this.bipedRightArm.rotateAngleZ = 0.0F;
      this.bipedLeftArm.rotateAngleZ = 0.0F;
      this.bipedRightLeg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
      this.bipedLeftLeg.rotateAngleX = MathHelper.cos(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
      this.bipedRightLeg.rotateAngleY = 0.0F;
      this.bipedLeftLeg.rotateAngleY = 0.0F;
      if(this.isRiding) {
         this.bipedRightArm.rotateAngleX += -0.62831855F;
         this.bipedLeftArm.rotateAngleX += -0.62831855F;
         this.bipedRightLeg.rotateAngleX = -1.2566371F;
         this.bipedLeftLeg.rotateAngleX = -1.2566371F;
         this.bipedRightLeg.rotateAngleY = 0.31415927F;
         this.bipedLeftLeg.rotateAngleY = -0.31415927F;
      }

      if(this.heldItemLeft != 0) {
         this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - 0.31415927F * (float)this.heldItemLeft;
      }

      if(this.heldItemRight != 0) {
         this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - 0.31415927F * (float)this.heldItemRight;
      }

      this.bipedRightArm.rotateAngleY = 0.0F;
      this.bipedLeftArm.rotateAngleY = 0.0F;
      if(this.onGround > -9990.0F) {
         float var8 = this.onGround;
         this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(var8) * 3.1415927F * 2.0F) * 0.2F;
         this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
         this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
         this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
         this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
         this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
         this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
         this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
         var8 = 1.0F - this.onGround;
         var8 = var8 * var8;
         var8 = var8 * var8;
         var8 = 1.0F - var8;
         float var9 = MathHelper.sin(var8 * 3.1415927F);
         float var10 = MathHelper.sin(this.onGround * 3.1415927F) * -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
         this.bipedRightArm.rotateAngleX = (float)((double)this.bipedRightArm.rotateAngleX - ((double)var9 * 1.2D + (double)var10));
         this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
         this.bipedRightArm.rotateAngleZ = MathHelper.sin(this.onGround * 3.1415927F) * -0.4F;
      }

      if(this.isSneak) {
         this.bipedBody.rotateAngleX = 0.5F;
         this.bipedRightArm.rotateAngleX += 0.4F;
         this.bipedLeftArm.rotateAngleX += 0.4F;
         this.bipedRightLeg.rotationPointZ = 4.0F;
         this.bipedLeftLeg.rotationPointZ = 4.0F;
         this.bipedRightLeg.rotationPointY = 9.0F;
         this.bipedLeftLeg.rotationPointY = 9.0F;
         this.bipedHead.rotationPointY = 1.0F;
         this.bipedHeadwear.rotationPointY = 1.0F;
      } else {
         this.bipedBody.rotateAngleX = 0.0F;
         this.bipedRightLeg.rotationPointZ = 0.1F;
         this.bipedLeftLeg.rotationPointZ = 0.1F;
         this.bipedRightLeg.rotationPointY = 12.0F;
         this.bipedLeftLeg.rotationPointY = 12.0F;
         this.bipedHead.rotationPointY = 0.0F;
         this.bipedHeadwear.rotationPointY = 0.0F;
      }

      this.bipedRightArm.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
      this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
      this.bipedRightArm.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
      this.bipedLeftArm.rotateAngleX -= MathHelper.sin(var3 * 0.067F) * 0.05F;
      if(this.aimedBow) {
         float var15 = 0.0F;
         float var16 = 0.0F;
         this.bipedRightArm.rotateAngleZ = 0.0F;
         this.bipedLeftArm.rotateAngleZ = 0.0F;
         this.bipedRightArm.rotateAngleY = -(0.1F - var15 * 0.6F) + this.bipedHead.rotateAngleY;
         this.bipedLeftArm.rotateAngleY = 0.1F - var15 * 0.6F + this.bipedHead.rotateAngleY + 0.4F;
         this.bipedRightArm.rotateAngleX = -1.5707964F + this.bipedHead.rotateAngleX;
         this.bipedLeftArm.rotateAngleX = -1.5707964F + this.bipedHead.rotateAngleX;
         this.bipedRightArm.rotateAngleX -= var15 * 1.2F - var16 * 0.4F;
         this.bipedLeftArm.rotateAngleX -= var15 * 1.2F - var16 * 0.4F;
         this.bipedRightArm.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
         this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
         this.bipedRightArm.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
         this.bipedLeftArm.rotateAngleX -= MathHelper.sin(var3 * 0.067F) * 0.05F;
      }

   }

   public void renderEars(float var1) {
      this.bipedEars.rotateAngleY = this.bipedHead.rotateAngleY;
      this.bipedEars.rotateAngleX = this.bipedHead.rotateAngleX;
      this.bipedEars.rotationPointX = 0.0F;
      this.bipedEars.rotationPointY = 0.0F;
      this.bipedEars.render(var1);
   }

   public void renderCloak(float var1) {
      this.bipedCloak.render(var1);
   }
}
