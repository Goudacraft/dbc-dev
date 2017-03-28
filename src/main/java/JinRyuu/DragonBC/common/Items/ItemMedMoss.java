package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.JRMCore.items.ItemJRMCSeedFood;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;

public class ItemMedMoss extends ItemJRMCSeedFood {
   public ItemMedMoss(int var1, float var2) {
      super(var1, var2, BlocksDBC.BlockCropMedMoss, Blocks.farmland);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName().replaceAll("item.", ""));
   }
}
