package com.morallenplay.vanillacookbook.setup;

import org.jetbrains.annotations.NotNull;

import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.conditions.ICondition;

public class NPConfigCondition implements ICondition {
	
	public static final MapCodec<NPConfigCondition> CODEC = MapCodec.unit(new NPConfigCondition());

	public NPConfigCondition() {
	}

	@Override
	public boolean test(@NotNull IContext context) {
		return Config.NP_ITEMS.get();
	}

	@Override
	public @NotNull MapCodec<? extends ICondition> codec() {
		return CODEC;
	}
}

