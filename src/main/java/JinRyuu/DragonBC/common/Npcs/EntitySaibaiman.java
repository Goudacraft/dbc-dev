package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntitySaibaiman extends EntityDBCEvil implements IMob {
   public int randomSoundDelay = 0;
   public final int AttPow = 20;
   public final int HePo = 200;

   public EntitySaibaiman(World var1) {
      super(var1);
      this.experienceValue = 10;
      this.setCustomNameTag("");
      this.setAlwaysRenderNameTag(false);
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0D);
   }

   public void onUpdate() {
      if(this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
         ;
      }

      super.onUpdate();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/Saibaiman.png";
   }

   public boolean getCanSpawnHere() {
      return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
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
               if(var6 instanceof EntitySaibaiman) {
                  EntitySaibaiman var7 = (EntitySaibaiman)var6;
               }
            }
         }

         return super.attackEntityFrom(var1, var2);
      }
   }

   protected void dropFewItems(boolean var1, int var2) {
      int var3 = this.rand.nextInt(5);
      if(var3 == 0) {
         this.dropItem(ItemsDBC.ItemSaibaiSeed, 1);
      }

   }

   public boolean interact(EntityPlayer var1) {
      return false;
   }
}
