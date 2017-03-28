package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.JRMCore.JRMCoreH;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityHealingPods extends TileEntity {
   private int timer = 100;

   public TileEntityHealingPods() {
   }

   public void updateEntity() {
      if(!this.worldObj.isRemote) {
         --this.timer;
         if(this.timer <= 0) {
            float var1 = 1.0F;
            AxisAlignedBB var2 = this.getRenderBoundingBox();
            List var3 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var2);

            for(int var4 = 0; var4 < var3.size(); ++var4) {
               EntityPlayer var5 = (EntityPlayer)var3.get(var4);
               int[] var6 = JRMCoreH.PlyrAttrbts(var5);
               byte var7 = JRMCoreH.getByte(var5, "jrmcPwrtyp");
               byte var8 = JRMCoreH.getByte(var5, "jrmcRace");
               byte var9 = JRMCoreH.getByte(var5, "jrmcClass");
               int var10 = JRMCoreH.stat(var7, 2, var6[2], var8, var9, 0.0F);
               int var11 = JRMCoreH.getInt(var5, "jrmcBdy");
               int var12 = JRMCoreH.stat(var7, 5, var6[5], var8, var9, 0.0F);
               int var13 = JRMCoreH.getInt(var5, "jrmcEnrgy");
               int var14 = JRMCoreH.stat(var7, 3, var6[2], var8, var9, 0.0F);
               int var15 = JRMCoreH.getInt(var5, "jrmcStamina");
               float var16 = 20.0F - var5.getHealth();
               if((float)var11 - var16 > 0.0F) {
                  var5.setHealth(var5.getHealth() + var16);
               }

               if(var11 < var10) {
                  float var17 = (float)(var11 + DBCConfig.healingpodhealingrate);
                  JRMCoreH.setInt(var17 > (float)var10?(float)var10:var17, var5, "jrmcBdy");
               }

               if(var13 < var12) {
                  float var18 = (float)(var13 + DBCConfig.healingpodhealingrate);
                  JRMCoreH.setInt(var18 > (float)var12?(float)var12:var18, var5, "jrmcEnrgy");
               }

               if(var15 < var14) {
                  float var19 = (float)(var15 + DBCConfig.healingpodhealingrate);
                  JRMCoreH.setInt(var19 > (float)var14?(float)var14:var19, var5, "jrmcStamina");
               }

               if(var5.getFoodStats().needFood()) {
                  var5.getFoodStats().addStats(1, 0.5F);
               }
            }

            this.timer = 100;
         }
      }

      super.updateEntity();
   }

   public void readFromNBT(NBTTagCompound var1) {
      super.readFromNBT(var1);
   }

   public void writeToNBT(NBTTagCompound var1) {
      super.writeToNBT(var1);
   }
}
