package JinRyuu.DragonBC.common.Entitys;

import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.common.registry.IThrowableEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityEnergyFM extends Entity implements IThrowableEntity, IEntityAdditionalSpawnData, IEntitySelector, IProjectile {
   public Entity shootingEntity;
   private int xTile = -1;
   private int yTile = -1;
   private int zTile = -1;
   private Block inTile;
   private int inData = 0;
   private boolean inGround = false;
   private int ticksInGround;
   private int ticksInAir = 0;
   private float Expl = 4.0F;
   private String ExplSound = "jinryuudragonbc:DBC.expl";
   private String AirSound = "jinryuudragonbc:DBC.hafire";
   private float strtX;
   private float strtY;
   private float strtZ;
   private float trgtX = 0.0F;
   private float trgtY = 0.0F;
   private float trgtZ = 0.0F;
   private byte speed;
   private boolean shrink = false;
   private byte relFired = 100;
   private float size = 10.0F;
   private int cb = 50;
   private boolean kiClashed;
   private List kiClashedList = new ArrayList();

   public float strtX() {
      return this.strtX;
   }

   public float strtY() {
      return this.strtY;
   }

   public float strtZ() {
      return this.strtZ;
   }

   public float trgtX() {
      return this.trgtX;
   }

   public float trgtY() {
      return this.trgtY;
   }

   public float trgtZ() {
      return this.trgtZ;
   }

   public int getShrink() {
      return this.getDataWatcher().getWatchableObjectInt(20);
   }

   public byte getSpe() {
      return this.speed;
   }

   public int getAirTicks() {
      return this.ticksInAir;
   }

   public void setAirTicks(int var1) {
      this.ticksInAir = var1;
   }

   public EntityEnergyFM(World var1) {
      super(var1);
      this.setSize(this.size, this.size);
   }

   public EntityEnergyFM(EntityLivingBase var1) {
      super(var1.worldObj);
      this.speed = 20;
      int var2 = (int)(this.posY > 65.0D?this.posY - 65.0D:1.0D) * 4;
      this.size = 0.5F + (float)(var2 / 5 * 100) * 0.02F / 8.0F;
      if(this.size > 10.0F) {
         this.size = 10.0F;
      }

      this.shootingEntity = var1;
      this.renderDistanceWeight = 10.0D;
      this.setSize(this.size, this.size);
      double var3 = (double)(var1.width + 1.0F);
      double var10000 = (double)(var1.height + 0.5F + this.size * 0.5F);
      Vec3 var7 = var1.getLook(1.0F);
      double var8 = var1.posX + var7.xCoord * var3;
      double var10 = var1.posY + var7.yCoord * var3 + (double)(var1.height * 0.55F);
      double var12 = var1.posZ + var7.zCoord * var3;
      this.setLocationAndAngles(var8, var10, var12, 0.0F, 0.0F);
      this.yOffset = this.size * 0.5F;
      this.motionX = 0.0D;
      this.motionZ = 0.0D;
      this.motionY = 1.0D;
      this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, (float)this.speed * 0.05F, 1.0F);
      this.strtX = (float)var8;
      this.strtY = (float)var10;
      this.strtZ = (float)var12;
   }

   protected void entityInit() {
      this.dataWatcher.addObject(20, Integer.valueOf(0));
   }

   public void setThrowableHeading(double var1, double var3, double var5, float var7, float var8) {
      float var9 = MathHelper.sqrt_double(var1 * var1 + var3 * var3 + var5 * var5);
      var1 = var1 / (double)var9;
      var3 = var3 / (double)var9;
      var5 = var5 / (double)var9;
      var1 = var1 + this.rand.nextGaussian() * 0.007499999832361937D * (double)var8;
      var3 = var3 + this.rand.nextGaussian() * 0.007499999832361937D * (double)var8;
      var5 = var5 + this.rand.nextGaussian() * 0.007499999832361937D * (double)var8;
      var1 = var1 * (double)var7;
      var3 = var3 * (double)var7;
      var5 = var5 * (double)var7;
      this.motionX = var1;
      this.motionY = var3;
      this.motionZ = var5;
      float var10 = MathHelper.sqrt_double(var1 * var1 + var5 * var5);
      this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(var1, var5) * 180.0D / 3.141592653589793D);
      this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(var3, (double)var10) * 180.0D / 3.141592653589793D);
      this.ticksInGround = 0;
   }

   @SideOnly(Side.CLIENT)
   public void setPositionAndRotation2(double var1, double var3, double var5, float var7, float var8, int var9) {
      this.setPosition(var1, var3, var5);
      this.setRotation(var7, var8);
   }

   @SideOnly(Side.CLIENT)
   public void setVelocity(double var1, double var3, double var5) {
      this.motionX = var1;
      this.motionY = var3;
      this.motionZ = var5;
      if(this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
         float var7 = MathHelper.sqrt_double(var1 * var1 + var5 * var5);
         this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(var1, var5) * 180.0D / 3.141592653589793D);
         this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(var3, (double)var7) * 180.0D / 3.141592653589793D);
         this.prevRotationPitch = this.rotationPitch;
         this.prevRotationYaw = this.rotationYaw;
         this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
         this.ticksInGround = 0;
      }

   }

   public void onUpdate() {
      if(!this.worldObj.isRemote && this.shootingEntity == null) {
         this.setDead();
      }

      if(this.posY >= 250.0D) {
         this.motionY = 0.0D;
      } else {
         int var1 = (int)(this.posY > 80.0D?this.posY - 80.0D:1.0D) * 4;
         this.size = 0.5F + (float)(var1 / 5 * 100) * 0.02F / 8.0F;
         this.setSize(this.size, this.size);
      }

      this.motionX = 0.0D;
      this.motionZ = 0.0D;
      if(this.ticksExisted == 1) {
         this.setSize(this.size, this.size);
         this.yOffset = this.size * 0.5F;
      }

      super.onUpdate();
      if(this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
         float var16 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
         this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.141592653589793D);
         this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, (double)var16) * 180.0D / 3.141592653589793D);
      }

      Block var17 = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
      if(var17.getMaterial() != Material.air) {
         var17.setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
         AxisAlignedBB var2 = var17.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
         if(var2 != null && var2.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ))) {
            this.inGround = true;
         }
      }

      if(this.inGround) {
         int var18 = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
         if(var17 == this.inTile && var18 == this.inData) {
            ++this.ticksInGround;
            if(this.ticksInGround == 1) {
               this.setDead();
               if(!this.worldObj.isRemote) {
                  this.worldObj.playSoundAtEntity(this, this.AirSound, 1.0F, 1.0F);
               }
            }
         } else {
            this.inGround = false;
            this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
            this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
            this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
            this.ticksInGround = 0;
            this.ticksInAir = 0;
         }
      } else {
         ++this.ticksInAir;
         Vec3 var19 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
         Vec3 var3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
         MovingObjectPosition var4 = this.worldObj.func_147447_a(var19, var3, false, true, false);
         var19 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
         var3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
         if(!this.worldObj.isRemote && this.ticksInAir >= 2000) {
            this.setDead();
         }

         for(int var5 = 1; var5 < 3; ++var5) {
            ;
         }

         int var22 = this.ticksInAir / 10 * 10;
         if(this.ticksInAir == (var22 == 0?10:var22)) {
            this.worldObj.playSoundAtEntity(this, "jinryuudragonbc:" + JRMCoreH.techSnds(0, 2, 0), 1.0F, 1.0F);
         }

         if(var4 != null) {
            var3 = Vec3.createVectorHelper(var4.hitVec.xCoord, var4.hitVec.yCoord, var4.hitVec.zCoord);
         }

         if(!this.worldObj.isRemote) {
            Entity var7 = null;
            List var8 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(0.5D, 0.5D, 0.5D));
            double var9 = 0.0D;

            for(var22 = 0; var22 < var8.size(); ++var22) {
               Entity var11 = (Entity)var8.get(var22);
               if(var11 instanceof EntityLivingBase && var11.canBeCollidedWith() && (var11 != this.shootingEntity || this.ticksInAir >= 5)) {
                  float var6 = 0.0F;
                  AxisAlignedBB var12 = var11.boundingBox.expand((double)var6, (double)var6, (double)var6);
                  MovingObjectPosition var13 = var12.calculateIntercept(var19, var3);
                  if(var13 != null) {
                     double var14 = var19.distanceTo(var13.hitVec);
                     if(var14 < var9 || var9 == 0.0D) {
                        var7 = var11;
                        var9 = var14;
                     }
                  }
               }
            }

            if(var7 != null) {
               var4 = new MovingObjectPosition(var7);
            }
         }

         if(var4 != null) {
            if(!this.worldObj.isRemote) {
               this.worldObj.playSoundAtEntity(this, this.ExplSound, 1.0F, 1.0F);
            }

            this.xTile = var4.blockX;
            this.yTile = var4.blockY;
            this.zTile = var4.blockZ;
            this.inTile = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
            this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
            this.inGround = true;
            if(this.inTile.getMaterial() != Material.air) {
               this.inTile.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
            }
         }

         this.posX += this.motionX;
         this.posY += this.motionY;

         for(this.posZ += this.motionZ; this.rotationPitch - this.prevRotationPitch >= 180.0F; this.prevRotationPitch += 360.0F) {
            ;
         }

         while(this.rotationYaw - this.prevRotationYaw < -180.0F) {
            this.prevRotationYaw -= 360.0F;
         }

         while(this.rotationYaw - this.prevRotationYaw >= 180.0F) {
            this.prevRotationYaw += 360.0F;
         }

         float var25 = 1.0F;
         float var24 = 0.0F;
         if(this.isInWater()) {
            for(int var26 = 0; var26 < 4; ++var26) {
               float var10 = 0.25F;
               this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)var10, this.posY - this.motionY * (double)var10, this.posZ - this.motionZ * (double)var10, this.motionX, this.motionY, this.motionZ);
            }

            var25 = 1.0F;
         }

         this.motionX *= (double)var25;
         this.motionY *= (double)var25;
         this.motionZ *= (double)var25;
         this.motionY -= (double)var24;
         this.setPosition(this.posX, this.posY, this.posZ);
      }

   }

   public void writeEntityToNBT(NBTTagCompound var1) {
      var1.setShort("xTile", (short)this.xTile);
      var1.setShort("yTile", (short)this.yTile);
      var1.setShort("zTile", (short)this.zTile);
      var1.setByte("inTile", (byte)Block.getIdFromBlock(this.inTile));
      var1.setByte("inData", (byte)this.inData);
      var1.setByte("inGround", (byte)(this.inGround?1:0));
   }

   public void readEntityFromNBT(NBTTagCompound var1) {
      this.xTile = var1.getShort("xTile");
      this.yTile = var1.getShort("yTile");
      this.zTile = var1.getShort("zTile");
      this.inTile = Block.getBlockById(var1.getByte("inTile") & 255);
      this.inData = var1.getByte("inData") & 255;
      this.inGround = var1.getByte("inGround") == 1;
   }

   public void onCollideWithPlayer(EntityPlayer var1) {
      if(!this.worldObj.isRemote && this.inGround) {
         ;
      }

   }

   protected boolean canTriggerWalking() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public float getShadowSize() {
      return 0.0F;
   }

   public boolean canAttackWithItem() {
      return false;
   }

   public boolean isEntityApplicable(Entity var1) {
      return false;
   }

   public void writeSpawnData(ByteBuf var1) {
      var1.writeInt(this.shootingEntity == null?0:this.shootingEntity.getEntityId());
      var1.writeByte(this.speed);
      var1.writeFloat(this.strtX);
      var1.writeFloat(this.strtY);
      var1.writeFloat(this.strtZ);
      var1.writeFloat(this.size);
      var1.writeFloat(this.trgtX);
      var1.writeFloat(this.trgtY);
      var1.writeFloat(this.trgtZ);
      var1.writeByte(this.shrink?1:0);
   }

   public void readSpawnData(ByteBuf var1) {
      int var2 = var1.readInt();
      this.shootingEntity = var2 == 0?this.shootingEntity:this.worldObj.getEntityByID(var2);
      this.speed = var1.readByte();
      this.strtX = var1.readFloat();
      this.strtY = var1.readFloat();
      this.strtZ = var1.readFloat();
      this.size = var1.readFloat();
      this.trgtX = var1.readFloat();
      this.trgtY = var1.readFloat();
      this.trgtZ = var1.readFloat();
      this.shrink = var1.readByte() == 1;
   }

   public Entity getThrower() {
      return null;
   }

   public void setThrower(Entity var1) {
   }

   @SideOnly(Side.CLIENT)
   public boolean isInRangeToRenderVec3D(Vec3 var1) {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public double getMaxRenderDistanceSquared() {
      return 65536.0D;
   }

   public boolean isInRangeToRenderDist(double var1) {
      return true;
   }
}
