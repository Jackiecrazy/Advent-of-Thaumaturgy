package com.Jackiecrazi.aoatc;

	import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;

import com.Jackiecrazi.aoatc.adventhandlers.AdventofEvent;
import com.Jackiecrazi.aoatc.adventhandlers.PotionHappenings;
import com.Jackiecrazi.aoatc.adventhandlers.TickPlayerThings;
import com.Jackiecrazi.aoatc.items.DawnwoodRodUpdate;
import com.Jackiecrazi.aoatc.items.GenericRodUpdate;
import com.Jackiecrazi.aoatc.items.ModItems;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;



	@Mod(modid = "AoATC", version = AoATC.MODVER, name = "Advent of Thaumaturgy",dependencies ="required-after:Thaumcraft;required-after:nevermine")
	public class AoATC
	{
		public static Potion potBlaze,potSpore;
		@Mod.Instance("AoATC")
		public static AoATC inst;
	    public static final String MODID = "AoATC";
	    public static final String MODVER = "0.0";
	    public static Item fword= ModItems.wandCore;
	    DawnwoodRodUpdate dawn = new DawnwoodRodUpdate();
	    AdventofEvent eventhandler = new AdventofEvent();
	    TickPlayerThings playertick=new TickPlayerThings();
	    PotionHappenings potion=new PotionHappenings();
	    @SidedProxy(clientSide="com.Jackiecrazi.aoatc.ClientProxy", serverSide="com.Jackiecrazi.aoatc.ServerProxy")
	    public static CommonProxy proxy;
	    public static CreativeTabs tabAT = new CreativeTabs("Advent of Thaumaturgy"){
	    @Override
	    public Item getTabIconItem() {
	    	return ModItems.AugiteDeleter;
	    	}
	    };
	    @EventHandler
	    public void init(FMLPreInitializationEvent event)
	    {
	    	Config.CreatioExNihilo(event.getSuggestedConfigurationFile());
	    	this.proxy.preInit(event);
	    	//Stuff I need
	    	FMLCommonHandler.instance().bus().register(dawn);
	    	MinecraftForge.EVENT_BUS.register(dawn);
	    	FMLCommonHandler.instance().bus().register(eventhandler);
	    	MinecraftForge.EVENT_BUS.register(eventhandler);
	    	FMLCommonHandler.instance().bus().register(playertick);
	    	MinecraftForge.EVENT_BUS.register(playertick);
	    	FMLCommonHandler.instance().bus().register(potion);
	    	/*MinecraftForge.EVENT_BUS.register(potion);*/
	    	//TODO that is not how to correctly register potions.
	    		
	    }
	    @EventHandler
	    public void init(FMLInitializationEvent event)
	    {
	    	this.proxy.init(event);
	    	gottaLootThemAll();
	    }
	    @EventHandler
	    public void init(FMLPostInitializationEvent event)
	    {
	    	this.proxy.postInit(event);
	    }
	    private void gottaLootThemAll(){
	    	addLoot(new WeightedRandomChestContent(new ItemStack(fword), 1, 1, 4), false);
	    }
		private void addLoot(WeightedRandomChestContent loot, boolean bonus) {
			ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(loot);
			ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(loot);
			ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(loot);
			ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(loot);
			ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(loot);
			ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(loot);
		}
	}

