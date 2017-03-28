package JinRyuu.DragonBC.common.Render;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityChest;

public class DragonBlockNamek01TileEntity extends TileEntityChest {
   private int cb = 100;

   public DragonBlockNamek01TileEntity() {
   }

   public boolean canUpdate() {
      return true;
   }

   public void writeToNBT(NBTTagCompound var1) {
      super.writeToNBT(var1);
   }

   public void readFromNBT(NBTTagCompound var1) {
      super.readFromNBT(var1);
   }

   public boolean shouldRenderInPass(int var1) {
      return var1 == 0;
   }

   public void updateEntity() {
      this.updateSound();
      super.updateEntity();
   }

   private void updateSound() {
      --this.cb;
      if(this.cb <= 0) {
         this.cb = 100;
         int var1 = this.xCoord;
         int var2 = this.yCoord;
         int var3 = this.zCoord;
         Block var4 = this.worldObj.getBlock(var1, var2, var3);
         if(!this.worldObj.isRemote) {
            if(this.worldObj.getBlock(var1 + 1, var2, var3) == var4) {
               if(this.worldObj.getBlock(var1 + 1, var2, var3 + 1) == var4 && this.worldObj.getBlock(var1 + 1, var2, var3 - 1) == var4 && this.worldObj.getBlock(var1 - 1, var2, var3) == var4 && this.worldObj.getBlock(var1 - 1, var2, var3 - 1) == var4 && this.worldObj.getBlock(var1 - 1, var2, var3 + 1) == var4) {
                  this.worldObj.playSoundEffect((double)var1, (double)var2, (double)var3, "jinryuudragonbc:dragon.glow", 1.0F, 1.0F);
               }
            } else if(this.worldObj.getBlock(var1, var2, var3 + 1) == var4 && this.worldObj.getBlock(var1 + 1, var2, var3 + 1) == var4 && this.worldObj.getBlock(var1 + 1, var2, var3 - 1) == var4 && this.worldObj.getBlock(var1, var2, var3 - 1) == var4 && this.worldObj.getBlock(var1 - 1, var2, var3 - 1) == var4 && this.worldObj.getBlock(var1 - 1, var2, var3 + 1) == var4) {
               this.worldObj.playSoundEffect((double)var1, (double)var2, (double)var3, "jinryuudragonbc:dragon.glow", 1.0F, 1.0F);
            }
         }
      }

   }
}
