package com.morallenplay.vanillacookbook.block;

import java.util.stream.Stream;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;

import net.minecraft.world.level.block.state.BlockBehaviour;

public class BrownieTrayBlock extends Block {
	public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 5);

	protected static final VoxelShape[] SHAPES = new VoxelShape[] { Stream
			.of(Block.box(1, 0, 1, 7, 3, 5), Block.box(1, 0, 6, 7, 3, 10),
					Block.box(1, 0, 11, 7, 3, 15), Block.box(9, 0, 11, 15, 3, 15),
					Block.box(9, 0, 6, 15, 3, 10), Block.box(9, 0, 1, 15, 3, 5))
			.reduce((v1, v2) -> {
				return Shapes.join(v1, v2, BooleanOp.OR);
			}).get(),
			Stream.of(Block.box(1, 0, 6, 7, 3, 10), Block.box(1, 0, 11, 7, 3, 15),
					Block.box(9, 0, 11, 15, 3, 15), Block.box(9, 0, 6, 15, 3, 10),
					Block.box(9, 0, 1, 15, 3, 5)).reduce((v1, v2) -> {
						return Shapes.join(v1, v2, BooleanOp.OR);
					}).get(),
			Stream.of(Block.box(1, 0, 11, 7, 3, 15), Block.box(9, 0, 11, 15, 3, 15),
					Block.box(9, 0, 6, 15, 3, 10), Block.box(9, 0, 1, 15, 3, 5))
					.reduce((v1, v2) -> {
						return Shapes.join(v1, v2, BooleanOp.OR);
					}).get(),
			Stream.of(Block.box(9, 0, 11, 15, 3, 15), Block.box(9, 0, 6, 15, 3, 10),
					Block.box(9, 0, 1, 15, 3, 5)).reduce((v1, v2) -> {
						return Shapes.join(v1, v2, BooleanOp.OR);
					}).get(),
			Shapes.join(Block.box(9, 0, 6, 15, 3, 10),
					Block.box(9, 0, 1, 15, 3, 5), BooleanOp.OR),
			Block.box(9, 0, 1, 15, 3, 5) };

	public BrownieTrayBlock(BlockBehaviour.Properties builder) {
		super(builder);
		this.registerDefaultState(this.stateDefinition.any().setValue(BITES, Integer.valueOf(0)));
	}

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPES[state.getValue(BITES)];
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(BITES);
	}

	public int getAnalogOutputSignal(BlockState blockState, Level worldIn, BlockPos pos) {
		return (6 - blockState.getValue(BITES)) * 2;
	}

	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player,
			InteractionHand handIn, BlockHitResult hit) {
		if (worldIn.isClientSide) {
			ItemStack itemstack = player.getItemInHand(handIn);
			if (this.eatCake(worldIn, pos, state, player) == InteractionResult.SUCCESS) {
				return InteractionResult.SUCCESS;
			}

			if (itemstack.isEmpty()) {
				return InteractionResult.CONSUME;
			}
		}

		return this.eatCake(worldIn, pos, state, player);
	}

	private InteractionResult eatCake(LevelAccessor world, BlockPos pos, BlockState state, Player player) {
		if (!player.canEat(false)) {
			return InteractionResult.PASS;
		} else {
			player.awardStat(Stats.EAT_CAKE_SLICE);
			player.getFoodData().eat(6, 0.55F);
			int i = state.getValue(BITES);
			if (i < 5) {
				world.setBlock(pos, state.setValue(BITES, Integer.valueOf(i + 1)), 3);
			} else {
				world.removeBlock(pos, false);
			}

			world.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.7F, 0.9F);
			return InteractionResult.SUCCESS;
		}
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn,
			BlockPos currentPos, BlockPos facingPos) {
		return facing == Direction.DOWN && !stateIn.canSurvive(worldIn, currentPos) ? Blocks.AIR.defaultBlockState()
				: super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		return worldIn.getBlockState(pos.below()).isSolid();
	}

	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
		return false;
	}

}
