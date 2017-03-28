package JinRyuu.DragonBC.common.p;

import JinRyuu.DragonBC.common.DBC;
import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.JRMCore.p.BAmh;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class DBCPchargepart implements IMessage {
   byte dbcchargepart;
   String dbcCharger;

   public DBCPchargepart() {
   }

   public DBCPchargepart(byte var1, String var2) {
      this.dbcchargepart = var1;
      this.dbcCharger = var2;
   }

   public void toBytes(ByteBuf var1) {
      var1.writeByte(this.dbcchargepart);
      ByteBufUtils.writeUTF8String(var1, this.dbcCharger);
   }

   public void fromBytes(ByteBuf var1) {
      this.dbcchargepart = var1.readByte();
      this.dbcCharger = ByteBufUtils.readUTF8String(var1);
   }

   public static class Handler extends BAmh<DBCPchargepart> {
      public Handler() {
      }

      public IMessage handleClientMessage(EntityPlayer var1, DBCPchargepart var2, MessageContext var3) {
         DBCClient.phc.handleDBCchargepart(var2.dbcchargepart, var2.dbcCharger, var1);
         return null;
      }

      public IMessage handleServerMessage(EntityPlayer var1, DBCPchargepart var2, MessageContext var3) {
         DBC.phs.handleDBCchargepart(var2.dbcchargepart, var2.dbcCharger, var1);
         return null;
      }
   }
}
