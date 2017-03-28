package JinRyuu.DragonBC.common.p;

import JinRyuu.DragonBC.common.DBC;
import JinRyuu.JRMCore.p.BAmh;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class DBCPenergy implements IMessage {
   byte b;
   byte b2;

   public DBCPenergy() {
   }

   public DBCPenergy(byte var1, byte var2) {
      this.b = var1;
      this.b2 = var2;
   }

   public void toBytes(ByteBuf var1) {
      var1.writeByte(this.b);
      var1.writeByte(this.b2);
   }

   public void fromBytes(ByteBuf var1) {
      this.b = var1.readByte();
      this.b2 = var1.readByte();
   }

   public static class Handler extends BAmh<DBCPenergy> {
      public Handler() {
      }

      public IMessage handleClientMessage(EntityPlayer var1, DBCPenergy var2, MessageContext var3) {
         return null;
      }

      public IMessage handleServerMessage(EntityPlayer var1, DBCPenergy var2, MessageContext var3) {
         DBC.phs.handleDBCenergy(var2.b, var2.b2, var1);
         return null;
      }
   }
}
