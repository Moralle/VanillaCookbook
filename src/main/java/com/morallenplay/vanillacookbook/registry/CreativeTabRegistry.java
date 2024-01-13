package com.morallenplay.vanillacookbook.registry;

import com.morallenplay.vanillacookbook.VanillaCookbook;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

// @Mod.EventBusSubscriber(modid = VanillaCookbook.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeTabRegistry {
	
	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VanillaCookbook.MOD_ID);
	
	public static final RegistryObject<CreativeModeTab> TAB_VANILLA_COOKBOOK = CREATIVE_TABS.register(VanillaCookbook.MOD_ID,
			() -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.vanillacookbook"))
				    .icon(() -> new ItemStack(ItemRegistry.BOOK_CAKE.get()))
				    .displayItems((params, output) -> {
				    	output.accept(ItemRegistry.COOKED_BAMBOO.get());
				    	output.accept(ItemRegistry.COOKED_BEETROOT.get());
				    	output.accept(ItemRegistry.COOKED_EGG.get());
				    	output.accept(ItemRegistry.GRILLED_MELON.get());
				    	output.accept(ItemRegistry.BAKED_APPLE.get());
				    	output.accept(ItemRegistry.COOKED_TURTLE_EGG.get());
				    	output.accept(ItemRegistry.COOKED_SNIFFER_EGG.get());
				    	output.accept(ItemRegistry.CACTUS_SLICE.get());
				    	output.accept(ItemRegistry.COOKED_CACTUS_SLICE.get());
				    	output.accept(ItemRegistry.CHEESE.get());
				    	output.accept(ItemRegistry.GARDEN_SOUP.get());
				    	output.accept(ItemRegistry.PUMPKIN_SOUP.get());
				    	output.accept(ItemRegistry.FISH_STEW.get());
				    	output.accept(ItemRegistry.VEGETABLE_STEW.get());
				    	output.accept(ItemRegistry.MEATY_STEW.get());
				    	output.accept(ItemRegistry.CHICKEN_SOUP.get());
				    	output.accept(ItemRegistry.INK_SOUP.get());
				    	output.accept(ItemRegistry.GLOW_INK_SOUP.get());
				    	output.accept(ItemRegistry.FUNGUS_STEW.get());
				    	output.accept(ItemRegistry.SMOLDERING_STEW.get());
				    	output.accept(ItemRegistry.PLAIN_SALAD.get());
				    	output.accept(ItemRegistry.KELP_SALAD.get());
				    	output.accept(ItemRegistry.FRUIT_SALAD.get());
				    	output.accept(ItemRegistry.GOLDEN_FRUIT_SALAD.get());
				    	output.accept(ItemRegistry.ROOT_SALAD.get());
				    	output.accept(ItemRegistry.MASHED_POTATOES.get());
				    	output.accept(ItemRegistry.APPLE_SAUCE.get());
				    	output.accept(ItemRegistry.MUSHROOM_SCRAMBLED_EGGS.get());
				    	output.accept(ItemRegistry.PUDDING.get());
				    	output.accept(ItemRegistry.CHOCOLATE_PUDDING.get());
				    	output.accept(ItemRegistry.JELLY.get());
				    	output.accept(ItemRegistry.MAGMA_JELLY.get());
				    	output.accept(ItemRegistry.APPLE_PIE.get());
				    	output.accept(ItemRegistry.BEETROOT_PIE.get());
				    	output.accept(ItemRegistry.BERRY_PIE.get());
				    	output.accept(ItemRegistry.WART_PIE.get());
				    	output.accept(ItemRegistry.POISONOUS_PIE.get());
				    	output.accept(ItemRegistry.BERRY_COOKIE.get());
				    	output.accept(ItemRegistry.HONEY_COOKIE.get());
				    	output.accept(ItemRegistry.POTATO_COOKIE.get());
				    	output.accept(ItemRegistry.PUMPKIN_COOKIE.get());
				    	output.accept(ItemRegistry.SUNFLOWER_SEED_COOKIE.get());
				    	output.accept(ItemRegistry.PANCAKE.get());
				    	output.accept(ItemRegistry.BERRY_PANCAKE.get());
				    	output.accept(ItemRegistry.HONEY_PANCAKE.get());
				    	output.accept(ItemRegistry.BACON_PANCAKE.get());
				    	output.accept(ItemRegistry.CREEPE.get());
				    	output.accept(ItemRegistry.BROWNIE.get());
				    	output.accept(ItemRegistry.BERRY_BROWNIE.get());
				    	output.accept(ItemRegistry.ICE_CREAM.get());
				    	output.accept(ItemRegistry.CHOCOLATE_ICE_CREAM.get());
				    	output.accept(ItemRegistry.BERRY_ICE_CREAM.get());
				    	output.accept(ItemRegistry.NEAPOLITAN_ICE_CREAM.get());
				    	output.accept(ItemRegistry.PUMPSICLE.get());
				    	output.accept(ItemRegistry.SNOW_HORN.get());
				    	output.accept(ItemRegistry.GLAZED_GLOW_BERRIES.get());
				    	output.accept(ItemRegistry.POTATO_CHIPS.get());
				    	output.accept(ItemRegistry.HOT_POTATO_CHIPS.get());
				    	output.accept(ItemRegistry.BEET_CHIPS.get());
				    	output.accept(ItemRegistry.APPLE_CHIPS.get());
				    	output.accept(ItemRegistry.HONEY_CANDY.get());
				    	output.accept(ItemRegistry.BERRY_CANDY.get());
				    	output.accept(ItemRegistry.WARPED_GUMMY.get());
				    	output.accept(ItemRegistry.CHOCOLATE.get());
				    	output.accept(ItemRegistry.PITCHER_PRALINE.get());
				    	output.accept(ItemRegistry.SWORD_LOLLIPOP.get());
				    	output.accept(ItemRegistry.TRAIL_MIX.get());
				    	output.accept(ItemRegistry.HOT_CHICKEN_DRUMSTICK.get());
				    	output.accept(ItemRegistry.FISH_AND_CHIPS.get());
				    	output.accept(ItemRegistry.KEBAB.get());
				    	output.accept(ItemRegistry.MEATLOAF.get());
				    	output.accept(ItemRegistry.MEATBALL.get());
				    	output.accept(ItemRegistry.SPICY_MEATBALL.get());
				    	output.accept(ItemRegistry.FRENCH_TOAST.get());
				    	output.accept(ItemRegistry.POTATO_PANCAKE.get());
				    	output.accept(ItemRegistry.STUFFED_SEA_PICKLE.get());
				    	output.accept(ItemRegistry.MINERS_SALAD.get());
				    	output.accept(ItemRegistry.NETHERITE_APPLE.get());
				    	output.accept(ItemRegistry.CHOCOLATE_EGG.get());
				    	output.accept(ItemRegistry.APPLE_JUICE.get());
				    	output.accept(ItemRegistry.BERRY_JUICE.get());
				    	output.accept(ItemRegistry.CACTUS_JUICE.get());
				    	output.accept(ItemRegistry.MELON_JUICE.get());
				    	output.accept(ItemRegistry.SEA_PICKLE_JUICE.get());
				    	output.accept(ItemRegistry.CHORUS_JUICE.get());
				    	output.accept(ItemRegistry.LEAF_TEA.get());
				    	output.accept(ItemRegistry.CHERRY_BLOSSOM_TEA.get());
				    	output.accept(ItemRegistry.FLOWER_TEA.get());
				    	output.accept(ItemRegistry.MILK_BOTTLE.get());
				    	output.accept(ItemRegistry.CHOCOLATE_MILK.get());
				    	output.accept(ItemRegistry.BERRY_MILK.get());
				    	output.accept(ItemRegistry.APPLE_SODA.get());
				    	output.accept(ItemRegistry.BERRY_SODA.get());
				    	output.accept(ItemRegistry.CACTUS_SODA.get());
				    	output.accept(ItemRegistry.MELON_SODA.get());
				    	output.accept(ItemRegistry.SEA_PICKLE_SODA.get());
				    	output.accept(ItemRegistry.CHORUS_SODA.get());
				    	
				    	if (ModList.get().isLoaded("farmersdelight")) {
				    		output.accept(ItemRegistry.PIZZA.get());
				    		output.accept(ItemRegistry.BERRY_CAKE_SLICE.get());
				    		output.accept(ItemRegistry.CARROT_CAKE_SLICE.get());
				    		output.accept(ItemRegistry.CHEESECAKE_SLICE.get());
				    		output.accept(ItemRegistry.CHOCOLATE_CAKE_SLICE.get());
				    		output.accept(ItemRegistry.MOHNKUCHEN_SLICE.get());
				    		output.accept(ItemRegistry.ICE_CREAM_CAKE_SLICE.get());
				    		output.accept(ItemRegistry.ROSE_CAKE_SLICE.get());
				    		output.accept(ItemRegistry.CHORUS_JUICE.get());
				    		output.accept(ItemRegistry.BOOK_CAKE_SLICE.get());
				    		output.accept(ItemRegistry.GLOW_BERRY_CAKE_SLICE.get());
				    	}
				    	
				    	if (ModList.get().isLoaded("create")) {
				    		output.accept(ItemRegistry.ROSE_ROCK_CANDY.get());
				    		output.accept(ItemRegistry.POLISHED_ROSE_ROCK_CANDY.get());
				    	}
				    	
				    	if (ModList.get().isLoaded("botania")) {
				    		output.accept(ItemRegistry.MANA_ROLL.get());
				    		output.accept(ItemRegistry.TATER_PUFFS.get());
				    	}
				    	
				    	output.accept(ItemRegistry.BERRY_CAKE.get());
				    	output.accept(ItemRegistry.CARROT_CAKE.get());
				    	output.accept(ItemRegistry.CHEESECAKE.get());
				    	output.accept(ItemRegistry.CHOCOLATE_CAKE.get());
				    	output.accept(ItemRegistry.MOHNKUCHEN.get());
				    	output.accept(ItemRegistry.ICE_CREAM_CAKE.get());
				    	output.accept(ItemRegistry.ROSE_CAKE.get());
				    	output.accept(ItemRegistry.CHORUS_CAKE.get());
				    	output.accept(ItemRegistry.BOOK_CAKE.get());
				    	output.accept(ItemRegistry.GLOW_BERRY_CAKE.get());
				    	output.accept(ItemRegistry.PANCAKE_STACK.get());
				    	output.accept(ItemRegistry.BROWNIE_TRAY.get());
				    	
				    	output.accept(ItemRegistry.THE_SLUDGE.get(), CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
				      })
					.build());
}