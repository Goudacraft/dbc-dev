package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSaibaiHatchlings extends WorldGenerator {
   public WorldGenSaibaiHatchlings() {
   }

   public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
      for(int var6 = 0; var6 < 1; ++var6) {
         int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
         int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
         int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);
         if(var1.isAirBlock(var7, var8, var9) && var1.getBlock(var7, var8 - 1, var9) == BlocksDBC.BlockNamekDirt && BlocksDBC.SaibaiHatched.canPlaceBlockAt(var1, var7, var8, var9)) {
            var1.setBlock(var7, var8 - 1, var9, BlocksDBC.SaibaiHatched, 1, 4);
            EntitySaibaiman var10 = new EntitySaibaiman(var1);
            var10.setLocationAndAngles((double)var7, (double)var8, (double)var9, 0.0F, 0.0F);
            var1.spawnEntityInWorld(var10);
         }
      }

      return true;
   }
}
