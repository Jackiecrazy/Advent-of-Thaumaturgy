package com.Jackiecrazi.aoatc;

import com.Jackiecrazi.aoatc.adventhandlers.AdventFuels;
import com.Jackiecrazi.aoatc.blocks.ModBlocks;
import com.Jackiecrazi.aoatc.entities.ModEntities;
import com.Jackiecrazi.aoatc.items.ModItems;
import com.Jackiecrazi.aoatc.researchesnrecipes.*;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
    	AscendingPotions.brew();
    	ModItems.init();
    	ModEntities.init();
    	ModBlocks.init();
    	
    }

    public void init(FMLInitializationEvent e) {
    	AscendingAspects.aspectize();
    	GameRegistry.registerFuelHandler(new AdventFuels());
    }

    public void postInit(FMLPostInitializationEvent e) {
    	AscendingAspects.actuallyaspectizeW();

    	RodsnCaps.addResearch();
    	RodsnCaps.addWandRods();
    	Generic.addGeneric();
    	Armour.addArmor();
    	Foci.addFoci();
    	WeaponAugmentation.augment();
    	Utility.initUtility();
    }
    public Side getSide() {
        return this instanceof ClientProxy ? Side.CLIENT : Side.SERVER;
    }
}
