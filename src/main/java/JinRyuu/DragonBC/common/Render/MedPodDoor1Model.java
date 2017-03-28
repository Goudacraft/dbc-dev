package JinRyuu.DragonBC.common.Render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class MedPodDoor1Model extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape2;

   public MedPodDoor1Model() {
      this.textureWidth = 64;
      this.textureHeight = 32;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 8, 16, 4);
      this.Shape1.setRotationPoint(-8.0F, 0.0F, 0.0F);
      this.Shape1.setTextureSize(64, 32);
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 24, 0);
      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 8, 16, 4);
      this.Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.Shape2.setTextureSize(64, 32);
      this.Shape2.mirror = true;
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
      this.render2(var1, var2, var3, var4, var5, var6, var7);
   }

   private void render2(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      int var8 = (int)var6;
      int var9 = (int)var5;
      if(var8 != 3 && var8 != 7) {
         if(var8 != 1 && var8 != 5) {
            if(var8 != 0 && var8 != 4) {
               if(var8 == 2 || var8 == 6) {
                  GL11.glPushMatrix();
                  GL11.glTranslatef(0.0F - (float)var9 * 0.02F, 0.0F, 0.0F);
                  this.Shape1.render(var7);
                  GL11.glPopMatrix();
                  GL11.glPushMatrix();
                  GL11.glTranslatef(0.0F + (float)var9 * 0.02F, 0.0F, 0.0F);
                  this.Shape2.render(var7);
                  GL11.glPopMatrix();
               }
            } else {
               GL11.glPushMatrix();
               GL11.glTranslatef(0.0F - (float)var9 * 0.02F, 0.0F, 0.0F);
               this.Shape1.render(var7);
               GL11.glPopMatrix();
               GL11.glPushMatrix();
               GL11.glTranslatef(0.0F + (float)var9 * 0.02F, 0.0F, 0.0F);
               this.Shape2.render(var7);
               GL11.glPopMatrix();
            }
         } else {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F - (float)var9 * 0.02F, 0.0F, 0.0F);
            this.Shape1.render(var7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F + (float)var9 * 0.02F, 0.0F, 0.0F);
            this.Shape2.render(var7);
            GL11.glPopMatrix();
         }
      } else {
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F - (float)var9 * 0.02F, 0.0F, 0.0F);
         this.Shape1.render(var7);
         GL11.glPopMatrix();
         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F + (float)var9 * 0.02F, 0.0F, 0.0F);
         this.Shape2.render(var7);
         GL11.glPopMatrix();
      }

   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
   }

   public void renderModel(int var1, int var2, float var3) {
      this.render((Entity)null, 0.0F, 0.0F, 0.0F, (float)var1, (float)var2, var3);
   }
}
