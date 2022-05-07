package com.morallenplay.vanillacookbook.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ChorusJuiceItem extends JuiceItem {

	public ChorusJuiceItem(Properties properties) {
		super(properties);
	}

	@Override
	public void affectPlayer(ItemStack stack, Level worldIn, LivingEntity entityLiving) {

		double d0 = entityLiving.getX();
		double d1 = entityLiving.getY();
		double d2 = entityLiving.getZ();

		for (int i = 0; i < 16; ++i) {
			double d3 = entityLiving.getX() + (entityLiving.getRandom().nextDouble() - 0.5D) * 16.0D;
			double d4 = Mth.clamp(entityLiving.getY() + (double) (entityLiving.getRandom().nextInt(16) - 8), 0.0D,
					(double) (worldIn.getHeight() - 1));
			double d5 = entityLiving.getZ() + (entityLiving.getRandom().nextDouble() - 0.5D) * 16.0D;
			if (entityLiving.isPassenger()) {
				entityLiving.stopRiding();
			}

			if (entityLiving.randomTeleport(d3, d4, d5, true)) {
				worldIn.playSound((Player) null, d0, d1, d2, SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS,
						1.0F, 1.0F);
				entityLiving.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 1.0F, 1.0F);
				break;
			}
		}

		if (entityLiving instanceof Player) {
			((Player) entityLiving).getCooldowns().addCooldown(this, 20);
		}

	}
}
