package JinRyuu.DragonBC.common.p;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.DBCH;
import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Entitys.EntityEnergyFM;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntityBarta;
import JinRyuu.DragonBC.common.Npcs.EntityBuuFat;
import JinRyuu.DragonBC.common.Npcs.EntityBuuSuper;
import JinRyuu.DragonBC.common.Npcs.EntityCell1;
import JinRyuu.DragonBC.common.Npcs.EntityCell2;
import JinRyuu.DragonBC.common.Npcs.EntityCell3;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg16;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg17;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg18;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg19;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg20;
import JinRyuu.DragonBC.common.Npcs.EntityDBCKami;
import JinRyuu.DragonBC.common.Npcs.EntityDarbura;
import JinRyuu.DragonBC.common.Npcs.EntityDodoria;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza1;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaFather;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaMecha;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier1;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier2;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier3;
import JinRyuu.DragonBC.common.Npcs.EntityGinyu;
import JinRyuu.DragonBC.common.Npcs.EntityGuldo;
import JinRyuu.DragonBC.common.Npcs.EntityJeice;
import JinRyuu.DragonBC.common.Npcs.EntityKiwi;
import JinRyuu.DragonBC.common.Npcs.EntityMasterGoku;
import JinRyuu.DragonBC.common.Npcs.EntityPuipui;
import JinRyuu.DragonBC.common.Npcs.EntityRecoome;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyanNappa;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyanRaditz;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyanVegeta;
import JinRyuu.DragonBC.common.Npcs.EntityYakon;
import JinRyuu.DragonBC.common.Npcs.EntityZarbon;
import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
import JinRyuu.DragonBC.common.Render.SpacePod01Entity;
import JinRyuu.DragonBC.common.Worlds.WorldTeleporterDBCSpacePod01;
import JinRyuu.DragonBC.common.Worlds.WorldTeleporterDBCTelep;
import JinRyuu.DragonBC.common.p.DBCPascendsound;
import JinRyuu.DragonBC.common.p.DBCPchargepart;
import JinRyuu.DragonBC.common.p.DBCPdescendsound;
import JinRyuu.DragonBC.common.p.DBCPduo;
import JinRyuu.DragonBC.common.p.DBCPscouter1;
import JinRyuu.DragonBC.common.p.DBCPscouter2;
import JinRyuu.DragonBC.common.p.DBCPscouter3;
import JinRyuu.DragonBC.common.p.DBCPscouter4;
import JinRyuu.DragonBC.common.p.DBCPspacepod1;
import JinRyuu.DragonBC.common.p.DBCPtick;
import JinRyuu.DragonBC.common.p.DBCPwish;
import JinRyuu.JRMCore.JRMCoreConfig;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHDBC;
import JinRyuu.JRMCore.entity.EntityEnergyAtt;
import JinRyuu.JRMCore.i.ExtendedPlayer;
import JinRyuu.JRMCore.p.PD;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;

public class DBCPacketHandlerServer {
   public static ChatStyle styl = (new ChatStyle()).setColor(EnumChatFormatting.YELLOW);
   public double explosionX;
   public double explosionY;
   public double explosionZ;
   public float explosionSize;
   public List chunkPositionRecords;
   public float playerVelocityX;
   public float playerVelocityY;
   public float playerVelocityZ;
   public boolean expGriOff;
   public double expDam;
   public Entity origin;
   static final int SHENL = 0;
   static final int PORUN = 1;

   public DBCPacketHandlerServer() {
   }

   public void handleDBCenergy(byte var1, byte var2, EntityPlayer var3) {
      if(var1 == 10) {
         JRMCoreH.setByte(1, var3, "jrmcFrng");
      } else if(var1 == 11) {
         JRMCoreH.setByte(0, var3, "jrmcFrng");
      } else {
         String var4 = JRMCoreH.getString(var3, JRMCoreH.techNbt[var1]);
         if(var1 >= 0 && var1 <= 7) {
            byte var5 = JRMCoreH.getByte(var3, "jrmcRelease");
            if(var5 > 0) {
               int[] var6 = JRMCoreH.PlyrAttrbts(var3);
               String[] var7 = new String[JRMCoreH.PlyrSkills.length];

               for(byte var8 = 0; var8 < JRMCoreH.SkillsNbt.length; ++var8) {
                  var7[var8] = JRMCoreH.getString(var3, JRMCoreH.SkillsNbt[var8]);
               }

               byte var45 = JRMCoreH.getByte(var3, "jrmcPwrtyp");
               byte var9 = JRMCoreH.getByte(var3, "jrmcRace");
               byte var10 = JRMCoreH.getByte(var3, "jrmcClass");
               int var11 = JRMCoreH.getInt(var3, "jrmcEnrgy");
               int var12 = JRMCoreH.getInt(var3, "jrmcBdy");
               byte var13 = JRMCoreH.getByte(var3, "jrmcAlign");
               byte var14 = JRMCoreH.getByte(var3, "jrmcState");
               byte var15 = JRMCoreH.getByte(var3, "jrmcState2");
               String var16 = JRMCoreH.getString(var3, "jrmcSSltX");
               int var17 = JRMCoreH.getInt(var3, "jrmcArcRsrv");
               byte var18 = (byte)(var14 + 1);
               int var19 = JRMCoreH.TransPwrModAtr(var6, 3, var14, var15, var9, var16, var5, var17);
               int var20 = JRMCoreH.TransPwrModAtr(var6, 3, 0, 0, var9, var16, var5, var17);
               int var21 = JRMCoreH.stat(var45, 4, var19, var9, var10, 0.0F);
               int var22 = JRMCoreH.stat(var45, 4, var20, var9, var10, 0.0F);
               EntityEnergyAtt var23 = null;
               boolean var24 = false;
               if(var1 >= 0 && var1 < 4 && var4 != null && var4.length() > 0) {
                  String[] var49 = var4.toString().split(";");
                  if(var49 != null && var49.length > 9) {
                     byte var50 = Byte.parseByte(var49[3]);
                     byte var52 = Byte.parseByte(var49[4]);
                     short var54 = Short.parseShort(var49[5]);
                     byte var57 = Byte.parseByte(var49[6]);
                     byte var58 = Byte.parseByte(var49[10]);
                     byte var59 = Byte.parseByte(var49[11]);
                     byte var60 = 0;
                     byte var61 = 0;
                     byte var62 = 0;
                     if(var49.length > 12) {
                        var60 = Byte.parseByte(var49[12]);
                        var61 = Byte.parseByte(var49[13]);
                        var62 = Byte.parseByte(var49[14]);
                     }

                     int var63 = 0;
                     int var66 = 0;
                     int var69 = 0;
                     byte[] var72 = new byte[]{(byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
                     if(var49.length > 16) {
                        var63 = Integer.parseInt(var49[16]);
                        var66 = Integer.parseInt(var49[17]);
                        var69 = Integer.parseInt(var49[18]);
                        var72 = JRMCoreH.tech_statmods(var49[19]);
                     }

                     var54 = (short)((int)((float)(var54 * var5) * 0.01F));
                     var54 = var54 < 1?1:var54;
                     int var73 = JRMCoreH.techDBCdmg(var49, var21, var72);
                     int var76 = JRMCoreH.techDBCkic(var49, var22, var72);
                     int var77 = (int)((float)(var73 * var5) * 0.01F);
                     int var80 = (int)((float)(var76 * var5) * 0.01F * (float)var2 * 0.02F);
                     var73 = var73 < 1?1:var73;
                     var77 = var77 < 1?1:var77;
                     var80 = var80 < 2?2:var80;
                     int var83 = var80 > var11?var12 - (var80 - var11):0;
                     if(var80 <= var11 || var83 > 0) {
                        JRMCoreH.setInt(var11 - var80, var3, "jrmcEnrgy");
                        if(var83 > 0) {
                           JRMCoreH.setInt(var83, var3, "jrmcBdy");
                        }

                        var3.worldObj.playSoundAtEntity(var3, "jinryuudragonbc:" + JRMCoreH.techSnds(var50, 1, var61), 1.0F, 1.0F);
                        var23 = new EntityEnergyAtt(var3, var50, var52, var54, var57, var58, var59, var60, var61, var62, var2, var77, var76, var72, var1);
                        var3.worldObj.spawnEntityInWorld(var23);
                     }
                  }
               } else if(var1 >= 4 && var1 < 8 && var4 != null && var4.length() > 0) {
                  int var25 = Integer.parseInt(var4);
                  String[] var26 = JRMCoreH.pmdbc[var25];
                  if(var26[0].equals("KAFakeMoon")) {
                     int var27 = Integer.parseInt(var26[7]);
                     if(var11 >= var27) {
                        int var28 = var11 - var27;
                        JRMCoreH.setInt(var28, var3, "jrmcEnrgy");
                        EntityEnergyFM var46 = new EntityEnergyFM(var3);
                        var3.worldObj.spawnEntityInWorld(var46);
                     }
                  } else if(var26 != null && var26.length > 9) {
                     byte var51 = Byte.parseByte(var26[3]);
                     byte var53 = Byte.parseByte(var26[4]);
                     short var29 = Short.parseShort(var26[5]);
                     byte var30 = Byte.parseByte(var26[6]);
                     byte var31 = Byte.parseByte(var26[10]);
                     byte var32 = Byte.parseByte(var26[11]);
                     byte var33 = Byte.parseByte(var26[12]);
                     byte var34 = Byte.parseByte(var26[13]);
                     byte var35 = Byte.parseByte(var26[14]);
                     if(var26.length > 12) {
                        var33 = Byte.parseByte(var26[12]);
                        var34 = Byte.parseByte(var26[13]);
                        var35 = Byte.parseByte(var26[14]);
                     }

                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     byte[] var39 = new byte[]{(byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
                     if(var26.length > 16) {
                        var36 = Integer.parseInt(var26[16]);
                        var37 = Integer.parseInt(var26[17]);
                        var38 = Integer.parseInt(var26[18]);
                        var39 = JRMCoreH.tech_statmods(var26[19]);
                     }

                     int var40 = JRMCoreH.techDBCdmg(var26, var21, var39);
                     int var41 = JRMCoreH.techDBCkic(var26, var22, var39);
                     short var42 = (short)((int)((float)(var40 * var5) * 0.02F));
                     short var43 = (short)((int)((float)(var41 * var5) * 0.02F * (float)var2 * 0.02F));
                     var40 = var40 < 1?1:var40;
                     var42 = var42 < 1?1:var42;
                     var43 = var43 < 2?2:var43;
                     int var44 = var43 > var11?var12 - (var43 - var11):0;
                     if(var43 <= var11 || var44 > 0) {
                        if(var34 > 0) {
                           var3.worldObj.playSoundAtEntity(var3, "jinryuudragonbc:" + JRMCoreH.techSnds(10, 1, (short)(var34 - 1)), 1.0F, 1.0F);
                        }

                        if(var33 > 0) {
                           var3.worldObj.playSoundAtEntity(var3, "jinryuudragonbc:" + JRMCoreH.techSnds(10, 3, (short)(var33 - 1)), 1.0F, 1.0F);
                        }

                        if(var44 > 0) {
                           JRMCoreH.setInt(var44, var3, "jrmcBdy");
                        }

                        JRMCoreH.setInt(var11 - var43, var3, "jrmcEnrgy");
                        var23 = new EntityEnergyAtt(var3, var51, var53, var42, var30, var31, var32, var33, var34, var35, var2, var40, var41, var39, var1);
                        var3.worldObj.spawnEntityInWorld(var23);
                     }
                  }
               }
            }
         }
      }

   }

   public void handleDBCdri(int var1, EntityPlayer var2) {
      NBTTagCompound var3 = this.nbt(var2, "");
      if(var1 == 5 || var1 == 6) {
         var3.setInteger("DBCdriS", var1);
      }

      if(var1 == 1 || var1 == 2) {
         var3.setInteger("DBCdriF", var1);
      }

      if(var1 == 3 || var1 == 4) {
         var3.setInteger("DBCdriY", var1);
      }

      if(var1 == 10) {
         ;
      }

      if(var1 >= 100) {
         ChatStyle var4 = (new ChatStyle()).setColor(EnumChatFormatting.WHITE);
         NBTTagCompound var5 = this.nbt(var2, "pres");
         byte var6 = JRMCoreH.getByte(var2, "jrmcAlign");
         int var7 = 1;
         var7 = JRMCoreConfig.tpgn;

         for(int var8 = 0; var8 <= 39; ++var8) {
            if(var1 == var8 * 100 + 98 && var5.getInteger("DBCSagaSys") != var1 + 2) {
               int var9 = var6 + 5 > 100?100:var6 + 5;
               JRMCoreH.tpalgn(var2, var8 * 3 * var7, var9);
               JRMCoreH.prog(var2, var1, var1 + 2);
            }

            if(var1 == var8 * 100 + 97 && var5.getInteger("DBCSagaSys") != var1 + 3) {
               if(var6 >= 55) {
                  int var22 = var6 - 5 < 0?100:var6 - 5;
                  JRMCoreH.tpalgn(var2, var8 * 3 * var7, var22);
               } else if(var6 <= 45) {
                  int var23 = var6 + 5 > 100?100:var6 + 5;
                  JRMCoreH.tpalgn(var2, var8 * 3 * var7, var23);
               } else {
                  JRMCoreH.tpalgn(var2, var8 * 3 * var7, 50);
               }

               JRMCoreH.prog(var2, var1, var1 + 3);
            }

            if(var1 == var8 * 100 + 96 && var5.getInteger("DBCSagaSys") != var1 + 4) {
               int var24 = var6 - 5 < 0?0:var6 - 5;
               JRMCoreH.tpalgn(var2, var8 * 3 * var7, var24);
               JRMCoreH.prog(var2, var1, var1 + 4);
            }

            if(var1 == var8 * 100 + 95) {
               ;
            }
         }

         int var21 = MathHelper.floor_double(var2.posX);
         int var25 = MathHelper.floor_double(var2.posY);
         int var10 = MathHelper.floor_double(var2.posZ);
         if(var1 == 100) {
            JRMCoreH.prog(var2, var1, 100);
         }

         if(var1 == 295) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.itemSaiySagaRad.line1", new Object[0])).setChatStyle(var4));
            EntitySaiyanRaditz var14 = new EntitySaiyanRaditz(var2.worldObj);
            if(mod_DragonBC.SagaSysSpawnPods) {
               SpacePod01Entity var15 = new SpacePod01Entity(var2.worldObj);
               String[] var16 = DBCH.NpcSpawnLoc(var21, var25, var10 - 4, var2.worldObj).split(";");
               var15.setLocationAndAngles(Double.parseDouble(var16[0]), Double.parseDouble(var16[1]), Double.parseDouble(var16[2]), 0.0F, 0.0F);
               var2.worldObj.spawnEntityInWorld(var15);
            }

            String[] var47 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var14.setLocationAndAngles(Double.parseDouble(var47[0]), Double.parseDouble(var47[1]), Double.parseDouble(var47[2]), 0.0F, 0.0F);
            var14.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var14);
         }

         if(var1 == 495) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.itemSaiySagaVeg.line1", new Object[0])).setChatStyle(var4));
            EntitySaiyanNappa var26 = new EntitySaiyanNappa(var2.worldObj);
            EntitySaiyanVegeta var48 = new EntitySaiyanVegeta(var2.worldObj);
            String[] var69 = DBCH.NpcSpawnLoc(var21, var25, var10 - 1, var2.worldObj).split(";");
            var26.setLocationAndAngles(Double.parseDouble(var69[0]), Double.parseDouble(var69[1]), Double.parseDouble(var69[2]), 0.0F, 0.0F);
            var26.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var26);
            var69 = DBCH.NpcSpawnLoc(var21, var25, var10 - 2, var2.worldObj).split(";");
            var48.setLocationAndAngles(Double.parseDouble(var69[0]), Double.parseDouble(var69[1]), Double.parseDouble(var69[2]), 0.0F, 0.0F);
            var48.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var48);
         }

         if(var1 == 795) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.itemFreeSagaCui.line1", new Object[0])).setChatStyle(var4));
            EntityKiwi var27 = new EntityKiwi(var2.worldObj);
            String[] var49 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var27.setLocationAndAngles(Double.parseDouble(var49[0]), Double.parseDouble(var49[1]), Double.parseDouble(var49[2]), 0.0F, 0.0F);
            var27.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var27);
         }

         if(var1 == 895) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.itemFreeSagaDod.line1", new Object[0])).setChatStyle(var4));
            EntityDodoria var28 = new EntityDodoria(var2.worldObj);
            String[] var50 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var28.setLocationAndAngles(Double.parseDouble(var50[0]), Double.parseDouble(var50[1]), Double.parseDouble(var50[2]), 0.0F, 0.0F);
            var28.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var28);
         }

         if(var1 == 995) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.itemFreeSagaZar.line1", new Object[0])).setChatStyle(var4));
            EntityZarbon var29 = new EntityZarbon(var2.worldObj);
            String[] var51 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var29.setLocationAndAngles(Double.parseDouble(var51[0]), Double.parseDouble(var51[1]), Double.parseDouble(var51[2]), 0.0F, 0.0F);
            var29.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var29);
         }

         if(var1 == 1095) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation(StatCollector.translateToLocal("dbc.itemFreeSagaGin.1.line1"), new Object[0])).setChatStyle(var4));
            var2.addChatMessage((new ChatComponentTranslation(StatCollector.translateToLocal("dbc.itemFreeSagaGin.2.line1"), new Object[0])).setChatStyle(var4));
            var2.addChatMessage((new ChatComponentTranslation(StatCollector.translateToLocal("dbc.itemFreeSagaGin.3.line1"), new Object[0])).setChatStyle(var4));
            var2.addChatMessage((new ChatComponentTranslation(StatCollector.translateToLocal("dbc.itemFreeSagaGin.4.line1"), new Object[0])).setChatStyle(var4));
            var2.addChatMessage((new ChatComponentTranslation(StatCollector.translateToLocal("dbc.itemFreeSagaGin.5.line1"), new Object[0])).setChatStyle(var4));
            var2.addChatMessage((new ChatComponentTranslation(StatCollector.translateToLocal("dbc.itemFreeSagaGin.6.line1"), new Object[0])).setChatStyle(var4));
            EntityRecoome var30 = new EntityRecoome(var2.worldObj);
            EntityBarta var52 = new EntityBarta(var2.worldObj);
            EntityJeice var71 = new EntityJeice(var2.worldObj);
            EntityGuldo var17 = new EntityGuldo(var2.worldObj);
            EntityGinyu var18 = new EntityGinyu(var2.worldObj);
            String[] var19 = DBCH.NpcSpawnLoc(var21, var25, var10 + 2, var2.worldObj).split(";");
            var30.setLocationAndAngles(Double.parseDouble(var19[0]), Double.parseDouble(var19[1]), Double.parseDouble(var19[2]), 0.0F, 0.0F);
            var19 = DBCH.NpcSpawnLoc(var21, var25, var10 - 2, var2.worldObj).split(";");
            var52.setLocationAndAngles(Double.parseDouble(var19[0]), Double.parseDouble(var19[1]), Double.parseDouble(var19[2]), 0.0F, 0.0F);
            var19 = DBCH.NpcSpawnLoc(var21, var25, var10 - 1, var2.worldObj).split(";");
            var71.setLocationAndAngles(Double.parseDouble(var19[0]), Double.parseDouble(var19[1]), Double.parseDouble(var19[2]), 0.0F, 0.0F);
            var19 = DBCH.NpcSpawnLoc(var21, var25, var10 + 1, var2.worldObj).split(";");
            var17.setLocationAndAngles(Double.parseDouble(var19[0]), Double.parseDouble(var19[1]), Double.parseDouble(var19[2]), 0.0F, 0.0F);
            var19 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var18.setLocationAndAngles(Double.parseDouble(var19[0]), Double.parseDouble(var19[1]), Double.parseDouble(var19[2]), 0.0F, 0.0F);
            var30.setSpwner(var2);
            var52.setSpwner(var2);
            var71.setSpwner(var2);
            var17.setSpwner(var2);
            var18.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var30);
            var2.worldObj.spawnEntityInWorld(var52);
            var2.worldObj.spawnEntityInWorld(var71);
            var2.worldObj.spawnEntityInWorld(var17);
            var2.worldObj.spawnEntityInWorld(var18);
         }

         if(var1 == 1195) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.itemFreeSagaFre.1.line1", new Object[0])).setChatStyle(var4));
            var2.addChatMessage((new ChatComponentTranslation("dbc.itemFreeSagaFre.2.line1", new Object[0])).setChatStyle(var4));
            EntityFreeza1 var31 = new EntityFreeza1(var2.worldObj);
            String[] var53 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var31.setLocationAndAngles(Double.parseDouble(var53[0]), Double.parseDouble(var53[1]), Double.parseDouble(var53[2]), 0.0F, 0.0F);
            var31.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var31);
         }

         if(var1 == 1495) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga.14.1", new Object[0])).setChatStyle(var4));
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga.14.2", new Object[]{var2.getCommandSenderName()})).setChatStyle(var4));

            for(int var32 = 0; var32 < 3; ++var32) {
               EntityFreezaSoldier1 var54 = new EntityFreezaSoldier1(var2.worldObj);
               String[] var72 = DBCH.NpcSpawnLoc(var21, var25, var10 + var32 - 1, var2.worldObj).split(";");
               var54.setLocationAndAngles(Double.parseDouble(var72[0]), Double.parseDouble(var72[1]), Double.parseDouble(var72[2]), 0.0F, 0.0F);
               var54.settarget(var2);
               var54.setTarget(var2);
               var54.setSpwner(var2);
               var2.worldObj.spawnEntityInWorld(var54);
            }

            for(int var33 = 0; var33 < 3; ++var33) {
               EntityFreezaSoldier2 var55 = new EntityFreezaSoldier2(var2.worldObj);
               String[] var73 = DBCH.NpcSpawnLoc(var21 + 1, var25, var10 + var33 - 1, var2.worldObj).split(";");
               var55.setLocationAndAngles(Double.parseDouble(var73[0]), Double.parseDouble(var73[1]), Double.parseDouble(var73[2]), 0.0F, 0.0F);
               var55.settarget(var2);
               var55.setTarget(var2);
               var55.setSpwner(var2);
               var2.worldObj.spawnEntityInWorld(var55);
            }

            for(int var34 = 0; var34 < 3; ++var34) {
               EntityFreezaSoldier3 var56 = new EntityFreezaSoldier3(var2.worldObj);
               String[] var74 = DBCH.NpcSpawnLoc(var21 + 2, var25, var10 + var34 - 1, var2.worldObj).split(";");
               var56.setLocationAndAngles(Double.parseDouble(var74[0]), Double.parseDouble(var74[1]), Double.parseDouble(var74[2]), 0.0F, 0.0F);
               var56.settarget(var2);
               var56.setTarget(var2);
               var56.setSpwner(var2);
               var2.worldObj.spawnEntityInWorld(var56);
            }
         }

         if(var1 == 1595) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga.15.1", new Object[0])).setChatStyle(var4));
            EntityFreezaFather var35 = new EntityFreezaFather(var2.worldObj);
            EntityFreezaMecha var57 = new EntityFreezaMecha(var2.worldObj);
            String[] var75 = DBCH.NpcSpawnLoc(var21, var25, var10 - 1, var2.worldObj).split(";");
            var35.setLocationAndAngles(Double.parseDouble(var75[0]), Double.parseDouble(var75[1]), Double.parseDouble(var75[2]), 0.0F, 0.0F);
            var35.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var35);
            var75 = DBCH.NpcSpawnLoc(var21, var25, var10 + 1, var2.worldObj).split(";");
            var57.setLocationAndAngles(Double.parseDouble(var75[0]), Double.parseDouble(var75[1]), Double.parseDouble(var75[2]), 0.0F, 0.0F);
            var57.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var57);
         }

         if(var1 == 1794) {
            JRMCoreH.prog(var2, var1, var1 + 6);
         }

         if(var1 == 1995) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga.19.1", new Object[0])).setChatStyle(var4));
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga.19.2", new Object[0])).setChatStyle(var4));
            EntityCyborg19 var36 = new EntityCyborg19(var2.worldObj);
            EntityCyborg20 var58 = new EntityCyborg20(var2.worldObj);
            String[] var77 = DBCH.NpcSpawnLoc(var21, var25, var10 - 1, var2.worldObj).split(";");
            var36.setLocationAndAngles(Double.parseDouble(var77[0]), Double.parseDouble(var77[1]), Double.parseDouble(var77[2]), 0.0F, 0.0F);
            var36.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var36);
            var77 = DBCH.NpcSpawnLoc(var21, var25, var10 + 1, var2.worldObj).split(";");
            var58.setLocationAndAngles(Double.parseDouble(var77[0]), Double.parseDouble(var77[1]), Double.parseDouble(var77[2]), 0.0F, 0.0F);
            var58.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var58);
         }

         if(var1 == 2094) {
            JRMCoreH.prog(var2, var1, var1 + 6);
         }

         if(var1 == 2295) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga.22.1", new Object[0])).setChatStyle(var4));
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga.22.2", new Object[0])).setChatStyle(var4));
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga.22.3", new Object[0])).setChatStyle(var4));
            EntityCyborg18 var37 = new EntityCyborg18(var2.worldObj);
            String[] var59 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var37.setLocationAndAngles(Double.parseDouble(var59[0]), Double.parseDouble(var59[1]), Double.parseDouble(var59[2]), 0.0F, 0.0F);
            var37.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var37);
         }

         if(var1 == 2395) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            EntityCell1 var38 = new EntityCell1(var2.worldObj);
            String[] var60 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var38.setLocationAndAngles(Double.parseDouble(var60[0]), Double.parseDouble(var60[1]), Double.parseDouble(var60[2]), 0.0F, 0.0F);
            var38.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var38);
         }

         if(var1 == 2695) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            EntityCell2 var39 = new EntityCell2(var2.worldObj);
            String[] var61 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var39.setLocationAndAngles(Double.parseDouble(var61[0]), Double.parseDouble(var61[1]), Double.parseDouble(var61[2]), 0.0F, 0.0F);
            var39.target(1);
            var39.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var39);
         }

         if(var1 == 2595) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga.25.1", new Object[0])).setChatStyle(var4));
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga.25.2", new Object[0])).setChatStyle(var4));
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga.25.3", new Object[0])).setChatStyle(var4));
            EntityCyborg17 var40 = new EntityCyborg17(var2.worldObj);
            EntityCyborg16 var62 = new EntityCyborg16(var2.worldObj);
            String[] var79 = DBCH.NpcSpawnLoc(var21, var25, var10 - 1, var2.worldObj).split(";");
            var40.setLocationAndAngles(Double.parseDouble(var79[0]), Double.parseDouble(var79[1]), Double.parseDouble(var79[2]), 0.0F, 0.0F);
            var79 = DBCH.NpcSpawnLoc(var21, var25, var10 + 1, var2.worldObj).split(";");
            var62.setLocationAndAngles(Double.parseDouble(var79[0]), Double.parseDouble(var79[1]), Double.parseDouble(var79[2]), 0.0F, 0.0F);
            var40.setSpwner(var2);
            var62.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var40);
            var2.worldObj.spawnEntityInWorld(var62);
         }

         if(var1 == 2995) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga.29.1", new Object[0])).setChatStyle(var4));
            EntityCell3 var41 = new EntityCell3(var2.worldObj);
            String[] var63 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var41.setLocationAndAngles(Double.parseDouble(var63[0]), Double.parseDouble(var63[1]), Double.parseDouble(var63[2]), 0.0F, 0.0F);
            var41.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var41);
         }

         if(var1 == 3195) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga." + var1 / 100 + ".1", new Object[0])).setChatStyle(var4));
            EntityPuipui var42 = new EntityPuipui(var2.worldObj);
            String[] var64 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var42.setLocationAndAngles(Double.parseDouble(var64[0]), Double.parseDouble(var64[1]), Double.parseDouble(var64[2]), 0.0F, 0.0F);
            var42.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var42);
         }

         if(var1 == 3295) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga." + var1 / 100 + ".1", new Object[0])).setChatStyle(var4));
            EntityYakon var43 = new EntityYakon(var2.worldObj);
            String[] var65 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var43.setLocationAndAngles(Double.parseDouble(var65[0]), Double.parseDouble(var65[1]), Double.parseDouble(var65[2]), 0.0F, 0.0F);
            var43.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var43);
         }

         if(var1 == 3395) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga." + var1 / 100 + ".1", new Object[0])).setChatStyle(var4));
            EntityDarbura var44 = new EntityDarbura(var2.worldObj);
            String[] var66 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var44.setLocationAndAngles(Double.parseDouble(var66[0]), Double.parseDouble(var66[1]), Double.parseDouble(var66[2]), 0.0F, 0.0F);
            var44.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var44);
         }

         if(var1 == 3594) {
            JRMCoreH.prog(var2, var1, var1 + 6);
         }

         if(var1 == 3495 || var1 == 3695) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga." + var1 / 100 + ".1", new Object[0])).setChatStyle(var4));
            EntityBuuFat var45 = new EntityBuuFat(var2.worldObj);
            String[] var67 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var45.setLocationAndAngles(Double.parseDouble(var67[0]), Double.parseDouble(var67[1]), Double.parseDouble(var67[2]), 0.0F, 0.0F);
            var45.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var45);
         }

         if(var1 == 3895) {
            JRMCoreH.prog(var2, var1, var1 - 85);
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga." + var1 / 100 + ".1", new Object[0])).setChatStyle(var4));
            var2.addChatMessage((new ChatComponentTranslation("dbc.MainSaga." + var1 / 100 + ".2", new Object[0])).setChatStyle(var4));
            EntityBuuSuper var46 = new EntityBuuSuper(var2.worldObj);
            String[] var68 = DBCH.NpcSpawnLoc(var21, var25, var10, var2.worldObj).split(";");
            var46.setLocationAndAngles(Double.parseDouble(var68[0]), Double.parseDouble(var68[1]), Double.parseDouble(var68[2]), 0.0F, 0.0F);
            var46.setSpwner(var2);
            var2.worldObj.spawnEntityInWorld(var46);
         }

         if(var1 == 3990) {
            JRMCoreH.prog(var2, var1, 99);
         }
      }

   }

   public void send(EntityPlayerMP var1) {
      var1.addChatMessage(new ChatComponentText(JRMCoreH.trl("jrmc", "notenoughtp")));
   }

   public void handleDBCwish(int var1, String var2, EntityPlayer var3) {
      MinecraftServer var4 = FMLCommonHandler.instance().getMinecraftServerInstance();
      if(var1 == 0) {
         String[] var5 = var2.split(";");
         int var6 = Integer.parseInt(var5[0]);
         EntityPlayer var7 = null;
         if(var5.length > 1) {
            for(int var8 = 0; var8 < var4.worldServers.length; ++var8) {
               int var9 = var4.worldServers[var8].provider.dimensionId;
               if(var9 == DBCConfig.otherWorld) {
                  var7 = var4.worldServers[var8].getPlayerEntityByName(var5[1]);
               }
            }
         }

         if(var6 < 100) {
            int var32 = JRMCoreH.getInt(var3, "jrmcWishes");
            int var37 = JRMCoreH.getInt(var3, "jrmcDrgn");
            ArrayList var10 = var37 == 0?DBCH.wishS:DBCH.wishP;
            if(var32 > 0) {
               var3.worldObj.playSoundEffect(var3.posX, var3.posY, var3.posZ, "jinryuudragonbc:dragon.grant", 1.0F, 1.0F);
               if(((String)var10.get(var6)).contains(";+;")) {
                  String[] var44 = ((String)var10.get(var6)).replace(";+;", ";+").split(";+");
                  String var47 = var44[0];
                  int var50 = Integer.parseInt(var44[1]);
                  int var51 = Integer.parseInt(var44[2]);
                  Item var52 = JRMCoreH.getItemByText(var47);
                  if(var52 != null) {
                     ItemStack var53 = new ItemStack(var52, var50, var51);
                     var3.inventory.addItemStackToInventory(var53);
                     var3.inventory.inventoryChanged = true;
                     this.closeInventoryChange(var3);
                  }
               } else if(((String)var10.get(var6)).equals("revive") && var7 != null) {
                  byte var43 = JRMCoreH.getByte(var7, "jrmcAlv");
                  if(var43 == 1 && var7 != null && var3.dimension != DBCConfig.otherWorld && var7.dimension == DBCConfig.otherWorld) {
                     JRMCoreH.setInt(0, var7, "jrmcReviveTmer");
                     String var46 = JRMCoreH.trlai("dbc", "canrevivenow");
                     ChatStyle var49 = (new ChatStyle()).setColor(EnumChatFormatting.YELLOW);
                     var7.addChatMessage((new ChatComponentTranslation(var46, new Object[0])).setChatStyle(var49));
                  }
               } else if(((String)var10.get(var6)).equals("reviventp") && var7 != null) {
                  byte var42 = JRMCoreH.getByte(var7, "jrmcAlv");
                  if(var42 == 1 && var7 != null && var3.dimension != DBCConfig.otherWorld && var7.dimension == DBCConfig.otherWorld) {
                     JRMCoreH.setString(var3.getCommandSenderName() + ";" + var3.dimension + ";" + (int)var3.posX + ";" + (int)var3.posY + ";" + (int)var3.posZ, var7, "jrmcRevtpInit");
                     String var45 = JRMCoreH.trlai("dbc", "reviveoffered");
                     ChatStyle var48 = (new ChatStyle()).setColor(EnumChatFormatting.YELLOW);
                     var7.addChatMessage((new ChatComponentTranslation(var45, new Object[]{var3.getCommandSenderName(), new ChatComponentTranslation(JRMCoreH.trlai("dbc", (String)DBCH.plntNms.get(Integer.valueOf(var3.dimension))), new Object[0]), (int)var3.posX + ", " + (int)var3.posY + ", " + (int)var3.posZ})).setChatStyle(var48));
                  }
               } else if(!((String)var10.get(var6)).equals("reviveall")) {
                  if(((String)var10.get(var6)).equals("young")) {
                     JRMCoreH.setFloat(90, var3, "JRYCAge");
                  } else if(((String)var10.get(var6)).equals("child")) {
                     JRMCoreH.setFloat(25, var3, "JRYCAge");
                  } else if(((String)var10.get(var6)).equals("old")) {
                     JRMCoreH.setFloat(300, var3, "JRYCAge");
                  } else if(((String)var10.get(var6)).equals("kicolor")) {
                     JRMCoreH.setInt(Integer.parseInt(var5[1]), var3, "jrmcAuraColor");
                  }
               } else if(var3.dimension != DBCConfig.otherWorld) {
                  int var11 = JRMCoreH.Algnmnt(JRMCoreH.getByte(var3, "jrmcAlign"));

                  for(int var12 = 0; var12 < var4.worldServers.length; ++var12) {
                     int var13 = var4.worldServers[var12].provider.dimensionId;
                     if(var13 == DBCConfig.otherWorld) {
                        for(Object var71 : var4.worldServers[var12].playerEntities) {
                           EntityPlayer var8 = (EntityPlayer) var71;
                           byte var15 = JRMCoreH.getByte(var7, "jrmcAlv");
                           if(var15 == 1 && var8 != null && var8.dimension == DBCConfig
                                   .otherWorld) {
                              int var16 = JRMCoreH.Algnmnt(JRMCoreH.getByte(var8, "jrmcAlign"));
                              if(var11 == var16) {
                                 JRMCoreH.setInt(0, var8, "jrmcReviveTmer");
                                 String var17 = JRMCoreH.trlai("dbc", "canrevivenow");
                                 ChatStyle var18 = (new ChatStyle()).setColor(EnumChatFormatting.YELLOW);
                                 var7.addChatMessage((new ChatComponentTranslation(var17, new Object[0])).setChatStyle(var18));
                              }
                           }
                        }
                     }
                  }
               }
            }

            JRMCoreH.setInt(--var32, var3, "jrmcWishes");
         }
      }

      if(var1 == 1) {
         int var19 = Integer.parseInt(var2);
         if(var19 == 100 && var3.dimension == DBCConfig.otherWorld && var3 != null && var3.ridingEntity == null && var3.riddenByEntity == null) {
            int var23 = JRMCoreH.getInt(var3, "jrmcReviveTmer");
            if(var23 <= 0) {
               if(JRMCoreHDBC.DBCgetConfigDeadInv() && var3.worldObj.getGameRules().getGameRuleBooleanValue("keepInventory") && !var3.capabilities.isCreativeMode && JRMCoreHDBC.hasHalo(var3)) {
                  JRMCoreH.nbt(var3).setTag("InventoryDead", var3.inventory.writeToNBT(new NBTTagList()));
                  var3.inventory.readFromNBT(JRMCoreH.nbt(var3).getTagList("InventoryLiving", 10));
                  var3.getEntityData().setTag("Inventory", var3.inventory.writeToNBT(new NBTTagList()));
               }

               JRMCoreH.setByte(0, var3, "jrmcAlv");
               FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)var3, DBCConfig.planetEarth, new WorldTeleporterDBCTelep(FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(DBCConfig.planetEarth)));
               var3.addExperience(1);
               double[] var28 = new double[]{50.0D, 220.0D, 50.0D};
               switch(JRMCoreH.Algnmnt(JRMCoreH.getByte(var3, "jrmcAlign"))) {
               case 0:
                  var28 = DBCConfig.RevLocG;
                  break;
               case 1:
                  var28 = DBCConfig.RevLocN;
                  break;
               case 2:
                  var28 = DBCConfig.RevLocE;
               }

               ((EntityPlayerMP)var3).playerNetServerHandler.setPlayerLocation(var28[0], var28[1], var28[2], 0.0F, 0.0F);
               ((EntityPlayerMP)var3).playerNetServerHandler.setPlayerLocation(var28[0], var28[1] + 1.0D, var28[2], 0.0F, 0.0F);
               System.out.println(var3.getCommandSenderName() + " revived!");
            }
         }

         if(var19 == 102) {
            ;
         }

         if(var19 == 101) {
            JRMCoreHDBC.reincarnate(var3);
            System.out.println(var3.getCommandSenderName() + " choose to Reincarnate!");
         }

         if(var19 == 199 && this.nbt(var3, "pres").getInteger("DBCSenzu") == 0) {
            this.nbt(var3, "pres").setInteger("DBCSenzu", 1);
            var3.inventory.addItemStackToInventory(new ItemStack(ItemsDBC.ItemSenzu, DBCConfig.senzuFromKarin));
            var3.inventory.inventoryChanged = true;
            this.closeInventoryChange(var3);
         }

         if(var19 == 202) {
            var3.inventory.addItemStackToInventory(new ItemStack(ItemsDBC.KintounItem, 1));
            var3.inventory.inventoryChanged = true;
            this.closeInventoryChange(var3);
         }

         if(var19 == 203) {
            var3.inventory.addItemStackToInventory(new ItemStack(ItemsDBC.KintounBlackItem, 1));
            var3.inventory.inventoryChanged = true;
            this.closeInventoryChange(var3);
         }
      } else if(var1 == 2) {
         String[] var20 = var2.split(";");
         int var24 = Integer.parseInt(var20[0]);
         float var29 = Float.parseFloat(var20[1]);
         ItemStack var34 = new ItemStack(var24 == 0?ItemsDBC.ItemWeightHandLeg:(var24 == 1?ItemsDBC.ItemWeightShell:ItemsDBC.ItemWeightShirt), 1, 1);
         if(var34 != null) {
            JRMCoreH.addItemWeightStats(var34, new Object[]{Float.valueOf(var29)});
            var3.inventory.addItemStackToInventory(var34);
            var3.inventory.inventoryChanged = true;
            this.closeInventoryChange(var3);
         }
      } else if(var1 == 3) {
         String var21 = ";";

         for(int var25 = 0; var25 < var4.worldServers.length; ++var25) {
            int var30 = var4.worldServers[var25].provider.dimensionId;
            if(var30 == DBCConfig.otherWorld) {
               for(Object var37 : var4.worldServers[var25].playerEntities) {
                  EntityPlayer var38 = (EntityPlayer) var37;
                  if(var38 != null && var38.dimension == DBCConfig.otherWorld) {
                     byte var40 = JRMCoreH.getByte(var38, "jrmcAlv");
                     if(var40 == 1) {
                        var21 = var21 + ";" + var38.getCommandSenderName();
                     }
                  }
               }
            }

            PD.sendTo(new DBCPwish(var1, var21), (EntityPlayerMP)var3);
         }
      } else if(var1 == 4) {
         String[] var22 = var2.split(";");
         int var26 = Integer.parseInt(var22[0]);
         int var31 = Integer.parseInt(var22[1]);
         int var36 = Integer.parseInt(var22[2]);
         TileEntity var39 = var3.worldObj.getTileEntity(var26, var31, var36);
         float var41 = Float.parseFloat(var22[3]);
         if(var39 instanceof ArtGravDevTileEntity) {
            ((ArtGravDevTileEntity)var39).setGravity(var41);
            var3.worldObj.markBlockForUpdate(var26, var31, var36);
            var39.markDirty();
         }
      }

   }

   public void handleDBCtick(int var1, EntityPlayer var2) {
      if(var1 == 0) {
         ;
      }

      if(var1 == 26) {
         ;
      }

      if(var1 >= 10 && var1 <= 25) {
         ;
      }

      if(var1 == -2 && ExtendedPlayer.get(var2).inventory.getStackInSlot(2) != null) {
         ExtendedPlayer.get(var2).inventory.setInventorySlotContents(2, (ItemStack)null);
         this.soundPowerUp(var2, "jinryuudragonbc:scouter.expl");
      }

      if(var1 == -3) {
         short var3 = JRMCoreH.getShort(var2, "jrmcGTrnng");
         int[] var4 = JRMCoreH.PlyrAttrbts(var2);
         byte var5 = JRMCoreH.getByte(var2, "jrmcPwrtyp");
         byte var6 = JRMCoreH.getByte(var2, "jrmcRace");
         byte var7 = JRMCoreH.getByte(var2, "jrmcClass");
         int var8 = JRMCoreH.stat(var5, 2, var4[2], var6, var7, 0.0F);
         int var9 = JRMCoreH.getInt(var2, "jrmcBdy");
         int var10 = JRMCoreH.stat(var5, 5, var4[5], var6, var7, 0.0F);
         int var11 = JRMCoreH.getInt(var2, "jrmcEnrgy");
         JRMCoreH.stat(var5, 3, var4[2], var6, var7, 0.0F);
         int var13 = JRMCoreH.getInt(var2, "jrmcStamina");
         if(var3 < DBCConfig.maxTrnExp && var9 > var8 / 2 && var11 > var10 / 2) {
            int var14 = var9 - 50;
            int var15 = var11 - 50;
            if(var14 < 0) {
               var2.setHealth(var2.getHealth() / 2.0F);
               JRMCoreH.setInt(0, var2, "jrmcBdy");
            } else {
               JRMCoreH.setInt(var14, var2, "jrmcBdy");
            }

            if(var15 < 0) {
               var15 = 0;
               JRMCoreH.setByte(0, var2, "jrmcRelease");
            }

            JRMCoreH.setInt(var15, var2, "jrmcEnrgy");
            JRMCoreH.setShort(var3 + 1, var2, "jrmcGTrnng");
            JRMCoreH.expPls(var2, 1);
         }
      }

      if(var1 == -6) {
         FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)var2, DBCConfig.planetEarth, new WorldTeleporterDBCTelep(FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(DBCConfig.planetEarth)));
         var2.setPositionAndUpdate(77.5D, 217.0D, 10.5D);
         var2.addExperience(1);
         JRMCoreH.setShort(2400, var2, "jrmcHTCTmO");
         String var16 = "dbc.timechamber.mustwaitaday";
         ChatStyle var19 = (new ChatStyle()).setColor(EnumChatFormatting.YELLOW);
         var2.addChatMessage((new ChatComponentTranslation(var16, new Object[0])).setChatStyle(var19));
      }

      if(var1 == -100) {
         int var17 = this.nbt(var2, "pres").getInteger("DBCSenzu");
         PD.sendTo(new DBCPspacepod1(var17), (EntityPlayerMP)var2);
      }

      if(var1 == -101) {
         int var18 = this.nbt(var2, "pres").getInteger("jrmcMaster");
         if(var18 == 0) {
            this.nbt(var2, "pres").setInteger("jrmcMaster", 1);
         }

         PD.sendTo(new DBCPtick(var18 + 2), (EntityPlayerMP)var2);
      }

   }

   public void handleDBCspacepod1(int var1, EntityPlayer var2) {
      Side var3 = FMLCommonHandler.instance().getEffectiveSide();
      if(var3 == Side.SERVER) {
         Entity var4 = null;
         if(var1 == 1) {
            if(var2.ridingEntity != null) {
               var4 = var2.ridingEntity;
               var4.setDead();
            }

            FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)var2, DBCConfig.planetNamek, new WorldTeleporterDBCSpacePod01(FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(DBCConfig.planetNamek), var4));
            var2.addExperience(1);
         }

         if(var1 == 2) {
            if(var2.ridingEntity != null) {
               var4 = var2.ridingEntity;
               var4.setDead();
            }

            int var5 = DBCConfig.planetVegeta;
            if(!DBCConfig.plntVegeta) {
               var5 = DBCConfig.planetEarth;
            }

            FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)var2, var5, new WorldTeleporterDBCSpacePod01(FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(var5), var4));
            var2.addExperience(1);
         }

         if(var1 == 3) {
            if(var2.ridingEntity != null) {
               var4 = var2.ridingEntity;
               var4.setDead();
            }

            FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP)var2, DBCConfig.planetEarth, new WorldTeleporterDBCSpacePod01(FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(DBCConfig.planetEarth), var4));
            var2.addExperience(1);
         }
      }

   }

   public void handleDBCchargepart(byte var1, String var2, EntityPlayer var3) {
      PD.sendToDimension(new DBCPchargepart(var1, var2), var3.dimension);
   }

   public void ki(NBTTagCompound var1, int var2) {
      if(var2 == 2) {
         var1.setInteger("DBCKiCharge", var1.getInteger("DBCKiCharge") * var2);
      }

      if(var2 == 3) {
         var1.setInteger("DBCKiCharge", var1.getInteger("DBCKiCharge") + var1.getInteger("DBCKiCharge") / (var2 - 1));
      }

      if(var2 == 4) {
         var1.setInteger("DBCKiCharge", var1.getInteger("DBCKiCharge") + var1.getInteger("DBCKiCharge") / (var2 - 1));
      }

      if(var2 == -4) {
         var1.setInteger("DBCKiCharge", var1.getInteger("DBCKiCharge") / 4);
      }

      if(var2 == -3) {
         var1.setInteger("DBCKiCharge", var1.getInteger("DBCKiCharge") / 3);
      }

      if(var2 == -2) {
         var1.setInteger("DBCKiCharge", var1.getInteger("DBCKiCharge") / 2);
      }

   }

   public void handleDBCascend(byte var1, EntityPlayer var2) {
      Side var3 = FMLCommonHandler.instance().getEffectiveSide();
      if(var3 == Side.SERVER) {
         NBTTagCompound var4 = this.nbt(var2, "pres");
         int[] var5 = JRMCoreH.PlyrAttrbts(var2);
         String var6 = var4.getString("jrmcStatusEff");
         String var7 = var4.getString("jrmcSSltX");
         String var8 = var4.getString("jrmcSSltY");
         byte var9 = var4.getByte("jrmcState");
         byte var10 = var9;
         byte var11 = var4.getByte("jrmcState2");
         byte var12 = JRMCoreH.getByte(var2, "jrmcAlign");
         byte var13 = var4.getByte("jrmcSaiRg");
         byte var14 = var4.getByte("jrmcRace");
         boolean var15 = JRMCoreH.PlyrSettings(var4, 0);
         int var16 = JRMCoreH.SklLvl(8, var2);
         int var17 = JRMCoreH.SklLvl(9, var2);
         boolean var18 = JRMCoreH.PlyrSettings(var2, 3);
         boolean var19 = JRMCoreH.PlyrSettings(var2, 1);
         boolean var20 = false;
         if(JRMCoreH.race_saiyan(var14)) {
            short var21 = 200;
            AxisAlignedBB var22 = AxisAlignedBB.getBoundingBox(var2.posX - (double)var21, 200.0D, var2.posZ - (double)var21, var2.posX + (double)var21, 255.0D, var2.posZ + (double)var21);
            List var23 = var2.worldObj.getEntitiesWithinAABB(EntityEnergyFM.class, var22);
            boolean var24 = !var23.isEmpty();
            boolean var25 = JRMCoreH.tailHas(JRMCoreH.getByte(var2, "jrmcTlmd"));
            boolean var26 = JRMCoreH.StusEfcts(8, var6) || var24;
            boolean var27 = var2.rotationPitch <= -90.0F;
            var20 = var26 && var27 && var25 && var9 == 0;
         }

         boolean var55 = JRMCoreH.PlyrSettings(var4, 4) && !JRMCoreH.StusEfcts(10, var6) && !JRMCoreH.StusEfcts(11, var6);
         String var56 = var4.getString("jrmcFuzion");
         if(var55 && !JRMCoreConfig.fuzn) {
            String var59 = JRMCoreH.trlai("jrmc", "specskilldisabled");
            var2.addChatMessage((new ChatComponentTranslation(var59, new Object[]{JRMCoreH.vlblSklsNms[0]})).setChatStyle(styl));
         } else if(var55 && JRMCoreConfig.fuzn) {
            if(var56.equals(" ")) {
               var4.setByte("jrmcSaiRg", (byte)0);
               byte var58 = 3;
               AxisAlignedBB var64 = AxisAlignedBB.getBoundingBox(var2.posX - (double)var58, var2.posY - (double)var58, var2.posZ - (double)var58, var2.posX + (double)var58, var2.posY + (double)var58, var2.posZ + (double)var58);
               List var68 = var2.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var64);
               if(!var68.isEmpty()) {
                  for(int var73 = 0; var73 < var68.size(); ++var73) {
                     EntityPlayer var77 = (EntityPlayer)var68.get(var73);
                     if(!var77.getCommandSenderName().equals(var2.getCommandSenderName())) {
                        NBTTagCompound var82 = this.nbt(var77, "pres");
                        byte var88 = var82.getByte("jrmcRace");
                        if(JRMCoreH.race_match(var14, var88)) {
                           boolean var93 = JRMCoreH.PlyrSettings(var82, 4);
                           String var98 = var82.getString("jrmcStatusEff");
                           boolean var104 = true;
                           Random var107 = new Random();
                           int var109 = var107.nextInt(100);
                           int var112 = JRMCoreH.SklLvl(0, var2);
                           int var115 = JRMCoreH.SklLvl(0, var77);
                           System.out.println(var109 + " " + (30 + var112 * 3 + var115 * 3) + " " + (30 + var112 * 3 + var115 * 3 > var109));
                           if(30 + var112 * 3 + var115 * 3 < var109) {
                              JRMCoreH.PlyrSettingsRem(var82, 4);
                              JRMCoreH.PlyrSettingsRem(var4, 4);
                              String var117 = JRMCoreH.trlai("dbc", "playersFuseFaild");
                              var2.addChatMessage((new ChatComponentTranslation(var117, new Object[]{var2.getCommandSenderName(), var77.getCommandSenderName()})).setChatStyle(styl));
                              var77.addChatMessage((new ChatComponentTranslation(var117, new Object[]{var2.getCommandSenderName(), var77.getCommandSenderName()})).setChatStyle(styl));
                              System.out.println(var2.getCommandSenderName() + " and " + var77.getCommandSenderName() + " fusion failed!");
                              var4.setString("jrmcFuzion", "120");
                              var82.setString("jrmcFuzion", "120");
                              JRMCoreH.StusEfcts(10, var4, false);
                              JRMCoreH.StusEfcts(11, var82, false);
                           } else if(var93 && var104) {
                              JRMCoreH.PlyrSettingsRem(var82, 4);
                              JRMCoreH.PlyrSettingsRem(var4, 4);
                              var6 = JRMCoreH.StusEfcts(10, var6, var4, true);
                              var98 = JRMCoreH.StusEfcts(11, var98, var82, true);
                              String var116 = JRMCoreHDBC.f_namgen(var2.getCommandSenderName(), var77.getCommandSenderName());
                              int var38 = 60 - (JRMCoreH.race_arc(var14) && var10 > 4?(var10 - 4) * 5:(JRMCoreH.race_humanNamek(var14)?var10 * 5:var10 * 2));
                              var82.setString("jrmcFuzion", var2.getCommandSenderName() + "," + var77.getCommandSenderName() + "," + var38);
                              var4.setString("jrmcFuzion", var2.getCommandSenderName() + "," + var77.getCommandSenderName() + "," + var38);
                              System.out.println(var2.getCommandSenderName() + " and " + var77.getCommandSenderName() + " fused to " + var116 + "!");
                              String var39 = JRMCoreH.trlai("dbc", "playersFused");
                              var2.addChatMessage((new ChatComponentTranslation(var39, new Object[]{var2.getCommandSenderName(), var77.getCommandSenderName(), var116})).setChatStyle(styl));
                              var77.addChatMessage((new ChatComponentTranslation(var39, new Object[]{var2.getCommandSenderName(), var77.getCommandSenderName(), var116})).setChatStyle(styl));
                              this.soundPowerUp(var2, "jinryuudragonbc:DBC.fusefin");
                              var6 = JRMCoreH.StusEfcts(3, var6, var4, false);
                              var6 = JRMCoreH.StusEfcts(5, var6, var4, false);
                              var6 = JRMCoreH.StusEfcts(4, var6, var4, false);
                              var98 = JRMCoreH.StusEfcts(3, var98, var82, false);
                              var98 = JRMCoreH.StusEfcts(5, var98, var82, false);
                              JRMCoreH.StusEfcts(4, var98, var82, false);
                              var4.setByte("jrmcState2", (byte)0);
                              var82.setByte("jrmcState2", (byte)0);
                              byte var40 = var4.getByte("jrmcPwrtyp");
                              byte var41 = var4.getByte("jrmcRace");
                              byte var42 = var4.getByte("jrmcClass");
                              int var43 = JRMCoreH.stat(var40, 2, var5[2], var41, var42, 0.0F);
                              int var44 = JRMCoreH.stat(var40, 5, var5[5], var41, var42, 0.0F);
                              var5 = JRMCoreH.PlyrAttrbts(var2);
                              int var45 = JRMCoreH.stat(var40, 2, var5[2], var41, var42, 0.0F);
                              int var46 = JRMCoreH.stat(var40, 5, var5[5], var41, var42, 0.0F);
                              double var47 = (double)var4.getInteger("jrmcBdy");
                              double var49 = (double)var4.getInteger("jrmcEnrgy");
                              var4.setInteger("jrmcBdy", (int)(var47 / (double)var43 * (double)var45));
                              var4.setInteger("jrmcEnrgy", (int)(var49 / (double)var44 * (double)var46));
                           }
                        }
                     }
                  }
               }
            }
         } else if(var7 != null && (!var15 || var20)) {
            int var57 = JRMCoreH.SklLvlX(1, var7);
            if(!JRMCoreH.race_saiyan(var14)) {
               if(var14 == 4) {
                  String var63 = JRMCoreH.StusEfcts[6];
                  if(var6.contains(var63)) {
                     var4.setString("jrmcStatusEff", var6.replace(var63, ""));
                  }

                  var4.setByte("jrmcTlmd", (byte)0);
                  if(var57 >= 1 && var9 == 0 && var13 >= 100) {
                     var10 = 1;
                     var4.setByte("jrmcState", (byte)1);
                     var4.setByte("jrmcSaiRg", (byte)0);
                  } else if(var57 >= 1 && var9 == 1 && var13 >= 100) {
                     var10 = 2;
                     var4.setByte("jrmcState", (byte)2);
                     var4.setByte("jrmcSaiRg", (byte)0);
                  } else if(var57 >= 1 && var9 == 2 && var13 >= 100) {
                     var10 = 3;
                     var4.setByte("jrmcState", (byte)3);
                     var4.setByte("jrmcSaiRg", (byte)0);
                  } else if(var57 >= 1 && var9 == 3 && var13 >= 100) {
                     var10 = 4;
                     var4.setByte("jrmcState", (byte)4);
                     var4.setByte("jrmcSaiRg", (byte)0);
                  } else if(var57 >= 7 && var9 == 4 && var13 >= 100 && var17 > 0 && var18) {
                     var10 = 7;
                     var4.setByte("jrmcState", (byte)7);
                     var4.setByte("jrmcSaiRg", (byte)0);
                  } else if(var57 >= 7 && var9 == 4 && var13 >= 100 && var19) {
                     var10 = 6;
                     var4.setByte("jrmcState", (byte)6);
                     var4.setByte("jrmcSaiRg", (byte)0);
                  } else if(var57 >= 4 && var9 == 4 && var13 >= 100) {
                     var10 = 5;
                     var4.setByte("jrmcState", (byte)5);
                     var4.setByte("jrmcSaiRg", (byte)0);
                  }
               } else if(JRMCoreH.race_humanNamek(var14)) {
                  if(JRMCoreHDBC.DBCgetConfigGodform() && JRMCoreHDBC.godformslrHN(var57) && var9 == 0 && var13 >= 100 && var17 > 0 && var18) {
                     var10 = 3;
                     var4.setByte("jrmcState", (byte)3);
                     var4.setByte("jrmcSaiRg", (byte)0);
                  } else if(var57 >= 3 && var9 == 0 && var13 >= 100 && var19) {
                     var10 = 1;
                     var4.setByte("jrmcState", (byte)1);
                     var4.setByte("jrmcSaiRg", (byte)0);
                  } else if(var57 >= 2 && var9 == 0 && var13 >= 100) {
                     var10 = 2;
                     var4.setByte("jrmcState", (byte)2);
                     var4.setByte("jrmcSaiRg", (byte)0);
                  }
               }
            } else {
               int var62 = 0;
               byte var67 = 3;
               AxisAlignedBB var71 = AxisAlignedBB.getBoundingBox(var2.posX - (double)var67, var2.posY - (double)var67, var2.posZ - (double)var67, var2.posX + (double)var67, var2.posY + (double)var67, var2.posZ + (double)var67);
               List var76 = var2.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var71);
               if(!var76.isEmpty()) {
                  for(int var28 = 0; var28 < var76.size(); ++var28) {
                     EntityPlayer var29 = (EntityPlayer)var76.get(var28);
                     if(!var29.getCommandSenderName().equals(var2.getCommandSenderName())) {
                        String var30 = JRMCoreH.getString(var29, "jrmcStatusEff");
                        byte var31 = JRMCoreH.getByte(var29, "jrmcAlign");
                        boolean var32 = JRMCoreH.StusEfcts(4, var30);
                        int var33 = JRMCoreH.getInt(var29, "jrmcGodStrain");
                        byte var34 = JRMCoreH.getByte(var29, "jrmcState");
                        byte var35 = JRMCoreH.getByte(var29, "jrmcRace");
                        boolean var36 = var34 == 1 || var34 == 4 || var34 == 0;
                        if(var36 && var32 && var33 <= 0 && JRMCoreH.Algnmnt(var31) == 0 && JRMCoreH.race_saiyan(var35)) {
                           ++var62;
                        }
                     }
                  }
               }

               if(var62 == 0) {
                  var71 = AxisAlignedBB.getBoundingBox(var2.posX - (double)var67, var2.posY - (double)var67, var2.posZ - (double)var67, var2.posX + (double)var67, var2.posY + (double)var67, var2.posZ + (double)var67);
                  List var80 = var2.worldObj.getEntitiesWithinAABB(EntityDBCKami.class, var71);
                  if(!var80.isEmpty()) {
                     for(int var85 = 0; var85 < var80.size(); ++var85) {
                        EntityDBCKami var91 = (EntityDBCKami)var80.get(var85);
                        if(var91 instanceof EntityMasterGoku) {
                           ++var62;
                        }
                     }
                  }
               }

               if(var20 && var13 >= 100) {
                  var10 = 7;
                  var4.setByte("jrmcState", (byte)7);
                  var4.setByte("jrmcSaiRg", (byte)0);
               } else if(var9 == 7 && var13 >= 100) {
                  var10 = 8;
                  var4.setByte("jrmcState", (byte)8);
                  var4.setByte("jrmcSaiRg", (byte)0);
               } else if(JRMCoreHDBC.DBCgetConfigGodform() && var9 == 0 && var13 >= 100 && var62 >= DBCConfig.SSGHelp && JRMCoreH.Algnmnt(var12) == 0) {
                  var10 = 9;
                  var4.setByte("jrmcState", (byte)9);
                  var4.setByte("jrmcSaiRg", (byte)0);
                  int var81 = JRMCoreH.attrLvl(var5);
                  int var86 = 0;
                  if(!var76.isEmpty()) {
                     int var92 = 0;

                     for(int var95 = 0; var95 < var76.size(); ++var95) {
                        EntityPlayer var103 = (EntityPlayer)var76.get(var95);
                        if(!var103.getCommandSenderName().equals(var2.getCommandSenderName())) {
                           byte var106 = JRMCoreH.getByte(var103, "jrmcAlign");
                           int var108 = JRMCoreH.getInt(var103, "jrmcGodStrain");
                           byte var111 = JRMCoreH.getByte(var103, "jrmcState");
                           boolean var114 = var111 == 1 || var111 == 4 || var111 == 0;
                           byte var37 = JRMCoreH.getByte(var103, "jrmcRace");
                           if(var114 && var108 <= 0 && JRMCoreH.Algnmnt(var106) == 0 && JRMCoreH.race_saiyan(var37)) {
                              var86 += JRMCoreH.attrLvl(JRMCoreH.PlyrAttrbts(var103));
                              JRMCoreH.setInt(DBCConfig.StrainGod, var103, "jrmcGodStrain");
                              JRMCoreH.setInt(0, var103, "jrmcEnrgy");
                              ++var92;
                           }
                        }
                     }

                     var86 = (var92 == 0?var81:var86) / DBCConfig.SSGHelp;
                     float var96 = (float)var86 / (float)var81;
                     var96 = var96 > 2.0F?2.0F:(var96 < 0.2F?0.2F:var96);
                     var86 = (int)(120.0F * var96);
                  }

                  JRMCoreH.setInt(var86, var2, "jrmcGodPwr");
               } else if(JRMCoreHDBC.DBCgetConfigGodform() && JRMCoreHDBC.godformslr(var57) && var9 == 0 && var13 >= 100 && var17 > 0 && var18) {
                  var10 = 10;
                  var4.setByte("jrmcState", (byte)10);
                  var4.setByte("jrmcSaiRg", (byte)0);
               } else if(var57 >= 5 && var9 == 0 && var13 >= 100) {
                  var10 = 4;
                  var4.setByte("jrmcState", (byte)4);
                  var4.setByte("jrmcSaiRg", (byte)0);
               } else if(var57 >= 2 && var9 == 0 && var13 >= 100) {
                  var10 = 1;
                  var4.setByte("jrmcState", (byte)1);
                  var4.setByte("jrmcSaiRg", (byte)0);
               } else if(var57 >= 6 && var9 == 4 && var19 && var13 >= 100) {
                  var10 = 5;
                  var4.setByte("jrmcState", (byte)5);
                  var4.setByte("jrmcSaiRg", (byte)0);
               } else if(var57 >= 3 && (var9 == 1 || var9 == 4) && var13 >= 100) {
                  var10 = 2;
                  var4.setByte("jrmcState", (byte)2);
                  var4.setByte("jrmcSaiRg", (byte)0);
               } else if(var57 >= 4 && var9 == 2 && var13 >= 100) {
                  var10 = 3;
                  var4.setByte("jrmcState", (byte)3);
                  var4.setByte("jrmcSaiRg", (byte)0);
               } else if(var57 >= 7 && var9 == 5 && var13 >= 100) {
                  var10 = 6;
                  var4.setByte("jrmcState", (byte)6);
                  var4.setByte("jrmcSaiRg", (byte)0);
               }
            }
         } else if(var15 && var16 > 0 && var16 > var11 && JRMCoreH.TransKaiDmg.length - 1 > var11) {
            var4.setByte("jrmcState2", (byte)(var11 + 1));
            var2.addChatMessage(new ChatComponentText(JRMCoreH.clgd + "Kaioken " + JRMCoreH.TransKaiNms[var11 + 1]));
         }

         if(!var56.equals(" ") && !var15) {
            String[] var60 = var56.split(",");
            if(var60.length == 3) {
               boolean var65 = var60[0].equalsIgnoreCase(var2.getCommandSenderName());
               if(var65) {
                  EntityPlayer var69 = var2.worldObj.getPlayerEntityByName(var60[1]);
                  boolean var74 = var69 == null;
                  int var78 = Integer.parseInt(var60[2]) - (JRMCoreH.race_arc(var14) && var10 > 4?(var10 - 4) * 5:(JRMCoreH.race_humanNamek(var14)?var10 * 5:var10 * 2));
                  if(!var74) {
                     NBTTagCompound var83 = JRMCoreH.nbt(var69);
                     var4.setString("jrmcFuzion", var60[0] + "," + var60[1] + "," + var78);
                     var83.setString("jrmcFuzion", var60[0] + "," + var60[1] + "," + var78);
                  }
               }
            }
         }

         var11 = var4.getByte("jrmcState2");
         if(var11 > 0) {
            byte var61 = var4.getByte("jrmcPwrtyp");
            byte var66 = var4.getByte("jrmcRace");
            byte var70 = var4.getByte("jrmcClass");
            int var75 = JRMCoreH.SklLvlX(1, JRMCoreH.getString(var2, "jrmcSSltX"));
            int var79 = JRMCoreH.getInt(var2, "jrmcStrain");
            int var84 = var4.getInteger("jrmcStrainTemp");
            int var89 = var4.getInteger("jrmcStrainActv");
            int var94 = JRMCoreH.stat(var61, 2, var5[2], var66, var70, 0.0F);
            int var102 = JRMCoreH.getInt(var2, "jrmcBdy");
            double var105 = JRMCoreH.KaiKCost(var2) * (double)var94;
            int var110 = (int)((double)var102 - var105 < 1.0D?1.0D:(double)var102 - var105);
            JRMCoreH.setInt(var110, var2, "jrmcBdy");
            if(!JRMCoreConfig.sskai) {
               JRMCoreH.setInt(var84 + (JRMCoreH.race_saiyan(var14) && var10 == 0?1:(var14 == 4 && var10 <= 4?1:(JRMCoreH.race_humanNamek(var14) && var10 <= 1?1:12))) + (20 - var16), var2, "jrmcStrainTemp");
            }

            if((float)var110 <= (float)var94 * 0.1F) {
               var4.setByte("jrmcState", (byte)(var66 == 4?4:0));
               var4.setByte("jrmcState2", (byte)0);
               JRMCoreH.setInt(var110, var2, "jrmcBdy");
            }

            if(!JRMCoreConfig.sskai) {
               if(var89 <= 0) {
                  int var113 = 100 + var16 * 6 - MathHelper.ceiling_float_int(JRMCoreH.KaiKFBal(var14, var9, var11, var75, var79)) * 2 - var11 * 2;
                  JRMCoreH.setInt(var113, var2, "jrmcStrainActv");
               } else {
                  var89 = var89 - MathHelper.ceiling_float_int(JRMCoreH.KaiKFBal(var14, var9, var11, var75, var79)) * 2 - var11 * 2;
                  JRMCoreH.setInt(var89, var2, "jrmcStrainActv");
               }
            }
         }
      }

   }

   public void handleDBCdescend(byte var1, EntityPlayer var2) {
      NBTTagCompound var3 = this.nbt(var2, "pres");
      byte var4 = var3.getByte("jrmcRace");
      byte var5 = var3.getByte("jrmcState");
      byte var6 = var3.getByte("jrmcState2");
      if(var6 > 0) {
         int var7 = var3.getInteger("jrmcStrainTemp");
         int var8 = var3.getInteger("jrmcStrainActv");
         int var9 = var3.getInteger("jrmcStrain");
         JRMCoreH.KaiKStrainAct(var3, var6, var9, var7, var8);
         var3.setByte("jrmcState2", (byte)0);
      } else {
         var3.setByte("jrmcState", (byte)(var4 == 4 && var5 >= 4?4:0));
      }

      if(var1 == 4) {
         var3.setByte("jrmcState", (byte)0);
      }

   }

   public void handleDBCchargesound(int var1, String var2, EntityPlayer var3) {
      this.soundPowerUp(var3, var2);
   }

   public void handleDBCjumpsound(int var1, int var2, EntityPlayer var3) {
      if(var1 == -2) {
         PD.sendTo(new DBCPduo(var1, JRMCoreH.getInt(var3, "jrmcWishes")), (EntityPlayerMP)var3);
      }

      if(var1 == -1) {
         PD.sendTo(new DBCPduo(var1, JRMCoreH.getInt(var3, "jrmcReviveTmer")), (EntityPlayerMP)var3);
      }

      if(var1 < 999 && var1 >= 0) {
         byte var4 = 16;
         AxisAlignedBB var5 = AxisAlignedBB.getBoundingBox(var3.posX - (double)var4, var3.posY - (double)var4, var3.posZ - (double)var4, var3.posX + (double)var4, var3.posY + (double)var4, var3.posZ + (double)var4);
         List var6 = var3.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var5);

         for(int var7 = 0; var7 < var6.size(); ++var7) {
            EntityPlayer var8 = (EntityPlayer)var6.get(var7);
            PD.sendTo(new DBCPduo(var1, var2), (EntityPlayerMP)var8);
         }
      } else if(var1 == 1000 && var3.worldObj.getEntityByID(var2) != null) {
         var3.worldObj.getEntityByID(var2).setDead();
      }

   }

   public void handleDBCascendsound(int var1, EntityPlayer var2) {
      byte var3 = 16;
      AxisAlignedBB var4 = AxisAlignedBB.getBoundingBox(var2.posX - (double)var3, var2.posY - (double)var3, var2.posZ - (double)var3, var2.posX + (double)var3, var2.posY + (double)var3, var2.posZ + (double)var3);
      List var5 = var2.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var4);

      for(int var6 = 0; var6 < var5.size(); ++var6) {
         EntityPlayer var7 = (EntityPlayer)var5.get(var6);
         PD.sendTo(new DBCPascendsound(var1), (EntityPlayerMP)var7);
      }

   }

   public void handleDBCdescendsound(int var1, EntityPlayer var2) {
      byte var3 = 16;
      AxisAlignedBB var4 = AxisAlignedBB.getBoundingBox(var2.posX - (double)var3, var2.posY - (double)var3, var2.posZ - (double)var3, var2.posX + (double)var3, var2.posY + (double)var3, var2.posZ + (double)var3);
      List var5 = var2.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var4);

      for(int var6 = 0; var6 < var5.size(); ++var6) {
         EntityPlayer var7 = (EntityPlayer)var5.get(var6);
         PD.sendTo(new DBCPdescendsound(var1), (EntityPlayerMP)var7);
      }

   }

   public void handleDBCscouter1(int var1, EntityPlayer var2) {
      byte var3 = 16;
      AxisAlignedBB var4 = AxisAlignedBB.getBoundingBox(var2.posX - (double)var3, var2.posY - (double)var3, var2.posZ - (double)var3, var2.posX + (double)var3, var2.posY + (double)var3, var2.posZ + (double)var3);
      List var5 = var2.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var4);

      for(int var6 = 0; var6 < var5.size(); ++var6) {
         EntityPlayer var7 = (EntityPlayer)var5.get(var6);
         PD.sendTo(new DBCPscouter1(var1), (EntityPlayerMP)var7);
      }

   }

   public void handleDBCscouter2(int var1, EntityPlayer var2) {
      byte var3 = 16;
      AxisAlignedBB var4 = AxisAlignedBB.getBoundingBox(var2.posX - (double)var3, var2.posY - (double)var3, var2.posZ - (double)var3, var2.posX + (double)var3, var2.posY + (double)var3, var2.posZ + (double)var3);
      List var5 = var2.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var4);

      for(int var6 = 0; var6 < var5.size(); ++var6) {
         EntityPlayer var7 = (EntityPlayer)var5.get(var6);
         PD.sendTo(new DBCPscouter2(var1), (EntityPlayerMP)var7);
      }

   }

   public void handleDBCscouter3(int var1, EntityPlayer var2) {
      byte var3 = 16;
      AxisAlignedBB var4 = AxisAlignedBB.getBoundingBox(var2.posX - (double)var3, var2.posY - (double)var3, var2.posZ - (double)var3, var2.posX + (double)var3, var2.posY + (double)var3, var2.posZ + (double)var3);
      List var5 = var2.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var4);

      for(int var6 = 0; var6 < var5.size(); ++var6) {
         EntityPlayer var7 = (EntityPlayer)var5.get(var6);
         PD.sendTo(new DBCPscouter3(var1), (EntityPlayerMP)var7);
      }

   }

   public void handleDBCscouter4(int var1, EntityPlayer var2) {
      byte var3 = 16;
      AxisAlignedBB var4 = AxisAlignedBB.getBoundingBox(var2.posX - (double)var3, var2.posY - (double)var3, var2.posZ - (double)var3, var2.posX + (double)var3, var2.posY + (double)var3, var2.posZ + (double)var3);
      List var5 = var2.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var4);

      for(int var6 = 0; var6 < var5.size(); ++var6) {
         EntityPlayer var7 = (EntityPlayer)var5.get(var6);
         PD.sendTo(new DBCPscouter4(var1), (EntityPlayerMP)var7);
      }

   }

   public void soundPowerUp(EntityPlayer var1, String var2) {
      var1.worldObj.playSoundAtEntity(var1, var2, 0.25F, 1.0F);
   }

   public NBTTagCompound nbt(EntityPlayer var1, String var2) {
      NBTTagCompound var3;
      if(var2.contains("pres")) {
         if(!var1.getEntityData().hasKey("PlayerPersisted")) {
            var3 = new NBTTagCompound();
            var1.getEntityData().setTag("PlayerPersisted", var3);
         } else {
            var3 = var1.getEntityData().getCompoundTag("PlayerPersisted");
         }
      } else {
         var3 = var1.getEntityData();
      }

      return var3;
   }

   public void closeInventoryChange(EntityPlayer var1) {
      var1.inventory.inventoryChanged = false;
   }
}
