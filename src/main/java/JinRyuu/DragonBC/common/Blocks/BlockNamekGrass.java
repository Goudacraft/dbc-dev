package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockNamekGrass extends Block {
   @SideOnly(Side.CLIENT)
   private IIcon iconGrassTop;
   @SideOnly(Side.CLIENT)
   private IIcon iconSnowSide;
   @SideOnly(Side.CLIENT)
   private IIcon iconGrassSideOverlay;

   public BlockNamekGrass() {
      super(Material.grass);
      this.setTickRandomly(true);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
      this.setHarvestLevel("shovel", 0);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public void addCreativeItems(ArrayList var1) {
      var1.add(new ItemStack(this, 1));
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(int var1, int var2) {
      return var1 == 1?this.iconGrassTop:(var1 == 0?BlocksDBC.BlockNamekDirt.getBlockTextureFromSide(var1):this.blockIcon);
   }

   @SideOnly(Side.CLIENT)
   public IIcon getIcon(IBlockAccess var1, int var2, int var3, int var4, int var5) {
      return var5 == 1?this.iconGrassTop:(var5 == 0?BlocksDBC.BlockNamekDirt.getBlockTextureFromSide(var5):this.blockIcon);
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName() + "Side");
      this.iconGrassTop = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName() + "Top");
   }

   public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
      if(!var1.isRemote) {
         if(var1.getBlockLightValue(var2, var3 + 1, var4) < 4 && var1.getBlockLightOpacity(var2, var3 + 1, var4) > 2) {
            var1.setBlock(var2, var3, var4, BlocksDBC.BlockNamekDirt);
         } else if(var1.getBlockLightValue(var2, var3 + 1, var4) >= 9) {
            for(int var6 = 0; var6 < 4; ++var6) {
               int var7 = var2 + var5.nextInt(3) - 1;
               int var8 = var3 + var5.nextInt(5) - 3;
               int var9 = var4 + var5.nextInt(3) - 1;
               var1.getBlock(var7, var8 + 1, var9);
               if((var1.getBlock(var7, var8, var9) == BlocksDBC.BlockNamekDirt || var1.getBlock(var7, var8, var9) == Blocks.dirt) && var1.getBlockMetadata(var7, var8, var9) == 0 && var1.getBlockLightValue(var7, var8 + 1, var9) >= 4 && var1.getBlockLightOpacity(var7, var8 + 1, var9) <= 2) {
                  var1.setBlock(var7, var8, var9, BlocksDBC.BlockNamekGrass);
               }
            }
         }
      }

   }

   public Item getItemDropped(int var1, Random var2, int var3) {
      return BlocksDBC.BlockNamekDirt.getItemDropped(0, var2, var3);
   }
}
