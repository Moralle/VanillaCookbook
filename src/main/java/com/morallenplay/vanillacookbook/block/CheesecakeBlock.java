package com.morallenplay.vanillacookbook.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

public class CheesecakeBlock extends CakeBlock{
		
		public CheesecakeBlock(BlockBehaviour.Properties builder)
		{
			super(builder);
		}
		
		@Override
		public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
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
			         player.getFoodData().eat(2, 0.1F);
			         player.removeAllEffects();
			         int i = state.getValue(BITES);
			         if (i < 6) {
			            world.setBlock(pos, state.setValue(BITES, Integer.valueOf(i + 1)), 3);
			         } else {
			            world.removeBlock(pos, false);
			         }

			         return InteractionResult.SUCCESS;
			      }
			   }

}
