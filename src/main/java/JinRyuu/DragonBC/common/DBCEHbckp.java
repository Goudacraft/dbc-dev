package JinRyuu.DragonBC.common;

import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.mod_JRMCore;
import com.jin_ryuu.SwordArtC.Main;
import com.jin_ryuu.SwordArtC.proxy.Client;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent.Post;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import org.lwjgl.opengl.GL11;

public class DBCEHbckp {
   public DBCEHbckp() {
   }

   public long bpc(Entity var1) {
      if(!(var1 instanceof EntityCreature)) {
         return var1 instanceof EntityPlayer?JRMCoreH.bpc(var1.getCommandSenderName()):1L;
      } else {
         int var2 = (int)(((EntityCreature)var1).getMaxHealth() / JRMCoreH.statInc(1, 2, 1, 0, 0, 0.0F) * 6.0F);
         long var3 = 1L;

         for(int var5 = 0; var5 <= var2; ++var5) {
            var3 += (long)JRMCoreH.attrCst(var5);
         }

         return var3;
      }
   }

   public void renderSense(int var1, int var2, int var3, int var4, Post var5) {
      double var6 = var5.x;
      double var8 = var5.y;
      double var10 = var5.z;
      EntityPlayer var12 = Main.proxy.getPlayerClient();
      double var13 = var5.entity.getDistanceSqToEntity(var12);
      float var15 = var12.isSneaking()?40.0F:20.0F;
      if(var13 < (double)(var15 * var15)) {
         float var16 = 39.0F;
         float var17 = var16 / (float)var4;
         float var18 = var17 * (float)var3;
         if(var18 > var16) {
            var18 = var16;
         }

         var17 = var16 / (float)var2;
         float var19 = var17 * (float)var1;
         if(var19 > var16) {
            var19 = var16;
         }

         long var20 = this.bpc(var5.entity);
         long var22 = JRMCoreH.bpc(JRMCoreClient.mc.thePlayer.getCommandSenderName(), JRMCoreH.Pwrtyp);
         long var24 = var20 > var22?var20 / var22:var22 / var20;
         String var26 = (var20 > var22?"+":"-") + (var24 > 100L?"100^x":var24 + "x");
         long var27 = JRMCoreH.bpc(JRMCoreClient.mc.thePlayer.getCommandSenderName(), JRMCoreH.Pwrtyp, 100);
         long var29 = var20 > var27?var20 / var22:var27 / var20;
         String var31 = (var20 > var27?"+":"-") + (var29 > 100L?"100^x":var29 + "x");
         FontRenderer var32 = RenderManager.instance.getFontRenderer();
         float var33 = 1.6F;
         float var34 = 0.016666668F * var33;
         GL11.glPushMatrix();
         float var35 = (float)Math.toDegrees(Math.atan2(0.0D - var5.z, 0.0D - var5.x));
         double var36 = Math.sin((double)(var35 / 57.295776F));
         double var38 = Math.cos((double)(var35 / 57.295776F));
         GL11.glTranslatef((float)(var6 + 1.5D * var36), (float)var8 + var5.entity.height + 1.75F - var5.entity.height * 0.75F + 0.5F, (float)(var10 - 1.5D * var38));
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-RenderManager.instance.playerViewY, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(RenderManager.instance.playerViewX, 1.0F, 0.0F, 0.0F);
         double var40 = (double)(RenderManager.instance.playerViewY % 180.0F / 57.295776F);
         GL11.glScalef(-var34, -var34, var34);
         var13 = (double)var5.entity.getDistanceToEntity(var12);
         if(var13 > 10.0D) {
            GL11.glScaled(var13 / 10.0D, var13 / 10.0D, var13 / 10.0D);
         }

         GL11.glDisable(2896);
         OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
         GL11.glDepthMask(false);
         GL11.glDisable(2929);
         GL11.glEnable(3042);
         OpenGlHelper.glBlendFunc(770, 771, 1, 0);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.7F);
         ResourceLocation var42 = new ResourceLocation(JRMCoreH.tjdbcAssts + ":" + "kisense.png");
         Client.mc.renderEngine.bindTexture(var42);
         this.drawTexturedModalRect(0.0F, 0.0F, 0, 0, 21.0F, 41.0F, 0.0F);
         int var43 = 654591;
         if(JRMCoreH.align > 66) {
            var43 = 654591;
         } else if(JRMCoreH.align <= 66 && JRMCoreH.align >= 33) {
            var43 = 13478142;
         } else if(JRMCoreH.align < 33) {
            var43 = 16522030;
         }

         int var44 = (JRMCoreH.Race == 1 || JRMCoreH.Race == 2) && JRMCoreH.State > 0?16574610:var43;
         glColor4f(var44, 1.0F);
         this.drawTexturedModalRect(1.0F, (float)(39 - (int)var18 + 1), 24, 0, 10.0F, (float)((int)var18), 0.0F);
         glColor4f(7208960, 1.0F);
         this.drawTexturedModalRect(11.0F, (float)(39 - (int)var19 + 1), 34, 0, 9.0F, (float)((int)var19), 0.0F);
         var16 = 41.0F;
         var17 = var16 / 10.0F;
         float var45 = var17 * (float)(var24 > 10L?10L:var24);
         if(var45 > var16) {
            var45 = var16;
         }

         glColor4f(var20 > var22?16737280:654591, 1.0F);
         this.drawTexturedModalRect(-3.0F, (float)(41 - (int)var45), 21, 0, 3.0F, (float)((int)var45), 0.0F);
         var45 = var17 * (float)(var29 > 10L?10L:var29);
         if(var45 > var16) {
            var45 = var16;
         }

         glColor4f(var20 > var27?16737280:654591, 1.0F);
         this.drawTexturedModalRect(21.0F, (float)(41 - (int)var45), 21, 0, 3.0F, (float)((int)var45), 0.0F);
         GL11.glEnable(2929);
         GL11.glDepthMask(true);
         GL11.glEnable(2896);
         GL11.glDisable(3042);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
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
      if(JRMCoreH.Pwrtyp == 1 && (var1.entity instanceof EntityCreature || var2)) {
         this.renderSense((int)var1.entity.getHealth(), (int)var1.entity.getMaxHealth(), 100, 100, var1);
      }

      if(var1.entity instanceof EntityPlayer && JRMCoreH.Pwrtyp == 1) {
         int var3 = Integer.parseInt(JRMCoreH.data(var1.entity.getCommandSenderName(), 8, "200"));
         int var4 = Integer.parseInt(JRMCoreH.data(var1.entity.getCommandSenderName(), 9, "200"));
         int[] var5 = JRMCoreH.PlyrAttrbtsC((EntityPlayer)var1.entity);
         String[] var6 = JRMCoreH.data(var1.entity.getCommandSenderName(), 1, "0;0;0;0;0;0").split(";");
         int var7 = Integer.parseInt(var6[3]);
         int var8 = Integer.parseInt(var6[0]);
         int var9 = JRMCoreH.stat(1, 2, var5[2], var8, var7, 0.0F);
         int var10 = JRMCoreH.stat(1, 5, var5[5], var8, var7, 0.0F);
         this.renderSense(var3, var9, var4, var10, var1);
         EntityPlayer var11 = mod_JRMCore.proxy.getPlayerClient();
         double var12 = var1.entity.getDistanceSqToEntity(var11);
         float var14 = var11.isSneaking()?4.0F:8.0F;
         if(var12 < (double)(var14 * var14)) {
            double var15 = var1.x;
            double var17 = var1.y;
            double var19 = var1.z;
            float var21 = 120.0F;
            float var22 = var21 / (float)var9;
            float var23 = var22 * (float)var3;
            if(var23 > var21) {
               var23 = var21;
            }

            float var24 = var23 > 50.0F?0.58F:(var23 > 25.0F?1.0F:1.0F);
            float var25 = var23 > 50.0F?0.83F:(var23 > 25.0F?1.0F:0.2F);
            float var26 = var23 > 50.0F?0.23F:(var23 > 25.0F?0.2F:0.2F);
            FontRenderer var27 = JRMCoreClient.mc.fontRenderer;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)var15, (float)var17 + var1.entity.height + 1.75F - var1.entity.height * 0.75F, (float)var19);
            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
            GL11.glRotatef(-RenderManager.instance.playerViewY, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(RenderManager.instance.playerViewX, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(-30.0F, 0.0F, 0.0F, 1.0F);
            float var28 = 0.0116F;
            GL11.glScalef(-var28, -var28, var28);
            GL11.glDisable(2896);
            GL11.glTranslatef(-var21 / 2.0F - var1.entity.width * 40.0F, 1.0F / var28, 0.0F - var1.entity.width * 80.0F);
            GL11.glEnable(3042);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var29 = new ResourceLocation(JRMCoreH.tjsaoc + ":" + "gui2.png");
            JRMCoreClient.mc.renderEngine.bindTexture(var29);
            this.drawTexturedModalRect(0.0F, -1.0F, 0, 43, 126.0F, 15.0F, 0.0F);
            GL11.glColor4f(var24, var25, var26, 1.0F);
            this.drawTexturedModalRect(4.0F, 1.0F, 0, 58, var23, 11.0F, -0.01F);
            GL11.glTranslatef(var21, 0.0F, 0.0F);
            GL11.glScalef(1.0F, 1.0F, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.drawTexturedModalRect(0.0F, -1.0F, 126, 43, -126.0F, 15.0F, 0.0F);
            GL11.glColor4f(var24, var25, var26, 1.0F);
            this.drawTexturedModalRect((float)((int)var23) - var21 - 2.0F, 1.0F, (int)var23, 58, -var23, 11.0F, 0.01F);
            GL11.glEnable(2896);
            GL11.glDisable(3042);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glPopMatrix();
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
