package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class SaibaiHatchedTileEntity extends TileEntity {
   private int spawnDelay = 100;
   private String mobID = "Saibaman";
   public double field_98287_c;
   public double field_98284_d = 0.0D;
   private int minSpawnDelay = 150;
   private int maxSpawnDelay = 600;
   private int spawnCount = 1;
   private Entity field_98291_j;
   private int maxNearbyEntities = 1;
   private int activatingRangeFromPlayer = 4;
   private int spawnRange = 8;

   public SaibaiHatchedTileEntity() {
   }

   public void readFromNBT(NBTTagCompound var1) {
      super.readFromNBT(var1);
   }

   public void writeToNBT(NBTTagCompound var1) {
      super.writeToNBT(var1);
   }

   public void updateEntity() {
      super.updateEntity();
   }

   private boolean canRun() {
      return this.worldObj.getClosestPlayer((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D, (double)this.activatingRangeFromPlayer) != null;
   }

   private void updateSpawner() {
      byte var1 = 4;
      AxisAlignedBB var2 = AxisAlignedBB.getBoundingBox((double)this.xCoord - (double)var1, (double)this.yCoord - (double)var1, (double)this.zCoord - (double)var1, (double)this.xCoord + (double)var1, (double)this.yCoord + (double)var1, (double)this.zCoord + (double)var1);
      int var3 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var2).size();
      if(this.canRun() && this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var2).size() > 0) {
         if(this.worldObj.isRemote) {
            double var10000 = (double)((float)this.xCoord + this.worldObj.rand.nextFloat());
            var10000 = (double)((float)this.yCoord + this.worldObj.rand.nextFloat());
            var10000 = (double)((float)this.zCoord + this.worldObj.rand.nextFloat());
            if(this.spawnDelay > 0) {
               --this.spawnDelay;
            }

            this.field_98284_d = this.field_98287_c;
            this.field_98287_c = (this.field_98287_c + (double)(1000.0F / ((float)this.spawnDelay + 200.0F))) % 360.0D;
         } else {
            if(this.spawnDelay == -1) {
               this.resetTimer();
            }

            if(this.spawnDelay > 0) {
               --this.spawnDelay;
               return;
            }

            boolean var6 = false;

            for(int var7 = 0; var7 < 1; ++var7) {
               EntitySaibaiman var8 = new EntitySaibaiman(this.worldObj);
               var1 = 16;
               var2 = AxisAlignedBB.getBoundingBox((double)this.xCoord - (double)var1, (double)this.yCoord - (double)var1, (double)this.zCoord - (double)var1, (double)this.xCoord + (double)var1, (double)this.yCoord + (double)var1, (double)this.zCoord + (double)var1);
               int var9 = this.worldObj.getEntitiesWithinAABB(EntityDBC.class, var2).size();
               if(this.worldObj.getEntitiesWithinAABB(EntityDBC.class, var2).size() == 0) {
                  this.resetTimer();
                  return;
               }

               double var4 = (double)this.xCoord + (this.worldObj.rand.nextDouble() - this.worldObj.rand.nextDouble()) * (double)this.spawnRange;
               double var10 = (double)(this.yCoord + this.worldObj.rand.nextInt(3) - 1);
               double var12 = (double)this.zCoord + (this.worldObj.rand.nextDouble() - this.worldObj.rand.nextDouble()) * (double)this.spawnRange;
               EntityLiving var14 = var8 instanceof EntityLiving?(EntityLiving)var8:null;
               var8.setLocationAndAngles(var4, var10, var12, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
               if(var14 == null || var14.getCanSpawnHere()) {
                  this.func_98265_a(var8);
                  this.worldObj.playAuxSFX(2004, this.xCoord, this.yCoord, this.zCoord, 0);
                  if(var14 != null) {
                     var14.spawnExplosionParticle();
                  }

                  var6 = true;
               }
            }

            if(var6) {
               this.resetTimer();
            }
         }
      }

   }

   private Entity func_98265_a(Entity var1) {
      if(var1 instanceof EntityLiving && var1.worldObj != null) {
         this.worldObj.spawnEntityInWorld(var1);
      }

      return var1;
   }

   private void resetTimer() {
      if(this.maxSpawnDelay <= this.minSpawnDelay) {
         this.spawnDelay = this.minSpawnDelay;
      } else {
         int var1 = this.maxSpawnDelay - this.minSpawnDelay;
         this.spawnDelay = this.minSpawnDelay + this.worldObj.rand.nextInt(var1);
      }

      this.func_98267_a(1);
   }

   private void func_98267_a(int var1) {
      this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, BlocksDBC.SaibaiHatched, var1, 0);
   }

   private boolean setDelayToMin(int var1) {
      if(var1 == 1 && this.worldObj.isRemote) {
         this.spawnDelay = this.minSpawnDelay;
         return true;
      } else {
         return false;
      }
   }

   public boolean receiveClientEvent(int var1, int var2) {
      return this.setDelayToMin(var1)?true:super.receiveClientEvent(var1, var2);
   }
}
