package com.Jackiecrazi.aoatc.entities.projectiles;

import com.Jackiecrazi.aoatc.blocks.ModBlocks;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.nevermine.mob.placement.EntityNoRange;
import net.nevermine.projectiles.NoGraceChecks;
import net.nevermine.projectiles.staff.EntityStaffFire;

public class EntityCustomFire extends EntityStaffFire{
	private float damage;
	int duration;
	int type;
	public EntityCustomFire(World par1World, EntityPlayer par3EntityPlayer,
			float dmg, int knock, float grav,int dur, int type) {
		super(par1World, par3EntityPlayer, dmg, knock, grav);
		this.duration=dur;
		this.damage=dmg;
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
	    	  
	        ((EntityLivingBase)movingobjectposition.entityHit).setFire(duration*20);
	      }
	      if(type==1){
	    	  this.worldObj.setBlock(serverPosX, serverPosY, serverPosZ, ModBlocks.Illumination);
	      }
	      if(type==3)this.worldObj.setBlock(serverPosX, serverPosY, serverPosZ, ModBlocks.Quarantino);
	    }
	    if (!worldObj.isRemote)
	      setDead();
	  }
}
