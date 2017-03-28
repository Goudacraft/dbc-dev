package JinRyuu.DragonBC.common.Worlds;

import JinRyuu.DragonBC.common.Worlds.x0GenLayerDBCNamekBiomes;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class x0GenLayerDBCNamek extends GenLayer {
   public x0GenLayerDBCNamek(long var1) {
      super(var1);
   }

   public static GenLayer[] makeTheWorld(long var0, WorldType var2) {
      x0GenLayerDBCNamekBiomes var3 = new x0GenLayerDBCNamekBiomes(1L);
      GenLayerZoom var5 = new GenLayerZoom(1000L, var3);
      var5 = new GenLayerZoom(1001L, var5);
      var5 = new GenLayerZoom(1002L, var5);
      var5 = new GenLayerZoom(1003L, var5);
      var5 = new GenLayerZoom(1004L, var5);
      var5 = new GenLayerZoom(1005L, var5);
      GenLayerVoronoiZoom var4 = new GenLayerVoronoiZoom(10L, var5);
      var5.initWorldGenSeed(var0);
      var4.initWorldGenSeed(var0);
      return new GenLayer[]{var5, var4};
   }

   public int[] getInts(int var1, int var2, int var3, int var4) {
      return null;
   }
}
