package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
import JinRyuu.DragonBC.common.Npcs.EntityDBCGood;
import JinRyuu.DragonBC.common.Npcs.EntityDBCKami;
import JinRyuu.DragonBC.common.Npcs.EntityDBCNeut;
import JinRyuu.JRMCore.JRMCoreCliTicH;
import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.mod_JRMCore;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent.Post;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import org.lwjgl.opengl.GL11;

public class DBCEH {
   public static final int ksm_default = 0;
   public static final int ksm_onlyPly = 1;
   public static final int ksm_onlyMob = 2;
   public static final int ksm_showall = 3;
   public static final int ksm_off = 4;
   public static int kisnsMd = 0;

   public DBCEH() {
   }

   public void renderSense(int var1, int var2, int var3, int var4, int var5, Post var6) {
      double var7 = var6.x;
      double var9 = var6.y;
      double var11 = var6.z;
      EntityPlayer var13 = mod_JRMCore.proxy.getPlayerClient();
      int var14 = JRMCoreH.SklLvl(6);
      double var15 = var6.entity.getDistanceSqToEntity(var13);
      float var17 = (float)(30 + var14 * 10);
      if(var15 < (double)(var17 * var17) && (var6.entity.posY >= 61.0D || var9 > (double)(-var14 * 4))) {
         float var18 = 39.0F;
         float var19 = var18 / (float)var4;
         float var20 = var19 * (float)var3;
         if(var20 > var18) {
            var20 = var18;
         }

         var19 = var18 / (float)var2;
         float var21 = var19 * (float)var1;
         if(var21 > var18) {
            var21 = var18;
         }

         long var22 = JRMCoreH.bpc(var6.entity);
         long var24 = JRMCoreH.bpc(JRMCoreClient.mc.thePlayer.getCommandSenderName(), JRMCoreH.Pwrtyp);
         long var26 = var22 > var24?var22 / var24:var24 / var22;
         long var28 = JRMCoreH.bpc(JRMCoreClient.mc.thePlayer.getCommandSenderName(), JRMCoreH.Pwrtyp, 100);
         long var30 = var22 > var28?var22 / var28:var28 / var22;
         boolean var32 = JRMCoreCliTicH.lockOn != null;
         if(var32) {
            if(!var32) {
               return;
            }
         } else if(var22 <= 5L || var22 < var24 && kisnsMd != 3 && var24 / var22 > 100L) {
            return;
         }

         FontRenderer var33 = RenderManager.instance.getFontRenderer();
         float var34 = 1.6F;
         float var35 = 0.016666668F * var34;
         GL11.glPushMatrix();
         float var36 = (float)Math.toDegrees(Math.atan2(0.0D - var6.z, 0.0D - var6.x));
         double var37 = Math.sin((double)(var36 / 57.295776F));
         double var39 = Math.cos((double)(var36 / 57.295776F));
         GL11.glTranslatef((float)(var7 + 1.5D * var37), (float)var9 + var6.entity.height + 1.75F - var6.entity.height * 0.75F + 0.5F, (float)(var11 - 1.5D * var39));
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-RenderManager.instance.playerViewY, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(RenderManager.instance.playerViewX, 1.0F, 0.0F, 0.0F);
         double var41 = (double)(RenderManager.instance.playerViewY % 180.0F / 57.295776F);
         GL11.glScalef(-var35, -var35, var35);
         var15 = (double)var6.entity.getDistanceToEntity(var13);
         if(var15 > 10.0D) {
            GL11.glScaled(var15 / 10.0D, var15 / 10.0D, var15 / 10.0D);
         }

         GL11.glDisable(2896);
         OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
         GL11.glDepthMask(false);
         GL11.glDisable(2929);
         GL11.glEnable(3042);
         OpenGlHelper.glBlendFunc(770, 771, 1, 0);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.7F);
         ResourceLocation var43 = new ResourceLocation(JRMCoreH.tjdbcAssts + ":" + "kisense.png");
         JRMCoreClient.mc.renderEngine.bindTexture(var43);
         this.drawTexturedModalRect(0.0F, 0.0F, 0, 0, 21.0F, 41.0F, 0.0F);
         int var44 = 16522030;
         int var45 = 654591;
         int var46 = 13478142;
         int var47 = 16737280;
         int var48 = 7208960;
         int var49 = 16574610;
         int var50;
         switch(var5) {
         case 0:
            var50 = var45;
            break;
         case 1:
            var50 = var46;
            break;
         case 2:
            var50 = var44;
            break;
         default:
            var50 = var46;
         }

         glColor4f(var50, 1.0F);
         this.drawTexturedModalRect(1.0F, (float)(39 - (int)var20 + 1), 25, 0, (float)(10 + (var14 > 1?0:9)), (float)((int)var20), 0.0F);
         if(var14 > 1) {
            glColor4f(7208960, 1.0F);
            this.drawTexturedModalRect(11.0F, (float)(39 - (int)var21 + 1), 35, 0, 9.0F, (float)((int)var21), 0.0F);
         }

         if(var14 > 3) {
            var18 = 41.0F;
            var19 = var18 / 10.0F;
            float var51 = var19 * (float)(var26 > 10L?10L:var26);
            if(var51 > var18) {
               var51 = var18;
            }

            glColor4f(var22 > var24?16737280:654591, 1.0F);
            this.drawTexturedModalRect(-3.0F, (float)(41 - (int)var51), 21, 0, 3.0F, (float)((int)var51), 0.0F);
            if(var26 > 10L && var14 > 6) {
               var19 = var18 / 100.0F;
               var51 = var19 * (float)(var26 > 100L?100L:var26);
               if(var51 > var18) {
                  var51 = var18;
               }

               this.drawTexturedModalRect(-4.0F, (float)(41 - (int)var51), 24, 0, 1.0F, (float)((int)var51), 0.0F);
            }

            var19 = var18 / 10.0F;
            var51 = var19 * (float)(var30 > 10L?10L:var30);
            if(var51 > var18) {
               var51 = var18;
            }

            glColor4f(var22 > var28?16737280:654591, 1.0F);
            this.drawTexturedModalRect(21.0F, (float)(41 - (int)var51), 21, 0, 3.0F, (float)((int)var51), 0.0F);
            if(var30 > 10L && var14 > 6) {
               var19 = var18 / 100.0F;
               var51 = var19 * (float)(var30 > 100L?100L:var30);
               if(var51 > var18) {
                  var51 = var18;
               }

               this.drawTexturedModalRect(24.0F, (float)(41 - (int)var51), 24, 0, 1.0F, (float)((int)var51), 0.0F);
            }
         }

         if(var14 > 9) {
            int var62 = var33.getStringWidth(var1 + "");
            var33.drawString("" + var1, 12 - var62 / 2, -8, 0);
         }

         GL11.glEnable(2929);
         GL11.glDepthMask(true);
         GL11.glEnable(2896);
         GL11.glDisable(3042);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
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

   public static void glColor4f(int var0, int var1, float var2, float var3) {
      float var4 = (float)(var0 >> 16 & 255) / 255.0F;
      float var5 = (float)(var0 >> 8 & 255) / 255.0F;
      float var6 = (float)(var0 & 255) / 255.0F;
      float var7 = (float)(var1 >> 16 & 255) / 255.0F;
      float var8 = (float)(var1 >> 8 & 255) / 255.0F;
      float var9 = (float)(var1 & 255) / 255.0F;
      float var10 = var2 > 1.0F?1.0F:var2;
      float var11 = 1.0F - var10;
      float var12 = var4 * var11 + var7 * var10;
      float var13 = var5 * var11 + var8 * var10;
      float var14 = var6 * var11 + var9 * var10;
      GL11.glColor4f(var12, var13, var14, var3);
   }

   @SideOnly(Side.CLIENT)
   @SubscribeEvent
   public void onRenderLivingEvent(Post var1) {
      boolean var2 = var1.entity instanceof EntityPlayer;
      boolean var3 = JRMCoreCliTicH.lockOn != null;
      boolean var4 = var3 && var1.entity.equals(JRMCoreCliTicH.lockOn);
      if(JRMCoreH.Pwrtyp == 1 && JRMCoreH.SklLvl(6) > 0 && kisnsMd != 4) {
         if(!(var1.entity instanceof EntityDBCKami) && var1.entity instanceof EntityCreature) {
            label86: {
               if(var3) {
                  if(!var4) {
                     break label86;
                  }
               } else if(kisnsMd == 1) {
                  break label86;
               }

               byte var5 = 1;
               if(var1.entity instanceof EntityMob) {
                  var5 = 2;
               } else if(var1.entity instanceof EntityDBCEvil) {
                  var5 = 2;
               } else if(var1.entity instanceof EntityDBCNeut) {
                  var5 = 1;
               } else if(var1.entity instanceof EntityDBCGood) {
                  var5 = 0;
               } else if(var1.entity instanceof EntityDBC) {
                  var5 = 1;
               } else if(var1.entity instanceof EntityDBC) {
                  var5 = 1;
               }

               this.renderSense((int)var1.entity.getHealth(), (int)var1.entity.getMaxHealth(), 100, 100, var5, var1);
            }
         }

         if(var2) {
            if(var3) {
               if(!var4) {
                  return;
               }
            } else if(kisnsMd == 2) {
               return;
            }

            if(!JRMCoreClient.mc.thePlayer.getCommandSenderName().equals(var1.entity.getCommandSenderName()) && JRMCoreH.dnn(14) && JRMCoreH.dnn(8) && JRMCoreH.dnn(9) && JRMCoreH.dnn(1) && JRMCoreH.dnn(5)) {
               EntityPlayer var16 = (EntityPlayer)var1.entity;
               int var6 = Integer.parseInt(JRMCoreH.data(var1.entity.getCommandSenderName(), 8, "200"));
               int var7 = Integer.parseInt(JRMCoreH.data(var1.entity.getCommandSenderName(), 9, "200"));
               int[] var8 = JRMCoreH.PlyrAttrbtsC((EntityPlayer)var1.entity);
               String[] var9 = JRMCoreH.data(var1.entity.getCommandSenderName(), 1, "0;0;0;0;0;0").split(";");
               int var10 = Integer.parseInt(var9[0]);
               int var11 = Integer.parseInt(var9[2]);
               int var12 = Integer.parseInt(var9[3]);
               int var13 = JRMCoreH.stat(var11, 2, var8[2], var10, var12, 0.0F);
               int var14 = JRMCoreH.stat(var11, 5, var8[5], var10, var12, 0.0F);
               int var15 = JRMCoreH.Algnmnt(Integer.parseInt(JRMCoreH.data(var1.entity.getCommandSenderName(), 5, "50;0").split(";")[0]));
               this.renderSense(var6, var13, var7, var14, var15, var1);
            }
         }
      }

   }

   public void drawTexturedModalRect(float var1, float var2, int var3, int var4, float var5, float var6, float var7) {
      float var8 = 0.00390625F;
      float var9 = 0.00390625F;
      Tessellator var10 = Tessellator.instance;
      var10.startDrawingQuads();
      var10.addVertexWithUV((double)var1, (double)(var2 + 0.0F), (double)var7, (double)((float)(var3 + 0) * var8), (double)((float)(var4 + 0) * var9));
      var10.addVertexWithUV((double)var1, (double)(var2 + var6), (double)var7, (double)((float)(var3 + 0) * var8), (double)(((float)var4 + var6) * var9));
      var10.addVertexWithUV((double)(var1 + var5), (double)(var2 + var6), (double)var7, (double)(((float)var3 + var5) * var8), (double)(((float)var4 + var6) * var9));
      var10.addVertexWithUV((double)(var1 + var5), (double)(var2 + 0.0F), (double)var7, (double)(((float)var3 + var5) * var8), (double)((float)(var4 + 0) * var9));
      var10.draw();
   }

   @SubscribeEvent
   public void onLivingDropsEvent(LivingDropsEvent var1) {
   }
}
