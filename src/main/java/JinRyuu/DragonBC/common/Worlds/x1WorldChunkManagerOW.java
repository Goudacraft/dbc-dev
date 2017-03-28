package JinRyuu.DragonBC.common.Worlds;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class x1WorldChunkManagerOW extends WorldChunkManager {
   private GenLayer genBiomes;
   private GenLayer biomeIndexLayer;
   private BiomeCache biomeCache;
   private List<BiomeGenBase> biomesToSpawnIn;

   public x1WorldChunkManagerOW() {
      this.biomeCache = new BiomeCache(this);
      this.biomesToSpawnIn = new ArrayList();
      this.biomesToSpawnIn.addAll(allowedBiomes);
   }

   public x1WorldChunkManagerOW(long var1, WorldType var3) {
      this();
   }

   public x1WorldChunkManagerOW(World var1) {
      this(var1.getSeed(), var1.getWorldInfo().getTerrainType());
   }

   public List<BiomeGenBase> getBiomesToSpawnIn() {
      return this.biomesToSpawnIn;
   }

   public BiomeGenBase getBiomeGenAt(int var1, int var2) {
      return this.biomeCache.getBiomeGenAt(var1, var2);
   }

   public float[] getRainfall(float[] var1, int var2, int var3, int var4, int var5) {
      IntCache.resetIntCache();
      if(var1 == null || var1.length < var4 * var5) {
         var1 = new float[var4 * var5];
      }

      int[] var6 = this.biomeIndexLayer.getInts(var2, var3, var4, var5);

      for(int var7 = 0; var7 < var4 * var5; ++var7) {
         try {
            float var8 = (float)BiomeGenBase.getBiome(var6[var7]).getIntRainfall() / 65536.0F;
            if(var8 > 1.0F) {
               var8 = 1.0F;
            }

            var1[var7] = var8;
         } catch (Throwable var11) {
            CrashReport var9 = CrashReport.makeCrashReport(var11, "Invalid Biome id");
            CrashReportCategory var10 = var9.makeCategory("DownfallBlock");
            var10.addCrashSection("biome id", Integer.valueOf(var7));
            var10.addCrashSection("downfalls[] size", Integer.valueOf(var1.length));
            var10.addCrashSection("x", Integer.valueOf(var2));
            var10.addCrashSection("z", Integer.valueOf(var3));
            var10.addCrashSection("w", Integer.valueOf(var4));
            var10.addCrashSection("h", Integer.valueOf(var5));
            throw new ReportedException(var9);
         }
      }

      return var1;
   }

   @SideOnly(Side.CLIENT)
   public float getTemperatureAtHeight(float var1, int var2) {
      return var1;
   }

   public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] var1, int var2, int var3, int var4, int var5) {
      IntCache.resetIntCache();
      if(var1 == null || var1.length < var4 * var5) {
         var1 = new BiomeGenBase[var4 * var5];
      }

      int[] var6 = this.genBiomes.getInts(var2, var3, var4, var5);

      try {
         for(int var7 = 0; var7 < var4 * var5; ++var7) {
            var1[var7] = BiomeGenBase.getBiome(var6[var7]);
         }

         return var1;
      } catch (Throwable var10) {
         CrashReport var8 = CrashReport.makeCrashReport(var10, "Invalid Biome id");
         CrashReportCategory var9 = var8.makeCategory("RawBiomeBlock");
         var9.addCrashSection("biomes[] size", Integer.valueOf(var1.length));
         var9.addCrashSection("x", Integer.valueOf(var2));
         var9.addCrashSection("z", Integer.valueOf(var3));
         var9.addCrashSection("w", Integer.valueOf(var4));
         var9.addCrashSection("h", Integer.valueOf(var5));
         throw new ReportedException(var8);
      }
   }

   public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] var1, int var2, int var3, int var4, int var5) {
      return this.getBiomeGenAt(var1, var2, var3, var4, var5, true);
   }

   public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] var1, int var2, int var3, int var4, int var5, boolean var6) {
      IntCache.resetIntCache();
      if(var1 == null || var1.length < var4 * var5) {
         var1 = new BiomeGenBase[var4 * var5];
      }

      if(var6 && var4 == 16 && var5 == 16 && (var2 & 15) == 0 && (var3 & 15) == 0) {
         BiomeGenBase[] var9 = this.biomeCache.getCachedBiomes(var2, var3);
         System.arraycopy(var9, 0, var1, 0, var4 * var5);
         return var1;
      } else {
         int[] var7 = this.biomeIndexLayer.getInts(var2, var3, var4, var5);

         for(int var8 = 0; var8 < var4 * var5; ++var8) {
            var1[var8] = BiomeGenBase.getBiome(var7[var8]);
         }

         return var1;
      }
   }

   public boolean areBiomesViable(int var1, int var2, int var3, List var4) {
      IntCache.resetIntCache();
      int var5 = var1 - var3 >> 2;
      int var6 = var2 - var3 >> 2;
      int var7 = var1 + var3 >> 2;
      int var8 = var2 + var3 >> 2;
      int var9 = var7 - var5 + 1;
      int var10 = var8 - var6 + 1;
      int[] var11 = this.genBiomes.getInts(var5, var6, var9, var10);

      try {
         for(int var12 = 0; var12 < var9 * var10; ++var12) {
            BiomeGenBase var16 = BiomeGenBase.getBiome(var11[var12]);
            if(!var4.contains(var16)) {
               return false;
            }
         }

         return true;
      } catch (Throwable var15) {
         CrashReport var13 = CrashReport.makeCrashReport(var15, "Invalid Biome id");
         CrashReportCategory var14 = var13.makeCategory("Layer");
         var14.addCrashSection("Layer", this.genBiomes.toString());
         var14.addCrashSection("x", Integer.valueOf(var1));
         var14.addCrashSection("z", Integer.valueOf(var2));
         var14.addCrashSection("radius", Integer.valueOf(var3));
         var14.addCrashSection("allowed", var4);
         throw new ReportedException(var13);
      }
   }

   public ChunkPosition findBiomePosition(int var1, int var2, int var3, List var4, Random var5) {
      IntCache.resetIntCache();
      int var6 = var1 - var3 >> 2;
      int var7 = var2 - var3 >> 2;
      int var8 = var1 + var3 >> 2;
      int var9 = var2 + var3 >> 2;
      int var10 = var8 - var6 + 1;
      int var11 = var9 - var7 + 1;
      int[] var12 = this.genBiomes.getInts(var6, var7, var10, var11);
      ChunkPosition var13 = null;
      int var14 = 0;

      for(int var15 = 0; var15 < var10 * var11; ++var15) {
         int var16 = var6 + var15 % var10 << 2;
         int var17 = var7 + var15 / var10 << 2;
         BiomeGenBase var18 = BiomeGenBase.getBiome(var12[var15]);
         if(var4.contains(var18) && (var13 == null || var5.nextInt(var14 + 1) == 0)) {
            var13 = new ChunkPosition(var16, 0, var17);
            ++var14;
         }
      }

      return var13;
   }

   public void cleanupCache() {
      this.biomeCache.cleanupCache();
   }
}
