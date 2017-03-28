package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockNamekLeaves extends BlockLeavesBase implements IShearable {
   int[] adjacentTreeBlocks;

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public BlockNamekLeaves(int var1) {
      super(Material.leaves, true);
      this.setTickRandomly(true);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public void addCreativeItems(ArrayList var1) {
      var1.add(new ItemStack(this, 1));
   }

   public int getRenderBlockPass() {
      return 0;
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public int getRenderColor(int var1) {
      return (var1 & 3) == 1?ColorizerFoliage.getFoliageColorPine():((var1 & 3) == 2?ColorizerFoliage.getFoliageColorBirch():ColorizerFoliage.getFoliageColorBasic());
   }

   public void onBlockRemoval(World var1, int var2, int var3, int var4) {
      byte var5 = 1;
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

   public int quantityDropped(Random var1) {
      return var1.nextInt(20) == 0?1:0;
   }

   public Item getItemDropped(int var1, Random var2, int var3) {
      return Item.getItemFromBlock(BlocksDBC.BlockNamekSapling);
   }

   public void harvestBlock(World var1, EntityPlayer var2, int var3, int var4, int var5, int var6) {
      super.harvestBlock(var1, var2, var3, var4, var5, var6);
   }

   public int damageDropped(int var1) {
      return var1 & 3;
   }

   public void onEntityWalking(World var1, int var2, int var3, int var4, Entity var5) {
      super.onEntityWalking(var1, var2, var3, var4, var5);
   }

   public boolean isShearable(ItemStack var1, IBlockAccess var2, int var3, int var4, int var5) {
      return true;
   }

   public ArrayList<ItemStack> onSheared(ItemStack var1, IBlockAccess var2, int var3, int var4, int var5, int var6) {
      ArrayList var7 = new ArrayList();
      var7.add(new ItemStack(this, 1, var2.getBlockMetadata(var3, var4, var5) & 3));
      return var7;
   }
}
