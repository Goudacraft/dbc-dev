package JinRyuu.DragonBC.common.Render;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class SpacePod01TileEntity extends TileEntity implements IInventory {
   private ItemStack[] inventory = new ItemStack[27];

   public SpacePod01TileEntity() {
   }

   public int getSizeInventory() {
      return this.inventory.length;
   }

   public ItemStack getStackInSlot(int var1) {
      return this.inventory[var1];
   }

   public void setInventorySlotContents(int var1, ItemStack var2) {
      this.inventory[var1] = var2;
      if(var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
         var2.stackSize = this.getInventoryStackLimit();
      }

   }

   public ItemStack decrStackSize(int var1, int var2) {
      ItemStack var3 = this.getStackInSlot(var1);
      if(var3 != null) {
         if(var3.stackSize <= var2) {
            this.setInventorySlotContents(var1, (ItemStack)null);
         } else {
            var3 = var3.splitStack(var2);
            if(var3.stackSize == 0) {
               this.setInventorySlotContents(var1, (ItemStack)null);
            }
         }
      }

      return var3;
   }

   public ItemStack getStackInSlotOnClosing(int var1) {
      ItemStack var2 = this.getStackInSlot(var1);
      if(var2 != null) {
         this.setInventorySlotContents(var1, (ItemStack)null);
      }

      return var2;
   }

   public int getInventoryStackLimit() {
      return 64;
   }

   public boolean isUseableByPlayer(EntityPlayer var1) {
      return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && var1.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) < 64.0D;
   }

   public boolean isStackValidForSlot(int var1, ItemStack var2) {
      return false;
   }

   public boolean isItemValidForSlot(int var1, ItemStack var2) {
      return false;
   }

   public boolean canUpdate() {
      return false;
   }

   public String getInventoryName() {
      return null;
   }

   public boolean hasCustomInventoryName() {
      return false;
   }

   public void openInventory() {
   }

   public void closeInventory() {
   }
}
