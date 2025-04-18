package com.morallenplay.vanillacookbook.event;

import com.morallenplay.vanillacookbook.VanillaCookbook;
import com.morallenplay.vanillacookbook.registry.ItemRegistry;
import com.morallenplay.vanillacookbook.setup.Config;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber(modid = VanillaCookbook.MODID)
public class CheeseBottleEvent {
	
	@SubscribeEvent
    public static void onCheeseRetrieval(PlayerEvent.ItemSmeltedEvent event) {
		Player player = event.getEntity();
		ItemStack output = event.getSmelting();
		
		if (output.getItem() == ItemRegistry.CHEESE.get() && !Config.CHEESE_SMELTING.get()) {
			player.getInventory().add(new ItemStack(Items.GLASS_BOTTLE, output.getCount()));
		}
	}

}
