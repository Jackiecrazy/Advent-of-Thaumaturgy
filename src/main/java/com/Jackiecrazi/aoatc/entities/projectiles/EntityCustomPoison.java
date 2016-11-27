package com.Jackiecrazi.aoatc.entities.projectiles;

import com.Jackiecrazi.aoatc.AscendingPotions;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.nevermine.mob.placement.EntityNoRange;
import net.nevermine.projectiles.NoGraceChecks;
import net.nevermine.projectiles.staff.EntityStaffPoison;

public class EntityCustomPoison extends EntityStaffPoison{
private float damage;
int duration;
int intensity;
int type;
	public EntityCustomPoison(World par1World, EntityPlayer par3EntityPlayer,
			float dmg, int knock, float grav,int dur,int intensity,int type) {
		super(par1World, par3EntityPlayer, dmg, knock, grav);
		this.duration=dur;
		this.intensity=intensity;
		this.type=type;
	}
	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition)
	  {
	    if (movingobjectposition.entityHit != null) {
	      if (((movingobjectposition.entityHit instanceof EntityCreature)) && (!(movingobjectposition.entityHit instanceof EntityNoRange))) {
	        NoGraceChecks.check((EntityCreature)movingobjectposition.entityHit, getThrower(), this, damage);
	      }

	      if ((movingobjectposition.entityHit instanceof EntityLivingBase)) {
	        if(this.type==1)((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(AscendingPotions.Spore.id, duration, intensity));
	        else ((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Potion.poison.id, duration, intensity));
	        if(this.type==2){
	        	((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, duration, intensity));
	        	((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Potion.weakness.id, duration, intensity));
	        }
	      }
	    }
	    if (!worldObj.isRemote)
	      setDead();
	  }

}
