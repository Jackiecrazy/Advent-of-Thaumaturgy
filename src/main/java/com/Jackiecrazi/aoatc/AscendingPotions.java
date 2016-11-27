package com.Jackiecrazi.aoatc;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;

public class AscendingPotions extends Potion{
	public static Potion Blaze;
	public static Potion Spore;
	public static Potion Drown;
	public static Potion Imprism;
	public static Potion Fear;
	final int tickrate;
	final int halvetick;
	public final int identity;
private ItemStack stackIcon;
	public AscendingPotions(int id, boolean isBad,
			int colour, int tick, int halvetick, int icon) {
		super(id, isBad, colour);
		this.tickrate=tick;
		this.halvetick=tick;
		this.setIcon(new ItemStack(Items.blaze_powder));
		this.identity=id;
	}
	public void setIcon(ItemStack i){
		stackIcon=i;
	}
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc)
	  {
		x+=6;
		y+=7;
		RenderItem itemRender = new RenderItem();
	    if (stackIcon == null) stackIcon = new ItemStack(Items.potato);
	    RenderHelper.enableGUIStandardItemLighting();
	    itemRender.renderItemIntoGUI(mc.fontRenderer, mc.renderEngine, stackIcon, x, y, false);
	    RenderHelper.enableStandardItemLighting();
	  }
	@Override
	public boolean isReady(int duration, int amplifier)
	{
		return duration%20==0;
	}
	@Override
	public void performEffect(EntityLivingBase l, int p_76394_2_){
		Random r=new Random();
		if(identity==Config.blazePotID){
			if(l.worldObj.isRemote)l.worldObj.spawnParticle("flame", l.posX + l.worldObj.rand.nextDouble() * 0.3, l.posY + l.worldObj.rand.nextDouble() * 0.3, l.posZ + l.worldObj.rand.nextDouble() * 0.3, 0, 0.06d, 0);
			l.attackEntityFrom(DamageSource.generic, l.getActivePotionEffect(AscendingPotions.Blaze).getAmplifier());
		}
		if(identity==Config.sporePotID&&l.getHealth()>l.getActivePotionEffect(AscendingPotions.Spore).getAmplifier()) l.attackEntityFrom(DamageSource.generic, l.getActivePotionEffect(AscendingPotions.Spore).getAmplifier());
		if(identity==Config.drownPotID){
			int potency=l.getActivePotionEffect(AscendingPotions.Drown).getAmplifier();
			if(potency>=1)l.setAir(0);
			if(potency>=2&&l.isInWater()){l.motionY-=potency;
			l.addVelocity(0d, -potency, 0d);
			}
			l.attackEntityFrom(DamageSource.drown, potency);
		}
		if(identity==Config.imprisonPotID){
			l.motionY=0.1;
			l.addVelocity(0d, 0.1, 0d);
			l.motionX=0;
			l.motionZ=0;
			l.onGround=false;
		}
		if(identity==Config.fearPotID){
			if(l instanceof EntityCreature){
				EntityCreature b=(EntityCreature)l;
				b.setAttackTarget(null);
				b.getNavigator().clearPathEntity();
				if(r.nextInt(999)==0)
				b.tasks.taskEntries.clear();
				b.targetTasks.taskEntries.clear();
			}
		}
	}
	public static void brew(){
		Blaze = new AscendingPotions(Config.blazePotID,true,3035801, 20,20,1).setPotionName("potion.blaze");
		Spore=new AscendingPotions(Config.sporePotID,true,3035801,20,20,1).setPotionName("potion.spore");
		Drown=new AscendingPotions(Config.drownPotID,true,3035801,20,20,1).setPotionName("potion.drown");
		Imprism=new AscendingPotions(Config.imprisonPotID,true,3035801,20,20,1).setPotionName("potion.imprison");
		Fear=new AscendingPotions(Config.fearPotID,true,3035801,20,20,1).setPotionName("potion.fear");
	}
	
}
