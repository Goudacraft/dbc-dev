package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Worlds.WorldGenNamekTrees;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockNamekSapling extends BlockSapling {
   private IIcon BSide;
   private IIcon BTop;
   private IIcon BBottom;
   private String side = "ajisasapling";
   private String top = "namekgrasstop";
   private String bottom = "lightdirt";
   public static final String[] WOOD_TYPES = new String[]{"namek"};

   public BlockNamekSapling() {
      float var1 = 0.4F;
      this.setBlockBounds(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var1 * 2.0F, 0.5F + var1);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
      if(!var1.isRemote) {
         super.updateTick(var1, var2, var3, var4, var5);
         System.out.println(var1.getBlockLightValue(var2, var3 + 1, var4));
         if(var1.getBlockLightValue(var2, var3 + 1, var4) >= 9 && var5.nextInt(7) == 0) {
            this.func_149879_c(var1, var2, var3, var4, var5);
         }
      }

   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public boolean isSameSapling(World var1, int var2, int var3, int var4, int var5) {
      return var1.getBlock(var2, var3, var4) == this && (var1.getBlockMetadata(var2, var3, var4) & 3) == var5;
   }

   protected boolean canPlaceBlockOn(Block var1) {
      return var1 == BlocksDBC.BlockNamekGrass;
   }

   protected boolean canThisPlantGrowOnThisBlockID(Block var1) {
      return var1 == BlocksDBC.BlockNamekGrass;
   }

   public void func_149878_d(World var1, int var2, int var3, int var4, Random var5) {
      System.out.println("test3");
      if(TerrainGen.saplingGrowTree(var1, var5, var2, var3, var4)) {
         int var6 = var1.getBlockMetadata(var2, var3, var4) & 3;
         WorldGenNamekTrees var7 = null;
         var7 = new WorldGenNamekTrees(true);
         if(!var7.generate(var1, var5, var2, var3, var4)) {
            ;
         }

      }
   }

   public int damageDropped(int var1) {
      return var1 & 3;
   }

   public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
      return null;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean renderAsNormalBlock() {
      return false;
   }

   public void func_149879_c(World var1, int var2, int var3, int var4, Random var5) {
      System.out.println("test");
      int var6 = var1.getBlockMetadata(var2, var3, var4);
      if((var6 & 8) == 0) {
         var1.setBlockMetadataWithNotify(var2, var3, var4, var6 | 8, 4);
      } else {
         this.func_149878_d(var1, var2, var3, var4, var5);
      }

   }

   public int getRenderType() {
      return 1;
   }

   public boolean func_149851_a(World var1, int var2, int var3, int var4, boolean var5) {
      return true;
   }

   public boolean func_149852_a(World var1, Random var2, int var3, int var4, int var5) {
      return (double)var1.rand.nextFloat() < 0.45D;
   }

   public void func_149853_b(World var1, Random var2, int var3, int var4, int var5) {
      this.func_149879_c(var1, var3, var4, var5, var2);
   }
}
