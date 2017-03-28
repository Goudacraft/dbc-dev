package JinRyuu.DragonBC.common;

import net.minecraft.util.StatCollector;

public class Lang {
   public String BigBangName = StatCollector.translateToLocal("dbc.KABigBang.name");
   public String BlastName = StatCollector.translateToLocal("dbc.KABlast.name");
   public String BurningAttName = StatCollector.translateToLocal("dbc.KABurningAtt.name");
   public String DeathBeamName = StatCollector.translateToLocal("dbc.KADeathBeam.name");
   public String DodonName = StatCollector.translateToLocal("dbc.KADodon.name");
   public String EnergyDiskName = StatCollector.translateToLocal("dbc.KAEnergyDisk.name");
   public String FinalFlashName = StatCollector.translateToLocal("dbc.KAFinalFlash.name");
   public String FingerLeserName = StatCollector.translateToLocal("dbc.KAFingerLeser.name");
   public String GalicGunName = StatCollector.translateToLocal("dbc.KAGalicGun.name");
   public String HameName = StatCollector.translateToLocal("dbc.KAHame.name");
   public String Hame10xName = StatCollector.translateToLocal("dbc.KAHame10x.name");
   public String MakankoName = StatCollector.translateToLocal("dbc.KAMakanko.name");
   public String MasenkoName = StatCollector.translateToLocal("dbc.KAMasenko.name");
   public String PlanetDestName = StatCollector.translateToLocal("dbc.KAPlanetDest.name");
   public String SpiritbombName = StatCollector.translateToLocal("dbc.KASpiritbomb.name");

   public Lang() {
   }

   public static void init() {
   }

   public String KAName(int var1) {
      String var2 = "";
      if(var1 == 1) {
         var2 = this.BigBangName;
      }

      if(var1 == 2) {
         var2 = this.BlastName;
      }

      if(var1 == 3) {
         var2 = this.BurningAttName;
      }

      if(var1 == 4) {
         var2 = this.DeathBeamName;
      }

      if(var1 == 5) {
         var2 = this.DodonName;
      }

      if(var1 == 6) {
         var2 = this.EnergyDiskName;
      }

      if(var1 == 7) {
         var2 = this.FinalFlashName;
      }

      if(var1 == 8) {
         var2 = this.FingerLeserName;
      }

      if(var1 == 9) {
         var2 = this.GalicGunName;
      }

      if(var1 == 10) {
         var2 = this.HameName;
      }

      if(var1 == 11) {
         var2 = this.Hame10xName;
      }

      if(var1 == 12) {
         var2 = this.MakankoName;
      }

      if(var1 == 13) {
         var2 = this.MasenkoName;
      }

      if(var1 == 14) {
         var2 = this.PlanetDestName;
      }

      if(var1 == 15) {
         var2 = this.SpiritbombName;
      }

      return var2;
   }
}
