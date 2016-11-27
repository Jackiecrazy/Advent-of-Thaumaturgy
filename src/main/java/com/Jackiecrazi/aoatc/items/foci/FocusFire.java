package com.Jackiecrazi.aoatc.items.foci;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.FocusUpgradeType;
import thaumcraft.api.wands.ItemFocusBasic;
import thaumcraft.common.items.wands.ItemWandCasting;

import com.Jackiecrazi.aoatc.Config;
import com.Jackiecrazi.aoatc.entities.projectiles.EntityCustomFire;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FocusFire extends ItemFocusBasic{
	public static FocusUpgradeType light = new FocusUpgradeType(Config.lightID, new ResourceLocation("aoatc", "textures/foci/light.png"), "focus.upgrade.light.name", "focus.upgrade.light.text", new AspectList().add(Aspect.AIR, 1).add(Aspect.MOTION, 1));
	public static FocusUpgradeType quarantine = new FocusUpgradeType(Config.quarantineID, new ResourceLocation("aoatc", "textures/foci/light.png"), "focus.upgrade.quarantine.name", "focus.upgrade.quarantine.text", new AspectList().add(Aspect.AIR, 1).add(Aspect.MOTION, 1));
	public static FocusUpgradeType blaze = new FocusUpgradeType(Config.blazeID, new ResourceLocation("aoatc", "textures/foci/light.png"), "focus.upgrade.blaze.name", "focus.upgrade.blaze.text", new AspectList().add(Aspect.AIR, 1).add(Aspect.MOTION, 2));
	public static FocusUpgradeType hellfire = new FocusUpgradeType(Config.hellfireID, new ResourceLocation("aoatc", "textures/foci/light.png"), "focus.upgrade.hellfire.name", "focus.upgrade.hellfire.text", new AspectList().add(Aspect.AIR, 2).add(Aspect.MOTION, 3));
	AspectList viscost = (new AspectList()).add(Aspect.FIRE, 30);
	@Override
	public boolean isVisCostPerTick(ItemStack focusstack)
	  {
	    return isUpgradedWith(focusstack,hellfire);
	  }
	@Override
	public int getFocusColor(ItemStack focusstack){
		return 0xFF0000;
	}
	@Override
	public AspectList getVisCost(ItemStack is){
		return viscost;
	}
	@Override
	public int getActivationCooldown(ItemStack focusstack)
	  {
		if(isUpgradedWith(focusstack, quarantine)) return 1000;
		else if(isUpgradedWith(focusstack, hellfire)) return 10;
	    return 100;
	  }
	
	@Override
	public ItemStack onFocusRightClick(ItemStack wandstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition)
	  {
		int kn;
		ItemWandCasting w = (ItemWandCasting) wandstack.getItem();
		float potency =w.getFocusPotency(wandstack)+5;
		if(isUpgradedWith(w.getFocusItem(wandstack), light)) kn=1;
		if(isUpgradedWith(w.getFocusItem(wandstack), quarantine))kn=3;
		if(isUpgradedWith(w.getFocusItem(wandstack), hellfire))kn=4;
		if(isUpgradedWith(w.getFocusItem(wandstack), blaze)){ kn = 2;} else kn =0;
		player.worldObj.spawnEntityInWorld(new EntityCustomFire(player.worldObj, player, potency, 0, 0.6F,w.getFocusPotency(wandstack), kn));
		//TODO lights add lights, quarantine prevents mob spawns, blaze can burn anything (pot effect), hellfire makes constant
		player.swingItem();
	    return wandstack;
	  }
	@Override
	public void onUsingFocusTick(ItemStack wandstack, EntityPlayer player, int count)
	  {
		ItemWandCasting w = (ItemWandCasting) wandstack.getItem();
		if(isUpgradedWith(w.getFocusItem(wandstack),hellfire)){
			float potency =(float) (w.getFocusPotency(wandstack)+0.5);
			player.worldObj.spawnEntityInWorld(new EntityCustomFire(player.worldObj, player, potency, 0, 0.6F,w.getFocusPotency(wandstack)+(w.getFocus(wandstack).getUpgradeLevel(wandstack, FocusUpgradeType.alchemistsfire)*2), 2));
		}
	  }
	@Override
	public FocusUpgradeType[] getPossibleUpgradesByRank(ItemStack focusstack, int rank)
	  {
		switch (rank) { case 1:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency,FocusUpgradeType.alchemistsfire };
		    case 2:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency };
		    case 3:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency,FocusUpgradeType.alchemistsfire, light,blaze };
		    case 4:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency };
		    case 5:
		    	if(this.isUpgradedWith(focusstack, light))
                    return new FocusUpgradeType[] {FocusUpgradeType.potency, FocusUpgradeType.frugal,FocusUpgradeType.alchemistsfire, quarantine};
                else if(this.isUpgradedWith(focusstack, blaze))
                    return new FocusUpgradeType[] {FocusUpgradeType.potency,FocusUpgradeType.frugal,FocusUpgradeType.alchemistsfire, hellfire};
                else
                    return new FocusUpgradeType[] {FocusUpgradeType.potency,FocusUpgradeType.frugal,FocusUpgradeType.alchemistsfire};
		    }
		    return null;
	  }
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_)
    {
        this.itemIcon = p_94581_1_.registerIcon(this.getIconString());
        this.icon = this.itemIcon;
    }
}
