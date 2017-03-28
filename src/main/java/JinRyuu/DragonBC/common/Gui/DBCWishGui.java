package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCClientTickHandler;
import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.Gui.DBCGuiButtons01;
import JinRyuu.DragonBC.common.p.DBCPwish;
import JinRyuu.JRMCore.JRMCoreGuiButtonC;
import JinRyuu.JRMCore.JRMCoreGuiButtons00;
import JinRyuu.JRMCore.JRMCoreGuiButtons01;
import JinRyuu.JRMCore.JRMCoreGuiSlider00;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.p.PD;
import java.awt.Color;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class DBCWishGui extends GuiScreen {
   private DBCClientTickHandler tick;
   private GuiIngame Guiingame;
   private int wishID = 0;
   private int prevwish = 0;
   private int wish = 0;
   private int KiColorSlcted = -1;
   boolean clicked = false;
   int page = 0;
   int wpp = 6;
   String target = "";
   private int ipg;
   private float BrghtSlcted = 0.8F;
   public static String[] playerlist = null;

   public void renderSuperProtect(int var1) {
      this.buttonList.clear();
      int var2 = this.width / 2;
      int var3 = this.height / 2;
      this.buttonList.add(new DBCGuiButtons01(100, var2 - 0, var3 - 0, 20, 20, "TEST"));
   }

   public DBCWishGui(int var1) {
      this.wish = var1;
      this.page = 0;
      if(this.wish == 1 || this.wish == 2) {
         DBCH.packDuo(-2, 0);
      }

      playerlist = null;
      this.target = "";
   }

   public void initGui() {
      this.buttonList.clear();
   }

   public void actionPerformed(GuiButton var1) {
      if(var1.id == -21) {
         int var2 = ((JRMCoreGuiButtonC)var1).getBgCol();
         this.KiColorSlcted = var2;
         this.wish = this.prevwish;
      }

      if(var1.id == -20) {
         this.BrghtSlcted = ((JRMCoreGuiSlider00)var1).sliderValue;
      }

      if(var1.id == -3) {
         ++this.ipg;
      }

      if(var1.id == -4) {
         --this.ipg;
      }

      if(var1.id == -5) {
         this.wish = this.prevwish;
      }

      if(var1.id == -1) {
         ++this.page;
      }

      if(var1.id == -2) {
         --this.page;
      }

      if(var1.id >= 0) {
         boolean var4 = true;
         this.clicked = true;
         this.wishID = var1.id;
         if(this.wish == 1) {
            if(this.target.length() < 2 && (((String)DBCH.wishS.get(var1.id)).equals("revive") || ((String)DBCH.wishS.get(var1.id)).equals("reviventp"))) {
               var4 = false;
               this.dbcWish(3, "");
               this.prevwish = this.wish;
               this.wishID = var1.id;
               this.wish = 10;
            }

            if(this.KiColorSlcted == -1 && ((String)DBCH.wishS.get(var1.id)).equals("kicolor")) {
               var4 = false;
               this.prevwish = this.wish;
               this.wishID = var1.id;
               this.wish = 11;
            }
         }

         if(this.wish == 2) {
            if(this.target.length() < 2 && (((String)DBCH.wishP.get(var1.id)).equals("revive") || ((String)DBCH.wishP.get(var1.id)).equals("reviventp"))) {
               var4 = false;
               this.dbcWish(3, "");
               this.prevwish = this.wish;
               this.wishID = var1.id;
               this.wish = 10;
            }

            if(this.KiColorSlcted == -1 && ((String)DBCH.wishP.get(var1.id)).equals("kicolor")) {
               var4 = false;
               this.prevwish = this.wish;
               this.wishID = var1.id;
               this.wish = 11;
            }
         }

         if(var4) {
            if(this.wish == 10) {
               int var3 = var1.id - 1000;
               this.target = playerlist[var3];
               this.wish = this.prevwish;
            } else {
               this.dbcWish(0, this.wishID + ";" + (this.KiColorSlcted >= 0?Integer.valueOf(this.KiColorSlcted):this.target));
               this.target = "";
               this.KiColorSlcted = -1;
            }
         }

         DBCH.packDuo(-2, 0);
      }

   }

   public void dbcWish(int var1, String var2) {
      PD.sendToServer(new DBCPwish(var1, var2));
   }

   public void drawScreen(int var1, int var2, float var3) {
      if(this.clicked && JRMCoreH.wishes <= 0) {
         this.mc.thePlayer.closeScreen();
      }

      this.buttonList.clear();
      FontRenderer var4 = this.mc.fontRenderer;
      ScaledResolution var5 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var6 = var5.getScaledWidth();
      int var7 = var5.getScaledHeight();
      int var8 = this.width / 2;
      int var9 = this.height / 2;
      short var10 = 182;
      short var11 = 191;
      int var12 = (this.width - var10) / 2;
      int var13 = (this.height - var11) / 2;
      String var14 = "jinryuudragonbc:wish.png";
      this.wpp = 6;
      if(this.wish == 1) {
         var14 = "jinryuudragonbc:wish.png";
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         ResourceLocation var15 = new ResourceLocation(var14);
         this.mc.renderEngine.bindTexture(var15);
         this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
         int var16 = 0;
         int var17 = 0;
         int var18 = JRMCoreH.Algnmnt(JRMCoreH.align);
         var17 = JRMCoreH.txt(JRMCoreH.trl("entity.jinryuudragonblockc.Dragon.name") + "/n Wishes: " + JRMCoreH.wishes, JRMCoreH.clb, 0, true, var12 + 5, var13 + 5 + var16 * 10, 175);
         var16 = var16 + var17;
         int var19 = DBCH.wishS.size();

         for(int var20 = this.page * this.wpp; var20 < (this.wpp + this.page * this.wpp > var19?var19:this.wpp + this.page * this.wpp); ++var20) {
            String var21 = ((String)DBCH.wishS.get(var20)).replace(";+;", ";+");
            int var22 = var20 % this.wpp;
            if(var21.contains(";+")) {
               String[] var86 = var21.split(";+");
               String var90 = var86[0];
               int var27 = Integer.parseInt(var86[1]);
               int var28 = Integer.parseInt(var86[2]);
               Item var29 = JRMCoreH.getItemByText(var90);
               if(var29 != null) {
                  ItemStack var30 = new ItemStack(var29, var27, var28);
                  String var76 = var30.stackSize + " " + var29.getItemStackDisplayName(var30);
                  int var81 = var4.getStringWidth(var76);
                  this.buttonList.add(new DBCGuiButtons01(var20, var8 - var81 / 2 - 5, var13 + 5 + var22 * 21 + var16 * 10, var81 + 10, 20, var76));
               }
            } else if(this.KiColorSlcted >= 0 && var21.equals("kicolor")) {
               int var85 = this.KiColorSlcted > 0?this.KiColorSlcted:11075583;
               String var75 = JRMCoreH.cct(JRMCoreH.trl("dbc", "wish" + var21), new Object[0]);
               int var80 = var4.getStringWidth(var75);
               this.buttonList.add(new JRMCoreGuiButtons00(var20, var8 - var80 / 2 - 5, var13 + 5 + var22 * 21 + var16 * 10, var80 + 10, 20, var75, var85));
            } else {
               String var25 = (var21.equals("revive") || var21.equals("reviventp")) && this.target.length() > 2?"S":"";
               String var26 = var25.equals("S")?this.target:JRMCoreH.trl("jrmc", JRMCoreH.AlgnmntNms[JRMCoreH.Algnmnt(JRMCoreH.align)]);
               String var23 = JRMCoreH.cct(JRMCoreH.trl("dbc", "wish" + var21 + var25), new Object[]{var26});
               int var24 = var4.getStringWidth(var23);
               this.buttonList.add(new DBCGuiButtons01(var20, var8 - var24 / 2 - 5, var13 + 5 + var22 * 21 + var16 * 10, var24 + 10, 20, var23));
            }
         }

         if(var19 > this.wpp + this.page * this.wpp) {
            String var58 = JRMCoreH.trl("jrmc", "Next");
            this.buttonList.add(new JRMCoreGuiButtons00(-1, var12 + var10 / 2 + 100, var13 + (var11 + 1) / 2 + 40, this.fontRendererObj.getStringWidth(var58) + 8, 20, var58, 0));
         }

         if(this.page != 0) {
            String var59 = JRMCoreH.trl("jrmc", "Prev");
            int var68 = this.fontRendererObj.getStringWidth(var59) + 8;
            this.buttonList.add(new JRMCoreGuiButtons00(-2, var12 + var10 / 2 - 100 - var68, var13 + (var11 + 1) / 2 + 40, var68, 20, var59, 0));
         }
      }

      if(this.wish == 2) {
         var14 = "jinryuudragonbc:wish2.png";
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         ResourceLocation var35 = new ResourceLocation(var14);
         this.mc.renderEngine.bindTexture(var35);
         this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
         int var39 = 0;
         int var45 = 0;
         int var51 = JRMCoreH.Algnmnt(JRMCoreH.align);
         var45 = JRMCoreH.txt(JRMCoreH.trl("entity.jinryuudragonblockc.Dragonp.name") + "/n Wishes: " + JRMCoreH.wishes, JRMCoreH.clb, 0, true, var12 + 5, var13 + 5 + var39 * 10, 175);
         var39 = var39 + var45;
         int var55 = DBCH.wishP.size();

         for(int var60 = this.page * this.wpp; var60 < (this.wpp + this.page * this.wpp > var55?var55:this.wpp + this.page * this.wpp); ++var60) {
            String var69 = ((String)DBCH.wishP.get(var60)).replace(";+;", ";+");
            int var74 = var60 % this.wpp;
            if(var69.contains(";+")) {
               String[] var89 = var69.split(";+");
               String var92 = var89[0];
               int var93 = Integer.parseInt(var89[1]);
               int var94 = Integer.parseInt(var89[2]);
               Item var95 = JRMCoreH.getItemByText(var92);
               if(var95 != null) {
                  ItemStack var96 = new ItemStack(var95, var93, var94);
                  String var79 = var96.stackSize + " " + var95.getItemStackDisplayName(var96);
                  int var84 = var4.getStringWidth(var79);
                  this.buttonList.add(new DBCGuiButtons01(var60, var8 - var84 / 2 - 5, var13 + 5 + var74 * 21 + var39 * 10, var84 + 10, 20, var79));
               }
            } else if(this.KiColorSlcted >= 0 && var69.equals("kicolor")) {
               int var88 = this.KiColorSlcted > 0?this.KiColorSlcted:11075583;
               String var78 = JRMCoreH.cct(JRMCoreH.trl("dbc", "wish" + var69), new Object[0]);
               int var83 = var4.getStringWidth(var78);
               this.buttonList.add(new JRMCoreGuiButtons00(var60, var8 - var83 / 2 - 5, var13 + 5 + var74 * 21 + var39 * 10, var83 + 10, 20, var78, var88));
            } else {
               String var87 = (var69.equals("revive") || var69.equals("reviventp")) && this.target.length() > 2?"S":"";
               String var91 = var87.equals("S")?this.target:JRMCoreH.trl("jrmc", JRMCoreH.AlgnmntNms[JRMCoreH.Algnmnt(JRMCoreH.align)]);
               String var77 = JRMCoreH.cct(JRMCoreH.trl("dbc", "wish" + var69 + var87), new Object[]{var91});
               int var82 = var4.getStringWidth(var77);
               this.buttonList.add(new DBCGuiButtons01(var60, var8 - var82 / 2 - 5, var13 + 5 + var74 * 21 + var39 * 10, var82 + 10, 20, var77));
            }
         }

         if(var55 > this.wpp + this.page * this.wpp) {
            String var61 = JRMCoreH.trl("jrmc", "Next");
            this.buttonList.add(new JRMCoreGuiButtons00(-1, var12 + var10 / 2 + 100, var13 + (var11 + 1) / 2 + 40, this.fontRendererObj.getStringWidth(var61) + 8, 20, var61, 0));
         }

         if(this.page != 0) {
            String var62 = JRMCoreH.trl("jrmc", "Prev");
            int var70 = this.fontRendererObj.getStringWidth(var62) + 8;
            this.buttonList.add(new JRMCoreGuiButtons00(-2, var12 + var10 / 2 - 100 - var70, var13 + (var11 + 1) / 2 + 40, var70, 20, var62, 0));
         }
      }

      if(this.wish == 10) {
         var14 = "jinryuudragonbc:wish.png";
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         ResourceLocation var36 = new ResourceLocation(var14);
         this.mc.renderEngine.bindTexture(var36);
         this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
         byte var41 = 0;
         int var47 = 0;
         int var52 = JRMCoreH.Algnmnt(JRMCoreH.align);
         var47 = JRMCoreH.txt(JRMCoreH.trl("dbc", "selectplayer"), JRMCoreH.clb, 0, true, var12 + 5, var13 + 5 + var41 * 10, 175);
         int var10000 = var41 + var47;
         int var56 = 0;
         if(playerlist != null && playerlist.length > 0) {
            for(int var63 = 0; var63 < playerlist.length; ++var63) {
               if(var56 <= 14 + this.ipg * 14 && var56 >= 0 + this.ipg * 14) {
                  String var71 = playerlist[var63];
                  this.buttonList.add(new JRMCoreGuiButtons01(1000 + var63, var12 + var10 / 2 - 80, var13 + (var11 + 1) / 2 - 84 + var56 * 10 - this.ipg * 14 * 10, this.fontRendererObj.getStringWidth(var71), var71, 0));
                  ++var56;
               }
            }
         }

         if(JRMCoreH.plyrs.length > 14 + this.ipg * 14) {
            String var64 = JRMCoreH.trl("jrmc", "Next");
            this.buttonList.add(new JRMCoreGuiButtons00(-3, var12 + var10 / 2 + 100, var13 + (var11 + 1) / 2 + 15, this.fontRendererObj.getStringWidth(var64) + 8, 20, var64, 0));
         }

         if(this.ipg != 0) {
            String var65 = JRMCoreH.trl("jrmc", "Prev");
            int var72 = this.fontRendererObj.getStringWidth(var65) + 8;
            this.buttonList.add(new JRMCoreGuiButtons00(-4, var12 + var10 / 2 - 100 - var72, var13 + (var11 + 1) / 2 + 15, var72, 20, var65, 0));
         }

         String var66 = JRMCoreH.trl("jrmc", "Back");
         int var73 = this.fontRendererObj.getStringWidth(var66) + 8;
         this.buttonList.add(new JRMCoreGuiButtons00(-5, var12 + var10 / 2 - 100 - var73, var13 + (var11 + 1) / 2 + 40, var73, 20, var66, 0));
      }

      if(this.wish == 11) {
         var14 = "jinryuudragonbc:wish.png";
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         ResourceLocation var37 = new ResourceLocation(var14);
         this.mc.renderEngine.bindTexture(var37);
         this.drawTexturedModalRect(var12, var13, 0, 0, var10, var11);
         int var42 = 0;

         for(int var49 = 0; var49 < 128; ++var49) {
            for(int var53 = 0; var53 < 128; ++var53) {
               Color var57 = Color.getHSBColor((float)var49 * 2.0F / 255.0F, (float)var53 * 2.0F / 255.0F, this.BrghtSlcted);
               int var67 = var57.getRed() * 65536 + var57.getGreen() * 256 + var57.getBlue();
               if(var67 == 0) {
                  var42 = 11075583;
                  if(JRMCoreH.align <= 66 && JRMCoreH.align >= 33) {
                     var42 = 14526719;
                  }

                  if(JRMCoreH.align < 33) {
                     var42 = 16646144;
                  }

                  this.buttonList.add(new JRMCoreGuiButtonC(-21, var12 + 5 + var49, var13 + 5 + var53, 1, 1, "", var67, var42));
               } else {
                  this.buttonList.add(new JRMCoreGuiButtonC(-21, var12 + 5 + var49, var13 + 5 + var53, 1, 1, "", var67));
               }
            }
         }

         if(this.BrghtSlcted == 0.0F) {
            var4.drawString(JRMCoreH.trl("jrmc", "AlignmentBased"), var12 + 5, var13 + 140, 0);
         }

         this.buttonList.add(new JRMCoreGuiSlider00(-20, var12 + 135, var13 + 5, "", this.BrghtSlcted, 1.0F));
         String var50 = JRMCoreH.trl("jrmc", "Back");
         int var54 = this.fontRendererObj.getStringWidth(var50) + 8;
         this.buttonList.add(new JRMCoreGuiButtons00(-5, var8 - 130 - var54, var9 + 65, var54, 20, var50, 0));
      }

      super.drawScreen(var1, var2, var3);
   }

   public boolean doesGuiPauseGame() {
      return false;
   }
}
