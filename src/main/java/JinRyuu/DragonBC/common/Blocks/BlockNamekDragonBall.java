package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Blocks.DBCMaterial;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockNamekDragonBall extends Block {
   protected int maxStackSize = 7;

   public BlockNamekDragonBall setMaxStackSize(int var1) {
      this.maxStackSize = var1;
      return this;
   }

   public int getItemStackLimit() {
      return this.maxStackSize;
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public BlockNamekDragonBall(int var1) {
      super(DBCMaterial.dragonblock);
      this.setTickRandomly(true);
      this.setHardness(0.1F);
      float var2 = 0.4F;
      this.setBlockBounds(0.5F - var2, 0.4F - var2, 0.5F - var2, 0.5F + var2, 0.4F + var2, 0.5F + var2);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9) {
      TileEntity var10 = var1.getTileEntity(var2, var3, var4);
      if(var10 != null && !var5.isSneaking()) {
         if(!var1.isRemote) {
            if(var1.getBlock(var2 + 1, var3, var4) == this) {
               if(var1.getBlock(var2 + 1, var3, var4 + 1) == this && var1.getBlock(var2 + 1, var3, var4 - 1) == this && var1.getBlock(var2 - 1, var3, var4) == this && var1.getBlock(var2 - 1, var3, var4 - 1) == this && var1.getBlock(var2 - 1, var3, var4 + 1) == this) {
                  var1.setBlock(var2, var3, var4, BlocksDBC.BlockDragonBallStone);
               }
            } else if(var1.getBlock(var2, var3, var4 + 1) == this && var1.getBlock(var2 + 1, var3, var4 + 1) == this && var1.getBlock(var2 + 1, var3, var4 - 1) == this && var1.getBlock(var2, var3, var4 - 1) == this && var1.getBlock(var2 - 1, var3, var4 - 1) == this && var1.getBlock(var2 - 1, var3, var4 + 1) == this) {
               var1.setBlock(var2, var3, var4, BlocksDBC.BlockDragonBallStone);
            }
         }

         return true;
      } else {
         return false;
      }
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

   public void addCreativeItems(ArrayList var1) {
      var1.add(new ItemStack(this, 1));
   }

   public int quantityDroppedWithBonus(int var1, Random var2) {
      return MathHelper.clamp_int(this.quantityDropped(var2) + var2.nextInt(var1 + 1), 1, 1);
   }

   public int quantityDropped(Random var1) {
      return 2 + var1.nextInt(3);
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
