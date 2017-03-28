package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.mod_DragonBC;
import JinRyuu.DragonBC.common.Npcs.EntityDBCKami;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityMasterFreeza extends EntityDBCKami {
   public final int HePo = 20000;

   public EntityMasterFreeza(World var1) {
      super(var1);
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20000.0D);
   }

   public boolean interact(EntityPlayer var1) {
      ItemStack var2 = var1.inventory.getCurrentItem();
      boolean var3 = var2 != null;
      if(this.isEntityAlive()) {
         var1.openGui(mod_DragonBC.instance, 18, var1.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ);
         return true;
      } else {
         return super.interact(var1);
      }
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/freeza5.png";
   }

   public void onUpdate() {
      super.onUpdate();
   }
}
