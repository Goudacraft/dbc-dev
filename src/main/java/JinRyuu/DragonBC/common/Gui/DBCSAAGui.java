package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.DragonBC.common.DBCClientTickHandler;
import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Gui.DBCGuiButtons00;
import JinRyuu.DragonBC.common.Gui.DBCGuiButtons01;
import JinRyuu.DragonBC.common.Gui.DBCGuiButtons02;
import JinRyuu.DragonBC.common.Gui.DBCGuiButtons06;
import JinRyuu.JRMCore.JRMCoreH;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class DBCSAAGui extends GuiScreen {
   private DBCClientTickHandler tick;
   private GuiIngame Guiingame;
   public int saa = 0;
   public static int count = 0;
   public static int warn = 0;
   public static int startcount = 0;
   private String Process = "Something is Wrong";
   private int wid = 0;
   private int hei = 0;
   private String textureFile = "jinryuudragonbc:sagas.png";

   public void renderSuperProtect(int var1) {
      this.buttonList.clear();
      int var2 = this.width / 2;
      int var3 = this.height / 2;
      this.buttonList.add(new DBCGuiButtons02(100, var2 - 0, var3 - 0, 20, 20, "TEST"));
   }

   public DBCSAAGui(int var1) {
      this.saa = var1;
   }

   public void initGui() {
      this.buttonList.clear();
      int var1 = this.width / 2;
      int var2 = this.height / 2;
      this.buttonList.add(new DBCGuiButtons02(-1, var1 + 130, var2 - 70, 70, 20, StatCollector.translateToLocal("dbc.saagui.abilities")));
      this.buttonList.add(new DBCGuiButtons02(-2, var1 + 130, var2 - 45, 70, 20, StatCollector.translateToLocal("dbc.saagui.sagasystem")));
      if(JRMCoreH.NC()) {
         this.buttonList.add(new DBCGuiButtons02(-1, var1 - 200, var2 - 70, 70, 20, "Dragon Block C"));
         this.buttonList.add(new DBCGuiButtons02(-3, var1 - 200, var2 - 45, 70, 20, "Naruto C"));
      }

      if(this.saa == 1) {
         this.buttonList.add(new DBCGuiButtons02(0, var1 - 82, var2 - 60, 83, 20, StatCollector.translateToLocal("dbc.saagui.body")));
         this.buttonList.add(new DBCGuiButtons02(1, var1 + 2, var2 - 60, 83, 20, StatCollector.translateToLocal("dbc.saagui.trainingpoints")));
         this.buttonList.add(new DBCGuiButtons02(2, var1 - 82, var2 - 35, 83, 20, StatCollector.translateToLocal("dbc.saagui.maxki")));
         this.buttonList.add(new DBCGuiButtons02(3, var1 + 2, var2 - 35, 83, 20, StatCollector.translateToLocal("dbc.saagui.chargeki")));
         this.buttonList.add(new DBCGuiButtons02(4, var1 - 82, var2 - 10, 83, 20, StatCollector.translateToLocal("dbc.saagui.dash")));
         this.buttonList.add(new DBCGuiButtons02(5, var1 + 2, var2 - 10, 83, 20, StatCollector.translateToLocal("dbc.saagui.punch")));
         this.buttonList.add(new DBCGuiButtons02(6, var1 - 82, var2 + 15, 83, 20, StatCollector.translateToLocal("dbc.saagui.jump")));
         this.buttonList.add(new DBCGuiButtons02(7, var1 + 2, var2 + 15, 83, 20, StatCollector.translateToLocal("dbc.saagui.fly")));
         this.buttonList.add(new DBCGuiButtons02(8, var1 - 82, var2 + 40, 83, 20, StatCollector.translateToLocal("dbc.saagui.ascending")));
         this.buttonList.add(new DBCGuiButtons02(9, var1 + 2, var2 + 40, 83, 20, StatCollector.translateToLocal("dbc.saagui.attackpower")));
         this.buttonList.add(new DBCGuiButtons01(10, var1 - 10, var2 + 65, 20, 20, "X"));
         if(!JRMCoreH.HairExists(DBCClient.mc.thePlayer)) {
            this.buttonList.add(new DBCGuiButtons01(200, var1 + 55, var2 + 65, 70, 20, StatCollector.translateToLocal("dbc.saagui.selecthair")));
         }
      }

      if(this.saa == 2) {
         var2 -= 10;
         this.buttonList.add(this.actionPerformed(21, var1 - 82, var2 - 60, 83, 20, StatCollector.translateToLocal("dbc.KABigBang.name")));
         this.buttonList.add(this.actionPerformed(22, var1 + 2, var2 - 60, 83, 20, StatCollector.translateToLocal("dbc.KABlast.name")));
         this.buttonList.add(this.actionPerformed(23, var1 - 82, var2 - 35, 83, 20, StatCollector.translateToLocal("dbc.KABurningAtt.name")));
         this.buttonList.add(this.actionPerformed(24, var1 + 2, var2 - 35, 83, 20, StatCollector.translateToLocal("dbc.KADeathBeam.name")));
         this.buttonList.add(this.actionPerformed(25, var1 - 82, var2 - 10, 83, 20, StatCollector.translateToLocal("dbc.KADodon.name")));
         this.buttonList.add(this.actionPerformed(26, var1 + 2, var2 - 10, 83, 20, StatCollector.translateToLocal("dbc.KAEnergyDisk.name")));
         this.buttonList.add(this.actionPerformed(27, var1 - 82, var2 + 15, 83, 20, StatCollector.translateToLocal("dbc.KAFinalFlash.name")));
         this.buttonList.add(this.actionPerformed(28, var1 + 2, var2 + 15, 83, 20, StatCollector.translateToLocal("dbc.KAFingerLeser.name")));
         this.buttonList.add(this.actionPerformed(29, var1 - 82, var2 + 40, 83, 20, StatCollector.translateToLocal("dbc.KAGalicGun.name")));
         this.buttonList.add(this.actionPerformed(30, var1 + 2, var2 + 40, 83, 20, StatCollector.translateToLocal("dbc.KAHame.name")));
         this.buttonList.add(new DBCGuiButtons01(100, var1 - 80, var2 + 65, 160, 20, StatCollector.translateToLocal("dbc.saagui.forgetattacks")));
         this.buttonList.add(new DBCGuiButtons01(10, var1 + 100, var2 - 80, 20, 20, "X"));
         this.buttonList.add(new DBCGuiButtons01(101, var1 + 85, var2 + 65, 40, 20, StatCollector.translateToLocal("dbc.saagui.next")));
      }

      if(this.saa == 3) {
         var2 -= 10;
         this.buttonList.add(this.actionPerformed(31, var1 + 2, var2 - 10, 83, 20, StatCollector.translateToLocal("dbc.KAHame10x.name")));
         this.buttonList.add(this.actionPerformed(32, var1 - 82, var2 + 15, 83, 20, StatCollector.translateToLocal("dbc.KAMakanko.name")));
         this.buttonList.add(this.actionPerformed(33, var1 + 2, var2 + 15, 83, 20, StatCollector.translateToLocal("dbc.KAMasenko.name")));
         this.buttonList.add(this.actionPerformed(34, var1 - 82, var2 + 40, 83, 20, StatCollector.translateToLocal("dbc.KAPlanetDest.name")));
         this.buttonList.add(new DBCGuiButtons01(100, var1 - 80, var2 + 65, 160, 20, StatCollector.translateToLocal("dbc.saagui.forgetattacks")));
         this.buttonList.add(new DBCGuiButtons01(10, var1 + 100, var2 - 80, 20, 20, "X"));
         this.buttonList.add(new DBCGuiButtons01(102, var1 - 125, var2 + 65, 40, 20, StatCollector.translateToLocal("dbc.saagui.back")));
      }

      if(this.saa == 4) {
         var2 -= 10;
         this.buttonList.add(this.actionPerformed(36, var1 - 82, var2 - 60, 83, 20, StatCollector.translateToLocal("dbc.KTKaioken.name")));
         this.buttonList.add(this.actionPerformed(35, var1 + 2, var2 - 60, 83, 20, StatCollector.translateToLocal("dbc.KASpiritbomb.name")));
         this.buttonList.add(new DBCGuiButtons01(100, var1 - 80, var2 + 65, 160, 20, StatCollector.translateToLocal("dbc.saagui.forgetattacks")));
         this.buttonList.add(new DBCGuiButtons01(10, var1 + 100, var2 - 80, 20, 20, "X"));
      }

      if(this.saa == 5) {
         this.buttonList.add(new DBCGuiButtons00(200, var1 - 83, var2 - 83, 83, 83, ""));
         this.buttonList.add(new DBCGuiButtons00(201, var1 + 0, var2 - 83, 83, 83, ""));
         this.buttonList.add(new DBCGuiButtons00(202, var1 - 83, var2 + 0, 83, 83, ""));
         this.buttonList.add(new DBCGuiButtons00(203, var1 + 0, var2 + 0, 83, 83, ""));
         this.buttonList.add(new DBCGuiButtons06(210, var1 + 85, var2 - 75, 40, 15, StatCollector.translateToLocal("dbc.saagui.Black")));
         this.buttonList.add(new DBCGuiButtons06(211, var1 + 85, var2 - 60, 40, 15, StatCollector.translateToLocal("dbc.saagui.White")));
         this.buttonList.add(new DBCGuiButtons06(212, var1 + 85, var2 - 45, 40, 15, StatCollector.translateToLocal("dbc.saagui.Purple")));
         this.buttonList.add(new DBCGuiButtons06(213, var1 + 85, var2 - 30, 40, 15, StatCollector.translateToLocal("dbc.saagui.Red")));
         this.buttonList.add(new DBCGuiButtons06(214, var1 + 85, var2 - 15, 40, 15, StatCollector.translateToLocal("dbc.saagui.Brown")));
         this.buttonList.add(new DBCGuiButtons06(215, var1 + 85, var2 + 0, 40, 15, StatCollector.translateToLocal("dbc.saagui.Orange")));
         this.buttonList.add(new DBCGuiButtons06(216, var1 + 85, var2 + 15, 40, 15, StatCollector.translateToLocal("dbc.saagui.Green")));
         this.buttonList.add(new DBCGuiButtons06(217, var1 + 85, var2 + 30, 40, 15, StatCollector.translateToLocal("dbc.saagui.Cyan")));
         this.buttonList.add(new DBCGuiButtons06(218, var1 + 85, var2 + 45, 40, 15, StatCollector.translateToLocal("dbc.saagui.Blue")));
         this.buttonList.add(new DBCGuiButtons01(10, var1 - 10, var2 + 65, 20, 20, "X"));
         this.buttonList.add(new DBCGuiButtons01(220, var1 + 83, var2 + 65, 43, 20, StatCollector.translateToLocal("dbc.saagui.accept")));
      }

   }

   public Object actionPerformed(int var1, int var2, int var3, int var4, int var5, String var6) {
      int var8 = var1 - 20;
      int var9 = 0;
      if(var8 == 1) {
         var9 = JRMCoreH.KABigBang;
      }

      if(var8 == 2) {
         var9 = JRMCoreH.KABlast;
      }

      if(var8 == 3) {
         var9 = JRMCoreH.KABurningAtt;
      }

      if(var8 == 4) {
         var9 = JRMCoreH.KADeathBeam;
      }

      if(var8 == 5) {
         var9 = JRMCoreH.KADodon;
      }

      if(var8 == 6) {
         var9 = JRMCoreH.KAEnergyDisk;
      }

      if(var8 == 7) {
         var9 = JRMCoreH.KAFinalFlash;
      }

      if(var8 == 8) {
         var9 = JRMCoreH.KAFingerLaser;
      }

      if(var8 == 9) {
         var9 = JRMCoreH.KAGalicGun;
      }

      if(var8 == 10) {
         var9 = JRMCoreH.KAKameHame;
      }

      if(var8 == 11) {
         var9 = JRMCoreH.KAKameHame10x;
      }

      if(var8 == 12) {
         var9 = JRMCoreH.KAMakanko;
      }

      if(var8 == 13) {
         var9 = JRMCoreH.KAMasenko;
      }

      if(var8 == 14) {
         var9 = JRMCoreH.KAPlanetDest;
      }

      if(var8 == 15) {
         var9 = JRMCoreH.KASpiritBomb;
      }

      if(var8 == 16) {
         var9 = JRMCoreH.KTKaioken;
      }

      Object var7;
      if(var9 == 1) {
         var7 = new DBCGuiButtons02(var1, var2, var3, var4, var5, var6);
      } else {
         var7 = new DBCGuiButtons01(var1, var2, var3, var4, var5, var6);
      }

      return var7;
   }

   public void actionPerformed(GuiButton var1) {
      if(var1.id == -1) {
         this.mc.thePlayer.openGui(mod_DragonBC.instance, 6, this.mc.thePlayer.worldObj, (int)this.mc.thePlayer.posX, (int)this.mc.thePlayer.posY, (int)this.mc.thePlayer.posZ);
      }

      if(var1.id == -2) {
         this.mc.thePlayer.openGui(mod_DragonBC.instance, 5, this.mc.thePlayer.worldObj, (int)this.mc.thePlayer.posX, (int)this.mc.thePlayer.posY, (int)this.mc.thePlayer.posZ);
      }

      if(var1.id == -3) {
         ;
      }

      if(var1.id == 0) {
         dbcSAA(20, var1.id);
         this.player();
      }

      if(var1.id == 10) {
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 21 || var1.id == 22 || var1.id == 23 || var1.id == 24 || var1.id == 25 || var1.id == 26 || var1.id == 27 || var1.id == 28 || var1.id == 29 || var1.id == 30 || var1.id == 31 || var1.id == 32 || var1.id == 33 || var1.id == 34 || var1.id == 35 || var1.id == 36 || var1.id == 100) {
         dbcSAA(var1.id);
         this.mc.thePlayer.closeScreen();
         if(var1.id != 100) {
            this.mc.thePlayer.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("dbc.saagui.newskill")));
         }
      }

      if(var1.id == 220) {
         this.mc.thePlayer.closeScreen();
         dbcHair(JRMCoreH.Har + JRMCoreH.Col);
      }

   }

   public void player() {
   }

   public static void dbcSAA(int var0, int var1) {
      System.out.println("dbcsaa channel is has not been set in DBCSAAGui " + var0 + " " + var1);
   }

   public static void dbcSAA(int var0) {
      int var1 = var0 + 100;
   }

   public static void dbcHair(String var0) {
      System.out.println("dbchalo channel is has not been set in DBCSAAGui " + var0);
   }

   public void drawScreen(int var1, int var2, float var3) {
      ScaledResolution var4 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var5 = var4.getScaledWidth();
      int var6 = var4.getScaledHeight();
      FontRenderer var7 = this.mc.fontRenderer;
      String var8 = "jinryuudragonbc:saa.png";
      String var9 = "jinryuudragonbc:saa2.png";
      short var10 = 256;
      short var11 = 160;
      int var12 = (this.width - var10) / 2;
      int var13 = (this.height - var11) / 2;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation var14 = new ResourceLocation(var8);
      this.mc.renderEngine.bindTexture(var14);
      this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
      if(this.saa == 5) {
         var8 = "jinryuudragonbc:gui/hairs.png";
         int var15 = 0;
         if(JRMCoreH.Col == "_C0") {
            var15 = 0;
         }

         if(JRMCoreH.Col == "_C1") {
            var15 = 16777200;
         }

         if(JRMCoreH.Col == "_C2") {
            var15 = 9265576;
         }

         if(JRMCoreH.Col == "_C3") {
            var15 = 16766976;
         }

         if(JRMCoreH.Col == "_C4") {
            var15 = 16724787;
         }

         if(JRMCoreH.Col == "_C5") {
            var15 = 6045747;
         }

         if(JRMCoreH.Col == "_C6") {
            var15 = 16744192;
         }

         if(JRMCoreH.Col == "_C7") {
            var15 = 25600;
         }

         if(JRMCoreH.Col == "_C8") {
            var15 = 5956839;
         }

         if(JRMCoreH.Col == "_C9") {
            var15 = 5683455;
         }

         float var16 = (float)(var15 >> 16 & 255) / 255.0F;
         float var17 = (float)(var15 >> 8 & 255) / 255.0F;
         float var18 = (float)(var15 & 255) / 255.0F;
         float var19 = 1.0F;
         GL11.glColor3f(var19 * var16, var19 * var17, var19 * var18);
         ResourceLocation var20 = new ResourceLocation(var8);
         this.mc.renderEngine.bindTexture(var20);
         this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
      }

      if(this.saa == 1) {
         int var36 = var11 - 10;
         int var37 = (this.width - var10) / 2;
         int var38 = (this.height - var36) / 2;
         this.drawTexturedModalRect(var37, var38, 0, 169, var10, 5);
         int var39 = var10 - 20;
         if(var39 < 1) {
            var39 = 1;
         }

         double var40 = (double)var39 * 0.01D;
         int var21 = (int)(var40 * (double)JRMCoreH.dbcEvilness);
         if(var21 > var10) {
            var21 = var10;
         }

         byte var22 = 5;
         int var23 = var11 - 10;
         int var24 = (this.width - var22) / 2 - var39 / 2 + var21;
         int var25 = var38 - 1;
         this.drawTexturedModalRect(var24, var25, 0, 175, var22, 7);
         String var26 = "";
         if(JRMCoreH.dbcBP != null && JRMCoreH.dbcBP.length > 0) {
            for(String var30 : JRMCoreH.dbcBP) {
               String[] var31 = var30.split(";");
               if(this.mc.thePlayer.getCommandSenderName().equals(var31[0])) {
                  var26 = var31[1];
               }
            }
         }

         this.current("BP: " + var26, 0, -71, var7, var5, var6);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         ResourceLocation var41 = new ResourceLocation(var9);
         this.mc.renderEngine.bindTexture(var41);
         this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
         int var42 = JRMCoreH.dbcTrainPoint;
         int var43 = JRMCoreH.jrmcExp;
         boolean var44 = false;
         int var45 = var44?16777215:8453920;
         String var34 = StatCollector.translateToLocal("dbc.saagui.curexp") + " " + var43;
         byte var32 = 5;
         byte var33 = 5;
         var7.drawString(var34, var32 + 1, var33, 0);
         var7.drawString(var34, var32 - 1, var33, 0);
         var7.drawString(var34, var32, var33 + 1, 0);
         var7.drawString(var34, var32, var33 - 1, 0);
         var7.drawString(var34, var32, var33, 8388564);
         this.current("" + JRMCoreH.kiPunch, 105, -10, var7, var5, var6);
         this.current("" + JRMCoreH.kiDash, -105, -10, var7, var5, var6);
         this.current("" + JRMCoreH.kiMax, -105, -35, var7, var5, var6);
         this.current("" + JRMCoreH.kiChargRa, 105, -35, var7, var5, var6);
         this.current("" + JRMCoreH.kiJump, -105, 15, var7, var5, var6);
         this.current("" + JRMCoreH.kiFly, 105, 15, var7, var5, var6);
         this.current("" + JRMCoreH.kiAsclvl, -105, 40, var7, var5, var6);
         this.current("" + JRMCoreH.kiAscPow, 105, 40, var7, var5, var6);
         this.current("" + JRMCoreH.dbcTrainPoint, 105, -60, var7, var5, var6);
         this.current("" + JRMCoreH.dbcHealth, -105, -60, var7, var5, var6);
         this.current2("" + JRMCoreH.kiPunch + "TP", 105, -10, var7, var5, var6);
         this.current2("" + JRMCoreH.kiDash + "TP", -105, -10, var7, var5, var6);
         this.current2("" + (JRMCoreH.kiMax / 50 <= 0?1:JRMCoreH.kiMax / 50) + "TP", -105, -35, var7, var5, var6);
         this.current2("" + JRMCoreH.kiChargRa + "TP", 105, -35, var7, var5, var6);
         this.current2("" + JRMCoreH.kiJump + "TP", -105, 15, var7, var5, var6);
         this.current2("" + JRMCoreH.kiFly + "TP", 105, 15, var7, var5, var6);
         this.current2("" + JRMCoreH.kiAsclvl * 20 + "TP", -105, 40, var7, var5, var6);
         this.current2("" + JRMCoreH.kiAscPow + "TP", 105, 40, var7, var5, var6);
         this.current2("5DBCxp", 106, -60, var7, var5, var6);
         this.current2("" + (JRMCoreH.dbcHealth / 50 <= 0?1:JRMCoreH.dbcHealth / 50) + "TP", -105, -60, var7, var5, var6);
      }

      super.drawScreen(var1, var2, var3);
   }

   public boolean doesGuiPauseGame() {
      return false;
   }

   public void current(String var1, int var2, int var3, FontRenderer var4, int var5, int var6) {
      int var7 = var4.getStringWidth(var1) / 2;
      int var8 = var5 / 2 + var2 - var7;
      int var9 = var6 / 2 + var3 + 8 - 6;
      var4.drawString(var1, var8 + 1, var9, 0);
      var4.drawString(var1, var8 - 1, var9, 0);
      var4.drawString(var1, var8, var9 + 1, 0);
      var4.drawString(var1, var8, var9 - 1, 0);
      var4.drawString(var1, var8, var9, 8388564);
   }

   public void current2(String var1, int var2, int var3, FontRenderer var4, int var5, int var6) {
      int var7 = var4.getStringWidth(var1) / 2;
      int var8 = var5 / 2 + var2 - var7;
      int var9 = var6 / 2 + var3 + 8 + 10 - 6;
      var4.drawString(var1, var8 + 1, var9, 0);
      var4.drawString(var1, var8 - 1, var9, 0);
      var4.drawString(var1, var8, var9 + 1, 0);
      var4.drawString(var1, var8, var9 - 1, 0);
      var4.drawString(var1, var8, var9, 8388564);
   }

   public void SagasPage(int var1, int var2) {
      this.textureFile = "jinryuudragonbc:sagas.png";
      this.ScouterRenderBlur(var1, var2);
   }

   public void SagasPrint() {
      this.initGui();
      Minecraft var1 = this.mc;
      WorldClient var2 = var1.theWorld;
      EntityClientPlayerMP var3 = var1.thePlayer;
      ScaledResolution var4 = new ScaledResolution(var1, var1.displayWidth, var1.displayHeight);
      int var5 = var4.getScaledWidth() / 2;
      int var6 = var4.getScaledHeight() / 2;
      boolean var7 = true;
      GL11.glEnable(3042);
      GL11.glEnable('\u803a');
      RenderHelper.enableStandardItemLighting();
      RenderHelper.disableStandardItemLighting();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.drawCenteredString(this.fontRendererObj, this.Process, var5 + this.wid, var6 + this.hei, 16768306);
      GL11.glDisable('\u803a');
      GL11.glDisable(3042);
   }

   public void SagasBack(int var1, int var2) {
      short var5 = 182;
      short var6 = 191;
      int var7 = (var1 - var5) / 2;
      int var8 = (var2 - var6) / 2;
      String var9 = "jinryuudragonbc:sagas.png";
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation var10 = new ResourceLocation(var9);
      this.mc.renderEngine.bindTexture(var10);
      this.drawTexturedModalRect(var7, var8, 0, 0, var5, var6);
   }

   public void ScouterRenderBlur(int var1, int var2) {
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3008);
      ResourceLocation var3 = new ResourceLocation(this.textureFile);
      this.mc.renderEngine.bindTexture(var3);
      Tessellator var4 = Tessellator.instance;
      var4.startDrawingQuads();
      var4.addVertexWithUV(0.0D, (double)var2, -90.0D, 0.0D, 1.0D);
      var4.addVertexWithUV((double)var1, (double)var2, -90.0D, 1.0D, 1.0D);
      var4.addVertexWithUV((double)var1, 0.0D, -90.0D, 1.0D, 0.0D);
      var4.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
      var4.draw();
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glEnable(3008);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }
}
