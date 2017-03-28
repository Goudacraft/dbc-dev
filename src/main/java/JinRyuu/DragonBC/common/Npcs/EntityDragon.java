package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Npcs.EntityDragon2;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDragon extends EntityCreature {
   public int randomSoundDelay = 0;
   private int time = 0;
   public int timeBack = 0;
   private boolean granted = false;
   protected Entity closestEntity;
   float var1 = 8.0F;
   private float maxDistanceForPlayer = 4.0F;
   private int lookTime;
   private Class watchedClass;
   private int jumpTicks = 0;

   public EntityDragon(World var1x) {
      super(var1x);
      this.experienceValue = 0;
      this.setAlwaysRenderNameTag(false);
      this.width = 1.0F;
      this.height = 4.0F;
      this.boundingBox.maxX = this.boundingBox.minX + (double)this.width;
      this.boundingBox.maxZ = this.boundingBox.minZ + (double)this.width;
      this.boundingBox.maxY = this.boundingBox.minY + (double)this.height;
      this.tasks.addTask(0, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.tasks.addTask(1, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.tasks.addTask(2, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.tasks.addTask(3, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.tasks.addTask(4, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.tasks.addTask(5, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.tasks.addTask(6, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.tasks.addTask(7, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.tasks.addTask(8, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.tasks.addTask(0, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
   }

   public boolean interact(EntityPlayer var1x) {
      ItemStack var2 = var1x.inventory.getCurrentItem();
      boolean var3 = var2 != null;
      if(this.isEntityAlive()) {
         if(!this.worldObj.isRemote) {
            if(!this.granted) {
               this.granted = true;
               JRMCoreH.setInt(1, var1x, "jrmcWishes");
               JRMCoreH.setInt(0, var1x, "jrmcDrgn");
            }
         } else if(!this.granted) {
            this.granted = true;
            var1x.openGui(mod_DragonBC.instance, 2, var1x.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ);
         }

         if(!var1x.worldObj.isRemote) {
            EntityDragon2 var4 = new EntityDragon2(var1x.worldObj);
            var4.setLocationAndAngles((double)((int)this.posX), (double)((int)this.posY), (double)((int)this.posZ), this.rotationYaw, 0.0F);
            var4.timeBack = this.timeBack;
            var1x.worldObj.spawnEntityInWorld(var4);
         }

         this.setDead();
         return true;
      } else {
         return super.interact(var1x);
      }
   }

   protected void updateAITasks() {
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

      ++this.time;
      if(this.time == 1) {
         System.out.println("Shenron is Summoned!");
      }

      if(this.worldObj.isRemote) {
         DBCH.dragonSum(this);
      }

      float var1x = 30.0F;
      AxisAlignedBB var2 = AxisAlignedBB.getBoundingBox(this.posX - (double)var1x, this.posY - (double)var1x, this.posZ - (double)var1x, this.posX + (double)var1x, this.posY + (double)var1x, this.posZ + (double)var1x);
      List var3 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var2);
      if(var3.size() == 0) {
         this.setDead();
      }

      super.onUpdate();
      this.shouldExecute();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/Dragon.png";
   }

   public boolean getCanSpawnHere() {
      return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
   }

   public void onLivingUpdate() {
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
         this.motionX *= 0.98D;
         this.motionY *= 0.98D;
         this.motionZ *= 0.98D;
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
      this.moveStrafing *= 0.98F;
      this.moveForward *= 0.98F;
      this.randomYawVelocity *= 0.9F;
      this.worldObj.theProfiler.endSection();
      this.worldObj.theProfiler.startSection("push");
      if(!this.worldObj.isRemote) {
         this.collideWithNearbyEntities();
      }

      this.worldObj.theProfiler.endSection();
      this.worldObj.theProfiler.startSection("looting");
      if(!this.worldObj.isRemote && this.canPickUpLoot() && !this.dead && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
         ;
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

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10000.0D);
   }
}
