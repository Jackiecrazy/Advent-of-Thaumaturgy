package com.Jackiecrazi.aoatc.items.armour;

import com.Jackiecrazi.aoatc.AoATC;

import thaumcraft.common.items.armor.ItemVoidRobeArmor;

public class ArmourEnderViking extends ItemVoidRobeArmor {

	public ArmourEnderViking(String name, ArmorMaterial enumarmormaterial, int render, int slot) {
		super(enumarmormaterial, render, slot);
		// TODO Auto-generated constructor stub
		this.setCreativeTab(AoATC.tabAT);
		this.setUnlocalizedName(name);
	}

}
