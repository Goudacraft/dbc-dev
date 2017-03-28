package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityAura;
import JinRyuu.DragonBC.common.Npcs.ModelAura;
import JinRyuu.DragonBC.common.Npcs.RenderDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderAura extends RenderDBC {
   private ModelAura aModel = new ModelAura();

   public RenderAura() {
      super(new ModelAura(), 0.5F);
   }

   public void renderAura(EntityAura var1, double var2, double var4, double var6, float var8, float var9) {
      this.shadowSize = 0.0F;
      GL11.glPushMatrix();
      GL11.glTranslatef((float)var2 + 0.0F, (float)var4 + 3.0F, (float)var6 + 0.0F);
      boolean var10 = var1.getRot();
      if(var10) {
         GL11.glTranslatef(0.0F, -1.5F, 0.0F);
         GL11.glRotatef(-var1.rotationYaw, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(var1.rotationPitch - 90.0F, 1.0F, 0.0F, 0.0F);
         GL11.glTranslatef(0.0F, 1.5F, 0.0F);
      }

      GL11.glPushMatrix();
      float var11 = (float)var1.getSpd();
      boolean var12 = var1.getInner();
      float var13 = 18.0F / (var11 * 0.05F);
      float var14 = (float)var1.getAge();
      float var15 = var1.getCRel();
      float var16 = var1.getState() + var15 * 0.03F;
      float var17 = var1.getState2() * 0.5F;
      int var18 = var1.getCol();
      String var19 = var1.getTex();
      int var20 = var1.getColL2();
      String var21 = var1.getTexL2();
      boolean var22 = var21.length() > 2;
      var16 = var16 + var17;
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation var23 = new ResourceLocation("jinryuudragonbc:" + var21 + ".png");
      ResourceLocation var24 = new ResourceLocation("jinryuudragonbc:" + var19 + ".png");
      this.renderManager.renderEngine.bindTexture(var24);
      glColor4f(var18, var1.getAlp());
      GL11.glDepthMask(false);
      GL11.glEnable(3042);
      GL11.glDisable(2896);
      GL11.glBlendFunc(770, 771);
      GL11.glAlphaFunc(516, 0.003921569F);
      GL11.glScalef(1.0F + 0.1F * var16, 1.0F + 0.07F * var16, 1.0F + 0.1F * var16);
      GL11.glTranslatef(0.0F, 0.0F - 0.15F * var16, 0.0F);
      GL11.glRotatef(var14 * var13, 0.0F, 1.0F, 0.0F);
      float var25 = 0.75F;

      for(int var26 = 0; var26 < (var12?2:1) && (var26 != 1 || var14 <= 10.0F); ++var26) {
         for(int var27 = 0; var27 < 4; ++var27) {
            GL11.glPushMatrix();
            GL11.glRotatef((float)(var27 * 90), 0.0F, 1.0F, 0.0F);
            if(var14 < 15.0F) {
               this.aModel.renderModel(var1, 0.0625F, var14, (float)var26 * var25, var11);
               if(var22) {
                  this.renderManager.renderEngine.bindTexture(var23);
                  glColor4f(var20, var1.getAlp());
                  this.aModel.renderModel(var1, 0.0625F, var14, (float)var26 * var25, var11);
               }
            }

            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glRotatef((float)(var27 * 90 + 45), 0.0F, 1.0F, 0.0F);
            this.renderManager.renderEngine.bindTexture(var24);
            glColor4f(var18, var1.getAlp());
            this.aModel.renderModel(var1, 0.0625F, var14 + 4.0F, (float)var26 * var25, var11);
            if(var22) {
               this.renderManager.renderEngine.bindTexture(var23);
               glColor4f(var20, var1.getAlp());
               this.aModel.renderModel(var1, 0.0625F, var14 + 4.0F, (float)var26 * var25, var11);
            }

            GL11.glPopMatrix();
         }
      }

      GL11.glDisable(3042);
      GL11.glAlphaFunc(516, 0.1F);
      GL11.glPopMatrix();
      GL11.glDepthMask(true);
      GL11.glPopMatrix();
      if(var14 < (float)var1.getLightLivingTime() && var1.getState() > 4.0F && var1.getState() < 7.0F && !var10) {
         GL11.glPushMatrix();
         Tessellator var64 = Tessellator.instance;
         GL11.glDisable(3553);
         GL11.glDisable(2896);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 1);
         double[] var65 = new double[8];
         double[] var28 = new double[8];
         double var29 = 0.0D;
         double var31 = 0.0D;
         new Random(var1.lightVert);

         for(int var34 = 7; var34 >= 0; --var34) {
            ;
         }

         byte var66 = 0;
         float var35 = 0.2F;
         Random var36 = new Random(var1.lightVert);

         for(int var37 = 0; var37 < 3; ++var37) {
            int var38 = 7;
            int var39 = 0;
            if(var37 > 0) {
               var38 = 7 - var37;
            }

            if(var37 > 0) {
               var39 = var38 - 2;
            }

            double var40 = var65[var38] - var29;
            double var42 = var28[var38] - var31;

            for(int var44 = var38; var44 >= var39; --var44) {
               double var45 = var40;
               double var47 = var42;
               var40 += (double)(var36.nextInt(31) - 15) * 0.07000000029802322D;
               var42 += (double)(var36.nextInt(31) - 15) * 0.07000000029802322D;
               var64.startDrawing(5);
               float var49 = 0.5F;
               var64.setColorRGBA_F(0.9F * var49, 0.9F * var49, 1.0F * var49, 0.3F);
               double var50 = 0.1D + (double)var66 * 0.2D;
               if(var37 == 0) {
                  ;
               }

               double var52 = 0.1D + (double)var66 * 0.2D;
               if(var37 == 0) {
                  ;
               }

               for(int var54 = 0; var54 < 5; ++var54) {
                  double var55 = var2 + 0.0D - var50;
                  double var57 = var6 + 0.0D - var50;
                  if(var54 == 1 || var54 == 2) {
                     var55 += var50 * 2.0D * (double)var35;
                  }

                  if(var54 == 2 || var54 == 3) {
                     var57 += var50 * 2.0D * (double)var35;
                  }

                  double var59 = var2 + 0.0D - var52;
                  double var61 = var6 + 0.0D - var52;
                  if(var54 == 1 || var54 == 2) {
                     var59 += var52 * 2.0D * (double)var35;
                  }

                  if(var54 == 2 || var54 == 3) {
                     var61 += var52 * 2.0D * (double)var35;
                  }

                  if(var44 < 8) {
                     var64.addVertex(var59 + var40 * (double)var35, var4 - (double)(var44 * 1 - 7) * (double)var35, var61 + var42 * (double)var35);
                     var64.addVertex(var55 + var45 * (double)var35, var4 - (double)((var44 + 1) * 1 - 7) * (double)var35, var57 + var47 * (double)var35);
                  }
               }

               var64.draw();
            }
         }

         GL11.glDisable(3042);
         GL11.glEnable(2896);
         GL11.glEnable(3553);
         GL11.glPopMatrix();
      }

   }

   public static void glColor4f(int var0, float var1) {
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 & 255) / 255.0F;
      float var5 = 1.0F;
      GL11.glColor4f(var5 * var2, var5 * var3, var5 * var4, var1);
   }

   protected float handleRotationFloat(Entity var1, float var2) {
      return (float)var1.ticksExisted + var2;
   }

   public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      this.renderAura((EntityAura)var1, var2, var4, var6, var8, var9);
   }
}
