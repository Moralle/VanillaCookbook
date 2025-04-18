package com.morallenplay.vanillacookbook.setup;

import com.mojang.serialization.MapCodec;
import com.morallenplay.vanillacookbook.registry.ConditionRegistry;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public class GoldenHoeApplesCondition implements LootItemCondition {
	public static final GoldenHoeApplesCondition INSTANCE = new GoldenHoeApplesCondition();
   
    public static final MapCodec<GoldenHoeApplesCondition> CODEC = MapCodec.unit(INSTANCE).stable();
    
    @Override
    public boolean test(LootContext context) {
        return !Config.GOLDEN_HOE_APPLES.getAsBoolean();
    }

	@Override
	public LootItemConditionType getType() {
		return ConditionRegistry.GOLDEN_HOE_APPLES.get();
	}
}