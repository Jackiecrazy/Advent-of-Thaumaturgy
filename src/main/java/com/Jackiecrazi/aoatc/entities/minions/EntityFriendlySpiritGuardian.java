package com.Jackiecrazi.aoatc.entities.minions;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
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
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.nevermine.izer.Itemizer;

public class EntityFriendlySpiritGuardian extends EntityTameable {

	public EntityFriendlySpiritGuardian(World p_i1604_1_) {
		super(p_i1604_1_);
		setSize(0.9F, 2.3F);
		getNavigator().setAvoidsWater(true);
		tasks.addTask(1, new EntityAISwimming(this));
		tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		tasks.addTask(4,
				new EntityAIAttackOnCollide(this, getMoveSpeed(), true));
		tasks.addTask(5, new EntityAIFollowOwner(this, getMoveSpeed(), 10.0F,
				2.0F));
		tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class,
				8.0F));
		targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(5, new EntityAIAttackOnCollide(this, EntityPlayer.class,
				getMoveSpeed(), false));
		targetTasks.addTask(6, new EntityAINearestAttackableTarget(this,
				EntityLiving.class, 0, false, true, IMob.mobSelector));
	}

	protected String getLivingSound() {
		return "nevermine:SpiritLiving";
	}

	protected String getDeathSound() {
		return "nevermine:SpiritDeath";
	}

	protected String getHurtSound() {
		return "nevermine:SpiritLiving";
	}

	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(
				0.8D);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(
				45.0D);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		return null;
	}

	public boolean isAIEnabled() {
		return true;
	}

	public EntityFriendlySpiritGuardian(World par1World, EntityPlayer p) {
		this(par1World);
		func_152115_b(p.getUniqueID().toString());
		setTamed(true);
	}

	public boolean interact(EntityPlayer par1EntityPlayer) {
		ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

		if ((var2 != null) && (var2.getItem() == Items.cookie)) {
			heal(20.0F);
			playLivingSound();
			var2.stackSize -= 1;
		}

		if (isTamed()) {
			if ((var2 != null) && (var2.getItem() == Itemizer.KineticRune)) {
				par1EntityPlayer.addPotionEffect(new PotionEffect(
						Potion.moveSpeed.id, 150, 3));
				par1EntityPlayer.inventory
						.consumeInventoryItem(Itemizer.KineticRune);
			}
		} else {
			setTamed(true);
			func_152115_b(par1EntityPlayer.getUniqueID().toString());
		}
		return super.interact(par1EntityPlayer);
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this),
				13.0F);
	}

	public double getMoveSpeed() {
		return getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.getAttributeValue();
	}
}
