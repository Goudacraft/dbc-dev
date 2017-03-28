package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityDBCWildlife extends EntityDBC {
   public EntityDBCWildlife(World var1) {
      super(var1);
   }

   protected NBTTagCompound nbt(EntityPlayer var1, String var2) {
      NBTTagCompound var3;
      if(var2.contains("pres")) {
         if(!var1.getEntityData().hasKey("PlayerPersisted")) {
            var3 = new NBTTagCompound();
            var1.getEntityData().setTag("PlayerPersisted", var3);
         } else {
            var3 = var1.getEntityData().getCompoundTag("PlayerPersisted");
         }
      } else {
         var3 = var1.getEntityData();
      }

      return var3;
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.0D);
   }

   public void writeEntityToNBT(NBTTagCompound var1) {
      super.writeEntityToNBT(var1);
      var1.setShort("Anger", (short)this.angerLevel);
   }

   public void readEntityFromNBT(NBTTagCompound var1) {
      super.readEntityFromNBT(var1);
      this.angerLevel = var1.getShort("Anger");
   }

   protected void becomeAngryAt(Entity var1) {
      this.entityToAttack = var1;
      this.angerLevel = 400 + this.rand.nextInt(400);
   }
}
