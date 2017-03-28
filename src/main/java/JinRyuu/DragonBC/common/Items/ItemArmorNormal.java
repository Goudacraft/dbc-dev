package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.IIcon;

public class ItemArmorNormal extends ItemArmor {
   public String armorNamePrefix;
   public ArmorMaterial material;
   @SideOnly(Side.CLIENT)
   public IIcon field_94604_cx1;
   private IIcon overlayIcon;
   private IIcon emptySlotIcon;
   private static final String[] CLOTH_OVERLAY_NAMES = new String[]{"leather_helmet_overlay", "leather_chestplate_overlay", "leather_leggings_overlay", "leather_boots_overlay"};

   public ItemArmorNormal(ArmorMaterial var1, int var2, int var3, String var4) {
      super(var1, var2, var3);
      this.material = var1;
      var1.getDamageReductionAmount(var3);
      this.setMaxDamage(var1.getDurability(var3));
      this.maxStackSize = 1;
      this.armorNamePrefix = var4;
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName().replaceAll("item.", "").toLowerCase());
      this.field_94604_cx1 = var1.registerIcon(EMPTY_SLOT_NAMES[this.armorType]);
      if(this.material == ArmorMaterial.CLOTH) {
         this.overlayIcon = var1.registerIcon(CLOTH_OVERLAY_NAMES[this.armorType]);
      }

      this.emptySlotIcon = var1.registerIcon(EMPTY_SLOT_NAMES[this.armorType]);
   }

   public String getArmorTexture(ItemStack var1, Entity var2, int var3, String var4) {
      String var5 = "";
      if(!var1.toString().toLowerCase().contains("pants") && !var1.toString().toLowerCase().contains("leg")) {
         var5 = "jinryuudragonbc:armor/" + this.armorNamePrefix + "_1" + ".png";
      } else {
         var5 = "jinryuudragonbc:armor/" + this.armorNamePrefix + "_2" + ".png";
      }

      return var5;
   }
}
