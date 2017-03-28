package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Worlds.WorldGenNamekTrees;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockDBCSaplings extends BlockSapling {
   public static final String[] field_149882_a = new String[]{"Namek"};
   private static final IIcon[] field_149881_b = new IIcon[field_149882_a.length];

   protected BlockDBCSaplings() {
      float var1 = 0.4F;
      this.setBlockBounds(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var1 * 2.0F, 0.5F + var1);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
      if(!var1.isRemote) {
         super.updateTick(var1, var2, var3, var4, var5);
         if(var1.getBlockLightValue(var2, var3 + 1, var4) >= 9 && var5.nextInt(7) == 0) {
            this.func_149879_c(var1, var2, var3, var4, var5);
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int var1, int var2) {
      var2 = var2 & 7;
      return field_149881_b[MathHelper.clamp_int(var2, 0, 5)];
   }

   public void func_149879_c(World var1, int var2, int var3, int var4, Random var5) {
      int var6 = var1.getBlockMetadata(var2, var3, var4);
      if((var6 & 8) == 0) {
         var1.setBlockMetadataWithNotify(var2, var3, var4, var6 | 8, 4);
      } else {
         this.func_149878_d(var1, var2, var3, var4, var5);
      }

   }

   public void func_149878_d(World var1, int var2, int var3, int var4, Random var5) {
      if(TerrainGen.saplingGrowTree(var1, var5, var2, var3, var4)) {
         int var6 = var1.getBlockMetadata(var2, var3, var4) & 7;
         WorldGenNamekTrees var7 = var5.nextInt(10) == 0?new WorldGenNamekTrees(true):new WorldGenNamekTrees(true);
         byte var8 = 0;
         byte var9 = 0;
         boolean var10 = false;
         switch(var6) {
         case 0:
         default:
            var7 = new WorldGenNamekTrees(true);
         case 1:
            Block var11 = Blocks.air;
            if(var10) {
               var1.setBlock(var2 + var8, var3, var4 + var9, var11, 0, 4);
               var1.setBlock(var2 + var8 + 1, var3, var4 + var9, var11, 0, 4);
               var1.setBlock(var2 + var8, var3, var4 + var9 + 1, var11, 0, 4);
               var1.setBlock(var2 + var8 + 1, var3, var4 + var9 + 1, var11, 0, 4);
            } else {
               var1.setBlock(var2, var3, var4, var11, 0, 4);
            }

            if(!((WorldGenerator)var7).generate(var1, var5, var2 + var8, var3, var4 + var9)) {
               if(var10) {
                  var1.setBlock(var2 + var8, var3, var4 + var9, this, var6, 4);
                  var1.setBlock(var2 + var8 + 1, var3, var4 + var9, this, var6, 4);
                  var1.setBlock(var2 + var8, var3, var4 + var9 + 1, this, var6, 4);
                  var1.setBlock(var2 + var8 + 1, var3, var4 + var9 + 1, this, var6, 4);
               } else {
                  var1.setBlock(var2, var3, var4, this, var6, 4);
               }
            }

         }
      }
   }

   public boolean func_149880_a(World var1, int var2, int var3, int var4, int var5) {
      return var1.getBlock(var2, var3, var4) == this && (var1.getBlockMetadata(var2, var3, var4) & 7) == var5;
   }

   public int damageDropped(int var1) {
      return MathHelper.clamp_int(var1 & 7, 0, 5);
   }

   @SideOnly(Side.CLIENT)
   public void getSubBlocks(Item var1, CreativeTabs var2, List var3) {
      var3.add(new ItemStack(var1, 1, 0));
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      for(int var2 = 0; var2 < field_149881_b.length; ++var2) {
         field_149881_b[var2] = var1.registerIcon("jinryuudragonbc:tile.Block" + field_149882_a[var2] + "Sapling");
      }

   }

   public boolean func_149851_a(World var1, int var2, int var3, int var4, boolean var5) {
      return true;
   }

   public boolean func_149852_a(World var1, Random var2, int var3, int var4, int var5) {
      return (double)var1.rand.nextFloat() < 0.45D;
   }

   public void func_149853_b(World var1, Random var2, int var3, int var4, int var5) {
      this.func_149879_c(var1, var3, var4, var5, var2);
   }

   protected boolean canPlaceBlockOn(Block var1) {
      return var1 == BlocksDBC.BlockNamekGrass;
   }
}
