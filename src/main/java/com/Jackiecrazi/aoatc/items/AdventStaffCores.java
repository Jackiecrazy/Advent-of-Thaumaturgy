package com.Jackiecrazi.aoatc.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import thaumcraft.api.wands.WandCap;
import thaumcraft.api.wands.WandRod;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.items.wands.ItemWandCasting;

import com.Jackiecrazi.aoatc.AoATC;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AdventStaffCores extends Item{
	public final String[] types = {
            "Dawnwood_staff",//0
			"Fungal_staff",//1
			"Ivory_staff",//2
			"Irowood_staff",//3
			"Bloodwood_staff",//4
			"Haunted_staff"};//5
    public IIcon[] icon;
    public AdventStaffCores(){
    	this.setCreativeTab(AoATC.tabAT);
    	setMaxStackSize(64);
    	this.setHasSubtypes(true);
    	setUnlocalizedName("AdventStaffCore");
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs xCreativeTabs, List list) {
        for(int x = 0; x < types.length; x++){
            list.add(new ItemStack(this, 1, x));
        }
            ItemStack wand = new ItemStack(ConfigItems.itemWandCasting, 1, 72);
            ((ItemWandCasting) wand.getItem()).setCap(wand, (WandCap) WandCap.caps.get("thaumium"));
            ((ItemWandCasting) wand.getItem()).setRod(wand, (WandRod) WandRod.rods.get("Dawnwood_staff"));
            list.add(wand);
            wand = new ItemStack(ConfigItems.itemWandCasting, 1, 72);
            ((ItemWandCasting) wand.getItem()).setCap(wand, (WandCap) WandCap.caps.get("thaumium"));
            ((ItemWandCasting) wand.getItem()).setRod(wand, (WandRod) WandRod.rods.get("Ivory_staff"));
            list.add(wand);
            wand = new ItemStack(ConfigItems.itemWandCasting, 1, 72);
            ((ItemWandCasting) wand.getItem()).setCap(wand, (WandCap) WandCap.caps.get("thaumium"));
            ((ItemWandCasting) wand.getItem()).setRod(wand, (WandRod) WandRod.rods.get("Fungal_staff"));
            list.add(wand);
            wand = new ItemStack(ConfigItems.itemWandCasting, 1, 72);
            ((ItemWandCasting) wand.getItem()).setCap(wand, (WandCap) WandCap.caps.get("Bloodstone"));
            ((ItemWandCasting) wand.getItem()).setRod(wand, (WandRod) WandRod.rods.get("Bloodwood_staff"));
            list.add(wand);
            wand = new ItemStack(ConfigItems.itemWandCasting, 1, 72);
            ((ItemWandCasting) wand.getItem()).setCap(wand, (WandCap) WandCap.caps.get("Bloodstone"));
            ((ItemWandCasting) wand.getItem()).setRod(wand, (WandRod) WandRod.rods.get("Haunted_staff"));
            list.add(wand);
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister ir)
    {
    	icon = new IIcon[types.length];
    	for(int x=0;x< types.length;x++)
    	icon[x]=ir.registerIcon("aoatc:rods/staff_rod_"+types[x].toLowerCase()+"_item");
    	
    }
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "." + types[stack.getItemDamage()];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }
    
    
}
