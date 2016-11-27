package com.Jackiecrazi.aoatc.items.baubles;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import thaumcraft.api.IRunicArmor;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.items.baubles.ItemAmuletVis;
import baubles.api.IBauble;

import com.Jackiecrazi.aoatc.AoATC;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class VisHoldingPendant extends ItemAmuletVis implements IBauble,IRunicArmor{
	public final IIcon[] icons=new IIcon[2];
	DecimalFormat myFormatter = new DecimalFormat("#######.##");
	public VisHoldingPendant(String subtype){
		super();
		this.setMaxDamage(0);
		this.setCreativeTab(AoATC.tabAT);
		this.setHasSubtypes(true);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	  public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	  {
	    par3List.add(new ItemStack(par1, 1, 0));
	  }
	@Override
	@SideOnly(Side.CLIENT)
	  public void registerIcons(IIconRegister ir)
	  {
	    icons[0] = ir.registerIcon("aoatc:mysteriumPendant");
	    icons[1] = ir.registerIcon("aoatc:mysteriumPendant");
	  }
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {
	    return par1 >= icons.length ? icons[0] : icons[par1];
	}
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	  {
	    list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("item.capacity.text") + " " + getMaxVis(stack) / 100);
	    if (stack.hasTagCompound())
	      for (Aspect aspect : Aspect.getPrimalAspects())
	        if (stack.stackTagCompound.hasKey(aspect.getTag())) {
	          String amount = myFormatter.format(stack.stackTagCompound.getInteger(aspect.getTag()) / 100.0F);
	          list.add(" \u00A7" + aspect.getChatcolor() + aspect.getName() + "\u00A7r x " + amount);
	        }
	  }
	public int getMaxVis(ItemStack stack)
	  {
	    return 25000;
	  }
}
