package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.DragonBC.common.DBCEH;
import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.DBCKeyHandler;
import JinRyuu.DragonBC.common.DBCKiAttacks;
import JinRyuu.DragonBC.common.DBCKiTech;
import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Gui.DBCGuiSpacePod01;
import JinRyuu.DragonBC.common.Gui.ScouterGui;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntityMasterEnma;
import JinRyuu.DragonBC.common.Npcs.EntityMasterKaio;
import JinRyuu.DragonBC.common.Render.SpacePod01Entity;
import JinRyuu.DragonBC.common.p.DBCPdri;
import JinRyuu.DragonBC.common.p.DBCPscouter1;
import JinRyuu.DragonBC.common.p.DBCPscouter2;
import JinRyuu.DragonBC.common.p.DBCPscouter3;
import JinRyuu.DragonBC.common.p.DBCPscouter4;
import JinRyuu.DragonBC.common.p.DBCPspacepod1;
import JinRyuu.JRMCore.JRMCoreClient;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHC;
import JinRyuu.JRMCore.JRMCoreKeyHandler;
import JinRyuu.JRMCore.mod_JRMCore;
import JinRyuu.JRMCore.i.ExtendedPlayer;
import JinRyuu.JRMCore.p.PD;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class DBCClientTickHandler {
   private int kibar;
   private int testing = 0;
   public static int countT = 0;
   public static int warnT = 0;
   public static int startcountT = 0;
   public static int ScFunc0 = 0;
   public static int ScFunc00 = 0;
   public static int ScFunc01 = 0;
   public static int ScFunc02 = 0;
   public static int ScFunc03 = 0;
   public static int ScFunc04 = 0;
   public static int ScFunc05 = 0;
   public static int ScFuncSB = 0;
   public static int heightplus = 0;
   public static int tick = 0;
   public static int runOutOfKi = 0;
   public static int c = 0;
   public static boolean selected = false;
   public static short csicsu = 0;
   public static boolean KAchrgOn = false;
   private int previousTime = 0;
   private int currentTime = 0;
   private int countingValue = 0;
   public static int counterValue = 0;
   private static int ticking;
   private static int TiLess;
   private static int TiSen;
   private Minecraft mc = DBCClient.mc;
   public static int time = 0;
   public static int power = 0;
   public static int jump = 0;
   public static int ascend = 0;
   public static int pup = 0;
   public static int ptime = 0;
   public static int partnorm = 0;
   public static int inSuperTime = 0;
   public static int inSuperTime2 = 0;
   public static int inSuperTime3 = 0;
   public static float explevel;
   public static String textura;
   public static Item SuperHair;
   public static Item NormalHair;
   public static Block BlockHair01;
   private int check = 0;
   public int test = 0;
   private int timeincham;
   private boolean liedown;
   private int curHand;
   private static boolean inc;
   public static boolean charge = false;
   public static int charg = 0;
   public static int mountHelper = 0;

   public DBCClientTickHandler() {
   }

   public void onRenderTickInGUI(GuiScreen var1) {
      if(this.mc.thePlayer != null && this.testing == 1) {
         EntityClientPlayerMP var2 = Minecraft.getMinecraft().thePlayer;
         ItemStack var3 = var2.inventory.getCurrentItem();
         if(var3 != null && var3.getItem() == ItemsDBC.ItemDragonRadar) {
            DBCClient.SagaSys.renderDragonRadar();
            if(this.mc.gameSettings.thirdPersonView == 0) {
               ++tick;
               if(tick > 4) {
                  this.DragonRadar(this.mc.thePlayer);
                  if(tick > 5) {
                     tick = 0;
                     this.DragonRadar(this.mc.thePlayer);
                  }
               }
            }
         }

         ItemStack var4 = ExtendedPlayer.get(this.mc.thePlayer).inventory.getStackInSlot(2);
         if(JRMCoreH.armTypScoutAllOn(var4) && DBCKeyHandler.ScFunc.getIsKeyPressed()) {
            ++ScFuncSB;
            if(ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0) {
               ScFunc00 = 1;
               ScFuncSB = 0;
               System.out.println("1");
               KeyBinding var10000 = DBCKeyHandler.ScFunc;
               KeyBinding.unPressAllKeys();
            }

            if(ScFuncSB > 3 && ScFunc00 == 1 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0) {
               ScFuncSB = 0;
               KeyBinding var5 = DBCKeyHandler.ScFunc;
               KeyBinding.unPressAllKeys();
            }

            if(ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 1 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0) {
               ScFunc01 = 0;
               ScFunc02 = 1;
               ScFuncSB = 0;
               System.out.println("2");
               KeyBinding var6 = DBCKeyHandler.ScFunc;
               KeyBinding.setKeyBindState(DBCKeyHandler.ScFunc.getKeyCode(), false);
            }

            if(ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 1 && ScFunc03 == 0 && ScFunc04 == 0) {
               ScFunc02 = 0;
               ScFunc03 = 1;
               ScFuncSB = 0;
               System.out.println("3");
               KeyBinding var7 = DBCKeyHandler.ScFunc;
               KeyBinding.setKeyBindState(DBCKeyHandler.ScFunc.getKeyCode(), false);
            }

            if(ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 1 && ScFunc04 == 0) {
               ScFunc03 = 0;
               ScFunc04 = 1;
               ScFuncSB = 0;
               System.out.println("4");
               KeyBinding var8 = DBCKeyHandler.ScFunc;
               KeyBinding.setKeyBindState(DBCKeyHandler.ScFunc.getKeyCode(), false);
            }

            if(ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 1) {
               ScFunc04 = 0;
               ScFuncSB = 0;
               ScFunc00 = 0;
               System.out.println("0");
               KeyBinding var9 = DBCKeyHandler.ScFunc;
               KeyBinding.setKeyBindState(DBCKeyHandler.ScFunc.getKeyCode(), false);
            }
         }

         DBCClient.scouterGui.renderScouter();
      }

   }

   public static boolean onHotbar(Item var0, EntityPlayer var1) {
      for(int var2 = 0; var2 < 9; ++var2) {
         if(var1.inventory.getStackInSlot(var2) != null && var1.inventory.getStackInSlot(var2).getItem() == var0) {
            return true;
         }
      }

      return false;
   }

   public void onRenderTick() {
      this.currentTime = (int)(System.currentTimeMillis() / 1000L);
      if(this.currentTime != this.previousTime) {
         this.previousTime = this.currentTime;
         counterValue = this.countingValue;
         this.countingValue = 0;
      }

      if(this.currentTime == this.previousTime) {
         ++this.countingValue;
      }

      if(JRMCoreH.curTech1CD >= 0.0F) {
         JRMCoreH.curTech1CD -= 10.0F / (float)counterValue;
      }

      if(JRMCoreH.curTech1CD <= 0.0F) {
         JRMCoreH.curTech1CD = 0.0F;
      }

      if(JRMCoreH.curTech2CD >= 0.0F) {
         JRMCoreH.curTech2CD -= 10.0F / (float)counterValue;
      }

      if(JRMCoreH.curTech2CD <= 0.0F) {
         JRMCoreH.curTech2CD = 0.0F;
      }

      if(JRMCoreH.curTech3CD >= 0.0F) {
         JRMCoreH.curTech3CD -= 10.0F / (float)counterValue;
      }

      if(JRMCoreH.curTech3CD <= 0.0F) {
         JRMCoreH.curTech3CD = 0.0F;
      }

      if(JRMCoreH.curTech4CD >= 0.0F) {
         JRMCoreH.curTech4CD -= 10.0F / (float)counterValue;
      }

      if(JRMCoreH.curTech4CD <= 0.0F) {
         JRMCoreH.curTech4CD = 0.0F;
      }

      if(JRMCoreH.curTech5CD >= 0.0F) {
         JRMCoreH.curTech5CD -= 10.0F / (float)counterValue;
      }

      if(JRMCoreH.curTech5CD <= 0.0F) {
         JRMCoreH.curTech5CD = 0.0F;
      }

      if(JRMCoreH.curTech6CD >= 0.0F) {
         JRMCoreH.curTech6CD -= 10.0F / (float)counterValue;
      }

      if(JRMCoreH.curTech6CD <= 0.0F) {
         JRMCoreH.curTech6CD = 0.0F;
      }

      if(JRMCoreH.curTech7CD >= 0.0F) {
         JRMCoreH.curTech7CD -= 10.0F / (float)counterValue;
      }

      if(JRMCoreH.curTech7CD <= 0.0F) {
         JRMCoreH.curTech7CD = 0.0F;
      }

      if(JRMCoreH.curTech8CD >= 0.0F) {
         JRMCoreH.curTech8CD -= 10.0F / (float)counterValue;
      }

      if(JRMCoreH.curTech8CD <= 0.0F) {
         JRMCoreH.curTech8CD = 0.0F;
      }

      if(this.mc.inGameHasFocus) {
         Minecraft var10000 = this.mc;
         if(Minecraft.isGuiEnabled()) {
            EntityClientPlayerMP var1 = Minecraft.getMinecraft().thePlayer;
            ItemStack var2 = this.mc.thePlayer.inventory.getCurrentItem();
            if(var2 != null && var2.getItem() == ItemsDBC.ItemDragonRadar) {
               DBCClient.SagaSys.renderDragonRadar();
               if(this.mc.gameSettings.thirdPersonView == 0) {
                  ++tick;
                  if(tick > 8) {
                     this.DragonRadar(this.mc.thePlayer);
                     if(tick > 9) {
                        tick = 0;
                        this.DragonRadar(this.mc.thePlayer);
                     }
                  }
               }
            }

            ItemStack var3 = ExtendedPlayer.get(this.mc.thePlayer).inventory.getStackInSlot(2);
            if(var3 != null && JRMCoreH.armTypScoutAllOn(var3)) {
               if(DBCKeyHandler.ScFunc.getIsKeyPressed()) {
                  ++ScFuncSB;
                  if(ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 0) {
                     ScFunc00 = 1;
                     ScFuncSB = 0;
                     System.out.println("1");
                     KeyBinding var6 = DBCKeyHandler.ScFunc;
                     KeyBinding.unPressAllKeys();
                  }

                  if(ScFuncSB > 3 && ScFunc00 == 1 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 0) {
                     ScFuncSB = 0;
                     KeyBinding var7 = DBCKeyHandler.ScFunc;
                     KeyBinding.unPressAllKeys();
                  }

                  if(ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 1 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 0) {
                     ScFunc01 = 0;
                     ScFunc02 = 1;
                     ScFuncSB = 0;
                     System.out.println("2");
                     KeyBinding var8 = DBCKeyHandler.ScFunc;
                     KeyBinding.setKeyBindState(DBCKeyHandler.ScFunc.getKeyCode(), false);
                  }

                  if(ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 1 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 0) {
                     ScFunc02 = 0;
                     ScFunc03 = 1;
                     ScFuncSB = 0;
                     System.out.println("3");
                     KeyBinding var9 = DBCKeyHandler.ScFunc;
                     KeyBinding.setKeyBindState(DBCKeyHandler.ScFunc.getKeyCode(), false);
                  }

                  if(ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 1 && ScFunc04 == 0 && ScFunc05 == 0) {
                     ScFunc03 = 0;
                     ScFunc04 = 1;
                     ScFuncSB = 0;
                     System.out.println("4");
                     KeyBinding var10 = DBCKeyHandler.ScFunc;
                     KeyBinding.setKeyBindState(DBCKeyHandler.ScFunc.getKeyCode(), false);
                  }

                  if(ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 1 && ScFunc05 == 0) {
                     ScFunc04 = 0;
                     ScFunc05 = 1;
                     ScFuncSB = 0;
                     System.out.println("5");
                     KeyBinding var11 = DBCKeyHandler.ScFunc;
                     KeyBinding.setKeyBindState(DBCKeyHandler.ScFunc.getKeyCode(), false);
                  }

                  if(ScFuncSB > 3 && ScFunc00 == 0 && ScFunc01 == 0 && ScFunc02 == 0 && ScFunc03 == 0 && ScFunc04 == 0 && ScFunc05 == 1) {
                     ScFunc05 = 0;
                     ScFuncSB = 0;
                     ScFunc00 = 0;
                     System.out.println("0");
                     KeyBinding var12 = DBCKeyHandler.ScFunc;
                     KeyBinding.setKeyBindState(DBCKeyHandler.ScFunc.getKeyCode(), false);
                  }
               }
            } else if(DBCKeyHandler.ScFunc.isPressed() && JRMCoreH.SklLvl(6) > 0) {
               ++DBCEH.kisnsMd;
               if(DBCEH.kisnsMd > 4) {
                  DBCEH.kisnsMd = 0;
               }

               String var4 = JRMCoreH.trlai("dbc", "kisensemode" + DBCEH.kisnsMd);
               ChatStyle var5 = (new ChatStyle()).setColor(EnumChatFormatting.YELLOW);
               JRMCoreClient.mc.thePlayer.addChatMessage((new ChatComponentTranslation(var4, new Object[0])).setChatStyle(var5));
            }

            if(this.mc.gameSettings.thirdPersonView == 0) {
               DBCClient.scouterGui.renderScouter();
            }
         }
      }

   }

   public void DragonRadar(EntityPlayer var1) {
      Block var2 = null;
      if(var1.worldObj.provider.dimensionId == 20) {
         var2 = BlocksDBC.BlockNamekDragonBall;
      }

      if(var1.worldObj.provider.dimensionId == 0) {
         var2 = BlocksDBC.BlockDragonBall;
      }

      byte var3 = 64;
      int var4 = MathHelper.floor_double(var1.posX);
      int var5 = MathHelper.floor_double(var1.posZ);

      for(int var6 = var4 - var3; var6 <= var4 + var3; ++var6) {
         for(int var7 = var5 - var3; var7 <= var5 + var3; ++var7) {
            for(int var8 = 109; var8 >= 64; --var8) {
               if(var1.worldObj.getBlock(var6, var8, var7) == var2) {
                  int var9 = (int)var1.rotationPitch + 60;
                  if(var9 > 0) {
                     DBCClient.SagaSys.DragonDetect((double)var6 - var1.posX - (double)var9, (double)var7 - var1.posZ - (double)var9);
                  } else {
                     DBCClient.SagaSys.DragonDetect((double)var6 - var1.posX, (double)var7 - var1.posZ);
                  }
               }
            }
         }
      }

   }

   public void onTickInGUI() {
      GuiScreen var1 = this.mc.currentScreen;
      if(var1 instanceof GuiMainMenu) {
         ;
      }

      if(DBCGuiSpacePod01.ToEarth == 1 || DBCGuiSpacePod01.ToVegeta == 1 || DBCGuiSpacePod01.ToNamek == 1) {
         int var2 = DBCGuiSpacePod01.ToEarth == 1?3:(DBCGuiSpacePod01.ToVegeta == 1?2:(DBCGuiSpacePod01.ToNamek == 1?1:0));
         PD.sendToServer(new DBCPspacepod1(var2));
      }

   }

   public static void dri(int var0) {
      PD.sendToServer(new DBCPdri(var0));
   }

   public void changeCurEnAtSlct(int var1) {
      int var2 = JRMCoreH.mrAtts?8:4;
      if(var1 > 0) {
         var1 = 1;
      }

      if(var1 < 0) {
         var1 = -1;
      }

      for(JRMCoreH.EnAtSlct = (byte)(JRMCoreH.EnAtSlct - var1); JRMCoreH.EnAtSlct < 0; JRMCoreH.EnAtSlct = (byte)(JRMCoreH.EnAtSlct + var2)) {
         ;
      }

      while(JRMCoreH.EnAtSlct >= var2) {
         JRMCoreH.EnAtSlct = (byte)(JRMCoreH.EnAtSlct - var2);
      }

   }

   public void onTickInGameEnd() {
      if(this.mc.theWorld != null && this.mc.thePlayer != null && !this.mc.thePlayer.isDead) {
         ;
      }

   }

   public void onTickInGame() {
      EntityClientPlayerMP var1 = Minecraft.getMinecraft().thePlayer;
      WorldClient var2 = FMLClientHandler.instance().getClient().theWorld;
      if(this.mc.theWorld != null && this.mc.thePlayer != null && !this.mc.thePlayer.isDead) {
         if(this.mc.isIntegratedServerRunning()) {
            ;
         }

         if(mountHelper != 0) {
            var1.mountEntity(var1.worldObj.getEntityByID(mountHelper));
            if(var1.isRiding()) {
               mountHelper = 0;
            }
         }

         boolean var3 = false;
         if(var1.dimension == 23) {
            ++this.timeincham;
            if(this.timeincham >= 24000) {
               DBCKiAttacks.dbctick(-6);
               this.timeincham = 0;
               var1.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("dbc.HTC.toolong")));
            }

            var3 = true;
         }

         if(!var3) {
            this.timeincham = 0;
         }

         if(var1.dimension == 22) {
            AxisAlignedBB var4 = AxisAlignedBB.getBoundingBox(60.0D, 10.0D, 35.0D, 90.0D, 110.0D, 65.0D);
            List var5 = var2.getEntitiesWithinAABB(EntityMasterEnma.class, var4);
            if(var5.isEmpty()) {
               ;
            }

            if(var5.size() > 1) {
               for(int var6 = 1; var5.size() > var6; ++var6) {
                  Entity var7 = (Entity)var5.get(var6);
                  JRMCoreH.KAsounds(var7, 999);
               }
            }

            AxisAlignedBB var30 = AxisAlignedBB.getBoundingBox(87.0D, 1.0D, -3739.0D, 127.0D, 140.0D, -3699.0D);
            List var40 = var2.getEntitiesWithinAABB(EntityMasterKaio.class, var30);
            if(var40.isEmpty()) {
               ;
            }

            if(var40.size() > 1) {
               for(int var8 = 1; var40.size() > var8; ++var8) {
                  Entity var9 = (Entity)var40.get(var8);
                  JRMCoreH.KAsounds(var9, 999);
               }
            }
         }

         if(var1.dimension == 0) {
            AxisAlignedBB var26 = AxisAlignedBB.getBoundingBox(76.0D, 64.0D, 41.0D, 79.0D, 129.0D, 44.0D);
            List var28 = var1.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var26);

            for(int var31 = 0; var31 < var28.size(); ++var31) {
               EntityPlayer var41 = (EntityPlayer)var28.get(var31);
               if(var41.getCommandSenderName() == var1.getCommandSenderName()) {
                  float var48 = 0.15F;
                  if(var1.motionX < (double)(-var48)) {
                     var1.motionX = (double)(-var48);
                  }

                  if(var1.motionX > (double)var48) {
                     var1.motionX = (double)var48;
                  }

                  if(var1.motionZ < (double)(-var48)) {
                     var1.motionZ = (double)(-var48);
                  }

                  if(var1.motionZ > (double)var48) {
                     var1.motionZ = (double)var48;
                  }

                  var1.fallDistance = 0.0F;
                  if(var1.motionY < -0.15D) {
                     var1.motionY = -0.15D;
                  }

                  boolean var53 = var1.isSneaking() && var1 instanceof EntityPlayer;
                  if(var53 && var1.motionY < 0.0D) {
                     var1.motionY = 0.0D;
                  }

                  if(var1.isCollidedHorizontally) {
                     var1.motionY = 0.2D;
                  }
               }
            }
         }

         ItemStack var27 = var1.inventory.armorItemInSlot(3);
         ItemStack var29 = this.mc.thePlayer.inventory.getCurrentItem();
         if(var29 == null && DBCClient.mc.gameSettings.keyBindUseItem.getIsKeyPressed() && JRMCoreH.KASelected == 16 && !JRMCoreKeyHandler.KiCharge.getIsKeyPressed() && JRMCoreH.kiAmount > 0) {
            ;
         }

         if(DBCGuiSpacePod01.ToEarth == 1 || DBCGuiSpacePod01.ToVegeta == 1 || DBCGuiSpacePod01.ToNamek == 1) {
            int var32 = DBCGuiSpacePod01.ToEarth == 1?3:(DBCGuiSpacePod01.ToVegeta == 1?2:(DBCGuiSpacePod01.ToNamek == 1?1:0));
            PD.sendToServer(new DBCPspacepod1(var32));
         }

         if(ScFunc00 == 1) {
            ++ScFunc0;
            if(ScFunc0 == 2) {
               ScFunc01 = 0;
               ScFunc00 = 1;
               ScFunc02 = 0;
               ScFunc03 = 0;
               ScFunc04 = 0;
               ScFunc05 = 0;
               int var33 = var1.getEntityId();
               PD.sendToServer(new DBCPscouter1(var33));
            }

            if(ScFunc0 == 30) {
               ScFunc01 = 1;
               ScFunc00 = 0;
               ScFunc0 = 0;
            }
         }

         ScouterGui var10000 = DBCClient.scouterGui;
         if(ScouterGui.count == 1) {
            ++countT;
            if(countT == 5) {
               int var34 = var1.getEntityId();
               PD.sendToServer(new DBCPscouter2(var34));
               countT = 0;
            }
         }

         var10000 = DBCClient.scouterGui;
         if(ScouterGui.warn == 1) {
            ++warnT;
            if(warnT == 10) {
               int var35 = var1.getEntityId();
               PD.sendToServer(new DBCPscouter3(var35));
               warnT = 10;
            }
         }

         var10000 = DBCClient.scouterGui;
         if(ScouterGui.warn != 1) {
            warnT = 0;
         }

         var10000 = DBCClient.scouterGui;
         if(ScouterGui.startcount == 1) {
            ++startcountT;
            if(warnT == 10) {
               int var36 = var1.getEntityId();
               PD.sendToServer(new DBCPscouter4(var36));
               startcountT = 10;
            }
         }

         var10000 = DBCClient.scouterGui;
         if(ScouterGui.startcount != 1) {
            startcountT = 0;
         }

         if(DBCClient.mc.thePlayer.ridingEntity != null && DBCClient.mc.thePlayer.ridingEntity.getClass() == SpacePod01Entity.class && DBCClient.mc.gameSettings.keyBindPickBlock.getIsKeyPressed()) {
            DBCClient.mc.thePlayer.openGui(mod_DragonBC.instance, 0, DBCClient.mc.theWorld, (int)DBCClient.mc.thePlayer.posX, (int)DBCClient.mc.thePlayer.posY, (int)DBCClient.mc.thePlayer.posZ);
         }

         if(DBCClient.mc.thePlayer.ridingEntity != null) {
            if(DBCClient.mc.gameSettings.keyBindForward.getIsKeyPressed()) {
               JRMCoreH.forw = 1.0D;
               dri(1);
            } else if(DBCClient.mc.gameSettings.keyBindBack.getIsKeyPressed()) {
               JRMCoreH.forw = 2.0D;
               dri(2);
            }

            if(DBCClient.mc.gameSettings.keyBindLeft.getIsKeyPressed()) {
               JRMCoreH.forw = 1.0D;
               dri(5);
            } else if(DBCClient.mc.gameSettings.keyBindRight.getIsKeyPressed()) {
               JRMCoreH.forw = 2.0D;
               dri(6);
            }

            if(DBCClient.mc.gameSettings.keyBindJump.getIsKeyPressed() && DBCClient.mc.thePlayer.ridingEntity != null) {
               JRMCoreH.forw = 3.0D;
               dri(3);
            } else if(JRMCoreKeyHandler.Fn.getIsKeyPressed() && DBCClient.mc.thePlayer.ridingEntity != null) {
               JRMCoreH.forw = 4.0D;
               dri(4);
            } else {
               JRMCoreH.forw = 0.0D;
            }
         }

         if(JRMCoreH.PlyrPwr(var1) == 1) {
            if(JRMCoreH.curRelease != 0 && !JRMCoreH.StusEfctsMe(11)) {
               boolean var38 = DBCClient.mc.gameSettings.keyBindPickBlock.getIsKeyPressed();
               if(var29 == null && var38 && !DBCClient.mc.gameSettings.keyBindUseItem.getIsKeyPressed() && !JRMCoreH.isChrgng) {
                  byte var44 = 0;
                  if(JRMCoreKeyHandler.Fn.getIsKeyPressed()) {
                     var44 = 1;
                  }

                  DBCKiTech.EnAtSlct(var44);
                  KeyBinding var73 = DBCClient.mc.gameSettings.keyBindPickBlock;
                  KeyBinding.setKeyBindState(DBCClient.mc.gameSettings.keyBindPickBlock.getKeyCode(), false);
                  nuller();
               } else if(JRMCoreKeyHandler.Fn.getIsKeyPressed() && !DBCClient.mc.gameSettings.keyBindUseItem.getIsKeyPressed() && !JRMCoreH.isChrgng) {
                  int var43 = Mouse.getDWheel();
                  if(var43 != 0) {
                     this.changeCurEnAtSlct(var43);
                     var1.inventory.currentItem = this.curHand;
                     if(DBCClient.mc.gameSettings.noclip) {
                        if(var43 > 0) {
                           var43 = 1;
                        }

                        if(var43 < 0) {
                           var43 = -1;
                        }

                        DBCClient.mc.gameSettings.noclipRate += (float)var43 * 0.25F;
                     }
                  }

                  for(int var50 = 0; var50 < 8; ++var50) {
                     if(Keyboard.getEventKey() == 2 + var50) {
                        JRMCoreH.EnAtSlct = (byte)(JRMCoreH.mrAtts?var50:(var50 < 4?var50:var50 - 4));
                        var1.inventory.currentItem = this.curHand;
                     }
                  }

                  var1.inventory.currentItem = this.curHand;
                  nuller();
               }

               this.curHand = var1.inventory.currentItem;
               float var45 = DBCClient.mc.thePlayer.rotationPitch < 0.0F?(float)((int)DBCClient.mc.thePlayer.rotationPitch * -1):(float)((int)DBCClient.mc.thePlayer.rotationPitch);
               float var51 = DBCClient.mc.thePlayer.rotationYaw < 0.0F?(float)((int)DBCClient.mc.thePlayer.rotationYaw * -1):(float)((int)DBCClient.mc.thePlayer.rotationYaw);
               if((var45 <= DBCH.RotPic || var45 <= DBCH.RotPic + 0.1F) && (var45 >= DBCH.RotPic || var45 >= DBCH.RotPic - 0.1F) && (var51 <= DBCH.RotYaw || var51 <= DBCH.RotYaw + 0.1F) && (var51 >= DBCH.RotYaw || var51 >= DBCH.RotYaw - 0.1F)) {
                  boolean var75 = false;
               } else {
                  boolean var74 = true;
               }

               byte var10 = JRMCoreH.EnAtSlct;
               float var11 = JRMCoreH.curCDEnAt(var10);
               String[] var12 = JRMCoreH.tech(var10);
               if(var29 == null && DBCClient.mc.gameSettings.keyBindUseItem.getIsKeyPressed() && JRMCoreKeyHandler.Fn.getIsKeyPressed() && JRMCoreH.curEnergy > 0 && !JRMCoreKeyHandler.KiCharge.getIsKeyPressed() && var12 != null && DBCKiTech.KAkiEn(var10, JRMCoreH.curRelease, JRMCoreH.chrgPrc)) {
                  byte[] var57 = JRMCoreH.tech_statmods(var12[19]);
                  int var60 = JRMCoreH.techDBCty(var12);
                  if(!JRMCoreH.isShtng && var11 == 0.0F) {
                     JRMCoreH.isChrgng = JRMCoreH.techDBCctWc(var12, var57) > 10.0F;
                     int var61 = (int)(50.0F / JRMCoreH.techDBCctWc(var12, var57) * (float)JRMCoreH.charged);
                     int var16 = JRMCoreH.PlyrAttrbts[3];
                     int var17 = JRMCoreH.TransPwrModAtr(JRMCoreH.PlyrAttrbts, 3, JRMCoreH.State, JRMCoreH.State2, JRMCoreH.Race, JRMCoreH.PlyrSkillX, JRMCoreH.curRelease, JRMCoreH.getArcRsrv());
                     int var18 = JRMCoreH.stat(JRMCoreH.Pwrtyp, 4, var17, JRMCoreH.Race, JRMCoreH.Class, 0.0F);
                     float var19 = (float)(JRMCoreH.techDBCkic(var12, var18, var57) * JRMCoreH.chrgPrc) * 0.02F * (float)JRMCoreH.curRelease * 0.01F;
                     if(var12[0].equals("KAFakeMoon")) {
                        var19 = (float)Integer.parseInt(var12[7]);
                     }

                     if((float)JRMCoreH.curEnergy > var19) {
                        if(var61 > 50 && csicsu == csicsu / 5 * 5) {
                           ++csicsu;
                           ++JRMCoreH.charged;
                        } else if(var61 > 50) {
                           ++csicsu;
                        } else if(var61 <= 50) {
                           ++JRMCoreH.charged;
                        }
                     }

                     if(JRMCoreH.charged > 0 && JRMCoreH.curRelease > 0) {
                        JRMCoreH.cast = 50.0F / JRMCoreH.techDBCctWc(var12, var57) * (float)JRMCoreH.charged;
                        JRMCoreH.chrgPrc = (byte)((int)(JRMCoreH.cast > 100.0F?100.0F:JRMCoreH.cast));
                     }
                  }

                  ExtendedPlayer var62 = ExtendedPlayer.get(var1);
                  if(var62.getAnimKiShoot() != var60 + 1) {
                     DBCKiTech.triForce(3, var60 + 1, 0);
                     var62.setAnimKiShoot(var60 + 1);
                  }

                  if(var12.length > 12 && JRMCoreH.charged == 3 && !inc) {
                     inc = true;
                     JRMCoreH.quad(1, var10 > 3?10:Integer.parseInt(var12[3]), 0, Integer.parseInt(var12[12]) - (var10 > 3?1:0));
                  }
               } else if(var12 != null) {
                  byte[] var13 = JRMCoreH.tech_statmods(var12[19]);
                  if(DBCKiTech.KAkiEn(var10, JRMCoreH.curRelease, JRMCoreH.chrgPrc)) {
                     int var14 = JRMCoreH.techDBCty(var12);
                     boolean var15 = DBCClient.mc.thePlayer.motionX < 0.05D && DBCClient.mc.thePlayer.motionZ < 0.05D && DBCClient.mc.thePlayer.motionX > -0.05D && DBCClient.mc.thePlayer.motionZ > -0.05D && DBCClient.mc.thePlayer.motionY < 0.05D;
                     if(var14 == 0 && (float)JRMCoreH.charged > JRMCoreH.techDBCctWc(var12, var13) / 2.0F) {
                        if(var15) {
                           if((float)JRMCoreH.charged > JRMCoreH.techDBCctWc(var12, var13) / 2.0F && JRMCoreH.chrgPrc != 0 && !JRMCoreH.isShtng) {
                              DBCClient.mc.thePlayer.motionY *= 0.0D;
                              if(JRMCoreH.cDEnAt(var10, JRMCoreH.techDBCcd(var12, var13)) && JRMCoreH.curEnergy > 0) {
                                 DBCKiTech.EnAt((byte)10);
                                 JRMCoreH.isShtng = true;
                                 DBCKiTech.EnAt(var10, JRMCoreH.chrgPrc);
                                 nuller();
                              }
                           }
                        } else {
                           nuller();
                           DBCKiTech.EnAt((byte)11);
                        }
                     } else if((float)JRMCoreH.charged > JRMCoreH.techDBCctWc(var12, var13) / 2.0F && var14 == 1 && JRMCoreH.chrgPrc != 0) {
                        if(JRMCoreH.cDEnAt(var10, JRMCoreH.techDBCcd(var12, var13)) && JRMCoreH.curEnergy > 0) {
                           JRMCoreH.isShtng = true;
                           DBCKiTech.EnAt(var10, JRMCoreH.chrgPrc);
                           nuller();
                        }

                        JRMCoreH.isShtng = false;
                     } else if((float)JRMCoreH.charged > JRMCoreH.techDBCctWc(var12, var13) / 2.0F && var14 == 2 && JRMCoreH.chrgPrc != 0) {
                        if(JRMCoreH.cDEnAt(var10, JRMCoreH.techDBCcd(var12, var13)) && JRMCoreH.curEnergy > 0) {
                           JRMCoreH.isShtng = true;
                           DBCKiTech.EnAt(var10, JRMCoreH.chrgPrc);
                           nuller();
                        }

                        JRMCoreH.isShtng = false;
                     } else if((float)JRMCoreH.charged > JRMCoreH.techDBCctWc(var12, var13) / 2.0F && var14 == 3 && JRMCoreH.chrgPrc != 0) {
                        if(JRMCoreH.cDEnAt(var10, JRMCoreH.techDBCcd(var12, var13)) && JRMCoreH.curEnergy > 0) {
                           JRMCoreH.isShtng = true;
                           DBCKiTech.EnAt(var10, JRMCoreH.chrgPrc);
                           nuller();
                        }

                        JRMCoreH.isShtng = false;
                     } else if((float)JRMCoreH.charged > JRMCoreH.techDBCctWc(var12, var13) / 2.0F && var14 == 4 && JRMCoreH.chrgPrc != 0) {
                        if(JRMCoreH.cDEnAt(var10, JRMCoreH.techDBCcd(var12, var13)) && JRMCoreH.curEnergy > 0) {
                           JRMCoreH.isShtng = true;
                           DBCKiTech.EnAt(var10, JRMCoreH.chrgPrc);
                           nuller();
                        }

                        JRMCoreH.isShtng = false;
                     } else if((float)JRMCoreH.charged > JRMCoreH.techDBCctWc(var12, var13) / 2.0F && var14 == 5 && JRMCoreH.chrgPrc != 0) {
                        if(JRMCoreH.cDEnAt(var10, JRMCoreH.techDBCcd(var12, var13)) && JRMCoreH.curEnergy > 0) {
                           JRMCoreH.isShtng = true;
                           DBCKiTech.EnAt(var10, JRMCoreH.chrgPrc);
                           nuller();
                        }

                        JRMCoreH.isShtng = false;
                     } else if((float)JRMCoreH.charged > JRMCoreH.techDBCctWc(var12, var13) / 2.0F && var14 == 6 && JRMCoreH.chrgPrc != 0) {
                        if(JRMCoreH.cDEnAt(var10, JRMCoreH.techDBCcd(var12, var13)) && JRMCoreH.curEnergy > 0) {
                           JRMCoreH.isShtng = true;
                           DBCKiTech.EnAt(var10, JRMCoreH.chrgPrc);
                           nuller();
                        }

                        JRMCoreH.isShtng = false;
                     } else if(JRMCoreH.curRelease != 0) {
                        nuller();
                     }

                     if(!var15) {
                        JRMCoreH.isShtng = false;
                     }
                  }
               } else {
                  nuller();
                  JRMCoreH.isShtng = false;
               }

               if(!JRMCoreH.isShtng && !JRMCoreH.isChrgng) {
                  ExtendedPlayer var58 = ExtendedPlayer.get(var1);
                  if(var58.getAnimKiShoot() != 0) {
                     DBCKiTech.triForce(3, 0, 0);
                     var58.setAnimKiShoot(0);
                  }
               }

               DBCH.RotPic = var45;
               DBCH.RotYaw = var51;
               JRMCoreH.Fall();
               JRMCoreHC.Blocking();
               DBCKiTech.ChargeKi();
               DBCKiTech.JumpKi(DBCClient.mc.gameSettings.keyBindJump);
               DBCKiTech.FloatKi(JRMCoreKeyHandler.KiFlight, DBCClient.mc.gameSettings.keyBindJump, DBCClient.mc.gameSettings.keyBindSneak);
               DBCKiTech.TurboMode(JRMCoreKeyHandler.KiDash);
               DBCKiTech.DashKi(var1.isSprinting() || DBCKiTech.turbo);
               DBCKiTech.Ascend(JRMCoreKeyHandler.KiAscend);
               DBCKiTech.Descend(JRMCoreKeyHandler.KiDescend);
            } else {
               JRMCoreH.Fall();
               if(!JRMCoreH.StusEfctsMe(11)) {
                  DBCKiTech.Descend(JRMCoreKeyHandler.KiDescend);
                  DBCKiTech.DashKi(false);
               }

               DBCKiTech.ChargeKi();
               if(JRMCoreKeyHandler.KiFlight.getIsKeyPressed() || JRMCoreKeyHandler.KiDash.getIsKeyPressed() || JRMCoreKeyHandler.KiAscend.getIsKeyPressed()) {
                  String var37 = JRMCoreH.StusEfctsMe(11)?JRMCoreH.trl("dbc", "fusedspectator"):JRMCoreH.trl("dbc.clienttick.increltouseki");
                  String var42 = JRMCoreKeyHandler.KiCharge.getKeyDescription();
                  String var49 = String.format(var37, new Object[]{var42});
                  this.mc.thePlayer.addChatMessage(new ChatComponentText(var49));
                  KeyBinding var70 = JRMCoreKeyHandler.KiFlight;
                  KeyBinding.setKeyBindState(JRMCoreKeyHandler.KiFlight.getKeyCode(), false);
                  var70 = JRMCoreKeyHandler.KiDash;
                  KeyBinding.setKeyBindState(JRMCoreKeyHandler.KiDash.getKeyCode(), false);
                  var70 = JRMCoreKeyHandler.KiAscend;
                  KeyBinding.setKeyBindState(JRMCoreKeyHandler.KiAscend.getKeyCode(), false);
               }
            }

            if(JRMCoreH.Pwrtyp == 1 && !JRMCoreH.damInd.isEmpty() && JRMCoreH.SklLvl(6) > 0) {
               ArrayList var39 = new ArrayList();
               if(!JRMCoreH.damInd.isEmpty()) {
                  for(Entry var52 : JRMCoreH.damInd.entrySet()) {
                     String[] var54 = ((String)var52.getKey()).split(":");
                     String[] var55 = ((String)var52.getValue()).split(":");
                     double var56 = Double.parseDouble(var54[0]);
                     double var59 = Double.parseDouble(var54[1]);
                     double var63 = Double.parseDouble(var54[2]);
                     double var64 = Double.parseDouble(var55[0]);
                     float var65 = Float.parseFloat(var55[1]) - 1.0F;
                     var39.add(var52.getKey());
                     mod_JRMCore.proxy.generateDamIndParticles(var56, var59, var63, var64, var65);
                  }
               }

               for(int var47 = 0; var47 < var39.size(); ++var47) {
                  JRMCoreH.damInd.remove(var39.get(var47));
               }

               var39.clear();
            }
         }
      }

   }

   public static void nuller() {
      JRMCoreH.chrgPrc = 0;
      JRMCoreH.charged = 0;
      JRMCoreH.channel = 0;
      JRMCoreH.wave = 0;
      JRMCoreH.isChrgng = false;
      JRMCoreH.cast = 0.0F;
      csicsu = 0;
      inc = false;
   }

   @SubscribeEvent
   public void onTick(ClientTickEvent var1) {
      if(var1.phase.equals(Phase.START)) {
         this.onTickInGame();
      } else if(var1.phase.equals(Phase.END)) {
         this.onTickInGameEnd();
      }

   }

   @SubscribeEvent
   public void onRenderTick(RenderTickEvent var1) {
      if(var1.phase == Phase.END) {
         this.onRenderTick();
      }

   }
}
