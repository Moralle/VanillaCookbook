package com.morallenplay.vanillacookbook.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MilkBottleItem extends JuiceItem {

	public MilkBottleItem(Properties properties) {
		super(properties);
	}
	
	public MilkBottleItem(Properties properties, boolean hasFoodEffectTooltip) {
		super(properties, hasFoodEffectTooltip, false);
	}

	public MilkBottleItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
		super(properties, hasFoodEffectTooltip, hasCustomTooltip);
	}

	public void affectPlayer(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		entityLiving.removeAllEffects();
	}
}
