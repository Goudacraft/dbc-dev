package JinRyuu.DragonBC.common.Render;

import JinRyuu.JRMCore.JRMCoreH;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class ArtGravDevTileEntity_bkp extends TileEntity {
   private float gravity = 1.0F;
   public int gravityDevCB;

   public ArtGravDevTileEntity_bkp() {
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

   public void updateEntity() {
      super.updateEntity();
      if(this.gravity > 1.0F) {
         --this.gravityDevCB;
         if(this.gravityDevCB <= 0) {
            this.gravityDevCB = 20;
            if(!this.worldObj.isRemote) {
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

   }

   public void writeToNBT(NBTTagCompound var1) {
      super.writeToNBT(var1);
      this.writeSyncableDataToNBT(var1);
   }

   public void readFromNBT(NBTTagCompound var1) {
      super.readFromNBT(var1);
      this.readSyncableDataFromNBT(var1);
   }

   public Packet getDescriptionPacket() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.writeSyncableDataToNBT(var1);
      return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, var1);
   }

   public void onDataPacket(NetworkManager var1, S35PacketUpdateTileEntity var2) {
      this.readSyncableDataFromNBT(var2.func_148857_g());
   }
}
