package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Render.ArtGravDevTileEntity;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ArtGravDevBlock extends BlockContainer {
   private final Random field_149933_a = new Random();
   private Class ArtGravDevTileEntity = ArtGravDevTileEntity.class;

   public ArtGravDevBlock() {
      super(Material.iron);
      this.setHardness(3.0F);
      this.setResistance(5.0F);
      this.setTickRandomly(true);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   @SideOnly(Side.CLIENT)
   public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4) {
      var3.add(JRMCoreH.trl("dbc", "ArtGravDevDesc"));
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
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

   public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
   }

   public int tickRate(World var1) {
      return 1;
   }

   public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9) {
      TileEntity var10 = var1.getTileEntity(var2, var3, var4);
      if(var10 != null && !var5.isSneaking()) {
         var5.openGui(mod_DragonBC.instance, 5, var1, var2, var3, var4);
         return true;
      } else {
         return false;
      }
   }

   public TileEntity createNewTileEntity(World var1, int var2) {
      return new ArtGravDevTileEntity();
   }

   public static void updateFurnaceBlockState(boolean var0, World var1, int var2, int var3, int var4) {
      int var5 = var1.getBlockMetadata(var2, var3, var4);
      TileEntity var6 = var1.getTileEntity(var2, var3, var4);
      if(var0) {
         var1.setBlock(var2, var3, var4, BlocksDBC.ArtGravDevBlock);
      } else {
         var1.setBlock(var2, var3, var4, BlocksDBC.ArtGravDevBlock);
      }

      var1.setBlockMetadataWithNotify(var2, var3, var4, var5, 2);
      if(var6 != null) {
         var6.validate();
         var1.setTileEntity(var2, var3, var4, var6);
      }

   }

   public void breakBlock(World var1, int var2, int var3, int var4, Block var5, int var6) {
      ArtGravDevTileEntity var7 = (ArtGravDevTileEntity)var1.getTileEntity(var2, var3, var4);
      if(var7 != null) {
         for(int var8 = 0; var8 < var7.getSizeInventory(); ++var8) {
            ItemStack var9 = var7.getStackInSlot(var8);
            if(var9 != null) {
               float var10 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
               float var11 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;
               float var12 = this.field_149933_a.nextFloat() * 0.8F + 0.1F;

               while(var9.stackSize > 0) {
                  int var13 = this.field_149933_a.nextInt(21) + 10;
                  if(var13 > var9.stackSize) {
                     var13 = var9.stackSize;
                  }

                  var9.stackSize -= var13;
                  EntityItem var14 = new EntityItem(var1, (double)((float)var2 + var10), (double)((float)var3 + var11), (double)((float)var4 + var12), new ItemStack(var9.getItem(), var13, var9.getItemDamage()));
                  if(var9.hasTagCompound()) {
                     var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
                  }

                  float var15 = 0.05F;
                  var14.motionX = (double)((float)this.field_149933_a.nextGaussian() * var15);
                  var14.motionY = (double)((float)this.field_149933_a.nextGaussian() * var15 + 0.2F);
                  var14.motionZ = (double)((float)this.field_149933_a.nextGaussian() * var15);
                  var1.spawnEntityInWorld(var14);
               }
            }
         }

         var1.func_147453_f(var2, var3, var4, var5);
      }

      super.breakBlock(var1, var2, var3, var4, var5, var6);
   }
}
