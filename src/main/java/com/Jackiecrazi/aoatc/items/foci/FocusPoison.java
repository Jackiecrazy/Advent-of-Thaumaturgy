package com.Jackiecrazi.aoatc.items.foci;

import com.Jackiecrazi.aoatc.Config;
import com.Jackiecrazi.aoatc.entities.projectiles.EntityCustomPoison;

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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FocusPoison extends ItemFocusBasic{
	public static FocusUpgradeType gu = new FocusUpgradeType(Config.guID, new ResourceLocation("aoatc", "textures/foci/gu.png"), "focus.upgrade.gu.name", "focus.upgrade.gu.text", new AspectList().add(Aspect.POISON, 5).add(Aspect.DEATH, 2));
	public static FocusUpgradeType pathogen = new FocusUpgradeType(Config.pathogenID, new ResourceLocation("aoatc", "textures/foci/pathogen.png"), "focus.upgrade.pathogen.name", "focus.upgrade.pathogen.text", new AspectList().add(Aspect.POISON, 3).add(Aspect.DEATH, 1));
	public static FocusUpgradeType spore = new FocusUpgradeType(Config.sporeID, new ResourceLocation("aoatc", "textures/foci/spore.png"), "focus.upgrade.spore.name", "focus.upgrade.spore.text", new AspectList().add(Aspect.POISON, 5).add(Aspect.PLANT, 2));
	public static FocusUpgradeType fungus = new FocusUpgradeType(Config.fungusID, new ResourceLocation("aoatc", "textures/foci/fungus.png"), "focus.upgrade.fungus.name", "focus.upgrade.fungus.text", new AspectList().add(Aspect.POISON, 3).add(Aspect.PLANT, 1));
	AspectList viscost = (new AspectList()).add(Aspect.EARTH, 40).add(Aspect.ENTROPY,25);
	@Override
	public int getFocusColor(ItemStack focusstack){
		return 0x006600;
	}
	@Override
	public AspectList getVisCost(ItemStack is){
		return viscost;
	}
	@Override
	public int getActivationCooldown(ItemStack focusstack)
	  {
	    if(isUpgradedWith(focusstack, spore)||isUpgradedWith(focusstack, gu)) return 2000;
	    else return 1000;
	  }
	
	@Override
	public ItemStack onFocusRightClick(ItemStack wandstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition)
	  {
		ItemWandCasting w = (ItemWandCasting) wandstack.getItem();
		float potency =w.getFocusPotency(wandstack)+3;
		int d;
		int i;
		int t=0;
		if(isUpgradedWith(w.getFocusItem(wandstack), fungus)){d=2000;i=1;}
		if(isUpgradedWith(w.getFocusItem(wandstack), pathogen)){d=500;i=4;}
		
		else d=1000;i=2;
		if(isUpgradedWith(w.getFocusItem(wandstack), spore)) t=1;
		if(isUpgradedWith(w.getFocusItem(wandstack), gu)) t=2;
		player.worldObj.spawnEntityInWorld(new EntityCustomPoison(player.worldObj, player, potency, 0, 0.4F,d,i,t));
		player.swingItem();
	    return wandstack;
	    //TODO gu gives buffs (regen energy?), spore pot effect spreads
	  }
	@Override
	public FocusUpgradeType[] getPossibleUpgradesByRank(ItemStack focusstack, int rank)
	  {
		switch (rank) { case 1:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency };
		    case 2:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency };
		    case 3:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency, pathogen,fungus };
		    case 4:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency };
		    case 5:
		    	if(this.isUpgradedWith(focusstack, pathogen))
                    return new FocusUpgradeType[] {FocusUpgradeType.potency, FocusUpgradeType.frugal, gu};
                else if(this.isUpgradedWith(focusstack, fungus))
                    return new FocusUpgradeType[] {FocusUpgradeType.potency,FocusUpgradeType.frugal, spore};
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
