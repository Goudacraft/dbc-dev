package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Items.GiTurtle;
import JinRyuu.DragonBC.common.Items.ItemAnyBase;
import JinRyuu.DragonBC.common.Items.ItemArmorNormal;
import JinRyuu.DragonBC.common.Items.ItemBodyDBC;
import JinRyuu.DragonBC.common.Items.ItemBraveSword;
import JinRyuu.DragonBC.common.Items.ItemBraveSwordBlade;
import JinRyuu.DragonBC.common.Items.ItemBraveSwordHandle;
import JinRyuu.DragonBC.common.Items.ItemDBCBucket;
import JinRyuu.DragonBC.common.Items.ItemDinoMeat;
import JinRyuu.DragonBC.common.Items.ItemDragonRadar;
import JinRyuu.DragonBC.common.Items.ItemHeadDBC;
import JinRyuu.DragonBC.common.Items.ItemKatana;
import JinRyuu.DragonBC.common.Items.ItemKatanaBlade;
import JinRyuu.DragonBC.common.Items.ItemKatanaHandle;
import JinRyuu.DragonBC.common.Items.ItemKatchin;
import JinRyuu.DragonBC.common.Items.ItemMedMoss;
import JinRyuu.DragonBC.common.Items.ItemRec;
import JinRyuu.DragonBC.common.Items.ItemSaibaiSeed;
import JinRyuu.DragonBC.common.Items.ItemSenzu;
import JinRyuu.DragonBC.common.Items.ItemSwordBase;
import JinRyuu.DragonBC.common.Items.ItemToolAxe;
import JinRyuu.DragonBC.common.Items.ItemToolPickaxe;
import JinRyuu.DragonBC.common.Items.ItemWarenai;
import JinRyuu.DragonBC.common.Items.ItemWeight;
import JinRyuu.DragonBC.common.Items.ItemZSword;
import JinRyuu.DragonBC.common.Items.ItemZSwordBlade;
import JinRyuu.DragonBC.common.Items.ItemZSwordHandle;
import JinRyuu.DragonBC.common.Render.DragonBlock01Item;
import JinRyuu.DragonBC.common.Render.KintounBlackItem;
import JinRyuu.DragonBC.common.Render.KintounItem;
import JinRyuu.DragonBC.common.Render.SpacePod01Item;
import JinRyuu.JRMCore.JRMCoreH2;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemsDBC {
   public static ToolMaterial KATANA = EnumHelper.addToolMaterial("KATANA", 1, 500, 6.0F, 10.0F, 20);
   public static ToolMaterial ZSWORD = EnumHelper.addToolMaterial("ZSWORD", 3, 2000, 8.0F, 20.0F, 5);
   public static ToolMaterial BSWORD = EnumHelper.addToolMaterial("BSWORD", 2, 1000, 12.0F, 15.0F, 25);
   public static ToolMaterial HandleSWORD = EnumHelper.addToolMaterial("HandleSWORD", 1, 100, 1.0F, 1.0F, 1);
   public static ToolMaterial BladeSWORD = EnumHelper.addToolMaterial("BladeSWORD", 1, 100, 2.0F, 1.0F, 1);
   public static ArmorMaterial GI2 = EnumHelper.addArmorMaterial("GI", 25, new int[]{3, 5, 5, 5}, 20);
   public static ArmorMaterial GI = EnumHelper.addArmorMaterial("GI", 15, new int[]{3, 5, 5, 5}, 20);
   public static ArmorMaterial WARENAI = EnumHelper.addArmorMaterial("WARENAI", 30, new int[]{3, 8, 6, 3}, 10);
   public static ArmorMaterial tier0 = EnumHelper.addArmorMaterial("tier0", 30, new int[]{1, 10, 6, 3}, 10);
   public static ArmorMaterial tier1 = EnumHelper.addArmorMaterial("tier1", 30, new int[]{1, 10, 4, 3}, 10);
   public static ArmorMaterial tier2 = EnumHelper.addArmorMaterial("tier2", 30, new int[]{1, 10, 2, 3}, 10);
   public static ArmorMaterial tier3 = EnumHelper.addArmorMaterial("tier3", 30, new int[]{1, 8, 4, 3}, 10);
   public static ArmorMaterial scouter1 = EnumHelper.addArmorMaterial("scouter1", 30, new int[]{1, 10, 6, 3}, 10);
   public static ArmorMaterial scouter2 = EnumHelper.addArmorMaterial("scouter2", 30, new int[]{2, 10, 6, 3}, 10);
   public static ArmorMaterial scouter3 = EnumHelper.addArmorMaterial("scouter3", 30, new int[]{3, 10, 6, 3}, 10);
   public static Item SpacePod01Item;
   public static Item SpacePodVegetaChip;
   public static Item KintounItem;
   public static Item KintounBlackItem;
   public static Item ItemAlienTechChipTier1;
   public static Item ItemChipTier2;
   public static Item ItemChipTier3;
   public static Item ItemDragonRadar;
   public static Item ItemDragonBlock;
   public static Item ItemNamekDragonBlock;
   public static Item ItemSaibaiSeed;
   public static Item ItemSenzu;
   public static Item ItemWarenai;
   public static Item ItemWarenaiFabric;
   public static Item ItemKatana;
   public static Item ItemNamekIT;
   public static Item ItemKatchin;
   public static Item ItemZSword;
   public static Item ItemBraveSword;
   public static Item ItemKatanaHandle;
   public static Item ItemBraveSwordHandle;
   public static Item ItemZSwordHandle;
   public static Item ItemKatanaSwordBlade;
   public static Item ItemBraveSwordBlade;
   public static Item ItemZSwordBlade;
   public static Item ItemDinoMeat;
   public static Item ItemDinoMeatCooked;
   public static Item ItemBucketMedLiq;
   public static Item ItemMedMoss;
   public static ItemPotion Bloods;
   public static Item[] DBCitems = new Item[30];
   public static Item BattleArmorHelmet00;
   public static Item BattleArmorChest00;
   public static Item BattleArmorLegs00;
   public static Item BattleArmorBoots00;
   public static Item BattleArmorHelmet01;
   public static Item BattleArmorChest01;
   public static Item BattleArmorLegs01;
   public static Item BattleArmorBoots01;
   public static Item BattleArmorHelmet02;
   public static Item BattleArmorChest02;
   public static Item BattleArmorLegs02;
   public static Item BattleArmorBoots02;
   public static Item BattleArmorHelmet03;
   public static Item BattleArmorChest03;
   public static Item BattleArmorLegs03;
   public static Item BattleArmorBoots03;
   public static Item BattleArmorHelmet04;
   public static Item BattleArmorChest04;
   public static Item BattleArmorLegs04;
   public static Item BattleArmorBoots04;
   public static Item BattleArmorHelmet05;
   public static Item BattleArmorChest05;
   public static Item BattleArmorLegs05;
   public static Item BattleArmorBoots05;
   public static Item BattleArmorHelmet00a;
   public static Item BattleArmorHelmet01a;
   public static Item BattleArmorHelmet02a;
   public static Item BattleArmorHelmet03a;
   public static Item BattleArmorHelmet04a;
   public static Item BattleArmorHelmet05a;
   public static Item BattleArmorHelmet00b;
   public static Item BattleArmorHelmet01b;
   public static Item BattleArmorHelmet02b;
   public static Item BattleArmorHelmet03b;
   public static Item BattleArmorHelmet04b;
   public static Item BattleArmorHelmet05b;
   public static Item GiFighter1Torso;
   public static Item GiFighter1Leg;
   public static Item GiFighter1Boots;
   public static Item GiNamekTorso;
   public static Item GiNamekLeg;
   public static Item GiNamekBoots;
   public static Item GiFutureTorso;
   public static Item GiFutureLeg;
   public static Item GiFutureBoots;
   public static Item GiFighter2Torso;
   public static Item GiFighter2Leg;
   public static Item GiFighter2Boots;
   public static Item KameTorso1;
   public static Item KameBoots1;
   public static Item GiFighter3Torso;
   public static Item ItemWeightShell;
   public static Item ItemWeightShirt;
   public static Item ItemWeightHandLeg;
   public static final String[] ItemsOutfitnams = new String[]{"c16", "c17", "c18", "c19", "c20", "darbura", "majinbuufat", "majinbuu", "tien", "chichi", "genblue", "highschool", "karinga", "pilaf", "saiyaman", "supkai", "black", "fusiond"};
   public static final String[] ItemsOutfitType = new String[]{"1,2,3", "1,2,3", "1,2,3", "0,1,2,3", "0,1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "1,2,3", "0,1,2,3", "0,1,2,3", "1,2,3", "1,2,3", "1,2,3"};
   public static final int outfit_c16 = 0;
   public static final int outfit_c17 = 1;
   public static final int outfit_c18 = 2;
   public static final int outfit_c19 = 3;
   public static final int outfit_c20 = 4;
   public static final int outfit_darbura = 5;
   public static final int outfit_majinbuufat = 6;
   public static final int outfit_majinbuu = 7;
   public static final int outfit_tien = 8;
   public static final int outfit_chichi = 9;
   public static final int outfit_genblue = 10;
   public static final int outfit_highschool = 11;
   public static final int outfit_karinga = 12;
   public static final int outfit_pilaf = 13;
   public static final int outfit_saiyaman = 14;
   public static final int outfit_supkai = 15;
   public static final int outfit_black = 16;
   public static final int outfit_fusionDance = 17;
   public static Item[] ItemsOutfit0 = new Item[ItemsOutfitnams.length];
   public static Item[] ItemsOutfit1 = new Item[ItemsOutfitnams.length];
   public static Item[] ItemsOutfit2 = new Item[ItemsOutfitnams.length];
   public static Item[] ItemsOutfit3 = new Item[ItemsOutfitnams.length];
   public static final String[] ItemsBodynams = new String[]{""};
   public static Item[] ItemsBody = new Item[ItemsBodynams.length];
   public static final String[] ItemsHeadnams = new String[]{""};
   public static Item[] ItemsHead = new Item[ItemsHeadnams.length];
   public static final int ItemBodysuitAmount = 8;
   public static ItemBodyDBC[] ItemBodysuits = new ItemBodyDBC[8];
   public static final String[] ItemsRecnams = new String[]{"DBC1", "DBC2", "DBC3", "DBC4", "DBC5"};
   public static Item[] ItemsRec = new Item[ItemsRecnams.length];
   public static final int ItemLehnoriIngot = 0;
   public static final int ItemDlogIngot = 1;
   public static final int ItemDnomaidIngot = 2;
   public static final int Itemjjay = 3;
   public static final int ItemDlogSword = 4;
   public static final int ItemDnomaidSword = 5;
   public static final int ItemLehnoriSword = 6;
   public static final int ItemDlogPickaxe = 7;
   public static final int ItemDnomaidPickaxe = 8;
   public static final int ItemLehnoriPickaxe = 9;
   public static final int ItemDlogAxe = 10;
   public static final int ItemDnomaidAxe = 11;
   public static final int ItemLehnoriAxe = 12;
   public static final int ItemLehnoriHelm = 13;
   public static final int ItemLehnoriChest = 14;
   public static final int ItemLehnoriLeg = 15;
   public static final int ItemLehnoriBoot = 16;
   public static final int ItemDlogHelm = 17;
   public static final int ItemDlogChest = 18;
   public static final int ItemDlogLeg = 19;
   public static final int ItemDlogBoot = 20;
   public static final int ItemDnomaidHelm = 21;
   public static final int ItemDnomaidChest = 22;
   public static final int ItemDnomaidLeg = 23;
   public static final int ItemDnomaidBoot = 24;
   public static final String[] ItemOWnams = new String[]{"LehnoriIngot", "DlogIngot", "DnomaidIngot", "JJay", "DlogSword", "DnomaidSword", "LehnoriSword", "DlogPick", "DnomaidPick", "LehnoriPick", "DlogAxe", "DnomaidAxe", "LehnoriAxe", "LehnoriHelmet", "LehnoriChest", "LehnoriPants", "LehnoriBoots", "DlogHelmet", "DlogChest", "DlogPants", "DlogBoots", "DnomaidHelmet", "DnomaidChest", "DnomaidPants", "DnomaidBoots"};
   public static final Item[] ItemOWtypes = new Item[]{new ItemAnyBase(), new ItemAnyBase(), new ItemAnyBase(), new ItemAnyBase(), new ItemSwordBase(ToolMaterial.WOOD), new ItemSwordBase(ToolMaterial.EMERALD), new ItemSwordBase(ToolMaterial.IRON), new ItemToolPickaxe(ToolMaterial.WOOD), new ItemToolPickaxe(ToolMaterial.EMERALD), new ItemToolPickaxe(ToolMaterial.IRON), new ItemToolAxe(ToolMaterial.WOOD), new ItemToolAxe(ToolMaterial.EMERALD), new ItemToolAxe(ToolMaterial.IRON), new ItemArmorNormal(ArmorMaterial.IRON, 0, 0, "lehnorilayer"), new ItemArmorNormal(ArmorMaterial.IRON, 0, 1, "lehnorilayer"), new ItemArmorNormal(ArmorMaterial.IRON, 0, 2, "lehnorilayer"), new ItemArmorNormal(ArmorMaterial.IRON, 0, 3, "lehnorilayer"), new ItemArmorNormal(ArmorMaterial.GOLD, 0, 0, "dloglayer"), new ItemArmorNormal(ArmorMaterial.GOLD, 0, 1, "dloglayer"), new ItemArmorNormal(ArmorMaterial.GOLD, 0, 2, "dloglayer"), new ItemArmorNormal(ArmorMaterial.GOLD, 0, 3, "dloglayer"), new ItemArmorNormal(ArmorMaterial.DIAMOND, 0, 0, "dnomaidlayer"), new ItemArmorNormal(ArmorMaterial.DIAMOND, 0, 1, "dnomaidlayer"), new ItemArmorNormal(ArmorMaterial.DIAMOND, 0, 2, "dnomaidlayer"), new ItemArmorNormal(ArmorMaterial.DIAMOND, 0, 3, "dnomaidlayer")};
   public static Item[] ItemsOW = new Item[ItemOWnams.length];

   public ItemsDBC() {
   }

   public static void init() {
      SpacePod01Item = GameRegistry.registerItem((new SpacePod01Item(BlocksDBC.SpacePod01Block, GI, 0, 0)).setUnlocalizedName("SpacePod01Item"), "SpacePod01Item", (String)null);
      KintounItem = GameRegistry.registerItem((new KintounItem()).setUnlocalizedName("KintounItem"), "KintounItem", (String)null);
      KintounBlackItem = GameRegistry.registerItem((new KintounBlackItem()).setUnlocalizedName("KintounBlackItem"), "KintounBlackItem", (String)null);
      ItemBucketMedLiq = GameRegistry.registerItem((new ItemDBCBucket(BlocksDBC.BlockHealingPods)).setUnlocalizedName("ItemBucketMedLiq"), "ItemBucketMedLiq", (String)null);
      ItemMedMoss = GameRegistry.registerItem((new ItemMedMoss(1, 0.1F)).setUnlocalizedName("ItemMedMoss"), "ItemMedMoss", (String)null);
      ItemSenzu = GameRegistry.registerItem((new ItemSenzu(20, 10.0F, true)).setUnlocalizedName("ItemSenzu"), "ItemSenzu", (String)null);
      ItemSaibaiSeed = GameRegistry.registerItem((new ItemSaibaiSeed()).setUnlocalizedName("ItemSaibaiSeed"), "ItemSaibaiSeed", (String)null);
      ItemWarenai = GameRegistry.registerItem((new ItemWarenai()).setUnlocalizedName("ItemWarenai"), "ItemWarenai", (String)null);
      ItemKatana = GameRegistry.registerItem((new ItemKatana(KATANA)).setUnlocalizedName("ItemKatana"), "ItemKatana", (String)null);
      ItemKatchin = GameRegistry.registerItem((new ItemKatchin()).setUnlocalizedName("ItemKatchin"), "ItemKatchin", (String)null);
      ItemBraveSword = GameRegistry.registerItem((new ItemBraveSword(BSWORD)).setUnlocalizedName("ItemBraveSword"), "ItemBraveSword", (String)null);
      ItemZSword = GameRegistry.registerItem((new ItemZSword(ZSWORD)).setUnlocalizedName("ItemZSword"), "ItemZSword", (String)null);
      ItemKatanaHandle = GameRegistry.registerItem((new ItemKatanaHandle(HandleSWORD)).setUnlocalizedName("ItemKatanaHandle"), "ItemKatanaHandle", (String)null);
      ItemBraveSwordHandle = GameRegistry.registerItem((new ItemBraveSwordHandle(HandleSWORD)).setUnlocalizedName("ItemBraveSwordHandle"), "ItemBraveSwordHandle", (String)null);
      ItemZSwordHandle = GameRegistry.registerItem((new ItemZSwordHandle(HandleSWORD)).setUnlocalizedName("ItemZSwordHandle"), "ItemZSwordHandle", (String)null);
      ItemKatanaSwordBlade = GameRegistry.registerItem((new ItemKatanaBlade(BladeSWORD)).setUnlocalizedName("ItemKatanaSwordBlade"), "ItemKatanaSwordBlade", (String)null);
      ItemBraveSwordBlade = GameRegistry.registerItem((new ItemBraveSwordBlade(BladeSWORD)).setUnlocalizedName("ItemBraveSwordBlade"), "ItemBraveSwordBlade", (String)null);
      ItemZSwordBlade = GameRegistry.registerItem((new ItemZSwordBlade(BladeSWORD)).setUnlocalizedName("ItemZSwordBlade"), "ItemZSwordBlade", (String)null);

      for(int var0 = 0; var0 < ItemOWnams.length; ++var0) {
         ItemsOW[var0] = GameRegistry.registerItem(ItemOWtypes[var0].setUnlocalizedName(ItemOWnams[var0]), ItemOWnams[var0], (String)null);
      }

      for(int var4 = 0; var4 < ItemsRecnams.length; ++var4) {
         ItemsRec[var4] = GameRegistry.registerItem((new ItemRec(ItemsRecnams[var4])).setUnlocalizedName("record." + ItemsRecnams[var4]), "record." + ItemsRecnams[var4], (String)null);
      }

      for(int var5 = 0; var5 < ItemsOutfitnams.length; ++var5) {
         String[] var1 = ItemsOutfitType[var5].split(",");

         for(int var2 = 0; var2 < var1.length; ++var2) {
            int var3 = Integer.parseInt(var1[var2]);
            switch(var3) {
            case 0:
               ItemsOutfit0[var5] = GameRegistry.registerItem((new GiTurtle(GI2, 0, var3, ItemsOutfitnams[var5])).setUnlocalizedName(ItemsOutfitnams[var5] + "Head"), ItemsOutfitnams[var5] + "Head", (String)null);
               break;
            case 1:
               ItemsOutfit1[var5] = GameRegistry.registerItem((new GiTurtle(GI2, 0, var3, ItemsOutfitnams[var5])).setUnlocalizedName(ItemsOutfitnams[var5] + "Chest"), ItemsOutfitnams[var5] + "Chest", (String)null);
               break;
            case 2:
               ItemsOutfit2[var5] = GameRegistry.registerItem((new GiTurtle(GI2, 0, var3, ItemsOutfitnams[var5])).setUnlocalizedName(ItemsOutfitnams[var5] + "Leg"), ItemsOutfitnams[var5] + "Leg", (String)null);
               break;
            case 3:
               ItemsOutfit3[var5] = GameRegistry.registerItem((new GiTurtle(GI2, 0, var3, ItemsOutfitnams[var5])).setUnlocalizedName(ItemsOutfitnams[var5] + "Boots"), ItemsOutfitnams[var5] + "Boots", (String)null);
            }
         }
      }

      for(int var6 = 0; var6 < 8; ++var6) {
         ItemBodysuits[var6] = (ItemBodyDBC)GameRegistry.registerItem((new ItemBodyDBC(JRMCoreH2.cols[15], "body" + var6)).setUnlocalizedName("bodysuit" + var6), "bodysuit" + var6, (String)null);
      }

      ItemWarenaiFabric = GameRegistry.registerItem((new ItemAnyBase()).setUnlocalizedName("ItemWarenaiFabric"), "ItemWarenaiFabric", (String)null);
      ItemAlienTechChipTier1 = GameRegistry.registerItem((new ItemKatchin()).setUnlocalizedName("ItemAlienTechChipTier1"), "ItemAlienTechChipTier1", (String)null);
      ItemChipTier2 = GameRegistry.registerItem((new ItemKatchin()).setUnlocalizedName("ItemChipTier2"), "ItemChipTier2", (String)null);
      ItemChipTier3 = GameRegistry.registerItem((new ItemKatchin()).setUnlocalizedName("ItemChipTier3"), "ItemChipTier3", (String)null);
      ItemDinoMeat = GameRegistry.registerItem((new ItemDinoMeat(2, 0.0F, 1.0F)).setUnlocalizedName("ItemDinoMeat"), "ItemDinoMeat", (String)null);
      ItemDinoMeatCooked = GameRegistry.registerItem((new ItemDinoMeat(5, 0.0F, 1.6F)).setUnlocalizedName("ItemDinoMeatCooked"), "ItemDinoMeatCooked", (String)null);
      ItemWeightShell = GameRegistry.registerItem((new ItemWeight(5)).setUnlocalizedName("ItemWeightShell"), "ItemWeightShell", (String)null);
      ItemWeightShirt = GameRegistry.registerItem((new ItemWeight(5)).setUnlocalizedName("ItemWeightShirt"), "ItemWeightShirt", (String)null);
      ItemWeightHandLeg = GameRegistry.registerItem((new ItemWeight(5)).setUnlocalizedName("ItemWeightHandLeg"), "ItemWeightHandLeg", (String)null);
      ItemDragonRadar = GameRegistry.registerItem((new ItemDragonRadar()).setUnlocalizedName("ItemDragonRadar"), "ItemDragonRadar", (String)null);
      ItemDragonBlock = GameRegistry.registerItem((new DragonBlock01Item(BlocksDBC.BlockDragonBall)).setUnlocalizedName("ItemDragonBlock"), "ItemDragonBlock", (String)null);
      ItemNamekDragonBlock = GameRegistry.registerItem((new DragonBlock01Item(BlocksDBC.BlockNamekDragonBall)).setUnlocalizedName("ItemNamekDragonBlock"), "ItemNamekDragonBlock", (String)null);
      BattleArmorHelmet00 = GameRegistry.registerItem((new ItemHeadDBC("tier0", "1")).setUnlocalizedName("YellowScouter"), "YellowScouter", (String)null);
      BattleArmorHelmet01 = GameRegistry.registerItem((new ItemHeadDBC("tier1", "1")).setUnlocalizedName("RedScouter"), "RedScouter", (String)null);
      BattleArmorHelmet02 = GameRegistry.registerItem((new ItemHeadDBC("tier2", "1")).setUnlocalizedName("PurpleScouter"), "PurpleScouter", (String)null);
      BattleArmorHelmet03 = GameRegistry.registerItem((new ItemHeadDBC("tier3", "1")).setUnlocalizedName("BlueScouter"), "BlueScouter", (String)null);
      BattleArmorHelmet04 = GameRegistry.registerItem((new ItemHeadDBC("tier4", "1")).setUnlocalizedName("GreenScouter"), "GreenScouter", (String)null);
      BattleArmorHelmet05 = GameRegistry.registerItem((new ItemHeadDBC("tier5", "1")).setUnlocalizedName("PinkScouter"), "PinkScouter", (String)null);
      BattleArmorChest00 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 1, "tier0")).setUnlocalizedName("BattleArmorChest00"), "BattleArmorChest00", (String)null);
      BattleArmorLegs00 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 2, "tier0")).setUnlocalizedName("BattleArmorLegs00"), "BattleArmorLegs00", (String)null);
      BattleArmorBoots00 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 3, "tier0")).setUnlocalizedName("BattleArmorBoots00"), "BattleArmorBoots00", (String)null);
      BattleArmorChest01 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 1, "tier1")).setUnlocalizedName("BattleArmorChest01"), "BattleArmorChest01", (String)null);
      BattleArmorLegs01 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 2, "tier1")).setUnlocalizedName("BattleArmorLegs01"), "BattleArmorLegs01", (String)null);
      BattleArmorBoots01 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 3, "tier1")).setUnlocalizedName("BattleArmorBoots01"), "BattleArmorBoots01", (String)null);
      BattleArmorChest02 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 1, "tier2")).setUnlocalizedName("BattleArmorChest02"), "BattleArmorChest02", (String)null);
      BattleArmorLegs02 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 2, "tier2")).setUnlocalizedName("BattleArmorLegs02"), "BattleArmorLegs02", (String)null);
      BattleArmorBoots02 = GameRegistry.registerItem((new GiTurtle(tier0, 0, 3, "tier2")).setUnlocalizedName("BattleArmorBoots02"), "BattleArmorBoots02", (String)null);
      BattleArmorChest03 = GameRegistry.registerItem((new GiTurtle(tier2, 0, 1, "tier3")).setUnlocalizedName("BattleArmorChest03"), "BattleArmorChest03", (String)null);
      BattleArmorLegs03 = GameRegistry.registerItem((new GiTurtle(tier2, 0, 2, "tier3")).setUnlocalizedName("BattleArmorLegs03"), "BattleArmorLegs03", (String)null);
      BattleArmorBoots03 = GameRegistry.registerItem((new GiTurtle(tier2, 0, 3, "tier3")).setUnlocalizedName("BattleArmorBoots03"), "BattleArmorBoots03", (String)null);
      BattleArmorChest04 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 1, "tier4")).setUnlocalizedName("BattleArmorChest04"), "BattleArmorChest04", (String)null);
      BattleArmorLegs04 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 2, "tier4")).setUnlocalizedName("BattleArmorLegs04"), "BattleArmorLegs04", (String)null);
      BattleArmorBoots04 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 3, "tier4")).setUnlocalizedName("BattleArmorBoots04"), "BattleArmorBoots04", (String)null);
      BattleArmorChest05 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 1, "tier5")).setUnlocalizedName("BattleArmorChest05"), "BattleArmorChest05", (String)null);
      BattleArmorLegs05 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 2, "tier5")).setUnlocalizedName("BattleArmorLegs05"), "BattleArmorLegs05", (String)null);
      BattleArmorBoots05 = GameRegistry.registerItem((new GiTurtle(tier3, 0, 3, "tier5")).setUnlocalizedName("BattleArmorBoots05"), "BattleArmorBoots05", (String)null);
      GiFighter1Torso = GameRegistry.registerItem((new GiTurtle(GI, 0, 1, "zfighter1")).setUnlocalizedName("GiFighterTorso1"), "GiFighterTorso1", (String)null);
      GiFighter1Leg = GameRegistry.registerItem((new GiTurtle(GI, 0, 2, "zfighter1")).setUnlocalizedName("GiFighterLeg1"), "GiFighterLeg1", (String)null);
      GiFighter1Boots = GameRegistry.registerItem((new GiTurtle(GI, 0, 3, "zfighter1")).setUnlocalizedName("GiFighterBoots1"), "GiFighterBoots1", (String)null);
      GiNamekTorso = GameRegistry.registerItem((new GiTurtle(GI, 0, 1, "namek")).setUnlocalizedName("GiNamekTorso0").setCreativeTab(mod_DragonBC.DragonBlockC), "GiNamekTorso0", (String)null);
      GiNamekLeg = GameRegistry.registerItem((new GiTurtle(GI, 0, 2, "namek")).setUnlocalizedName("GiNamekLeg0").setCreativeTab(mod_DragonBC.DragonBlockC), "GiNamekLeg0", (String)null);
      GiNamekBoots = GameRegistry.registerItem((new GiTurtle(GI, 0, 3, "namek")).setUnlocalizedName("GiNamekBoots0").setCreativeTab(mod_DragonBC.DragonBlockC), "GiNamekBoots0", (String)null);
      GiFutureTorso = GameRegistry.registerItem((new GiTurtle(GI, 0, 1, "future")).setUnlocalizedName("GiFutureTorso0"), "GiFutureTorso0", (String)null);
      GiFutureLeg = GameRegistry.registerItem((new GiTurtle(GI, 0, 2, "future")).setUnlocalizedName("GiFutureLeg0"), "GiFutureLeg0", (String)null);
      GiFutureBoots = GameRegistry.registerItem((new GiTurtle(GI, 0, 3, "future")).setUnlocalizedName("GiFutureBoots0"), "GiFutureBoots0", (String)null);
      GiFighter2Torso = GameRegistry.registerItem((new GiTurtle(GI, 0, 1, "zfighter2")).setUnlocalizedName("GiFighterTorso2").setCreativeTab(mod_DragonBC.DragonBlockC), "GiFighterTorso2", (String)null);
      GiFighter2Leg = GameRegistry.registerItem((new GiTurtle(GI, 0, 2, "zfighter2")).setUnlocalizedName("GiFighterLeg2").setCreativeTab(mod_DragonBC.DragonBlockC), "GiFighterLeg2", (String)null);
      GiFighter2Boots = GameRegistry.registerItem((new GiTurtle(GI, 0, 3, "zfighter2")).setUnlocalizedName("GiFighterBoots2").setCreativeTab(mod_DragonBC.DragonBlockC), "GiFighterBoots2", (String)null);
      KameTorso1 = GameRegistry.registerItem((new GiTurtle(GI, 0, 1, "kame")).setUnlocalizedName("KameTorso1").setCreativeTab(mod_DragonBC.DragonBlockC), "KameTorso1", (String)null);
      KameBoots1 = GameRegistry.registerItem((new GiTurtle(GI, 0, 3, "kame")).setUnlocalizedName("KameBoots1").setCreativeTab(mod_DragonBC.DragonBlockC), "KameBoots1", (String)null);
      GiFighter3Torso = GameRegistry.registerItem((new GiTurtle(GI, 0, 1, "zfighter3")).setUnlocalizedName("GiFighterTorso3").setCreativeTab(mod_DragonBC.DragonBlockC), "GiFighterTorso3", (String)null);
      BattleArmorHelmet00a = GameRegistry.registerItem((new ItemHeadDBC("tier0", "2")).setUnlocalizedName("YellowScoutera"), "YellowScoutera", (String)null);
      BattleArmorHelmet01a = GameRegistry.registerItem((new ItemHeadDBC("tier1", "2")).setUnlocalizedName("RedScoutera"), "RedScoutera", (String)null);
      BattleArmorHelmet02a = GameRegistry.registerItem((new ItemHeadDBC("tier2", "2")).setUnlocalizedName("PurpleScoutera"), "PurpleScoutera", (String)null);
      BattleArmorHelmet03a = GameRegistry.registerItem((new ItemHeadDBC("tier3", "2")).setUnlocalizedName("BlueScoutera"), "BlueScoutera", (String)null);
      BattleArmorHelmet04a = GameRegistry.registerItem((new ItemHeadDBC("tier4", "2")).setUnlocalizedName("GreenScoutera"), "GreenScoutera", (String)null);
      BattleArmorHelmet05a = GameRegistry.registerItem((new ItemHeadDBC("tier5", "2")).setUnlocalizedName("PinkScoutera"), "PinkScoutera", (String)null);
      BattleArmorHelmet00b = GameRegistry.registerItem((new ItemHeadDBC("tier0", "3")).setUnlocalizedName("YellowScouterb"), "YellowScouterb", (String)null);
      BattleArmorHelmet01b = GameRegistry.registerItem((new ItemHeadDBC("tier1", "3")).setUnlocalizedName("RedScouterb"), "RedScouterb", (String)null);
      BattleArmorHelmet02b = GameRegistry.registerItem((new ItemHeadDBC("tier2", "3")).setUnlocalizedName("PurpleScouterb"), "PurpleScouterb", (String)null);
      BattleArmorHelmet03b = GameRegistry.registerItem((new ItemHeadDBC("tier3", "3")).setUnlocalizedName("BlueScouterb"), "BlueScouterb", (String)null);
      BattleArmorHelmet04b = GameRegistry.registerItem((new ItemHeadDBC("tier4", "3")).setUnlocalizedName("GreenScouterb"), "GreenScouterb", (String)null);
      BattleArmorHelmet05b = GameRegistry.registerItem((new ItemHeadDBC("tier5", "3")).setUnlocalizedName("PinkScouterb"), "PinkScouterb", (String)null);
   }
}
