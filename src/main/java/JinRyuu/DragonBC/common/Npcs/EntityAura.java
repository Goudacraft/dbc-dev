package JinRyuu.DragonBC.common.Npcs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntityAura extends Entity {
   public int randomSoundDelay;
   public long lightVert;
   private int lightLivingTime;
   private String mot;
   private boolean rot;
   private int Age;
   private int color;
   private int colorl2;
   private float state;
   private float state2;
   private int crel;
   private float yaw;
   private float pitch;
   private float alpha;
   private String tex;
   private String texl2;
   private int speed;
   private boolean inner;
   private int rendpass;

   public int getLightLivingTime() {
      return this.lightLivingTime;
   }

   public EntityAura(World var1) {
      super(var1);
      this.randomSoundDelay = 0;
      this.mot = "";
      this.rot = false;
      this.color = 16777215;
      this.colorl2 = 16777215;
      this.state = 0.0F;
      this.state2 = 0.0F;
      this.crel = 0;
      this.yaw = 0.0F;
      this.pitch = 0.0F;
      this.alpha = 0.1F;
      this.tex = "aura";
      this.texl2 = "";
      this.speed = 20;
      this.inner = true;
      this.rendpass = 1;
   }

   public EntityAura(World var1, String var2, int var3, float var4, float var5, int var6, boolean var7, float var8) {
      this(var1, var2, var3, var4, var5, var6, var7);
      this.alpha = var8;
   }

   public EntityAura(World var1, String var2, int var3, float var4, float var5, int var6, boolean var7) {
      this(var1, var2, var3, var4, var5, var6);
      this.rot = var7;
   }

   public EntityAura(World var1, String var2, int var3, float var4, float var5, int var6) {
      super(var1);
      this.randomSoundDelay = 0;
      this.mot = "";
      this.rot = false;
      this.color = 16777215;
      this.colorl2 = 16777215;
      this.state = 0.0F;
      this.state2 = 0.0F;
      this.crel = 0;
      this.yaw = 0.0F;
      this.pitch = 0.0F;
      this.alpha = 0.1F;
      this.tex = "aura";
      this.texl2 = "";
      this.speed = 20;
      this.inner = true;
      this.rendpass = 1;
      this.mot = var2;
      this.color = var3;
      this.state = var4;
      this.state2 = var5;
      this.crel = var6;
      this.lightVert = this.rand.nextLong();
      this.lightLivingTime = this.rand.nextInt(4) + 0;
   }

   public boolean shouldRenderInPass(int var1) {
      return var1 == this.rendpass;
   }

   @SideOnly(Side.CLIENT)
   public float getShadowSize() {
      return 0.0F;
   }

   public boolean getRot() {
      return this.rot;
   }

   public float getYaw() {
      return this.yaw;
   }

   public float getPitch() {
      return this.pitch;
   }

   public int getAge() {
      return this.Age;
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

   public int getCol() {
      return this.color;
   }

   public void setCol(int var1) {
      this.color = var1;
   }

   public int getColL2() {
      return this.colorl2;
   }

   public void setColL2(int var1) {
      this.colorl2 = var1;
   }

   public float getAlp() {
      return this.alpha;
   }

   public void setAlp(float var1) {
      this.alpha = var1;
   }

   public String getTex() {
      return this.tex;
   }

   public void setTex(String var1) {
      this.tex = var1;
   }

   public String getTexL2() {
      return this.texl2;
   }

   public void setTexL2(String var1) {
      this.texl2 = var1;
   }

   public int getSpd() {
      return this.speed;
   }

   public void setSpd(int var1) {
      this.speed = var1;
   }

   public boolean getInner() {
      return this.inner;
   }

   public void setInner(boolean var1) {
      this.inner = var1;
   }

   public void setRendPass(int var1) {
      this.rendpass = var1;
   }

   public void onUpdate() {
      if(this.mot.length() > 1) {
         EntityPlayer var1 = this.worldObj.getPlayerEntityByName(this.mot);
         if(var1 != null) {
            if(this.rot) {
               this.yaw = var1.rotationYaw;
               this.pitch = var1.rotationPitch;
            }

            this.setLocationAndAngles(var1.posX, var1.posY + (double)(var1 instanceof EntityPlayerSP?-1.6F:0.0F), var1.posZ, var1.rotationYaw, var1.rotationPitch);
            if(this.getAge() < this.getLightLivingTime() && this.getState() > 4.0F && this.getState() < 7.0F && this.getAge() == 2) {
               var1.playSound("jinryuudragonbc:1610.spark", 0.0625F, 0.85F + (float)this.lightLivingTime * 0.05F);
            }
         } else {
            this.setDead();
         }
      }

      if(this.Age++ >= this.speed) {
         this.setDead();
      }

   }

   public boolean getCanSpawnHere() {
      return !this.worldObj.checkNoEntityCollision(this.boundingBox);
   }

   public void onLivingUpdate() {
   }

   protected void readEntityFromNBT(NBTTagCompound var1) {
   }

   protected void writeEntityToNBT(NBTTagCompound var1) {
   }

   protected void entityInit() {
   }
}
