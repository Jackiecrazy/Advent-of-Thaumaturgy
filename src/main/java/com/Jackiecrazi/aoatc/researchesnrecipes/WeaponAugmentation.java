package com.Jackiecrazi.aoatc.researchesnrecipes;

import com.Jackiecrazi.aoatc.items.ModItems;
import com.Jackiecrazi.aoatc.researchesnrecipes.*;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.nevermine.izer.Itemizer;
import net.nevermine.izer.equipment.Weaponizer;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class WeaponAugmentation {
	public static void augment(){
		InfusionRecipe DemonicSkellieSword = ThaumcraftApi.addInfusionCraftingRecipe("DemonicSkellyTools", new ItemStack(ModItems.SkellySword), 5, new AspectList().add(Aspect.DEATH,16).add(Aspect.UNDEAD,24).add(Aspect.GREED, 16), new ItemStack(Weaponizer.SkeletalSword), 
				new ItemStack[]{new ItemStack(Itemizer.PrimordialSkull),new ItemStack(Itemizer.StaringEye),new ItemStack(Itemizer.FleshyBones),new ItemStack(Itemizer.PrimordialDust),new ItemStack(Itemizer.FootboneFragment),new ItemStack(Itemizer.FootboneFragment),new ItemStack(Itemizer.MagicRepairDust),new ItemStack(Itemizer.FleshyBones),new ItemStack(Itemizer.ObservingEye)});
		InfusionRecipe DemonicSkellieArchergun = ThaumcraftApi.addInfusionCraftingRecipe("DemonicSkellyTools", new ItemStack(ModItems.SkellyArchergun), 5, new AspectList().add(Aspect.DEATH,16).add(Aspect.UNDEAD,24).add(Aspect.GREED, 16), new ItemStack(Weaponizer.SkeletalArchergun), 
				new ItemStack[]{new ItemStack(Itemizer.PrimordialSkull),new ItemStack(Itemizer.StaringEye),new ItemStack(Itemizer.FleshyBones),new ItemStack(Itemizer.PrimordialDust),new ItemStack(Itemizer.FootboneFragment),new ItemStack(Itemizer.FootboneFragment),new ItemStack(Itemizer.MagicRepairDust),new ItemStack(Itemizer.FleshyBones),new ItemStack(Itemizer.ObservingEye)});
		ThaumcraftApi.getCraftingRecipes().add(new InfusionRecipeRealmstone());
		
		
		new ResearchItem("DemonicSkellyTools", "AOATC", (new AspectList().add(Aspect.UNDEAD, 16).add(Aspect.WEAPON, 8).add(Aspect.SOUL,24)), 0, 3, 5, new ItemStack(ModItems.SkellySword))
		.setParents("the_beginning","INFUSION")
		.setItemTriggers(new ItemStack(Weaponizer.SkeletalSword))
		.setConcealed()
		.setAspectTriggers(Aspect.SOUL)
		.setPages(
			new ResearchPage(StatCollector.translateToLocal("tc.fluff.DemonicSkellySword")),
			new ResearchPage(DemonicSkellieSword),
			new ResearchPage(DemonicSkellieArchergun)
		)
		.registerResearchItem();
		
		new RealmstoneInfu("RealmstoneAugmentation", "AOATC", (new AspectList().add(Aspect.TRAVEL, 16).add(Aspect.WEAPON, 8).add(Aspect.ELDRITCH,24)), 2, 2, 4, new ItemStack(Itemizer.RealmstoneAbyss))
		.setParents("the_beginning","INFUSION")
		.setConcealed()
		.setHidden()
		.setAspectTriggers(Aspect.SOUL)
		.setItemTriggers(new ItemStack(Itemizer.RealmstoneAbyss),new ItemStack(Itemizer.RealmstoneAncientCavern),new ItemStack(Itemizer.RealmstoneBarathos),new ItemStack(Itemizer.RealmstoneBorean),new ItemStack(Itemizer.RealmstoneCandyland),new ItemStack(Itemizer.RealmstoneCandyland),new ItemStack(Itemizer.RealmstoneCeleve),new ItemStack(Itemizer.RealmstoneCrystevia),
				new ItemStack(Itemizer.RealmstoneCreeponia),new ItemStack(Itemizer.RealmstoneDeeplands),new ItemStack(Itemizer.RealmstoneDustopia),new ItemStack(Itemizer.RealmstoneGardencia),new ItemStack(Itemizer.RealmstoneHaven),new ItemStack(Itemizer.RealmstoneImmortallis),new ItemStack(Itemizer.RealmstoneIromine),new ItemStack(Itemizer.RealmstoneLabricon),
				new ItemStack(Itemizer.RealmstoneLelyetia),new ItemStack(Itemizer.RealmstoneMysterium),new ItemStack(Itemizer.RealmstonePrecasia),new ItemStack(Itemizer.RealmstoneVoxPonds))
		.setPages(
			new ResearchPage(StatCollector.translateToLocal("tc.fluff.RealmstoneAugmentation")),
			new ResearchPage(new RealmstoneVisual())
		)
		.registerResearchItem();
		ThaumcraftApi.addWarpToResearch("DemonicSkellyTools", 4);
		ThaumcraftApi.addWarpToItem(new ItemStack(ModItems.SkellySword), 5);
		ThaumcraftApi.addWarpToItem(new ItemStack(ModItems.SkellyArchergun), 5);
		
	}
}
