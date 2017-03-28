package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.DBCMaterial;
import JinRyuu.DragonBC.common.Render.MedPodDoor1TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MedPodDoor1Block extends BlockContainer {
   private Class MedPodDoor1TileEntity;

   public MedPodDoor1Block() {
      super(DBCMaterial.dragonblock);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
      this.MedPodDoor1TileEntity = MedPodDoor1TileEntity.class;
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public void registerIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
      int var5 = var1.getBlockMetadata(var2, var3, var4);
      return isFenceGateOpen(var5)?null:(var5 != 2 && var5 != 0?AxisAlignedBB.getBoundingBox((double)((float)var2 + 0.375F), (double)var3, (double)var4, (double)((float)var2 + 0.625F), (double)((float)var3 + 1.5F), (double)(var4 + 1)):AxisAlignedBB.getBoundingBox((double)var2, (double)var3, (double)((float)var4 + 0.375F), (double)(var2 + 1), (double)((float)var3 + 1.5F), (double)((float)var4 + 0.625F)));
   }

   public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
      int var5 = this.getDirection(var1.getBlockMetadata(var2, var3, var4));
      if(var5 != 2 && var5 != 0) {
         this.setBlockBounds(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
      } else {
         this.setBlockBounds(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
      }

   }

   public boolean getBlocksMovement(IBlockAccess var1, int var2, int var3, int var4) {
      return isFenceGateOpen(var1.getBlockMetadata(var2, var3, var4));
   }

   public void onBlockPlacedBy(World var1, int var2, int var3, int var4, EntityLivingBase var5, ItemStack var6) {
      int var7 = (MathHelper.floor_double((double)(var5.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;
      var1.setBlockMetadataWithNotify(var2, var3, var4, var7, 2);
   }

   public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9) {
      TileEntity var10 = var1.getTileEntity(var2, var3, var4);
      if(var10 != null && !var5.isSneaking()) {
         Block var11 = var1.getBlock(var2, var3 + 1, var4);
         Block var12 = var1.getBlock(var2, var3 - 1, var4);
         int var13 = var1.getBlockMetadata(var2, var3, var4);
         var1.getBlockMetadata(var2, var3 + 1, var4);
         var1.getBlockMetadata(var2, var3 - 1, var4);
         if(isFenceGateOpen(var13)) {
            var1.playSoundEffect((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "jinryuudragonbc:150724.MedPodDoor1", 1.0F, var1.rand.nextFloat() * 0.1F + 0.8F);
            int var16 = var13 - 4;
            var1.setBlockMetadataWithNotify(var2, var3, var4, var16, 2);
            if(var11 == this) {
               var1.setBlockMetadataWithNotify(var2, var3 + 1, var4, var16, 2);
            }

            if(var12 == this) {
               var1.setBlockMetadataWithNotify(var2, var3 - 1, var4, var16, 2);
            }
         } else {
            var1.playSoundEffect((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "jinryuudragonbc:150724.MedPodDoor1", 1.0F, var1.rand.nextFloat() * 0.1F + 0.9F);
            int var17 = var13 + 4;
            var1.setBlockMetadataWithNotify(var2, var3, var4, var17, 2);
            if(var11 == this) {
               var1.setBlockMetadataWithNotify(var2, var3 + 1, var4, var17, 2);
            }

            if(var12 == this) {
               var1.setBlockMetadataWithNotify(var2, var3 - 1, var4, var17, 2);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public int getDirection(int var1) {
      return var1 & 3;
   }

   public void onNeighborBlockChange(World var1, int var2, int var3, int var4, Block var5) {
      if(!var1.isRemote) {
         int var6 = var1.getBlockMetadata(var2, var3, var4);
         boolean var7 = var1.isBlockIndirectlyGettingPowered(var2, var3, var4) || var1.isBlockIndirectlyGettingPowered(var2, var3 + 1, var4) || var1.isBlockIndirectlyGettingPowered(var2, var3 - 1, var4);
         if(var7 || var5.canProvidePower()) {
            Block var8 = var1.getBlock(var2, var3 + 1, var4);
            Block var9 = var1.getBlock(var2, var3 - 1, var4);
            int var10 = var1.getBlockMetadata(var2, var3, var4);
            var1.getBlockMetadata(var2, var3 + 1, var4);
            var1.getBlockMetadata(var2, var3 - 1, var4);
            if(var7 && !isFenceGateOpen(var6)) {
               var1.playSoundEffect((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "jinryuudragonbc:150724.MedPodDoor1", 1.0F, var1.rand.nextFloat() * 0.1F + 0.9F);
               int var15 = var10 + 4;
               var1.setBlockMetadataWithNotify(var2, var3, var4, var15, 2);
               if(var8 == this) {
                  var1.setBlockMetadataWithNotify(var2, var3 + 1, var4, var15, 2);
               }

               if(var9 == this) {
                  var1.setBlockMetadataWithNotify(var2, var3 - 1, var4, var15, 2);
               }
            } else if(!var7 && isFenceGateOpen(var6)) {
               var1.playSoundEffect((double)var2 + 0.5D, (double)var3 + 0.5D, (double)var4 + 0.5D, "jinryuudragonbc:150724.MedPodDoor1", 1.0F, var1.rand.nextFloat() * 0.1F + 0.8F);
               int var13 = var10 - 4;
               var1.setBlockMetadataWithNotify(var2, var3, var4, var13, 2);
               TileEntity var14 = var1.getTileEntity(var2, var3, var4);
               if(var14 instanceof MedPodDoor1TileEntity) {
                  ((MedPodDoor1TileEntity)var14).setCb(21);
               }

               if(var8 == this) {
                  var1.setBlockMetadataWithNotify(var2, var3 + 1, var4, var13, 2);
                  var14 = var1.getTileEntity(var2, var3 + 1, var4);
                  if(var14 instanceof MedPodDoor1TileEntity) {
                     ((MedPodDoor1TileEntity)var14).setCb(21);
                  }
               }

               if(var9 == this) {
                  var1.setBlockMetadataWithNotify(var2, var3 - 1, var4, var13, 2);
                  var14 = var1.getTileEntity(var2, var3 - 1, var4);
                  if(var14 instanceof MedPodDoor1TileEntity) {
                     ((MedPodDoor1TileEntity)var14).setCb(21);
                  }
               }
            }
         }
      }

   }

   public static boolean isFenceGateOpen(int var0) {
      return (var0 & 4) != 0;
   }

   public int quanityDropped(Random var1) {
      return 1;
   }

   public int getRenderType() {
      return -1;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean renderAsNormalBlock() {
      return false;
   }

   public void breakBlock(World var1, int var2, int var3, int var4, Block var5, int var6) {
      super.breakBlock(var1, var2, var3, var4, var5, var6);
   }

   public TileEntity createNewTileEntity(World var1, int var2) {
      return new MedPodDoor1TileEntity();
   }

   @SideOnly(Side.CLIENT)
   public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5) {
      return true;
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }
}
