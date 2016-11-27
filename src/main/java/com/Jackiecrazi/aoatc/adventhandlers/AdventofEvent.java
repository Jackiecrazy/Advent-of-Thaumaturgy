package com.Jackiecrazi.aoatc.adventhandlers;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.nevermine.assist.ConfigurationHelper;
import net.nevermine.common.nevermine;
import net.nevermine.izer.Itemizer;
import net.nevermine.minion.entity.EntityRosid;
import net.nevermine.mob.entity.creeponia.EntityCreepCow;
import net.nevermine.mob.placement.EntityHunter;
import net.nevermine.npc.entity.EntityProfessor;
import net.nevermine.resource.soulpower.soulPowerHelper;
import net.nevermine.skill.foraging.foragingHelper;
import net.nevermine.skill.hunter.hunterHelper;
import net.nevermine.skill.infusion.infusionHelper;
import net.nevermine.skill.runation.runationHelper;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.wands.WandCap;
import thaumcraft.api.wands.WandRod;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.items.wands.ItemWandCasting;
import thaumcraft.common.lib.network.PacketHandler;
import thaumcraft.common.lib.network.playerdata.PacketResearchComplete;
import baubles.common.lib.PlayerHandler;

import com.Jackiecrazi.aoatc.AscendingPotions;
import com.Jackiecrazi.aoatc.NBTThingyMajiggy;
import com.Jackiecrazi.aoatc.blocks.ModBlocks;
import com.Jackiecrazi.aoatc.entities.minions.EntityFriendlySpiritGuardian;
import com.Jackiecrazi.aoatc.entities.minions.EntityFriendlySpiritProtector;
import com.Jackiecrazi.aoatc.items.AugiteDeleter;
import com.Jackiecrazi.aoatc.items.ModItems;
import com.Jackiecrazi.aoatc.items.baubles.VisHoldingPendant;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent;

public class AdventofEvent {
	Aspect[] vis = { Aspect.AIR, Aspect.EARTH, Aspect.ENTROPY, Aspect.ORDER,
			Aspect.WATER, Aspect.FIRE };
	int x;

	@SubscribeEvent
	public void sadism(AttackEntityEvent event) {
		EntityPlayer attacker = event.entityPlayer;
		Random r=new Random();
		if (event.target instanceof EntityLivingBase) {
			
			EntityLivingBase defender = (EntityLivingBase) event.target;
			ItemStack heldItem = attacker.getHeldItem();
			if (heldItem == null)
				return;
			if (heldItem.getItem() instanceof ItemWandCasting) {
				ItemWandCasting wand = (ItemWandCasting) heldItem.getItem();
				WandRod test = wand.getRod(heldItem);
				WandCap exam = wand.getCap(heldItem);
				Random rand = new Random();
				if (test == ModItems.rod_fungal
						|| test == ModItems.staff_fungal) {
					defender.addPotionEffect(new PotionEffect(Potion.poison.id,
							100, 2));
				}
				else if((test==ModItems.rod_bloodwood||test==ModItems.staff_bloodwood)&&r.nextInt(29)==1){
					attacker.heal(test==ModItems.staff_bloodwood?exam==ModItems.cap_bloodstone?4:3:exam==ModItems.cap_bloodstone?3:2);
				}
				else if((test==ModItems.staff_haunted||test==ModItems.rod_haunted)){
					
					if(r.nextInt(29)==0){
					defender.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id,test==ModItems.staff_haunted?40:20,20));
					if(test==ModItems.staff_haunted)defender.addPotionEffect(new PotionEffect(AscendingPotions.Fear.id,40,1));
					}
				}
				if (exam == ModItems.cap_omni) {
					attacker.worldObj.createExplosion(attacker, defender.posX,
							defender.posY + 1, defender.posZ, 1.0F, false);
				}
				if (exam == ModItems.cap_mercurial && rand.nextInt(20) == 0) {
					attacker.worldObj.createExplosion(attacker, defender.posX,
							defender.posY + 1, defender.posZ, 4.0F, false);
				}
			}
			if (NBTThingyMajiggy.get(heldItem).getString("Realmstone") != null) {
				String rs = NBTThingyMajiggy.get(heldItem).getString(
						"Realmstone");
				if (rs.contains("Creeponia"))
					attacker.worldObj.createExplosion(attacker, defender.posX,
							defender.posY, defender.posZ, 3.0F, false);
			}
		}
	}

	private Item boots = null;
	private Item body = null;
	private Item legs = null;
	private Item helmet = null;
	private Item amulet = null;
	private Item ring1 = null;
	private Item ring2 = null;
	private Item belt = null;

	@SubscribeEvent
	public void masochism(LivingHurtEvent e) {
		EntityLivingBase masochist = (EntityLivingBase) e.entityLiving;
		float dmg = e.ammount;
		Random r = new Random();
		double MPosX = masochist.posX;
		double MPosY = masochist.posY;
		double MPosZ = masochist.posZ;
		if (e.source.getEntity() instanceof EntityPlayer) {
			// TODO check for focus on wand and increase damage accordingly.
			// Long and convoluted, but cool
			EntityPlayer pl = (EntityPlayer) e.source.getEntity();
			if (pl.getHeldItem() != null) {
				ItemStack is = pl.getHeldItem();
				if (is.getItem() instanceof ItemWandCasting) {
					ItemWandCasting w = (ItemWandCasting) is.getItem();
					if (w.getRod(is) == ModItems.rod_limonite) {
						e.ammount += (float) 3;
					}
				}
				if (NBTThingyMajiggy.get(is).getString("Realmstone") != null) {
					String rs = NBTThingyMajiggy.get(is)
							.getString("Realmstone");
					if (rs.contains("Abyss") && r.nextInt(3) == 0) {
						pl.setHealth(pl.getHealth() - 1);
						float hi = e.ammount * 2;
						e.ammount = hi;
					} else if (rs.contains("AncientCavern")) {
						if (foragingHelper.getProperties(pl).getLevel() >= 60)
							;
						// TODO increase drops
						if (infusionHelper.getProperties(pl).getLevel() >= 60)
							pl.heal(2);
						;
						if (hunterHelper.getProperties(pl).getLevel() >= 60) {
							if (masochist instanceof EntityHunter)
								e.ammount = dmg * 3;
							else
								e.ammount = dmg * 2;
						}
						if (runationHelper.getProperties(pl).getLevel() >= 60)
							soulPowerHelper.getProperties(pl).regen(2000);
						;
					} else if (rs.contains("Barathos"))
						e.ammount *= 1.25;
					else if (rs.contains("Borean")) {
						masochist.addPotionEffect(new PotionEffect(
								Potion.moveSlowdown.id, 40, 1));
						pl.heal(1.0F);
						;
					} else if (rs.contains("Candyland")) {
						List mobs = pl.worldObj.getEntitiesWithinAABB(
								EntityLiving.class,
								pl.boundingBox.expand(5.0D, 5.0D, 5.0D));
						int size = mobs.size();
						pl.heal(0.5F * size);
						if (r.nextInt(3) == 0) {
							if (!mobs.isEmpty()) {
								Iterator iterator = mobs.iterator();

								while (iterator.hasNext()) {
									EntityLivingBase entitylivingbase = (EntityLivingBase) iterator
											.next();
									double d0 = pl
											.getDistanceSqToEntity(entitylivingbase);

									if (d0 < 25.0D
											&& !(entitylivingbase instanceof EntityPlayer)) {
										entitylivingbase.attackEntityFrom(
												DamageSource.generic, 3);
									}
								}
							}
						}
					} else if (rs.contains("Celeve")) {
						int gamble = r.nextInt(3);
						if (gamble == 0)
							e.ammount = dmg * 3;
						else if (gamble == 3)
							e.setCanceled(true);
					} else if (rs.contains("Crystevia") && r.nextInt(19) == 0)
						pl.setHealth(pl.getMaxHealth());
					else if (rs.contains("Deeplands")) {
						e.ammount = (float) (dmg * 1.3);
						if (r.nextInt(2) == 0) {
							masochist.addPotionEffect(new PotionEffect(
									Potion.moveSlowdown.id, 100, 1));
							masochist.addPotionEffect(new PotionEffect(
									Potion.weakness.id, 100, 1));
						}
					} else if (rs.contains("Dustopia"))
						masochist.addPotionEffect(new PotionEffect(
								Potion.wither.id, 100, 1));
					else if (rs.contains("Gardencia") && r.nextInt(3) == 0) {
						EntityRosid var5 = new EntityRosid(pl.worldObj);
						var5.setPosition(pl.posX, pl.posY + 1.0D, pl.posZ);
						pl.worldObj.spawnEntityInWorld(var5);
					} else if (rs.contains("Haven")) {
						int poteffect = 0;
						int shawarma = r.nextInt(4);
						switch (shawarma) {
						case 0:
							poteffect = Potion.moveSlowdown.id;
							break;
						case 1:
							poteffect = Potion.poison.id;
							break;
						case 2:
							poteffect = Potion.weakness.id;
						case 3:
							e.ammount = dmg * 2;
							break;
						}
						masochist.addPotionEffect(new PotionEffect(shawarma,
								200, 1));
						if (shawarma == 4)
							masochist.setFire(2000);
					} else if (rs.contains("Immortallis"))
						;
					else if (rs.contains("Iromine")) {
						int gamb = r.nextInt(19);
						if (gamb <= 1)
							e.ammount = dmg * 3;
						else if (gamb >= 14)
							e.ammount = dmg * 2;
					} else if (rs.contains("Labricon"))
						// TODO what to do?
						;
					else if (rs.contains("Lelyetia"))
						// TODO random effects
						;
					else if (rs.contains("Mysterium"))
						// TODO what to do?
						;
					else if (rs.contains("Precasia") && r.nextInt(19) == 0) {
						pl.addPotionEffect(new PotionEffect(
								Potion.moveSpeed.id, 100, 3));
						pl.addPotionEffect(new PotionEffect(
								Potion.damageBoost.id, 100, 1));
					} else if (rs.contains("VoxPonds")) {
						masochist.addPotionEffect(new PotionEffect(
								Potion.wither.id, 40, 1));
						List mobs = pl.worldObj.getEntitiesWithinAABB(
								EntityLiving.class,
								pl.boundingBox.expand(5.0D, 5.0D, 5.0D));
						if (!mobs.isEmpty()) {
							Iterator iterator = mobs.iterator();

							while (iterator.hasNext()) {
								EntityLivingBase entitylivingbase = (EntityLivingBase) iterator
										.next();
								double d0 = pl
										.getDistanceSqToEntity(entitylivingbase);

								if (d0 < 25.0D
										&& !(entitylivingbase instanceof EntityPlayer)
										&& !(entitylivingbase == masochist)) {
									entitylivingbase
											.addPotionEffect(new PotionEffect(
													Potion.poison.id, 40, 1));
									entitylivingbase
											.addPotionEffect(new PotionEffect(
													Potion.moveSlowdown.id, 40,
													1));
								}
							}
						}
					}
				}
			}
		}
		if ((e.entity instanceof EntityPlayer)) {
			EntityPlayer player = (EntityPlayer) e.entity;
			ItemStack stackBoots = player.inventory.armorItemInSlot(0);
			ItemStack stackLegs = player.inventory.armorItemInSlot(1);
			ItemStack stackBody = player.inventory.armorItemInSlot(2);
			ItemStack stackHelmet = player.inventory.armorItemInSlot(3);
			ItemStack[] baubleInv = PlayerHandler.getPlayerBaubles(player).stackList;
			ItemStack stackAmulet = baubleInv[0];
			ItemStack stackRing1 = baubleInv[1];
			ItemStack stackRing2 = baubleInv[2];
			ItemStack stackBelt = baubleInv[3];
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
			if (stackAmulet != null)
				amulet = stackAmulet.getItem();
			else
				amulet = null;
			if (stackRing1 != null)
				ring1 = stackHelmet.getItem();
			else
				ring1 = null;
			if (stackRing2 != null)
				ring2 = stackHelmet.getItem();
			else
				ring2 = null;
			if (stackBelt != null)
				belt = stackHelmet.getItem();
			else
				belt = null;

			DamageSource s = e.source;
			if (masochist.getHeldItem() != null) {
				ItemStack receive = masochist.getHeldItem();
				if (NBTThingyMajiggy.get(receive).getString("Realmstone") != null) {
					String rs = NBTThingyMajiggy.get(receive).getString(
							"Realmstone");
					if (rs.contains("Barathos"))
						e.ammount *= 0.75;
				}
				if (receive.getItem() instanceof ItemWandCasting) {
					ItemWandCasting wand = (ItemWandCasting) receive
							.getItem();
					WandCap test = wand.getCap(receive);
					WandRod exam=wand.getRod(receive);
					if (e.source.isExplosion()) {
						if (test == ModItems.cap_mercurial
								|| test == ModItems.cap_omni) {
							for (x = 0; x < vis.length; x++) {
								if (((ItemWandCasting) receive.getItem())
										.getVis(receive, vis[x]) < ((ItemWandCasting) receive
										.getItem()).getMaxVis(receive)) {
									((ItemWandCasting) receive.getItem())
											.addVis(receive, vis[x], 1, true);
								}
							}
						}
					}
					//physical attacks
					if(!e.source.isExplosion()&&e.source.isFireDamage()&&e.source.isMagicDamage()){
						int chanceToBlock=0;
						if(exam==ModItems.rod_irowood)chanceToBlock=3;
						if(exam==ModItems.staff_irowood)chanceToBlock=6;
						if(r.nextInt(10)<chanceToBlock)e.setCanceled(true);
					}
				}
				
			}
			if (e.source == DamageSource.fall) {
				if (boots == ModItems.EldriplateB
						&& body == ModItems.EldriplateC
						&& legs == ModItems.EldriplateL
						&& helmet == ModItems.EldriplateH) {
					e.setCanceled(true);
				}
			}
			if (e.source.getEntity() != null) {
				Entity revenge = e.source.getEntity();
				if (revenge instanceof EntityLivingBase) {
					EntityLivingBase revengeTarget = (EntityLivingBase) revenge;
					if (amulet == ModItems.MysteriumPendant) {
						VisHoldingPendant summonpendant = (VisHoldingPendant) amulet;
						AspectList viscost = (new AspectList())
								.add(Aspect.WATER, 1500)
								.add(Aspect.ORDER, 1500)
								.add(Aspect.ENTROPY, 1500);
						if (summonpendant.consumeAllVis(stackAmulet, player,
								viscost, true, true)) {
							EntityFriendlySpiritGuardian summon1 = new EntityFriendlySpiritGuardian(
									player.worldObj, player);
							summon1.setPosition(MPosX, MPosY, MPosZ);
							EntityFriendlySpiritProtector summon2 = new EntityFriendlySpiritProtector(
									player.worldObj, player);
							summon2.setPosition(MPosX, MPosY, MPosZ);
							if (!player.worldObj.isRemote) {
								player.worldObj.spawnEntityInWorld(summon1);
								player.worldObj.spawnEntityInWorld(summon2);
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void tooltips(ItemTooltipEvent e) {
		if (e.itemStack != null) {
			if (e.itemStack.hasTagCompound()) {
				if (NBTThingyMajiggy.get(e.itemStack).getString("Realmstone") != null) {
					String rs = NBTThingyMajiggy.get(e.itemStack).getString(
							"Realmstone");
					if (rs.contains("Abyss"))
						e.toolTip
								.add(nevermine.RED
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentabyss"));
					else if (rs.contains("AncientCavern"))
						e.toolTip
								.add(nevermine.GRAY
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentancientcavern"));
					else if (rs.contains("Barathos"))
						e.toolTip
								.add(nevermine.DARK_RED
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentbarathos"));
					else if (rs.contains("Borean"))
						e.toolTip
								.add(nevermine.AQUA
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentlborean"));
					else if (rs.contains("Candyland"))
						e.toolTip
								.add(nevermine.YELLOW
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentcandyland"));
					else if (rs.contains("Celeve"))
						e.toolTip
								.add(nevermine.RED
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentceleve"));
					else if (rs.contains("Creeponia"))
						e.toolTip
								.add(nevermine.YELLOW
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentcreeponia"));
					else if (rs.contains("Crystevia"))
						e.toolTip
								.add(nevermine.DARK_AQUA
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentcrystevia"));
					else if (rs.contains("Deeplands"))
						e.toolTip
								.add(nevermine.GRAY
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentdeeplands"));
					else if (rs.contains("Dustopia"))
						e.toolTip
								.add(nevermine.RED
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentdustopia"));
					else if (rs.contains("Gardencia"))
						e.toolTip
								.add(nevermine.GREEN
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentgardencia"));
					else if (rs.contains("Haven"))
						e.toolTip
								.add(nevermine.LIGHT_PURPLE
										+ StatCollector
												.translateToLocal("aoatc.rsaugmenthaven"));
					else if (rs.contains("Immortallis"))
						e.toolTip
								.add(nevermine.GOLD
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentimmortalis"));
					else if (rs.contains("Iromine"))
						e.toolTip
								.add(nevermine.GOLD
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentiromine"));
					else if (rs.contains("Labricon"))
						e.toolTip
								.add(nevermine.RED
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentlabricon"));
					else if (rs.contains("Lelyetia"))
						e.toolTip
								.add(nevermine.DARK_RED
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentlelyetia"));
					else if (rs.contains("Mysterium"))
						e.toolTip
								.add(nevermine.DARK_PURPLE
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentmysterium"));
					else if (rs.contains("Precasia"))
						e.toolTip
								.add(nevermine.DARK_GREEN
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentprecasia"));
					else if (rs.contains("VoxPonds"))
						e.toolTip
								.add(nevermine.DARK_GREEN
										+ StatCollector
												.translateToLocal("aoatc.rsaugmentvoxponds"));
				}
			}
			if (e.itemStack.getItem() instanceof ItemWandCasting) {
				ItemStack wand = e.itemStack;
				if ((((ItemWandCasting) wand.getItem()).getRod(wand) == ModItems.staff_dawnwood)
						&& (((ItemWandCasting) wand.getItem()).getCap(wand) == ModItems.cap_lyon)) {
					e.toolTip.add(" ");
					e.toolTip.add(StatCollector.translateToLocal(
							"aoatc.ref.Zany").trim());
				}
				if ((((ItemWandCasting) wand.getItem()).getRod(wand) == ModItems.rod_limonite)
						&& (((ItemWandCasting) wand.getItem()).getCap(wand) == ModItems.cap_lyon)) {
					e.toolTip.add(" ");
					e.toolTip.add(StatCollector.translateToLocal(
							"aoatc.ref.Crazi").trim());
				}
			}
			if (e.itemStack.getItem() instanceof AugiteDeleter) {
				e.toolTip.add(StatCollector.translateToLocal(
						"aoatc.ref.Augite.1").trim());
				e.toolTip.add(StatCollector.translateToLocal(
						"aoatc.ref.Augite.2").trim());
				e.toolTip.add(StatCollector.translateToLocal(
						"aoatc.ref.Augite.3").trim());
			}

		}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void unlockResearchandDeletStuff(EntityInteractEvent e) {
		Entity fetus = e.target;
		EntityPlayer player = e.entityPlayer;

		// Unlock research
		if (fetus instanceof EntityProfessor
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "InfBulBag"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@InfBulBag"))) {
			PacketHandler.INSTANCE.sendTo(new PacketResearchComplete(
					"@InfBulBag"), (EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"@InfBulBag");
		}

		if (e.entityPlayer.getCurrentEquippedItem() != null) {
			if (e.entityPlayer.getCurrentEquippedItem().getItem() == ModItems.AugiteDeleter)
				fetus.setDead();
			if (e.entityPlayer.getCurrentEquippedItem().getItem() == Items.glass_bottle
					&& fetus instanceof EntityCreepCow) {
				Item is = e.entityPlayer.getCurrentEquippedItem().getItem();
				ItemStack res = new ItemStack(Itemizer.DischargeCapsule);
				e.entityPlayer.inventory.consumeInventoryItem(is);
				if (!e.entityPlayer.worldObj.isRemote
						&& e.entityPlayer.inventory.consumeInventoryItem(is)) {
					if (!e.entityPlayer.inventory.addItemStackToInventory(res))
						e.entityPlayer.dropItem(Itemizer.DischargeCapsule, 1);
					e.entityPlayer.swingItem();
				}
			}

		}
	}

	@SubscribeEvent
	public void spawnsomething(EntityJoinWorldEvent e) {
		if (e.entity instanceof EntityThrowable) {
			EntityThrowable p = (EntityThrowable) e.entity;
			if (p.getThrower() instanceof EntityPlayer) {
				EntityPlayer pl = (EntityPlayer) p.getThrower();
				if (pl.getHeldItem().getItem() == ConfigItems.itemWandCasting) {
					ItemStack s = pl.getHeldItem();
					ItemWandCasting wand = (ItemWandCasting) s.getItem();
					if (wand.getCap(s) == ModItems.cap_lyon) {
						double health = pl.getMaxHealth();
						double ch = pl.getHealth();
						double loss = (double) health / ch;
						p.addVelocity(p.motionX * loss, p.motionY / loss,
								p.motionZ * loss);
					}
				}
			}
		}
		if (e.entity instanceof EntityMob) {
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 4; y++) {
					for (int z = 0; z < 4; z++) {
						if (e.entity.worldObj.getBlock(x, y, z) == ModBlocks.Quarantino) {
							e.setCanceled(true);
							return;
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void tickdaeverything(LivingUpdateEvent e) {
		EntityLivingBase l = e.entityLiving;
		if (l.isPotionActive(AscendingPotions.Spore.id)) {
			if (l.getActivePotionEffect(AscendingPotions.Spore).getDuration() == 20) {
				List<EntityLivingBase> entities = l.worldObj
						.getEntitiesWithinAABB(EntityLivingBase.class,
								l.boundingBox.expand(5.0D, 5.0D, 4.0D));
				for (EntityLivingBase entity : entities) {
					entity.addPotionEffect(new PotionEffect(Potion.poison.id,
							300, 2));
				}
			}
		}
	}

	@SubscribeEvent
	public void unlockDimResearch(PlayerChangedDimensionEvent e) {
		int d = e.toDim;
		EntityPlayer player = e.player;
		if (d == ConfigurationHelper.abyss
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Abyss"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Abyss"))) {
			PacketHandler.INSTANCE.sendTo(new PacketResearchComplete("Abyss"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Abyss");
		} else if (d == ConfigurationHelper.greckon
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Greckon"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Greckon"))) {
			PacketHandler.INSTANCE.sendTo(
					new PacketResearchComplete("Greckon"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Greckon");
		} else if (d == ConfigurationHelper.dustopia
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Dustopia"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Dustopia"))) {
			PacketHandler.INSTANCE.sendTo(
					new PacketResearchComplete("Dustopia"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Dustopia");
		} else if (d == ConfigurationHelper.voxponds
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "VoxPonds"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@VoxPonds"))) {
			PacketHandler.INSTANCE.sendTo(
					new PacketResearchComplete("VoxPonds"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"VoxPonds");
		} else if (d == ConfigurationHelper.creeponia
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Creeponia"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Creeponia"))) {
			PacketHandler.INSTANCE.sendTo(new PacketResearchComplete(
					"Creeponia"), (EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Creeponia");
		} else if (d == ConfigurationHelper.haven
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Haven"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Haven"))) {
			PacketHandler.INSTANCE.sendTo(new PacketResearchComplete("Haven"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Haven");
		} else if (d == ConfigurationHelper.runandor
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Runandor"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Runandor"))) {
			PacketHandler.INSTANCE.sendTo(
					new PacketResearchComplete("Runandor"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Runandor");
		} else if (d == ConfigurationHelper.candyland
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Candyland"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Candyland"))) {
			PacketHandler.INSTANCE.sendTo(new PacketResearchComplete(
					"Candyland"), (EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Candyland");
		} else if (d == ConfigurationHelper.iromine
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Iromine"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Iromine"))) {
			PacketHandler.INSTANCE.sendTo(
					new PacketResearchComplete("Iromine"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Iromine");
		} else if (d == ConfigurationHelper.lunalus
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Lunalus"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Lunalus"))) {
			PacketHandler.INSTANCE.sendTo(
					new PacketResearchComplete("Lunalus"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Lunalus");
		} else if (d == ConfigurationHelper.deeplands
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Deeplands"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Deeplands"))) {
			PacketHandler.INSTANCE.sendTo(new PacketResearchComplete(
					"Deeplands"), (EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Deeplands");
		} else if (d == ConfigurationHelper.barathos
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Barathos"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Barathos"))) {
			PacketHandler.INSTANCE.sendTo(
					new PacketResearchComplete("Barathos"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Barathos");
		} else if (d == ConfigurationHelper.celeve
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Celeve"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Celeve"))) {
			PacketHandler.INSTANCE.sendTo(new PacketResearchComplete("Celeve"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Celeve");
		} else if (d == ConfigurationHelper.crystevia
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Crystevia"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Crystevia"))) {
			PacketHandler.INSTANCE.sendTo(new PacketResearchComplete(
					"Crystevia"), (EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Crystevia");
		} else if (d == ConfigurationHelper.precasia
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Precasia"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Precasia"))) {
			PacketHandler.INSTANCE.sendTo(
					new PacketResearchComplete("Precasia"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Precasia");
		} else if (d == ConfigurationHelper.mysterium
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Mysterium"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Mysterium"))) {
			PacketHandler.INSTANCE.sendTo(new PacketResearchComplete(
					"Mysterium"), (EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Mysterium");
		} else if (d == ConfigurationHelper.gardencia
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Gardencia"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Gardencia"))) {
			PacketHandler.INSTANCE.sendTo(new PacketResearchComplete(
					"Gardencia"), (EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Gardencia");
		} else if (d == ConfigurationHelper.lborean
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "LBorean"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@LBorean"))) {
			PacketHandler.INSTANCE.sendTo(
					new PacketResearchComplete("LBorean"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"LBorean");
		} else if (d == ConfigurationHelper.lelyetia
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Lelyetia"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Lelyetia"))) {
			PacketHandler.INSTANCE.sendTo(
					new PacketResearchComplete("Lelyetia"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Lelyetia");
		}else if (d == -1
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "Nether"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@Nether"))) {
			PacketHandler.INSTANCE.sendTo(
					new PacketResearchComplete("Nether"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"Nether");
		}else if (d == 1
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "End"))
				&& (!ThaumcraftApiHelper.isResearchComplete(
						player.getCommandSenderName(), "@End"))) {
			PacketHandler.INSTANCE.sendTo(
					new PacketResearchComplete("End"),
					(EntityPlayerMP) player);
			Thaumcraft.proxy.getResearchManager().completeResearch(player,
					"End");
		}
	}

}
