package com.morallenplay.vanillacookbook.event;

import com.morallenplay.vanillacookbook.VanillaCookbook;
import com.morallenplay.vanillacookbook.registry.ItemRegistry;
import com.morallenplay.vanillacookbook.setup.Tags;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = VanillaCookbook.MOD_ID, bus = Bus.FORGE)
public class ChocolateEggEvent {
	
	@SubscribeEvent
	public static void onEggUse(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getPlayer();
        Level world = event.getWorld();
        Block block = world.getBlockState(event.getPos()).getBlock();
        ItemStack heldItemStack = event.getItemStack();
		if (heldItemStack.is(Tags.EASTER_EGG_ITEMS) && block == Blocks.DRAGON_EGG && !player.isShiftKeyDown() && !world.isClientSide) {
            player.getInventory().add(new ItemStack(ItemRegistry.CHOCOLATE_EGG.get()));
            heldItemStack.shrink(1);
            world.playSound(null, event.getPos(), SoundEvents.CHICKEN_EGG, SoundSource.PLAYERS, 1.0F, 0.8F);
            event.setCanceled(true);
			event.setCancellationResult(InteractionResult.SUCCESS);
        }
    
	}
}
