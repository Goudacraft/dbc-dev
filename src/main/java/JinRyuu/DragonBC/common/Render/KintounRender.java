package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.Render.KintounBaseEntity;
import JinRyuu.DragonBC.common.Render.KintounModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class KintounRender extends Render {
   private ModelBase aModel = new KintounModel();
   private static final ResourceLocation shearedSheepTextures = new ResourceLocation("jinryuudragonbc:armor/halo.png");

   public KintounRender() {
      this.shadowSize = 0.5F;
   }

   public void renderAModelAt(KintounBaseEntity var1, double var2, double var4, double var6, float var8, float var9) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)var2, (float)var4 - 0.7F, (float)var6);
      GL11.glRotatef(90.0F - var8, 0.0F, 1.0F, 0.0F);
      ResourceLocation var10 = new ResourceLocation("jinryuudragonbc:armor/white.png");
      this.renderManager.renderEngine.bindTexture(var10);
      int var11 = var1.getCloudColor();
      float var12 = 1.0F;
      float var13 = (float)(var11 >> 16 & 255) / 255.0F;
      float var14 = (float)(var11 >> 8 & 255) / 255.0F;
      float var15 = (float)(var11 & 255) / 255.0F;
      GL11.glColor3f(var12 * var13, var12 * var14, var12 * var15);
      GL11.glEnable(2977);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glScalef(-1.0F, -1.0F, 1.0F);
      this.aModel.render(var1, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      this.renderAModelAt((KintounBaseEntity)var1, var2, var4, var6, var8, var9);
   }

   protected ResourceLocation getEntityTexture(Entity var1) {
      return shearedSheepTextures;
   }
}
