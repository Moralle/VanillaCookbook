package com.morallenplay.vanillacookbook.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class JuiceItem extends ContainerItem{
	
	public JuiceItem(Properties properties)
	{
		super(properties);
	}
	
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.DRINK;
	}
	
	public SoundEvent getEatingSound() {
		return SoundEvents.GENERIC_DRINK;
	}
}
