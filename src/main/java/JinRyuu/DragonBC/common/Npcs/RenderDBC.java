package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDragon;
import JinRyuu.DragonBC.common.Npcs.EntityDragon2;
import JinRyuu.DragonBC.common.Npcs.EntityNamekian03;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent.Specials.Post;
import net.minecraftforge.client.event.RenderLivingEvent.Specials.Pre;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderDBC extends RendererLivingEntity {
   boolean b = false;

   public RenderDBC(ModelBase var1, float var2) {
      super(var1, var2);
      this.mainModel = var1;
      this.shadowSize = var2;
   }

   public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      this.doRender((EntityLivingBase)var1, var2, var4, var6, var8, var9);
   }

   protected ResourceLocation getEntityTexture(Entity var1) {
      return var1 instanceof EntityNamekian03?new ResourceLocation(((EntityNamekian03)var1).getTexture()):(var1 instanceof EntityDBC?new ResourceLocation(((EntityDBC)var1).getTexture()):(var1 instanceof EntityDragon?new ResourceLocation(((EntityDragon)var1).getTexture()):(var1 instanceof EntityDragon2?new ResourceLocation(((EntityDragon2)var1).getTexture()):new ResourceLocation("jinryuudragonbc:npcs/" + var1.getCommandSenderName().replaceAll("entity.jinryuudragonblockc.", "").replaceAll(".name", "") + ".png"))));
   }

   protected void passSpecialRender(EntityLivingBase var1, double var2, double var4, double var6) {
      if(!MinecraftForge.EVENT_BUS.post(new Pre(var1, this, var2, var4, var6))) {
         if(this.b) {
            float var8 = 1.6F;
            float var9 = 0.016666668F * var8;
            double var10 = var1.getDistanceSqToEntity(this.renderManager.livingPlayer);
            float var12 = var1.isSneaking()?NAME_TAG_RANGE_SNEAK:NAME_TAG_RANGE;
            if(var10 < (double)(var12 * var12)) {
               String var13 = var1.getCommandSenderName();
               if(var1.isSneaking()) {
                  FontRenderer var14 = this.getFontRendererFromRenderManager();
                  GL11.glPushMatrix();
                  GL11.glTranslatef((float)var2 + 0.0F, (float)var4 + var1.height + 0.5F, (float)var6);
                  GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                  GL11.glRotatef(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
                  GL11.glRotatef(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
                  GL11.glScalef(-var9, -var9, var9);
                  GL11.glDisable(2896);
                  GL11.glTranslatef(0.0F, 0.25F / var9, 0.0F);
                  GL11.glDepthMask(false);
                  GL11.glEnable(3042);
                  GL11.glBlendFunc(770, 771);
                  Tessellator var15 = Tessellator.instance;
                  GL11.glDisable(3553);
                  var15.startDrawingQuads();
                  int var16 = var14.getStringWidth(var13) / 2;
                  var15.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
                  var15.addVertex((double)(-var16 - 1), -1.0D, 0.0D);
                  var15.addVertex((double)(-var16 - 1), 8.0D, 0.0D);
                  var15.addVertex((double)(var16 + 1), 8.0D, 0.0D);
                  var15.addVertex((double)(var16 + 1), -1.0D, 0.0D);
                  var15.draw();
                  GL11.glEnable(3553);
                  GL11.glDepthMask(true);
                  var14.drawString(var13, -var14.getStringWidth(var13) / 2, 0, 553648127);
                  GL11.glEnable(2896);
                  GL11.glDisable(3042);
                  GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                  GL11.glPopMatrix();
               } else {
                  this.func_96449_a(var1, var2, var4, var6, var13, var9, var10);
               }
            }
         }

         MinecraftForge.EVENT_BUS.post(new Post(var1, this, var2, var4, var6));
      }
   }
}
