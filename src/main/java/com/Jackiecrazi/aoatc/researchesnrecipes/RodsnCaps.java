package com.Jackiecrazi.aoatc.researchesnrecipes;

import java.util.HashMap;

import com.Jackiecrazi.aoatc.AscendingAspects;
import com.Jackiecrazi.aoatc.items.ModItems;

import net.nevermine.block.generation.wood.*;
import net.nevermine.izer.*;
import net.nevermine.izer.equipment.Armorizer;
import net.nevermine.izer.equipment.Weaponizer;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.config.ConfigItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class RodsnCaps {
	public static HashMap recipes = new HashMap();

	public static void addResearch() {
		ResearchCategories.registerCategory("AOATC", new ResourceLocation(
				"nevermine", "textures/items/abominator.png"),
				new ResourceLocation("thaumcraft",
						"textures/gui/gui_researchback.png"));

	}

	public static void addWandRods(){
    	
    	InfusionRecipe DawnWandcore = 
    			ThaumcraftApi.addInfusionCraftingRecipe("ROD_Dawnwood", new ItemStack(ModItems.wandCore,1,0), 4, new AspectList().add(AscendingAspects.DIMENSION, 16).add(Aspect.ENTROPY, 8).add(Aspect.TREE, 16).add(Aspect.MAGIC, 16),new ItemStack(Blockizer.WoodDawn), new ItemStack[]{new ItemStack(Items.diamond),new ItemStack(Items.diamond),new ItemStack(Blockizer.WoodDawn),new ItemStack(Blockizer.WoodDawn),new ItemStack(Blockizer.WoodDawn),new ItemStack(Blockizer.WoodDawn)});
    	InfusionRecipe FungalWandcore = 
    			ThaumcraftApi.addInfusionCraftingRecipe("ROD_Fungal", new ItemStack(ModItems.wandCore,1,1), 2, new AspectList().add(AscendingAspects.DIMENSION, 16).add(Aspect.MIND, 8).add(Aspect.PLANT, 16).add(Aspect.MAGIC, 16),new ItemStack(Blockizer.MushroomStemYellow), new ItemStack[]{new ItemStack(Itemizer.IngotMystite),new ItemStack(Itemizer.IngotMystite),new ItemStack(Blockizer.MushroomStemGreen),new ItemStack(Itemizer.ShroomStone),new ItemStack(Blockizer.MushroomStemOrange),new ItemStack(Blockizer.MushroomStemPurple)});
    	InfusionRecipe EmberWandcore = 
    			ThaumcraftApi.addInfusionCraftingRecipe("ROD_Emberstone", new ItemStack(ModItems.wandCore,1,2), 2, new AspectList().add(AscendingAspects.DIMENSION, 16).add(Aspect.FIRE, 16).add(Aspect.CRYSTAL, 8).add(Aspect.MAGIC, 16),new ItemStack(Itemizer.IngotEmberstone), new ItemStack[]{new ItemStack(Items.diamond),new ItemStack(Items.diamond),new ItemStack(Itemizer.ExplosiveIdol),new ItemStack(ConfigItems.itemFocusFire),new ItemStack(Itemizer.IngotEmberstone),new ItemStack(Itemizer.IngotEmberstone)});
    	InfusionRecipe LimoniteWandcore = 
    	       	ThaumcraftApi.addInfusionCraftingRecipe("ROD_Limonite", new ItemStack(ModItems.wandCore,1,3), 1, new AspectList().add(Aspect.METAL, 8).add(Aspect.MOTION, 16).add(Aspect.MAGIC, 16),new ItemStack(Itemizer.IngotLimonite), new ItemStack[]{new ItemStack(Items.diamond),new ItemStack(Weaponizer.HellFire),new ItemStack(Weaponizer.SliceStar),new ItemStack(Weaponizer.GooBall),new ItemStack(Weaponizer.Vulkram),new ItemStack(Weaponizer.Chakram)});
    	InfusionRecipe LunossoWandcore = 
    	       	ThaumcraftApi.addInfusionCraftingRecipe("ROD_Lunosso", new ItemStack(ModItems.wandCore,1,4), 2, new AspectList().add(AscendingAspects.DIMENSION, 16).add(Aspect.TREE, 16).add(Aspect.MAGIC, 16),new ItemStack(Blockizer.WoodLunide), new ItemStack[]{new ItemStack(Items.diamond),new ItemStack(Blocks.torch),new ItemStack(Itemizer.ObservingEye),new ItemStack(Blockizer.WoodLunide),new ItemStack(Blockizer.WoodLunide),new ItemStack(Blockizer.WoodLunide)});
    	InfusionRecipe IvoryWandcore= 
    			ThaumcraftApi.addInfusionCraftingRecipe("ROD_Ivory", new ItemStack(ModItems.wandCore,1,5), 2, new AspectList().add(AscendingAspects.DIMENSION, 16).add(Aspect.BEAST, 16).add(Aspect.MAGIC, 16), new ItemStack(Itemizer.Ivory), new ItemStack[]{new ItemStack(Items.diamond),new ItemStack(Items.diamond),new ItemStack(Itemizer.AncientOrb),new ItemStack(Itemizer.Ivory),new ItemStack(Itemizer.Ivory),new ItemStack(Itemizer.Ivory)});
    	InfusionRecipe IrowoodWandcore= 
    			ThaumcraftApi.addInfusionCraftingRecipe("ROD_Irowood", new ItemStack(ModItems.wandCore,1,6), 3, new AspectList().add(AscendingAspects.DIMENSION, 16).add(Aspect.METAL, 16).add(Aspect.TREE,8).add(Aspect.MAGIC, 16), new ItemStack(Blockizer.WoodIromine), new ItemStack[]{new ItemStack(Items.diamond),new ItemStack(Items.diamond),new ItemStack(Itemizer.MechaGear),new ItemStack(Itemizer.MechaGear),new ItemStack(Itemizer.IngotLyon),new ItemStack(Itemizer.CoinSilvro)});
    	InfusionRecipe BloodwoodWandCore= 
    			ThaumcraftApi.addInfusionCraftingRecipe("ROD_Bloodwood", new ItemStack(ModItems.wandCore,1,7), 2, new AspectList().add(AscendingAspects.DIMENSION, 16).add(Aspect.LIFE, 16).add(Aspect.TREE, 8).add(Aspect.MAGIC, 16), new ItemStack(Blockizer.WoodBlood), new ItemStack[]{new ItemStack(Itemizer.Bloodstone),new ItemStack(Itemizer.Bloodstone),new ItemStack(Itemizer.StaringEye),new ItemStack(Blockizer.BloodPine),new ItemStack(Blockizer.EyeBlock),new ItemStack(Blockizer.EyeBlock)});
    	InfusionRecipe HauntedWandcore= 
    			ThaumcraftApi.addInfusionCraftingRecipe("ROD_Haunted", new ItemStack(ModItems.wandCore,1,8), 3, new AspectList().add(AscendingAspects.DIMENSION, 16).add(Aspect.HUNGER, 16).add(Aspect.TREE, 8).add(Aspect.MAGIC, 16), new ItemStack(Blockizer.WoodHaunted), new ItemStack[]{new ItemStack(Itemizer.IngotGhastly),new ItemStack(Itemizer.IngotGhastly),new ItemStack(Itemizer.HauntedIdol),new ItemStack(Blockizer.WoodHaunted),new ItemStack(Blockizer.HauntedWoodFlashingFace),new ItemStack(Blockizer.HauntedWoodLargeEye)});
    	
    	ShapedArcaneRecipe Fungalstaffrod = ThaumcraftApi.addArcaneCraftingRecipe("ROD_Fungal_staff", new ItemStack(ModItems.staffCore,1,1), new AspectList().add(Aspect.AIR, 100).add(Aspect.EARTH, 100).add(Aspect.WATER, 100).add(Aspect.FIRE, 100).add(Aspect.ORDER, 100).add(Aspect.ENTROPY, 100), new Object[]{
    		"  O"," A ","A  ",Character.valueOf('A'), new ItemStack(ModItems.wandCore,1,1),Character.valueOf('O'),ItemApi.getItem("itemResource", 15)
    	});
    	ShapedArcaneRecipe Dawnstaffrod = ThaumcraftApi.addArcaneCraftingRecipe("ROD_Dawnwood_staff", new ItemStack(ModItems.staffCore,1,0), new AspectList().add(Aspect.AIR, 200).add(Aspect.EARTH, 200).add(Aspect.WATER, 200).add(Aspect.FIRE, 200).add(Aspect.ORDER, 200).add(Aspect.ENTROPY, 200), new Object[]{
    		"  O"," A ","A  ",Character.valueOf('A'), new ItemStack(ModItems.wandCore,1,0),Character.valueOf('O'),ItemApi.getItem("itemResource", 15)
    	});
    	ShapedArcaneRecipe Ivorystaffrod = ThaumcraftApi.addArcaneCraftingRecipe("ROD_Ivory_staff", new ItemStack(ModItems.staffCore,1,2), new AspectList().add(Aspect.AIR, 100).add(Aspect.EARTH, 100).add(Aspect.WATER, 100).add(Aspect.FIRE, 100).add(Aspect.ORDER, 100).add(Aspect.ENTROPY, 100), new Object[]{
    		"  O"," A ","A  ",Character.valueOf('A'), new ItemStack(ModItems.wandCore,1,5),Character.valueOf('O'),ItemApi.getItem("itemResource", 15)
    	});
    	ShapedArcaneRecipe Irowoodstaffrod = ThaumcraftApi.addArcaneCraftingRecipe("ROD_Irowood_staff", new ItemStack(ModItems.staffCore,1,3), new AspectList().add(Aspect.AIR, 150).add(Aspect.EARTH, 150).add(Aspect.WATER, 150).add(Aspect.FIRE, 150).add(Aspect.ORDER, 150).add(Aspect.ENTROPY, 150), new Object[]{
    		"  O"," A ","A  ",Character.valueOf('A'), new ItemStack(ModItems.wandCore,1,6),Character.valueOf('O'),ItemApi.getItem("itemResource", 15)
    	});
    	ShapedArcaneRecipe Bloodwoodstaffrod = ThaumcraftApi.addArcaneCraftingRecipe("ROD_Bloodwood_staff", new ItemStack(ModItems.staffCore,1,4), new AspectList().add(Aspect.AIR, 100).add(Aspect.EARTH, 100).add(Aspect.WATER, 100).add(Aspect.FIRE, 100).add(Aspect.ORDER, 100).add(Aspect.ENTROPY, 100), new Object[]{
    		"  O"," A ","A  ",Character.valueOf('A'), new ItemStack(ModItems.wandCore,1,7),Character.valueOf('O'),ItemApi.getItem("itemResource", 15)
    	});
    	ShapedArcaneRecipe Hauntedstaffrod = ThaumcraftApi.addArcaneCraftingRecipe("ROD_Haunted_staff", new ItemStack(ModItems.staffCore,1,5), new AspectList().add(Aspect.AIR, 150).add(Aspect.EARTH, 150).add(Aspect.WATER, 150).add(Aspect.FIRE, 150).add(Aspect.ORDER, 150).add(Aspect.ENTROPY, 150), new Object[]{
    		"  O"," A ","A  ",Character.valueOf('A'), new ItemStack(ModItems.wandCore,1,8),Character.valueOf('O'),ItemApi.getItem("itemResource", 15)
    	});
    	
    	ShapedArcaneRecipe DechargedLyonicCaps = ThaumcraftApi.addArcaneCraftingRecipe("CAP_lyon", new ItemStack(ModItems.oldCaps,1,0), new AspectList().add(Aspect.AIR, 25).add(Aspect.EARTH, 25).add(Aspect.WATER, 25).add(Aspect.FIRE, 25).add(Aspect.ORDER, 25).add(Aspect.ENTROPY, 25), new Object[]{
    		"AAA","A A",Character.valueOf('A'), new ItemStack(Itemizer.IngotLyon)
    	});
    	
    	ShapedArcaneRecipe DechargedMercurialCaps = ThaumcraftApi.addArcaneCraftingRecipe("CAP_mercurial", new ItemStack(ModItems.oldCaps,1,2), new AspectList().add(Aspect.EARTH, 35).add(Aspect.FIRE, 30).add(Aspect.ENTROPY, 35), new Object[]{
    		"A A","AOA",Character.valueOf('A'), new ItemStack(Itemizer.Ornamyte),Character.valueOf('O'), new ItemStack(Itemizer.Jewelyte)
    	});
    	
    	ShapedArcaneRecipe DechargedOmniCaps = ThaumcraftApi.addArcaneCraftingRecipe("CAP_omni", new ItemStack(ModItems.oldCaps,1,4), new AspectList().add(Aspect.EARTH, 35).add(Aspect.FIRE, 30).add(Aspect.ENTROPY, 35), new Object[]{
    		"A A","AOA",Character.valueOf('A'), new ItemStack(Itemizer.Ornamyte),Character.valueOf('O'), new ItemStack(Itemizer.Gemenyte)
    	});
    	
    	ShapedArcaneRecipe DechargedRuniumCaps = ThaumcraftApi.addArcaneCraftingRecipe("CAP_runium", new ItemStack(ModItems.oldCaps,1,6), new AspectList().add(Aspect.EARTH, 35).add(Aspect.ORDER, 30).add(Aspect.FIRE, 35), new Object[]{
    		"AAA","A A",Character.valueOf('A'), new ItemStack(Itemizer.RuniumChunk)
    	});
    	
    	ShapedArcaneRecipe DechargedBloodstoneCaps = ThaumcraftApi.addArcaneCraftingRecipe("CAP_bloodstone", new ItemStack(ModItems.oldCaps,1,8), new AspectList().add(Aspect.EARTH, 35).add(Aspect.ORDER, 30).add(Aspect.WATER, 35), new Object[]{
    		"AAA","A A",Character.valueOf('A'), new ItemStack(Itemizer.Bloodstone)
    	});
    	
    	InfusionRecipe LyonicCaps = 
    	ThaumcraftApi.addInfusionCraftingRecipe("CAP_lyon", new ItemStack(ModItems.oldCaps,2,1), 4, (new AspectList().add(Aspect.METAL, 8).add(Aspect.LIFE, 16).add(Aspect.ENERGY, 8).add(Aspect.MAGIC, 8)),new ItemStack(ModItems.oldCaps,1,0), new ItemStack[]{new ItemStack(Items.diamond),new ItemStack(Items.diamond),new ItemStack(Itemizer.IngotLyon),new ItemStack(Itemizer.IngotLyon),new ItemStack(Itemizer.IngotLyon),new ItemStack(Itemizer.IngotLyon),new ItemStack(Itemizer.IngotLyon),new ItemStack(Armorizer.LyonicChestplate)});
    	    
    	InfusionRecipe MercurialCaps = 
    	    	ThaumcraftApi.addInfusionCraftingRecipe("CAP_mercurial", new ItemStack(ModItems.oldCaps,1,3), 3, (new AspectList().add(Aspect.ENTROPY, 10).add(Aspect.EARTH, 10).add(Aspect.FIRE, 10).add(Aspect.MAGIC, 8)),new ItemStack(ModItems.oldCaps,1,2), new ItemStack[]{new ItemStack(Items.gunpowder),new ItemStack(Items.gunpowder),new ItemStack(Items.gunpowder),new ItemStack(Blocks.tnt),new ItemStack(Blocks.tnt),new ItemStack(Itemizer.ExplosiveGem)});
    	    	 
    	InfusionRecipe OmniCaps = 
    	    	ThaumcraftApi.addInfusionCraftingRecipe("CAP_omni", new ItemStack(ModItems.oldCaps,1,5), 3, (new AspectList().add(Aspect.ENTROPY, 10).add(Aspect.EARTH, 10).add(Aspect.FIRE, 10).add(Aspect.MAGIC, 8)),new ItemStack(ModItems.oldCaps,1,4), new ItemStack[]{new ItemStack(Items.gunpowder),new ItemStack(Items.gunpowder),new ItemStack(Items.gunpowder),new ItemStack(Blocks.tnt),new ItemStack(Blocks.tnt),new ItemStack(Itemizer.ExplosiveGem)});
    	
    	InfusionRecipe RuniumCaps = 
    	    	ThaumcraftApi.addInfusionCraftingRecipe("CAP_runium", new ItemStack(ModItems.oldCaps,1,7), 2, (new AspectList().add(Aspect.EARTH, 10).add(Aspect.EARTH, 10).add(Aspect.MAGIC, 8)),new ItemStack(ModItems.oldCaps,1,6), new ItemStack[]{new ItemStack(Itemizer.Rune),new ItemStack(Itemizer.Rune),ItemApi.getItem("itemResource", 14)});
    	
    	InfusionRecipe BloodstoneCaps = 
    	    	ThaumcraftApi.addInfusionCraftingRecipe("CAP_bloodstone", new ItemStack(ModItems.oldCaps,1,9), 3, (new AspectList().add(Aspect.CRYSTAL, 10).add(Aspect.LIFE, 10).add(Aspect.HUNGER, 10).add(Aspect.MAGIC, 8)),new ItemStack(ModItems.oldCaps,1,8), new ItemStack[]{new ItemStack(Itemizer.Bloodstone),new ItemStack(Itemizer.StaringEye),ItemApi.getItem("itemResource", 14)});
    	
    	
    	ShapedArcaneRecipe WindFocus = ThaumcraftApi.addArcaneCraftingRecipe("the_beginning", new ItemStack(ModItems.WindFocus), new AspectList().add(Aspect.AIR, 20).add(Aspect.ENTROPY,10), new Object[]{
    		"AOA","OSO","AOA",Character.valueOf('A'), new ItemStack(Items.quartz),Character.valueOf('O'),new ItemStack(Itemizer.WindRune),Character.valueOf('S'),new ItemStack(Weaponizer.WindStaff)
    	});
		ShapedArcaneRecipe WitherFocus = ThaumcraftApi.addArcaneCraftingRecipe("the_beginning", new ItemStack(ModItems.WitherFocus), new AspectList().add(Aspect.AIR, 10).add(Aspect.ENTROPY,20), new Object[]{
    		"AOA","OSO","AOA",Character.valueOf('A'), new ItemStack(Items.quartz),Character.valueOf('O'),new ItemStack(Itemizer.WitherRune),Character.valueOf('S'),new ItemStack(Weaponizer.WitherStaff)
    	});
		ShapedArcaneRecipe PoisonFocus = ThaumcraftApi.addArcaneCraftingRecipe("the_beginning", new ItemStack(ModItems.PoisonFocus), new AspectList().add(Aspect.WATER, 10).add(Aspect.ENTROPY,20), new Object[]{
    		"AOA","OSO","AOA",Character.valueOf('A'), new ItemStack(Items.quartz),Character.valueOf('O'),new ItemStack(Itemizer.PoisonRune),Character.valueOf('S'),new ItemStack(Weaponizer.PoisonStaff)
    	});
		ShapedArcaneRecipe FireFocus = ThaumcraftApi.addArcaneCraftingRecipe("the_beginning", new ItemStack(ModItems.FireFocus), new AspectList().add(Aspect.FIRE, 10).add(Aspect.ENTROPY,10), new Object[]{
    		"AOA","OSO","AOA",Character.valueOf('A'), new ItemStack(Items.quartz),Character.valueOf('O'),new ItemStack(Itemizer.FireRune),Character.valueOf('S'),new ItemStack(Weaponizer.FireStaff)
    	});
		ShapedArcaneRecipe WaterFocus = ThaumcraftApi.addArcaneCraftingRecipe("the_beginning", new ItemStack(ModItems.WaterFocus), new AspectList().add(Aspect.WATER, 10).add(Aspect.ENTROPY,10), new Object[]{
    		"AOA","OSO","AOA",Character.valueOf('A'), new ItemStack(Items.quartz),Character.valueOf('O'),new ItemStack(Itemizer.WaterRune),Character.valueOf('S'),new ItemStack(Weaponizer.WaterStaff)
    	});
    	     	 
    	new ResearchItem("ROD_Dawnwood", "AOATC", (new AspectList().add(Aspect.ENTROPY, 8).add(Aspect.TREE, 8).add(Aspect.DARKNESS, 8).add(AscendingAspects.DIMENSION, 8)), -8, -5, 2, new ItemStack(ModItems.wandCore,1,0))
    	.setParents("Dustopia","INFUSION")
    	.setConcealed()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Dawnwood") ),
    		new ResearchPage(DawnWandcore)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("ROD_Dawnwood_staff", "AOATC", (new AspectList().add(Aspect.ENTROPY, 8).add(Aspect.TREE, 8).add(Aspect.DARKNESS, 8).add(AscendingAspects.DIMENSION, 8)), -9, -6, 2, new ItemStack(ModItems.staffCore,1,0))
    	.setParents("ROD_Dawnwood")
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Dawnwood_staff") ),
    		new ResearchPage(Dawnstaffrod)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("ROD_Fungal", "AOATC", new AspectList().add(Aspect.POISON, 8).add(Aspect.PLANT, 8).add(Aspect.MIND, 8).add(AscendingAspects.DIMENSION, 8), -5, 8, 2, new ItemStack(ModItems.wandCore,1,1))
    	.setParents("Mysterium","INFUSION")
    	.setConcealed()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Fungal") ),
    		new ResearchPage(FungalWandcore)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("ROD_Limonite", "AOATC", new AspectList().add(Aspect.MOTION, 8).add(Aspect.METAL, 8).add(Aspect.MAGIC, 8).add(AscendingAspects.DIMENSION, 8), 2, 9, 2, new ItemStack(ModItems.wandCore,1,3))
    	.setParents("Overworld","INFUSION")
    	.setConcealed()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Limonite") ),
    		new ResearchPage(LimoniteWandcore)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("ROD_Lunosso", "AOATC", new AspectList().add(Aspect.TREE, 8).add(Aspect.PLANT, 8).add(Aspect.LIGHT, 8).add(AscendingAspects.DIMENSION, 8), 10, 0, 2, new ItemStack(ModItems.wandCore,1,4))
    	.setParents("Lunalus","INFUSION")
    	.setConcealed()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Lunosso") ),
    		new ResearchPage(LunossoWandcore)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("ROD_Fungal_staff", "AOATC", new AspectList().add(Aspect.POISON, 8).add(Aspect.PLANT, 8).add(Aspect.MIND, 8).add(AscendingAspects.DIMENSION, 8), -6, 9, 2, new ItemStack(ModItems.staffCore,1,1))
    	.setParents("ROD_Fungal")
    	.setConcealed()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Fungal_staff") ),
    		new ResearchPage(Fungalstaffrod)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("ROD_Emberstone", "AOATC", new AspectList().add(Aspect.FIRE, 8).add(Aspect.ORDER, 8).add(Aspect.ENERGY, 8).add(Aspect.ENTROPY, 8), -9, -2, 2, new ItemStack(ModItems.wandCore,1,2))
    	.setParents("Nether","INFUSION")
    	.setConcealed()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Emberstone") ),
    		new ResearchPage(EmberWandcore)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("ROD_Bloodwood", "AOATC", new AspectList().add(Aspect.LIFE, 8).add(Aspect.HEAL, 8).add(Aspect.HUNGER, 8).add(AscendingAspects.DIMENSION, 8), -7, -7, 2, new ItemStack(ModItems.wandCore,1,7))
    	.setParents("Abyss","INFUSION")
    	.setConcealed()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Bloodwood") ),
    		new ResearchPage(BloodwoodWandCore)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("ROD_Ivory", "AOATC", new AspectList().add(Aspect.BEAST, 8).add(Aspect.CRYSTAL, 8).add(Aspect.HUNGER, 8).add(AscendingAspects.DIMENSION, 8), -7, 7, 2, new ItemStack(ModItems.wandCore,1,5))
    	.setParents("Precasia","INFUSION")
    	.setConcealed()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Ivory") ),
    		new ResearchPage(IvoryWandcore)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("ROD_Irowood", "AOATC", new AspectList().add(Aspect.METAL, 8).add(Aspect.TREE, 8).add(Aspect.MECHANISM, 8).add(AscendingAspects.DIMENSION, 8), 8, -5, 3, new ItemStack(ModItems.wandCore,1,6))
    	.setParents("Iromine","INFUSION")
    	.setConcealed()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Irowood") ),
    		new ResearchPage(IrowoodWandcore)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("ROD_Haunted", "AOATC", new AspectList().add(Aspect.SOUL, 8).add(Aspect.TREE, 8).add(Aspect.ELDRITCH, 8).add(AscendingAspects.DIMENSION, 8), -4, -8, 3, new ItemStack(ModItems.wandCore,1,8))
    	.setParents("Greckon","INFUSION")
    	.setConcealed()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Haunted") ),
    		new ResearchPage(HauntedWandcore)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("ROD_Ivory_staff", "AOATC", new AspectList().add(Aspect.BEAST, 8).add(Aspect.TREE, 8).add(Aspect.CRYSTAL, 8).add(AscendingAspects.DIMENSION, 8), -8, 8, 2, new ItemStack(ModItems.staffCore,1,2))
    	.setParents("ROD_Ivory")
    	.setConcealed()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Ivory_staff") ),
    		new ResearchPage(Ivorystaffrod)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("ROD_Irowood_staff", "AOATC", new AspectList().add(Aspect.METAL, 8).add(Aspect.TREE, 8).add(Aspect.MECHANISM, 8).add(AscendingAspects.DIMENSION, 8), 9, -6, 3, new ItemStack(ModItems.staffCore,1,3))
    	.setParents("ROD_Irowood")
    	.setConcealed()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Irowood_staff") ),
    		new ResearchPage(Irowoodstaffrod)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("ROD_Bloodwood_staff", "AOATC", new AspectList().add(Aspect.LIFE, 8).add(Aspect.HEAL, 8).add(Aspect.HUNGER, 8).add(AscendingAspects.DIMENSION, 8), -8, -8, 2, new ItemStack(ModItems.staffCore,1,4))
    	.setParents("ROD_Bloodwood")
    	.setConcealed()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Bloodwood_staff") ),
    		new ResearchPage(Bloodwoodstaffrod)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("ROD_Haunted_staff", "AOATC", new AspectList().add(Aspect.SOUL, 8).add(Aspect.TREE, 8).add(Aspect.MIND, 8).add(AscendingAspects.DIMENSION, 8), -4, -9, 3, new ItemStack(ModItems.staffCore,1,5))
    	.setParents("ROD_Haunted")
    	.setConcealed()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.ROD_Haunted_staff") ),
    		new ResearchPage(Hauntedstaffrod)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("CAP_Lyon", "AOATC", (new AspectList().add(Aspect.METAL, 8).add(Aspect.LIFE, 4).add(Aspect.ENERGY, 8).add(AscendingAspects.DIMENSION, 8)), 6, -3, 3, new ItemStack(ModItems.oldCaps,1,1))
    	.setParents("Iromine","INFUSION")
    	.setConcealed()
    	.setItemTriggers(new ItemStack(Itemizer.IngotLyon))
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.CAP_Lyon") ),
    		new ResearchPage(DechargedLyonicCaps),
    		new ResearchPage(LyonicCaps)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("CAP_Explosions", "AOATC", (new AspectList().add(Aspect.CRYSTAL, 8).add(Aspect.ENTROPY, 4).add(Aspect.ENERGY, 8).add(Aspect.WEAPON, 8)), -8, 0, 2, new ItemStack(ModItems.oldCaps,1,4))
    	.setParents("Creeponia","INFUSION")
    	.setConcealed()
    	.setItemTriggers(new ItemStack(Itemizer.Ornamyte),new ItemStack(Itemizer.Gemenyte),new ItemStack(Itemizer.Jewelyte))
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.CAP_Explosions") )
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("CAP_Omni", "AOATC", (new AspectList().add(Aspect.METAL, 8).add(Aspect.LIFE, 4).add(Aspect.ENERGY, 8).add(AscendingAspects.DIMENSION, 8)), -7, -1, 0, new ItemStack(ModItems.oldCaps,1,5))
    	.setParents("CAP_Explosions","INFUSION")
    	.setSecondary()
    	.setConcealed()
    	.setPages(
    		new ResearchPage(DechargedOmniCaps),
    		new ResearchPage(OmniCaps)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("CAP_Mercurial", "AOATC", (new AspectList().add(Aspect.METAL, 8).add(Aspect.LIFE, 4).add(Aspect.ENERGY, 8).add(AscendingAspects.DIMENSION, 8)), -7, 1, 0, new ItemStack(ModItems.oldCaps,1,3))
    	.setParents("CAP_Explosions","INFUSION")
    	.setSecondary()
    	.setConcealed()
    	.setPages(
    		new ResearchPage(DechargedMercurialCaps),
    		new ResearchPage(MercurialCaps)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("CAP_Bloodstone", "AOATC", (new AspectList().add(Aspect.CRYSTAL, 8).add(Aspect.LIFE, 4).add(Aspect.ENERGY, 8).add(AscendingAspects.DIMENSION, 8)), -5, -5, 2, new ItemStack(ModItems.oldCaps,1,9))
    	.setParents("Abyss","INFUSION")
    	.setConcealed()
 .setItemTriggers(new ItemStack(Itemizer.Bloodstone))
    	.setPages(
    			new ResearchPage(StatCollector.translateToLocal("tc.fluff.CAP_Bloodstone")),
    		new ResearchPage(DechargedBloodstoneCaps),
    		new ResearchPage(BloodstoneCaps)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("CAP_Runium", "AOATC", (new AspectList().add(Aspect.MAGIC,8)), 2, 7, 1, new ItemStack(ModItems.oldCaps,1,7))
    	.setParents("Overworld","INFUSION")
    	.setConcealed()
 .setItemTriggers(new ItemStack(Itemizer.RuniumChunk))
    	.setPages(
    			new ResearchPage(StatCollector.translateToLocal("tc.fluff.CAP_Runium")),
    		new ResearchPage(DechargedRuniumCaps),
    		new ResearchPage(RuniumCaps)
    	)
    	.registerResearchItem();
    	
    	new ResearchItem("the_beginning","AOATC",new AspectList(), 0, 0, 0, new ItemStack(Itemizer.AncientTeleporterBlueprint))
    	.setAutoUnlock()
    	.setSpecial()
    	.setPages(new ResearchPage(StatCollector.translateToLocal("tc.fluff.the_beginning")),
    			new ResearchPage(StatCollector.translateToLocal("tc.fluff.BasicFoci")),
    			new ResearchPage(WindFocus),
    			new ResearchPage(PoisonFocus),
    			new ResearchPage(WitherFocus),
    			new ResearchPage(WaterFocus),
    			new ResearchPage(FireFocus))
    	.registerResearchItem();
		
}
}
