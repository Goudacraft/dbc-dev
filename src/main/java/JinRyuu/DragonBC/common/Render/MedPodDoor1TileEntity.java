package JinRyuu.DragonBC.common.Render;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class MedPodDoor1TileEntity extends TileEntity {
   private int cb = 0;

   public MedPodDoor1TileEntity() {
   }

   public boolean canUpdate() {
      return true;
   }

   public void writeToNBT(NBTTagCompound var1) {
      super.writeToNBT(var1);
      var1.setInteger("cb", this.cb);
   }

   public void readFromNBT(NBTTagCompound var1) {
      super.readFromNBT(var1);
      this.cb = var1.getInteger("cb");
   }

   public int getCb() {
      return this.cb;
   }

   public void setCb(int var1) {
      this.cb = var1;
   }

   public boolean shouldRenderInPass(int var1) {
      return var1 == 1;
   }

   public void updateEntity() {
      this.updateSound();
      super.updateEntity();
   }

   private void updateSound() {
      int var1 = this.getBlockMetadata();
      if(var1 > 3 && this.cb <= 20) {
         ++this.cb;
      }

      if(var1 < 4 && this.cb > 0) {
         --this.cb;
      }

   }
}
