package com.morallenplay.vanillacookbook.block;

import com.morallenplay.vanillacookbook.registry.BlockRegistry;
//import com.morallenplay.vanillacookbook.setup.Config;
import com.morallenplay.vanillacookbook.setup.Config;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

public class ChorusCakeBlock extends CakeBlock {

	public ChorusCakeBlock(BlockBehaviour.Properties builder) {
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
			if (eatCake(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                return InteractionResult.CONSUME;
            }
		}
		
		this.teleport(state, level, pos, player);

		return this.eatCake(level, pos, state, player);
	}
	
	
	private InteractionResult eatCake(LevelAccessor world, BlockPos pos, BlockState state, Player player) {
		if (!player.canEat(false)) {
			return InteractionResult.PASS;
		} else {
			
			player.awardStat(Stats.EAT_CAKE_SLICE);
			player.getFoodData().eat(4, 0.1F);
			world.gameEvent(player, GameEvent.EAT, pos);
			if (Config.CHORUS_CAKE_TELEPORTATION.get()) {
				int i = state.getValue(BITES);
		         if (i < 6) {
		            world.setBlock(pos, state.setValue(BITES, Integer.valueOf(i + 1)), 3);
		         } else {
		            world.removeBlock(pos, false);
		            world.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
		         }
			}

			return InteractionResult.SUCCESS;
		}
	}

	@SuppressWarnings("deprecation")
	private void teleport(BlockState state, Level world, BlockPos pos, Player player) {
		
		WorldBorder worldborder = world.getWorldBorder();
		if (Config.CHORUS_CAKE_TELEPORTATION.get()) return;
		for (int i = 0; i < 1000; ++i) {
			BlockPos blockpos = pos.offset(world.random.nextInt(8) - world.random.nextInt(8),
					world.random.nextInt(8) - world.random.nextInt(8), world.random.nextInt(8) - world.random.nextInt(8));
			if (world.getBlockState(blockpos).isAir() && worldborder.isWithinBounds(blockpos) && world.getBlockState(blockpos.below()).isSolid() && world.getBlockState(blockpos.below()).getBlock() != BlockRegistry.CHORUS_CAKE.get()) {
				if (state.getValue(BITES) == 6) {
					world.removeBlock(pos, false);
				} else if (player.canEat(false)) {
					world.setBlock(blockpos, state.setValue(BITES, Integer.valueOf(state.getValue(BITES) + 1)), 3);
					world.playSound(null, pos, SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.BLOCKS, 0.7F, 0.9F);
					world.removeBlock(pos, false);
				}

				return;
			}
		}

	}

}
