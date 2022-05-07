package com.morallenplay.vanillacookbook.event;

import com.morallenplay.vanillacookbook.VanillaCookbook;
import com.morallenplay.vanillacookbook.registry.ItemRegistry;
import com.morallenplay.vanillacookbook.setup.Config;

import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = VanillaCookbook.MOD_ID, bus = Bus.FORGE)
public class TradesEvent {
	
	//get(level) (Emeralds, Sold Item, max trades, XP to Villager)
	
	@SubscribeEvent
    public static void onVillagersTradesEvent(VillagerTradesEvent event) {
		if (Config.VILLAGER_TRADES.get()) return;
		if(event.getType() == VillagerProfession.FARMER) {
			 event.getTrades().get(2).add(new BasicItemListing(1, new ItemStack(ItemRegistry.CHEESE.get(), 4), 16, 2, 0.05f));
			 event.getTrades().get(2).add(new BasicItemListing(1, new ItemStack(ItemRegistry.APPLE_PIE.get(), 4), 12, 5, 0.05f));
			 event.getTrades().get(2).add(new BasicItemListing(1, new ItemStack(ItemRegistry.BEETROOT_PIE.get(), 4), 12, 5, 0.05f));
			 event.getTrades().get(2).add(new BasicItemListing(1, new ItemStack(ItemRegistry.BERRY_PIE.get(), 4), 12, 5, 0.05f));
			 event.getTrades().get(3).add(new BasicItemListing(3, new ItemStack(ItemRegistry.BERRY_COOKIE.get(), 18), 12, 10, 0.05f));
			 event.getTrades().get(4).add(new BasicItemListing(1, new ItemStack(ItemRegistry.BERRY_CAKE.get()), 12, 15, 0.05f));
			 event.getTrades().get(4).add(new BasicItemListing(1, new ItemStack(ItemRegistry.CARROT_CAKE.get()), 12, 15, 0.05f));
			 event.getTrades().get(4).add(new BasicItemListing(1, new ItemStack(ItemRegistry.CHOCOLATE_CAKE.get()), 12, 15, 0.05f));
			 event.getTrades().get(5).add(new BasicItemListing(1, new ItemStack(ItemRegistry.PANCAKE.get(), 4), 16, 10, 0.05f));
		}
		if(event.getType() == VillagerProfession.FISHERMAN) {
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(ItemRegistry.FISH_AND_CHIPS.get(), 3), new ItemStack(Items.EMERALD, 1), 12, 30, 0.05f));
		}
		if(event.getType() == VillagerProfession.LIBRARIAN) {
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(ItemRegistry.BOOK_CAKE.get()), new ItemStack(Items.EMERALD, 2), 12, 30, 0.05f));
		}
		if(event.getType() == VillagerProfession.BUTCHER) {
			event.getTrades().get(4).add(new BasicItemListing(1, new ItemStack(ItemRegistry.MEATLOAF.get(), 6), 16, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(1, new ItemStack(ItemRegistry.MEATBALL.get(), 8), 16, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(1, new ItemStack(ItemRegistry.HOT_CHICKEN_DRUMSTICK.get(), 12), 16, 15, 0.05f));
		}
	}
}
