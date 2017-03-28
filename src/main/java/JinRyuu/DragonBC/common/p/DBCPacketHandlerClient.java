package JinRyuu.DragonBC.common.p;

import JinRyuu.DragonBC.common.DBCClientTickHandler;
import JinRyuu.DragonBC.common.Gui.DBCWishGui;
import JinRyuu.DragonBC.common.Npcs.EntityAura;
import JinRyuu.DragonBC.common.Npcs.EntityAuraRing;
import JinRyuu.JRMCore.JRMCoreH;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class DBCPacketHandlerClient {
   public DBCPacketHandlerClient() {
   }

   public void handleDBCdri(int var1, EntityPlayer var2) {
      JRMCoreH.DSpeed = var1;
      if(var1 >= 99) {
         JRMCoreH.SagaProg = var1;
      }

   }

   public void handleDBCwish(int var1, String var2, EntityPlayer var3) {
      if(var1 == 3) {
         DBCWishGui.playerlist = var2.split(";");
      }

   }

   public void handleDBCtick(int var1, EntityPlayer var2) {
      if(var1 >= 0 && var1 <= 3) {
         if(var1 == 0 || var1 == 1) {
            JRMCoreH.Senzu = var1;
         }

         if(var1 == 2 || var1 == 3) {
            JRMCoreH.Master = var1 - 2;
         }
      }

   }

   public void handleDBCspacepod1(int var1, EntityPlayer var2) {
      if(var1 >= 0 && var1 <= 3) {
         if(var1 == 0 || var1 == 1) {
            JRMCoreH.Senzu = var1;
         }

         if(var1 == 2 || var1 == 3) {
            JRMCoreH.Master = var1 - 2;
         }
      } else {
         DBCClientTickHandler.mountHelper = var1;
      }

   }

   public void handleDBCchargepart(byte var1, String var2, EntityPlayer var3) {
      EntityPlayer var4 = var3.worldObj.getPlayerEntityByName(var2);
      Random var5 = new Random();
      Object var6 = null;
      float var7 = 0.0F;
      float var8 = 0.0F;
      int var9 = 0;
      if(JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && JRMCoreH.dnn(2) && JRMCoreH.plyrs.length <= JRMCoreH.data2.length && JRMCoreH.dnn(10) && JRMCoreH.plyrs.length <= JRMCoreH.dat10.length) {
         for(int var10 = 0; var10 < JRMCoreH.plyrs.length; ++var10) {
            if(JRMCoreH.plyrs[var10].equals(var2)) {
               String[] var11 = JRMCoreH.data2[var10].split(";");
               var7 = (float)Integer.parseInt(var11[0]);
               var8 = (float)Integer.parseInt(var11[1]);
               var9 = Integer.parseInt(JRMCoreH.dat10[var10].split(";")[0]);
            }
         }
      }

      if(var1 == 1) {
         var6 = new EntityAura(var3.worldObj, var2, var8 > 0.0F?16646144:11075583, var7, var8, var9);
      }

      if(var1 == 2) {
         var6 = new EntityAura(var3.worldObj, var2, var8 > 0.0F?16646144:16701952, var7, var8, var9);
      }

      if(var1 == 3) {
         var6 = new EntityAura(var3.worldObj, var2, var8 > 0.0F?16646144:14526719, var7, var8, var9);
      }

      if(var1 == 4) {
         var6 = new EntityAura(var3.worldObj, var2, var8 > 0.0F?16646144:16646144, var7, var8, var9);
      }

      if(var1 == 5) {
         var6 = new EntityAuraRing(var3.worldObj, var2, var8 > 0.0F?16646144:11075583, var7, var8, var9);
      }

      if(var1 == 6) {
         var6 = new EntityAuraRing(var3.worldObj, var2, var8 > 0.0F?16646144:16701952, var7, var8, var9);
      }

      if(var1 == 7) {
         var6 = new EntityAuraRing(var3.worldObj, var2, var8 > 0.0F?16646144:14526719, var7, var8, var9);
      }

      if(var1 == 8) {
         var6 = new EntityAuraRing(var3.worldObj, var2, var8 > 0.0F?16646144:16646144, var7, var8, var9);
      }

      if(var1 == 9) {
         var6 = new EntityAura(var3.worldObj, var2, var8 > 0.0F?16646144:11075583, var7, var8, var9);
      }

      if(var6 != null && var4 != null) {
         ((Entity)var6).setLocationAndAngles(var4.posX - 0.0D, var4.posY - 1.6D + (double)var5.nextInt(5) * 0.03D, var4.posZ - 0.0D, var5.nextFloat(), 0.0F);
         var3.worldObj.spawnEntityInWorld((Entity)var6);
      }

   }

   public void handleDBCascend(byte var1, EntityPlayer var2) {
   }

   public void handleDBCdescend(byte var1, EntityPlayer var2) {
   }

   public void handleDBCchargesound(int var1, String var2, EntityPlayer var3) {
      this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var1), var2);
   }

   public void handleDBCjumpsound(int var1, int var2, EntityPlayer var3) {
      if(var1 == -2) {
         JRMCoreH.wishes = var2;
      }

      if(var1 == -1) {
         JRMCoreH.revTmr = var2 * 5;
      }

      if(var1 == 1) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC.jump");
      }

      if(var1 == 2) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.cbigbang");
      }

      if(var1 == 3) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "");
      }

      if(var1 == 4) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.cburning");
      }

      if(var1 == 5) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "");
      }

      if(var1 == 6) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "");
      }

      if(var1 == 7) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.ckidisc");
      }

      if(var1 == 8) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC2.finalflash_charge");
      }

      if(var1 == 9) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "");
      }

      if(var1 == 10) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.cgallitgun");
      }

      if(var1 == 11) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC.hame");
      }

      if(var1 == 12) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC.hame");
      }

      if(var1 == 13) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.cspecialbeamcannon");
      }

      if(var1 == 14) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.cmasenko");
      }

      if(var1 == 15) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC2.deathball_charge");
      }

      if(var1 == 16) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.cspiritbomb");
      }

      if(var1 == 102) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC2.bigbang_fire");
      }

      if(var1 == 103) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC2.blast");
      }

      if(var1 == 104) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.fburning");
      }

      if(var1 == 105) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC2.basicbeam_fire");
      }

      if(var1 == 106) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC2.kiball_release");
      }

      if(var1 == 107) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC2.disc_fire");
      }

      if(var1 == 108) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.ffinalflash");
      }

      if(var1 == 109) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.fingerleser");
      }

      if(var1 == 110) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.fgallitgun");
      }

      if(var1 == 111) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC.ha");
      }

      if(var1 == 112) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC.ha10x");
      }

      if(var1 == 113) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.fspecialbeamcannon");
      }

      if(var1 == 114) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.fmasenko");
      }

      if(var1 == 115) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC2.deathball_fire");
      }

      if(var1 == 116) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.fspiritbomb");
      }

      if(var1 == 300) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC3.force");
      }

      if(var1 == 1000) {
         this.soundPowerUp((EntityPlayer)var3.worldObj.getEntityByID(var2), "jinryuudragonbc:DBC2.tp");
      }

   }

   public void handleDBCascendsound(int var1, EntityPlayer var2) {
      this.soundPowerUp((EntityPlayer)var2.worldObj.getEntityByID(var1), "jinryuudragonbc:DBC.ascend");
   }

   public void handleDBCdescendsound(int var1, EntityPlayer var2) {
      this.soundPowerUp((EntityPlayer)var2.worldObj.getEntityByID(var1), "jinryuudragonbc:DBC.descend");
   }

   public void handleDBCscouter1(int var1, EntityPlayer var2) {
      this.soundPowerUp((EntityPlayer)var2.worldObj.getEntityByID(var1), "jinryuudragonbc:scouter.scouteron");
   }

   public void handleDBCscouter2(int var1, EntityPlayer var2) {
      this.soundPowerUp((EntityPlayer)var2.worldObj.getEntityByID(var1), "jinryuudragonbc:scouter.count");
   }

   public void handleDBCscouter3(int var1, EntityPlayer var2) {
      this.soundPowerUp((EntityPlayer)var2.worldObj.getEntityByID(var1), "jinryuudragonbc:scouter.warn");
   }

   public void handleDBCscouter4(int var1, EntityPlayer var2) {
      this.soundPowerUp((EntityPlayer)var2.worldObj.getEntityByID(var1), "jinryuudragonbc:scouter.startcount");
   }

   public void soundPowerUp(EntityPlayer var1, String var2) {
      if(var1 != null) {
         var1.playSound(var2, 0.25F, 1.0F);
      }

   }

   public void closeInventoryChange(EntityPlayer var1) {
      var1.inventory.inventoryChanged = false;
   }

   public void closeInventoryChange(EntityPlayerMP var1) {
      var1.inventory.inventoryChanged = false;
   }
}
