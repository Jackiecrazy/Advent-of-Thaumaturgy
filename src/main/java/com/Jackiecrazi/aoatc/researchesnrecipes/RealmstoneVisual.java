package com.Jackiecrazi.aoatc.researchesnrecipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.nevermine.item.weapon.energy.BaseEnergy;
import net.nevermine.item.weapon.greatblade.BaseGreatblade;
import net.nevermine.item.weapon.gun.BaseGun;
import net.nevermine.item.weapon.scythe.BaseScythe;
import net.nevermine.item.weapon.sword.SwordInterface;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.internal.DummyInternalMethodHandler;
import thaumcraft.api.internal.IInternalMethodHandler;
import thaumcraft.common.lib.research.ResearchManager;

import com.Jackiecrazi.aoatc.AoATC;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RealmstoneVisual extends InfusionRecipe {
    private static final IInternalMethodHandler FAKE_HANDLER = new FakeMethodHandler();
    
    private static ItemStack[] armorItems;

    private final ItemStack[] components;
    
    private static ItemStack[] heyo;

    public RealmstoneVisual() {
        super("", new ItemStack(Blocks.cobblestone), 0, InfusionRecipeRealmstone.ASPECTS, new ItemStack(Blocks.dirt), new ItemStack[0]);

        components = new ItemStack[InfusionRecipeRealmstone.COMPONENTS.length + 1];
        System.arraycopy(InfusionRecipeRealmstone.COMPONENTS, 0, components, 1, InfusionRecipeRealmstone.COMPONENTS.length);

        if(armorItems == null && AoATC.proxy.getSide() == Side.CLIENT) {
            findArmorItems();
        }
        if(heyo==null && AoATC.proxy.getSide()==Side.CLIENT){
        	findWeapons();
        }
    }

    private void findArmorItems() {
        List<ItemStack> items = new ArrayList<ItemStack>();
        for (Object o : Item.itemRegistry) {
            if (o instanceof Item && ((Item) o).getCreativeTab() != null) {
                List list = new ArrayList();

                try {
                    ((Item) o).getSubItems((Item) o, ((Item) o).getCreativeTab(), list);
                } catch (Throwable ignored) {
                }

                for (Object o2 : list) {
                    if (o2 != null && o2 instanceof ItemStack 
                           ) {
                    	ItemStack o3=(ItemStack)o2;
                    	if(o3.getUnlocalizedName().contains("Realmstone")&&!o3.getUnlocalizedName().contains("ragment"))
                        items.add((ItemStack) o3);
                    }
                }
            }
        }
        armorItems = items.toArray(new ItemStack[items.size()]);
    }

    private void findWeapons(){
    	List<ItemStack> items = new ArrayList<ItemStack>();
        for (Object o : Item.itemRegistry) {
            if (o instanceof Item && ((Item) o).getCreativeTab() != null) {
                List list = new ArrayList();

                try {
                    ((Item) o).getSubItems((Item) o, ((Item) o).getCreativeTab(), list);
                } catch (Throwable ignored) {
                }

                for (Object o2 : list) {
                    if (o2 != null && o2 instanceof ItemStack 
                           ) {
                    	ItemStack o4=(ItemStack)o2;
                    	Item o3=o4.getItem();
                    	if(((o3 instanceof ItemSword)||(o3 instanceof BaseScythe)||(o3 instanceof BaseGreatblade)))
                        items.add((ItemStack) o2);
                    }
                }
            }
        }
        heyo = items.toArray(new ItemStack[items.size()]);
    }
    
    private boolean canSee(ItemStack stack) {
        String research = getResearchKey(stack);
        return research == null || ResearchManager.isResearchComplete(Minecraft.getMinecraft().thePlayer.getCommandSenderName(), research);
    }

    public ItemStack getCurrentDisguise() {
        Random random = new Random(System.currentTimeMillis() / 1000);
        int next;
        next = random.nextInt(armorItems.length);
        return armorItems[next];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getRecipeInput() {
        if(Minecraft.getMinecraft().thePlayer == null) {
            return new ItemStack(Items.cookie);
        }
        return heyo[getRecipeInput(new Random(System.currentTimeMillis() / 1000))];
    }

    private int getRecipeInput(Random random) {
        int index;
        do {
            index = random.nextInt(armorItems.length);
        } while (!canSee(armorItems[index]));
        return index;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Object getRecipeOutput(ItemStack input) {
        if(Minecraft.getMinecraft().thePlayer == null) {
            return new ItemStack(Items.cookie);
        }
        return InfusionRecipeRealmstone.Realmstone(input, getCurrentDisguise());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack[] getComponents() {
        components[0] = getCurrentDisguise();
        return components;
    }

    @SideOnly(Side.CLIENT)
    private static String getResearchKey(ItemStack stack) {
        IInternalMethodHandler old = ThaumcraftApi.internalMethods;
        ThaumcraftApi.internalMethods = FAKE_HANDLER;
        Object[] result = ThaumcraftApi.getCraftingRecipeKey(Minecraft.getMinecraft().thePlayer, stack);
        ThaumcraftApi.internalMethods = old;
        return result == null ? null : (String)result[0];
    }

    private static class FakeMethodHandler extends DummyInternalMethodHandler {
        @Override
        public boolean isResearchComplete(String username, String researchkey) {
            return true;
        }
    }
    @Override
    public int getInstability(){
    	return 5;
    }
}