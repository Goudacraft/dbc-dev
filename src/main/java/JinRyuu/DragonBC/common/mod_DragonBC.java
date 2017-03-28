package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.DBC;
import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.DBCEH;
import JinRyuu.DragonBC.common.DBCHandlerBucket;
import JinRyuu.DragonBC.common.DBCHandlerFuel;
import JinRyuu.DragonBC.common.DBCTab;
import JinRyuu.DragonBC.common.Lang;
import JinRyuu.DragonBC.common.RecipesDBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Entitys.EntityEnergyFM;
import JinRyuu.DragonBC.common.Gui.ComDbc;
import JinRyuu.DragonBC.common.Gui.ComDbcSpawn;
import JinRyuu.DragonBC.common.Gui.ComReincarnate;
import JinRyuu.DragonBC.common.Gui.ComRespCon;
import JinRyuu.DragonBC.common.Gui.ComRevive;
import JinRyuu.DragonBC.common.Gui.ComSkill;
import JinRyuu.DragonBC.common.Gui.ComStrain;
import JinRyuu.DragonBC.common.Gui.DBCGuiHandler;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntityBarta;
import JinRyuu.DragonBC.common.Npcs.EntityBuuFat;
import JinRyuu.DragonBC.common.Npcs.EntityBuuSuper;
import JinRyuu.DragonBC.common.Npcs.EntityCell1;
import JinRyuu.DragonBC.common.Npcs.EntityCell2;
import JinRyuu.DragonBC.common.Npcs.EntityCell3;
import JinRyuu.DragonBC.common.Npcs.EntityCell4;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg16;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg17;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg18;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg19;
import JinRyuu.DragonBC.common.Npcs.EntityCyborg20;
import JinRyuu.DragonBC.common.Npcs.EntityDarbura;
import JinRyuu.DragonBC.common.Npcs.EntityDino01;
import JinRyuu.DragonBC.common.Npcs.EntityDodoria;
import JinRyuu.DragonBC.common.Npcs.EntityDragon;
import JinRyuu.DragonBC.common.Npcs.EntityDragon2;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza1;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza2;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza3;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza4;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza5;
import JinRyuu.DragonBC.common.Npcs.EntityFreeza6;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaFather;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaMecha;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier1;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier2;
import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier3;
import JinRyuu.DragonBC.common.Npcs.EntityGinyu;
import JinRyuu.DragonBC.common.Npcs.EntityGuldo;
import JinRyuu.DragonBC.common.Npcs.EntityHell01;
import JinRyuu.DragonBC.common.Npcs.EntityHell02;
import JinRyuu.DragonBC.common.Npcs.EntityJeice;
import JinRyuu.DragonBC.common.Npcs.EntityKiwi;
import JinRyuu.DragonBC.common.Npcs.EntityMasterBabidi;
import JinRyuu.DragonBC.common.Npcs.EntityMasterCell;
import JinRyuu.DragonBC.common.Npcs.EntityMasterEnma;
import JinRyuu.DragonBC.common.Npcs.EntityMasterFreeza;
import JinRyuu.DragonBC.common.Npcs.EntityMasterGoku;
import JinRyuu.DragonBC.common.Npcs.EntityMasterKaio;
import JinRyuu.DragonBC.common.Npcs.EntityMasterKami;
import JinRyuu.DragonBC.common.Npcs.EntityMasterKarin;
import JinRyuu.DragonBC.common.Npcs.EntityMasterRoshi;
import JinRyuu.DragonBC.common.Npcs.EntityNamekian01;
import JinRyuu.DragonBC.common.Npcs.EntityNamekian03;
import JinRyuu.DragonBC.common.Npcs.EntityPorunga;
import JinRyuu.DragonBC.common.Npcs.EntityPorunga2;
import JinRyuu.DragonBC.common.Npcs.EntityPuipui;
import JinRyuu.DragonBC.common.Npcs.EntityRecoome;
import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan01;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyan02;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyanNappa;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyanRaditz;
import JinRyuu.DragonBC.common.Npcs.EntitySaiyanVegeta;
import JinRyuu.DragonBC.common.Npcs.EntityYakon;
import JinRyuu.DragonBC.common.Npcs.EntityZarbon;
import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
import JinRyuu.DragonBC.common.Render.DragonBlock01TileEntity;
import JinRyuu.DragonBC.common.Render.DragonBlockNS01TileEntity;
import JinRyuu.DragonBC.common.Render.DragonBlockNamek01TileEntity;
import JinRyuu.DragonBC.common.Render.DragonBlockS01TileEntity;
import JinRyuu.DragonBC.common.Render.KintounBlackEntity;
import JinRyuu.DragonBC.common.Render.KintounEntity;
import JinRyuu.DragonBC.common.Render.MedPodDoor1TileEntity;
import JinRyuu.DragonBC.common.Render.SaibaiHatchedTileEntity;
import JinRyuu.DragonBC.common.Render.SpacePod01Entity;
import JinRyuu.DragonBC.common.Render.SpacePod01TileEntity;
import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
import JinRyuu.DragonBC.common.Worlds.WorldGeneratorDB;
import JinRyuu.DragonBC.common.Worlds.x0WorldProviderNamek;
import JinRyuu.DragonBC.common.Worlds.x1WorldProviderOW;
import JinRyuu.DragonBC.common.Worlds.x2WorldProviderTC;
import JinRyuu.DragonBC.common.Worlds.x3WorldProviderVegeta;
import JinRyuu.JRMCore.entity.EntityEnergyAtt;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.FluidContainerRegistry;
import org.apache.logging.log4j.Logger;

@Mod(
   modid = "jinryuudragonblockc",
   name = "Dragon Block C",
   version = "1.4.30",
   dependencies = "required-after:jinryuujrmcore"
)
public class mod_DragonBC {
   public static final String MOD = "Dragon Block C";
   public static CreativeTabs DragonBlockC = new DBCTab("DragonBlockC");
   @SidedProxy(
      clientSide = "JinRyuu.DragonBC.common.DBCClient",
      serverSide = "JinRyuu.DragonBC.common.DBC"
   )
   public static DBC proxy;
   @Instance("mod_DragonBC")
   public static mod_DragonBC instance = new mod_DragonBC();
   private DBCGuiHandler guiHandler = new DBCGuiHandler();
   public static boolean DeathSystemOff = false;
   public static int DBSpawnChance = 4;
   public static boolean DBSpawnEnabled = true;
   public static String DBSpawnTime = "daytime";
   public static boolean SagaSystemOn = true;
   public static boolean SagaSysSpawnPods = true;
   public static boolean cDeathSystemOff = false;
   public static int cDBSpawnChance = 4;
   public static boolean cDBSpawnEnabled = true;
   public static String cDBSpawnTime = "daytime";
   public static boolean cSagaSystemOn = true;
   public static boolean cSagaSysSpawnPods = true;
   public static int cwfb = 0;
   public static int chfb = 0;
   public static int cwfn = 0;
   public static int chfn = 0;
   public static boolean ConsSizeChangeOn = true;
   public static boolean TransSizeChangeOn = true;
   public static int renderId = 100;
   public int entityID = 0;
   public static Properties runtimeIdProperties = new Properties();
   public static Logger logger;

   public mod_DragonBC() {
   }

   private String getVersion() {
      return "1.4.30";
   }

   public int nextEntityID() {
      ++this.entityID;
      return this.entityID;
   }

   public static DamageSource causeEntityEnergyAttDamage(EntityEnergyAtt var0, Entity var1) {
      return (new EntityDamageSourceIndirect("Energy Attack", var0, var1)).setProjectile();
   }

   @EventHandler
   public void ServerStarting(FMLServerStartingEvent var1) {
      ServerCommandManager var2 = (ServerCommandManager)var1.getServer().getCommandManager();
      var2.registerCommand(new ComRespCon());
      var2.registerCommand(new ComDbc());
      var2.registerCommand(new ComDbcSpawn());
      var2.registerCommand(new ComRevive());
      var2.registerCommand(new ComSkill());
      var2.registerCommand(new ComStrain());
      var2.registerCommand(new ComReincarnate());
   }

   private void modMeta(FMLPreInitializationEvent var1) {
      ModMetadata var2 = var1.getModMetadata();
      var2.name = "Dragon Block C";
      var2.description = "A Dragon Ball mod for Minecraft.";
      var2.authorList.clear();
      var2.authorList.add("JinRyuu Nagy");
      var2.modId = "jinryuudragonblockc";
      var2.version = "1.4.30";
      var2.autogenerated = false;
   }

   @EventHandler
   public void PreLoad(FMLPreInitializationEvent var1) {
      this.modMeta(var1);
      logger = var1.getModLog();
      logger.info("Current Version " + this.getVersion());
      logger.info("Copyright (c) Tamas \'JinRyuu\' Nagy,  2012-" + (new SimpleDateFormat("yyyy")).format(new Date()) + "");
      logger.info("http://jingames.net");
      Configuration var2 = new Configuration(var1.getSuggestedConfigurationFile());
      DBCConfig.init(var2);
      proxy.registerKeys();
      proxy.registerTicks();
      proxy.registerDBCRender();
      proxy.initialize();
      logger.info("Pre Initialization Complated");
      instance = this;
   }

   @EventHandler
   public void load(FMLInitializationEvent var1) {
      BlocksDBC.init();
      BlocksDBC.register();
      ItemsDBC.init();
      RecipesDBC.init();
      DBCEH var2 = new DBCEH();
      MinecraftForge.EVENT_BUS.register(var2);
      FMLCommonHandler.instance().bus().register(var2);
      GameRegistry.registerFuelHandler(new DBCHandlerFuel());
      FluidContainerRegistry.registerFluidContainer(BlocksDBC.medicalLiquid, new ItemStack(ItemsDBC.ItemBucketMedLiq), new ItemStack(Items.bucket));
      DBCHandlerBucket.INSTANCE.buckets.put(BlocksDBC.BlockHealingPods, ItemsDBC.ItemBucketMedLiq);
      MinecraftForge.EVENT_BUS.register(DBCHandlerBucket.INSTANCE);
      BiomeGenBaseDBC.init();
      GameRegistry.registerWorldGenerator(new WorldGeneratorDB(), 0);
      DimensionManager.registerProviderType(DBCConfig.planetNamek, x0WorldProviderNamek.class, true);
      DimensionManager.registerDimension(DBCConfig.planetNamek, DBCConfig.planetNamek);
      if(DBCConfig.plntVegeta) {
         DimensionManager.registerProviderType(DBCConfig.planetVegeta, x3WorldProviderVegeta.class, false);
         DimensionManager.registerDimension(DBCConfig.planetVegeta, DBCConfig.planetVegeta);
      }

      DimensionManager.registerProviderType(22, x1WorldProviderOW.class, true);
      DimensionManager.registerDimension(22, 22);
      DimensionManager.registerProviderType(23, x2WorldProviderTC.class, false);
      DimensionManager.registerDimension(23, 23);
      Lang.init();
      logger.info("Initialization Completed");
      EntityRegistry.registerModEntity(EntityPorunga.class, "Dragonp", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityPorunga2.class, "Dragonp2", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityDragon2.class, "Dragon2", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityDragon.class, "Dragon", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntitySaiyanRaditz.class, "Raditz", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntitySaiyanNappa.class, "Nappa", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntitySaiyanVegeta.class, "Vegeta", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntitySaibaiman.class, "Saibaiman", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntitySaiyan01.class, "Saiyan01", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntitySaiyan02.class, "Saiyan02", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityKiwi.class, "Kiwi", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityDodoria.class, "Dodoria", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityZarbon.class, "Zarbon", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityGuldo.class, "Guldo", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityRecoome.class, "Recoome", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityBarta.class, "Barta", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityJeice.class, "Jeice", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityGinyu.class, "Ginyu", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityFreezaSoldier1.class, "FreezaSoldier1", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityFreezaSoldier2.class, "FreezaSoldier2", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityFreezaSoldier3.class, "FreezaSoldier3", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityFreeza1.class, "Freeza1", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityFreeza2.class, "Freeza2", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityFreeza3.class, "Freeza3", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityFreeza4.class, "Freeza4", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityFreeza5.class, "Freeza5", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityFreeza6.class, "Freeza6", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityFreezaFather.class, "KingCold", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityFreezaMecha.class, "MechaFreeza", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityCyborg16.class, "Cyborg16", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityCyborg17.class, "Cyborg17", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityCyborg18.class, "Cyborg18", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityCyborg19.class, "Cyborg19", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityCyborg20.class, "Cyborg20", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityCell1.class, "Cell1", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityCell2.class, "Cell2", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityCell3.class, "Cell3", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityCell4.class, "Cell4", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(SpacePod01Entity.class, "SpacePod", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(KintounEntity.class, "Kintoun", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(KintounBlackEntity.class, "KintounBlack", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityHell01.class, "hell01", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityHell02.class, "hell02", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityMasterEnma.class, "enma", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityNamekian01.class, "Namekian01", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityNamekian03.class, "Namekian03", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityMasterKami.class, "kami", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityMasterKaio.class, "northkaio", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityMasterKarin.class, "karin", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityMasterRoshi.class, "roshi", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityMasterCell.class, "cellmaster", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityMasterGoku.class, "gokumaster", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityMasterFreeza.class, "Freezamaster", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityDino01.class, "EntityDino01", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityEnergyAtt.class, "EnergyAttack", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityPuipui.class, "Puipui", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityYakon.class, "Yakon", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityDarbura.class, "Darbura", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityBuuFat.class, "BuuFat", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityBuuSuper.class, "BuuSuper", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityMasterBabidi.class, "masterbabidi", this.nextEntityID(), instance, 80, 5, true);
      EntityRegistry.registerModEntity(EntityEnergyFM.class, "KiFakeMoon", this.nextEntityID(), instance, 400, 5, true);
      logger.info(this.nextEntityID() - 1 + " Entities Loaded!");
      GameRegistry.registerTileEntity(DragonBlockS01TileEntity.class, "DragonBlockS01TileEntity");
      GameRegistry.registerTileEntity(DragonBlockNS01TileEntity.class, "DragonBlockNS01TileEntity");
      GameRegistry.registerTileEntity(DragonBlockNamek01TileEntity.class, "DragonBlockNamek01TileEntity");
      GameRegistry.registerTileEntity(DragonBlock01TileEntity.class, "DragonBlock01TileEntity");
      GameRegistry.registerTileEntity(SpacePod01TileEntity.class, "SpacePod01TileEntity");
      GameRegistry.registerTileEntity(SaibaiHatchedTileEntity.class, "SaibaiHatchedTileEntity");
      GameRegistry.registerTileEntity(MedPodDoor1TileEntity.class, "MedPodDoor1TileEntity");
      GameRegistry.registerTileEntity(ArtGravDevTileEntity.class, "ArtGravDevTileEntity");
      NetworkRegistry.INSTANCE.registerGuiHandler(this, this.guiHandler);
      proxy.registerRenderThings();
   }

   @EventHandler
   public void PostLoad(FMLPostInitializationEvent var1) {
      proxy.postInit();
      logger.info("Fully Loaded!");
      logger.info("Have a good game!");
      logger.info("Fight For Your Life ^^");
   }
}
