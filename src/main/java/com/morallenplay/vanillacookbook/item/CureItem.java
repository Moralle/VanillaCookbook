package com.morallenplay.vanillacookbook.item;

import java.util.Random;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CureItem extends ContainerItem {

	private MobEffect effect;
	private float chance;

	public CureItem(Properties properties, MobEffect effect, float chance) {
		super(properties, false, false);
		this.effect = effect;
		this.chance = chance;
	}
	
	public CureItem(Properties properties, MobEffect effect, float chance, boolean hasFoodEffectTooltip) {
		super(properties, hasFoodEffectTooltip, false);
		this.effect = effect;
		this.chance = chance;
	}
	
	public CureItem(Properties properties, MobEffect effect, float chance, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
		super(properties, hasFoodEffectTooltip, hasCustomTooltip);
		this.effect = effect;
		this.chance = chance;
	}

	public void affectPlayer(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		if (new Random().nextFloat() < chance) {
			entityLiving.removeEffect(effect);
		}
	}
}
