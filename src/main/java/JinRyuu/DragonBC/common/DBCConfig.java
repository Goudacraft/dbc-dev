package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.mod_DragonBC;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class DBCConfig {
   public static int playerCount = 0;
   public static int planetEarth = 0;
   public static int planetNamek = 20;
   public static int planetVegeta = 21;
   public static int otherWorld = 22;
   public static int dimTimeChamber = 23;
   public static boolean oldDsh;
   public static boolean oldJmp;
   public static boolean oldFly;
   public static boolean plntVegeta;
   public static boolean flyAnyLvl;
   public static int eDBrate = 2;
   public static int nDBrate = 3;
   public static int maxTrnExp = 1000;
   public static int healingpodhealingrate = 100;
   public static int senzuFromKarin = 1;
   public static int senzuCool = 15;
   public static boolean coldDsh;
   public static boolean coldJmp;
   public static boolean coldFly;
   public static boolean cplntVegeta;
   public static boolean cflyAnyLvl;
   public static int ceDBrate = 2;
   public static int cnDBrate = 3;
   public static int cmaxTrnExp = 1000;
   public static int chealingpodhealingrate = 100;
   public static int csenzuFromKarin = 1;
   public static int csenzuCool = 15;
   public static int spdc;
   public static int mdal;
   public static int mdat;
   public static int NPCOgreHP = 2000;
   public static int cNPCOgreHP;
   public static int NPCOgreDam = 500;
   public static int cNPCOgreDam;
   public static boolean DeadInv;
   public static boolean cDeadInv;
   public static boolean FreeRev;
   public static boolean cFreeRev;
   public static float Reinc;
   public static float cReinc;
   public static int RevTm;
   public static int cRevTm;
   public static double[] RevLocG;
   public static double[] cRevLocG;
   public static double[] RevLocN;
   public static double[] cRevLocN;
   public static double[] RevLocE;
   public static double[] cRevLocE;
   public static boolean Godform;
   public static boolean cGodform;
   public static boolean GodformCosm;
   public static boolean cGodformCosm;
   public static int StrainGod;
   public static int cStrainGod;
   public static int SSGHelp;
   public static int cSSGHelp;
   public static int TechExpRate;
   public static int cTechExpRate;
   public static int TechExpNeed;
   public static int cTechExpNeed;
   public static int TechCostMod;
   public static int cTechCostMod;
   public static boolean DsblO;
   public static boolean cDsblO;
   public static final String CATEGORY_SERVERSIDED = "general";
   public static final String CATEGORY_NPCCONFIGS = "NPC Configs";
   public static final String CATEGORY_DEATHSYSTEM = "Death System Configs";
   public static final String CATEGORY_CLIENTSIDED = "Client Sided Configs";
   public static final String CATEGORY_TRANSFORMATIONS = "Transformation Configs";
   public static final String CATEGORY_TECHNIQUES = "Techniques Configs";

   public DBCConfig() {
   }

   public static void init(Configuration var0) {
      var0.load();
      Side var1 = FMLCommonHandler.instance().getEffectiveSide();
      Property var2 = var0.get("general", "Max Training Experience Limit", 1000);
      var2.comment = "Server Sided! Max training experience limit can be set from 0-30000 (default: 1000). This is not TP this is Exp.";
      cmaxTrnExp = var2.getInt(1000);
      if(cmaxTrnExp < 0) {
         cmaxTrnExp = 0;
      }

      if(cmaxTrnExp > 30000) {
         cmaxTrnExp = 30000;
      }

      maxTrnExp = cmaxTrnExp;
      Property var3 = var0.get("general", "Planet Vegeta", true);
      var3.comment = "Server Sided! If \'false\' then Planet Vegeta wont appear, If \'true\' then Planet Vegeta will be available.";
      cplntVegeta = var3.getBoolean(true);
      plntVegeta = cplntVegeta;
      Property var4 = var0.get("general", "Earth Dragon Block Spawn Rate", 2);
      var4.comment = "Server Sided! Spawn rate can only be from 1 (everyday 1 DB, around everyplayer somewhere) to 100 (extremly rare spawn, 100 days 1 DB) ";
      ceDBrate = var4.getInt(2);
      if(ceDBrate < 1) {
         ceDBrate = 1;
      }

      if(ceDBrate > 100) {
         ceDBrate = 100;
      }

      eDBrate = ceDBrate;
      Property var5 = var0.get("general", "Namek Dragon Block Spawn Rate", 3);
      var5.comment = "Server Sided! Spawn rate can only be from 1 (everyday 1 DB, around everyplayer somewhere) to 100 (extremly rare spawn, 100 days 1 DB) ";
      cnDBrate = var5.getInt(3);
      if(cnDBrate < 1) {
         cnDBrate = 1;
      }

      if(cnDBrate > 100) {
         cnDBrate = 100;
      }

      nDBrate = cnDBrate;
      Property var6 = var0.get("Client Sided Configs", "Old Dash", false);
      var6.comment = "If \'false\' then the current sprint dash will be used, If \'true\' then the one key press and hold (R) dash will be available.";
      coldDsh = var6.getBoolean(false);
      oldDsh = coldDsh;
      Property var7 = var0.get("Client Sided Configs", "Old Jump", false);
      var7.comment = "If \'false\' then the current space jump will be used, If \'true\' then the one key press and hold (X) jump will be available.";
      coldJmp = var7.getBoolean(false);
      oldJmp = coldJmp;
      Property var8 = var0.get("Client Sided Configs", "Old Fly", false);
      var8.comment = "If \'false\' then the current turn on/off fly will be used, If \'true\' then the one key press and hold (F) Fly and (Ctrl) for float will be available.";
      coldFly = var8.getBoolean(false);
      oldFly = coldFly;
      Property var9 = var0.get("general", "Fly with no Fly Skill", false);
      var9.comment = "Server Sided! If \'false\' then one can only fly with Fly Skill, If \'true\' then one will be able to Fly without Fly Skill.";
      cflyAnyLvl = var9.getBoolean(false);
      flyAnyLvl = cflyAnyLvl;
      Property var10 = var0.get("general", "Spacepods drop timer", 60);
      var10.comment = "Server Sided! Spacepods will drop after given seconds if not being ridden. If 0 they wont drop! (Default: 60)";
      spdc = var10.getInt(60);
      var10 = var0.get("general", "Saga mob despawn area limit", 50);
      var10.comment = "Server Sided! Saga mobs will despawn if the mob spawner (a player) is not in the area in specified block radius after specific seconds that can be set in \'Saga mob despawn timer\' config option. If 0 Saga mobs wont despawn! (Default: 50)";
      mdal = var10.getInt(50);
      var10 = var0.get("general", "Saga mob despawn timer", 30);
      var10.comment = "Server Sided! Saga mob despawn timer in seconds, if spawner not near it. If \'Saga mob despawn area limit\' config option is 0 this wont work! (Default: 30)";
      mdat = var10.getInt(30);
      mdat = mdat < 1?1:mdat;
      Property var11 = var0.get("Death System Configs", "Death System Off", false);
      var11.comment = "Server Sided! If \'false\' then Death System is on, If \'true\' then its off. (may reduce lag if true)";
      mod_DragonBC.cDeathSystemOff = var11.getBoolean(false);
      mod_DragonBC.DeathSystemOff = mod_DragonBC.cDeathSystemOff;
      Property var12 = var0.get("general", "Dragon Blocks Spawn Enabled", true);
      var12.comment = "Server Sided! If \'true\' Dragon Blocks will spawn, if \'false\' then they wont spawn at all. (may reduce lag if false)";
      mod_DragonBC.cDBSpawnEnabled = var12.getBoolean(true);
      mod_DragonBC.DBSpawnEnabled = mod_DragonBC.cDBSpawnEnabled;
      Property var13 = var0.get("general", "Dragon Blocks Spawn Chance", 3);
      var13.comment = "Server Sided! The maximum number (default: 2) of Dragon Blocks spawned around the players, in a 64 block radius. (from 0 to 7)";
      mod_DragonBC.cDBSpawnChance = var13.getInt(2);
      mod_DragonBC.DBSpawnChance = mod_DragonBC.cDBSpawnChance;
      Property var14 = var0.get("general", "Dragon Blocks Spawn Time", "midday");
      var14.comment = "Server Sided! The daytime when the Dragon Blocks will spawn. 3 states, \'morning\', \'midday\'(default), and \'evening\'.";
      mod_DragonBC.cDBSpawnTime = var14.getString();
      mod_DragonBC.DBSpawnTime = mod_DragonBC.cDBSpawnTime;
      Property var15 = var0.get("general", "Saga System On", true);
      var15.comment = "Server Sided! If \'true\' Saga System will work, if \'false\' then no one will be able to progress in Saga System.  (may reduce lag if false)";
      mod_DragonBC.cSagaSystemOn = var15.getBoolean(true);
      mod_DragonBC.SagaSystemOn = mod_DragonBC.cSagaSystemOn;
      Property var16 = var0.get("general", "Saga System Spawn Spacepods", true);
      var16.comment = "Server Sided! If \'true\' Spacepods will spawn in the saga part where it can, if \'false\' then Spacepods wont spawn.";
      mod_DragonBC.cSagaSysSpawnPods = var16.getBoolean(true);
      mod_DragonBC.SagaSysSpawnPods = mod_DragonBC.cSagaSysSpawnPods;
      Property var17 = var0.get("general", "Healing Pods Healing Rate", 20);
      var17.comment = "Server Sided! Healing pods healing rate can be set from 20 energy and body points to 1000! (from 20 to 1000)";
      chealingpodhealingrate = var17.getInt(100);
      if(chealingpodhealingrate < 20) {
         chealingpodhealingrate = 20;
      }

      if(chealingpodhealingrate > 1000) {
         chealingpodhealingrate = 1000;
      }

      healingpodhealingrate = chealingpodhealingrate;
      Property var18 = var0.get("general", "Senzu from Korin", 1);
      var18.comment = "Server Sided! Number of Senzu from Korin! (from 1 to 10)";
      csenzuFromKarin = var18.getInt(1);
      if(csenzuFromKarin < 1) {
         csenzuFromKarin = 1;
      }

      if(csenzuFromKarin > 10) {
         csenzuFromKarin = 10;
      }

      senzuFromKarin = csenzuFromKarin;
      Property var19 = var0.get("general", "Senzu from Korin", 1);
      var19.comment = "Server Sided! Number of Senzu from Korin! (from 1 to 10)";
      csenzuFromKarin = var19.getInt(1);
      if(csenzuFromKarin < 1) {
         csenzuFromKarin = 1;
      }

      if(csenzuFromKarin > 10) {
         csenzuFromKarin = 10;
      }

      senzuFromKarin = csenzuFromKarin;
      var19 = var0.get("general", "Senzu Cooldown", 15);
      var19.comment = "Server Sided! Indicates how long senzu can not be used, In seconds! (from 0 to 1200)";
      csenzuCool = var19.getInt(15);
      if(csenzuCool < 0) {
         csenzuCool = 0;
      }

      if(csenzuCool > 1200) {
         csenzuCool = 1200;
      }

      senzuCool = csenzuCool;
      var19 = var0.get("NPC Configs", "NPC Otherworld Ogre Stat Health", 2000);
      var19.comment = "Server Sided! Otherworld Ogre NPCs Health amount from 10 to 100000. (default: 2000)";
      cNPCOgreHP = var19.getInt(2000);
      if(cNPCOgreHP < 10) {
         cNPCOgreHP = 10;
      }

      if(cNPCOgreHP > 100000) {
         cNPCOgreHP = 100000;
      }

      NPCOgreHP = cNPCOgreHP;
      var19 = var0.get("NPC Configs", "NPC Otherworld Ogre Stat Damage", 500);
      var19.comment = "Server Sided! Otherworld Ogre NPCs Damage amount from 10 to 100000. (default: 500)";
      cNPCOgreDam = var19.getInt(500);
      if(cNPCOgreDam < 10) {
         cNPCOgreDam = 10;
      }

      if(cNPCOgreDam > 100000) {
         cNPCOgreDam = 100000;
      }

      NPCOgreDam = cNPCOgreDam;
      var19 = var0.get("Death System Configs", "Death System - Switch Inventory", true);
      var19.comment = "Server Sided! If \'true\' and keepInventory is On then players will have separate inventory for dead and living states (Creative switching while dead will cause issues). If \'false\' then like it was before depending on keepInventory\'s state";
      cDeadInv = var19.getBoolean();
      DeadInv = cDeadInv;
      var19 = var0.get("Death System Configs", "Death System - Free Revive", true);
      var19.comment = "Server Sided! If \'true\' players can revive for free, \'Revive Timer\' config will be used to determine the revive interval.If \'false\' then players wont be able to revive for free even after time, Only way to revive is to wish revival, by Reincarnation, or dbcrevive command.";
      cFreeRev = var19.getBoolean();
      FreeRev = cFreeRev;
      var19 = var0.get("Death System Configs", "Death System - Revive Timer", 5);
      var19.comment = "Server Sided! The time in minutes after a player can use \'Free Revive\' if it is \'true\'. The time can go from 1 min to 100000 mins (close to a week). (default: 20)";
      cRevTm = var19.getInt() * 12;
      if(cRevTm < 12) {
         cRevTm = 12;
      }

      if(cRevTm > 1200000) {
         cRevTm = 1200000;
      }

      RevTm = cRevTm;
      var19 = var0.get("Death System Configs", "Death System - Reincarnation Penalty", 50);
      var19.comment = "Server Sided! Reincarnation resets everything like starting new, but leaving a percentage of attributes left. Value can go from 0 to 100. (default: 50) #to disable it use 0!";
      cReinc = (float)var19.getInt() * 0.01001F;
      if(cReinc < 0.0F) {
         cReinc = 0.0F;
      }

      if(cReinc > 1.0F) {
         cReinc = 1.0F;
      }

      Reinc = cReinc;
      var19 = var0.get("Transformation Configs", "Transformation - SuperSaiyanGod Helpers needed", 5);
      var19.comment = "Server Sided! The amount of Good Saiyans needed to preform the SSG ritual. The amount can go from 1 to 100. (default: 5)";
      cSSGHelp = var19.getInt();
      if(cSSGHelp < 1) {
         cSSGHelp = 1;
      }

      if(cSSGHelp > 100) {
         cSSGHelp = 100;
      }

      SSGHelp = cSSGHelp;
      var19 = var0.get("Techniques Configs", "Ki Technique - Experience gain rate per hit", 1);
      var19.comment = "Server Sided! Exp gain rate per living entity hit for ki techniques. The higher the more exp will be gained. The amount can go from 1 to 10000. (default: 1)";
      cTechExpRate = var19.getInt();
      if(cTechExpRate < 1) {
         cTechExpRate = 1;
      }

      if(cTechExpRate > 10000) {
         cTechExpRate = 10000;
      }

      TechExpRate = cTechExpRate;
      var19 = var0.get("Techniques Configs", "Ki Technique - Experience needed to upgrade", 15);
      var19.comment = "Server Sided! Exp amount needed to upgrade to first level, the other levels will multiplied with this amount. The higher the more exp will be needed to upgrade. The amount can go from 10 to 1000. (default: 15)";
      cTechExpNeed = var19.getInt();
      if(cTechExpNeed < 10) {
         cTechExpNeed = 10;
      }

      if(cTechExpNeed > 1000) {
         cTechExpNeed = 1000;
      }

      TechExpNeed = cTechExpNeed;
      var19 = var0.get("Techniques Configs", "Ki Technique - Energy cost modifier", 50);
      var19.comment = "Server Sided! Ki cost modifier, with this you can reduce in percentage the costs of ki attacks. So your Ki attacks can cost less or more Ki. The amount can go from 1 to 1000. (default: 100)";
      cTechCostMod = var19.getInt();
      if(cTechCostMod < 1) {
         cTechCostMod = 1;
      }

      if(cTechCostMod > 1000) {
         cTechCostMod = 1000;
      }

      TechCostMod = cTechCostMod;
      var19 = var0.get("Transformation Configs", "Transformation - SuperSaiyanGod Helpers fatigue", 10);
      var19.comment = "Server Sided! How long helper saiyans can\'t help in SSG ritual again. The time can go from 0 mins to 1000 mins. (default: 10)";
      cStrainGod = var19.getInt() * 12;
      if(cStrainGod < 0) {
         cStrainGod = 0;
      }

      if(cStrainGod > 12000) {
         cStrainGod = 12000;
      }

      StrainGod = cStrainGod;
      double[] var20 = new double[]{75.0D, 220.0D, 55.0D};
      var19 = var0.get("Death System Configs", "Death System - Good Revive Location", var20, "Server Sided! Revive position for players with good alignment.");
      cRevLocG = var19.getDoubleList();
      RevLocG = cRevLocG;
      var20 = new double[]{58.0D, 220.0D, 7.0D};
      var19 = var0.get("Death System Configs", "Death System - Neutral Revive Location", var20, "Server Sided! Revive position for players with neutral alignment.");
      cRevLocN = var19.getDoubleList();
      RevLocN = cRevLocN;
      var20 = new double[]{96.0D, 230.0D, 7.0D};
      var19 = var0.get("Death System Configs", "Death System - Evil Revive Location", var20, "Server Sided! Revive position for players with evil alignment.");
      cRevLocE = var19.getDoubleList();
      RevLocE = cRevLocE;
      var19 = var0.get("Transformation Configs", "Transformations - God Form", true);
      var19.comment = "Server Sided! If \'true\' then God transformations will be enabled. If \'false\' then god transformations will be disabled";
      cGodform = var19.getBoolean();
      Godform = cGodform;
      var19 = var0.get("Transformation Configs", "Transformations - God Forms Cosmetics", true);
      var19.comment = "Client Sided! If \'true\' then God transformations will have SSG red eyes and SSG flaming aura. If \'false\' then god transformations wont have any difference in eye and aura";
      cGodformCosm = var19.getBoolean();
      GodformCosm = cGodformCosm;
      var19 = var0.get("NPC Configs", "NPC Otherworld Ogre Disable", false);
      var19.comment = "Client Sided! If \'true\' then Ogres in otherworld will get disabled. If \'false\' Ogres are enabled. (default: false)";
      cDsblO = var19.getBoolean();
      DsblO = cDsblO;
      if(var1 == Side.CLIENT) {
         mod_DragonBC.cwfb = var0.get("Client Sided Configs", "Custom X pos for Ki Bar", 0).getInt(0);
         mod_DragonBC.chfb = var0.get("Client Sided Configs", "Custom Y pos for Ki Bar", 0).getInt(0);
         mod_DragonBC.cwfn = var0.get("Client Sided Configs", "Custom X pos for Ki Number", 0).getInt(0);
         mod_DragonBC.chfn = var0.get("Client Sided Configs", "Custom Y pos for Ki Number", 0).getInt(0);
      }

      var0.save();
      DBCH.wishInit();
      DBCH.plntNmsInit();
   }
}
