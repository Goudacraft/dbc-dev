package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenOWTrees extends WorldGenerator {
   private final int minTreeHeight;
   private final boolean growVines;
   private final int metaWood;
   private final int metaLeaves;

   public WorldGenOWTrees(boolean var1) {
      this(var1, 8, 0, 0, false);
   }

   public WorldGenOWTrees(boolean var1, int var2, int var3, int var4, boolean var5) {
      super(var1);
      this.minTreeHeight = var2;
      this.metaWood = var3;
      this.metaLeaves = var4;
      this.growVines = var5;
   }

   public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
      if(var1.isAirBlock(var3, var4, var5) && !var1.isAirBlock(var3, var4 - 1, var5)) {
         int var6 = 4 + var2.nextInt(4);
         int var7 = 3 + var2.nextInt(5);
         int var8 = 3 + var2.nextInt(5);
         int var9 = 4 + var2.nextInt(4);

         for(int var10 = 0; var10 < var7; ++var10) {
            for(int var11 = 0; var11 < var8; ++var11) {
               for(int var12 = 0; var12 < var9; ++var12) {
                  this.setBlock(var1, var3 + var10 - var7 / 2, var4 + var6 - 3 + var12, var5 + var11 - var8 / 2, Blocks.leaves);
               }
            }
         }

         for(int var13 = 0; var13 < var6; ++var13) {
            this.setBlock(var1, var3 + 0, var4 + var13, var5 + 0, Blocks.log);
         }
      }

      return true;
   }

   private void setBlock(World var1, int var2, int var3, int var4, Block var5) {
      var1.setBlock(var2, var3, var4, var5);
   }

   protected boolean func_150523_a(Block var1) {
      return var1.getMaterial() == Material.air || var1.getMaterial() == Material.leaves || var1 == BlocksDBC.BlockNamekGrass || var1 == BlocksDBC.BlockNamekGrass || var1 == BlocksDBC.BlockNamekLog || var1 == BlocksDBC.BlockNamekLog || var1 == Blocks.sapling || var1 == Blocks.vine;
   }

   public void func_150524_b(World var1, Random var2, int var3, int var4, int var5) {
   }

   protected boolean isReplaceable(World var1, int var2, int var3, int var4) {
      Block var5 = var1.getBlock(var2, var3, var4);
      return var5.isAir(var1, var2, var3, var4) || var5.isLeaves(var1, var2, var3, var4) || var5.isWood(var1, var2, var3, var4) || this.func_150523_a(var5);
   }
}
