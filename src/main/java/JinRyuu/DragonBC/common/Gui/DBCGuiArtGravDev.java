package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.Gui.DBCGuiButtons01;
import JinRyuu.DragonBC.common.Render.ArtGravDevContainer;
import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
import JinRyuu.DragonBC.common.p.DBCPwish;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.p.PD;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class DBCGuiArtGravDev extends GuiContainer {
   private static final ResourceLocation furnaceGuiTextures = new ResourceLocation(JRMCoreH.tjdbcAssts, "gui/ArtGravDev.png");
   private ArtGravDevTileEntity tileFurnace;
   private String name = "";
   private int text = 0;
   protected GuiTextField inputField;
   private String defaultInputFieldText = "";
   private boolean updateTimerStopper = false;

   public DBCGuiArtGravDev(InventoryPlayer var1, ArtGravDevTileEntity var2) {
      super(new ArtGravDevContainer(var1, var2));
      this.tileFurnace = var2;
   }

   public void actionPerformed(GuiButton var1) {
      if((this.name.matches("[0-9].+") || this.name.matches("[0-9]+")) && this.name.length() > 0) {
         this.name = (Float.parseFloat(this.name) > 1000.0F?1000.0F:(Float.parseFloat(this.name) < 1.0F?1.0F:Float.parseFloat(this.name))) + "";
         if(var1.id == 210) {
            PD.sendToServer(new DBCPwish(4, this.tileFurnace.xCoord + ";" + this.tileFurnace.yCoord + ";" + this.tileFurnace.zCoord + ";" + this.name));
            this.mc.thePlayer.closeScreen();
         }
      }

   }

   private void name(FontRenderer var1, int var2, int var3) {
      this.inputField = new GuiTextField(var1, var2 + 100, var3 + 15 + 0, 40, 12);
      this.inputField.setMaxStringLength(5);
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

   protected void drawGuiContainerForegroundLayer(int var1, int var2) {
      String var3 = this.tileFurnace.hasCustomInventoryName()?this.tileFurnace.getInventoryName():I18n.format(this.tileFurnace.getInventoryName(), new Object[0]);
      this.fontRendererObj.drawString(var3, this.xSize / 2 - this.fontRendererObj.getStringWidth(var3) / 2, 6, 4210752);
      this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
      int var4 = this.width / 2;
      int var5 = this.height / 2;
      int var6 = (this.width - this.xSize) / 2;
      int var7 = (this.height - this.ySize) / 2;
      int var8 = 1;
      ++var8;
      StringBuilder var10000 = (new StringBuilder()).append(JRMCoreH.trl("dbc", "Gravity")).append(": ");
      Object var13;
      if(this.tileFurnace.isBurning() && this.tileFurnace.getGravity() > 1.0F) {
         var13 = Float.valueOf(this.tileFurnace.getGravity());
      } else {
         String var10002;
         label200: {
            var13 = (new StringBuilder()).append("1");
            if(!this.tileFurnace.isBurning()) {
               ArtGravDevTileEntity var10003 = this.tileFurnace;
               if(this.tileFurnace.getStackInSlot(0) == null) {
                  var10002 = " (" + JRMCoreH.trl("dbc", "OutOfFuel") + ")";
                  break label200;
               }
            }

            var10002 = "";
         }

         var13 = var13.append(var10002).toString();
      }

      String var9 = var10000.append(var13).toString();
      int var10 = this.fontRendererObj.getStringWidth(var9) + 8;
      this.fontRendererObj.drawString(var9, 25, 10 + var8 * 11, 0);
      ++var8;
   }

   protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
      int var4 = (this.width - this.xSize) / 2;
      int var5 = (this.height - this.ySize) / 2;
      this.drawTexturedModalRect(var4, var5, 0, 0, this.xSize, this.ySize);
      int var6 = (this.width - this.xSize) / 2;
      int var7 = (this.height - this.ySize) / 2;
      if(this.tileFurnace.isBurning()) {
         int var8 = this.tileFurnace.getBurnTimeRemainingScaled(13);
         this.drawTexturedModalRect(var4 + 5, var5 + 36 + 12 - var8, 176, 12 - var8, 14, var8 + 1);
      }

      int var11 = 1;
      String var9 = JRMCoreH.trl("dbc", "SetGravity") + ":";
      int var10 = this.fontRendererObj.getStringWidth(var9) + 8;
      ++this.text;
      if(this.text == 1) {
         this.name(this.fontRendererObj, var6 + 25 - 100 + var10, var7 + 10 - 18 + var11 * 11);
         this.inputField.setText("1");
      } else {
         this.text = 2;
      }

      if(this.inputField != null) {
         this.inputField.drawTextBox();
         this.name = this.inputField.getText();
         this.fontRendererObj.drawString(var9, var6 + 25, var7 + 10 + var11 * 11, 0);
      }

      ++var11;
   }

   public void drawScreen(int var1, int var2, float var3) {
      ScaledResolution var4 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var5 = var4.getScaledWidth();
      int var6 = var4.getScaledHeight();
      FontRenderer var7 = this.mc.fontRenderer;
      this.buttonList.clear();
      int var8 = this.width / 2;
      int var9 = this.height / 2;
      int var10 = 1;
      String var11 = JRMCoreH.trl("jrmc", "Update");
      int var12 = this.fontRendererObj.getStringWidth(var11) + 8;
      this.buttonList.add(new DBCGuiButtons01(210, this.guiLeft + 165 - var12, this.guiTop + 35 + var10 * 11, var12, 20, var11));
      ++var10;
      super.drawScreen(var1, var2, var3);
   }
}
