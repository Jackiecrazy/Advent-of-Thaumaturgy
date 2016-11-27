package com.Jackiecrazi.aoatc.items.utility;

import java.text.DecimalFormat;
import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import net.nevermine.izer.Itemizer;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.baubles.ItemAmuletVis;
import thaumcraft.common.lib.research.ResearchManager;
import baubles.api.BaubleType;

import com.Jackiecrazi.aoatc.AoATC;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class InfiniteBulletBag extends ItemAmuletVis {
	DecimalFormat myFormatter = new DecimalFormat("#######.##");
	
	
	public InfiniteBulletBag() {
		this.setMaxStackSize(1);
		this.setCreativeTab(AoATC.tabAT);
		this.setUnlocalizedName("InfBulBag");
		this.setHasSubtypes(false);
	}
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	  {
	    /*if (stack.getItemDamage() == 0) {
	      list.add(EnumChatFormatting.AQUA + StatCollector.translateToLocal("item.ItemAmuletVis.text"));
	    }*/
	    list.add(EnumChatFormatting.GOLD + StatCollector.translateToLocal("suffix.infinitebullets"));
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

	  public int getVis(ItemStack is, Aspect aspect) {
	    int out = 0;
	    if ((is.hasTagCompound()) && (is.stackTagCompound.hasKey(aspect.getTag()))) {
	      out = is.stackTagCompound.getInteger(aspect.getTag());
	    }
	    return out;
	  }

	  public void storeVis(ItemStack is, Aspect aspect, int amount) {
	    is.setTagInfo(aspect.getTag(), new NBTTagInt(amount));
	  }

	  public AspectList getAspectsWithRoom(ItemStack wandstack) {
	    AspectList out = new AspectList();
	    AspectList cur = getAllVis(wandstack);
	    for (Aspect aspect : cur.getAspects()) {
	      if (cur.getAmount(aspect) < getMaxVis(wandstack)) {
	        out.add(aspect, 1);
	      }
	    }
	    return out;
	  }

	  public AspectList getAllVis(ItemStack is) {
	    AspectList out = new AspectList();
	    for (Aspect aspect : Aspect.getPrimalAspects()) {
	      if ((is.hasTagCompound()) && (is.stackTagCompound.hasKey(aspect.getTag())))
	        out.merge(aspect, is.stackTagCompound.getInteger(aspect.getTag()));
	      else {
	        out.merge(aspect, 0);
	      }
	    }
	    return out;
	  }

	  public boolean consumeAllVis(ItemStack is, EntityPlayer player, AspectList aspects, boolean doit, boolean crafting) {
	    if ((aspects == null) || (aspects.size() == 0)) return false;
	    for (Aspect aspect : aspects.getAspects()) {
	      if (getVis(is, aspect) < aspects.getAmount(aspect)) return false;
	    }
	    if (doit) {
	      for (Aspect aspect : aspects.getAspects())
	        storeVis(is, aspect, getVis(is, aspect) - aspects.getAmount(aspect));
	    }
	    return true;
	  }

	  public int addVis(ItemStack is, Aspect aspect, int amount, boolean doit) {
	    if (!aspect.isPrimal()) return 0;
	    int storeAmount = getVis(is, aspect) + amount * 100;
	    int leftover = Math.max(storeAmount - getMaxVis(is), 0);
	    if (doit) storeVis(is, aspect, Math.min(storeAmount, getMaxVis(is)));
	    return leftover / 100;
	  }

	  public int addRealVis(ItemStack is, Aspect aspect, int amount, boolean doit) {
	    if (!aspect.isPrimal()) return 0;
	    int storeAmount = getVis(is, aspect) + amount;
	    int leftover = Math.max(storeAmount - getMaxVis(is), 0);
	    if (doit) storeVis(is, aspect, Math.min(storeAmount, getMaxVis(is)));
	    return leftover;
	  }
	  @SideOnly(Side.CLIENT)
		@Override
		  public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
		  {
		    par3List.add(new ItemStack(par1, 1, 0));
		  }
	  @Override
	  public ItemStack onItemRightClick(ItemStack is, World w, EntityPlayer p){
		  	  
			  w.playSoundAtEntity(p, "random.pop", 0.3F, 1.0F);
			  p.setItemInUse(is, this.getMaxItemUseDuration(is));
		  return is;
		  
	  }
	  @SideOnly(Side.CLIENT)
	  public void registerIcons(IIconRegister ir)
	  {
	    icon[0] = ir.registerIcon("nevermine:gemBag");
	    icon[1] = ir.registerIcon("thaumcraft:vis_amulet");
	  }
	  public BaubleType getBaubleType(ItemStack itemstack)
	  {
	    return BaubleType.AMULET;
	  }
	  public boolean canEquip(ItemStack itemstack, EntityLivingBase player)
	  {
	    return false;
	  }

	  public boolean canUnequip(ItemStack itemstack, EntityLivingBase player)
	  {
	    return true;
	  }
	  
	  public void onPlayerStoppedUsing(ItemStack is, World w, EntityPlayer p, int timeused)
	    {
		  int amountToGive=timeused/4;
		  int costy=timeused*20;
		  
		  InfiniteBulletBag bag=((InfiniteBulletBag)is.getItem());
		  is.setItemDamage(0);
		  AspectList cost=new AspectList().add(Aspect.EARTH, costy).add(Aspect.WATER,costy).add(Aspect.ORDER, costy).add(Aspect.ENTROPY, costy).add(Aspect.FIRE, costy).add(Aspect.AIR, costy);
		  if(bag.consumeAllVis(is, p, cost, true, true)){
				if(p.inventory.addItemStackToInventory(new ItemStack(Itemizer.MetalPellet,amountToGive)));
		  }
		  else if(timeused>0) onPlayerStoppedUsing(is,w,p,timeused-1);
	    }
	  public EnumAction getItemUseAction(ItemStack p_77661_1_)
	    {
	        return EnumAction.eat;
	    }
	  public int getMaxItemUseDuration(ItemStack p_77626_1_)
	    {
	        return 256;
	    }
	  public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_)
	    {
	        return p_77654_1_;
	    }
	  @SideOnly(Side.CLIENT)
	  public IIcon getIconFromDamage(int par1) {
	    return par1 >= icon.length ? icon[0] : icon[par1];
	  }
}
