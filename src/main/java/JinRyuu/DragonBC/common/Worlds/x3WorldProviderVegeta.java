package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
import JinRyuu.DragonBC.common.Worlds.x0ChunkProviderNamek;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class x3WorldProviderVegeta extends WorldProvider {
   public x3WorldProviderVegeta() {
   }

   public int registerWorld() {
      return 21;
   }

   public boolean renderClouds() {
      return true;
   }

   public boolean renderEndSky() {
      return false;
   }

   public boolean renderVoidFog() {
      return true;
   }

   public float setMoonSize() {
      return 5.0F;
   }

   public float setSunSize() {
      return 4.0F;
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
      return true;
   }

   public String getRespawnMessage() {
      return " Leaving Planet Vegeta ";
   }

   public boolean hasMultipleBiomes() {
      return true;
   }

   public void registerWorldChunkManager() {
      this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBaseDBC.Vegeta, 0.8F);
   }

   public IChunkProvider createChunkGenerator() {
      return new x0ChunkProviderNamek(this.worldObj, this.worldObj.getSeed(), true);
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
      return "Vegeta";
   }
}
