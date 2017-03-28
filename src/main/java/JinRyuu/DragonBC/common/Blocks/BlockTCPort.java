package JinRyuu.DragonBC.common.Blocks;

import JinRyuu.DragonBC.common.Worlds.WorldTeleporterDBCTelep;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTCPort extends Block {
   public BlockTCPort() {
      super(Material.iron);
      this.setBlockUnbreakable();
      this.setResistance(6000000.0F);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   @SideOnly(Side.CLIENT)
   public int getRenderBlockPass() {
      return 0;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean renderAsNormalBlock() {
      return false;
   }

   public boolean canCollideCheck(int var1, boolean var2) {
      return false;
   }

   public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
      return null;
   }

   public boolean isBlockSolid(IBlockAccess var1, int var2, int var3, int var4, int var5) {
      return false;
   }

   @SideOnly(Side.CLIENT)
   public void registerBlockIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public int idDropped(int var1, Random var2, int var3) {
      return 0;
   }

   public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5) {
      if(var5 != null && var5 instanceof EntityPlayerMP && var5.ridingEntity == null && var5.riddenByEntity == null) {
         EntityPlayerMP var6 = (EntityPlayerMP)var5;
         if(var6.dimension == 0 && var2 == 77 && var3 == 217 && var4 == 8) {
            short var7 = JRMCoreH.getShort(var6, "jrmcHTCTmO");
            short var8 = (short)JRMCoreH.getByte(var6, "jrmcMsg");
            if(var7 == 0) {
               var6.mcServer.getConfigurationManager().transferPlayerToDimension(var6, 23, new WorldTeleporterDBCTelep(var6.mcServer.worldServerForDimension(23)));
               var6.setPositionAndUpdate(55.0D, 35.0D, 11.0D);
               var6.addExperience(1);
            } else if(var8 == 0) {
               short var9 = (short)(var7 / 120);
               String var10 = JRMCoreH.cly + StatCollector.translateToLocal("dbc.timechamber.waitillenter");
               String var11 = JRMCoreH.cly + StatCollector.translateToLocal("dbc.timechamber.waitillenter.sec");
               String var12 = JRMCoreH.cly + StatCollector.translateToLocal("dbc.timechamber.waitillenter.min");
               String var13 = var9 <= 0?" " + var7 / 2 + " " + var11:" " + var9 + " " + var12;
               String var14 = String.format(JRMCoreH.cldr + var10, new Object[]{JRMCoreH.cldr + var13});
               var6.addChatMessage(new ChatComponentText(var14));
               JRMCoreH.setByte(1, var6, "jrmcMsg");
            }
         }

         if(var6.dimension == 23 && (var2 == 55 || var2 == 54) && var3 == 35 && var4 == 8) {
            var6.mcServer.getConfigurationManager().transferPlayerToDimension(var6, 0, new WorldTeleporterDBCTelep(var6.mcServer.worldServerForDimension(0)));
            var6.setPositionAndUpdate(77.5D, 217.0D, 10.5D);
            var6.addExperience(1);
         }
      }

   }
}
