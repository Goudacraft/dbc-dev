package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemAlienTechChipTier1 extends Item {
   public ItemAlienTechChipTier1() {
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }
}
