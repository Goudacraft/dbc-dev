package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Worlds.BiomeDecoratorDBC;
import JinRyuu.DragonBC.common.Worlds.BiomeGenStony;
import JinRyuu.DragonBC.common.Worlds.x0BiomeGenNamek;
import JinRyuu.DragonBC.common.Worlds.x1BiomeGenOW;
import JinRyuu.DragonBC.common.Worlds.x2BiomeGenTC;
import JinRyuu.DragonBC.common.Worlds.x3BiomeGenVegata;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public abstract class BiomeGenBaseDBC extends BiomeGenBase {
   public static BiomeGenBase Namek = new x0BiomeGenNamek(100);
   public static BiomeGenBase Vegeta = new x3BiomeGenVegata(103);
   public static BiomeGenBase Stony = new BiomeGenStony(104);
   public static BiomeGenBase OtherW = new x1BiomeGenOW(105);
   public static BiomeGenBase TC = new x2BiomeGenTC(106);

   public BiomeGenBaseDBC(int var1) {
      super(var1);
      this.theBiomeDecorator = new BiomeDecoratorDBC();
   }

   public WorldGenerator getRandomWorldGenForGrass(Random var1) {
      return var1.nextInt(4) == 0?new WorldGenTallGrass(Blocks.tallgrass, 2):new WorldGenTallGrass(Blocks.tallgrass, 1);
   }

   public static void init() {
      BiomeDictionary.registerBiomeType(Namek, new Type[]{Type.PLAINS});
      BiomeDictionary.registerBiomeType(Vegeta, new Type[]{Type.PLAINS});
      BiomeDictionary.registerBiomeType(Stony, new Type[]{Type.HOT, Type.DRY});
      BiomeDictionary.registerBiomeType(OtherW, new Type[]{Type.DEAD});
      BiomeDictionary.registerBiomeType(TC, new Type[]{Type.HOT, Type.DRY});
      BiomeDictionary.registerAllBiomes();
      BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(Stony, 10));
   }
}
