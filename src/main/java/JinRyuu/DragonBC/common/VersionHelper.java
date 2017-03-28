package JinRyuu.DragonBC.common;

public class VersionHelper {
   public static final byte UNINITIALIZED = 0;
   public static final byte CURRENT = 1;
   public static final byte OUTDATED = 2;
   public static final byte CONNECTION_ERROR = 3;
   private static final String VERSION_CHECK_DISABLED = "version check_disabled";
   private static final String VERSION_CHECK_INIT_LOG_MESSAGE = "version init_log_message";
   private static final String UNINITIALIZED_MESSAGE = "version uninitialized";
   private static final String CURRENT_MESSAGE = "version current";
   private static final String OUTDATED_MESSAGE = "version outdated";
   private static final String CONNECTION_ERROR_MESSAGE = "version connection_error";
   public static byte result = 0;
   public static String line = null;

   public VersionHelper() {
   }

   public static String getResultMessage() {
      return result == 0?"version uninitialized":(result == 1?"Your Version Is Updated":(result == 2?"There is a New Version Available!":(result == 3?"Cannot connect to server!":null)));
   }
}
