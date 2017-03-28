package JinRyuu.DragonBC.common.p;

import JinRyuu.DragonBC.common.DBC;
import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.JRMCore.p.BAmh;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class DBCPduo implements IMessage {
   int i;
   int i2;

   public DBCPduo() {
   }

   public DBCPduo(int var1, int var2) {
      this.i = var1;
      this.i2 = var2;
   }

   public void toBytes(ByteBuf var1) {
      var1.writeInt(this.i);
      var1.writeInt(this.i2);
   }

   public void fromBytes(ByteBuf var1) {
      this.i = var1.readInt();
      this.i2 = var1.readInt();
   }

   public static class Handler extends BAmh<DBCPduo> {
      public Handler() {
      }

      public IMessage handleClientMessage(EntityPlayer var1, DBCPduo var2, MessageContext var3) {
         DBCClient.phc.handleDBCjumpsound(var2.i, var2.i2, var1);
         return null;
      }

      public IMessage handleServerMessage(EntityPlayer var1, DBCPduo var2, MessageContext var3) {
         DBC.phs.handleDBCjumpsound(var2.i, var2.i2, var1);
         return null;
      }
   }
}
