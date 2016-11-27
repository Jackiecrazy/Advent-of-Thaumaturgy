package com.Jackiecrazi.aoatc.entities;

import thaumcraft.common.config.ConfigItems;

import com.Jackiecrazi.aoatc.items.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.nevermine.common.nevermine;
import net.nevermine.izer.Itemizer;
import net.nevermine.izer.equipment.Weaponizer;
import net.nevermine.npc.entity.EntityNevermineVillager;
import net.nevermine.npc.entity.RestockedRecipe;

public class AscendingThaumaturge extends EntityNevermineVillager{

	public AscendingThaumaturge(World var1) {
		super(var1);
		// TODO Tragic
	}
	public static ItemStack as = new ItemStack(ConfigItems.itemShard, 2,0);
	public static ItemStack fs = new ItemStack(ConfigItems.itemShard, 2,1);
	public static ItemStack es = new ItemStack(ConfigItems.itemShard, 2,2);
	public static ItemStack ws = new ItemStack(ConfigItems.itemShard, 2,3);
	public static ItemStack os = new ItemStack(ConfigItems.itemShard, 2,4);
	public static ItemStack ens = new ItemStack(ConfigItems.itemShard, 2,5);
	@Override
	public void interaction(EntityPlayer p) {
		switch (rand.nextInt(4))
	    {
	    case 0:
	      p.addChatMessage(nevermine.addChatMessage("Ascending Thaumaturge: Ascension and Thaumaturgy didn't go together before.", new Object[0]));
	      break;
	    case 1:
	      p.addChatMessage(nevermine.addChatMessage("Ascending Thaumaturge: Fly, you fools!", new Object[0]));
	      break;
	    case 2:
	      p.addChatMessage(nevermine.addChatMessage("Ascending Thaumaturge: I'm surprised nobody goes down this line, adventure and magic.", new Object[0]));
	      break;
	    case 3:
	      p.addChatMessage(nevermine.addChatMessage("Ascending Thaumaturge: O "+p.getDisplayName()+", how much longer do I need to start your name with 'O'?", new Object[0]));
	    }
	}

	@Override
	public int guiID() {
		return 30;
	}

	@Override
	public void addRecipies(MerchantRecipeList var2) {
		var2.add(new RestockedRecipe(new ItemStack(Itemizer.CopperCoin, 32, 1),new ItemStack(Weaponizer.WindStaff), new ItemStack(ModItems.WindFocus)));
		var2.add(new RestockedRecipe(new ItemStack(Itemizer.CopperCoin, 10, 1), as));
		var2.add(new RestockedRecipe(new ItemStack(Itemizer.CopperCoin, 10, 1), fs));
		var2.add(new RestockedRecipe(new ItemStack(Itemizer.CopperCoin, 10, 1), es));
		var2.add(new RestockedRecipe(new ItemStack(Itemizer.CopperCoin, 10, 1), ws));
		var2.add(new RestockedRecipe(new ItemStack(Itemizer.CopperCoin, 10, 1), os));
		var2.add(new RestockedRecipe(new ItemStack(Itemizer.CopperCoin, 10, 1), ens));
	    var2.add(new RestockedRecipe(new ItemStack(Itemizer.CopperCoin, 10, 1), new ItemStack(ConfigItems.itemResource, 3,14)));
	    var2.add(new RestockedRecipe(new ItemStack(Itemizer.CopperCoin, 32, 1), new ItemStack(Items.glowstone_dust, 2)));
	    var2.add(new RestockedRecipe(new ItemStack(Itemizer.CopperCoin, 32, 1), new ItemStack(Items.redstone, 2)));
	}

	@Override
	public String mobName() {
		return "Ascending Thaumaturge";
	}
	
}
