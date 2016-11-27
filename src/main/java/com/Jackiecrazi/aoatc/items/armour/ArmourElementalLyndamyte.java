package com.Jackiecrazi.aoatc.items.armour;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.nevermine.izer.Itemizer;
import thaumcraft.api.IRepairable;
import thaumcraft.api.IRunicArmor;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.aspects.Aspect;

import com.Jackiecrazi.aoatc.AoATC;
import com.Jackiecrazi.aoatc.items.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmourElementalLyndamyte extends ItemArmor implements IRunicArmor,IVisDiscountGear,IRepairable{
public IIcon iconHelm,iconChest,iconLegs,iconBoots;
	public ArmourElementalLyndamyte(String unlocalizedname,ArmorMaterial material, int renderindex,
			int type) {
		super(material, renderindex, type);
		this.setUnlocalizedName(unlocalizedname);
		setCreativeTab(AoATC.tabAT);
		// TODO Auto-generated constructor stub
	}
	public EnumRarity getRarity(ItemStack itemstack)
	  {
	    return EnumRarity.uncommon;
	  }

	  public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	  {
	    list.add(EnumChatFormatting.DARK_PURPLE + StatCollector.translateToLocal("tc.visdiscount") + ": " + getVisDiscount(stack, player, null) + "%");
	    super.addInformation(stack, player, list, par4);
	  }

	  public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	  {
	    return par2ItemStack.isItemEqual(new ItemStack(Itemizer.IngotRosite)) ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	  }
	@SideOnly(Side.CLIENT)
	  public void registerIcons(IIconRegister ir)
	  {
		iconHelm = ir.registerIcon("aoatc:armor/thaumiumhelm");
	    iconChest = ir.registerIcon("aoatc:armor/thaumiumchest");
	    iconLegs = ir.registerIcon("aoatc:armor/thaumiumlegs");
	    iconBoots = ir.registerIcon("aoatc:armor/thaumiumboots");
	  }
	public int getVisDiscount(ItemStack paramItemStack,
			EntityPlayer paramEntityPlayer, Aspect paramAspect) {
		// TODO Auto-generated method stub
		return 3;
	}

	public int getRunicCharge(ItemStack paramItemStack) {
		// TODO Auto-generated method stub
		return 0;
	}
	@SideOnly(Side.CLIENT)
	  public IIcon getIconFromDamage(int par1) {
	    return armorType == 2 ? iconLegs : armorType == 1 ? iconChest : armorType == 0 ? iconHelm : iconBoots;
	  }

	  public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	  {
	    if ((stack.getItem() == ModItems.ElementalLyndamyteB) || (stack.getItem() == ModItems.ElementalLyndamyteC) || (stack.getItem() == ModItems.ElementalLyndamyteH))
	    {
	      return "aoatc:textures/models/armor/lynd_elem_1.png";
	    }
	    if (stack.getItem() == ModItems.ElementalLyndamyteL) {
	      return "aoatc:textures/models/armor/lynd_elem_2.png";
	    }
	    return "aoatc:textures/models/armor/lynd_elem_1.png";
	  }
}
