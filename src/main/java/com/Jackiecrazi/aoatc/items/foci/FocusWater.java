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
import com.Jackiecrazi.aoatc.entities.projectiles.EntityCustomWater;
import com.Jackiecrazi.aoatc.entities.projectiles.EntityCustomWind;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FocusWater extends ItemFocusBasic{
	public static FocusUpgradeType bubble = new FocusUpgradeType(Config.bubbleID, new ResourceLocation("aoatc", "textures/foci/bubble.png"), "focus.upgrade.bubble.name", "focus.upgrade.bubble.text", new AspectList().add(Aspect.WATER, 2).add(Aspect.ORDER, 1));
	public static FocusUpgradeType imprison = new FocusUpgradeType(Config.imprisonID, new ResourceLocation("aoatc", "textures/foci/imprison.png"), "focus.upgrade.imprison.name", "focus.upgrade.imprison.text", new AspectList().add(Aspect.WATER, 2).add(Aspect.TRAP, 2));
	public static FocusUpgradeType drown = new FocusUpgradeType(Config.drownID, new ResourceLocation("aoatc", "textures/foci/drown.png"), "focus.upgrade.drown.name", "focus.upgrade.drown.text", new AspectList().add(Aspect.WATER, 1).add(Aspect.DEATH, 2));
	public static FocusUpgradeType kraken = new FocusUpgradeType(Config.krakenID, new ResourceLocation("aoatc", "textures/foci/kraken.png"), "focus.upgrade.kraken.name", "focus.upgrade.kraken.text", new AspectList().add(Aspect.WATER, 2).add(Aspect.BEAST, 3));
	AspectList viscost = (new AspectList()).add(Aspect.WATER, 30);
	@Override
	public int getFocusColor(ItemStack focusstack){
		return 0xFFFFFF;
	}
	@Override
	public AspectList getVisCost(ItemStack is){
		return viscost;
	}
	@Override
	public int getActivationCooldown(ItemStack focusstack)
	  {
		if(isUpgradedWith(focusstack, imprison)) return 100;
	    return 1000;
	  }
	
	@Override
	public ItemStack onFocusRightClick(ItemStack wandstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition)
	  {
		int kn=0;
		int type=0;
		boolean maxed=false;
		float gravity = 0.6F;
		ItemWandCasting w = (ItemWandCasting) wandstack.getItem();
		float potency =w.getFocusPotency(wandstack)+5;
		if(isUpgradedWith(w.getFocusItem(wandstack), bubble)){ type = 1;gravity=-1F;}
		if(isUpgradedWith(w.getFocusItem(wandstack), drown))type=2;
		if(isUpgradedWith(w.getFocusItem(wandstack), kraken)||isUpgradedWith(w.getFocusItem(wandstack), imprison))maxed=true;
		player.worldObj.spawnEntityInWorld(new EntityCustomWater(player.worldObj, player, potency, kn, gravity, type,maxed));
		player.swingItem();
	    return wandstack;
	  }
	@Override
	public FocusUpgradeType[] getPossibleUpgradesByRank(ItemStack focusstack, int rank)
	  {
		switch (rank) { case 1:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency };
		    case 2:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency };
		    case 3:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency, bubble,drown };
		    case 4:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency };
		    case 5:
		    	if(this.isUpgradedWith(focusstack, bubble))
                    return new FocusUpgradeType[] {FocusUpgradeType.potency, FocusUpgradeType.frugal, imprison};
                else if(this.isUpgradedWith(focusstack, drown))
                    return new FocusUpgradeType[] {FocusUpgradeType.potency,FocusUpgradeType.frugal, kraken};
                else
                    return new FocusUpgradeType[] {FocusUpgradeType.potency,FocusUpgradeType.frugal};
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
