package com.morallenplay.vanillacookbook.setup;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
	
	public static ForgeConfigSpec COMMON_CONFIG;
	
	public static final String CATEGORY_COMPAT = "compat";
	public static final String CATEGORY_FEATURES = "features";
	
	public static ForgeConfigSpec.BooleanValue FD_ITEMS;
	public static ForgeConfigSpec.BooleanValue NP_ITEMS;
	public static ForgeConfigSpec.BooleanValue VILLAGER_TRADES;
	public static ForgeConfigSpec.BooleanValue LOOT_GENERATION;
	public static ForgeConfigSpec.BooleanValue CHORUS_CAKE_TELEPORTATION;
	public static ForgeConfigSpec.BooleanValue CHEESE_SMELTING;
	
	static {
		ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
		
		COMMON_BUILDER.comment("Enable/Disable Recipes").push(CATEGORY_COMPAT);
		FD_ITEMS = COMMON_BUILDER.comment("Disable recipes for duplicate/similar items to Farmer's Delight? (Default: false)").define("hideFDItems", false);
		NP_ITEMS = COMMON_BUILDER.comment("Disable recipes for duplicate/similar items to Neapolitan? (Default: false)").define("hideNPItems", false);
		COMMON_BUILDER.pop();
		
		COMMON_BUILDER.comment("Enable/Disable Features").push(CATEGORY_FEATURES);
		VILLAGER_TRADES = COMMON_BUILDER.comment("Disable additional Villager trades? (Default: false)").define("trades", false);
		LOOT_GENERATION = COMMON_BUILDER.comment("Disable additional loot? (Default: false)").define("loot", false);
		CHORUS_CAKE_TELEPORTATION = COMMON_BUILDER.comment("Disable Chorus Cake Teleportation? (Default: false)").define("cakeTeleportation", false);
		CHEESE_SMELTING = COMMON_BUILDER.comment("Disable the returnal of a bottle when smelting cheese in a furnace? (Default: false)").define("cheeseBottle", false);
		
		COMMON_BUILDER.pop();
		
		COMMON_CONFIG = COMMON_BUILDER.build();
	}
	
//	@SubscribeEvent
//	public static void onLoad(final ModConfig.Loading configEvent) {
//	}
//
//	@SubscribeEvent
//	public static void onReload(final ModConfig.Reloading configEvent) {
//	}
}
