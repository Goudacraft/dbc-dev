package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockTCFloor extends Block {
   public BlockTCFloor() {
      super(Material.rock);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public int quantityDropped(Random var1) {
      return 1;
   }
}
