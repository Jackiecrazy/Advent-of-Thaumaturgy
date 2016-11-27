package com.Jackiecrazi.aoatc.researchesnrecipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.nevermine.item.weapon.energy.BaseEnergy;
import net.nevermine.item.weapon.greatblade.BaseGreatblade;
import net.nevermine.item.weapon.gun.BaseGun;
import net.nevermine.item.weapon.scythe.BaseScythe;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.lib.crafting.InfusionRunicAugmentRecipe;
import thaumcraft.common.lib.events.EventHandlerRunic;
import thaumcraft.common.lib.research.ResearchManager;

import com.Jackiecrazi.aoatc.NBTThingyMajiggy;

public class InfusionRecipeRealmstone extends InfusionRunicAugmentRecipe{
	public static final ItemStack[] COMPONENTS = new ItemStack[] {new ItemStack(Items.slime_ball),new ItemStack(Items.ender_pearl),new ItemStack(ConfigItems.itemResource,1,14)};
    public static final AspectList ASPECTS = new AspectList().add(Aspect.ELDRITCH, 16).add(Aspect.WEAPON, 8).add(Aspect.MAGIC, 8);

    private Map<ItemStack, List<ItemStack>> cachedItems = new HashMap<ItemStack, List<ItemStack>>();
	@Override
    public boolean matches(ArrayList<ItemStack> input, ItemStack central, World world, EntityPlayer player) {
        if(input.size() != COMPONENTS.length + 1) {
        	System.out.println("halpmeh");
            return false;
        }
        if(!ResearchManager.isResearchComplete(player.getCommandSenderName(), "RealmstoneAugmentation")){System.out.println("not researched"); return false;}
        Item centre = central.getItem();
        if((!(centre instanceof ItemSword)&&!(centre instanceof BaseScythe)&&!(centre instanceof BaseGreatblade))){System.out.println("not a weapon"); return false;}
        List<ItemStack> copy = (List<ItemStack>) input.clone();
        List<ItemStack> result = new ArrayList<ItemStack>(copy.size());
        for(ItemStack required : COMPONENTS) {
            boolean contains = false;
            for(int i = 0; i < copy.size(); i++) {
                if(areItemStacksEqual(required, copy.get(i), true)) {
                    contains = true;
                    result.add(copy.get(i));
                    copy.remove(i);
                    break;
                }
            }
            if(!contains) {
            	System.out.println("We're missing something");
                return false;
            }
        }

        ItemStack realmstone = copy.get(0);
        if(!realmstone.getItem().getUnlocalizedName().contains("Realmstone")) {
        	System.out.println("not a realmstone");
            return false;
        }

        result.add(0, realmstone);
        cachedItems.put(central, result);
        return true;
    }
	@Override
    public Object getRecipeOutput(ItemStack input) {
        List<ItemStack> components = cachedItems.get(input);
        if(components != null) {
            return Realmstone(input, components.get(0));
        }
        return input;
    }
	public static ItemStack Realmstone(ItemStack stack, ItemStack disguise) {
        ItemStack out = stack.copy();
        NBTTagCompound compound = NBTThingyMajiggy.get(out);
        compound.setString("Realmstone", disguise.getUnlocalizedName());;
        return out;
    }
	public boolean hasRealmstone(ItemStack s){
		return NBTThingyMajiggy.get(s).getString("Realmstone")!=null;
	}
	@Override
	public AspectList getAspects(ItemStack input)
	  {
	    cachedItems.remove(input);
	    return ASPECTS;
	  }
	@Override
	  public int getInstability(ItemStack input)
	{
	    return 5;
	  }
	@Override
	  public ItemStack[] getComponents(ItemStack input) {
	    List<ItemStack> com = cachedItems.get(input);
	    if(com!=null){
	    	return com.toArray(new ItemStack[com.size()]);
	    }
	    return new ItemStack[0];
	  }
}
