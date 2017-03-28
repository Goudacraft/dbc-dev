package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.DBCLoc;
import JinRyuu.DragonBC.common.DBCLocHlp;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class DBCLocHand {
   public DBCLocHand() {
   }

   public static void LangLod() {
      for(String var3 : DBCLoc.localFiles) {
         String var4 = var3.replace("es_AR", "es_ES").replace("es_MX", "es_ES").replace("pt_BR", "pt_PT");
         LanguageRegistry.instance().loadLocalization(var4, DBCLocHlp.getLocFrmName(var3), DBCLocHlp.isXMLLangFil(var4));
      }

   }
}
