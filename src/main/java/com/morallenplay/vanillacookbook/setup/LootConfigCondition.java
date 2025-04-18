package com.morallenplay.vanillacookbook.setup;

import com.mojang.serialization.MapCodec;
import com.morallenplay.vanillacookbook.registry.ConditionRegistry;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public class LootConfigCondition implements LootItemCondition {
	public static final LootConfigCondition INSTANCE = new LootConfigCondition();
   
    public static final MapCodec<LootConfigCondition> CODEC = MapCodec.unit(INSTANCE).stable();
    
    @Override
    public boolean test(LootContext context) {
        return !Config.LOOT_GENERATION.getAsBoolean();
    }

	@Override
	public LootItemConditionType getType() {
		return ConditionRegistry.LOOT_CONFIG.get();
	}
}