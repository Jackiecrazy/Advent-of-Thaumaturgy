package com.Jackiecrazi.aoatc.blocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

import com.Jackiecrazi.aoatc.blocks.*;
public class ModBlocks {
	public static Block Illumination;
	public static Block Quarantino;
	public static void init(){
	Illumination = new Illuminati(Material.air);
	Quarantino=new Illuminati(Material.air).setquarantine(true);
	GameRegistry.registerBlock(Illumination, "Illumination").setLightLevel(15).setBlockName("Illumination");
	GameRegistry.registerBlock(Quarantino, "Quarantino").setLightLevel(15).setBlockName("Quarantino");
	}
}
