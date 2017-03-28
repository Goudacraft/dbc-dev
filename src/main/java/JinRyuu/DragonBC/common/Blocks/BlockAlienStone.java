package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockAlienStone extends Block {
   public BlockAlienStone() {
      super(Material.rock);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
      this.setHardness(1.5F);
      this.setResistance(10.0F);
      this.setStepSound(soundTypeStone);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public Item getItemDropped(int var1, Random var2, int var3) {
      return Item.getItemFromBlock(BlocksDBC.BlockAlienCobbleStone);
   }
}
