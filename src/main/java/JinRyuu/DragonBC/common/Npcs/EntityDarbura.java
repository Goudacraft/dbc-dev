package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityDBCEvil;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaFather;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDarbura extends EntityDBCEvil {
   public int randomSoundDelay = 0;
   public String tex;
   public final int AttPow = 2400;
   public final int HePo = 24000;
   private int wait = 0;
   private int m = 1;
   private int target;

   public EntityDarbura(World var1) {
      super(var1);
      this.experienceValue = 200;
      this.tex = "darbura";
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(24000.0D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2400.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public long BattlePowerOld() {
      int var1 = -1364901888;
      int var2 = this.experienceValue * 100;
      long var3 = (long)(var1 + this.rand.nextInt((int)Math.pow(10.0D, (double)((var1 + "").length() - 2))));
      return var3;
   }

   public void target(int var1) {
      this.target = var1;
   }

   public void onLivingUpdate() {
      ++this.wait;
      List var1 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(16.0D, 16.0D, 16.0D));
      if(!var1.isEmpty()) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            Entity var3 = (Entity)var1.get(var2);
            this.becomeAngryAt(var3);
            if(this.wait == 200 * this.m) {
               ++this.m;
               if(!this.worldObj.isRemote) {
                  this.setPositionAndUpdate(var3.posX, var3.posY + 1.0D, var3.posZ);
                  this.worldObj.playSoundAtEntity(this, "jinryuudragonbc:DBC2.tp", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
               }
            }
         }
      }

      super.onLivingUpdate();
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

   private void becomeAngryAt(Entity var1) {
      this.entityToAttack = var1;
      this.angerLevel = 400 + this.rand.nextInt(400);
      this.randomSoundDelay = this.rand.nextInt(40);
   }
}
