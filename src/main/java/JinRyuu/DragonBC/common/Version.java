package JinRyuu.DragonBC.common;

public class Version {
   public static final String MOD_ID = "jinryuudragonblockc";
   public static final String MOD_NAME = "Dragon Block C";
   public static final String VERSION = "1.4.30";
   public static final String CHANNEL_NAME = "jinryuudragonblockc";
   public static final String BUILD_NUMBER = "@BUILD_NUMBER@";
   public static EnumUpdateState currentVersion = EnumUpdateState.CURRENT;
   private static String recommendedVersion;

   public Version() {
   }

   public static String getVersion() {
      return "1.4.30 (:@BUILD_NUMBER@)";
   }

   public static String getRecommendedVersion() {
      return recommendedVersion;
   }

   public static enum EnumUpdateState {
      CURRENT,
      OUTDATED,
      CONNECTION_ERROR;

      private EnumUpdateState() {
      }
   }
}
