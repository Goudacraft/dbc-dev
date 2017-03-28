package JinRyuu.DragonBC.common.Worlds;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.MapGenBase;

public class x1MapGenCavesOW extends MapGenBase {
   private static final String __OBFID = "CL_00000393";

   public x1MapGenCavesOW() {
   }

   protected void func_151542_a(long var1, int var3, int var4, Block[] var5, double var6, double var8, double var10) {
      this.func_151541_a(var1, var3, var4, var5, var6, var8, var10, 1.0F + this.rand.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
   }

   protected void func_151541_a(long var1, int var3, int var4, Block[] var5, double var6, double var8, double var10, float var12, float var13, float var14, int var15, int var16, double var17) {
      double var19 = (double)(var3 * 16 + 8);
      double var21 = (double)(var4 * 16 + 8);
      float var23 = 0.0F;
      float var24 = 0.0F;
      Random var25 = new Random(var1);
      if(var16 <= 0) {
         int var26 = this.range * 16 - 16;
         var16 = var26 - var25.nextInt(var26 / 4);
      }

      boolean var65 = false;
      if(var15 == -1) {
         var15 = var16 / 2;
         var65 = true;
      }

      int var27 = var25.nextInt(var16 / 2) + var16 / 4;

      for(boolean var28 = var25.nextInt(6) == 0; var15 < var16; ++var15) {
         double var29 = 1.5D + (double)(MathHelper.sin((float)var15 * 3.1415927F / (float)var16) * var12 * 1.0F);
         double var31 = var29 * var17;
         float var33 = MathHelper.cos(var14);
         float var34 = MathHelper.sin(var14);
         var6 += (double)(MathHelper.cos(var13) * var33);
         var8 += (double)var34;
         var10 += (double)(MathHelper.sin(var13) * var33);
         if(var28) {
            var14 = var14 * 0.92F;
         } else {
            var14 = var14 * 0.7F;
         }

         var14 = var14 + var24 * 0.1F;
         var13 += var23 * 0.1F;
         var24 = var24 * 0.9F;
         var23 = var23 * 0.75F;
         var24 = var24 + (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 2.0F;
         var23 = var23 + (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 4.0F;
         if(!var65 && var15 == var27 && var12 > 1.0F && var16 > 0) {
            this.func_151541_a(var25.nextLong(), var3, var4, var5, var6, var8, var10, var25.nextFloat() * 0.5F + 0.5F, var13 - 1.5707964F, var14 / 3.0F, var15, var16, 1.0D);
            this.func_151541_a(var25.nextLong(), var3, var4, var5, var6, var8, var10, var25.nextFloat() * 0.5F + 0.5F, var13 + 1.5707964F, var14 / 3.0F, var15, var16, 1.0D);
            return;
         }

         if(var65 || var25.nextInt(4) != 0) {
            double var35 = var6 - var19;
            double var37 = var10 - var21;
            double var39 = (double)(var16 - var15);
            double var41 = (double)(var12 + 2.0F + 16.0F);
            if(var35 * var35 + var37 * var37 - var39 * var39 > var41 * var41) {
               return;
            }

            if(var6 >= var19 - 16.0D - var29 * 2.0D && var10 >= var21 - 16.0D - var29 * 2.0D && var6 <= var19 + 16.0D + var29 * 2.0D && var10 <= var21 + 16.0D + var29 * 2.0D) {
               int var43 = MathHelper.floor_double(var6 - var29) - var3 * 16 - 1;
               int var44 = MathHelper.floor_double(var6 + var29) - var3 * 16 + 1;
               int var45 = MathHelper.floor_double(var8 - var31) - 1;
               int var46 = MathHelper.floor_double(var8 + var31) + 1;
               int var47 = MathHelper.floor_double(var10 - var29) - var4 * 16 - 1;
               int var48 = MathHelper.floor_double(var10 + var29) - var4 * 16 + 1;
               if(var43 < 0) {
                  var43 = 0;
               }

               if(var44 > 16) {
                  var44 = 16;
               }

               if(var45 < 1) {
                  var45 = 1;
               }

               if(var46 > 248) {
                  var46 = 248;
               }

               if(var47 < 0) {
                  var47 = 0;
               }

               if(var48 > 16) {
                  var48 = 16;
               }

               boolean var49 = false;

               for(int var50 = var43; !var49 && var50 < var44; ++var50) {
                  for(int var52 = var47; !var49 && var52 < var48; ++var52) {
                     for(int var53 = var46 + 1; !var49 && var53 >= var45 - 1; --var53) {
                        int var51 = (var50 * 16 + var52) * 256 + var53;
                        if(var53 >= 0 && var53 < 256) {
                           Block var10000 = var5[var51];
                           if(this.isOceanBlock(var5, var51, var50, var53, var52, var3, var4)) {
                              var49 = true;
                           }

                           if(var53 != var45 - 1 && var50 != var43 && var50 != var44 - 1 && var52 != var47 && var52 != var48 - 1) {
                              var53 = var45;
                           }
                        }
                     }
                  }
               }

               if(!var49) {
                  for(int var66 = var43; var66 < var44; ++var66) {
                     double var68 = ((double)(var66 + var3 * 16) + 0.5D - var6) / var29;

                     for(int var67 = var47; var67 < var48; ++var67) {
                        double var54 = ((double)(var67 + var4 * 16) + 0.5D - var10) / var29;
                        int var56 = (var66 * 16 + var67) * 256 + var46;
                        boolean var57 = false;
                        if(var68 * var68 + var54 * var54 < 1.0D) {
                           for(int var58 = var46 - 1; var58 >= var45; --var58) {
                              double var59 = ((double)var58 + 0.5D - var8) / var31;
                              if(var59 > -0.7D && var68 * var68 + var59 * var59 + var54 * var54 < 1.0D) {
                                 Block var69 = var5[var56];
                                 if(this.isTopBlock(var5, var56, var66, var58, var67, var3, var4)) {
                                    var57 = true;
                                 }

                                 this.digBlock(var5, var56, var66, var58, var67, var3, var4, var57);
                              }

                              --var56;
                           }
                        }
                     }
                  }

                  if(var65) {
                     break;
                  }
               }
            }
         }
      }

   }

   protected void func_151538_a(World var1, int var2, int var3, int var4, int var5, Block[] var6) {
      int var7 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(15) + 1) + 1);
      if(this.rand.nextInt(7) != 0) {
         var7 = 0;
      }

      for(int var8 = 0; var8 < var7; ++var8) {
         double var9 = (double)(var2 * 16 + this.rand.nextInt(16));
         double var11 = (double)this.rand.nextInt(this.rand.nextInt(120) + 8);
         double var13 = (double)(var3 * 16 + this.rand.nextInt(16));
         int var15 = 1;
         if(this.rand.nextInt(4) == 0) {
            this.func_151542_a(this.rand.nextLong(), var4, var5, var6, var9, var11, var13);
            var15 += this.rand.nextInt(4);
         }

         for(int var16 = 0; var16 < var15; ++var16) {
            float var17 = this.rand.nextFloat() * 3.1415927F * 2.0F;
            float var18 = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float var19 = this.rand.nextFloat() * 2.0F + this.rand.nextFloat();
            if(this.rand.nextInt(10) == 0) {
               var19 *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0F + 1.0F;
            }

            this.func_151541_a(this.rand.nextLong(), var4, var5, var6, var9, var11, var13, var19, var17, var18, 0, 0, 1.0D);
         }
      }

   }

   protected boolean isOceanBlock(Block[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return var1[var2] == Blocks.flowing_water || var1[var2] == Blocks.water;
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
            var1[var2] = Blocks.lava;
         } else {
            var1[var2] = null;
            if(var8 && var1[var2 - 1] == var11) {
               var1[var2 - 1] = (Block)var10;
            }
         }
      }

   }
}
