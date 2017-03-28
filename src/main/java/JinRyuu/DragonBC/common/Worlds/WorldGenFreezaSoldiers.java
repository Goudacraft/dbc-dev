package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier1;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier2;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier3;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenFreezaSoldiers extends WorldGenerator {
   public WorldGenFreezaSoldiers() {
   }

   public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
      for(int var6 = 0; var6 < 1; ++var6) {
         int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
         int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
         int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);
         if(var1.isAirBlock(var7, var8, var9) && var1.getBlock(var7, var8 - 1, var9) == BlocksDBC.BlockNamekGrass) {
            EntityFreezaSoldier1 var10 = new EntityFreezaSoldier1(var1);
            EntityFreezaSoldier2 var11 = new EntityFreezaSoldier2(var1);
            EntityFreezaSoldier3 var12 = new EntityFreezaSoldier3(var1);
            var10.setLocationAndAngles((double)var7, (double)var8 + 3.0D, (double)var9, 0.0F, 0.0F);
            var11.setLocationAndAngles((double)var7, (double)var8 + 3.0D, (double)var9 + 1.0D, 0.0F, 0.0F);
            var12.setLocationAndAngles((double)var7 + 1.0D, (double)var8 + 3.0D, (double)var9, 0.0F, 0.0F);
            var10.setSpwner(var10);
            var11.setSpwner(var11);
            var12.setSpwner(var12);
            var1.spawnEntityInWorld(var10);
            var1.spawnEntityInWorld(var11);
            var1.spawnEntityInWorld(var12);
         }
      }

      return true;
   }
}
