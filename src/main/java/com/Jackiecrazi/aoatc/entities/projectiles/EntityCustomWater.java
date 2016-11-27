package com.Jackiecrazi.aoatc.entities.projectiles;

import com.Jackiecrazi.aoatc.Config;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.nevermine.mob.placement.EntityNoRange;
import net.nevermine.projectiles.NoGraceChecks;
import net.nevermine.projectiles.staff.EntityStaffWater;

public class EntityCustomWater extends EntityStaffWater {
	public int type;
	protected float potency;
	protected boolean maxed;
	public EntityCustomWater(World worldObj, EntityPlayer player,
			float potency, int kn, float gravity,int type,boolean maxed) {
		super(worldObj, player, potency, kn, gravity);
		this.type=type;
		this.potency=potency;
		this.maxed=maxed;
	}
	@Override
	  protected void onImpact(MovingObjectPosition movingobjectposition)
	  {
	    if (movingobjectposition.entityHit != null) {
	      if (((movingobjectposition.entityHit instanceof EntityCreature)) && (!(movingobjectposition.entityHit instanceof EntityNoRange))) {
	        NoGraceChecks.check((EntityCreature)movingobjectposition.entityHit, getThrower(), this, potency);
	      }
	      if ((movingobjectposition.entityHit instanceof EntityLivingBase)) {
	    	  int duration,glowstone=2;
		        if(this.type==1){duration=200;}else duration=100;
		        if(this.maxed&&this.type==1)glowstone=30;
	        ((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, duration, glowstone));
	        if(this.maxed&&this.type==1)((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Config.imprisonPotID,100,1));
	        if(this.type==2){
	        //TODO drown and kraken (2) and bubble(1)
	        	int kraken=1;
	        	if(this.maxed)kraken=2;
	        	((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Config.drownPotID,400,kraken));
	        	
	        }
	      }
	    }
	    if (!worldObj.isRemote)
	      setDead();
	  }
}
