package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.DragonBC.common.DBCClientTickHandler;
import JinRyuu.DragonBC.common.DBCKiAttacks;
import JinRyuu.DragonBC.common.Blocks.DBCMaterial;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.DragonBC.common.Npcs.EntityHell01;
import JinRyuu.DragonBC.common.Npcs.EntityHell02;
import JinRyuu.DragonBC.common.Npcs.EntityMasterEnma;
import JinRyuu.DragonBC.common.Npcs.EntityNamekian01;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan01;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan02;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.i.ExtendedPlayer;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public class ScouterGui extends Gui {
   protected FontRenderer fontRenderer;
   private Minecraft mc;
   private DBCClientTickHandler tick;
   private GuiIngame Guiingame;
   public static int count = 0;
   public static int warn = 0;
   public static int startcount = 0;
   public static int soundFunc2 = 0;
   int otherPlayerValue;
   public static int soundFunc3 = 0;
   protected String entiBP;
   protected String entiLoc;
   private String textureFile;

   public ScouterGui() {
      this.fontRenderer = DBCClient.mc.fontRenderer;
      this.mc = DBCClient.mc;
      this.otherPlayerValue = 0;
      this.entiBP = "\u00a7e";
      this.entiLoc = "\u00a7e";
      this.textureFile = "jinryuudragonbc:misc/scouterjelzo.png";
   }

   public void initGui() {
   }

   public void ScFunctionsInit(int var1, int var2, int var3) {
      this.ScouterRenderBlur(var1, var2);
      if(DBCClientTickHandler.ScFunc00 == 1) {
         this.ScouterIntro(var1, var2, var3);
         this.textureFile = "jinryuudragonbc:misc/intro.png";
         this.ScouterRenderBlur(var1, var2);
      }

      if(DBCClientTickHandler.ScFunc01 == 1) {
         this.ScouterFunction1(var1, var2, var3);
         this.textureFile = "jinryuudragonbc:misc/func1.png";
         this.ScouterRenderBlur(var1, var2);
      }

      if(DBCClientTickHandler.ScFunc02 == 1) {
         this.ScouterFunc2(var1, var2, var3);
         this.textureFile = "jinryuudragonbc:misc/func2.png";
         this.ScouterRenderBlur(var1, var2);
      }

      if(DBCClientTickHandler.ScFunc03 == 1) {
         this.ScouterFunc3(var1, var2, var3);
         this.textureFile = "jinryuudragonbc:misc/func3.png";
         this.ScouterRenderBlur(var1, var2);
      }

      if(DBCClientTickHandler.ScFunc04 == 1) {
         this.ScouterFunc2MP(var1, var2, var3);
         this.textureFile = "jinryuudragonbc:misc/func2mp.png";
         this.ScouterRenderBlur(var1, var2);
      }

      if(DBCClientTickHandler.ScFunc05 == 1) {
         this.ScouterFunc3MP(var1, var2, var3);
         this.textureFile = "jinryuudragonbc:misc/func3mp.png";
         this.ScouterRenderBlur(var1, var2);
      }

   }

   public void renderKAC1() {
      ScaledResolution var1 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var2 = var1.getScaledWidth();
      int var3 = var1.getScaledHeight();
      FontRenderer var4 = this.mc.fontRenderer;
      this.mc.entityRenderer.setupOverlayRendering();
      this.textureFile = "jinryuudragonbc:misc/KAC1.png";
      this.ScouterRenderBlur(var2, var3);
   }

   public void renderKAC2() {
      ScaledResolution var1 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var2 = var1.getScaledWidth();
      int var3 = var1.getScaledHeight();
      FontRenderer var4 = this.mc.fontRenderer;
      this.mc.entityRenderer.setupOverlayRendering();
      this.textureFile = "jinryuudragonbc:misc/KAC2.png";
      this.ScouterRenderBlur(var2, var3);
   }

   public void renderKAC3() {
      ScaledResolution var1 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var2 = var1.getScaledWidth();
      int var3 = var1.getScaledHeight();
      FontRenderer var4 = this.mc.fontRenderer;
      this.mc.entityRenderer.setupOverlayRendering();
      this.textureFile = "jinryuudragonbc:misc/KAC3.png";
      this.ScouterRenderBlur(var2, var3);
   }

   public void renderKAC4() {
      ScaledResolution var1 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var2 = var1.getScaledWidth();
      int var3 = var1.getScaledHeight();
      FontRenderer var4 = this.mc.fontRenderer;
      this.mc.entityRenderer.setupOverlayRendering();
      this.textureFile = "jinryuudragonbc:misc/KAC4.png";
      this.ScouterRenderBlur(var2, var3);
   }

   public void renderKAC5() {
      ScaledResolution var1 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var2 = var1.getScaledWidth();
      int var3 = var1.getScaledHeight();
      FontRenderer var4 = this.mc.fontRenderer;
      this.mc.entityRenderer.setupOverlayRendering();
      this.textureFile = "jinryuudragonbc:misc/KAC5.png";
      this.ScouterRenderBlur(var2, var3);
   }

   public void renderScouter() {
      ScaledResolution var1 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var2 = var1.getScaledWidth();
      int var3 = var1.getScaledHeight();
      FontRenderer var4 = this.mc.fontRenderer;
      this.mc.entityRenderer.setupOverlayRendering();
      ItemStack var5 = ExtendedPlayer.get(this.mc.thePlayer).inventory.getStackInSlot(2);
      if(var5 != null) {
         Item var7 = var5.getItem();
         byte var8 = 0;
         if(JRMCoreH.armTypScoutOn(var5)) {
            var8 = 1;
         }

         if(JRMCoreH.armTypScoutAOn(var5)) {
            var8 = 2;
         }

         if(JRMCoreH.armTypScoutBOn(var5)) {
            var8 = 3;
         }

         if(var7 == ItemsDBC.BattleArmorHelmet00 || var7 == ItemsDBC.BattleArmorHelmet00a || var7 == ItemsDBC.BattleArmorHelmet00b) {
            this.textureFile = "jinryuudragonbc:misc/scoutery0.png";
            this.ScFunctionsInit(var2, var3, var8);
         }

         if(var7 == ItemsDBC.BattleArmorHelmet01 || var7 == ItemsDBC.BattleArmorHelmet01a || var7 == ItemsDBC.BattleArmorHelmet01b) {
            this.textureFile = "jinryuudragonbc:misc/scouterr0.png";
            this.ScFunctionsInit(var2, var3, var8);
         }

         if(var7 == ItemsDBC.BattleArmorHelmet02 || var7 == ItemsDBC.BattleArmorHelmet02a || var7 == ItemsDBC.BattleArmorHelmet02b) {
            this.textureFile = "jinryuudragonbc:misc/scouterp0.png";
            this.ScFunctionsInit(var2, var3, var8);
         }

         if(var7 == ItemsDBC.BattleArmorHelmet03 || var7 == ItemsDBC.BattleArmorHelmet03a || var7 == ItemsDBC.BattleArmorHelmet03b) {
            this.textureFile = "jinryuudragonbc:misc/scouterb0.png";
            this.ScFunctionsInit(var2, var3, var8);
         }

         if(var7 == ItemsDBC.BattleArmorHelmet04 || var7 == ItemsDBC.BattleArmorHelmet04a || var7 == ItemsDBC.BattleArmorHelmet04b) {
            this.textureFile = "jinryuudragonbc:misc/scouterg0.png";
            this.ScFunctionsInit(var2, var3, var8);
         }

         if(var7 == ItemsDBC.BattleArmorHelmet05 || var7 == ItemsDBC.BattleArmorHelmet05a || var7 == ItemsDBC.BattleArmorHelmet05b) {
            this.textureFile = "jinryuudragonbc:misc/scouterpi0.png";
            this.ScFunctionsInit(var2, var3, var8);
         }

         if(JRMCoreH.armTypScoutAllOn(var5)) {
            if(var7.getDamage(var5) > 30) {
               this.textureFile = "jinryuudragonbc:misc/crack1.png";
               this.ScouterRenderBlur(var2, var3);
            }

            if(var7.getDamage(var5) > 40) {
               this.textureFile = "jinryuudragonbc:misc/crack2.png";
               this.ScouterRenderBlur(var2, var3);
            }

            if(var7.getDamage(var5) > 50) {
               this.textureFile = "jinryuudragonbc:misc/crack3.png";
               this.ScouterRenderBlur(var2, var3);
            }
         }
      }

      double var31 = 8.0D;
      double var9 = 8.0D;
      double var11 = 32.0D;
      double var13 = 32.0D;
      double var15 = 16.0D;
      double var17 = 16.0D;
      double var19 = 12.0D;
      double var21 = 12.0D;
      double var23 = 4.0D;
      double var25 = 4.0D;
      double var27 = 2.0D;
      double var29 = 2.0D;
   }

   public void ScouterFunction1(int var1, int var2, int var3) {
      double var4 = 8.0D * (double)var3;
      double var6 = 8.0D * (double)var3;
      double var8 = 8.0D * (double)var3;
      double var10 = 8.0D * (double)var3;
      double var12 = 32.0D * (double)var3;
      double var14 = 32.0D * (double)var3;
      double var16 = 16.0D * (double)var3;
      double var18 = 16.0D * (double)var3;
      double var20 = 12.0D * (double)var3;
      double var22 = 12.0D * (double)var3;
      double var24 = 4.0D * (double)var3;
      double var26 = 4.0D * (double)var3;
      double var28 = 2.0D * (double)var3;
      double var30 = 2.0D * (double)var3;
      double var32 = 32.0D * (double)var3;
      double var34 = 16.0D * (double)var3;
      double var36 = this.mc.thePlayer.posX;
      double var38 = this.mc.thePlayer.posY;
      double var40 = this.mc.thePlayer.posZ;
      double var42 = (double)this.mc.thePlayer.rotationYaw;
      float var44 = this.mc.thePlayer.rotationPitch;
      AxisAlignedBB var45 = AxisAlignedBB.getBoundingBox(var36 - var4, var38 - var6, var40 - var4, var36 + var4, var38 + var6, var40 + var4);
      AxisAlignedBB var46 = AxisAlignedBB.getBoundingBox(var36 - var32, var38 - var34, var40 - var32, var36 + var32, var38 + var34, var40 + var32);
      AxisAlignedBB var47 = AxisAlignedBB.getBoundingBox(var36 - var28, var38 - var30, var40 - var28, var36 + var28, var38 + var18, var40 + var28);
      AxisAlignedBB var48 = AxisAlignedBB.getBoundingBox(var36 - var28, var38 - var18, var40 - var28, var36 + var28, var38 + var30, var40 + var28);
      Class var49 = EntityCreature.class;
      Class var50 = EntityBlaze.class;
      Class var51 = EntityCaveSpider.class;
      Class var52 = EntityCreeper.class;
      Class var53 = EntityZombie.class;
      Class var54 = EntityGiantZombie.class;
      Class var55 = EntityPigZombie.class;
      Class var56 = EntityGhast.class;
      Class var57 = EntityMagmaCube.class;
      Class var58 = EntitySilverfish.class;
      Class var59 = EntitySkeleton.class;
      Class var60 = EntitySlime.class;
      Class var61 = EntitySpider.class;
      Class var62 = EntityPlayerMP.class;
      Class var63 = EntityWitch.class;
      Class var64 = EntityEnderman.class;
      this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var49, AxisAlignedBB.getBoundingBox(var36 - var16, var38 - var30, var40 - var16, var36 + var16, var38 + var30, var40 + var16));
      this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var49, var47);
      this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var49, var48);
      List var68 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var49, AxisAlignedBB.getBoundingBox(var36 - var20, var38 - var22, var40 - var20, var36 + var20, var38 + var22, var40 + var20));
      List var69 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var50, var45);
      List var70 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var51, var45);
      List var71 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var52, var45);
      List var72 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var53, var45);
      List var73 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var54, var45);
      List var74 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var55, var45);
      List var75 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var56, AxisAlignedBB.getBoundingBox(var36 - var8, var38 - var10, var40 - var8, var36 + var8, var38 + var10, var40 + var8));
      List var76 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var57, var45);
      List var77 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var58, var45);
      List var78 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var59, var45);
      List var79 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var60, var45);
      List var80 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var61, var45);
      List var81 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var62, var45);
      List var82 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var63, var45);
      List var83 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var64, var45);
      if(!var68.isEmpty()) {
         this.textureFile = "jinryuudragonbc:misc/scouterjelzo.png";
         this.ScouterRenderBlur(var1, var2);
         warn = 1;
         Class var84 = EntityCreature.class;
         List var85 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var84, var46);
         this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var84, var47);
         this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var84, var48);
         Entity var88 = this.mc.thePlayer.worldObj.findNearestEntityWithinAABB(var84, var46, this.mc.thePlayer);
         this.mc.thePlayer.worldObj.findNearestEntityWithinAABB(var84, var47, this.mc.thePlayer);
         this.mc.thePlayer.worldObj.findNearestEntityWithinAABB(var84, var48, this.mc.thePlayer);
         if(!var85.isEmpty()) {
            double var91 = var88.posX - var36;
            double var93 = var88.posZ - var40;
            double var95 = 0.0D;
            var95 = (var42 - 90.0D) * 3.141592653589793D / 180.0D - Math.atan2(var93, var91);
            double var101 = 0.0D;

            double var97;
            for(var97 = var95 - var95; var97 < -3.141592653589793D; var97 += 6.283185307179586D) {
               ;
            }

            while(var97 >= 3.141592653589793D) {
               var97 -= 6.283185307179586D;
            }

            if(var97 < -1.0D) {
               var97 = -1.0D;
            }

            if(var97 > 1.0D) {
               var97 = 1.0D;
            }

            var101 = var101 + var97 * 0.1D;
            var101 = var101 * 0.8D;
            double var99 = var95 + var101;
            var97 = Math.sin(var99);
            double var103 = Math.cos(var99);
            double var105 = var88.posY - var38 + 1.0D;
            double var108 = (double)this.mc.thePlayer.getDistanceToEntity(var88);
            double var110 = 0.0D;
            var110 = (double)var44 * 3.141592653589793D / 180.0D - Math.atan2(var108, var105);
            double var116 = 0.0D;

            double var112;
            for(var112 = var110 - var110; var112 < -3.141592653589793D; var112 += 6.283185307179586D) {
               ;
            }

            while(var112 >= 3.141592653589793D) {
               var112 -= 6.283185307179586D;
            }

            if(var112 < -1.0D) {
               var112 = -1.0D;
            }

            if(var112 > 1.0D) {
               var112 = 1.0D;
            }

            var116 = var116 + var112 * 0.1D;
            var116 = var116 * 0.8D;
            double var114 = var110 + var116;
            var112 = Math.sin(var114);
            double var118 = Math.cos(var114);
            if(var103 < -0.5D) {
               this.textureFile = "jinryuudragonbc:misc/eszak.png";
               this.ScouterRenderBlur(var1, var2);
            }

            if(var103 > 0.5D) {
               this.textureFile = "jinryuudragonbc:misc/del.png";
               this.ScouterRenderBlur(var1, var2);
            }

            if(var97 < -0.5D) {
               this.textureFile = "jinryuudragonbc:misc/bal.png";
               this.ScouterRenderBlur(var1, var2);
            }

            if(var97 > 0.5D) {
               this.textureFile = "jinryuudragonbc:misc/jobb.png";
               this.ScouterRenderBlur(var1, var2);
            }

            if(var118 > 0.1D) {
               this.textureFile = "jinryuudragonbc:misc/scouterfent.png";
               this.ScouterRenderBlur(var1, var2);
            }

            if(var118 < -0.1D) {
               this.textureFile = "jinryuudragonbc:misc/scouterlent.png";
               this.ScouterRenderBlur(var1, var2);
            }
         }

         if(!var69.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterB.png";
            this.ScouterRenderBlur(var1, var2);
         }

         if(!var70.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterC.png";
            this.ScouterRenderBlur(var1, var2);
         }

         if(!var71.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterA.png";
            this.ScouterRenderBlur(var1, var2);
            this.textureFile = "jinryuudragonbc:misc/scouteregyeb.png";
            this.ScouterRenderBlur(var1, var2);
         }

         if(!var72.isEmpty() || !var73.isEmpty() || !var74.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterZ.png";
            this.ScouterRenderBlur(var1, var2);
         }

         if(!var76.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterM.png";
            this.ScouterRenderBlur(var1, var2);
         }

         if(!var77.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterI.png";
            this.ScouterRenderBlur(var1, var2);
         }

         if(!var78.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterK.png";
            this.ScouterRenderBlur(var1, var2);
         }

         if(!var80.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterP.png";
            this.ScouterRenderBlur(var1, var2);
         }

         if(!var81.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterJ.png";
            this.ScouterRenderBlur(var1, var2);
            count = 1;
         }

         if(!var82.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterW.png";
            this.ScouterRenderBlur(var1, var2);
         }

         if(!var83.isEmpty()) {
            this.textureFile = "jinryuudragonbc:misc/scouterH.png";
            this.ScouterRenderBlur(var1, var2);
         }
      }

      if(!var79.isEmpty()) {
         this.textureFile = "jinryuudragonbc:misc/scouterL.png";
         this.ScouterRenderBlur(var1, var2);
         startcount = 1;
      }

      if(!var75.isEmpty()) {
         this.textureFile = "jinryuudragonbc:misc/scouterG.png";
         this.ScouterRenderBlur(var1, var2);
         startcount = 1;
      }

      if(var68.isEmpty()) {
         warn = 0;
         count = 0;
         startcount = 0;
      }

   }

   public void ScouterSearch(int var1, int var2) {
   }

   public void ScouterFunc2(int var1, int var2, int var3) {
      double var4 = 16.0D * (double)var3;
      double var6 = 2.0D * (double)var3;
      double var8 = 2.0D * (double)var3;
      double var10 = 16.0D * (double)var3;
      double var12 = 32.0D * (double)var3;
      double var14 = 16.0D * (double)var3;
      double var16 = 32.0D * (double)var3;
      double var18 = 32.0D * (double)var3;
      double var20 = this.mc.thePlayer.posX;
      double var22 = this.mc.thePlayer.posY;
      double var24 = this.mc.thePlayer.posZ;
      double var26 = (double)this.mc.thePlayer.rotationYaw;
      AxisAlignedBB var28 = AxisAlignedBB.getBoundingBox(var20 - var12, var22 - var14, var24 - var12, var20 + var12, var22 + var14, var24 + var12);
      AxisAlignedBB var29 = AxisAlignedBB.getBoundingBox(var20 - var4, var22 - var6, var24 - var4, var20 + var4, var22 + var6, var24 + var4);
      AxisAlignedBB var30 = AxisAlignedBB.getBoundingBox(var20 - var4, var22 - var10, var24 - var4, var20 + var4, var22 + var6, var24 + var4);
      Class var31 = EntityMob.class;
      Class var32 = EntityNamekian01.class;
      Class var33 = EntitySaiyan01.class;
      Class var34 = EntitySaiyan02.class;
      Class var35 = EntityHell01.class;
      Class var36 = EntityHell02.class;
      Class var37 = EntityMasterEnma.class;
      Class var38 = EntityCreature.class;
      List var39 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var38, var28);
      Entity var40 = this.mc.thePlayer.worldObj.findNearestEntityWithinAABB(var38, var28, this.mc.thePlayer);
      if(!var39.isEmpty()) {
         Class var41 = var40.getClass();
         if(var41 == var32) {
            ;
         }

         if(var41 == var33) {
            ;
         }

         if(var41 == var34) {
            ;
         }

         if(var41 == var35) {
            ;
         }

         if(var41 == var36) {
            ;
         }

         if(var41 == var37) {
            ;
         }
      }

      if(!var39.isEmpty()) {
         Class var46 = var40.getClass();
         soundFunc2 = 1;
         double var42 = this.mc.thePlayer.getDistanceSqToEntity(var40);
         int var44 = (int)var42;
         this.toString();
         String var45 = String.valueOf(var44);
         this.entiLoc = var45;
         this.textureFile = "jinryuudragonbc:misc/tavolsag.png";
         this.ScouterRenderBlur(var1, var2);
         this.Func2TAV();
      }

   }

   public void ScouterFunc3(int var1, int var2, int var3) {
      Vec3 var4 = this.mc.thePlayer.getLookVec();
      double var5 = 16.0D * (double)var3;
      double var7 = 2.0D * (double)var3;
      double var9 = 2.0D * (double)var3;
      double var11 = 16.0D * (double)var3;
      double var13 = this.mc.thePlayer.posX;
      double var15 = this.mc.thePlayer.posY;
      double var17 = this.mc.thePlayer.posZ;
      double var19 = (double)this.mc.thePlayer.rotationYaw;
      AxisAlignedBB var21 = AxisAlignedBB.getBoundingBox(var13 - var9, var15 - var7, var17 - var5, var13 + var5, var15 + var7, var17 + var5);
      AxisAlignedBB var22 = AxisAlignedBB.getBoundingBox(var13 - var5, var15 - var7, var17 - var5, var13 + var9, var15 + var7, var17 + var5);
      AxisAlignedBB var23 = AxisAlignedBB.getBoundingBox(var13 - var5, var15 - var7, var17 - var9, var13 + var5, var15 + var7, var17 + var5);
      AxisAlignedBB var24 = AxisAlignedBB.getBoundingBox(var13 - var5, var15 - var7, var17 - var5, var13 + var5, var15 + var7, var17 + var9);
      AxisAlignedBB var25 = AxisAlignedBB.getBoundingBox(var13 - var9, var15 - var11, var17 - var9, var13 + var9, var15 + var7, var17 + var9);
      AxisAlignedBB var26 = AxisAlignedBB.getBoundingBox(var13 - var9, var15 - var7, var17 - var9, var13 + var9, var15 + var11, var17 + var9);
      AxisAlignedBB var27 = AxisAlignedBB.getBoundingBox(var13 - var5, var15 - var11, var17 - var5, var13 + var5, var15 + var7, var17 + var5);
      Class var28 = EntityBlaze.class;
      Class var29 = EntityCaveSpider.class;
      Class var30 = EntityCreeper.class;
      Class var31 = EntityZombie.class;
      Class var32 = EntityGiantZombie.class;
      Class var33 = EntityPigZombie.class;
      Class var34 = EntityGhast.class;
      Class var35 = EntityMagmaCube.class;
      Class var36 = EntitySilverfish.class;
      Class var37 = EntitySkeleton.class;
      Class var38 = EntitySlime.class;
      Class var39 = EntitySpider.class;
      Class var40 = EntityPlayerMP.class;
      Class var41 = EntityWitch.class;
      Class var42 = EntityEnderman.class;
      Class var43 = EntityMob.class;
      Class var44 = EntityMob.class;
      Class var45 = EntityCreature.class;
      List var46 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var45, var27);
      Entity var47 = this.mc.thePlayer.worldObj.findNearestEntityWithinAABB(var45, var27, this.mc.thePlayer);
      if(!var46.isEmpty()) {
         Class var48 = var47.getClass();
         if(var48 == var28) {
            var44 = var28;
         }

         if(var48 == var29) {
            var44 = var29;
         }

         if(var48 == var30) {
            var44 = var30;
         }

         if(var48 == var31) {
            var44 = var31;
         }

         if(var48 == var32) {
            var44 = var32;
         }

         if(var48 == var33) {
            var44 = var33;
         }

         if(var48 == var34) {
            var44 = var34;
         }

         if(var48 == var35) {
            var44 = var35;
         }

         if(var48 == var36) {
            var44 = var36;
         }

         if(var48 == var37) {
            var44 = var37;
         }

         if(var48 == var38) {
            var44 = var38;
         }

         if(var48 == var39) {
            var44 = var39;
         }

         if(var48 == var40) {
            var44 = var40;
         }

         if(var48 == var41) {
            var44 = var41;
         }

         if(var48 == var42) {
            var44 = var42;
         }
      }

      this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var43, var21);
      this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var43, var22);
      this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var43, var23);
      this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var43, var24);
      this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var43, var25);
      this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var43, var26);
      this.mc.thePlayer.worldObj.findNearestEntityWithinAABB(var43, var27, this.mc.thePlayer);
      if(!var46.isEmpty()) {
         List var55 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var45, var27);
         List var56 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var45, var26);
         List var57 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var45, var25);
         Entity var58 = this.mc.thePlayer.worldObj.findNearestEntityWithinAABB(var45, var27, this.mc.thePlayer);
         this.mc.thePlayer.worldObj.findNearestEntityWithinAABB(var45, var26, this.mc.thePlayer);
         this.mc.thePlayer.worldObj.findNearestEntityWithinAABB(var45, var25, this.mc.thePlayer);
         if(!var55.isEmpty()) {
            double var61 = var58.posX - var13;
            double var63 = var58.posZ - var17;
            double var65 = 0.0D;
            var65 = (var19 - 90.0D) * 3.141592653589793D / 180.0D - Math.atan2(var63, var61);
            double var71 = 0.0D;

            double var67;
            for(var67 = var65 - var65; var67 < -3.141592653589793D; var67 += 6.283185307179586D) {
               ;
            }

            while(var67 >= 3.141592653589793D) {
               var67 -= 6.283185307179586D;
            }

            if(var67 < -1.0D) {
               var67 = -1.0D;
            }

            if(var67 > 1.0D) {
               var67 = 1.0D;
            }

            var71 = var71 + var67 * 0.1D;
            var71 = var71 * 0.8D;
            double var69 = var65 + var71;
            var67 = Math.sin(var69);
            double var73 = Math.cos(var69);
            if(var73 < -0.5D) {
               this.textureFile = "jinryuudragonbc:misc/BPeszak.png";
               this.ScouterRenderBlur(var1, var2);
            }

            if(var73 > 0.5D) {
               this.textureFile = "jinryuudragonbc:misc/BPdel.png";
               this.ScouterRenderBlur(var1, var2);
            }

            if(var67 < -0.5D) {
               this.textureFile = "jinryuudragonbc:misc/BPbal.png";
               this.ScouterRenderBlur(var1, var2);
            }

            if(var67 > 0.5D) {
               this.textureFile = "jinryuudragonbc:misc/BPjobb.png";
               this.ScouterRenderBlur(var1, var2);
            }

            if(!var56.isEmpty()) {
               this.textureFile = "jinryuudragonbc:misc/BPfent.png";
               this.ScouterRenderBlur(var1, var2);
            }

            if(!var57.isEmpty()) {
               this.textureFile = "jinryuudragonbc:misc/BPlent.png";
               this.ScouterRenderBlur(var1, var2);
            }
         }
      }

      String var75 = "0";
      int var76 = 0;
      new Random();
      if(!var46.isEmpty()) {
         Class var79 = var47.getClass();
         if(var79 == null) {
            var75 = "Error";
         }

         if(var79 == var44) {
            var75 = "" + JRMCoreH.bpc(var47);
            warn = 1;
         }

         if(var79 != var44 && var79 != null) {
            var76 = (int)(((EntityCreature)var47).getHealth() * 50.0F);
            warn = 1;
            if(var76 <= 500 && var79 != EntityWolf.class) {
               var76 = (int)(((EntityCreature)var47).getHealth() / 2.0F);
               warn = 0;
            }

            var75 = "" + JRMCoreH.bpc(var47);
         }

         Entity var59 = this.mc.thePlayer.worldObj.findNearestEntityWithinAABB(EntityDBC.class, var27, this.mc.thePlayer);
         if(var59 instanceof EntityDBC) {
            var75 = "" + JRMCoreH.bpc(var59);
            warn = 1;
         }
      }

      if(!var46.isEmpty()) {
         soundFunc3 = 1;
         if(var3 == 1 && Long.parseLong(var75) > 100000L || var3 == 2 && Long.parseLong(var75) > 1000000L) {
            DBCKiAttacks.dbctick(-2);
            DBCKiAttacks.scouterRem(this.mc.thePlayer);
         }

         this.entiBP = Long.parseLong(var75) / 1000000L != 0L?Long.parseLong(var75) / 1000000L + " mill":var75;
         this.textureFile = "jinryuudragonbc:misc/battlepower.png";
         this.ScouterRenderBlur(var1, var2);
         this.Func3BP();
      }

      if(var46.isEmpty()) {
         warn = 0;
         count = 0;
         startcount = 0;
      }

   }

   public void ScouterFunc2MP(int var1, int var2, int var3) {
      double var4 = 16.0D * (double)var3;
      double var6 = 2.0D * (double)var3;
      double var8 = 2.0D * (double)var3;
      double var10 = 16.0D * (double)var3;
      double var12 = 32.0D * (double)var3;
      double var14 = 16.0D * (double)var3;
      double var16 = 32.0D * (double)var3;
      double var18 = 32.0D * (double)var3;
      double var20 = this.mc.thePlayer.posX;
      double var22 = this.mc.thePlayer.posY;
      double var24 = this.mc.thePlayer.posZ;
      AxisAlignedBB var26 = AxisAlignedBB.getBoundingBox(var20 - var12, var22 - var14, var24 - var12, var20 + var12, var22 + var14, var24 + var12);
      AxisAlignedBB var27 = AxisAlignedBB.getBoundingBox(var20 - var4, var22 - var6, var24 - var4, var20 + var4, var22 + var6, var24 + var4);
      AxisAlignedBB var28 = AxisAlignedBB.getBoundingBox(var20 - var4, var22 - var10, var24 - var4, var20 + var4, var22 + var6, var24 + var4);
      Class var29 = EntityPlayer.class;
      List var30 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var29, var26);
      Entity var31 = this.mc.thePlayer.worldObj.findNearestEntityWithinAABB(var29, var26, this.mc.thePlayer);
      if(!var30.isEmpty() && var31 != null) {
         Class var32 = var31.getClass();
         if(var31 == this.mc.thePlayer) {
            return;
         }

         soundFunc2 = 1;
         double var33 = this.mc.thePlayer.getDistanceSqToEntity(var31);
         int var35 = (int)var33;
         this.toString();
         String var36 = String.valueOf(var35);
         this.entiLoc = var36;
         this.Func2TAV();
         this.textureFile = "jinryuudragonbc:misc/tavolsag.png";
         this.ScouterRenderBlur(var1, var2);
      }

   }

   public void ScouterFunc3MP(int var1, int var2, int var3) {
      double var4 = 16.0D * (double)var3;
      double var6 = 16.0D * (double)var3;
      double var8 = this.mc.thePlayer.posX;
      double var10 = this.mc.thePlayer.posY;
      double var12 = this.mc.thePlayer.posZ;
      AxisAlignedBB var14 = AxisAlignedBB.getBoundingBox(var8 - var4, var10 - var6, var12 - var4, var8 + var4, var10 + var6, var12 + var4);
      Class var15 = EntityPlayer.class;
      List var16 = this.mc.thePlayer.worldObj.getEntitiesWithinAABB(var15, var14);
      Entity var17 = this.mc.thePlayer.worldObj.findNearestEntityWithinAABB(var15, var14, this.mc.thePlayer);
      if(!var16.isEmpty() && var17 != null && var17 != this.mc.thePlayer) {
         soundFunc3 = 1;
         String var18 = "0";
         String var19 = "" + JRMCoreH.bpc(((EntityPlayer)var17).getCommandSenderName(), JRMCoreH.Pwrtyp);
         if(var17 instanceof EntityPlayer && !var19.contains("Data")) {
            var18 = var19;
         }

         if(var3 == 1 && Long.parseLong(var18) > 100000L || var3 == 2 && Long.parseLong(var18) > 1000000L) {
            DBCKiAttacks.dbctick(-2);
            DBCKiAttacks.scouterRem(this.mc.thePlayer);
         }

         String var20 = Long.parseLong(var18) / 1000000L != 0L?Long.parseLong(var18) / 1000000L + " mill":var18;
         this.entiBP = var20;
         this.textureFile = "jinryuudragonbc:misc/battlepower.png";
         this.ScouterRenderBlur(var1, var2);
         this.Func3BP();
      }

      if(var16.isEmpty()) {
         warn = 0;
         count = 0;
         startcount = 0;
      }

   }

   public void Func3BP() {
      this.initGui();
      Minecraft var1 = this.mc;
      WorldClient var2 = var1.theWorld;
      EntityClientPlayerMP var3 = var1.thePlayer;
      ScaledResolution var4 = new ScaledResolution(var1, var1.displayWidth, var1.displayHeight);
      int var5 = var4.getScaledWidth();
      int var6 = var4.getScaledHeight();
      boolean var7 = true;
      var1.entityRenderer.setupOverlayRendering();
      RenderHelper.enableStandardItemLighting();
      RenderHelper.disableStandardItemLighting();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.drawCenteredString(this.fontRenderer, this.entiBP, var5 / 8, var6 / 40 * 16, 16768306);
   }

   public void Func2TAV() {
      this.initGui();
      EntityClientPlayerMP var1 = this.mc.thePlayer;
      ScaledResolution var2 = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
      int var3 = var2.getScaledWidth();
      int var4 = var2.getScaledHeight();
      boolean var5 = true;
      FontRenderer var6 = this.mc.fontRenderer;
      this.mc.entityRenderer.setupOverlayRendering();
      RenderHelper.enableStandardItemLighting();
      RenderHelper.disableStandardItemLighting();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.drawCenteredString(var6, this.entiLoc, var3 / 400 * 120, var4 / 40 * 15, 16768306);
   }

   public void ScouterDBRadar(int var1, int var2) {
      double var3 = 32.0D;
      double var5 = 8.0D;
      double var7 = 8.0D;
      double var9 = this.mc.thePlayer.posX;
      double var11 = this.mc.thePlayer.posY;
      double var13 = this.mc.thePlayer.posZ;
      AxisAlignedBB var15 = AxisAlignedBB.getBoundingBox(var9 - var7, var11 - var5, var13 - var3, var9 + var3, var11 + var5, var13 + var3);
      AxisAlignedBB var16 = AxisAlignedBB.getBoundingBox(var9 - var3, var11 - var5, var13 - var3, var9 + var7, var11 + var5, var13 + var3);
      AxisAlignedBB var17 = AxisAlignedBB.getBoundingBox(var9 - var3, var11 - var5, var13 - var7, var9 + var3, var11 + var5, var13 + var3);
      AxisAlignedBB var18 = AxisAlignedBB.getBoundingBox(var9 - var3, var11 - var5, var13 - var3, var9 + var3, var11 + var5, var13 + var7);
      this.mc.thePlayer.worldObj.isAABBInMaterial(var15, DBCMaterial.dragonblock);
      this.mc.thePlayer.worldObj.isAABBInMaterial(var16, DBCMaterial.dragonblock);
      this.mc.thePlayer.worldObj.isAABBInMaterial(var17, DBCMaterial.dragonblock);
      this.mc.thePlayer.worldObj.isAABBInMaterial(var18, DBCMaterial.dragonblock);
      boolean var19 = true;
      if(true) {
         this.textureFile = "jinryuudragonbc:misc/TAVjobb.png";
         this.ScouterRenderBlur(var1, var2);
      }

      boolean var20 = true;
      if(true) {
         this.textureFile = "jinryuudragonbc:misc/TAVbal.png";
         this.ScouterRenderBlur(var1, var2);
      }

      boolean var21 = true;
      if(true) {
         this.textureFile = "jinryuudragonbc:misc/TAVeszak.png";
         this.ScouterRenderBlur(var1, var2);
      }

      boolean var22 = true;
      if(true) {
         this.textureFile = "jinryuudragonbc:misc/TAVdel.png";
         this.ScouterRenderBlur(var1, var2);
      }

   }

   public void ScouterIntro(int var1, int var2, int var3) {
      this.textureFile = "jinryuudragonbc:misc/intro.png";
      this.ScouterRenderBlur(var1, var2);
   }

   public void ScouterRenderBlur(int var1, int var2) {
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      this.zLevel = -600.0F;
      ResourceLocation var3 = new ResourceLocation(this.textureFile);
      this.mc.renderEngine.bindTexture(var3);
      Tessellator var4 = Tessellator.instance;
      var4.startDrawingQuads();
      var4.addVertexWithUV(0.0D, (double)var2, (double)this.zLevel, 0.0D, 1.0D);
      var4.addVertexWithUV((double)var1, (double)var2, (double)this.zLevel, 1.0D, 1.0D);
      var4.addVertexWithUV((double)var1, 0.0D, (double)this.zLevel, 1.0D, 0.0D);
      var4.addVertexWithUV(0.0D, 0.0D, (double)this.zLevel, 0.0D, 0.0D);
      var4.draw();
      GL11.glDisable(3042);
   }
}
