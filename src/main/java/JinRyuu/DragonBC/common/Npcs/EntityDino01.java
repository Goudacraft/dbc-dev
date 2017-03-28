package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBCWildlifeA;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityDino01 extends EntityDBCWildlifeA implements IMob {
   public int randomSoundDelay = 0;
   public final int AttPow = 40;
   public final int HePo = 300;

   public EntityDino01(World var1) {
      super(var1);
      this.experienceValue = 50;
      this.yOffset *= 4.0F;
      this.setSize(this.width * 3.0F, this.height * 4.0F);
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(40.0D);
   }

   public void onUpdate() {
      if(this.randomSoundDelay > 0 && --this.randomSoundDelay == 0) {
         ;
      }

      super.onUpdate();
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/dino01.png";
   }

   public boolean getCanSpawnHere() {
      return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
   }

   protected Entity findPlayerToAttack() {
      return super.findPlayerToAttack();
   }

   public void onLivingUpdate() {
      super.onLivingUpdate();
   }

   protected void dropFewItems(boolean var1, int var2) {
      int var3 = this.rand.nextInt(2 + var2);
      this.dropItem(ItemsDBC.ItemDinoMeat, 1);

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

   protected boolean canDespawn() {
      return true;
   }
}
