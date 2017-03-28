package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Render.SpacePod01Entity;
import JinRyuu.DragonBC.common.p.DBCPspacepod1;
import JinRyuu.JRMCore.p.PD;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class WorldTeleporterDBCSpacePod01 extends Teleporter {
   private Random random;
   private WorldServer worldServerInstance;
   private Entity mo;

   public WorldTeleporterDBCSpacePod01(WorldServer var1, Entity var2) {
      super(var1);
      this.worldServerInstance = var1;
      this.random = new Random();
      this.mo = var2;
   }

   public void placeInPortal(Entity var1, double var2, double var4, double var6, float var8) {
      int var9 = MathHelper.floor_double(var1.posX + 1.0D);
      int var10 = MathHelper.floor_double(var1.posY);
      int var11 = MathHelper.floor_double(var1.posZ);
      int var12 = var9;
      int var13 = var11;

      for(int var14 = 250; var14 > 5; --var14) {
         if(this.worldServerInstance.getBlock(var12, var14, var13) != Blocks.air) {
            this.placeInExistingPortal(this.worldServerInstance, var1, var12, var14, var13);
            return;
         }
      }

   }

   public boolean placeInExistingPortal(World var1, Entity var2, int var3, int var4, int var5) {
      double var9 = (double)var3 + 0.5D;
      double var11 = (double)var4;
      double var13 = (double)var5 + 0.5D;
      var2.setLocationAndAngles(var9 + 0.0D, var11 + 20.0D, var13 + 0.0D, var2.rotationYaw, 0.0F);
      var2.motionX = var2.motionY = var2.motionZ = 0.0D;
      if(this.mo != null && this.mo.getClass() == SpacePod01Entity.class) {
         SpacePod01Entity var15 = new SpacePod01Entity(var1);
         var15.setLocationAndAngles(var9 + 0.0D, var11 + 20.0D, var13 + 0.0D, var2.rotationYaw, 0.0F);
         var1.spawnEntityInWorld(var15);
         var2.mountEntity(var15);
         PD.sendTo(new DBCPspacepod1(var15.getEntityId()), (EntityPlayerMP)var2);
      }

      return true;
   }
}
