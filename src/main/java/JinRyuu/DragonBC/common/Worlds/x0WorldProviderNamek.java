package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.Worlds.x0ChunkProviderNamek;
import JinRyuu.DragonBC.common.Worlds.x0WorldChunkManagerNamek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

public class x0WorldProviderNamek extends WorldProvider {
   public x0WorldProviderNamek() {
   }

   public IChunkProvider createChunkGenerator() {
      return new x0ChunkProviderNamek(this.worldObj, this.worldObj.getSeed(), true);
   }

   public void registerWorldChunkManager() {
      this.worldChunkMgr = new x0WorldChunkManagerNamek(this.worldObj.getSeed(), this.terrainType);
      this.dimensionId = DBCConfig.planetNamek;
   }

   public static WorldProvider getProviderForDimension(int var0) {
      return DimensionManager.createProviderFor(DBCConfig.planetNamek);
   }

   public String getDimensionName() {
      return "Namek";
   }

   public String getSaveFolder() {
      return this.getDimensionName();
   }

   public float calculateCelestialAngle(long var1, float var3) {
      return 1.0F;
   }

   @SideOnly(Side.CLIENT)
   public boolean renderStars() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public double getMovementFactor() {
      return 0.1D;
   }

   @SideOnly(Side.CLIENT)
   public float getStarBrightness(World var1, float var2) {
      return 1.0F;
   }

   @SideOnly(Side.CLIENT)
   public boolean renderClouds() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public boolean renderVoidFog() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public boolean renderEndSky() {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public float setSunSize() {
      return 0.25F;
   }

   @SideOnly(Side.CLIENT)
   public float setMoonSize() {
      return 4.0F;
   }

   @SideOnly(Side.CLIENT)
   public Vec3 getSkyColor(Entity var1, float var2) {
      return this.worldObj.getSkyColorBody(var1, var2);
   }

   @SideOnly(Side.CLIENT)
   public boolean isSkyColored() {
      return true;
   }

   public boolean canRespawnHere() {
      return true;
   }

   public boolean isSurfaceWorld() {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public float getCloudHeight() {
      return this.terrainType.getCloudHeight();
   }

   public ChunkCoordinates getEntrancePortalLocation() {
      return new ChunkCoordinates(50, 5, 0);
   }

   protected void generateLightBrightnessTable() {
      float var1 = 0.0F;

      for(int var2 = 0; var2 <= 15; ++var2) {
         float var3 = 1.0F - (float)var2 / 15.0F;
         this.lightBrightnessTable[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
      }

   }

   @SideOnly(Side.CLIENT)
   public String getWelcomeMessage() {
      return "Entering Planet Namek";
   }

   @SideOnly(Side.CLIENT)
   public String getDepartMessage() {
      return "Leaving Planet Namek";
   }

   public Vec3 drawClouds(float var1) {
      return super.drawClouds(var1);
   }

   @SideOnly(Side.CLIENT)
   public Vec3 getFogColor(float var1, float var2) {
      float var3 = MathHelper.cos(var1 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      if(var3 < 0.0F) {
         var3 = 0.0F;
      }

      if(var3 > 1.0F) {
         var3 = 1.0F;
      }

      float var4 = 0.7529412F;
      float var5 = 0.84705883F;
      float var6 = 1.0F;
      var4 = var4 * (var3 * 0.94F + 0.06F);
      var5 = var5 * (var3 * 0.94F + 0.06F);
      var6 = var6 * (var3 * 0.91F + 0.09F);
      return Vec3.createVectorHelper((double)var4, (double)var5, (double)var6);
   }
}
