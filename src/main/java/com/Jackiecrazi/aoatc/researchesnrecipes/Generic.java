package com.Jackiecrazi.aoatc.researchesnrecipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.nevermine.izer.Itemizer;
import net.nevermine.izer.Plantizer;
import net.nevermine.izer.equipment.Weaponizer;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import com.Jackiecrazi.aoatc.AscendingAspects;
import com.Jackiecrazi.aoatc.items.ModItems;

public class Generic {
	public static void addGeneric(){
		
		
		new ResearchItem("Erebon", "AOATC", (new AspectList().add(AscendingAspects.EREBON, 8)), -4, -4, 1, new ItemStack(Items.iron_sword))
    	.setParents("the_beginning")
    	.setAutoUnlock()
    	.setSpecial()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Erebon"))
    	)
    	.registerResearchItem();
    	
		new ResearchItem("Luxon", "AOATC", (new AspectList().add(AscendingAspects.LUXON, 8)), 4, 4, 1, new ItemStack(Itemizer.StoneBowl))
    	.setParents("the_beginning")
    	.setAutoUnlock()
    	.setSpecial()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Luxon"))
    	)
    	.registerResearchItem();
    	
		new ResearchItem("Pluton", "AOATC", (new AspectList().add(AscendingAspects.PLUTON, 8)), 4, -4, 1, new ItemStack(Itemizer.IngotRosite))
    	.setParents("the_beginning")
    	.setAutoUnlock()
    	.setSpecial()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Pluton"))
    	)
    	.registerResearchItem();
		
		new ResearchItem("Selyan", "AOATC", (new AspectList().add(AscendingAspects.SELYAN, 8)), -4, 4, 1, new ItemStack(Plantizer.HeartFruitSeeds))
    	.setParents("the_beginning")
    	.setAutoUnlock()
    	.setSpecial()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Selyan"))
    	)
    	.registerResearchItem();
    	
    	
		new ResearchItem("Abyss", "AOATC", (new AspectList().add(AscendingAspects.EREBON, 8)), -6, -6, 2, new ItemStack(Itemizer.StaringEye))
    	.setParents("Erebon")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Abyss"))
    	)
    	.setRound()
    	.registerResearchItem();
		
    	new ResearchItem("Greckon", "AOATC", (new AspectList().add(AscendingAspects.EREBON, 8)), -4, -7, 2, new ItemStack(Itemizer.HauntedIdol))
    	.setParents("Erebon")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Greckon"))
    	)
    	.setRound()
    	.registerResearchItem();
    	
    	new ResearchItem("Dustopia", "AOATC", (new AspectList().add(AscendingAspects.EREBON, 8)), -7, -4, 2, new ItemStack(Itemizer.PrimordialDust))
    	.setParents("Erebon")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Dustopia"))
    	)
    	.setRound()
    	.registerResearchItem();
    	
    	new ResearchItem("VoxPonds", "AOATC", (new AspectList().add(AscendingAspects.EREBON, 8)), -2, -8, 2, new ItemStack(Itemizer.VileStone))
    	.setParents("Erebon")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.VoxPonds"))
    	)
    	.setRound()
    	.registerResearchItem();
    	
    	new ResearchItem("Creeponia", "AOATC", (new AspectList().add(AscendingAspects.EREBON,8)), -9, 0, 2, new ItemStack(Itemizer.ExplosiveGem))
    	.setParents("Erebon")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Creeponia"))
    	)
    	.setRound()
    	.registerResearchItem();
    	
    	new ResearchItem("Nether", "AOATC", (new AspectList().add(AscendingAspects.EREBON,8)), -8, -2, 2, new ItemStack(Itemizer.NethengeicCallstone))
    	.setParents("Erebon")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Nether"))
    	)
    	.setRound()
    	.registerResearchItem();
    	
    	new ResearchItem("Immortallis", "AOATC", (new AspectList().add(AscendingAspects.EREBON, 8).add(AscendingAspects.PLUTON,8)), 0, -9, 2, new ItemStack(Itemizer.StartingCoin))
    	.setParents("Erebon","Pluton")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Immortallis"))
    	)
    	.setRound()
    	.registerResearchItem();
    	
		new ResearchItem("Haven", "AOATC", (new AspectList().add(AscendingAspects.LUXON, 8)), 6, 6, 2, new ItemStack(Itemizer.VoliantHeart))
    	.setParents("Luxon")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Haven"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("Runandor", "AOATC", (new AspectList().add(AscendingAspects.LUXON, 8)), 4, 7, 2, new ItemStack(Itemizer.MegaRuneStone))
    	.setParents("Luxon")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Runandor"))
    	)
    	.setRound()
    	.registerResearchItem();
    	
		new ResearchItem("Candyland", "AOATC", (new AspectList().add(AscendingAspects.LUXON, 8)), 7, 4, 2, new ItemStack(Itemizer.TreatBag))
    	.setParents("Luxon")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Candyland"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("Deeplands", "AOATC", (new AspectList().add(AscendingAspects.PLUTON, 8)), 6, -6, 2, new ItemStack(Itemizer.BoulderDash))
    	.setParents("Pluton")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Deeplands"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("Iromine", "AOATC", (new AspectList().add(AscendingAspects.PLUTON, 8)), 7, -4, 2, new ItemStack(Itemizer.CoinSilvro))
    	.setParents("Pluton")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Iromine"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("Lunalus", "AOATC", (new AspectList().add(AscendingAspects.PLUTON, 8)), 9, 0, 2, new ItemStack(Itemizer.ObservingEye))
    	.setParents("Pluton")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Lunalus"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("Barathos", "AOATC", (new AspectList().add(AscendingAspects.PLUTON, 8)), 2, -8, 2, new ItemStack(Itemizer.HiveChunk))
    	.setParents("Pluton")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Barathos"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("Celeve", "AOATC", (new AspectList().add(AscendingAspects.PLUTON, 8)), 8, -2, 2, new ItemStack(Itemizer.ToyGyrocopter))
    	.setParents("Pluton")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Celeve"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("Crystevia", "AOATC", (new AspectList().add(AscendingAspects.PLUTON, 8)), 4, -7, 2, new ItemStack(Itemizer.GiantCrystal))
    	.setParents("Pluton")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Crystevia"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("Precasia", "AOATC", (new AspectList().add(AscendingAspects.SELYAN, 8)), -6, 6, 2, new ItemStack(Itemizer.AncientOrb))
    	.setParents("Selyan")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Precasia"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("Mysterium", "AOATC", (new AspectList().add(AscendingAspects.SELYAN, 8)), -4, 7, 2, new ItemStack(Itemizer.ShroomStone))
    	.setParents("Selyan")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Mysterium"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("Gardencia", "AOATC", (new AspectList().add(AscendingAspects.SELYAN, 8)), -7, 4, 2, new ItemStack(Itemizer.PedalPile))
    	.setParents("Selyan")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Gardencia"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("LBorean", "AOATC", (new AspectList().add(AscendingAspects.SELYAN, 8)), -2, 8, 2, new ItemStack(Itemizer.CallOfTheDrake))
    	.setParents("Selyan")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.LBorean"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("Lelyetia", "AOATC", (new AspectList().add(AscendingAspects.SELYAN, 8)), -8, 2, 2, new ItemStack(Itemizer.GuardiansEye))
    	.setParents("Selyan")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Lelyetia"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("AncientCavern", "AOATC", (new AspectList().add(AscendingAspects.SELYAN, 8).add(AscendingAspects.PLUTON, 8).add(AscendingAspects.EREBON, 8).add(AscendingAspects.LUXON, 8)), 0, 9, 2, new ItemStack(Weaponizer.ErebonScythe))
    	.setParents("Selyan","Erebon","Pluton","Luxon")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.AncientCavern"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("Overworld", "AOATC", (new AspectList().add(AscendingAspects.SELYAN, 8).add(AscendingAspects.PLUTON, 8).add(AscendingAspects.EREBON, 8).add(AscendingAspects.LUXON, 8)), 2, 8, 2, new ItemStack(Itemizer.TrollIdol))
    	.setParents("the_beginning")
    	.setHidden()
    	.setAutoUnlock()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Overworld"))
    	)
    	.setRound()
    	.registerResearchItem();
		
		new ResearchItem("End", "AOATC", (new AspectList().add(Aspect.ELDRITCH,8).add(AscendingAspects.DIMENSION,8)), 8, 2, 2, new ItemStack(Items.ender_eye))
    	.setParents("the_beginning")
    	.setHidden()
    	.setPages(
    		new ResearchPage(StatCollector.translateToLocal("tc.fluff.Overworld"))
    	)
    	.setRound()
    	.registerResearchItem();
	}
}
