package JinRyuu.DragonBC.common.Entitys;

import JinRyuu.DragonBC.common.Entitys.EntityEnergyFM;
import JinRyuu.DragonBC.common.Npcs.ModelEnergy;
import JinRyuu.DragonBC.common.Npcs.RenderDBC;
import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderEnergyFM extends RenderDBC {
   private ModelEnergy ener = new ModelEnergy();
   private double dist;

   public RenderEnergyFM() {
      super(new ModelEnergy(), 0.5F);
   }

   public void renderEnergy(EntityEnergyFM var1, double var2, double var4, double var6, float var8, float var9) {
      int var10 = var1.getShrink();
      int var11 = JRMCoreH.techCol[1];
      boolean var12 = false;
      if(var1.shootingEntity != null) {
         var12 = var1.shootingEntity.getEntityId() == JRMCoreClient.mc.thePlayer.getEntityId();
      }

      float var13 = this.handleRotationFloat(var1, var9);
      double var14 = (double)var1.strtX();
      double var16 = (double)var1.strtY();
      double var18 = (double)var1.strtZ();
      double var20 = var14 - var1.posX;
      double var22 = var16 - var1.posY;
      double var24 = var18 - var1.posZ;
      double var10000 = var14 - (double)var1.trgtX();
      var10000 = var16 - (double)var1.trgtY();
      var10000 = var18 - (double)var1.trgtZ();
      if(var10 > 0) {
         double var32 = this.dist - (double)((float)var1.getSpe() * 0.05F);
         this.dist = var32 < 0.0D?0.0D:var32;
      } else {
         this.dist = (double)MathHelper.sqrt_double(var20 * var20 + var22 * var22 + var24 * var24);
      }

      int var41 = (int)(var1.posY > 80.0D?var1.posY - 80.0D:1.0D) * 4;
      float var33 = 1.0F + (float)(var41 / 5 * 100) * 0.02F * 0.15F;
      double var34 = var14 - JRMCoreClient.mc.thePlayer.posX;
      double var36 = var16 - JRMCoreClient.mc.thePlayer.posY;
      double var38 = var18 - JRMCoreClient.mc.thePlayer.posZ;
      GL11.glPushMatrix();
      GL11.glDisable(2896);
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
      GL11.glDepthMask(false);
      GL11.glEnable(3042);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glTranslatef((float)var2, (float)var4, (float)var6);
      GL11.glRotatef(var1.prevRotationYaw + (var1.rotationYaw - var1.prevRotationYaw) * var9 - 180.0F, 0.0F, 1.0F, 0.0F);
      GL11.glRotatef(var1.prevRotationPitch + (var1.rotationPitch - var1.prevRotationPitch) * var9, 1.0F, 0.0F, 0.0F);
      GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      this.tex(var11);
      GL11.glScalef(var33 / 2.0F, var33 / 2.0F, var33 / 2.0F);
      this.ener.renderModel((byte)1, var1, 0.0F, 0.0F, 0.0625F, var13, false);
      GL11.glDepthMask(true);
      GL11.glEnable(2896);
      GL11.glDisable(3042);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
   }

   public void tex(int var1) {
      float var2 = (float)(var1 >> 16 & 255) / 255.0F;
      float var3 = (float)(var1 >> 8 & 255) / 255.0F;
      float var4 = (float)(var1 & 255) / 255.0F;
      GL11.glColor4f(var2, var3, var4, 0.5F);
      ResourceLocation var5 = new ResourceLocation("jinryuumodscore:allw.png");
      this.renderManager.renderEngine.bindTexture(var5);
   }

   protected float handleRotationFloat(Entity var1, float var2) {
      return (float)var1.ticksExisted + var2;
   }

   public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      this.renderEnergy((EntityEnergyFM)var1, var2, var4, var6, var8, var9);
   }
}
