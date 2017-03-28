package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.Render.SpacePod01TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class DBCContainer extends Container {
   protected SpacePod01TileEntity tile_entity;

   public DBCContainer(SpacePod01TileEntity var1, InventoryPlayer var2) {
      this.tile_entity = var1;
      int var3 = 0;

      for(int var4 = 0; var4 < 3; ++var4) {
         for(int var5 = 0; var5 < 9; ++var5) {
            this.addSlotToContainer(new Slot(var1, var3, 9 + var5 * 18, 9 + var4 * 18));
            ++var3;
         }
      }

      this.bindPlayerInventory(var2);
   }

   public boolean canInteractWith(EntityPlayer var1) {
      return this.tile_entity.isUseableByPlayer(var1);
   }

   protected void bindPlayerInventory(InventoryPlayer var1) {
      for(int var2 = 0; var2 < 3; ++var2) {
         for(int var3 = 0; var3 < 9; ++var3) {
            this.addSlotToContainer(new Slot(var1, var3 + var2 * 9 + 9, 9 + var3 * 18, 85 + var2 * 16));
         }
      }

      for(int var4 = 0; var4 < 9; ++var4) {
         this.addSlotToContainer(new Slot(var1, var4, 6 + var4 * 16, 142));
      }

   }

   public ItemStack putStackInSlot(int var1) {
      ItemStack var2 = null;
      Slot var3 = (Slot)this.inventorySlots.get(var1);
      if(var3 != null && var3.getHasStack()) {
         ItemStack var4 = var3.getStack();
         var2 = var4.copy();
         if(var1 == 0) {
            if(!this.mergeItemStack(var4, 1, this.inventorySlots.size(), true)) {
               return null;
            }
         } else if(!this.mergeItemStack(var4, 0, 1, false)) {
            return null;
         }

         if(var4.stackSize == 0) {
            var3.putStack((ItemStack)null);
         } else {
            var3.onSlotChanged();
         }
      }

      return var2;
   }
}
