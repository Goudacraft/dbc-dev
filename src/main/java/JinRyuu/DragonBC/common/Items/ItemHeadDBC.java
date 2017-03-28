package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.items.ItemHeadwear;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ItemHeadDBC extends ItemHeadwear {
   private String armorNamePrefix;
   private String tier;

   public ItemHeadDBC(String var1, String var2) {
      super(var1, var2, Integer.parseInt(var2) * 50 + 200);
      this.armorNamePrefix = var1;
      this.tier = var2;
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public String getTextureFile() {
      return JRMCoreH.tjdbcAssts + ":" + "";
   }

   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + this.getUnlocalizedName().replaceAll("item.", "").replaceAll("Scoutera", "Scouter").replaceAll("Scouterb", "Scouter"));
   }

   public String getArmorTexture(ItemStack var1, Entity var2, int var3, String var4) {
      String var5 = "";
      String var6 = "";
      String var7 = "";
      var7 = "jbra";
      if(!var1.toString().contains("leg") && !var1.toString().contains("Leg")) {
         var5 = "jinryuudragonbc:armor/" + this.armorNamePrefix + "_1" + var7 + var6 + ".png";
      } else {
         var5 = "jinryuudragonbc:armor/" + this.armorNamePrefix + "_2" + var7 + var6 + ".png";
      }

      return var5;
   }
}
