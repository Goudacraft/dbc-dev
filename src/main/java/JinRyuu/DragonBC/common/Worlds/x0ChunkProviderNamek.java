package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
import cpw.mods.fml.common.eventhandler.Event.Result;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.event.terraingen.ChunkProviderEvent.ReplaceBiomeBlocks;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Post;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Pre;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType;

public class x0ChunkProviderNamek implements IChunkProvider {
   private Random rand;
   private NoiseGeneratorOctaves noiseGen1;
   private NoiseGeneratorOctaves noiseGen2;
   private NoiseGeneratorOctaves noiseGen3;
   private NoiseGeneratorPerlin noisePerl;
   public NoiseGeneratorOctaves noiseGen5;
   public NoiseGeneratorOctaves noiseGen6;
   public NoiseGeneratorOctaves mobSpawnerNoise;
   private World worldObj;
   private final boolean mapFeaturesEnabled;
   private WorldType worldType;
   private final double[] noiseArray;
   private final float[] parabolicField;
   private double[] stoneNoise = new double[256];
   private MapGenBase caveGenerator = new MapGenCaves();
   private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
   private MapGenBase ravineGenerator = new MapGenRavine();
   private BiomeGenBase[] biomesForGeneration;
   double[] noise3;
   double[] noise1;
   double[] noise2;
   double[] noise5;
   int[][] field_73219_j = new int[32][32];

   public x0ChunkProviderNamek(World var1, long var2, boolean var4) {
      this.worldObj = var1;
      this.mapFeaturesEnabled = var4;
      this.worldType = var1.getWorldInfo().getTerrainType();
      this.rand = new Random(var2);
      this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
      this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
      this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
      this.noisePerl = new NoiseGeneratorPerlin(this.rand, 4);
      this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
      this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
      this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
      this.noiseArray = new double[825];
      this.parabolicField = new float[25];

      for(int var5 = -2; var5 <= 2; ++var5) {
         for(int var6 = -2; var6 <= 2; ++var6) {
            float var7 = 10.0F / MathHelper.sqrt_float((float)(var5 * var5 + var6 * var6) + 0.2F);
            this.parabolicField[var5 + 2 + (var6 + 2) * 5] = var7;
         }
      }

      NoiseGenerator[] var8 = new NoiseGenerator[]{this.noiseGen1, this.noiseGen2, this.noiseGen3, this.noisePerl, this.noiseGen5, this.noiseGen6, this.mobSpawnerNoise};
      var8 = TerrainGen.getModdedNoiseGenerators(var1, this.rand, var8);
      this.noiseGen1 = (NoiseGeneratorOctaves)var8[0];
      this.noiseGen2 = (NoiseGeneratorOctaves)var8[1];
      this.noiseGen3 = (NoiseGeneratorOctaves)var8[2];
      this.noisePerl = (NoiseGeneratorPerlin)var8[3];
      this.noiseGen5 = (NoiseGeneratorOctaves)var8[4];
      this.noiseGen6 = (NoiseGeneratorOctaves)var8[5];
      this.mobSpawnerNoise = (NoiseGeneratorOctaves)var8[6];
   }

   public void func_147424_a(int var1, int var2, Block[] var3) {
      byte var4 = 63;
      this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, var1 * 4 - 2, var2 * 4 - 2, 10, 10);
      this.func_147423_a(var1 * 4, 0, var2 * 4);

      for(int var5 = 0; var5 < 4; ++var5) {
         int var6 = var5 * 5;
         int var7 = (var5 + 1) * 5;

         for(int var8 = 0; var8 < 4; ++var8) {
            int var9 = (var6 + var8) * 33;
            int var10 = (var6 + var8 + 1) * 33;
            int var11 = (var7 + var8) * 33;
            int var12 = (var7 + var8 + 1) * 33;

            for(int var13 = 0; var13 < 32; ++var13) {
               double var14 = 0.125D;
               double var16 = this.noiseArray[var9 + var13];
               double var18 = this.noiseArray[var10 + var13];
               double var20 = this.noiseArray[var11 + var13];
               double var22 = this.noiseArray[var12 + var13];
               double var24 = (this.noiseArray[var9 + var13 + 1] - var16) * var14;
               double var26 = (this.noiseArray[var10 + var13 + 1] - var18) * var14;
               double var28 = (this.noiseArray[var11 + var13 + 1] - var20) * var14;
               double var30 = (this.noiseArray[var12 + var13 + 1] - var22) * var14;

               for(int var32 = 0; var32 < 8; ++var32) {
                  double var33 = 0.25D;
                  double var35 = var16;
                  double var37 = var18;
                  double var39 = (var20 - var16) * var33;
                  double var41 = (var22 - var18) * var33;

                  for(int var43 = 0; var43 < 4; ++var43) {
                     int var44 = var43 + var5 * 4 << 12 | 0 + var8 * 4 << 8 | var13 * 8 + var32;
                     short var45 = 256;
                     var44 = var44 - var45;
                     double var46 = 0.25D;
                     double var48 = (var37 - var35) * var46;
                     double var50 = var35 - var48;

                     for(int var52 = 0; var52 < 4; ++var52) {
                        if((var50 += var48) > 0.0D) {
                           var3[var44 += var45] = Blocks.stone;
                        } else if(var13 * 8 + var32 < var4) {
                           var3[var44 += var45] = Blocks.water;
                        } else {
                           var3[var44 += var45] = null;
                        }
                     }

                     var35 += var39;
                     var37 += var41;
                  }

                  var16 += var24;
                  var18 += var26;
                  var20 += var28;
                  var22 += var30;
               }
            }
         }
      }

   }

   public void replaceBlocksForBiome(int var1, int var2, Block[] var3, byte[] var4, BiomeGenBase[] var5) {
      ReplaceBiomeBlocks var6 = new ReplaceBiomeBlocks(this, var1, var2, var3, var4, var5);
      MinecraftForge.EVENT_BUS.post(var6);
      if(var6.getResult() != Result.DENY) {
         double var7 = 0.03125D;
         this.stoneNoise = this.noisePerl.func_151599_a(this.stoneNoise, (double)(var1 * 16), (double)(var2 * 16), 16, 16, var7 * 2.0D, var7 * 2.0D, 1.0D);

         for(int var9 = 0; var9 < 16; ++var9) {
            for(int var10 = 0; var10 < 16; ++var10) {
               BiomeGenBaseDBC var11 = (BiomeGenBaseDBC)var5[var10 + var9 * 16];
               this.genTerrainBlocks(var11, this.worldObj, this.rand, var3, var4, var1 * 16 + var9, var2 * 16 + var10, this.stoneNoise[var10 + var9 * 16]);
            }
         }

      }
   }

   public void genTerrainBlocks(BiomeGenBaseDBC var1, World var2, Random var3, Block[] var4, byte[] var5, int var6, int var7, double var8) {
      this.genBiomeModdedTerrain(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void genBiomeModdedTerrain(BiomeGenBaseDBC var1, World var2, Random var3, Block[] var4, byte[] var5, int var6, int var7, double var8) {
      Block var10 = var1.topBlock;
      byte var11 = (byte)(var1.field_150604_aj & 255);
      Block var12 = var1.fillerBlock;
      int var13 = -1;
      int var14 = (int)(var8 / 3.0D + 3.0D + var3.nextDouble() * 0.25D);
      int var15 = var6 & 15;
      int var16 = var7 & 15;
      int var17 = var4.length / 256;

      for(int var18 = 255; var18 >= 0; --var18) {
         int var19 = (var16 * 16 + var15) * var17 + var18;
         if(var18 <= 0 + var3.nextInt(5)) {
            var4[var19] = Blocks.bedrock;
         } else {
            Block var20 = var4[var19];
            if(var20 != null && var20.getMaterial() != Material.air) {
               if(var20 == Blocks.stone) {
                  if(var13 == -1) {
                     if(var14 <= 0) {
                        var10 = null;
                        var11 = 0;
                        var12 = Blocks.stone;
                     } else if(var18 >= 59 && var18 <= 64) {
                        var10 = var1.topBlock;
                        var11 = (byte)(var1.field_150604_aj & 255);
                        var12 = var1.fillerBlock;
                     }

                     if(var18 < 63 && (var10 == null || var10.getMaterial() == Material.air)) {
                        if(var1.getFloatTemperature(var6, var18, var7) < 0.15F) {
                           var10 = Blocks.ice;
                           var11 = 0;
                        } else {
                           var10 = Blocks.water;
                           var11 = 0;
                        }
                     }

                     var13 = var14;
                     if(var18 >= 62) {
                        var4[var19] = var10;
                        var5[var19] = var11;
                     } else if(var18 < 56 - var14) {
                        var10 = null;
                        var12 = Blocks.stone;
                        var4[var19] = Blocks.gravel;
                     } else {
                        var4[var19] = var12;
                     }
                  } else if(var13 > 0) {
                     --var13;
                     var4[var19] = var12;
                     if(var13 == 0 && var12 == Blocks.sand) {
                        var13 = var3.nextInt(4) + Math.max(0, var18 - 63);
                        var12 = Blocks.sandstone;
                     }
                  }
               }
            } else {
               var13 = -1;
            }
         }
      }

   }

   public Chunk loadChunk(int var1, int var2) {
      return this.provideChunk(var1, var2);
   }

   public Chunk provideChunk(int var1, int var2) {
      this.rand.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
      Block[] var3 = new Block[65536];
      byte[] var4 = new byte[65536];
      this.func_147424_a(var1, var2, var3);
      this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, var1 * 16, var2 * 16, 16, 16);
      this.replaceBlocksForBiome(var1, var2, var3, var4, this.biomesForGeneration);
      this.caveGenerator.func_151539_a(this, this.worldObj, var1, var2, var3);
      this.ravineGenerator.func_151539_a(this, this.worldObj, var1, var2, var3);
      if(this.mapFeaturesEnabled) {
         this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, var1, var2, var3);
      }

      Chunk var5 = new Chunk(this.worldObj, var3, var4, var1, var2);
      byte[] var6 = var5.getBiomeArray();

      for(int var7 = 0; var7 < var6.length; ++var7) {
         var6[var7] = (byte)this.biomesForGeneration[var7].biomeID;
      }

      var5.generateSkylightMap();
      return var5;
   }

   private void func_147423_a(int var1, int var2, int var3) {
      this.noise5 = this.noiseGen6.generateNoiseOctaves(this.noise5, var1, var3, 5, 5, 200.0D, 200.0D, 0.5D);
      this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, var1, var2, var3, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
      this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, var1, var2, var3, 5, 33, 5, 684.412D, 684.412D, 684.412D);
      this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, var1, var2, var3, 5, 33, 5, 684.412D, 684.412D, 684.412D);
      int var4 = 0;
      int var5 = 0;

      for(int var6 = 0; var6 < 5; ++var6) {
         for(int var7 = 0; var7 < 5; ++var7) {
            float var8 = 0.0F;
            float var9 = 0.0F;
            float var10 = 0.0F;
            byte var11 = 2;
            BiomeGenBase var12 = this.biomesForGeneration[var6 + 2 + (var7 + 2) * 10];

            for(int var13 = -var11; var13 <= var11; ++var13) {
               for(int var14 = -var11; var14 <= var11; ++var14) {
                  BiomeGenBase var15 = this.biomesForGeneration[var6 + var13 + 2 + (var7 + var14 + 2) * 10];
                  float var16 = var15.rootHeight;
                  float var17 = var15.heightVariation;
                  if(this.worldType == WorldType.AMPLIFIED && var16 > 0.0F) {
                     var16 = 1.0F + var16 * 2.0F;
                     var17 = 1.0F + var17 * 4.0F;
                  }

                  float var18 = this.parabolicField[var13 + 2 + (var14 + 2) * 5] / (var16 + 2.0F);
                  if(var15.rootHeight > var12.rootHeight) {
                     var18 /= 2.0F;
                  }

                  var8 += var17 * var18;
                  var9 += var16 * var18;
                  var10 += var18;
               }
            }

            var8 = var8 / var10;
            var9 = var9 / var10;
            var8 = var8 * 0.9F + 0.1F;
            var9 = (var9 * 4.0F - 1.0F) / 8.0F;
            double var38 = this.noise5[var5] / 8000.0D;
            if(var38 < 0.0D) {
               var38 = -var38 * 0.3D;
            }

            var38 = var38 * 3.0D - 2.0D;
            if(var38 < 0.0D) {
               var38 = var38 / 2.0D;
               if(var38 < -1.0D) {
                  var38 = -1.0D;
               }

               var38 = var38 / 1.4D;
               var38 = var38 / 2.0D;
            } else {
               if(var38 > 1.0D) {
                  var38 = 1.0D;
               }

               var38 = var38 / 8.0D;
            }

            ++var5;
            double var43 = (double)var9;
            double var46 = (double)var8;
            var43 = var43 + var38 * 0.2D;
            var43 = var43 * 8.5D / 8.0D;
            double var19 = 8.5D + var43 * 4.0D;

            for(int var21 = 0; var21 < 33; ++var21) {
               double var22 = ((double)var21 - var19) * 12.0D * 128.0D / 256.0D / var46;
               if(var22 < 0.0D) {
                  var22 *= 4.0D;
               }

               double var24 = this.noise1[var4] / 512.0D;
               double var26 = this.noise2[var4] / 512.0D;
               double var28 = (this.noise3[var4] / 10.0D + 1.0D) / 2.0D;
               double var30 = MathHelper.denormalizeClamp(var24, var26, var28) - var22;
               if(var21 > 29) {
                  double var32 = (double)((float)(var21 - 29) / 3.0F);
                  var30 = var30 * (1.0D - var32) + -10.0D * var32;
               }

               this.noiseArray[var4] = var30;
               ++var4;
            }
         }
      }

   }

   public boolean chunkExists(int var1, int var2) {
      return true;
   }

   public void populate(IChunkProvider var1, int var2, int var3) {
      BlockFalling.fallInstantly = true;
      int var4 = var2 * 16;
      int var5 = var3 * 16;
      BiomeGenBase var6 = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
      this.rand.setSeed(this.worldObj.getSeed());
      long var7 = this.rand.nextLong() / 2L * 2L + 1L;
      long var9 = this.rand.nextLong() / 2L * 2L + 1L;
      this.rand.setSeed((long)var2 * var7 + (long)var3 * var9 ^ this.worldObj.getSeed());
      boolean var11 = false;
      MinecraftForge.EVENT_BUS.post(new Pre(var1, this.worldObj, this.rand, var2, var3, var11));
      if(this.mapFeaturesEnabled) {
         this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, var2, var3);
      }

      if(var6 != BiomeGenBase.desert && var6 != BiomeGenBase.desertHills && !var11 && this.rand.nextInt(4) == 0 && TerrainGen.populate(var1, this.worldObj, this.rand, var2, var3, var11, EventType.LAKE)) {
         int var12 = var4 + this.rand.nextInt(16) + 8;
         int var13 = this.rand.nextInt(256);
         int var14 = var5 + this.rand.nextInt(16) + 8;
         (new WorldGenLakes(Blocks.water)).generate(this.worldObj, this.rand, var12, var13, var14);
      }

      if(TerrainGen.populate(var1, this.worldObj, this.rand, var2, var3, var11, EventType.LAVA) && !var11 && this.rand.nextInt(8) == 0) {
         int var19 = var4 + this.rand.nextInt(16) + 8;
         int var22 = this.rand.nextInt(this.rand.nextInt(248) + 8);
         int var25 = var5 + this.rand.nextInt(16) + 8;
         if(var22 < 63 || this.rand.nextInt(10) == 0) {
            (new WorldGenLakes(Blocks.lava)).generate(this.worldObj, this.rand, var19, var22, var25);
         }
      }

      boolean var15 = TerrainGen.populate(var1, this.worldObj, this.rand, var2, var3, var11, EventType.DUNGEON);

      for(int var20 = 0; var15 && var20 < 8; ++var20) {
         int var23 = var4 + this.rand.nextInt(16) + 8;
         int var26 = this.rand.nextInt(256);
         int var16 = var5 + this.rand.nextInt(16) + 8;
         (new WorldGenDungeons()).generate(this.worldObj, this.rand, var23, var26, var16);
      }

      var6.decorate(this.worldObj, this.rand, var4, var5);
      if(TerrainGen.populate(var1, this.worldObj, this.rand, var2, var3, var11, EventType.ANIMALS)) {
         SpawnerAnimals.performWorldGenSpawning(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.rand);
      }

      var4 = var4 + 8;
      var5 = var5 + 8;
      var15 = TerrainGen.populate(var1, this.worldObj, this.rand, var2, var3, var11, EventType.ICE);

      for(int var21 = 0; var15 && var21 < 16; ++var21) {
         for(int var24 = 0; var24 < 16; ++var24) {
            int var27 = this.worldObj.getPrecipitationHeight(var4 + var21, var5 + var24);
            if(this.worldObj.isBlockFreezable(var21 + var4, var27 - 1, var24 + var5)) {
               this.worldObj.setBlock(var21 + var4, var27 - 1, var24 + var5, Blocks.ice, 0, 2);
            }

            if(this.worldObj.func_147478_e(var21 + var4, var27, var24 + var5, true)) {
               this.worldObj.setBlock(var21 + var4, var27, var24 + var5, Blocks.snow_layer, 0, 2);
            }
         }
      }

      MinecraftForge.EVENT_BUS.post(new Post(var1, this.worldObj, this.rand, var2, var3, var11));
      BlockFalling.fallInstantly = false;
   }

   public boolean saveChunks(boolean var1, IProgressUpdate var2) {
      return true;
   }

   public void saveExtraData() {
   }

   public boolean unloadQueuedChunks() {
      return false;
   }

   public boolean canSave() {
      return true;
   }

   public String makeString() {
      return "RandomLevelSource";
   }

   public List getPossibleCreatures(EnumCreatureType var1, int var2, int var3, int var4) {
      BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(var2, var4);
      return var1 == EnumCreatureType.monster && this.scatteredFeatureGenerator.func_143030_a(var2, var3, var4)?this.scatteredFeatureGenerator.getScatteredFeatureSpawnList():var5.getSpawnableList(var1);
   }

   public int getLoadedChunkCount() {
      return 0;
   }

   public void recreateStructures(int var1, int var2) {
      if(this.mapFeaturesEnabled) {
         ;
      }

   }

   public ChunkPosition func_147416_a(World var1, String var2, int var3, int var4, int var5) {
      return null;
   }
}
