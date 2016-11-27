package com.Jackiecrazi.aoatc.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import thaumcraft.api.wands.*;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.items.wands.ItemWandCasting;

import com.Jackiecrazi.aoatc.*;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AdventWandCores extends Item{
	public final String[] types = {
            "Dawnwood",//0
			"Fungal",//1
			"Embers",//2
			"Limonite",//3
			"Lunosso",//4
			"Ivory",//5
			"Irowood",//6
			"Bloodwood",//7
			"Haunted"//8
			};
    public IIcon[] icon;
    public AdventWandCores(){
    	this.setCreativeTab(AoATC.tabAT);
    	setMaxStackSize(64);
    	this.setHasSubtypes(true);
    	setUnlocalizedName("AdventWandCore");
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs xCreativeTabs, List list) {
        for(int x = 0; x < types.length; x++){
            list.add(new ItemStack(this, 1, x));
        }
            ItemStack wand = new ItemStack(ConfigItems.itemWandCasting, 1, 72);
            ((ItemWandCasting) wand.getItem()).setCap(wand, (WandCap) WandCap.caps.get("thaumium"));
            ((ItemWandCasting) wand.getItem()).setRod(wand, (WandRod) WandRod.rods.get("Dawnwood"));
            list.add(wand);
            wand = new ItemStack(ConfigItems.itemWandCasting, 1, 72);
            ((ItemWandCasting) wand.getItem()).setCap(wand, (WandCap) WandCap.caps.get("thaumium"));
            ((ItemWandCasting) wand.getItem()).setRod(wand, (WandRod) WandRod.rods.get("Fungal"));
            list.add(wand);
            wand = new ItemStack(ConfigItems.itemWandCasting, 1, 72);
            ((ItemWandCasting) wand.getItem()).setCap(wand, (WandCap) WandCap.caps.get("Runium"));
            ((ItemWandCasting) wand.getItem()).setRod(wand, (WandRod) WandRod.rods.get("Limonite"));
            list.add(wand);
            wand = new ItemStack(ConfigItems.itemWandCasting, 1, 72);
            ((ItemWandCasting) wand.getItem()).setCap(wand, (WandCap) WandCap.caps.get("thaumium"));
            ((ItemWandCasting) wand.getItem()).setRod(wand, (WandRod) WandRod.rods.get("Lunosso"));
            list.add(wand);
            wand = new ItemStack(ConfigItems.itemWandCasting, 1, 72);
            ((ItemWandCasting) wand.getItem()).setCap(wand, (WandCap) WandCap.caps.get("thaumium"));
            ((ItemWandCasting) wand.getItem()).setRod(wand, (WandRod) WandRod.rods.get("Ivory"));
            list.add(wand);
            wand = new ItemStack(ConfigItems.itemWandCasting, 1, 72);
            ((ItemWandCasting) wand.getItem()).setCap(wand, (WandCap) WandCap.caps.get("Lyon"));
            ((ItemWandCasting) wand.getItem()).setRod(wand, (WandRod) WandRod.rods.get("Irowood"));
            list.add(wand);
            wand = new ItemStack(ConfigItems.itemWandCasting, 1, 72);
            ((ItemWandCasting) wand.getItem()).setCap(wand, (WandCap) WandCap.caps.get("Bloodstone"));
            ((ItemWandCasting) wand.getItem()).setRod(wand, (WandRod) WandRod.rods.get("Bloodwood"));
            list.add(wand);
            wand = new ItemStack(ConfigItems.itemWandCasting, 1, 72);
            ((ItemWandCasting) wand.getItem()).setCap(wand, (WandCap) WandCap.caps.get("thaumium"));
            ((ItemWandCasting) wand.getItem()).setRod(wand, (WandRod) WandRod.rods.get("Haunted"));
            list.add(wand);
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister ir)
    {
    	icon = new IIcon[types.length];
    	for(int x=0;x< types.length;x++)
    	icon[x]=ir.registerIcon("aoatc:rods/wand_rod_"+types[x].toLowerCase()+"_item");
    	
    }
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + types[stack.getItemDamage()];
    }
}
