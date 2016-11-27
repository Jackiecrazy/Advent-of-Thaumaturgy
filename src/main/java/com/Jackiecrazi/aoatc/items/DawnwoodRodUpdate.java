package com.Jackiecrazi.aoatc.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.wands.IWandRodOnUpdate;
import thaumcraft.common.items.wands.ItemWandCasting;

public class DawnwoodRodUpdate implements IWandRodOnUpdate{

    public void onUpdate(ItemStack itemstack, EntityPlayer player) {
    	if(player.ticksExisted % 100 == 0){
            if (((ItemWandCasting) itemstack.getItem()).getVis(itemstack, Aspect.ENTROPY) < ((ItemWandCasting) itemstack.getItem()).getMaxVis(itemstack)) {
                ((ItemWandCasting) itemstack.getItem()).addVis(itemstack, Aspect.ENTROPY, 1, true);
            }
    	}
        }
    }
