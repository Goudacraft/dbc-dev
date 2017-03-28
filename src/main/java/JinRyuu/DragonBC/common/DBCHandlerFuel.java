package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DBCHandlerFuel implements IFuelHandler {
   public DBCHandlerFuel() {
   }

   public int getBurnTime(ItemStack var1) {
      Item var2 = var1.getItem();
      return var2 == ItemsDBC.ItemsOW[3]?1500:(var2 == Item.getItemFromBlock(BlocksDBC.BlockOW[0])?15000:0);
   }
}
