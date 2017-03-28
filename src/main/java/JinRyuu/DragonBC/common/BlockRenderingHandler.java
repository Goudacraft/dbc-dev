package JinRyuu.DragonBC.common;

import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;

public class BlockRenderingHandler implements ISimpleBlockRenderingHandler {
   public static final double POSITION_FIX = -0.5D;
   private static ArtGravDevTileEntity generator = new ArtGravDevTileEntity();

   public BlockRenderingHandler() {
   }

   public void renderInventoryBlock(Block var1, int var2, int var3, RenderBlocks var4) {
   }

   public boolean renderWorldBlock(IBlockAccess var1, int var2, int var3, int var4, Block var5, int var6, RenderBlocks var7) {
      Tessellator var8 = Tessellator.instance;
      Object var9 = null;
      if(var9 != null) {
         RenderStaticTileEntity(var1, var2, var3, var4, var7, (TileEntity)var9);
         return true;
      } else {
         return false;
      }
   }

   public static void RenderStaticTileEntity(IBlockAccess var0, int var1, int var2, int var3, RenderBlocks var4, TileEntity var5) {
   }

   public int getRenderId() {
      return 0;
   }

   public boolean shouldRender3DInInventory(int var1) {
      return true;
   }
}
