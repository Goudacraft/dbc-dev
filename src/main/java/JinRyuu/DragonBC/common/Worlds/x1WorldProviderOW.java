package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
import JinRyuu.DragonBC.common.Worlds.x1ChunkProviderOW;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class x1WorldProviderOW extends WorldProvider {
   public x1WorldProviderOW() {
   }

   public int registerWorld() {
      return 22;
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
      return false;
   }

   public String getRespawnMessage() {
      return " Leaving Other World ";
   }

   public boolean hasMultipleBiomes() {
      return false;
   }

   public void registerWorldChunkManager() {
      this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBaseDBC.OtherW, 0.8F);
   }

   public IChunkProvider createChunkGenerator() {
      return new x1ChunkProviderOW(this.worldObj, this.worldObj.getSeed(), false);
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
      return "OtherWorld";
   }
}
