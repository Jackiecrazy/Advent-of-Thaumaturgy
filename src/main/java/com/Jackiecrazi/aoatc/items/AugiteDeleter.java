package com.Jackiecrazi.aoatc.items;

import com.Jackiecrazi.aoatc.AoATC;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AugiteDeleter extends Item{
	public AugiteDeleter(){
		this.setCreativeTab(AoATC.tabAT);
		this.setUnlocalizedName("AugiteDeleter");
		this.setMaxStackSize(1);
	}
}
