package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityDBC;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreH2;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDBCGood extends EntityDBC {
   public EntityDBCGood(World var1) {
      super(var1);
   }

   public void onDeath(DamageSource var1) {
      Entity var2 = var1.getEntity();
      if(var2 instanceof EntityPlayer) {
         int var3 = JRMCoreH.getByte((EntityPlayer)var2, "jrmcAlign");
         var3 = var3 - 20;
         var3 = var3 < 0?0:var3;
         JRMCoreH.setByte(var3, (EntityPlayer)var2, "jrmcAlign");
         int var4 = JRMCoreH.getInt((EntityPlayer)var2, "jrmcKarma");
         JRMCoreH.setInt(var4 + 1, (EntityPlayer)var2, "jrmcKarma");
         ((EntityPlayer)var2).addChatMessage((new ChatComponentTranslation(JRMCoreH.trlai("dbc.moreevil.line1"), new Object[0])).setChatStyle(JRMCoreH2.styl_wht));
      }

      super.onDeath(var1);
   }
}
