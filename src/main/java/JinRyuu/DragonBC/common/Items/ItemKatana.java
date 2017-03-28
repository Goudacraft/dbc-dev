package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;

public class ItemKatana extends ItemSword {
   public ItemKatana(ToolMaterial var1) {
      super(var1);
      this.setMaxDamage(300);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public ItemStack onItemRightClick(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10) {
      if(var1.getItemDamage() == 15) {
         Block var11 = var3.getBlock(var4, var5, var6);
         if(var11 == BlocksDBC.BlockNamekSapling && !var3.isRemote) {
            --var1.stackSize;
         }
      }

      return var1;
   }
}
