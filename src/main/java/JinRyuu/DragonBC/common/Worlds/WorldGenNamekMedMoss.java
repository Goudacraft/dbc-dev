package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenNamekMedMoss extends WorldGenerator {
   public WorldGenNamekMedMoss(boolean var1) {
      super(var1);
   }

   public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
      if(var1.isAirBlock(var3, var4, var5) && var1.getBlock(var3, var4 - 1, var5) == BlocksDBC.BlockNamekGrass) {
         this.func_150515_a(var1, var3 + 0, var4 + 0, var5 + 0, BlocksDBC.BlockWildMedMoss);
      }

      return true;
   }
}
