package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityDBCWildlife;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDBCWildlifeP extends EntityDBCWildlife {
   public EntityDBCWildlifeP(World var1) {
      super(var1);
   }

   public void onDeath(DamageSource var1) {
      Entity var2 = var1.getEntity();
      if(var2 instanceof EntityPlayer) {
         List var3 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

         for(int var4 = 0; var4 < var3.size(); ++var4) {
            Entity var5 = (Entity)var3.get(var4);
            if(var5 instanceof EntityDBCWildlifeP) {
               EntityDBCWildlifeP var6 = (EntityDBCWildlifeP)var5;
               var6.becomeAngryAt(var2);
            }
         }

         this.becomeAngryAt(var2);
      }

      super.onDeath(var1);
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
               if(var6 instanceof EntityDBCWildlifeP) {
                  EntityDBCWildlifeP var7 = (EntityDBCWildlifeP)var6;
                  var7.becomeAngryAt(var3);
               }
            }

            this.becomeAngryAt(var3);
         }

         return super.attackEntityFrom(var1, var2);
      }
   }
}
