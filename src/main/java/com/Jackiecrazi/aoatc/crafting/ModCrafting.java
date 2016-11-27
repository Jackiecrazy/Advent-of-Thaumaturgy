package com.Jackiecrazi.aoatc.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;


import cpw.mods.fml.common.registry.GameRegistry;

public class ModCrafting {
	public static void initCrafting(){
		GameRegistry.addRecipe(new ItemStack(Items.apple), "n", "n", "n", 'n', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(Items.baked_potato), "a", "b", "c", 'b', Items.iron_ingot, 'a', Items.gold_ingot, 'c', Items.stick);
	}
}
