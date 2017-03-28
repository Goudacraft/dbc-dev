package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockNamekLog extends Block {
   @SideOnly(Side.CLIENT)
   private IIcon iconGrassTop;
   @SideOnly(Side.CLIENT)
   private IIcon iconSnowSide;
   @SideOnly(Side.CLIENT)
   private IIcon iconGrassSideOverlay;

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public void addCreativeItems(ArrayList var1) {
      var1.add(new ItemStack(this, 1));
   }

   public BlockNamekLog() {
      super(Material.wood);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int var1, int var2) {
      return var1 == 1?this.iconGrassTop:(var1 == 0?this.iconGrassTop:this.blockIcon);
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(IBlockAccess var1, int var2, int var3, int var4, int var5) {
      return var5 == 1?this.iconGrassTop:(var5 == 0?this.iconGrassTop:this.blockIcon);
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName() + "Side");
      this.iconGrassTop = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName() + "Top");
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean renderAsNormalBlock() {
      return false;
   }

   public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4) {
      float var5 = 0.375F;
      float var6 = 0.625F;
      float var7 = 0.375F;
      float var8 = 0.625F;
      this.setBlockBounds(var5, 0.0F, var7, var6, 1.0F, var8);
   }

   public int quantityDropped(Random var1) {
      return 1;
   }

   public void harvestBlock(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6) {
      super.harvestBlock(var1, var2, var3, var4, var5, var6);
   }

   public void onBlockRemoval(World var1, int var2, int var3, int var4) {
      byte var5 = 4;
      int var6 = var5 + 1;
      if(var1.checkChunksExist(var2 - var6, var3 - var6, var4 - var6, var2 + var6, var3 + var6, var4 + var6)) {
         for(int var7 = -var5; var7 <= var5; ++var7) {
            for(int var8 = -var5; var8 <= var5; ++var8) {
               for(int var9 = -var5; var9 <= var5; ++var9) {
                  Block var10 = var1.getBlock(var2 + var7, var3 + var8, var4 + var9);
                  if(var10 != null) {
                     var10.beginLeavesDecay(var1, var2 + var7, var3 + var8, var4 + var9);
                  }
               }
            }
         }
      }

   }

   public boolean getBlocksMovement(IBlockAccess var1, int var2, int var3, int var4) {
      return false;
   }

   public int damageDropped(int var1) {
      return var1;
   }

   public boolean canSustainLeaves(World var1, int var2, int var3, int var4) {
      return true;
   }

   public boolean isWood(World var1, int var2, int var3, int var4) {
      return true;
   }
}
