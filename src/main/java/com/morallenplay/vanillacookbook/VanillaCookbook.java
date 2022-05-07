package com.morallenplay.vanillacookbook;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.morallenplay.vanillacookbook.registry.BlockRegistry;
import com.morallenplay.vanillacookbook.registry.CompostChances;
import com.morallenplay.vanillacookbook.registry.ItemRegistry;
import com.morallenplay.vanillacookbook.setup.Config;
import com.morallenplay.vanillacookbook.setup.FDConfigCondition;
import com.morallenplay.vanillacookbook.setup.NPConfigCondition;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
    public static final CreativeModeTab ITEM_GROUP = new VCItemGroup(VanillaCookbook.MOD_ID);
    public static VanillaCookbook instance;

    public VanillaCookbook() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);
    	
    	ItemRegistry.ITEMS.register(modEventBus);
    	BlockRegistry.BLOCKS.register(modEventBus);
    	
    	ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
    	
    	CraftingHelper.register(new FDConfigCondition.Serializer());
    	CraftingHelper.register(new NPConfigCondition.Serializer());
    	
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
    
    public static class VCItemGroup extends CreativeModeTab {

		public VCItemGroup(String label) {
			super(label);
		}

		@Override
		public ItemStack makeIcon() {
			return ItemRegistry.BOOK_CAKE.get().getDefaultInstance();
		}
	}
}
