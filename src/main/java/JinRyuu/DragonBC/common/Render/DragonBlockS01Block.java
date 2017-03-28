package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import JinRyuu.DragonBC.common.Blocks.DBCMaterial;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import JinRyuu.DragonBC.common.Render.DragonBlockS01TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class DragonBlockS01Block extends BlockContainer {
   private Class DragonBlockS01TileEntity = DragonBlockS01TileEntity.class;
   private static int tickDragonBall = 0;
   int port1 = 0;

   public DragonBlockS01Block() {
      super(DBCMaterial.dragonblock);
      this.setTickRandomly(true);
      this.setHardness(0.1F);
      float var1 = 0.2F;
      this.setBlockBounds(0.5F - var1, 0.2F - var1, 0.5F - var1, 0.5F + var1, 0.2F + var1, 0.5F + var1);
   }

   public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
      if(!var1.isRemote && var5.nextInt(5) == 0) {
         var1.setBlock(var2, var3, var4, BlocksDBC.BlockDragonBall);
      }

   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public void registerIcons(IIconRegister var1) {
      this.blockIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public ItemStack getPickBlock(MovingObjectPosition var1, World var2, int var3, int var4, int var5) {
      Item var6 = ItemsDBC.ItemDragonBlock;
      Object var7 = var6 instanceof ItemBlock && !this.isFlowerPot()?Block.getBlockFromItem(var6):this;
      return new ItemStack(var6, 1, ((Block)var7).getDamageValue(var2, var3, var4, var5));
   }

   @SideOnly(Side.CLIENT)
   public Item getItem(World var1, int var2, int var3, int var4) {
      return ItemsDBC.ItemDragonBlock;
   }

   public Item getItemDropped(int var1, Random var2, int var3) {
      return ItemsDBC.ItemDragonBlock;
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
      return var10 != null && !var5.isSneaking();
   }

   public void breakBlock(World var1, int var2, int var3, int var4, Block var5, int var6) {
      super.breakBlock(var1, var2, var3, var4, var5, var6);
   }

   public TileEntity createNewTileEntity(World var1, int var2) {
      return new DragonBlockS01TileEntity();
   }
}
