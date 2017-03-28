package JinRyuu.DragonBC.common.Npcs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityAuraRing extends Entity {
   public int randomSoundDelay = 0;
   public int tex = 1;
   private String mot = "";
   int Age;
   int MaxAge = 20;
   int color = 16777215;
   private float state = 0.0F;
   private float state2 = 0.0F;
   int crel = 0;
   float alpha = 0.1F;

   public EntityAuraRing(World var1) {
      super(var1);
   }

   public boolean shouldRenderInPass(int var1) {
      return var1 == 1;
   }

   public EntityAuraRing(World var1, String var2, int var3, float var4, float var5, int var6) {
      super(var1);
      this.mot = var2;
      this.color = var3;
      this.state = var4;
      this.state2 = var5;
      this.crel = var6;
   }

   @SideOnly(Side.CLIENT)
   public float getShadowSize() {
      return 0.0F;
   }

   public int getAge() {
      return this.Age;
   }

   public int getCol() {
      return this.color;
   }

   public float getState() {
      return this.state;
   }

   public float getState2() {
      return this.state2;
   }

   public float getCRel() {
      return (float)this.crel;
   }

   public void setCol(int var1) {
      this.color = var1;
   }

   public float getAlp() {
      return this.alpha;
   }

   public void setAlp(float var1) {
      this.alpha = var1;
   }

   public void onUpdate() {
      if(this.mot.length() > 1) {
         EntityPlayer var1 = this.worldObj.getPlayerEntityByName(this.mot);
         if(var1 != null) {
            this.setLocationAndAngles(var1.posX, var1.posY + (double)(var1 instanceof EntityPlayerSP?-1.6F:0.0F), var1.posZ, 0.0F, 0.0F);
         } else {
            this.setDead();
         }
      }

      if(this.Age++ >= this.MaxAge) {
         this.setDead();
      }

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
