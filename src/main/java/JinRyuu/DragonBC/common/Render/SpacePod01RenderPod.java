package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.Render.SpacePod01Entity;
import JinRyuu.DragonBC.common.Render.SpacePod01Model;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class SpacePod01RenderPod extends Render {
   private ModelBase aModel = new SpacePod01Model();
   private static final ResourceLocation shearedSheepTextures = new ResourceLocation("jinryuudragonbc:SpacePodBlock.png");

   public SpacePod01RenderPod() {
      this.shadowSize = 0.5F;
   }

   public void renderAModelAt(SpacePod01Entity var1, double var2, double var4, double var6, float var8, float var9) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)var2, (float)var4 + 1.0F, (float)var6);
      GL11.glRotatef(180.0F - var8, 0.0F, 1.0F, 0.0F);
      ResourceLocation var10 = new ResourceLocation("jinryuudragonbc:SpacePodBlock.png");
      this.renderManager.renderEngine.bindTexture(var10);
      GL11.glEnable(2977);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glScalef(-1.0F, -1.0F, 1.0F);
      this.aModel.render(var1, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      this.renderAModelAt((SpacePod01Entity)var1, var2, var4, var6, var8, var9);
   }

   protected ResourceLocation getEntityTexture(Entity var1) {
      return shearedSheepTextures;
   }
}
