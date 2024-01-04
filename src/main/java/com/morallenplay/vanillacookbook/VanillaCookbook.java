package com.morallenplay.vanillacookbook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.morallenplay.vanillacookbook.registry.BlockRegistry;
import com.morallenplay.vanillacookbook.registry.CompostChances;
import com.morallenplay.vanillacookbook.registry.ItemRegistry;
import com.morallenplay.vanillacookbook.registry.RecipeRegistry;
import com.morallenplay.vanillacookbook.setup.Config;
import com.morallenplay.vanillacookbook.setup.FDConfigCondition;
import com.morallenplay.vanillacookbook.setup.NPConfigCondition;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("unused")
@Mod("vanillacookbook")
public class VanillaCookbook
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "vanillacookbook";
    public static VanillaCookbook instance;

    public VanillaCookbook() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);
    	
//    	modEventBus.addListener(this::buildContents);
    	
    	ItemRegistry.ITEMS.register(modEventBus);
    	BlockRegistry.BLOCKS.register(modEventBus);
    	
    	ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
    	
    	CraftingHelper.register(new FDConfigCondition.Serializer());
    	CraftingHelper.register(new NPConfigCondition.Serializer());
    	
    	RecipeRegistry.RECIPE_SERIALIZERS.register(modEventBus);
    	
//    	CreativeTabRegistry.CREATIVE_TABS.register(modEventBus);
    	
    	instance = this;
       
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	CompostChances.register();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    	
    }
    
//	public static CreativeModeTab VANILLA_COOKBOOK_TAB;
//	
//	@SubscribeEvent
//	public void buildContents(CreativeModeTabEvent.Register event) {
//		VANILLA_COOKBOOK_TAB = event.registerCreativeModeTab(new ResourceLocation(VanillaCookbook.MOD_ID, "vanillacookbook"), builder ->
//	    
//	    builder.title(Component.translatable("itemGroup.vanillacookbook"))
//	    .icon(() -> new ItemStack(ItemRegistry.BOOK_CAKE.get()))
//	    .displayItems((params, output) -> {
//	    	output.accept(ItemRegistry.COOKED_BAMBOO.get());
//	    	output.accept(ItemRegistry.COOKED_BEETROOT.get());
//	    	output.accept(ItemRegistry.COOKED_EGG.get());
//	    	output.accept(ItemRegistry.GRILLED_MELON.get());
//	    	output.accept(ItemRegistry.BAKED_APPLE.get());
//	    	output.accept(ItemRegistry.COOKED_TURTLE_EGG.get());
//	    	output.accept(ItemRegistry.CACTUS_SLICE.get());
//	    	output.accept(ItemRegistry.COOKED_CACTUS_SLICE.get());
//	    	output.accept(ItemRegistry.CHEESE.get());
//	    	output.accept(ItemRegistry.GARDEN_SOUP.get());
//	    	output.accept(ItemRegistry.PUMPKIN_SOUP.get());
//	    	output.accept(ItemRegistry.FISH_STEW.get());
//	    	output.accept(ItemRegistry.VEGETABLE_STEW.get());
//	    	output.accept(ItemRegistry.MEATY_STEW.get());
//	    	output.accept(ItemRegistry.CHICKEN_SOUP.get());
//	    	output.accept(ItemRegistry.INK_SOUP.get());
//	    	output.accept(ItemRegistry.GLOW_INK_SOUP.get());
//	    	output.accept(ItemRegistry.FUNGUS_STEW.get());
//	    	output.accept(ItemRegistry.SMOLDERING_STEW.get());
//	    	output.accept(ItemRegistry.PLAIN_SALAD.get());
//	    	output.accept(ItemRegistry.KELP_SALAD.get());
//	    	output.accept(ItemRegistry.FRUIT_SALAD.get());
//	    	output.accept(ItemRegistry.GOLDEN_FRUIT_SALAD.get());
//	    	output.accept(ItemRegistry.ROOT_SALAD.get());
//	    	output.accept(ItemRegistry.MASHED_POTATOES.get());
//	    	output.accept(ItemRegistry.APPLE_SAUCE.get());
//	    	output.accept(ItemRegistry.MUSHROOM_SCRAMBLED_EGGS.get());
//	    	output.accept(ItemRegistry.PUDDING.get());
//	    	output.accept(ItemRegistry.CHOCOLATE_PUDDING.get());
//	    	output.accept(ItemRegistry.JELLY.get());
//	    	output.accept(ItemRegistry.MAGMA_JELLY.get());
//	    	output.accept(ItemRegistry.APPLE_PIE.get());
//	    	output.accept(ItemRegistry.BEETROOT_PIE.get());
//	    	output.accept(ItemRegistry.BERRY_PIE.get());
//	    	output.accept(ItemRegistry.WART_PIE.get());
//	    	output.accept(ItemRegistry.POISONOUS_PIE.get());
//	    	output.accept(ItemRegistry.BERRY_COOKIE.get());
//	    	output.accept(ItemRegistry.HONEY_COOKIE.get());
//	    	output.accept(ItemRegistry.POTATO_COOKIE.get());
//	    	output.accept(ItemRegistry.PUMPKIN_COOKIE.get());
//	    	output.accept(ItemRegistry.SUNFLOWER_SEED_COOKIE.get());
//	    	output.accept(ItemRegistry.PANCAKE.get());
//	    	output.accept(ItemRegistry.BERRY_PANCAKE.get());
//	    	output.accept(ItemRegistry.HONEY_PANCAKE.get());
//	    	output.accept(ItemRegistry.BACON_PANCAKE.get());
//	    	output.accept(ItemRegistry.CREEPE.get());
//	    	output.accept(ItemRegistry.BROWNIE.get());
//	    	output.accept(ItemRegistry.BERRY_BROWNIE.get());
//	    	output.accept(ItemRegistry.ICE_CREAM.get());
//	    	output.accept(ItemRegistry.CHOCOLATE_ICE_CREAM.get());
//	    	output.accept(ItemRegistry.BERRY_ICE_CREAM.get());
//	    	output.accept(ItemRegistry.NEAPOLITAN_ICE_CREAM.get());
//	    	output.accept(ItemRegistry.PUMPSICLE.get());
//	    	output.accept(ItemRegistry.SNOW_HORN.get());
//	    	output.accept(ItemRegistry.GLAZED_GLOW_BERRIES.get());
//	    	output.accept(ItemRegistry.POTATO_CHIPS.get());
//	    	output.accept(ItemRegistry.HOT_POTATO_CHIPS.get());
//	    	output.accept(ItemRegistry.BEET_CHIPS.get());
//	    	output.accept(ItemRegistry.APPLE_CHIPS.get());
//	    	output.accept(ItemRegistry.HONEY_CANDY.get());
//	    	output.accept(ItemRegistry.BERRY_CANDY.get());
//	    	output.accept(ItemRegistry.WARPED_GUMMY.get());
//	    	output.accept(ItemRegistry.CHOCOLATE.get());
//	    	output.accept(ItemRegistry.SWORD_LOLLIPOP.get());
//	    	output.accept(ItemRegistry.TRAIL_MIX.get());
//	    	output.accept(ItemRegistry.HOT_CHICKEN_DRUMSTICK.get());
//	    	output.accept(ItemRegistry.FISH_AND_CHIPS.get());
//	    	output.accept(ItemRegistry.KEBAB.get());
//	    	output.accept(ItemRegistry.MEATLOAF.get());
//	    	output.accept(ItemRegistry.MEATBALL.get());
//	    	output.accept(ItemRegistry.SPICY_MEATBALL.get());
//	    	output.accept(ItemRegistry.FRENCH_TOAST.get());
//	    	output.accept(ItemRegistry.POTATO_PANCAKE.get());
//	    	output.accept(ItemRegistry.STUFFED_SEA_PICKLE.get());
//	    	output.accept(ItemRegistry.MINERS_SALAD.get());
//	    	output.accept(ItemRegistry.NETHERITE_APPLE.get());
//	    	output.accept(ItemRegistry.CHOCOLATE_EGG.get());
//	    	output.accept(ItemRegistry.APPLE_JUICE.get());
//	    	output.accept(ItemRegistry.BERRY_JUICE.get());
//	    	output.accept(ItemRegistry.CACTUS_JUICE.get());
//	    	output.accept(ItemRegistry.MELON_JUICE.get());
//	    	output.accept(ItemRegistry.SEA_PICKLE_JUICE.get());
//	    	output.accept(ItemRegistry.CHORUS_JUICE.get());
//	    	output.accept(ItemRegistry.LEAF_TEA.get());
//	    	output.accept(ItemRegistry.FLOWER_TEA.get());
//	    	output.accept(ItemRegistry.MILK_BOTTLE.get());
//	    	output.accept(ItemRegistry.CHOCOLATE_MILK.get());
//	    	output.accept(ItemRegistry.BERRY_MILK.get());
//	    	output.accept(ItemRegistry.APPLE_SODA.get());
//	    	output.accept(ItemRegistry.BERRY_SODA.get());
//	    	output.accept(ItemRegistry.CACTUS_SODA.get());
//	    	output.accept(ItemRegistry.MELON_SODA.get());
//	    	output.accept(ItemRegistry.SEA_PICKLE_SODA.get());
//	    	output.accept(ItemRegistry.CHORUS_SODA.get());
//	    	
//	    	if (ModList.get().isLoaded("farmersdelight")) {
//	    		output.accept(ItemRegistry.PIZZA.get());
//	    		output.accept(ItemRegistry.BERRY_CAKE_SLICE.get());
//	    		output.accept(ItemRegistry.CARROT_CAKE_SLICE.get());
//	    		output.accept(ItemRegistry.CHEESECAKE_SLICE.get());
//	    		output.accept(ItemRegistry.CHOCOLATE_CAKE_SLICE.get());
//	    		output.accept(ItemRegistry.MOHNKUCHEN_SLICE.get());
//	    		output.accept(ItemRegistry.ICE_CREAM_CAKE_SLICE.get());
//	    		output.accept(ItemRegistry.ROSE_CAKE_SLICE.get());
//	    		output.accept(ItemRegistry.CHORUS_JUICE.get());
//	    		output.accept(ItemRegistry.BOOK_CAKE_SLICE.get());
//	    		output.accept(ItemRegistry.GLOW_BERRY_CAKE_SLICE.get());
//	    	}
//	    	
//	    	output.accept(ItemRegistry.BERRY_CAKE.get());
//	    	output.accept(ItemRegistry.CARROT_CAKE.get());
//	    	output.accept(ItemRegistry.CHEESECAKE.get());
//	    	output.accept(ItemRegistry.CHOCOLATE_CAKE.get());
//	    	output.accept(ItemRegistry.MOHNKUCHEN.get());
//	    	output.accept(ItemRegistry.ICE_CREAM_CAKE.get());
//	    	output.accept(ItemRegistry.ROSE_CAKE.get());
//	    	output.accept(ItemRegistry.CHORUS_CAKE.get());
//	    	output.accept(ItemRegistry.BOOK_CAKE.get());
//	    	output.accept(ItemRegistry.GLOW_BERRY_CAKE.get());
//	    	output.accept(ItemRegistry.PANCAKE_STACK.get());
//	    	output.accept(ItemRegistry.BROWNIE_TRAY.get());
//	    	
//	    	output.accept(ItemRegistry.THE_SLUDGE.get(), CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
//	      })
//	    .build()
//	  );
//	}
}
