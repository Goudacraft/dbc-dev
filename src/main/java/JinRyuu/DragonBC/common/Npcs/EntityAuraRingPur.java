package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCKiAttacks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityAuraRingPur extends Entity {
   public int randomSoundDelay = 0;
   public int tex = 1;
   private Entity mot;
   int Age;
   int MaxAge = 7;

   public EntityAuraRingPur(World var1) {
      super(var1);
   }

   public EntityAuraRingPur(World var1, Entity var2) {
      super(var1);
      this.mot = var2;
   }

   @SideOnly(Side.CLIENT)
   public float getShadowSize() {
      return 0.0F;
   }

   public void onUpdate() {
      if(this.mot != null) {
         this.motionX = this.mot.motionX;
         this.motionY = this.mot.motionY;
         this.motionZ = this.mot.motionZ;
      }

      this.prevPosX = this.posX;
      this.prevPosY = this.posY;
      this.prevPosZ = this.posZ;
      if(this.Age++ >= this.MaxAge) {
         this.setDead();
      }

      this.motionY += 0.0D;
      if(this.posY == this.prevPosY) {
         this.motionX *= 1.0D;
         this.motionZ *= 1.0D;
      }

      if(!this.onGround) {
         this.motionX *= DBCKiAttacks.motX;
         this.motionZ *= DBCKiAttacks.motZ;
         this.motionY *= DBCKiAttacks.motY;
      }

      this.moveEntity(this.motionX * 2.0D, this.motionY * 2.0D, this.motionZ * 2.0D);
   }

   public boolean getCanSpawnHere() {
      return !this.worldObj.checkNoEntityCollision(this.boundingBox);
   }

   public void onLivingUpdate() {
   }

   protected void entityInit() {
   }

   protected void readEntityFromNBT(NBTTagCompound var1) {
   }

   protected void writeEntityToNBT(NBTTagCompound var1) {
   }
}
