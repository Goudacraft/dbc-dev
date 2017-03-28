package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
import JinRyuu.DragonBC.common.Render.SaibaiHatchedTileEntity;
import java.util.Random;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SaibaiHatchedBlock extends BlockContainer {
   private Class SaibaiHatchedTileEntity = SaibaiHatchedTileEntity.class;
   int port1 = 0;

   public SaibaiHatchedBlock() {
      super(Material.rock);
      this.setTickRandomly(true);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public void registerIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public int idDropped(int var1, Random var2, int var3) {
      return 0;
   }

   public int quanityDropped(Random var1) {
      return 0;
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
      if(var5.capabilities.isCreativeMode) {
         EntitySaibaiman var10 = new EntitySaibaiman(var1);
         var10.setLocationAndAngles((double)var2 + 0.5D, (double)(var3 + 1), (double)var4 + 0.5D, 0.0F, 0.0F);
         if(!var1.isRemote) {
            var1.spawnEntityInWorld(var10);
         }
      }

      return true;
   }

   public TileEntity createNewTileEntity(World var1, int var2) {
      return new SaibaiHatchedTileEntity();
   }
}
