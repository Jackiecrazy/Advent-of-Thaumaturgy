package com.Jackiecrazi.aoatc.entities.projectiles;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.nevermine.mob.placement.EntityNoRange;
import net.nevermine.projectiles.NoGraceChecks;
import net.nevermine.projectiles.staff.EntityStaffWind;

public class EntityCustomWind extends EntityStaffWind{
	private float damage;
	boolean pause;
	int knock;
		public EntityCustomWind(World par1World, EntityPlayer par3EntityPlayer,
				float dmg, int knock, float grav,boolean pause) {
			super(par1World, par3EntityPlayer, dmg, knock, grav);
			this.pause=pause;
			this.knock=knock;
		}
		@Override
		protected void onImpact(MovingObjectPosition movingobjectposition)
		  {
		    if (movingobjectposition.entityHit != null) {
		      if (((movingobjectposition.entityHit instanceof EntityCreature)) && (!(movingobjectposition.entityHit instanceof EntityNoRange))) {
		        NoGraceChecks.check((EntityCreature)movingobjectposition.entityHit, getThrower(), this, damage);
		        float f4 = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
		        movingobjectposition.entityHit.addVelocity(motionX * knock * 0.6000000238418579D / f4, 0.1D, motionZ * knock * 0.6000000238418579D / f4);
		        if(this.pause)((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id,40,66));
		      }
		    }
		    if (!worldObj.isRemote)
		      setDead();
		  }

}
