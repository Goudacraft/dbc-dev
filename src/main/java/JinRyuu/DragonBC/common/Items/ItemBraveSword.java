package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;

public class ItemBraveSword extends ItemSword {
   private float weaponDamage;

   public ItemBraveSword(ToolMaterial var1) {
      super(var1);
      this.setMaxDamage(600);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
      this.weaponDamage = 1.0F;
   }

   public void onUpdate(ItemStack var1, World var2, Entity var3, int var4, boolean var5) {
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public Multimap getItemAttributeModifiers() {
      Multimap var1 = super.getItemAttributeModifiers();
      var1.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.weaponDamage, 0));
      return var1;
   }
}
