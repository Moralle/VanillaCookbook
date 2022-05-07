package com.morallenplay.vanillacookbook.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class IceCreamItem extends ContainerItem {
	public IceCreamItem(Properties properties) {
		super(properties);
	}

	public void affectPlayer(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		entityLiving.clearFire();
	}
}
