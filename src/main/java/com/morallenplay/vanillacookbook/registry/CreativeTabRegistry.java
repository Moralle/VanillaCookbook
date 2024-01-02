package com.morallenplay.vanillacookbook.registry;

import com.morallenplay.vanillacookbook.VanillaCookbook;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VanillaCookbook.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabRegistry {
	
	public static CreativeModeTab VANILLA_COOKBOOK_TAB;
	
	@SubscribeEvent
	public void buildContents(CreativeModeTabEvent.Register event) {
		VANILLA_COOKBOOK_TAB = event.registerCreativeModeTab(new ResourceLocation(VanillaCookbook.MOD_ID, "vanilla_cookbook"), builder ->
	    
	    builder.title(Component.translatable("item_group.vanilla_cookbook"))
	    .icon(() -> new ItemStack(ItemRegistry.BOOK_CAKE.get()))
	    .displayItems((enabledFlags, populator, hasPermissions) -> {
	        populator.accept(ItemRegistry.APPLE_CHIPS.get());
	      })
	  );
	}
}
