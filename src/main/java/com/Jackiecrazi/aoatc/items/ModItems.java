package com.Jackiecrazi.aoatc.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.nevermine.izer.Itemizer;
import net.nevermine.izer.equipment.Armorizer;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.wands.StaffRod;
import thaumcraft.api.wands.WandCap;
import thaumcraft.api.wands.WandRod;
import thaumcraft.common.items.wands.WandRodPrimalOnUpdate;

import com.Jackiecrazi.aoatc.AoATC;
import com.Jackiecrazi.aoatc.items.armour.ArmourEldriplate;
import com.Jackiecrazi.aoatc.items.armour.ArmourElementalLyndamyte;
import com.Jackiecrazi.aoatc.items.armour.ArmourEnderViking;
import com.Jackiecrazi.aoatc.items.baubles.VisHoldingPendant;
import com.Jackiecrazi.aoatc.items.foci.FocusCoral;
import com.Jackiecrazi.aoatc.items.foci.FocusCreateMithions;
import com.Jackiecrazi.aoatc.items.foci.FocusFire;
import com.Jackiecrazi.aoatc.items.foci.FocusNoxious;
import com.Jackiecrazi.aoatc.items.foci.FocusPoison;
import com.Jackiecrazi.aoatc.items.foci.FocusWater;
import com.Jackiecrazi.aoatc.items.foci.FocusWind;
import com.Jackiecrazi.aoatc.items.foci.FocusWither;
import com.Jackiecrazi.aoatc.items.utility.InfiniteBulletBag;
import com.Jackiecrazi.aoatc.items.weapons.DemonicSkellyArchergun;
import com.Jackiecrazi.aoatc.items.weapons.DemonicSkellySword;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {
	public static Item wandCore,staffCore,oldCaps;
	public static WandRod rod_dawnwood,rod_fungal,rod_ember,rod_limonite,rod_lunosso,rod_ivory,rod_irowood,rod_bloodwood,rod_haunted;
	public static StaffRod staff_fungal,staff_dawnwood,staff_ivory,staff_irowood,staff_bloodwood,staff_haunted;
	public static WandCap cap_lyon,cap_mercurial,cap_omni,cap_bloodstone,cap_runium;
	public static Item MithionFocus,WindFocus,CoralFocus,NoxiousFocus,PoisonFocus,WitherFocus,FireFocus,WaterFocus;
	public static Item ElementalLyndamyteH,ElementalLyndamyteC,ElementalLyndamyteL,ElementalLyndamyteB,EldriplateH,EldriplateC,EldriplateL,EldriplateB,EVH,EVC,EVL,EVB;
	public static Item infBulletBag;
	public static Item MysteriumPendant;
	public static Item DebugSummoner,AugiteDeleter;
	public static Item SkellySword,SkellyArchergun;
	public static Item.ToolMaterial Demon = EnumHelper.addToolMaterial("Corruption", 4, 200, 4.0F, 31.0F, 15);
	public static void init()
    {
		
		wandCore = new AdventWandCores().setUnlocalizedName("AdventWandCores");
		GameRegistry.registerItem(wandCore, "AdventWandCores");
		staffCore = new AdventStaffCores().setUnlocalizedName("AdventStaffCores");
		GameRegistry.registerItem(staffCore, "AdventStaffCores");
		oldCaps = new AdventOldCaps().setUnlocalizedName("AdventCaps");
		GameRegistry.registerItem(oldCaps, "AdventCaps");
		AugiteDeleter = new AugiteDeleter().setTextureName("aoatc:augite_deleter");
		GameRegistry.registerItem(AugiteDeleter, "AugiteDeleter");
		DebugSummoner=new DebugSummoner().setUnlocalizedName("DebugItem");
		GameRegistry.registerItem(DebugSummoner, "DebugItem");
		
		ElementalLyndamyteH = new ArmourElementalLyndamyte("EL_Helm",Armorizer.AdventArmor,2,0);
		ElementalLyndamyteC = new ArmourElementalLyndamyte("EL_Chest",Armorizer.AdventArmor,2,1);
		ElementalLyndamyteL = new ArmourElementalLyndamyte("EL_Legs",Armorizer.AdventArmor,2,2);
		ElementalLyndamyteB = new ArmourElementalLyndamyte("EL_Boots",Armorizer.AdventArmor,2,3);
		EldriplateH = new ArmourEldriplate("EldriplateFacemask",Armorizer.AdventArmor,2,0);
		EldriplateC = new ArmourEldriplate("EldriplateGi",Armorizer.AdventArmor,2,1);
		EldriplateL = new ArmourEldriplate("EldriplateLeggings",Armorizer.AdventArmor,2,2);
		EldriplateB = new ArmourEldriplate("EldriplateBoots",Armorizer.AdventArmor,2,3);
		EVH=new ArmourEnderViking("EVHelmet",Armorizer.AdventArmor,4,0);
		EVC= new ArmourEnderViking("EVChest",Armorizer.AdventArmor,4,1);
		EVL= new ArmourEnderViking("EVLegs",Armorizer.AdventArmor,4,2);
		EVB= new ArmourEnderViking("EVBoots",Armorizer.AdventArmor,4,3);
		GameRegistry.registerItem(EVH,"EVH");
		GameRegistry.registerItem(EVC,"EVC");
		GameRegistry.registerItem(EVL,"EVL");
		GameRegistry.registerItem(EVB,"EVB");
		GameRegistry.registerItem(EldriplateH, "EldriplateFacemask");
		GameRegistry.registerItem(EldriplateC, "EldriplateGi");
		GameRegistry.registerItem(EldriplateL, "EldriplateLeggings");
		GameRegistry.registerItem(EldriplateB, "EldriplateBoots");
		GameRegistry.registerItem(ElementalLyndamyteH, "EL_Helm");
		GameRegistry.registerItem(ElementalLyndamyteC, "EL_Chest");
		GameRegistry.registerItem(ElementalLyndamyteL, "EL_Legs");
		GameRegistry.registerItem(ElementalLyndamyteB, "EL_Boots");
		
		infBulletBag=new InfiniteBulletBag().setTextureName("aoatc:InfBulBag");
		GameRegistry.registerItem(infBulletBag, "InfBulBag");
		
		MysteriumPendant=new VisHoldingPendant("Mysterium").setUnlocalizedName("MysteriumPendant");
		GameRegistry.registerItem(MysteriumPendant, "MysteriumPendant");
		
		SkellySword = new DemonicSkellySword(Demon).setCreativeTab(AoATC.tabAT).setTextureName("aoatc:swordSkeleton");
		GameRegistry.registerItem(SkellySword, "DemonSkeleSword");
		SkellyArchergun=new DemonicSkellyArchergun(101, "Archergun", 800, 1, Itemizer.ElementalArrow).setRecoil(1.0F).setUnlocalizedName("DemonSkeleArchergun").setTextureName("aoatc:archergunSkeleton");
		GameRegistry.registerItem(SkellyArchergun, "DemonSkeleArchergun");
		
		MithionFocus = new FocusCreateMithions().setUnlocalizedName("FocusMinion").setCreativeTab(AoATC.tabAT).setTextureName("aoatc:focus_minion");
		GameRegistry.registerItem(MithionFocus, "minionfocus");
		WindFocus = new FocusWind().setUnlocalizedName("FocusWind").setCreativeTab(AoATC.tabAT).setTextureName("aoatc:focus_wind");
		GameRegistry.registerItem(WindFocus, "FocusWind");
		CoralFocus = new FocusCoral().setUnlocalizedName("FocusCoral").setCreativeTab(AoATC.tabAT).setTextureName("aoatc:focus_coral");
		GameRegistry.registerItem(CoralFocus, "FocusCoral");
		NoxiousFocus= new FocusNoxious().setUnlocalizedName("FocusNoxious").setCreativeTab(AoATC.tabAT).setTextureName("aoatc:focus_noxious");
		GameRegistry.registerItem(NoxiousFocus, "FocusNoxious");
		PoisonFocus=new FocusPoison().setUnlocalizedName("FocusPoison").setCreativeTab(AoATC.tabAT).setTextureName("aoatc:focus_poison");
		GameRegistry.registerItem(PoisonFocus, "FocusPoison");
		WitherFocus=new FocusWither().setUnlocalizedName("FocusWither").setCreativeTab(AoATC.tabAT).setTextureName("aoatc:focus_wither");
		GameRegistry.registerItem(WitherFocus, "FocusWither");
		FireFocus=new FocusFire().setUnlocalizedName("FocusFire").setCreativeTab(AoATC.tabAT).setTextureName("aoatc:focus_fire");
		GameRegistry.registerItem(FireFocus, "FocusFire");
		WaterFocus=new FocusWater().setUnlocalizedName("FocusWater").setCreativeTab(AoATC.tabAT).setTextureName("aoatc:focus_water");
		GameRegistry.registerItem(WaterFocus, "FocusWater");
		rod_dawnwood = new WandRod("Dawnwood", 200, new ItemStack(wandCore,1,0), 20, new GenericRodUpdate(Aspect.ENTROPY,300), new ResourceLocation("aoatc","textures/models/wands/wand_rod_dawnwood.png"));;
		rod_fungal = new WandRod("Fungal", 90, new ItemStack(wandCore,1,1), 15, new GenericRodUpdate(1000), new ResourceLocation("aoatc","textures/models/wands/wand_rod_fungal.png"));
		rod_ember = new WandRod("Emberstone", 95, new ItemStack(wandCore,1,2), 15, new EmberRodUpdate(), new ResourceLocation("aoatc","textures/models/wands/wand_rod_emberstone.png"));
		rod_lunosso = new WandRod("Lunosso", 125, new ItemStack(wandCore,1,3), 15, new LunossoRodUpdate(), new ResourceLocation("aoatc","textures/models/wands/wand_rod_lunosso.png"));
		rod_limonite = new WandRod("Limonite", 100, new ItemStack(wandCore,1,4), 15, new ResourceLocation("aoatc","textures/models/wands/wand_rod_limonite.png"));
		rod_ivory=new WandRod("Ivory", 90, new ItemStack(wandCore,1,5), 15, new ResourceLocation("aoatc","textures/models/wands/wand_rod_ivory.png"));
		rod_irowood=new WandRod("Irowood", 100, new ItemStack(wandCore,1,6), 15, new ResourceLocation("aoatc","textures/models/wands/wand_rod_irowood.png"));
		rod_bloodwood=new WandRod("Bloodwood", 100, new ItemStack(wandCore,1,7), 15, new ResourceLocation("aoatc","textures/models/wands/wand_rod_bloodwood.png"));
		rod_haunted=new WandRod("Haunted", 100, new ItemStack(wandCore,1,8), 15, new ResourceLocation("aoatc","textures/models/wands/wand_rod_haunted.png"));
		
		staff_fungal = new StaffRod("Fungal", 135, new ItemStack(staffCore,1,1), 30, new GenericRodUpdate(500), new ResourceLocation("aoatc","textures/models/wands/wand_rod_fungal.png"));
		staff_dawnwood= new StaffRod("Dawnwood", 200,new ItemStack(staffCore,1,0),40,new GenericRodUpdate(Aspect.ENTROPY,200),new ResourceLocation("aoatc","textures/models/wands/wand_rod_dawnwood.png"));
		staff_ivory= new StaffRod("Ivory", 180,new ItemStack(staffCore,1,2),40,new ResourceLocation("aoatc","textures/models/wands/wand_rod_ivory.png"));
		staff_irowood= new StaffRod("Irowood", 200,new ItemStack(staffCore,1,3),40,new ResourceLocation("aoatc","textures/models/wands/wand_rod_irowood.png"));
		staff_haunted= new StaffRod("Haunted", 200,new ItemStack(staffCore,1,5),40,new ResourceLocation("aoatc","textures/models/wands/wand_rod_haunted.png"));
		staff_bloodwood= new StaffRod("Bloodwood", 180,new ItemStack(staffCore,1,4),40,new ResourceLocation("aoatc","textures/models/wands/wand_rod_bloodwood.png"));
		
		cap_lyon = new AscendingCap("Lyon", 0.8F, new ItemStack(oldCaps,1,1), 3, new ResourceLocation("aoatc","textures/models/wands/wand_cap_lyon.png"));
		cap_omni = new AscendingCap("Omni", 0.85F, new ItemStack(oldCaps,1,5), 5, new ResourceLocation("aoatc","textures/models/wands/wand_cap_omni.png"));
		cap_mercurial = new AscendingCap("Mercurial", 0.85F, new ItemStack(oldCaps,1,3), 6, new ResourceLocation("aoatc","textures/models/wands/wand_cap_mercurial.png"));
		cap_bloodstone=new AscendingCap("Bloodstone", 0.85F, new ItemStack(oldCaps,1,9), 6, new ResourceLocation("aoatc","textures/models/wands/wand_cap_bloodstone.png"));
		cap_runium=new AscendingCap("Runium", 0.89F, new ItemStack(oldCaps,1,7), 6, new ResourceLocation("aoatc","textures/models/wands/wand_cap_runium.png"));
    }
}
