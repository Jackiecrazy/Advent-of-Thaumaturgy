package com.Jackiecrazi.aoatc.entities;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.nevermine.npc.entity.EntityAssassin;
import cpw.mods.fml.common.registry.EntityRegistry;

import com.Jackiecrazi.aoatc.AoATC;
import com.Jackiecrazi.aoatc.entities.*;
import com.Jackiecrazi.aoatc.entities.minions.EntityFriendlySpiritGuardian;
import com.Jackiecrazi.aoatc.entities.minions.EntityFriendlySpiritProtector;

public class ModEntities {
	public static void init(){
		int mobcount=0;
    EntityRegistry.registerModEntity(AscendingThaumaturge.class, "AscendingThaumaturge", mobcount++, AoATC.inst, 128, 1, true);
    EntityRegistry.registerModEntity(EntityFriendlySpiritGuardian.class, "FriendlySpiritGuardian", mobcount++, AoATC.inst, 32, 1, true);
    EntityRegistry.registerModEntity(EntityFriendlySpiritProtector.class, "FriendlySpirit", mobcount++, AoATC.inst, 32, 1, true);
	}
}
