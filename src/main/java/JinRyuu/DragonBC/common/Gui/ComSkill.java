package JinRyuu.DragonBC.common.Gui;

import JinRyuu.JRMCore.JRMCoreH;
import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class ComSkill extends CommandBase {
   public ComSkill() {
   }

   public String getCommandName() {
      return "dbcskill";
   }

   public int getRequiredPermissionLevel() {
      return 2;
   }

   public void processCommand(ICommandSender var1, String[] var2) {
      if(var2.length < 2) {
         String var22 = "";

         for(int var23 = 0; var23 < JRMCoreH.vlblSklsNms.length; ++var23) {
            var22 = var22 + ", " + JRMCoreH.vlblSklsNms[var23];
         }

         throw new WrongUsageException("/dbcskill (give or take) (skillName) [playerName] OR /dbcskill take all [playerName] --> skillNames can be: " + var22, new Object[0]);
      } else {
         String var3 = var2[0];
         boolean var4 = var3.toLowerCase().contentEquals("give");
         boolean var5 = var3.toLowerCase().contentEquals("take");
         int var6 = -1;

         for(int var7 = 0; var7 < JRMCoreH.vlblSklsNms.length; ++var7) {
            if(var2[1].toLowerCase().equals(JRMCoreH.vlblSklsNms[var7].toLowerCase())) {
               var6 = var7;
               break;
            }
         }

         EntityPlayerMP var24;
         if(var2.length > 2) {
            var24 = getPlayer(var1, var2[2]);
         } else {
            var24 = getCommandSenderAsPlayer(var1);
         }

         NBTTagCompound var8 = JRMCoreH.nbt(var24, "pres");
         byte var10 = JRMCoreH.getByte(var24, "jrmcPwrtyp");
         String[] var11 = new String[JRMCoreH.SkillsNbt.length];

         for(byte var12 = 0; var12 < JRMCoreH.SkillsNbt.length; ++var12) {
            if(var8.getString(JRMCoreH.SkillsNbt[var12]) == null) {
               var8.setString(JRMCoreH.SkillsNbt[var12], "pty");
            }

            var11[var12] = var8.getString(JRMCoreH.SkillsNbt[var12]);
         }

         int[] var25 = JRMCoreH.PlyrAttrbts(var24);
         String[] var13 = JRMCoreH.vlblSkls;
         int[][] var14 = JRMCoreH.vlblSklsLvl;
         String[] var15 = JRMCoreH.vlblSklsNms;
         if(var4) {
            boolean var16 = false;
            int var17 = JRMCoreH.SklSlt(var25[4]);
            var17 = var17 > 10?10:var17;
            int var18 = 0;

            for(byte var19 = 0; var19 < 10; ++var19) {
               if(var11[var19].contains(var13[var6])) {
                  var16 = true;
               }

               if(!var11[var19].contains("pty")) {
                  ++var18;
               }
            }

            if(var16) {
               String var35 = JRMCoreH.trlai("jrmc", "alreadyhaveskill");
               ChatStyle var20 = (new ChatStyle()).setColor(EnumChatFormatting.YELLOW);
               var24.addChatMessage((new ChatComponentTranslation(var35, new Object[0])).setChatStyle(var20));
               this.notifyAdmins(var1, "%s already has skill %s", new Object[]{var24.getCommandSenderName(), var15[var6]});
            } else if(var18 >= var17) {
               String var36 = JRMCoreH.trlai("jrmc", "noslotleft");
               ChatStyle var39 = (new ChatStyle()).setColor(EnumChatFormatting.YELLOW);
               var24.addChatMessage((new ChatComponentTranslation(var36, new Object[0])).setChatStyle(var39));
               this.notifyAdmins(var1, "%s has no slot left for skill %s", new Object[]{var24.getCommandSenderName(), var15[var6]});
            } else {
               for(byte var37 = 0; var37 < 10; ++var37) {
                  if(var11[var37].contains("pty")) {
                     var8.setString(JRMCoreH.SkillsNbt[var37], var13[var6] + "0");
                     String var40 = JRMCoreH.trlai("jrmc", "skilladded");
                     ChatStyle var21 = (new ChatStyle()).setColor(EnumChatFormatting.YELLOW);
                     var24.addChatMessage((new ChatComponentTranslation(var40, new Object[]{var15[var6]})).setChatStyle(var21));
                     this.notifyAdmins(var1, "%s has received skill %s", new Object[]{var24.getCommandSenderName(), var15[var6]});
                     break;
                  }
               }
            }
         }

         if(var5) {
            if(var6 >= 0) {
               for(byte var26 = 0; var26 < 10; ++var26) {
                  if(var11[var26].contains(var13[var6])) {
                     if(var8.getString(JRMCoreH.SkillsNbt[var26]).contains(var13[8])) {
                        String var29 = var8.getString("jrmcSettings");
                        String var32 = JRMCoreH.PlyrSttngs[0];
                        var8.setString("jrmcSettings", var29.contains(var32)?var29.replace(var32, ""):var29);
                     }

                     var8.setString(JRMCoreH.SkillsNbt[var26], "pty");
                     String var30 = var15[var6];
                     String var33 = "Skill " + var30 + " removed";
                     ChatStyle var38 = (new ChatStyle()).setColor(EnumChatFormatting.YELLOW);
                     var24.addChatMessage((new ChatComponentText(var33)).setChatStyle(var38));
                     this.notifyAdmins(var1, "%s\'s skill %s has been removed!", new Object[]{var24.getCommandSenderName(), var30});
                  }
               }
            } else {
               for(byte var27 = 0; var27 < 10; ++var27) {
                  var8.setString(JRMCoreH.SkillsNbt[var27], "pty");
                  String var31 = JRMCoreH.trlai("jrmc", "skillallremoved");
                  ChatStyle var34 = (new ChatStyle()).setColor(EnumChatFormatting.YELLOW);
                  var24.addChatMessage((new ChatComponentText(var31)).setChatStyle(var34));
                  this.notifyAdmins(var1, "%s\'s all skill has been removed!", new Object[]{var24.getCommandSenderName()});
               }
            }
         }

      }
   }

   private void notifyAdmins(ICommandSender var1, String var2, Object[] var3) {
      func_152373_a(var1, this, var2, var3);
   }

   public String getCommandUsage(ICommandSender var1) {
      return "/dbcsaga reset (playerName)";
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
