package com.morallenplay.vanillacookbook.block;

import java.util.stream.Stream;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SliceCakeBlock extends CakeBlock{
	
	protected static final VoxelShape[] SHAPES = new VoxelShape[] { Stream.of(
			Block.box(3, 0, 1, 7, 4, 5),
			Block.box(9, 0, 1, 13, 4, 5),
			Block.box(1, 0, 6, 5, 4, 10),
			Block.box(6, 0, 6, 10, 4, 10),
			Block.box(11, 0, 6, 15, 4, 10),
			Block.box(3, 0, 11, 7, 4, 15),
			Block.box(9, 0, 11, 13, 4, 15)
			).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
			Stream.of(
					Block.box(9, 0, 1, 13, 4, 5),
					Block.box(1, 0, 6, 5, 4, 10),
					Block.box(6, 0, 6, 10, 4, 10),
					Block.box(11, 0, 6, 15, 4, 10),
					Block.box(3, 0, 11, 7, 4, 15),
					Block.box(9, 0, 11, 13, 4, 15)
					).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
			Stream.of(
					Block.box(1, 0, 6, 5, 4, 10),
					Block.box(6, 0, 6, 10, 4, 10),
					Block.box(11, 0, 6, 15, 4, 10),
					Block.box(3, 0, 11, 7, 4, 15),
					Block.box(9, 0, 11, 13, 4, 15)
					).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
			Stream.of(
					Block.box(6, 0, 6, 10, 4, 10),
					Block.box(11, 0, 6, 15, 4, 10),
					Block.box(3, 0, 11, 7, 4, 15),
					Block.box(9, 0, 11, 13, 4, 15)
					).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
			Stream.of(
							Block.box(11, 0, 6, 15, 4, 10),
							Block.box(3, 0, 11, 7, 4, 15),
							Block.box(9, 0, 11, 13, 4, 15)
							).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get(),
			Shapes.join(Block.box(3, 0, 11, 7, 4, 15), Block.box(9, 0, 11, 13, 4, 15), BooleanOp.OR),
			Block.box(9, 0, 11, 13, 4, 15) };

	public SliceCakeBlock(BlockBehaviour.Properties builder)
	{
		super(builder);
	}
	
	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
			BlockHitResult hit) {
		if (worldIn.isClientSide) {
			ItemStack itemstack = player.getItemInHand(handIn);
			if (eat(worldIn, pos, state, player) == InteractionResult.SUCCESS) {
				return InteractionResult.SUCCESS;
			}

			if (itemstack.isEmpty()) {
				return InteractionResult.CONSUME;
			}
		}

		return eat(worldIn, pos, state, player);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
	      return SHAPES[state.getValue(BITES)];
	   }
}