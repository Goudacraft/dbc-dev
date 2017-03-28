package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityDBCWildlife;
import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.entity.EntityEnergyAtt;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class EntityDBC extends EntityCreature implements IMob {
   protected String texture;
   private double moveSpeed = 0.699D;
   private int rang = 0;
   public int angerLevel = 0;
   private int aggroCooldown = 0;
   public int prevAttackCounter = 0;
   public int attackCounter = 0;
   private Entity targetedEntity = null;
   private boolean updtd = false;

   public EntityDBC(World var1) {
      super(var1);
      this.experienceValue = 5;
      this.setCustomNameTag("");
      this.setAlwaysRenderNameTag(false);
   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return this.texture;
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1000.0D);
      this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
   }

   protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(23, new Integer(0));
   }

   protected boolean isAIEnabled() {
      return false;
   }

   protected boolean canDespawn() {
      return false;
   }

   public void onDeath(DamageSource var1) {
      Entity var2 = var1.getEntity();
      if(var2 instanceof EntityPlayer) {
         System.out.println("DBC-Info: " + this.getCommandSenderName() + " has been killed by " + var2.getCommandSenderName());
         byte var3 = 1;
         if(var2 instanceof EntityPlayer) {
            EntityPlayer var4 = (EntityPlayer)var2;
            JRMCoreH.expPls(var4, var3);
         }
      }

      super.onDeath(var1);
   }

   public int getAttackStrength(Entity var1, int var2) {
      ItemStack var3 = this.getHeldItem();
      boolean var4 = false;
      if(var3 != null) {
         ;
      }

      int var5 = var2 - this.rand.nextInt((int)((float)(var2 + 1) * 0.5F));
      return var5;
   }

   protected void updateEntityActionState() {
      if(!(this instanceof EntityDBCWildlife) && !(this instanceof EntitySaibaiman) && this.angerLevel > 0) {
         this.fallDistance = 0.0F;
         this.prevAttackCounter = this.attackCounter;
         if(this.targetedEntity != null && this.targetedEntity.isDead) {
            this.targetedEntity = null;
            this.dataWatcher.updateObject(23, Integer.valueOf(0));
            super.updateEntityActionState();
         }

         if(this.targetedEntity == null || this.aggroCooldown-- <= 0) {
            this.targetedEntity = this.worldObj.getClosestVulnerablePlayerToEntity(this, 100.0D);
            super.updateEntityActionState();
            if(this.targetedEntity != null) {
               this.dataWatcher.updateObject(23, Integer.valueOf(this.targetedEntity.getEntityId()));
               this.aggroCooldown = 20;
            }
         }

         float var1 = this.width / 2.0F + 3.5F;
         if(this.entityToAttack != null && this.entityToAttack.isEntityAlive() && this.entityToAttack.getDistanceToEntity(this) < var1) {
            AxisAlignedBB var2 = AxisAlignedBB.getBoundingBox(this.posX - (double)var1, this.posY - (double)var1, this.posZ - (double)var1, this.posX + (double)var1, this.posY + (double)var1, this.posZ + (double)var1);
            List var3 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, var2);
            if(this.attackTime <= 0) {
               for(int var4 = 0; var4 < var3.size(); ++var4) {
                  EntityPlayer var5 = (EntityPlayer)var3.get(var4);
                  this.attackEntityAsMob(var5);
               }

               this.attackTime = 35;
               this.worldObj.playSoundAtEntity(this, "jinryuudragonbc:DBC3.force", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }
         }

         double var27 = 64.0D;
         if(this.targetedEntity != null && this.targetedEntity.getDistanceSqToEntity(this) < var27 * var27) {
            double var28 = this.targetedEntity.posX - this.posX;
            double var6 = this.targetedEntity.boundingBox.minY + (double)(this.targetedEntity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
            double var8 = this.targetedEntity.posZ - this.posZ;
            this.renderYawOffset = this.rotationYaw = -((float)Math.atan2(var28, var8)) * 180.0F / 3.1415927F;
            if(this.canEntityBeSeen(this.targetedEntity)) {
               if(this.attackCounter == 10) {
                  ;
               }

               ++this.attackCounter;
               if(this.attackCounter == 80) {
                  this.worldObj.playSoundAtEntity(this, "jinryuudragonbc:DBC2.basicbeam_fire", 0.5F, 1.0F);
                  byte var10 = 1;
                  byte var11 = 1;
                  byte var12 = 1;
                  byte var13 = 0;
                  byte var14 = 1;
                  byte var15 = 0;
                  byte var16 = 0;
                  byte var17 = 0;
                  byte[] var18 = JRMCoreH.techDBCstatsDefault;
                  byte var19 = 50;
                  int var20 = (int)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
                  int var21 = (int)((float)var20 * 1.2F);
                  int var22 = var21 / 2;
                  EntityEnergyAtt var23 = new EntityEnergyAtt(this, var10, var11, var19, var12, var13, var14, var15, var16, var17, (byte)50, var21, var22, var18, (byte)0);
                  double var24 = (double)this.width + 0.5D;
                  Vec3 var26 = this.getLook(1.0F);
                  var23.posX = this.posX + var26.xCoord * var24;
                  var23.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
                  var23.posZ = this.posZ + var26.zCoord * var24;
                  this.worldObj.spawnEntityInWorld(var23);
                  this.attackCounter = -40;
               }
            } else if(this.attackCounter > 0) {
               --this.attackCounter;
            }
         } else if(this.attackCounter > 0) {
            --this.attackCounter;
         }
      } else {
         super.updateEntityActionState();
      }

   }

   public void onLivingUpdate() {
      this.updateArmSwingProgress();
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
      super.onLivingUpdate();
   }

   public int updateDataInt(int var1) {
      return this.dataWatcher.getWatchableObjectInt(var1);
   }

   public void onUpdate() {
      if(this.worldObj.isRemote) {
         ++this.rang;
      }

      if(this.worldObj.isRemote && this.rang > 100) {
         this.rang = 0;
         int var1 = this.updateDataInt(23);
         this.targetedEntity = var1 > 0?this.worldObj.getEntityByID(var1):null;
      }

      if(!this.worldObj.isRemote && !this.updtd) {
         this.updtd = true;
      }

      if(!(this instanceof EntityDBCWildlife) && !(this instanceof EntitySaibaiman) && this.targetedEntity != null && this.canEntityBeSeen(this.targetedEntity)) {
         if(this.targetedEntity.posY - 4.0D > this.posY) {
            this.motionY += 0.1D;
         } else if(this.targetedEntity.posY - 1.6D >= this.posY) {
            this.posY = this.targetedEntity.posY - 1.6D;
            this.motionY = 0.0D;
            this.fallDistance = 0.0F;
         }
      }

      super.onUpdate();
   }

   protected Entity findPlayerToAttack() {
      EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
      return var1 != null && this.canEntityBeSeen(var1)?var1:null;
   }

   public boolean attackEntityAsMob(Entity var1) {
      if(!(var1 instanceof EntityDBC)) {
         int var2 = (int)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
         var2 = this.getAttackStrength(var1, var2);
         int var3 = 0;
         if(var1 instanceof EntityLivingBase) {
            var2 = (int)((float)var2 + EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase)var1));
            var3 += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase)var1);
         }

         boolean var4 = var1.attackEntityFrom(DamageSource.causeMobDamage(this), (float)var2);
         if(var4) {
            if(var3 > 0) {
               var1.addVelocity((double)(-MathHelper.sin(this.rotationYaw * 3.1415927F / 180.0F) * (float)var3 * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * 3.1415927F / 180.0F) * (float)var3 * 0.5F));
               this.motionX *= 0.6D;
               this.motionZ *= 0.6D;
            }

            int var5 = EnchantmentHelper.getFireAspectModifier(this);
            if(var5 > 0) {
               var1.setFire(var5 * 4);
            }

            if(var1 instanceof EntityLivingBase) {
               EnchantmentHelper.func_151384_a((EntityLivingBase)var1, this);
            }

            EnchantmentHelper.func_151385_b(this, var1);
         }

         return var4;
      } else {
         return false;
      }
   }

   protected void attackEntity(Entity var1, float var2) {
      if(this.attackTime <= 0 && var2 < this.width / 2.0F + 2.5F && var1.boundingBox.maxY > this.boundingBox.minY && var1.boundingBox.minY < this.boundingBox.maxY) {
         this.attackTime = 35;
         this.attackEntityAsMob(var1);
      }

   }

   public float getBlockPathWeight(int var1, int var2, int var3) {
      return 0.5F - this.worldObj.getLightBrightness(var1, var2, var3);
   }

   protected boolean isValidLightLevel() {
      int var1 = MathHelper.floor_double(this.posX);
      int var2 = MathHelper.floor_double(this.boundingBox.minY);
      int var3 = MathHelper.floor_double(this.posZ);
      if(this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, var1, var2, var3) > this.rand.nextInt(32)) {
         return false;
      } else {
         int var4 = this.worldObj.getBlockLightValue(var1, var2, var3);
         if(this.worldObj.isThundering()) {
            int var5 = this.worldObj.skylightSubtracted;
            this.worldObj.skylightSubtracted = 10;
            var4 = this.worldObj.getBlockLightValue(var1, var2, var3);
            this.worldObj.skylightSubtracted = var5;
         }

         return var4 <= this.rand.nextInt(8);
      }
   }

   public boolean getCanSpawnHere() {
      return true;
   }
}
