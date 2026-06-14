package com.morallenplay.vanillacookbook.registry;

import java.util.function.Supplier;

import com.mojang.serialization.MapCodec;
import com.morallenplay.vanillacookbook.VanillaCookbook;
import com.morallenplay.vanillacookbook.setup.FDConfigCondition;
import com.morallenplay.vanillacookbook.setup.GoldenHoeApplesCondition;
import com.morallenplay.vanillacookbook.setup.LootConfigCondition;
import com.morallenplay.vanillacookbook.setup.NPConfigCondition;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ConditionRegistry {
	
	public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODECS =
	        DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, VanillaCookbook.MODID);

	public static final Supplier<MapCodec<FDConfigCondition>> FD_CONFIG =
	        CONDITION_CODECS.register("fd_config", () -> FDConfigCondition.CODEC);
	
	public static final Supplier<MapCodec<NPConfigCondition>> NP_CONFIG =
	        CONDITION_CODECS.register("np_config", () -> NPConfigCondition.CODEC);
	
	public static final DeferredRegister<LootItemConditionType> LOOT_CONDITION_TYPES =
	        DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, VanillaCookbook.MODID);

	public static final Supplier<LootItemConditionType> LOOT_CONFIG =
	        LOOT_CONDITION_TYPES.register("loot_config", () -> new LootItemConditionType(LootConfigCondition.CODEC));
	
	public static final Supplier<LootItemConditionType> GOLDEN_HOE_APPLES =
	        LOOT_CONDITION_TYPES.register("golden_hoe_apples", () -> new LootItemConditionType(GoldenHoeApplesCondition.CODEC));
}
