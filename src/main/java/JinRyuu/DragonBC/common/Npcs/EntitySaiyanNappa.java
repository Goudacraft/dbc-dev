package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyanVegeta;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntitySaiyanNappa extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public final int AttPow = 35;
   public final int HePo = 350;

   public EntitySaiyanNappa(World var1) {
      super(var1);
      this.experienceValue = 40;
      this.angerLevel = 400;
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(350.0D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(35.0D);
   }

   public void onUpdate() {
      if(this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
         ;
      }

      super.onUpdate();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/nappa.png";
   }

   public boolean getCanSpawnHere() {
      return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
   }

   protected Entity findPlayerToAttack() {
      return this.angerLevel == 0?null:super.findPlayerToAttack();
   }

   public void onLivingUpdate() {
      super.onLivingUpdate();
   }

   public void onDeath(DamageSource var1) {
      Entity var2 = var1.getEntity();
      if(var2 instanceof EntityPlayer) {
         List var3 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

         for(int var4 = 0; var4 < var3.size(); ++var4) {
            Entity var5 = (Entity)var3.get(var4);
            if(var5 instanceof EntitySaiyanVegeta) {
               EntitySaiyanVegeta var6 = (EntitySaiyanVegeta)var5;
               var6.becomeAngryAt(var2);
            }
         }
      }

      super.onDeath(var1);
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
               if(var6 instanceof EntitySaiyanNappa) {
                  EntitySaiyanNappa var7 = (EntitySaiyanNappa)var6;
               }
            }
         }

         return super.attackEntityFrom(var1, var2);
      }
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
