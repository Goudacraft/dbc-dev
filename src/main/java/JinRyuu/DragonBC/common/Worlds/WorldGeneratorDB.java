package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Npcs.EntityMasterEnma;
import JinRyuu.DragonBC.common.Npcs.EntityMasterKaio;
import JinRyuu.DragonBC.common.Npcs.EntityMasterKami;
import JinRyuu.DragonBC.common.Npcs.EntityMasterKarin;
import JinRyuu.DragonBC.common.Villages.ChkInSt;
import JinRyuu.DragonBC.common.Villages.KiLt;
import JinRyuu.DragonBC.common.Villages.KnTr;
import JinRyuu.DragonBC.common.Villages.SnkWy;
import JinRyuu.DragonBC.common.Villages.TiCha;
import JinRyuu.DragonBC.common.Villages.bs;
import JinRyuu.DragonBC.common.Villages.builds;
import JinRyuu.DragonBC.common.Villages.ca;
import JinRyuu.DragonBC.common.Villages.fs;
import JinRyuu.DragonBC.common.Villages.gh;
import JinRyuu.DragonBC.common.Villages.kh;
import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
import JinRyuu.DragonBC.common.Worlds.WorldGenOWTrees;
import JinRyuu.JRMCore.JRMCoreComTickH;
import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHDBC;
import JinRyuu.JRMCore.blocks.BlocksJRMC;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGeneratorDB implements IWorldGenerator {
   protected WorldGenerator ChkInSt;
   protected WorldGenerator KiLt;
   protected WorldGenerator SnkWy;
   protected WorldGenerator TiCha;
   protected WorldGenerator KnTr;
   public static boolean KiLtSpawn = true;
   public static boolean KiLtTCSpawn = true;
   public static boolean ChkInStSpawn = true;
   public static boolean SnkWySpawn = true;
   public static boolean TiChaSpawn = true;
   public static boolean TiChaKLSpawn = true;
   public static boolean KnTrSpawn = true;
   public static boolean FSSpawn = true;
   public static boolean KHSpawn = true;
   public static boolean CASpawn = true;
   public static boolean GHSpawn = true;
   public static boolean BSSpawn = true;
   public static builds[] DBbuilds = new builds[]{new ca(), new gh(), new fs(), new bs()};
   public static int[] DBbuildsdim = new int[]{0, 0, DBCConfig.planetNamek, 0};

   public WorldGeneratorDB() {
   }

   public void generate(Random var1, int var2, int var3, World var4, IChunkProvider var5, IChunkProvider var6) {
      switch(var4.provider.dimensionId) {
      case -1:
         this.generateNether(var4, var1, var2 * 16, var3 * 16);
         break;
      case 0:
         this.generateSurface(var4, var1, var2 * 16, var3 * 16);
         break;
      case 20:
         this.generateNamek(var4, var1, var2 * 16, var3 * 16);
         break;
      case 22:
         this.generateOW(var4, var1, var2 * 16, var3 * 16);
         break;
      case 23:
         this.generateTC(var4, var1, var2 * 16, var3 * 16);
      }

   }

   private void generateSurface(World var1, Random var2, int var3, int var4) {
      if(var1.provider.dimensionId == 0) {
         for(int var5 = 0; var5 < 10; ++var5) {
            int var6 = var3 + var2.nextInt(16);
            int var7 = var4 + var2.nextInt(16);
            int var8 = 10 + var2.nextInt(127);
            (new WorldGenMinable(BlocksDBC.BlockOreWrenai, 8)).generate(var1, var2, var6, var8, var7);
         }

         if(JRMCoreConfig.BuildingSpawnCheck && var1.getBlock(86, 216, 50) != BlocksJRMC.BlockColoredStone && KiLtSpawn) {
            KiLtSpawn = false;
            this.KiLt = new KiLt();
            this.KiLt.generate(var1, var1.rand, 0, 0, 0);
            var1.setBlock(43, 216, 37, BlocksJRMC.BlockColoredStone, 0, 3);
            var1.setBlock(77, 167, 42, BlocksJRMC.BlockColoredStone, 4, 3);
            var1.setBlock(78, 217, 32, BlocksJRMC.stoneSingleSlab);
            var1.setBlock(76, 217, 32, BlocksJRMC.stoneSingleSlab);
            var1.setBlock(78, 218, 32, Blocks.air, 0, 3);
            var1.setBlock(78, 219, 32, Blocks.air, 0, 3);
            var1.setBlock(78, 220, 32, Blocks.air, 0, 3);
            var1.setBlock(76, 218, 32, Blocks.air, 0, 3);
            var1.setBlock(76, 219, 32, Blocks.air, 0, 3);
            var1.setBlock(76, 220, 32, Blocks.air, 0, 3);
            var1.setBlock(79, 218, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            var1.setBlock(79, 219, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            var1.setBlock(79, 220, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            var1.setBlock(79, 221, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            var1.setBlock(75, 218, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            var1.setBlock(75, 219, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            var1.setBlock(75, 220, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            var1.setBlock(75, 221, 32, BlocksJRMC.BlockColoredStone, 4, 3);
            if(var1.getBlock(80, 134, 34) != BlocksJRMC.BlockFence && KnTrSpawn) {
               KnTrSpawn = false;
               this.KnTr = new KnTr();
               this.KnTr.generate(var1, var1.rand, 0, 0, 0);
               var1.setBlock(77, 133, 45, BlocksJRMC.BlockColoredStone, 0, 3);
               var1.setBlock(77, 134, 45, BlocksJRMC.BlockColoredStone, 0, 3);
            }

            if(var1.getBlock(77, 219, 8) != BlocksDBC.BlockTCPort && KiLtTCSpawn) {
               KiLtTCSpawn = false;
               var1.setBlock(77, 217, 8, BlocksDBC.BlockTCPort, 0, 3);
               var1.setBlock(77, 218, 8, BlocksDBC.BlockTCPort, 0, 3);
               var1.setBlock(77, 219, 8, BlocksDBC.BlockTCPort, 0, 3);
               var1.setBlock(76, 217, 8, BlocksDBC.BlockTCPort, 0, 3);
               var1.setBlock(76, 218, 8, BlocksDBC.BlockTCPort, 0, 3);
               var1.setBlock(78, 217, 8, BlocksDBC.BlockTCPort, 0, 3);
               var1.setBlock(78, 218, 8, BlocksDBC.BlockTCPort, 0, 3);
               var1.setBlock(78, 219, 8, BlocksDBC.BlockTCPort, 0, 3);
               var1.setBlock(76, 219, 8, BlocksDBC.BlockTCPort, 0, 3);
               var1.setBlock(76, 220, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               var1.setBlock(77, 220, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               var1.setBlock(78, 220, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               var1.setBlock(75, 220, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               var1.setBlock(75, 219, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               var1.setBlock(75, 218, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               var1.setBlock(75, 217, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               var1.setBlock(79, 220, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               var1.setBlock(79, 219, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               var1.setBlock(79, 218, 8, BlocksJRMC.BlockColoredStone, 0, 3);
               var1.setBlock(79, 217, 8, BlocksJRMC.BlockColoredStone, 0, 3);
            }
         }

         if(JRMCoreConfig.NPCSpawnCheck) {
            AxisAlignedBB var24 = AxisAlignedBB.getBoundingBox(56.0D, 10.0D, 20.0D, 116.0D, 240.0D, 80.0D);
            List var26 = var1.getEntitiesWithinAABB(EntityMasterKami.class, var24);
            if(var26.isEmpty()) {
               EntityMasterKami var28 = new EntityMasterKami(var1);
               var28.setLocationAndAngles(86.0D, 217.0D, 50.0D, 0.0F, 0.0F);
               var1.spawnEntityInWorld(var28);
            }

            AxisAlignedBB var29 = AxisAlignedBB.getBoundingBox(70.0D, 120.0D, 30.0D, 90.0D, 140.0D, 50.0D);
            List var31 = var1.getEntitiesWithinAABB(EntityMasterKarin.class, var29);
            if(var31.isEmpty()) {
               EntityMasterKarin var9 = new EntityMasterKarin(var1);
               var9.setLocationAndAngles(80.0D, 133.0D, 40.0D, 0.0F, 0.0F);
               var1.spawnEntityInWorld(var9);
            }
         }
      }

      int var25 = var3 + var2.nextInt(16);
      int var27 = var4 + var2.nextInt(16);
      byte var30 = 62;
      if(var1.getBiomeGenForCoords(var25, var27) == BiomeGenBase.ocean || var1.getBiomeGenForCoords(var25, var27) == BiomeGenBase.deepOcean || DBCH.genKH.length() < 3) {
         boolean var32 = true;
         if(KHSpawn && var1.getBlock(var25, var30, var27) == Blocks.water && var1.getBlock(var25, var30 + 1, var27).getMaterial() == Material.air) {
            int var36 = 62;

            for(int var10 = var30; var10 > 35; --var10) {
               if(var10 < var36) {
                  var36 = var10;
               }

               if(var1.getBlock(var25, var10, var27) != Blocks.water) {
                  var32 = false;
                  break;
               }
            }

            if(var32) {
               int var40 = JRMCoreConfig.buildingSpawnAreaSize;
               byte var11 = 30;
               AxisAlignedBB var12 = AxisAlignedBB.getBoundingBox((double)var25 - (double)var40, 64.0D, (double)var27 - (double)var40, (double)var25 + (double)var40, (double)(63 + var40 > 200?200:63 + var40), (double)var27 + (double)var40);
               List var13 = var1.func_147461_a(var12);
               boolean var14 = true;

               for(int var15 = 0; var15 < 8 && var14; ++var15) {
                  var14 = var1.getBiomeGenForCoords(var25 + (var15 != 0 && var15 != 2 && var15 != 6?(var15 != 4 && var15 != 5?-var40 * 2:0):var40 * 2), var27 + (var15 != 0 && var15 != 1 && var15 != 5?(var15 != 6 && var15 != 7?-var40 * 2:0):var40 * 2)) == BiomeGenBase.ocean || var1.getBiomeGenForCoords(var25 + (var15 != 0 && var15 != 2 && var15 != 6?(var15 != 4 && var15 != 5?-var40 * 2:0):var40 * 2), var27 + (var15 != 0 && var15 != 1 && var15 != 5?(var15 != 6 && var15 != 7?-var40 * 2:0):var40 * 2)) == BiomeGenBase.deepOcean;
               }

               if(var13.size() == 0 && var14 && DBCH.khrwi(FMLCommonHandler.instance().getMinecraftServerInstance()).length() < 3) {
                  KHSpawn = false;
                  String var45 = var25 + ";" + (var30 + 1) + ";" + var27;
                  MinecraftServer var16 = FMLCommonHandler.instance().getMinecraftServerInstance();
                  DBCH.khwwi(var16, var45, false);
                  DBCH.genKH = var45;
                  kh var17 = new kh();
                  var17.generate(var1, var2, var25 - var11, var30 - 3, var27 - var11);
                  int var18 = var16.getCurrentPlayerCount();

                  for(int var19 = 0; var19 < var18; ++var19) {
                     EntityPlayerMP var20 = JRMCoreH.getPlayerForUsername(var16, var16.getAllUsernames()[var19]);
                     String var21 = JRMCoreH.cly + JRMCoreH.trl("dbc.worldgen.buildings.beenfound");
                     String var22 = JRMCoreH.cly + JRMCoreH.trl("dbc.com.loc.kame");
                     String var23 = String.format(var21, new Object[]{var22});
                     var20.addChatMessage(new ChatComponentText(JRMCoreH.cly + var23));
                  }
               }
            }
         }
      }

      int var44 = var2.nextInt(15);
      byte var41 = 1;
      if(this.DBbuildsSpawn(var41) && var44 == 0) {
         int var33 = var3 + var2.nextInt(16);
         int var37 = var4 + var2.nextInt(16);
         this.buildingSpawn(var1, var2, var33, var37, var41, BiomeGenBase.plains, Type.NORMAL);
      }

      var41 = 0;
      if(this.DBbuildsSpawn(var41) && var44 == 1) {
         int var34 = var3 + var2.nextInt(16);
         int var38 = var4 + var2.nextInt(16);
         this.buildingSpawn(var1, var2, var34, var38, var41, BiomeGenBase.plains, Type.NORMAL);
      }

      var41 = 3;
      if(this.DBbuildsSpawn(var41) && var44 == 3) {
         int var35 = var3 + var2.nextInt(16);
         int var39 = var4 + var2.nextInt(16);
         this.buildingSpawn(var1, var2, var35, var39, var41, BiomeGenBase.plains, Type.UNDER);
      }

   }

   public static String DBbuildsNams(int var0) {
      return var0 == 0?DBCH.ca:(var0 == 1?DBCH.gh:(var0 == 2?DBCH.fs:(var0 == 3?DBCH.bs:"")));
   }

   public static String DBbuildsNams2(int var0) {
      return var0 == 0?"dbc.com.loc.cell":(var0 == 1?"dbc.com.loc.goku":(var0 == 2?"dbc.com.loc.freeza":(var0 == 3?"dbc.com.loc.babidi":"")));
   }

   public static String DBbuildsGen(int var0) {
      if(var0 == 0) {
         DBCH.genCA = DBCH.carwi(FMLCommonHandler.instance().getMinecraftServerInstance());
         return DBCH.genCA;
      } else if(var0 == 1) {
         DBCH.genGH = DBCH.ghrwi(FMLCommonHandler.instance().getMinecraftServerInstance());
         return DBCH.genGH;
      } else if(var0 == 2) {
         DBCH.genFS = DBCH.fsrwi(FMLCommonHandler.instance().getMinecraftServerInstance());
         return DBCH.genFS;
      } else if(var0 == 3) {
         DBCH.genBS = DBCH.bsrwi(FMLCommonHandler.instance().getMinecraftServerInstance());
         return DBCH.genBS;
      } else {
         return "";
      }
   }

   public static void DBbuildsGen(int var0, String var1) {
      if(var0 == 0) {
         DBCH.genCA = var1;
         DBCH.cawwi(FMLCommonHandler.instance().getMinecraftServerInstance(), var1, false);
      } else if(var0 == 1) {
         DBCH.genGH = var1;
         DBCH.ghwwi(FMLCommonHandler.instance().getMinecraftServerInstance(), var1, false);
      } else if(var0 == 2) {
         DBCH.genFS = var1;
         DBCH.fswwi(FMLCommonHandler.instance().getMinecraftServerInstance(), var1, false);
      } else if(var0 == 3) {
         DBCH.genBS = var1;
         DBCH.bswwi(FMLCommonHandler.instance().getMinecraftServerInstance(), var1, false);
      }

   }

   public boolean DBbuildsSpawn(int var1) {
      return var1 == 0?CASpawn:(var1 == 1?GHSpawn:(var1 == 2?FSSpawn:(var1 == 3?BSSpawn:false)));
   }

   public static void DBbuildsSpawn(int var0, boolean var1) {
      if(var0 == 0) {
         CASpawn = var1;
      } else if(var0 == 1) {
         GHSpawn = var1;
      } else if(var0 == 2) {
         FSSpawn = var1;
      } else if(var0 == 3) {
         BSSpawn = var1;
      }

   }

   public void buildingSpawn(World var1, Random var2, int var3, int var4, int var5, BiomeGenBase var6, Type var7) {
      if(this.DBbuildsSpawn(var5) && var1.provider.dimensionId == DBbuildsdim[var5] && var1.getBiomeGenForCoords(var3, var4) == var6) {
         if(var1.getBlock(86, 216, 50) == BlocksJRMC.BlockColoredStone) {
            ;
         }

         String var8 = DBbuildsGen(var5);
         if(var8.length() > 2) {
            DBbuildsSpawn(var5, false);
         } else if(var8.length() == 1) {
            builds var9 = DBbuilds[var5];
            int var10 = JRMCoreConfig.buildingSpawnAreaSize;
            boolean var11 = JRMCoreHDBC.checkForBuildsAound(var1, var3, var4, var10);

            for(int var12 = 0; var12 < 4; ++var12) {
               if(var1.getBiomeGenForCoords(var3 + (var12 != 0 && var12 != 1?builds.SizeX:0), var4 + (var12 != 0 && var12 != 2?builds.SizeZ:0)) != var6) {
                  var11 = false;
                  break;
               }
            }

            if(var11) {
               int var21 = var1.getHeightValue(var3, var4);
               if(var21 > 67) {
                  for(int var13 = 0; var13 < 4; ++var13) {
                     int var14 = var1.getHeightValue(var3 + (var13 != 0 && var13 != 1?builds.SizeX:0), var4 + (var13 != 0 && var13 != 2?builds.SizeZ:0));
                     if(var1.getBlock(var3 + (var13 != 0 && var13 != 1?builds.SizeX:0), var14 - 1, var4 + (var13 != 0 && var13 != 2?builds.SizeZ:0)) == Blocks.water) {
                        var11 = false;
                        break;
                     }
                  }

                  if(var11 && var7 == Type.UNDER) {
                     int var22 = var1.getHeightValue(var3 + builds.SizeX / 2, var4 + builds.SizeZ / 2);
                     if(var1.getBlock(var3 + builds.SizeX / 2, var22, var4 + builds.SizeZ / 2) == Blocks.water || var22 < 60) {
                        var11 = false;
                     }

                     var21 = var22 - builds.SizeY;
                  }

                  if(var11) {
                     DBbuildsSpawn(var5, true);
                     String var23 = var3 + ";" + var21 + ";" + var4;
                     DBbuildsGen(var5, var23);
                     MinecraftServer var24 = FMLCommonHandler.instance().getMinecraftServerInstance();
                     int var15 = var24.getCurrentPlayerCount();

                     for(int var16 = 0; var16 < var15; ++var16) {
                        EntityPlayerMP var17 = JRMCoreH.getPlayerForUsername(var24, var24.getAllUsernames()[var16]);
                        String var18 = JRMCoreH.cly + JRMCoreH.trl("dbc.worldgen.buildings.beenfound");
                        String var19 = JRMCoreH.cly + JRMCoreH.trl(DBbuildsNams(var5));
                        String var20 = String.format(var18, new Object[]{var19});
                        var17.addChatMessage(new ChatComponentText(JRMCoreH.cly + var20));
                     }

                     var9.setWorld(var1);
                     JRMCoreComTickH.bldngsChecker = 300;
                     JRMCoreComTickH.bldngChkr = true;
                  }
               }
            }
         }
      }

   }

   private void generateNether(World var1, Random var2, int var3, int var4) {
   }

   private void generateNamek(World var1, Random var2, int var3, int var4) {
      if(var1.provider.dimensionId == DBCConfig.planetNamek) {
         byte var7 = 2;
         if(this.DBbuildsSpawn(var7)) {
            int var5 = var3 + var2.nextInt(16);
            int var6 = var4 + var2.nextInt(16);
            this.buildingSpawn(var1, var2, var5, var6, var7, BiomeGenBaseDBC.Namek, Type.NORMAL);
         }

         for(int var8 = 0; var8 < 10; ++var8) {
            int var9 = var3 + var2.nextInt(16);
            int var10 = var4 + var2.nextInt(16);
            int var11 = 10 + var2.nextInt(127);
            (new WorldGenMinable(BlocksDBC.BlockOreWrenai, 6)).generate(var1, var2, var9, var11, var10);
         }
      }

   }

   private void generateTC(World var1, Random var2, int var3, int var4) {
      if(var1.provider.dimensionId == 23 && JRMCoreConfig.BuildingSpawnCheck && var1.getBlock(55, 34, 8) != BlocksJRMC.BlockColoredStone && TiChaSpawn) {
         TiChaSpawn = false;
         this.TiCha = new TiCha();
         this.TiCha.generate(var1, var1.rand, 0, 0, 0);
         if(var1.getBlock(53, 37, 8) != BlocksDBC.BlockTCPort && TiChaKLSpawn) {
            TiChaKLSpawn = false;
            var1.setBlock(54, 35, 8, BlocksDBC.BlockTCPort, 0, 3);
            var1.setBlock(55, 35, 8, BlocksDBC.BlockTCPort, 0, 3);
            var1.setBlock(54, 36, 8, BlocksDBC.BlockTCPort, 0, 3);
            var1.setBlock(55, 36, 8, BlocksDBC.BlockTCPort, 0, 3);
            var1.setBlock(53, 36, 8, BlocksDBC.BlockTCPort, 0, 3);
            var1.setBlock(53, 35, 8, BlocksDBC.BlockTCPort, 0, 3);
            var1.setBlock(53, 37, 8, BlocksDBC.BlockTCPort, 0, 3);
            var1.setBlock(54, 37, 8, BlocksDBC.BlockTCPort, 0, 3);
            var1.setBlock(55, 37, 8, BlocksDBC.BlockTCPort, 0, 3);
         }
      }

   }

   private void generateOW(World var1, Random var2, int var3, int var4) {
      if(var1.provider.dimensionId == 22) {
         byte var7 = 3;

         for(int var8 = 0; var8 < var7; ++var8) {
            int var9 = var3 + var2.nextInt(16) + 8;
            int var10 = var2.nextInt(50);
            int var11 = var4 + var2.nextInt(16) + 8;
            (new WorldGenOWTrees(false)).generate(var1, var2, var9, var10, var11);
         }

         for(int var13 = 0; var13 < 10; ++var13) {
            int var18 = var3 + var2.nextInt(16);
            int var23 = var2.nextInt(40);
            int var29 = var4 + var2.nextInt(16);
            (new WorldGenMinable(BlocksDBC.BlockOreJJay, 12)).generate(var1, var2, var18, var23, var29);
         }

         for(int var14 = 0; var14 < 10; ++var14) {
            int var19 = var3 + var2.nextInt(16);
            int var24 = var2.nextInt(40);
            int var30 = var4 + var2.nextInt(16);
            (new WorldGenMinable(BlocksDBC.BlockOreDlog, 8)).generate(var1, var2, var19, var24, var30);
         }

         for(int var15 = 0; var15 < 10; ++var15) {
            int var20 = var3 + var2.nextInt(16);
            int var25 = var2.nextInt(40);
            int var31 = var4 + var2.nextInt(16);
            (new WorldGenMinable(BlocksDBC.BlockOreLehnori, 8)).generate(var1, var2, var20, var25, var31);
         }

         for(int var16 = 0; var16 < 10; ++var16) {
            int var21 = var3 + var2.nextInt(16);
            int var26 = var2.nextInt(40);
            int var32 = var4 + var2.nextInt(16);
            (new WorldGenMinable(BlocksDBC.BlockOreDnomaid, 7, Blocks.lava)).generate(var1, var2, var21, var26, var32);
         }

         if(JRMCoreConfig.BuildingSpawnCheck) {
            if(var1.getBlock(75, 90, 127) != BlocksJRMC.BlockColoredStone && ChkInStSpawn) {
               ChkInStSpawn = false;
               this.ChkInSt = new ChkInSt();
               this.ChkInSt.generate(var1, var1.rand, 0, 0, 0);
            }

            if(var1.getBlock(75, 90, -5) != BlocksJRMC.BlockColoredStone && SnkWySpawn) {
               SnkWySpawn = false;
               this.SnkWy = new SnkWy();
               this.SnkWy.generate(var1, var1.rand, 0, 0, 0);
            }
         }

         if(JRMCoreConfig.NPCSpawnCheck) {
            AxisAlignedBB var17 = AxisAlignedBB.getBoundingBox(60.0D, 10.0D, 35.0D, 90.0D, 110.0D, 65.0D);
            List var22 = var1.getEntitiesWithinAABB(EntityMasterEnma.class, var17);
            if(var22.isEmpty()) {
               EntityMasterEnma var27 = new EntityMasterEnma(var1);
               var27.setLocationAndAngles(75.0D, 91.0D, 53.0D, 0.0F, 0.0F);
               var1.spawnEntityInWorld(var27);
            }

            AxisAlignedBB var28 = AxisAlignedBB.getBoundingBox(87.0D, 1.0D, -3739.0D, 127.0D, 140.0D, -3699.0D);
            List var33 = var1.getEntitiesWithinAABB(EntityMasterKaio.class, var28);
            if(var33.isEmpty()) {
               EntityMasterKaio var12 = new EntityMasterKaio(var1);
               var12.setLocationAndAngles(107.0D, 116.0D, -3719.0D, 0.0F, 0.0F);
               var1.spawnEntityInWorld(var12);
            }
         }
      }

   }

   public static enum Type {
      NORMAL,
      UNDER,
      WATER;

      private Type() {
      }
   }
}
