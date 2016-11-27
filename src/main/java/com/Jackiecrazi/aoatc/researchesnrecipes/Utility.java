package com.Jackiecrazi.aoatc.researchesnrecipes;

import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.nevermine.izer.Blockizer;
import net.nevermine.izer.Itemizer;
import net.nevermine.izer.equipment.Armorizer;
import net.nevermine.izer.equipment.Weaponizer;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigItems;

import com.Jackiecrazi.aoatc.AscendingAspects;
import com.Jackiecrazi.aoatc.items.ModItems;

public class Utility {

	public static void initUtility() {
		InfusionRecipe InfiniteBulletBag = ThaumcraftApi
				.addInfusionCraftingRecipe(
						"InfBulBag",
						new ItemStack(ModItems.infBulletBag),
						5,
						(new AspectList().add(Aspect.WEAPON, 128)
								.add(AscendingAspects.PLUTON, 64)
								.add(AscendingAspects.SELYAN, 64)
								.add(Aspect.EXCHANGE, 32).add(Aspect.METAL, 64)),
						new ItemStack(Itemizer.GemBag), new ItemStack[] {
								new ItemStack(Itemizer.IngotLimonite),
								new ItemStack(Itemizer.IngotLimonite),
								new ItemStack(Itemizer.IngotLimonite),
								new ItemStack(Itemizer.IngotLimonite),
								new ItemStack(Itemizer.IngotLimonite),
								new ItemStack(Itemizer.RealmstoneMysterium),
								new ItemStack(Itemizer.RealmstoneMysterium),
								new ItemStack(Weaponizer.FungalStaff),
								new ItemStack(Itemizer.MetalPellet),
								new ItemStack(Itemizer.MetalSlug)});
		InfusionRecipe MysteriumPendant = ThaumcraftApi
				.addInfusionCraftingRecipe(
						"MysteriumPendant",
						new ItemStack(ModItems.MysteriumPendant),
						5,
						(new AspectList().add(Aspect.TRAVEL, 16)
								.add(AscendingAspects.SELYAN, 64)
								.add(Aspect.WEAPON, 32).add(Aspect.MIND, 64)),
						new ItemStack(ConfigItems.itemAmuletVis,1,1), new ItemStack[] {
								new ItemStack(Itemizer.IngotRosite),
								new ItemStack(Itemizer.IngotJade),
								new ItemStack(Itemizer.IngotSapphire),
								new ItemStack(ConfigItems.itemResource,1,5),
								new ItemStack(ConfigItems.itemResource,1,5),
								new ItemStack(Itemizer.RealmstoneMysterium),
								new ItemStack(Itemizer.RealmstoneMysterium),
								new ItemStack(Weaponizer.FungalStaff)});
		
		new ResearchItem("InfBulBag", "AOATC",
				(new AspectList().add(Aspect.WEAPON, 8).add(AscendingAspects.SELYAN, 8)
						.add(AscendingAspects.PLUTON, 8).add(Aspect.FIRE, 8).add(Aspect.METAL, 8)), 8, -3, 2,
				new ItemStack(ModItems.infBulletBag))
				.setParents("Mysterium", "INFUSION","Iromine")
				.setHidden()
				.setConcealed()
				.setPages(
						new ResearchPage(StatCollector
								.translateToLocal("tc.fluff.InfBulBag")),
						new ResearchPage(InfiniteBulletBag)).registerResearchItem();
		new ResearchItem("MysteriumPendant", "AOATC",
				(new AspectList().add(Aspect.MIND, 8).add(AscendingAspects.SELYAN, 8).add(Aspect.TRAVEL, 8)), -3, 8, 2,
				new ItemStack(ModItems.MysteriumPendant))
				.setParents("Mysterium", "INFUSION")
				.setHidden()
				.setConcealed()
				.setEntityTriggers("nevermine.SpiritGuardian","nevermine.SpiritProtector")
				.setPages(
						new ResearchPage(StatCollector
								.translateToLocal("tc.fluff.MysteriumPendant")),
						new ResearchPage(MysteriumPendant)).registerResearchItem();
	}

}
