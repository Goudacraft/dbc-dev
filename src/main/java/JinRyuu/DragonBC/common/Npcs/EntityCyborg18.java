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
import net.minecraft.world.World;

public class EntityCyborg18 extends EntityCyborgsInf {
   public int randomSoundDelay = 0;
   public String tex;
   public final int AttPow = 500;
   public final int HePo = 5000;

   public EntityCyborg18(World var1) {
      super(var1);
      this.experienceValue = 200;
      this.tex = "c18";
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5000.0D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(500.0D);
   }

   public void initCreature() {
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/" + this.tex + ".png";
   }

   public long BattlePowerOld() {
      long var1 = 700000000L;
      int var3 = this.experienceValue * 100;
      long var4 = var1 + (long)this.rand.nextInt(100);
      return var4;
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
