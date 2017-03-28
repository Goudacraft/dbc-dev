package JinRyuu.DragonBC.common.Gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class DBCGuiButtons04 extends GuiButton {
   public DBCGuiButtons04(int var1, int var2, int var3, int var4, int var5, String var6) {
      super(var1, var2, var3, var4, var5, var6);
   }

   public void drawButton(Minecraft var1, int var2, int var3) {
      if(this.visible) {
         FontRenderer var4 = var1.fontRenderer;
         ResourceLocation var5 = new ResourceLocation("jinryuudragonbc:guibutton04.png");
         var1.getTextureManager().bindTexture(var5);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.field_146123_n = var2 >= this.xPosition && var3 >= this.yPosition && var2 < this.xPosition + this.width && var3 < this.yPosition + this.height;
         int var6 = this.getHoverState(this.field_146123_n);
         this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + var6 * 20, this.width / 2, this.height);
         this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + var6 * 20, this.width / 2, this.height);
         this.mouseDragged(var1, var2, var3);
         int var7 = 14737632;
         if(!this.enabled) {
            var7 = -6250336;
         } else if(this.field_146123_n) {
            var7 = 16777120;
         }

         this.drawCenteredString(var4, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, var7);
      }

   }
}
