package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.Npcs.EntityBarta;
import JinRyuu.DragonBC.common.Npcs.EntityBuuFat;
import JinRyuu.DragonBC.common.Npcs.EntityBuuSuper;
import JinRyuu.DragonBC.common.Npcs.EntityCell1;
import JinRyuu.DragonBC.common.Npcs.EntityCell2;
import JinRyuu.DragonBC.common.Npcs.EntityCell3;
import JinRyuu.DragonBC.common.Npcs.EntityCell4;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg16;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg17;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg18;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg19;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg20;
import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
import JinRyuu.DragonBC.common.Npcs.EntityDarbura;
import JinRyuu.DragonBC.common.Npcs.EntityDino01;
import JinRyuu.DragonBC.common.Npcs.EntityDodoria;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza1;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza2;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza3;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza4;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza5;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza6;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaFather;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaMecha;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier1;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier2;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier3;
import JinRyuu.DragonBC.common.Npcs.EntityGinyu;
import JinRyuu.DragonBC.common.Npcs.EntityGuldo;
import JinRyuu.DragonBC.common.Npcs.EntityHell01;
import JinRyuu.DragonBC.common.Npcs.EntityHell02;
import JinRyuu.DragonBC.common.Npcs.EntityJeice;
import JinRyuu.DragonBC.common.Npcs.EntityKiwi;
import JinRyuu.DragonBC.common.Npcs.EntityNamekian01;
import JinRyuu.DragonBC.common.Npcs.EntityPuipui;
import JinRyuu.DragonBC.common.Npcs.EntityRecoome;
import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan01;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan02;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyanNappa;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyanRaditz;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyanVegeta;
import JinRyuu.DragonBC.common.Npcs.EntityYakon;
import JinRyuu.DragonBC.common.Npcs.EntityZarbon;
import JinRyuu.JRMCore.JRMCoreH;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;

public class ComDbcSpawn extends CommandBase {
   public ComDbcSpawn() {
   }

   public String getCommandName() {
      return "dbcspawn";
   }

   public String getCommandUsage(ICommandSender var1) {
      return "Use \'/dbcspawn (DBCmobName)\' to spawn the DBC mobs.";
   }

   public int getRequiredPermissionLevel() {
      return 2;
   }

   public boolean canCommandSenderUseCommand(ICommandSender var1) {
      return true;
   }

   private NBTTagCompound nbt(EntityPlayer var1, String var2) {
      return JRMCoreH.nbt(var1, var2);
   }

   public void processCommand(ICommandSender var1, String[] var2) {
      if(var2.length <= 0) {
         throw new WrongUsageException("Use \'/dbcspawn (DBCmobName)\' to spawn the DBC mobs. ", new Object[0]);
      } else {
         EntityPlayerMP var3 = getCommandSenderAsPlayer(var1);
         String var4 = var2[0];
         EntityDBC[] var5 = new EntityDBC[]{new EntitySaiyanRaditz(var3.worldObj), new EntitySaiyanNappa(var3.worldObj), new EntitySaiyanVegeta(var3.worldObj), new EntitySaibaiman(var3.worldObj), new EntitySaiyan01(var3.worldObj), new EntitySaiyan02(var3.worldObj), new EntityHell01(var3.worldObj), new EntityHell02(var3.worldObj), new EntityKiwi(var3.worldObj), new EntityDodoria(var3.worldObj), new EntityZarbon(var3.worldObj), new EntityGuldo(var3.worldObj), new EntityRecoome(var3.worldObj), new EntityBarta(var3.worldObj), new EntityJeice(var3.worldObj), new EntityGinyu(var3.worldObj), new EntityFreezaSoldier1(var3.worldObj), new EntityFreezaSoldier2(var3.worldObj), new EntityFreezaSoldier3(var3.worldObj), new EntityFreeza1(var3.worldObj), new EntityFreeza2(var3.worldObj), new EntityFreeza3(var3.worldObj), new EntityFreeza4(var3.worldObj), new EntityFreeza5(var3.worldObj), new EntityFreeza6(var3.worldObj), new EntityFreezaFather(var3.worldObj), new EntityFreezaMecha(var3.worldObj), new EntityCyborg16(var3.worldObj), new EntityCyborg17(var3.worldObj), new EntityCyborg18(var3.worldObj), new EntityCyborg19(var3.worldObj), new EntityCyborg20(var3.worldObj), new EntityCell1(var3.worldObj), new EntityCell2(var3.worldObj), new EntityCell3(var3.worldObj), new EntityCell4(var3.worldObj), new EntityNamekian01(var3.worldObj), new EntityPuipui(var3.worldObj), new EntityYakon(var3.worldObj), new EntityDarbura(var3.worldObj), new EntityBuuFat(var3.worldObj), new EntityBuuSuper(var3.worldObj), new EntityDino01(var3.worldObj)};
         String[] var6 = new String[]{"Raditz", "Nappa", "Vegeta", "Saibaiman", "Saiyan01", "Saiyan02", "Ogre1", "Ogre2", "Kiwi", "Dodoria", "Zarbon", "Guldo", "Recoome", "Barta", "Jeice", "Ginyu", "FreezaSoldier1", "FreezaSoldier2", "FreezaSoldier3", "Freeza1", "Freeza2", "Freeza3", "Freeza4", "Freeza5", "Freeza6", "KingCold", "MechaFreeza", "Cyborg16", "Cyborg17", "Cyborg18", "Cyborg19", "Cyborg20", "Cell1", "Cell2", "Cell3", "Cell4", "Namekian01", "PuiPui", "Yakon", "Dabura", "BuuFat", "BuuSuper", "Dino01"};
         String var7 = var4.toLowerCase();
         EntityDBC var8 = null;
         boolean var9 = false;

         for(int var10 = 0; var10 < var6.length; ++var10) {
            if(var6[var10].toLowerCase().contains(var7)) {
               var8 = var5[var10];
               var8.setWorld(var3.worldObj);
               String[] var11 = DBCH.NpcSpawnLoc((int)var3.posX, (int)var3.posY, (int)var3.posZ, var3.worldObj).split(";");
               var8.setLocationAndAngles(Double.parseDouble(var11[0]), Double.parseDouble(var11[1]), Double.parseDouble(var11[2]), 0.0F, 0.0F);
               if(var8 instanceof EntityDBCEvil) {
                  ((EntityDBCEvil)var8).setSpwner(var3);
               }

               var3.worldObj.spawnEntityInWorld(var8);
               this.notifyAdmins(var1, "%s spawned %s!", new Object[]{var3.getCommandSenderName(), var6[var10]});
               var9 = true;
               break;
            }
         }

         if(!var9) {
            this.notifyAdmins(var1, "%s couldn\'t spawn %s!", new Object[]{var3.getCommandSenderName(), var7});
         }

      }
   }

   private void notifyAdmins(ICommandSender var1, String var2, Object[] var3) {
      func_152373_a(var1, this, var2, var3);
   }
}
