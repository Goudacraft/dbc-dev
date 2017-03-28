package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCH;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPorunga2 extends EntityCreature {
   public int randomSoundDelay = 0;
   public int timeBack;
   protected Entity closestEntity;
   float var1 = 8.0F;
   private int age;
   private int jumpTicks = 0;

   public EntityPorunga2(World var1x) {
      super(var1x);
      this.experienceValue = 0;
      this.width = 1.0F;
      this.height = 32.0F;
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
      return this.isEntityAlive()?true:super.interact(var1x);
   }

   protected void updateAITasks() {
   }

   public void onUpdate() {
      if(this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
         ;
      }

      this.motionX *= 0.0D;
      this.motionZ *= 0.0D;
      super.onUpdate();
      ++this.age;
      if(this.age == 200) {
         System.out.println("Porunga has fulfilled a wish!");
         this.setDead();
      }

      if(this.worldObj.isRemote) {
         DBCH.dragonSum(this);
      }

   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/Porunga.png";
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
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0E-6D);
      this.motionX *= 1.0E-4D;
      this.motionZ *= 1.0E-4D;
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50000.0D);
   }
}
