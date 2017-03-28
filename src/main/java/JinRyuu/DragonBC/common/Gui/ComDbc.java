package JinRyuu.DragonBC.common.Gui;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.Worlds.WorldTeleporterDBCTelep;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHDBC;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ComDbc extends CommandBase {
   public ComDbc() {
   }

   public String getCommandName() {
      return "dbc";
   }

   public String getCommandUsage(ICommandSender var1) {
      return "Use \'/dbc locations\' or \'/dbc loc\' to receive the locations in DBC and Use \'/dbc accept\' to accept offers like revive with teleport.";
   }

   public int getRequiredPermissionLevel() {
      return 0;
   }

   public boolean canCommandSenderUseCommand(ICommandSender var1) {
      return true;
   }

   private NBTTagCompound nbt(EntityPlayer var1, String var2) {
      return JRMCoreH.nbt(var1, var2);
   }

   public void processCommand(ICommandSender var1, String[] var2) {
      if(var2.length <= 0) {
         throw new WrongUsageException("Use \'/dbc locations\' or \'/dbc loc\' to receive the locations in DBC and Use \'/dbc accept\' to accept offers like revive with teleport.", new Object[0]);
      } else {
         EntityPlayerMP var3 = getCommandSenderAsPlayer(var1);
         String var4 = var2[0];
         boolean var5 = var4.toLowerCase().contains("locations") || var4.toLowerCase().contains("loc");
         boolean var6 = var4.toLowerCase().contains("accept");
         boolean var7 = false;
         if(var5) {
            ChatStyle var8 = (new ChatStyle()).setColor(EnumChatFormatting.YELLOW);
            if(var3.dimension == 0) {
               String[] var9 = DBCH.genKH.split(";");
               String[] var10 = DBCH.genCA.split(";");
               String[] var11 = DBCH.genGH.split(";");
               String[] var12 = DBCH.genBS.split(";");
               var3.addChatMessage((new ChatComponentText(StatCollector.translateToLocal("dbc.com.loc.coords"))).setChatStyle(var8));
               var3.addChatMessage((new ChatComponentText(StatCollector.translateToLocal("dbc.com.loc.kami"))).setChatStyle(var8));
               if(var9.length > 2) {
                  var3.addChatMessage((new ChatComponentText(StatCollector.translateToLocal("dbc.com.loc.kame") + ": " + (JRMCoreH.parseInt(var9[0]) + DBCH.genKHnpc1[0]) + " " + (JRMCoreH.parseInt(var9[1]) + DBCH.genKHnpc1[1]) + " " + (JRMCoreH.parseInt(var9[2]) + DBCH.genKHnpc1[2]))).setChatStyle(var8));
               } else {
                  var3.addChatMessage((new ChatComponentText(StatCollector.translateToLocal("dbc.com.loc.kamenotexp"))).setChatStyle(var8));
               }

               if(var10.length > 2) {
                  var3.addChatMessage((new ChatComponentText(StatCollector.translateToLocal("dbc.com.loc.cell") + ": " + (JRMCoreH.parseInt(var10[0]) + DBCH.genCAnpc1[0]) + " " + (JRMCoreH.parseInt(var10[1]) + DBCH.genCAnpc1[1]) + " " + (JRMCoreH.parseInt(var10[2]) + DBCH.genCAnpc1[2]))).setChatStyle(var8));
               } else {
                  var3.addChatMessage((new ChatComponentText(StatCollector.translateToLocal("dbc.com.loc.cellnotexp"))).setChatStyle(var8));
               }

               if(var11.length > 2) {
                  var3.addChatMessage((new ChatComponentText(StatCollector.translateToLocal("dbc.com.loc.goku") + ": " + (JRMCoreH.parseInt(var11[0]) + DBCH.genGHnpc1[0]) + " " + (JRMCoreH.parseInt(var11[1]) + DBCH.genGHnpc1[1]) + " " + (JRMCoreH.parseInt(var11[2]) + DBCH.genGHnpc1[2]))).setChatStyle(var8));
               } else {
                  var3.addChatMessage((new ChatComponentText(StatCollector.translateToLocal("dbc.com.loc.gokunotexp"))).setChatStyle(var8));
               }

               if(var12.length > 2) {
                  var3.addChatMessage((new ChatComponentText(StatCollector.translateToLocal("dbc.com.loc.babidi") + ": " + (JRMCoreH.parseInt(var12[0]) + DBCH.genBSnpc1[0]) + " " + (JRMCoreH.parseInt(var12[1]) + DBCH.genBSnpc1[1]) + " " + (JRMCoreH.parseInt(var12[2]) + DBCH.genBSnpc1[2]))).setChatStyle(var8));
               } else {
                  var3.addChatMessage((new ChatComponentText(StatCollector.translateToLocal("dbc.com.loc.babidinotexp"))).setChatStyle(var8));
               }
            }

            if(var3.dimension == DBCConfig.planetNamek) {
               String var21 = DBCH.genFS.replace(";", " ");
               var3.addChatMessage((new ChatComponentText(StatCollector.translateToLocal("dbc.com.loc.coords"))).setChatStyle(var8));
               if(var21.length() > 3) {
                  var3.addChatMessage((new ChatComponentText(StatCollector.translateToLocal("dbc.com.loc.freeza") + ": " + var21)).setChatStyle(var8));
               } else {
                  var3.addChatMessage((new ChatComponentText(StatCollector.translateToLocal("dbc.com.loc.freezanotexp"))).setChatStyle(var8));
               }
            }
         }

         if(var6) {
            MinecraftServer var20 = FMLCommonHandler.instance().getMinecraftServerInstance();
            if(var3.dimension == DBCConfig.otherWorld && var3 != null && var3.ridingEntity == null && var3.riddenByEntity == null) {
               String[] var22 = JRMCoreH.getString(var3, "jrmcRevtpInit").split(";");
               if(var22.length > 3) {
                  String var23 = var22[0];
                  int var24 = Integer.parseInt(var22[1]);
                  int var13 = Integer.parseInt(var22[2]);
                  int var14 = Integer.parseInt(var22[3]);
                  int var15 = Integer.parseInt(var22[4]);
                  JRMCoreH.setByte(0, var3, "jrmcAlv");
                  var20.getConfigurationManager().transferPlayerToDimension(var3, var24, new WorldTeleporterDBCTelep(var20.worldServerForDimension(var24)));
                  var3.addExperience(1);
                  double[] var16 = new double[]{(double)var13, (double)var14, (double)var15};
                  var3.playerNetServerHandler.setPlayerLocation(var16[0], var16[1], var16[2], 0.0F, 0.0F);
                  System.out.println(var3.getCommandSenderName() + " revived by " + var23 + "!");
                  if(JRMCoreHDBC.DBCgetConfigDeadInv() && var3.worldObj.getGameRules().getGameRuleBooleanValue("keepInventory") && !var3.capabilities.isCreativeMode && JRMCoreH.getByte(var3, "jrmcAlv") == 1) {
                     JRMCoreH.nbt(var3).setTag("InventoryDead", var3.inventory.writeToNBT(new NBTTagList()));
                     var3.inventory.readFromNBT(JRMCoreH.nbt(var3).getTagList("InventoryLiving", 10));
                     var3.getEntityData().setTag("Inventory", var3.inventory.writeToNBT(new NBTTagList()));
                  }

                  EntityPlayerMP var17 = JRMCoreH.getPlayerForUsername(var20, var23);
                  if(var17 != null) {
                     String var18 = JRMCoreH.trlai("dbc", "reviveaccepted");
                     ChatStyle var19 = (new ChatStyle()).setColor(EnumChatFormatting.YELLOW);
                     var17.addChatMessage((new ChatComponentTranslation(var18, new Object[]{var3.getCommandSenderName(), JRMCoreH.trl("dbc", (String)DBCH.plntNms.get(Integer.valueOf(var24))), var13 + ", " + var14 + ", " + var15})).setChatStyle(var19));
                  }
               }
            }

            JRMCoreH.setString("e", var3, "jrmcRevtpInit");
         }

      }
   }

   private void notifyAdmins(ICommandSender var1, String var2, Object[] var3) {
      func_152373_a(var1, this, var2, var3);
   }
}
