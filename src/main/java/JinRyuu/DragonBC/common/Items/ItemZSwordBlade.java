package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Items.ItemsDBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;

public class ItemZSwordBlade extends ItemSword {
   public ItemZSwordBlade(ToolMaterial var1) {
      super(var1);
      this.setMaxDamage(100);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + ItemsDBC.ItemBraveSwordBlade.getUnlocalizedName());
   }
}
