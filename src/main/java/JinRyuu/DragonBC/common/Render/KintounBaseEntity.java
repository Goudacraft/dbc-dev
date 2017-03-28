package JinRyuu.DragonBC.common.Render;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class KintounBaseEntity extends Entity {
   private int cloudColor = 16777216;

   public int getCloudColor() {
      return this.cloudColor;
   }

   public void setCloudColor(int var1) {
      this.cloudColor = var1;
   }

   public KintounBaseEntity(World var1) {
      super(var1);
   }

   protected void entityInit() {
   }

   protected void readEntityFromNBT(NBTTagCompound var1) {
   }

   protected void writeEntityToNBT(NBTTagCompound var1) {
   }
}
