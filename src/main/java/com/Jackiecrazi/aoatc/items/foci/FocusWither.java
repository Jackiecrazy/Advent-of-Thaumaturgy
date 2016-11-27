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
import com.Jackiecrazi.aoatc.entities.projectiles.EntityCustomWither;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FocusWither extends ItemFocusBasic{
	public static FocusUpgradeType gongtau = new FocusUpgradeType(Config.gongtauID, new ResourceLocation("aoatc", "textures/foci/gongtau.png"), "focus.upgrade.gongtau.name", "focus.upgrade.gongtau.text", new AspectList().add(Aspect.POISON, 5).add(Aspect.DEATH, 2));
	public static FocusUpgradeType blackmagic = new FocusUpgradeType(Config.blackmagicID, new ResourceLocation("aoatc", "textures/foci/blackmagic.png"), "focus.upgrade.blackmagic.name", "focus.upgrade.blackmagic.text", new AspectList().add(Aspect.POISON, 3).add(Aspect.DEATH, 1));
	public static FocusUpgradeType voodoo = new FocusUpgradeType(Config.voodooID, new ResourceLocation("aoatc", "textures/foci/ph.png"), "focus.upgrade.voodoo.name", "focus.upgrade.voodoo.text", new AspectList().add(Aspect.POISON, 5).add(Aspect.PLANT, 2));
	public static FocusUpgradeType curse = new FocusUpgradeType(Config.curseID, new ResourceLocation("aoatc", "textures/foci/voodoo.png"), "focus.upgrade.curse.name", "focus.upgrade.curse.text", new AspectList().add(Aspect.POISON, 3).add(Aspect.PLANT, 1));
	AspectList viscost = (new AspectList()).add(Aspect.EARTH, 60).add(Aspect.ENTROPY,30);
	@Override
	public int getFocusColor(ItemStack focusstack){
		return 0x000000;
	}
	@Override
	public AspectList getVisCost(ItemStack is){
		return viscost;
	}
	@Override
	public int getActivationCooldown(ItemStack focusstack)
	  {
	    if(isUpgradedWith(focusstack, gongtau)||isUpgradedWith(focusstack, voodoo)) return 2000;
	    else return 1000;
	  }
	
	@Override
	public ItemStack onFocusRightClick(ItemStack wandstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition)
	  {
		ItemWandCasting w = (ItemWandCasting) wandstack.getItem();
		float potency =w.getFocusPotency(wandstack)+3;
		int d,i,c = 0;
		if(isUpgradedWith(w.getFocusItem(wandstack), gongtau)){d=500;i=4;c=3;}
		else if(isUpgradedWith(w.getFocusItem(wandstack), voodoo)){d=2000;i=1;c=4;}
		else if(isUpgradedWith(w.getFocusItem(wandstack), blackmagic)){d=500;i=4;c=2;}
		else if(isUpgradedWith(w.getFocusItem(wandstack), curse)){d=2000;i=1;c=1;}
		else d=1000;i=2;
		player.worldObj.spawnEntityInWorld(new EntityCustomWither(player.worldObj, player, potency, 0, 0.4F, d, i,c));
		player.swingItem();
	    return wandstack;
	    //TODO voodoo heals player, gongtau regens soul power?
	  }
	@Override
	public FocusUpgradeType[] getPossibleUpgradesByRank(ItemStack focusstack, int rank)
	  {
		switch (rank) { case 1:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency };
		    case 2:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency };
		    case 3:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency, curse,blackmagic };
		    case 4:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency };
		    case 5:
		    	if(this.isUpgradedWith(focusstack, curse))
                    return new FocusUpgradeType[] {FocusUpgradeType.potency, FocusUpgradeType.frugal, voodoo};
                else if(this.isUpgradedWith(focusstack, blackmagic))
                    return new FocusUpgradeType[] {FocusUpgradeType.potency,FocusUpgradeType.frugal, gongtau};
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