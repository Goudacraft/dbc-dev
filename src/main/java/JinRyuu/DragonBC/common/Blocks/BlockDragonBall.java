package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Blocks.DBCMaterial;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockDragonBall extends Block {
   protected int maxStackSize = 7;

   public BlockDragonBall setMaxStackSize(int var1) {
      this.maxStackSize = var1;
      return this;
   }

   public int getItemStackLimit() {
      return this.maxStackSize;
   }

   public BlockDragonBall() {
      super(DBCMaterial.dragonblock);
      this.setTickRandomly(true);
      this.setHardness(0.1F);
      float var1 = 0.2F;
      this.setBlockBounds(0.5F - var1, 0.2F - var1, 0.5F - var1, 0.5F + var1, 0.2F + var1, 0.5F + var1);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
      if(!var1.isRemote) {
         if(var1.getBlock(var2 + 1, var3, var4) == this) {
            if(var1.getBlock(var2 + 1, var3, var4 + 1) == this && var1.getBlock(var2 + 1, var3, var4 - 1) == this && var1.getBlock(var2 - 1, var3, var4) == this && var1.getBlock(var2 - 1, var3, var4 - 1) == this && var1.getBlock(var2 - 1, var3, var4 + 1) == this) {
               var1.setBlock(var2, var3, var4, BlocksDBC.BlockDragonBallStone);
            }
         } else if(var1.getBlock(var2, var3, var4 + 1) == this && var1.getBlock(var2 + 1, var3, var4 + 1) == this && var1.getBlock(var2 + 1, var3, var4 - 1) == this && var1.getBlock(var2, var3, var4 - 1) == this && var1.getBlock(var2 - 1, var3, var4 - 1) == this && var1.getBlock(var2 - 1, var3, var4 + 1) == this) {
            var1.setBlock(var2, var3, var4, BlocksDBC.BlockDragonBallStone);
         }
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
