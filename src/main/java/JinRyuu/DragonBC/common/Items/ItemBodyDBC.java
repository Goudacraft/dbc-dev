package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.items.ItemBodysuit;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ItemBodyDBC extends ItemBodysuit {
   public String armorNamePrefix;

   public ItemBodyDBC(int var1, String var2) {
      super(var1);
      this.armorNamePrefix = var2;
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public String getTextureFile() {
      return JRMCoreH.tjdbcAssts + ":" + "";
   }

   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + this.getUnlocalizedName().replaceAll("item.", ""));
   }

   public String getArmorTexture(ItemStack var1, Entity var2, int var3, String var4) {
      String var5 = "";
      var5 = "jinryuudragonbc:armor/" + this.armorNamePrefix + ".png";
      return var5;
   }
}
