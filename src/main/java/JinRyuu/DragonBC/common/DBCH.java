package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntityBuuFat;
import JinRyuu.DragonBC.common.Npcs.EntityBuuSuper;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg16;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg17;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg18;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg19;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg20;
import JinRyuu.DragonBC.common.Npcs.EntityDarbura;
import JinRyuu.DragonBC.common.p.DBCPascend;
import JinRyuu.DragonBC.common.p.DBCPascendsound;
import JinRyuu.DragonBC.common.p.DBCPchargepart;
import JinRyuu.DragonBC.common.p.DBCPchargesound;
import JinRyuu.DragonBC.common.p.DBCPdescend;
import JinRyuu.DragonBC.common.p.DBCPdescendsound;
import JinRyuu.DragonBC.common.p.DBCPdri;
import JinRyuu.DragonBC.common.p.DBCPduo;
import JinRyuu.DragonBC.common.p.DBCPenergy;
import JinRyuu.DragonBC.common.p.DBCPscouter1;
import JinRyuu.DragonBC.common.p.DBCPscouter2;
import JinRyuu.DragonBC.common.p.DBCPscouter3;
import JinRyuu.DragonBC.common.p.DBCPscouter4;
import JinRyuu.DragonBC.common.p.DBCPspacepod1;
import JinRyuu.DragonBC.common.p.DBCPtick;
import JinRyuu.DragonBC.common.p.DBCPwish;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHDBC;
import JinRyuu.JRMCore.p.PD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class DBCH {
   public static String genKH = "";
   public static String genCA = "";
   public static String genGH = "";
   public static String genFS = "";
   public static String genBS = "";
   public static int[] genKHnpc1 = new int[]{-5, 0, -18};
   public static int[] genCAnpc1 = new int[]{2, 2, 10};
   public static int[] genGHnpc1 = new int[]{8, 1, 31};
   public static int[] genFSnpc1 = new int[]{2, 1, 15};
   public static int[] genBSnpc1 = new int[]{15, 1, 20};
   public static String wi = "wi.dbc";
   public static String kh = "KameHouse";
   public static String khn1 = "KameHouseNPC1";
   public static String ca = "CellArena";
   public static String can1 = "CellArenaNPC1";
   public static String gh = "GokuHouse";
   public static String ghn1 = "GokuHouseNPC1";
   public static String fs = "FreizaShip";
   public static String fsn1 = "FreizaShipNPC1";
   public static String bs = "BabidiShip";
   public static boolean HTCtrain = false;
   public static int KPminX = 75;
   public static int KPminY = 110;
   public static int KPminZ = -3757;
   public static int KPmaxX = 132;
   public static int KPmaxY = 150;
   public static int KPmaxZ = -3702;
   public static int[] Kami = new int[]{86, 217, 50, 0};
   public static int[] Karn = new int[]{80, 133, 40, 0};
   public static int[] Enma = new int[]{75, 91, 53, 0};
   public static int[] KaiO = new int[]{107, 116, -3719, 0};
   public static float RotYaw = 0.0F;
   public static float RotPic = 0.0F;
   public static int cbge = 0;
   public static Class[] rp = new Class[]{DBCPascend.class, DBCPascendsound.class, DBCPchargepart.class, DBCPchargesound.class, DBCPdescend.class, DBCPdescendsound.class, DBCPdri.class, DBCPenergy.class, DBCPduo.class, DBCPscouter1.class, DBCPscouter2.class, DBCPscouter3.class, DBCPscouter4.class, DBCPspacepod1.class, DBCPtick.class, DBCPwish.class};
   public static Class[] rph = new Class[]{DBCPascend.Handler.class, DBCPascendsound.Handler.class, DBCPchargepart.Handler.class, DBCPchargesound.Handler.class, DBCPdescend.Handler.class, DBCPdescendsound.Handler.class, DBCPdri.Handler.class, DBCPenergy.Handler.class, DBCPduo.Handler.class, DBCPscouter1.Handler.class, DBCPscouter2.Handler.class, DBCPscouter3.Handler.class, DBCPscouter4.Handler.class, DBCPspacepod1.Handler.class, DBCPtick.Handler.class, DBCPwish.Handler.class};
   public static int planetEarth = 0;
   public static int planetNamek = 20;
   public static int planetVegeta = 21;
   public static int otherWorld = 22;
   public static int dimTimeChamber = 23;
   public static HashMap<Integer, String> plntNms = new HashMap();
   public static ArrayList<String> wishS = new ArrayList();
   public static ArrayList<String> wishP = new ArrayList();
   public static int mult = 1;

   public DBCH() {
   }

   public static void wwi(MinecraftServer var0, String var1, String var2, boolean var3) {
      String var4 = "/data";
      JRMCoreH.wd(var0, var1, var2 + "", var4, wi, var3);
   }

   public static String rwi(MinecraftServer var0, String var1) {
      String var2 = "/data";
      return JRMCoreH.rd(var0, var1 + "", var2, wi);
   }

   public static void khwwi(MinecraftServer var0, String var1, boolean var2) {
      wwi(var0, var1, kh, var2);
   }

   public static String khrwi(MinecraftServer var0) {
      return rwi(var0, kh);
   }

   public static void khn1wwi(MinecraftServer var0, String var1, boolean var2) {
      wwi(var0, var1, khn1, var2);
   }

   public static String khn1rwi(MinecraftServer var0) {
      return rwi(var0, khn1);
   }

   public static void cawwi(MinecraftServer var0, String var1, boolean var2) {
      wwi(var0, var1, ca, var2);
   }

   public static String carwi(MinecraftServer var0) {
      return rwi(var0, ca);
   }

   public static void can1wwi(MinecraftServer var0, String var1, boolean var2) {
      wwi(var0, var1, can1, var2);
   }

   public static String can1rwi(MinecraftServer var0) {
      return rwi(var0, can1);
   }

   public static void ghwwi(MinecraftServer var0, String var1, boolean var2) {
      wwi(var0, var1, gh, var2);
   }

   public static String ghrwi(MinecraftServer var0) {
      return rwi(var0, gh);
   }

   public static void ghn1wwi(MinecraftServer var0, String var1, boolean var2) {
      wwi(var0, var1, ghn1, var2);
   }

   public static String ghn1rwi(MinecraftServer var0) {
      return rwi(var0, ghn1);
   }

   public static void fswwi(MinecraftServer var0, String var1, boolean var2) {
      wwi(var0, var1, fs, var2);
   }

   public static String fsrwi(MinecraftServer var0) {
      return rwi(var0, fs);
   }

   public static void fsn1wwi(MinecraftServer var0, String var1, boolean var2) {
      wwi(var0, var1, fsn1, var2);
   }

   public static String fsn1rwi(MinecraftServer var0) {
      return rwi(var0, fsn1);
   }

   public static void bswwi(MinecraftServer var0, String var1, boolean var2) {
      wwi(var0, var1, bs, var2);
   }

   public static String bsrwi(MinecraftServer var0) {
      return rwi(var0, bs);
   }

   public static boolean mvng() {
      float var0 = DBCClient.mc.thePlayer.rotationPitch < 0.0F?(float)((int)DBCClient.mc.thePlayer.rotationPitch * -1):(float)((int)DBCClient.mc.thePlayer.rotationPitch);
      float var1 = DBCClient.mc.thePlayer.rotationYaw < 0.0F?(float)((int)DBCClient.mc.thePlayer.rotationYaw * -1):(float)((int)DBCClient.mc.thePlayer.rotationYaw);
      if((var0 <= RotPic || var0 <= RotPic + 0.1F) && (var0 >= RotPic || var0 >= RotPic - 0.1F) && (var1 <= RotYaw || var1 <= RotYaw + 0.1F) && (var1 >= RotYaw || var1 >= RotYaw - 0.1F)) {
         boolean var3 = false;
      } else {
         boolean var10000 = true;
      }

      return DBCClient.mc.thePlayer.motionX > 0.005D || DBCClient.mc.thePlayer.motionZ > 0.005D || DBCClient.mc.thePlayer.motionX < -0.005D || DBCClient.mc.thePlayer.motionZ < -0.005D || DBCClient.mc.thePlayer.motionY > 0.005D;
   }

   public static boolean lkng() {
      float var0 = DBCClient.mc.thePlayer.rotationPitch < 0.0F?(float)((int)DBCClient.mc.thePlayer.rotationPitch * -1):(float)((int)DBCClient.mc.thePlayer.rotationPitch);
      float var1 = DBCClient.mc.thePlayer.rotationYaw < 0.0F?(float)((int)DBCClient.mc.thePlayer.rotationYaw * -1):(float)((int)DBCClient.mc.thePlayer.rotationYaw);
      boolean var2 = var0 > RotPic && var0 > RotPic + 0.1F || var0 < RotPic && var0 < RotPic - 0.1F || var1 > RotYaw && var1 > RotYaw + 0.1F || var1 < RotYaw && var1 < RotYaw - 0.1F;
      return var2;
   }

   public static void dbcWish(int var0, EntityPlayer var1) {
   }

   public static void DBCDeath(EntityPlayer var0) {
      mod_DragonBC var10000 = mod_DragonBC.instance;
      if(!mod_DragonBC.DeathSystemOff) {
         byte var1 = JRMCoreH.getByte(var0, "jrmcAlv");
         if(var1 != 1) {
            JRMCoreH.setByte(1, var0, "jrmcAlv");
            JRMCoreH.setInt(DBCConfig.RevTm, var0, "jrmcReviveTmer");
         }
      }

      if(var0 != null) {
         JRMCoreH.setInt(0, var0, "jrmcAlCntr");
         System.out.println(var0.getCommandSenderName() + " has died");
         byte var8 = JRMCoreH.getByte(var0, "jrmcDiff");
         byte var2 = JRMCoreH.getByte(var0, "jrmcPwrtyp");
         if(var8 > 0 && var2 == 1) {
            for(int var3 = 0; var3 < var8; ++var3) {
               for(int var4 = 0; var4 < 2; ++var4) {
                  Random var5 = new Random();
                  int var6 = var5.nextInt(6);
                  int var7 = JRMCoreH.getInt(var0, JRMCoreH.AttrbtNbtI[var6]);
                  if(var7 > 1) {
                     JRMCoreH.setInt(var7 - 1, var0, JRMCoreH.AttrbtNbtI[var6]);
                     System.out.println("Because of death, " + var0.getCommandSenderName() + " also lost a " + JRMCoreH.attrNms(var2, var6) + " point.");
                     break;
                  }
               }
            }
         }
      }

   }

   public static void DBCUpdate(EntityPlayer var0) {
   }

   public static void dragonSum(Entity var0) {
      double var1 = var0.posX;
      double var3 = var0.posY;
      double var5 = var0.posZ;
      byte var7 = 100;
      AxisAlignedBB var8 = AxisAlignedBB.getBoundingBox(var1 - (double)var7, var3 - (double)var7, var5 - (double)var7, var1 + (double)var7, var3 + (double)var7, var5 + (double)var7);
      List var9 = var0.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var8);
      if(!var9.isEmpty()) {
         JRMCoreHDBC.dragonSum = 100;
      }

   }

   public static String NpcSpawnLoc(int var0, int var1, int var2, World var3) {
      int var4 = 0;

      label34:
      for(int var5 = 3; var5 < 6; ++var5) {
         for(int var6 = 0; var6 < 6; ++var6) {
            for(int var7 = var1 + 5; var7 > 1; --var7) {
               if(var3.isAirBlock(var0 + var5, var7, var2 + var6) && !var3.isAirBlock(var0 + var5, var7 - 1, var2 + var6)) {
                  var0 += var5;
                  var1 = var7;
                  var2 += var6;
                  ++var4;
                  break label34;
               }
            }
         }
      }

      double var10 = (double)var0 + 0.5D;
      double var11 = (double)var2 + 0.5D;
      return var10 + ";" + var1 + ";" + var11;
   }

   public static void DBSpawn(EntityPlayer var0, long var1) {
      mod_DragonBC var10000 = mod_DragonBC.instance;
      if(mod_DragonBC.DBSpawnEnabled) {
         byte var3 = 48;
         int var4 = DBTime("morning")?1:(DBTime("evening")?11996:6001);
         if(var1 == (long)var4) {
            int var5 = var0.dimension;
            Random var6 = new Random();
            int var7 = var5 == DBCConfig.planetEarth?DBCConfig.eDBrate:(var5 == DBCConfig.planetNamek?DBCConfig.nDBrate:10);
            int var8 = var6.nextInt(var7);
            if(var8 == 0) {
               Block var9 = var5 == DBCConfig.planetEarth?BlocksDBC.BlockDragonBallStone:(var5 == DBCConfig.planetNamek?BlocksDBC.BlockNamekDragonBallStone:null);
               Block var10 = var5 == DBCConfig.planetEarth?BlocksDBC.BlockDragonBall:(var5 == DBCConfig.planetNamek?BlocksDBC.BlockNamekDragonBall:null);
               Object var11 = null;
               int var12 = 0;
               int var13 = MathHelper.floor_double(var0.posX);
               int var14 = MathHelper.floor_double(var0.posZ);

               for(int var15 = var13 - var3; var15 <= var13 + var3; ++var15) {
                  for(int var16 = var14 - var3; var16 <= var14 + var3; ++var16) {
                     for(int var17 = 109; var17 >= 64; --var17) {
                        if(var0.worldObj.getBlock(var15, var17, var16) == var10) {
                           ++var12;
                        }

                        if(var0.worldObj.getBlock(var15, var17, var16) == var9) {
                           ++var12;
                        }
                     }
                  }
               }

               int var18 = MathHelper.floor_double(var0.posX + (double)var0.worldObj.rand.nextInt(var3) + (double)(var0.worldObj.rand.nextInt(var3) * -1));
               int var19 = MathHelper.floor_double(var0.posZ + (double)var0.worldObj.rand.nextInt(var3) + (double)(var0.worldObj.rand.nextInt(var3) * -1));

               for(int var20 = 109; var20 >= 64; --var20) {
                  if(!var0.worldObj.isAirBlock(var18, var20, var19) && var0.worldObj.getBlock(var18, var20, var19) != var9 && var0.worldObj.getBlock(var18, var20, var19) != var10 && (var0.worldObj.getBlock(var18, var20, var19) == Blocks.grass || var0.worldObj.getBlock(var18, var20, var19) == Blocks.sand || var0.worldObj.getBlock(var18, var20, var19) == BlocksDBC.BlockNamekGrass)) {
                     mod_DragonBC var10001 = mod_DragonBC.instance;
                     if(var12 < mod_DragonBC.DBSpawnChance) {
                        var0.worldObj.setBlock(var18, var20 + 1, var19, var9, 0, 3);
                        break;
                     }
                  }
               }
            }
         }
      }

   }

   private static boolean DBTime(String var0) {
      mod_DragonBC var10000 = mod_DragonBC.instance;
      return mod_DragonBC.DBSpawnTime.contains(var0);
   }

   public static void packDuo(int var0, int var1) {
      PD.sendToServer(new DBCPduo(var0, var1));
   }

   public static void plntNmsInit() {
      plntNms.put(Integer.valueOf(DBCConfig.planetEarth), "Earth");
      plntNms.put(Integer.valueOf(DBCConfig.planetNamek), "Namek");
      plntNms.put(Integer.valueOf(DBCConfig.planetVegeta), "Vegeta");
      plntNms.put(Integer.valueOf(DBCConfig.otherWorld), "OtherWorld");
      plntNms.put(Integer.valueOf(DBCConfig.dimTimeChamber), "TimeChamber");
   }

   public static void wishInit() {
      wishS.add("minecraft:diamond;+;" + 3 * mult + ";+;0");
      wishS.add("jinryuudragonblockc:ItemAlienTechChipTier1;+;" + 3 * mult + ";+;0");
      wishS.add("jinryuudragonblockc:ItemWarenai;+;" + 5 * mult + ";+;0");
      wishS.add("jinryuudragonblockc:ItemSenzu;+;" + 3 * mult + ";+;0");
      wishS.add("jinryuudragonblockc:ItemKatchin;+;" + 1 * mult + ";+;0");
      wishS.add("revive");
      wishS.add("reviventp");
      wishS.add("reviveall");
      wishS.add("kicolor");
      if(JRMCoreH.JYC()) {
         wishS.add("young");
         wishS.add("child");
         wishS.add("old");
      }

      wishP.add("minecraft:diamond;+;" + 3 * mult + ";+;0");
      wishP.add("jinryuudragonblockc:ItemAlienTechChipTier1;+;" + 3 * mult + ";+;0");
      wishP.add("jinryuudragonblockc:ItemWarenai;+;" + 5 * mult + ";+;0");
      wishP.add("jinryuudragonblockc:ItemSenzu;+;" + 3 * mult + ";+;0");
      wishP.add("jinryuudragonblockc:ItemKatchin;+;" + 1 * mult + ";+;0");
      wishP.add("revive");
      wishP.add("reviventp");
      wishP.add("kicolor");
      if(JRMCoreH.JYC()) {
         wishP.add("young");
         wishP.add("child");
         wishP.add("old");
      }

   }

   public static void toDrop(int var0, LivingDropsEvent var1) {
      EntityLivingBase var2 = var1.entityLiving;
      int var3 = var1.entityLiving.worldObj.rand.nextInt(100);
      Item[] var4 = var3 < 5?ItemsDBC.ItemsOutfit1:(var3 < 10?ItemsDBC.ItemsOutfit2:(var3 < 15?ItemsDBC.ItemsOutfit3:ItemsDBC.ItemsOutfit0));
      ItemStack var5 = new ItemStack(var4[var0], 1, 1);
      if(var3 < 20 && var5 != null && var5.stackSize != 0 && var5.getItem() != null) {
         EntityItem var6 = new EntityItem(var2.worldObj, var2.posX, var2.posY, var2.posZ, var5);
         var6.delayBeforeCanPickup = 10;
         var1.drops.add(var6);
      }

      System.out.println(var1.drops + " " + var3);
   }

   public static void onEventDrop(LivingDropsEvent var0) {
      if(var0.entityLiving instanceof EntityCyborg16) {
         toDrop(0, var0);
      }

      if(var0.entityLiving instanceof EntityCyborg17) {
         toDrop(1, var0);
      }

      if(var0.entityLiving instanceof EntityCyborg18) {
         toDrop(2, var0);
      }

      if(var0.entityLiving instanceof EntityCyborg19) {
         toDrop(3, var0);
      }

      if(var0.entityLiving instanceof EntityCyborg20) {
         toDrop(4, var0);
      }

      if(var0.entityLiving instanceof EntityDarbura) {
         toDrop(5, var0);
      }

      if(var0.entityLiving instanceof EntityBuuFat) {
         toDrop(6, var0);
      }

      if(var0.entityLiving instanceof EntityBuuSuper) {
         toDrop(7, var0);
      }

      if(var0.entityLiving instanceof EntityBuuSuper) {
         toDrop(7, var0);
      }

   }
}
