package JinRyuu.DragonBC.common.Npcs;

import JinRyuu.DragonBC.common.Npcs.EntityCyborgs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class EntityCyborgsAbs extends EntityCyborgs {
   public int randomSoundDelay = 0;

   public EntityCyborgsAbs(World var1) {
      super(var1);
   }

   private void becomeAngryAt(Entity var1) {
      this.entityToAttack = var1;
      this.angerLevel = 400 + this.rand.nextInt(400);
      this.randomSoundDelay = this.rand.nextInt(40);
   }
}
