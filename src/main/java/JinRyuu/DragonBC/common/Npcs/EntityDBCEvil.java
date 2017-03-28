package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan01;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan02;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import io.netty.buffer.ByteBuf;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDBCEvil extends EntityDBC implements IEntityAdditionalSpawnData {
   private Entity spwner = null;
   protected Entity target = null;
   private int noSpwnr = DBCConfig.mdat;

   public EntityDBCEvil(World var1) {
      super(var1);
   }

   protected NBTTagCompound nbt(EntityPlayer var1, String var2) {
      NBTTagCompound var3;
      if(var2.contains("pres")) {
         if(!var1.getEntityData().hasKey("PlayerPersisted")) {
            var3 = new NBTTagCompound();
            var1.getEntityData().setTag("PlayerPersisted", var3);
         } else {
            var3 = var1.getEntityData().getCompoundTag("PlayerPersisted");
         }
      } else {
         var3 = var1.getEntityData();
      }

      return var3;
   }

   public void setSpwner(Entity var1) {
      this.spwner = var1;
   }

   public Entity getSpwner() {
      return this.spwner;
   }

   public void settarget(Entity var1) {
      this.target = var1;
   }

   public Entity gettarget() {
      return this.target;
   }

   public void setETA(Entity var1) {
      this.entityToAttack = var1;
   }

   protected Entity findPlayerToAttack() {
      return this.target != null?this.target:super.findPlayerToAttack();
   }

   public void onDeath(DamageSource var1) {
      Entity var2 = var1.getEntity();
      super.onDeath(var1);
   }

   public void onUpdate() {
      if(!(this instanceof EntitySaiyan01) && !(this instanceof EntitySaiyan02)) {
         double var1 = (double)DBCConfig.mdal;
         if(this.spwner != null && var1 != 0.0D) {
            AxisAlignedBB var3 = AxisAlignedBB.getBoundingBox(this.posX - var1, this.posY - var1, this.posZ - var1, this.posX + var1, this.posY + var1, this.posZ + var1);
            List var4 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var3);
            boolean var5 = false;
            int var6 = 0;
            int var7 = JRMCoreH.getInt((EntityPlayer)this.spwner, "JRMCGID");

            for(int var8 = 0; var8 < var4.size(); ++var8) {
               EntityPlayer var9 = (EntityPlayer)var4.get(var8);
               int var10 = JRMCoreH.getInt(var9, "JRMCGID");
               if(this.spwner.getEntityId() == var9.getEntityId() || var7 != 0 && var7 == var10) {
                  ++var6;
               }
            }

            if(this.getEntityId() == this.spwner.getEntityId()) {
               ++var6;
            }

            if(var6 == 0) {
               --this.noSpwnr;
               if(this.noSpwnr <= 0) {
                  this.setDead();
               }
            } else if(this.noSpwnr != DBCConfig.mdat) {
               this.noSpwnr = DBCConfig.mdat;
            }
         }

         if(!this.worldObj.isRemote && this.spwner == null) {
            this.setDead();
         }
      }

      super.onUpdate();
   }

   public boolean attackEntityFrom(DamageSource var1, float var2) {
      if(!super.attackEntityFrom(var1, var2)) {
         return false;
      } else if(this.spwner != null) {
         MinecraftServer var10 = FMLCommonHandler.instance().getMinecraftServerInstance();
         EntityPlayer var4 = (EntityPlayer)this.spwner;
         Entity var5 = var1.getEntity();
         if(var5 instanceof EntityPlayer) {
            int var6 = JRMCoreH.getInt(var4, "JRMCGID");
            int var7 = JRMCoreH.getInt((EntityPlayer)var5, "JRMCGLID");
            if(var6 != 0 && var6 == var7) {
               this.setTarget(var5);
               this.settarget(var5);
               EntityLivingBase var12 = this.getAttackTarget();
               if(var12 == null && this.getEntityToAttack() instanceof EntityLivingBase) {
                  var12 = (EntityLivingBase)this.getEntityToAttack();
               }

               if(var12 == null && var1.getEntity() instanceof EntityLivingBase) {
                  var12 = (EntityLivingBase)var1.getEntity();
               }

               return true;
            } else if(var4.getEntityId() == var5.getEntityId()) {
               this.setTarget(var5);
               this.settarget(var5);
               EntityLivingBase var8 = this.getAttackTarget();
               if(var8 == null && this.getEntityToAttack() instanceof EntityLivingBase) {
                  var8 = (EntityLivingBase)this.getEntityToAttack();
               }

               if(var8 == null && var1.getEntity() instanceof EntityLivingBase) {
                  var8 = (EntityLivingBase)var1.getEntity();
               }

               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         EntityLivingBase var3 = this.getAttackTarget();
         if(var3 == null && this.getEntityToAttack() instanceof EntityLivingBase) {
            var3 = (EntityLivingBase)this.getEntityToAttack();
         }

         if(var3 == null && var1.getEntity() instanceof EntityLivingBase) {
            var3 = (EntityLivingBase)var1.getEntity();
         }

         return true;
      }
   }

   public void writeSpawnData(ByteBuf var1) {
      var1.writeInt(this.spwner == null?0:this.spwner.getEntityId());
      var1.writeInt(this.target == null?0:this.target.getEntityId());
      var1.writeInt(this.entityToAttack == null?0:this.entityToAttack.getEntityId());
   }

   public void readSpawnData(ByteBuf var1) {
      int var2 = var1.readInt();
      int var3 = var1.readInt();
      int var4 = var1.readInt();
      this.spwner = var2 == 0?this.spwner:this.worldObj.getEntityByID(var2);
      this.target = var3 == 0?this.target:this.worldObj.getEntityByID(var3);
      this.entityToAttack = var4 == 0?this.entityToAttack:this.worldObj.getEntityByID(var4);
   }
}
