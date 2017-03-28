package JinRyuu.DragonBC.common.Villages;

import JinRyuu.JRMCore.blocks.BlocksJRMC;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class builds extends WorldGenerator {
   protected boolean notComplete = false;
   protected int x = 0;
   protected int y = 0;
   protected int z = 0;
   protected int r = 0;
   protected int flp = 0;
   protected boolean check = false;
   public static int SizeX = 0;
   public static int SizeZ = 0;
   public static int SizeY = 0;
   public static int MidPointX = 0;
   public static int MidPointZ = 0;
   protected Block air = Blocks.air;
   protected Block b56 = BlocksJRMC.stoneSingleSlab2;
   protected Block b97 = Blocks.planks;
   protected Block c = BlocksJRMC.BlockColoredStone2;
   protected Block c2 = BlocksJRMC.BlockColoredStone2;
   protected Block s = BlocksJRMC.stoneSingleSlab2;
   protected Block f = BlocksJRMC.BlockFence2;
   protected Block stairCompactCobblestone = Blocks.stone_stairs;
   protected Block stairCompactPlanks = Blocks.oak_stairs;
   protected Block stoneSingleSlab = Blocks.stone_slab;
   protected Block woodSingleSlab = Blocks.wooden_slab;
   protected Block fence = Blocks.fence;
   protected Block planks = Blocks.planks;
   protected Block leaves = Blocks.leaves;
   protected Block glass = Blocks.glass;
   protected Block wood = Blocks.log;
   protected Block stone = Blocks.stone;
   protected Block sand = Blocks.sand;
   protected Block sandstone = Blocks.sandstone;
   protected Block grass = Blocks.grass;
   protected Block dirt = Blocks.dirt;
   protected Block oak_stairs = Blocks.oak_stairs;
   protected Block doorWood = Blocks.wooden_door;
   protected Block iron_door = Blocks.iron_door;
   protected Block iron_block = Blocks.iron_block;
   protected Block torchWood = Blocks.air;
   protected Block glowStone = Blocks.glowstone;
   protected Block bookShelf = Blocks.bookshelf;
   protected Block stoneDoubleSlab = Blocks.stonebrick;
   protected Block signWall = Blocks.wall_sign;
   protected Block blockSteel = Blocks.iron_block;
   protected Block ladder = Blocks.ladder;
   protected Block stoneBrick = Blocks.stonebrick;
   protected Block woodDoubleSlab = Blocks.planks;
   protected Block sandStone = Blocks.sandstone;
   protected Block b116 = Blocks.flower_pot;
   protected Block b121 = BlocksJRMC.BlockStairs2;
   protected Block b113 = Blocks.anvil;
   protected World w;
   protected boolean respawn = false;

   public void b(int var1, int var2, int var3, Block var4) {
      this.b(var1, var2, var3, var4, 0);
   }

   protected void b(int var1, int var2, int var3, Block var4, int var5) {
      this.setBlockAndNotifyAdequately(this.w, var1, var2, var3, var4, var5);
   }

   public boolean getNotComplete() {
      return this.notComplete;
   }

   public void setR(int var1) {
      this.r = var1;
   }

   public void setFlp(int var1) {
      this.flp = var1;
   }

   public void setCheck(boolean var1) {
      this.check = var1;
   }

   protected Block[] GetValidSpawnBlocks() {
      return new Block[]{Blocks.grass};
   }

   public boolean LocationIsValidSpawn(World var1, int var2, int var3, int var4) {
      this.w = var1;
      int var5 = 0;

      for(Block var6 = var1.getBlock(var2, var3, var4); var6 != Blocks.air; var6 = var1.getBlock(var2, var3 + var5, var4)) {
         ++var5;
      }

      if(var5 > 6) {
         return false;
      } else {
         var3 = var3 + (var5 - 1);
         Block var7 = var1.getBlock(var2, var3, var4);
         Block var8 = var1.getBlock(var2, var3 + 1, var4);
         Block var9 = var1.getBlock(var2, var3 - 1, var4);

         for(Block var13 : this.GetValidSpawnBlocks()) {
            if(var8 != Blocks.air) {
               return false;
            }

            if(var7 == var13) {
               return true;
            }

            if(var7 == Blocks.snow && var9 == var13) {
               return true;
            }
         }

         return false;
      }
   }

   public builds() {
   }

   public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
      return false;
   }

   public void setWorld(World var1) {
      this.w = var1;
   }

   public boolean generateBuilding(World var1, Random var2, int var3, int var4, int var5) {
      return false;
   }

   public void setRespawn(boolean var1) {
      this.respawn = var1;
   }
}
