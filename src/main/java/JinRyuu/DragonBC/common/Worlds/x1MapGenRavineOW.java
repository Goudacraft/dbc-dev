package JinRyuu.DragonBC.common.Worlds;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.MapGenBase;

public class x1MapGenRavineOW extends MapGenBase {
   private float[] field_75046_d = new float[1024];
   private static final String __OBFID = "CL_00000390";

   public x1MapGenRavineOW() {
   }

   protected void func_151540_a(long var1, int var3, int var4, Block[] var5, double var6, double var8, double var10, float var12, float var13, float var14, int var15, int var16, double var17) {
      Random var19 = new Random(var1);
      double var20 = (double)(var3 * 16 + 8);
      double var22 = (double)(var4 * 16 + 8);
      float var24 = 0.0F;
      float var25 = 0.0F;
      if(var16 <= 0) {
         int var26 = this.range * 16 - 16;
         var16 = var26 - var19.nextInt(var26 / 4);
      }

      boolean var64 = false;
      if(var15 == -1) {
         var15 = var16 / 2;
         var64 = true;
      }

      float var27 = 1.0F;

      for(int var28 = 0; var28 < 256; ++var28) {
         if(var28 == 0 || var19.nextInt(3) == 0) {
            var27 = 1.0F + var19.nextFloat() * var19.nextFloat() * 1.0F;
         }

         this.field_75046_d[var28] = var27 * var27;
      }

      for(; var15 < var16; ++var15) {
         double var65 = 1.5D + (double)(MathHelper.sin((float)var15 * 3.1415927F / (float)var16) * var12 * 1.0F);
         double var30 = var65 * var17;
         var65 = var65 * ((double)var19.nextFloat() * 0.25D + 0.75D);
         var30 = var30 * ((double)var19.nextFloat() * 0.25D + 0.75D);
         float var32 = MathHelper.cos(var14);
         float var33 = MathHelper.sin(var14);
         var6 += (double)(MathHelper.cos(var13) * var32);
         var8 += (double)var33;
         var10 += (double)(MathHelper.sin(var13) * var32);
         var14 = var14 * 0.7F;
         var14 = var14 + var25 * 0.05F;
         var13 += var24 * 0.05F;
         var25 = var25 * 0.8F;
         var24 = var24 * 0.5F;
         var25 = var25 + (var19.nextFloat() - var19.nextFloat()) * var19.nextFloat() * 2.0F;
         var24 = var24 + (var19.nextFloat() - var19.nextFloat()) * var19.nextFloat() * 4.0F;
         if(var64 || var19.nextInt(4) != 0) {
            double var34 = var6 - var20;
            double var36 = var10 - var22;
            double var38 = (double)(var16 - var15);
            double var40 = (double)(var12 + 2.0F + 16.0F);
            if(var34 * var34 + var36 * var36 - var38 * var38 > var40 * var40) {
               return;
            }

            if(var6 >= var20 - 16.0D - var65 * 2.0D && var10 >= var22 - 16.0D - var65 * 2.0D && var6 <= var20 + 16.0D + var65 * 2.0D && var10 <= var22 + 16.0D + var65 * 2.0D) {
               int var42 = MathHelper.floor_double(var6 - var65) - var3 * 16 - 1;
               int var43 = MathHelper.floor_double(var6 + var65) - var3 * 16 + 1;
               int var44 = MathHelper.floor_double(var8 - var30) - 1;
               int var45 = MathHelper.floor_double(var8 + var30) + 1;
               int var46 = MathHelper.floor_double(var10 - var65) - var4 * 16 - 1;
               int var47 = MathHelper.floor_double(var10 + var65) - var4 * 16 + 1;
               if(var42 < 0) {
                  var42 = 0;
               }

               if(var43 > 16) {
                  var43 = 16;
               }

               if(var44 < 1) {
                  var44 = 1;
               }

               if(var45 > 248) {
                  var45 = 248;
               }

               if(var46 < 0) {
                  var46 = 0;
               }

               if(var47 > 16) {
                  var47 = 16;
               }

               boolean var48 = false;

               for(int var49 = var42; !var48 && var49 < var43; ++var49) {
                  for(int var51 = var46; !var48 && var51 < var47; ++var51) {
                     for(int var52 = var45 + 1; !var48 && var52 >= var44 - 1; --var52) {
                        int var50 = (var49 * 16 + var51) * 256 + var52;
                        if(var52 >= 0 && var52 < 256) {
                           Block var10000 = var5[var50];
                           if(this.isOceanBlock(var5, var50, var49, var52, var51, var3, var4)) {
                              var48 = true;
                           }

                           if(var52 != var44 - 1 && var49 != var42 && var49 != var43 - 1 && var51 != var46 && var51 != var47 - 1) {
                              var52 = var44;
                           }
                        }
                     }
                  }
               }

               if(!var48) {
                  for(int var68 = var42; var68 < var43; ++var68) {
                     double var70 = ((double)(var68 + var3 * 16) + 0.5D - var6) / var65;

                     for(int var69 = var46; var69 < var47; ++var69) {
                        double var53 = ((double)(var69 + var4 * 16) + 0.5D - var10) / var65;
                        int var55 = (var68 * 16 + var69) * 256 + var45;
                        boolean var56 = false;
                        if(var70 * var70 + var53 * var53 < 1.0D) {
                           for(int var57 = var45 - 1; var57 >= var44; --var57) {
                              double var58 = ((double)var57 + 0.5D - var8) / var30;
                              if((var70 * var70 + var53 * var53) * (double)this.field_75046_d[var57] + var58 * var58 / 6.0D < 1.0D) {
                                 Block var71 = var5[var55];
                                 if(this.isTopBlock(var5, var55, var68, var57, var69, var3, var4)) {
                                    var56 = true;
                                 }

                                 this.digBlock(var5, var55, var68, var57, var69, var3, var4, var56);
                              }

                              --var55;
                           }
                        }
                     }
                  }

                  if(var64) {
                     break;
                  }
               }
            }
         }
      }

   }

   protected void func_151538_a(World var1, int var2, int var3, int var4, int var5, Block[] var6) {
      if(this.rand.nextInt(50) == 0) {
         double var7 = (double)(var2 * 16 + this.rand.nextInt(16));
         double var9 = (double)(this.rand.nextInt(this.rand.nextInt(40) + 8) + 20);
         double var11 = (double)(var3 * 16 + this.rand.nextInt(16));
         byte var13 = 1;

         for(int var14 = 0; var14 < var13; ++var14) {
            float var15 = this.rand.nextFloat() * 3.1415927F * 2.0F;
            float var16 = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float var17 = (this.rand.nextFloat() * 2.0F + this.rand.nextFloat()) * 2.0F;
            this.func_151540_a(this.rand.nextLong(), var4, var5, var6, var7, var9, var11, var17, var15, var16, 0, 0, 3.0D);
         }
      }

   }

   protected boolean isOceanBlock(Block[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return var1[var2] == Blocks.water || var1[var2] == Blocks.flowing_water;
   }

   private boolean isExceptionBiome(BiomeGenBase var1) {
      return var1 == BiomeGenBase.mushroomIsland?true:(var1 == BiomeGenBase.beach?true:var1 == BiomeGenBase.desert);
   }

   private boolean isTopBlock(Block[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      BiomeGenBase var8 = this.worldObj.getBiomeGenForCoords(var3 + var6 * 16, var5 + var7 * 16);
      return this.isExceptionBiome(var8)?var1[var2] == Blocks.grass:var1[var2] == var8.topBlock;
   }

   protected void digBlock(Block[] var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
      BiomeGenBase var9 = this.worldObj.getBiomeGenForCoords(var3 + var6 * 16, var5 + var7 * 16);
      Object var10 = this.isExceptionBiome(var9)?Blocks.grass:var9.topBlock;
      Block var11 = this.isExceptionBiome(var9)?Blocks.dirt:var9.fillerBlock;
      Block var12 = var1[var2];
      if(var12 == Blocks.stone || var12 == Blocks.dirt || var12 == var11 || var12 == var10) {
         if(var4 < 10) {
            var1[var2] = Blocks.flowing_lava;
         } else {
            var1[var2] = null;
            if(var8 && var1[var2 - 1] == var11) {
               var1[var2 - 1] = (Block)var10;
            }
         }
      }

   }
}
