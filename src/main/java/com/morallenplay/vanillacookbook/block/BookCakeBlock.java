package com.morallenplay.vanillacookbook.block;

import java.util.stream.Stream;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BookCakeBlock extends CakesBlock{
	
	protected static final VoxelShape[] SHAPES = new VoxelShape[] { Stream.of(Block.box(4, 5, 2, 13, 6, 14),
			Block.box(3, 1, 2, 12, 5, 14), Block.box(4, 0, 2, 13, 1, 14)).reduce((v1, v2) -> {
				return Shapes.join(v1, v2, BooleanOp.OR);
			}).get(), Stream.of(Block.box(5, 5, 2, 13, 6, 14), Block.box(5, 1, 2, 12, 5, 14),
					Block.box(5, 0, 2, 13, 1, 14)).reduce((v1, v2) -> {
						return Shapes.join(v1, v2, BooleanOp.OR);
					}).get(),
			Stream.of(Block.box(6, 5, 2, 13, 6, 14), Block.box(6, 1, 2, 12, 5, 14),
					Block.box(6, 0, 2, 13, 1, 14)).reduce((v1, v2) -> {
						return Shapes.join(v1, v2, BooleanOp.OR);
					}).get(),
			Stream.of(Block.box(7, 5, 2, 13, 6, 14), Block.box(7, 1, 2, 12, 5, 14),
					Block.box(7, 0, 2, 13, 1, 14)).reduce((v1, v2) -> {
						return Shapes.join(v1, v2, BooleanOp.OR);
					}).get(),
			Stream.of(Block.box(8, 5, 2, 13, 6, 14), Block.box(8, 1, 2, 12, 5, 14),
					Block.box(8, 0, 2, 13, 1, 14)).reduce((v1, v2) -> {
						return Shapes.join(v1, v2, BooleanOp.OR);
					}).get(),
			Stream.of(Block.box(9, 5, 2, 13, 6, 14), Block.box(9, 1, 2, 12, 5, 14),
					Block.box(9, 0, 2, 13, 1, 14)).reduce((v1, v2) -> {
						return Shapes.join(v1, v2, BooleanOp.OR);
					}).get(),
			Stream.of(Block.box(10, 5, 2, 13, 6, 14), Block.box(10, 1, 2, 12, 5, 14),
					Block.box(10, 0, 2, 13, 1, 14)).reduce((v1, v2) -> {
						return Shapes.join(v1, v2, BooleanOp.OR);
					}).get() };

	public BookCakeBlock(BlockBehaviour.Properties builder) {
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
		
		this.randomMessage(level, player);
		return eat(level, pos, state, player);
	}
	
	protected static InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            player.awardStat(Stats.EAT_CAKE_SLICE);
            player.getFoodData().eat(2, 0.1F);
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
	
	protected void randomMessage(Level level, Player player) {
		if (!level.isClientSide() && Math.random() <= 0.1) {
            player.displayClientMessage(Component.translatable("block.vanillacookbook.book_cake.message" + level.getRandom().nextInt(10)), true);
        }
		return;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPES[state.getValue(BITES)];
	}
}
