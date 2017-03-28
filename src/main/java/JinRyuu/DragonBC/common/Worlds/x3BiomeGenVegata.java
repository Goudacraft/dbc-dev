package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan01;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan02;
import JinRyuu.DragonBC.common.Worlds.BiomeDecoratorDBC;
import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
import java.awt.Color;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;

public class x3BiomeGenVegata extends BiomeGenBaseDBC {
   BiomeDecoratorDBC customBiomeDecorator;
   final float HUE = Color.RGBtoHSB(255, 102, 102, (float[])null)[0];

   public x3BiomeGenVegata(int var1) {
      super(var1);
      this.setBiomeName("Vegeta");
      this.topBlock = BlocksDBC.BlockNamekDirt;
      this.fillerBlock = BlocksDBC.BlockAlienStone;
      this.theBiomeDecorator = new BiomeDecoratorDBC();
      this.customBiomeDecorator = (BiomeDecoratorDBC)this.theBiomeDecorator;
      this.setColor(8368696);
      this.setMinMaxHeight(0.0F, 0.7F);
      this.setTemperatureRainfall(0.8F, 0.9F);
      this.temperature = 0.5F;
      this.waterColorMultiplier = 16711680;
      this.spawnableMonsterList.clear();
      this.spawnableCreatureList.clear();
      this.spawnableWaterCreatureList.clear();
      this.spawnableMonsterList.add(new SpawnListEntry(EntitySaiyan01.class, 2, 1, 3));
      this.spawnableMonsterList.add(new SpawnListEntry(EntitySaiyan02.class, 4, 1, 3));
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
