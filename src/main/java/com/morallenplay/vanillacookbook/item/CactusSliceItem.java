package com.morallenplay.vanillacookbook.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

import net.minecraft.world.level.Level;

public class CactusSliceItem extends Item{
	private float damage;
	private float chance;
	public CactusSliceItem(Item.Properties builder, float damage, float chance)
	{
		super(builder);
		this.damage = damage;
		this.chance = chance;
	}
	
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		
		if (!worldIn.isClientSide && (new Random().nextFloat() < chance)) {
			entityLiving.hurt(worldIn.damageSources().generic(), damage);
	      }
		
		ItemStack itemstack = super.finishUsingItem(stack, worldIn, entityLiving);
		
		return itemstack;
	}
}
