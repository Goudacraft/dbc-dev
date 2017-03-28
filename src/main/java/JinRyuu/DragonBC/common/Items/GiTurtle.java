package JinRyuu.DragonBC.common.Items;

import JinRyuu.DragonBC.common.DBCClient;
import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreHJBRA;
import JinRyuu.JRMCore.JRMCoreHJFC;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.IIcon;

public class GiTurtle extends ItemArmor {
   public String armorNamePrefix;
   public ArmorMaterial material;
   @SideOnly(Side.CLIENT)
   public IIcon field_94604_cx1;
   private IIcon overlayIcon;
   private IIcon emptySlotIcon;
   private static final String[] CLOTH_OVERLAY_NAMES = new String[]{"leather_helmet_overlay", "leather_chestplate_overlay", "leather_leggings_overlay", "leather_boots_overlay"};

   public GiTurtle(ArmorMaterial var1, int var2, int var3, String var4) {
      super(var1, var2, var3);
      this.material = var1;
      var1.getDamageReductionAmount(var3);
      this.setMaxDamage(var1.getDurability(var3));
      this.maxStackSize = 1;
      this.armorNamePrefix = var4;
      this.setCreativeTab(mod_DragonBC.DragonBlockC);
   }

   @SideOnly(Side.CLIENT)
   public ModelBiped giMdl(int var1, EntityLivingBase var2) {
      switch(var1) {
      case 0:
         return this.wear(var2)?JRMCoreHJBRA.GiTurtleMdl1:DBCClient.armor1;
      case 1:
         return this.wear(var2)?JRMCoreHJBRA.GiTurtleMdl1:DBCClient.armor1;
      case 2:
      default:
         return this.wear(var2)?JRMCoreHJBRA.GiTurtleMdl2:DBCClient.armor2;
      case 3:
         return this.wear(var2)?JRMCoreHJBRA.GiTurtleMdl1:DBCClient.armor1;
      }
   }

   public boolean wear(EntityLivingBase var1) {
      return JRMCoreH.JBRA() && (var1 instanceof EntityPlayer || JRMCoreH.JFC() && JRMCoreHJFC.isChildNPC(var1));
   }

   @SideOnly(Side.CLIENT)
   public ModelBiped getArmorModel(EntityLivingBase var1, ItemStack var2, int var3) {
      ModelBiped var4 = this.giMdl(var3, var1);
      if(this.wear(var1)) {
         var4 = JRMCoreHJBRA.showModel(var4, var1, var2, var3);
      } else {
         var4.bipedHead.showModel = var3 == 0;
         var4.bipedHeadwear.showModel = false;
         var4.bipedBody.showModel = var3 == 1 || var3 == 2;
         var4.bipedRightArm.showModel = var3 == 1;
         var4.bipedLeftArm.showModel = var3 == 1;
         var4.bipedRightLeg.showModel = var3 == 2 || var3 == 3;
         var4.bipedLeftLeg.showModel = var3 == 2 || var3 == 3;
         if(var1 instanceof EntityMob) {
            var4.bipedRightArm.showModel = false;
            var4.bipedLeftArm.showModel = false;
         }

         ItemStack var5 = var1.getHeldItem();
         var4.heldItemRight = var5 != null?1:0;
         if(var5 != null && var1 instanceof EntityPlayer && ((EntityPlayer)var1).getItemInUseCount() > 0) {
            EnumAction var6 = var5.getItemUseAction();
            if(var6 == EnumAction.block) {
               var4.heldItemRight = 3;
            } else if(var6 == EnumAction.bow) {
               var4.aimedBow = true;
            }
         }

         var4.isSneak = var1.isSneaking();
         var4.isRiding = var1.isRiding();
         var4.isChild = var1.isChild();
      }

      return var4;
   }

   @SideOnly(Side.CLIENT)
   public void registerIcons(IIconRegister var1) {
      this.itemIcon = var1.registerIcon("jinryuudragonbc:" + this.getUnlocalizedName().replaceAll("Scoutera", "Scouter").replaceAll("Scouterb", "Scouter"));
      this.field_94604_cx1 = var1.registerIcon(EMPTY_SLOT_NAMES[this.armorType]);
      if(this.material == ArmorMaterial.CLOTH) {
         this.overlayIcon = var1.registerIcon(CLOTH_OVERLAY_NAMES[this.armorType]);
      }

      this.emptySlotIcon = var1.registerIcon(EMPTY_SLOT_NAMES[this.armorType]);
   }

   public String getArmorTexture(ItemStack var1, Entity var2, int var3, String var4) {
      String var5 = "";
      String var6 = "";
      String var7 = "";
      if(var1.getItemDamageForDisplay() > var1.getMaxDamage() / 2) {
         var6 = "_dam";
      }

      var7 = "jbra";
      if(!var1.toString().contains("leg") && !var1.toString().contains("Leg")) {
         var5 = "jinryuudragonbc:armor/" + this.armorNamePrefix + "_1" + var7 + var6 + ".png";
      } else {
         var5 = "jinryuudragonbc:armor/" + this.armorNamePrefix + "_2" + var7 + var6 + ".png";
      }

      return var5;
   }
}
