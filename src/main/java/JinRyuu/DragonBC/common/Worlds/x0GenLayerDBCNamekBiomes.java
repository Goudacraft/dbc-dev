package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class x0GenLayerDBCNamekBiomes extends GenLayer {
   protected BiomeGenBase[] allowedBiomes = new BiomeGenBase[]{BiomeGenBaseDBC.Namek};

   public x0GenLayerDBCNamekBiomes(long var1) {
      super(var1);
   }

   public x0GenLayerDBCNamekBiomes(long var1, GenLayer var3) {
      super(var1);
      this.parent = var3;
   }

   public int[] getInts(int var1, int var2, int var3, int var4) {
      int[] var5 = IntCache.getIntCache(var3 * var4);

      for(int var6 = 0; var6 < var4; ++var6) {
         for(int var7 = 0; var7 < var3; ++var7) {
            this.initChunkSeed((long)(var7 + var1), (long)(var6 + var2));
            var5[var7 + var6 * var3] = this.allowedBiomes[this.nextInt(this.allowedBiomes.length)].biomeID;
         }
      }

      return var5;
   }
}
