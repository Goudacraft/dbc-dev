package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.Items.ItemKatanaModel;
import JinRyuu.JRMCore.JRMCoreClient;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import org.lwjgl.opengl.GL11;

public class ItemDBCRender implements IItemRenderer {
   protected ItemKatanaModel model = new ItemKatanaModel();
   protected String t;

   public ItemDBCRender(String var1) {
      this.t = var1;
   }

   public boolean handleRenderType(ItemStack var1, ItemRenderType var2) {
      switch(var2) {
      case EQUIPPED:
         return true;
      case INVENTORY:
         return true;
      case ENTITY:
         return true;
      case EQUIPPED_FIRST_PERSON:
         return true;
      default:
         return false;
      }
   }

   public boolean shouldUseRenderHelper(ItemRenderType var1, ItemStack var2, ItemRendererHelper var3) {
      return false;
   }

   public void renderItem(ItemRenderType var1, ItemStack var2, Object... var3) {
      switch(var1) {
      case EQUIPPED:
      case ENTITY:
      case EQUIPPED_FIRST_PERSON:
         GL11.glPushMatrix();
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         JRMCoreClient.mc.renderEngine.bindTexture(new ResourceLocation("jinryuudragonbc:textures/blades/" + this.t + ".png"));
         float var6 = 1.0F;
         float var7 = 1.0F;
         GL11.glScalef(var7, var7, var7);
         GL11.glColor3f(var6, var6, var6);
         GL11.glRotatef(-140.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(-0.8F, -0.75F, -0.0F);
         this.model.render(this.t);
         GL11.glDisable(3042);
         GL11.glPopMatrix();
         break;
      case INVENTORY:
         GL11.glPushMatrix();
         float var4 = 1.0F;
         float var5 = 10.0F;
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         GL11.glScalef(var5, var5, var5);
         GL11.glColor3f(var4, var4, var4);
         GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
         GL11.glTranslatef(1.1F, -0.4F, -0.0F);
         JRMCoreClient.mc.renderEngine.bindTexture(new ResourceLocation("jinryuudragonbc:textures/blades/" + this.t + ".png"));
         this.model.render(this.t);
         GL11.glDisable(3042);
         GL11.glPopMatrix();
      }

   }
}
