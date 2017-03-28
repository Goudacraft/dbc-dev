package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.Gui.DBCGuiArtGravDev;
import JinRyuu.DragonBC.common.Gui.DBCGuiSpacePod01;
import JinRyuu.DragonBC.common.Gui.DBCKiGui;
import JinRyuu.DragonBC.common.Gui.DBCSAAGui;
import JinRyuu.DragonBC.common.Gui.DBCTalkGui;
import JinRyuu.DragonBC.common.Gui.DBCWishGui;
import JinRyuu.DragonBC.common.Render.ArtGravDevContainer;
import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
import JinRyuu.DragonBC.common.p.DBCPspacepod1;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.p.PD;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class DBCGuiHandler implements IGuiHandler {
   public static final int ArtGravDevGui = 5;

   public DBCGuiHandler() {
   }

   public Object getServerGuiElement(int var1, EntityPlayer var2, World var3, int var4, int var5, int var6) {
      if(var1 == 5) {
         TileEntity var7 = var3.getTileEntity(var4, var5, var6);
         return new ArtGravDevContainer(var2.inventory, (ArtGravDevTileEntity)var7);
      } else {
         if(var1 == 13) {
            PD.sendTo(new DBCPspacepod1(JRMCoreH.getInt(var2, "DBCSenzu")), (EntityPlayerMP)var2);
         }

         return null;
      }
   }

   public Object getClientGuiElement(int var1, EntityPlayer var2, World var3, int var4, int var5, int var6) {
      TileEntity var7 = var3.getTileEntity(var4, var5, var6);
      Object var8 = null;
      if(var1 == 0) {
         var8 = new DBCGuiSpacePod01(var4, var5, var6);
      }

      if(var1 == 1) {
         var8 = new DBCKiGui(var2.getEntityData().getInteger("DBCKiCharge"));
      }

      if(var1 == 2) {
         var8 = new DBCWishGui(1);
      }

      if(var1 == 3) {
         var8 = new DBCWishGui(2);
      }

      if(var1 == 5) {
         var8 = new DBCGuiArtGravDev(var2.inventory, (ArtGravDevTileEntity)var7);
      }

      if(var1 == 6) {
         var8 = new DBCSAAGui(1);
      }

      if(var1 == 7) {
         var8 = new DBCSAAGui(5);
      }

      if(var1 >= 10) {
         var8 = new DBCTalkGui(var1, var3, var4, var5, var6);
      }

      return var8;
   }
}
