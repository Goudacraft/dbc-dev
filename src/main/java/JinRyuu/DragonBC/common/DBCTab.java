package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.Items.ItemsDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DBCTab extends CreativeTabs {
   public DBCTab(String var1) {
      super(var1);
   }

   public ItemStack getIconItemStack() {
      return new ItemStack(ItemsDBC.ItemDragonBlock);
   }

   @SideOnly(Side.CLIENT)
   public Item getTabIconItem() {
      return ItemsDBC.ItemDragonBlock;
   }
}
