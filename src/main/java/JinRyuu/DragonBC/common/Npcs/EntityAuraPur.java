package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.DBCKiAttacks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityAuraPur extends Entity {
   public int randomSoundDelay = 0;
   public int tex = 3;
   private Entity mot;
   int Age;
   int MaxAge = 20;

   public EntityAuraPur(World var1) {
      super(var1);
   }

   public EntityAuraPur(World var1, Entity var2) {
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

      boolean var1 = false;
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      if(this.worldObj.getBlock((int)this.posX, (int)this.posY, (int)this.posZ - 1).getMaterial() == Material.air) {
         var1 = true;
         var2 = (int)this.posX;
         var3 = (int)this.posY;
         var4 = (int)this.posZ;
      }

      this.prevPosX = this.posX;
      this.prevPosY = this.posY;
      this.prevPosZ = this.posZ;
      if(this.Age++ >= this.MaxAge) {
         if(var1) {
            ;
         }

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

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      String var1 = "";
      if(this.tex == 1) {
         var1 = "jinryuudragonbc:aurab.png";
      }

      if(this.tex == 2) {
         var1 = "jinryuudragonbc:auras.png";
      }

      if(this.tex == 3) {
         var1 = "jinryuudragonbc:aurap.png";
      }

      if(this.tex == 4) {
         var1 = "jinryuudragonbc:aurar.png";
      }

      return var1;
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
