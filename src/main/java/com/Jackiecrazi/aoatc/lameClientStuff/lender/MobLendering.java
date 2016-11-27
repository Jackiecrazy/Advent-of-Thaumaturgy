package com.Jackiecrazi.aoatc.lameClientStuff.lender;

import net.nevermine.mob.model.mysterium.modelSpiritGuardian;
import net.nevermine.mob.model.mysterium.modelSpiritProtector;
import net.nevermine.mob.render.mysterium.RenderSpiritGuardian;
import net.nevermine.mob.render.mysterium.RenderSpiritProtector;

import com.Jackiecrazi.aoatc.entities.minions.EntityFriendlySpiritGuardian;
import com.Jackiecrazi.aoatc.entities.minions.EntityFriendlySpiritProtector;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class MobLendering {
	public static void DrewDrawDrawn(){
		RenderingRegistry.registerEntityRenderingHandler(EntityFriendlySpiritGuardian.class, new RenderSpiritGuardian(new modelSpiritGuardian(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFriendlySpiritProtector.class, new RenderSpiritProtector(new modelSpiritProtector(), 0.5F));
	}
}
