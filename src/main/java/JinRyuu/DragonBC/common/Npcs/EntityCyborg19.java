package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityCyborg20;
import JinRyuu.DragonBC.common.Npcs.EntityCyborgsAbs;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaFather;
import JinRyuu.JRMCore.entity.EntityKiAttacks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityCyborg19 extends EntityCyborgsAbs {
   public int randomSoundDelay = 0;
   public String tex;
   private boolean abs;
   public int BP2 = 350000000;
   public final int AttPow = 600;
   public final int HePo = 6000;

   public EntityCyborg19(World var1) {
      super(var1);
      this.experienceValue = 200;
      this.tex = "c19";
      this.abs = false;
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(6000.0D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(600.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public boolean attackEntityFrom(DamageSource var1, float var2) {
      if(this.isEntityInvulnerable()) {
         return false;
      } else {
         Entity var3 = var1.getEntity();
         if(var3 instanceof EntityKiAttacks) {
            this.setHealth(this.getHealth() + 300.0F);
         }

         if(var3 instanceof EntityPlayer) {
            List var4 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

            for(int var5 = 0; var5 < var4.size(); ++var5) {
               Entity var6 = (Entity)var4.get(var5);
               if(var6 instanceof EntityCyborg20) {
                  EntityCyborg20 var7 = (EntityCyborg20)var6;
                  var7.becomeAngryAt(var3);
               }
            }

            this.becomeAngryAt(var3);
         }

         return super.attackEntityFrom(var1, var2);
      }
   }

   public void onDeath(DamageSource var1) {
      Entity var2 = var1.getEntity();
      if(var2 instanceof EntityPlayer) {
         List var3 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

         for(int var4 = 0; var4 < var3.size(); ++var4) {
            Entity var5 = (Entity)var3.get(var4);
            if(var5 instanceof EntityFreezaFather) {
               EntityFreezaFather var6 = (EntityFreezaFather)var5;
               var6.becomeAngryAt(var2);
            }
         }

         this.becomeAngryAt(var2);
      }

      super.onDeath(var1);
   }

   public void becomeAngryAt(Entity var1) {
      this.entityToAttack = var1;
      this.angerLevel = 400 + this.rand.nextInt(400);
      this.randomSoundDelay = this.rand.nextInt(40);
   }
}
