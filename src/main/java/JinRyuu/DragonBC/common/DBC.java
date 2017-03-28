package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.DBCCommonTickHandler;
import JinRyuu.DragonBC.common.p.DBCPacketHandlerServer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import java.io.File;
import net.minecraft.world.storage.SaveHandler;

public class DBC {
   public static SaveHandler saveHandler;
   public static DBCPacketHandlerServer phs = new DBCPacketHandlerServer();

   public DBC() {
   }

   public void initialize() {
      FMLCommonHandler.instance().bus().register(new DBCCommonTickHandler());
   }

   public void postInit() {
   }

   public void registerRenderThings() {
   }

   public void registerTicks() {
   }

   public void registerKeys() {
   }

   public String getMinecraftVersion() {
      return Loader.instance().getMinecraftModContainer().getVersion();
   }

   public File getMinecraftDir() {
      return new File(".");
   }

   public void registerDBCRender() {
   }
}
