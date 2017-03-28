package JinRyuu.DragonBC.common.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

@SideOnly(Side.CLIENT)
public class ItemKatanaModel extends ModelBase {
   ModelRenderer sw;
   ModelRenderer grip;
   ModelRenderer pummel;
   ModelRenderer guard;
   ModelRenderer edge;
   ModelRenderer kat;
   ModelRenderer kgrip;
   ModelRenderer kguard;
   ModelRenderer kedge;

   public ItemKatanaModel() {
      this(0.0F);
   }

   public ItemKatanaModel(float var1) {
      this(var1, 0.0F, 64, 32);
   }

   public ItemKatanaModel(float var1, float var2, int var3, int var4) {
      this.textureWidth = var3;
      this.textureHeight = var4;
      this.sw = new ModelRenderer(this, 0, 0);
      this.sw.addBox(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F);
      this.sw.setRotationPoint(0.0F, 0.0F + var2, 0.0F);
      this.grip = new ModelRenderer(this, 0, 0);
      this.grip.addBox(0.0F, 13.96667F, 0.0F, 1, 7, 1);
      this.grip.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.grip, 0.0F, 0.0F, 0.0F);
      this.guard = new ModelRenderer(this, 0, 26);
      this.guard.addBox(-2.0F, 9.9F, -10.0F, 5, 1, 1);
      this.guard.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.guard, 0.7853982F, 0.0F, 0.0F);
      this.edge = new ModelRenderer(this, 4, 0);
      this.edge.addBox(-1.0F, -10.1F, 0.5F, 3, 24, 0);
      this.edge.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.edge, 0.0F, 0.0F, 0.0F);
      this.pummel = new ModelRenderer(this, 0, 28);
      this.pummel.addBox(-0.5F, 20.1F, -0.5F, 2, 2, 2);
      this.pummel.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.pummel, 0.0F, 0.0F, 0.0F);
      this.sw.addChild(this.grip);
      this.sw.addChild(this.pummel);
      this.sw.addChild(this.guard);
      this.sw.addChild(this.edge);
      this.kat = new ModelRenderer(this, 0, 0);
      this.kat.addBox(-0.0F, -0.0F, -0.0F, 0, 0, 0, 0.02F);
      this.kat.setRotationPoint(0.0F, 0.0F + var2, 0.0F);
      this.kgrip = new ModelRenderer(this, 0, 0);
      this.kgrip.addBox(0.0F, 13.96667F, 0.0F, 1, 7, 1);
      this.kgrip.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.kgrip, 0.0F, 0.0F, 0.0F);
      this.kguard = new ModelRenderer(this, 0, 29);
      this.kguard.addBox(-1.0F, 13.9F, -1.0F, 3, 0, 3);
      this.kguard.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.kguard, 0.0F, 0.0F, 0.0F);
      this.kedge = new ModelRenderer(this, 4, 0);
      this.kedge.addBox(-1.0F, -10.1F, 0.5F, 3, 24, 0);
      this.kedge.setRotationPoint(0.0F, 0.0F, 0.0F);
      this.setRotation(this.kedge, 0.0F, 0.0F, 0.0F);
      this.kat.addChild(this.kgrip);
      this.kat.addChild(this.kguard);
      this.kat.addChild(this.kedge);
   }

   private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
      var1.rotateAngleX = var2;
      var1.rotateAngleY = var3;
      var1.rotateAngleZ = var4;
   }

   public void render(String var1) {
      float var2 = 0.0625F;
      if(var1.contains("S") || var1.contains("Z")) {
         this.sw.render(var2);
      }

      if(var1.contains("K")) {
         this.kat.render(var2);
      }

   }
}
