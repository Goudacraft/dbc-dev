package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemDinoMeat extends ItemFood {
   private float l = 1.0F;

   public ItemDinoMeat(int var1, float var2, float var3) {
      super(var1, var2, true);
      this.setMaxStackSize(16);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
      this.setAlwaysEdible();
      this.l = var3;
   }

   @SideOnly(Side.CLIENT)
   public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4) {
      var3.add(StatCollector.translateToLocal("dbc.ItemDinoMeat.line1"));
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public ItemStack onEaten(ItemStack var1, World var2, EntityPlayer var3) {
      super.onEaten(var1, var2, var3);
      var3.inventory.addItemStackToInventory(new ItemStack(Items.bone));
      return var1;
   }

   protected void onFoodEaten(ItemStack var1, World var2, EntityPlayer var3) {
      if(!var2.isRemote) {
         int[] var4 = JRMCoreH.PlyrAttrbts(var3);
         byte var5 = JRMCoreH.getByte(var3, "jrmcPwrtyp");
         byte var6 = JRMCoreH.getByte(var3, "jrmcRace");
         byte var7 = JRMCoreH.getByte(var3, "jrmcClass");
         int var8 = JRMCoreH.stat(var5, 2, var4[2], var6, var7, 0.0F);
         int var9 = JRMCoreH.getInt(var3, "jrmcBdy");
         int var10 = JRMCoreH.stat(var5, 5, var4[5], var6, var7, 0.0F);
         int var11 = JRMCoreH.getInt(var3, "jrmcEnrgy");
         int var12 = JRMCoreH.stat(var5, 3, var4[2], var6, var7, 0.0F);
         int var13 = JRMCoreH.getInt(var3, "jrmcStamina");
         int var14 = (int)((float)var9 + ((float)var8 * 0.3F > 500.0F?500.0F:(float)var8 * 0.3F) * this.l);
         JRMCoreH.setInt(var14 > var8?var8:var14, var3, "jrmcBdy");
         int var15 = (int)((float)var11 + ((float)var10 * 0.2F > 500.0F?500.0F:(float)var10 * 0.2F) * this.l);
         JRMCoreH.setInt(var15 > var10?var10:var15, var3, "jrmcEnrgy");
         int var16 = (int)((float)var13 + ((float)var12 * 0.2F > 500.0F?500.0F:(float)var12 * 0.2F) * this.l);
         JRMCoreH.setInt(var16 > var12?var12:var16, var3, "jrmcStamina");
      }

   }
}
