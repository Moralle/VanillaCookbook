package com.morallenplay.vanillacookbook.item;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CureItem extends ContainerItem {

	private Holder<MobEffect> effect;
	private float chance;

	public CureItem(Properties properties, Holder<MobEffect> effect, float chance) {
		super(properties, false, false);
		this.effect = effect;
		this.chance = chance;
	}
	
	public CureItem(Properties properties, Holder<MobEffect> effect, float chance, boolean hasFoodEffectTooltip) {
		super(properties, hasFoodEffectTooltip, false);
		this.effect = effect;
		this.chance = chance;
	}
	
	public CureItem(Properties properties, Holder<MobEffect> effect, float chance, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
		super(properties, hasFoodEffectTooltip, hasCustomTooltip);
		this.effect = effect;
		this.chance = chance;
	}

	public void affectPlayer(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		if (Math.random() < chance) {
			entityLiving.removeEffect(effect);
		}
	}
}
