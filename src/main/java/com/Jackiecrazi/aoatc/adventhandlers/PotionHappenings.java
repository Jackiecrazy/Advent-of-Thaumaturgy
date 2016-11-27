package com.Jackiecrazi.aoatc.adventhandlers;

import java.util.Iterator;
import java.util.List;

import com.Jackiecrazi.aoatc.AscendingPotions;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PotionHappenings {
	@SubscribeEvent
	public void tickPotions(LivingEvent.LivingUpdateEvent e){
		float h =5F;
		EntityLivingBase l = e.entityLiving;
		if(l!=null){
			if(l.isPotionActive(AscendingPotions.Blaze.id)&&l.ticksExisted%20==0){
				if(l.worldObj.isRemote)l.worldObj.spawnParticle("flame", l.posX + l.worldObj.rand.nextDouble() * 0.3, l.posY + l.worldObj.rand.nextDouble() * 0.3, l.posZ + l.worldObj.rand.nextDouble() * 0.3, 0, 0.06d, 0);
				l.attackEntityFrom(DamageSource.generic, l.getActivePotionEffect(AscendingPotions.Blaze).getAmplifier());
			}
			if(l.isPotionActive(AscendingPotions.Spore.id)){
				if(l.ticksExisted%20==0&&l.getHealth()>l.getActivePotionEffect(AscendingPotions.Spore).getAmplifier()) l.attackEntityFrom(DamageSource.generic, l.getActivePotionEffect(AscendingPotions.Spore).getAmplifier());
			}
		}
	}
}
