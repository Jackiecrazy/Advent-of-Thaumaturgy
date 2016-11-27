package com.Jackiecrazi.aoatc;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTThingyMajiggy {
	public static NBTTagCompound get(ItemStack s){
		return getData(s);
		
	}
	public static NBTTagCompound getData(ItemStack stack) {
        NBTTagCompound compound = stack.getTagCompound();
        if(compound == null) {
            compound = new NBTTagCompound();
            stack.setTagCompound(compound);
        }
        return compound;
    }
}
