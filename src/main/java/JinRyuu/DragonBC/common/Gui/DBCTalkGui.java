package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.DBCKiAttacks;
import JinRyuu.DragonBC.common.DBCKiTech;
import JinRyuu.DragonBC.common.Gui.DBCGuiButtons01;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBCKami;
import JinRyuu.DragonBC.common.p.DBCPdri;
import JinRyuu.DragonBC.common.p.DBCPwish;
import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreGuiButtons00MS;
import JinRyuu.JRMCore.JRMCoreGuiButtons01;
import JinRyuu.JRMCore.JRMCoreGuiScreen;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHDBC;
import JinRyuu.JRMCore.JRMCoreM;
import JinRyuu.JRMCore.p.PD;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class DBCTalkGui extends GuiScreen {
   private Minecraft mc = JRMCoreClient.mc;
   private FontRenderer fontRenderer;
   private int tick;
   private GuiIngame Guiingame;
   private int wish;
   private int ipg;
   private int lp;
   private int master;
   private HashMap<String, String> MsnSysTalkTo;
   private String CurMaster;
   private String name;
   private int text;
   protected GuiTextField inputField;
   private String defaultInputFieldText;
   private int updateTimer;
   private int updateTime;
   private boolean updateTimerStopper;
   public static int count = 0;
   public static int warn = 0;
   public static int startcount = 0;
   private String Process;
   private int wid;
   private int hei;
   private String textureFile;

   public void renderSuperProtect(int var1) {
      this.buttonList.clear();
      int var2 = this.width / 2;
      int var3 = this.height / 2;
      this.buttonList.add(new DBCGuiButtons01(100, var2 - 0, var3 - 0, 20, 20, "TEST"));
   }

   public DBCTalkGui(int var1, World var2, int var3, int var4, int var5) {
      this.fontRenderer = this.mc.fontRenderer;
      this.wish = 0;
      this.ipg = 0;
      this.lp = 0;
      this.master = 0;
      this.CurMaster = "";
      this.name = "";
      this.text = 0;
      this.defaultInputFieldText = "";
      this.updateTimer = 0;
      this.updateTime = 0;
      this.updateTimerStopper = false;
      this.Process = "Something is Wrong";
      this.wid = 0;
      this.hei = 0;
      this.textureFile = "jinryuudragonbc:sagas.png";
      double var6 = 0.1D;
      AxisAlignedBB var8 = AxisAlignedBB.getBoundingBox((double)var3 - var6, (double)var4 + var6, (double)var5 - var6, (double)var3 + var6, (double)var4 + var6, (double)var5 + var6);
      List var9 = var2.getEntitiesWithinAABB(EntityDBCKami.class, var8);
      Iterator var10 = var9.iterator();
      if(var10.hasNext()) {
         EntityDBCKami var11 = (EntityDBCKami)var10.next();
         this.CurMaster = var11.getCommandSenderName();
      }

      this.wish = var1;
      this.updateTime = 0;
      JRMCoreH.revTmr = -1;
      JRMCoreH.Master = 1;
      this.MsnSysTalkTo = JRMCoreM.getMda_Obj_TalkTo();
      if(this.wish == 13) {
         DBCKiAttacks.dbctick(-100);
      }

      if(this.wish == 12) {
         DBCKiAttacks.dbctick(-101);
      }

      if(this.wish == 15) {
         DBCKiAttacks.dbctick(-101);
      }

      if(this.wish == 16) {
         DBCKiAttacks.dbctick(-101);
      }

      if(this.wish == 17) {
         DBCKiAttacks.dbctick(-101);
      }

      if(this.wish == 18) {
         DBCKiAttacks.dbctick(-101);
      }

      if(this.wish == 19) {
         DBCKiAttacks.dbctick(-101);
      }

   }

   public void initGui() {
   }

   public void actionPerformed(GuiButton var1) {
      if(var1.id == -1) {
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 0) {
         this.dbcWish(var1.id);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 1) {
         this.dbcWish(var1.id);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 2) {
         this.dbcWish(var1.id);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 3) {
         this.dbcWish(var1.id);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 4) {
         this.dbcWish(var1.id);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 10) {
         this.dbcWish(var1.id);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 11) {
         this.dbcWish(var1.id);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 12) {
         this.dbcWish(var1.id);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 13) {
         this.dbcWish(var1.id);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 14) {
         this.dbcWish(var1.id);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 99) {
         this.updateTime = 0;
         if(this.wish == 10) {
            this.wish = 1001;
         } else if(this.wish == 1001) {
            this.wish = 10;
         }
      }

      if(var1.id == 100) {
         this.dbcTelep(var1.id);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 101) {
         this.dbcTelep(var1.id);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 103) {
         this.wish = 121;
      }

      if(var1.id == 104) {
         this.wish = 12;
      }

      if(var1.id == 105) {
         this.mc.thePlayer.closeScreen();
         JRMCoreH.Char((byte)101, (byte)0);
      }

      if(var1.id == 106) {
         JRMCoreH.Char((byte)104, (byte)0);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 107) {
         this.wish = 1102;
      }

      if(var1.id == 108) {
         this.wish = 1104;
      }

      if(var1.id == 109) {
         JRMCoreH.Char((byte)105, (byte)0);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 198) {
         this.wish = 113;
      }

      if(var1.id == 110) {
         this.wish = 1105;
      }

      for(int var2 = 0; var2 < 10; ++var2) {
         if(var1.id == 10111 + var2) {
            this.wish = 111 + var2;
         }

         if(var1.id == 101111 + var2 * 10) {
            this.wish = 1111 + var2 * 10;
         }
      }

      if(var1.id == 199) {
         this.dbcWish(var1.id);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 201) {
         this.mc.thePlayer.closeScreen();
         JRMCoreH.Char((byte)4, (byte)0);
         JRMCoreH.Char((byte)100, (byte)0);
         JRMCoreH.resetChar();
         DBCKiTech.turbo = false;
      }

      if(var1.id == 2011) {
         this.wish = 1101;
      }

      if(var1.id == 2012) {
         this.wish = 11;
      }

      if(var1.id == 202) {
         if(JRMCoreH.align > 65) {
            this.dbcWish(var1.id);
         } else {
            this.dbcWish(var1.id + 1);
         }

         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 203) {
         this.dri(JRMCoreH.SagaProg + 100 - 6);
         this.mc.thePlayer.closeScreen();
      }

      if(var1.id == 204) {
         int var6 = JRMCoreH.SagaSideProg + 100 - 6;
         int var3 = var6 / 10000;
         int var4 = var6 / 100 - var3 * 100;
         int var5 = var6 - var3 * 10000 - var4 * 100;
         JRMCoreH.quad(2, var3, var4, var5);
         this.mc.thePlayer.closeScreen();
      }

      if(var1 instanceof JRMCoreGuiButtons00MS && var1.id == 6000) {
         JRMCoreGuiButtons00MS var7 = (JRMCoreGuiButtons00MS)var1;
         if(var7.d2.equals("-3")) {
            this.mc.thePlayer.closeScreen();
         }

         JRMCoreGuiScreen.dataSend(var7.d1, var7.d2);
      }

      for(int var8 = 0; var8 < JRMCoreH.vlblSkls.length; ++var8) {
         if(var1.id == 1000 + var8) {
            JRMCoreH.Skll((byte)1, (byte)var8);
         }
      }

      for(byte var9 = 0; var9 < (JRMCoreH.Pwrtyp == 2?JRMCoreH.pmj:JRMCoreH.pmdbc).length; ++var9) {
         if(var1.id == 4200 + var9) {
            JRMCoreH.Tech((byte)4, "" + var9);
            this.wish = (this.wish - 1000) / 10;
            this.ipg = 0;
         }
      }

      if((this.name.matches("[0-9].+") || this.name.matches("[0-9]+")) && this.name.length() > 0) {
         this.name = (Float.parseFloat(this.name) > 5000.0F?5000.0F:(Float.parseFloat(this.name) < 0.1F?0.1F:Float.parseFloat(this.name))) + "";
         if(var1.id == 210) {
            PD.sendToServer(new DBCPwish(2, "0;" + this.name));
            this.mc.thePlayer.closeScreen();
         }

         if(var1.id == 211) {
            PD.sendToServer(new DBCPwish(2, "1;" + this.name));
            this.mc.thePlayer.closeScreen();
         }

         if(var1.id == 212) {
            PD.sendToServer(new DBCPwish(2, "2;" + this.name));
            this.mc.thePlayer.closeScreen();
         }
      }

   }

   public void dri(int var1) {
      PD.sendToServer(new DBCPdri(var1));
   }

   public void dbcWish(int var1) {
      PD.sendToServer(new DBCPwish(1, var1 + ""));
   }

   public void dbcTelep(int var1) {
      PD.sendToServer(new DBCPwish(1, var1 + ""));
   }

   private void name(FontRenderer var1, int var2, int var3) {
      this.inputField = new GuiTextField(var1, var2 + 100, var3 + 15 + 0, 100, 12);
      this.inputField.setMaxStringLength(20);
      this.inputField.setEnableBackgroundDrawing(true);
      this.inputField.setFocused(true);
      this.inputField.setText(this.defaultInputFieldText);
      this.inputField.setCanLoseFocus(true);
   }

   public void updateScreen() {
      if(this.inputField != null) {
         this.inputField.updateCursorCounter();
      }

   }

   protected void keyTyped(char var1, int var2) {
      super.keyTyped(var1, var2);
      if(this.inputField != null) {
         this.inputField.textboxKeyTyped(var1, var2);
      }

   }

   protected void mouseClicked(int var1, int var2, int var3) {
      super.mouseClicked(var1, var2, var3);
      if(this.inputField != null) {
         this.inputField.mouseClicked(var1, var2, var3);
      }

   }

   public void sklLrn(int var1, int var2, int var3) {
      this.buttonList.add(new DBCGuiButtons01(JRMCoreH.SklLvl(var1, (byte)1) < 1?1000 + var1:-1, var2, var3, 83, 20, JRMCoreH.trl("dbc", JRMCoreH.vlblSklsNms[var1])));
      this.mc.fontRenderer.drawString(JRMCoreH.SklLvl(var1, (byte)1) < 1?JRMCoreH.trl("dbc.talkgui.cost") + ": " + JRMCoreH.vlblSklsLvl[var1][0] * 5:JRMCoreH.trl("dbc.talkgui.owned"), var2 + 120, var3, 0);
   }

   public void sklLrn(int var1, int var2, int var3, boolean var4) {
      DBCGuiButtons01 var5 = new DBCGuiButtons01(JRMCoreH.SklLvl(var1, (byte)1) < 1?1000 + var1:-1, var2, var3, 83, 20, JRMCoreH.trl("dbc", JRMCoreH.vlblSklsNms[var1]));
      var5.enabled = var4;
      this.buttonList.add(var5);
      this.mc.fontRenderer.drawString(JRMCoreH.SklLvl(var1) < 1?JRMCoreH.trl("dbc.talkgui.cost") + ": " + JRMCoreH.vlblSklsLvl[var1][0] * 5:JRMCoreH.trl("dbc.talkgui.owned"), var2 + 120, var3, 0);
   }

   public void drawScreen(int var1, int var2, float var3) {
      ScaledResolution var4 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var5 = var4.getScaledWidth();
      int var6 = var4.getScaledHeight();
      FontRenderer var7 = this.mc.fontRenderer;
      this.buttonList.clear();
      ++this.tick;
      if(this.tick >= 20) {
         this.tick = 0;
         JRMCoreH.jrmct(1);
         JRMCoreH.jrmct(3);
      }

      int var8 = this.width / 2;
      int var9 = this.height / 2;
      short var10 = 256;
      short var11 = 160;
      int var12 = (this.width - var10) / 2;
      int var13 = (this.height - var11) / 2;
      boolean var14 = true;
      if(this.MsnSysTalkTo != null) {
         String var15 = EntityList.createEntityByName((String)this.MsnSysTalkTo.get("N"), (World)null).getCommandSenderName();
         if(var15.equalsIgnoreCase(this.CurMaster)) {
            var14 = false;
            String var16 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var17 = new ResourceLocation(var16);
            this.mc.renderEngine.bindTexture(var17);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            int var18 = 0;
            this.Process = var15;
            var18 = var18 + JRMCoreH.txt(this.Process, "\u00a78", 0, true, var12 + 6, var13 + 5 + var18 * 10, 0);
            boolean var19 = Boolean.parseBoolean((String)this.MsnSysTalkTo.get("translated"));
            this.Process = JRMCoreH.trl((String)this.MsnSysTalkTo.get("G"));
            var18 = var18 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var18 * 10, 0);
            this.Process = JRMCoreH.trl((String)this.MsnSysTalkTo.get("B"));
            int var20 = var7.getStringWidth(this.Process) + 8;
            this.buttonList.add(new JRMCoreGuiButtons00MS(6000, var12 + var10 - 6 - var20, var13 + var11 - 5 - 20, var20, 20, this.Process, 0, (String)this.MsnSysTalkTo.get("series"), "-3"));
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
         }
      }

      if(var14) {
         if(this.wish == 10) {
            var10 = 182;
            var11 = 191;
            var12 = (this.width - var10) / 2;
            var13 = (this.height - var11) / 2;
            this.drawBg("enma", var10, var11);
            int var32 = (int)(System.currentTimeMillis() / 1000L);
            if(this.updateTime < var32) {
               this.updateTime = var32 + 5;
               DBCH.packDuo(-1, 0);
            }

            int var214 = 0;
            int var249 = 0;
            int var278 = JRMCoreH.Algnmnt(JRMCoreH.align);
            var249 = JRMCoreH.txt(JRMCoreH.trl("dbc.talkgui.enmawelcome" + (var278 == 0?"G":(var278 == 1?"N":"E"))), JRMCoreH.clb, 0, true, var12 + 5, var13 + 5 + var214 * 10, 175);
            var214 = var214 + var249;
            if(DBCConfig.Reinc > 0.0F) {
               String var70 = JRMCoreH.trl("dbc.talkgui.reincarnate");
               int var112 = var7.getStringWidth(var70);
               this.buttonList.add(new DBCGuiButtons01(99, var12 + var10 / 2 - var112 / 2 - 5, var13 + 5 + var214 * 21 - var249 * 10, var112 + 10, 20, var70));
               ++var214;
            }

            if(JRMCoreH.revTmr > 0 && DBCConfig.FreeRev) {
               String var72 = JRMCoreH.trl("dbc.talkgui.revivetime", new Object[]{JRMCoreH.format_lz2(new Object[]{Integer.valueOf(JRMCoreH.revTmr / 1 % 60)}), JRMCoreH.format_lz2(new Object[]{Integer.valueOf(JRMCoreH.revTmr / 60 % 60)}), JRMCoreH.format_lz2(new Object[]{Integer.valueOf(JRMCoreH.revTmr / 3600 % 24)}), JRMCoreH.format_lz2(new Object[]{Integer.valueOf(JRMCoreH.revTmr / 86400)})});
               int var114 = var7.getStringWidth(var72);
               var7.drawString(var72, var12 + var10 / 2 - var114 / 2, var13 + 12 + var214 * 21 - var249 * 10, 0);
               ++var214;
               var72 = JRMCoreH.trl("dbc.talkgui.revfree");
               var114 = var7.getStringWidth(var72);
               DBCGuiButtons01 var21 = new DBCGuiButtons01(-1, var8 - var114 / 2 - 5, var13 + 5 + var214 * 21 - var249 * 10, var114 + 10, 20, var72);
               var21.enabled = false;
               this.buttonList.add(var21);
               ++var214;
            } else if(JRMCoreH.revTmr == 0) {
               String var71 = JRMCoreH.trl("dbc.talkgui.revfree");
               int var113 = var7.getStringWidth(var71);
               this.buttonList.add(new DBCGuiButtons01(100, var8 - var113 / 2 - 5, var13 + 5 + var214 * 21 - var249 * 10, var113 + 10, 20, var71));
               ++var214;
            }

            String var74 = JRMCoreH.trl("dbc.talkgui.stay");
            int var116 = var7.getStringWidth(var74);
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - var116 / 2 - 5, var13 + 5 + var214 * 21 - var249 * 10, var116 + 10, 20, var74));
            ++var214;
         }

         if(this.wish == 1001) {
            var10 = 182;
            var11 = 191;
            var12 = (this.width - var10) / 2;
            var13 = (this.height - var11) / 2;
            this.drawBg("enma", var10, var11);
            int var33 = (int)(System.currentTimeMillis() / 1000L);
            if(this.updateTime < var33 && !this.updateTimerStopper) {
               this.updateTime = var33 + 10;
            }

            this.updateTimer = this.updateTime - var33;
            if(this.updateTimer <= 0 && !this.updateTimerStopper) {
               this.updateTimerStopper = true;
            }

            int var218 = 0;
            int var251 = 0;
            var251 = JRMCoreH.txt(JRMCoreH.trl("dbc.talkgui.enmareincarnate", new Object[]{(int)(DBCConfig.Reinc * 100.0F) + "%"}), JRMCoreH.clb, 0, true, var12 + 5, var13 + 5 + var218 * 10, 175);
            var218 = var218 + var251;
            this.buttonList.add(new DBCGuiButtons01(99, var12 + var10 / 2 - 40 - 5, var13 + 10 + var218 * 21 - var251 * 10, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
            ++var218;
            if(this.updateTimer <= 0) {
               this.buttonList.add(new DBCGuiButtons01(101, var12 + var10 / 2 - 40 - 5, var13 + 10 + var218 * 21 - var251 * 10, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
               ++var218;
            } else {
               String var75 = JRMCoreH.trl("dbc.talkgui.enmareincavilabl", new Object[]{JRMCoreH.format_lz2(new Object[]{Integer.valueOf(this.updateTimer % 60)})});
               int var117 = var7.getStringWidth(var75);
               var7.drawString(var75, var12 + var10 / 2 - var117 / 2, var13 + 10 + var218 * 21 - var251 * 10 + 5, 0);
               ++var218;
            }
         }

         if(this.wish == 11) {
            this.master = 5;
            int var34 = 0;
            if(JRMCoreH.SagaProg == 1700) {
               this.buttonList.add(new DBCGuiButtons01(203, var8 - 35, var9 - 5, 100, 20, StatCollector.translateToLocal("dbc.MainSaga.17.1")));
            } else if(JRMCoreH.SagaSideProg == 10100) {
               this.buttonList.add(new DBCGuiButtons01(204, var8 - 35, var9 - 5, 100, 20, StatCollector.translateToLocal("dbc.sidesagas.101.talkok")));
            } else {
               if((JRMCoreH.Race == 1 || JRMCoreH.Race == 2) && (JRMCoreH.TlMd == 3 || JRMCoreH.TlMd == 4)) {
                  String var76 = JRMCoreH.trl("dbc.talkgui.kami.forcetailregrow");
                  int var118 = this.fontRendererObj.getStringWidth(var76) + 8;
                  this.buttonList.add(new DBCGuiButtons01(108, var8 + 115 - var118, var9 + 15 + var34 * 21, var118, 20, var76));
                  ++var34;
               }

               if((JRMCoreH.Race == 1 || JRMCoreH.Race == 2) && (JRMCoreH.TlMd == -1 || JRMCoreH.TlMd == 0 || JRMCoreH.TlMd == 1)) {
                  String var77 = JRMCoreH.trl("dbc.talkgui.kami.cutdowntail");
                  int var119 = this.fontRendererObj.getStringWidth(var77) + 8;
                  this.buttonList.add(new DBCGuiButtons01(107, var8 + 115 - var119, var9 + 15 + var34 * 21, var119, 20, var77));
                  ++var34;
               }

               String var78 = JRMCoreH.trl("dbc.talkgui.anew");
               int var120 = this.fontRendererObj.getStringWidth(var78) + 8;
               this.buttonList.add(new DBCGuiButtons01(2011, var8 + 115 - var120, var9 + 15 + var34 * 21, var120, 20, var78));
               ++var34;
               var78 = JRMCoreH.trl("dbc.talkgui.skills");
               var120 = this.fontRendererObj.getStringWidth(var78) + 8;
               this.buttonList.add(new DBCGuiButtons01(this.wish + 10100, var8 + 115 - var120, var9 + 15 + var34 * 21, var120, 20, var78));
               ++var34;
               var34 = 0;
               var78 = JRMCoreH.trl("dbc.talkgui.giveweights");
               var120 = this.fontRendererObj.getStringWidth(var78) + 8;
               this.buttonList.add(new DBCGuiButtons01(110, var8 - 115 - 0, var9 + 15 + var34 * 21, var120, 20, var78));
               ++var34;
            }

            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
         }

         if(this.wish == 1101) {
            this.buttonList.add(new DBCGuiButtons01(2012, var8 - 35, var9 + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
            this.buttonList.add(new DBCGuiButtons01(201, var8 - 120, var9 + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
         }

         if(this.wish == 1102) {
            this.buttonList.add(new DBCGuiButtons01(2012, var8 - 35, var9 + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
            this.buttonList.add(new DBCGuiButtons01(106, var8 - 120, var9 + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
         }

         if(this.wish == 1104) {
            this.buttonList.add(new DBCGuiButtons01(2012, var8 - 35, var9 + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
            this.buttonList.add(new DBCGuiButtons01(109, var8 - 120, var9 + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
         }

         if(this.wish == 1105) {
            String var39 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var81 = new ResourceLocation(var39);
            this.mc.renderEngine.bindTexture(var81);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            int var123 = 0;
            this.Process = StatCollector.translateToLocal("dbc.talkgui.giveweightsdesc");
            var123 = var123 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var123 * 10, 0);
            int var223 = 0;
            String var253 = JRMCoreH.trl("dbc.talkgui.weightamount");
            int var279 = this.fontRendererObj.getStringWidth(var253) + 8;
            ++this.text;
            if(this.text == 1) {
               this.name(var7, var8 - 220 + var279, var9 - 25 + var223 * 21);
               this.inputField.setText("5");
            } else {
               this.text = 2;
            }

            if(this.inputField != null) {
               this.inputField.drawTextBox();
               this.name = this.inputField.getText();
               var7.drawString(var253, var8 - 120, var9 - 7 + var223 * 21, 0);
            }

            ++var223;
            var253 = ItemsDBC.ItemWeightHandLeg.getItemStackDisplayName(new ItemStack(ItemsDBC.ItemWeightHandLeg));
            var279 = this.fontRendererObj.getStringWidth(var253) + 8;
            if(this.master == 6) {
               this.buttonList.add(new DBCGuiButtons01(210, var8 - 120, var9 - 15 + var223 * 21, var279, 20, var253));
               ++var223;
            }

            var253 = ItemsDBC.ItemWeightShell.getItemStackDisplayName(new ItemStack(ItemsDBC.ItemWeightShell));
            var279 = this.fontRendererObj.getStringWidth(var253) + 8;
            if(this.master == 2) {
               this.buttonList.add(new DBCGuiButtons01(211, var8 - 120, var9 - 15 + var223 * 21, var279, 20, var253));
               ++var223;
            }

            var253 = ItemsDBC.ItemWeightShirt.getItemStackDisplayName(new ItemStack(ItemsDBC.ItemWeightShirt));
            var279 = this.fontRendererObj.getStringWidth(var253) + 8;
            if(this.master == 6 || this.master == 5) {
               this.buttonList.add(new DBCGuiButtons01(212, var8 - 120, var9 - 15 + var223 * 21, var279, 20, var253));
               ++var223;
            }
         }

         if(this.wish == 111) {
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
            String var40 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var82 = new ResourceLocation(var40);
            this.mc.renderEngine.bindTexture(var82);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            var8 = this.width / 2;
            var9 = this.height / 2;
            var7.drawString("TP: " + JRMCoreH.curTP, var12 + 5, var13 + 5, 0);
            int var125 = 0;
            this.sklLrn(1, var12 + 5, var13 + 25 + var125 * 21);
            ++var125;
            this.sklLrn(3, var12 + 5, var13 + 25 + var125 * 21);
            ++var125;
            this.sklLrn(5, var12 + 5, var13 + 25 + var125 * 21);
            ++var125;
            this.sklLrn(4, var12 + 5, var13 + 25 + var125 * 21);
            ++var125;
            this.sklLrn(7, var12 + 5, var13 + 25 + var125 * 21);
            ++var125;
            this.sklLrn(6, var12 + 5, var13 + 25 + var125 * 21);
            ++var125;
         }

         if(this.wish == 12) {
            this.master = 6;
            int var41 = 0;
            if(JRMCoreH.align > 33) {
               if(JRMCoreH.Master == 1) {
                  String var83 = JRMCoreH.trl("dbc.talkgui.learntechs");
                  int var132 = this.fontRendererObj.getStringWidth(var83) + 8;
                  this.buttonList.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, var8 + 115 - var132, var9 + 15 + var41 * 21, var132, 20, var83));
                  ++var41;
               }

               String var84 = JRMCoreH.trl("dbc.talkgui.skills");
               int var133 = this.fontRendererObj.getStringWidth(var84) + 8;
               this.buttonList.add(new DBCGuiButtons01(this.wish + 10100, var8 + 115 - var133, var9 + 15 + var41 * 21, var133, 20, var84));
               ++var41;
            }

            String var85 = JRMCoreH.trl("dbc.talkgui.difftonormal");
            int var134 = this.fontRendererObj.getStringWidth(var85) + 8;
            this.buttonList.add(new DBCGuiButtons01(103, var8 + 115 - var134, var9 + 15 + var41 * 21, var134, 20, var85));
            ++var41;
            if(JRMCoreH.align > 33) {
               var41 = 0;
               var85 = JRMCoreH.trl("dbc.talkgui.giveweights");
               var134 = this.fontRendererObj.getStringWidth(var85) + 8;
               this.buttonList.add(new DBCGuiButtons01(110, var8 - 115 - 0, var9 + 15 + var41 * 21, var134, 20, var85));
               ++var41;
            }

            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
         }

         if(this.wish == 112) {
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
            String var45 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var87 = new ResourceLocation(var45);
            this.mc.renderEngine.bindTexture(var87);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            var8 = this.width / 2;
            var9 = this.height / 2;
            var7.drawString("TP: " + JRMCoreH.curTP, var12 + 5, var13 + 5, 0);
            int var136 = 0;
            boolean var226 = DBCConfig.Godform && JRMCoreHDBC.godKiAble();
            this.sklLrn(9, var12 + 5, var13 + 25 + var136 * 21, var226);
            ++var136;
            this.sklLrn(8, var12 + 5, var13 + 25 + var136 * 21);
            ++var136;
            this.sklLrn(2, var12 + 5, var13 + 25 + var136 * 21);
            ++var136;
            this.sklLrn(3, var12 + 5, var13 + 25 + var136 * 21);
            ++var136;
            this.sklLrn(5, var12 + 5, var13 + 25 + var136 * 21);
            ++var136;
            this.sklLrn(4, var12 + 5, var13 + 25 + var136 * 21);
            ++var136;
         }

         if(this.wish == 1121) {
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
            String var46 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var88 = new ResourceLocation(var46);
            this.mc.renderEngine.bindTexture(var88);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            var8 = this.width / 2;
            var9 = this.height / 2;
            String[][] var143 = JRMCoreH.pmdbc;
            var7.drawString(JRMCoreH.curTP + " " + "Training Points", var12 + 10, var13 + 5, 0);
            int var227 = 0;
            int var257 = var143.length;

            for(byte var283 = 0; var283 < var257; ++var283) {
               int var292 = Integer.parseInt(var143[var283][2]);
               if(var292 == 1 || var292 == 6) {
                  if(var227 <= 13 + this.ipg * 13 && var227 >= 0 + this.ipg * 13) {
                     String var22 = JRMCoreH.trl("dbc", var143[var283][0]);
                     int var23 = this.fontRenderer.getStringWidth(var22);
                     var7.drawString(var22, var12 + var10 / 2 - 122, var13 + (var11 + 1) / 2 - 64 + var227 * 10 - this.lp * 13 * 10, 0);
                     String var24 = JRMCoreH.techOwnd(var283, (byte)1)?" Owned":"";
                     int var25 = this.fontRenderer.getStringWidth(var24);
                     var7.drawString(var24, var12 + var10 / 2 - 122 + var23, var13 + (var11 + 1) / 2 - 64 + var227 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                     if(!JRMCoreH.techOwnd(var283, (byte)1)) {
                        int var26 = (int)((float)JRMCoreH.techDBCtpc(var143[var283]) * 0.9F);
                        String var28 = " " + var26 + " tp";
                        int var29 = this.fontRenderer.getStringWidth(var22);
                        if(JRMCoreH.curTP >= var26) {
                           this.buttonList.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(var283, (byte)1)?4200 + var283:-1, var12 + var10 / 2 - 122 + var23 + var25, var13 + (var11 + 1) / 2 - 64 + var227 * 10 - this.lp * 13 * 10, var29, var28, JRMCoreH.techNCCol[1]));
                        } else {
                           var7.drawString(var28, var12 + var10 / 2 - 122 + var23 + var25, var13 + (var11 + 1) / 2 - 64 + var227 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                        }
                     }
                  }

                  ++var227;
               }
            }
         }

         if(this.wish == 121) {
            String var47 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var89 = new ResourceLocation(var47);
            this.mc.renderEngine.bindTexture(var89);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            Iterator var144 = this.mc.fontRenderer.listFormattedStringToWidth(JRMCoreH.trl("dbc", "KaioDiffRed"), 245).iterator();
            int var228 = 0;

            while(var144.hasNext()) {
               ++var228;
               String var258 = (String)var144.next();
               var7.drawString("\u00a70" + var258, var12 + 5, var13 + 5 + var228 * 10, 0);
            }

            this.buttonList.add(new DBCGuiButtons01(104, var8 - 35, var9 + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.no")));
            this.buttonList.add(new DBCGuiButtons01(105, var8 - 120, var9 + 55, 80, 20, JRMCoreH.trl("dbc.talkgui.confirm")));
         }

         if(this.wish == 13) {
            this.master = 4;
            if(JRMCoreH.align > 65) {
               if(JRMCoreH.Senzu == 0) {
                  this.buttonList.add(new DBCGuiButtons01(199, var8 - 35, var9 + 35, 100, 20, StatCollector.translateToLocal("dbc.talkgui.karin.senzu")));
               }

               this.buttonList.add(new DBCGuiButtons01(198, var8 - 35, var9 + 55, 100, 20, StatCollector.translateToLocal("dbc.talkgui.skills")));
               if(!this.mc.thePlayer.inventory.hasItem(ItemsDBC.KintounItem)) {
                  this.buttonList.add(new DBCGuiButtons01(202, var8 - 35, var9 + 15, 100, 20, StatCollector.translateToLocal("dbc.talkgui.kintoun")));
               }
            } else if(!this.mc.thePlayer.inventory.hasItem(ItemsDBC.KintounBlackItem)) {
               this.buttonList.add(new DBCGuiButtons01(202, var8 - 35, var9 + 15, 140, 20, StatCollector.translateToLocal("dbc.talkgui.kintounblack")));
            }

            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
         }

         if(this.wish == 113) {
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
            String var48 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var90 = new ResourceLocation(var48);
            this.mc.renderEngine.bindTexture(var90);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            var8 = this.width / 2;
            var9 = this.height / 2;
            var7.drawString("TP: " + JRMCoreH.curTP, var12 + 5, var13 + 5, 0);
            int var145 = 0;
            this.sklLrn(1, var12 + 5, var13 + 25 + var145 * 21);
            ++var145;
            this.sklLrn(3, var12 + 5, var13 + 25 + var145 * 21);
            ++var145;
         }

         if(this.wish == 15) {
            this.master = 2;
            String var49 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var91 = new ResourceLocation(var49);
            this.mc.renderEngine.bindTexture(var91);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            int var148 = 0;
            this.Process = StatCollector.translateToLocal(JRMCoreH.Masters[2]);
            var148 = var148 + JRMCoreH.txt(this.Process, "\u00a78", 0, true, var12 + 6, var13 + 5 + var148 * 10, 0);
            this.Process = StatCollector.translateToLocal("dbc.talkgui.roshi.goodneut");
            var148 = var148 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var148 * 10, 0);
            int var229 = 0;
            if(JRMCoreH.align > 32) {
               if(JRMCoreH.Master == 1) {
                  String var259 = JRMCoreH.trl("dbc.talkgui.learntechs");
                  int var284 = this.fontRendererObj.getStringWidth(var259) + 8;
                  this.buttonList.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, var8 + 115 - var284, var9 + 15 + var229 * 21, var284, 20, var259));
                  ++var229;
               }

               String var260 = JRMCoreH.trl("dbc.talkgui.skills");
               int var285 = this.fontRendererObj.getStringWidth(var260) + 8;
               this.buttonList.add(new DBCGuiButtons01(this.wish + 10100, var8 + 115 - var285, var9 + 15 + var229 * 21, var285, 20, var260));
               ++var229;
            }

            var229 = 0;
            String var261 = JRMCoreH.trl("dbc.talkgui.giveweights");
            int var286 = this.fontRendererObj.getStringWidth(var261) + 8;
            this.buttonList.add(new DBCGuiButtons01(110, var8 - 115 - 0, var9 + 15 + var229 * 21, var286, 20, var261));
            ++var229;
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
         }

         if(this.wish == 115) {
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
            String var50 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var92 = new ResourceLocation(var50);
            this.mc.renderEngine.bindTexture(var92);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            var8 = this.width / 2;
            var9 = this.height / 2;
            var7.drawString("TP: " + JRMCoreH.curTP, var12 + 5, var13 + 5, 0);
            int var151 = 0;
            this.sklLrn(1, var12 + 5, var13 + 25 + var151 * 21);
            ++var151;
            this.sklLrn(2, var12 + 5, var13 + 25 + var151 * 21);
            ++var151;
            this.sklLrn(3, var12 + 5, var13 + 25 + var151 * 21);
            ++var151;
         }

         if(this.wish == 1151) {
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
            String var51 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var93 = new ResourceLocation(var51);
            this.mc.renderEngine.bindTexture(var93);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            var8 = this.width / 2;
            var9 = this.height / 2;
            String[][] var155 = JRMCoreH.pmdbc;
            var7.drawString(JRMCoreH.curTP + " " + "Training Points", var12 + 10, var13 + 5, 0);
            int var233 = 0;
            int var262 = var155.length;

            for(byte var287 = 0; var287 < var262; ++var287) {
               if(Integer.parseInt(var155[var287][2]) == 2 || Integer.parseInt(var155[var287][2]) == 1) {
                  if(var233 <= 13 + this.ipg * 13 && var233 >= 0 + this.ipg * 13) {
                     String var293 = JRMCoreH.trl("dbc", var155[var287][0]);
                     int var298 = this.fontRenderer.getStringWidth(var293);
                     var7.drawString(var293, var12 + var10 / 2 - 122, var13 + (var11 + 1) / 2 - 64 + var233 * 10 - this.lp * 13 * 10, 0);
                     String var303 = JRMCoreH.techOwnd(var287, (byte)1)?" Owned":"";
                     int var308 = this.fontRenderer.getStringWidth(var303);
                     var7.drawString(var303, var12 + var10 / 2 - 122 + var298, var13 + (var11 + 1) / 2 - 64 + var233 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                     if(!JRMCoreH.techOwnd(var287, (byte)1)) {
                        int var313 = (int)((float)JRMCoreH.techDBCtpc(var155[var287]) * 0.9F);
                        String var27 = " " + var313 + " tp";
                        int var322 = this.fontRenderer.getStringWidth(var293);
                        if(JRMCoreH.curTP >= var313) {
                           this.buttonList.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(var287, (byte)1)?4200 + var287:-1, var12 + var10 / 2 - 122 + var298 + var308, var13 + (var11 + 1) / 2 - 64 + var233 * 10 - this.lp * 13 * 10, var322, var27, JRMCoreH.techNCCol[1]));
                        } else {
                           var7.drawString(var27, var12 + var10 / 2 - 122 + var298 + var308, var13 + (var11 + 1) / 2 - 64 + var233 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                        }
                     }
                  }

                  ++var233;
               }
            }
         }

         if(this.wish == 16) {
            this.master = 12;
            String var52 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var94 = new ResourceLocation(var52);
            this.mc.renderEngine.bindTexture(var94);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            int var156 = 0;
            this.Process = StatCollector.translateToLocal(JRMCoreH.Masters[12]);
            var156 = var156 + JRMCoreH.txt(this.Process, "\u00a78", 0, true, var12 + 6, var13 + 5 + var156 * 10, 0);
            if(JRMCoreH.align <= 32) {
               this.Process = StatCollector.translateToLocal("dbc.talkgui.cell.evil");
               var156 = var156 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var156 * 10, 0);
               if(JRMCoreH.Master == 1) {
                  String var234 = JRMCoreH.trl("dbc.talkgui.learntechs");
                  int var263 = this.fontRendererObj.getStringWidth(var234) + 8;
                  this.buttonList.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, var8 + 15 - var263 / 2, var9 + 35, var263, 20, var234));
               }

               String var235 = JRMCoreH.trl("dbc.talkgui.skills");
               int var264 = this.fontRendererObj.getStringWidth(var235) + 8;
               this.buttonList.add(new DBCGuiButtons01(this.wish + 10100, var8 + 15 - var264 / 2, var9 + 55, var264, 20, var235));
            } else {
               this.Process = StatCollector.translateToLocal("dbc.talkgui.cell.goodneut");
               var156 = var156 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var156 * 10, 0);
            }

            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
         }

         if(this.wish == 116) {
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
            String var53 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var95 = new ResourceLocation(var53);
            this.mc.renderEngine.bindTexture(var95);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            var8 = this.width / 2;
            var9 = this.height / 2;
            var7.drawString("TP: " + JRMCoreH.curTP, var12 + 5, var13 + 5, 0);
            int var160 = 0;
            this.sklLrn(1, var12 + 5, var13 + 25 + var160 * 21);
            ++var160;
            this.sklLrn(2, var12 + 5, var13 + 25 + var160 * 21);
            ++var160;
            this.sklLrn(3, var12 + 5, var13 + 25 + var160 * 21);
            ++var160;
            this.sklLrn(5, var12 + 5, var13 + 25 + var160 * 21);
            ++var160;
            this.sklLrn(4, var12 + 5, var13 + 25 + var160 * 21);
            ++var160;
            this.sklLrn(6, var12 + 5, var13 + 25 + var160 * 21);
            ++var160;
         }

         if(this.wish == 1161) {
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
            String var54 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var96 = new ResourceLocation(var54);
            this.mc.renderEngine.bindTexture(var96);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            var8 = this.width / 2;
            var9 = this.height / 2;
            String[][] var167 = JRMCoreH.pmdbc;
            var7.drawString(JRMCoreH.curTP + " " + "Training Points", var12 + 10, var13 + 5, 0);
            int var236 = 0;
            int var265 = var167.length;

            for(byte var288 = 0; var288 < var265; ++var288) {
               int var294 = Integer.parseInt(var167[var288][2]);
               if(var294 == 2 || var294 == 1 || var294 == 7 || var294 == 8 || var294 == 9 || var294 == 11) {
                  if(var236 <= 13 + this.ipg * 13 && var236 >= 0 + this.ipg * 13) {
                     String var299 = JRMCoreH.trl("dbc", var167[var288][0]);
                     int var304 = this.fontRenderer.getStringWidth(var299);
                     var7.drawString(var299, var12 + var10 / 2 - 122, var13 + (var11 + 1) / 2 - 64 + var236 * 10 - this.lp * 13 * 10, 0);
                     String var309 = JRMCoreH.techOwnd(var288, (byte)1)?" Owned":"";
                     int var314 = this.fontRenderer.getStringWidth(var309);
                     var7.drawString(var309, var12 + var10 / 2 - 122 + var304, var13 + (var11 + 1) / 2 - 64 + var236 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                     if(!JRMCoreH.techOwnd(var288, (byte)1)) {
                        int var318 = (int)((float)JRMCoreH.techDBCtpc(var167[var288]) * 0.9F);
                        String var323 = " " + var318 + " tp";
                        int var327 = this.fontRenderer.getStringWidth(var299);
                        if(JRMCoreH.curTP >= var318) {
                           this.buttonList.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(var288, (byte)1)?4200 + var288:-1, var12 + var10 / 2 - 122 + var304 + var314, var13 + (var11 + 1) / 2 - 64 + var236 * 10 - this.lp * 13 * 10, var327, var323, JRMCoreH.techNCCol[1]));
                        } else {
                           var7.drawString(var323, var12 + var10 / 2 - 122 + var304 + var314, var13 + (var11 + 1) / 2 - 64 + var236 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                        }
                     }
                  }

                  ++var236;
               }
            }
         }

         if(this.wish == 17) {
            this.master = 13;
            String var55 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var97 = new ResourceLocation(var55);
            this.mc.renderEngine.bindTexture(var97);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            int var168 = 0;
            this.Process = StatCollector.translateToLocal(JRMCoreH.Masters[13]);
            var168 = var168 + JRMCoreH.txt(this.Process, "\u00a78", 0, true, var12 + 6, var13 + 5 + var168 * 10, 0);
            if(JRMCoreH.align > 32) {
               this.Process = StatCollector.translateToLocal("dbc.talkgui.songoku.goodneut");
               var168 = var168 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var168 * 10, 0);
               if(JRMCoreH.Master == 1) {
                  String var237 = JRMCoreH.trl("dbc.talkgui.learntechs");
                  int var266 = this.fontRendererObj.getStringWidth(var237) + 8;
                  this.buttonList.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, var8 + 15 - var266 / 2, var9 + 35, var266, 20, var237));
               }

               String var238 = JRMCoreH.trl("dbc.talkgui.skills");
               int var267 = this.fontRendererObj.getStringWidth(var238) + 8;
               this.buttonList.add(new DBCGuiButtons01(this.wish + 10100, var8 + 15 - var267 / 2, var9 + 55, var267, 20, var238));
            } else {
               this.Process = StatCollector.translateToLocal("dbc.talkgui.songoku.evil");
               var168 = var168 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var168 * 10, 0);
            }

            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
         }

         if(this.wish == 117) {
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
            String var56 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var98 = new ResourceLocation(var56);
            this.mc.renderEngine.bindTexture(var98);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            var8 = this.width / 2;
            var9 = this.height / 2;
            var7.drawString("TP: " + JRMCoreH.curTP, var12 + 5, var13 + 5, 0);
            int var172 = 0;
            this.sklLrn(3, var12 + 5, var13 + 25 + var172 * 21);
            ++var172;
            this.sklLrn(5, var12 + 5, var13 + 25 + var172 * 21);
            ++var172;
            this.sklLrn(4, var12 + 5, var13 + 25 + var172 * 21);
            ++var172;
            this.sklLrn(6, var12 + 5, var13 + 25 + var172 * 21);
            ++var172;
            this.sklLrn(0, var12 + 5, var13 + 25 + var172 * 21);
            ++var172;
         }

         if(this.wish == 1171) {
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
            String var57 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var99 = new ResourceLocation(var57);
            this.mc.renderEngine.bindTexture(var99);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            var8 = this.width / 2;
            var9 = this.height / 2;
            String[][] var178 = JRMCoreH.pmdbc;
            var7.drawString(JRMCoreH.curTP + " " + "Training Points", var12 + 10, var13 + 5, 0);
            int var239 = 0;
            int var268 = var178.length;

            for(byte var289 = 0; var289 < var268; ++var289) {
               int var295 = Integer.parseInt(var178[var289][2]);
               if(var295 == 2 || var295 == 1 || var295 == 6 || var295 == 7 || var295 == 8) {
                  if(var239 <= 13 + this.ipg * 13 && var239 >= 0 + this.ipg * 13) {
                     String var300 = JRMCoreH.trl("dbc", var178[var289][0]);
                     int var305 = this.fontRenderer.getStringWidth(var300);
                     var7.drawString(var300, var12 + var10 / 2 - 122, var13 + (var11 + 1) / 2 - 64 + var239 * 10 - this.lp * 13 * 10, 0);
                     String var310 = JRMCoreH.techOwnd(var289, (byte)1)?" Owned":"";
                     int var315 = this.fontRenderer.getStringWidth(var310);
                     var7.drawString(var310, var12 + var10 / 2 - 122 + var305, var13 + (var11 + 1) / 2 - 64 + var239 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                     if(!JRMCoreH.techOwnd(var289, (byte)1)) {
                        int var319 = (int)((float)JRMCoreH.techDBCtpc(var178[var289]) * 0.9F);
                        String var324 = " " + var319 + " tp";
                        int var328 = this.fontRenderer.getStringWidth(var300);
                        if(JRMCoreH.curTP >= var319) {
                           this.buttonList.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(var289, (byte)1)?4200 + var289:-1, var12 + var10 / 2 - 122 + var305 + var315, var13 + (var11 + 1) / 2 - 64 + var239 * 10 - this.lp * 13 * 10, var328, var324, JRMCoreH.techNCCol[1]));
                        } else {
                           var7.drawString(var324, var12 + var10 / 2 - 122 + var305 + var315, var13 + (var11 + 1) / 2 - 64 + var239 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                        }
                     }
                  }

                  ++var239;
               }
            }
         }

         if(this.wish == 18) {
            this.master = 11;
            String var58 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var100 = new ResourceLocation(var58);
            this.mc.renderEngine.bindTexture(var100);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            int var179 = 0;
            this.Process = StatCollector.translateToLocal(JRMCoreH.Masters[11]);
            var179 = var179 + JRMCoreH.txt(this.Process, "\u00a78", 0, true, var12 + 6, var13 + 5 + var179 * 10, 0);
            if(JRMCoreH.align <= 32) {
               this.Process = StatCollector.translateToLocal("dbc.talkgui.freeza.evil");
               var179 = var179 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var179 * 10, 0);
               if(JRMCoreH.Master == 1) {
                  String var240 = JRMCoreH.trl("dbc.talkgui.learntechs");
                  int var269 = this.fontRendererObj.getStringWidth(var240) + 8;
                  this.buttonList.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, var8 + 15 - var269 / 2, var9 + 35, var269, 20, var240));
               }

               String var241 = JRMCoreH.trl("dbc.talkgui.skills");
               int var270 = this.fontRendererObj.getStringWidth(var241) + 8;
               this.buttonList.add(new DBCGuiButtons01(this.wish + 10100, var8 + 15 - var270 / 2, var9 + 55, var270, 20, var241));
            } else {
               this.Process = StatCollector.translateToLocal("dbc.talkgui.freeza.else");
               var179 = var179 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var179 * 10, 0);
            }

            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
         }

         if(this.wish == 118) {
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
            String var59 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var101 = new ResourceLocation(var59);
            this.mc.renderEngine.bindTexture(var101);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            var8 = this.width / 2;
            var9 = this.height / 2;
            var7.drawString("TP: " + JRMCoreH.curTP, var12 + 5, var13 + 5, 0);
            int var183 = 0;
            this.sklLrn(1, var12 + 5, var13 + 25 + var183 * 21);
            ++var183;
            this.sklLrn(2, var12 + 5, var13 + 25 + var183 * 21);
            ++var183;
            this.sklLrn(3, var12 + 5, var13 + 25 + var183 * 21);
            ++var183;
            this.sklLrn(5, var12 + 5, var13 + 25 + var183 * 21);
            ++var183;
            this.sklLrn(4, var12 + 5, var13 + 25 + var183 * 21);
            ++var183;
         }

         if(this.wish == 1181) {
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
            String var60 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var102 = new ResourceLocation(var60);
            this.mc.renderEngine.bindTexture(var102);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            var8 = this.width / 2;
            var9 = this.height / 2;
            String[][] var189 = JRMCoreH.pmdbc;
            var7.drawString(JRMCoreH.curTP + " " + "Training Points", var12 + 10, var13 + 5, 0);
            int var242 = 0;
            int var271 = var189.length;

            for(byte var290 = 0; var290 < var271; ++var290) {
               int var296 = Integer.parseInt(var189[var290][2]);
               if(var296 == 1 || var296 == 11) {
                  if(var242 <= 13 + this.ipg * 13 && var242 >= 0 + this.ipg * 13) {
                     String var301 = JRMCoreH.trl("dbc", var189[var290][0]);
                     int var306 = this.fontRenderer.getStringWidth(var301);
                     var7.drawString(var301, var12 + var10 / 2 - 122, var13 + (var11 + 1) / 2 - 64 + var242 * 10 - this.lp * 13 * 10, 0);
                     String var311 = JRMCoreH.techOwnd(var290, (byte)1)?" Owned":"";
                     int var316 = this.fontRenderer.getStringWidth(var311);
                     var7.drawString(var311, var12 + var10 / 2 - 122 + var306, var13 + (var11 + 1) / 2 - 64 + var242 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                     if(!JRMCoreH.techOwnd(var290, (byte)1)) {
                        int var320 = (int)((float)JRMCoreH.techDBCtpc(var189[var290]) * 0.9F);
                        String var325 = " " + var320 + " tp";
                        int var329 = this.fontRenderer.getStringWidth(var301);
                        if(JRMCoreH.curTP >= var320) {
                           this.buttonList.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(var290, (byte)1)?4200 + var290:-1, var12 + var10 / 2 - 122 + var306 + var316, var13 + (var11 + 1) / 2 - 64 + var242 * 10 - this.lp * 13 * 10, var329, var325, JRMCoreH.techNCCol[1]));
                        } else {
                           var7.drawString(var325, var12 + var10 / 2 - 122 + var306 + var316, var13 + (var11 + 1) / 2 - 64 + var242 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                        }
                     }
                  }

                  ++var242;
               }
            }
         }

         if(this.wish == 19) {
            this.master = 15;
            String var61 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var103 = new ResourceLocation(var61);
            this.mc.renderEngine.bindTexture(var103);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            int var190 = 0;
            this.Process = StatCollector.translateToLocal(JRMCoreH.Masters[15]);
            var190 = var190 + JRMCoreH.txt(this.Process, "\u00a78", 0, true, var12 + 6, var13 + 5 + var190 * 10, 0);
            if(JRMCoreH.align <= 65) {
               this.Process = StatCollector.translateToLocal("dbc.talkgui.babidi.evilneut");
               var190 = var190 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var190 * 10, 0);
               if(JRMCoreH.Master == 1) {
                  String var243 = JRMCoreH.trl("dbc.talkgui.learntechs");
                  int var272 = this.fontRendererObj.getStringWidth(var243) + 8;
                  this.buttonList.add(new DBCGuiButtons01((this.wish + 10100) * 10 + 1, var8 + 15 - var272 / 2, var9 + 35, var272, 20, var243));
               }

               String var244 = JRMCoreH.trl("dbc.talkgui.skills");
               int var273 = this.fontRendererObj.getStringWidth(var244) + 8;
               this.buttonList.add(new DBCGuiButtons01(this.wish + 10100, var8 + 15 - var273 / 2, var9 + 55, var273, 20, var244));
            } else if(JRMCoreH.align == 100) {
               this.Process = StatCollector.translateToLocal("dbc.talkgui.babidi.fullgood");
               var190 = var190 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var190 * 10, 0);
            } else {
               this.Process = StatCollector.translateToLocal("dbc.talkgui.babidi.good");
               var190 = var190 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var190 * 10, 0);
            }

            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
         }

         if(this.wish == 119) {
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
            String var62 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var104 = new ResourceLocation(var62);
            this.mc.renderEngine.bindTexture(var104);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            var8 = this.width / 2;
            var9 = this.height / 2;
            var7.drawString("TP: " + JRMCoreH.curTP, var12 + 5, var13 + 5, 0);
            int var195 = 0;
            this.sklLrn(1, var12 + 5, var13 + 25 + var195 * 21);
            ++var195;
            this.sklLrn(2, var12 + 5, var13 + 25 + var195 * 21);
            ++var195;
            this.sklLrn(3, var12 + 5, var13 + 25 + var195 * 21);
            ++var195;
            this.sklLrn(5, var12 + 5, var13 + 25 + var195 * 21);
            ++var195;
            this.sklLrn(4, var12 + 5, var13 + 25 + var195 * 21);
            ++var195;
         }

         if(this.wish == 1191) {
            this.buttonList.add(new DBCGuiButtons01(-1, var8 - 150, var9 + 65, 20, 20, "X"));
            String var63 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var105 = new ResourceLocation(var63);
            this.mc.renderEngine.bindTexture(var105);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            var8 = this.width / 2;
            var9 = this.height / 2;
            String[][] var201 = JRMCoreH.pmdbc;
            var7.drawString(JRMCoreH.curTP + " " + "Training Points", var12 + 10, var13 + 5, 0);
            int var245 = 0;
            int var274 = var201.length;

            for(byte var291 = 0; var291 < var274; ++var291) {
               int var297 = Integer.parseInt(var201[var291][2]);
               if(var297 == 1) {
                  if(var245 <= 13 + this.ipg * 13 && var245 >= 0 + this.ipg * 13) {
                     String var302 = JRMCoreH.trl("dbc", var201[var291][0]);
                     int var307 = this.fontRenderer.getStringWidth(var302);
                     var7.drawString(var302, var12 + var10 / 2 - 122, var13 + (var11 + 1) / 2 - 64 + var245 * 10 - this.lp * 13 * 10, 0);
                     String var312 = JRMCoreH.techOwnd(var291, (byte)1)?" Owned":"";
                     int var317 = this.fontRenderer.getStringWidth(var312);
                     var7.drawString(var312, var12 + var10 / 2 - 122 + var307, var13 + (var11 + 1) / 2 - 64 + var245 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[1]);
                     if(!JRMCoreH.techOwnd(var291, (byte)1)) {
                        int var321 = (int)((float)JRMCoreH.techDBCtpc(var201[var291]) * 0.9F);
                        String var326 = " " + var321 + " tp";
                        int var330 = this.fontRenderer.getStringWidth(var302);
                        if(JRMCoreH.curTP >= var321) {
                           this.buttonList.add(new JRMCoreGuiButtons01(!JRMCoreH.techOwnd(var291, (byte)1)?4200 + var291:-1, var12 + var10 / 2 - 122 + var307 + var317, var13 + (var11 + 1) / 2 - 64 + var245 * 10 - this.lp * 13 * 10, var330, var326, JRMCoreH.techNCCol[1]));
                        } else {
                           var7.drawString(var326, var12 + var10 / 2 - 122 + var307 + var317, var13 + (var11 + 1) / 2 - 64 + var245 * 10 - this.lp * 13 * 10, JRMCoreH.techNCCol[0]);
                        }
                     }
                  }

                  ++var245;
               }
            }
         }

         if(this.wish == 11) {
            String var64 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var106 = new ResourceLocation(var64);
            this.mc.renderEngine.bindTexture(var106);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            this.current(StatCollector.translateToLocal("dbc.talkgui.line0000"), 10, 10, var7, var12, var13);
            String var202 = StatCollector.translateToLocal("dbc.talkgui.line0001");
            String var246 = StatCollector.translateToLocal("dbc.talkgui.line0002");
            String var275 = StatCollector.translateToLocal("dbc.talkgui.line0003");
            if(JRMCoreH.align > 66) {
               var202 = StatCollector.translateToLocal("dbc.talkgui.line0004");
               var246 = StatCollector.translateToLocal("dbc.talkgui.line0005");
               var275 = StatCollector.translateToLocal("dbc.talkgui.line0006");
            }

            if(JRMCoreH.align < 33) {
               var202 = StatCollector.translateToLocal("dbc.talkgui.line0007");
               var246 = StatCollector.translateToLocal("dbc.talkgui.line0008");
               var275 = StatCollector.translateToLocal("dbc.talkgui.line0009");
            }

            if(JRMCoreH.SagaProg == 1700) {
               var202 = StatCollector.translateToLocal("dbc.MainSaga.17.2");
               var246 = StatCollector.translateToLocal("dbc.MainSaga.17.3");
               var275 = StatCollector.translateToLocal("dbc.MainSaga.17.4");
            }

            if(JRMCoreH.SagaSideProg == 10100) {
               var202 = StatCollector.translateToLocal("dbc.sidesagas.101.talk");
               JRMCoreH.txt(var202, "\u00a70", 5, true, var12 + 15, var13 + 20, 0);
            } else {
               this.current(var202, 15, 20, var7, var12, var13);
               this.current(var246, 15, 30, var7, var12, var13);
               this.current(var275, 15, 40, var7, var12, var13);
            }
         }

         if(this.wish == 1101) {
            String var65 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var107 = new ResourceLocation(var65);
            this.mc.renderEngine.bindTexture(var107);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            int var204 = 0;
            this.Process = StatCollector.translateToLocal("dbc.talkgui.kami.startanew");
            var204 = var204 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var204 * 10, 0);
         }

         if(this.wish == 1102) {
            String var66 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var108 = new ResourceLocation(var66);
            this.mc.renderEngine.bindTexture(var108);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            int var206 = 0;
            this.Process = StatCollector.translateToLocal("dbc.talkgui.kami.confirmtailcut");
            var206 = var206 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var206 * 10, 0);
         }

         if(this.wish == 1104) {
            String var67 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var109 = new ResourceLocation(var67);
            this.mc.renderEngine.bindTexture(var109);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            int var208 = 0;
            this.Process = StatCollector.translateToLocal("dbc.talkgui.kami.tailregrow");
            var208 = var208 + JRMCoreH.txt(this.Process, "\u00a70", 5, true, var12 + 6, var13 + 5 + var208 * 10, 0);
         }

         if(this.wish == 12) {
            String var68 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var110 = new ResourceLocation(var68);
            this.mc.renderEngine.bindTexture(var110);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            this.current(StatCollector.translateToLocal("dbc.talkgui.line0010"), 10, 10, var7, var12, var13);
            String var210 = StatCollector.translateToLocal("dbc.talkgui.line0011");
            String var247 = StatCollector.translateToLocal("dbc.talkgui.line0012");
            String var276 = StatCollector.translateToLocal("dbc.talkgui.line0013");
            if(JRMCoreH.align > 66) {
               var210 = StatCollector.translateToLocal("dbc.talkgui.line0014");
               var247 = StatCollector.translateToLocal("dbc.talkgui.line0015");
               var276 = StatCollector.translateToLocal("dbc.talkgui.line0016");
            }

            if(JRMCoreH.align < 33) {
               var210 = StatCollector.translateToLocal("dbc.talkgui.line0017");
               var247 = StatCollector.translateToLocal("dbc.talkgui.line0018");
               var276 = StatCollector.translateToLocal("dbc.talkgui.line0019");
            }

            this.current(var210, 15, 20, var7, var12, var13);
            this.current(var247, 15, 30, var7, var12, var13);
            this.current(var276, 15, 40, var7, var12, var13);
         }

         if(this.wish == 13) {
            String var69 = "jinryuudragonbc:saa.png";
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            ResourceLocation var111 = new ResourceLocation(var69);
            this.mc.renderEngine.bindTexture(var111);
            this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
            this.current(StatCollector.translateToLocal("dbc.talkgui.karin.00"), 10, 10, var7, var12, var13);
            String var211 = StatCollector.translateToLocal("dbc.talkgui.karin.01");
            String var248 = StatCollector.translateToLocal("dbc.talkgui.karin.02");
            String var277 = StatCollector.translateToLocal("dbc.talkgui.karin.03");
            if(JRMCoreH.align < 66) {
               var211 = StatCollector.translateToLocal("dbc.talkgui.karin.04");
               var248 = StatCollector.translateToLocal("dbc.talkgui.karin.05");
               var277 = StatCollector.translateToLocal("dbc.talkgui.karin.06");
            }

            if(JRMCoreH.align < 33) {
               var211 = StatCollector.translateToLocal("dbc.talkgui.karin.07");
               var248 = StatCollector.translateToLocal("dbc.talkgui.karin.08");
               var277 = StatCollector.translateToLocal("dbc.talkgui.karin.09");
            }

            if(JRMCoreH.Senzu == 1) {
               this.current(StatCollector.translateToLocal("dbc.talkgui.karin.nosenzu"), 25, 80, var7, var12, var13);
            }

            this.current(var211, 15, 20, var7, var12, var13);
            this.current(var248, 15, 30, var7, var12, var13);
            this.current(var277, 15, 40, var7, var12, var13);
         }
      }

      super.drawScreen(var1, var2, var3);
   }

   private void drawBg(String var1) {
      this.drawBg(var1, 256, 160);
   }

   private void drawBg(String var1, int var2, int var3) {
      String var4 = "jinryuudragonbc:" + var1 + ".png";
      int var5 = (this.width - var2) / 2;
      int var6 = (this.height - var3) / 2;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation var7 = new ResourceLocation(var4);
      this.mc.renderEngine.bindTexture(var7);
      this.drawTexturedModalRect(var5, var6, 0, 0, var2, var3);
   }

   public void current(String var1, int var2, int var3, FontRenderer var4, int var5, int var6) {
      int var7 = var4.getStringWidth(var1) / 2;
      int var8 = var5 + var2;
      int var9 = var6 + var3;
      var4.drawString(var1, var8, var9, 0);
   }

   public boolean doesGuiPauseGame() {
      return false;
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
      var1.entityRenderer.setupOverlayRendering();
      GL11.glEnable(3042);
      GL11.glEnable('\u803a');
      RenderHelper.enableStandardItemLighting();
      RenderHelper.disableStandardItemLighting();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.drawCenteredString(this.fontRenderer, this.Process, var5 + this.wid, var6 + this.hei, 16768306);
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
}
