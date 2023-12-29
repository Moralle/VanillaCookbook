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
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlockRegistry {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			VanillaCookbook.MOD_ID);
	
	
	public static final RegistryObject<Block> BERRY_CAKE = BLOCKS.register("berry_cake", () -> new CakesBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(0.5F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> CARROT_CAKE = BLOCKS.register("carrot_cake", () -> new CakesBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(0.5F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> CHEESECAKE = BLOCKS.register("cheesecake", () -> new CheesecakeBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(0.5F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> CHOCOLATE_CAKE = BLOCKS.register("chocolate_cake", () -> new CakesBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(0.5F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> MOHNKUCHEN = BLOCKS.register("mohnkuchen", () -> new SliceCakeBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(0.5F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> ICE_CREAM_CAKE = BLOCKS.register("ice_cream_cake", () -> new CakesBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(0.5F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> ROSE_CAKE = BLOCKS.register("rose_cake", () -> new CakesBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(0.5F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> BOOK_CAKE = BLOCKS.register("book_cake", () -> new BookCakeBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(0.5F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> PANCAKE_STACK = BLOCKS.register("pancake_stack", () -> new PancakeStackBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(0.5F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> CHORUS_CAKE = BLOCKS.register("chorus_cake", () -> new ChorusCakeBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(0.5F).sound(SoundType.WOOL)));
	public static final RegistryObject<Block> GLOW_BERRY_CAKE = BLOCKS.register("glow_berry_cake", () -> new CakesBlock(Block.Properties.of().pushReaction(PushReaction.DESTROY).strength(0.5F).sound(SoundType.WOOL).lightLevel((p_152684_) -> {
	      return 14 - p_152684_.getValue(CakesBlock.BITES);
	   })));
	public static final RegistryObject<Block> BROWNIE_TRAY = BLOCKS.register("brownie_tray", () -> new BrownieTrayBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).strength(0.5F).sound(SoundType.WOOL)));
}
