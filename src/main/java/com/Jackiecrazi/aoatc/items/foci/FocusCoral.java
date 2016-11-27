package com.Jackiecrazi.aoatc.items.foci;

import java.util.Iterator;
import java.util.List;

import com.Jackiecrazi.aoatc.Config;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
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

public class FocusCoral extends ItemFocusBasic{
	public static FocusUpgradeType mending = new FocusUpgradeType(Config.mendingID, new ResourceLocation("aoatc", "textures/foci/mending.png"), "focus.upgrade.mending.name", "focus.upgrade.mending.text", new AspectList().add(Aspect.HEAL, 1).add(Aspect.LIFE, 1));
	public static FocusUpgradeType shielding = new FocusUpgradeType(Config.shieldingID, new ResourceLocation("aoatc", "textures/foci/shielding.png"), "focus.upgrade.shielding.name", "focus.upgrade.shielding.text", new AspectList().add(Aspect.ARMOR, 1).add(Aspect.LIFE, 1));
	public static FocusUpgradeType medic = new FocusUpgradeType(Config.medicID, new ResourceLocation("aoatc", "textures/foci/medic.png"), "focus.upgrade.medic.name", "focus.upgrade.medic.text", new AspectList().add(Aspect.HEAL, 1).add(Aspect.LIFE, 1));
	AspectList viscost = (new AspectList()).add(Aspect.WATER, 1500).add(Aspect.ORDER,1500);
	@Override
	public int getFocusColor(ItemStack focusstack){
		return 0x99FFFF;
	}
	@Override
	public AspectList getVisCost(ItemStack is){
		return viscost;
	}
	@Override
	public int getActivationCooldown(ItemStack focusstack)
	  {
	    return this.isUpgradedWith(focusstack, mending)? 12000:6000;
	  }
	
	@Override
	public ItemStack onFocusRightClick(ItemStack wandstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition)
	  {
		ItemWandCasting w = (ItemWandCasting) wandstack.getItem();
		int potency;
		float range = 5;
		if(isUpgradedWith(w.getFocusItem(wandstack), mending)) potency = 4;
		else if(isUpgradedWith(w.getFocusItem(wandstack), shielding)) potency =2; else potency =3;
		player.addPotionEffect(new PotionEffect(21, 1000, potency));
		if(isUpgradedWith(w.getFocusItem(wandstack), shielding))player.addPotionEffect(new PotionEffect(Potion.resistance.id,200,2));
		if(isUpgradedWith(w.getFocusItem(wandstack),medic)){
			List<EntityTameable> entities = world.getEntitiesWithinAABB(EntityTameable.class, AxisAlignedBB.getBoundingBox(player.posX - range, player.posY - range, player.posZ - range, player.posX + range, player.posY + range, player.posZ + range));
            if (!entities.isEmpty())
            {
                Iterator iterator = entities.iterator();

                while (iterator.hasNext())
                {
                    EntityTameable entitylivingbase = (EntityTameable)iterator.next();
                    double d0 = player.getDistanceSqToEntity(entitylivingbase);

                    if (d0 < 16.0D)
                    {
                    	entitylivingbase.addPotionEffect(new PotionEffect(Potion.regeneration.id, 100, 2));
                }
            }
		}
            player.addPotionEffect(new PotionEffect(Potion.regeneration.id,80,1));
		}
	    return wandstack;
	  }
	@Override
	public FocusUpgradeType[] getPossibleUpgradesByRank(ItemStack focusstack, int rank)
	  {
		switch (rank) { case 1:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal};
		    case 2:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal};
		    case 3:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal,mending,shielding };
		    case 4:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal };
		    case 5:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, medic };
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
