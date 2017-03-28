package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.DBC;
import JinRyuu.DragonBC.common.DBCClientTickHandler;
import JinRyuu.DragonBC.common.DBCKeyHandler;
import JinRyuu.DragonBC.common.Entitys.EntityEnergyFM;
import JinRyuu.DragonBC.common.Entitys.RenderEnergyFM;
import JinRyuu.DragonBC.common.Gui.DBCKiGui;
import JinRyuu.DragonBC.common.Gui.DBCSAAGui;
import JinRyuu.DragonBC.common.Gui.DBCSagaGui;
import JinRyuu.DragonBC.common.Gui.DBCWishGui;
import JinRyuu.DragonBC.common.Gui.ScouterGui;
import JinRyuu.DragonBC.common.Items.GiTurtleMdl;
import JinRyuu.DragonBC.common.Items.ItemDBCRender;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Npcs.EntityAura;
import JinRyuu.DragonBC.common.Npcs.EntityAuraLightning;
import JinRyuu.DragonBC.common.Npcs.EntityAuraPur;
import JinRyuu.DragonBC.common.Npcs.EntityAuraRed;
import JinRyuu.DragonBC.common.Npcs.EntityAuraRing;
import JinRyuu.DragonBC.common.Npcs.EntityAuraRingPur;
import JinRyuu.DragonBC.common.Npcs.EntityAuraRingRed;
import JinRyuu.DragonBC.common.Npcs.EntityAuraRingSup;
import JinRyuu.DragonBC.common.Npcs.EntityAuraSup;
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
import JinRyuu.DragonBC.common.Npcs.ModelBabidi;
import JinRyuu.DragonBC.common.Npcs.ModelBuuFat;
import JinRyuu.DragonBC.common.Npcs.ModelBuuSuper;
import JinRyuu.DragonBC.common.Npcs.ModelDBCZed;
import JinRyuu.DragonBC.common.Npcs.ModelDino01;
import JinRyuu.DragonBC.common.Npcs.ModelDragon;
import JinRyuu.DragonBC.common.Npcs.ModelFr4;
import JinRyuu.DragonBC.common.Npcs.ModelFr6;
import JinRyuu.DragonBC.common.Npcs.ModelKarin;
import JinRyuu.DragonBC.common.Npcs.ModelNPCNormal;
import JinRyuu.DragonBC.common.Npcs.ModelRaditz;
import JinRyuu.DragonBC.common.Npcs.ModelRoshi;
import JinRyuu.DragonBC.common.Npcs.ModelSaibaiman;
import JinRyuu.DragonBC.common.Npcs.ModelVegeta;
import JinRyuu.DragonBC.common.Npcs.ModelYakon;
import JinRyuu.DragonBC.common.Npcs.RenderAura;
import JinRyuu.DragonBC.common.Npcs.RenderAuraLightning;
import JinRyuu.DragonBC.common.Npcs.RenderAuraPur;
import JinRyuu.DragonBC.common.Npcs.RenderAuraRed;
import JinRyuu.DragonBC.common.Npcs.RenderAuraRing;
import JinRyuu.DragonBC.common.Npcs.RenderAuraRingPur;
import JinRyuu.DragonBC.common.Npcs.RenderAuraRingRed;
import JinRyuu.DragonBC.common.Npcs.RenderAuraRingSup;
import JinRyuu.DragonBC.common.Npcs.RenderAuraSup;
import JinRyuu.DragonBC.common.Npcs.RenderDBC;
import JinRyuu.DragonBC.common.Npcs.RenderPorunga;
import JinRyuu.DragonBC.common.Npcs.RenderPorunga2;
import JinRyuu.DragonBC.common.Render.ArtGravDevRender;
import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
import JinRyuu.DragonBC.common.Render.DragonBlock01Render;
import JinRyuu.DragonBC.common.Render.DragonBlock01TileEntity;
import JinRyuu.DragonBC.common.Render.DragonBlockNS01Render;
import JinRyuu.DragonBC.common.Render.DragonBlockNS01TileEntity;
import JinRyuu.DragonBC.common.Render.DragonBlockNamek01Render;
import JinRyuu.DragonBC.common.Render.DragonBlockNamek01TileEntity;
import JinRyuu.DragonBC.common.Render.DragonBlockS01Render;
import JinRyuu.DragonBC.common.Render.DragonBlockS01TileEntity;
import JinRyuu.DragonBC.common.Render.KintounBlackEntity;
import JinRyuu.DragonBC.common.Render.KintounEntity;
import JinRyuu.DragonBC.common.Render.KintounRender;
import JinRyuu.DragonBC.common.Render.MedPodDoor1Render;
import JinRyuu.DragonBC.common.Render.MedPodDoor1TileEntity;
import JinRyuu.DragonBC.common.Render.SaibaiHatchedRender;
import JinRyuu.DragonBC.common.Render.SaibaiHatchedTileEntity;
import JinRyuu.DragonBC.common.Render.SpacePod01Entity;
import JinRyuu.DragonBC.common.Render.SpacePod01Render;
import JinRyuu.DragonBC.common.Render.SpacePod01RenderPod;
import JinRyuu.DragonBC.common.Render.SpacePod01TileEntity;
import JinRyuu.DragonBC.common.p.DBCPacketHandlerClient;
import JinRyuu.JRMCore.entity.EntityEnergyAtt;
import JinRyuu.JRMCore.entity.RenderEnergyAtt;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;

@SideOnly(Side.CLIENT)
public class DBCClient extends DBC {
   public static ScouterGui scouterGui;
   public static DBCSagaGui SagaSys;
   public static DBCKiGui KiGui;
   public static DBCWishGui WishGui;
   public static DBCSAAGui SAAGui;
   public static Minecraft mc = Minecraft.getMinecraft();
   @SideOnly(Side.CLIENT)
   public static final ModelBiped armor1 = new GiTurtleMdl(0.205F);
   @SideOnly(Side.CLIENT)
   public static final ModelBiped armor2 = new GiTurtleMdl(0.11F);
   public static DBCPacketHandlerClient phc = new DBCPacketHandlerClient();

   public DBCClient() {
   }

   public void initialize() {
      super.initialize();
      FMLCommonHandler.instance().bus().register(new DBCClientTickHandler());
   }

   public void postInit() {
      super.postInit();
   }

   public void registerRenderThings() {
      scouterGui = new ScouterGui();
      SagaSys = new DBCSagaGui();
      KiGui = new DBCKiGui(0);
      WishGui = new DBCWishGui(0);
      SAAGui = new DBCSAAGui(2);
      MinecraftForgeClient.registerItemRenderer(ItemsDBC.ItemKatana, new ItemDBCRender("K"));
      MinecraftForgeClient.registerItemRenderer(ItemsDBC.ItemBraveSword, new ItemDBCRender("S"));
      MinecraftForgeClient.registerItemRenderer(ItemsDBC.ItemZSword, new ItemDBCRender("Z"));
      RenderingRegistry.registerEntityRenderingHandler(EntityEnergyAtt.class, new RenderEnergyAtt());
      RenderingRegistry.registerEntityRenderingHandler(EntityEnergyFM.class, new RenderEnergyFM());
      RenderingRegistry.registerEntityRenderingHandler(SpacePod01Entity.class, new SpacePod01RenderPod());
      RenderingRegistry.registerEntityRenderingHandler(KintounEntity.class, new KintounRender());
      RenderingRegistry.registerEntityRenderingHandler(KintounBlackEntity.class, new KintounRender());
      RenderingRegistry.registerEntityRenderingHandler(EntityAuraRed.class, new RenderAuraRed());
      RenderingRegistry.registerEntityRenderingHandler(EntityAuraSup.class, new RenderAuraSup());
      RenderingRegistry.registerEntityRenderingHandler(EntityAuraPur.class, new RenderAuraPur());
      RenderingRegistry.registerEntityRenderingHandler(EntityPorunga.class, new RenderPorunga());
      RenderingRegistry.registerEntityRenderingHandler(EntityPorunga2.class, new RenderPorunga2());
      RenderingRegistry.registerEntityRenderingHandler(EntityDragon2.class, new RenderDBC(new ModelDragon(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityDragon.class, new RenderDBC(new ModelDragon(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityAura.class, new RenderAura());
      RenderingRegistry.registerEntityRenderingHandler(EntityAuraRing.class, new RenderAuraRing());
      RenderingRegistry.registerEntityRenderingHandler(EntityAuraRingSup.class, new RenderAuraRingSup());
      RenderingRegistry.registerEntityRenderingHandler(EntityAuraRingPur.class, new RenderAuraRingPur());
      RenderingRegistry.registerEntityRenderingHandler(EntityAuraRingRed.class, new RenderAuraRingRed());
      RenderingRegistry.registerEntityRenderingHandler(EntityAuraLightning.class, new RenderAuraLightning());
      RenderingRegistry.registerEntityRenderingHandler(EntityHell01.class, new RenderDBC(new ModelNPCNormal(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityHell02.class, new RenderDBC(new ModelNPCNormal(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityMasterEnma.class, new RenderDBC(new ModelRaditz(2.0F), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityMasterKami.class, new RenderDBC(new ModelNPCNormal(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityMasterKaio.class, new RenderDBC(new ModelNPCNormal(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityMasterKarin.class, new RenderDBC(new ModelKarin(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityMasterRoshi.class, new RenderDBC(new ModelRoshi(1.0F), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityMasterCell.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityMasterGoku.class, new RenderDBC(new ModelDBCZed(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityMasterFreeza.class, new RenderDBC(new ModelFr4(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityNamekian01.class, new RenderDBC(new ModelNPCNormal(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityNamekian03.class, new RenderDBC(new ModelNPCNormal(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntitySaiyan01.class, new RenderDBC(new ModelNPCNormal(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntitySaiyan02.class, new RenderDBC(new ModelNPCNormal(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntitySaibaiman.class, new RenderDBC(new ModelSaibaiman(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntitySaiyanRaditz.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntitySaiyanNappa.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntitySaiyanVegeta.class, new RenderDBC(new ModelVegeta(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityDino01.class, new RenderDBC(new ModelDino01(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityKiwi.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityDodoria.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityZarbon.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityGuldo.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityRecoome.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityBarta.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityJeice.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityGinyu.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityFreezaSoldier1.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityFreezaSoldier2.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityFreezaSoldier3.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityFreeza1.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityFreeza2.class, new RenderDBC(new ModelRaditz(1.25F), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityFreeza3.class, new RenderDBC(new ModelRaditz(1.25F), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityFreeza4.class, new RenderDBC(new ModelFr4(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityFreeza5.class, new RenderDBC(new ModelFr4(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityFreeza6.class, new RenderDBC(new ModelFr6(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityPuipui.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityYakon.class, new RenderDBC(new ModelYakon(2.0F), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityDarbura.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityBuuFat.class, new RenderDBC(new ModelBuuFat(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityBuuSuper.class, new RenderDBC(new ModelBuuSuper(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityMasterBabidi.class, new RenderDBC(new ModelBabidi(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityFreezaFather.class, new RenderDBC(new ModelRaditz(2.0F), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityFreezaMecha.class, new RenderDBC(new ModelFr4(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityCyborg16.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityCyborg17.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityCyborg18.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityCyborg19.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityCyborg20.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityCell1.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityCell2.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityCell3.class, new RenderDBC(new ModelRaditz(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(EntityCell4.class, new RenderDBC(new ModelRaditz(), 0.5F));
      ClientRegistry.registerTileEntity(DragonBlockNS01TileEntity.class, "DragonBlockNS01TileEntityRender", new DragonBlockNS01Render());
      ClientRegistry.registerTileEntity(DragonBlockS01TileEntity.class, "DragonBlockS01TileEntityRender", new DragonBlockS01Render());
      ClientRegistry.registerTileEntity(DragonBlockNamek01TileEntity.class, "DragonBlockNamek01TileEntityRender", new DragonBlockNamek01Render());
      ClientRegistry.registerTileEntity(DragonBlock01TileEntity.class, "DragonBlock01TileEntityRender", new DragonBlock01Render());
      ClientRegistry.registerTileEntity(SpacePod01TileEntity.class, "SpacePod01TileEntityRender", new SpacePod01Render());
      ClientRegistry.registerTileEntity(SaibaiHatchedTileEntity.class, "SaibaiHatchedEntityRender", new SaibaiHatchedRender());
      ClientRegistry.registerTileEntity(MedPodDoor1TileEntity.class, "MedPodDoor1EntityRender", new MedPodDoor1Render());
      ClientRegistry.registerTileEntity(ArtGravDevTileEntity.class, "ArtGravDevRender", new ArtGravDevRender());
   }

   public void registerKeys() {
      ClientRegistry.registerKeyBinding(DBCKeyHandler.ScFunc);
   }

   public void registerTicks() {
   }

   public File getMinecraftDir() {
      return Minecraft.getMinecraft().mcDataDir;
   }
}
