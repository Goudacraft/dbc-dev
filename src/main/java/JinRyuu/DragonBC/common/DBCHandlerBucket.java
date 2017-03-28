package JinRyuu.DragonBC.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class DBCHandlerBucket {
   public static DBCHandlerBucket INSTANCE = new DBCHandlerBucket();
   public Map<Block, Item> buckets = new HashMap();

   public DBCHandlerBucket() {
   }

   @SubscribeEvent
   public void onBucketFill(FillBucketEvent var1) {
      ItemStack var2 = this.fillBucket(var1.world, var1.target);
      if(var2 != null) {
         var1.result = var2;
         var1.setResult(Result.ALLOW);
      }
   }

   private ItemStack fillBucket(World var1, MovingObjectPosition var2) {
      Block var3 = var1.getBlock(var2.blockX, var2.blockY, var2.blockZ);
      Item var4 = (Item)this.buckets.get(var3);
      if(var4 != null && var1.getBlockMetadata(var2.blockX, var2.blockY, var2.blockZ) == 0) {
         var1.setBlockToAir(var2.blockX, var2.blockY, var2.blockZ);
         return new ItemStack(var4);
      } else {
         return null;
      }
   }
}
