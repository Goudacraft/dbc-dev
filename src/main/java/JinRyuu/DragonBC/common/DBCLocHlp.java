package JinRyuu.DragonBC.common;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class DBCLocHlp {
   public DBCLocHlp() {
   }

   public static boolean isXMLLangFil(String var0) {
      return var0.endsWith(".xml");
   }

   public static String getLocFrmName(String var0) {
      return var0.substring(var0.lastIndexOf("/") + 1, var0.lastIndexOf("."));
   }

   public static String getLocStrng(String var0) {
      return LanguageRegistry.instance().getStringLocalization(var0);
   }
}
