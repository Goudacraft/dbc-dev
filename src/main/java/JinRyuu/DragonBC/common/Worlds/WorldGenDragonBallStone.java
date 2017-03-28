package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDragonBallStone extends WorldGenerator {
   public WorldGenDragonBallStone() {
   }

   public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
      int var6 = var3 + var2.nextInt(8) - var2.nextInt(8);
      int var7 = var4 + var2.nextInt(4) - var2.nextInt(4);
      int var8 = var5 + var2.nextInt(8) - var2.nextInt(8);
      if(var1.isAirBlock(var6, var7, var8) && var1.getBlock(var6, var7 - 1, var8) == Blocks.grass && BlocksDBC.BlockDragonBallStone.canPlaceBlockAt(var1, var6, var7, var8)) {
         var1.setBlock(var6, var7, var8, BlocksDBC.BlockDragonBallStone, 10, 4);
      }

      return true;
   }
}
