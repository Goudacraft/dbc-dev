package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenNamekTrees extends WorldGenerator {
   private final int minTreeHeight;
   private final boolean growVines;
   private final int metaWood;
   private final int metaLeaves;

   public WorldGenNamekTrees(boolean var1) {
      this(var1, 8, 0, 0, false);
   }

   public WorldGenNamekTrees(boolean var1, int var2, int var3, int var4, boolean var5) {
      super(var1);
      this.minTreeHeight = var2;
      this.metaWood = var3;
      this.metaLeaves = var4;
      this.growVines = var5;
   }

   public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
      if(var1.isAirBlock(var3, var4, var5) && (var1.getBlock(var3, var4 - 1, var5) == BlocksDBC.BlockNamekGrass || var1.getBlock(var3, var4 - 1, var5) == BlocksDBC.BlockNamekDirt)) {
         this.setBlock(var1, var3 + 0, var4 + 0, var5 + 0, BlocksDBC.BlockNamekLog);
         this.setBlock(var1, var3 + 0, var4 + 1, var5 + 0, BlocksDBC.BlockNamekLog);
         this.setBlock(var1, var3 + 0, var4 + 2, var5 + 0, BlocksDBC.BlockNamekLog);
         this.setBlock(var1, var3 + 0, var4 + 3, var5 + 0, BlocksDBC.BlockNamekLog);
         this.setBlock(var1, var3 + 0, var4 + 4, var5 + 0, BlocksDBC.BlockNamekLog);
         this.setBlock(var1, var3 + 0, var4 + 5, var5 + 0, BlocksDBC.BlockNamekLog);
         this.setBlock(var1, var3 - 1, var4 + 6, var5 + 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 - 1, var4 + 6, var5 + 0, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 - 1, var4 + 6, var5 - 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 0, var4 + 6, var5 + 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 0, var4 + 6, var5 + 0, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 0, var4 + 6, var5 - 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 1, var4 + 6, var5 + 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 1, var4 + 6, var5 + 0, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 1, var4 + 6, var5 - 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 - 1, var4 + 7, var5 + 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 - 1, var4 + 7, var5 + 0, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 - 1, var4 + 7, var5 - 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 0, var4 + 7, var5 + 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 0, var4 + 7, var5 + 0, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 0, var4 + 7, var5 - 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 1, var4 + 7, var5 + 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 1, var4 + 7, var5 + 0, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 1, var4 + 7, var5 - 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 - 1, var4 + 8, var5 + 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 - 1, var4 + 8, var5 + 0, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 - 1, var4 + 8, var5 - 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 0, var4 + 8, var5 + 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 0, var4 + 8, var5 + 0, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 0, var4 + 8, var5 - 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 1, var4 + 8, var5 + 1, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 1, var4 + 8, var5 + 0, BlocksDBC.BlockNamekLeaves);
         this.setBlock(var1, var3 + 1, var4 + 8, var5 - 1, BlocksDBC.BlockNamekLeaves);
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
