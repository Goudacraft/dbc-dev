package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityNamekian01;
import JinRyuu.JRMCore.JRMCoreH;
import JinRyuu.JRMCore.JRMCoreH2;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowGolem;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIPlay;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIVillagerMate;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Tuple;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.village.Village;
import net.minecraft.world.World;

public class EntityNamekian03 extends EntityVillager implements INpc, IMerchant {
   public final int AttPow;
   public final int HePo;
   private int randomTickDivider;
   private boolean isMating;
   private boolean isPlaying;
   Village villageObj;
   private EntityPlayer buyingPlayer;
   private MerchantRecipeList buyingList;
   private int timeUntilReset;
   private boolean needsInitilization;
   private int wealth;
   private String lastBuyingPlayer;
   private boolean isLookingForHome;
   private float field_82191_bN;
   public static final Map villagerStockList = new HashMap();
   public static final Map blacksmithSellingList = new HashMap();

   public EntityNamekian03(World var1) {
      this(var1, 0);
   }

   public EntityNamekian03(World var1, int var2) {
      super(var1);
      this.AttPow = 30;
      this.HePo = 300;
      this.randomTickDivider = 0;
      this.isMating = false;
      this.isPlaying = false;
      this.villageObj = null;
      this.setProfession(var2);
      this.getNavigator().setBreakDoors(true);
      this.getNavigator().setAvoidsWater(true);
      this.tasks.addTask(0, new EntityAISwimming(this));
      this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.30000001192092896D, 0.3499999940395355D));
      this.tasks.addTask(1, new EntityAITradePlayer(this));
      this.tasks.addTask(1, new EntityAILookAtTradePlayer(this));
      this.tasks.addTask(2, new EntityAIMoveIndoors(this));
      this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
      this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
      this.tasks.addTask(6, new EntityAIVillagerMate(this));
      this.tasks.addTask(7, new EntityAIFollowGolem(this));
      this.tasks.addTask(8, new EntityAIPlay(this, 0.3199999928474426D));
      this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
      this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityVillager.class, 5.0F, 0.02F));
      this.tasks.addTask(9, new EntityAIWander(this, 0.30000001192092896D));
      this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
   }

   public boolean attackEntityFrom(DamageSource var1, float var2) {
      if(this.isEntityInvulnerable()) {
         return false;
      } else {
         Entity var3 = var1.getEntity();
         if(var3 instanceof EntityPlayer) {
            List var4 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

            for(int var5 = 0; var5 < var4.size(); ++var5) {
               Entity var6 = (Entity)var4.get(var5);
               if(var6 instanceof EntityNamekian01) {
                  EntityNamekian01 var7 = (EntityNamekian01)var6;
                  var7.becomeAngryAt(var3);
               }
            }
         }

         return super.attackEntityFrom(var1, var2);
      }
   }

   public boolean isAIEnabled() {
      return true;
   }

   protected void updateAITick() {
      if(--this.randomTickDivider <= 0) {
         this.worldObj.villageCollectionObj.addVillagerPosition(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ));
         this.randomTickDivider = 70 + this.rand.nextInt(50);
         this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 32);
         if(this.villageObj != null) {
            ChunkCoordinates var1 = this.villageObj.getCenter();
            if(this.isLookingForHome) {
               this.isLookingForHome = false;
            }
         }
      }

      if(!this.isTrading() && this.timeUntilReset > 0) {
         --this.timeUntilReset;
         if(this.timeUntilReset <= 0) {
            if(this.needsInitilization) {
               if(this.buyingList.size() > 1) {
                  for(MerchantRecipe var2 : this.buyingList) {
                     ;
                  }
               }

               this.addDefaultEquipmentAndRecipies(1);
               this.needsInitilization = false;
               if(this.villageObj != null && this.lastBuyingPlayer != null) {
                  this.worldObj.setEntityState(this, (byte)14);
                  this.villageObj.setReputationForPlayer(this.lastBuyingPlayer, 1);
               }
            }

            this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
         }
      }

      super.updateAITick();
   }

   public boolean interact(EntityPlayer var1) {
      return true;
   }

   protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(20, Integer.valueOf(0));
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0D);
   }

   public void writeEntityToNBT(NBTTagCompound var1) {
      super.writeEntityToNBT(var1);
      var1.setInteger("Profession", this.getProfession());
      var1.setInteger("Riches", this.wealth);
      if(this.buyingList != null) {
         var1.setTag("Offers", this.buyingList.getRecipiesAsTags());
      }

   }

   public void readEntityFromNBT(NBTTagCompound var1) {
      super.readEntityFromNBT(var1);
      this.setProfession(var1.getInteger("Profession"));
      this.wealth = var1.getInteger("Riches");
      if(var1.hasKey("Offers")) {
         NBTTagCompound var2 = var1.getCompoundTag("Offers");
         this.buyingList = new MerchantRecipeList(var2);
      }

   }

   @SideOnly(Side.CLIENT)
   public String getTexture() {
      return "jinryuudragonbc:npcs/namek02.png";
   }

   protected boolean canDespawn() {
      return false;
   }

   public void setProfession(int var1) {
      this.dataWatcher.updateObject(16, Integer.valueOf(var1));
   }

   public int getProfession() {
      return this.dataWatcher.getWatchableObjectInt(16);
   }

   public boolean isMating() {
      return this.isMating;
   }

   public void setMating(boolean var1) {
      this.isMating = var1;
   }

   public void setPlaying(boolean var1) {
      this.isPlaying = var1;
   }

   public boolean isPlaying() {
      return this.isPlaying;
   }

   public void onDeath(DamageSource var1) {
      if(this.villageObj != null) {
         Entity var2 = var1.getEntity();
         if(var2 != null) {
            if(var2 instanceof EntityPlayer) {
               int var3 = JRMCoreH.getByte((EntityPlayer)var2, "jrmcAlign");
               var3 = var3 - 20;
               var3 = var3 < 0?0:var3;
               JRMCoreH.setByte(var3, (EntityPlayer)var2, "jrmcAlign");
               int var4 = JRMCoreH.getInt((EntityPlayer)var2, "jrmcKarma");
               JRMCoreH.setInt(var4 + 1, (EntityPlayer)var2, "jrmcKarma");
               ((EntityPlayer)var2).addChatMessage((new ChatComponentTranslation(JRMCoreH.trlai("dbc.moreevil.line1"), new Object[0])).setChatStyle(JRMCoreH2.styl_wht));
               this.villageObj.setReputationForPlayer(((EntityPlayer)var2).getCommandSenderName(), -2);
            } else if(var2 instanceof IMob) {
               this.villageObj.endMatingSeason();
            }
         } else if(var2 == null) {
            EntityPlayer var7 = this.worldObj.getClosestPlayerToEntity(this, 16.0D);
            if(var7 != null) {
               this.villageObj.endMatingSeason();
            }
         }
      }

      super.onDeath(var1);
   }

   public void setCustomer(EntityPlayer var1) {
      this.buyingPlayer = var1;
   }

   public EntityPlayer getCustomer() {
      return this.buyingPlayer;
   }

   public boolean isTrading() {
      return this.buyingPlayer != null;
   }

   public void useRecipe(MerchantRecipe var1) {
      var1.incrementToolUses();
      if(var1.hasSameIDsAs((MerchantRecipe)this.buyingList.get(this.buyingList.size() - 1))) {
         this.timeUntilReset = 40;
         this.needsInitilization = true;
         if(this.buyingPlayer != null) {
            this.lastBuyingPlayer = this.buyingPlayer.getCommandSenderName();
         } else {
            this.lastBuyingPlayer = null;
         }
      }

   }

   public MerchantRecipeList getRecipes(EntityPlayer var1) {
      if(this.buyingList == null) {
         this.addDefaultEquipmentAndRecipies(1);
      }

      return this.buyingList;
   }

   private float adjustProbability(float var1) {
      float var2 = var1 + this.field_82191_bN;
      return var2 > 0.9F?0.9F - (var2 - 0.9F):var2;
   }

   private void addDefaultEquipmentAndRecipies(int var1) {
      if(this.buyingList != null) {
         this.field_82191_bN = MathHelper.sqrt_float((float)this.buyingList.size()) * 0.2F;
      } else {
         this.field_82191_bN = 0.0F;
      }

      MerchantRecipeList var2 = new MerchantRecipeList();
      VillagerRegistry.manageVillagerTrades(var2, this, this.getProfession(), this.rand);
      if(var2.isEmpty()) {
         ;
      }

      Collections.shuffle(var2);
      if(this.buyingList == null) {
         this.buyingList = new MerchantRecipeList();
      }

      for(int var4 = 0; var4 < var1 && var4 < var2.size(); ++var4) {
         this.buyingList.addToListWithCheck((MerchantRecipe)var2.get(var4));
      }

   }

   private static int getRandomCountForItem(int var0, Random var1) {
      Tuple var2 = (Tuple)villagerStockList.get(Integer.valueOf(var0));
      return var2 == null?1:(((Integer)var2.getFirst()).intValue() >= ((Integer)var2.getSecond()).intValue()?((Integer)var2.getFirst()).intValue():((Integer)var2.getFirst()).intValue() + var1.nextInt(((Integer)var2.getSecond()).intValue() - ((Integer)var2.getFirst()).intValue()));
   }

   private static int getRandomCountForBlacksmithItem(int var0, Random var1) {
      Tuple var2 = (Tuple)blacksmithSellingList.get(Integer.valueOf(var0));
      return var2 == null?1:(((Integer)var2.getFirst()).intValue() >= ((Integer)var2.getSecond()).intValue()?((Integer)var2.getFirst()).intValue():((Integer)var2.getFirst()).intValue() + var1.nextInt(((Integer)var2.getSecond()).intValue() - ((Integer)var2.getFirst()).intValue()));
   }

   @SideOnly(Side.CLIENT)
   public void handleHealthUpdate(byte var1) {
      if(var1 == 12) {
         this.generateRandomParticles("heart");
      } else if(var1 == 13) {
         this.generateRandomParticles("angryVillager");
      } else if(var1 == 14) {
         this.generateRandomParticles("happyVillager");
      } else {
         super.handleHealthUpdate(var1);
      }

   }

   @SideOnly(Side.CLIENT)
   private void generateRandomParticles(String var1) {
      for(int var2 = 0; var2 < 5; ++var2) {
         double var3 = this.rand.nextGaussian() * 0.02D;
         double var5 = this.rand.nextGaussian() * 0.02D;
         double var7 = this.rand.nextGaussian() * 0.02D;
         this.worldObj.spawnParticle(var1, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 1.0D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, var3, var5, var7);
      }

   }

   public void initCreature() {
      VillagerRegistry.applyRandomTrade(this, this.worldObj.rand);
   }

   public void setLookingForHome() {
      this.isLookingForHome = true;
   }

   public EntityVillager func_90012_b(EntityAgeable var1) {
      EntityVillager var2 = new EntityVillager(this.worldObj);
      return var2;
   }
}
