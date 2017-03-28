package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemDragonRadar extends Item {
   public static String test = "test";
   private Map<String, Properties> modLanguageData = new HashMap();

   public ItemDragonRadar() {
      this.maxStackSize = 50;
      this.setMaxDamage(0);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   @SideOnly(Side.CLIENT)
   public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4) {
      var3.add(StatCollector.translateToLocal("dbc.itemDRadar.line1"));
      var3.add(StatCollector.translateToLocal("dbc.itemDRadar.line2"));
      var3.add(StatCollector.translateToLocal("dbc.itemDRadar.line3"));
   }

   public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10) {
      return false;
   }
}
