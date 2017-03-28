package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreH2;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityFreeza6 extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public final int AttPow = 400;
   public final int HePo = 4000;

   public EntityFreeza6(World var1) {
      super(var1);
      this.experienceValue = 200;
      this.angerLevel = 400;
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/freeza6.png";
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4000.0D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(400.0D);
   }

   public void onUpdate() {
      if(this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
         ;
      }

      super.onUpdate();
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
      return super.findPlayerToAttack();
   }

   public void onLivingUpdate() {
      super.onLivingUpdate();
   }

   public void onDeath(DamageSource var1) {
      Entity var2 = var1.getEntity();
      if(var2 instanceof EntityPlayer) {
         byte var3 = 50;
         if(var2 instanceof EntityPlayer) {
            EntityPlayer var4 = (EntityPlayer)var2;
            JRMCoreH.expPls(var4, var3);
         }

         ((EntityPlayer)var2).addChatMessage((new ChatComponentTranslation(JRMCoreH.trlai("dbc.itemFreeSagaFre.d.6.line1"), new Object[0])).setChatStyle(JRMCoreH2.styl_wht));
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
               if(var6 instanceof EntityFreeza6) {
                  EntityFreeza6 var7 = (EntityFreeza6)var6;
                  var7.becomeAngryAt(var3);
               }
            }

            this.becomeAngryAt(var3);
         }

         return super.attackEntityFrom(var1, var2);
      }
   }

   void becomeAngryAt(Entity var1) {
      this.entityToAttack = var1;
      this.angerLevel = 400 + this.rand.nextInt(400);
      this.randomSoundDelay = this.rand.nextInt(40);
   }

   protected void dropFewItems(boolean var1, int var2) {
      int var3 = this.rand.nextInt(1 + var2);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.dropItem(ItemsDBC.BattleArmorHelmet04, 1);
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
