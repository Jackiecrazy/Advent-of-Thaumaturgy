package com.Jackiecrazi.aoatc.items.foci;

import java.util.List;

import com.Jackiecrazi.aoatc.Config;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.nevermine.minion.entity.EntityAlluricorn;
import net.nevermine.minion.entity.EntityBlissard;
import net.nevermine.minion.entity.EntityCompeer;
import net.nevermine.minion.entity.EntityConstructServility;
import net.nevermine.minion.entity.EntityCorby;
import net.nevermine.minion.entity.EntityCraggy;
import net.nevermine.minion.entity.EntityDraggy;
import net.nevermine.minion.entity.EntityEnderCarrier;
import net.nevermine.minion.entity.EntityGnawer;
import net.nevermine.minion.entity.EntityGoofer;
import net.nevermine.minion.entity.EntityHealingGolem;
import net.nevermine.minion.entity.EntityHellquin;
import net.nevermine.minion.entity.EntityHorntail;
import net.nevermine.minion.entity.EntityMechaCyclops;
import net.nevermine.minion.entity.EntityMechaSkellox;
import net.nevermine.minion.entity.EntityPenguin;
import net.nevermine.minion.entity.EntityPlateosaur;
import net.nevermine.minion.entity.EntityRammerhorn;
import net.nevermine.minion.entity.EntityShaddy;
import net.nevermine.minion.entity.EntitySpikeback;
import net.nevermine.minion.entity.EntitySpraggy;
import net.nevermine.minion.entity.EntityWaggy;
import net.nevermine.resource.creation.creationHelper;
import net.nevermine.resource.soulpower.soulPowerHelper;
import net.nevermine.skill.creation.creationSkillHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.FocusUpgradeType;
import thaumcraft.api.wands.ItemFocusBasic;
import thaumcraft.common.items.wands.ItemWandCasting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FocusCreateMithions extends ItemFocusBasic{
	int shabam;
	public static FocusUpgradeType corporeal = new FocusUpgradeType(Config.corporealID, new ResourceLocation("aoatc", "textures/foci/corporeal.png"), "focus.upgrade.corporeal.name", "focus.upgrade.corporeal.text", new AspectList().add(Aspect.SOUL, 1).add(Aspect.MOTION, 1));
	public static FocusUpgradeType imbue = new FocusUpgradeType(Config.imbueID, new ResourceLocation("aoatc", "textures/foci/imbue.png"), "focus.upgrade.imbue.name", "focus.upgrade.imbue.text", new AspectList().add(Aspect.MAGIC, 1).add(Aspect.ENERGY, 1));
	EntityTameable a;
	final float[] q = {
			1800,
			1200,
			1800,
			1800,
			2400,
			3000,
			3000,
			3000,
			3600,
			3600,
			3600,
			3000,
			3600,
			2400,
			4200,
			3600,
			4200,
			3600,
			4200,
			4200,
			4800,
			4800
	};
	final int[] c = {
			1,
			1,
			5,
			15,
			25,
			30,
			35,
			45,
			45,
			54,
			59,
			60,
			63,
			68,
			70,
			70,
			74,
			78,
			81,
			83,
			91,
			92
	};
	AspectList viscost = (new AspectList().add(Aspect.AIR, 1000).add(Aspect.EARTH, 1000).add(Aspect.FIRE, 1000).add(Aspect.WATER, 1000).add(Aspect.ORDER, 1000).add(Aspect.ENTROPY, 1000));
	AspectList lowcost = (new AspectList().add(Aspect.AIR, 2000).add(Aspect.EARTH, 2000).add(Aspect.FIRE, 2000).add(Aspect.WATER, 2000).add(Aspect.ORDER, 2000).add(Aspect.ENTROPY, 2000));
	public FocusCreateMithions(){
		this.setMaxStackSize(1);
		this.setUnlocalizedName("FocusMinion");
	}
	@Override
	public int getFocusColor(ItemStack focusstack){
		return 0xFFFFCC;
	}
	@Override
	public AspectList getVisCost(ItemStack is){
		return lowcost; 
	}
	@Override
	public int getActivationCooldown(ItemStack focusstack)
	  {
	    return 40;
	  }
	
	public EntityTameable getMithion(EntityPlayer player,ItemStack i){
		int s = getShabam(i);
		switch(s){
		case 0: a = new EntityPenguin(player.worldObj, player);
		break;
		case 1: a = new EntityDraggy(player.worldObj, player);
		break;
		case 2: a = new EntityCompeer(player.worldObj, player);
		break;
	    case 3: a = new EntityWaggy(player.worldObj, player);
	    break;
		case 4: a = new EntityPlateosaur(player.worldObj, player);
		break;
		case 5: a = new EntitySpraggy(player.worldObj, player);
		break;
		case 6: a = new EntitySpikeback(player.worldObj, player);
		break;
		case 7: a = new EntityCraggy(player.worldObj, player);
		break;
		case 8: a = new EntityHellquin(player.worldObj, player);
		break;
		case 9: a = new EntityHorntail(player.worldObj, player);
		break;
		case 10: a = new EntityRammerhorn(player.worldObj, player);
		break;
		case 11: a = new EntityShaddy(player.worldObj, player);
		break;
		case 12: a = new EntityCorby(player.worldObj, player);
		break;
		case 13: a = new EntityGnawer(player.worldObj, player);
		break;
		case 14: a = new EntityEnderCarrier(player.worldObj, player);
		break;
		case 15: a = new EntityBlissard(player.worldObj, player);
		break;
		case 16: a = new EntityGoofer(player.worldObj, player);
		break;
		case 17: a = new EntityMechaCyclops(player.worldObj, player);
		break;
		case 18: a = new EntityAlluricorn(player.worldObj, player);
		break;
		case 19: a = new EntityConstructServility(player.worldObj, player);
		break;
		case 20: a = new EntityHealingGolem(player.worldObj, player);
		break;
		case 21: a = new EntityMechaSkellox(player.worldObj, player);
		break;
		}
		return a;
	}
	
	public void storeShabam(ItemStack stack, int tee)
	  {
		if(!stack.hasTagCompound()){
			System.out.println("No tag compound for "+stack.getDisplayName()+", creating ex nihilo...");
			//TODO There is never a tag compound;
	    System.out.println("made one");
	    stack.setTagCompound(new NBTTagCompound());
	    System.out.println("casted it");
		}
	    stack.getTagCompound().setInteger("shabam", tee);
	    System.out.println("Set the integer!");
	  }
	
	public int getShabam(ItemStack i){
		if(i.hasTagCompound()){
			return i.getTagCompound().getInteger("shabam");
		}
		else{
			i.setTagCompound(new NBTTagCompound());
			i.getTagCompound().setInteger("shabam", 0);
			return 0;
		}
	}
	
	public boolean highEnough(EntityPlayer player, ItemStack i){
		int s = getShabam(i);
		if(creationSkillHelper.getProperties(player).getLevel() < c[s]) return false;
		else return true;
	}
	
	@Override
	public ItemStack onFocusRightClick(ItemStack wandstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition)
	  {
		ItemWandCasting w = (ItemWandCasting) wandstack.getItem();
		w.getFocusItem(wandstack).getTagCompound();
		int s = getShabam(w.getFocusItem(wandstack));
		System.out.println("got shabam from "+w.getFocusItem(wandstack).getDisplayName()+" and it's "+s);
		int potency =w.getFocusPotency(wandstack);
		if(!player.isSneaking()){
			if(w.consumeAllVis(wandstack, player, viscost, true, false)){
		if(movingobjectposition != null && movingobjectposition.typeOfHit == MovingObjectType.BLOCK)
		{
			ForgeDirection dir = ForgeDirection.getOrientation(movingobjectposition.sideHit);
			int px = movingobjectposition.blockX;
			int py = movingobjectposition.blockY;
			int pz = movingobjectposition.blockZ;
			Block b = world.getBlock(px+dir.offsetX, py+dir.offsetY, pz+dir.offsetZ);
    	if(b == Blocks.air){
    		a= getMithion(player,w.getFocusItem(wandstack));
    		a.setLocationAndAngles(px+dir.offsetX, py+dir.offsetY, pz+dir.offsetZ, player.rotationYaw, player.rotationPitch);
    		float cost = q[s];
    		float soul = 2000;
    		if(creationSkillHelper.getProperties(player).getLevel() < c[s]&&isUpgradedWith(w.getFocusItem(wandstack), corporeal))cost = 4800;
    		else if(creationSkillHelper.getProperties(player).getLevel() < c[s]) cost = 6000;
    		else if(isUpgradedWith(w.getFocusItem(wandstack), corporeal)){ 
    			cost = q[s]+ 600;
    		}
    		else cost =q[s];
    		if(isUpgradedWith(w.getFocusItem(wandstack), corporeal)) soul =0;
    		if((creationHelper.getProperties(player).useBar(cost)&&soulPowerHelper.getProperties(player).useBar(soul)&&(!world.isRemote)))
    					    {
    					      player.worldObj.spawnEntityInWorld(a);
    					      player.swingItem();
    					      System.out.println("summoned minion at "+px+", "+py+", "+pz);
    					      if(isUpgradedWith(w.getFocusItem(wandstack), imbue)) a.addPotionEffect(new PotionEffect(Potion.resistance.id,1000,1));
    					    }
    		else if(!creationHelper.getProperties(player).useBar(q[s])) System.out.println("too low creation "+cost);
    		else System.out.println("nobody knows why~");
    	}
		
	    return wandstack;
	  }
			}
		
		}
		else if(!world.isRemote){
			if(s+1 == 22) s =-1;
			storeShabam(w.getFocusItem(wandstack),s+1);
			System.out.println("shabam stored...? at "+ (s+1) + " and is it client? "+world.isRemote);
			//TODO s is always 0 even if it displays 1 in the debug
		}
		return wandstack;
	  }
	public String mithionName(ItemStack i,EntityPlayer p){
		String name = "tree";
		int s = getShabam(i);
		switch(s){
		case 0: name = "Penguin";
		break;
		case 1: name = "Draggy";
		break;
		case 2: name = "Compeer";
		break;
	    case 3: name = "Waggy";
	    break;
		case 4: name = "Plateosaur" ;
		break;
		case 5: name = "Spraggy" ;
		break;
		case 6: name = "Spikeback" ;
		break;
		case 7: name = "Craggy" ;
		break;
		case 8: name = "Hellquin" ;
		break;
		case 9: name = "Horntail" ;
		break;
		case 10: name = "Rammerhorn" ;
		break;
		case 11: name = "Shaddy" ;
		break;
		case 12: name = "Corby" ;
		break;
		case 13: name = "Gnawer" ;
		break;
		case 14: name = "Ender Carrier" ;
		break;
		case 15: name = "Blissard" ;
		break;
		case 16: name = "Goofer" ;
		break;
		case 17: name = "Mecha Cyclops" ;
		break;
		case 18: name = "Alluricorn" ;
		break;
		case 19: name = "Construct of Servility" ;
		break;
		case 20: name = "Healing Golem" ;
		break;
		case 21: name = "Mecha Skellox" ;
		break;
		}
		return name;
	}
	@Override
	public void addInformation(ItemStack focusstack, EntityPlayer player, List list, boolean par4) {
		int s = getShabam(focusstack);
		String mithion =mithionName(focusstack,player);
		float cost;
		ItemFocusBasic focus = (ItemFocusBasic) focusstack.getItem();
		if(highEnough(player, focusstack)&&focus.isUpgradedWith(focusstack, corporeal)) cost=q[s]+600; else if(focus.isUpgradedWith(focusstack, corporeal))cost=4800;else if(highEnough(player,focusstack)) cost=q[s]; else cost=6000;
	    super.addInformation(focusstack, player, list, par4);
	    list.add(mithion);
	    list.add("Recommended Level: "+c[s]);
	    list.add("Required Creation: "+(cost/600));
	}
	
	@Override
	public FocusUpgradeType[] getPossibleUpgradesByRank(ItemStack focusstack, int rank)
	  {
		switch (rank) { case 1:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal };
		    case 2:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency };
		    case 3:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency, corporeal };
		    case 4:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal };
		    case 5:
		      return new FocusUpgradeType[] { FocusUpgradeType.frugal, FocusUpgradeType.potency, imbue };
		    }
		    return null;
	  }
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_)
    {
        this.itemIcon = p_94581_1_.registerIcon(this.getIconString());
        this.icon = this.itemIcon;
    }
}
