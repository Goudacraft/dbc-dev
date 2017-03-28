package JinRyuu.DragonBC.common.Worlds;

import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class WorldTeleporterDBCTelep extends Teleporter {
   private Random random;
   private WorldServer worldServerInstance;

   public WorldTeleporterDBCTelep(WorldServer var1) {
      super(var1);
      this.worldServerInstance = var1;
      this.random = new Random();
   }

   public void placeInPortal(Entity var1, double var2, double var4, double var6, float var8) {
      int var9 = MathHelper.floor_double(var1.posX + 1.0D);
      int var10 = MathHelper.floor_double(var1.posY);
      int var11 = MathHelper.floor_double(var1.posZ);
      int var12 = var9;
      int var14 = var11;

      for(int var13 = 250; var13 > 5; --var13) {
         if(this.worldServerInstance.getBlock(var12, var13, var14) != Blocks.air) {
            this.placeInExistingPortal(this.worldServerInstance, var1, var12, var13, var14);
            return;
         }
      }

   }

   public boolean placeInExistingPortal(World var1, Entity var2, int var3, int var4, int var5) {
      double var9 = (double)var3 + 0.5D;
      double var11 = (double)var4 + 0.5D + 4.0D;
      double var13 = (double)var5 + 0.5D;
      var2.setLocationAndAngles(var9 + 0.0D, var11 + 2.0D, var13 + 0.0D, var2.rotationYaw, 0.0F);
      var2.motionX = var2.motionY = var2.motionZ = 0.0D;
      var9 = var9 - 3.0D;
      var13 = var13 - 3.0D;
      return true;
   }
}
