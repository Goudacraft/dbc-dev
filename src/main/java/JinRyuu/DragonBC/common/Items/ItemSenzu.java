package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.DBCConfig;
import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.JRMCoreH;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemSenzu extends Item {
   private boolean alwaysEdible;

   public ItemSenzu(int var1, float var2, boolean var3) {
      this.setHasSubtypes(true);
      this.maxStackSize = 5;
      this.setMaxDamage(1);
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   @SideOnly(Side.CLIENT)
   public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4) {
      var3.add(StatCollector.translateToLocal("dbc.itemSenzu.line1"));
   }

   public String getTextureFile() {
      return "jinryuudragonbc:";
   }

   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName());
   }

   public void onPlayerStoppedUsing(ItemStack var1, World var2, EntityPlayer var3, int var4) {
      int var5 = this.getMaxItemUseDuration(var1) - var4;
      ArrowLooseEvent var6 = new ArrowLooseEvent(var3, var1, var5);
      MinecraftForge.EVENT_BUS.post(var6);
      if(!var6.isCanceled()) {
         var5 = var6.charge;
         if(!var2.isRemote) {
            int[] var8 = JRMCoreH.PlyrAttrbts(var3);
            byte var9 = JRMCoreH.getByte(var3, "jrmcPwrtyp");
            byte var10 = JRMCoreH.getByte(var3, "jrmcRace");
            byte var11 = JRMCoreH.getByte(var3, "jrmcClass");
            int var12 = JRMCoreH.stat(var9, 2, var8[2], var10, var11, 0.0F);
            int var13 = JRMCoreH.stat(var9, 5, var8[5], var10, var11, 0.0F);
            int var14 = JRMCoreH.stat(var9, 3, var8[2], var10, var11, 0.0F);
            int var15 = (int)(System.currentTimeMillis() / 1000L);
            int var16 = JRMCoreH.getInt(var3, "jrmcSenzuCC");
            if(var16 > var15) {
               var3.addChatMessage((new ChatComponentText("Senzu can be used again after " + (var16 - var15) + " seconds!")).setChatStyle((new ChatStyle()).setColor(EnumChatFormatting.GOLD)));
               return;
            }

            JRMCoreH.setInt(var12, var3, "jrmcBdy");
            JRMCoreH.setInt(var13, var3, "jrmcEnrgy");
            JRMCoreH.setInt(var14, var3, "jrmcStamina");
            JRMCoreH.setInt(var15 + DBCConfig.senzuCool, var3, "jrmcSenzuCC");
            var3.setHealth(var3.getMaxHealth());
            var2.playSoundAtEntity(var3, "jinryuudragonbc:DBC2.sensu", 0.5F, var2.rand.nextFloat() * 0.1F + 0.9F);
            var3.getFoodStats().addStats(20, 0.9F);
            if(!var3.capabilities.isCreativeMode) {
               --var1.stackSize;
            }
         }

      }
   }

   public ItemStack onEaten(ItemStack var1, World var2, EntityPlayer var3) {
      return var1;
   }

   public int getMaxItemUseDuration(ItemStack var1) {
      return 72000;
   }

   public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
      ArrowNockEvent var4 = new ArrowNockEvent(var3, var1);
      MinecraftForge.EVENT_BUS.post(var4);
      if(var4.isCanceled()) {
         return var4.result;
      } else {
         if(var3.capabilities.isCreativeMode || var3.inventory.hasItem(this)) {
            var3.setItemInUse(var1, this.getMaxItemUseDuration(var1));
         }

         return var1;
      }
   }

   public EnumAction getItemUseAction(ItemStack var1) {
      return EnumAction.block;
   }
}
