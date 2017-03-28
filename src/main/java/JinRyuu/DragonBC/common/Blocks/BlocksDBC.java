package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.Blocks.BlockAlienCobbleStone;
import JinRyuu.DragonBC.common.Blocks.BlockAlienStone;
import JinRyuu.DragonBC.common.Blocks.BlockAnyBase;
import JinRyuu.DragonBC.common.Blocks.BlockCropMedMoss;
import JinRyuu.DragonBC.common.Blocks.BlockDBCSaplings;
import JinRyuu.DragonBC.common.Blocks.BlockHealingPods;
import JinRyuu.DragonBC.common.Blocks.BlockNamekDirt;
import JinRyuu.DragonBC.common.Blocks.BlockNamekGrass;
import JinRyuu.DragonBC.common.Blocks.BlockNamekLeaves;
import JinRyuu.DragonBC.common.Blocks.BlockNamekLog;
import JinRyuu.DragonBC.common.Blocks.BlockNamekStone;
import JinRyuu.DragonBC.common.Blocks.BlockOreDBC;
import JinRyuu.DragonBC.common.Blocks.BlockOreWrenai;
import JinRyuu.DragonBC.common.Blocks.BlockTCFloor;
import JinRyuu.DragonBC.common.Blocks.BlockTCPort;
import JinRyuu.DragonBC.common.Blocks.BlockWildMedMoss;
import JinRyuu.DragonBC.common.Blocks.BlockYellowCloud;
import JinRyuu.DragonBC.common.Blocks.ItemDBCSaplingsTex;
import JinRyuu.DragonBC.common.Render.ArtGravDevBlock;
import JinRyuu.DragonBC.common.Render.DragonBlock01Block;
import JinRyuu.DragonBC.common.Render.DragonBlockNS01Block;
import JinRyuu.DragonBC.common.Render.DragonBlockNamek01Block;
import JinRyuu.DragonBC.common.Render.DragonBlockS01Block;
import JinRyuu.DragonBC.common.Render.MedPodDoor1Block;
import JinRyuu.DragonBC.common.Render.SaibaiHatchedBlock;
import JinRyuu.DragonBC.common.Render.SpacePod01Block;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BlocksDBC {
   public static Block BlockAlienStone;
   public static Block BlockAlienCobbleStone;
   public static Block BlockNamekDragonBallStone;
   public static Block BlockNamekDragonBall;
   public static Block BlockDragonBallStone;
   public static Block BlockDragonBall;
   public static Block BlockOreWrenai;
   public static Block BlockNamekGrass;
   public static Block BlockNamekDirt;
   public static Block BlockNamekStone;
   public static Block BlockNamekLog;
   public static Block BlockNamekLeaves;
   public static Block BlockKiFire;
   public static Block AuraDyn;
   public static Block BlockHellStone;
   public static Block BlockYellowCloud;
   public static Block BlockInvisWall;
   public static Block BlockTCPort;
   public static Block BlockTCFloor;
   public static Fluid medicalLiquid = new Fluid("medicalliquid");
   public static Block BlockHealingPods;
   public static Block BlockHealingPodDoor;
   public static Block BlockCropMedMoss;
   public static Block BlockWildMedMoss;
   public static Block SpacePod01Block;
   public static Block SaibaiHatched;
   public static Block ArtGravDevBlock;
   public static BlockDBCSaplings BlockNamekSapling;
   public static Block DBCmobSpawner;
   public static String mod = "jinryuudragonbc:tile.";
   public static Block BlockOreJJay;
   public static Block BlockOreDlog;
   public static Block BlockOreLehnori;
   public static Block BlockOreDnomaid;
   public static String[] BlockOWnams = new String[]{"JJayblock", "Dlogblock", "Lehnoriblock", "Dnomaidblock"};
   public static Block[] BlockOWtyps = new Block[]{new BlockAnyBase(ToolMaterial.WOOD.getHarvestLevel()), new BlockAnyBase(ToolMaterial.STONE.getHarvestLevel()), new BlockAnyBase(ToolMaterial.STONE.getHarvestLevel()), new BlockAnyBase(ToolMaterial.IRON.getHarvestLevel())};
   public static Block[] BlockOW = new Block[BlockOWnams.length];
   public static final int BlockJJay = 0;
   public static final int BlockDlog = 1;
   public static final int BlockLehnori = 2;
   public static final int BlockDnomaid = 3;

   public BlocksDBC() {
   }

   public static void init() {
      FluidRegistry.registerFluid(medicalLiquid);
      BlockAlienStone = (new BlockAlienStone()).setBlockName("BlockAlienStone").setBlockTextureName(mod + "BlockAlienStone");
      BlockAlienCobbleStone = (new BlockAlienCobbleStone()).setBlockName("BlockAlienCobbleStone").setBlockTextureName(mod + "BlockAlienCobbleStone");
      BlockNamekDragonBallStone = (new DragonBlockNS01Block()).setBlockName("BlockNamekDragonBallStone").setBlockTextureName(mod + "BlockNamekDragonBallStone");
      BlockNamekDragonBall = (new DragonBlockNamek01Block()).setBlockName("BlockNamekDragonBall").setBlockTextureName(mod + "BlockNamekDragonBall");
      BlockDragonBallStone = (new DragonBlockS01Block()).setBlockName("BlockDragonBallStone").setBlockTextureName(mod + "BlockDragonBallStone");
      BlockDragonBall = (new DragonBlock01Block()).setBlockName("BlockDragonBall").setBlockTextureName(mod + "BlockDragonBall");
      BlockOreWrenai = (new BlockOreWrenai()).setBlockName("BlockOreWrenai").setBlockTextureName(mod + "BlockOreWrenai");
      BlockNamekGrass = (new BlockNamekGrass()).setHardness(0.6F).setStepSound(Block.soundTypeGrass).setBlockName("BlockNamekGrass").setBlockTextureName(mod + "BlockNamekGrass");
      BlockNamekDirt = (new BlockNamekDirt()).setHardness(0.5F).setStepSound(Block.soundTypeGravel).setBlockName("BlockNamekDirt").setBlockTextureName(mod + "BlockNamekDirt");
      BlockNamekStone = (new BlockNamekStone()).setHardness(1.5F).setStepSound(Block.soundTypeStone).setBlockName("BlockNamekStone").setBlockTextureName(mod + "BlockNamekStone");
      BlockNamekLog = (new BlockNamekLog()).setHardness(2.0F).setStepSound(Block.soundTypeWood).setBlockName("BlockNamekLog").setBlockTextureName(mod + "BlockNamekLog");
      BlockNamekLeaves = (new BlockNamekLeaves(52)).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("BlockNamekLeaves").setBlockTextureName(mod + "BlockNamekLeaves");
      BlockNamekSapling = (BlockDBCSaplings)(new BlockDBCSaplings()).setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("Sapling");
      BlockOreJJay = (new BlockOreDBC(ToolMaterial.WOOD.getHarvestLevel())).setBlockName("JJayore").setBlockTextureName(mod + "JJayore");
      BlockOreDlog = (new BlockOreDBC(ToolMaterial.STONE.getHarvestLevel())).setBlockName("Dlogore").setBlockTextureName(mod + "Dlogore");
      BlockOreLehnori = (new BlockOreDBC(ToolMaterial.STONE.getHarvestLevel())).setBlockName("Lehnoriore").setBlockTextureName(mod + "Lehnoriore");
      BlockOreDnomaid = (new BlockOreDBC(ToolMaterial.IRON.getHarvestLevel())).setBlockName("Dnomaidore").setBlockTextureName(mod + "Dnomaidore");

      for(int var0 = 0; var0 < BlockOW.length; ++var0) {
         BlockOW[var0] = BlockOWtyps[var0].setBlockName(BlockOWnams[var0]).setBlockTextureName(mod + BlockOWnams[var0]);
      }

      BlockYellowCloud = (new BlockYellowCloud()).setHardness(5.0F).setStepSound(Block.soundTypeGrass).setBlockName("BlockYellowCloud").setBlockTextureName(mod + "BlockYellowCloud");
      BlockTCPort = (new BlockTCPort()).setBlockName("BlockTCPort").setBlockTextureName(mod + "BlockTCPort");
      BlockTCFloor = (new BlockTCFloor()).setHardness(50.0F).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setBlockName("BlockTCFloor").setBlockTextureName(mod + "BlockTCFloor");
      BlockHealingPods = (new BlockHealingPods(medicalLiquid, Material.water)).setBlockName("BlockHealingPods");
      BlockHealingPodDoor = (new MedPodDoor1Block()).setHardness(50.0F).setResistance(2000.0F).setBlockName("BlockHealingPodDoor");
      BlockCropMedMoss = (new BlockCropMedMoss()).setBlockName("BlockCropMedMoss");
      BlockWildMedMoss = (new BlockWildMedMoss()).setBlockName("BlockWildMedMoss");
      SpacePod01Block = (new SpacePod01Block()).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("SpacePod01Block").setBlockTextureName(mod + "SpacePod01Block");
      SaibaiHatched = (new SaibaiHatchedBlock()).setHardness(0.2F).setLightOpacity(5).setStepSound(Block.soundTypeGrass).setBlockName("SaibaiHatched").setBlockTextureName(mod + "SaibaiHatched");
      ArtGravDevBlock = (new ArtGravDevBlock()).setHardness(0.2F).setLightOpacity(5).setStepSound(Block.soundTypeMetal).setBlockName("ArtGravDevBlock").setBlockTextureName(mod + "ArtGravDevBlock");
   }

   public static void register() {
      GameRegistry.registerBlock(BlockTCPort, BlockTCPort.getUnlocalizedName());
      GameRegistry.registerBlock(BlockTCFloor, BlockTCFloor.getUnlocalizedName());
      GameRegistry.registerBlock(BlockYellowCloud, BlockYellowCloud.getUnlocalizedName());
      GameRegistry.registerBlock(BlockAlienStone, BlockAlienStone.getUnlocalizedName());
      GameRegistry.registerBlock(BlockAlienCobbleStone, BlockAlienCobbleStone.getUnlocalizedName());
      GameRegistry.registerBlock(BlockNamekDragonBallStone, BlockNamekDragonBallStone.getUnlocalizedName());
      GameRegistry.registerBlock(BlockNamekDragonBall, BlockNamekDragonBall.getUnlocalizedName());
      GameRegistry.registerBlock(BlockDragonBallStone, BlockDragonBallStone.getUnlocalizedName());
      GameRegistry.registerBlock(BlockDragonBall, BlockDragonBall.getUnlocalizedName());
      GameRegistry.registerBlock(BlockOreWrenai, BlockOreWrenai.getUnlocalizedName());
      GameRegistry.registerBlock(BlockNamekGrass, BlockNamekGrass.getUnlocalizedName());
      GameRegistry.registerBlock(BlockNamekLog, BlockNamekLog.getUnlocalizedName());
      GameRegistry.registerBlock(BlockNamekDirt, BlockNamekDirt.getUnlocalizedName());
      GameRegistry.registerBlock(BlockNamekStone, BlockNamekStone.getUnlocalizedName());
      GameRegistry.registerBlock(BlockNamekLeaves, BlockNamekLeaves.getUnlocalizedName());
      GameRegistry.registerBlock(BlockNamekSapling, ItemDBCSaplingsTex.class, BlockNamekSapling.getUnlocalizedName());
      GameRegistry.registerBlock(BlockOreJJay, BlockOreJJay.getUnlocalizedName());
      GameRegistry.registerBlock(BlockOreDlog, BlockOreDlog.getUnlocalizedName());
      GameRegistry.registerBlock(BlockOreLehnori, BlockOreLehnori.getUnlocalizedName());
      GameRegistry.registerBlock(BlockOreDnomaid, BlockOreDnomaid.getUnlocalizedName());

      for(int var0 = 0; var0 < BlockOW.length; ++var0) {
         GameRegistry.registerBlock(BlockOW[var0], BlockOW[var0].getUnlocalizedName());
      }

      GameRegistry.registerBlock(BlockHealingPods, BlockHealingPods.getUnlocalizedName());
      GameRegistry.registerBlock(BlockHealingPodDoor, BlockHealingPodDoor.getUnlocalizedName());
      GameRegistry.registerBlock(SpacePod01Block, SpacePod01Block.getUnlocalizedName());
      GameRegistry.registerBlock(SaibaiHatched, SaibaiHatched.getUnlocalizedName());
      GameRegistry.registerBlock(ArtGravDevBlock, ArtGravDevBlock.getUnlocalizedName());
      GameRegistry.registerBlock(BlockCropMedMoss, BlockCropMedMoss.getUnlocalizedName());
      GameRegistry.registerBlock(BlockWildMedMoss, BlockWildMedMoss.getUnlocalizedName());
   }
}
