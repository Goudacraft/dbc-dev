package JinRyuu.DragonBC.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DBCCommonTickHandler {
   boolean charge = false;
   EntityPlayer player;
   protected WorldGenerator ChkInSt;
   protected WorldGenerator KiLt;
   protected WorldGenerator SnkWy;
   protected WorldGenerator TiCha;
   private int tick;

   public DBCCommonTickHandler() {
   }

   public void onPlayerTick(EntityPlayer var1) {
   }

   public String getLabel() {
      return null;
   }

   private NBTTagCompound nbt(EntityPlayer var1, String var2) {
      NBTTagCompound var3;
      if(var2.contains("pres")) {
         if(!var1.getEntityData().hasKey("PlayerPersisted")) {
            var3 = new NBTTagCompound();
            var1.getEntityData().setTag("PlayerPersisted", var3);
         } else {
            var3 = var1.getEntityData().getCompoundTag("PlayerPersisted");
         }
      } else {
         var3 = var1.getEntityData();
      }

      return var3;
   }

   public void onTickInGame() {
   }

   @SubscribeEvent
   public void onTick(ServerTickEvent var1) {
      if(var1.phase.equals(Phase.START)) {
         this.onTickInGame();
      }

   }
}
