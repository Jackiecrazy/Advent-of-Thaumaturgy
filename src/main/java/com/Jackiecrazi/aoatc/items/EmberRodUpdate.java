package com.Jackiecrazi.aoatc.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import thaumcraft.api.wands.IWandRodOnUpdate;

public class EmberRodUpdate implements IWandRodOnUpdate{

	public void onUpdate(ItemStack wand,
			EntityPlayer p) {
		if(!wand.hasTagCompound()){
			wand.setTagCompound(new NBTTagCompound());
    		wand.getTagCompound().setString("owner", p.getUniqueID().toString());
    		}
	}

}
