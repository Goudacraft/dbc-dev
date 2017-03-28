package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDino01;
import JinRyuu.DragonBC.common.Worlds.BiomeDecoratorDBC;
import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;

public class BiomeGenStony extends BiomeGenBase {
   BiomeDecoratorDBC customBiomeDecorator;
   public static final BiomeGenBase Stony = BiomeGenBaseDBC.Stony;

   public BiomeGenStony(int var1) {
      super(var1);
      this.setBiomeName("Dirty Stony");
      this.topBlock = BlocksDBC.BlockNamekDirt;
      this.fillerBlock = BlocksDBC.BlockAlienStone;
      this.theBiomeDecorator = new BiomeDecoratorDBC();
      this.customBiomeDecorator = (BiomeDecoratorDBC)this.theBiomeDecorator;
      this.customBiomeDecorator.NamekTreePerChunk = 0;
      this.customBiomeDecorator.WarenaiOrePerChunk = 0;
      this.customBiomeDecorator.NamekianHouseChunk = 0;
      this.customBiomeDecorator.NamekFreezaSoldiersChunk = 0;
      this.setMinMaxHeight(0.4F, 1.5F);
      this.setTemperatureRainfall(0.8F, 0.9F);
      this.temperature = 0.5F;
      this.spawnableCreatureList.clear();
      this.spawnableWaterCreatureList.clear();
      this.spawnableMonsterList.add(new SpawnListEntry(EntityDino01.class, 10, 1, 1));
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

   public int getBiomeFoliageColor() {
      double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature2(), 0.0F, 1.0F);
      double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
      return ColorizerFoliage.getFoliageColor(var1, var3);
   }
}
