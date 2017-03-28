package JinRyuu.DragonBC.common.Render;

import JinRyuu.DragonBC.common.mod_DragonBC;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DragonBlock01Item extends Item {
   private Block spawn;

   public DragonBlock01Item(Block var1) {
      this.spawn = var1;
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
      this.maxStackSize = 7;
   }

   public String getTextureFile() {
      return "jinryuudragonbc:dragonitems1.png";
   }

   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10) {
      if(var3.getBlock(var4, var5, var6) != Blocks.snow) {
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

         if(!var3.isAirBlock(var4, var5, var6)) {
            return false;
         }
      }

      if(!var2.canPlayerEdit(var4, var5, var6, var7, var1)) {
         return false;
      } else {
         if(this.spawn != null && this.spawn.canPlaceBlockAt(var3, var4, var5, var6)) {
            --var1.stackSize;
            var3.setBlock(var4, var5, var6, this.spawn);
         }

         return true;
      }
   }
}
