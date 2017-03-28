package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemNamekChip extends Item {
   private Minecraft var2;
   int slot;

   public ItemNamekChip() {
      this.maxStackSize = 2;
      this.setMaxDamage(1);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public void onPlayerStoppedUsing(ItemStack var1, World var2x, EntityPlayer var3, int var4) {
      int var5 = this.getMaxItemUseDuration(var1) - var4;
      ArrowLooseEvent var6 = new ArrowLooseEvent(var3, var1, var5);
      MinecraftForge.EVENT_BUS.post(var6);
      if(!var6.isCanceled()) {
         var5 = var6.charge;
         if(var3.isInsideOfMaterial(Material.portal)) {
            var2x.destroyBlockInWorldPartially((int)var3.posX, (int)var3.posY, (int)var3.posZ, 1, 1);
            if(var3 instanceof EntityPlayerMP) {
               EntityPlayerMP var7 = (EntityPlayerMP)var3;
               if(var7.dimension == 0) {
                  ;
               }
            }
         }

      }
   }

   public ItemStack onFoodEaten(ItemStack var1, World var2x, EntityPlayer var3) {
      return var1;
   }

   public int getMaxItemUseDuration(ItemStack var1) {
      return 72000;
   }

   public EnumAction getItemUseAction(ItemStack var1) {
      return EnumAction.bow;
   }

   public ItemStack onItemRightClick(ItemStack var1, World var2x, EntityPlayer var3) {
      ArrowNockEvent var4 = new ArrowNockEvent(var3, var1);
      MinecraftForge.EVENT_BUS.post(var4);
      if(var4.isCanceled()) {
         return var4.result;
      } else {
         if(var3.capabilities.isCreativeMode) {
            var3.setItemInUse(var1, this.getMaxItemUseDuration(var1));
         }

         return var1;
      }
   }

   public int getItemEnchantability() {
      return 1;
   }
}
