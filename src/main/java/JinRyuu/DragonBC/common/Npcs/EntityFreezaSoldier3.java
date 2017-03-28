package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldiers;
import JinRyuu.DragonBC.common.Npcs.EntityNamekian01;
import JinRyuu.DragonBC.common.Npcs.EntityNamekian03;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityFreezaSoldier3 extends EntityFreezaSoldiers {
   public int randomSoundDelay = 0;
   public final int AttPow = 20;
   public final int HePo = 200;

   public EntityFreezaSoldier3(World var1) {
      super(var1);
      this.experienceValue = 5;
      this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityNamekian01.class, 200, false));
      this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityNamekian03.class, 200, false));
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0D);
   }

   public void onDeath(DamageSource var1) {
      Entity var2 = var1.getEntity();
      if(var2 instanceof EntityPlayer) {
         ;
      }

      super.onDeath(var1);
   }

   public void onUpdate() {
      if(this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
         ;
      }

      super.onUpdate();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/soldier3.png";
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
      return this.target != null?this.target:(this.angerLevel == 0?null:super.findPlayerToAttack());
   }

   public void onLivingUpdate() {
      super.onLivingUpdate();
   }

   protected void dropFewItems(boolean var1, int var2) {
      int var3 = this.rand.nextInt(1);
      if(var3 != 0) {
         this.dropItem(ItemsDBC.BattleArmorHelmet04, 1);
      }

      var3 = this.rand.nextInt(2 + var2);

      for(int var4 = 0; var4 < var3; ++var4) {
         ;
      }

   }

   public boolean interact(EntityPlayer var1) {
      return false;
   }
}
