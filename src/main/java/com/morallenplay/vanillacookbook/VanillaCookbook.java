package com.morallenplay.vanillacookbook;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.morallenplay.vanillacookbook.registry.BlockRegistry;
import com.morallenplay.vanillacookbook.registry.ConditionRegistry;
import com.morallenplay.vanillacookbook.registry.CreativeTabRegistry;
import com.morallenplay.vanillacookbook.registry.ItemRegistry;
import com.morallenplay.vanillacookbook.registry.RecipeSerializerRegistry;
import com.morallenplay.vanillacookbook.setup.Config;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(VanillaCookbook.MODID)
public class VanillaCookbook
{
	
    public static final String MODID = "vanillacookbook";
    
    @SuppressWarnings("unused")
	private static final Logger LOGGER = LogUtils.getLogger();
    
    public VanillaCookbook(IEventBus modEventBus, ModContainer modContainer)
    {
    	modEventBus.addListener(this::commonSetup);
		
        ItemRegistry.ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        CreativeTabRegistry.CREATIVE_MODE_TABS.register(modEventBus);
        RecipeSerializerRegistry.RECIPE_SERIALIZERS.register(modEventBus);
        ConditionRegistry.CONDITION_CODECS.register(modEventBus);
        ConditionRegistry.LOOT_CONDITION_TYPES.register(modEventBus);
        
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
        modContainer.registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }
}
