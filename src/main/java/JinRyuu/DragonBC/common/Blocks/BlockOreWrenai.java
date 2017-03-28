package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;

public class BlockOreWrenai extends Block {
   public BlockOreWrenai() {
      super(Material.rock);
      this.setTickRandomly(true);
      this.setHardness(3.0F);
      this.setResistance(5.0F);
      this.setStepSound(soundTypeStone);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public int quantityDroppedWithBonus(int var1, Random var2) {
      return MathHelper.clamp_int(this.quantityDropped(var2) + var2.nextInt(var1 + 1), 1, 1);
   }

   public int quantityDropped(Random var1) {
      return 2 + var1.nextInt(3);
   }

   public Item getItemDropped(int var1, Random var2, int var3) {
      return ItemsDBC.ItemWarenai;
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }
}
