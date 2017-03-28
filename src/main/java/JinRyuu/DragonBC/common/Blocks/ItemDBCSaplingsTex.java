package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.Blocks.BlockDBCSaplings;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemDBCSaplingsTex extends ItemBlock {
   protected final String[] field_150942_c = BlockDBCSaplings.field_149882_a;

   public ItemDBCSaplingsTex(Block var1) {
      super(var1);
      this.setHasSubtypes(true);
   }

   public int getMetadata(int var1) {
      return var1;
   }

   public String getUnlocalizedName(ItemStack var1) {
      int var2 = var1.getItemDamage();
      if(var2 < 0 || var2 >= this.field_150942_c.length) {
         var2 = 0;
      }

      return "tile.Block" + this.field_150942_c[var2] + "Sapling";
   }
}
