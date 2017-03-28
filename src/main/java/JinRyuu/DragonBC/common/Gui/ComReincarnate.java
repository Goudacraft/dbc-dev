package JinRyuu.DragonBC.common.Gui;

import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHDBC;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class ComReincarnate extends CommandBase {
   public ComReincarnate() {
   }

   public String getCommandName() {
      return "dbcreincarnate";
   }

   public int getRequiredPermissionLevel() {
      return 2;
   }

   public void processCommand(ICommandSender var1, String[] var2) {
      if(var2.length < 0) {
         throw new WrongUsageException("/dbcreincarnate [playerName]", new Object[0]);
      } else {
         EntityPlayerMP var3;
         if(var2.length > 0) {
            var3 = getPlayer(var1, var2[0]);
         } else {
            var3 = getCommandSenderAsPlayer(var1);
         }

         JRMCoreHDBC.reincarnate(var3);
         String var4 = JRMCoreH.trlai("dbc", "reincarnated");
         ChatStyle var5 = (new ChatStyle()).setColor(EnumChatFormatting.YELLOW);
         var3.addChatMessage((new ChatComponentTranslation(var4, new Object[0])).setChatStyle(var5));
         this.notifyAdmins(var1, "%s reincarnated!", new Object[]{var3.getCommandSenderName()});
      }
   }

   private void notifyAdmins(ICommandSender var1, String var2, Object[] var3) {
      func_152373_a(var1, this, var2, var3);
   }

   public String getCommandUsage(ICommandSender var1) {
      return "/dbcreincarnate (playerName)";
   }

   public List addTabCompletionOptions(ICommandSender var1, String[] var2) {
      return var2.length == 1?getListOfStringsMatchingLastWord(var2, this.getListOfPlayers()):null;
   }

   protected String[] getListOfPlayers() {
      return MinecraftServer.getServer().getAllUsernames();
   }

   public boolean isUsernameIndex(int var1) {
      return var1 == 0;
   }
}
