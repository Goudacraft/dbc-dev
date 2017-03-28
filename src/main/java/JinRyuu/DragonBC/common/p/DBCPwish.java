package JinRyuu.DragonBC.common.p;

import JinRyuu.DragonBC.common.DBC;
import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.JRMCore.p.BAmh;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class DBCPwish implements IMessage {
   int i;
   String s;

   public DBCPwish() {
   }

   public DBCPwish(int var1, String var2) {
      this.i = var1;
      this.s = var2;
   }

   public void toBytes(ByteBuf var1) {
      var1.writeInt(this.i);
      ByteBufUtils.writeUTF8String(var1, this.s);
   }

   public void fromBytes(ByteBuf var1) {
      this.i = var1.readInt();
      this.s = ByteBufUtils.readUTF8String(var1);
   }

   public static class Handler extends BAmh<DBCPwish> {
      public Handler() {
      }

      public IMessage handleClientMessage(EntityPlayer var1, DBCPwish var2, MessageContext var3) {
         DBCClient.phc.handleDBCwish(var2.i, var2.s, var1);
         return null;
      }

      public IMessage handleServerMessage(EntityPlayer var1, DBCPwish var2, MessageContext var3) {
         DBC.phs.handleDBCwish(var2.i, var2.s, var1);
         return null;
      }
   }
}
