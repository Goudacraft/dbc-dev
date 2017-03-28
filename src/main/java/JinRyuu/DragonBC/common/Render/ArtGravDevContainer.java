package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ArtGravDevContainer extends Container {
   private static int INV_START = 1;
   private static int INV_END = INV_START + 26;
   private static int HOTBAR_START = INV_END + 1;
   private static int HOTBAR_END = HOTBAR_START + 8;
   private ArtGravDevTileEntity tileFurnace;
   private int lastCookTime;
   private int lastBurnTime;
   private int lastItemBurnTime;

   public ArtGravDevContainer(InventoryPlayer var1, ArtGravDevTileEntity var2) {
      this.tileFurnace = var2;
      this.addSlotToContainer(new Slot(var2, 0, 5, 53));
      INV_START = 1;
      INV_END = INV_START;

      for(int var3 = 0; var3 < 3; ++var3) {
         for(int var4 = 0; var4 < 9; ++var4) {
            this.addSlotToContainer(new Slot(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            ++INV_END;
         }
      }

      --INV_END;
      HOTBAR_START = INV_END + 1;
      HOTBAR_END = HOTBAR_START;

      for(int var5 = 0; var5 < 9; ++var5) {
         this.addSlotToContainer(new Slot(var1, var5, 8 + var5 * 18, 142));
         ++HOTBAR_END;
      }

      --HOTBAR_END;
   }

   public void addCraftingToCrafters(ICrafting var1) {
      super.addCraftingToCrafters(var1);
      var1.sendProgressBarUpdate(this, 1, this.tileFurnace.furnaceBurnTime);
      var1.sendProgressBarUpdate(this, 2, this.tileFurnace.currentItemBurnTime);
   }

   public void detectAndSendChanges() {
      super.detectAndSendChanges();

      for(int var1 = 0; var1 < this.crafters.size(); ++var1) {
         ICrafting var2 = (ICrafting)this.crafters.get(var1);
         if(this.lastBurnTime != this.tileFurnace.furnaceBurnTime) {
            var2.sendProgressBarUpdate(this, 1, this.tileFurnace.furnaceBurnTime);
         }

         if(this.lastItemBurnTime != this.tileFurnace.currentItemBurnTime) {
            var2.sendProgressBarUpdate(this, 2, this.tileFurnace.currentItemBurnTime);
         }
      }

      this.lastBurnTime = this.tileFurnace.furnaceBurnTime;
      this.lastItemBurnTime = this.tileFurnace.currentItemBurnTime;
   }

   @SideOnly(Side.CLIENT)
   public void updateProgressBar(int var1, int var2) {
      if(var1 == 1) {
         this.tileFurnace.furnaceBurnTime = var2;
      }

      if(var1 == 2) {
         this.tileFurnace.currentItemBurnTime = var2;
      }

   }

   public boolean canInteractWith(EntityPlayer var1) {
      return this.tileFurnace.isUseableByPlayer(var1);
   }

   public ItemStack transferStackInSlot(EntityPlayer var1, int var2) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.inventorySlots.get(var2);
      if(var4 != null && var4.getHasStack()) {
         ItemStack var5 = var4.getStack();
         var3 = var5.copy();
         if(var2 != 0) {
            if(ArtGravDevTileEntity.isItemFuel(var5)) {
               if(!this.mergeItemStack(var5, 0, INV_START, false)) {
                  return null;
               }
            } else if(var2 >= INV_START && var2 < HOTBAR_START) {
               if(!this.mergeItemStack(var5, HOTBAR_START, HOTBAR_END + 1, false)) {
                  return null;
               }
            } else if(var2 >= HOTBAR_START && var2 < HOTBAR_END + 1 && !this.mergeItemStack(var5, INV_START, INV_END + 1, false)) {
               return null;
            }
         } else if(!this.mergeItemStack(var5, INV_START, HOTBAR_END + 1, false)) {
            return null;
         }

         if(var5.stackSize == 0) {
            var4.putStack((ItemStack)null);
         } else {
            var4.onSlotChanged();
         }

         if(var5.stackSize == var3.stackSize) {
            return null;
         }

         var4.onPickupFromSlot(var1, var5);
      }

      return var3;
   }
}
