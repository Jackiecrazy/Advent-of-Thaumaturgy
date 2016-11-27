package com.Jackiecrazi.aoatc.items;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.wands.WandCap;

public class AscendingCap extends WandCap{
	public AscendingCap(String tag, float discount, ItemStack item, int craftCost, ResourceLocation texture) {
	    super(tag,discount,item,craftCost);
	    setTexture(texture);
	  }

	  public AscendingCap(String tag, float discount, List<Aspect> specialAspects, float discountSpecial, ItemStack item, int craftCost,ResourceLocation texture) {
		  super(tag,discount,specialAspects,discountSpecial,item,craftCost);
		    setTexture(texture);
	  }
}
