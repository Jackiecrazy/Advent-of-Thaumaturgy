package com.Jackiecrazi.aoatc.entities.projectiles;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.nevermine.mob.placement.EntityNoRange;
import net.nevermine.projectiles.NoGraceChecks;
import net.nevermine.projectiles.staff.EntityStaffWither;
import net.nevermine.resource.soulpower.soulPowerHelper;

public class EntityCustomWither extends EntityStaffWither{
	private float damage;
	int duration;
	int intensity;
	int curses;
		public EntityCustomWither(World par1World, EntityPlayer par3EntityPlayer,
				float dmg, int knock, float grav,int dur,int intensity,int curse) {
			super(par1World, par3EntityPlayer, dmg, knock, grav);
			this.duration=dur;
			this.intensity=intensity;
			this.curses=curse;
		}
		@Override
		protected void onImpact(MovingObjectPosition movingobjectposition)
		  {
		    if (movingobjectposition.entityHit != null) {
		      if (((movingobjectposition.entityHit instanceof EntityCreature)) && (!(movingobjectposition.entityHit instanceof EntityNoRange))) {
		        NoGraceChecks.check((EntityCreature)movingobjectposition.entityHit, getThrower(), this, damage);
		      }

		      if ((movingobjectposition.entityHit instanceof EntityLivingBase)) {
		        ((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Potion.wither.id, duration, intensity));
		        if(curses==1||curses==4){
		        	((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Potion.weakness.id, duration, 1));
		        	((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, duration, 1));
		        	((EntityLivingBase)movingobjectposition.entityHit).addPotionEffect(new PotionEffect(Potion.hunger.id, duration, 1));
		        }
		        if(curses==2||curses==3){
		        	getThrower().addPotionEffect(new PotionEffect(Potion.moveSpeed.id,duration,1));
		        	getThrower().addPotionEffect(new PotionEffect(Potion.damageBoost.id,duration,1));
		        }
		        if(curses==3){
		        	soulPowerHelper.getProperties((EntityPlayer) getThrower()).regen(100);;
		        }
		        if(curses==4){
		        	EntityPlayer player = (EntityPlayer)getThrower();
		        	PotionEffect[] effects = (PotionEffect[])player.getActivePotionEffects().toArray(new PotionEffect[]{});
		            for(PotionEffect effect : effects){
		            	if(effect.getPotionID()==22&&effect.getAmplifier()<4) {
		            		player.addPotionEffect(new PotionEffect(22, 40, effect.getAmplifier()+1));
		            	}
		            }
		        }
		      }
		    }
		    if (!worldObj.isRemote)
		      setDead();
		  }
}
