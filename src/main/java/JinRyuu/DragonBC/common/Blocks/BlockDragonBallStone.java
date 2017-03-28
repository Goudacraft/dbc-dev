package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Blocks.DBCMaterial;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockDragonBallStone extends Block {
   private static int tickDragonBall = 0;

   public BlockDragonBallStone() {
      super(DBCMaterial.dragonblock);
      this.setTickRandomly(true);
      this.setHardness(1.0F);
      float var1 = 0.2F;
      this.setBlockBounds(0.5F - var1, 0.2F - var1, 0.5F - var1, 0.5F + var1, var1 + 0.2F, 0.5F + var1);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public Item getItemDropped(int var1, Random var2, int var3) {
      return Item.getItemFromBlock(BlocksDBC.BlockDragonBall);
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
      if(!var1.isRemote && var5.nextInt(5) == 0) {
         var1.setBlock(var2, var3, var4, BlocksDBC.BlockDragonBall);
      }

   }

   public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
      return null;
   }

   public boolean renderAsNormalBlock() {
      return false;
   }

   public int getRenderType() {
      return 0;
   }

   public boolean isOpaqueCube() {
      return false;
   }
}
