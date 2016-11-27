package com.Jackiecrazi.aoatc.items;
import com.Jackiecrazi.aoatc.blocks.ModBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.IWandRodOnUpdate;
import thaumcraft.common.items.wands.ItemWandCasting;

public class LunossoRodUpdate implements IWandRodOnUpdate{

	public void onUpdate(ItemStack paramItemStack,
			EntityPlayer paramEntityPlayer) {
		ItemWandCasting wand = (ItemWandCasting)paramItemStack.getItem();
		AspectList al = (wand.getAllVis(paramItemStack));
		if(al.getAmount(Aspect.AIR)>=1&&al.getAmount(Aspect.FIRE)>=1&&paramEntityPlayer.ticksExisted%200==0){
			wand.consumeAllVis(paramItemStack, paramEntityPlayer, al, true, false);
			paramEntityPlayer.worldObj.setBlock((int)paramEntityPlayer.posX, (int)paramEntityPlayer.posY, (int)paramEntityPlayer.posZ, ModBlocks.Illumination);
		}
		
	}

}
