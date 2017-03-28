package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
import JinRyuu.DragonBC.common.Npcs.EntityDBCNeut;
import JinRyuu.DragonBC.common.Npcs.EntityMasterBabidi;
import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreH2;
import JinRyuu.JRMCore.entity.EntityEnAttacks;
import JinRyuu.JRMCore.entity.EntityNPCshadow;
import JinRyuu.JRMCore.entity.EntityPunch;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDBCKami extends EntityDBC {
   public int rang = 1;
   protected Entity closestEntity;
   private float maxDistanceForPlayer = 4.0F;
   private int lookTime;
   private Class watchedClass;
   float var1 = 8.0F;
   public int randomSoundDelay = 0;
   private List PList = new ArrayList();
   private List RDup = new ArrayList();
   private int jumpTicks = 0;

   public EntityDBCKami(World var1x) {
      super(var1x);
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10000.0D);
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.0D);
   }

   protected boolean isMovementCeased() {
      return true;
   }

   protected boolean canDespawn() {
      return false;
   }

   protected void updateAITasks() {
   }

   public void applyEntityCollision(Entity var1x) {
   }

   public void addVelocity(double var1x, double var3, double var5) {
      this.motionX += 0.0D;
      this.motionY += 0.0D;
      this.motionZ += 0.0D;
      this.isAirBorne = false;
   }

   protected void setBeenAttacked() {
      this.velocityChanged = false;
   }

   public boolean canBePushed() {
      return false;
   }

   protected void collideWithEntity(Entity var1x) {
   }

   public boolean attackEntityFrom(DamageSource var1x, float var2) {
      return false;
   }

   public boolean attackEntityAsMob(Entity var1x) {
      return false;
   }

   public void shouldExecute() {
      this.closestEntity = this.worldObj.getClosestPlayerToEntity(this, (double)this.maxDistanceForPlayer);
      if(this.closestEntity != null) {
         this.watchedClass = EntityPlayer.class;
         this.getLookHelper().setLookPosition(this.closestEntity.posX, this.closestEntity.posY + 2.0D, this.closestEntity.posZ, 10.0F, (float)this.getVerticalFaceSpeed());
      }

   }

   public void onUpdate() {
      if(this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
         ;
      }

      if(!this.worldObj.isRemote) {
         byte var1x = 2;
         AxisAlignedBB var2 = AxisAlignedBB.getBoundingBox(this.posX - (double)var1x, this.posY - (double)var1x, this.posZ - (double)var1x, this.posX + (double)var1x, this.posY + (double)var1x, this.posZ + (double)var1x);
         List var3 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this.attackingPlayer, var2);

         for(int var4 = 0; var3.size() > var4; ++var4) {
            Entity var5 = (Entity)var3.get(var4);
            if(var5 instanceof EntityDBCKami) {
               EntityDBCKami var6 = (EntityDBCKami)var5;
               if(!this.RDup.contains(var6)) {
                  this.RDup.add(var5);
               }
            }
         }

         for(int var12 = 0; this.RDup.size() > var12; ++var12) {
            Entity var15 = (Entity)this.RDup.get(var12);
            if(var12 > 0) {
               var15.setDead();
               this.RDup.remove(var15);
            }
         }
      }

      if(!this.worldObj.isRemote && JRMCoreConfig.sfzns) {
         int var9 = 60 + (this.dimension == 22?20:(this instanceof EntityMasterBabidi?-40:0));
         AxisAlignedBB var10 = AxisAlignedBB.getBoundingBox(this.posX - (double)var9, this.posY - (double)var9, this.posZ - (double)var9, this.posX + (double)var9, this.posY + (double)var9, this.posZ + (double)var9);
         List var11 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, var10);

         for(int var13 = 0; var11.size() > var13; ++var13) {
            Entity var16 = (Entity)var11.get(var13);
            if(var16 instanceof EntityMob || var16 instanceof IProjectile || var16 instanceof EntityNPCshadow || var16 instanceof EntityFlying || var16 instanceof EntityDBCNeut || var16 instanceof EntityDBCEvil) {
               var16.setDead();
            }

            if(var16 instanceof EntityEnAttacks) {
               if(((EntityEnAttacks)var16).shootingEntity instanceof EntityPlayer) {
                  String var18 = JRMCoreH.trlai("dbc.entitymasters.nofightinsafe");
                  ((EntityPlayer)((EntityEnAttacks)var16).shootingEntity).addChatMessage((new ChatComponentTranslation(var18, new Object[0])).setChatStyle(JRMCoreH2.styl_ylw));
               }

               var16.setDead();
            }

            if(var16 instanceof EntityPunch) {
               if(((EntityPunch)var16).shootingEntity instanceof EntityPlayer) {
                  String var19 = JRMCoreH.trlai("dbc.entitymasters.nofightinsafe");
                  ((EntityPlayer)((EntityPunch)var16).shootingEntity).addChatMessage((new ChatComponentTranslation(var19, new Object[0])).setChatStyle(JRMCoreH2.styl_ylw));
               }

               var16.setDead();
            }

            if(var16 instanceof EntityPlayer) {
               EntityPlayer var20 = (EntityPlayer)var16;
               String var7 = JRMCoreH.trlai("dbc.entitymasters.insafezone");
               String var8 = JRMCoreH.trlai(this.getCommandSenderName());
               if(!this.PList.contains(var20)) {
                  this.PList.add(var16);
                  var20.addChatMessage((new ChatComponentTranslation(var7, new Object[]{new ChatComponentTranslation(var8, new Object[0])})).setChatStyle(JRMCoreH2.styl_ylw));
               }
            }
         }

         for(int var14 = 0; this.PList.size() > var14; ++var14) {
            Entity var17 = (Entity)this.PList.get(var14);
            boolean var21 = true;
            if(var11.contains(var17)) {
               var21 = false;
            }

            if(var21) {
               this.PList.remove(var17);
               EntityPlayer var22 = (EntityPlayer)var17;
               String var23 = JRMCoreH.trlai("dbc.entitymasters.leftsafe");
               var22.addChatMessage((new ChatComponentTranslation(var23, new Object[0])).setChatStyle(JRMCoreH2.styl_ylw));
            }
         }
      }

      super.onUpdate();
      this.shouldExecute();
   }

   public boolean getCanSpawnHere() {
      return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
   }

   public void onLivingUpdate() {
      this.motionY = 0.0D;
      if(this.jumpTicks > 0) {
         --this.jumpTicks;
      }

      if(this.newPosRotationIncrements > 0) {
         double var1x = this.posX + (this.newPosX - this.posX) / (double)this.newPosRotationIncrements;
         double var3 = this.posY + (this.newPosY - this.posY) / (double)this.newPosRotationIncrements;
         double var5 = this.posZ + (this.newPosZ - this.posZ) / (double)this.newPosRotationIncrements;
         double var7 = MathHelper.wrapAngleTo180_double(this.newRotationYaw - (double)this.rotationYaw);
         this.rotationYaw = (float)((double)this.rotationYaw + var7 / (double)this.newPosRotationIncrements);
         this.rotationPitch = (float)((double)this.rotationPitch + (this.newRotationPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
         --this.newPosRotationIncrements;
         this.setPosition(var1x, var3, var5);
         this.setRotation(this.rotationYaw, this.rotationPitch);
      } else if(!this.isClientWorld()) {
         this.motionX = 0.0D;
         this.motionY = 0.0D;
         this.motionZ = 0.0D;
      }

      if(Math.abs(this.motionX) < 0.005D) {
         this.motionX = 0.0D;
      }

      if(Math.abs(this.motionY) < 0.005D) {
         this.motionY = 0.0D;
      }

      if(Math.abs(this.motionZ) < 0.005D) {
         this.motionZ = 0.0D;
      }

      this.worldObj.theProfiler.startSection("ai");
      if(this.isMovementBlocked()) {
         this.isJumping = false;
         this.moveStrafing = 0.0F;
         this.moveForward = 0.0F;
         this.randomYawVelocity = 0.0F;
      } else if(this.isClientWorld()) {
         if(this.isAIEnabled()) {
            this.worldObj.theProfiler.startSection("newAi");
            this.updateAITasks();
            this.worldObj.theProfiler.endSection();
         } else {
            this.worldObj.theProfiler.startSection("oldAi");
            this.worldObj.theProfiler.endSection();
            this.rotationYawHead = this.rotationYaw;
         }
      }

      this.worldObj.theProfiler.endSection();
      this.worldObj.theProfiler.startSection("jump");
      if(this.isJumping) {
         if(!this.isInWater() && !this.handleLavaMovement()) {
            if(this.onGround && this.jumpTicks == 0) {
               this.jump();
               this.jumpTicks = 10;
            }
         } else {
            this.motionY += 0.03999999910593033D;
         }
      } else {
         this.jumpTicks = 0;
      }

      this.worldObj.theProfiler.endSection();
      this.worldObj.theProfiler.startSection("travel");
      this.moveStrafing *= 0.0F;
      this.moveForward *= 0.0F;
      this.randomYawVelocity *= 0.0F;
      this.worldObj.theProfiler.endSection();
      this.worldObj.theProfiler.startSection("push");
      if(!this.worldObj.isRemote) {
         this.collideWithNearbyEntities();
      }

      this.worldObj.theProfiler.endSection();
      EntityPlayer var9 = this.worldObj.getClosestPlayerToEntity(this, (double)this.var1);
      if(var9 != null) {
         this.closestEntity = var9;
         this.numTicksToChaseTarget = 10 + this.rand.nextInt(20);
      } else {
         this.randomYawVelocity = (this.rand.nextFloat() - 0.5F) * 20.0F;
      }

      if(this.closestEntity != null) {
         this.faceEntity(this.closestEntity, 10.0F, (float)this.getVerticalFaceSpeed());
         if(this.numTicksToChaseTarget-- <= 0 || this.closestEntity.isDead || this.closestEntity.getDistanceSqToEntity(this) > (double)(this.var1 * this.var1)) {
            this.closestEntity = null;
         }
      }

   }

   public void faceEntity(Entity var1x, float var2, float var3) {
      double var4 = var1x.posX - this.posX;
      double var6 = var1x.posZ - this.posZ;
      double var8;
      if(var1x instanceof EntityLivingBase) {
         EntityLivingBase var10 = (EntityLivingBase)var1x;
         var8 = var10.posY + (double)(var10.height * 0.85F) - 1.600000023841858D - (this.posY + (double)this.getEyeHeight());
      } else {
         var8 = (var1x.boundingBox.minY + var1x.boundingBox.maxY) / 2.0D - (this.posY + (double)this.getEyeHeight());
      }

      double var14 = (double)MathHelper.sqrt_double(var4 * var4 + var6 * var6);
      float var12 = (float)(Math.atan2(var6, var4) * 180.0D / 3.141592653589793D) - 90.0F;
      float var13 = (float)(-(Math.atan2(var8, var14) * 180.0D / 3.141592653589793D));
      this.rotationPitch = this.updateRotation(this.rotationPitch, var13, var3);
      this.rotationYaw = this.updateRotation(this.rotationYaw, var12, var2);
   }

   private float updateRotation(float var1x, float var2, float var3) {
      float var4 = MathHelper.wrapAngleTo180_float(var2 - var1x);
      if(var4 > var3) {
         var4 = var3;
      }

      if(var4 < -var3) {
         var4 = -var3;
      }

      return var1x + var4;
   }
}
