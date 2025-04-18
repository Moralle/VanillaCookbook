package com.morallenplay.vanillacookbook.registry;

import com.morallenplay.vanillacookbook.VanillaCookbook;
import com.morallenplay.vanillacookbook.block.BookCakeBlock;
import com.morallenplay.vanillacookbook.block.BrownieTrayBlock;
import com.morallenplay.vanillacookbook.block.CakesBlock;
import com.morallenplay.vanillacookbook.block.CheesecakeBlock;
import com.morallenplay.vanillacookbook.block.ChorusCakeBlock;
import com.morallenplay.vanillacookbook.block.PancakeStackBlock;
import com.morallenplay.vanillacookbook.block.SliceCakeBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlockRegistry {

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(VanillaCookbook.MODID);
	
	
	public static final DeferredBlock<Block> BERRY_CAKE = BLOCKS.register("berry_cake", () -> new CakesBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
	public static final DeferredBlock<Block> CARROT_CAKE = BLOCKS.register("carrot_cake", () -> new CakesBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
	public static final DeferredBlock<Block> CHEESECAKE = BLOCKS.register("cheesecake", () -> new CheesecakeBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
	public static final DeferredBlock<Block> CHOCOLATE_CAKE = BLOCKS.register("chocolate_cake", () -> new CakesBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
	public static final DeferredBlock<Block> MOHNKUCHEN = BLOCKS.register("mohnkuchen", () -> new SliceCakeBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
	public static final DeferredBlock<Block> ICE_CREAM_CAKE = BLOCKS.register("ice_cream_cake", () -> new CakesBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
	public static final DeferredBlock<Block> ROSE_CAKE = BLOCKS.register("rose_cake", () -> new CakesBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
	public static final DeferredBlock<Block> BOOK_CAKE = BLOCKS.register("book_cake", () -> new BookCakeBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
	public static final DeferredBlock<Block> PANCAKE_STACK = BLOCKS.register("pancake_stack", () -> new PancakeStackBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
	public static final DeferredBlock<Block> CHORUS_CAKE = BLOCKS.register("chorus_cake", () -> new ChorusCakeBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
	public static final DeferredBlock<Block> GLOW_BERRY_CAKE = BLOCKS.register("glow_berry_cake", () -> new CakesBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY).lightLevel((p_152684_) -> {
	      return 14 - p_152684_.getValue(CakesBlock.BITES);
	   })));
	public static final DeferredBlock<Block> BROWNIE_TRAY = BLOCKS.register("brownie_tray", () -> new BrownieTrayBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.WOOL).pushReaction(PushReaction.DESTROY)));
}