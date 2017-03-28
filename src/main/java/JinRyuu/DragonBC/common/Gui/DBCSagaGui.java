package JinRyuu.DragonBC.common.Gui;

import JinRyuu.JRMCore.JRMCoreClient;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class DBCSagaGui extends Gui {
   private Minecraft mc = JRMCoreClient.mc;
   private FontRenderer fontRenderer;
   private static double zDepth = 0.0D;

   public DBCSagaGui() {
      this.fontRenderer = this.mc.fontRenderer;
   }

   public void renderDragonRadar() {
      ScaledResolution var1 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var2 = var1.getScaledWidth();
      int var3 = var1.getScaledHeight();
      FontRenderer var4 = this.mc.fontRenderer;
      this.mc.entityRenderer.setupOverlayRendering();
      GL11.glEnable(3042);
      this.DragonSys(var2, var3);
      GL11.glDisable(3042);
   }

   public void DragonSys(int var1, int var2) {
      this.DragonBack(var1, var2);
   }

   public void DragonBack(int var1, int var2) {
      short var5 = 146;
      short var6 = 166;
      int var7 = (var1 - var5 / 4) / 1;
      int var8 = (var2 - var6 / 4) / 1;
      int var9 = (var1 + var5 / 4) / 1;
      int var10 = (int)(((double)var2 + (double)var6 / 4.1D) / 1.0D);
      String var11 = "jinryuudragonbc:radar.png";
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation var12 = new ResourceLocation(var11);
      this.mc.renderEngine.bindTexture(var12);
      double var13 = Math.toRadians((double)this.mc.thePlayer.rotationYaw) + 1.5707963267948966D;
      int var15 = (int)this.mc.thePlayer.rotationPitch + 60;
      if(var15 > 0) {
         this.drawTexturedModalRect(var7 - var15, var8 - var15, 0, 0, var5, var6);
         drawArrow((double)(var9 - var15), (double)(var10 - var15), var13, 10.0D, Color.GREEN.getRGB());
      } else {
         this.drawTexturedModalRect(var7, var8, 0, 0, var5, var6);
         drawArrow((double)var9, (double)var10, var13, 10.0D, Color.GREEN.getRGB());
      }

   }

   public static void drawArrow(double var0, double var2, double var4, double var6, int var8) {
      double var9 = 2.356194490192345D;
      double[] var11 = new double[]{var0 + var6 * Math.cos(var4), var2 + var6 * Math.sin(var4), var0 + var6 * 0.5D * Math.cos(var4 - var9), var2 + var6 * 0.5D * Math.sin(var4 - var9), var0, var2, var0 + var6 * 0.5D * Math.cos(var4 + var9), var2 + var6 * 0.5D * Math.sin(var4 + var9)};
      setColor(var8);
      drawColoredQuad(var11);
      resetColor();
   }

   public static void setColor(int var0) {
      float var1 = (float)(var0 >> 24 & 255) / 255.0F;
      float var2 = (float)(var0 >> 16 & 255) / 255.0F;
      float var3 = (float)(var0 >> 8 & 255) / 255.0F;
      float var4 = (float)(var0 >> 0 & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, var1);
   }

   public static void drawColoredQuad(double[] var0) {
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      Tessellator var1 = Tessellator.instance;
      var1.startDrawingQuads();
      var1.addVertex(var0[0], var0[1], zDepth);
      var1.addVertex(var0[2], var0[3], zDepth);
      var1.addVertex(var0[4], var0[5], zDepth);
      var1.addVertex(var0[6], var0[7], zDepth);
      var1.draw();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
   }

   public static void setZDepth(double var0) {
      zDepth = var0;
   }

   public static void resetColor() {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public void DragonDetect(double var1, double var3) {
      EntityClientPlayerMP var5 = this.mc.thePlayer;
      ScaledResolution var6 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var7 = var6.getScaledWidth();
      int var8 = var6.getScaledHeight();
      byte var9 = 8;
      byte var10 = 8;
      int var11 = (var7 + 32) / 1;
      int var12 = (var8 + 36) / 1;
      String var13 = "jinryuudragonbc:detect.png";
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation var14 = new ResourceLocation(var13);
      this.mc.renderEngine.bindTexture(var14);
      this.drawTexturedModalRect((int)((double)var11 + var1), (int)((double)var12 + var3), 0, 0, var9, var10);
   }
}
