package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.Render.MedPodDoor1Model;
import JinRyuu.DragonBC.common.Render.MedPodDoor1TileEntity;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class MedPodDoor1Render extends TileEntitySpecialRenderer {
   private MedPodDoor1Model aModel = new MedPodDoor1Model();
   private int moving = 0;

   public MedPodDoor1Render() {
   }

   public void renderAModelAt(MedPodDoor1TileEntity var1, double var2, double var4, double var6, float var8) {
      GL11.glPushMatrix();
      Block var9 = var1.getBlockType();
      int var10 = var1.getBlockMetadata();
      if(var10 != 3 && var10 != 7) {
         if(var10 != 1 && var10 != 5) {
            if(var10 != 0 && var10 != 4) {
               if(var10 == 2 || var10 == 6) {
                  GL11.glTranslatef((float)var2 + 0.5F, (float)var4 + 1.0F, (float)var6 + 0.625F);
                  GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
               }
            } else {
               GL11.glTranslatef((float)var2 + 0.5F, (float)var4 + 1.0F, (float)var6 + 0.375F);
               GL11.glRotatef(0.0F, 0.0F, 1.0F, 0.0F);
            }
         } else {
            GL11.glTranslatef((float)var2 + 0.625F, (float)var4 + 1.0F, (float)var6 + 0.5F);
            GL11.glRotatef(270.0F, 0.0F, 1.0F, 0.0F);
         }
      } else {
         GL11.glTranslatef((float)var2 + 0.375F, (float)var4 + 1.0F, (float)var6 + 0.5F);
         GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
      }

      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation var11 = new ResourceLocation("jinryuudragonbc:textures/blockmodels/MedPodDoor1.png");
      this.bindTexture(var11);
      GL11.glEnable(2977);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glPushMatrix();
      this.aModel.renderModel(var1.getCb(), var10, 0.0625F);
      GL11.glPopMatrix();
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
      this.renderAModelAt((MedPodDoor1TileEntity)var1, var2, var4, var6, var8);
   }
}
