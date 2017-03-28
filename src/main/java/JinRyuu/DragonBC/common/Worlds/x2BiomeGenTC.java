package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Worlds.BiomeDecoratorDBC;
import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
import java.awt.Color;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.biome.BiomeGenBase;

public class x2BiomeGenTC extends BiomeGenBaseDBC {
   BiomeDecoratorDBC customBiomeDecorator;
   final float HUE = Color.RGBtoHSB(255, 255, 255, (float[])null)[0];

   public x2BiomeGenTC(int var1) {
      super(var1);
      this.setBiomeName("Time Chamber");
      this.topBlock = Blocks.air;
      this.fillerBlock = Blocks.air;
      this.setDisableRain();
      this.setColor(16777215);
      this.setMinMaxHeight(0.0F, 0.0F);
      this.setTemperatureRainfall(0.8F, 0.9F);
      this.temperature = 0.5F;
      this.waterColorMultiplier = 16777215;
      this.spawnableMonsterList.clear();
      this.spawnableCreatureList.clear();
      this.spawnableWaterCreatureList.clear();
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

   public int getSkyColorByTemp(float var1) {
      var1 = var1 / 3.0F;
      if(var1 < -1.0F) {
         var1 = -1.0F;
      }

      if(var1 > 1.0F) {
         var1 = 1.0F;
      }

      return Color.WHITE.getRGB();
   }

   public int getBiomeFoliageColor() {
      double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature2(), 0.0F, 1.0F);
      double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
      return ColorizerFoliage.getFoliageColor(var1, var3);
   }
}
