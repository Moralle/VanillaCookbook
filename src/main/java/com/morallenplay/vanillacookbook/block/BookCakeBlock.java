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

public class BookCakeBlock extends CakeBlock{
	
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
