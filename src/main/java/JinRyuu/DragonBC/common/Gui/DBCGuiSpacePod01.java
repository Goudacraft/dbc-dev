package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.Gui.DBCGuiButtonsC;
import JinRyuu.DragonBC.common.p.DBCPspacepod1;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.p.PD;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class DBCGuiSpacePod01 extends GuiScreen {
   public World world;
   public EntityPlayer player;
   public Minecraft mc;
   public int planet20;
   int px;
   int py;
   int pz;
   public static String guired = "jinryuudragonbc:guibutton05.png";
   public static String guigreen = "jinryuudragonbc:guibutton06.png";
   public static String buttontex = "";
   public static int spon = 0;
   public static int spoff = 0;
   public static int spstart = 0;
   public static int sp3 = 0;
   public static int sp2 = 0;
   public static int sp1 = 0;
   public static int ToNamek = 0;
   public static int ToVegeta = 0;
   public static int ToEarth = 0;
   public final int xSizeOfTexture;
   public final int ySizeOfTexture;
   public static int loadtime = 100;
   public static int sc = -1;
   public static int ss = 0;
   public static int ssl = 0;
   public static int ssD = 0;
   public static final int screen_OFF = -1;
   public static final int screen_Loading = 0;
   public static final int screen_MainMenu = 1;
   public static final int screen_Destinations = 2;
   public static final int screen_Travelling = 3;
   public static final int screen_Arrived = 4;
   public static final int panel_left_mode = 0;
   public static final int panel_mid_on = 1;
   public static final int panel_right_ok = 2;
   public static final ResourceLocation Panel = new ResourceLocation("jinryuudragonbc:sppanel.png");
   public static final int[] dests = new int[]{DBCConfig.planetEarth, DBCConfig.planetNamek, DBCConfig.planetVegeta};
   public static final int[] destsTP = new int[]{3, 1, 2};

   public DBCGuiSpacePod01(int var1, int var2, int var3) {
      this.world = DBCClient.mc.theWorld;
      this.player = DBCClient.mc.thePlayer;
      this.mc = DBCClient.mc;
      this.planet20 = 0;
      this.xSizeOfTexture = 400;
      this.ySizeOfTexture = 300;
      this.px = var1;
      this.py = var2;
      this.pz = var3;
   }

   public void initGui() {
      this.buttonList.clear();
   }

   public void actionPerformed2(GuiButton var1) {
      EntityClientPlayerMP var2 = this.mc.thePlayer;
      WorldClient var3 = this.mc.theWorld;
      if(var1.id == 0) {
         if(spon == 0) {
            spon = 1;
         } else {
            this.spResetCounters();
         }
      }

      if(var1.id == 1) {
         this.spResetCounters();
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 2) {
         if(sp3 == 0 && sp2 == 0 && sp1 == 0) {
            this.mc.thePlayer.closeScreen();
            this.spResetCounters();
         }

         if(sp3 == 1 && sp2 == 0 && sp1 == 0) {
            this.mc.thePlayer.closeScreen();
            ToEarth = 1;
            ToNamek = 0;
            ToVegeta = 0;
            this.spResetCounters();
         }

         if(sp3 == 0 && sp2 == 1 && sp1 == 0) {
            this.mc.thePlayer.closeScreen();
            ToEarth = 0;
            ToNamek = 0;
            ToVegeta = 1;
            this.spResetCounters();
         }

         if(sp3 == 0 && sp2 == 0 && sp1 == 1) {
            this.mc.thePlayer.closeScreen();
            ToEarth = 0;
            ToNamek = 1;
            ToVegeta = 0;
            this.spResetCounters();
         }

         if(ToEarth == 1) {
            ToEarth = 0;
            ToNamek = 0;
            ToVegeta = 0;
            byte var4 = 3;
            PD.sendToServer(new DBCPspacepod1((byte)var4));
         }

         if(ToVegeta == 1) {
            ToEarth = 0;
            ToNamek = 0;
            ToVegeta = 0;
            byte var5 = 2;
            PD.sendToServer(new DBCPspacepod1((byte)var5));
         }

         if(ToNamek == 1) {
            ToEarth = 0;
            ToNamek = 0;
            ToVegeta = 0;
            byte var6 = 1;
            PD.sendToServer(new DBCPspacepod1((byte)var6));
         }
      }

      if(var1.id == 3) {
         sp3 = 1;
         sp2 = 0;
         sp1 = 0;
      }

      if(var1.id == 4) {
         sp3 = 0;
         sp2 = 1;
         sp1 = 0;
      }

      if(var1.id == 5) {
         sp3 = 0;
         sp2 = 0;
         sp1 = 1;
      }

      if(var1.id == 6) {
         sp3 = 0;
         sp2 = 0;
         sp1 = 0;
         ToEarth = 0;
         ToNamek = 0;
         ToVegeta = 0;
      }

   }

   public void spResetCounters() {
      spon = 0;
      spoff = 0;
      spstart = 0;
      sp3 = 0;
      sp2 = 0;
      sp1 = 0;
   }

   public void actionPerformed(GuiButton var1) {
      if(var1.id == 1) {
         if(sc == -1) {
            loadtime = 100;
            sc = 0;
         } else {
            sc = -1;
            this.mc.thePlayer.closeScreen();
         }
      } else if(var1.id == 0) {
         if(sc == 2) {
            ++ss;
            if(ss > ssl) {
               ss = 0;
            }
         }
      } else if(var1.id == 2) {
         if(sc == 1) {
            sc = 2;
         } else if(sc == 2) {
            switch(ss) {
            case 0:
               sc = 1;
               break;
            case 1:
               PD.sendToServer(new DBCPspacepod1(ssD));
               sc = 1;
               break;
            case 2:
               PD.sendToServer(new DBCPspacepod1(ssD));
               sc = 1;
            case 3:
            }
         }

         ss = 0;
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      this.buttonList.clear();
      ScaledResolution var4 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var5 = var4.getScaledWidth();
      int var6 = var4.getScaledHeight();
      FontRenderer var7 = this.fontRendererObj;
      String var8 = "jinryuudragonbc:spacepodGUI01.png";
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation var9 = new ResourceLocation(var8);
      this.mc.renderEngine.bindTexture(var9);
      Tessellator var10 = Tessellator.instance;
      var10.startDrawingQuads();
      var10.addVertexWithUV(0.0D, (double)var6, -90.0D, 0.0D, 1.0D);
      var10.addVertexWithUV((double)var5, (double)var6, -90.0D, 1.0D, 1.0D);
      var10.addVertexWithUV((double)var5, 0.0D, -90.0D, 1.0D, 0.0D);
      var10.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
      var10.draw();
      int var11 = this.width / 2;
      int var12 = this.height / 2;
      short var13 = 140;
      byte var14 = 70;
      int var15 = (this.width - var13) / 2;
      int var16 = (this.height - var14) / 2;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation var17 = Panel;
      this.mc.renderEngine.bindTexture(var17);
      this.drawTexturedModalRect(var11 - 90, var12 - 44, 0, 0 + (sc == -1?0:70), var13, var14);
      this.buttonList.add(0, new DBCGuiButtonsC(0, var11 - 90, var12 + 29, 50, 15, "", guigreen));
      this.buttonList.add(1, new DBCGuiButtonsC(1, var11 - 35, var12 + 29, 30, 15, "On", guired));
      this.buttonList.add(2, new DBCGuiButtonsC(2, var11 + 0, var12 + 29, 50, 15, "", guigreen));
      if(sc == -1) {
         ((DBCGuiButtonsC)this.buttonList.get(0)).displayString = "";
         ((DBCGuiButtonsC)this.buttonList.get(1)).displayString = JRMCoreH.trl("jrmc", "On");
         ((DBCGuiButtonsC)this.buttonList.get(2)).displayString = "";
      } else if(sc == 0) {
         if(loadtime > 0) {
            ((DBCGuiButtonsC)this.buttonList.get(0)).displayString = "";
            ((DBCGuiButtonsC)this.buttonList.get(1)).displayString = "";
            ((DBCGuiButtonsC)this.buttonList.get(2)).displayString = "";
            --loadtime;
            var7.drawString(JRMCoreH.cllg + "LOADING LAUNCHER", var11 - 70, var12 - 30, 0);
         } else {
            sc = 1;
         }
      } else if(sc == 1) {
         ((DBCGuiButtonsC)this.buttonList.get(0)).displayString = JRMCoreH.trl("jrmc", "Select");
         ((DBCGuiButtonsC)this.buttonList.get(1)).displayString = JRMCoreH.trl("jrmc", "Off");
         ((DBCGuiButtonsC)this.buttonList.get(2)).displayString = JRMCoreH.trl("jrmc", "OK");
         var7.drawString(JRMCoreH.cllg + JRMCoreH.trl("jrmc", "Planet") + ": " + JRMCoreH.cly + JRMCoreH.trl("dbc", (String)DBCH.plntNms.get(Integer.valueOf(DBCClient.mc.thePlayer.dimension))), var11 - 80, var12 - 40, 0);
         ssl = 0;
         var7.drawString(JRMCoreH.cllg + "> " + JRMCoreH.trl("jrmc", "Destinations"), var11 - 70, var12 - 20, 0);
      } else if(sc == 2) {
         ((DBCGuiButtonsC)this.buttonList.get(0)).displayString = JRMCoreH.trl("jrmc", "Select");
         ((DBCGuiButtonsC)this.buttonList.get(1)).displayString = JRMCoreH.trl("jrmc", "Off");
         ((DBCGuiButtonsC)this.buttonList.get(2)).displayString = JRMCoreH.trl("jrmc", "OK");
         var7.drawString(JRMCoreH.cllg + JRMCoreH.trl("jrmc", "Destinations"), var11 - 80, var12 - 40, 0);
         ssl = 2;
         var7.drawString(JRMCoreH.cly + "> ", var11 - 70, var12 - 30 + ss * 10, 0);
         int var18 = 0;
         var7.drawString(JRMCoreH.cly + JRMCoreH.trl("jrmc", "Back"), var11 - 60, var12 - 30 + var18 * 10, 0);
         ++var18;

         for(int var19 = 0; var19 < dests.length; ++var19) {
            if(DBCClient.mc.thePlayer.dimension != dests[var19]) {
               if(ss == var18) {
                  ssD = destsTP[var19];
               }

               var7.drawString(JRMCoreH.cllg + (String)DBCH.plntNms.get(Integer.valueOf(dests[var19])), var11 - 60, var12 - 30 + var18 * 10, 0);
               ++var18;
            }
         }
      }

      super.drawScreen(var1, var2, var3);
   }

   public boolean doesGuiPauseGame() {
      return false;
   }
}
