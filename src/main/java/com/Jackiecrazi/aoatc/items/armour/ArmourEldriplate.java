package com.Jackiecrazi.aoatc.items.armour;

import com.Jackiecrazi.aoatc.AoATC;
import com.Jackiecrazi.aoatc.items.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import scala.util.Random;
import thaumcraft.api.IGoggles;
import thaumcraft.api.IRepairable;
import thaumcraft.api.IRunicArmor;
import thaumcraft.api.IVisDiscountGear;
import thaumcraft.api.IWarpingGear;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.nodes.IRevealer;
import thaumcraft.common.items.armor.ItemCultistPlateArmor;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.nevermine.resource.energy.energyHelper;
import net.nevermine.resource.soulpower.soulPowerHelper;

public class ArmourEldriplate extends ItemCultistPlateArmor implements IRunicArmor,IVisDiscountGear,IRepairable,IGoggles, IRevealer, IWarpingGear{
	public IIcon iconHelm,iconChest,iconLegs,iconBoots;
	public ArmourEldriplate(String name,ArmorMaterial mat, int render,
			int type) {
		super(mat, render, type);
		this.setUnlocalizedName(name);
		this.setCreativeTab(AoATC.tabAT);
	}

	public int getVisDiscount(ItemStack paramItemStack,
			EntityPlayer paramEntityPlayer, Aspect paramAspect) {
		return paramItemStack == new ItemStack(ModItems.EldriplateB)? 3:5;
	}
	
	  public EnumRarity getRarity(ItemStack itemstack)
	  {
	    return EnumRarity.epic;
	  }
	  
	public int getRunicCharge(ItemStack paramItemStack) {
		return 0;
	}

	public int getWarp(ItemStack paramItemStack, EntityPlayer paramEntityPlayer) {
		return 2;
	}

	public boolean showNodes(ItemStack paramItemStack,
			EntityLivingBase paramEntityLivingBase) {
		int type = ((ItemArmor)paramItemStack.getItem()).armorType;
	    return type == 0;
	}

	public boolean showIngamePopups(ItemStack paramItemStack,
			EntityLivingBase paramEntityLivingBase) {
		int type = ((ItemArmor)paramItemStack.getItem()).armorType;
	    return type == 0;
	}
	
	  public void onUpdate(ItemStack stack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_)
	  {
	    super.onUpdate(stack, world, entity, p_77663_4_, p_77663_5_);

	    if ((!world.isRemote) && (stack.isItemDamaged()) && (entity.ticksExisted % 20 == 0) && ((entity instanceof EntityLivingBase)))
	      stack.damageItem(-1, (EntityLivingBase)entity);
	  }

	  public void onArmorTick(World world, EntityPlayer player, ItemStack armor)
	  {
	    super.onArmorTick(world, player, armor);
	    if ((!world.isRemote) && (armor.getItemDamage() > 0) && (player.ticksExisted % 20 == 0)){
	      armor.damageItem(-5, player);
	    }
	    Random r=new Random();
	    if(energyHelper.getProperties(player).useBar(0.025F)&&soulPowerHelper.getProperties(player).useBar(0.025f)){
	    player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,20,1));
	    player.addPotionEffect(new PotionEffect(Potion.digSpeed.id,20,1));
	    PotionEffect[] effects = (PotionEffect[])player.getActivePotionEffects().toArray(new PotionEffect[]{});
        for(PotionEffect effect : effects){
        	if(effect.getPotionID()==Potion.blindness.id) player.removePotionEffect(Potion.blindness.id);
        	if(effect.getPotionID()==Potion.confusion.id) player.removePotionEffect(Potion.confusion.id);
        }
	    }
	  }
	  public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	  {
	      return stack.getItem()==ModItems.EldriplateB?"aoatc:textures/models/armor/eldriboots.png": "aoatc:textures/models/armor/eldriarmor.png";
	  }
	  
	  @SideOnly(Side.CLIENT)
	  public IIcon getIconFromDamage(int par1) {
	    return armorType == 2 ? iconLegs : armorType == 1 ? iconChest : armorType == 0 ? iconHelm : iconBoots;
	  }
	  
	  @Override
	  @SideOnly(Side.CLIENT)
	  public void registerIcons(IIconRegister ir)
	  {
		iconHelm = ir.registerIcon("aoatc:armor/eldriplatehelm");
	    iconChest = ir.registerIcon("aoatc:armor/eldriplatechest");
	    iconLegs = ir.registerIcon("aoatc:armor/eldriplatelegs");
	    iconBoots = ir.registerIcon("aoatc:armor/eldriplateboots");
	  }
}
