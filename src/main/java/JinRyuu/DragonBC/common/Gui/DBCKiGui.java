package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.DragonBC.common.DBCClientTickHandler;
import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreH;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class DBCKiGui extends Gui {
   private Minecraft mc = JRMCoreClient.mc;
   private FontRenderer fontRenderer;
   private DBCClientTickHandler tick;
   private GuiIngame Guiingame;
   public int itemKi;
   private float xSize_lo;
   private float ySize_lo;
   protected int guiLeft;
   protected int guiTop;
   protected int xSize;
   protected int ySize;
   public int width;
   public int height;
   private int kihelp1;
   private int kihelp2;
   private short kihelp3;
   private double kihelp4;
   public double ret;

   public DBCKiGui(int var1) {
      this.fontRenderer = this.mc.fontRenderer;
      this.itemKi = 0;
      this.xSize = 176;
      this.ySize = 166;
      this.ret = 0.0D;
      this.itemKi = var1;
   }

   public void initGui() {
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.xSize_lo = (float)var1;
      this.ySize_lo = (float)var2;
   }

   public void setWorldAndResolution(Minecraft var1, int var2, int var3) {
      this.width = var2;
      this.height = var3;
      this.initGui1();
   }

   public void initGui1() {
      this.guiLeft = (this.width - this.xSize) / 2;
      this.guiTop = (this.height - this.ySize) / 2;
   }

   public void renderTest() {
      ScaledResolution var1 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var2 = var1.getScaledWidth();
      int var3 = var1.getScaledHeight();
      FontRenderer var4 = this.mc.fontRenderer;
      boolean var5 = true;
      boolean var6 = true;
      int var7 = 16777215;
   }

   public void renderKiBar(int var1) {
      ScaledResolution var2 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var3 = var2.getScaledWidth();
      int var4 = var2.getScaledHeight();
      FontRenderer var5 = this.mc.fontRenderer;
      int var10 = var3 / 2 - 91;
      int var7 = var4 - 52 + 3;
      var1 = JRMCoreH.kiAmount;
      int var11 = JRMCoreH.kiMax;
      int var12 = JRMCoreH.kiChargRa;
      double var13 = JRMCoreH.kiMultip;
      int var15 = mod_DragonBC.cwfb + 10;
      int var16 = mod_DragonBC.chfb + 10;
      short var17 = 182;
      double var18 = 182.0D;
      double var20 = var13;
      if(var13 < 1.0D) {
         var20 = 1.0D;
      }

      double var22 = var18 / var20;
      double var8 = var22 * (double)var1;
      if(var8 > var18) {
         var8 = var18;
      }

      this.kihelp1 = var15;
      this.kihelp2 = var16;
      this.kihelp3 = var17;
      this.kihelp4 = var8;
      boolean var24 = false;
      int var25 = var24?16777215:8453920;
      String var28 = "" + var1;
      int var26 = mod_DragonBC.cwfn + ((int)var18 + var5.getStringWidth(var28)) / 2;
      int var27 = mod_DragonBC.chfn + 2;
      var5.drawString(var28, var26 + 1, var27, 0);
      var5.drawString(var28, var26 - 1, var27, 0);
      var5.drawString(var28, var26, var27 + 1, 0);
      var5.drawString(var28, var26, var27 - 1, 0);
      var5.drawString(var28, var26, var27, 8388564);
      var1 = JRMCoreH.dbcHealthCur;
      var11 = JRMCoreH.dbcHealth;
      var15 = var3 - 13;
      var16 = var4 / 2 + 33;
      var17 = 41;
      byte var29 = 41;
      var20 = (double)var11;
      if(var20 < 1.0D) {
         var20 = 1.0D;
      }

      var22 = (double)var29 / var20;
      var8 = var22 * (double)var1;
      if(var8 > (double)var29) {
         var8 = (double)var29;
      }

      ResourceLocation var30 = new ResourceLocation("jinryuudragonbc:icons.png");
      this.mc.renderEngine.bindTexture(var30);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.drawTexturedModalRect(var15, var16, 0, 80, 11, var17);
      if(var8 > 0.0D) {
         this.drawTexturedModalRect(var15, var16, 11, 80, 11, (int)var8);
      }

      var24 = false;
      var25 = var24?16777215:8453920;
      var28 = "" + var1;
      var26 = var15 + 12 - var28.length() * 6;
      var27 = var16 + 45;
      var5.drawString(var28, var26 + 1, var27, 0);
      var5.drawString(var28, var26 - 1, var27, 0);
      var5.drawString(var28, var26, var27 + 1, 0);
      var5.drawString(var28, var26, var27 - 1, 0);
      var5.drawString(var28, var26, var27, 8388564);
      this.kiBarHelper(this.kihelp1, this.kihelp2, this.kihelp3, this.kihelp4);
   }

   public void kiBarHelper(int var1, int var2, int var3, double var4) {
      ResourceLocation var6 = new ResourceLocation("jinryuudragonbc:icons.png");
      this.mc.renderEngine.bindTexture(var6);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.drawTexturedModalRect(var1, var2, 0, 64, var3, 5);
      if(var4 > 0.0D) {
         this.drawTexturedModalRect(var1, var2, 0, 69, (int)var4, 5);
      }

   }

   public void renderKiChrgBar() {
      ScaledResolution var1 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var2 = var1.getScaledWidth();
      int var3 = var1.getScaledHeight();
      FontRenderer var4 = this.mc.fontRenderer;
      ResourceLocation var5 = new ResourceLocation("jinryuudragonbc:icons.png");
      this.mc.renderEngine.bindTexture(var5);
      int var8 = JRMCoreH.KACharge;
      int var9 = JRMCoreH.kiMax;
      int var10 = JRMCoreH.kiChargRa;
      int var11 = JRMCoreH.KASelected;
      short var12 = 0;
      if(var11 == 1) {
         var12 = 40;
      }

      if(var11 == 2) {
         var12 = 2;
      }

      if(var11 == 3) {
         var12 = 40;
      }

      if(var11 == 4) {
         var12 = 40;
      }

      if(var11 == 5) {
         var12 = 2;
      }

      if(var11 == 6) {
         var12 = 40;
      }

      if(var11 == 7) {
         var12 = 120;
      }

      if(var11 == 8) {
         var12 = 2;
      }

      if(var11 == 9) {
         var12 = 50;
      }

      if(var11 == 10) {
         var12 = 40;
      }

      if(var11 == 11) {
         var12 = 120;
      }

      if(var11 == 12) {
         var12 = 70;
      }

      if(var11 == 13) {
         var12 = 40;
      }

      if(var11 == 14) {
         var12 = 200;
      }

      if(var11 == 15) {
         var12 = 200;
      }

      int var13 = var2 / 2 - 30;
      int var14 = var3 / 2 + 60;
      byte var15 = 60;
      double var16 = 60.0D;
      short var18 = var12;
      if(var12 < 1) {
         var18 = 1;
      }

      double var19 = var16 / (double)var18;
      double var6 = var19 * (double)var8;
      if(var6 > var16) {
         var6 = var16;
      }

      this.drawTexturedModalRect(var13, var14, 0, 0, var15, 10);
      if(var6 > 0.0D) {
         this.drawTexturedModalRect(var13, var14, 0, 10, (int)var6, 10);
      }

   }

   public void renderTP(int var1) {
      ScaledResolution var2 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var3 = var2.getScaledWidth();
      int var4 = var2.getScaledHeight();
      FontRenderer var5 = this.mc.fontRenderer;
      String var6 = "jinryuudragonbc:icons.png";
      short var7 = 130;
      byte var8 = 44;
      int var9 = var3 - var7 + 131;
      int var10 = (var4 - var8) / 2;
      float var11 = DBCClient.mc.thePlayer.rotationPitch + 0.0F;
      if(var11 > 0.0F) {
         var9 = var9 - (int)(var11 * 1.4F);
      } else {
         var9 = var9 - 0;
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation var12 = new ResourceLocation(var6);
      this.mc.renderEngine.bindTexture(var12);
      int var13 = JRMCoreH.KASelected;
      if(var13 != 0) {
         this.drawTexturedModalRect(var9, var10, 0, 20, var7, var8);
         this.name(this.KAName(var13), 3, 3, var5, var9, var10);
         this.name(this.KAcost(var13), 3, 13, var5, var9, var10);
         if(var13 != 16) {
            this.name(this.KAdesc(var13), 3, 23, var5, var9, var10);
            this.name(this.KAdesc2(var13), 3, 33, var5, var9, var10);
         }

         byte var14 = 16;
         byte var15 = 16;
         int var16 = var3 - var14;
         int var17 = (var4 - var15) / 2;
         String var18 = "jinryuudragonbc:KA/KA" + var13 + ".png";
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         ResourceLocation var19 = new ResourceLocation(var18);
         this.mc.renderEngine.bindTexture(var19);
         this.drawTexturedModalRect(var16 - 1, var17 - 33, 0, 0, var14, var15);
      }

   }

   public void name(String var1, int var2, int var3, FontRenderer var4, int var5, int var6) {
      int var7 = var5 + var2;
      int var8 = var6 + var3;
      var4.drawString(var1, var7 + 1, var8, 0);
      var4.drawString(var1, var7 - 1, var8, 0);
      var4.drawString(var1, var7, var8 + 1, 0);
      var4.drawString(var1, var7, var8 - 1, 0);
      var4.drawString(var1, var7, var8, 8388564);
   }

   public String KAName(int var1) {
      String var2 = "";
      if(var1 == 1) {
         var2 = StatCollector.translateToLocal("dbc.KABigBang.name");
      }

      if(var1 == 2) {
         var2 = StatCollector.translateToLocal("dbc.KABlast.name");
      }

      if(var1 == 3) {
         var2 = StatCollector.translateToLocal("dbc.KABurningAtt.name");
      }

      if(var1 == 4) {
         var2 = StatCollector.translateToLocal("dbc.KADeathBeam.name");
      }

      if(var1 == 5) {
         var2 = StatCollector.translateToLocal("dbc.KADodon.name");
      }

      if(var1 == 6) {
         var2 = StatCollector.translateToLocal("dbc.KAEnergyDisk.name");
      }

      if(var1 == 7) {
         var2 = StatCollector.translateToLocal("dbc.KAFinalFlash.name");
      }

      if(var1 == 8) {
         var2 = StatCollector.translateToLocal("dbc.KAFingerLeser.name");
      }

      if(var1 == 9) {
         var2 = StatCollector.translateToLocal("dbc.KAGalicGun.name");
      }

      if(var1 == 10) {
         var2 = StatCollector.translateToLocal("dbc.KAHame.name");
      }

      if(var1 == 11) {
         var2 = StatCollector.translateToLocal("dbc.KAHame10x.name");
      }

      if(var1 == 12) {
         var2 = StatCollector.translateToLocal("dbc.KAMakanko.name");
      }

      if(var1 == 13) {
         var2 = StatCollector.translateToLocal("dbc.KAMasenko.name");
      }

      if(var1 == 14) {
         var2 = StatCollector.translateToLocal("dbc.KAPlanetDest.name");
      }

      if(var1 == 15) {
         var2 = StatCollector.translateToLocal("dbc.KASpiritbomb.name");
      }

      if(var1 == 16) {
         var2 = StatCollector.translateToLocal("dbc.KTKaioken.name");
      }

      return var2;
   }

   public String KAcost(int var1) {
      int var2 = JRMCoreH.kiAscPow;
      if(JRMCoreH.armTypSS1On(DBCClient.mc.thePlayer)) {
         var2 *= 2;
      }

      if(JRMCoreH.armTypSS2On(DBCClient.mc.thePlayer)) {
         var2 *= 3;
      }

      if(JRMCoreH.armTypSS3On(DBCClient.mc.thePlayer)) {
         var2 *= 4;
      }

      byte var3 = JRMCoreH.align;
      double var4 = (double)(100 - var3) * 0.01D;
      double var6 = (double)var3 * 0.01D;
      double var8 = var4 + 0.2D;
      double var10 = var6 + 0.2D;
      double var12 = 1.0D - (var6 - var4 < 0.0D?(var6 - var4) * -1.0D:var6 - var4) + 0.2D;
      int var14 = JRMCoreH.kiMax;
      int var15 = 0;
      if(var1 == 1) {
         this.ret = var12 * 20.0D * (double)var2;
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 2) {
         this.ret = (double)(3 * var2);
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 3) {
         this.ret = var10 * 15.0D * (double)var2;
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 4) {
         this.ret = var8 * 8.0D * (double)var2;
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 5) {
         this.ret = var12 * 5.0D * (double)var2;
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 6) {
         this.ret = (double)(10 * var2);
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 7) {
         this.ret = var12 * 16.0D * (double)var2;
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 8) {
         this.ret = var8 * 6.0D * (double)var2;
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 9) {
         this.ret = var12 * 9.0D * (double)var2;
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 10) {
         this.ret = var10 * 8.0D * (double)var2;
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 11) {
         this.ret = var10 * 19.0D * (double)var2;
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 12) {
         this.ret = var12 * 11.0D * (double)var2;
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 13) {
         this.ret = var10 * 9.0D * (double)var2;
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 14) {
         this.ret = var8 * 100.0D * (double)var2;
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 15) {
         this.ret = var10 * 80.0D * (double)var2;
         var15 = (int)this.ret > var14 * var2?(int)((double)(var14 * var2) * 0.9D):(int)this.ret;
      }

      if(var1 == 16) {
         var15 = JRMCoreH.kiKaioKen;
      }

      return StatCollector.translateToLocal("dbc.itemKiAtt.line1") + var15 + " Ki";
   }

   public String KAdesc(int var1) {
      int var2 = JRMCoreH.kiAscPow;
      if(JRMCoreH.armTypSS1On(DBCClient.mc.thePlayer)) {
         var2 *= 2;
      }

      if(JRMCoreH.armTypSS2On(DBCClient.mc.thePlayer)) {
         var2 *= 3;
      }

      if(JRMCoreH.armTypSS3On(DBCClient.mc.thePlayer)) {
         var2 *= 4;
      }

      byte var3 = JRMCoreH.align;
      double var4 = (double)(100 - var3) * 0.01D;
      double var6 = (double)var3 * 0.01D;
      double var8 = var4 + 0.2D;
      double var10 = var6 + 0.2D;
      double var12 = 1.0D - (var6 - var4 < 0.0D?(var6 - var4) * -1.0D:var6 - var4) + 0.2D;
      double var14 = 0.0D;
      int var16 = 0;
      int var17 = JRMCoreH.kiMax;
      if(var1 == 1) {
         var14 = var12 * 15.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 2) {
         var14 = 2.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 3) {
         var14 = var10 * 13.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 4) {
         var14 = var8 * 5.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 5) {
         var14 = var12 * 4.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 6) {
         var14 = 8.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 7) {
         var14 = var12 * 9.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 8) {
         var14 = var8 * 5.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 9) {
         var14 = var12 * 6.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 10) {
         var14 = var10 * 5.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 11) {
         var14 = var10 * 10.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 12) {
         var14 = var12 * 7.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 13) {
         var14 = var10 * 5.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 14) {
         var14 = var8 * 50.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 15) {
         var14 = var10 * 50.0D * (double)var2;
         var16 = (int)this.ret > var17 * var2?(int)(var14 * (double)(var17 * var2) / this.ret):(int)var14;
      }

      if(var1 == 16) {
         var14 = (double)JRMCoreH.kiKaioKen;
      }

      return StatCollector.translateToLocal("dbc.itemKiAtt.line2") + var16 + StatCollector.translateToLocal("dbc.itemKiAtt.line2.2");
   }

   public String KAdesc2(int var1) {
      return var1 != 2 && var1 != 5 && var1 != 6 && var1 != 8 && var1 != 16?StatCollector.translateToLocal("dbc.itemKiAtt.line3"):StatCollector.translateToLocal("dbc.itemKiAtt.line4");
   }
}
