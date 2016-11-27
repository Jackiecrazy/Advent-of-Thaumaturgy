package com.Jackiecrazi.aoatc.items;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.wands.IWandRodOnUpdate;
import thaumcraft.common.items.wands.ItemWandCasting;

public class GenericRodUpdate implements IWandRodOnUpdate{
Aspect[] vis = {Aspect.AIR,Aspect.EARTH,Aspect.ENTROPY,Aspect.ORDER,Aspect.WATER,Aspect.FIRE};
int x;
int spd;
Aspect aspect;
ArrayList<Aspect> primals;
public GenericRodUpdate(Aspect aspect,int spe)
{
  this.aspect = aspect;
  this.spd=spe;
}

public GenericRodUpdate(int spe) {
    aspect = null;
    primals = Aspect.getPrimalAspects();
    this.spd=spe;
  }

public void onUpdate(ItemStack itemstack, EntityPlayer player)
{
  if (aspect != null) {
    if ((player.ticksExisted % spd == 0) && 
      (((ItemWandCasting)itemstack.getItem()).getVis(itemstack, aspect) < ((ItemWandCasting)itemstack.getItem()).getMaxVis(itemstack) / 10)) {
      ((ItemWandCasting)itemstack.getItem()).addVis(itemstack, aspect, 1, true);
    }

  }
  else if (player.ticksExisted % spd == 0) {
    ArrayList q = new ArrayList();
    for (Aspect as : primals) {
      if (((ItemWandCasting)itemstack.getItem()).getVis(itemstack, as) < ((ItemWandCasting)itemstack.getItem()).getMaxVis(itemstack) / 10) {
        q.add(as);
      }
    }
    if (q.size() > 0)
      ((ItemWandCasting)itemstack.getItem()).addVis(itemstack, (Aspect)q.get(player.worldObj.rand.nextInt(q.size())), 1, true);
  }
}
}