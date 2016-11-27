package com.Jackiecrazi.aoatc.items.weapons;

import java.util.List;
import java.util.Random;

import com.Jackiecrazi.aoatc.AoATC;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.nevermine.item.weapon.archergun.SkeletalArchergun;
import net.nevermine.item.weapon.gun.BaseGun;
import net.nevermine.izer.equipment.Weaponizer;
import net.nevermine.projectiles.auxillary.EntityElementalArrow;

public class DemonicSkellyArchergun extends BaseGun{

	private Random rand = new Random();
	  private int canShootTick = 0;

	  public DemonicSkellyArchergun(int consumeChance, String effect, int uses, int fireRate, Item item) {
	    super(consumeChance, effect, uses, fireRate, item); setCreativeTab(AoATC.tabAT);
	  }

	  public void fireGun(World world, ItemStack stack, EntityPlayer player, float multi)
	  {
	    EntityElementalArrow var5 = new EntityElementalArrow(world, player, 3.3F * multi, 0, true);
	    var5.setDamage(4.5F * multi);
	    world.spawnEntityInWorld(var5);
	  }

	  @SideOnly(Side.CLIENT)
	  public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	  {
	    par3List.add("22 Base Ranged Damage");
	    par3List.add("Insanely Fast Speed");
	    par3List.add(par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() + " Uses Remaining");
	  }
}
