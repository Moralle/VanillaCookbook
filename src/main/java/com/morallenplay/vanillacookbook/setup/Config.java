package com.morallenplay.vanillacookbook.setup;

import net.neoforged.neoforge.common.ModConfigSpec;


public class Config {
	
	public static ModConfigSpec COMMON_CONFIG;
	public static ModConfigSpec CLIENT_CONFIG;
	
	public static final String CATEGORY_COMPAT = "compat";
	public static final String CATEGORY_FEATURES = "features";
	public static final String CATEGORY_CLIENT = "client";
	
	public static ModConfigSpec.BooleanValue FD_ITEMS;
	public static ModConfigSpec.BooleanValue NP_ITEMS;
	public static ModConfigSpec.BooleanValue VILLAGER_TRADES;
	public static ModConfigSpec.BooleanValue LOOT_GENERATION;
	public static ModConfigSpec.BooleanValue GOLDEN_HOE_APPLES;
	public static ModConfigSpec.BooleanValue CHORUS_CAKE_TELEPORTATION;
	public static ModConfigSpec.BooleanValue CHEESE_SMELTING;
	public static ModConfigSpec.BooleanValue FOOD_EFFECT_TOOLTIPS;
	public static ModConfigSpec.BooleanValue FOOD_SPECIAL_TOOLTIPS;
	
	static {
		ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();
		
		COMMON_BUILDER.comment("Enable/Disable Recipes").push(CATEGORY_COMPAT);
		FD_ITEMS = COMMON_BUILDER.comment("Disable recipes for duplicate/similar items to Farmer's Delight? (Default: false)").define("hideFDItems", false);
		NP_ITEMS = COMMON_BUILDER.comment("Disable recipes for duplicate/similar items to Neapolitan? (Default: false)").define("hideNPItems", false);
		COMMON_BUILDER.pop();
		
		COMMON_BUILDER.comment("Enable/Disable Features").push(CATEGORY_FEATURES);
		VILLAGER_TRADES = COMMON_BUILDER.comment("Disable additional Villager trades? (Default: false)").define("trades", false);
		LOOT_GENERATION = COMMON_BUILDER.comment("Disable additional loot? (Default: false)").define("loot", false);
		GOLDEN_HOE_APPLES = COMMON_BUILDER.comment("Disable Oak/Dark Oak Leaves dropping golden apples when broken with a golden hoe? (Default: false)").define("golden_hoe_apples", false);
		CHORUS_CAKE_TELEPORTATION = COMMON_BUILDER.comment("Disable Chorus Cake Teleportation? (Default: false)").define("cakeTeleportation", false);
		CHEESE_SMELTING = COMMON_BUILDER.comment("Disable the returnal of a bottle when smelting cheese in a furnace? (Default: false)").define("cheeseBottle", false);
		
		COMMON_BUILDER.pop();
		
		COMMON_CONFIG = COMMON_BUILDER.build();
		
		ModConfigSpec.Builder CLIENT_BUILDER = new ModConfigSpec.Builder();
		
		CLIENT_BUILDER.comment("Client settings").push(CATEGORY_CLIENT);
		
		FOOD_EFFECT_TOOLTIPS = CLIENT_BUILDER.comment("Should items display tooltips describing their (potion) effects? (Default: true)")
				.define("foodEffectTooltips", true);
		FOOD_SPECIAL_TOOLTIPS = CLIENT_BUILDER.comment("Should items display tooltips describing other effects (i.e. cheese curing all potion effects)? (Default: true)")
				.define("foodSpecialTooltips", true);
		
		CLIENT_BUILDER.pop();

		CLIENT_CONFIG = CLIENT_BUILDER.build();
	}
}
