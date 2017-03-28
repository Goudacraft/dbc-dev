package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class ItemDBCBucket extends ItemBucket {
   public ItemDBCBucket(Block var1) {
      super(var1);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
      this.setContainerItem(Items.bucket);
   }

   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName().replaceAll("item.", ""));
   }
}
