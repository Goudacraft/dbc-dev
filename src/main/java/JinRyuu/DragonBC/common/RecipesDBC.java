package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Items.ItemBodyDBC;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.JRMCore.JRMCoreH2;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RecipesDBC {
   public RecipesDBC() {
   }

   public static void init() {
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemKatana, 1), new Object[]{"L", "X", Character.valueOf('X'), ItemsDBC.ItemKatanaHandle, Character.valueOf('L'), ItemsDBC.ItemKatanaSwordBlade});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemBraveSword, 1), new Object[]{"L", "X", Character.valueOf('X'), ItemsDBC.ItemBraveSwordHandle, Character.valueOf('L'), ItemsDBC.ItemBraveSwordBlade});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemZSword, 1), new Object[]{"L", "X", Character.valueOf('X'), ItemsDBC.ItemZSwordHandle, Character.valueOf('L'), ItemsDBC.ItemZSwordBlade});
      short var0 = 32767;
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemKatana, 1), new Object[]{new ItemStack(ItemsDBC.ItemKatana, 1, var0), new ItemStack(Items.iron_ingot, 1, 0)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemBraveSword, 1), new Object[]{new ItemStack(ItemsDBC.ItemBraveSword, 1, var0), new ItemStack(ItemsDBC.ItemKatchin, 1, 0), new ItemStack(Items.iron_ingot, 1, 0)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemZSword, 1), new Object[]{new ItemStack(ItemsDBC.ItemZSword, 1, var0), new ItemStack(ItemsDBC.ItemKatchin, 1, 0), new ItemStack(ItemsDBC.ItemKatchin, 1, 0)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemKatanaHandle, 1), new Object[]{"LXL", Character.valueOf('X'), Items.iron_ingot, Character.valueOf('L'), Items.leather});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemBraveSwordHandle, 1), new Object[]{"X X", "LKL", Character.valueOf('X'), Items.iron_ingot, Character.valueOf('L'), Items.leather, Character.valueOf('K'), ItemsDBC.ItemKatchin});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemZSwordHandle, 1), new Object[]{"G G", "LKL", Character.valueOf('K'), ItemsDBC.ItemKatchin, Character.valueOf('L'), Items.leather, Character.valueOf('G'), Items.gold_ingot});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemKatanaSwordBlade, 1), new Object[]{"XXX", "XXX", " X ", Character.valueOf('X'), Items.iron_ingot});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemBraveSwordBlade, 1), new Object[]{"XKX", Character.valueOf('X'), ItemsDBC.ItemKatanaSwordBlade, Character.valueOf('K'), ItemsDBC.ItemKatchin});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemZSwordBlade, 1), new Object[]{" K ", "XKX", " K ", Character.valueOf('X'), ItemsDBC.ItemBraveSwordBlade, Character.valueOf('K'), ItemsDBC.ItemKatchin});
      Item[] var1 = new Item[]{ItemsDBC.BattleArmorHelmet00, ItemsDBC.BattleArmorHelmet01, ItemsDBC.BattleArmorHelmet02, ItemsDBC.BattleArmorHelmet03, ItemsDBC.BattleArmorHelmet04, ItemsDBC.BattleArmorHelmet05, ItemsDBC.BattleArmorHelmet00a, ItemsDBC.BattleArmorHelmet01a, ItemsDBC.BattleArmorHelmet02a, ItemsDBC.BattleArmorHelmet03a, ItemsDBC.BattleArmorHelmet04a, ItemsDBC.BattleArmorHelmet05a, ItemsDBC.BattleArmorHelmet00b, ItemsDBC.BattleArmorHelmet01b, ItemsDBC.BattleArmorHelmet02b, ItemsDBC.BattleArmorHelmet03b, ItemsDBC.BattleArmorHelmet04b, ItemsDBC.BattleArmorHelmet05b};
      Item[] var2 = new Item[]{ItemsDBC.BattleArmorChest00, ItemsDBC.BattleArmorChest01, ItemsDBC.BattleArmorChest02, ItemsDBC.BattleArmorChest03, ItemsDBC.BattleArmorChest04, ItemsDBC.BattleArmorChest05, ItemsDBC.BattleArmorLegs00, ItemsDBC.BattleArmorLegs01, ItemsDBC.BattleArmorLegs02, ItemsDBC.BattleArmorLegs03, ItemsDBC.BattleArmorLegs04, ItemsDBC.BattleArmorLegs05, ItemsDBC.BattleArmorBoots00, ItemsDBC.BattleArmorBoots01, ItemsDBC.BattleArmorBoots02, ItemsDBC.BattleArmorBoots03, ItemsDBC.BattleArmorBoots04, ItemsDBC.BattleArmorBoots05};

      for(Item var6 : var1) {
         GameRegistry.addShapelessRecipe(new ItemStack(var6, 1), new Object[]{new ItemStack(var6, 1, var0), new ItemStack(ItemsDBC.ItemWarenai, 1, 0)});
      }

      for(Item var17 : var2) {
         GameRegistry.addShapelessRecipe(new ItemStack(var17, 1), new Object[]{new ItemStack(var17, 1, var0), new ItemStack(ItemsDBC.ItemWarenai, 1, 0), new ItemStack(ItemsDBC.ItemWarenai, 1, 0)});
      }

      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet00, 1), new Object[]{"YC", "GX", Character.valueOf('X'), ItemsDBC.ItemWarenai, Character.valueOf('G'), Blocks.glass, Character.valueOf('Y'), new ItemStack(Items.dye, 1, 11), Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet01, 1), new Object[]{"RC", "GX", Character.valueOf('X'), ItemsDBC.ItemWarenai, Character.valueOf('G'), Blocks.glass, Character.valueOf('R'), new ItemStack(Items.dye, 1, 1), Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet02, 1), new Object[]{"PC", "GX", Character.valueOf('X'), ItemsDBC.ItemWarenai, Character.valueOf('G'), Blocks.glass, Character.valueOf('P'), new ItemStack(Items.dye, 1, 5), Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet03, 1), new Object[]{"BC", "GX", Character.valueOf('X'), ItemsDBC.ItemWarenai, Character.valueOf('G'), Blocks.glass, Character.valueOf('B'), new ItemStack(Items.dye, 1, 4), Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet04, 1), new Object[]{"gC", "GX", Character.valueOf('X'), ItemsDBC.ItemWarenai, Character.valueOf('G'), Blocks.glass, Character.valueOf('g'), new ItemStack(Items.dye, 1, 2), Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet05, 1), new Object[]{"PC", "GX", Character.valueOf('X'), ItemsDBC.ItemWarenai, Character.valueOf('G'), Blocks.glass, Character.valueOf('P'), new ItemStack(Items.dye, 1, 9), Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest00, 1), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), ItemsDBC.ItemWarenai});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest01, 1), new Object[]{"D D", "BXB", "BDB", Character.valueOf('X'), ItemsDBC.BattleArmorChest00, Character.valueOf('B'), new ItemStack(Items.dye, 1, 0), Character.valueOf('D'), new ItemStack(Items.dye, 1, 12)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest02, 1), new Object[]{"D D", "BXB", "BDB", Character.valueOf('X'), ItemsDBC.BattleArmorChest00, Character.valueOf('B'), new ItemStack(Items.dye, 1, 0), Character.valueOf('D'), new ItemStack(Items.dye, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest03, 1), new Object[]{"D D", " X ", " D ", Character.valueOf('X'), ItemsDBC.BattleArmorChest00, Character.valueOf('D'), new ItemStack(Items.dye, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest04, 1), new Object[]{" D ", "BXB", "BDB", Character.valueOf('X'), ItemsDBC.BattleArmorChest00, Character.valueOf('B'), new ItemStack(Items.dye, 1, 0), Character.valueOf('D'), new ItemStack(Items.dye, 1, 2)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorChest05, 1), new Object[]{" D ", " X ", " D ", Character.valueOf('X'), ItemsDBC.BattleArmorChest00, Character.valueOf('D'), new ItemStack(Items.dye, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs00, 1), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), ItemsDBC.ItemWarenai});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs01, 1), new Object[]{"D D", "BXB", "B B", Character.valueOf('X'), ItemsDBC.BattleArmorLegs00, Character.valueOf('B'), new ItemStack(Items.dye, 1, 0), Character.valueOf('D'), new ItemStack(Items.dye, 1, 12)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs02, 1), new Object[]{"D D", "BXB", "   ", Character.valueOf('X'), ItemsDBC.BattleArmorLegs00, Character.valueOf('B'), new ItemStack(Items.dye, 1, 0), Character.valueOf('D'), new ItemStack(Items.dye, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs03, 1), new Object[]{" D ", "BXB", "   ", Character.valueOf('X'), ItemsDBC.BattleArmorLegs00, Character.valueOf('B'), new ItemStack(Items.dye, 1, 0), Character.valueOf('D'), new ItemStack(Items.dye, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs04, 1), new Object[]{"D D", "BXB", "B B", Character.valueOf('X'), ItemsDBC.BattleArmorLegs00, Character.valueOf('B'), new ItemStack(Items.dye, 1, 0), Character.valueOf('D'), new ItemStack(Items.dye, 1, 2)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorLegs05, 1), new Object[]{"D D", "BXB", "B B", Character.valueOf('X'), ItemsDBC.BattleArmorLegs00, Character.valueOf('B'), new ItemStack(Items.dye, 1, 4), Character.valueOf('D'), new ItemStack(Items.dye, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots00, 1), new Object[]{"X X", "X X", Character.valueOf('X'), ItemsDBC.ItemWarenai});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots01, 1), new Object[]{"DXD", "B B", "   ", Character.valueOf('X'), ItemsDBC.BattleArmorBoots00, Character.valueOf('B'), new ItemStack(Items.dye, 1, 12), Character.valueOf('D'), new ItemStack(Items.dye, 1, 0)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots02, 1), new Object[]{"DXD", "B B", "   ", Character.valueOf('X'), ItemsDBC.BattleArmorBoots00, Character.valueOf('B'), new ItemStack(Items.dye, 1, 3), Character.valueOf('D'), new ItemStack(Items.dye, 1, 0)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots03, 1), new Object[]{" X ", "B B", "   ", Character.valueOf('X'), ItemsDBC.BattleArmorBoots00, Character.valueOf('B'), new ItemStack(Items.dye, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots04, 1), new Object[]{"DXD", "B B", "   ", Character.valueOf('X'), ItemsDBC.BattleArmorBoots00, Character.valueOf('B'), new ItemStack(Items.dye, 1, 2), Character.valueOf('D'), new ItemStack(Items.dye, 1, 1)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorBoots05, 1), new Object[]{"DXD", "D D", "   ", Character.valueOf('X'), ItemsDBC.BattleArmorBoots00, Character.valueOf('D'), new ItemStack(Items.dye, 1, 15)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet00a, 1), new Object[]{" C ", "CXC", " C ", Character.valueOf('X'), ItemsDBC.BattleArmorHelmet00, Character.valueOf('C'), ItemsDBC.ItemChipTier2});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet01a, 1), new Object[]{" C ", "CXC", " C ", Character.valueOf('X'), ItemsDBC.BattleArmorHelmet01, Character.valueOf('C'), ItemsDBC.ItemChipTier2});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet02a, 1), new Object[]{" C ", "CXC", " C ", Character.valueOf('X'), ItemsDBC.BattleArmorHelmet02, Character.valueOf('C'), ItemsDBC.ItemChipTier2});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet03a, 1), new Object[]{" C ", "CXC", " C ", Character.valueOf('X'), ItemsDBC.BattleArmorHelmet03, Character.valueOf('C'), ItemsDBC.ItemChipTier2});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet04a, 1), new Object[]{" C ", "CXC", " C ", Character.valueOf('X'), ItemsDBC.BattleArmorHelmet04, Character.valueOf('C'), ItemsDBC.ItemChipTier2});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet05a, 1), new Object[]{" C ", "CXC", " C ", Character.valueOf('X'), ItemsDBC.BattleArmorHelmet05, Character.valueOf('C'), ItemsDBC.ItemChipTier2});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet00b, 1), new Object[]{" C ", "CXC", " C ", Character.valueOf('X'), ItemsDBC.BattleArmorHelmet00a, Character.valueOf('C'), ItemsDBC.ItemChipTier3});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet01b, 1), new Object[]{" C ", "CXC", " C ", Character.valueOf('X'), ItemsDBC.BattleArmorHelmet01a, Character.valueOf('C'), ItemsDBC.ItemChipTier3});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet02b, 1), new Object[]{" C ", "CXC", " C ", Character.valueOf('X'), ItemsDBC.BattleArmorHelmet02a, Character.valueOf('C'), ItemsDBC.ItemChipTier3});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet03b, 1), new Object[]{" C ", "CXC", " C ", Character.valueOf('X'), ItemsDBC.BattleArmorHelmet03a, Character.valueOf('C'), ItemsDBC.ItemChipTier3});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet04b, 1), new Object[]{" C ", "CXC", " C ", Character.valueOf('X'), ItemsDBC.BattleArmorHelmet04a, Character.valueOf('C'), ItemsDBC.ItemChipTier3});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.BattleArmorHelmet05b, 1), new Object[]{" C ", "CXC", " C ", Character.valueOf('X'), ItemsDBC.BattleArmorHelmet05a, Character.valueOf('C'), ItemsDBC.ItemChipTier3});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter3Torso, 1), new Object[]{"R R", "RBR", "BRB", Character.valueOf('R'), new ItemStack(Blocks.wool, 1, 14), Character.valueOf('B'), new ItemStack(Blocks.wool, 1, 11)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.KameTorso1, 1), new Object[]{"R R", "R R", "RRR", Character.valueOf('R'), new ItemStack(Blocks.wool, 1, 14)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.KameBoots1, 1), new Object[]{"B B", "Y Y", Character.valueOf('Y'), new ItemStack(Blocks.wool, 1, 15), Character.valueOf('B'), new ItemStack(Blocks.wool, 1, 0)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter3Torso, 1), new Object[]{new ItemStack(ItemsDBC.GiFighter3Torso, 1, var0), new ItemStack(Blocks.wool, 1, 14), new ItemStack(Blocks.wool, 1, 11)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.KameTorso1, 1), new Object[]{new ItemStack(ItemsDBC.KameTorso1, 1, var0), new ItemStack(Blocks.wool, 1, 14), new ItemStack(Blocks.wool, 1, 14)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.KameBoots1, 1), new Object[]{new ItemStack(ItemsDBC.KameBoots1, 1, var0), new ItemStack(Blocks.wool, 1, 0)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter1Torso, 1), new Object[]{"R R", "RBR", "RRR", Character.valueOf('R'), new ItemStack(Blocks.wool, 1, 14), Character.valueOf('B'), new ItemStack(Blocks.wool, 1, 11)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter1Leg, 1), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), new ItemStack(Blocks.wool, 1, 14)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter1Boots, 1), new Object[]{"B B", "Y Y", Character.valueOf('Y'), new ItemStack(Blocks.wool, 1, 4), Character.valueOf('B'), new ItemStack(Blocks.wool, 1, 11)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter1Torso, 1), new Object[]{new ItemStack(ItemsDBC.GiFighter1Torso, 1, var0), new ItemStack(Blocks.wool, 1, 14), new ItemStack(Blocks.wool, 1, 11)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter1Leg, 1), new Object[]{new ItemStack(ItemsDBC.GiFighter1Leg, 1, var0), new ItemStack(Blocks.wool, 1, 14), new ItemStack(Blocks.wool, 1, 14)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter1Boots, 1), new Object[]{new ItemStack(ItemsDBC.GiFighter1Boots, 1, var0), new ItemStack(Blocks.wool, 1, 4)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiNamekTorso, 1), new Object[]{"B B", "BBB", "BBB", Character.valueOf('B'), new ItemStack(Blocks.wool, 1, 11)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiNamekLeg, 1), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), new ItemStack(Blocks.wool, 1, 11)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiNamekBoots, 1), new Object[]{"B B", "B B", Character.valueOf('B'), new ItemStack(Blocks.wool, 1, 12)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiNamekTorso, 1), new Object[]{new ItemStack(ItemsDBC.GiNamekTorso, 1, var0), new ItemStack(Blocks.wool, 1, 11), new ItemStack(Blocks.wool, 1, 11)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiNamekLeg, 1), new Object[]{new ItemStack(ItemsDBC.GiNamekLeg, 1, var0), new ItemStack(Blocks.wool, 1, 11), new ItemStack(Blocks.wool, 1, 11)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiNamekBoots, 1), new Object[]{new ItemStack(ItemsDBC.GiNamekBoots, 1, var0), new ItemStack(Blocks.wool, 1, 12)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFutureTorso, 1), new Object[]{"B B", "BBB", Character.valueOf('B'), new ItemStack(Blocks.wool, 1, 11)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFutureLeg, 1), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), new ItemStack(Blocks.wool, 1, 7)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFutureBoots, 1), new Object[]{"B B", "B B", Character.valueOf('B'), new ItemStack(Blocks.wool, 1, 4)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFutureTorso, 1), new Object[]{new ItemStack(ItemsDBC.GiFutureTorso, 1, var0), new ItemStack(Blocks.wool, 1, 11), new ItemStack(Blocks.wool, 1, 11)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFutureLeg, 1), new Object[]{new ItemStack(ItemsDBC.GiFutureLeg, 1, var0), new ItemStack(Blocks.wool, 1, 7), new ItemStack(Blocks.wool, 1, 7)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFutureBoots, 1), new Object[]{new ItemStack(ItemsDBC.GiFutureBoots, 1, var0), new ItemStack(Blocks.wool, 1, 4)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter2Torso, 1), new Object[]{"B B", "BRB", "BBB", Character.valueOf('R'), new ItemStack(Blocks.wool, 1, 14), Character.valueOf('B'), new ItemStack(Blocks.wool, 1, 11)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter2Leg, 1), new Object[]{"BBB", "X X", "X X", Character.valueOf('X'), new ItemStack(Blocks.wool, 1, 11), Character.valueOf('B'), new ItemStack(Blocks.wool, 1, 3)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.GiFighter2Boots, 1), new Object[]{"Y Y", "Y Y", Character.valueOf('Y'), new ItemStack(Blocks.wool, 1, 0)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter2Torso, 1), new Object[]{new ItemStack(ItemsDBC.GiFighter2Torso, 1, var0), new ItemStack(Blocks.wool, 1, 11), new ItemStack(Blocks.wool, 1, 11)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter2Leg, 1), new Object[]{new ItemStack(ItemsDBC.GiFighter2Leg, 1, var0), new ItemStack(Blocks.wool, 1, 14), new ItemStack(Blocks.wool, 1, 3)});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.GiFighter2Boots, 1), new Object[]{new ItemStack(ItemsDBC.GiFighter2Boots, 1, var0), new ItemStack(Blocks.wool, 1, 0)});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.SpacePod01Item, 1), new Object[]{"WWW", "WCW", "WWW", Character.valueOf('C'), ItemsDBC.ItemChipTier2, Character.valueOf('W'), ItemsDBC.ItemWarenai});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemAlienTechChipTier1, 3), new Object[]{"GIR", "CCC", "WWW", Character.valueOf('C'), new ItemStack(Items.dye, 1, 2), Character.valueOf('G'), Items.gold_ingot, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('R'), Items.redstone, Character.valueOf('W'), ItemsDBC.ItemWarenai});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemChipTier2, 1), new Object[]{"BGB", "CCC", "GBG", Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1, Character.valueOf('B'), new ItemStack(Items.dye, 1, 4), Character.valueOf('G'), Items.glowstone_dust});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemChipTier3, 1), new Object[]{"BDB", "CcC", "DBD", Character.valueOf('C'), ItemsDBC.ItemChipTier2, Character.valueOf('c'), ItemsDBC.ItemAlienTechChipTier1, Character.valueOf('B'), new ItemStack(Items.dye, 1, 4), Character.valueOf('D'), Items.diamond});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.ArtGravDevBlock, 1), new Object[]{"IKI", "CCC", "KIK", Character.valueOf('C'), ItemsDBC.ItemChipTier3, Character.valueOf('I'), Items.iron_ingot, Character.valueOf('K'), ItemsDBC.ItemKatchin});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemBucketMedLiq, 1), new Object[]{"CCC", "CBC", "CCC", Character.valueOf('C'), ItemsDBC.ItemMedMoss, Character.valueOf('B'), Items.bucket});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemDragonRadar, 1), new Object[]{"ICI", "CWC", "ICI", Character.valueOf('I'), Items.iron_ingot, Character.valueOf('W'), ItemsDBC.ItemWarenai, Character.valueOf('C'), ItemsDBC.ItemAlienTechChipTier1});
      GameRegistry.addRecipe(new ItemStack(Blocks.planks, 2), new Object[]{"X", Character.valueOf('X'), BlocksDBC.BlockNamekLog});
      GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone, 1), new Object[]{"X", Character.valueOf('X'), BlocksDBC.BlockAlienCobbleStone});
      GameRegistry.addRecipe(new ItemStack(Blocks.stone, 1), new Object[]{"X", Character.valueOf('X'), BlocksDBC.BlockAlienStone});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockNamekStone, 4), new Object[]{"XX", "XX", Character.valueOf('X'), BlocksDBC.BlockAlienStone});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[11], 1), new Object[]{"II ", "IS ", " S ", Character.valueOf('I'), ItemsDBC.ItemsOW[2], Character.valueOf('S'), Items.stick});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[8], 1), new Object[]{"III", " S ", " S ", Character.valueOf('I'), ItemsDBC.ItemsOW[2], Character.valueOf('S'), Items.stick});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[5], 1), new Object[]{" I ", " I ", " S ", Character.valueOf('I'), ItemsDBC.ItemsOW[2], Character.valueOf('S'), Items.stick});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[10], 1), new Object[]{"II ", "IS ", " S ", Character.valueOf('I'), ItemsDBC.ItemsOW[1], Character.valueOf('S'), Items.stick});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[7], 1), new Object[]{"III", " S ", " S ", Character.valueOf('I'), ItemsDBC.ItemsOW[1], Character.valueOf('S'), Items.stick});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[4], 1), new Object[]{" I ", " I ", " S ", Character.valueOf('I'), ItemsDBC.ItemsOW[1], Character.valueOf('S'), Items.stick});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[12], 1), new Object[]{"II ", "IS ", " S ", Character.valueOf('I'), ItemsDBC.ItemsOW[0], Character.valueOf('S'), Items.stick});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[9], 1), new Object[]{"III", " S ", " S ", Character.valueOf('I'), ItemsDBC.ItemsOW[0], Character.valueOf('S'), Items.stick});
      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[6], 1), new Object[]{" I ", " I ", " S ", Character.valueOf('I'), ItemsDBC.ItemsOW[0], Character.valueOf('S'), Items.stick});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockOW[0], 1), new Object[]{"III", "III", "III", Character.valueOf('I'), ItemsDBC.ItemsOW[3]});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockOW[1], 1), new Object[]{"III", "III", "III", Character.valueOf('I'), ItemsDBC.ItemsOW[1]});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockOW[2], 1), new Object[]{"III", "III", "III", Character.valueOf('I'), ItemsDBC.ItemsOW[0]});
      GameRegistry.addRecipe(new ItemStack(BlocksDBC.BlockOW[3], 1), new Object[]{"III", "III", "III", Character.valueOf('I'), ItemsDBC.ItemsOW[2]});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemsOW[3], 9), new Object[]{BlocksDBC.BlockOW[0]});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemsOW[1], 9), new Object[]{BlocksDBC.BlockOW[1]});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemsOW[0], 9), new Object[]{BlocksDBC.BlockOW[2]});
      GameRegistry.addShapelessRecipe(new ItemStack(ItemsDBC.ItemsOW[2], 9), new Object[]{BlocksDBC.BlockOW[3]});

      for(int var11 = 0; var11 < 3; ++var11) {
         GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[var11 * 4 + 13], 1), new Object[]{"XXX", "X X", Character.valueOf('X'), ItemsDBC.ItemsOW[var11]});
         GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[var11 * 4 + 14], 1), new Object[]{"X X", "XXX", "XXX", Character.valueOf('X'), ItemsDBC.ItemsOW[var11]});
         GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[var11 * 4 + 15], 1), new Object[]{"XXX", "X X", "X X", Character.valueOf('X'), ItemsDBC.ItemsOW[var11]});
         GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemsOW[var11 * 4 + 16], 1), new Object[]{"X X", "X X", Character.valueOf('X'), ItemsDBC.ItemsOW[var11]});
      }

      GameRegistry.addRecipe(new ItemStack(ItemsDBC.ItemWarenaiFabric, 4), new Object[]{"WOW", "OWO", "WOW", Character.valueOf('W'), new ItemStack(Blocks.wool, 1, 0), Character.valueOf('O'), ItemsDBC.ItemWarenai});
      String[] var12 = new String[]{"FFF", "WWW", "FFF", "FWF", "FWF", "   ", "   ", "   "};
      String[] var14 = new String[]{"FFF", "FFF", "WFW", "FFF", "WFW", "FFF", "WFW", "WFW"};
      String[] var16 = new String[]{"W W", "W W", "W W", "W W", "W W", "W W", "W W", "   "};

      for(int var18 = 0; var18 < ItemsDBC.ItemBodysuits.length; ++var18) {
         ItemStack var7 = new ItemStack(ItemsDBC.ItemBodysuits[var18]);
         GameRegistry.addRecipe(var7, new Object[]{var12[var18], var14[var18], var16[var18], Character.valueOf('W'), new ItemStack(Blocks.wool, 1, 0), Character.valueOf('F'), ItemsDBC.ItemWarenaiFabric});

         for(int var8 = 0; var8 < JRMCoreH2.colNams.length; ++var8) {
            var7 = new ItemStack(ItemsDBC.ItemBodysuits[var18]);
            ((ItemBodyDBC)var7.getItem()).setColor(var7, JRMCoreH2.cols[var8]);
            ItemStack var9 = new ItemStack(Items.dye, 1, var8);
            GameRegistry.addRecipe(((ItemBodyDBC)var7.getItem()).setColor(var7, JRMCoreH2.cols[var8]), new Object[]{"DDD", "DXD", "DDD", Character.valueOf('X'), ItemsDBC.ItemBodysuits[var18], Character.valueOf('D'), var9});
         }
      }

      GameRegistry.addSmelting(BlocksDBC.BlockDragonBallStone, new ItemStack(BlocksDBC.BlockDragonBall, 1), 0.1F);
      GameRegistry.addSmelting(BlocksDBC.BlockOreWrenai, new ItemStack(ItemsDBC.ItemWarenai, 1), 0.7F);
      GameRegistry.addSmelting(BlocksDBC.BlockAlienCobbleStone, new ItemStack(BlocksDBC.BlockAlienStone, 1), 0.1F);
      GameRegistry.addSmelting(Items.sugar, new ItemStack(Items.dye, 1, 3), 0.2F);
      GameRegistry.addSmelting(ItemsDBC.ItemDinoMeat, new ItemStack(ItemsDBC.ItemDinoMeatCooked), 0.5F);
      GameRegistry.addSmelting(BlocksDBC.BlockOreLehnori, new ItemStack(ItemsDBC.ItemsOW[0]), 0.7F);
      GameRegistry.addSmelting(BlocksDBC.BlockOreDlog, new ItemStack(ItemsDBC.ItemsOW[1]), 1.0F);
      GameRegistry.addSmelting(BlocksDBC.BlockOreDnomaid, new ItemStack(ItemsDBC.ItemsOW[2]), 1.0F);
   }
}
