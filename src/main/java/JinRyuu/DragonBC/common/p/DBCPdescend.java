package JinRyuu.DragonBC.common.p;

import JinRyuu.DragonBC.common.DBC;
import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.JRMCore.p.BAmh;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class DBCPdescend implements IMessage {
   byte i;

   public DBCPdescend() {
   }

   public DBCPdescend(byte var1) {
      this.i = var1;
   }

   public void toBytes(ByteBuf var1) {
      var1.writeByte(this.i);
   }

   public void fromBytes(ByteBuf var1) {
      this.i = var1.readByte();
   }

   public static class Handler extends BAmh<DBCPdescend> {
      public Handler() {
      }

      public IMessage handleClientMessage(EntityPlayer var1, DBCPdescend var2, MessageContext var3) {
         DBCClient.phc.handleDBCdescend(var2.i, var1);
         return null;
      }

      public IMessage handleServerMessage(EntityPlayer var1, DBCPdescend var2, MessageContext var3) {
         DBC.phs.handleDBCdescend(var2.i, var1);
         return null;
      }
   }
}
