package com.morallenplay.vanillacookbook.item;

import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ChorusDirectionItem extends ContainerItem {

	public ChorusDirectionItem(Properties properties) {
		super(properties);
	}
	
	public ChorusDirectionItem(Properties properties, boolean hasFoodEffectTooltip) {
		super(properties, hasFoodEffectTooltip, false);
	}

	public ChorusDirectionItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
		super(properties, hasFoodEffectTooltip, hasCustomTooltip);
	}
	
	@Override
	public void affectPlayer(ItemStack stack, Level worldIn, LivingEntity entityLiving) {

		double d0 = entityLiving.getX();
		double d1 = entityLiving.getY();
		double d2 = entityLiving.getZ();
		
		double e0 = 0.5;
		double e1 = 8;
		double e2 = 0.5;
		
		Direction direction = entityLiving.getNearestViewDirection();
		
		switch (direction) {
		
		case EAST -> e0 = -1;
		case WEST -> e0 = 1;
		case UP -> e1 = -16;
		case DOWN -> e1 = 16;
		case SOUTH -> e2 = -1;
		case NORTH -> e2 = 1;
		
		}

		for (int i = 0; i < 16; ++i) {
			double d3 = entityLiving.getX() + (entityLiving.getRandom().nextDouble() - e0) * 16.0D;
			double d4 = Mth.clamp(entityLiving.getY() + (double) (entityLiving.getRandom().nextInt(16) - e1),
			(double)worldIn.getMinBuildHeight(),
			(double)(worldIn.getMinBuildHeight() + ((ServerLevel)worldIn).getLogicalHeight() - 1));
			double d5 = entityLiving.getZ() + (entityLiving.getRandom().nextDouble() - e2) * 16.0D;
			if (entityLiving.isPassenger()) {
				entityLiving.stopRiding();
			}

			if (entityLiving.randomTeleport(d3, d4, d5, true)) {
				worldIn.playSound((Player) null, d0, d1, d2, SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS,
						1.0F, 1.0F);
				entityLiving.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 1.0F, 1.0F);
				entityLiving.resetFallDistance();
				break;
			}
		}

		if (entityLiving instanceof Player) {
			((Player) entityLiving).resetCurrentImpulseContext();
			((Player) entityLiving).getCooldowns().addCooldown(this, 20);
		}

	}
}
