package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.blocks.BlockJRMCCrops;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockWildMedMoss extends BlockJRMCCrops {
   public BlockWildMedMoss() {
      this.maxGrowthStage = 1;
      this.setBlockTextureName(JRMCoreH.tjdbcAssts + ":" + "BlockCropMedMoss2");
   }

   protected boolean canPlaceBlockOn(Block var1) {
      return var1 == Blocks.grass || var1 == BlocksDBC.BlockNamekGrass;
   }

   public int quantityDropped(int var1, int var2, Random var3) {
      return var3.nextInt(2) + 1;
   }

   public Item getItemDropped(int var1, Random var2, int var3) {
      return ItemsDBC.ItemMedMoss;
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.iIcon = new IIcon[this.maxGrowthStage + 1];
      this.iIcon[0] = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + "BlockCropMedMoss2");
      this.iIcon[1] = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + "BlockCropMedMoss3");
   }
}
