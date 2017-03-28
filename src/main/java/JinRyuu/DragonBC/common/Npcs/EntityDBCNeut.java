package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDBCNeut extends EntityDBC {
   public EntityDBCNeut(World var1) {
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

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.699999988079071D);
   }

   public void onDeath(DamageSource var1) {
      Entity var2 = var1.getEntity();
      if(var2 instanceof EntityPlayer) {
         List var3 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

         for(int var4 = 0; var4 < var3.size(); ++var4) {
            Entity var5 = (Entity)var3.get(var4);
            if(var5 instanceof EntityDBCNeut) {
               EntityDBCNeut var6 = (EntityDBCNeut)var5;
               var6.becomeAngryAt(var2);
            }
         }

         this.becomeAngryAt(var2);
      }

      super.onDeath(var1);
   }

   public void writeEntityToNBT(NBTTagCompound var1) {
      super.writeEntityToNBT(var1);
      var1.setShort("Anger", (short)this.angerLevel);
   }

   public void readEntityFromNBT(NBTTagCompound var1) {
      super.readEntityFromNBT(var1);
      this.angerLevel = var1.getShort("Anger");
   }

   protected Entity findPlayerToAttack() {
      return this.angerLevel == 0?null:super.findPlayerToAttack();
   }

   public boolean attackEntityFrom(DamageSource var1, float var2) {
      if(this.isEntityInvulnerable()) {
         return false;
      } else {
         Entity var3 = var1.getEntity();
         if(var3 instanceof EntityPlayer) {
            List var4 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

            for(int var5 = 0; var5 < var4.size(); ++var5) {
               Entity var6 = (Entity)var4.get(var5);
               if(var6 instanceof EntityDBCNeut) {
                  EntityDBCNeut var7 = (EntityDBCNeut)var6;
                  var7.becomeAngryAt(var3);
               }
            }

            this.becomeAngryAt(var3);
         }

         return super.attackEntityFrom(var1, var2);
      }
   }

   private void becomeAngryAt(Entity var1) {
      this.entityToAttack = var1;
      this.angerLevel = 400 + this.rand.nextInt(400);
   }
}
