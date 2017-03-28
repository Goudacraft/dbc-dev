package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Npcs.EntityHell01;
import JinRyuu.DragonBC.common.Npcs.EntityHell02;
import JinRyuu.DragonBC.common.Worlds.BiomeDecoratorDBC;
import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
import java.awt.Color;
import java.util.Random;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;

public class x1BiomeGenOW extends BiomeGenBaseDBC {
   BiomeDecoratorDBC customBiomeDecorator;
   final float HUE = Color.RGBtoHSB(255, 102, 102, (float[])null)[0];

   public x1BiomeGenOW(int var1) {
      super(var1);
      this.setBiomeName("Other World");
      this.topBlock = BlocksDBC.BlockYellowCloud;
      this.fillerBlock = BlocksDBC.BlockYellowCloud;
      this.theBiomeDecorator = new BiomeDecoratorDBC();
      this.customBiomeDecorator = (BiomeDecoratorDBC)this.theBiomeDecorator;
      this.customBiomeDecorator.ChkInStChunk = 10;
      this.setDisableRain();
      this.setMinMaxHeight(0.1F, 0.2F);
      this.setColor(16421912);
      this.setDisableRain();
      this.setTemperatureRainfall(2.0F, 0.0F);
      this.temperature = 0.5F;
      this.waterColorMultiplier = 16711680;
      this.spawnableMonsterList.clear();
      this.spawnableCreatureList.clear();
      this.spawnableWaterCreatureList.clear();
      if(!DBCConfig.DsblO) {
         this.spawnableMonsterList.add(new SpawnListEntry(EntityHell01.class, 100, 1, 2));
         this.spawnableMonsterList.add(new SpawnListEntry(EntityHell02.class, 100, 1, 2));
      }

   }

   public void decorate(World var1, Random var2, int var3, int var4) {
      super.decorate(var1, var2, var3, var4);
   }

   public BiomeGenBase setTemperatureRainfall(float var1, float var2) {
      if(var1 > 0.1F && var1 < 0.2F) {
         throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
      } else {
         this.temperature = var1;
         this.rainfall = var2;
         return this;
      }
   }

   public BiomeGenBase setMinMaxHeight(float var1, float var2) {
      this.rootHeight = var1;
      this.heightVariation = var2;
      return this;
   }

   public final int getIntTemperature2() {
      return (int)(this.temperature * 65536.0F);
   }

   public final float getFloatTemperature2() {
      return this.temperature;
   }

   public BiomeGenBase setColor(int var1) {
      this.color = Color.getHSBColor(0.42F - (float)var1 * 0.05F, 0.5F + (float)var1 * 0.1F, 1.0F).getRGB();
      return this;
   }

   public int getSkyColorByTemp(float var1) {
      var1 = var1 / 3.0F;
      if(var1 < -1.0F) {
         var1 = -1.0F;
      }

      if(var1 > 1.0F) {
         var1 = 1.0F;
      }

      return Color.getHSBColor(this.HUE, 0.5F + var1 * 0.1F, 1.0F).getRGB();
   }

   public int getBiomeFoliageColor() {
      double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature2(), 0.0F, 1.0F);
      double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
      return ColorizerFoliage.getFoliageColor(var1, var3);
   }
}
