package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityCyborgsInf;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaFather;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.world.World;

public class EntityCell1 extends EntityCyborgsInf {
   public int randomSoundDelay = 0;
   public String tex;
   public final int AttPow = 1500;
   public final int HePo = 15000;
   private int wait = 0;
   private int m = 1;

   public EntityCell1(World var1) {
      super(var1);
      this.experienceValue = 200;
      this.tex = "cell1";
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15000.0D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1500.0D);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public void onLivingUpdate() {
      ++this.wait;
      List var1 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(32.0D, 32.0D, 32.0D));
      if(var1.size() > 0) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            EntityPlayer var3 = (EntityPlayer)var1.get(var2);
            if(var3 instanceof EntityPlayer) {
               this.becomeAngryAt(var3);
               if(this.wait == 100 * this.m) {
                  ++this.m;
                  if(!this.worldObj.isRemote) {
                     this.setPositionAndUpdate(var3.posX, var3.posY + 1.0D, var3.posZ);
                     this.worldObj.playSoundAtEntity(this, "jinryuudragonbc:DBC2.tp", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
                  }
               }
            }
         }
      }

      super.onLivingUpdate();
   }

   public void onDeath(DamageSource var1) {
      if(var1 instanceof EntityDamageSourceIndirect || var1 instanceof EntityDamageSource) {
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
      }

      super.onDeath(var1);
   }

   private void becomeAngryAt(Entity var1) {
      this.entityToAttack = var1;
      this.angerLevel = 400 + this.rand.nextInt(400);
      this.randomSoundDelay = this.rand.nextInt(40);
   }
}
