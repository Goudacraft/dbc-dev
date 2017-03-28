package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
import JinRyuu.DragonBC.common.Worlds.x2ChunkProviderTC;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class x2WorldProviderTC extends WorldProvider {
   public x2WorldProviderTC() {
   }

   public int registerWorld() {
      return 23;
   }

   public boolean renderClouds() {
      return false;
   }

   public boolean renderEndSky() {
      return false;
   }

   public boolean renderVoidFog() {
      return true;
   }

   public float setMoonSize() {
      return 0.0F;
   }

   public float setSunSize() {
      return 0.0F;
   }

   public String getSunTexture() {
      return "jinryuudragonbc:sun.png";
   }

   public String getMoonTexture() {
      return "jinryuudragonbc:moon_phases.png";
   }

   public boolean renderStars() {
      return true;
   }

   public boolean darkenSkyDuringRain() {
      return false;
   }

   public String getRespawnMessage() {
      return " Leaving Time Chamber";
   }

   public boolean hasMultipleBiomes() {
      return false;
   }

   public void registerWorldChunkManager() {
      this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBaseDBC.TC, 0.8F);
   }

   public IChunkProvider createChunkGenerator() {
      return new x2ChunkProviderTC(this.worldObj, this.worldObj.getSeed(), false);
   }

   public boolean canRespawnHere() {
      return true;
   }

   public float calculateCelestialAngle(long var1, float var3) {
      return 1.0F;
   }

   public String getSaveFolder() {
      return this.getDimensionName();
   }

   public String getDimensionName() {
      return "TimeChamber";
   }
}
