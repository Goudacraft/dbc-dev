package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.Render.Hair01TileEntity;
import JinRyuu.DragonBC.common.Render.hair;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class Hair01Render extends TileEntitySpecialRenderer {
   private hair aModel = new hair();

   public Hair01Render() {
   }

   public void renderAModelAt(Hair01TileEntity var1, double var2, double var4, double var6, float var8) {
      GL11.glPushMatrix();
      GL11.glTranslatef((float)var2 + 0.5F, (float)var4 + 0.5F, (float)var6 + 0.5F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation var9 = new ResourceLocation("jinryuudragonbc:armor/hair.png");
      this.bindTexture(var9);
      GL11.glPushMatrix();
      this.aModel.renderModel(0.0625F);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }

   public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
      this.renderAModelAt((Hair01TileEntity)var1, var2, var4, var6, var8);
   }
}
