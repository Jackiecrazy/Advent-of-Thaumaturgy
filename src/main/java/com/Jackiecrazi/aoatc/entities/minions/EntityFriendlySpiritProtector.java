package com.Jackiecrazi.aoatc.entities.minions;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.nevermine.projectiles.staff.EntityStaffFire;

public class EntityFriendlySpiritProtector extends EntityTameable implements
		IRangedAttackMob {

	public EntityFriendlySpiritProtector(World p_i1604_1_) {
		super(p_i1604_1_);
		getNavigator().setAvoidsWater(true);
	    tasks.addTask(1, new EntityAISwimming(this));
	    tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
	    tasks.addTask(4, new EntityAIAttackOnCollide(this, getMoveSpeed(), true));
	    tasks.addTask(5, new EntityAIFollowOwner(this, getMoveSpeed(), 10.0F, 2.0F));
	    tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	    targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
	    targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
	    targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
	    tasks.addTask(5, new EntityAIAttackOnCollide(this, EntityPlayer.class, getMoveSpeed(), false));
	    targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		setSize(0.9F, 2.3F);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_,
			float p_82196_2_) {
		EntityStaffFire var2 = new EntityStaffFire(worldObj, this, 8.0F, 0,
				0.075F);

		playSound("nevermine:SpiritGuardianShot", 1.0F, 1.0F / (getRNG()
				.nextFloat() * 0.4F + 0.8F));
		worldObj.spawnEntityInWorld(var2);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityFriendlySpiritProtector(World par1World, EntityPlayer p) {
		this(par1World);
		func_152115_b(p.getUniqueID().toString());
		setTamed(true);
	}

	public double getMoveSpeed() {
		return getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.getAttributeValue();
	}
	protected boolean isAIEnabled() {
	    return true;
	  }

	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(
				0.8D);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(
				45.0D);
	}

}
