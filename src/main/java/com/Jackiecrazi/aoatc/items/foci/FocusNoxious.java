package com.Jackiecrazi.aoatc.items.foci;

import java.util.Random;

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
import com.Jackiecrazi.aoatc.entities.projectiles.EntityCustomPoison;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FocusNoxious extends ItemFocusBasic{
	public static FocusUpgradeType noxious = new FocusUpgradeType(Config.noxiousID, new ResourceLocation("aoatc", "textures/foci/noxious.png"), "focus.upgrade.noxious.name", "focus.upgrade.noxious.text", new AspectList().add(Aspect.POISON, 1).add(Aspect.ORDER, 1));
	public static FocusUpgradeType toxic = new FocusUpgradeType(Config.toxicID, new ResourceLocation("aoatc", "textures/foci/toxic.png"), "focus.upgrade.toxic.name", "focus.upgrade.toxic.text", new AspectList().add(Aspect.POISON, 1).add(Aspect.ENTROPY, 1));
	public static FocusUpgradeType evolve = new FocusUpgradeType(Config.evolvedID, new ResourceLocation("thaumcraft", "textures/items/brain.png"), "focus.upgrade.evolve.name", "focus.upgrade.evolved.text", new AspectList().add(Aspect.MIND, 1).add(Aspect.ORDER, 1));
	public static FocusUpgradeType fused = new FocusUpgradeType(Config.fusedID, new ResourceLocation("aoatc", "textures/foci/fused.png"), "focus.upgrade.fused.name", "focus.upgrade.fused.text", new AspectList().add(Aspect.EXCHANGE, 1).add(Aspect.ORDER, 1));
	AspectList viscost = (new AspectList()).add(Aspect.EARTH, 80).add(Aspect.ENTROPY,50);
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
	    if(isUpgradedWith(focusstack, fused)) return 4000;
	    else return 2000;
	  }
	
	@Override
	public ItemStack onFocusRightClick(ItemStack wandstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition)
	  {
		int dmg;
		Random r = new Random();
		float gravity = r.nextFloat();
		float dev1= r.nextFloat();
		float dev2=r.nextFloat();
		ItemWandCasting w = (ItemWandCasting) wandstack.getItem();
		if(isUpgradedWith(w.getFocusItem(wandstack), toxic)){ dmg = 2; dev1=0.5F;dev2=0.3F;} else dmg =0;
		float potency =w.getFocusPotency(wandstack)+dmg+7;
		if(isUpgradedWith(w.getFocusItem(wandstack), fused)) potency=(w.getFocusPotency(wandstack)+dmg+7)*3;
		if(isUpgradedWith(w.getFocusItem(wandstack), evolve)){ gravity = 0;dev1=0.2F;dev2=0.1F;}
		int d;
		int i;
		if(isUpgradedWith(w.getFocusItem(wandstack), noxious)){d=200;i=3;}else d=100;i=3;
		player.worldObj.spawnEntityInWorld(new EntityCustomPoison(player.worldObj, player, potency, 0, 0.4F,d,i,0));
	    if(!isUpgradedWith(w.getFocusItem(wandstack), fused)){
	    	player.worldObj.spawnEntityInWorld(new EntityCustomPoison(player.worldObj, player, potency, 0, gravity+dev1,d,i,0));
	    	player.worldObj.spawnEntityInWorld(new EntityCustomPoison(player.worldObj, player, potency, 0, gravity+dev2,d,i,0));
	    	player.worldObj.spawnEntityInWorld(new EntityCustomPoison(player.worldObj, player, potency, 0, gravity+dev1,d,i,0));
	    	player.worldObj.spawnEntityInWorld(new EntityCustomPoison(player.worldObj, player, potency, 0, gravity+dev2,d,i,0));
	  }
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
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency, noxious,toxic };
		    case 4:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency };
		    case 5:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency, fused };
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
