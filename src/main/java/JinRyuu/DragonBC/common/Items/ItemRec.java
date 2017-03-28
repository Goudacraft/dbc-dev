package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.JRMCoreH;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemRec extends ItemRecord {
   public ItemRec(String var1) {
      super(var1);
      this.maxStackSize = 1;
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon(JRMCoreH.tjdbcAssts + ":" + this.getUnlocalizedName());
   }

   public EnumRarity getRarity(ItemStack var1) {
      return EnumRarity.rare;
   }

   public ResourceLocation getRecordResource(String var1) {
      return new ResourceLocation(JRMCoreH.tjdbcAssts + ":" + var1);
   }
}
