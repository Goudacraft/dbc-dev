package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockAlienCobbleStone extends Block {
   public BlockAlienCobbleStone() {
      super(Material.rock);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
      this.setHardness(2.0F);
      this.setResistance(10.0F);
      this.setStepSound(soundTypeStone);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }
}
