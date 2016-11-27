package com.Jackiecrazi.aoatc.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.Jackiecrazi.aoatc.AoATC;
import com.Jackiecrazi.aoatc.entities.minions.EntityFriendlySpiritProtector;

public class DebugSummoner extends Item{
	public DebugSummoner(){
		this.setCreativeTab(AoATC.tabAT);
	}
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer p){
		EntityFriendlySpiritProtector spawn=new EntityFriendlySpiritProtector(world,p);
		spawn.setPosition(p.posX, p.posY, p.posZ);
		if(!world.isRemote){
			world.spawnEntityInWorld(spawn);
		}
		return stack;
	}
}
