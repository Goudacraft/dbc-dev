package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOreDBC extends Block {
   private Random rand = new Random();

   public BlockOreDBC(int var1) {
      super(Material.rock);
      this.setHardness(3.0F);
      this.setResistance(5.0F);
      this.setStepSound(soundTypePiston);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
      this.setHarvestLevel("pickaxe", var1);
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName().replaceAll("tile.", ""));
   }

   public Item getItemDropped(int var1, Random var2, int var3) {
      return this == BlocksDBC.BlockOreJJay?ItemsDBC.ItemsOW[3]:(this == BlocksDBC.BlockOreDnomaid?ItemsDBC.ItemsOW[2]:Item.getItemFromBlock(this));
   }

   public int quantityDropped(Random var1) {
      return this == Blocks.lapis_ore?4 + var1.nextInt(5):1;
   }

   public int quantityDroppedWithBonus(int var1, Random var2) {
      if(var1 > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, var2, var1)) {
         int var3 = var2.nextInt(var1 + 2) - 1;
         if(var3 < 0) {
            var3 = 0;
         }

         return this.quantityDropped(var2) * (var3 + 1);
      } else {
         return this.quantityDropped(var2);
      }
   }

   public void dropBlockAsItemWithChance(World var1, int var2, int var3, int var4, int var5, float var6, int var7) {
      super.dropBlockAsItemWithChance(var1, var2, var3, var4, var5, var6, var7);
   }

   public int getExpDrop(IBlockAccess var1, int var2, int var3) {
      if(this.getItemDropped(var2, this.rand, var3) != Item.getItemFromBlock(this)) {
         int var4 = 0;
         if(this == BlocksDBC.BlockOreJJay) {
            var4 = MathHelper.getRandomIntegerInRange(this.rand, 0, 2);
         } else if(this == BlocksDBC.BlockOreDnomaid) {
            var4 = MathHelper.getRandomIntegerInRange(this.rand, 3, 7);
         }

         return var4;
      } else {
         return 0;
      }
   }

   public int damageDropped(int var1) {
      return this == Blocks.lapis_ore?4:0;
   }
}
