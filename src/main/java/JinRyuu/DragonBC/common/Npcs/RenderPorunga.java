package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityPorunga;
import JinRyuu.DragonBC.common.Npcs.ModelPorunga;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderPorunga extends RenderLiving {
   private ModelPorunga aModel = new ModelPorunga();
   private static final ResourceLocation endermanTextures = new ResourceLocation("jinryuudragonbc:npcs/Porunga.png");

   public RenderPorunga() {
      super(new ModelPorunga(), 0.5F);
   }

   public void renderPorunga(EntityPorunga var1, double var2, double var4, double var6, float var8, float var9) {
      GL11.glPushMatrix();
      this.handleRotationFloat(var1, var9);
      float var11 = this.handleSizeFloat(var1, var9);
      Random var12 = new Random();
      float var13 = (float)((double)var12.nextInt(5) * 0.1D);
      GL11.glTranslatef((float)var2 + 0.0F, (float)var4 + 3.5F, (float)var6 + 0.0F);
      GL11.glRotatef(-(var1.prevRotationYaw + (var1.rotationYaw - var1.prevRotationYaw) * var9 - 180.0F), 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(0.0F, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation var15 = new ResourceLocation("jinryuudragonbc:npcs/Porunga.png");
      this.renderManager.renderEngine.bindTexture(var15);
      GL11.glEnable(2977);
      GL11.glPushMatrix();
      GL11.glScalef(var11, var11, var11);
      this.aModel.renderModel(var1, 0.0625F);
      GL11.glPopMatrix();
      GL11.glPopMatrix();
   }

   protected float handleRotationFloat(Entity var1, float var2) {
      return (float)var1.ticksExisted + var2;
   }

   protected float handleSizeFloat(Entity var1, float var2) {
      float var3 = (float)var1.ticksExisted * 0.05F;
      if(var3 > 3.0F) {
         var3 = 3.0F;
      }

      return var3;
   }

   public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      this.renderPorunga((EntityPorunga)var1, var2, var4, var6, var8, var9);
   }

   protected ResourceLocation getEntityTexture(Entity var1) {
      return endermanTextures;
   }
}
