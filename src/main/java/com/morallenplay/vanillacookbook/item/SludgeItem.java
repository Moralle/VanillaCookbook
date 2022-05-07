package com.morallenplay.vanillacookbook.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SludgeItem extends Item {

	public SludgeItem(Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		super.finishUsingItem(stack, worldIn, entityLiving);
		if (entityLiving instanceof ServerPlayer) {
			ServerPlayer serverplayerentity = (ServerPlayer) entityLiving;
			serverplayerentity.getFoodData().setFoodLevel(0);
			serverplayerentity.getFoodData().setSaturation(0);
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
		}
		return stack;
	}
}
