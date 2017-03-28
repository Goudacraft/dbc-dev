package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Render.KintounEntity;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class KintounItem extends Item {
   public KintounItem() {
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
      this.maxStackSize = 1;
   }

   public String getTextureFile() {
      return "jinryuudragonbc:dragonitems1.png";
   }

   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10) {
      if(var7 == 0) {
         --var5;
      }

      if(var7 == 1) {
         ++var5;
      }

      if(var7 == 2) {
         --var6;
      }

      if(var7 == 3) {
         ++var6;
      }

      if(var7 == 4) {
         --var4;
      }

      if(var7 == 5) {
         ++var4;
      }

      if(!var2.canPlayerEdit(var4, var5, var6, var7, var1)) {
         return false;
      } else {
         if(!var3.isRemote) {
            var2.inventory.consumeInventoryItem(this);
            var2.inventory.inventoryChanged = true;
            var2.inventory.inventoryChanged = false;
            KintounEntity var11 = new KintounEntity(var3);
            var11.setLocationAndAngles((double)var4, (double)(var5 + 1), (double)var6, var2.rotationYaw, 0.0F);
            var3.spawnEntityInWorld(var11);
         }

         return true;
      }
   }
}
