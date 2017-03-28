package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Render.ArtGravDevBlock;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class ArtGravDevTileEntity extends TileEntity implements ISidedInventory {
   private static final int[] slotsBottom = new int[]{0};
   private ItemStack[] furnaceItemStacks = new ItemStack[1];
   public int furnaceBurnTime;
   public int currentItemBurnTime;
   private String tileEntityName;
   public static final int itemFuel = 0;
   private float gravity = 1.0F;
   public int gravityDevCB;

   public ArtGravDevTileEntity() {
   }

   public boolean canUpdate() {
      return true;
   }

   private void writeSyncableDataToNBT(NBTTagCompound var1) {
      var1.setFloat("gravity", this.gravity);
   }

   private void readSyncableDataFromNBT(NBTTagCompound var1) {
      this.gravity = var1.getFloat("gravity");
   }

   public float getGravity() {
      return this.gravity;
   }

   public void setGravity(float var1) {
      this.gravity = var1;
   }

   public Packet getDescriptionPacket() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.writeSyncableDataToNBT(var1);
      return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, var1);
   }

   public void onDataPacket(NetworkManager var1, S35PacketUpdateTileEntity var2) {
      this.readSyncableDataFromNBT(var2.func_148857_g());
   }

   public int getSizeInventory() {
      return this.furnaceItemStacks.length;
   }

   public ItemStack getStackInSlot(int var1) {
      return this.furnaceItemStacks[var1];
   }

   public ItemStack decrStackSize(int var1, int var2) {
      if(this.furnaceItemStacks[var1] != null) {
         if(this.furnaceItemStacks[var1].stackSize <= var2) {
            ItemStack var4 = this.furnaceItemStacks[var1];
            this.furnaceItemStacks[var1] = null;
            return var4;
         } else {
            ItemStack var3 = this.furnaceItemStacks[var1].splitStack(var2);
            if(this.furnaceItemStacks[var1].stackSize == 0) {
               this.furnaceItemStacks[var1] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack getStackInSlotOnClosing(int var1) {
      if(this.furnaceItemStacks[var1] != null) {
         ItemStack var2 = this.furnaceItemStacks[var1];
         this.furnaceItemStacks[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void setInventorySlotContents(int var1, ItemStack var2) {
      this.furnaceItemStacks[var1] = var2;
      if(var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
         var2.stackSize = this.getInventoryStackLimit();
      }

   }

   public String getInventoryName() {
      return this.hasCustomInventoryName()?this.tileEntityName:BlocksDBC.ArtGravDevBlock.getUnlocalizedName() + ".name";
   }

   public boolean hasCustomInventoryName() {
      return this.tileEntityName != null && this.tileEntityName.length() > 0;
   }

   public void func_145951_a(String var1) {
      this.tileEntityName = var1;
   }

   public void readFromNBT(NBTTagCompound var1) {
      super.readFromNBT(var1);
      this.readSyncableDataFromNBT(var1);
      NBTTagList var2 = var1.getTagList("Items", 10);
      this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

      for(int var3 = 0; var3 < var2.tagCount(); ++var3) {
         NBTTagCompound var4 = var2.getCompoundTagAt(var3);
         byte var5 = var4.getByte("Slot");
         if(var5 >= 0 && var5 < this.furnaceItemStacks.length) {
            this.furnaceItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
         }
      }

      this.furnaceBurnTime = var1.getShort("BurnTime");
      this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[0]);
      if(var1.hasKey("CustomName", 8)) {
         this.tileEntityName = var1.getString("CustomName");
      }

   }

   public void writeToNBT(NBTTagCompound var1) {
      super.writeToNBT(var1);
      this.writeSyncableDataToNBT(var1);
      var1.setShort("BurnTime", (short)this.furnaceBurnTime);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.furnaceItemStacks.length; ++var3) {
         if(this.furnaceItemStacks[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.setByte("Slot", (byte)var3);
            this.furnaceItemStacks[var3].writeToNBT(var4);
            var2.appendTag(var4);
         }
      }

      var1.setTag("Items", var2);
      if(this.hasCustomInventoryName()) {
         var1.setString("CustomName", this.tileEntityName);
      }

   }

   public int getInventoryStackLimit() {
      return 64;
   }

   @SideOnly(Side.CLIENT)
   public int getBurnTimeRemainingScaled(int var1) {
      if(this.currentItemBurnTime == 0) {
         this.currentItemBurnTime = 200;
      }

      return this.furnaceBurnTime * var1 / this.currentItemBurnTime;
   }

   public boolean isBurning() {
      return this.furnaceBurnTime > 0;
   }

   public void updateEntity() {
      boolean var1 = this.furnaceBurnTime > 0;
      boolean var2 = false;
      if(this.furnaceBurnTime > 0) {
         --this.furnaceBurnTime;
      }

      if(!this.worldObj.isRemote) {
         if(this.gravity > 1.0F && this.isBurning()) {
            --this.gravityDevCB;
            if(this.gravityDevCB <= 0) {
               this.gravityDevCB = 20;
               byte var3 = 10;
               AxisAlignedBB var4 = AxisAlignedBB.getBoundingBox((double)this.xCoord - (double)var3, (double)this.yCoord - (double)var3, (double)this.zCoord - (double)var3, (double)this.xCoord + (double)var3, (double)this.yCoord + (double)var3, (double)this.zCoord + (double)var3);
               List var5 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var4);
               if(!var5.isEmpty()) {
                  for(int var6 = 0; var6 < var5.size(); ++var6) {
                     EntityPlayer var7 = (EntityPlayer)var5.get(var6);
                     int var8 = (int)(System.currentTimeMillis() / 1000L) + 1;
                     JRMCoreH.setInt(var8, var7, "jrmcGravZoneLast");
                     float var9 = JRMCoreH.getFloat(var7, "jrmcGravForce");
                     if(this.gravity > var9) {
                        JRMCoreH.setFloat(this.gravity, var7, "jrmcGravForce");
                     }
                  }
               }
            }
         }

         if((this.furnaceBurnTime != 0 || this.furnaceItemStacks[0] != null) && this.furnaceBurnTime == 0 && this.canSmelt()) {
            this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[0]);
            if(this.furnaceBurnTime > 0) {
               var2 = true;
               if(this.furnaceItemStacks[0] != null) {
                  --this.furnaceItemStacks[0].stackSize;
                  if(this.furnaceItemStacks[0].stackSize == 0) {
                     this.furnaceItemStacks[0] = this.furnaceItemStacks[0].getItem().getContainerItem(this.furnaceItemStacks[0]);
                  }
               }
            }
         }

         if(var1 != this.furnaceBurnTime > 0) {
            var2 = true;
            ArtGravDevBlock.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
         }
      }

      if(var2) {
         this.markDirty();
      }

   }

   private boolean canSmelt() {
      return this.furnaceItemStacks[0] == null?false:this.gravity > 1.0F;
   }

   public void smeltItem() {
      if(this.canSmelt() && this.gravity > 1.0F) {
         --this.gravityDevCB;
         if(this.gravityDevCB <= 0) {
            this.gravityDevCB = 20;
            byte var1 = 10;
            AxisAlignedBB var2 = AxisAlignedBB.getBoundingBox((double)this.xCoord - (double)var1, (double)this.yCoord - (double)var1, (double)this.zCoord - (double)var1, (double)this.xCoord + (double)var1, (double)this.yCoord + (double)var1, (double)this.zCoord + (double)var1);
            List var3 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var2);
            if(!var3.isEmpty()) {
               for(int var4 = 0; var4 < var3.size(); ++var4) {
                  EntityPlayer var5 = (EntityPlayer)var3.get(var4);
                  int var6 = (int)(System.currentTimeMillis() / 1000L) + 1;
                  JRMCoreH.setInt(var6, var5, "jrmcGravZoneLast");
                  float var7 = JRMCoreH.getFloat(var5, "jrmcGravForce");
                  if(this.gravity > var7) {
                     JRMCoreH.setFloat(this.gravity, var5, "jrmcGravForce");
                  }
               }
            }
         }
      }

   }

   public static int getItemBurnTime(ItemStack var0) {
      if(var0 == null) {
         return 0;
      } else {
         Item var1 = var0.getItem();
         if(var1 instanceof ItemBlock && Block.getBlockFromItem(var1) != Blocks.air) {
            Block var2 = Block.getBlockFromItem(var1);
            if(var2 == Blocks.wooden_slab) {
               return 150;
            }

            if(var2.getMaterial() == Material.wood) {
               return 300;
            }

            if(var2 == Blocks.coal_block) {
               return 16000;
            }
         }

         return var1 instanceof ItemTool && ((ItemTool)var1).getToolMaterialName().equals("WOOD")?200:(var1 instanceof ItemSword && ((ItemSword)var1).getToolMaterialName().equals("WOOD")?200:(var1 instanceof ItemHoe && ((ItemHoe)var1).getToolMaterialName().equals("WOOD")?200:(var1 == Items.stick?100:(var1 == Items.coal?1600:(var1 == Items.lava_bucket?20000:(var1 == Item.getItemFromBlock(Blocks.sapling)?100:(var1 == Items.blaze_rod?2400:GameRegistry.getFuelValue(var0))))))));
      }
   }

   public static boolean isItemFuel(ItemStack var0) {
      return getItemBurnTime(var0) > 0;
   }

   public boolean isUseableByPlayer(EntityPlayer var1) {
      return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this?false:var1.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
   }

   public void openInventory() {
   }

   public void closeInventory() {
   }

   public boolean isItemValidForSlot(int var1, ItemStack var2) {
      return var1 == 2?false:(var1 == 1?isItemFuel(var2):true);
   }

   public int[] getAccessibleSlotsFromSide(int var1) {
      return slotsBottom;
   }

   public boolean canInsertItem(int var1, ItemStack var2, int var3) {
      return this.isItemValidForSlot(var1, var2);
   }

   public boolean canExtractItem(int var1, ItemStack var2, int var3) {
      return var3 != 0 || var1 != 1 || var2.getItem() == Items.bucket;
   }
}
