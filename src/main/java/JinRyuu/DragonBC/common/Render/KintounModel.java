package JinRyuu.DragonBC.common.Render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class KintounModel extends ModelBase {
   ModelRenderer Shape1;
   ModelRenderer Shape2;
   ModelRenderer Shape3;
   ModelRenderer Shape4;
   ModelRenderer Shape6;
   ModelRenderer Shape7;

   public KintounModel() {
      this.textureWidth = 128;
      this.textureHeight = 64;
      this.Shape1 = new ModelRenderer(this, 0, 0);
      this.Shape1.addBox(-10.0F, -7.0F, -10.0F, 20, 10, 16);
      this.Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
      this.Shape2 = new ModelRenderer(this, 0, 0);
      this.Shape2.addBox(-8.0F, -6.0F, -12.0F, 16, 8, 20);
      this.Shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
      this.Shape3 = new ModelRenderer(this, 0, 0);
      this.Shape3.addBox(-4.0F, -4.0F, -14.0F, 8, 4, 24);
      this.Shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
      this.Shape4 = new ModelRenderer(this, 0, 0);
      this.Shape4.addBox(-8.0F, -8.0F, -8.0F, 16, 12, 12);
      this.Shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
      this.Shape6 = new ModelRenderer(this, 0, 0);
      this.Shape6.addBox(-12.0F, -6.0F, -8.0F, 24, 8, 12);
      this.Shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
      this.Shape7 = new ModelRenderer(this, 0, 0);
      this.Shape7.addBox(-14.0F, -4.0F, -5.0F, 28, 4, 6);
      this.Shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
      this.Shape1.addChild(this.Shape2);
      this.Shape1.addChild(this.Shape3);
      this.Shape1.addChild(this.Shape4);
      this.Shape1.addChild(this.Shape6);
      this.Shape1.addChild(this.Shape7);
   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, 0.0F, 0.5F);
      this.Shape1.render(var7);
      GL11.glPopMatrix();
   }

   public void renderModel(float var1) {
      this.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, var1);
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
   }
}
