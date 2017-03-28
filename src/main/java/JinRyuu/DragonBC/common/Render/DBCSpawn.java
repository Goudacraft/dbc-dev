package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public abstract class DBCSpawn {
   public int spawnDelay = 100;
   private String mobID = "Saibaman";
   public double field_98287_c;
   public double field_98284_d = 0.0D;
   private int minSpawnDelay = 200;
   private int maxSpawnDelay = 800;
   private int spawnCount = 1;
   private Entity field_98291_j;
   private int maxNearbyEntities = 1;
   private int activatingRangeFromPlayer = 8;
   private int spawnRange = 8;

   public DBCSpawn() {
   }

   public String getEntityNameToSpawn() {
      return this.mobID;
   }

   public void setMobID(String var1) {
      this.mobID = var1;
   }

   public boolean canRun() {
      return this.getSpawnerWorld().getClosestPlayer((double)this.getSpawnerX() + 0.5D, (double)this.getSpawnerY() + 0.5D, (double)this.getSpawnerZ() + 0.5D, (double)this.activatingRangeFromPlayer) != null;
   }

   public void updateSpawner() {
      byte var1 = 4;
      AxisAlignedBB var2 = AxisAlignedBB.getBoundingBox((double)this.getSpawnerX() - (double)var1, (double)this.getSpawnerY() - (double)var1, (double)this.getSpawnerZ() - (double)var1, (double)this.getSpawnerX() + (double)var1, (double)this.getSpawnerY() + (double)var1, (double)this.getSpawnerZ() + (double)var1);
      int var3 = this.getSpawnerWorld().getEntitiesWithinAABB(EntityPlayer.class, var2).size();
      if(this.canRun() && var3 != 0) {
         if(this.getSpawnerWorld().isRemote) {
            double var10000 = (double)((float)this.getSpawnerX() + this.getSpawnerWorld().rand.nextFloat());
            var10000 = (double)((float)this.getSpawnerY() + this.getSpawnerWorld().rand.nextFloat());
            var10000 = (double)((float)this.getSpawnerZ() + this.getSpawnerWorld().rand.nextFloat());
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

            for(int var7 = 0; var7 < this.spawnCount; ++var7) {
               EntitySaibaiman var8 = new EntitySaibaiman(this.getSpawnerWorld());
               var1 = 16;
               var2 = AxisAlignedBB.getBoundingBox((double)this.getSpawnerX() - (double)var1, (double)this.getSpawnerY() - (double)var1, (double)this.getSpawnerZ() - (double)var1, (double)this.getSpawnerX() + (double)var1, (double)this.getSpawnerY() + (double)var1, (double)this.getSpawnerZ() + (double)var1);
               int var9 = this.getSpawnerWorld().getEntitiesWithinAABB(EntityDBC.class, var2).size();
               if(var9 >= 1) {
                  this.resetTimer();
                  return;
               }

               double var4 = (double)this.getSpawnerX() + (this.getSpawnerWorld().rand.nextDouble() - this.getSpawnerWorld().rand.nextDouble()) * (double)this.spawnRange;
               double var10 = (double)(this.getSpawnerY() + this.getSpawnerWorld().rand.nextInt(3) - 1);
               double var12 = (double)this.getSpawnerZ() + (this.getSpawnerWorld().rand.nextDouble() - this.getSpawnerWorld().rand.nextDouble()) * (double)this.spawnRange;
               EntityLiving var14 = var8 instanceof EntityLiving?(EntityLiving)var8:null;
               var8.setLocationAndAngles(var4, var10, var12, this.getSpawnerWorld().rand.nextFloat() * 360.0F, 0.0F);
               if(var14 == null || var14.getCanSpawnHere()) {
                  this.func_98265_a(var8);
                  this.getSpawnerWorld().playAuxSFX(2004, this.getSpawnerX(), this.getSpawnerY(), this.getSpawnerZ(), 0);
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

   public Entity func_98265_a(Entity var1) {
      if(var1 instanceof EntityLiving && var1.worldObj != null) {
         this.getSpawnerWorld().spawnEntityInWorld(var1);
      }

      return var1;
   }

   private void resetTimer() {
      if(this.maxSpawnDelay <= this.minSpawnDelay) {
         this.spawnDelay = this.minSpawnDelay;
      } else {
         int var1 = this.maxSpawnDelay - this.minSpawnDelay;
         this.spawnDelay = this.minSpawnDelay + this.getSpawnerWorld().rand.nextInt(var1);
      }

      this.func_98267_a(1);
   }

   public void readFromNBT(NBTTagCompound var1) {
      this.mobID = var1.getString("EntityId");
      this.spawnDelay = var1.getShort("Delay");
      if(var1.hasKey("MinSpawnDelay")) {
         this.minSpawnDelay = var1.getShort("MinSpawnDelay");
         this.maxSpawnDelay = var1.getShort("MaxSpawnDelay");
         this.spawnCount = var1.getShort("SpawnCount");
      }

      if(var1.hasKey("MaxNearbyEntities")) {
         this.maxNearbyEntities = var1.getShort("MaxNearbyEntities");
         this.activatingRangeFromPlayer = var1.getShort("RequiredPlayerRange");
      }

      if(var1.hasKey("SpawnRange")) {
         this.spawnRange = var1.getShort("SpawnRange");
      }

      if(this.getSpawnerWorld() != null && this.getSpawnerWorld().isRemote) {
         this.field_98291_j = null;
      }

   }

   public void writeToNBT(NBTTagCompound var1) {
      var1.setString("EntityId", this.getEntityNameToSpawn());
      var1.setShort("Delay", (short)this.spawnDelay);
      var1.setShort("MinSpawnDelay", (short)this.minSpawnDelay);
      var1.setShort("MaxSpawnDelay", (short)this.maxSpawnDelay);
      var1.setShort("SpawnCount", (short)this.spawnCount);
      var1.setShort("MaxNearbyEntities", (short)this.maxNearbyEntities);
      var1.setShort("RequiredPlayerRange", (short)this.activatingRangeFromPlayer);
      var1.setShort("SpawnRange", (short)this.spawnRange);
   }

   public boolean setDelayToMin(int var1) {
      if(var1 == 1 && this.getSpawnerWorld().isRemote) {
         this.spawnDelay = this.minSpawnDelay;
         return true;
      } else {
         return false;
      }
   }

   @SideOnly(Side.CLIENT)
   public Entity func_98281_h() {
      if(this.field_98291_j == null) {
         Entity var1 = EntityList.createEntityByName(this.getEntityNameToSpawn(), (World)null);
         var1 = this.func_98265_a(var1);
         this.field_98291_j = var1;
      }

      return this.field_98291_j;
   }

   public abstract void func_98267_a(int var1);

   public abstract World getSpawnerWorld();

   public abstract int getSpawnerX();

   public abstract int getSpawnerY();

   public abstract int getSpawnerZ();
}
