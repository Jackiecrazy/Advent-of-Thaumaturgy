package com.Jackiecrazi.aoatc.researchesnrecipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.nevermine.izer.Blockizer;
import net.nevermine.izer.Itemizer;
import net.nevermine.izer.equipment.Slabizer;
import net.nevermine.izer.equipment.Tabletizer;
import net.nevermine.izer.equipment.Weaponizer;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import com.Jackiecrazi.aoatc.items.ModItems;

public class Foci {
	public static void addFoci(){
		InfusionRecipe MithionFocus = 
				ThaumcraftApi.addInfusionCraftingRecipe("FOCUS_Minion", new ItemStack(ModItems.MithionFocus), 6, new AspectList().add(Aspect.MOTION, 16).add(Aspect.LIFE, 40).add(Aspect.SOUL, 24).add(Aspect.MAGIC, 16),new ItemStack(Itemizer.EmptySlab), new ItemStack[]{new ItemStack(Slabizer.AlluricornSlab),new ItemStack(Slabizer.BlissardSlab),new ItemStack(Slabizer.CompeerSlab),new ItemStack(Slabizer.ConstructServilitySlab),new ItemStack(Slabizer.ConstructServilitySlab),new ItemStack(Slabizer.CorbySlab),new ItemStack(Slabizer.CraggySlab),new ItemStack(Slabizer.DraggySlab),new ItemStack(Slabizer.EnderCarrierSlab),new ItemStack(Slabizer.GnawerSlab),new ItemStack(Slabizer.GooferSlab),new ItemStack(Slabizer.HealingGolemSlab),new ItemStack(Slabizer.HellquinSlab),new ItemStack(Slabizer.HorntailSlab),new ItemStack(Slabizer.MechaCyclopsSlab),new ItemStack(Slabizer.MechaSkelloxSlab),new ItemStack(Slabizer.PenguinSlab),new ItemStack(Slabizer.PlateosaurSlab),new ItemStack(Slabizer.RammerhornSlab),new ItemStack(Slabizer.ShaddySlab),new ItemStack(Slabizer.SpikebackSlab),new ItemStack(Slabizer.SpraggySlab),new ItemStack(Slabizer.WaggySlab),new ItemStack(Items.quartz),new ItemStack(Items.quartz)});
		InfusionRecipe CoralFocus = 
				ThaumcraftApi.addInfusionCraftingRecipe("FOCUS_Coral", new ItemStack(ModItems.CoralFocus), 5, new AspectList().add(Aspect.HEAL, 8).add(Aspect.LIFE, 20).add(Aspect.WATER, 32).add(Aspect.MAGIC, 16),new ItemStack(Weaponizer.CoralStaff), new ItemStack[]{new ItemStack(Items.golden_apple),new ItemStack(Items.golden_apple),new ItemStack(Items.golden_apple),new ItemStack(Itemizer.WaterRune),new ItemStack(Itemizer.WaterRune),new ItemStack(Itemizer.WaterRune),new ItemStack(Tabletizer.TabletHealth)});
		InfusionRecipe NoxiousFocus = 
				ThaumcraftApi.addInfusionCraftingRecipe("FOCUS_Noxious", new ItemStack(ModItems.NoxiousFocus), 5, new AspectList().add(Aspect.POISON, 20).add(Aspect.DEATH, 10).add(Aspect.MAGIC, 32),new ItemStack(Weaponizer.NoxiousStaff), new ItemStack[]{new ItemStack(Itemizer.SludgeParasite),new ItemStack(Itemizer.ToxicLump),new ItemStack(Itemizer.PoisonRune),new ItemStack(Itemizer.PoisonRune),new ItemStack(Itemizer.PoisonRune),new ItemStack(Itemizer.DoomStone)});
		
		new ResearchItem("FOCUS_Coral", "AOATC", (new AspectList().add(Aspect.WATER, 16).add(Aspect.HEAL, 8)), 1, 8, 2, new ItemStack(ModItems.CoralFocus))
		.setParents("Overworld","INFUSION")
		.setItemTriggers(new ItemStack(Weaponizer.CoralStaff))
		.setHidden()
		.setPages(
			new ResearchPage(StatCollector.translateToLocal("tc.fluff.FOCUS_Coral")),
			new ResearchPage(CoralFocus)
		)
		.registerResearchItem();
		
		new ResearchItem("FOCUS_Noxious", "AOATC", (new AspectList().add(Aspect.POISON, 16).add(Aspect.ENTROPY, 8)), -1, -8, 3, new ItemStack(ModItems.NoxiousFocus))
		.setParents("VoxPonds")
		.setParentsHidden("FOCUS_Coral")
		.setHidden()
		.setItemTriggers(new ItemStack(Weaponizer.NoxiousStaff))
		.setPages(
			new ResearchPage(StatCollector.translateToLocal("tc.fluff.FOCUS_Noxious")),
			new ResearchPage(NoxiousFocus)
		)
		.registerResearchItem();
		
	new ResearchItem("FOCUS_Minion", "AOATC", (new AspectList().add(Aspect.SOUL, 32).add(Aspect.MOTION, 16).add(Aspect.LIFE, 8).add(Aspect.ELDRITCH, 8)), 3, 0, 5, new ItemStack(ModItems.MithionFocus))
	.setParentsHidden("FOCUS_Coral","Greckon","Haven","Abyss","Dustopia")
	.setHidden()
	.setConcealed()
	.setItemTriggers(new ItemStack(Slabizer.AlluricornSlab),new ItemStack(Slabizer.BlissardSlab),new ItemStack(Slabizer.CompeerSlab),new ItemStack(Slabizer.ConstructServilitySlab),new ItemStack(Slabizer.ConstructServilitySlab),new ItemStack(Slabizer.CorbySlab),new ItemStack(Slabizer.CraggySlab),new ItemStack(Slabizer.DraggySlab),new ItemStack(Slabizer.EnderCarrierSlab),new ItemStack(Slabizer.GnawerSlab),new ItemStack(Slabizer.GooferSlab),new ItemStack(Slabizer.HealingGolemSlab),new ItemStack(Slabizer.HellquinSlab),new ItemStack(Slabizer.HorntailSlab),new ItemStack(Slabizer.MechaCyclopsSlab),new ItemStack(Slabizer.MechaSkelloxSlab),new ItemStack(Slabizer.PenguinSlab),new ItemStack(Slabizer.PlateosaurSlab),new ItemStack(Slabizer.RammerhornSlab),new ItemStack(Slabizer.ShaddySlab),new ItemStack(Slabizer.SpikebackSlab),new ItemStack(Slabizer.SpraggySlab),new ItemStack(Slabizer.WaggySlab))
	.setPages(
		new ResearchPage(StatCollector.translateToLocal("tc.fluff.FOCUS_Minion")),
		new ResearchPage(MithionFocus)
	)
	.registerResearchItem();
	}
}
