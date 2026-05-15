package com.morallenplay.vanillacookbook.event;

import com.morallenplay.vanillacookbook.VanillaCookbook;
import com.morallenplay.vanillacookbook.setup.Config;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = VanillaCookbook.MODID)
public class DragonHeadBreathEvent {
	
	@SubscribeEvent
	public static void onEggUse(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level world = event.getLevel();
        Block block = world.getBlockState(event.getPos()).getBlock();
        ItemStack heldItemStack = event.getItemStack();
		if (heldItemStack.is(Items.GLASS_BOTTLE) && (block == Blocks.DRAGON_HEAD || block == Blocks.DRAGON_WALL_HEAD) && !player.isShiftKeyDown() && !world.isClientSide && !Config.DRAGON_HEAD_BREATH.get()) {
            player.getInventory().add(new ItemStack(Items.DRAGON_BREATH));
            heldItemStack.shrink(1);
            world.playSound(null, event.getPos(), SoundEvents.BOTTLE_FILL_DRAGONBREATH, SoundSource.BLOCKS, 1.0F, 1.0F);
            event.setCanceled(true);
			event.setCancellationResult(InteractionResult.SUCCESS);
        }
    
	}
}
