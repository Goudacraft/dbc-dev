package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.DragonBC.common.DBCClientTickHandler;
import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.Entitys.EntityEnergyFM;
import JinRyuu.DragonBC.common.Npcs.EntityAura;
import JinRyuu.DragonBC.common.Npcs.EntityAuraRing;
import JinRyuu.DragonBC.common.p.DBCPascend;
import JinRyuu.DragonBC.common.p.DBCPascendsound;
import JinRyuu.DragonBC.common.p.DBCPchargesound;
import JinRyuu.DragonBC.common.p.DBCPdescend;
import JinRyuu.DragonBC.common.p.DBCPdescendsound;
import JinRyuu.DragonBC.common.p.DBCPduo;
import JinRyuu.DragonBC.common.p.DBCPenergy;
import JinRyuu.JRMCore.JRMCoreCliTicH;
import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHDBC;
import JinRyuu.JRMCore.JRMCoreKeyHandler;
import JinRyuu.JRMCore.p.JRMCorePTri;
import JinRyuu.JRMCore.p.PD;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import java.util.List;
import java.util.Random;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class DBCKiTech {
   public static int ascend = 0;
   public static int pup = 0;
   public static int pup2 = 0;
   public static int ptime = 0;
   public static int inSuperTime = 0;
   private static int time = 0;
   private static int time2 = 0;
   private static int time3 = 0;
   private static int partnorm = 0;
   private static int power = 0;
   private static int jump;
   public static boolean jumping = false;
   public static boolean jumpRel = false;
   public static boolean floating = false;
   public static boolean releasing = false;
   public static boolean ascending = false;
   public static boolean ascendingK = false;
   private static float sec = 0.0F;
   public static float flyY = 0.0F;
   public static int floatTime = 0;
   public static boolean floatMultAdded = false;
   private static boolean dodge_forwDash_STE;
   private static float sent;
   public static int tickTime = 0;
   public static int prevTickTime = 0;
   public static int dash = 0;
   public static float dodge_recently;
   public static boolean dodge_forwHold;
   public static boolean dodge_forwDash;
   public static boolean turbo = false;
   public static int ton = 0;

   public DBCKiTech() {
   }

   public static void ChargeKi() {
      ++partnorm;
      if(partnorm >= 5) {
         partnorm = 0;
         chargePart(false);
      }

      ++power;
      if(power >= (int)(JRMCoreH.State == 10 && JRMCoreH.State2 > 0?JRMCoreCliTicH.counterValue * 3.0F:JRMCoreCliTicH.counterValue * 2.5F)) {
         power = 0;
         chargePart(true);
      }

      boolean var0 = JRMCoreKeyHandler.KiCharge.getIsKeyPressed() && !JRMCoreKeyHandler.KiAscend.getIsKeyPressed() && !JRMCoreH.StusEfctsMe(11);
      if(var0) {
         if(!releasing) {
            releasing = true;
            JRMCoreH.Skll((byte)5, (byte)0, (byte)4);
         }
      } else if(releasing) {
         releasing = false;
         JRMCoreH.Skll((byte)5, (byte)1, (byte)4);
      }

      if(var0) {
         EntityClientPlayerMP var1 = DBCClient.mc.thePlayer;
         ++time;
         ++time2;
         ++time3;
         if(!JRMCoreKeyHandler.Fn.getIsKeyPressed() || (JRMCoreH.Race == 0 || JRMCoreH.Race == 3) && JRMCoreH.State > 0) {
            if(JRMCoreH.curRelease < 50 + JRMCoreH.SklLvl(5, (byte)1) * 5 && time >= (JRMCoreH.curRelease >= 50?(turbo?15:30):(turbo?5:10))) {
               time = 0;
               float var2 = 100.0F / (float)JRMCoreH.maxEnergy * (float)JRMCoreH.curEnergy;
               float var3 = (float)JRMCoreH.curRelease;
               var2 = var2 > 75.0F?75.0F:var2;
               if(var3 >= 50.0F) {
                  if(var3 - 50.0F >= (var2 - 50.0F) * 2.0F) {
                     return;
                  }
               } else if(var3 >= (var2 <= 10.0F?var2 * 5.0F:50.0F)) {
                  return;
               }

               JRMCoreH.Rls((byte)1);
            }
         } else if(time3 >= 10) {
            time3 = 0;
            JRMCoreH.Rls((byte)2);
         }
      }

   }

   public static void fall(EntityPlayer var0) {
      for(var0.fallDistance = 0.0F; ForgeHooks.onLivingUpdate(var0); var0.fallDistance = 0.0F) {
         ;
      }

   }

   public static void JumpKi(KeyBinding var0) {
      EntityClientPlayerMP var1 = DBCClient.mc.thePlayer;
      float var2 = turbo?1.0F:0.7F;
      float var3 = (float)JRMCoreH.SklLvl(1, (byte)1);
      float var4 = 0.72F;
      float var5 = 0.3F + 0.05F * var3 + (float)(JRMCoreH.PlyrAttrbts((EntityPlayer)null)[1] / JRMCoreConfig.attrMx) * 0.2F;
      float var6 = (float)JRMCoreH.curRelease * 0.01F;
      float var7 = var4 * var5 * var2 * var6;
      int var8 = 1 + (int)(var7 * 30.0F);
      boolean var9 = true;
      if(JRMCoreH.curEnergy < var8) {
         var9 = false;
      }

      boolean var10 = JRMCoreConfig.releaseStop?!releasing:true;
      if(var0.getIsKeyPressed() && !var10) {
         KeyBinding.setKeyBindState(var0.getKeyCode(), false);
         if(JRMCoreClient.mc.thePlayer.motionY > 0.0D) {
            JRMCoreClient.mc.thePlayer.motionY = 0.0D;
         }
      }

      if(var0.getIsKeyPressed() && var10 && !jumpRel && var9) {
         jumping = true;
         if(jump >= 10) {
            jumping = false;
         }

         if(jump >= 1 && jump < 10 && jump / 3 * 3 == jump) {
            JRMCoreH.Cost((short)var8);
         }

         if(jumping) {
            DBCClient.mc.thePlayer.motionY += 0.05D + (double)var7;
         }
      } else {
         jumpRel = true;
      }

      if(!jumpRel && !floating) {
         ++jump;
         if(jump == 4) {
            JRMCoreH.KAsounds(var1, 0);
         }
      }

      if(var1.onGround) {
         jump = 0;
         jumpRel = false;
      }

   }

   public static long dtap1() {
      return System.currentTimeMillis() + 50L;
   }

   public static long dtap4() {
      return System.currentTimeMillis() + 250L;
   }

   public static void FloatKi(KeyBinding var0, KeyBinding var1, KeyBinding var2) {
      EntityClientPlayerMP var3 = DBCClient.mc.thePlayer;
      int var4 = JRMCoreH.SklLvl(3, (byte)1);
      float var5 = JRMCoreH.statInc(JRMCoreH.Pwrtyp, 11, 100, JRMCoreH.Race, JRMCoreH.Class, 0.0F) * 0.01F;
      float var6 = JRMCoreH.spdFrm(JRMCoreH.PlyrAttrbts((EntityPlayer)null)[4], var4, (float)JRMCoreH.curRelease, turbo, true, JRMCoreH.State, JRMCoreH.State2, var5);
      boolean var7 = JRMCoreClient.mc.gameSettings.keyBindForward.isPressed();
      boolean var8 = JRMCoreClient.mc.gameSettings.keyBindForward.getIsKeyPressed();
      if(JRMCoreClient.mc.gameSettings.keyBindForward.getIsKeyPressed() && !JRMCoreClient.mc.thePlayer.onGround) {
         dodge_forwHold = true;
      } else {
         dodge_forwHold = false;
         dodge_forwDash = false;
      }

      if(dodge_forwHold) {
         ;
      }

      int[] var9 = JRMCoreH.PlyrAttrbts();
      byte var10 = JRMCoreH.Pwrtyp;
      byte var11 = JRMCoreH.Race;
      byte var12 = JRMCoreH.Class;
      int var13 = JRMCoreH.stat(var10, 3, var9[2], var11, var12, 0.0F);
      int var14 = JRMCoreH.curStamina;
      int var15 = (int)((float)var13 * (0.2F - (float)var4 * 0.005F));
      boolean var16 = !JRMCoreH.PlyrSettings(2);
      if(var14 > var15 && var4 > 0 && var16) {
         if((var7 || dodge_forwDash) && !var3.onGround && (dodge_forwDash || JRMCoreCliTicH.getDT(JRMCoreClient.mc.gameSettings.keyBindForward))) {
            if(!dodge_forwDash_STE) {
               dodge_forwDash_STE = true;
            }

            if(floating) {
               floating = false;
            }

            dodge_forwDash = true;
            float var17 = var6 * 1.5F;
            float var18 = JRMCoreH.weightPerc(1);
            var17 = var17 * var18;
            double var19 = (double)(-MathHelper.sin(var3.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(var3.rotationPitch / 180.0F * 3.1415927F));
            double var21 = (double)(MathHelper.cos(var3.rotationYaw / 180.0F * 3.1415927F) * MathHelper.cos(var3.rotationPitch / 180.0F * 3.1415927F));
            double var23 = (double)(-MathHelper.sin(var3.rotationPitch / 180.0F * 3.1415927F));
            setThrowableHeading(var3, var19, var23, var21, var17, 0.0F);
            if(sec <= 0.0F || var7) {
               sec = JRMCoreCliTicH.counterValue;
               triForce(4, 0, var7?5:4);
               chargePart(false);
            }
         }

         if(dodge_forwDash_STE && !dodge_forwDash) {
            dodge_forwDash_STE = false;
            floating = true;
         }
      } else if(dodge_forwDash) {
         dodge_forwDash = false;
         if(dodge_forwDash_STE) {
            dodge_forwDash_STE = false;
            floating = true;
         }
      }

      if(sec > 0.0F) {
         --sec;
      }

      boolean var35 = JRMCoreH.StusEfctsMe(7);
      if(var35 && !dodge_forwDash_STE && sent <= 0.0F) {
         sent = JRMCoreCliTicH.counterValue * 0.5F;
         JRMCoreH.Skll((byte)5, (byte)1, (byte)7);
      } else if(!var35 && dodge_forwDash_STE && sent <= 0.0F) {
         sent = JRMCoreCliTicH.counterValue * 0.5F;
         JRMCoreH.Skll((byte)5, (byte)0, (byte)7);
      } else if(sent > 0.0F && sent <= 1.0F && !var35 && !dodge_forwDash_STE) {
         sent = 0.0F;
      } else if(sent > 0.0F && sent <= 1.0F && var35 && dodge_forwDash_STE) {
         sent = 0.0F;
      }

      if(sent > 0.0F) {
         --sent;
      }

      int var36 = (int)(1.0F + var6);
      boolean var37 = true;
      boolean var20 = var4 == 0;
      if(DBCConfig.flyAnyLvl) {
         var20 = false;
      }

      if(JRMCoreH.curEnergy < var36 || var20) {
         var37 = false;
      }

      if(DBCConfig.oldFly) {
         if(var0.getIsKeyPressed() || JRMCoreKeyHandler.Fn.getIsKeyPressed() && var0.getIsKeyPressed() && var37) {
            ++floatTime;
            if(floatTime >= 20) {
               JRMCoreH.Cost((short)var36);
               floatTime = 0;
            }

            if(JRMCoreKeyHandler.Fn.getIsKeyPressed()) {
               DBCClient.mc.thePlayer.motionY /= 15.15D;
            } else {
               DBCClient.mc.thePlayer.motionY = (double)(0.6F * var6);
            }

            float var38 = var3.moveStrafing;
            float var22 = var3.moveForward;
            if(!DBCClient.mc.gameSettings.keyBindForward.getIsKeyPressed() && !DBCClient.mc.gameSettings.keyBindBack.getIsKeyPressed() && !DBCClient.mc.gameSettings.keyBindLeft.getIsKeyPressed() && !DBCClient.mc.gameSettings.keyBindRight.getIsKeyPressed()) {
               var3.motionX = 0.0D;
               var3.motionZ = 0.0D;
               floatMultAdded = false;
            } else {
               mv(var38, var22, var3, var6);
               floatMultAdded = true;
            }
         }
      } else {
         if(var0.getIsKeyPressed()) {
            KeyBinding.setKeyBindState(var0.getKeyCode(), false);
            if(!floating && var37) {
               floating = true;
            } else if(floating) {
               floating = false;
               floatMultAdded = false;
            }
         }

         if(floating && var37 && !var3.onGround) {
            ++floatTime;
            if(floatTime >= 20) {
               JRMCoreH.Cost((short)var36);
               floatTime = 0;
            }

            if(var1.getIsKeyPressed()) {
               jumpRel = true;
               DBCClient.mc.thePlayer.motionY = (double)(0.6F * var6);
            } else if(var2.getIsKeyPressed()) {
               if(DBCClient.mc.thePlayer.motionY > (double)(-(0.6F * var6))) {
                  DBCClient.mc.thePlayer.motionY = (double)(-(0.6F * var6));
               }
            } else if(var3.motionY < 0.0D) {
               DBCClient.mc.thePlayer.motionY /= 15.15D;
            }

            float var39 = var3.moveStrafing;
            float var40 = var3.moveForward;
            if(!DBCClient.mc.gameSettings.keyBindForward.getIsKeyPressed() && !DBCClient.mc.gameSettings.keyBindBack.getIsKeyPressed() && !DBCClient.mc.gameSettings.keyBindLeft.getIsKeyPressed() && !DBCClient.mc.gameSettings.keyBindRight.getIsKeyPressed()) {
               var3.motionX = 0.0D;
               var3.motionZ = 0.0D;
               floatMultAdded = false;
            } else {
               if(JRMCoreH.StusEfctsMe(9) && !JRMCoreH.StusEfctsMe(4) && !DBCClient.mc.gameSettings.keyBindBack.getIsKeyPressed() && !DBCClient.mc.gameSettings.keyBindLeft.getIsKeyPressed() && !DBCClient.mc.gameSettings.keyBindRight.getIsKeyPressed()) {
                  float var24 = JRMCoreH.weightPerc(1);
                  float var41 = var6 * var24;
                  byte var25 = 0;
                  byte var26 = 0;
                  byte var27 = 0;
                  double var28 = (double)(-MathHelper.sin((var3.rotationYaw + (float)var25 + (float)var27 + (float)var26) / 180.0F * 3.1415927F) * MathHelper.cos(var3.rotationPitch / 180.0F * 3.1415927F));
                  double var30 = (double)(MathHelper.cos((var3.rotationYaw + (float)var25 + (float)var27 + (float)var26) / 180.0F * 3.1415927F) * MathHelper.cos(var3.rotationPitch / 180.0F * 3.1415927F));
                  double var32 = (double)(-MathHelper.sin((var3.rotationPitch + (float)var25) / 180.0F * 3.1415927F));
                  setThrowableHeading(var3, var28, var32, var30, var41, 0.0F);
               } else {
                  mv(var39, var40, var3, var6);
               }

               floatMultAdded = true;
            }
         }

         if(floating && var3.onGround) {
            floating = false;
            floatMultAdded = false;
         }
      }

   }

   public static void mv(float var0, float var1, EntityPlayer var2, float var3) {
      float var4 = var0 * var0 + var1 * var1;
      if(var4 >= 1.0E-4F) {
         var4 = MathHelper.sqrt_float(var4);
         if(var4 < 1.0F) {
            var4 = 1.0F;
         }

         var4 = var3 / var4;
         float var5 = MathHelper.sin(var2.rotationYaw * 3.1415927F / 180.0F);
         float var6 = MathHelper.cos(var2.rotationYaw * 3.1415927F / 180.0F);
         float var7 = MathHelper.sin(var2.rotationPitch * 3.1415927F / 180.0F);
         float var8 = 1.0F - (var7 < 0.0F?-var7:var7);
         var0 = var0 * var4;
         var1 = var1 * var4;
         float var9 = var2.onGround?0.25F:0.25F;
         var2.motionX = (double)((var0 * var6 - var1 * var5) * var9);
         var2.motionZ = (double)((var1 * var6 + var0 * var5) * var9);
      }

   }

   public static void DashKi(boolean var0) {
      EntityClientPlayerMP var1 = DBCClient.mc.thePlayer;
      WorldClient var2 = DBCClient.mc.theWorld;
      int var3 = JRMCoreH.SklLvl(2, (byte)1);
      float var4 = JRMCoreH.statInc(JRMCoreH.Pwrtyp, 7, 100, JRMCoreH.Race, JRMCoreH.Class, 0.0F) * 0.01F;
      float var5 = JRMCoreH.spdFrm(JRMCoreH.PlyrAttrbts((EntityPlayer)null)[1], var3, (float)JRMCoreH.curRelease, turbo, false, JRMCoreH.State, JRMCoreH.State2, var4);
      int var6 = (int)(1.0F + var5);
      int[] var7 = JRMCoreH.PlyrAttrbts();
      byte var8 = JRMCoreH.Pwrtyp;
      byte var9 = JRMCoreH.Race;
      byte var10 = JRMCoreH.Class;
      int var11 = JRMCoreH.stat(var8, 3, var7[2], var9, var10, 0.0F);
      int var12 = JRMCoreH.curStamina;
      int var13 = (int)((float)var11 * 0.2F - (float)var3 * 0.01F);
      if(dodge_recently > 0.0F) {
         --dodge_recently;
      }

      boolean var14 = JRMCoreClient.mc.gameSettings.keyBindLeft.isPressed();
      boolean var15 = JRMCoreClient.mc.gameSettings.keyBindRight.isPressed();
      boolean var16 = JRMCoreClient.mc.gameSettings.keyBindBack.isPressed();
      boolean var17 = !JRMCoreH.PlyrSettings(2);
      if(var12 > var13 && var3 > 0 && dodge_recently <= 0.0F && var17 && JRMCoreH.curRelease > 0) {
         if(var14 && JRMCoreCliTicH.getDT(JRMCoreClient.mc.gameSettings.keyBindLeft)) {
            dodge_recently = JRMCoreCliTicH.counterValue;
            double var18 = Math.cos((double)(JRMCoreClient.mc.thePlayer.rotationYaw - 90.0F) * 3.141592653589793D / 180.0D) * 1.5D;
            double var20 = Math.sin((double)(JRMCoreClient.mc.thePlayer.rotationYaw - 90.0F) * 3.141592653589793D / 180.0D) * -1.5D;
            JRMCoreClient.mc.thePlayer.motionZ = var18;
            JRMCoreClient.mc.thePlayer.motionX = var20;
            triForce(4, 0, 0);
         }

         if(var15 && JRMCoreCliTicH.getDT(JRMCoreClient.mc.gameSettings.keyBindRight)) {
            dodge_recently = JRMCoreCliTicH.counterValue;
            double var27 = Math.cos((double)(JRMCoreClient.mc.thePlayer.rotationYaw + 90.0F) * 3.141592653589793D / 180.0D) * 1.5D;
            double var30 = Math.sin((double)(JRMCoreClient.mc.thePlayer.rotationYaw + 90.0F) * 3.141592653589793D / 180.0D) * -1.5D;
            JRMCoreClient.mc.thePlayer.motionZ = var27;
            JRMCoreClient.mc.thePlayer.motionX = var30;
            triForce(4, 0, 1);
         }

         if(var16 && JRMCoreCliTicH.getDT(JRMCoreClient.mc.gameSettings.keyBindBack)) {
            dodge_recently = JRMCoreCliTicH.counterValue;
            double var28 = Math.cos((double)JRMCoreClient.mc.thePlayer.rotationYaw * 3.141592653589793D / 180.0D) * -1.0D;
            double var31 = Math.sin((double)JRMCoreClient.mc.thePlayer.rotationYaw * 3.141592653589793D / 180.0D) * 1.0D;
            JRMCoreClient.mc.thePlayer.motionZ = var28;
            JRMCoreClient.mc.thePlayer.motionX = var31;
            triForce(4, 0, 3);
         }
      }

      boolean var29 = true;
      if(JRMCoreH.curEnergy < var6 || dodge_forwDash) {
         var29 = false;
      }

      if(var29 && var0 && !floating && JRMCoreH.curRelease > 0) {
         ++dash;
         if(dash >= 20) {
            JRMCoreH.Cost((short)var6);
            dash = 0;
         }

         double var19 = var1.posX;
         double var21 = var1.posY;
         double var23 = var1.posZ;
         if(var2.getBlock((int)var19, (int)var21 - 2, (int)var23) != Blocks.ice) {
            float var25 = var1.moveStrafing;
            float var26 = var1.moveForward;
            if(!DBCClient.mc.gameSettings.keyBindForward.getIsKeyPressed() && !DBCClient.mc.gameSettings.keyBindBack.getIsKeyPressed() && !DBCClient.mc.gameSettings.keyBindLeft.getIsKeyPressed() && !DBCClient.mc.gameSettings.keyBindRight.getIsKeyPressed()) {
               var1.motionX = 0.0D;
               var1.motionZ = 0.0D;
               floatMultAdded = false;
            } else {
               mv(var25, var26, var1, var5);
               floatMultAdded = true;
            }
         }
      }

   }

   public static void setThrowableHeading(Entity var0, double var1, double var3, double var5, float var7, float var8) {
      Random var9 = var0.worldObj.rand;
      var1 = var1 * (double)var7;
      var3 = var3 * (double)var7;
      var5 = var5 * (double)var7;
      float var10 = var0.onGround?0.25F:0.25F;
      var0.motionX = var1 * (double)var10;
      var0.motionY = var3 * (double)var10;
      var0.motionZ = var5 * (double)var10;
   }

   public static void TurboMode(KeyBinding var0) {
      EntityClientPlayerMP var1 = DBCClient.mc.thePlayer;
      if(var0.getIsKeyPressed()) {
         KeyBinding.setKeyBindState(var0.getKeyCode(), false);
         if(!turbo) {
            turbo = true;
            JRMCoreH.Skll((byte)5, (byte)0, (byte)3);
            JRMCoreH.jrmct(3);
         } else if(turbo) {
            turbo = false;
            JRMCoreH.Skll((byte)5, (byte)1, (byte)3);
            JRMCoreH.jrmct(3);
         }
      }

      if(JRMCoreH.curEnergy <= 0) {
         turbo = false;
         ++ton;
         if(ton > 10) {
            JRMCoreH.Skll((byte)5, (byte)1, (byte)3);
            JRMCoreH.jrmct(3);
            ton = 0;
         }
      }

   }

   public static void EnAt(byte var0) {
      PD.sendToServer(new DBCPenergy(var0, (byte)0));
   }

   public static void EnAt(byte var0, byte var1) {
      PD.sendToServer(new DBCPenergy(var0, var1));
   }

   public static void EnAtSlct(byte var0) {
      byte var1 = JRMCoreH.EnAtSlct;
      JRMCoreH.EnAtSlct = (byte)(var1 + (var0 == 1?-1:1));
      if(JRMCoreH.EnAtSlct > (JRMCoreH.mrAtts?7:3)) {
         JRMCoreH.EnAtSlct = 0;
      } else if(JRMCoreH.EnAtSlct < 0) {
         JRMCoreH.EnAtSlct = (byte)(JRMCoreH.mrAtts?7:3);
      }

   }

   public static boolean KAkiEn(byte var0, byte var1, byte var2) {
      String[] var3 = JRMCoreH.tech(var0);
      short var4 = (short)(JRMCoreH.maxEnergy + 1);
      if(var3 != null) {
         if(var0 < 4) {
            var4 = (short)((int)((float)(JRMCoreH.costEnAt(var3) * var1) * 0.02F * (float)var2 * 0.02F));
         } else {
            var4 = (short)((int)((float)(Short.parseShort(var3[7]) * var1) * 0.02F * (float)var2 * 0.02F * (float)(JRMCoreH.State + 1)));
         }

         if(JRMCoreH.curEnergy >= var4) {
            return JRMCoreH.curEnergy >= var4;
         }

         DBCClientTickHandler.nuller();
         KeyBinding var10000 = DBCClient.mc.gameSettings.keyBindUseItem;
         KeyBinding.setKeyBindState(DBCClient.mc.gameSettings.keyBindUseItem.getKeyCode(), false);
      }

      return false;
   }

   public static void Ascend(KeyBinding var0) {
      boolean var1 = false;
      boolean var2 = DBCClient.mc.thePlayer.rotationPitch <= -90.0F;
      if(var2) {
         short var3 = 200;
         EntityClientPlayerMP var4 = DBCClient.mc.thePlayer;
         AxisAlignedBB var5 = AxisAlignedBB.getBoundingBox(var4.posX - (double)var3, 200.0D, var4.posZ - (double)var3, var4.posX + (double)var3, 255.0D, var4.posZ + (double)var3);
         List var6 = var4.worldObj.getEntitiesWithinAABB(EntityEnergyFM.class, var5);
         boolean var7 = !var6.isEmpty();
         boolean var8 = JRMCoreH.StusEfctsMe(8) || var7;
         boolean var9 = JRMCoreH.tailHas(JRMCoreH.TlMd);
         boolean var10 = false;

         for(int var11 = (int)var4.posY; var11 < 256; ++var11) {
            int var12 = (int)var4.posX;
            int var13 = (int)var4.posZ;
            var10 = DBCClient.mc.theWorld.isAirBlock(var12 < 0?var12 - 1:var12, var11, var13 < 0?var13 - 1:var13);
            if(!var10) {
               break;
            }
         }

         var1 = var10 && var9 && JRMCoreH.State == 0 && JRMCoreH.rSai(JRMCoreH.Race) && var8 && var2;
      }

      boolean var14 = var1?true:var0.getIsKeyPressed();
      boolean var15 = JRMCoreH.PlyrSettings.contains(JRMCoreH.PlyrSttngs[0]);
      if(var0.getIsKeyPressed() && JRMCoreH.PlyrSettings(4) && !JRMCoreH.StusEfctsMe(10) && !JRMCoreH.StusEfctsMe(11)) {
         if(var0.isPressed() && JRMCoreH.PlyrSettings(4)) {
            String var18 = "jinryuudragonbc:DBC.fusestrt";
            soundAsc(var18);
         }

         ++ptime;
         byte var19 = 12;
         if(ptime >= var19) {
            ptime = 0;
            JRMCoreH.Cost(1);
            byte var24 = 10;
            var24 = var24 > 100?100:var24;
            triForce(1, 0, var24);
         }

         ++ascend;
         byte var26 = 10;
         if(ascend >= var26 && JRMCoreH.TransSaiCurRg >= 100) {
            Ascndng();
            JRMCoreH.Rls((byte)1);
            ascend = 0;
            ptime = 0;
            partnorm = 0;
            pup = 0;
            pup2 = 0;
         }
      } else if(var15 && !var1) {
         boolean var17 = var14 && (float)JRMCoreH.curBody > (float)JRMCoreH.maxBody * 0.05F && JRMCoreH.SklLvl(8) > JRMCoreH.State2 && JRMCoreH.State2 < JRMCoreH.TransKaiDmg.length - 1;
         if(var17) {
            if(!ascendingK) {
               ascendingK = true;
               JRMCoreH.Skll((byte)5, (byte)0, (byte)5);
            }
         } else if(ascendingK) {
            ascendingK = false;
            JRMCoreH.Skll((byte)5, (byte)1, (byte)5);
         } else if(ascending) {
            ascending = false;
            JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
         }

         if(var17) {
            ++pup;
            ++pup2;
            if(pup >= 33 || pup2 == 1) {
               soundAsc(2);
               pup = 0;
            }

            ++ascend;
            boolean var23 = true;
            if(ascend >= 20 + (10 - JRMCoreH.SklLvl(8)) * 10) {
               Ascndng();
               boolean var34 = JRMCoreH.State2 > 0 || JRMCoreH.StusEfctsMe(5);
               String var47 = "jinryuudragonbc:DBC3.force";
               if(var34 && JRMCoreH.race_saiyan(JRMCoreH.Race) && JRMCoreH.State == 10) {
                  var47 = "jinryuudragonbc:1610.aurabks";
               }

               soundAsc(var47);
               ascend = 0;
               ptime = 0;
               partnorm = 0;
               pup = 0;
               pup2 = 0;
            }
         } else if(!var14) {
            ascend = 0;
         }
      } else {
         boolean var16 = false;
         if(var14 && JRMCoreH.Race == 4 && JRMCoreH.PlyrSkillX != null && JRMCoreH.curEnergy > 1 && JRMCoreH.State != 5 && JRMCoreH.State != 6) {
            if(JRMCoreH.PlyrSkillX.contains("TR")) {
               int var22 = Integer.parseInt(JRMCoreH.PlyrSkillX.replaceAll("TR", ""));
               if(JRMCoreH.State < 4 || var22 >= 3 && JRMCoreH.State == 4) {
                  if(DBCClient.mc.thePlayer.motionX >= 0.05D || DBCClient.mc.thePlayer.motionZ >= 0.05D || DBCClient.mc.thePlayer.motionX <= -0.05D || DBCClient.mc.thePlayer.motionZ <= -0.05D) {
                     return;
                  }

                  var16 = true;
                  ++time;
                  if(JRMCoreH.curRelease < 50 && time >= 10) {
                     label697: {
                        time = 0;
                        float var31 = 100.0F / (float)JRMCoreH.maxEnergy * (float)JRMCoreH.curEnergy;
                        float var43 = (float)JRMCoreH.curRelease;
                        var31 = var31 > 75.0F?75.0F:var31;
                        if(var43 >= 50.0F) {
                           if(var43 - 50.0F >= (var31 - 50.0F) * 2.0F) {
                              break label697;
                           }
                        } else if(var43 >= (var31 <= 10.0F?var31 * 5.0F:50.0F)) {
                           break label697;
                        }

                        JRMCoreH.Rls((byte)1);
                     }
                  }

                  ++pup;
                  ++pup2;
                  if(pup >= 33 || pup2 == 1) {
                     soundAsc(2);
                     pup = 0;
                  }

                  ++ptime;
                  int var33 = var22 >= 3?10:(var22 >= 2?13:15);
                  if(ptime >= var33) {
                     ptime = 0;
                     JRMCoreH.Cost(1);
                     int var44 = (var22 >= 3?15:(var22 >= 2?10:5)) * (JRMCoreH.State > 3?1:4);
                     var44 = var44 > 100?100:var44;
                     triForce(1, 0, var44);
                  }

                  ++ascend;
                  byte var46 = 10;
                  if(ascend >= var46 && JRMCoreH.TransSaiCurRg >= 100) {
                     Ascndng();
                     soundAsc(4);
                     var16 = true;
                     ascend = 0;
                     ptime = 0;
                     partnorm = 0;
                     pup = 0;
                     pup2 = 0;
                     JRMCoreH.kiInSuper = var22 >= 2?2:1;
                  }
               }
            }
         } else if(var14 && JRMCoreH.race_saiyan(JRMCoreH.Race) && JRMCoreH.PlyrSkillX != null && JRMCoreH.curEnergy > 1 && JRMCoreH.State != 3 && JRMCoreH.State != 6) {
            if(JRMCoreH.PlyrSkillX.contains("TR")) {
               int var21 = Integer.parseInt(JRMCoreH.PlyrSkillX.replaceAll("TR", ""));
               boolean var30 = var21 >= 1 && JRMCoreH.State == 7;
               if(var1 || var30 || var21 >= 1 && (JRMCoreH.State < var21 || JRMCoreH.State == 4 && 1 < var21)) {
                  if(DBCClient.mc.thePlayer.motionX >= 0.05D || DBCClient.mc.thePlayer.motionZ >= 0.05D || DBCClient.mc.thePlayer.motionX <= -0.05D || DBCClient.mc.thePlayer.motionZ <= -0.05D) {
                     return;
                  }

                  var16 = true;
                  ++time;
                  if(JRMCoreH.curRelease < 50 && time >= 10) {
                     label1237: {
                        time = 0;
                        float var39 = 100.0F / (float)JRMCoreH.maxEnergy * (float)JRMCoreH.curEnergy;
                        float var48 = (float)JRMCoreH.curRelease;
                        var39 = var39 > 75.0F?75.0F:var39;
                        if(var48 >= 50.0F) {
                           if(var48 - 50.0F >= (var39 - 50.0F) * 2.0F) {
                              break label1237;
                           }
                        } else if(var48 >= (var39 <= 10.0F?var39 * 5.0F:50.0F)) {
                           break label1237;
                        }

                        JRMCoreH.Rls((byte)1);
                     }
                  }

                  ++pup;
                  ++pup2;
                  if(pup >= 33 || pup2 == 1) {
                     String var41 = "jinryuudragonbc:DBC.aura";
                     if(JRMCoreH.race_saiyan(JRMCoreH.Race) && JRMCoreH.PlyrSettings(3) && !var1 && JRMCoreH.State == 0) {
                        var41 = "jinryuudragonbc:1610.aurab";
                     }

                     soundAsc(var41);
                     pup = 0;
                  }

                  ++ptime;
                  int var42 = var1?5:(var21 >= 3?5:(var21 >= 2?7:10));
                  if(ptime >= var42) {
                     ptime = 0;
                     JRMCoreH.Cost(1);
                     int var49 = var1?15:(var30?5:(var21 >= 4?15:(var21 >= 2?10:5)));
                     var49 = var49 > 100?100:var49;
                     triForce(1, 0, var49);
                  }

                  ++ascend;
                  byte var51 = 10;
                  if(ascend >= var51 && JRMCoreH.TransSaiCurRg >= 100) {
                     Ascndng();
                     String var52 = "jinryuudragonbc:DBC.ascend";
                     var52 = "jinryuudragonbc:1610.sss";
                     soundAsc(var52);
                     var16 = true;
                     ascend = 0;
                     ptime = 0;
                     partnorm = 0;
                     pup = 0;
                     pup2 = 0;
                     JRMCoreH.kiInSuper = var21 >= 2?2:1;
                  }
               }
            }
         } else if(var14 && JRMCoreH.race_humanNamek(JRMCoreH.Race) && JRMCoreH.PlyrSkillX != null && JRMCoreH.curEnergy > 1 && JRMCoreH.State == 0) {
            if(JRMCoreH.PlyrSkillX.contains("TR")) {
               int var20 = Integer.parseInt(JRMCoreH.PlyrSkillX.replaceAll("TR", ""));
               if(var20 != 0 && var20 >= 1) {
                  if(DBCClient.mc.thePlayer.motionX >= 0.05D || DBCClient.mc.thePlayer.motionZ >= 0.05D || DBCClient.mc.thePlayer.motionX <= -0.05D || DBCClient.mc.thePlayer.motionZ <= -0.05D) {
                     return;
                  }

                  var16 = true;
                  ++time;
                  if(time >= 7) {
                     label1777: {
                        time = 0;
                        float var27 = 100.0F / (float)JRMCoreH.maxEnergy * (float)JRMCoreH.curEnergy;
                        float var35 = (float)JRMCoreH.curRelease;
                        var27 = var27 > 75.0F?75.0F:var27;
                        if(var35 >= 50.0F) {
                           if(var35 - 50.0F >= (var27 - 50.0F) * 2.0F) {
                              break label1777;
                           }
                        } else if(var35 >= (var27 <= 10.0F?var27 * 5.0F:50.0F)) {
                           break label1777;
                        }

                        JRMCoreH.Rls((byte)1);
                     }
                  }

                  ++pup;
                  ++pup2;
                  if(pup >= 33 || pup2 == 1) {
                     soundAsc(2);
                     pup = 0;
                  }

                  ++ptime;
                  int var29 = var20 >= 3?5:(var20 >= 2?7:10);
                  if(ptime >= var29) {
                     ptime = 0;
                     JRMCoreH.Cost(1);
                     int var36 = (var20 >= 3?15:(var20 >= 2?10:5)) * 2;
                     var36 = var36 > 100?100:var36;
                     triForce(1, 0, var36);
                  }

                  ++ascend;
                  byte var38 = 10;
                  if(ascend >= var38 && JRMCoreH.TransSaiCurRg >= 100) {
                     Ascndng();
                     soundAsc(4);
                     var16 = true;
                     ascend = 0;
                     ptime = 0;
                     partnorm = 0;
                     pup = 0;
                     pup2 = 0;
                  }
               }
            }
         } else if(JRMCoreH.TransSaiCurRg > 0) {
            ++ptime;
            if(ptime >= 40) {
               triForce(1, 1, 100);
               ptime = 0;
            }
         }

         if(var16) {
            if(!ascending) {
               ascending = true;
               JRMCoreH.Skll((byte)5, (byte)0, (byte)1);
            }
         } else if(ascending) {
            ascending = false;
            JRMCoreH.Skll((byte)5, (byte)1, (byte)1);
         } else if(ascendingK) {
            ascendingK = false;
            JRMCoreH.Skll((byte)5, (byte)1, (byte)5);
         }
      }

      if(JRMCoreH.State2 > 0 && !JRMCoreKeyHandler.KiCharge.getIsKeyPressed() && !var14 && !ascendingK) {
         ascendingK = true;
         JRMCoreH.Skll((byte)5, (byte)0, (byte)5);
      }

   }

   public static void ssj2() {
      ++pup;
      JRMCoreH.kiInSuper = 2;
      if(pup == 50) {
         pup = 0;
      }

   }

   public static void Descend(KeyBinding var0) {
      if(var0.getIsKeyPressed()) {
         KeyBinding.setKeyBindState(var0.getKeyCode(), false);
         if(JRMCoreH.State2 == 0 && JRMCoreH.State == 0 || JRMCoreH.State2 == 0 && JRMCoreH.Race == 4 && JRMCoreH.State <= 4) {
            JRMCoreH.Rls((byte)0);
         }

         JRMCoreH.kiInSuper = 0;
         ascend = 0;
         ptime = 0;
         partnorm = 0;
         pup = 0;
         if(JRMCoreH.State2 <= 0 && JRMCoreH.State != 7) {
            if((JRMCoreH.Race != 4 || JRMCoreH.Race == 4 && JRMCoreH.State > 4) && JRMCoreH.PlyrSkillX != null && JRMCoreH.PlyrSkillX.contains("TR")) {
               int var1 = Integer.parseInt(JRMCoreH.PlyrSkillX.replaceAll("TR", ""));
               if(var1 != 0) {
                  String var2 = "jinryuudragonbc:DBC.descend";
                  if(JRMCoreH.race_saiyan(JRMCoreH.Race)) {
                     var2 = "jinryuudragonbc:1610.sse";
                  }

                  soundAsc(var2);
                  Dscndng();
               }
            }
         } else {
            soundAsc(3);
            Dscndng();
         }
      }

   }

   public static void triForce(int var0, int var1, int var2) {
      PD.sendToServer(new JRMCorePTri((byte)var0, (byte)var1, (byte)var2));
   }

   public static void Ascndng() {
      byte var0 = 1;
      PD.sendToServer(new DBCPascend((byte)var0));
   }

   public static void Dscndng(int var0) {
      PD.sendToServer(new DBCPdescend((byte)var0));
   }

   public static void Dscndng() {
      byte var0 = 1;
      Dscndng(var0);
   }

   public static void soundAsc(String var0) {
      int var1 = DBCClient.mc.thePlayer.getEntityId();
      PD.sendToServer(new DBCPchargesound(var1, var0));
   }

   public static void soundAsc(int var0) {
      int var1 = DBCClient.mc.thePlayer.getEntityId();
      Object var2;
      switch(var0) {
      case 1:
         var2 = new DBCPascendsound(var1);
         break;
      case 2:
         var2 = new DBCPchargesound(var1, "jinryuudragonbc:DBC.aura");
         break;
      case 3:
         var2 = new DBCPdescendsound(var1);
         break;
      case 4:
         var2 = new DBCPduo(300, var1);
         break;
      default:
         var2 = new DBCPdescendsound(var1);
      }

      PD.sendToServer((IMessage)var2);
   }

   public static void chargePart(boolean var0) {
      World var1 = DBCClient.mc.thePlayer.worldObj;

      for(int var2 = 0; var2 < JRMCoreH.plyrs.length; ++var2) {
         if(JRMCoreH.dnn(19) && JRMCoreH.dnn(2) && JRMCoreH.dnn(1) && JRMCoreH.dnn(5)) {
            String var3 = JRMCoreH.StusEfctsClient(var2);
            String[] var4 = JRMCoreH.data2[var2].split(";");
            int var5 = Integer.parseInt(var4[1]);
            if(var3.contains(JRMCoreH.StusEfcts[4]) || var3.contains(JRMCoreH.StusEfcts[1]) || var3.contains(JRMCoreH.StusEfcts[3]) || var3.contains(JRMCoreH.StusEfcts[5]) || var3.contains(JRMCoreH.StusEfcts[7])) {
               EntityPlayer var6 = var1.getPlayerEntityByName(JRMCoreH.plyrs[var2]);
               if(var6 instanceof EntityPlayer) {
                  String[] var7 = JRMCoreH.data1[var2].split(";");
                  int var8 = Integer.parseInt(var7[0]);
                  String[] var9 = JRMCoreH.data5[var2].split(";");
                  int var10 = Integer.parseInt(var9[0]);
                  int var11 = Integer.parseInt(var9[1]);
                  chargePart((EntityPlayer)var6, var8, var10, var11, Integer.parseInt(var4[0]), var5, var0, var3);
               }
            }
         }
      }

   }

   public static void chargePart(EntityPlayer var0, int var1, int var2, int var3, int var4, int var5, boolean var6, String var7) {
      byte var8 = 0;
      boolean var9 = var5 > 0 || JRMCoreH.StusEfcts(5, var7);
      if(!var6) {
         partnorm = 0;
         if(var9 && JRMCoreH.race_saiyan(var1) && var4 == 10) {
            var8 = 9;
         } else if(var9) {
            var8 = 4;
         } else if((!JRMCoreH.race_saiyan(var1) || var4 <= 0 || var4 == 7) && !JRMCoreHDBC.godKiUser(var1, var4)) {
            if(var2 > 66) {
               var8 = 1;
            } else if(var2 <= 66 && var2 >= 33) {
               var8 = 3;
            } else if(var2 < 33) {
               var8 = 4;
            }
         } else {
            var8 = 2;
         }
      } else {
         String var10 = "jinryuudragonbc:DBC.aura";
         if(JRMCoreH.race_saiyan(var1) && var4 == 10) {
            var10 = "jinryuudragonbc:1610.aurab";
         }

         if(JRMCoreH.race_saiyan(var1) && var4 != 10 && JRMCoreHDBC.godKiUser(var1, var4)) {
            var10 = "jinryuudragonbc:1610.aurag";
         }

         if(var9 && JRMCoreH.race_saiyan(var1) && var4 == 10) {
            var10 = "jinryuudragonbc:1610.aurabk";
         }

         soundAsc(var10);
         if(!JRMCoreH.StusEfcts(3, var7) && !JRMCoreH.StusEfcts(7, var7)) {
            if(var5 > 0) {
               var8 = 8;
            }

            if(var4 > 0 && (!JRMCoreH.race_saiyan(var1) || var4 != 7) && JRMCoreHDBC.godKiUser(var1, var4)) {
               var8 = 6;
            }

            if(var2 > 66) {
               var8 = 5;
            }

            if(var2 <= 66 && var2 >= 33) {
               var8 = 7;
            }

            if(var2 < 33) {
               var8 = 8;
            }
         }

         power = 0;
      }

      if(var8 > 0) {
         String var27 = var0.getCommandSenderName();
         double var11 = var0.posY;
         EntityPlayer var13 = var0.worldObj.getPlayerEntityByName(var27);
         Random var14 = new Random();
         Object var15 = null;
         EntityAura var16 = null;
         float var17 = 0.0F;
         float var18 = 0.0F;
         int var19 = 0;
         if(JRMCoreH.plyrs != null && JRMCoreH.plyrs.length > 0 && JRMCoreH.dnn(2) && JRMCoreH.dnn(10)) {
            for(int var20 = 0; var20 < JRMCoreH.plyrs.length; ++var20) {
               if(JRMCoreH.plyrs[var20].equals(var27)) {
                  String[] var21 = JRMCoreH.data2[var20].split(";");
                  var17 = (float)Integer.parseInt(var21[0]);
                  var18 = (float)Integer.parseInt(var21[1]);
                  var19 = Integer.parseInt(JRMCoreH.dat10[var20].split(";")[0]);
               }
            }
         }

         boolean var30 = JRMCoreH.StusEfcts(7, var7) || JRMCoreH.StusEfcts(9, var7) && JRMCoreH.data(var27, 3, "0").contains("1") && !JRMCoreH.StusEfctsMe(4);
         boolean var31 = JRMCoreHDBC.godKiUserBase(var1, var4);
         boolean var22 = JRMCoreH.race_saiyan(var1) && var4 == 10;
         boolean var23 = JRMCoreH.Algnmnt_Evil(var2);
         int var24 = JRMCoreHDBC.col_sai(2, 11075583, 1, var1, var4, var2);
         var17 = !var31 && !var22?var17:0.0F;
         if(!JRMCoreH.race_saiyan(var1) || var17 != 7.0F && var17 != 8.0F) {
            boolean var32 = false;
         } else {
            boolean var10000 = true;
         }

         var17 = JRMCoreH.race_namek(var1) && var17 == 2.0F?10.0F:var17;
         boolean var26 = DBCClient.mc.thePlayer.getCommandSenderName().equals(var27) && DBCClient.mc.gameSettings.thirdPersonView == 0;
         if(var8 == 1) {
            var15 = new EntityAura(var0.worldObj, var27, var18 > 0.0F?16646144:(var3 > 0?var3:11075583), var17, var18, var19, var30);
         }

         if(var8 == 2) {
            var15 = new EntityAura(var0.worldObj, var27, var18 > 0.0F?16646144:var24, var17, var18, var19, var30);
         }

         if(var8 == 3) {
            var15 = new EntityAura(var0.worldObj, var27, var18 > 0.0F?16646144:(var3 > 0?var3:14526719), var17, var18, var19, var30);
         }

         if(var8 == 4) {
            var15 = new EntityAura(var0.worldObj, var27, var18 > 0.0F?16646144:(var3 > 0?var3:16646144), var17, var18, var19, var30);
         }

         if(var8 == 5) {
            var15 = new EntityAuraRing(var0.worldObj, var27, var18 > 0.0F?16646144:(var3 > 0?var3:11075583), var17, var18, var19);
         }

         if(var8 == 6) {
            var15 = new EntityAuraRing(var0.worldObj, var27, var18 > 0.0F?16646144:var24, var17, var18, var19);
         }

         if(var8 == 7) {
            var15 = new EntityAuraRing(var0.worldObj, var27, var18 > 0.0F?16646144:(var3 > 0?var3:14526719), var17, var18, var19);
         }

         if(var8 == 8) {
            var15 = new EntityAuraRing(var0.worldObj, var27, var18 > 0.0F?16646144:(var3 > 0?var3:16646144), var17, var18, var19);
         }

         if(var8 == 9) {
            var15 = new EntityAura(var0.worldObj, var27, var24, 0.0F, 0.0F, var19, var30);
            if(var18 > 0.0F) {
               var16 = new EntityAura(var0.worldObj, var27, 16646144, 2.0F + var17, var18 * 1.5F, var19, var30);
            }
         }

         if(var15 != null && var13 != null) {
            if(var15 instanceof EntityAura) {
               if(var31) {
                  ((EntityAura)var15).setAlp(var26?0.05F:0.2F);
                  ((EntityAura)var15).setTex("aurai");
                  ((EntityAura)var15).setTexL2("aurai2");
                  ((EntityAura)var15).setColL2(16747301);
               } else if(var22 && var23) {
                  ((EntityAura)var15).setSpd(30);
                  ((EntityAura)var15).setAlp(var26?0.05F:0.2F);
                  ((EntityAura)var15).setTex("aurai");
                  ((EntityAura)var15).setTexL2("aurai2");
                  ((EntityAura)var15).setColL2(7872713);
               } else if(var22) {
                  ((EntityAura)var15).setSpd(40);
                  ((EntityAura)var15).setAlp(var26?0.05F:0.5F);
                  ((EntityAura)var15).setTex("aurag");
               } else {
                  ((EntityAura)var15).setAlp(var26?0.05F:0.2F);
               }
            }

            ((Entity)var15).setLocationAndAngles(var13.posX - 0.0D, var13.posY - 2.0D + (double)var14.nextInt(5) * 0.03D, var13.posZ - 0.0D, var14.nextFloat(), 0.0F);
            var0.worldObj.spawnEntityInWorld((Entity)var15);
         }

         if(var16 != null && var13 != null) {
            if(var16 instanceof EntityAura) {
               ((EntityAura)var16).setSpd(40);
               ((EntityAura)var16).setAlp(var26?0.025F:0.3F);
               ((EntityAura)var16).setTex("aurak");
               ((EntityAura)var16).setInner(false);
               ((EntityAura)var16).setRendPass(0);
            }

            var16.setLocationAndAngles(var13.posX - 0.0D, var13.posY - 2.0D + (double)var14.nextInt(5) * 0.03D, var13.posZ - 0.0D, var14.nextFloat(), 0.0F);
            var0.worldObj.spawnEntityInWorld(var16);
         }
      }

   }
}
