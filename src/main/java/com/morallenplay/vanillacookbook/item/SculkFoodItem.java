package com.morallenplay.vanillacookbook.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SculkFoodItem extends CheeseItem{
	
	public SculkFoodItem(Properties properties) {
		super(properties);
	}
	
	public SculkFoodItem(Properties properties, boolean hasFoodEffectTooltip) {
		super(properties, hasFoodEffectTooltip, false);
	}

	public SculkFoodItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
		super(properties, hasFoodEffectTooltip, hasCustomTooltip);
	}
	
	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		super.finishUsingItem(stack, worldIn, entityLiving);
		if (entityLiving instanceof ServerPlayer) {
			ServerPlayer serverplayerentity = (ServerPlayer) entityLiving;
			int experience = serverplayerentity.experienceLevel;
			int hunger = serverplayerentity.getFoodData().getFoodLevel();
			float saturation = serverplayerentity.getFoodData().getSaturationLevel();
			serverplayerentity.getFoodData().setFoodLevel(hunger + (experience / 6));
			serverplayerentity.getFoodData().setSaturation(saturation + ((experience / 6) * 2));
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
		}
		return stack;
	}
}
