package com.Jackiecrazi.aoatc.items.foci;

import com.Jackiecrazi.aoatc.Config;
import com.Jackiecrazi.aoatc.entities.projectiles.EntityCustomWind;

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

public class FocusWind extends ItemFocusBasic{
	public static FocusUpgradeType gust = new FocusUpgradeType(Config.gustID, new ResourceLocation("aoatc", "textures/foci/gust.png"), "focus.upgrade.gust.name", "focus.upgrade.gust.text", new AspectList().add(Aspect.AIR, 1).add(Aspect.MOTION, 1));
	public static FocusUpgradeType gale = new FocusUpgradeType(Config.galeID, new ResourceLocation("aoatc", "textures/foci/gale.png"), "focus.upgrade.gale.name", "focus.upgrade.gale.text", new AspectList().add(Aspect.AIR, 1).add(Aspect.MOTION, 1));
	public static FocusUpgradeType tornado = new FocusUpgradeType(Config.tornadoID, new ResourceLocation("aoatc", "textures/foci/tornado.png"), "focus.upgrade.tornado.name", "focus.upgrade.tornado.text", new AspectList().add(Aspect.AIR, 1).add(Aspect.MOTION, 2));
	public static FocusUpgradeType hurricane = new FocusUpgradeType(Config.hurricaneID, new ResourceLocation("aoatc", "textures/foci/hurricane.png"), "focus.upgrade.hurricane.name", "focus.upgrade.hurricane.text", new AspectList().add(Aspect.AIR, 2).add(Aspect.MOTION, 3));
	AspectList viscost = (new AspectList()).add(Aspect.AIR, 30);
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
		if(isUpgradedWith(focusstack, gale)) return 100;
	    return 1000;
	  }
	
	@Override
	public ItemStack onFocusRightClick(ItemStack wandstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition)
	  {
		int kn;
		float gravity = 0.6F;
		ItemWandCasting w = (ItemWandCasting) wandstack.getItem();
		float potency =w.getFocusPotency(wandstack)+5;
		if(isUpgradedWith(w.getFocusItem(wandstack), gust)) gravity = 0;
		if(isUpgradedWith(w.getFocusItem(wandstack), tornado)){ kn = 2;} else kn =0;
		player.worldObj.spawnEntityInWorld(new EntityCustomWind(player.worldObj, player, potency, kn, gravity, isUpgradedWith(w.getFocusItem(wandstack), hurricane)));
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
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency, gust,tornado };
		    case 4:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency };
		    case 5:
		    	if(this.isUpgradedWith(focusstack, gust))
                    return new FocusUpgradeType[] {FocusUpgradeType.potency, FocusUpgradeType.frugal, gale};
                else if(this.isUpgradedWith(focusstack, tornado))
                    return new FocusUpgradeType[] {FocusUpgradeType.potency,FocusUpgradeType.frugal, hurricane};
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
