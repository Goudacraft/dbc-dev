package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.Render.SpacePod01TileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class DBCGui extends GuiContainer {
   public DBCGui(InventoryPlayer var1, SpacePod01TileEntity var2) {
      super((Container)null);
   }

   protected void drawGuiContainerForegroundLayer(int var1, int var2) {
      this.fontRendererObj.drawString("Tutorial Gui", 6, 6, 16777215);
      this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 6, this.ySize - 96, 16777215);
   }

   protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
      String var4 = "/terrain.png";
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      ResourceLocation var5 = new ResourceLocation(var4);
      this.mc.renderEngine.bindTexture(var5);
      int var6 = (this.width - this.xSize) / 2;
      int var7 = (this.height - this.ySize) / 2;
      this.drawTexturedModalRect(var6, var7, 0, 0, this.xSize, this.ySize);
   }
}
