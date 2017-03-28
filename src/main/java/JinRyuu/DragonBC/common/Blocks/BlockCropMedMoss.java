package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.blocks.BlockJRMCCrops;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockCropMedMoss extends BlockJRMCCrops {
   public BlockCropMedMoss() {
      this.setBlockTextureName(JRMCoreH.tjdbcAssts + ":" + "BlockCropMedMoss0");
   }

   public int quantityDropped(int var1, int var2, Random var3) {
      return var1 / 3 > 1?var1 / 3 + var3.nextInt(2):var1 / 3;
   }

   public Item getItemDropped(int var1, Random var2, int var3) {
      return ItemsDBC.ItemMedMoss;
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.iIcon = new IIcon[this.maxGrowthStage + 1];
      this.iIcon[0] = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + "BlockCropMedMoss0");
      this.iIcon[1] = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + "BlockCropMedMoss0");
      this.iIcon[2] = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + "BlockCropMedMoss0");
      this.iIcon[3] = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + "BlockCropMedMoss1");
      this.iIcon[4] = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + "BlockCropMedMoss1");
      this.iIcon[5] = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + "BlockCropMedMoss2");
      this.iIcon[6] = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + "BlockCropMedMoss2");
      this.iIcon[7] = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + "BlockCropMedMoss3");
   }
}
