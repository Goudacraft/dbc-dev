package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.Render.ArtGravDevModel;
import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ArtGravDevRender extends TileEntitySpecialRenderer {
   private ArtGravDevModel aModel = new ArtGravDevModel();

   public ArtGravDevRender() {
   }

   public void renderAModelAt(ArtGravDevTileEntity var1, double var2, double var4, double var6, float var8) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)var2 + 0.5F, (float)var4 + 1.5F, (float)var6 + 0.5F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation var9 = new ResourceLocation("jinryuudragonbc:textures/blockmodels/GravDev" + (var1.isBurning() && var1.getGravity() > 1.0F?"On":"") + ".png");
      this.bindTexture(var9);
      GL11.glPushMatrix();
      this.aModel.renderModel(0.0625F);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }

   public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
      this.renderAModelAt((ArtGravDevTileEntity)var1, var2, var4, var6, var8);
   }
}
