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

public class AdventOldCaps extends Item{
	public final String[] types = {
            "lyon_inactive",//0
            "lyon",//1
            "mercurial_inactive",//2
            "mercurial",//3
            "omni_inactive",//4
            "omni",//5
            "runium_inactive",//6
            "runium",//7
            "bloodstone_inactive",//8
            "bloodstone"};//9
    public IIcon[] icon;
    public AdventOldCaps(){
    	this.setCreativeTab(AoATC.tabAT);
    	setMaxStackSize(64);
    	this.setHasSubtypes(true);
    	setUnlocalizedName("AdventWandCaps");
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister ir)
    {
    	icon = new IIcon[types.length];
    	for(int x=0;x< types.length;x++)
    	icon[x]=ir.registerIcon("aoatc:caps/wand_cap_"+types[x]);
    	
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs xCreativeTabs, List list) {
        for(int x = 0; x < types.length; x++){
            list.add(new ItemStack(this, 1, x));
        }
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
