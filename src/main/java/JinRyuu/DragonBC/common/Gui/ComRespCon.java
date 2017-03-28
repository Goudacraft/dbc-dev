package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.Villages.builds;
import JinRyuu.DragonBC.common.Worlds.WorldGeneratorDB;
import JinRyuu.JRMCore.JRMCoreHDBC;
import JinRyuu.JRMCore.JRMCoreSafe;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.StatCollector;

public class ComRespCon extends CommandBase {
   public ComRespCon() {
   }

   public String getCommandName() {
      return "dbcbuildings";
   }

   public int getRequiredPermissionLevel() {
      return 2;
   }

   public void processCommand(ICommandSender var1, String[] var2) {
      if(var2.length <= 0) {
         throw new WrongUsageException("/dbcbuildings (respawn)", new Object[0]);
      } else {
         String var3 = var2[0];
         boolean var4 = var3.toLowerCase().contentEquals("respawn");
         boolean var5 = var3.toLowerCase().contentEquals("reset");
         var3 = "";
         if(var5 && var2.length > 1) {
            var3 = var2[1];
         } else {
            var5 = false;
         }

         EntityPlayerMP var6 = getCommandSenderAsPlayer(var1);
         JRMCoreSafe var7 = new JRMCoreSafe(var6.worldObj);
         if(!var4 && !var5) {
            throw new WrongUsageException("Buildings Respawn failure", new Object[0]);
         } else {
            var7.saveSpawnList("false ", var7.OWDataDir, "edp.dbc");
            var7.saveSpawnList("false ", var7.OWDataDir, "swk.dbc");
            var7.saveSpawnList("false ", var7.dataDir, "kl.dbc");
            JRMCoreHDBC.WorldGenBuildingsSpawnCheck(FMLCommonHandler.instance().getMinecraftServerInstance());
            int[] var8 = new int[3];
            if(DBCH.genCA.contains(";")) {
               for(int var9 = 0; var9 < 3; ++var9) {
                  var8[var9] = Integer.parseInt(DBCH.genCA.split(";")[var9]);
               }
            }

            int[] var19 = new int[3];
            if(DBCH.genGH.contains(";")) {
               for(int var10 = 0; var10 < 3; ++var10) {
                  var19[var10] = Integer.parseInt(DBCH.genGH.split(";")[var10]);
               }
            }

            int[] var20 = new int[3];
            if(DBCH.genFS.contains(";")) {
               for(int var11 = 0; var11 < 3; ++var11) {
                  var20[var11] = Integer.parseInt(DBCH.genFS.split(";")[var11]);
               }
            }

            int[] var21 = new int[3];
            if(DBCH.genBS.contains(";")) {
               for(int var12 = 0; var12 < 3; ++var12) {
                  var21[var12] = Integer.parseInt(DBCH.genBS.split(";")[var12]);
               }
            }

            int[][] var22 = new int[][]{var8, var19, var20, var21};

            for(int var13 = 0; var13 < var22.length; ++var13) {
               int[] var14 = var22[var13];
               if(WorldGeneratorDB.DBbuildsdim[var13] == var6.dimension && var14.length > 2) {
                  builds var15 = WorldGeneratorDB.DBbuilds[var13];
                  var15.setWorld(var6.worldObj);
                  var15.setRespawn(true);
                  byte var16 = -1;
                  if(!var4 && var5 && var3.equals("babidi") && var13 == 3) {
                     var16 = 3;
                     int var17 = var6.worldObj.getHeightValue(var14[0] + builds.SizeX / 2, var14[2] + builds.SizeZ / 2);
                     var14[1] = var17 - builds.SizeY;
                  }

                  if(var14[0] != 0 || var14[1] != 0 || var14[2] != 0) {
                     if(var16 > -1) {
                        WorldGeneratorDB.DBbuildsSpawn(var16, true);
                        String var23 = var14[0] + ";" + var14[1] + ";" + var14[2];
                        WorldGeneratorDB.DBbuildsGen(var16, var23);
                     }

                     var15.generate(var6.worldObj, var6.worldObj.rand, var14[0], var14[1], var14[2]);
                     this.notifyAdmins(var1, StatCollector.translateToLocal(WorldGeneratorDB.DBbuildsNams2(var13)) + " has been respawned.", new Object[0]);
                  }
               }
            }

            JRMCoreHDBC.WorldGenBuildingsSpawnCheck(FMLCommonHandler.instance().getMinecraftServerInstance());
            JRMCoreHDBC.DBCCommonTickHandlerNPCSpawnCheck(var6);
            this.notifyAdmins(var1, "Buildings Respawn was Set. Now you must go close to a new chunk to activate it.", new Object[]{var6.getCommandSenderName()});
         }
      }
   }

   private void notifyAdmins(ICommandSender var1, String var2, Object[] var3) {
      func_152373_a(var1, this, var2, var3);
   }

   public String getCommandUsage(ICommandSender var1) {
      return "/dbcbuildings (respawn)";
   }
}
