package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockHealingPods extends BlockFluidClassic {
   @SideOnly(Side.CLIENT)
   protected IIcon stillIcon;
   @SideOnly(Side.CLIENT)
   protected IIcon flowingIcon;

   public BlockHealingPods(Fluid var1, Material var2) {
      super(var1, var2);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public IIcon getIcon(int var1, int var2) {
      return var1 != 0 && var1 != 1?this.flowingIcon:this.stillIcon;
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.stillIcon = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + this.getUnlocalizedName() + "Still");
      this.flowingIcon = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + this.getUnlocalizedName() + "Flowing");
   }

   public boolean canDisplace(IBlockAccess var1, int var2, int var3, int var4) {
      return var1.getBlock(var2, var3, var4).getMaterial().isLiquid()?false:super.canDisplace(var1, var2, var3, var4);
   }

   public boolean displaceIfPossible(World var1, int var2, int var3, int var4) {
      return var1.getBlock(var2, var3, var4).getMaterial().isLiquid()?false:super.displaceIfPossible(var1, var2, var3, var4);
   }

   @SideOnly(Side.CLIENT)
   public void randomDisplayTick(World var1, int var2, int var3, int var4, Random var5) {
      if(this.blockMaterial == Material.water) {
         if(var5.nextInt(10) == 0) {
            int var6 = var1.getBlockMetadata(var2, var3, var4);
            if(var6 <= 0 || var6 >= 8) {
               var1.spawnParticle("suspended", (double)((float)var2 + var5.nextFloat()), (double)((float)var3 + var5.nextFloat()), (double)((float)var4 + var5.nextFloat()), 0.0D, 0.0D, 0.0D);
            }
         }

         for(int var21 = 0; var21 < 0; ++var21) {
            int var7 = var5.nextInt(4);
            int var8 = var2;
            int var9 = var4;
            if(var7 == 0) {
               var8 = var2 - 1;
            }

            if(var7 == 1) {
               ++var8;
            }

            if(var7 == 2) {
               var9 = var4 - 1;
            }

            if(var7 == 3) {
               ++var9;
            }

            if(var1.getBlock(var8, var3, var9).getMaterial() == Material.air && (var1.getBlock(var8, var3 - 1, var9).getMaterial().blocksMovement() || var1.getBlock(var8, var3 - 1, var9).getMaterial().isLiquid())) {
               float var10 = 0.0625F;
               double var11 = (double)((float)var2 + var5.nextFloat());
               double var13 = (double)((float)var3 + var5.nextFloat());
               double var15 = (double)((float)var4 + var5.nextFloat());
               if(var7 == 0) {
                  var11 = (double)((float)var2 - var10);
               }

               if(var7 == 1) {
                  var11 = (double)((float)(var2 + 1) + var10);
               }

               if(var7 == 2) {
                  var15 = (double)((float)var4 - var10);
               }

               if(var7 == 3) {
                  var15 = (double)((float)(var4 + 1) + var10);
               }

               double var17 = 0.0D;
               double var19 = 0.0D;
               if(var7 == 0) {
                  var17 = (double)(-var10);
               }

               if(var7 == 1) {
                  var17 = (double)var10;
               }

               if(var7 == 2) {
                  var19 = (double)(-var10);
               }

               if(var7 == 3) {
                  var19 = (double)var10;
               }

               var1.spawnParticle("splash", var11, var13, var15, var17, 0.0D, var19);
            }
         }
      }

      if(this.blockMaterial == Material.water && var5.nextInt(64) == 0) {
         int var22 = var1.getBlockMetadata(var2, var3, var4);
         if(var22 > 0 && var22 < 8) {
            var1.playSound((double)((float)var2 + 0.5F), (double)((float)var3 + 0.5F), (double)((float)var4 + 0.5F), "liquid.water", var5.nextFloat() * 0.25F + 0.75F, var5.nextFloat() * 1.0F + 0.5F, false);
         }
      }

      if(this.blockMaterial == Material.lava && var1.getBlock(var2, var3 + 1, var4).getMaterial() == Material.air && !var1.getBlock(var2, var3 + 1, var4).isOpaqueCube()) {
         if(var5.nextInt(100) == 0) {
            double var23 = (double)((float)var2 + var5.nextFloat());
            double var25 = (double)var3 + this.maxY;
            double var27 = (double)((float)var4 + var5.nextFloat());
            var1.spawnParticle("lava", var23, var25, var27, 0.0D, 0.0D, 0.0D);
            var1.playSound(var23, var25, var27, "liquid.lavapop", 0.2F + var5.nextFloat() * 0.2F, 0.9F + var5.nextFloat() * 0.15F, false);
         }

         if(var5.nextInt(200) == 0) {
            var1.playSound((double)var2, (double)var3, (double)var4, "liquid.lava", 0.2F + var5.nextFloat() * 0.2F, 0.9F + var5.nextFloat() * 0.15F, false);
         }
      }

      if(var5.nextInt(10) == 0 && World.doesBlockHaveSolidTopSurface(var1, var2, var3 - 1, var4) && !var1.getBlock(var2, var3 - 2, var4).getMaterial().blocksMovement()) {
         double var24 = (double)((float)var2 + var5.nextFloat());
         double var26 = (double)var3 - 1.05D;
         double var28 = (double)((float)var4 + var5.nextFloat());
         if(this.blockMaterial == Material.water) {
            var1.spawnParticle("dripWater", var24, var26, var28, 0.0D, 0.0D, 0.0D);
         } else {
            var1.spawnParticle("dripLava", var24, var26, var28, 0.0D, 0.0D, 0.0D);
         }
      }

   }
}
