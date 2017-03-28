package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.p.DBCPdri;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.p.PD;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class SpacePod01Entity extends Entity {
   private boolean isBoatEmpty;
   private double speedMultiplier;
   private int boatPosRotationIncrements;
   private double boatX;
   private double boatY;
   private double boatZ;
   private double boatYaw;
   private double boatPitch;
   @SideOnly(Side.CLIENT)
   private double velocityX;
   @SideOnly(Side.CLIENT)
   private double velocityY;
   @SideOnly(Side.CLIENT)
   private double velocityZ;
   public String texture;
   private float dS;
   private float T;
   private int emptyCounter;

   public boolean shouldRenderInPass(int var1) {
      return var1 == 0;
   }

   public SpacePod01Entity(World var1) {
      super(var1);
      this.T = 0.05F;
      this.emptyCounter = 0;
      this.isBoatEmpty = true;
      this.speedMultiplier = 0.07D;
      this.preventEntitySpawning = true;
      this.setSize(1.5F, 1.5F);
      this.yOffset = this.height / 2.0F;
   }

   protected boolean canTriggerWalking() {
      return false;
   }

   protected void entityInit() {
      this.dataWatcher.addObject(17, new Integer(0));
      this.dataWatcher.addObject(18, new Integer(1));
      this.dataWatcher.addObject(19, new Float(0.0F));
   }

   public AxisAlignedBB getCollisionBox(Entity var1) {
      return var1.boundingBox;
   }

   public AxisAlignedBB getBoundingBox() {
      return this.boundingBox;
   }

   public boolean canBePushed() {
      return true;
   }

   public SpacePod01Entity(World var1, double var2, double var4, double var6) {
      this(var1);
      this.setPosition(var2, var4 + (double)this.yOffset, var6);
      this.motionX = 0.0D;
      this.motionY = 0.0D;
      this.motionZ = 0.0D;
      this.prevPosX = var2;
      this.prevPosY = var4;
      this.prevPosZ = var6;
   }

   public double getMountedYOffset() {
      return (double)this.height * 0.0D - 0.30000001192092896D;
   }

   public boolean attackEntityFrom(DamageSource var1, float var2) {
      if(this.isEntityInvulnerable()) {
         return false;
      } else if(!this.worldObj.isRemote && !this.isDead) {
         this.setTimeSinceHit(10);
         this.setDamageTaken(this.getDamageTaken() + var2 * 10.0F);
         this.setBeenAttacked();
         boolean var3 = var1.getEntity() instanceof EntityPlayer && ((EntityPlayer)var1.getEntity()).capabilities.isCreativeMode;
         if(var3 || this.getDamageTaken() > 40.0F) {
            if(this.riddenByEntity != null) {
               this.riddenByEntity.mountEntity(this);
            }

            this.func_145778_a(ItemsDBC.SpacePod01Item, 1, 0.0F);
            if(!var3) {
               ;
            }

            this.setDead();
         }

         return true;
      } else {
         return true;
      }
   }

   @SideOnly(Side.CLIENT)
   public void performHurtAnimation() {
      this.setTimeSinceHit(10);
      this.setDamageTaken(this.getDamageTaken() * 11.0F);
   }

   public boolean canBeCollidedWith() {
      return !this.isDead;
   }

   @SideOnly(Side.CLIENT)
   public void setPositionAndRotation2(double var1, double var3, double var5, float var7, float var8, int var9) {
      if(this.isBoatEmpty) {
         this.boatPosRotationIncrements = var9 + 5;
      } else {
         double var10 = var1 - this.posX;
         double var12 = var3 - this.posY;
         double var14 = var5 - this.posZ;
         double var16 = var10 * var10 + var12 * var12 + var14 * var14;
         if(var16 <= 1.0D) {
            return;
         }

         this.boatPosRotationIncrements = 3;
      }

      this.boatX = var1;
      this.boatY = var3;
      this.boatZ = var5;
      this.boatYaw = (double)var7;
      this.boatPitch = (double)var8;
      this.motionX = this.velocityX;
      this.motionY = this.velocityY;
      this.motionZ = this.velocityZ;
   }

   @SideOnly(Side.CLIENT)
   public void setVelocity(double var1, double var3, double var5) {
      this.velocityX = this.motionX = var1;
      this.velocityY = this.motionY = var3;
      this.velocityZ = this.motionZ = var5;
   }

   public void onUpdate() {
      super.onUpdate();
      if(this.getTimeSinceHit() > 0) {
         this.setTimeSinceHit(this.getTimeSinceHit() - 1);
      }

      if(this.getDamageTaken() > 0.0F) {
         this.setDamageTaken(this.getDamageTaken() - 1.0F);
      }

      this.prevPosX = this.posX;
      this.prevPosY = this.posY;
      this.prevPosZ = this.posZ;
      byte var1 = 5;
      double var2 = 0.0D;

      for(int var4 = 0; var4 < var1; ++var4) {
         double var5 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(var4 + 0) / (double)var1 - 0.125D;
         double var7 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(var4 + 1) / (double)var1 - 0.125D;
         AxisAlignedBB.getBoundingBox(this.boundingBox.minX, var5, this.boundingBox.minZ, this.boundingBox.maxX, var7, this.boundingBox.maxZ);
      }

      double var25 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
      if(var25 > 0.26249999999999996D) {
         double var6 = Math.cos((double)this.rotationYaw * 3.141592653589793D / 180.0D);
         double var8 = Math.sin((double)this.rotationYaw * 3.141592653589793D / 180.0D);

         for(int var10 = 0; (double)var10 < 1.0D + var25 * 60.0D; ++var10) {
            double var11 = (double)(this.rand.nextFloat() * 2.0F - 1.0F);
            double var13 = (double)(this.rand.nextInt(2) * 2 - 1) * 0.7D;
         }
      }

      if(this.worldObj.isRemote && this.isBoatEmpty) {
         if(this.boatPosRotationIncrements > 0) {
            double var26 = this.posX + (this.boatX - this.posX) / (double)this.boatPosRotationIncrements;
            double var29 = this.posY + (this.boatY - this.posY) / (double)this.boatPosRotationIncrements;
            double var33 = this.posZ + (this.boatZ - this.posZ) / (double)this.boatPosRotationIncrements;
            double var32 = MathHelper.wrapAngleTo180_double(this.boatYaw - (double)this.rotationYaw);
            this.rotationYaw = (float)((double)this.rotationYaw + var32 / (double)this.boatPosRotationIncrements);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.boatPitch - (double)this.rotationPitch) / (double)this.boatPosRotationIncrements);
            --this.boatPosRotationIncrements;
            this.setPosition(var26, var29, var33);
            this.setRotation(this.rotationYaw, this.rotationPitch);
         } else {
            double var27 = this.posX + this.motionX;
            double var30 = this.posY + this.motionY;
            double var34 = this.posZ + this.motionZ;
            this.setPosition(var27, var30, var34);
            this.motionX *= 0.9900000095367432D;
            this.motionY *= 0.949999988079071D;
            this.motionZ *= 0.9900000095367432D;
         }
      } else {
         double var14 = 0.0D;
         if(this.riddenByEntity != null) {
            if(this.riddenByEntity instanceof EntityPlayer) {
               NBTTagCompound var16 = JRMCoreH.nbt((EntityPlayer)this.riddenByEntity, "");
               if(var16.getInteger("DBCdriF") == 1) {
                  var14 = 0.55D;
                  this.dS += this.T;
                  var16.setInteger("DBCdriF", 0);
               } else if(var16.getInteger("DBCdriF") == 2) {
                  var14 = -0.55D;
                  this.dS -= this.T;
                  var16.setInteger("DBCdriF", 0);
               } else {
                  var14 = 0.0D;
                  var16.setInteger("DBCdriF", 0);
               }

               if(var16.getInteger("DBCdriY") == 3) {
                  this.motionY += 0.5D;
                  if(this.motionY > 0.5D) {
                     this.motionY = 0.5D;
                  }

                  var16.setInteger("DBCdriY", 0);
               } else if(var16.getInteger("DBCdriY") == 4) {
                  if(this.worldObj.getBlock((int)this.posX + 0, (int)this.posY - 2, (int)this.posZ + 0).getMaterial() == Material.air) {
                     this.motionY -= 0.5D;
                     if(this.motionY < -0.5D) {
                        this.motionY = -0.5D;
                     }

                     var16.setInteger("DBCdriY", 0);
                  }
               } else {
                  this.motionY = 0.0D;
                  var16.setInteger("DBCdriY", 0);
               }

               if(var16.getInteger("DBCdriS") == 5) {
                  this.rotationYaw -= 4.0F;
                  var16.setInteger("DBCdriS", 0);
               } else if(var16.getInteger("DBCdriS") == 6) {
                  this.rotationYaw += 4.0F;
                  var16.setInteger("DBCdriS", 0);
               } else {
                  var16.setInteger("DBCdriS", 0);
               }
            }

            if(this.dS > 0.5F) {
               this.dS = 0.5F;
            }

            if(this.dS < -0.5F) {
               this.dS = -0.5F;
            }

            double var36 = Math.cos((double)this.rotationYaw * 3.141592653589793D / 180.0D) * var14;
            double var18 = Math.sin((double)this.rotationYaw * 3.141592653589793D / 180.0D) * -var14;
            this.motionZ = var36;
            this.motionX = var18;
            this.riddenByEntity.fallDistance = 0.0F;
            this.fallDistance = 0.0F;
            if(this.ridingEntity != null) {
               this.ridingEntity.fallDistance = 0.0F;
            }

            this.riddenByEntity.onGround = false;
            this.dri(10);
         } else {
            var14 = 0.0D;
            this.dS = 0.0F;
         }

         this.fallDistance = 0.0F;
         if(this.riddenByEntity == null) {
            this.motionX *= 0.3900000095367432D;
            this.motionZ *= 0.3900000095367432D;
            if(DBCConfig.spdc > 0) {
               ++this.emptyCounter;
               if(this.emptyCounter == 20 * DBCConfig.spdc) {
                  this.func_145778_a(ItemsDBC.SpacePod01Item, 1, 0.0F);
                  this.setDead();
               }
            }
         } else {
            this.emptyCounter = 0;
         }

         this.moveEntity(this.motionX, this.motionY, this.motionZ);
         if(this.isCollidedHorizontally && var25 > 0.2D) {
            if(!this.worldObj.isRemote && !this.isDead) {
               this.setDead();
               this.func_145778_a(ItemsDBC.SpacePod01Item, 1, 0.0F);
            }
         } else if(this.riddenByEntity != null) {
            this.motionX *= 0.3900000095367432D;
            this.motionY *= 0.349999988079071D;
            this.motionZ *= 0.3900000095367432D;
         }

         this.rotationPitch = 0.0F;
         double var28 = (double)this.rotationYaw;
         double var12 = this.prevPosX - this.posX;
         double var31 = this.prevPosZ - this.posZ;
         if(var12 * var12 + var31 * var31 > 0.001D) {
            var28 = (double)((float)(Math.atan2(var31, var12) * 180.0D / 3.141592653589793D));
         }

         double var37 = MathHelper.wrapAngleTo180_double(var28 - (double)this.rotationYaw);
         if(var37 > 20.0D) {
            var37 = 20.0D;
         }

         if(var37 < -20.0D) {
            var37 = -20.0D;
         }

         this.setRotation(this.rotationYaw, this.rotationPitch);
         if(!this.worldObj.isRemote) {
            List var39 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(0.20000000298023224D, 0.0D, 0.20000000298023224D));
            if(var39 != null && !var39.isEmpty()) {
               for(int var19 = 0; var19 < var39.size(); ++var19) {
                  Entity var20 = (Entity)var39.get(var19);
                  if(var20 != this.riddenByEntity && var20.canBePushed() && var20 instanceof SpacePod01Entity) {
                     this.motionX = 0.0D;
                     this.motionY = 0.0D;
                     this.motionZ = 0.0D;
                  }
               }
            }

            for(int var40 = 0; var40 < 4; ++var40) {
               int var41 = MathHelper.floor_double(this.posX + ((double)(var40 % 2) - 0.5D) * 0.8D);
               int var21 = MathHelper.floor_double(this.posZ + ((double)(var40 / 2) - 0.5D) * 0.8D);

               for(int var22 = 0; var22 < 2; ++var22) {
                  int var23 = MathHelper.floor_double(this.posY) + var22;
                  Block var24 = this.worldObj.getBlock(var41, var23, var21);
                  if(var24 == Blocks.snow) {
                     this.worldObj.setBlockToAir(var41, var23, var21);
                  } else if(var24 == Blocks.waterlily) {
                     this.worldObj.destroyBlockInWorldPartially(var41, var23, var21, 0, 0);
                  }
               }
            }

            if(this.riddenByEntity != null && this.riddenByEntity.isDead) {
               this.riddenByEntity = null;
            }
         }
      }

   }

   public void updateRiderPosition() {
      if(this.riddenByEntity != null) {
         double var1 = Math.cos((double)this.rotationYaw * 3.141592653589793D / 180.0D) * 0.4D;
         double var3 = Math.sin((double)this.rotationYaw * 3.141592653589793D / 180.0D) * 0.4D;
         this.riddenByEntity.setPosition(this.posX + var1, this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(), this.posZ + var3);
      }

   }

   public void dri(int var1) {
      float var2 = this.riddenByEntity != null?this.dS:0.0F;
      PD.sendTo(new DBCPdri((int)(var2 * 10.0F)), (EntityPlayerMP)this.riddenByEntity);
   }

   protected void writeEntityToNBT(NBTTagCompound var1) {
   }

   protected void readEntityFromNBT(NBTTagCompound var1) {
   }

   @SideOnly(Side.CLIENT)
   public float getShadowSize() {
      return 0.0F;
   }

   public boolean interactFirst(EntityPlayer var1) {
      return this.interact(var1);
   }

   public boolean interact(EntityPlayer var1) {
      if(this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer && this.riddenByEntity != var1) {
         return true;
      } else {
         if(!this.worldObj.isRemote) {
            var1.mountEntity(this);
         }

         return true;
      }
   }

   public void setDamageTaken(float var1) {
      this.dataWatcher.updateObject(19, Float.valueOf(var1));
   }

   public float getDamageTaken() {
      return this.dataWatcher.getWatchableObjectFloat(19);
   }

   public void setTimeSinceHit(int var1) {
      this.dataWatcher.updateObject(17, Integer.valueOf(var1));
   }

   public int getTimeSinceHit() {
      return this.dataWatcher.getWatchableObjectInt(17);
   }

   public void setForwardDirection(int var1) {
      this.dataWatcher.updateObject(18, Integer.valueOf(var1));
   }

   public int getForwardDirection() {
      return this.dataWatcher.getWatchableObjectInt(18);
   }

   @SideOnly(Side.CLIENT)
   public void setIsBoatEmpty(boolean var1) {
      this.isBoatEmpty = var1;
   }
}
