package com.morallenplay.vanillacookbook.setup;

import org.jetbrains.annotations.NotNull;

import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.conditions.ICondition;

public class FDConfigCondition implements ICondition {
	
	public static final MapCodec<FDConfigCondition> CODEC = MapCodec.unit(new FDConfigCondition());

	public FDConfigCondition() {
	}

	@Override
	public boolean test(@NotNull IContext context) {
		return Config.FD_ITEMS.get();
	}

	@Override
	public @NotNull MapCodec<? extends ICondition> codec() {
		return CODEC;
	}
}
