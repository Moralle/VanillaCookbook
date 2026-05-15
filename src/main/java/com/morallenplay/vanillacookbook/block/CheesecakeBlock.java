package com.morallenplay.vanillacookbook.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

public class CheesecakeBlock extends CakesBlock{
		
		public CheesecakeBlock(BlockBehaviour.Properties builder)
		{
			super(builder);
		}
		
		@Override
	    protected ItemInteractionResult useItemOn(
	        ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult)
	    {
				return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
		}

		 @Override
		    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
			if (level.isClientSide) {
				if (eat(level, pos, state, player) == InteractionResult.SUCCESS) {
					return InteractionResult.SUCCESS;
				}

				if (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
					return InteractionResult.CONSUME;
				}
			}

			return eat(level, pos, state, player);
		}
		
		protected static InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
		       if (!player.canEat(false)) {
		           return InteractionResult.PASS;
		       } else {
		           player.awardStat(Stats.EAT_CAKE_SLICE);
		           player.getFoodData().eat(2, 0.1F);
		           player.removeAllEffects();
		           int i = state.getValue(BITES);
		           level.gameEvent(player, GameEvent.EAT, pos);
		           if (i < 6) {
		               level.setBlock(pos, state.setValue(BITES, Integer.valueOf(i + 1)), 3);
		           } else {
		               level.removeBlock(pos, false);
		               level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
		           }

		           return InteractionResult.SUCCESS;
		       }
		 }
}
