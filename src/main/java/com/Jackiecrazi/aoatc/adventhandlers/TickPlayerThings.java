package com.Jackiecrazi.aoatc.adventhandlers;

import java.util.Collection;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.nevermine.izer.equipment.Armorizer;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.lib.network.PacketHandler;
import thaumcraft.common.lib.network.playerdata.PacketResearchComplete;

import com.Jackiecrazi.aoatc.NBTThingyMajiggy;
import com.Jackiecrazi.aoatc.items.ModItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class TickPlayerThings {
	private Item boots = null;
	  private Item body = null;
	  private Item legs = null;
	  private Item helmet = null;
	@SubscribeEvent
	public void tickplayer(TickEvent.PlayerTickEvent ev){
		EntityPlayer player=ev.player;
		 ItemStack stackBoots = player.inventory.armorItemInSlot(0);
	      ItemStack stackLegs = player.inventory.armorItemInSlot(1);
	      ItemStack stackBody = player.inventory.armorItemInSlot(2);
	      ItemStack stackHelmet = player.inventory.armorItemInSlot(3);
	      if (stackBoots != null)
	          boots = stackBoots.getItem();
	        else
	          boots = null;
	        if (stackBody != null)
	          body = stackBody.getItem();
	        else
	          body = null;
	        if (stackLegs != null)
	          legs = stackLegs.getItem();
	        else
	          legs = null;
	        if (stackHelmet != null)
	          helmet = stackHelmet.getItem();
	        else
	          helmet = null;
		if(boots==ModItems.EldriplateB&&body == ModItems.EldriplateC&&legs==ModItems.EldriplateL&&helmet==ModItems.EldriplateH){
			EntityPlayer p=ev.player;
			if (p.motionY < 0.0D&&!p.isSneaking()&&!p.isInWater()){
				p.motionY *= 0.800000011920929D;
				p.fallDistance = -0.5F;
			}
		}
		if(boots==Armorizer.VoidBoots&&body==Armorizer.VoidChestplate&&legs==Armorizer.VoidLeggings&&helmet==Armorizer.VoidHelmet&&player.getCurrentEquippedItem()!=null){
			if(player.getCurrentEquippedItem().getItem()==ConfigItems.itemChestVoidRobe&&(!ThaumcraftApiHelper.isResearchComplete(player.getCommandSenderName(), "Eldriplate")) && (!ThaumcraftApiHelper.isResearchComplete(player.getCommandSenderName(), "@Eldriplate"))&&player instanceof EntityPlayerMP&&player.ticksExisted%100==0){
				System.out.println("Unlocking Eldriplate research...");
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("Eldriplate.discovery")));
		          PacketHandler.INSTANCE.sendTo(new PacketResearchComplete("@Eldriplate"), (EntityPlayerMP)player);
		          Thaumcraft.proxy.getResearchManager().completeResearch(player, "@Eldriplate");
			}
		}
		if (boots==Armorizer.LyndamyteBoots&&body==Armorizer.LyndamyteChestplate&&legs==Armorizer.LyndamyteLeggings&&helmet==Armorizer.LyndamyteHelmet&&player instanceof EntityPlayerMP&&player.getCurrentEquippedItem()!=null&&player.getCurrentEquippedItem().getItem()==ConfigItems.itemShard&&(!ThaumcraftApiHelper.isResearchComplete(player.getCommandSenderName(), "Elemental_Lyndamyte")) && (!ThaumcraftApiHelper.isResearchComplete(player.getCommandSenderName(), "@Elemental_Lyndamyte"))&&player.ticksExisted%100==0)
        {
			System.out.println("Unlocking EL research...");
          player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("EL.discovery")));
          PacketHandler.INSTANCE.sendTo(new PacketResearchComplete("@Elemental_Lyndamyte"), (EntityPlayerMP)player);
          Thaumcraft.proxy.getResearchManager().completeResearch(player, "@Elemental_Lyndamyte");
        }
		if(player.getCurrentEquippedItem()!=null){
			ItemStack held=player.getCurrentEquippedItem();
			if(player.getCurrentEquippedItem().getItem()==ModItems.SkellySword||player.getCurrentEquippedItem().getItem()==ModItems.SkellyArchergun){
				if(held.getItemDamage()>0&&player.experience>(held.getItemDamage()*5)&&player.ticksExisted%100==0){
					int repair=held.getItemDamage()*(-1);
					held.damageItem(repair, player);
					player.addExperience(repair*5);
				}
			}
		}
	}
}
