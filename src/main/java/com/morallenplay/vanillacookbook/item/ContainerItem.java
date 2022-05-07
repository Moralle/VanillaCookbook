package com.morallenplay.vanillacookbook.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ContainerItem extends Item {

	public ContainerItem(Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		if (!worldIn.isClientSide) {
			this.affectPlayer(stack, worldIn, entityLiving);
		}

		ItemStack containerStack = stack.getContainerItem();

		super.finishUsingItem(stack, worldIn, entityLiving);
		if (entityLiving instanceof ServerPlayer) {
			ServerPlayer serverplayerentity = (ServerPlayer) entityLiving;
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
		}

		if (stack.isEmpty()) {
			return containerStack;
		} else {
			if (entityLiving instanceof Player && !((Player) entityLiving).getAbilities().instabuild) {
				Player playerentity = (Player) entityLiving;
				if (!playerentity.getInventory().add(containerStack)) {
					playerentity.drop(containerStack, false);
				}
			}

			return stack;
		}
	}

	public void affectPlayer(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
	}
}
