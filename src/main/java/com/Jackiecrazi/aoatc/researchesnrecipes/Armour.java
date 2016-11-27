package com.Jackiecrazi.aoatc.researchesnrecipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.nevermine.izer.Blockizer;
import net.nevermine.izer.Itemizer;
import net.nevermine.izer.equipment.Armorizer;
import net.nevermine.izer.equipment.Tabletizer;
import net.nevermine.izer.equipment.Weaponizer;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigItems;

import com.Jackiecrazi.aoatc.items.ModItems;

public class Armour {
	public static void addArmor() {
		InfusionRecipe ElementalLyndamyteH = ThaumcraftApi
				.addInfusionCraftingRecipe(
						"Elemental_Lyndamyte",
						new ItemStack(ModItems.ElementalLyndamyteH),
						5,
						(new AspectList().add(Aspect.ENTROPY, 5)
								.add(Aspect.FIRE, 5).add(Aspect.AIR, 5)
								.add(Aspect.WATER, 5).add(Aspect.EARTH, 5)
								.add(Aspect.ORDER, 5).add(Aspect.ARMOR, 5).add(
								Aspect.METAL, 5)), new ItemStack(
								Armorizer.LyndamyteHelmet), new ItemStack[] {
								new ItemStack(ConfigItems.itemShard, 1, 0),
								new ItemStack(ConfigItems.itemShard, 1, 1),
								new ItemStack(ConfigItems.itemShard, 1, 2),
								new ItemStack(ConfigItems.itemShard, 1, 3),
								new ItemStack(ConfigItems.itemShard, 1, 4),
								new ItemStack(ConfigItems.itemShard, 1, 5),
								new ItemStack(ConfigItems.itemShard, 1, 6) });
		InfusionRecipe ElementalLyndamyteC = ThaumcraftApi
				.addInfusionCraftingRecipe(
						"Elemental_Lyndamyte",
						new ItemStack(ModItems.ElementalLyndamyteC),
						5,
						(new AspectList().add(Aspect.ENTROPY, 10)
								.add(Aspect.FIRE, 10).add(Aspect.AIR, 10)
								.add(Aspect.WATER, 10).add(Aspect.EARTH, 10)
								.add(Aspect.ORDER, 10).add(Aspect.ARMOR, 10)
								.add(Aspect.METAL, 10)), new ItemStack(
								Armorizer.LyndamyteChestplate),
						new ItemStack[] {
								new ItemStack(ConfigItems.itemShard, 1, 0),
								new ItemStack(ConfigItems.itemShard, 1, 1),
								new ItemStack(ConfigItems.itemShard, 1, 2),
								new ItemStack(ConfigItems.itemShard, 1, 3),
								new ItemStack(ConfigItems.itemShard, 1, 4),
								new ItemStack(ConfigItems.itemShard, 1, 5),
								new ItemStack(ConfigItems.itemShard, 1, 6) });
		InfusionRecipe ElementalLyndamyteL = ThaumcraftApi
				.addInfusionCraftingRecipe(
						"Elemental_Lyndamyte",
						new ItemStack(ModItems.ElementalLyndamyteL),
						5,
						(new AspectList().add(Aspect.ENTROPY, 7)
								.add(Aspect.FIRE, 7).add(Aspect.AIR, 7)
								.add(Aspect.WATER, 7).add(Aspect.EARTH, 7)
								.add(Aspect.ORDER, 7).add(Aspect.ARMOR, 7).add(
								Aspect.METAL, 7)), new ItemStack(
								Armorizer.LyndamyteLeggings), new ItemStack[] {
								new ItemStack(ConfigItems.itemShard, 1, 0),
								new ItemStack(ConfigItems.itemShard, 1, 1),
								new ItemStack(ConfigItems.itemShard, 1, 2),
								new ItemStack(ConfigItems.itemShard, 1, 3),
								new ItemStack(ConfigItems.itemShard, 1, 4),
								new ItemStack(ConfigItems.itemShard, 1, 5),
								new ItemStack(ConfigItems.itemShard, 1, 6) });
		InfusionRecipe ElementalLyndamyteB = ThaumcraftApi
				.addInfusionCraftingRecipe(
						"Elemental_Lyndamyte",
						new ItemStack(ModItems.ElementalLyndamyteB),
						5,
						(new AspectList().add(Aspect.ENTROPY, 5)
								.add(Aspect.FIRE, 5).add(Aspect.AIR, 5)
								.add(Aspect.WATER, 5).add(Aspect.EARTH, 5)
								.add(Aspect.ORDER, 5).add(Aspect.ARMOR, 5).add(
								Aspect.METAL, 5)), new ItemStack(
								Armorizer.LyndamyteBoots), new ItemStack[] {
								new ItemStack(ConfigItems.itemShard, 1, 0),
								new ItemStack(ConfigItems.itemShard, 1, 1),
								new ItemStack(ConfigItems.itemShard, 1, 2),
								new ItemStack(ConfigItems.itemShard, 1, 3),
								new ItemStack(ConfigItems.itemShard, 1, 4),
								new ItemStack(ConfigItems.itemShard, 1, 5),
								new ItemStack(ConfigItems.itemShard, 1, 6) });
		InfusionRecipe EldriplateH = ThaumcraftApi.addInfusionCraftingRecipe(
				"Eldriplate",
				new ItemStack(ModItems.EldriplateH),
				7,
				new AspectList().add(Aspect.DARKNESS, 32)
						.add(Aspect.ELDRITCH, 16).add(Aspect.VOID, 16),
				new ItemStack(Armorizer.VoidHelmet), new ItemStack[] {
						new ItemStack(ConfigItems.itemHelmetVoidRobe),
						new ItemStack(Itemizer.GoldicapPedals),
						new ItemStack(Itemizer.GoldicapPedals),
						new ItemStack(Itemizer.GoldicapPedals),
						new ItemStack(Tabletizer.TabletDebuff),
						new ItemStack(Armorizer.SpeedHelmet) }); // TODO make
																	// the
																	// dimension
																	// aspects
		InfusionRecipe EldriplateC = ThaumcraftApi.addInfusionCraftingRecipe(
				"Eldriplate", new ItemStack(ModItems.EldriplateC), 7,
				new AspectList().add(Aspect.AIR, 32).add(Aspect.ELDRITCH, 16)
						.add(Aspect.VOID, 16), new ItemStack(
						Armorizer.VoidChestplate), new ItemStack[] {
						new ItemStack(ConfigItems.itemChestVoidRobe),
						new ItemStack(Itemizer.OpteryxFeather),
						new ItemStack(Itemizer.OpteryxFeather),
						new ItemStack(Itemizer.OpteryxFeather),
						new ItemStack(Tabletizer.TabletResistance),
						new ItemStack(Armorizer.SpeedChestplate) });
		InfusionRecipe EldriplateL = ThaumcraftApi.addInfusionCraftingRecipe(
				"Eldriplate", new ItemStack(ModItems.EldriplateL), 7,
				new AspectList().add(Aspect.MOTION, 32)
						.add(Aspect.ELDRITCH, 16).add(Aspect.VOID, 16),
				new ItemStack(Armorizer.VoidLeggings), new ItemStack[] {
						new ItemStack(ConfigItems.itemLegsVoidRobe),
						new ItemStack(Itemizer.Rosidons),
						new ItemStack(Itemizer.Rosidons),
						new ItemStack(Itemizer.Rosidons),
						new ItemStack(Tabletizer.TabletSpeed),
						new ItemStack(Armorizer.SpeedLeggings) });
		InfusionRecipe EldriplateB = ThaumcraftApi.addInfusionCraftingRecipe(
				"Eldriplate", new ItemStack(ModItems.EldriplateB), 7,
				new AspectList().add(Aspect.TRAVEL, 32)
						.add(Aspect.ELDRITCH, 16).add(Aspect.VOID, 16),
				new ItemStack(Armorizer.VoidBoots), new ItemStack[] {
						new ItemStack(ConfigItems.itemBootsVoid),
						new ItemStack(Itemizer.HollyTopPedals),
						new ItemStack(Itemizer.HollyTopPedals),
						new ItemStack(Itemizer.HollyTopPedals),
						new ItemStack(Weaponizer.Gravitator),
						new ItemStack(Armorizer.SpeedBoots) });

		new ResearchItem("Elemental_Lyndamyte", "AOATC", (new AspectList()
				.add(Aspect.ENTROPY, 8).add(Aspect.FIRE, 8).add(Aspect.AIR, 8)
				.add(Aspect.WATER, 8).add(Aspect.EARTH, 8).add(Aspect.ORDER, 8)
				.add(Aspect.ARMOR, 8).add(Aspect.METAL, 8)), 3, 7, 2,
				new ItemStack(ModItems.ElementalLyndamyteC))
				.setParents("Overworld", "INFUSION")
				.setHidden()
				.setPages(
						new ResearchPage(
								StatCollector
										.translateToLocal("tc.fluff.Elemental_Lyndamyte")),
						new ResearchPage(ElementalLyndamyteH),
						new ResearchPage(ElementalLyndamyteC),
						new ResearchPage(ElementalLyndamyteL),
						new ResearchPage(ElementalLyndamyteB))
				.registerResearchItem();
		new ResearchItem("Eldriplate", "AOATC",
				(new AspectList().add(Aspect.ELDRITCH, 8).add(Aspect.MOTION, 8)
						.add(Aspect.TRAVEL, 8).add(Aspect.AIR, 8)
						.add(Aspect.ARMOR, 8).add(Aspect.METAL, 8)), 1, 9, 4,
				new ItemStack(ModItems.EldriplateC))
				.setParents("Overworld", "INFUSION")
				.setHidden()
				.setPages(
						new ResearchPage(StatCollector
								.translateToLocal("tc.fluff.Eldriplate")),
						new ResearchPage(EldriplateH),
						new ResearchPage(EldriplateC),
						new ResearchPage(EldriplateL),
						new ResearchPage(EldriplateB)).registerResearchItem();
		ThaumcraftApi.addWarpToResearch("Eldriplate", 2);
	}
}
