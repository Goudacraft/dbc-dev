package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityAuraPur;
import JinRyuu.DragonBC.common.Npcs.ModelAura;
import JinRyuu.DragonBC.common.Npcs.RenderDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderAuraPur extends RenderDBC {
   private ModelAura aModel = new ModelAura();

   public RenderAuraPur() {
      super(new ModelAura(), 0.5F);
   }

   public void renderAuraPur(EntityAuraPur var1, double var2, double var4, double var6, float var8, float var9) {
      this.shadowSize = 0.0F;
      GL11.glPushMatrix();
      GL11.glPushMatrix();
      float var10 = this.handleRotationFloat(var1, var9);
      Random var11 = new Random();
      float var12 = (float)((double)var11.nextInt(5) * 0.1D);
      GL11.glTranslatef((float)var2 + 0.0F, (float)var4 + 1.5F, (float)var6 + 0.0F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation var13 = new ResourceLocation("jinryuudragonbc:aurap.png");
      this.renderManager.renderEngine.bindTexture(var13);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.15F);
      GL11.glDepthMask(false);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glAlphaFunc(516, 0.003921569F);

      for(int var14 = 0; var14 < 8; ++var14) {
         GL11.glPushMatrix();
         GL11.glRotatef((float)(var14 * 45), 0.0F, 1.0F, 0.0F);
         this.aModel.renderModel(var1, 0.0625F, var10, 0.0F, 20.0F);
         GL11.glPopMatrix();
      }

      GL11.glDisable(3042);
      GL11.glAlphaFunc(516, 0.1F);
      GL11.glPopMatrix();
      GL11.glDepthMask(true);
      GL11.glPopMatrix();
   }

   protected float handleRotationFloat(Entity var1, float var2) {
      return (float)var1.ticksExisted + var2;
   }

   public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      this.renderAuraPur((EntityAuraPur)var1, var2, var4, var6, var8, var9);
   }
}
