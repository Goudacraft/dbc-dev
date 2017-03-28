package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Render.SpacePod01TileEntity;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class SpacePod01Block extends BlockContainer {
   private Class SpacePod01TileEntity;
   int port1 = 0;

   public SpacePod01Block() {
      super(Material.tnt);
      float var1 = 0.4F;
      this.setBlockBounds(-0.5F, 0.0F, -0.5F, 1.5F, 2.0F, 1.5F);
      this.SpacePod01TileEntity = SpacePod01TileEntity.class;
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public void registerIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
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

   public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
      return null;
   }

   public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5) {
      if(var5.ridingEntity == null && var5.riddenByEntity == null && var5 instanceof EntityPlayerMP) {
         EntityPlayerMP var6 = (EntityPlayerMP)var5;
         ++this.port1;
      }

   }

   public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9) {
      TileEntity var10 = var1.getTileEntity(var2, var3, var4);
      if(var10 != null && !var5.isSneaking()) {
         var5.inventory.addItemStackToInventory(new ItemStack(ItemsDBC.SpacePod01Item, 1));
         var5.openGui(mod_DragonBC.instance, 0, var1, var2, var3, var4);
         return true;
      } else {
         return false;
      }
   }

   private void dropItems(World var1, int var2, int var3, int var4) {
      Random var5 = new Random();
      TileEntity var6 = var1.getTileEntity(var2, var3, var4);
      if(var6 instanceof IInventory) {
         IInventory var7 = (IInventory)var6;

         for(int var8 = 0; var8 < var7.getSizeInventory(); ++var8) {
            ItemStack var9 = var7.getStackInSlot(var8);
            if(var9 != null && var9.stackSize > 0) {
               float var10 = var5.nextFloat() * 0.6F + 0.1F;
               float var11 = var5.nextFloat() * 0.6F + 0.1F;
               float var12 = var5.nextFloat() * 0.6F + 0.1F;
               EntityItem var13 = new EntityItem(var1, (double)((float)var2 + var10), (double)((float)var3 + var11), (double)((float)var4 + var12), var9);
               if(var9.hasTagCompound()) {
                  var9.setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
               }

               float var14 = 0.5F;
               var13.motionX = var5.nextGaussian() * (double)var14;
               var13.motionY = var5.nextGaussian() * (double)var14 + 0.20000000298023224D;
               var13.motionZ = var5.nextGaussian() * (double)var14;
               var1.spawnEntityInWorld(var13);
               var9.stackSize = 0;
            }
         }

      }
   }

   public TileEntity createNewTileEntity(World var1, int var2) {
      return new SpacePod01TileEntity();
   }
}
