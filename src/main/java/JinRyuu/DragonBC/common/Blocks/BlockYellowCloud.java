package JinRyuu.DragonBC.common.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockYellowCloud extends Block {
   public BlockYellowCloud() {
      super(Material.craftedSnow);
      this.setHardness(0.1F);
      this.setResistance(10.0F);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   @SideOnly(Side.CLIENT)
   public int getRenderBlockPass() {
      return 0;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean renderAsNormalBlock() {
      return false;
   }

   public boolean canCollideCheck(int var1, boolean var2) {
      return false;
   }

   public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
      return null;
   }

   public boolean isBlockSolid(IBlockAccess var1, int var2, int var3, int var4, int var5) {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public int idDropped(int var1, Random var2, int var3) {
      return 0;
   }
}
