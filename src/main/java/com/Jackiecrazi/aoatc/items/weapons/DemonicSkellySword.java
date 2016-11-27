package com.Jackiecrazi.aoatc.items.weapons;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.nevermine.projectiles.cannon.EntityRPGShot;

public class DemonicSkellySword extends ItemSword{

	public DemonicSkellySword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		this.setMaxStackSize(1);
		this.setUnlocalizedName("DemonSkeleSword");
	}
	public boolean hitEntity(ItemStack is, EntityLivingBase target, EntityLivingBase hitter)
	  {
		return super.hitEntity(is, target, hitter);
	  }
}
