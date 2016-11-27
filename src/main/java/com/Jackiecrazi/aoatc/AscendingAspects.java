package com.Jackiecrazi.aoatc;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import com.google.common.collect.ImmutableList;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.nevermine.item.weapon.energy.BaseEnergy;
import net.nevermine.item.weapon.gun.BaseGun;
import net.nevermine.item.weapon.staff.BaseStaff;
import net.nevermine.izer.Itemizer;
import net.nevermine.izer.equipment.Weaponizer;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class AscendingAspects {
	/*
	 * public static Aspect ABYSS,ANCIENTCAVERN; public static Aspect BARATHOS;
	 * public static Aspect CANDYLAND,CELEVE,CREEPONIA,CRYSTEVIA; public static
	 * Aspect DEEPLANDS,DUSTOPIA; public static Aspect ETHEREUS,EVERLAND; public
	 * static Aspect GARDENCIA,GRECKON; public static Aspect HAVEN; public
	 * static Aspect IMMORTALLIS; public static Aspect PLUTON; public static
	 * Aspect LABRICON,LELYETIA,LBOREAN,LUNALUS; public static Aspect MYSTERIUM;
	 * public static Aspect PLAYTOPIA,SELYAN; public static Aspect RUNANDOR;
	 * public static Aspect SHYRELANDS; public static Aspect VOXPONDS;
	 */
	public static Aspect DIMENSION;
	public static Aspect EREBON;
	public static Aspect PLUTON;
	public static Aspect SELYAN;
	public static Aspect LUXON;

	public static void aspectize() {
		DIMENSION = new Aspect("imperium", 0x9900FF, new Aspect[] {
				Aspect.ELDRITCH, Aspect.EARTH }, new ResourceLocation("aoatc",
				"textures/aspects/dimension.png"), 1);
		/*
		 * ABYSS=new Aspect("cruentis",0xFF0000, new Aspect[] { Aspect.FLESH,
		 * Aspect.DARKNESS }, new ResourceLocation("aoatc",
		 * "textures/aspects/abyss.png"), 1); CELEVE=new
		 * Aspect("scurra",0xFFFF00, new Aspect[] { Aspect.MAN, Aspect.DARKNESS
		 * }, new ResourceLocation("aoatc", "textures/aspects/celeve.png"), 1);
		 * DEEPLANDS=new Aspect("saxum",0x999999, new Aspect[] { Aspect.EARTH,
		 * Aspect.MINE }, new ResourceLocation("aoatc",
		 * "textures/aspects/deeplands.png"), 1); HAVEN=new
		 * Aspect("caelestis",0x66FFFF, new Aspect[] { Aspect.LIGHT,
		 * Aspect.FLIGHT }, new ResourceLocation("aoatc",
		 * "textures/aspects/haven.png"), 1); LBOREAN=new
		 * Aspect("oceanum",0x0099FF, new Aspect[] { Aspect.WATER, Aspect.PLANT
		 * }, new ResourceLocation("aoatc", "textures/aspects/lborean.png"), 1);
		 * LUNALUS=new Aspect("lunae",0xFF00FF, new Aspect[] { Aspect.ELDRITCH,
		 * Aspect.EARTH }, new ResourceLocation("aoatc",
		 * "textures/aspects/lunalus.png"), 1); MYSTERIUM=new
		 * Aspect("mysticus",0x3366FF, new Aspect[] { Aspect.MIND,
		 * Aspect.ELDRITCH }, new ResourceLocation("aoatc",
		 * "textures/aspects/mysterium.png"), 1); PRECASIA=new
		 * Aspect("veteris",0x00CC00, new Aspect[] { Aspect.BEAST, Aspect.TREE
		 * }, new ResourceLocation("aoatc", "textures/aspects/SELYAN.png"), 1);
		 * CREEPONIA=new Aspect("displodo",0x006600, new Aspect[] {
		 * Aspect.ENTROPY, Aspect.EARTH }, new ResourceLocation("aoatc",
		 * "textures/aspects/creeponia.png"), 1); ANCIENTCAVERN=new
		 * Aspect("dominus",0x9933FF, new Aspect[] { Aspect.VOID, Aspect.SOUL },
		 * new ResourceLocation("aoatc", "textures/aspects/ancientcavern.png"),
		 * 1); RUNANDOR=new Aspect("tabula",0x00FFFF, new Aspect[] { MYSTERIUM,
		 * Aspect.MAGIC }, new ResourceLocation("aoatc",
		 * "textures/aspects/runandor.png"), 1); GRECKON=new
		 * Aspect("exterreo",0x330066, new Aspect[] { MYSTERIUM, Aspect.DARKNESS
		 * }, new ResourceLocation("aoatc", "textures/aspects/greckon.png"), 1);
		 * BARATHOS =new Aspect("solitudinem",0x990000, new Aspect[] { RUNANDOR,
		 * Aspect.EARTH }, new ResourceLocation("aoatc",
		 * "textures/aspects/barathos.png"), 1); CANDYLAND=new
		 * Aspect("dulcis",0xFF6633, new Aspect[] { CELEVE, Aspect.HUNGER }, new
		 * ResourceLocation("aoatc", "textures/aspects/candyland.png"), 1);
		 * CRYSTEVIA=new Aspect("crystallinus",0x66CCFF, new Aspect[] {
		 * DEEPLANDS, Aspect.CRYSTAL }, new ResourceLocation("aoatc",
		 * "textures/aspects/crystevia.png"), 1); DUSTOPIA=new
		 * Aspect("umbra",0x000000, new Aspect[] { GRECKON, Aspect.DARKNESS },
		 * new ResourceLocation("aoatc", "textures/aspects/dustopia.png"), 1);
		 * GARDENCIA=new Aspect("floridis",0x33FF33, new Aspect[] { SELYAN,
		 * Aspect.PLANT }, new ResourceLocation("aoatc",
		 * "textures/aspects/gardencia.png"), 1); IMMORTALLIS=new
		 * Aspect("carcerem",0xFF6600, new Aspect[] { Aspect.SOUL,
		 * Aspect.ELDRITCH }, new ResourceLocation("aoatc",
		 * "textures/aspects/immortallis.png"), 1); IROMINE=new
		 * Aspect("aurumea",0xFFCC00, new Aspect[] { DEEPLANDS, Aspect.METAL },
		 * new ResourceLocation("aoatc", "textures/aspects/iromine.png"),1);
		 * LELYETIA=new Aspect("silvis",0xFF9900, new Aspect[] { HAVEN,
		 * Aspect.ELDRITCH }, new ResourceLocation("aoatc",
		 * "textures/aspects/lelyetia.png"), 1); VOXPONDS=new
		 * Aspect("toxicus",0x009900, new Aspect[] { GARDENCIA, Aspect.POISON },
		 * new ResourceLocation("aoatc", "textures/aspects/voxponds.png"), 1);
		 */
		EREBON = new Aspect("praelia", 0xFF3300, new Aspect[] { DIMENSION,
				Aspect.WEAPON }, new ResourceLocation("aoatc",
				"textures/aspects/erebon.png"), 1);
		PLUTON = new Aspect("thensauri", 0xCCCC33, new Aspect[] { DIMENSION,
				Aspect.GREED }, new ResourceLocation("aoatc",
				"textures/aspects/pluton.png"), 1);
		SELYAN = new Aspect("naturae", 0x00FF00, new Aspect[] { DIMENSION,
				Aspect.PLANT }, new ResourceLocation("aoatc",
				"textures/aspects/selyan.png"), 1);
		LUXON = new Aspect("lucis", 0xFFFF33, new Aspect[] { DIMENSION,
				Aspect.LIGHT }, new ResourceLocation("aoatc",
				"textures/aspects/luxon.png"), 1);
	}

	public static void actuallyaspectizeW() {
		AspectList l;
		/*
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.Abominator,1), new AspectList().add(SELYAN,
		 * 3).add(Aspect.WEAPON, 6)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.Abyssro,1), new AspectList().add(IROMINE,
		 * 3).add(Aspect.WEAPON, 6).add(ABYSS,3));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.AlacrityBow,1), new
		 * AspectList().add(Aspect.MOTION, 3).add(Aspect.WEAPON, 3));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.AmethystSword,1), new
		 * AspectList().add(Aspect.GREED, 3).add(Aspect.WEAPON, 4));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.AncientBomber,1), new
		 * AspectList().add(Aspect.ENTROPY, 5).add(Aspect.WEAPON, 5).add(SELYAN,
		 * 3)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.AncientBow,1), new AspectList().add(SELYAN,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.POISON, 5));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.AncientDischarger,1), new
		 * AspectList().add(Aspect.FIRE, 3).add(Aspect.WEAPON, 5).add(SELYAN,
		 * 3)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.ApocoAssaultRifle,1), new
		 * AspectList().add(VOXPONDS, 3).add(Aspect.WEAPON, 5).add(IROMINE, 3));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.ApocoRifle,1), new AspectList().add(VOXPONDS,
		 * 3).add(Aspect.WEAPON, 5).add(GRECKON, 3).add(Aspect.ENTROPY, 3));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.ApocoShower,1), new AspectList().add(VOXPONDS,
		 * 3).add(Aspect.WEAPON, 5).add(ABYSS, 3).add(Aspect.ENTROPY, 3));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.AquaCannon,1), new AspectList().add(LBOREAN,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.HEAL, 2));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.AquaMagnum,1), new AspectList().add(LBOREAN,
		 * 3).add(Aspect.WEAPON, 5).add(CANDYLAND, 3));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.AquaticStaff,1), new AspectList().add(LBOREAN,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.WATER, 2));
		 * ThaumcraftApi.registerObjectTag(new ItemStack(Weaponizer.Artifact,1),
		 * new AspectList().add(Aspect.ENTROPY, 3).add(Aspect.FLIGHT,
		 * 2).add(Aspect.WEAPON, 5).add(LELYETIA, 3));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.AtlanticBow,1), new
		 * AspectList().add(Aspect.WATER, 3).add(Aspect.WEAPON,
		 * 3).add(Aspect.TRAP, 2)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.AtlanticStaff,1), new
		 * AspectList().add(Aspect.WATER, 3).add(Aspect.WEAPON,
		 * 3).add(Aspect.TRAP, 2).add(Aspect.MAGIC, 2));
		 * ThaumcraftApi.registerObjectTag(new ItemStack(Weaponizer.Atomizer,1),
		 * new AspectList().add(LUNALUS, 3).add(Aspect.WEAPON,
		 * 5).add(Aspect.ENTROPY, 2).add(Aspect.MOTION, 1));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BalloonBomber,1), new AspectList().add(CELEVE,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.ENTROPY, 2));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.Baronator,1), new AspectList().add(BARATHOS,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.ENTROPY, 2));
		 * ThaumcraftApi.registerObjectTag(new ItemStack(Weaponizer.BaronBow,1),
		 * new AspectList().add(BARATHOS, 3).add(Aspect.WEAPON, 3));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BaronGreatblade,1), new
		 * AspectList().add(BARATHOS, 3).add(Aspect.WEAPON,
		 * 3).add(Aspect.ENTROPY, 2)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BaronSSR,1), new AspectList().add(BARATHOS,
		 * 3).add(Aspect.WEAPON, 5)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BaronStaff,1), new AspectList().add(BARATHOS,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.MAGIC, 2));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BaronSword,1), new AspectList().add(BARATHOS,
		 * 3).add(Aspect.WEAPON, 5)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BattleVulcane,1), new
		 * AspectList().add(IMMORTALLIS, 3).add(Aspect.WEAPON,
		 * 5).add(Aspect.ENTROPY, 2)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BayonetteRifle,1), new AspectList().add(HAVEN,
		 * 3).add(Aspect.WEAPON, 4)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BayonetteSR,1), new AspectList().add(RUNANDOR,
		 * 3).add(Aspect.WEAPON, 4)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.Beamer,1), new AspectList().add(DUSTOPIA,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.ENTROPY, 3));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BearBlaster,1), new AspectList().add(MYSTERIUM,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.BEAST, 2));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BeeBlaster,1), new AspectList().add(MYSTERIUM,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.BEAST, 2));
		 * ThaumcraftApi.registerObjectTag(new ItemStack(Weaponizer.BigBlast,1),
		 * new AspectList().add(ABYSS, 3).add(Aspect.WEAPON,
		 * 5).add(Aspect.MOTION, 3)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BigTop,1), new AspectList().add(CELEVE,
		 * 3).add(Aspect.WEAPON, 5)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BlastBarrel,1), new AspectList().add(CRYSTEVIA,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.EARTH, 2));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BlastCannon,1), new AspectList().add(ABYSS,
		 * 3).add(LELYETIA, 3).add(Aspect.WEAPON, 5).add(Aspect.ENTROPY, 2));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BlastChiller,1), new
		 * AspectList().add(Aspect.TRAP, 3).add(Aspect.WEAPON, 3));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BlissfulBlast,1), new AspectList().add(ABYSS,
		 * 3).add(CELEVE, 3).add(Aspect.WEAPON, 5).add(Aspect.MOTION, 3));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BloodDrainer,1), new AspectList().add(ABYSS,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.LIFE, 2).add(Aspect.HUNGER, 2));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.Bloodfury,1), new AspectList().add(ABYSS,
		 * 3).add(Aspect.WEAPON, 3)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BloodIron,1), new AspectList().add(ABYSS,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.MOTION, 2));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BloodstoneSword,1), new AspectList().add(ABYSS,
		 * 3).add(Aspect.WEAPON, 3)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BlueBarrel,1), new
		 * AspectList().add(Aspect.MOTION, 3).add(Aspect.WEAPON, 3));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BoltRifle,1), new AspectList().add(IROMINE,
		 * 3).add(Aspect.WEAPON, 3)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BombLauncher,1), new AspectList().add(ABYSS,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.ENTROPY, 2));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BoneBlaster,1), new AspectList().add(SELYAN,
		 * 3).add(Aspect.WEAPON, 3)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BoomBoom,1), new AspectList().add(CREEPONIA,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.ENTROPY, 2));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BoomCannon,1), new
		 * AspectList().add(Aspect.ENTROPY, 3).add(Aspect.WEAPON, 3));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BoreicBow,1), new AspectList().add(LBOREAN,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.ENERGY, 2));
		 * ThaumcraftApi.registerObjectTag(new ItemStack(Weaponizer.Boulder,1),
		 * new AspectList().add(MYSTERIUM, 3).add(BARATHOS,
		 * 3).add(Aspect.WEAPON, 5).add(Aspect.ENERGY, 2));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BoulderBomber,1), new
		 * AspectList().add(DEEPLANDS, 3).add(DUSTOPIA, 1).add(SELYAN,
		 * 1).add(Aspect.WEAPON, 5).add(Aspect.MOTION, 2));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BozoBlaster,1), new AspectList().add(CELEVE,
		 * 3).add(Aspect.WEAPON, 3)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BrownBlaster,1), new
		 * AspectList().add(Aspect.WEAPON, 2).add(Aspect.MOTION, 1));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BubbleHorn,1), new AspectList().add(HAVEN,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.TRAP, 1));
		 * ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.BulbCannon,1), new
		 * AspectList().add(Aspect.UNDEAD, 3).add(ABYSS, 3).add(Aspect.WEAPON,
		 * 5).add(Aspect.MOTION, 2)); ThaumcraftApi.registerObjectTag(new
		 * ItemStack(Weaponizer.CamelCannon,1), new AspectList().add(MYSTERIUM,
		 * 3).add(Aspect.WEAPON, 3).add(Aspect.BEAST, 2));
		 */
		List<Item> bunchaitems = ImmutableList.copyOf(Item.itemRegistry);
		if (!bunchaitems.isEmpty()) {
			Iterator ite = bunchaitems.iterator();
			while (ite.hasNext()) {
				Item suffolk = (Item) ite.next();
				try{
				if (suffolk != null) {
					if (GameRegistry.findUniqueIdentifierFor(suffolk) != null) {
						if (GameRegistry.findUniqueIdentifierFor(suffolk).modId
								.contains("nevermine")) {
							String hampshire = GameRegistry
									.findUniqueIdentifierFor(suffolk).modId;
							if (suffolk instanceof BaseGun)
								ThaumcraftApi.registerObjectTag(new ItemStack(
										suffolk, 1), new AspectList().add(
										Aspect.WEAPON, 3));
							if (suffolk instanceof BaseStaff)
								ThaumcraftApi.registerObjectTag(new ItemStack(
										suffolk, 1),
										new AspectList().add(Aspect.WEAPON, 3)
												.add(Aspect.MAGIC, 2));
							if (suffolk instanceof BaseEnergy)
								ThaumcraftApi.registerObjectTag(new ItemStack(
										suffolk, 1),
										new AspectList().add(Aspect.WEAPON, 3)
												.add(Aspect.SOUL, 3));
							if (hampshire.contains("Food"))
								ThaumcraftApi.registerObjectTag(new ItemStack(
										suffolk, 1),
										new AspectList().add(Aspect.HUNGER, 3)
												.add(Aspect.WATER, 3));
							if (hampshire.contains("Realmstone"))
								ThaumcraftApi.registerObjectTag(new ItemStack(
										suffolk, 1),
										new AspectList().add(Aspect.TRAVEL, 3)
												.add(DIMENSION, 5));
						}
					}
				}
				}catch(NullPointerException e){
					LogManager.getLogger("AoATC").fatal("Unable to initialize aspect for "+suffolk);
					LogManager.getLogger("AoATC").error(e);
				}
			}
		}
		
		LogManager
				.getLogger("AoATC")
				.warn("PLEASE HELP WITH ASPECT INITIALIZATION! PM Jackiecrazy for more details at MCF");
	}

	public static void actuallyaspectizeM() {

	}

	public static void actuallyaspectizeI() {
		ThaumcraftApi.registerObjectTag(
				new ItemStack(Itemizer.AmethystIngot, 1),
				new AspectList().add(Aspect.METAL, 3).add(Aspect.GREED, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(Itemizer.AmphibiyteLung,
				1), new AspectList().add(Aspect.BEAST, 3).add(Aspect.AIR, 1));
		ThaumcraftApi.registerObjectTag(new ItemStack(Itemizer.AncientOrb, 1),
				new AspectList().add(SELYAN, 3).add(Aspect.ENERGY, 2));
		ThaumcraftApi.registerObjectTag(
				new ItemStack(Itemizer.AncientTeleporterBlueprint, 1),
				new AspectList().add(Aspect.METAL, 3).add(Aspect.GREED, 2)
						.add(DIMENSION, 2).add(Aspect.TRAVEL, 2));
		ThaumcraftApi.registerObjectTag(
				new ItemStack(Itemizer.ApocoStone, 1),
				new AspectList().add(Aspect.EARTH, 3).add(Aspect.GREED, 2)
						.add(DIMENSION, 2).add(Aspect.TRAVEL, 2));

	}
}