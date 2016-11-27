package com.Jackiecrazi.aoatc.adventhandlers;

import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.WandRod;
import thaumcraft.common.items.wands.ItemWandCasting;

import com.Jackiecrazi.aoatc.items.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.IFuelHandler;

public class AdventFuels implements IFuelHandler{

	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() instanceof ItemWandCasting) {
			ItemWandCasting wand = (ItemWandCasting) fuel.getItem();
			WandRod test = wand.getRod(fuel);
			if (test == ModItems.rod_ember&&wand.getVis(fuel, Aspect.FIRE)>=5) {
				return 200;
			}
		}
		else return 0;
		return 0;
	}
	
}
