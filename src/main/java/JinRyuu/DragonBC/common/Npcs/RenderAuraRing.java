package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityAuraRing;
import JinRyuu.DragonBC.common.Npcs.ModelKiAuraRing;
import JinRyuu.DragonBC.common.Npcs.RenderAura;
import JinRyuu.DragonBC.common.Npcs.RenderDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderAuraRing extends RenderDBC {
   private ModelKiAuraRing aModel = new ModelKiAuraRing();

   public RenderAuraRing() {
      super(new ModelKiAuraRing(), 0.5F);
   }

   public void renderAuraRing(EntityAuraRing var1, double var2, double var4, double var6, float var8, float var9) {
      this.shadowSize = 0.0F;
      GL11.glPushMatrix();
      float var10 = (float)var1.getAge();
      float var11 = var1.getCRel();
      float var12 = var1.getState() + var11 * 0.03F;
      float var13 = var1.getState2() * 0.5F;
      var12 = var12 + var13;
      GL11.glPushMatrix();
      float var14 = this.handleRotationFloat(var1, var9);
      float var15 = this.handleSizeFloat(var1, var9);
      Random var16 = new Random();
      float var17 = (float)((double)var16.nextInt(5) * 0.1D);
      GL11.glTranslatef((float)var2 + 0.0F, (float)var4 + 3.2F, (float)var6 + 0.0F);
      GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
      ResourceLocation var19 = new ResourceLocation("jinryuudragonbc:auraring.png");
      this.renderManager.renderEngine.bindTexture(var19);
      RenderAura.glColor4f(var1.color, var1.alpha);
      GL11.glDepthMask(false);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glAlphaFunc(516, 0.003921569F);
      GL11.glScalef(var15, 1.0F, var15);
      GL11.glTranslatef(0.0F, 0.0F - 0.15F * var12, 0.0F);
      GL11.glScalef(1.0F + 0.1F * var12, 1.0F + 0.05F * var12, 1.0F + 0.1F * var12);
      GL11.glRotatef(var10 * 18.0F, 0.0F, 1.0F, 0.0F);
      this.aModel.renderModel(var1, 0.0F, 0.0F, 0.0625F, var14);
      GL11.glDisable(3042);
      GL11.glAlphaFunc(516, 0.1F);
      GL11.glPopMatrix();
      GL11.glDepthMask(true);
      GL11.glPopMatrix();
   }

   protected float handleRotationFloat(Entity var1, float var2) {
      return (float)var1.ticksExisted + var2;
   }

   protected float handleSizeFloat(Entity var1, float var2) {
      float var3 = ((float)var1.ticksExisted + var2) / 2.0F;
      return var3;
   }

   public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      this.renderAuraRing((EntityAuraRing)var1, var2, var4, var6, var8, var9);
   }
}
