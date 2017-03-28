package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSaibaiSeed extends Item {
   private boolean alwaysEdible;
   private int ticker = 0;

   public ItemSaibaiSeed() {
      this.setMaxDamage(1);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   @SideOnly(Side.CLIENT)
   public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4) {
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public ItemStack onEaten(ItemStack var1, World var2, EntityPlayer var3) {
      return var1;
   }

   public int getMaxItemUseDuration(ItemStack var1) {
      return 72000;
   }

   public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10) {
      if(var3.getBlock(var4, var5, var6) != null) {
         if(!var3.isRemote && this.ticker == 0) {
            EntitySaibaiman var11 = new EntitySaibaiman(var3);
            var11.setWorld(var2.worldObj);
            var11.setLocationAndAngles((double)((float)var4 + 0.5F), (double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), 0.0F, 0.0F);
            var11.setSpwner(var2);
            var3.spawnEntityInWorld(var11);
            this.ticker = 20;
            --var1.stackSize;
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public void onUpdate(ItemStack var1, World var2, Entity var3, int var4, boolean var5) {
      if(!var2.isRemote && this.ticker > 0) {
         --this.ticker;
      }

   }

   public EnumAction getItemUseAction(ItemStack var1) {
      return EnumAction.none;
   }
}
