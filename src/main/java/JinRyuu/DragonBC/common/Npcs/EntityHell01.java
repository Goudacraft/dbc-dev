package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.Npcs.EntityDBCNeut;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityHell01 extends EntityDBCNeut {
   public int randomSoundDelay = 0;
   public final int AttPow = 500;
   public final int HePo = 2000;

   public EntityHell01(World var1) {
      super(var1);
      if(DBCConfig.NPCOgreDam != 500 || DBCConfig.NPCOgreHP != 2000) {
         this.getEntityData().setDouble("jrmcSpawnInitiatedCAT", (double)DBCConfig.NPCOgreDam);
         this.getEntityData().setDouble("jrmcSpawnInitiatedCHP", (double)DBCConfig.NPCOgreHP);
      }

      this.experienceValue = 30;
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2000.0D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(500.0D);
   }

   protected boolean canDespawn() {
      return true;
   }

   public void onUpdate() {
      if(this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
         ;
      }

      super.onUpdate();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/hell01.png";
   }

   public boolean getCanSpawnHere() {
      return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
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

   public void onLivingUpdate() {
      super.onLivingUpdate();
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
               if(var6 instanceof EntityHell01) {
                  EntityHell01 var7 = (EntityHell01)var6;
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
      this.randomSoundDelay = this.rand.nextInt(40);
   }

   protected void dropFewItems(boolean var1, int var2) {
      int var3 = this.rand.nextInt(2 + var2);

      for(int var4 = 0; var4 < var3; ++var4) {
         ;
      }

      var3 = this.rand.nextInt(2 + var2);

      for(int var6 = 0; var6 < var3; ++var6) {
         ;
      }

   }

   public boolean interact(EntityPlayer var1) {
      return false;
   }
}
