package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Villages.ChkInSt;
import JinRyuu.DragonBC.common.Villages.NamekianHouse1;
import JinRyuu.DragonBC.common.Worlds.WorldGenNamekMedMoss;
import JinRyuu.DragonBC.common.Worlds.WorldGenNamekTrees;
import JinRyuu.DragonBC.common.Worlds.WorldGenOre;
import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Post;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Pre;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType;

public class BiomeDecoratorDBC extends BiomeDecorator {
   protected int grassPerChunk;
   protected int treesPerChunk;
   protected int WarenaiOrePerChunk;
   protected int NamekMedMossPerChunk;
   protected int NamekTreePerChunk;
   protected int NamekianHouseChunk;
   protected int NamekFreezaSoldiersChunk;
   protected int ChkInStChunk;
   protected WorldGenerator NamekTreeGen = new WorldGenNamekTrees(true);
   protected WorldGenerator NamekMedMossGen = new WorldGenNamekMedMoss(false);
   protected WorldGenerator WarenaiOreGen = new WorldGenOre(BlocksDBC.BlockOreWrenai, 5, Blocks.stone);
   protected WorldGenerator NamekianHouse = new NamekianHouse1();
   protected WorldGenerator ChkInSt = new ChkInSt();

   public BiomeDecoratorDBC() {
   }

   public void decorateChunk(World var1, Random var2, BiomeGenBase var3, int var4, int var5) {
      if(this.currentWorld != null) {
         throw new RuntimeException("Already decorating!!");
      } else {
         this.currentWorld = var1;
         this.randomGenerator = var2;
         this.chunk_X = var4;
         this.chunk_Z = var5;
         this.genDecorations(var3);
         this.currentWorld = null;
         this.randomGenerator = null;
      }
   }

   protected void genDecorations(BiomeGenBase var1) {
      MinecraftForge.EVENT_BUS.post(new Pre(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
      this.generateOres();

      for(int var2 = 0; var2 < this.NamekTreePerChunk; ++var2) {
         int var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
         int var4 = 65 + this.randomGenerator.nextInt(50);
         int var5 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
         this.NamekTreeGen.generate(this.currentWorld, this.randomGenerator, var3, var4, var5);
      }

      for(int var6 = 0; var6 < this.NamekMedMossPerChunk; ++var6) {
         int var9 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
         int var12 = 65 + this.randomGenerator.nextInt(50);
         int var15 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
         this.NamekMedMossGen.generate(this.currentWorld, this.randomGenerator, var9, var12, var15);
      }

      for(int var7 = 0; var7 < this.WarenaiOrePerChunk; ++var7) {
         int var10 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
         int var13 = 32 + this.randomGenerator.nextInt(128);
         int var16 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
         this.WarenaiOreGen.generate(this.currentWorld, this.randomGenerator, var10, var13, var16);
      }

      for(int var8 = 0; var8 < this.NamekianHouseChunk; ++var8) {
         int var11 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
         int var14 = 65 + this.randomGenerator.nextInt(20);
         int var17 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
         this.NamekianHouse.generate(this.currentWorld, this.randomGenerator, var11, var14, var17);
      }

      MinecraftForge.EVENT_BUS.post(new Post(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
   }

   protected void generateOres() {
      MinecraftForge.ORE_GEN_BUS.post(new net.minecraftforge.event.terraingen.OreGenEvent.Pre(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
      if(TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.dirtGen, this.chunk_X, this.chunk_Z, EventType.DIRT)) {
         this.genStandardOre1(20, this.dirtGen, 0, 256);
      }

      if(TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.ironGen, this.chunk_X, this.chunk_Z, EventType.IRON)) {
         this.genStandardOre1(20, this.ironGen, 0, 64);
      }

      if(TerrainGen.generateOre(this.currentWorld, this.randomGenerator, this.goldGen, this.chunk_X, this.chunk_Z, EventType.GOLD)) {
         this.genStandardOre1(2, this.goldGen, 0, 32);
      }

      MinecraftForge.ORE_GEN_BUS.post(new net.minecraftforge.event.terraingen.OreGenEvent.Post(this.currentWorld, this.randomGenerator, this.chunk_X, this.chunk_Z));
   }
}
